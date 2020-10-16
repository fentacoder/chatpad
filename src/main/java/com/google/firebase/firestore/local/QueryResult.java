package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;

public class QueryResult {
  private final ImmutableSortedMap<DocumentKey, Document> documents;
  
  private final ImmutableSortedSet<DocumentKey> remoteKeys;
  
  public QueryResult(ImmutableSortedMap<DocumentKey, Document> paramImmutableSortedMap, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet) {
    this.documents = paramImmutableSortedMap;
    this.remoteKeys = paramImmutableSortedSet;
  }
  
  public ImmutableSortedMap<DocumentKey, Document> getDocuments() {
    return this.documents;
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoteKeys() {
    return this.remoteKeys;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\QueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */