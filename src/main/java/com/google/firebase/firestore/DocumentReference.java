package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.QueryListener;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class DocumentReference {
  private final FirebaseFirestore firestore;
  
  private final DocumentKey key;
  
  DocumentReference(DocumentKey paramDocumentKey, FirebaseFirestore paramFirebaseFirestore) {
    this.key = (DocumentKey)Preconditions.checkNotNull(paramDocumentKey);
    this.firestore = paramFirebaseFirestore;
  }
  
  private ListenerRegistration addSnapshotListenerInternal(Executor paramExecutor, EventManager.ListenOptions paramListenOptions, Activity paramActivity, EventListener<DocumentSnapshot> paramEventListener) {
    AsyncEventListener asyncEventListener = new AsyncEventListener(paramExecutor, DocumentReference$$Lambda$3.lambdaFactory$(this, paramEventListener));
    Query query = asQuery();
    QueryListener queryListener = this.firestore.getClient().listen(query, paramListenOptions, (EventListener)asyncEventListener);
    return ActivityScope.bind(paramActivity, (ListenerRegistration)new ListenerRegistrationImpl(this.firestore.getClient(), queryListener, asyncEventListener));
  }
  
  private Query asQuery() {
    return Query.atPath(this.key.getPath());
  }
  
  static DocumentReference forPath(ResourcePath paramResourcePath, FirebaseFirestore paramFirebaseFirestore) {
    if (paramResourcePath.length() % 2 == 0)
      return new DocumentReference(DocumentKey.fromPath(paramResourcePath), paramFirebaseFirestore); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid document reference. Document references must have an even number of segments, but ");
    stringBuilder.append(paramResourcePath.canonicalString());
    stringBuilder.append(" has ");
    stringBuilder.append(paramResourcePath.length());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Task<DocumentSnapshot> getViaSnapshotListener(Source paramSource) {
    TaskCompletionSource taskCompletionSource1 = new TaskCompletionSource();
    TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
    EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
    listenOptions.includeDocumentMetadataChanges = true;
    listenOptions.includeQueryMetadataChanges = true;
    listenOptions.waitForSyncWhenOnline = true;
    taskCompletionSource2.setResult(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, null, DocumentReference$$Lambda$2.lambdaFactory$(taskCompletionSource1, taskCompletionSource2, paramSource)));
    return taskCompletionSource1.getTask();
  }
  
  private static EventManager.ListenOptions internalOptions(MetadataChanges paramMetadataChanges) {
    boolean bool2;
    EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
    MetadataChanges metadataChanges = MetadataChanges.INCLUDE;
    boolean bool1 = true;
    if (paramMetadataChanges == metadataChanges) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    listenOptions.includeDocumentMetadataChanges = bool2;
    if (paramMetadataChanges == MetadataChanges.INCLUDE) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    listenOptions.includeQueryMetadataChanges = bool2;
    listenOptions.waitForSyncWhenOnline = false;
    return listenOptions;
  }
  
  private Task<Void> update(UserData.ParsedUpdateData paramParsedUpdateData) {
    return this.firestore.getClient().write(paramParsedUpdateData.toMutationList(this.key, Precondition.exists(true))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
  }
  
  public ListenerRegistration addSnapshotListener(Activity paramActivity, EventListener<DocumentSnapshot> paramEventListener) {
    return addSnapshotListener(paramActivity, MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Activity paramActivity, MetadataChanges paramMetadataChanges, EventListener<DocumentSnapshot> paramEventListener) {
    Preconditions.checkNotNull(paramActivity, "Provided activity must not be null.");
    Preconditions.checkNotNull(paramMetadataChanges, "Provided MetadataChanges value must not be null.");
    Preconditions.checkNotNull(paramEventListener, "Provided EventListener must not be null.");
    return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, internalOptions(paramMetadataChanges), paramActivity, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(EventListener<DocumentSnapshot> paramEventListener) {
    return addSnapshotListener(MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(MetadataChanges paramMetadataChanges, EventListener<DocumentSnapshot> paramEventListener) {
    return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, paramMetadataChanges, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Executor paramExecutor, EventListener<DocumentSnapshot> paramEventListener) {
    return addSnapshotListener(paramExecutor, MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Executor paramExecutor, MetadataChanges paramMetadataChanges, EventListener<DocumentSnapshot> paramEventListener) {
    Preconditions.checkNotNull(paramExecutor, "Provided executor must not be null.");
    Preconditions.checkNotNull(paramMetadataChanges, "Provided MetadataChanges value must not be null.");
    Preconditions.checkNotNull(paramEventListener, "Provided EventListener must not be null.");
    return addSnapshotListenerInternal(paramExecutor, internalOptions(paramMetadataChanges), null, paramEventListener);
  }
  
  public CollectionReference collection(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided collection path must not be null.");
    return new CollectionReference((ResourcePath)this.key.getPath().append((BasePath)ResourcePath.fromString(paramString)), this.firestore);
  }
  
  public Task<Void> delete() {
    return this.firestore.getClient().write(Collections.singletonList(new DeleteMutation(this.key, Precondition.NONE))).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DocumentReference))
      return false; 
    paramObject = paramObject;
    if (!this.key.equals(((DocumentReference)paramObject).key) || !this.firestore.equals(((DocumentReference)paramObject).firestore))
      bool = false; 
    return bool;
  }
  
  public Task<DocumentSnapshot> get() {
    return get(Source.DEFAULT);
  }
  
  public Task<DocumentSnapshot> get(Source paramSource) {
    return (paramSource == Source.CACHE) ? this.firestore.getClient().getDocumentFromLocalCache(this.key).continueWith(Executors.DIRECT_EXECUTOR, DocumentReference$$Lambda$1.lambdaFactory$(this)) : getViaSnapshotListener(paramSource);
  }
  
  public FirebaseFirestore getFirestore() {
    return this.firestore;
  }
  
  public String getId() {
    return this.key.getPath().getLastSegment();
  }
  
  DocumentKey getKey() {
    return this.key;
  }
  
  public CollectionReference getParent() {
    return new CollectionReference((ResourcePath)this.key.getPath().popLast(), this.firestore);
  }
  
  public String getPath() {
    return this.key.getPath().canonicalString();
  }
  
  public int hashCode() {
    return this.key.hashCode() * 31 + this.firestore.hashCode();
  }
  
  public Task<Void> set(Object paramObject) {
    return set(paramObject, SetOptions.OVERWRITE);
  }
  
  public Task<Void> set(Object paramObject, SetOptions paramSetOptions) {
    Preconditions.checkNotNull(paramObject, "Provided data must not be null.");
    Preconditions.checkNotNull(paramSetOptions, "Provided options must not be null.");
    if (paramSetOptions.isMerge()) {
      paramObject = this.firestore.getDataConverter().parseMergeData(paramObject, paramSetOptions.getFieldMask());
    } else {
      paramObject = this.firestore.getDataConverter().parseSetData(paramObject);
    } 
    return this.firestore.getClient().write(paramObject.toMutationList(this.key, Precondition.NONE)).continueWith(Executors.DIRECT_EXECUTOR, Util.voidErrorTransformer());
  }
  
  public Task<Void> update(FieldPath paramFieldPath, Object paramObject, Object... paramVarArgs) {
    return update(this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramFieldPath, paramObject, paramVarArgs)));
  }
  
  public Task<Void> update(String paramString, Object paramObject, Object... paramVarArgs) {
    return update(this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramString, paramObject, paramVarArgs)));
  }
  
  public Task<Void> update(Map<String, Object> paramMap) {
    return update(this.firestore.getDataConverter().parseUpdateData(paramMap));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\DocumentReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */