package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

public final class SetMutation extends Mutation {
  private final ObjectValue value;
  
  public SetMutation(DocumentKey paramDocumentKey, ObjectValue paramObjectValue, Precondition paramPrecondition) {
    super(paramDocumentKey, paramPrecondition);
    this.value = paramObjectValue;
  }
  
  public MaybeDocument applyToLocalView(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2, Timestamp paramTimestamp) {
    verifyKeyMatches(paramMaybeDocument1);
    if (!getPrecondition().isValidFor(paramMaybeDocument1))
      return paramMaybeDocument1; 
    SnapshotVersion snapshotVersion = getPostMutationVersion(paramMaybeDocument1);
    return (MaybeDocument)new Document(getKey(), snapshotVersion, Document.DocumentState.LOCAL_MUTATIONS, this.value);
  }
  
  public MaybeDocument applyToRemoteDocument(MaybeDocument paramMaybeDocument, MutationResult paramMutationResult) {
    boolean bool;
    verifyKeyMatches(paramMaybeDocument);
    if (paramMutationResult.getTransformResults() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Transform results received by SetMutation.", new Object[0]);
    SnapshotVersion snapshotVersion = paramMutationResult.getVersion();
    return (MaybeDocument)new Document(getKey(), snapshotVersion, Document.DocumentState.COMMITTED_MUTATIONS, this.value);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!hasSameKeyAndPrecondition((Mutation)paramObject) || !this.value.equals(((SetMutation)paramObject).value))
      bool = false; 
    return bool;
  }
  
  public ObjectValue extractBaseValue(MaybeDocument paramMaybeDocument) {
    return null;
  }
  
  public ObjectValue getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return keyAndPreconditionHashCode() * 31 + this.value.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SetMutation{");
    stringBuilder.append(keyAndPreconditionToString());
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\SetMutation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */