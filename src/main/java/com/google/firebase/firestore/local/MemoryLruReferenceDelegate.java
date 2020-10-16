package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MemoryLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
  private long currentSequenceNumber;
  
  private final LruGarbageCollector garbageCollector;
  
  private ReferenceSet inMemoryPins;
  
  private final ListenSequence listenSequence;
  
  private final Map<DocumentKey, Long> orphanedSequenceNumbers;
  
  private final MemoryPersistence persistence;
  
  private final LocalSerializer serializer;
  
  MemoryLruReferenceDelegate(MemoryPersistence paramMemoryPersistence, LruGarbageCollector.Params paramParams, LocalSerializer paramLocalSerializer) {
    this.persistence = paramMemoryPersistence;
    this.serializer = paramLocalSerializer;
    this.orphanedSequenceNumbers = new HashMap<>();
    this.listenSequence = new ListenSequence(paramMemoryPersistence.getQueryCache().getHighestListenSequenceNumber());
    this.currentSequenceNumber = -1L;
    this.garbageCollector = new LruGarbageCollector(this, paramParams);
  }
  
  private boolean isPinned(DocumentKey paramDocumentKey, long paramLong) {
    boolean bool = mutationQueuesContainsKey(paramDocumentKey);
    boolean bool1 = true;
    if (bool)
      return true; 
    if (this.inMemoryPins.containsKey(paramDocumentKey))
      return true; 
    if (this.persistence.getQueryCache().containsKey(paramDocumentKey))
      return true; 
    Long long_ = this.orphanedSequenceNumbers.get(paramDocumentKey);
    if (long_ == null || long_.longValue() <= paramLong)
      bool1 = false; 
    return bool1;
  }
  
  private boolean mutationQueuesContainsKey(DocumentKey paramDocumentKey) {
    Iterator<MemoryMutationQueue> iterator = this.persistence.getMutationQueues().iterator();
    while (iterator.hasNext()) {
      if (((MemoryMutationQueue)iterator.next()).containsKey(paramDocumentKey))
        return true; 
    } 
    return false;
  }
  
  public void addReference(DocumentKey paramDocumentKey) {
    this.orphanedSequenceNumbers.put(paramDocumentKey, Long.valueOf(getCurrentSequenceNumber()));
  }
  
  public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> paramConsumer) {
    for (Map.Entry<DocumentKey, Long> entry : this.orphanedSequenceNumbers.entrySet()) {
      if (!isPinned((DocumentKey)entry.getKey(), ((Long)entry.getValue()).longValue()))
        paramConsumer.accept(entry.getValue()); 
    } 
  }
  
  public void forEachTarget(Consumer<QueryData> paramConsumer) {
    this.persistence.getQueryCache().forEachTarget(paramConsumer);
  }
  
  public long getByteSize() {
    long l = this.persistence.getQueryCache().getByteSize(this.serializer) + 0L + this.persistence.getRemoteDocumentCache().getByteSize(this.serializer);
    Iterator<MemoryMutationQueue> iterator = this.persistence.getMutationQueues().iterator();
    while (iterator.hasNext())
      l += ((MemoryMutationQueue)iterator.next()).getByteSize(this.serializer); 
    return l;
  }
  
  public long getCurrentSequenceNumber() {
    boolean bool;
    if (this.currentSequenceNumber != -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Attempting to get a sequence number outside of a transaction", new Object[0]);
    return this.currentSequenceNumber;
  }
  
  public LruGarbageCollector getGarbageCollector() {
    return this.garbageCollector;
  }
  
  public long getSequenceNumberCount() {
    long l = this.persistence.getQueryCache().getTargetCount();
    long[] arrayOfLong = new long[1];
    forEachOrphanedDocumentSequenceNumber(MemoryLruReferenceDelegate$$Lambda$1.lambdaFactory$(arrayOfLong));
    return l + arrayOfLong[0];
  }
  
  public void onTransactionCommitted() {
    boolean bool;
    if (this.currentSequenceNumber != -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Committing a transaction without having started one", new Object[0]);
    this.currentSequenceNumber = -1L;
  }
  
  public void onTransactionStarted() {
    boolean bool;
    if (this.currentSequenceNumber == -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Starting a transaction without committing the previous one", new Object[0]);
    this.currentSequenceNumber = this.listenSequence.next();
  }
  
  public void removeMutationReference(DocumentKey paramDocumentKey) {
    this.orphanedSequenceNumbers.put(paramDocumentKey, Long.valueOf(getCurrentSequenceNumber()));
  }
  
  public int removeOrphanedDocuments(long paramLong) {
    MemoryRemoteDocumentCache memoryRemoteDocumentCache = this.persistence.getRemoteDocumentCache();
    Iterator<MaybeDocument> iterator = memoryRemoteDocumentCache.getDocuments().iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      DocumentKey documentKey = ((MaybeDocument)iterator.next()).getKey();
      if (!isPinned(documentKey, paramLong)) {
        memoryRemoteDocumentCache.remove(documentKey);
        this.orphanedSequenceNumbers.remove(documentKey);
        b++;
      } 
    } 
    return b;
  }
  
  public void removeReference(DocumentKey paramDocumentKey) {
    this.orphanedSequenceNumbers.put(paramDocumentKey, Long.valueOf(getCurrentSequenceNumber()));
  }
  
  public void removeTarget(QueryData paramQueryData) {
    paramQueryData = paramQueryData.withSequenceNumber(getCurrentSequenceNumber());
    this.persistence.getQueryCache().updateQueryData(paramQueryData);
  }
  
  public int removeTargets(long paramLong, SparseArray<?> paramSparseArray) {
    return this.persistence.getQueryCache().removeQueries(paramLong, paramSparseArray);
  }
  
  public void setInMemoryPins(ReferenceSet paramReferenceSet) {
    this.inMemoryPins = paramReferenceSet;
  }
  
  public void updateLimboDocument(DocumentKey paramDocumentKey) {
    this.orphanedSequenceNumbers.put(paramDocumentKey, Long.valueOf(getCurrentSequenceNumber()));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryLruReferenceDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */