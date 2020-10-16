package com.google.firebase.firestore;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.EmptyCredentialsProvider;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import java.util.concurrent.Executor;

public class FirebaseFirestore {
  private static final String TAG = "FirebaseFirestore";
  
  private final AsyncQueue asyncQueue;
  
  private volatile FirestoreClient client;
  
  private final Context context;
  
  private final CredentialsProvider credentialsProvider;
  
  private final UserDataConverter dataConverter;
  
  private final DatabaseId databaseId;
  
  private final FirebaseApp firebaseApp;
  
  private final InstanceRegistry instanceRegistry;
  
  private final GrpcMetadataProvider metadataProvider;
  
  private final String persistenceKey;
  
  private FirebaseFirestoreSettings settings;
  
  FirebaseFirestore(Context paramContext, DatabaseId paramDatabaseId, String paramString, CredentialsProvider paramCredentialsProvider, AsyncQueue paramAsyncQueue, FirebaseApp paramFirebaseApp, InstanceRegistry paramInstanceRegistry, GrpcMetadataProvider paramGrpcMetadataProvider) {
    this.context = (Context)Preconditions.checkNotNull(paramContext);
    this.databaseId = (DatabaseId)Preconditions.checkNotNull(Preconditions.checkNotNull(paramDatabaseId));
    this.dataConverter = new UserDataConverter(paramDatabaseId);
    this.persistenceKey = (String)Preconditions.checkNotNull(paramString);
    this.credentialsProvider = (CredentialsProvider)Preconditions.checkNotNull(paramCredentialsProvider);
    this.asyncQueue = (AsyncQueue)Preconditions.checkNotNull(paramAsyncQueue);
    this.firebaseApp = paramFirebaseApp;
    this.instanceRegistry = paramInstanceRegistry;
    this.metadataProvider = paramGrpcMetadataProvider;
    this.settings = (new FirebaseFirestoreSettings.Builder()).build();
  }
  
  private ListenerRegistration addSnapshotsInSyncListener(Executor paramExecutor, Activity paramActivity, Runnable paramRunnable) {
    ensureClientConfigured();
    AsyncEventListener asyncEventListener = new AsyncEventListener(paramExecutor, FirebaseFirestore$$Lambda$3.lambdaFactory$(paramRunnable));
    this.client.addSnapshotsInSyncListener((EventListener)asyncEventListener);
    return ActivityScope.bind(paramActivity, FirebaseFirestore$$Lambda$4.lambdaFactory$(this, asyncEventListener));
  }
  
  private void ensureClientConfigured() {
    if (this.client != null)
      return; 
    synchronized (this.databaseId) {
      if (this.client != null)
        return; 
      DatabaseInfo databaseInfo = new DatabaseInfo();
      this(this.databaseId, this.persistenceKey, this.settings.getHost(), this.settings.isSslEnabled());
      FirestoreClient firestoreClient = new FirestoreClient();
      this(this.context, databaseInfo, this.settings, this.credentialsProvider, this.asyncQueue, this.metadataProvider);
      this.client = firestoreClient;
      return;
    } 
  }
  
  public static FirebaseFirestore getInstance() {
    FirebaseApp firebaseApp = FirebaseApp.getInstance();
    if (firebaseApp != null)
      return getInstance(firebaseApp, "(default)"); 
    throw new IllegalStateException("You must call FirebaseApp.initializeApp first.");
  }
  
  public static FirebaseFirestore getInstance(FirebaseApp paramFirebaseApp) {
    return getInstance(paramFirebaseApp, "(default)");
  }
  
  private static FirebaseFirestore getInstance(FirebaseApp paramFirebaseApp, String paramString) {
    Preconditions.checkNotNull(paramFirebaseApp, "Provided FirebaseApp must not be null.");
    FirestoreMultiDbComponent firestoreMultiDbComponent = (FirestoreMultiDbComponent)paramFirebaseApp.get(FirestoreMultiDbComponent.class);
    Preconditions.checkNotNull(firestoreMultiDbComponent, "Firestore component is not present.");
    return firestoreMultiDbComponent.get(paramString);
  }
  
  static FirebaseFirestore newInstance(Context paramContext, FirebaseApp paramFirebaseApp, InternalAuthProvider paramInternalAuthProvider, String paramString, InstanceRegistry paramInstanceRegistry, GrpcMetadataProvider paramGrpcMetadataProvider) {
    String str = paramFirebaseApp.getOptions().getProjectId();
    if (str != null) {
      EmptyCredentialsProvider emptyCredentialsProvider;
      FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider;
      DatabaseId databaseId = DatabaseId.forDatabase(str, paramString);
      AsyncQueue asyncQueue = new AsyncQueue();
      if (paramInternalAuthProvider == null) {
        Logger.debug("FirebaseFirestore", "Firebase Auth not available, falling back to unauthenticated usage.", new Object[0]);
        emptyCredentialsProvider = new EmptyCredentialsProvider();
      } else {
        firebaseAuthCredentialsProvider = new FirebaseAuthCredentialsProvider((InternalAuthProvider)emptyCredentialsProvider);
      } 
      return new FirebaseFirestore(paramContext, databaseId, paramFirebaseApp.getName(), (CredentialsProvider)firebaseAuthCredentialsProvider, asyncQueue, paramFirebaseApp, paramInstanceRegistry, paramGrpcMetadataProvider);
    } 
    throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
  }
  
  private <ResultT> Task<ResultT> runTransaction(Transaction.Function<ResultT> paramFunction, Executor paramExecutor) {
    ensureClientConfigured();
    Function function = FirebaseFirestore$$Lambda$1.lambdaFactory$(this, paramExecutor, paramFunction);
    return this.client.transaction(function);
  }
  
  public static void setLoggingEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      Logger.setLogLevel(Logger.Level.DEBUG);
    } else {
      Logger.setLogLevel(Logger.Level.WARN);
    } 
  }
  
  public ListenerRegistration addSnapshotsInSyncListener(Activity paramActivity, Runnable paramRunnable) {
    return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, paramActivity, paramRunnable);
  }
  
  public ListenerRegistration addSnapshotsInSyncListener(Runnable paramRunnable) {
    return addSnapshotsInSyncListener(Executors.DEFAULT_CALLBACK_EXECUTOR, paramRunnable);
  }
  
  public ListenerRegistration addSnapshotsInSyncListener(Executor paramExecutor, Runnable paramRunnable) {
    return addSnapshotsInSyncListener(paramExecutor, null, paramRunnable);
  }
  
  public WriteBatch batch() {
    ensureClientConfigured();
    return new WriteBatch(this);
  }
  
  public Task<Void> clearPersistence() {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.asyncQueue.enqueueAndForgetEvenAfterShutdown(FirebaseFirestore$$Lambda$2.lambdaFactory$(this, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public CollectionReference collection(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided collection path must not be null.");
    ensureClientConfigured();
    return new CollectionReference(ResourcePath.fromString(paramString), this);
  }
  
  public Query collectionGroup(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided collection ID must not be null.");
    if (!paramString.contains("/")) {
      ensureClientConfigured();
      return new Query(new Query(ResourcePath.EMPTY, paramString), this);
    } 
    throw new IllegalArgumentException(String.format("Invalid collectionId '%s'. Collection IDs must not contain '/'.", new Object[] { paramString }));
  }
  
  public Task<Void> disableNetwork() {
    ensureClientConfigured();
    return this.client.disableNetwork();
  }
  
  public DocumentReference document(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided document path must not be null.");
    ensureClientConfigured();
    return DocumentReference.forPath(ResourcePath.fromString(paramString), this);
  }
  
  public Task<Void> enableNetwork() {
    ensureClientConfigured();
    return this.client.enableNetwork();
  }
  
  public FirebaseApp getApp() {
    return this.firebaseApp;
  }
  
  AsyncQueue getAsyncQueue() {
    return this.asyncQueue;
  }
  
  FirestoreClient getClient() {
    return this.client;
  }
  
  UserDataConverter getDataConverter() {
    return this.dataConverter;
  }
  
  DatabaseId getDatabaseId() {
    return this.databaseId;
  }
  
  public FirebaseFirestoreSettings getFirestoreSettings() {
    return this.settings;
  }
  
  public Task<Void> runBatch(WriteBatch.Function paramFunction) {
    WriteBatch writeBatch = batch();
    paramFunction.apply(writeBatch);
    return writeBatch.commit();
  }
  
  public <TResult> Task<TResult> runTransaction(Transaction.Function<TResult> paramFunction) {
    Preconditions.checkNotNull(paramFunction, "Provided transaction update function must not be null.");
    return runTransaction(paramFunction, Transaction.getDefaultExecutor());
  }
  
  public void setFirestoreSettings(FirebaseFirestoreSettings paramFirebaseFirestoreSettings) {
    synchronized (this.databaseId) {
      Preconditions.checkNotNull(paramFirebaseFirestoreSettings, "Provided settings must not be null.");
      if (this.client == null || this.settings.equals(paramFirebaseFirestoreSettings)) {
        this.settings = paramFirebaseFirestoreSettings;
        return;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      this("FirebaseFirestore has already been started and its settings can no longer be changed. You can only call setFirestoreSettings() before calling any other methods on a FirebaseFirestore object.");
      throw illegalStateException;
    } 
  }
  
  public Task<Void> terminate() {
    this.instanceRegistry.remove(getDatabaseId().getDatabaseId());
    return terminateInternal();
  }
  
  Task<Void> terminateInternal() {
    ensureClientConfigured();
    return this.client.terminate();
  }
  
  void validateReference(DocumentReference paramDocumentReference) {
    Preconditions.checkNotNull(paramDocumentReference, "Provided DocumentReference must not be null.");
    if (paramDocumentReference.getFirestore() == this)
      return; 
    throw new IllegalArgumentException("Provided document reference is from a different Cloud Firestore instance.");
  }
  
  public Task<Void> waitForPendingWrites() {
    return this.client.waitForPendingWrites();
  }
  
  public static interface InstanceRegistry {
    void remove(String param1String);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FirebaseFirestore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */