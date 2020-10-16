package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;

interface ReferenceDelegate {
  void addReference(DocumentKey paramDocumentKey);
  
  long getCurrentSequenceNumber();
  
  void onTransactionCommitted();
  
  void onTransactionStarted();
  
  void removeMutationReference(DocumentKey paramDocumentKey);
  
  void removeReference(DocumentKey paramDocumentKey);
  
  void removeTarget(QueryData paramQueryData);
  
  void setInMemoryPins(ReferenceSet paramReferenceSet);
  
  void updateLimboDocument(DocumentKey paramDocumentKey);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\ReferenceDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */