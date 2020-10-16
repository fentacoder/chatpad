package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;

public final class SnapshotVersion implements Comparable<SnapshotVersion> {
  public static final SnapshotVersion NONE = new SnapshotVersion(new Timestamp(0L, 0));
  
  private final Timestamp timestamp;
  
  public SnapshotVersion(Timestamp paramTimestamp) {
    this.timestamp = paramTimestamp;
  }
  
  public int compareTo(SnapshotVersion paramSnapshotVersion) {
    return this.timestamp.compareTo(paramSnapshotVersion.timestamp);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SnapshotVersion))
      return false; 
    if (compareTo((SnapshotVersion)paramObject) != 0)
      bool = false; 
    return bool;
  }
  
  public Timestamp getTimestamp() {
    return this.timestamp;
  }
  
  public int hashCode() {
    return getTimestamp().hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SnapshotVersion(seconds=");
    stringBuilder.append(this.timestamp.getSeconds());
    stringBuilder.append(", nanos=");
    stringBuilder.append(this.timestamp.getNanoseconds());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\SnapshotVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */