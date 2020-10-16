package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class SQLiteMutationQueue implements MutationQueue {
  private static final int BLOB_MAX_INLINE_LENGTH = 1000000;
  
  private final SQLitePersistence db;
  
  private ByteString lastStreamToken;
  
  private int nextBatchId;
  
  private final LocalSerializer serializer;
  
  private final String uid;
  
  SQLiteMutationQueue(SQLitePersistence paramSQLitePersistence, LocalSerializer paramLocalSerializer, User paramUser) {
    String str;
    this.db = paramSQLitePersistence;
    this.serializer = paramLocalSerializer;
    if (paramUser.isAuthenticated()) {
      str = paramUser.getUid();
    } else {
      str = "";
    } 
    this.uid = str;
    this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
  }
  
  private MutationBatch decodeInlineMutationBatch(int paramInt, byte[] paramArrayOfbyte) {
    try {
      if (paramArrayOfbyte.length < 1000000)
        return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(paramArrayOfbyte)); 
      BlobAccumulator blobAccumulator = new BlobAccumulator();
      this(paramArrayOfbyte);
      while (blobAccumulator.more) {
        int i = blobAccumulator.numChunks();
        this.db.query("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(new Object[] { Integer.valueOf(i * 1000000 + 1), Integer.valueOf(1000000), this.uid, Integer.valueOf(paramInt) }).first(blobAccumulator);
      } 
      ByteString byteString = blobAccumulator.result();
      return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(byteString));
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw Assert.fail("MutationBatch failed to parse: %s", new Object[] { invalidProtocolBufferException });
    } 
  }
  
  private void loadNextBatchIdAcrossAllUsers() {
    ArrayList arrayList = new ArrayList();
    this.db.query("SELECT uid FROM mutation_queues").forEach(SQLiteMutationQueue$$Lambda$2.lambdaFactory$(arrayList));
    this.nextBatchId = 0;
    for (String str : arrayList) {
      this.db.query("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").binding(new Object[] { str }).forEach(SQLiteMutationQueue$$Lambda$3.lambdaFactory$(this));
    } 
    this.nextBatchId++;
  }
  
  private void writeMutationQueueMetadata() {
    this.db.execute("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", new Object[] { this.uid, Integer.valueOf(-1), this.lastStreamToken.toByteArray() });
  }
  
  public void acknowledgeBatch(MutationBatch paramMutationBatch, ByteString paramByteString) {
    this.lastStreamToken = (ByteString)Preconditions.checkNotNull(paramByteString);
    writeMutationQueueMetadata();
  }
  
  public MutationBatch addMutationBatch(Timestamp paramTimestamp, List<Mutation> paramList1, List<Mutation> paramList2) {
    int i = this.nextBatchId;
    this.nextBatchId = i + 1;
    MutationBatch mutationBatch = new MutationBatch(i, paramTimestamp, paramList1, paramList2);
    WriteBatch writeBatch = this.serializer.encodeMutationBatch(mutationBatch);
    this.db.execute("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", new Object[] { this.uid, Integer.valueOf(i), writeBatch.toByteArray() });
    HashSet<DocumentKey> hashSet = new HashSet();
    SQLiteStatement sQLiteStatement = this.db.prepare("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
    Iterator<Mutation> iterator = paramList2.iterator();
    while (iterator.hasNext()) {
      DocumentKey documentKey = ((Mutation)iterator.next()).getKey();
      if (!hashSet.add(documentKey))
        continue; 
      String str = EncodedPath.encode(documentKey.getPath());
      this.db.execute(sQLiteStatement, new Object[] { this.uid, str, Integer.valueOf(i) });
      this.db.getIndexManager().addToCollectionParentIndex((ResourcePath)documentKey.getPath().popLast());
    } 
    return mutationBatch;
  }
  
  public List<MutationBatch> getAllMutationBatches() {
    ArrayList<MutationBatch> arrayList = new ArrayList();
    this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").binding(new Object[] { Integer.valueOf(1000000), this.uid }).forEach(SQLiteMutationQueue$$Lambda$7.lambdaFactory$(this, arrayList));
    return arrayList;
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey paramDocumentKey) {
    String str = EncodedPath.encode(paramDocumentKey.getPath());
    ArrayList<MutationBatch> arrayList = new ArrayList();
    this.db.query("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(new Object[] { Integer.valueOf(1000000), this.uid, str }).forEach(SQLiteMutationQueue$$Lambda$8.lambdaFactory$(this, arrayList));
    return arrayList;
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> paramIterable) {
    ArrayList<String> arrayList = new ArrayList();
    Iterator<DocumentKey> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(EncodedPath.encode(((DocumentKey)iterator.next()).getPath())); 
    SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(new Object[] { Integer.valueOf(1000000), this.uid }, ), (List)arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
    ArrayList<?> arrayList1 = new ArrayList();
    HashSet hashSet = new HashSet();
    while (longQuery.hasMoreSubqueries())
      longQuery.performNextSubquery().forEach(SQLiteMutationQueue$$Lambda$9.lambdaFactory$(this, hashSet, arrayList1)); 
    if (longQuery.getSubqueriesPerformed() > 1)
      Collections.sort(arrayList1, SQLiteMutationQueue$$Lambda$10.lambdaFactory$()); 
    return (List)arrayList1;
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query paramQuery) {
    Assert.hardAssert(paramQuery.isCollectionGroupQuery() ^ true, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
    ResourcePath resourcePath = paramQuery.getPath();
    int i = resourcePath.length();
    String str2 = EncodedPath.encode(resourcePath);
    String str1 = EncodedPath.prefixSuccessor(str2);
    ArrayList<MutationBatch> arrayList = new ArrayList();
    this.db.query("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(new Object[] { Integer.valueOf(1000000), this.uid, str2, str1 }).forEach(SQLiteMutationQueue$$Lambda$11.lambdaFactory$(this, arrayList, i + 1));
    return arrayList;
  }
  
  public int getHighestUnacknowledgedBatchId() {
    return ((Integer)this.db.query("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").binding(new Object[] { Integer.valueOf(-1), this.uid }).<Integer>firstValue(SQLiteMutationQueue$$Lambda$6.lambdaFactory$())).intValue();
  }
  
  public ByteString getLastStreamToken() {
    return this.lastStreamToken;
  }
  
  public MutationBatch getNextMutationBatchAfterBatchId(int paramInt) {
    return this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").binding(new Object[] { Integer.valueOf(1000000), this.uid, Integer.valueOf(paramInt + 1) }).<MutationBatch>firstValue(SQLiteMutationQueue$$Lambda$5.lambdaFactory$(this));
  }
  
  public boolean isEmpty() {
    return this.db.query("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").binding(new Object[] { this.uid }).isEmpty();
  }
  
  public MutationBatch lookupMutationBatch(int paramInt) {
    return this.db.query("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(new Object[] { Integer.valueOf(1000000), this.uid, Integer.valueOf(paramInt) }).<MutationBatch>firstValue(SQLiteMutationQueue$$Lambda$4.lambdaFactory$(this, paramInt));
  }
  
  public void performConsistencyCheck() {
    if (!isEmpty())
      return; 
    ArrayList arrayList = new ArrayList();
    this.db.query("SELECT path FROM document_mutations WHERE uid = ?").binding(new Object[] { this.uid }).forEach(SQLiteMutationQueue$$Lambda$12.lambdaFactory$(arrayList));
    Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", new Object[] { arrayList });
  }
  
  public void removeMutationBatch(MutationBatch paramMutationBatch) {
    boolean bool;
    SQLiteStatement sQLiteStatement1 = this.db.prepare("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
    SQLiteStatement sQLiteStatement2 = this.db.prepare("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
    int i = paramMutationBatch.getBatchId();
    if (this.db.execute(sQLiteStatement1, new Object[] { this.uid, Integer.valueOf(i) }) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Mutation batch (%s, %d) did not exist", new Object[] { this.uid, Integer.valueOf(paramMutationBatch.getBatchId()) });
    Iterator<Mutation> iterator = paramMutationBatch.getMutations().iterator();
    while (iterator.hasNext()) {
      DocumentKey documentKey = ((Mutation)iterator.next()).getKey();
      String str = EncodedPath.encode(documentKey.getPath());
      this.db.execute(sQLiteStatement2, new Object[] { this.uid, str, Integer.valueOf(i) });
      this.db.getReferenceDelegate().removeMutationReference(documentKey);
    } 
  }
  
  public void setLastStreamToken(ByteString paramByteString) {
    this.lastStreamToken = (ByteString)Preconditions.checkNotNull(paramByteString);
    writeMutationQueueMetadata();
  }
  
  public void start() {
    loadNextBatchIdAcrossAllUsers();
    if (this.db.query("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").binding(new Object[] { this.uid }).first(SQLiteMutationQueue$$Lambda$1.lambdaFactory$(this)) == 0)
      writeMutationQueueMetadata(); 
  }
  
  private static class BlobAccumulator implements Consumer<Cursor> {
    private final ArrayList<ByteString> chunks = new ArrayList<>();
    
    private boolean more = true;
    
    BlobAccumulator(byte[] param1ArrayOfbyte) {
      addChunk(param1ArrayOfbyte);
    }
    
    private void addChunk(byte[] param1ArrayOfbyte) {
      ByteString byteString = ByteString.copyFrom(param1ArrayOfbyte);
      this.chunks.add(byteString);
    }
    
    public void accept(Cursor param1Cursor) {
      byte[] arrayOfByte = param1Cursor.getBlob(0);
      addChunk(arrayOfByte);
      if (arrayOfByte.length < 1000000)
        this.more = false; 
    }
    
    int numChunks() {
      return this.chunks.size();
    }
    
    ByteString result() {
      return ByteString.copyFrom(this.chunks);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteMutationQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */