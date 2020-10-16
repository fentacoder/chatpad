package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

public final class DeleteMutation extends Mutation {
  public DeleteMutation(DocumentKey paramDocumentKey, Precondition paramPrecondition) {
    super(paramDocumentKey, paramPrecondition);
  }
  
  public MaybeDocument applyToLocalView(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2, Timestamp paramTimestamp) {
    verifyKeyMatches(paramMaybeDocument1);
    return (MaybeDocument)(!getPrecondition().isValidFor(paramMaybeDocument1) ? paramMaybeDocument1 : new NoDocument(getKey(), SnapshotVersion.NONE, false));
  }
  
  public MaybeDocument applyToRemoteDocument(MaybeDocument paramMaybeDocument, MutationResult paramMutationResult) {
    boolean bool;
    verifyKeyMatches(paramMaybeDocument);
    if (paramMutationResult.getTransformResults() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Transform results received by DeleteMutation.", new Object[0]);
    return (MaybeDocument)new NoDocument(getKey(), paramMutationResult.getVersion(), true);
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject) ? true : ((paramObject == null || getClass() != paramObject.getClass()) ? false : hasSameKeyAndPrecondition((DeleteMutation)paramObject));
  }
  
  public ObjectValue extractBaseValue(MaybeDocument paramMaybeDocument) {
    return null;
  }
  
  public int hashCode() {
    return keyAndPreconditionHashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DeleteMutation{");
    stringBuilder.append(keyAndPreconditionToString());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\DeleteMutation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */