package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;

class SQLiteSchema {
  static final int INDEXING_SUPPORT_VERSION = 11;
  
  private static final int SEQUENCE_NUMBER_BATCH_SIZE = 100;
  
  static final int VERSION = 10;
  
  private final SQLiteDatabase db;
  
  SQLiteSchema(SQLiteDatabase paramSQLiteDatabase) {
    this.db = paramSQLiteDatabase;
  }
  
  private void addReadTime() {
    this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
    this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
  }
  
  private void addSequenceNumber() {
    if (!tableContainsColumn("target_documents", "sequence_number"))
      this.db.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER"); 
  }
  
  private void addTargetCount() {
    if (!tableContainsColumn("target_globals", "target_count"))
      this.db.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER"); 
    long l = DatabaseUtils.queryNumEntries(this.db, "targets");
    ContentValues contentValues = new ContentValues();
    contentValues.put("target_count", Long.valueOf(l));
    this.db.update("target_globals", contentValues, null, null);
  }
  
  private void createLocalDocumentsCollectionIndex() {
    Runnable runnable = SQLiteSchema$$Lambda$5.lambdaFactory$(this);
    ifTablesDontExist(new String[] { "collection_index" }, runnable);
  }
  
  private void createV1MutationQueue() {
    Runnable runnable = SQLiteSchema$$Lambda$1.lambdaFactory$(this);
    ifTablesDontExist(new String[] { "mutation_queues", "mutations", "document_mutations" }, runnable);
  }
  
  private void createV1QueryCache() {
    Runnable runnable = SQLiteSchema$$Lambda$3.lambdaFactory$(this);
    ifTablesDontExist(new String[] { "targets", "target_globals", "target_documents" }, runnable);
  }
  
  private void createV1RemoteDocumentCache() {
    Runnable runnable = SQLiteSchema$$Lambda$4.lambdaFactory$(this);
    ifTablesDontExist(new String[] { "remote_documents" }, runnable);
  }
  
  private void createV8CollectionParentsIndex() {
    Runnable runnable = SQLiteSchema$$Lambda$9.lambdaFactory$(this);
    ifTablesDontExist(new String[] { "collection_parents" }, runnable);
    Consumer consumer = SQLiteSchema$$Lambda$10.lambdaFactory$(new MemoryIndexManager.MemoryCollectionParentIndex(), this.db.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)"));
    (new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents")).forEach(SQLiteSchema$$Lambda$11.lambdaFactory$(consumer));
    (new SQLitePersistence.Query(this.db, "SELECT path FROM document_mutations")).forEach(SQLiteSchema$$Lambda$12.lambdaFactory$(consumer));
  }
  
  private void dropLastLimboFreeSnapshotVersion() {
    (new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets")).forEach(SQLiteSchema$$Lambda$6.lambdaFactory$(this));
  }
  
  private void dropV1QueryCache() {
    if (tableExists("targets"))
      this.db.execSQL("DROP TABLE targets"); 
    if (tableExists("target_globals"))
      this.db.execSQL("DROP TABLE target_globals"); 
    if (tableExists("target_documents"))
      this.db.execSQL("DROP TABLE target_documents"); 
  }
  
  private void ensureSequenceNumbers() {
    boolean bool;
    Long long_ = (new SQLitePersistence.Query(this.db, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1")).<Long>firstValue(SQLiteSchema$$Lambda$7.lambdaFactory$());
    if (long_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Missing highest sequence number", new Object[0]);
    long l = long_.longValue();
    SQLiteStatement sQLiteStatement = this.db.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
    SQLitePersistence.Query query = (new SQLitePersistence.Query(this.db, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?")).binding(new Object[] { Integer.valueOf(100) });
    boolean[] arrayOfBoolean = new boolean[1];
    do {
      arrayOfBoolean[0] = false;
      query.forEach(SQLiteSchema$$Lambda$8.lambdaFactory$(arrayOfBoolean, sQLiteStatement, l));
    } while (arrayOfBoolean[0]);
  }
  
  private void ensureTargetGlobal() {
    boolean bool;
    if (DatabaseUtils.queryNumEntries(this.db, "target_globals") == 1L) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      this.db.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", (Object[])new String[] { "0", "0", "0", "0" }); 
  }
  
  private boolean hasReadTime() {
    boolean bool4;
    boolean bool1 = tableContainsColumn("remote_documents", "read_time_seconds");
    boolean bool2 = tableContainsColumn("remote_documents", "read_time_nanos");
    boolean bool3 = true;
    if (bool1 == bool2) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    Assert.hardAssert(bool4, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
    if (bool1 && bool2) {
      bool4 = bool3;
    } else {
      bool4 = false;
    } 
    return bool4;
  }
  
  private void ifTablesDontExist(String[] paramArrayOfString, Runnable paramRunnable) {
    String str1;
    StringBuilder stringBuilder2;
    int j;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("[");
    stringBuilder1.append(TextUtils.join(", ", (Object[])paramArrayOfString));
    stringBuilder1.append("]");
    String str2 = stringBuilder1.toString();
    int i = 0;
    int k = i;
    while (i < paramArrayOfString.length) {
      int n;
      String str = paramArrayOfString[i];
      int m = tableExists(str);
      if (i == 0) {
        int i1 = m;
      } else {
        n = k;
        if (m != k) {
          String str3;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Expected all of ");
          stringBuilder.append(str2);
          stringBuilder.append(" to either exist or not, but ");
          str1 = stringBuilder.toString();
          if (k != 0) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str1);
            stringBuilder2.append(paramArrayOfString[0]);
            stringBuilder2.append(" exists and ");
            stringBuilder2.append(str);
            stringBuilder2.append(" does not");
            str3 = stringBuilder2.toString();
          } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str1);
            stringBuilder2.append(str3[0]);
            stringBuilder2.append(" does not exist and ");
            stringBuilder2.append(str);
            stringBuilder2.append(" does");
            str3 = stringBuilder2.toString();
          } 
          throw new IllegalStateException(str3);
        } 
      } 
      i++;
      j = n;
    } 
    if (j == 0) {
      str1.run();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Skipping migration because all of ");
      stringBuilder.append((String)stringBuilder2);
      stringBuilder.append(" already exist");
      Log.d("SQLiteSchema", stringBuilder.toString());
    } 
  }
  
  private void removeAcknowledgedMutations() {
    (new SQLitePersistence.Query(this.db, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues")).forEach(SQLiteSchema$$Lambda$2.lambdaFactory$(this));
  }
  
  private void removeMutationBatch(String paramString, int paramInt) {
    boolean bool;
    SQLiteStatement sQLiteStatement = this.db.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
    sQLiteStatement.bindString(1, paramString);
    sQLiteStatement.bindLong(2, paramInt);
    if (sQLiteStatement.executeUpdateDelete() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Mutatiohn batch (%s, %d) did not exist", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.db.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private boolean tableContainsColumn(String paramString1, String paramString2) {
    boolean bool;
    if (getTableColumns(paramString1).indexOf(paramString2) != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean tableExists(String paramString) {
    return (new SQLitePersistence.Query(this.db, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?")).binding(new Object[] { paramString }).isEmpty() ^ true;
  }
  
  List<String> getTableColumns(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    Cursor cursor1 = null;
    Cursor cursor2 = cursor1;
    try {
      SQLiteDatabase sQLiteDatabase = this.db;
      cursor2 = cursor1;
      StringBuilder stringBuilder = new StringBuilder();
      cursor2 = cursor1;
      this();
      cursor2 = cursor1;
      stringBuilder.append("PRAGMA table_info(");
      cursor2 = cursor1;
      stringBuilder.append(paramString);
      cursor2 = cursor1;
      stringBuilder.append(")");
      cursor2 = cursor1;
      Cursor cursor = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
      cursor2 = cursor;
      int i = cursor.getColumnIndex("name");
      while (true) {
        cursor2 = cursor;
        if (cursor.moveToNext()) {
          cursor2 = cursor;
          arrayList.add(cursor.getString(i));
          continue;
        } 
        return arrayList;
      } 
    } finally {
      if (cursor2 != null)
        cursor2.close(); 
    } 
  }
  
  void runMigrations() {
    runMigrations(0, 10);
  }
  
  void runMigrations(int paramInt) {
    runMigrations(paramInt, 10);
  }
  
  void runMigrations(int paramInt1, int paramInt2) {
    if (paramInt1 < 1 && paramInt2 >= 1) {
      createV1MutationQueue();
      createV1QueryCache();
      createV1RemoteDocumentCache();
    } 
    if (paramInt1 < 3 && paramInt2 >= 3 && paramInt1 != 0) {
      dropV1QueryCache();
      createV1QueryCache();
    } 
    if (paramInt1 < 4 && paramInt2 >= 4) {
      ensureTargetGlobal();
      addTargetCount();
    } 
    if (paramInt1 < 5 && paramInt2 >= 5)
      addSequenceNumber(); 
    if (paramInt1 < 6 && paramInt2 >= 6)
      removeAcknowledgedMutations(); 
    if (paramInt1 < 7 && paramInt2 >= 7)
      ensureSequenceNumbers(); 
    if (paramInt1 < 8 && paramInt2 >= 8)
      createV8CollectionParentsIndex(); 
    if (paramInt1 < 9 && paramInt2 >= 9)
      if (!hasReadTime()) {
        addReadTime();
      } else {
        dropLastLimboFreeSnapshotVersion();
      }  
    if (paramInt1 == 9 && paramInt2 >= 10)
      dropLastLimboFreeSnapshotVersion(); 
    if (paramInt1 < 11 && paramInt2 >= 11) {
      Preconditions.checkState(Persistence.INDEXING_SUPPORT_ENABLED);
      createLocalDocumentsCollectionIndex();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteSchema.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */