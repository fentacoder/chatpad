package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MemoryEagerReferenceDelegate implements ReferenceDelegate {
  private ReferenceSet inMemoryPins;
  
  private Set<DocumentKey> orphanedDocuments;
  
  private final MemoryPersistence persistence;
  
  MemoryEagerReferenceDelegate(MemoryPersistence paramMemoryPersistence) {
    this.persistence = paramMemoryPersistence;
  }
  
  private boolean isReferenced(DocumentKey paramDocumentKey) {
    if (this.persistence.getQueryCache().containsKey(paramDocumentKey))
      return true; 
    if (mutationQueuesContainKey(paramDocumentKey))
      return true; 
    ReferenceSet referenceSet = this.inMemoryPins;
    return (referenceSet != null && referenceSet.containsKey(paramDocumentKey));
  }
  
  private boolean mutationQueuesContainKey(DocumentKey paramDocumentKey) {
    Iterator<MemoryMutationQueue> iterator = this.persistence.getMutationQueues().iterator();
    while (iterator.hasNext()) {
      if (((MemoryMutationQueue)iterator.next()).containsKey(paramDocumentKey))
        return true; 
    } 
    return false;
  }
  
  public void addReference(DocumentKey paramDocumentKey) {
    this.orphanedDocuments.remove(paramDocumentKey);
  }
  
  public long getCurrentSequenceNumber() {
    return -1L;
  }
  
  public void onTransactionCommitted() {
    MemoryRemoteDocumentCache memoryRemoteDocumentCache = this.persistence.getRemoteDocumentCache();
    for (DocumentKey documentKey : this.orphanedDocuments) {
      if (!isReferenced(documentKey))
        memoryRemoteDocumentCache.remove(documentKey); 
    } 
    this.orphanedDocuments = null;
  }
  
  public void onTransactionStarted() {
    this.orphanedDocuments = new HashSet<>();
  }
  
  public void removeMutationReference(DocumentKey paramDocumentKey) {
    this.orphanedDocuments.add(paramDocumentKey);
  }
  
  public void removeReference(DocumentKey paramDocumentKey) {
    this.orphanedDocuments.add(paramDocumentKey);
  }
  
  public void removeTarget(QueryData paramQueryData) {
    MemoryQueryCache memoryQueryCache = this.persistence.getQueryCache();
    for (DocumentKey documentKey : memoryQueryCache.getMatchingKeysForTargetId(paramQueryData.getTargetId()))
      this.orphanedDocuments.add(documentKey); 
    memoryQueryCache.removeQueryData(paramQueryData);
  }
  
  public void setInMemoryPins(ReferenceSet paramReferenceSet) {
    this.inMemoryPins = paramReferenceSet;
  }
  
  public void updateLimboDocument(DocumentKey paramDocumentKey) {
    if (isReferenced(paramDocumentKey)) {
      this.orphanedDocuments.remove(paramDocumentKey);
    } else {
      this.orphanedDocuments.add(paramDocumentKey);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryEagerReferenceDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */