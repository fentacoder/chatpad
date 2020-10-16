package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

final class SQLiteIndexManager implements IndexManager {
  private final MemoryIndexManager.MemoryCollectionParentIndex collectionParentsCache = new MemoryIndexManager.MemoryCollectionParentIndex();
  
  private final SQLitePersistence db;
  
  SQLiteIndexManager(SQLitePersistence paramSQLitePersistence) {
    this.db = paramSQLitePersistence;
  }
  
  public void addToCollectionParentIndex(ResourcePath paramResourcePath) {
    boolean bool;
    if (paramResourcePath.length() % 2 == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Expected a collection path.", new Object[0]);
    if (this.collectionParentsCache.add(paramResourcePath)) {
      String str = paramResourcePath.getLastSegment();
      paramResourcePath = (ResourcePath)paramResourcePath.popLast();
      this.db.execute("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", new Object[] { str, EncodedPath.encode(paramResourcePath) });
    } 
  }
  
  public List<ResourcePath> getCollectionParents(String paramString) {
    ArrayList<ResourcePath> arrayList = new ArrayList();
    this.db.query("SELECT parent FROM collection_parents WHERE collection_id = ?").binding(new Object[] { paramString }).forEach(SQLiteIndexManager$$Lambda$1.lambdaFactory$(arrayList));
    return arrayList;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteIndexManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */