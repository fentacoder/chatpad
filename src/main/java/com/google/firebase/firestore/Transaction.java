package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Transaction {
  private final FirebaseFirestore firestore;
  
  private final Transaction transaction;
  
  Transaction(Transaction paramTransaction, FirebaseFirestore paramFirebaseFirestore) {
    this.transaction = (Transaction)Preconditions.checkNotNull(paramTransaction);
    this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(paramFirebaseFirestore);
  }
  
  private Task<DocumentSnapshot> getAsync(DocumentReference paramDocumentReference) {
    return this.transaction.lookup(Collections.singletonList(paramDocumentReference.getKey())).continueWith(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$1.lambdaFactory$(this));
  }
  
  private Transaction update(DocumentReference paramDocumentReference, UserData.ParsedUpdateData paramParsedUpdateData) {
    this.firestore.validateReference(paramDocumentReference);
    this.transaction.update(paramDocumentReference.getKey(), paramParsedUpdateData);
    return this;
  }
  
  public Transaction delete(DocumentReference paramDocumentReference) {
    this.firestore.validateReference(paramDocumentReference);
    this.transaction.delete(paramDocumentReference.getKey());
    return this;
  }
  
  public DocumentSnapshot get(DocumentReference paramDocumentReference) throws FirebaseFirestoreException {
    this.firestore.validateReference(paramDocumentReference);
    try {
      return (DocumentSnapshot)Tasks.await(getAsync(paramDocumentReference));
    } catch (ExecutionException executionException) {
      if (executionException.getCause() instanceof FirebaseFirestoreException)
        throw (FirebaseFirestoreException)executionException.getCause(); 
      throw new RuntimeException(executionException.getCause());
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException(interruptedException);
    } 
  }
  
  public Transaction set(DocumentReference paramDocumentReference, Object paramObject) {
    return set(paramDocumentReference, paramObject, SetOptions.OVERWRITE);
  }
  
  public Transaction set(DocumentReference paramDocumentReference, Object paramObject, SetOptions paramSetOptions) {
    this.firestore.validateReference(paramDocumentReference);
    Preconditions.checkNotNull(paramObject, "Provided data must not be null.");
    Preconditions.checkNotNull(paramSetOptions, "Provided options must not be null.");
    if (paramSetOptions.isMerge()) {
      paramObject = this.firestore.getDataConverter().parseMergeData(paramObject, paramSetOptions.getFieldMask());
    } else {
      paramObject = this.firestore.getDataConverter().parseSetData(paramObject);
    } 
    this.transaction.set(paramDocumentReference.getKey(), (UserData.ParsedSetData)paramObject);
    return this;
  }
  
  public Transaction update(DocumentReference paramDocumentReference, FieldPath paramFieldPath, Object paramObject, Object... paramVarArgs) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramFieldPath, paramObject, paramVarArgs)));
  }
  
  public Transaction update(DocumentReference paramDocumentReference, String paramString, Object paramObject, Object... paramVarArgs) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramString, paramObject, paramVarArgs)));
  }
  
  public Transaction update(DocumentReference paramDocumentReference, Map<String, Object> paramMap) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(paramMap));
  }
  
  public static interface Function<TResult> {
    TResult apply(Transaction param1Transaction) throws FirebaseFirestoreException;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\Transaction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */