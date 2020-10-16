package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class IndexFreeQueryEngine implements QueryEngine {
  private static final String LOG_TAG = "IndexFreeQueryEngine";
  
  private LocalDocumentsView localDocumentsView;
  
  private ImmutableSortedSet<Document> applyQuery(Query paramQuery, ImmutableSortedMap<DocumentKey, MaybeDocument> paramImmutableSortedMap) {
    ImmutableSortedSet<Document> immutableSortedSet2 = new ImmutableSortedSet(Collections.emptyList(), paramQuery.comparator());
    Iterator<Map.Entry> iterator = paramImmutableSortedMap.iterator();
    ImmutableSortedSet<Document> immutableSortedSet1 = immutableSortedSet2;
    while (iterator.hasNext()) {
      MaybeDocument maybeDocument = (MaybeDocument)((Map.Entry)iterator.next()).getValue();
      if (maybeDocument instanceof Document) {
        Document document = (Document)maybeDocument;
        if (paramQuery.matches(document))
          immutableSortedSet1 = immutableSortedSet1.insert(document); 
      } 
    } 
    return immutableSortedSet1;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> executeFullCollectionScan(Query paramQuery) {
    if (Logger.isDebugEnabled())
      Logger.debug("IndexFreeQueryEngine", "Using full collection scan to execute query: %s", new Object[] { paramQuery.toString() }); 
    return this.localDocumentsView.getDocumentsMatchingQuery(paramQuery, SnapshotVersion.NONE);
  }
  
  private boolean needsRefill(Query.LimitType paramLimitType, ImmutableSortedSet<Document> paramImmutableSortedSet, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet1, SnapshotVersion paramSnapshotVersion) {
    Document document;
    if (paramImmutableSortedSet1.size() != paramImmutableSortedSet.size())
      return true; 
    if (paramLimitType == Query.LimitType.LIMIT_TO_FIRST) {
      document = (Document)paramImmutableSortedSet.getMaxEntry();
    } else {
      document = (Document)paramImmutableSortedSet.getMinEntry();
    } 
    boolean bool = false;
    if (document == null)
      return false; 
    if (document.hasPendingWrites() || document.getVersion().compareTo(paramSnapshotVersion) > 0)
      bool = true; 
    return bool;
  }
  
  public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet) {
    boolean bool;
    if (this.localDocumentsView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "setLocalDocumentsView() not called", new Object[0]);
    if (paramQuery.matchesAllDocuments())
      return executeFullCollectionScan(paramQuery); 
    if (paramSnapshotVersion.equals(SnapshotVersion.NONE))
      return executeFullCollectionScan(paramQuery); 
    ImmutableSortedSet<Document> immutableSortedSet = applyQuery(paramQuery, this.localDocumentsView.getDocuments((Iterable<DocumentKey>)paramImmutableSortedSet));
    if ((paramQuery.hasLimitToFirst() || paramQuery.hasLimitToLast()) && needsRefill(paramQuery.getLimitType(), immutableSortedSet, paramImmutableSortedSet, paramSnapshotVersion))
      return executeFullCollectionScan(paramQuery); 
    if (Logger.isDebugEnabled())
      Logger.debug("IndexFreeQueryEngine", "Re-using previous result from %s to execute query: %s", new Object[] { paramSnapshotVersion.toString(), paramQuery.toString() }); 
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap = this.localDocumentsView.getDocumentsMatchingQuery(paramQuery, paramSnapshotVersion);
    for (Document document : immutableSortedSet)
      immutableSortedMap = immutableSortedMap.insert(document.getKey(), document); 
    return immutableSortedMap;
  }
  
  public void handleDocumentChange(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2) {}
  
  public void setLocalDocumentsView(LocalDocumentsView paramLocalDocumentsView) {
    this.localDocumentsView = paramLocalDocumentsView;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\IndexFreeQueryEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */