package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;
import java.util.List;

public final class Target {
  public static final long NO_LIMIT = -1L;
  
  private final String collectionGroup;
  
  private final Bound endAt;
  
  private final List<Filter> filters;
  
  private final long limit;
  
  private String memoizedCannonicalId;
  
  private final List<OrderBy> orderBy;
  
  private final ResourcePath path;
  
  private final Bound startAt;
  
  Target(ResourcePath paramResourcePath, String paramString, List<Filter> paramList, List<OrderBy> paramList1, long paramLong, Bound paramBound1, Bound paramBound2) {
    this.path = paramResourcePath;
    this.collectionGroup = paramString;
    this.orderBy = paramList1;
    this.filters = paramList;
    this.limit = paramLong;
    this.startAt = paramBound1;
    this.endAt = paramBound2;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.collectionGroup;
    if ((str != null) ? !str.equals(((Target)paramObject).collectionGroup) : (((Target)paramObject).collectionGroup != null))
      return false; 
    if (this.limit != ((Target)paramObject).limit)
      return false; 
    if (!this.orderBy.equals(((Target)paramObject).orderBy))
      return false; 
    if (!this.filters.equals(((Target)paramObject).filters))
      return false; 
    if (!this.path.equals(((Target)paramObject).path))
      return false; 
    Bound bound = this.startAt;
    if ((bound != null) ? !bound.equals(((Target)paramObject).startAt) : (((Target)paramObject).startAt != null))
      return false; 
    bound = this.endAt;
    paramObject = ((Target)paramObject).endAt;
    if (bound != null) {
      bool = bound.equals(paramObject);
    } else if (paramObject != null) {
      bool = false;
    } 
    return bool;
  }
  
  public String getCanonicalId() {
    String str = this.memoizedCannonicalId;
    if (str != null)
      return str; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getPath().canonicalString());
    if (this.collectionGroup != null) {
      stringBuilder.append("|cg:");
      stringBuilder.append(this.collectionGroup);
    } 
    stringBuilder.append("|f:");
    Iterator<Filter> iterator = getFilters().iterator();
    while (iterator.hasNext())
      stringBuilder.append(((Filter)iterator.next()).getCanonicalId()); 
    stringBuilder.append("|ob:");
    for (OrderBy orderBy : getOrderBy()) {
      String str1;
      stringBuilder.append(orderBy.getField().canonicalString());
      if (orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
        str1 = "asc";
      } else {
        str1 = "desc";
      } 
      stringBuilder.append(str1);
    } 
    if (hasLimit()) {
      stringBuilder.append("|l:");
      stringBuilder.append(getLimit());
    } 
    if (this.startAt != null) {
      stringBuilder.append("|lb:");
      stringBuilder.append(this.startAt.canonicalString());
    } 
    if (this.endAt != null) {
      stringBuilder.append("|ub:");
      stringBuilder.append(this.endAt.canonicalString());
    } 
    this.memoizedCannonicalId = stringBuilder.toString();
    return this.memoizedCannonicalId;
  }
  
  public String getCollectionGroup() {
    return this.collectionGroup;
  }
  
  public Bound getEndAt() {
    return this.endAt;
  }
  
  public List<Filter> getFilters() {
    return this.filters;
  }
  
  public long getLimit() {
    Assert.hardAssert(hasLimit(), "Called getLimit when no limit was set", new Object[0]);
    return this.limit;
  }
  
  public List<OrderBy> getOrderBy() {
    return this.orderBy;
  }
  
  public ResourcePath getPath() {
    return this.path;
  }
  
  public Bound getStartAt() {
    return this.startAt;
  }
  
  public boolean hasLimit() {
    boolean bool;
    if (this.limit != -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    byte b1;
    byte b2;
    int i = this.orderBy.hashCode();
    String str = this.collectionGroup;
    int j = 0;
    if (str != null) {
      b1 = str.hashCode();
    } else {
      b1 = 0;
    } 
    int k = this.filters.hashCode();
    int m = this.path.hashCode();
    long l = this.limit;
    int n = (int)(l ^ l >>> 32L);
    Bound bound = this.startAt;
    if (bound != null) {
      b2 = bound.hashCode();
    } else {
      b2 = 0;
    } 
    bound = this.endAt;
    if (bound != null)
      j = bound.hashCode(); 
    return (((((i * 31 + b1) * 31 + k) * 31 + m) * 31 + n) * 31 + b2) * 31 + j;
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
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Query(");
    stringBuilder.append(this.path.canonicalString());
    if (this.collectionGroup != null) {
      stringBuilder.append(" collectionGroup=");
      stringBuilder.append(this.collectionGroup);
    } 
    boolean bool = this.filters.isEmpty();
    byte b = 0;
    if (!bool) {
      stringBuilder.append(" where ");
      for (byte b1 = 0; b1 < this.filters.size(); b1++) {
        if (b1 > 0)
          stringBuilder.append(" and "); 
        stringBuilder.append(((Filter)this.filters.get(b1)).toString());
      } 
    } 
    if (!this.orderBy.isEmpty()) {
      stringBuilder.append(" order by ");
      for (byte b1 = b; b1 < this.orderBy.size(); b1++) {
        if (b1 > 0)
          stringBuilder.append(", "); 
        stringBuilder.append(this.orderBy.get(b1));
      } 
    } 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\Target.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */