package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;

class SQLiteLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
  static final int REMOVE_ORPHANED_DOCUMENTS_BATCH_SIZE = 100;
  
  private long currentSequenceNumber = -1L;
  
  private final LruGarbageCollector garbageCollector;
  
  private ReferenceSet inMemoryPins;
  
  private ListenSequence listenSequence;
  
  private final SQLitePersistence persistence;
  
  SQLiteLruReferenceDelegate(SQLitePersistence paramSQLitePersistence, LruGarbageCollector.Params paramParams) {
    this.persistence = paramSQLitePersistence;
    this.garbageCollector = new LruGarbageCollector(this, paramParams);
  }
  
  private boolean isPinned(DocumentKey paramDocumentKey) {
    return this.inMemoryPins.containsKey(paramDocumentKey) ? true : mutationQueuesContainKey(paramDocumentKey);
  }
  
  private boolean mutationQueuesContainKey(DocumentKey paramDocumentKey) {
    return this.persistence.query("SELECT 1 FROM document_mutations WHERE path = ?").binding(new Object[] { EncodedPath.encode(paramDocumentKey.getPath()) }).isEmpty() ^ true;
  }
  
  private void removeSentinel(DocumentKey paramDocumentKey) {
    this.persistence.execute("DELETE FROM target_documents WHERE path = ? AND target_id = 0", new Object[] { EncodedPath.encode(paramDocumentKey.getPath()) });
  }
  
  private void writeSentinel(DocumentKey paramDocumentKey) {
    String str = EncodedPath.encode(paramDocumentKey.getPath());
    this.persistence.execute("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", new Object[] { str, Long.valueOf(getCurrentSequenceNumber()) });
  }
  
  public void addReference(DocumentKey paramDocumentKey) {
    writeSentinel(paramDocumentKey);
  }
  
  public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> paramConsumer) {
    this.persistence.query("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").forEach(SQLiteLruReferenceDelegate$$Lambda$2.lambdaFactory$(paramConsumer));
  }
  
  public void forEachTarget(Consumer<QueryData> paramConsumer) {
    this.persistence.getQueryCache().forEachTarget(paramConsumer);
  }
  
  public long getByteSize() {
    return this.persistence.getByteSize();
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
    return this.persistence.getQueryCache().getTargetCount() + ((Long)this.persistence.query("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)").<Long>firstValue(SQLiteLruReferenceDelegate$$Lambda$1.lambdaFactory$())).longValue();
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
    writeSentinel(paramDocumentKey);
  }
  
  public int removeOrphanedDocuments(long paramLong) {
    int[] arrayOfInt = new int[1];
    label12: while (true) {
      boolean bool;
      for (bool = true; bool; bool = false) {
        if (this.persistence.query("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").binding(new Object[] { Long.valueOf(paramLong), Integer.valueOf(100) }).forEach(SQLiteLruReferenceDelegate$$Lambda$3.lambdaFactory$(this, arrayOfInt)) == 100)
          continue label12; 
      } 
      return arrayOfInt[0];
    } 
  }
  
  public void removeReference(DocumentKey paramDocumentKey) {
    writeSentinel(paramDocumentKey);
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
  
  void start(long paramLong) {
    this.listenSequence = new ListenSequence(paramLong);
  }
  
  public void updateLimboDocument(DocumentKey paramDocumentKey) {
    writeSentinel(paramDocumentKey);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteLruReferenceDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */