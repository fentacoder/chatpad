package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.Map;

final class TargetState {
  private boolean current = false;
  
  private final Map<DocumentKey, DocumentViewChange.Type> documentChanges = new HashMap<>();
  
  private boolean hasChanges = true;
  
  private int outstandingResponses = 0;
  
  private ByteString resumeToken = ByteString.EMPTY;
  
  void addDocumentChange(DocumentKey paramDocumentKey, DocumentViewChange.Type paramType) {
    this.hasChanges = true;
    this.documentChanges.put(paramDocumentKey, paramType);
  }
  
  void clearChanges() {
    this.hasChanges = false;
    this.documentChanges.clear();
  }
  
  boolean hasChanges() {
    return this.hasChanges;
  }
  
  boolean isCurrent() {
    return this.current;
  }
  
  boolean isPending() {
    boolean bool;
    if (this.outstandingResponses != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  void markCurrent() {
    this.hasChanges = true;
    this.current = true;
  }
  
  void recordPendingTargetRequest() {
    this.outstandingResponses++;
  }
  
  void recordTargetResponse() {
    this.outstandingResponses--;
  }
  
  void removeDocumentChange(DocumentKey paramDocumentKey) {
    this.hasChanges = true;
    this.documentChanges.remove(paramDocumentKey);
  }
  
  TargetChange toTargetChange() {
    ImmutableSortedSet<DocumentKey> immutableSortedSet1 = DocumentKey.emptyKeySet();
    ImmutableSortedSet<DocumentKey> immutableSortedSet2 = DocumentKey.emptyKeySet();
    ImmutableSortedSet<DocumentKey> immutableSortedSet3 = DocumentKey.emptyKeySet();
    for (Map.Entry<DocumentKey, DocumentViewChange.Type> entry : this.documentChanges.entrySet()) {
      DocumentKey documentKey = (DocumentKey)entry.getKey();
      DocumentViewChange.Type type = (DocumentViewChange.Type)entry.getValue();
      int i = null.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[type.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            immutableSortedSet3 = immutableSortedSet3.insert(documentKey);
            continue;
          } 
          throw Assert.fail("Encountered invalid change type: %s", new Object[] { type });
        } 
        immutableSortedSet2 = immutableSortedSet2.insert(documentKey);
        continue;
      } 
      immutableSortedSet1 = immutableSortedSet1.insert(documentKey);
    } 
    return new TargetChange(this.resumeToken, this.current, immutableSortedSet1, immutableSortedSet2, immutableSortedSet3);
  }
  
  void updateResumeToken(ByteString paramByteString) {
    if (!paramByteString.isEmpty()) {
      this.hasChanges = true;
      this.resumeToken = paramByteString;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\TargetState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */