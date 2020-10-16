package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;

public final class LocalWriteResult {
  private final int batchId;
  
  private final ImmutableSortedMap<DocumentKey, MaybeDocument> changes;
  
  LocalWriteResult(int paramInt, ImmutableSortedMap<DocumentKey, MaybeDocument> paramImmutableSortedMap) {
    this.batchId = paramInt;
    this.changes = paramImmutableSortedMap;
  }
  
  public int getBatchId() {
    return this.batchId;
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> getChanges() {
    return this.changes;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LocalWriteResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */