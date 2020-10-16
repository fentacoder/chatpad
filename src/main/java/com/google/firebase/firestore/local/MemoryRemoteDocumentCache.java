package com.google.firebase.firestore.local;

import android.util.Pair;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class MemoryRemoteDocumentCache implements RemoteDocumentCache {
  private ImmutableSortedMap<DocumentKey, Pair<MaybeDocument, SnapshotVersion>> docs = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());
  
  private final MemoryPersistence persistence;
  
  MemoryRemoteDocumentCache(MemoryPersistence paramMemoryPersistence) {
    this.persistence = paramMemoryPersistence;
  }
  
  public void add(MaybeDocument paramMaybeDocument, SnapshotVersion paramSnapshotVersion) {
    Assert.hardAssert(paramSnapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
    this.docs = this.docs.insert(paramMaybeDocument.getKey(), new Pair(paramMaybeDocument, paramSnapshotVersion));
    this.persistence.getIndexManager().addToCollectionParentIndex((ResourcePath)paramMaybeDocument.getKey().getPath().popLast());
  }
  
  public MaybeDocument get(DocumentKey paramDocumentKey) {
    Pair pair = (Pair)this.docs.get(paramDocumentKey);
    if (pair != null) {
      MaybeDocument maybeDocument = (MaybeDocument)pair.first;
    } else {
      pair = null;
    } 
    return (MaybeDocument)pair;
  }
  
  public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> paramIterable) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (DocumentKey documentKey : paramIterable)
      hashMap.put(documentKey, get(documentKey)); 
    return (Map)hashMap;
  }
  
  public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion) {
    Assert.hardAssert(paramQuery.isCollectionGroupQuery() ^ true, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap = DocumentCollections.emptyDocumentMap();
    ResourcePath resourcePath = paramQuery.getPath();
    DocumentKey documentKey = DocumentKey.fromPath((ResourcePath)resourcePath.append(""));
    Iterator<Map.Entry> iterator = this.docs.iteratorFrom(documentKey);
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (!resourcePath.isPrefixOf((BasePath)((DocumentKey)entry.getKey()).getPath()))
        break; 
      MaybeDocument maybeDocument = (MaybeDocument)((Pair)entry.getValue()).first;
      if (!(maybeDocument instanceof Document) || ((SnapshotVersion)((Pair)entry.getValue()).second).compareTo(paramSnapshotVersion) <= 0)
        continue; 
      Document document = (Document)maybeDocument;
      if (paramQuery.matches(document))
        immutableSortedMap = immutableSortedMap.insert(document.getKey(), document); 
    } 
    return immutableSortedMap;
  }
  
  long getByteSize(LocalSerializer paramLocalSerializer) {
    Iterator<MaybeDocument> iterator = (new DocumentIterable()).iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += paramLocalSerializer.encodeMaybeDocument(iterator.next()).getSerializedSize());
    return l;
  }
  
  Iterable<MaybeDocument> getDocuments() {
    return new DocumentIterable();
  }
  
  public void remove(DocumentKey paramDocumentKey) {
    this.docs = this.docs.remove(paramDocumentKey);
  }
  
  private class DocumentIterable implements Iterable<MaybeDocument> {
    private DocumentIterable() {}
    
    public Iterator<MaybeDocument> iterator() {
      return new Iterator<MaybeDocument>() {
          public boolean hasNext() {
            return iterator.hasNext();
          }
          
          public MaybeDocument next() {
            return (MaybeDocument)((Pair)((Map.Entry)iterator.next()).getValue()).first;
          }
        };
    }
  }
  
  class null implements Iterator<MaybeDocument> {
    public boolean hasNext() {
      return iterator.hasNext();
    }
    
    public MaybeDocument next() {
      return (MaybeDocument)((Pair)((Map.Entry)iterator.next()).getValue()).first;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryRemoteDocumentCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */