package com.google.firebase.firestore;

public class SnapshotMetadata {
  private final boolean hasPendingWrites;
  
  private final boolean isFromCache;
  
  SnapshotMetadata(boolean paramBoolean1, boolean paramBoolean2) {
    this.hasPendingWrites = paramBoolean1;
    this.isFromCache = paramBoolean2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof SnapshotMetadata))
      return false; 
    paramObject = paramObject;
    if (this.hasPendingWrites != ((SnapshotMetadata)paramObject).hasPendingWrites || this.isFromCache != ((SnapshotMetadata)paramObject).isFromCache)
      bool = false; 
    return bool;
  }
  
  public boolean hasPendingWrites() {
    return this.hasPendingWrites;
  }
  
  public int hashCode() {
    return this.hasPendingWrites * 31 + this.isFromCache;
  }
  
  public boolean isFromCache() {
    return this.isFromCache;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SnapshotMetadata{hasPendingWrites=");
    stringBuilder.append(this.hasPendingWrites);
    stringBuilder.append(", isFromCache=");
    stringBuilder.append(this.isFromCache);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\SnapshotMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */