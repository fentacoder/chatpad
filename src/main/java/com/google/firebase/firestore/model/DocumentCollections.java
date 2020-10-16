package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;

public class DocumentCollections {
  private static final ImmutableSortedMap<DocumentKey, ?> EMPTY_DOCUMENT_MAP = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());
  
  public static ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap() {
    return (ImmutableSortedMap)EMPTY_DOCUMENT_MAP;
  }
  
  public static ImmutableSortedMap<DocumentKey, MaybeDocument> emptyMaybeDocumentMap() {
    return (ImmutableSortedMap)EMPTY_DOCUMENT_MAP;
  }
  
  public static ImmutableSortedMap<DocumentKey, SnapshotVersion> emptyVersionMap() {
    return (ImmutableSortedMap)EMPTY_DOCUMENT_MAP;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\DocumentCollections.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */