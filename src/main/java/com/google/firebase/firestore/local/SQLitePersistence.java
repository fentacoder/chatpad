package com.google.firebase.firestore.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.common.base.Function;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.FileUtil;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SQLitePersistence extends Persistence {
  private SQLiteDatabase db;
  
  private final SQLiteIndexManager indexManager;
  
  private final SQLiteOpenHelper opener;
  
  private final SQLiteQueryCache queryCache;
  
  private final SQLiteLruReferenceDelegate referenceDelegate;
  
  private final SQLiteRemoteDocumentCache remoteDocumentCache;
  
  private final LocalSerializer serializer;
  
  private boolean started;
  
  private final SQLiteTransactionListener transactionListener = new SQLiteTransactionListener() {
      public void onBegin() {
        SQLitePersistence.this.referenceDelegate.onTransactionStarted();
      }
      
      public void onCommit() {
        SQLitePersistence.this.referenceDelegate.onTransactionCommitted();
      }
      
      public void onRollback() {}
    };
  
  public SQLitePersistence(Context paramContext, String paramString, DatabaseId paramDatabaseId, LocalSerializer paramLocalSerializer, LruGarbageCollector.Params paramParams) {
    this(paramLocalSerializer, paramParams, new OpenHelper(paramContext, databaseName(paramString, paramDatabaseId)));
  }
  
  public SQLitePersistence(LocalSerializer paramLocalSerializer, LruGarbageCollector.Params paramParams, SQLiteOpenHelper paramSQLiteOpenHelper) {
    this.opener = paramSQLiteOpenHelper;
    this.serializer = paramLocalSerializer;
    this.queryCache = new SQLiteQueryCache(this, this.serializer);
    this.indexManager = new SQLiteIndexManager(this);
    this.remoteDocumentCache = new SQLiteRemoteDocumentCache(this, this.serializer);
    this.referenceDelegate = new SQLiteLruReferenceDelegate(this, paramParams);
  }
  
  private static void bind(SQLiteProgram paramSQLiteProgram, Object[] paramArrayOfObject) {
    for (byte b = 0; b < paramArrayOfObject.length; b++) {
      Object object = paramArrayOfObject[b];
      if (object == null) {
        paramSQLiteProgram.bindNull(b + 1);
      } else if (object instanceof String) {
        paramSQLiteProgram.bindString(b + 1, (String)object);
      } else if (object instanceof Integer) {
        paramSQLiteProgram.bindLong(b + 1, ((Integer)object).intValue());
      } else if (object instanceof Long) {
        paramSQLiteProgram.bindLong(b + 1, ((Long)object).longValue());
      } else if (object instanceof Double) {
        paramSQLiteProgram.bindDouble(b + 1, ((Double)object).doubleValue());
      } else if (object instanceof byte[]) {
        paramSQLiteProgram.bindBlob(b + 1, (byte[])object);
      } else {
        throw Assert.fail("Unknown argument %s of type %s", new Object[] { object, object.getClass() });
      } 
    } 
  }
  
  public static void clearPersistence(Context paramContext, DatabaseId paramDatabaseId, String paramString) throws FirebaseFirestoreException {
    String str2 = paramContext.getDatabasePath(databaseName(paramString, paramDatabaseId)).getPath();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append("-journal");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append("-wal");
    String str3 = stringBuilder2.toString();
    File file2 = new File(str2);
    File file1 = new File(str1);
    File file3 = new File(str3);
    try {
      FileUtil.delete(file2);
      FileUtil.delete(file1);
      FileUtil.delete(file3);
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to clear persistence.");
      stringBuilder.append(iOException);
      throw new FirebaseFirestoreException(stringBuilder.toString(), FirebaseFirestoreException.Code.UNKNOWN);
    } 
  }
  
  public static String databaseName(String paramString, DatabaseId paramDatabaseId) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("firestore.");
      stringBuilder.append(URLEncoder.encode(paramString, "utf-8"));
      stringBuilder.append(".");
      stringBuilder.append(URLEncoder.encode(paramDatabaseId.getProjectId(), "utf-8"));
      stringBuilder.append(".");
      stringBuilder.append(URLEncoder.encode(paramDatabaseId.getDatabaseId(), "utf-8"));
      return stringBuilder.toString();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  private long getPageCount() {
    return ((Long)query("PRAGMA page_count").<Long>firstValue(SQLitePersistence$$Lambda$2.lambdaFactory$())).longValue();
  }
  
  private long getPageSize() {
    return ((Long)query("PRAGMA page_size").<Long>firstValue(SQLitePersistence$$Lambda$1.lambdaFactory$())).longValue();
  }
  
  int execute(SQLiteStatement paramSQLiteStatement, Object... paramVarArgs) {
    paramSQLiteStatement.clearBindings();
    bind((SQLiteProgram)paramSQLiteStatement, paramVarArgs);
    return paramSQLiteStatement.executeUpdateDelete();
  }
  
  void execute(String paramString, Object... paramVarArgs) {
    this.db.execSQL(paramString, paramVarArgs);
  }
  
  long getByteSize() {
    return getPageCount() * getPageSize();
  }
  
  IndexManager getIndexManager() {
    return this.indexManager;
  }
  
  MutationQueue getMutationQueue(User paramUser) {
    return new SQLiteMutationQueue(this, this.serializer, paramUser);
  }
  
  SQLiteQueryCache getQueryCache() {
    return this.queryCache;
  }
  
  public SQLiteLruReferenceDelegate getReferenceDelegate() {
    return this.referenceDelegate;
  }
  
  RemoteDocumentCache getRemoteDocumentCache() {
    return this.remoteDocumentCache;
  }
  
  public boolean isStarted() {
    return this.started;
  }
  
  SQLiteStatement prepare(String paramString) {
    return this.db.compileStatement(paramString);
  }
  
  Query query(String paramString) {
    return new Query(this.db, paramString);
  }
  
  <T> T runTransaction(String paramString, Supplier<T> paramSupplier) {
    Logger.debug(TAG, "Starting transaction: %s", new Object[] { paramString });
    this.db.beginTransactionWithListener(this.transactionListener);
    try {
      Object object = paramSupplier.get();
      this.db.setTransactionSuccessful();
      return (T)object;
    } finally {
      this.db.endTransaction();
    } 
  }
  
  void runTransaction(String paramString, Runnable paramRunnable) {
    Logger.debug(TAG, "Starting transaction: %s", new Object[] { paramString });
    this.db.beginTransactionWithListener(this.transactionListener);
    try {
      paramRunnable.run();
      this.db.setTransactionSuccessful();
      return;
    } finally {
      this.db.endTransaction();
    } 
  }
  
  public void shutdown() {
    Assert.hardAssert(this.started, "SQLitePersistence shutdown without start!", new Object[0]);
    this.started = false;
    this.db.close();
    this.db = null;
  }
  
  public void start() {
    Assert.hardAssert(this.started ^ true, "SQLitePersistence double-started!", new Object[0]);
    this.started = true;
    try {
      this.db = this.opener.getWritableDatabase();
      this.queryCache.start();
      this.referenceDelegate.start(this.queryCache.getHighestListenSequenceNumber());
      return;
    } catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
      throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", sQLiteDatabaseLockedException);
    } 
  }
  
  static class LongQuery {
    private static final int LIMIT = 900;
    
    private final List<Object> argsHead;
    
    private final Iterator<Object> argsIter;
    
    private final SQLitePersistence db;
    
    private final String head;
    
    private int subqueriesPerformed = 0;
    
    private final String tail;
    
    LongQuery(SQLitePersistence param1SQLitePersistence, String param1String1, List<Object> param1List, String param1String2) {
      this.db = param1SQLitePersistence;
      this.head = param1String1;
      this.argsHead = Collections.emptyList();
      this.tail = param1String2;
      this.argsIter = param1List.iterator();
    }
    
    LongQuery(SQLitePersistence param1SQLitePersistence, String param1String1, List<Object> param1List1, List<Object> param1List2, String param1String2) {
      this.db = param1SQLitePersistence;
      this.head = param1String1;
      this.argsHead = param1List1;
      this.tail = param1String2;
      this.argsIter = param1List2.iterator();
    }
    
    int getSubqueriesPerformed() {
      return this.subqueriesPerformed;
    }
    
    boolean hasMoreSubqueries() {
      return this.argsIter.hasNext();
    }
    
    SQLitePersistence.Query performNextSubquery() {
      this.subqueriesPerformed++;
      ArrayList arrayList = new ArrayList(this.argsHead);
      StringBuilder stringBuilder1 = new StringBuilder();
      for (byte b = 0; this.argsIter.hasNext() && b < 900 - this.argsHead.size(); b++) {
        if (b > 0)
          stringBuilder1.append(", "); 
        stringBuilder1.append("?");
        arrayList.add(this.argsIter.next());
      } 
      String str = stringBuilder1.toString();
      SQLitePersistence sQLitePersistence = this.db;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.head);
      stringBuilder2.append(str);
      stringBuilder2.append(this.tail);
      return sQLitePersistence.query(stringBuilder2.toString()).binding(arrayList.toArray());
    }
  }
  
  private static class OpenHelper extends SQLiteOpenHelper {
    private boolean configured;
    
    OpenHelper(Context param1Context, String param1String) {
      super(param1Context, param1String, null, 10);
    }
    
    private void ensureConfigured(SQLiteDatabase param1SQLiteDatabase) {
      if (!this.configured)
        onConfigure(param1SQLiteDatabase); 
    }
    
    public void onConfigure(SQLiteDatabase param1SQLiteDatabase) {
      this.configured = true;
      param1SQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
    }
    
    public void onCreate(SQLiteDatabase param1SQLiteDatabase) {
      ensureConfigured(param1SQLiteDatabase);
      (new SQLiteSchema(param1SQLiteDatabase)).runMigrations(0);
    }
    
    public void onDowngrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      ensureConfigured(param1SQLiteDatabase);
    }
    
    public void onOpen(SQLiteDatabase param1SQLiteDatabase) {
      ensureConfigured(param1SQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      ensureConfigured(param1SQLiteDatabase);
      (new SQLiteSchema(param1SQLiteDatabase)).runMigrations(param1Int1);
    }
  }
  
  static class Query {
    private SQLiteDatabase.CursorFactory cursorFactory;
    
    private final SQLiteDatabase db;
    
    private final String sql;
    
    Query(SQLiteDatabase param1SQLiteDatabase, String param1String) {
      this.db = param1SQLiteDatabase;
      this.sql = param1String;
    }
    
    private Cursor startQuery() {
      SQLiteDatabase.CursorFactory cursorFactory = this.cursorFactory;
      return (cursorFactory != null) ? this.db.rawQueryWithFactory(cursorFactory, this.sql, null, null) : this.db.rawQuery(this.sql, null);
    }
    
    Query binding(Object... param1VarArgs) {
      this.cursorFactory = SQLitePersistence$Query$$Lambda$1.lambdaFactory$(param1VarArgs);
      return this;
    }
    
    int first(Consumer<Cursor> param1Consumer) {
      Cursor cursor;
      try {
        cursor = startQuery();
      } finally {
        param1Consumer = null;
      } 
      if (cursor != null)
        cursor.close(); 
      throw param1Consumer;
    }
    
    <T> T firstValue(Function<Cursor, T> param1Function) {
      Cursor cursor;
      try {
        cursor = startQuery();
      } finally {
        param1Function = null;
      } 
      if (cursor != null)
        cursor.close(); 
      throw param1Function;
    }
    
    int forEach(Consumer<Cursor> param1Consumer) {
      Cursor cursor = startQuery();
      byte b = 0;
      try {
        while (cursor.moveToNext()) {
          b++;
          param1Consumer.accept(cursor);
        } 
        return b;
      } finally {
        param1Consumer = null;
      } 
    }
    
    boolean isEmpty() {
      Cursor cursor;
      Exception exception;
      try {
        cursor = startQuery();
      } finally {
        exception = null;
      } 
      if (cursor != null)
        cursor.close(); 
      throw exception;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLitePersistence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */