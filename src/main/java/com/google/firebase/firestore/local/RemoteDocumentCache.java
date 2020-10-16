package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;

interface RemoteDocumentCache {
  void add(MaybeDocument paramMaybeDocument, SnapshotVersion paramSnapshotVersion);
  
  MaybeDocument get(DocumentKey paramDocumentKey);
  
  Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> paramIterable);
  
  ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion);
  
  void remove(DocumentKey paramDocumentKey);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\RemoteDocumentCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */