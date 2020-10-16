package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.local.LocalWriteResult;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SyncEngine implements RemoteStore.RemoteStoreCallback {
  private static final String TAG = SyncEngine.class.getSimpleName();
  
  private User currentUser;
  
  private final ReferenceSet limboDocumentRefs;
  
  private final Map<Integer, LimboResolution> limboResolutionsByTarget;
  
  private final Map<DocumentKey, Integer> limboTargetsByKey;
  
  private final LocalStore localStore;
  
  private final Map<User, Map<Integer, TaskCompletionSource<Void>>> mutationUserCallbacks;
  
  private final Map<Integer, List<TaskCompletionSource<Void>>> pendingWritesCallbacks;
  
  private final Map<Integer, List<Query>> queriesByTarget;
  
  private final Map<Query, QueryView> queryViewsByQuery;
  
  private final RemoteStore remoteStore;
  
  private SyncEngineCallback syncEngineListener;
  
  private final TargetIdGenerator targetIdGenerator;
  
  public SyncEngine(LocalStore paramLocalStore, RemoteStore paramRemoteStore, User paramUser) {
    this.localStore = paramLocalStore;
    this.remoteStore = paramRemoteStore;
    this.queryViewsByQuery = new HashMap<>();
    this.queriesByTarget = new HashMap<>();
    this.limboTargetsByKey = new HashMap<>();
    this.limboResolutionsByTarget = new HashMap<>();
    this.limboDocumentRefs = new ReferenceSet();
    this.mutationUserCallbacks = new HashMap<>();
    this.targetIdGenerator = TargetIdGenerator.forSyncEngine();
    this.currentUser = paramUser;
    this.pendingWritesCallbacks = new HashMap<>();
  }
  
  private void addUserCallback(int paramInt, TaskCompletionSource<Void> paramTaskCompletionSource) {
    Map<Object, Object> map1 = (Map)this.mutationUserCallbacks.get(this.currentUser);
    Map<Object, Object> map2 = map1;
    if (map1 == null) {
      map2 = new HashMap<>();
      this.mutationUserCallbacks.put(this.currentUser, map2);
    } 
    map2.put(Integer.valueOf(paramInt), paramTaskCompletionSource);
  }
  
  private void assertCallback(String paramString) {
    boolean bool;
    if (this.syncEngineListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Trying to call %s before setting callback", new Object[] { paramString });
  }
  
  private void emitNewSnapsAndNotifyLocalStore(ImmutableSortedMap<DocumentKey, MaybeDocument> paramImmutableSortedMap, RemoteEvent paramRemoteEvent) {
    ArrayList<ViewSnapshot> arrayList = new ArrayList();
    ArrayList<LocalViewChanges> arrayList1 = new ArrayList();
    Iterator<Map.Entry> iterator = this.queryViewsByQuery.entrySet().iterator();
    while (iterator.hasNext()) {
      TargetChange targetChange;
      QueryView queryView = (QueryView)((Map.Entry)iterator.next()).getValue();
      View view = queryView.getView();
      View.DocumentChanges documentChanges1 = view.computeDocChanges(paramImmutableSortedMap);
      View.DocumentChanges documentChanges2 = documentChanges1;
      if (documentChanges1.needsRefill())
        documentChanges2 = view.computeDocChanges(this.localStore.executeQuery(queryView.getQuery(), false).getDocuments(), documentChanges1); 
      if (paramRemoteEvent == null) {
        documentChanges1 = null;
      } else {
        targetChange = (TargetChange)paramRemoteEvent.getTargetChanges().get(Integer.valueOf(queryView.getTargetId()));
      } 
      ViewChange viewChange = queryView.getView().applyChanges(documentChanges2, targetChange);
      updateTrackedLimboDocuments(viewChange.getLimboChanges(), queryView.getTargetId());
      if (viewChange.getSnapshot() != null) {
        arrayList.add(viewChange.getSnapshot());
        arrayList1.add(LocalViewChanges.fromViewSnapshot(queryView.getTargetId(), viewChange.getSnapshot()));
      } 
    } 
    this.syncEngineListener.onViewSnapshots(arrayList);
    this.localStore.notifyLocalViewChanges(arrayList1);
  }
  
  private boolean errorIsInteresting(Status paramStatus) {
    String str;
    Status.Code code = paramStatus.getCode();
    if (paramStatus.getDescription() != null) {
      str = paramStatus.getDescription();
    } else {
      str = "";
    } 
    return (code == Status.Code.FAILED_PRECONDITION && str.contains("requires an index")) ? true : ((code == Status.Code.PERMISSION_DENIED));
  }
  
  private void failOutstandingPendingWritesAwaitingTasks() {
    Iterator<Map.Entry> iterator = this.pendingWritesCallbacks.entrySet().iterator();
    while (iterator.hasNext()) {
      Iterator<TaskCompletionSource> iterator1 = ((List)((Map.Entry)iterator.next()).getValue()).iterator();
      while (iterator1.hasNext())
        ((TaskCompletionSource)iterator1.next()).setException((Exception)new FirebaseFirestoreException("'waitForPendingWrites' task is cancelled due to User change.", FirebaseFirestoreException.Code.CANCELLED)); 
    } 
    this.pendingWritesCallbacks.clear();
  }
  
  private ViewSnapshot initializeViewAndComputeSnapshot(Query paramQuery, int paramInt) {
    boolean bool;
    QueryResult queryResult = this.localStore.executeQuery(paramQuery, true);
    ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
    if (this.queriesByTarget.get(Integer.valueOf(paramInt)) != null) {
      Query query = ((List<Query>)this.queriesByTarget.get(Integer.valueOf(paramInt))).get(0);
      if (((QueryView)this.queryViewsByQuery.get(query)).getView().getSyncState() == ViewSnapshot.SyncState.SYNCED) {
        bool = true;
      } else {
        bool = false;
      } 
      TargetChange targetChange = TargetChange.createSynthesizedTargetChangeForCurrentChange(bool);
    } else {
      syncState = null;
    } 
    View view = new View(paramQuery, queryResult.getRemoteKeys());
    ViewChange viewChange = view.applyChanges(view.computeDocChanges(queryResult.getDocuments()), (TargetChange)syncState);
    if (view.getLimboDocuments().size() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "View returned limbo docs before target ack from the server", new Object[0]);
    QueryView queryView = new QueryView(paramQuery, paramInt, view);
    this.queryViewsByQuery.put(paramQuery, queryView);
    if (!this.queriesByTarget.containsKey(Integer.valueOf(paramInt)))
      this.queriesByTarget.put(Integer.valueOf(paramInt), new ArrayList<>(1)); 
    ((List<Query>)this.queriesByTarget.get(Integer.valueOf(paramInt))).add(paramQuery);
    return viewChange.getSnapshot();
  }
  
  private void logErrorIfInteresting(Status paramStatus, String paramString, Object... paramVarArgs) {
    if (errorIsInteresting(paramStatus))
      Logger.warn("Firestore", "%s: %s", new Object[] { String.format(paramString, paramVarArgs), paramStatus }); 
  }
  
  private void notifyUser(int paramInt, Status paramStatus) {
    Map map = this.mutationUserCallbacks.get(this.currentUser);
    if (map != null) {
      Integer integer = Integer.valueOf(paramInt);
      TaskCompletionSource taskCompletionSource = (TaskCompletionSource)map.get(integer);
      if (taskCompletionSource != null) {
        if (paramStatus != null) {
          taskCompletionSource.setException((Exception)Util.exceptionFromStatus(paramStatus));
        } else {
          taskCompletionSource.setResult(null);
        } 
        map.remove(integer);
      } 
    } 
  }
  
  private void removeAndCleanupTarget(int paramInt, Status paramStatus) {
    for (Query query : this.queriesByTarget.get(Integer.valueOf(paramInt))) {
      this.queryViewsByQuery.remove(query);
      if (!paramStatus.isOk()) {
        this.syncEngineListener.onError(query, paramStatus);
        logErrorIfInteresting(paramStatus, "Listen for %s failed", new Object[] { query });
      } 
    } 
    this.queriesByTarget.remove(Integer.valueOf(paramInt));
    ImmutableSortedSet immutableSortedSet = this.limboDocumentRefs.referencesForId(paramInt);
    this.limboDocumentRefs.removeReferencesForId(paramInt);
    for (DocumentKey documentKey : immutableSortedSet) {
      if (!this.limboDocumentRefs.containsKey(documentKey))
        removeLimboTarget(documentKey); 
    } 
  }
  
  private void removeLimboTarget(DocumentKey paramDocumentKey) {
    Integer integer = this.limboTargetsByKey.get(paramDocumentKey);
    if (integer != null) {
      this.remoteStore.stopListening(integer.intValue());
      this.limboTargetsByKey.remove(paramDocumentKey);
      this.limboResolutionsByTarget.remove(integer);
    } 
  }
  
  private void resolvePendingWriteTasks(int paramInt) {
    if (this.pendingWritesCallbacks.containsKey(Integer.valueOf(paramInt))) {
      Iterator<TaskCompletionSource> iterator = ((List)this.pendingWritesCallbacks.get(Integer.valueOf(paramInt))).iterator();
      while (iterator.hasNext())
        ((TaskCompletionSource)iterator.next()).setResult(null); 
      this.pendingWritesCallbacks.remove(Integer.valueOf(paramInt));
    } 
  }
  
  private void trackLimboChange(LimboDocumentChange paramLimboDocumentChange) {
    DocumentKey documentKey = paramLimboDocumentChange.getKey();
    if (!this.limboTargetsByKey.containsKey(documentKey)) {
      Logger.debug(TAG, "New document in limbo: %s", new Object[] { documentKey });
      int i = this.targetIdGenerator.nextId();
      QueryData queryData = new QueryData(Query.atPath(documentKey.getPath()).toTarget(), i, -1L, QueryPurpose.LIMBO_RESOLUTION);
      this.limboResolutionsByTarget.put(Integer.valueOf(i), new LimboResolution(documentKey));
      this.remoteStore.listen(queryData);
      this.limboTargetsByKey.put(documentKey, Integer.valueOf(i));
    } 
  }
  
  private void updateTrackedLimboDocuments(List<LimboDocumentChange> paramList, int paramInt) {
    for (LimboDocumentChange limboDocumentChange : paramList) {
      DocumentKey documentKey;
      int i = null.$SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type[limboDocumentChange.getType().ordinal()];
      if (i != 1) {
        if (i == 2) {
          Logger.debug(TAG, "Document no longer in limbo: %s", new Object[] { limboDocumentChange.getKey() });
          documentKey = limboDocumentChange.getKey();
          this.limboDocumentRefs.removeReference(documentKey, paramInt);
          if (!this.limboDocumentRefs.containsKey(documentKey))
            removeLimboTarget(documentKey); 
          continue;
        } 
        throw Assert.fail("Unknown limbo change type: %s", new Object[] { documentKey.getType() });
      } 
      this.limboDocumentRefs.addReference(documentKey.getKey(), paramInt);
      trackLimboChange((LimboDocumentChange)documentKey);
    } 
  }
  
  public Map<DocumentKey, Integer> getCurrentLimboDocuments() {
    return new HashMap<>(this.limboTargetsByKey);
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int paramInt) {
    LimboResolution limboResolution = this.limboResolutionsByTarget.get(Integer.valueOf(paramInt));
    if (limboResolution != null && limboResolution.receivedDocument)
      return DocumentKey.emptyKeySet().insert(limboResolution.key); 
    ArrayList arrayList = Lists.newArrayList();
    if (this.queriesByTarget.containsKey(Integer.valueOf(paramInt)))
      for (Query query : this.queriesByTarget.get(Integer.valueOf(paramInt))) {
        if (this.queryViewsByQuery.containsKey(query))
          arrayList.addAll(Lists.newArrayList((Iterable)((QueryView)this.queryViewsByQuery.get(query)).getView().getSyncedDocuments())); 
      }  
    return new ImmutableSortedSet(arrayList, DocumentKey.comparator());
  }
  
  public void handleCredentialChange(User paramUser) {
    boolean bool = this.currentUser.equals(paramUser);
    this.currentUser = paramUser;
    if ((bool ^ true) != 0) {
      failOutstandingPendingWritesAwaitingTasks();
      emitNewSnapsAndNotifyLocalStore(this.localStore.handleUserChange(paramUser), null);
    } 
    this.remoteStore.handleCredentialChange();
  }
  
  public void handleOnlineStateChange(OnlineState paramOnlineState) {
    assertCallback("handleOnlineStateChange");
    ArrayList<ViewSnapshot> arrayList = new ArrayList();
    Iterator<Map.Entry> iterator = this.queryViewsByQuery.entrySet().iterator();
    while (iterator.hasNext()) {
      ViewChange viewChange = ((QueryView)((Map.Entry)iterator.next()).getValue()).getView().applyOnlineStateChange(paramOnlineState);
      Assert.hardAssert(viewChange.getLimboChanges().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
      if (viewChange.getSnapshot() != null)
        arrayList.add(viewChange.getSnapshot()); 
    } 
    this.syncEngineListener.onViewSnapshots(arrayList);
    this.syncEngineListener.handleOnlineStateChange(paramOnlineState);
  }
  
  public void handleRejectedListen(int paramInt, Status paramStatus) {
    Map<LimboResolution, NoDocument> map;
    assertCallback("handleRejectedListen");
    LimboResolution limboResolution = this.limboResolutionsByTarget.get(Integer.valueOf(paramInt));
    if (limboResolution != null) {
      DocumentKey documentKey = limboResolution.key;
    } else {
      limboResolution = null;
    } 
    if (limboResolution != null) {
      this.limboTargetsByKey.remove(limboResolution);
      this.limboResolutionsByTarget.remove(Integer.valueOf(paramInt));
      map = Collections.singletonMap(limboResolution, new NoDocument((DocumentKey)limboResolution, SnapshotVersion.NONE, false));
      Set<LimboResolution> set = Collections.singleton(limboResolution);
      handleRemoteEvent(new RemoteEvent(SnapshotVersion.NONE, Collections.emptyMap(), Collections.emptySet(), map, set));
    } else {
      this.localStore.releaseTarget(paramInt);
      removeAndCleanupTarget(paramInt, (Status)map);
    } 
  }
  
  public void handleRejectedWrite(int paramInt, Status paramStatus) {
    assertCallback("handleRejectedWrite");
    ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap = this.localStore.rejectBatch(paramInt);
    if (!immutableSortedMap.isEmpty())
      logErrorIfInteresting(paramStatus, "Write failed at %s", new Object[] { ((DocumentKey)immutableSortedMap.getMinKey()).getPath() }); 
    notifyUser(paramInt, paramStatus);
    resolvePendingWriteTasks(paramInt);
    emitNewSnapsAndNotifyLocalStore(immutableSortedMap, null);
  }
  
  public void handleRemoteEvent(RemoteEvent paramRemoteEvent) {
    assertCallback("handleRemoteEvent");
    for (Map.Entry entry : paramRemoteEvent.getTargetChanges().entrySet()) {
      Integer integer = (Integer)entry.getKey();
      TargetChange targetChange = (TargetChange)entry.getValue();
      LimboResolution limboResolution = this.limboResolutionsByTarget.get(integer);
      if (limboResolution != null) {
        boolean bool;
        if (targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size() + targetChange.getRemovedDocuments().size() <= 1) {
          bool = true;
        } else {
          bool = false;
        } 
        Assert.hardAssert(bool, "Limbo resolution for single document contains multiple changes.", new Object[0]);
        if (targetChange.getAddedDocuments().size() > 0) {
          LimboResolution.access$002(limboResolution, true);
          continue;
        } 
        if (targetChange.getModifiedDocuments().size() > 0) {
          Assert.hardAssert(limboResolution.receivedDocument, "Received change for limbo target document without add.", new Object[0]);
          continue;
        } 
        if (targetChange.getRemovedDocuments().size() > 0) {
          Assert.hardAssert(limboResolution.receivedDocument, "Received remove for limbo target document without add.", new Object[0]);
          LimboResolution.access$002(limboResolution, false);
        } 
      } 
    } 
    emitNewSnapsAndNotifyLocalStore(this.localStore.applyRemoteEvent(paramRemoteEvent), paramRemoteEvent);
  }
  
  public void handleSuccessfulWrite(MutationBatchResult paramMutationBatchResult) {
    assertCallback("handleSuccessfulWrite");
    notifyUser(paramMutationBatchResult.getBatch().getBatchId(), null);
    resolvePendingWriteTasks(paramMutationBatchResult.getBatch().getBatchId());
    emitNewSnapsAndNotifyLocalStore(this.localStore.acknowledgeBatch(paramMutationBatchResult), null);
  }
  
  public int listen(Query paramQuery) {
    assertCallback("listen");
    Assert.hardAssert(this.queryViewsByQuery.containsKey(paramQuery) ^ true, "We already listen to query: %s", new Object[] { paramQuery });
    QueryData queryData = this.localStore.allocateTarget(paramQuery.toTarget());
    ViewSnapshot viewSnapshot = initializeViewAndComputeSnapshot(paramQuery, queryData.getTargetId());
    this.syncEngineListener.onViewSnapshots(Collections.singletonList(viewSnapshot));
    this.remoteStore.listen(queryData);
    return queryData.getTargetId();
  }
  
  public void registerPendingWritesTask(TaskCompletionSource<Void> paramTaskCompletionSource) {
    if (!this.remoteStore.canUseNetwork())
      Logger.debug(TAG, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]); 
    int i = this.localStore.getHighestUnacknowledgedBatchId();
    if (i == -1) {
      paramTaskCompletionSource.setResult(null);
      return;
    } 
    if (this.pendingWritesCallbacks.containsKey(Integer.valueOf(i))) {
      ((List<TaskCompletionSource<Void>>)this.pendingWritesCallbacks.get(Integer.valueOf(i))).add(paramTaskCompletionSource);
    } else {
      this.pendingWritesCallbacks.put(Integer.valueOf(i), Lists.newArrayList((Object[])new TaskCompletionSource[] { paramTaskCompletionSource }));
    } 
  }
  
  public void setCallback(SyncEngineCallback paramSyncEngineCallback) {
    this.syncEngineListener = paramSyncEngineCallback;
  }
  
  void stopListening(Query paramQuery) {
    boolean bool;
    assertCallback("stopListening");
    QueryView queryView = this.queryViewsByQuery.get(paramQuery);
    if (queryView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Trying to stop listening to a query not found", new Object[0]);
    this.queryViewsByQuery.remove(paramQuery);
    int i = queryView.getTargetId();
    List list = this.queriesByTarget.get(Integer.valueOf(i));
    list.remove(paramQuery);
    if (list.isEmpty()) {
      this.localStore.releaseTarget(i);
      this.remoteStore.stopListening(i);
      removeAndCleanupTarget(i, Status.OK);
    } 
  }
  
  public <TResult> Task<TResult> transaction(AsyncQueue paramAsyncQueue, Function<Transaction, Task<TResult>> paramFunction) {
    return (new TransactionRunner<>(paramAsyncQueue, this.remoteStore, paramFunction)).run();
  }
  
  public void writeMutations(List<Mutation> paramList, TaskCompletionSource<Void> paramTaskCompletionSource) {
    assertCallback("writeMutations");
    LocalWriteResult localWriteResult = this.localStore.writeLocally(paramList);
    addUserCallback(localWriteResult.getBatchId(), paramTaskCompletionSource);
    emitNewSnapsAndNotifyLocalStore(localWriteResult.getChanges(), null);
    this.remoteStore.fillWritePipeline();
  }
  
  private static class LimboResolution {
    private final DocumentKey key;
    
    private boolean receivedDocument;
    
    LimboResolution(DocumentKey param1DocumentKey) {
      this.key = param1DocumentKey;
    }
  }
  
  static interface SyncEngineCallback {
    void handleOnlineStateChange(OnlineState param1OnlineState);
    
    void onError(Query param1Query, Status param1Status);
    
    void onViewSnapshots(List<ViewSnapshot> param1List);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\SyncEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */