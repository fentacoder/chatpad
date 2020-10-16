package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;

public interface QueryEngine {
  ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet);
  
  void handleDocumentChange(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2);
  
  void setLocalDocumentsView(LocalDocumentsView paramLocalDocumentsView);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\QueryEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */