package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LocalDocumentsView {
  private final IndexManager indexManager;
  
  private final MutationQueue mutationQueue;
  
  private final RemoteDocumentCache remoteDocumentCache;
  
  LocalDocumentsView(RemoteDocumentCache paramRemoteDocumentCache, MutationQueue paramMutationQueue, IndexManager paramIndexManager) {
    this.remoteDocumentCache = paramRemoteDocumentCache;
    this.mutationQueue = paramMutationQueue;
    this.indexManager = paramIndexManager;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> addMissingBaseDocuments(List<MutationBatch> paramList, ImmutableSortedMap<DocumentKey, Document> paramImmutableSortedMap) {
    HashSet<DocumentKey> hashSet = new HashSet();
    null = paramList.iterator();
    while (null.hasNext()) {
      for (Mutation mutation : ((MutationBatch)null.next()).getMutations()) {
        if (mutation instanceof com.google.firebase.firestore.model.mutation.PatchMutation && !paramImmutableSortedMap.containsKey(mutation.getKey()))
          hashSet.add(mutation.getKey()); 
      } 
    } 
    for (Map.Entry<DocumentKey, MaybeDocument> entry : this.remoteDocumentCache.getAll(hashSet).entrySet()) {
      if (entry.getValue() != null && entry.getValue() instanceof Document)
        paramImmutableSortedMap = paramImmutableSortedMap.insert(entry.getKey(), entry.getValue()); 
    } 
    return paramImmutableSortedMap;
  }
  
  private Map<DocumentKey, MaybeDocument> applyLocalMutationsToDocuments(Map<DocumentKey, MaybeDocument> paramMap, List<MutationBatch> paramList) {
    for (Map.Entry<DocumentKey, MaybeDocument> entry : paramMap.entrySet()) {
      MaybeDocument maybeDocument = (MaybeDocument)entry.getValue();
      Iterator<MutationBatch> iterator = paramList.iterator();
      while (iterator.hasNext())
        maybeDocument = ((MutationBatch)iterator.next()).applyToLocalView((DocumentKey)entry.getKey(), maybeDocument); 
      entry.setValue(maybeDocument);
    } 
    return paramMap;
  }
  
  private MaybeDocument getDocument(DocumentKey paramDocumentKey, List<MutationBatch> paramList) {
    MaybeDocument maybeDocument2 = this.remoteDocumentCache.get(paramDocumentKey);
    Iterator<MutationBatch> iterator = paramList.iterator();
    MaybeDocument maybeDocument1;
    for (maybeDocument1 = maybeDocument2; iterator.hasNext(); maybeDocument1 = ((MutationBatch)iterator.next()).applyToLocalView(paramDocumentKey, maybeDocument1));
    return maybeDocument1;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionGroupQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion) {
    Map.Entry entry;
    Assert.hardAssert(paramQuery.getPath().isEmpty(), "Currently we only support collection group queries at the root.", new Object[0]);
    String str = paramQuery.getCollectionGroup();
    ImmutableSortedMap immutableSortedMap = DocumentCollections.emptyDocumentMap();
    Iterator<ResourcePath> iterator = this.indexManager.getCollectionParents(str).iterator();
    label11: while (iterator.hasNext()) {
      Iterator<Map.Entry> iterator1 = getDocumentsMatchingCollectionQuery(paramQuery.asCollectionQueryAtPath((ResourcePath)((ResourcePath)iterator.next()).append(str)), paramSnapshotVersion).iterator();
      ImmutableSortedMap immutableSortedMap1 = immutableSortedMap;
      while (true) {
        immutableSortedMap = immutableSortedMap1;
        if (iterator1.hasNext()) {
          entry = iterator1.next();
          immutableSortedMap1 = immutableSortedMap1.insert(entry.getKey(), entry.getValue());
          continue;
        } 
        continue label11;
      } 
    } 
    return (ImmutableSortedMap<DocumentKey, Document>)entry;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion) {
    DocumentKey documentKey;
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap1;
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap2 = this.remoteDocumentCache.getAllDocumentsMatchingQuery(paramQuery, paramSnapshotVersion);
    List<MutationBatch> list = this.mutationQueue.getAllMutationBatchesAffectingQuery(paramQuery);
    immutableSortedMap2 = addMissingBaseDocuments(list, immutableSortedMap2);
    label25: for (MutationBatch mutationBatch : list) {
      Iterator<Mutation> iterator = mutationBatch.getMutations().iterator();
      ImmutableSortedMap<DocumentKey, Document> immutableSortedMap = immutableSortedMap2;
      while (true) {
        immutableSortedMap2 = immutableSortedMap;
        if (iterator.hasNext()) {
          Mutation mutation = iterator.next();
          if (!paramQuery.getPath().isImmediateParentOf((BasePath)mutation.getKey().getPath()))
            continue; 
          documentKey = mutation.getKey();
          MaybeDocument maybeDocument2 = (MaybeDocument)immutableSortedMap.get(documentKey);
          MaybeDocument maybeDocument1 = mutation.applyToLocalView(maybeDocument2, maybeDocument2, mutationBatch.getLocalWriteTime());
          if (maybeDocument1 instanceof Document) {
            immutableSortedMap = immutableSortedMap.insert(documentKey, maybeDocument1);
            continue;
          } 
          immutableSortedMap = immutableSortedMap.remove(documentKey);
          continue;
        } 
        continue label25;
      } 
    } 
    for (Map.Entry entry : documentKey) {
      if (!paramQuery.matches((Document)entry.getValue()))
        immutableSortedMap1 = documentKey.remove(entry.getKey()); 
    } 
    return immutableSortedMap1;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingDocumentQuery(ResourcePath paramResourcePath) {
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap2 = DocumentCollections.emptyDocumentMap();
    MaybeDocument maybeDocument = getDocument(DocumentKey.fromPath(paramResourcePath));
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap1 = immutableSortedMap2;
    if (maybeDocument instanceof Document)
      immutableSortedMap1 = immutableSortedMap2.insert(maybeDocument.getKey(), maybeDocument); 
    return immutableSortedMap1;
  }
  
  MaybeDocument getDocument(DocumentKey paramDocumentKey) {
    return getDocument(paramDocumentKey, this.mutationQueue.getAllMutationBatchesAffectingDocumentKey(paramDocumentKey));
  }
  
  ImmutableSortedMap<DocumentKey, MaybeDocument> getDocuments(Iterable<DocumentKey> paramIterable) {
    return getLocalViewOfDocuments(this.remoteDocumentCache.getAll(paramIterable));
  }
  
  ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion) {
    ResourcePath resourcePath = paramQuery.getPath();
    return paramQuery.isDocumentQuery() ? getDocumentsMatchingDocumentQuery(resourcePath) : (paramQuery.isCollectionGroupQuery() ? getDocumentsMatchingCollectionGroupQuery(paramQuery, paramSnapshotVersion) : getDocumentsMatchingCollectionQuery(paramQuery, paramSnapshotVersion));
  }
  
  IndexManager getIndexManager() {
    return this.indexManager;
  }
  
  ImmutableSortedMap<DocumentKey, MaybeDocument> getLocalViewOfDocuments(Map<DocumentKey, MaybeDocument> paramMap) {
    ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap2 = DocumentCollections.emptyMaybeDocumentMap();
    Iterator<Map.Entry> iterator = applyLocalMutationsToDocuments(paramMap, this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(paramMap.keySet())).entrySet().iterator();
    ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap1;
    for (immutableSortedMap1 = immutableSortedMap2; iterator.hasNext(); immutableSortedMap1 = immutableSortedMap1.insert(documentKey, noDocument)) {
      NoDocument noDocument;
      Map.Entry entry = iterator.next();
      DocumentKey documentKey = (DocumentKey)entry.getKey();
      MaybeDocument maybeDocument2 = (MaybeDocument)entry.getValue();
      MaybeDocument maybeDocument1 = maybeDocument2;
      if (maybeDocument2 == null)
        noDocument = new NoDocument(documentKey, SnapshotVersion.NONE, false); 
    } 
    return immutableSortedMap1;
  }
  
  MutationQueue getMutationQueue() {
    return this.mutationQueue;
  }
  
  RemoteDocumentCache getRemoteDocumentCache() {
    return this.remoteDocumentCache;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LocalDocumentsView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */