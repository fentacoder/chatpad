package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;

public class ReferenceValue extends FieldValue {
  private final DatabaseId databaseId;
  
  private final DocumentKey key;
  
  private ReferenceValue(DatabaseId paramDatabaseId, DocumentKey paramDocumentKey) {
    this.databaseId = paramDatabaseId;
    this.key = paramDocumentKey;
  }
  
  public static ReferenceValue valueOf(DatabaseId paramDatabaseId, DocumentKey paramDocumentKey) {
    return new ReferenceValue(paramDatabaseId, paramDocumentKey);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    if (paramFieldValue instanceof ReferenceValue) {
      paramFieldValue = paramFieldValue;
      int i = this.databaseId.compareTo(((ReferenceValue)paramFieldValue).databaseId);
      if (i == 0)
        i = this.key.compareTo(((ReferenceValue)paramFieldValue).key); 
      return i;
    } 
    return defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof ReferenceValue;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (bool) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.key.equals(((ReferenceValue)paramObject).key)) {
        bool2 = bool1;
        if (this.databaseId.equals(((ReferenceValue)paramObject).databaseId))
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public DatabaseId getDatabaseId() {
    return this.databaseId;
  }
  
  public int hashCode() {
    return (961 + this.databaseId.hashCode()) * 31 + this.key.hashCode();
  }
  
  public int typeOrder() {
    return 6;
  }
  
  public DocumentKey value() {
    return this.key;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\ReferenceValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */