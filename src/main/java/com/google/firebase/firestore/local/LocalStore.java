package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class LocalStore {
  private static final long RESUME_TOKEN_MAX_AGE_SECONDS = TimeUnit.MINUTES.toSeconds(5L);
  
  private LocalDocumentsView localDocuments;
  
  private final ReferenceSet localViewReferences;
  
  private MutationQueue mutationQueue;
  
  private final Persistence persistence;
  
  private final QueryCache queryCache;
  
  private final SparseArray<QueryData> queryDataByTarget;
  
  private QueryEngine queryEngine;
  
  private final RemoteDocumentCache remoteDocuments;
  
  private final Map<Target, Integer> targetIdByTarget;
  
  private final TargetIdGenerator targetIdGenerator;
  
  public LocalStore(Persistence paramPersistence, QueryEngine paramQueryEngine, User paramUser) {
    Assert.hardAssert(paramPersistence.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
    this.persistence = paramPersistence;
    this.queryCache = paramPersistence.getQueryCache();
    this.targetIdGenerator = TargetIdGenerator.forQueryCache(this.queryCache.getHighestTargetId());
    this.mutationQueue = paramPersistence.getMutationQueue(paramUser);
    this.remoteDocuments = paramPersistence.getRemoteDocumentCache();
    this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, paramPersistence.getIndexManager());
    this.queryEngine = paramQueryEngine;
    paramQueryEngine.setLocalDocumentsView(this.localDocuments);
    this.localViewReferences = new ReferenceSet();
    paramPersistence.getReferenceDelegate().setInMemoryPins(this.localViewReferences);
    this.queryDataByTarget = new SparseArray();
    this.targetIdByTarget = new HashMap<>();
  }
  
  private void applyWriteToRemoteDocuments(MutationBatchResult paramMutationBatchResult) {
    MutationBatch mutationBatch = paramMutationBatchResult.getBatch();
    for (DocumentKey documentKey : mutationBatch.getKeys()) {
      boolean bool;
      MaybeDocument maybeDocument = this.remoteDocuments.get(documentKey);
      SnapshotVersion snapshotVersion = (SnapshotVersion)paramMutationBatchResult.getDocVersions().get(documentKey);
      if (snapshotVersion != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "docVersions should contain every doc in the write.", new Object[0]);
      if (maybeDocument == null || maybeDocument.getVersion().compareTo(snapshotVersion) < 0) {
        MaybeDocument maybeDocument1 = mutationBatch.applyToRemoteDocument(documentKey, maybeDocument, paramMutationBatchResult);
        if (maybeDocument1 == null) {
          if (maybeDocument == null) {
            bool = true;
          } else {
            bool = false;
          } 
          Assert.hardAssert(bool, "Mutation batch %s applied to document %s resulted in null.", new Object[] { mutationBatch, maybeDocument });
          continue;
        } 
        this.remoteDocuments.add(maybeDocument1, paramMutationBatchResult.getCommitVersion());
      } 
    } 
    this.mutationQueue.removeMutationBatch(mutationBatch);
  }
  
  private static boolean shouldPersistQueryData(QueryData paramQueryData1, QueryData paramQueryData2, TargetChange paramTargetChange) {
    boolean bool = paramQueryData2.getResumeToken().isEmpty();
    boolean bool1 = true;
    Assert.hardAssert(bool ^ true, "Attempted to persist query data with empty resume token", new Object[0]);
    if (paramQueryData1.getResumeToken().isEmpty())
      return true; 
    if (paramQueryData2.getSnapshotVersion().getTimestamp().getSeconds() - paramQueryData1.getSnapshotVersion().getTimestamp().getSeconds() >= RESUME_TOKEN_MAX_AGE_SECONDS)
      return true; 
    if (paramTargetChange.getAddedDocuments().size() + paramTargetChange.getModifiedDocuments().size() + paramTargetChange.getRemovedDocuments().size() <= 0)
      bool1 = false; 
    return bool1;
  }
  
  private void startMutationQueue() {
    this.persistence.runTransaction("Start MutationQueue", LocalStore$$Lambda$1.lambdaFactory$(this));
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> acknowledgeBatch(MutationBatchResult paramMutationBatchResult) {
    return this.persistence.<ImmutableSortedMap<DocumentKey, MaybeDocument>>runTransaction("Acknowledge batch", LocalStore$$Lambda$3.lambdaFactory$(this, paramMutationBatchResult));
  }
  
  public QueryData allocateTarget(Target paramTarget) {
    int i;
    QueryData queryData = this.queryCache.getQueryData(paramTarget);
    if (queryData != null) {
      i = queryData.getTargetId();
    } else {
      AllocateQueryHolder allocateQueryHolder = new AllocateQueryHolder();
      this.persistence.runTransaction("Allocate target", LocalStore$$Lambda$8.lambdaFactory$(this, allocateQueryHolder, paramTarget));
      i = allocateQueryHolder.targetId;
      queryData = allocateQueryHolder.cached;
    } 
    if (this.queryDataByTarget.get(i) == null) {
      this.queryDataByTarget.put(i, queryData);
      this.targetIdByTarget.put(paramTarget, Integer.valueOf(i));
    } 
    return queryData;
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> applyRemoteEvent(RemoteEvent paramRemoteEvent) {
    SnapshotVersion snapshotVersion = paramRemoteEvent.getSnapshotVersion();
    return this.persistence.<ImmutableSortedMap<DocumentKey, MaybeDocument>>runTransaction("Apply remote event", LocalStore$$Lambda$6.lambdaFactory$(this, paramRemoteEvent, snapshotVersion));
  }
  
  public LruGarbageCollector.Results collectGarbage(LruGarbageCollector paramLruGarbageCollector) {
    return this.persistence.<LruGarbageCollector.Results>runTransaction("Collect garbage", LocalStore$$Lambda$10.lambdaFactory$(this, paramLruGarbageCollector));
  }
  
  public QueryResult executeQuery(Query paramQuery, boolean paramBoolean) {
    ImmutableSortedSet<DocumentKey> immutableSortedSet1;
    QueryData queryData = getQueryData(paramQuery.toTarget());
    SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
    ImmutableSortedSet<DocumentKey> immutableSortedSet2 = DocumentKey.emptyKeySet();
    if (queryData != null) {
      snapshotVersion = queryData.getLastLimboFreeSnapshotVersion();
      immutableSortedSet2 = this.queryCache.getMatchingKeysForTargetId(queryData.getTargetId());
    } 
    QueryEngine queryEngine = this.queryEngine;
    if (!paramBoolean)
      snapshotVersion = SnapshotVersion.NONE; 
    if (paramBoolean) {
      immutableSortedSet1 = immutableSortedSet2;
    } else {
      immutableSortedSet1 = DocumentKey.emptyKeySet();
    } 
    return new QueryResult(queryEngine.getDocumentsMatchingQuery(paramQuery, snapshotVersion, immutableSortedSet1), immutableSortedSet2);
  }
  
  public int getHighestUnacknowledgedBatchId() {
    return this.mutationQueue.getHighestUnacknowledgedBatchId();
  }
  
  public SnapshotVersion getLastRemoteSnapshotVersion() {
    return this.queryCache.getLastRemoteSnapshotVersion();
  }
  
  public ByteString getLastStreamToken() {
    return this.mutationQueue.getLastStreamToken();
  }
  
  public MutationBatch getNextMutationBatch(int paramInt) {
    return this.mutationQueue.getNextMutationBatchAfterBatchId(paramInt);
  }
  
  QueryData getQueryData(Target paramTarget) {
    Integer integer = this.targetIdByTarget.get(paramTarget);
    return (integer != null) ? (QueryData)this.queryDataByTarget.get(integer.intValue()) : this.queryCache.getQueryData(paramTarget);
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int paramInt) {
    return this.queryCache.getMatchingKeysForTargetId(paramInt);
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> handleUserChange(User paramUser) {
    List<MutationBatch> list2 = this.mutationQueue.getAllMutationBatches();
    this.mutationQueue = this.persistence.getMutationQueue(paramUser);
    startMutationQueue();
    List<MutationBatch> list1 = this.mutationQueue.getAllMutationBatches();
    this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, this.persistence.getIndexManager());
    this.queryEngine.setLocalDocumentsView(this.localDocuments);
    ImmutableSortedSet immutableSortedSet = DocumentKey.emptyKeySet();
    Iterator<List> iterator = Arrays.<List>asList(new List[] { list2, list1 }).iterator();
    label16: while (iterator.hasNext()) {
      Iterator<MutationBatch> iterator1 = ((List)iterator.next()).iterator();
      ImmutableSortedSet immutableSortedSet1 = immutableSortedSet;
      label14: while (true) {
        immutableSortedSet = immutableSortedSet1;
        if (iterator1.hasNext()) {
          Iterator<Mutation> iterator2 = ((MutationBatch)iterator1.next()).getMutations().iterator();
          immutableSortedSet = immutableSortedSet1;
          while (true) {
            immutableSortedSet1 = immutableSortedSet;
            if (iterator2.hasNext()) {
              immutableSortedSet = immutableSortedSet.insert(((Mutation)iterator2.next()).getKey());
              continue;
            } 
            continue label14;
          } 
          break;
        } 
        continue label16;
      } 
    } 
    return this.localDocuments.getDocuments((Iterable<DocumentKey>)immutableSortedSet);
  }
  
  public void notifyLocalViewChanges(List<LocalViewChanges> paramList) {
    this.persistence.runTransaction("notifyLocalViewChanges", LocalStore$$Lambda$7.lambdaFactory$(this, paramList));
  }
  
  public MaybeDocument readDocument(DocumentKey paramDocumentKey) {
    return this.localDocuments.getDocument(paramDocumentKey);
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> rejectBatch(int paramInt) {
    return this.persistence.<ImmutableSortedMap<DocumentKey, MaybeDocument>>runTransaction("Reject batch", LocalStore$$Lambda$4.lambdaFactory$(this, paramInt));
  }
  
  public void releaseTarget(int paramInt) {
    this.persistence.runTransaction("Release target", LocalStore$$Lambda$9.lambdaFactory$(this, paramInt));
  }
  
  public void setLastStreamToken(ByteString paramByteString) {
    this.persistence.runTransaction("Set stream token", LocalStore$$Lambda$5.lambdaFactory$(this, paramByteString));
  }
  
  public void start() {
    startMutationQueue();
  }
  
  public LocalWriteResult writeLocally(List<Mutation> paramList) {
    Timestamp timestamp = Timestamp.now();
    HashSet<DocumentKey> hashSet = new HashSet();
    Iterator<Mutation> iterator = paramList.iterator();
    while (iterator.hasNext())
      hashSet.add(((Mutation)iterator.next()).getKey()); 
    return this.persistence.<LocalWriteResult>runTransaction("Locally write mutations", LocalStore$$Lambda$2.lambdaFactory$(this, hashSet, paramList, timestamp));
  }
  
  private static class AllocateQueryHolder {
    QueryData cached;
    
    int targetId;
    
    private AllocateQueryHolder() {}
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LocalStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */