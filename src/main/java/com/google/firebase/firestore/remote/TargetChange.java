package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.protobuf.ByteString;

public final class TargetChange {
  private final ImmutableSortedSet<DocumentKey> addedDocuments;
  
  private final boolean current;
  
  private final ImmutableSortedSet<DocumentKey> modifiedDocuments;
  
  private final ImmutableSortedSet<DocumentKey> removedDocuments;
  
  private final ByteString resumeToken;
  
  public TargetChange(ByteString paramByteString, boolean paramBoolean, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet1, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet2, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet3) {
    this.resumeToken = paramByteString;
    this.current = paramBoolean;
    this.addedDocuments = paramImmutableSortedSet1;
    this.modifiedDocuments = paramImmutableSortedSet2;
    this.removedDocuments = paramImmutableSortedSet3;
  }
  
  public static TargetChange createSynthesizedTargetChangeForCurrentChange(boolean paramBoolean) {
    return new TargetChange(ByteString.EMPTY, paramBoolean, DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (this.current != ((TargetChange)paramObject).current) ? false : (!this.resumeToken.equals(((TargetChange)paramObject).resumeToken) ? false : (!this.addedDocuments.equals(((TargetChange)paramObject).addedDocuments) ? false : (!this.modifiedDocuments.equals(((TargetChange)paramObject).modifiedDocuments) ? false : this.removedDocuments.equals(((TargetChange)paramObject).removedDocuments))));
  }
  
  public ImmutableSortedSet<DocumentKey> getAddedDocuments() {
    return this.addedDocuments;
  }
  
  public ImmutableSortedSet<DocumentKey> getModifiedDocuments() {
    return this.modifiedDocuments;
  }
  
  public ImmutableSortedSet<DocumentKey> getRemovedDocuments() {
    return this.removedDocuments;
  }
  
  public ByteString getResumeToken() {
    return this.resumeToken;
  }
  
  public int hashCode() {
    return (((this.resumeToken.hashCode() * 31 + this.current) * 31 + this.addedDocuments.hashCode()) * 31 + this.modifiedDocuments.hashCode()) * 31 + this.removedDocuments.hashCode();
  }
  
  public boolean isCurrent() {
    return this.current;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\TargetChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */