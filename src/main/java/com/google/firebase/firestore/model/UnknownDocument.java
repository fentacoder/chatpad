package com.google.firebase.firestore.model;

public final class UnknownDocument extends MaybeDocument {
  public UnknownDocument(DocumentKey paramDocumentKey, SnapshotVersion paramSnapshotVersion) {
    super(paramDocumentKey, paramSnapshotVersion);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!getVersion().equals(paramObject.getVersion()) || !getKey().equals(paramObject.getKey()))
      bool = false; 
    return bool;
  }
  
  public boolean hasPendingWrites() {
    return true;
  }
  
  public int hashCode() {
    return getKey().hashCode() * 31 + getVersion().hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UnknownDocument{key=");
    stringBuilder.append(getKey());
    stringBuilder.append(", version=");
    stringBuilder.append(getVersion());
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\UnknownDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */