package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;

final class SQLiteQueryCache implements QueryCache {
  private final SQLitePersistence db;
  
  private int highestTargetId;
  
  private long lastListenSequenceNumber;
  
  private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
  
  private final LocalSerializer localSerializer;
  
  private long targetCount;
  
  SQLiteQueryCache(SQLitePersistence paramSQLitePersistence, LocalSerializer paramLocalSerializer) {
    this.db = paramSQLitePersistence;
    this.localSerializer = paramLocalSerializer;
  }
  
  private QueryData decodeQueryData(byte[] paramArrayOfbyte) {
    try {
      return this.localSerializer.decodeQueryData(Target.parseFrom(paramArrayOfbyte));
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw Assert.fail("QueryData failed to parse: %s", new Object[] { invalidProtocolBufferException });
    } 
  }
  
  private void removeMatchingKeysForTargetId(int paramInt) {
    this.db.execute("DELETE FROM target_documents WHERE target_id = ?", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void removeTarget(int paramInt) {
    removeMatchingKeysForTargetId(paramInt);
    this.db.execute("DELETE FROM targets WHERE target_id = ?", new Object[] { Integer.valueOf(paramInt) });
    this.targetCount--;
  }
  
  private void saveQueryData(QueryData paramQueryData) {
    int i = paramQueryData.getTargetId();
    String str = paramQueryData.getTarget().getCanonicalId();
    Timestamp timestamp = paramQueryData.getSnapshotVersion().getTimestamp();
    Target target = this.localSerializer.encodeQueryData(paramQueryData);
    this.db.execute("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", new Object[] { Integer.valueOf(i), str, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), paramQueryData.getResumeToken().toByteArray(), Long.valueOf(paramQueryData.getSequenceNumber()), target.toByteArray() });
  }
  
  private boolean updateMetadata(QueryData paramQueryData) {
    boolean bool;
    if (paramQueryData.getTargetId() > this.highestTargetId) {
      this.highestTargetId = paramQueryData.getTargetId();
      bool = true;
    } else {
      bool = false;
    } 
    if (paramQueryData.getSequenceNumber() > this.lastListenSequenceNumber) {
      this.lastListenSequenceNumber = paramQueryData.getSequenceNumber();
      bool = true;
    } 
    return bool;
  }
  
  private void writeMetadata() {
    this.db.execute("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", new Object[] { Integer.valueOf(this.highestTargetId), Long.valueOf(this.lastListenSequenceNumber), Long.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getSeconds()), Integer.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getNanoseconds()), Long.valueOf(this.targetCount) });
  }
  
  public void addMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    SQLiteStatement sQLiteStatement = this.db.prepare("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
    SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate = this.db.getReferenceDelegate();
    for (DocumentKey documentKey : paramImmutableSortedSet) {
      String str = EncodedPath.encode(documentKey.getPath());
      this.db.execute(sQLiteStatement, new Object[] { Integer.valueOf(paramInt), str });
      sQLiteLruReferenceDelegate.addReference(documentKey);
    } 
  }
  
  public void addQueryData(QueryData paramQueryData) {
    saveQueryData(paramQueryData);
    updateMetadata(paramQueryData);
    this.targetCount++;
    writeMetadata();
  }
  
  public boolean containsKey(DocumentKey paramDocumentKey) {
    String str = EncodedPath.encode(paramDocumentKey.getPath());
    return this.db.query("SELECT target_id FROM target_documents WHERE path = ? AND target_id != 0 LIMIT 1").binding(new Object[] { str }).isEmpty() ^ true;
  }
  
  public void forEachTarget(Consumer<QueryData> paramConsumer) {
    this.db.query("SELECT target_proto FROM targets").forEach(SQLiteQueryCache$$Lambda$2.lambdaFactory$(this, paramConsumer));
  }
  
  public long getHighestListenSequenceNumber() {
    return this.lastListenSequenceNumber;
  }
  
  public int getHighestTargetId() {
    return this.highestTargetId;
  }
  
  public SnapshotVersion getLastRemoteSnapshotVersion() {
    return this.lastRemoteSnapshotVersion;
  }
  
  public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int paramInt) {
    DocumentKeysHolder documentKeysHolder = new DocumentKeysHolder();
    this.db.query("SELECT path FROM target_documents WHERE target_id = ?").binding(new Object[] { Integer.valueOf(paramInt) }).forEach(SQLiteQueryCache$$Lambda$5.lambdaFactory$(documentKeysHolder));
    return documentKeysHolder.keys;
  }
  
  public QueryData getQueryData(Target paramTarget) {
    String str = paramTarget.getCanonicalId();
    QueryDataHolder queryDataHolder = new QueryDataHolder();
    this.db.query("SELECT target_proto FROM targets WHERE canonical_id = ?").binding(new Object[] { str }).forEach(SQLiteQueryCache$$Lambda$4.lambdaFactory$(this, paramTarget, queryDataHolder));
    return queryDataHolder.queryData;
  }
  
  public long getTargetCount() {
    return this.targetCount;
  }
  
  public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    SQLiteStatement sQLiteStatement = this.db.prepare("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
    SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate = this.db.getReferenceDelegate();
    for (DocumentKey documentKey : paramImmutableSortedSet) {
      String str = EncodedPath.encode(documentKey.getPath());
      this.db.execute(sQLiteStatement, new Object[] { Integer.valueOf(paramInt), str });
      sQLiteLruReferenceDelegate.removeReference(documentKey);
    } 
  }
  
  int removeQueries(long paramLong, SparseArray<?> paramSparseArray) {
    int[] arrayOfInt = new int[1];
    this.db.query("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").binding(new Object[] { Long.valueOf(paramLong) }).forEach(SQLiteQueryCache$$Lambda$3.lambdaFactory$(this, paramSparseArray, arrayOfInt));
    writeMetadata();
    return arrayOfInt[0];
  }
  
  public void removeQueryData(QueryData paramQueryData) {
    removeTarget(paramQueryData.getTargetId());
    writeMetadata();
  }
  
  public void setLastRemoteSnapshotVersion(SnapshotVersion paramSnapshotVersion) {
    this.lastRemoteSnapshotVersion = paramSnapshotVersion;
    writeMetadata();
  }
  
  void start() {
    int i = this.db.query("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").first(SQLiteQueryCache$$Lambda$1.lambdaFactory$(this));
    boolean bool = true;
    if (i != 1)
      bool = false; 
    Assert.hardAssert(bool, "Missing target_globals entry", new Object[0]);
  }
  
  public void updateQueryData(QueryData paramQueryData) {
    saveQueryData(paramQueryData);
    if (updateMetadata(paramQueryData))
      writeMetadata(); 
  }
  
  private static class DocumentKeysHolder {
    ImmutableSortedSet<DocumentKey> keys = DocumentKey.emptyKeySet();
    
    private DocumentKeysHolder() {}
  }
  
  private static class QueryDataHolder {
    QueryData queryData;
    
    private QueryDataHolder() {}
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteQueryCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */