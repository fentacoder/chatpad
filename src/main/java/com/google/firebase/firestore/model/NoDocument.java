package com.google.firebase.firestore.model;

public final class NoDocument extends MaybeDocument {
  private boolean hasCommittedMutations;
  
  public NoDocument(DocumentKey paramDocumentKey, SnapshotVersion paramSnapshotVersion, boolean paramBoolean) {
    super(paramDocumentKey, paramSnapshotVersion);
    this.hasCommittedMutations = paramBoolean;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.hasCommittedMutations != ((NoDocument)paramObject).hasCommittedMutations || !getVersion().equals(paramObject.getVersion()) || !getKey().equals(paramObject.getKey()))
      bool = false; 
    return bool;
  }
  
  public boolean hasCommittedMutations() {
    return this.hasCommittedMutations;
  }
  
  public boolean hasPendingWrites() {
    return hasCommittedMutations();
  }
  
  public int hashCode() {
    return (getKey().hashCode() * 31 + this.hasCommittedMutations) * 31 + getVersion().hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NoDocument{key=");
    stringBuilder.append(getKey());
    stringBuilder.append(", version=");
    stringBuilder.append(getVersion());
    stringBuilder.append(", hasCommittedMutations=");
    stringBuilder.append(hasCommittedMutations());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\NoDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */