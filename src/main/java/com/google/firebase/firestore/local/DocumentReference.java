package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

class DocumentReference {
  static final Comparator<DocumentReference> BY_KEY = DocumentReference$$Lambda$1.lambdaFactory$();
  
  static final Comparator<DocumentReference> BY_TARGET = DocumentReference$$Lambda$2.lambdaFactory$();
  
  private final DocumentKey key;
  
  private final int targetOrBatchId;
  
  public DocumentReference(DocumentKey paramDocumentKey, int paramInt) {
    this.key = paramDocumentKey;
    this.targetOrBatchId = paramInt;
  }
  
  int getId() {
    return this.targetOrBatchId;
  }
  
  DocumentKey getKey() {
    return this.key;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\DocumentReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */