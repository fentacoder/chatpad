package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

public final class PatchMutation extends Mutation {
  private final FieldMask mask;
  
  private final ObjectValue value;
  
  public PatchMutation(DocumentKey paramDocumentKey, ObjectValue paramObjectValue, FieldMask paramFieldMask, Precondition paramPrecondition) {
    super(paramDocumentKey, paramPrecondition);
    this.value = paramObjectValue;
    this.mask = paramFieldMask;
  }
  
  private ObjectValue patchDocument(MaybeDocument paramMaybeDocument) {
    ObjectValue objectValue;
    if (paramMaybeDocument instanceof Document) {
      objectValue = ((Document)paramMaybeDocument).getData();
    } else {
      objectValue = ObjectValue.emptyObject();
    } 
    return patchObject(objectValue);
  }
  
  private ObjectValue patchObject(ObjectValue paramObjectValue) {
    for (FieldPath fieldPath : this.mask.getMask()) {
      if (!fieldPath.isEmpty()) {
        FieldValue fieldValue = this.value.get(fieldPath);
        if (fieldValue == null) {
          paramObjectValue = paramObjectValue.delete(fieldPath);
          continue;
        } 
        paramObjectValue = paramObjectValue.set(fieldPath, fieldValue);
      } 
    } 
    return paramObjectValue;
  }
  
  public MaybeDocument applyToLocalView(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2, Timestamp paramTimestamp) {
    verifyKeyMatches(paramMaybeDocument1);
    if (!getPrecondition().isValidFor(paramMaybeDocument1))
      return paramMaybeDocument1; 
    SnapshotVersion snapshotVersion = getPostMutationVersion(paramMaybeDocument1);
    ObjectValue objectValue = patchDocument(paramMaybeDocument1);
    return (MaybeDocument)new Document(getKey(), snapshotVersion, Document.DocumentState.LOCAL_MUTATIONS, objectValue);
  }
  
  public MaybeDocument applyToRemoteDocument(MaybeDocument paramMaybeDocument, MutationResult paramMutationResult) {
    boolean bool;
    verifyKeyMatches(paramMaybeDocument);
    if (paramMutationResult.getTransformResults() == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Transform results received by PatchMutation.", new Object[0]);
    if (!getPrecondition().isValidFor(paramMaybeDocument))
      return (MaybeDocument)new UnknownDocument(getKey(), paramMutationResult.getVersion()); 
    SnapshotVersion snapshotVersion = paramMutationResult.getVersion();
    ObjectValue objectValue = patchDocument(paramMaybeDocument);
    return (MaybeDocument)new Document(getKey(), snapshotVersion, Document.DocumentState.COMMITTED_MUTATIONS, objectValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!hasSameKeyAndPrecondition((Mutation)paramObject) || !this.value.equals(((PatchMutation)paramObject).value))
      bool = false; 
    return bool;
  }
  
  public ObjectValue extractBaseValue(MaybeDocument paramMaybeDocument) {
    return null;
  }
  
  public FieldMask getMask() {
    return this.mask;
  }
  
  public ObjectValue getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return keyAndPreconditionHashCode() * 31 + this.value.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PatchMutation{");
    stringBuilder.append(keyAndPreconditionToString());
    stringBuilder.append(", mask=");
    stringBuilder.append(this.mask);
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\PatchMutation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */