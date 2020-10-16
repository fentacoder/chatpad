package com.google.firebase.firestore.local;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.protobuf.ByteString;

public final class QueryData {
  private final SnapshotVersion lastLimboFreeSnapshotVersion;
  
  private final QueryPurpose purpose;
  
  private final ByteString resumeToken;
  
  private final long sequenceNumber;
  
  private final SnapshotVersion snapshotVersion;
  
  private final Target target;
  
  private final int targetId;
  
  public QueryData(Target paramTarget, int paramInt, long paramLong, QueryPurpose paramQueryPurpose) {
    this(paramTarget, paramInt, paramLong, paramQueryPurpose, SnapshotVersion.NONE, SnapshotVersion.NONE, WatchStream.EMPTY_RESUME_TOKEN);
  }
  
  QueryData(Target paramTarget, int paramInt, long paramLong, QueryPurpose paramQueryPurpose, SnapshotVersion paramSnapshotVersion1, SnapshotVersion paramSnapshotVersion2, ByteString paramByteString) {
    this.target = (Target)Preconditions.checkNotNull(paramTarget);
    this.targetId = paramInt;
    this.sequenceNumber = paramLong;
    this.lastLimboFreeSnapshotVersion = paramSnapshotVersion2;
    this.purpose = paramQueryPurpose;
    this.snapshotVersion = (SnapshotVersion)Preconditions.checkNotNull(paramSnapshotVersion1);
    this.resumeToken = (ByteString)Preconditions.checkNotNull(paramByteString);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!this.target.equals(((QueryData)paramObject).target) || this.targetId != ((QueryData)paramObject).targetId || this.sequenceNumber != ((QueryData)paramObject).sequenceNumber || !this.purpose.equals(((QueryData)paramObject).purpose) || !this.snapshotVersion.equals(((QueryData)paramObject).snapshotVersion) || !this.lastLimboFreeSnapshotVersion.equals(((QueryData)paramObject).lastLimboFreeSnapshotVersion) || !this.resumeToken.equals(((QueryData)paramObject).resumeToken))
      bool = false; 
    return bool;
  }
  
  public SnapshotVersion getLastLimboFreeSnapshotVersion() {
    return this.lastLimboFreeSnapshotVersion;
  }
  
  public QueryPurpose getPurpose() {
    return this.purpose;
  }
  
  public ByteString getResumeToken() {
    return this.resumeToken;
  }
  
  public long getSequenceNumber() {
    return this.sequenceNumber;
  }
  
  public SnapshotVersion getSnapshotVersion() {
    return this.snapshotVersion;
  }
  
  public Target getTarget() {
    return this.target;
  }
  
  public int getTargetId() {
    return this.targetId;
  }
  
  public int hashCode() {
    return (((((this.target.hashCode() * 31 + this.targetId) * 31 + (int)this.sequenceNumber) * 31 + this.purpose.hashCode()) * 31 + this.snapshotVersion.hashCode()) * 31 + this.lastLimboFreeSnapshotVersion.hashCode()) * 31 + this.resumeToken.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("QueryData{target=");
    stringBuilder.append(this.target);
    stringBuilder.append(", targetId=");
    stringBuilder.append(this.targetId);
    stringBuilder.append(", sequenceNumber=");
    stringBuilder.append(this.sequenceNumber);
    stringBuilder.append(", purpose=");
    stringBuilder.append(this.purpose);
    stringBuilder.append(", snapshotVersion=");
    stringBuilder.append(this.snapshotVersion);
    stringBuilder.append(", lastLimboFreeSnapshotVersion=");
    stringBuilder.append(this.lastLimboFreeSnapshotVersion);
    stringBuilder.append(", resumeToken=");
    stringBuilder.append(this.resumeToken);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public QueryData withLastLimboFreeSnapshotVersion(SnapshotVersion paramSnapshotVersion) {
    return new QueryData(this.target, this.targetId, this.sequenceNumber, this.purpose, this.snapshotVersion, paramSnapshotVersion, this.resumeToken);
  }
  
  public QueryData withResumeToken(ByteString paramByteString, SnapshotVersion paramSnapshotVersion) {
    return new QueryData(this.target, this.targetId, this.sequenceNumber, this.purpose, paramSnapshotVersion, this.lastLimboFreeSnapshotVersion, paramByteString);
  }
  
  public QueryData withSequenceNumber(long paramLong) {
    return new QueryData(this.target, this.targetId, paramLong, this.purpose, this.snapshotVersion, this.lastLimboFreeSnapshotVersion, this.resumeToken);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\QueryData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */