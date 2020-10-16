package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IndexedQueryEngine implements QueryEngine {
  private static final double HIGH_SELECTIVITY = 1.0D;
  
  private static final double LOW_SELECTIVITY = 0.5D;
  
  private static final List<Class> lowCardinalityTypes = Arrays.asList(new Class[] { BooleanValue.class, ArrayValue.class, ObjectValue.class });
  
  private final SQLiteCollectionIndex collectionIndex;
  
  private LocalDocumentsView localDocuments;
  
  public IndexedQueryEngine(SQLiteCollectionIndex paramSQLiteCollectionIndex) {
    this.collectionIndex = paramSQLiteCollectionIndex;
  }
  
  private static IndexRange convertFilterToIndexRange(Filter paramFilter) {
    IndexRange.Builder builder = IndexRange.builder().setFieldPath(paramFilter.getField());
    if (paramFilter instanceof FieldFilter) {
      FieldFilter fieldFilter = (FieldFilter)paramFilter;
      FieldValue fieldValue = fieldFilter.getValue();
      int i = null.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[fieldFilter.getOperator().ordinal()];
      if (i != 1) {
        if (i != 2 && i != 3) {
          if (i == 4 || i == 5) {
            builder.setStart(fieldValue);
            return builder.build();
          } 
          throw Assert.fail("Unexpected operator in query filter", new Object[0]);
        } 
        builder.setEnd(fieldValue);
      } else {
        builder.setStart(fieldValue).setEnd(fieldValue);
      } 
    } 
    return builder.build();
  }
  
  private static double estimateFilterSelectivity(Filter paramFilter) {
    Assert.hardAssert(paramFilter instanceof FieldFilter, "Filter type expected to be FieldFilter", new Object[0]);
    FieldFilter fieldFilter = (FieldFilter)paramFilter;
    boolean bool = fieldFilter.getValue().equals(null);
    double d1 = 1.0D;
    double d2 = d1;
    if (!bool)
      if (fieldFilter.getValue().equals(DoubleValue.NaN)) {
        d2 = d1;
      } else {
        if (fieldFilter.getOperator().equals(Filter.Operator.EQUAL)) {
          d2 = 1.0D;
        } else {
          d2 = 0.5D;
        } 
        if (lowCardinalityTypes.contains(fieldFilter.getValue().getClass()))
          d1 = 0.5D; 
        d2 = d1 * d2;
      }  
    return d2;
  }
  
  static IndexRange extractBestIndexRange(Query paramQuery) {
    Filter filter;
    boolean bool = paramQuery.getFilters().isEmpty();
    Query query = null;
    if (!bool) {
      Iterator<Filter> iterator = paramQuery.getFilters().iterator();
      double d = -1.0D;
      paramQuery = query;
      while (iterator.hasNext()) {
        Filter filter1 = iterator.next();
        double d1 = estimateFilterSelectivity(filter1);
        if (d1 > d) {
          filter = filter1;
          d = d1;
        } 
      } 
      if (filter != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Filter should be defined", new Object[0]);
      return convertFilterToIndexRange(filter);
    } 
    return !((OrderBy)filter.getOrderBy().get(0)).getField().equals(FieldPath.KEY_PATH) ? IndexRange.builder().setFieldPath(((OrderBy)filter.getOrderBy().get(0)).getField()).build() : null;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> performCollectionQuery(Query paramQuery) {
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap;
    Assert.hardAssert(paramQuery.isDocumentQuery() ^ true, "matchesCollectionQuery() called with document query.", new Object[0]);
    IndexRange indexRange = extractBestIndexRange(paramQuery);
    if (indexRange != null) {
      immutableSortedMap = performQueryUsingIndex(paramQuery, indexRange);
    } else {
      Assert.hardAssert(immutableSortedMap.getFilters().isEmpty(), "If there are any filters, we should be able to use an index.", new Object[0]);
      immutableSortedMap = this.localDocuments.getDocumentsMatchingQuery((Query)immutableSortedMap, SnapshotVersion.NONE);
    } 
    return immutableSortedMap;
  }
  
  private ImmutableSortedMap<DocumentKey, Document> performQueryUsingIndex(Query paramQuery, IndexRange paramIndexRange) {
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap2 = DocumentCollections.emptyDocumentMap();
    IndexCursor indexCursor = this.collectionIndex.getCursor(paramQuery.getPath(), paramIndexRange);
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap1 = immutableSortedMap2;
    try {
      while (indexCursor.next()) {
        Document document = (Document)this.localDocuments.getDocument(indexCursor.getDocumentKey());
        if (paramQuery.matches(document))
          immutableSortedMap1 = immutableSortedMap1.insert(indexCursor.getDocumentKey(), document); 
      } 
      return immutableSortedMap1;
    } finally {
      indexCursor.close();
    } 
  }
  
  public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query paramQuery, SnapshotVersion paramSnapshotVersion, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet) {
    ImmutableSortedMap<DocumentKey, Document> immutableSortedMap;
    boolean bool;
    if (this.localDocuments != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "setLocalDocumentsView() not called", new Object[0]);
    if (paramQuery.isDocumentQuery()) {
      immutableSortedMap = this.localDocuments.getDocumentsMatchingQuery(paramQuery, SnapshotVersion.NONE);
    } else {
      immutableSortedMap = performCollectionQuery((Query)immutableSortedMap);
    } 
    return immutableSortedMap;
  }
  
  public void handleDocumentChange(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2) {
    throw new RuntimeException("Not yet implemented.");
  }
  
  public void setLocalDocumentsView(LocalDocumentsView paramLocalDocumentsView) {
    this.localDocuments = paramLocalDocumentsView;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\IndexedQueryEngine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */