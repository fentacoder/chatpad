package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;

public class CollectionReference extends Query {
  CollectionReference(ResourcePath paramResourcePath, FirebaseFirestore paramFirebaseFirestore) {
    super(Query.atPath(paramResourcePath), paramFirebaseFirestore);
    if (paramResourcePath.length() % 2 == 1)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid collection reference. Collection references must have an odd number of segments, but ");
    stringBuilder.append(paramResourcePath.canonicalString());
    stringBuilder.append(" has ");
    stringBuilder.append(paramResourcePath.length());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Task<DocumentReference> add(Object paramObject) {
    Preconditions.checkNotNull(paramObject, "Provided data must not be null.");
    DocumentReference documentReference = document();
    return documentReference.set(paramObject).continueWith(Executors.DIRECT_EXECUTOR, CollectionReference$$Lambda$1.lambdaFactory$(documentReference));
  }
  
  public DocumentReference document() {
    return document(Util.autoId());
  }
  
  public DocumentReference document(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided document path must not be null.");
    return DocumentReference.forPath((ResourcePath)this.query.getPath().append((BasePath)ResourcePath.fromString(paramString)), this.firestore);
  }
  
  public String getId() {
    return this.query.getPath().getLastSegment();
  }
  
  public DocumentReference getParent() {
    ResourcePath resourcePath = (ResourcePath)this.query.getPath().popLast();
    return resourcePath.isEmpty() ? null : new DocumentReference(DocumentKey.fromPath(resourcePath), this.firestore);
  }
  
  public String getPath() {
    return this.query.getPath().canonicalString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\CollectionReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */