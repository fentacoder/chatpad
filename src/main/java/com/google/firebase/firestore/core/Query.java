package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class Query {
  private static final OrderBy KEY_ORDERING_ASC = OrderBy.getInstance(OrderBy.Direction.ASCENDING, FieldPath.KEY_PATH);
  
  private static final OrderBy KEY_ORDERING_DESC = OrderBy.getInstance(OrderBy.Direction.DESCENDING, FieldPath.KEY_PATH);
  
  private final String collectionGroup;
  
  private final Bound endAt;
  
  private final List<OrderBy> explicitSortOrder;
  
  private final List<Filter> filters;
  
  private final long limit;
  
  private final LimitType limitType;
  
  private List<OrderBy> memoizedOrderBy;
  
  private Target memoizedTarget;
  
  private final ResourcePath path;
  
  private final Bound startAt;
  
  public Query(ResourcePath paramResourcePath, String paramString) {
    this(paramResourcePath, paramString, Collections.emptyList(), Collections.emptyList(), -1L, LimitType.LIMIT_TO_FIRST, null, null);
  }
  
  public Query(ResourcePath paramResourcePath, String paramString, List<Filter> paramList, List<OrderBy> paramList1, long paramLong, LimitType paramLimitType, Bound paramBound1, Bound paramBound2) {
    this.path = paramResourcePath;
    this.collectionGroup = paramString;
    this.explicitSortOrder = paramList1;
    this.filters = paramList;
    this.limit = paramLong;
    this.limitType = paramLimitType;
    this.startAt = paramBound1;
    this.endAt = paramBound2;
  }
  
  public static Query atPath(ResourcePath paramResourcePath) {
    return new Query(paramResourcePath, null);
  }
  
  private boolean matchesBounds(Document paramDocument) {
    Bound bound = this.startAt;
    if (bound != null && !bound.sortsBeforeDocument(getOrderBy(), paramDocument))
      return false; 
    bound = this.endAt;
    return !(bound != null && bound.sortsBeforeDocument(getOrderBy(), paramDocument));
  }
  
  private boolean matchesFilters(Document paramDocument) {
    Iterator<Filter> iterator = this.filters.iterator();
    while (iterator.hasNext()) {
      if (!((Filter)iterator.next()).matches(paramDocument))
        return false; 
    } 
    return true;
  }
  
  private boolean matchesOrderBy(Document paramDocument) {
    for (OrderBy orderBy : this.explicitSortOrder) {
      if (!orderBy.getField().equals(FieldPath.KEY_PATH) && paramDocument.getField(orderBy.field) == null)
        return false; 
    } 
    return true;
  }
  
  private boolean matchesPathAndCollectionGroup(Document paramDocument) {
    ResourcePath resourcePath = paramDocument.getKey().getPath();
    String str = this.collectionGroup;
    boolean bool1 = false;
    boolean bool2 = false;
    if (str != null) {
      boolean bool = bool2;
      if (paramDocument.getKey().hasCollectionId(this.collectionGroup)) {
        bool = bool2;
        if (this.path.isPrefixOf((BasePath)resourcePath))
          bool = true; 
      } 
      return bool;
    } 
    if (DocumentKey.isDocumentKey(this.path))
      return this.path.equals(resourcePath); 
    boolean bool3 = bool1;
    if (this.path.isPrefixOf((BasePath)resourcePath)) {
      bool3 = bool1;
      if (this.path.length() == resourcePath.length() - 1)
        bool3 = true; 
    } 
    return bool3;
  }
  
  public Query asCollectionQueryAtPath(ResourcePath paramResourcePath) {
    return new Query(paramResourcePath, null, this.filters, this.explicitSortOrder, this.limit, this.limitType, this.startAt, this.endAt);
  }
  
  public Comparator<Document> comparator() {
    return new QueryComparator(getOrderBy());
  }
  
  public Query endAt(Bound paramBound) {
    return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, this.limitType, this.startAt, paramBound);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (this.limitType != ((Query)paramObject).limitType) ? false : toTarget().equals(paramObject.toTarget());
  }
  
  public Query filter(Filter paramFilter) {
    boolean bool = isDocumentQuery();
    boolean bool1 = true;
    Assert.hardAssert(bool ^ true, "No filter is allowed for document query", new Object[0]);
    FieldPath fieldPath1 = null;
    FieldPath fieldPath2 = fieldPath1;
    if (paramFilter instanceof FieldFilter) {
      fieldPath2 = fieldPath1;
      if (((FieldFilter)paramFilter).isInequality())
        fieldPath2 = paramFilter.getField(); 
    } 
    fieldPath1 = inequalityField();
    if (fieldPath1 == null || fieldPath2 == null || fieldPath1.equals(fieldPath2)) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Query must only have one inequality field", new Object[0]);
    bool = bool1;
    if (!this.explicitSortOrder.isEmpty()) {
      bool = bool1;
      if (fieldPath2 != null)
        if (((OrderBy)this.explicitSortOrder.get(0)).field.equals(fieldPath2)) {
          bool = bool1;
        } else {
          bool = false;
        }  
    } 
    Assert.hardAssert(bool, "First orderBy must match inequality field", new Object[0]);
    ArrayList<Filter> arrayList = new ArrayList<>(this.filters);
    arrayList.add(paramFilter);
    return new Query(this.path, this.collectionGroup, arrayList, this.explicitSortOrder, this.limit, this.limitType, this.startAt, this.endAt);
  }
  
  public Filter.Operator findFilterOperator(List<Filter.Operator> paramList) {
    for (Filter filter : this.filters) {
      if (filter instanceof FieldFilter) {
        Filter.Operator operator = ((FieldFilter)filter).getOperator();
        if (paramList.contains(operator))
          return operator; 
      } 
    } 
    return null;
  }
  
  public String getCanonicalId() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(toTarget().getCanonicalId());
    stringBuilder.append("|lt:");
    stringBuilder.append(this.limitType);
    return stringBuilder.toString();
  }
  
  public String getCollectionGroup() {
    return this.collectionGroup;
  }
  
  public Bound getEndAt() {
    return this.endAt;
  }
  
  public List<OrderBy> getExplicitOrderBy() {
    return this.explicitSortOrder;
  }
  
  public List<Filter> getFilters() {
    return this.filters;
  }
  
  public FieldPath getFirstOrderByField() {
    return this.explicitSortOrder.isEmpty() ? null : ((OrderBy)this.explicitSortOrder.get(0)).getField();
  }
  
  public long getLimitToFirst() {
    Assert.hardAssert(hasLimitToFirst(), "Called getLimitToFirst when no limit was set", new Object[0]);
    return this.limit;
  }
  
  public long getLimitToLast() {
    Assert.hardAssert(hasLimitToLast(), "Called getLimitToLast when no limit was set", new Object[0]);
    return this.limit;
  }
  
  public LimitType getLimitType() {
    if (hasLimitToLast() || hasLimitToFirst()) {
      boolean bool1 = true;
      Assert.hardAssert(bool1, "Called getLimitType when no limit was set", new Object[0]);
      return this.limitType;
    } 
    boolean bool = false;
    Assert.hardAssert(bool, "Called getLimitType when no limit was set", new Object[0]);
    return this.limitType;
  }
  
  public List<OrderBy> getOrderBy() {
    if (this.memoizedOrderBy == null) {
      FieldPath fieldPath1 = inequalityField();
      FieldPath fieldPath2 = getFirstOrderByField();
      boolean bool = false;
      if (fieldPath1 != null && fieldPath2 == null) {
        if (fieldPath1.isKeyField()) {
          this.memoizedOrderBy = Collections.singletonList(KEY_ORDERING_ASC);
        } else {
          this.memoizedOrderBy = Arrays.asList(new OrderBy[] { OrderBy.getInstance(OrderBy.Direction.ASCENDING, fieldPath1), KEY_ORDERING_ASC });
        } 
      } else {
        ArrayList<OrderBy> arrayList = new ArrayList();
        for (OrderBy orderBy : this.explicitSortOrder) {
          arrayList.add(orderBy);
          if (orderBy.getField().equals(FieldPath.KEY_PATH))
            bool = true; 
        } 
        if (!bool) {
          OrderBy.Direction direction;
          OrderBy orderBy;
          if (this.explicitSortOrder.size() > 0) {
            List<OrderBy> list = this.explicitSortOrder;
            direction = ((OrderBy)list.get(list.size() - 1)).getDirection();
          } else {
            direction = OrderBy.Direction.ASCENDING;
          } 
          if (direction.equals(OrderBy.Direction.ASCENDING)) {
            orderBy = KEY_ORDERING_ASC;
          } else {
            orderBy = KEY_ORDERING_DESC;
          } 
          arrayList.add(orderBy);
        } 
        this.memoizedOrderBy = arrayList;
      } 
    } 
    return this.memoizedOrderBy;
  }
  
  public ResourcePath getPath() {
    return this.path;
  }
  
  public Bound getStartAt() {
    return this.startAt;
  }
  
  public boolean hasLimitToFirst() {
    boolean bool;
    if (this.limitType == LimitType.LIMIT_TO_FIRST && this.limit != -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasLimitToLast() {
    boolean bool;
    if (this.limitType == LimitType.LIMIT_TO_LAST && this.limit != -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return toTarget().hashCode() * 31 + this.limitType.hashCode();
  }
  
  public FieldPath inequalityField() {
    for (Filter filter : this.filters) {
      if (filter instanceof FieldFilter) {
        filter = filter;
        if (filter.isInequality())
          return filter.getField(); 
      } 
    } 
    return null;
  }
  
  public boolean isCollectionGroupQuery() {
    boolean bool;
    if (this.collectionGroup != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isDocumentQuery() {
    boolean bool;
    if (DocumentKey.isDocumentKey(this.path) && this.collectionGroup == null && this.filters.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Query limitToFirst(long paramLong) {
    return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, paramLong, LimitType.LIMIT_TO_FIRST, this.startAt, this.endAt);
  }
  
  public Query limitToLast(long paramLong) {
    return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, paramLong, LimitType.LIMIT_TO_LAST, this.startAt, this.endAt);
  }
  
  public boolean matches(Document paramDocument) {
    boolean bool;
    if (matchesPathAndCollectionGroup(paramDocument) && matchesOrderBy(paramDocument) && matchesFilters(paramDocument) && matchesBounds(paramDocument)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean matchesAllDocuments() {
    null = this.filters.isEmpty();
    boolean bool = true;
    if (null && this.limit == -1L && this.startAt == null && this.endAt == null) {
      null = bool;
      if (!getExplicitOrderBy().isEmpty()) {
        if (getExplicitOrderBy().size() == 1 && getFirstOrderByField().isKeyField())
          return bool; 
      } else {
        return null;
      } 
    } 
    return false;
  }
  
  public Query orderBy(OrderBy paramOrderBy) {
    Assert.hardAssert(isDocumentQuery() ^ true, "No ordering is allowed for document query", new Object[0]);
    if (this.explicitSortOrder.isEmpty()) {
      FieldPath fieldPath = inequalityField();
      if (fieldPath != null && !fieldPath.equals(paramOrderBy.field))
        throw Assert.fail("First orderBy must match inequality field", new Object[0]); 
    } 
    ArrayList<OrderBy> arrayList = new ArrayList<>(this.explicitSortOrder);
    arrayList.add(paramOrderBy);
    return new Query(this.path, this.collectionGroup, this.filters, arrayList, this.limit, this.limitType, this.startAt, this.endAt);
  }
  
  public Query startAt(Bound paramBound) {
    return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, this.limitType, paramBound, this.endAt);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Query(target=");
    stringBuilder.append(toTarget().toString());
    stringBuilder.append(";limitType=");
    stringBuilder.append(this.limitType.toString());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public Target toTarget() {
    if (this.memoizedTarget == null)
      if (this.limitType == LimitType.LIMIT_TO_FIRST) {
        this.memoizedTarget = new Target(getPath(), getCollectionGroup(), getFilters(), getOrderBy(), this.limit, getStartAt(), getEndAt());
      } else {
        ArrayList<OrderBy> arrayList = new ArrayList();
        for (OrderBy orderBy : getOrderBy()) {
          OrderBy.Direction direction;
          if (orderBy.getDirection() == OrderBy.Direction.DESCENDING) {
            direction = OrderBy.Direction.ASCENDING;
          } else {
            direction = OrderBy.Direction.DESCENDING;
          } 
          arrayList.add(OrderBy.getInstance(direction, orderBy.getField()));
        } 
        Bound bound3 = this.endAt;
        Bound bound1 = null;
        if (bound3 != null) {
          bound3 = new Bound(bound3.getPosition(), this.endAt.isBefore() ^ true);
        } else {
          bound3 = null;
        } 
        Bound bound2 = this.startAt;
        if (bound2 != null)
          bound1 = new Bound(bound2.getPosition(), this.startAt.isBefore() ^ true); 
        this.memoizedTarget = new Target(getPath(), getCollectionGroup(), getFilters(), arrayList, this.limit, bound3, bound1);
      }  
    return this.memoizedTarget;
  }
  
  public enum LimitType {
    LIMIT_TO_FIRST, LIMIT_TO_LAST;
    
    static {
    
    }
  }
  
  private static class QueryComparator implements Comparator<Document> {
    private final List<OrderBy> sortOrder;
    
    QueryComparator(List<OrderBy> param1List) {
      Iterator<OrderBy> iterator = param1List.iterator();
      label15: while (true) {
        boolean bool = false;
        while (iterator.hasNext()) {
          OrderBy orderBy = iterator.next();
          if (bool || orderBy.getField().equals(FieldPath.KEY_PATH)) {
            bool = true;
            continue;
          } 
          continue label15;
        } 
        if (bool) {
          this.sortOrder = param1List;
          return;
        } 
        throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
      } 
    }
    
    public int compare(Document param1Document1, Document param1Document2) {
      Iterator<OrderBy> iterator = this.sortOrder.iterator();
      while (iterator.hasNext()) {
        int i = ((OrderBy)iterator.next()).compare(param1Document1, param1Document2);
        if (i != 0)
          return i; 
      } 
      return 0;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\Query.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */