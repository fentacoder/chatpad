package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {
  private final SQLitePersistence db;
  
  private final LocalSerializer serializer;
  
  SQLiteRemoteDocumentCache(SQLitePersistence paramSQLitePersistence, LocalSerializer paramLocalSerializer) {
    this.db = paramSQLitePersistence;
    this.serializer = paramLocalSerializer;
  }
  
  private MaybeDocument decodeMaybeDocument(byte[] paramArrayOfbyte) {
    try {
      return this.serializer.decodeMaybeDocument(MaybeDocument.parseFrom(paramArrayOfbyte));
    } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
      throw Assert.fail("MaybeDocument failed to parse: %s", new Object[] { invalidProtocolBufferException });
    } 
  }
  
  private String pathForKey(DocumentKey paramDocumentKey) {
    return EncodedPath.encode(paramDocumentKey.getPath());
  }
  
  public void add(MaybeDocument paramMaybeDocument, SnapshotVersion paramSnapshotVersion) {
    Assert.hardAssert(paramSnapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
    String str = pathForKey(paramMaybeDocument.getKey());
    Timestamp timestamp = paramSnapshotVersion.getTimestamp();
    MaybeDocument maybeDocument = this.serializer.encodeMaybeDocument(paramMaybeDocument);
    this.db.execute("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", new Object[] { str, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), maybeDocument.toByteArray() });
    this.db.getIndexManager().addToCollectionParentIndex((ResourcePath)paramMaybeDocument.getKey().getPath().popLast());
  }
  
  public MaybeDocument get(DocumentKey paramDocumentKey) {
    String str = pathForKey(paramDocumentKey);
    return this.db.query("SELECT contents FROM remote_documents WHERE path = ?").binding(new Object[] { str }).<MaybeDocument>firstValue(SQLiteRemoteDocumentCache$$Lambda$1.lambdaFactory$(this));
  }
  
  public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> paramIterable) {
    ArrayList<String> arrayList = new ArrayList();
    Iterator<DocumentKey> iterator2 = paramIterable.iterator();
    while (iterator2.hasNext())
      arrayList.add(EncodedPath.encode(((DocumentKey)iterator2.next()).getPath())); 
    HashMap<Object, Object> hashMap = new HashMap<>();
    Iterator<DocumentKey> iterator1 = paramIterable.iterator();
    while (iterator1.hasNext())
      hashMap.put(iterator1.next(), null); 
    SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT contents FROM remote_documents WHERE path IN (", (List)arrayList, ") ORDER BY path");
    while (longQuery.hasMoreSubqueries())
      longQuery.performNextSubquery().forEach(SQLiteRemoteDocumentCache$$Lambda$2.lambdaFactory$(this, hashMap)); 
    return (Map)hashMap;
  }
  
  public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion) {
    SQLitePersistence.Query query;
    Assert.hardAssert(paramQuery.isCollectionGroupQuery() ^ true, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
    ResourcePath resourcePath = paramQuery.getPath();
    int i = resourcePath.length();
    String str1 = EncodedPath.encode(resourcePath);
    String str2 = EncodedPath.prefixSuccessor(str1);
    Timestamp timestamp = paramSnapshotVersion.getTimestamp();
    BackgroundQueue backgroundQueue = new BackgroundQueue();
    ImmutableSortedMap[] arrayOfImmutableSortedMap = new ImmutableSortedMap[1];
    arrayOfImmutableSortedMap[0] = DocumentCollections.emptyDocumentMap();
    if (paramSnapshotVersion.equals(SnapshotVersion.NONE)) {
      query = this.db.query("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?").binding(new Object[] { str1, str2 });
    } else {
      query = this.db.query("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?AND (read_time_seconds > ? OR (read_time_seconds = ? AND read_time_nanos > ?))").binding(new Object[] { str1, str2, Long.valueOf(timestamp.getSeconds()), Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()) });
    } 
    query.forEach(SQLiteRemoteDocumentCache$$Lambda$3.lambdaFactory$(this, i + 1, backgroundQueue, paramQuery, arrayOfImmutableSortedMap));
    try {
      backgroundQueue.drain();
    } catch (InterruptedException interruptedException) {
      Assert.fail("Interrupted while deserializing documents", new Object[] { interruptedException });
    } 
    return arrayOfImmutableSortedMap[0];
  }
  
  public void remove(DocumentKey paramDocumentKey) {
    String str = pathForKey(paramDocumentKey);
    this.db.execute("DELETE FROM remote_documents WHERE path = ?", new Object[] { str });
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteRemoteDocumentCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */