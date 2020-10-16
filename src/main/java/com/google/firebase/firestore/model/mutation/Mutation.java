package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

public abstract class Mutation {
  private final DocumentKey key;
  
  private final Precondition precondition;
  
  Mutation(DocumentKey paramDocumentKey, Precondition paramPrecondition) {
    this.key = paramDocumentKey;
    this.precondition = paramPrecondition;
  }
  
  static SnapshotVersion getPostMutationVersion(MaybeDocument paramMaybeDocument) {
    return (paramMaybeDocument instanceof com.google.firebase.firestore.model.Document) ? paramMaybeDocument.getVersion() : SnapshotVersion.NONE;
  }
  
  public abstract MaybeDocument applyToLocalView(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2, Timestamp paramTimestamp);
  
  public abstract MaybeDocument applyToRemoteDocument(MaybeDocument paramMaybeDocument, MutationResult paramMutationResult);
  
  public abstract ObjectValue extractBaseValue(MaybeDocument paramMaybeDocument);
  
  public DocumentKey getKey() {
    return this.key;
  }
  
  public Precondition getPrecondition() {
    return this.precondition;
  }
  
  boolean hasSameKeyAndPrecondition(Mutation paramMutation) {
    boolean bool;
    if (this.key.equals(paramMutation.key) && this.precondition.equals(paramMutation.precondition)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  int keyAndPreconditionHashCode() {
    return getKey().hashCode() * 31 + this.precondition.hashCode();
  }
  
  String keyAndPreconditionToString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("key=");
    stringBuilder.append(this.key);
    stringBuilder.append(", precondition=");
    stringBuilder.append(this.precondition);
    return stringBuilder.toString();
  }
  
  void verifyKeyMatches(MaybeDocument paramMaybeDocument) {
    if (paramMaybeDocument != null)
      Assert.hardAssert(paramMaybeDocument.getKey().equals(getKey()), "Can only apply a mutation to a document with the same key", new Object[0]); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\Mutation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */