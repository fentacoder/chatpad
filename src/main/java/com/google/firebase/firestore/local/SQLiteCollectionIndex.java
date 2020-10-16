package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.FieldValue;

public class SQLiteCollectionIndex {
  private final SQLitePersistence db;
  
  private final String uid;
  
  SQLiteCollectionIndex(SQLitePersistence paramSQLitePersistence, User paramUser) {
    String str;
    this.db = paramSQLitePersistence;
    if (paramUser.isAuthenticated()) {
      str = paramUser.getUid();
    } else {
      str = "";
    } 
    this.uid = str;
  }
  
  public void addEntry(FieldPath paramFieldPath, FieldValue paramFieldValue, DocumentKey paramDocumentKey) {
    throw new RuntimeException("Not yet implemented.");
  }
  
  public IndexCursor getCursor(ResourcePath paramResourcePath, IndexRange paramIndexRange) {
    throw new RuntimeException("Not yet implemented.");
  }
  
  public void removeEntry(FieldPath paramFieldPath, FieldValue paramFieldValue, DocumentKey paramDocumentKey) {
    throw new RuntimeException("Not yet implemented.");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SQLiteCollectionIndex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */