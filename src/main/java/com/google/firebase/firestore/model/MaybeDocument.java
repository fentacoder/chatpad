package com.google.firebase.firestore.model;

public abstract class MaybeDocument {
  private final DocumentKey key;
  
  private final SnapshotVersion version;
  
  MaybeDocument(DocumentKey paramDocumentKey, SnapshotVersion paramSnapshotVersion) {
    this.key = paramDocumentKey;
    this.version = paramSnapshotVersion;
  }
  
  public DocumentKey getKey() {
    return this.key;
  }
  
  public SnapshotVersion getVersion() {
    return this.version;
  }
  
  public abstract boolean hasPendingWrites();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\MaybeDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */