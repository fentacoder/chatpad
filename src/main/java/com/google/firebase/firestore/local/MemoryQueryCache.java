package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class MemoryQueryCache implements QueryCache {
  private long highestSequenceNumber = 0L;
  
  private int highestTargetId;
  
  private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
  
  private final MemoryPersistence persistence;
  
  private final ReferenceSet references = new ReferenceSet();
  
  private final Map<Target, QueryData> targets = new HashMap<>();
  
  MemoryQueryCache(MemoryPersistence paramMemoryPersistence) {
    this.persistence = paramMemoryPersistence;
  }
  
  private void removeMatchingKeysForTargetId(int paramInt) {
    this.references.removeReferencesForId(paramInt);
  }
  
  public void addMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    this.references.addReferences(paramImmutableSortedSet, paramInt);
    ReferenceDelegate referenceDelegate = this.persistence.getReferenceDelegate();
    Iterator<DocumentKey> iterator = paramImmutableSortedSet.iterator();
    while (iterator.hasNext())
      referenceDelegate.addReference(iterator.next()); 
  }
  
  public void addQueryData(QueryData paramQueryData) {
    this.targets.put(paramQueryData.getTarget(), paramQueryData);
    int i = paramQueryData.getTargetId();
    if (i > this.highestTargetId)
      this.highestTargetId = i; 
    if (paramQueryData.getSequenceNumber() > this.highestSequenceNumber)
      this.highestSequenceNumber = paramQueryData.getSequenceNumber(); 
  }
  
  public boolean containsKey(DocumentKey paramDocumentKey) {
    return this.references.containsKey(paramDocumentKey);
  }
  
  public void forEachTarget(Consumer<QueryData> paramConsumer) {
    Iterator<QueryData> iterator = this.targets.values().iterator();
    while (iterator.hasNext())
      paramConsumer.accept(iterator.next()); 
  }
  
  long getByteSize(LocalSerializer paramLocalSerializer) {
    Iterator<Map.Entry> iterator = this.targets.entrySet().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += paramLocalSerializer.encodeQueryData((QueryData)((Map.Entry)iterator.next()).getValue()).getSerializedSize());
    return l;
  }
  
  public long getHighestListenSequenceNumber() {
    return this.highestSequenceNumber;
  }
  
  public int getHighestTargetId() {
    return this.highestTargetId;
  }
  
  public SnapshotVersion getLastRemoteSnapshotVersion() {
    return this.lastRemoteSnapshotVersion;
  }
  
  public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int paramInt) {
    return this.references.referencesForId(paramInt);
  }
  
  public QueryData getQueryData(Target paramTarget) {
    return this.targets.get(paramTarget);
  }
  
  public long getTargetCount() {
    return this.targets.size();
  }
  
  public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    this.references.removeReferences(paramImmutableSortedSet, paramInt);
    ReferenceDelegate referenceDelegate = this.persistence.getReferenceDelegate();
    Iterator<DocumentKey> iterator = paramImmutableSortedSet.iterator();
    while (iterator.hasNext())
      referenceDelegate.removeReference(iterator.next()); 
  }
  
  int removeQueries(long paramLong, SparseArray<?> paramSparseArray) {
    Iterator<Map.Entry> iterator = this.targets.entrySet().iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      int i = ((QueryData)entry.getValue()).getTargetId();
      if (((QueryData)entry.getValue()).getSequenceNumber() <= paramLong && paramSparseArray.get(i) == null) {
        iterator.remove();
        removeMatchingKeysForTargetId(i);
        b++;
      } 
    } 
    return b;
  }
  
  public void removeQueryData(QueryData paramQueryData) {
    this.targets.remove(paramQueryData.getTarget());
    this.references.removeReferencesForId(paramQueryData.getTargetId());
  }
  
  public void setLastRemoteSnapshotVersion(SnapshotVersion paramSnapshotVersion) {
    this.lastRemoteSnapshotVersion = paramSnapshotVersion;
  }
  
  public void updateQueryData(QueryData paramQueryData) {
    addQueryData(paramQueryData);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryQueryCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */