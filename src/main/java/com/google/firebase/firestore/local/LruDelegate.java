package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

public interface LruDelegate {
  void forEachOrphanedDocumentSequenceNumber(Consumer<Long> paramConsumer);
  
  void forEachTarget(Consumer<QueryData> paramConsumer);
  
  long getByteSize();
  
  LruGarbageCollector getGarbageCollector();
  
  long getSequenceNumberCount();
  
  int removeOrphanedDocuments(long paramLong);
  
  int removeTargets(long paramLong, SparseArray<?> paramSparseArray);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LruDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */