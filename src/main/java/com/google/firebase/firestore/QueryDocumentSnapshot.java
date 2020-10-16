package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.Map;

public class QueryDocumentSnapshot extends DocumentSnapshot {
  private QueryDocumentSnapshot(FirebaseFirestore paramFirebaseFirestore, DocumentKey paramDocumentKey, Document paramDocument, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramFirebaseFirestore, paramDocumentKey, paramDocument, paramBoolean1, paramBoolean2);
  }
  
  static QueryDocumentSnapshot fromDocument(FirebaseFirestore paramFirebaseFirestore, Document paramDocument, boolean paramBoolean1, boolean paramBoolean2) {
    return new QueryDocumentSnapshot(paramFirebaseFirestore, paramDocument.getKey(), paramDocument, paramBoolean1, paramBoolean2);
  }
  
  public Map<String, Object> getData() {
    boolean bool;
    Map<String, Object> map = super.getData();
    if (map != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
    return map;
  }
  
  public Map<String, Object> getData(DocumentSnapshot.ServerTimestampBehavior paramServerTimestampBehavior) {
    boolean bool;
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    Map<String, Object> map = super.getData(paramServerTimestampBehavior);
    if (map != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Data in a QueryDocumentSnapshot should be non-null", new Object[0]);
    return map;
  }
  
  public <T> T toObject(Class<T> paramClass) {
    boolean bool;
    paramClass = super.toObject((Class)paramClass);
    if (paramClass != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
    return (T)paramClass;
  }
  
  public <T> T toObject(Class<T> paramClass, DocumentSnapshot.ServerTimestampBehavior paramServerTimestampBehavior) {
    boolean bool;
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    paramClass = super.toObject((Class)paramClass, paramServerTimestampBehavior);
    if (paramClass != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Object in a QueryDocumentSnapshot should be non-null", new Object[0]);
    return (T)paramClass;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\QueryDocumentSnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */