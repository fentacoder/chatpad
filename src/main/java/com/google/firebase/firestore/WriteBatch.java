package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Map;

public class WriteBatch {
  private boolean committed = false;
  
  private final FirebaseFirestore firestore;
  
  private final ArrayList<Mutation> mutations = new ArrayList<>();
  
  WriteBatch(FirebaseFirestore paramFirebaseFirestore) {
    this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(paramFirebaseFirestore);
  }
  
  private WriteBatch update(DocumentReference paramDocumentReference, UserData.ParsedUpdateData paramParsedUpdateData) {
    this.firestore.validateReference(paramDocumentReference);
    verifyNotCommitted();
    this.mutations.addAll(paramParsedUpdateData.toMutationList(paramDocumentReference.getKey(), Precondition.exists(true)));
    return this;
  }
  
  private void verifyNotCommitted() {
    if (!this.committed)
      return; 
    throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
  }
  
  public Task<Void> commit() {
    verifyNotCommitted();
    this.committed = true;
    return (this.mutations.size() > 0) ? this.firestore.getClient().write(this.mutations) : Tasks.forResult(null);
  }
  
  public WriteBatch delete(DocumentReference paramDocumentReference) {
    this.firestore.validateReference(paramDocumentReference);
    verifyNotCommitted();
    this.mutations.add(new DeleteMutation(paramDocumentReference.getKey(), Precondition.NONE));
    return this;
  }
  
  public WriteBatch set(DocumentReference paramDocumentReference, Object paramObject) {
    return set(paramDocumentReference, paramObject, SetOptions.OVERWRITE);
  }
  
  public WriteBatch set(DocumentReference paramDocumentReference, Object paramObject, SetOptions paramSetOptions) {
    this.firestore.validateReference(paramDocumentReference);
    Preconditions.checkNotNull(paramObject, "Provided data must not be null.");
    Preconditions.checkNotNull(paramSetOptions, "Provided options must not be null.");
    verifyNotCommitted();
    if (paramSetOptions.isMerge()) {
      paramObject = this.firestore.getDataConverter().parseMergeData(paramObject, paramSetOptions.getFieldMask());
    } else {
      paramObject = this.firestore.getDataConverter().parseSetData(paramObject);
    } 
    this.mutations.addAll(paramObject.toMutationList(paramDocumentReference.getKey(), Precondition.NONE));
    return this;
  }
  
  public WriteBatch update(DocumentReference paramDocumentReference, FieldPath paramFieldPath, Object paramObject, Object... paramVarArgs) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramFieldPath, paramObject, paramVarArgs)));
  }
  
  public WriteBatch update(DocumentReference paramDocumentReference, String paramString, Object paramObject, Object... paramVarArgs) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(Util.collectUpdateArguments(1, paramString, paramObject, paramVarArgs)));
  }
  
  public WriteBatch update(DocumentReference paramDocumentReference, Map<String, Object> paramMap) {
    return update(paramDocumentReference, this.firestore.getDataConverter().parseUpdateData(paramMap));
  }
  
  public static interface Function {
    void apply(WriteBatch param1WriteBatch);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\WriteBatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */