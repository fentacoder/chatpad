package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Transaction {
  private static final Executor defaultExecutor = createDefaultExecutor();
  
  private boolean committed;
  
  private final Datastore datastore;
  
  private FirebaseFirestoreException lastWriteError;
  
  private final ArrayList<Mutation> mutations = new ArrayList<>();
  
  private final HashMap<DocumentKey, SnapshotVersion> readVersions = new HashMap<>();
  
  private Set<DocumentKey> writtenDocs = new HashSet<>();
  
  public Transaction(Datastore paramDatastore) {
    this.datastore = paramDatastore;
  }
  
  private static Executor createDefaultExecutor() {
    LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue();
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    threadPoolExecutor.allowCoreThreadTimeOut(true);
    return threadPoolExecutor;
  }
  
  private void ensureCommitNotCalled() {
    Assert.hardAssert(this.committed ^ true, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
  }
  
  public static Executor getDefaultExecutor() {
    return defaultExecutor;
  }
  
  private Precondition precondition(DocumentKey paramDocumentKey) {
    SnapshotVersion snapshotVersion = this.readVersions.get(paramDocumentKey);
    return (!this.writtenDocs.contains(paramDocumentKey) && snapshotVersion != null) ? Precondition.updateTime(snapshotVersion) : Precondition.NONE;
  }
  
  private Precondition preconditionForUpdate(DocumentKey paramDocumentKey) throws FirebaseFirestoreException {
    SnapshotVersion snapshotVersion = this.readVersions.get(paramDocumentKey);
    if (!this.writtenDocs.contains(paramDocumentKey) && snapshotVersion != null) {
      if (snapshotVersion == null || !snapshotVersion.equals(SnapshotVersion.NONE))
        return Precondition.updateTime(snapshotVersion); 
      throw new FirebaseFirestoreException("Can't update a document that doesn't exist.", FirebaseFirestoreException.Code.INVALID_ARGUMENT);
    } 
    return Precondition.exists(true);
  }
  
  private void recordVersion(MaybeDocument paramMaybeDocument) throws FirebaseFirestoreException {
    StringBuilder stringBuilder;
    if (paramMaybeDocument instanceof com.google.firebase.firestore.model.Document) {
      SnapshotVersion snapshotVersion = paramMaybeDocument.getVersion();
    } else if (paramMaybeDocument instanceof com.google.firebase.firestore.model.NoDocument) {
      SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected document type in transaction: ");
      stringBuilder.append(paramMaybeDocument.getClass().getCanonicalName());
      throw Assert.fail(stringBuilder.toString(), new Object[0]);
    } 
    if (this.readVersions.containsKey(paramMaybeDocument.getKey())) {
      if (!((SnapshotVersion)this.readVersions.get(paramMaybeDocument.getKey())).equals(paramMaybeDocument.getVersion()))
        throw new FirebaseFirestoreException("Document version changed between two reads.", FirebaseFirestoreException.Code.ABORTED); 
    } else {
      this.readVersions.put(paramMaybeDocument.getKey(), stringBuilder);
    } 
  }
  
  private void write(List<Mutation> paramList) {
    ensureCommitNotCalled();
    this.mutations.addAll(paramList);
  }
  
  public Task<Void> commit() {
    ensureCommitNotCalled();
    FirebaseFirestoreException firebaseFirestoreException = this.lastWriteError;
    if (firebaseFirestoreException != null)
      return Tasks.forException((Exception)firebaseFirestoreException); 
    HashSet hashSet = new HashSet(this.readVersions.keySet());
    Iterator<Mutation> iterator = this.mutations.iterator();
    while (iterator.hasNext())
      hashSet.remove(((Mutation)iterator.next()).getKey()); 
    if (hashSet.size() > 0)
      return Tasks.forException((Exception)new FirebaseFirestoreException("Every document read in a transaction must also be written.", FirebaseFirestoreException.Code.INVALID_ARGUMENT)); 
    this.committed = true;
    return this.datastore.commit(this.mutations).continueWithTask(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$2.lambdaFactory$());
  }
  
  public void delete(DocumentKey paramDocumentKey) {
    write((List)Collections.singletonList(new DeleteMutation(paramDocumentKey, precondition(paramDocumentKey))));
    this.writtenDocs.add(paramDocumentKey);
  }
  
  public Task<List<MaybeDocument>> lookup(List<DocumentKey> paramList) {
    ensureCommitNotCalled();
    return (this.mutations.size() != 0) ? Tasks.forException((Exception)new FirebaseFirestoreException("Firestore transactions require all reads to be executed before all writes.", FirebaseFirestoreException.Code.INVALID_ARGUMENT)) : this.datastore.lookup(paramList).continueWithTask(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$1.lambdaFactory$(this));
  }
  
  public void set(DocumentKey paramDocumentKey, UserData.ParsedSetData paramParsedSetData) {
    write(paramParsedSetData.toMutationList(paramDocumentKey, precondition(paramDocumentKey)));
    this.writtenDocs.add(paramDocumentKey);
  }
  
  public void update(DocumentKey paramDocumentKey, UserData.ParsedUpdateData paramParsedUpdateData) {
    try {
      write(paramParsedUpdateData.toMutationList(paramDocumentKey, preconditionForUpdate(paramDocumentKey)));
    } catch (FirebaseFirestoreException firebaseFirestoreException) {
      this.lastWriteError = firebaseFirestoreException;
    } 
    this.writtenDocs.add(paramDocumentKey);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\Transaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */