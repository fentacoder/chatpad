package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DocumentViewChangeSet {
  private final TreeMap<DocumentKey, DocumentViewChange> changes = new TreeMap<>();
  
  public void addChange(DocumentViewChange paramDocumentViewChange) {
    DocumentKey documentKey = paramDocumentViewChange.getDocument().getKey();
    DocumentViewChange documentViewChange = this.changes.get(documentKey);
    if (documentViewChange == null) {
      this.changes.put(documentKey, paramDocumentViewChange);
      return;
    } 
    DocumentViewChange.Type type1 = documentViewChange.getType();
    DocumentViewChange.Type type2 = paramDocumentViewChange.getType();
    if (type2 != DocumentViewChange.Type.ADDED && type1 == DocumentViewChange.Type.METADATA) {
      this.changes.put(documentKey, paramDocumentViewChange);
    } else if (type2 == DocumentViewChange.Type.METADATA && type1 != DocumentViewChange.Type.REMOVED) {
      paramDocumentViewChange = DocumentViewChange.create(type1, paramDocumentViewChange.getDocument());
      this.changes.put(documentKey, paramDocumentViewChange);
    } else if (type2 == DocumentViewChange.Type.MODIFIED && type1 == DocumentViewChange.Type.MODIFIED) {
      paramDocumentViewChange = DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, paramDocumentViewChange.getDocument());
      this.changes.put(documentKey, paramDocumentViewChange);
    } else if (type2 == DocumentViewChange.Type.MODIFIED && type1 == DocumentViewChange.Type.ADDED) {
      paramDocumentViewChange = DocumentViewChange.create(DocumentViewChange.Type.ADDED, paramDocumentViewChange.getDocument());
      this.changes.put(documentKey, paramDocumentViewChange);
    } else if (type2 == DocumentViewChange.Type.REMOVED && type1 == DocumentViewChange.Type.ADDED) {
      this.changes.remove(documentKey);
    } else if (type2 == DocumentViewChange.Type.REMOVED && type1 == DocumentViewChange.Type.MODIFIED) {
      paramDocumentViewChange = DocumentViewChange.create(DocumentViewChange.Type.REMOVED, documentViewChange.getDocument());
      this.changes.put(documentKey, paramDocumentViewChange);
    } else {
      if (type2 == DocumentViewChange.Type.ADDED && type1 == DocumentViewChange.Type.REMOVED) {
        paramDocumentViewChange = DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, paramDocumentViewChange.getDocument());
        this.changes.put(documentKey, paramDocumentViewChange);
        return;
      } 
      throw Assert.fail("Unsupported combination of changes %s after %s", new Object[] { type2, type1 });
    } 
  }
  
  List<DocumentViewChange> getChanges() {
    return new ArrayList<>(this.changes.values());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\DocumentViewChangeSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */