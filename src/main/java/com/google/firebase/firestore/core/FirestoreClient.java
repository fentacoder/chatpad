package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Function;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.IndexFreeQueryEngine;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryEngine;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.AndroidConnectivityMonitor;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FirestoreClient implements RemoteStore.RemoteStoreCallback {
  private static final String LOG_TAG = "FirestoreClient";
  
  private final AsyncQueue asyncQueue;
  
  private final CredentialsProvider credentialsProvider;
  
  private final DatabaseInfo databaseInfo;
  
  private EventManager eventManager;
  
  private LocalStore localStore;
  
  private LruGarbageCollector.Scheduler lruScheduler;
  
  private final GrpcMetadataProvider metadataProvider;
  
  private Persistence persistence;
  
  private RemoteStore remoteStore;
  
  private SyncEngine syncEngine;
  
  public FirestoreClient(Context paramContext, DatabaseInfo paramDatabaseInfo, FirebaseFirestoreSettings paramFirebaseFirestoreSettings, CredentialsProvider paramCredentialsProvider, AsyncQueue paramAsyncQueue, GrpcMetadataProvider paramGrpcMetadataProvider) {
    this.databaseInfo = paramDatabaseInfo;
    this.credentialsProvider = paramCredentialsProvider;
    this.asyncQueue = paramAsyncQueue;
    this.metadataProvider = paramGrpcMetadataProvider;
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    paramAsyncQueue.enqueueAndForget(FirestoreClient$$Lambda$1.lambdaFactory$(this, taskCompletionSource, paramContext, paramFirebaseFirestoreSettings));
    paramCredentialsProvider.setChangeListener(FirestoreClient$$Lambda$2.lambdaFactory$(this, atomicBoolean, taskCompletionSource, paramAsyncQueue));
  }
  
  private void initialize(Context paramContext, User paramUser, boolean paramBoolean, long paramLong) {
    LruGarbageCollector lruGarbageCollector;
    Logger.debug("FirestoreClient", "Initializing. user=%s", new Object[] { paramUser.getUid() });
    if (paramBoolean) {
      LocalSerializer localSerializer = new LocalSerializer(new RemoteSerializer(this.databaseInfo.getDatabaseId()));
      LruGarbageCollector.Params params = LruGarbageCollector.Params.WithCacheSizeBytes(paramLong);
      SQLitePersistence sQLitePersistence = new SQLitePersistence(paramContext, this.databaseInfo.getPersistenceKey(), this.databaseInfo.getDatabaseId(), localSerializer, params);
      lruGarbageCollector = sQLitePersistence.getReferenceDelegate().getGarbageCollector();
      this.persistence = (Persistence)sQLitePersistence;
    } else {
      this.persistence = (Persistence)MemoryPersistence.createEagerGcMemoryPersistence();
      lruGarbageCollector = null;
    } 
    this.persistence.start();
    IndexFreeQueryEngine indexFreeQueryEngine = new IndexFreeQueryEngine();
    this.localStore = new LocalStore(this.persistence, (QueryEngine)indexFreeQueryEngine, paramUser);
    if (lruGarbageCollector != null) {
      this.lruScheduler = lruGarbageCollector.newScheduler(this.asyncQueue, this.localStore);
      this.lruScheduler.start();
    } 
    Datastore datastore = new Datastore(this.databaseInfo, this.asyncQueue, this.credentialsProvider, paramContext, this.metadataProvider);
    AndroidConnectivityMonitor androidConnectivityMonitor = new AndroidConnectivityMonitor(paramContext);
    this.remoteStore = new RemoteStore(this, this.localStore, datastore, this.asyncQueue, (ConnectivityMonitor)androidConnectivityMonitor);
    this.syncEngine = new SyncEngine(this.localStore, this.remoteStore, paramUser);
    this.eventManager = new EventManager(this.syncEngine);
    this.localStore.start();
    this.remoteStore.start();
  }
  
  private void verifyNotTerminated() {
    if (!isTerminated())
      return; 
    throw new IllegalStateException("The client has already been terminated");
  }
  
  public void addSnapshotsInSyncListener(EventListener<Void> paramEventListener) {
    verifyNotTerminated();
    this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$14.lambdaFactory$(this, paramEventListener));
  }
  
  public Task<Void> disableNetwork() {
    verifyNotTerminated();
    return this.asyncQueue.enqueue(FirestoreClient$$Lambda$3.lambdaFactory$(this));
  }
  
  public Task<Void> enableNetwork() {
    verifyNotTerminated();
    return this.asyncQueue.enqueue(FirestoreClient$$Lambda$4.lambdaFactory$(this));
  }
  
  public Task<Document> getDocumentFromLocalCache(DocumentKey paramDocumentKey) {
    verifyNotTerminated();
    return this.asyncQueue.enqueue(FirestoreClient$$Lambda$8.lambdaFactory$(this, paramDocumentKey)).continueWith(FirestoreClient$$Lambda$9.lambdaFactory$());
  }
  
  public Task<ViewSnapshot> getDocumentsFromLocalCache(Query paramQuery) {
    verifyNotTerminated();
    return this.asyncQueue.enqueue(FirestoreClient$$Lambda$10.lambdaFactory$(this, paramQuery));
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int paramInt) {
    return this.syncEngine.getRemoteKeysForTarget(paramInt);
  }
  
  public void handleOnlineStateChange(OnlineState paramOnlineState) {
    this.syncEngine.handleOnlineStateChange(paramOnlineState);
  }
  
  public void handleRejectedListen(int paramInt, Status paramStatus) {
    this.syncEngine.handleRejectedListen(paramInt, paramStatus);
  }
  
  public void handleRejectedWrite(int paramInt, Status paramStatus) {
    this.syncEngine.handleRejectedWrite(paramInt, paramStatus);
  }
  
  public void handleRemoteEvent(RemoteEvent paramRemoteEvent) {
    this.syncEngine.handleRemoteEvent(paramRemoteEvent);
  }
  
  public void handleSuccessfulWrite(MutationBatchResult paramMutationBatchResult) {
    this.syncEngine.handleSuccessfulWrite(paramMutationBatchResult);
  }
  
  public boolean isTerminated() {
    return this.asyncQueue.isShuttingDown();
  }
  
  public QueryListener listen(Query paramQuery, EventManager.ListenOptions paramListenOptions, EventListener<ViewSnapshot> paramEventListener) {
    verifyNotTerminated();
    QueryListener queryListener = new QueryListener(paramQuery, paramListenOptions, paramEventListener);
    this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$6.lambdaFactory$(this, queryListener));
    return queryListener;
  }
  
  public void removeSnapshotsInSyncListener(EventListener<Void> paramEventListener) {
    if (isTerminated())
      return; 
    this.eventManager.removeSnapshotsInSyncListener(paramEventListener);
  }
  
  public void stopListening(QueryListener paramQueryListener) {
    if (isTerminated())
      return; 
    this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$7.lambdaFactory$(this, paramQueryListener));
  }
  
  public Task<Void> terminate() {
    this.credentialsProvider.removeChangeListener();
    return this.asyncQueue.enqueueAndInitiateShutdown(FirestoreClient$$Lambda$5.lambdaFactory$(this));
  }
  
  public <TResult> Task<TResult> transaction(Function<Transaction, Task<TResult>> paramFunction) {
    verifyNotTerminated();
    return AsyncQueue.callTask(this.asyncQueue.getExecutor(), FirestoreClient$$Lambda$12.lambdaFactory$(this, paramFunction));
  }
  
  public Task<Void> waitForPendingWrites() {
    verifyNotTerminated();
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$13.lambdaFactory$(this, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public Task<Void> write(List<Mutation> paramList) {
    verifyNotTerminated();
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.asyncQueue.enqueueAndForget(FirestoreClient$$Lambda$11.lambdaFactory$(this, paramList, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\FirestoreClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */