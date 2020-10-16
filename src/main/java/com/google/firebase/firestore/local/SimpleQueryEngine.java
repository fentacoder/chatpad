package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

public class SimpleQueryEngine implements QueryEngine {
  private LocalDocumentsView localDocumentsView;
  
  public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet) {
    boolean bool;
    if (this.localDocumentsView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "setLocalDocumentsView() not called", new Object[0]);
    return this.localDocumentsView.getDocumentsMatchingQuery(paramQuery, SnapshotVersion.NONE);
  }
  
  public void handleDocumentChange(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2) {}
  
  public void setLocalDocumentsView(LocalDocumentsView paramLocalDocumentsView) {
    this.localDocumentsView = paramLocalDocumentsView;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\SimpleQueryEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */