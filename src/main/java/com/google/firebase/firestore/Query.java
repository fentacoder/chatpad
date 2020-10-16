package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.QueryListener;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class Query {
  final FirebaseFirestore firestore;
  
  final Query query;
  
  Query(Query paramQuery, FirebaseFirestore paramFirebaseFirestore) {
    this.query = (Query)Preconditions.checkNotNull(paramQuery);
    this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(paramFirebaseFirestore);
  }
  
  private ListenerRegistration addSnapshotListenerInternal(Executor paramExecutor, EventManager.ListenOptions paramListenOptions, Activity paramActivity, EventListener<QuerySnapshot> paramEventListener) {
    validateHasExplicitOrderByForLimitToLast();
    AsyncEventListener asyncEventListener = new AsyncEventListener(paramExecutor, Query$$Lambda$3.lambdaFactory$(this, paramEventListener));
    QueryListener queryListener = this.firestore.getClient().listen(this.query, paramListenOptions, (EventListener)asyncEventListener);
    return ActivityScope.bind(paramActivity, (ListenerRegistration)new ListenerRegistrationImpl(this.firestore.getClient(), queryListener, asyncEventListener));
  }
  
  private Bound boundFromDocumentSnapshot(String paramString, DocumentSnapshot paramDocumentSnapshot, boolean paramBoolean) {
    Preconditions.checkNotNull(paramDocumentSnapshot, "Provided snapshot must not be null.");
    if (paramDocumentSnapshot.exists()) {
      Document document = paramDocumentSnapshot.getDocument();
      ArrayList<ReferenceValue> arrayList = new ArrayList();
      for (OrderBy orderBy : this.query.getOrderBy()) {
        if (orderBy.getField().equals(FieldPath.KEY_PATH)) {
          arrayList.add(ReferenceValue.valueOf(this.firestore.getDatabaseId(), document.getKey()));
          continue;
        } 
        FieldValue fieldValue = document.getField(orderBy.getField());
        if (!(fieldValue instanceof com.google.firebase.firestore.model.value.ServerTimestampValue)) {
          if (fieldValue != null) {
            arrayList.add(fieldValue);
            continue;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Invalid query. You are trying to start or end a query using a document for which the field '");
          stringBuilder2.append(orderBy.getField());
          stringBuilder2.append("' (used as the orderBy) does not exist.");
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Invalid query. You are trying to start or end a query using a document for which the field '");
        stringBuilder1.append(orderBy.getField());
        stringBuilder1.append("' is an uncommitted server timestamp. (Since the value of this field is unknown, you cannot start/end a query with it.)");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      return new Bound(arrayList, paramBoolean);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't use a DocumentSnapshot for a document that doesn't exist for ");
    stringBuilder.append((String)orderBy);
    stringBuilder.append("().");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Bound boundFromFields(String paramString, Object[] paramArrayOfObject, boolean paramBoolean) {
    List<OrderBy> list = this.query.getExplicitOrderBy();
    if (paramArrayOfObject.length <= list.size()) {
      ArrayList<ReferenceValue> arrayList = new ArrayList();
      for (byte b = 0; b < paramArrayOfObject.length; b++) {
        Object object = paramArrayOfObject[b];
        if (((OrderBy)list.get(b)).getField().equals(FieldPath.KEY_PATH)) {
          if (object instanceof String) {
            object = object;
            if (this.query.isCollectionGroupQuery() || !object.contains("/")) {
              object = this.query.getPath().append((BasePath)ResourcePath.fromString((String)object));
              if (DocumentKey.isDocumentKey((ResourcePath)object)) {
                object = DocumentKey.fromPath((ResourcePath)object);
                arrayList.add(ReferenceValue.valueOf(this.firestore.getDatabaseId(), (DocumentKey)object));
              } else {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to ");
                stringBuilder1.append(paramString);
                stringBuilder1.append("() must result in a valid document path, but '");
                stringBuilder1.append(object);
                stringBuilder1.append("' is not because it contains an odd number of segments.");
                throw new IllegalArgumentException(stringBuilder1.toString());
              } 
            } else {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to ");
              stringBuilder1.append(paramString);
              stringBuilder1.append("() must be a plain document ID, but '");
              stringBuilder1.append((String)object);
              stringBuilder1.append("' contains a slash.");
              throw new IllegalArgumentException(stringBuilder1.toString());
            } 
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Invalid query. Expected a string for document ID in ");
            stringBuilder1.append(paramString);
            stringBuilder1.append("(), but got ");
            stringBuilder1.append(object);
            stringBuilder1.append(".");
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
        } else {
          arrayList.add(this.firestore.getDataConverter().parseQueryValue(object));
        } 
      } 
      return new Bound(arrayList, paramBoolean);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Too many arguments provided to ");
    stringBuilder.append(paramString);
    stringBuilder.append("(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Task<QuerySnapshot> getViaSnapshotListener(Source paramSource) {
    TaskCompletionSource taskCompletionSource1 = new TaskCompletionSource();
    TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
    EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
    listenOptions.includeDocumentMetadataChanges = true;
    listenOptions.includeQueryMetadataChanges = true;
    listenOptions.waitForSyncWhenOnline = true;
    taskCompletionSource2.setResult(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, null, Query$$Lambda$2.lambdaFactory$(taskCompletionSource1, taskCompletionSource2, paramSource)));
    return taskCompletionSource1.getTask();
  }
  
  private static EventManager.ListenOptions internalOptions(MetadataChanges paramMetadataChanges) {
    boolean bool2;
    EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
    MetadataChanges metadataChanges = MetadataChanges.INCLUDE;
    boolean bool1 = true;
    if (paramMetadataChanges == metadataChanges) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    listenOptions.includeDocumentMetadataChanges = bool2;
    if (paramMetadataChanges == MetadataChanges.INCLUDE) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    listenOptions.includeQueryMetadataChanges = bool2;
    listenOptions.waitForSyncWhenOnline = false;
    return listenOptions;
  }
  
  private Query orderBy(FieldPath paramFieldPath, Direction paramDirection) {
    Preconditions.checkNotNull(paramDirection, "Provided direction must not be null.");
    if (this.query.getStartAt() == null) {
      if (this.query.getEndAt() == null) {
        OrderBy.Direction direction;
        validateOrderByField(paramFieldPath);
        if (paramDirection == Direction.ASCENDING) {
          direction = OrderBy.Direction.ASCENDING;
        } else {
          direction = OrderBy.Direction.DESCENDING;
        } 
        return new Query(this.query.orderBy(OrderBy.getInstance(direction, paramFieldPath)), this.firestore);
      } 
      throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
    } 
    throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
  }
  
  private ReferenceValue parseDocumentIdValue(Object paramObject) {
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (!str.isEmpty()) {
        ResourcePath resourcePath;
        if (this.query.isCollectionGroupQuery() || !str.contains("/")) {
          resourcePath = (ResourcePath)this.query.getPath().append((BasePath)ResourcePath.fromString(str));
          if (DocumentKey.isDocumentKey(resourcePath))
            return ReferenceValue.valueOf(getFirestore().getDatabaseId(), DocumentKey.fromPath(resourcePath)); 
          paramObject = new StringBuilder();
          paramObject.append("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '");
          paramObject.append(resourcePath);
          paramObject.append("' is not because it has an odd number of segments (");
          paramObject.append(resourcePath.length());
          paramObject.append(").");
          throw new IllegalArgumentException(paramObject.toString());
        } 
        paramObject = new StringBuilder();
        paramObject.append("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '");
        paramObject.append((String)resourcePath);
        paramObject.append("' contains a '/' character.");
        throw new IllegalArgumentException(paramObject.toString());
      } 
      throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
    } 
    if (paramObject instanceof DocumentReference) {
      paramObject = paramObject;
      return ReferenceValue.valueOf(getFirestore().getDatabaseId(), paramObject.getKey());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: ");
    stringBuilder.append(Util.typeName(paramObject));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private void validateDisjunctiveFilterElements(Object paramObject, Filter.Operator paramOperator) {
    if (paramObject instanceof List) {
      paramObject = paramObject;
      if (paramObject.size() != 0) {
        if (paramObject.size() <= 10) {
          if (!paramObject.contains(null)) {
            if (!paramObject.contains(Double.valueOf(Double.NaN)) && !paramObject.contains(Float.valueOf(Float.NaN)))
              return; 
            paramObject = new StringBuilder();
            paramObject.append("Invalid Query. '");
            paramObject.append(paramOperator.toString());
            paramObject.append("' filters cannot contain 'NaN' in the value array.");
            throw new IllegalArgumentException(paramObject.toString());
          } 
          paramObject = new StringBuilder();
          paramObject.append("Invalid Query. '");
          paramObject.append(paramOperator.toString());
          paramObject.append("' filters cannot contain 'null' in the value array.");
          throw new IllegalArgumentException(paramObject.toString());
        } 
        paramObject = new StringBuilder();
        paramObject.append("Invalid Query. '");
        paramObject.append(paramOperator.toString());
        paramObject.append("' filters support a maximum of 10 elements in the value array.");
        throw new IllegalArgumentException(paramObject.toString());
      } 
    } 
    paramObject = new StringBuilder();
    paramObject.append("Invalid Query. A non-empty array is required for '");
    paramObject.append(paramOperator.toString());
    paramObject.append("' filters.");
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  private void validateHasExplicitOrderByForLimitToLast() {
    if (!this.query.hasLimitToLast() || !this.query.getExplicitOrderBy().isEmpty())
      return; 
    throw new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
  }
  
  private void validateNewFilter(Filter paramFilter) {
    if (paramFilter instanceof FieldFilter) {
      FieldPath fieldPath;
      FieldFilter fieldFilter = (FieldFilter)paramFilter;
      Filter.Operator operator = fieldFilter.getOperator();
      List<Filter.Operator> list1 = Arrays.asList(new Filter.Operator[] { Filter.Operator.ARRAY_CONTAINS, Filter.Operator.ARRAY_CONTAINS_ANY });
      List<Filter.Operator> list2 = Arrays.asList(new Filter.Operator[] { Filter.Operator.ARRAY_CONTAINS_ANY, Filter.Operator.IN });
      boolean bool1 = list1.contains(operator);
      boolean bool2 = list2.contains(operator);
      if (fieldFilter.isInequality()) {
        fieldPath = this.query.inequalityField();
        FieldPath fieldPath1 = paramFilter.getField();
        if (fieldPath == null || fieldPath.equals(fieldPath1)) {
          fieldPath = this.query.getFirstOrderByField();
          if (fieldPath != null)
            validateOrderByFieldMatchesInequality(fieldPath, fieldPath1); 
          return;
        } 
        throw new IllegalArgumentException(String.format("All where filters other than whereEqualTo() must be on the same field. But you have filters on '%s' and '%s'", new Object[] { fieldPath.canonicalString(), fieldPath1.canonicalString() }));
      } 
      if (bool2 || bool1) {
        Filter.Operator operator1;
        paramFilter = null;
        if (bool2)
          operator1 = this.query.findFilterOperator((List)fieldPath); 
        Filter.Operator operator2 = operator1;
        if (operator1 == null) {
          operator2 = operator1;
          if (bool1)
            operator2 = this.query.findFilterOperator(list1); 
        } 
        if (operator2 != null) {
          if (operator2 == operator) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Invalid Query. You cannot use more than one '");
            stringBuilder1.append(operator.toString());
            stringBuilder1.append("' filter.");
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid Query. You cannot use '");
          stringBuilder.append(operator.toString());
          stringBuilder.append("' filters with '");
          stringBuilder.append(operator2.toString());
          stringBuilder.append("' filters.");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } 
    } 
  }
  
  private void validateOrderByField(FieldPath paramFieldPath) {
    FieldPath fieldPath = this.query.inequalityField();
    if (this.query.getFirstOrderByField() == null && fieldPath != null)
      validateOrderByFieldMatchesInequality(paramFieldPath, fieldPath); 
  }
  
  private void validateOrderByFieldMatchesInequality(FieldPath paramFieldPath1, FieldPath paramFieldPath2) {
    if (paramFieldPath1.equals(paramFieldPath2))
      return; 
    String str = paramFieldPath2.canonicalString();
    throw new IllegalArgumentException(String.format("Invalid query. You have an inequality where filter (whereLessThan(), whereGreaterThan(), etc.) on field '%s' and so you must also have '%s' as your first orderBy() field, but your first orderBy() is currently on field '%s' instead.", new Object[] { str, str, paramFieldPath1.canonicalString() }));
  }
  
  private Query whereHelper(FieldPath paramFieldPath, Filter.Operator paramOperator, Object paramObject) {
    StringBuilder stringBuilder;
    Preconditions.checkNotNull(paramFieldPath, "Provided field path must not be null.");
    Preconditions.checkNotNull(paramOperator, "Provided op must not be null.");
    if (paramFieldPath.getInternalPath().isKeyField()) {
      if (paramOperator != Filter.Operator.ARRAY_CONTAINS && paramOperator != Filter.Operator.ARRAY_CONTAINS_ANY) {
        if (paramOperator == Filter.Operator.IN) {
          validateDisjunctiveFilterElements(paramObject, paramOperator);
          ArrayList<ReferenceValue> arrayList = new ArrayList();
          paramObject = ((List)paramObject).iterator();
          while (paramObject.hasNext())
            arrayList.add(parseDocumentIdValue(paramObject.next())); 
          paramObject = ArrayValue.fromList(arrayList);
        } else {
          paramObject = parseDocumentIdValue(paramObject);
        } 
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid query. You can't perform '");
        stringBuilder.append(paramOperator.toString());
        stringBuilder.append("' queries on FieldPath.documentId().");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } else {
      boolean bool;
      if (paramOperator == Filter.Operator.IN || paramOperator == Filter.Operator.ARRAY_CONTAINS_ANY)
        validateDisjunctiveFilterElements(paramObject, paramOperator); 
      UserDataConverter userDataConverter = this.firestore.getDataConverter();
      if (paramOperator == Filter.Operator.IN) {
        bool = true;
      } else {
        bool = false;
      } 
      paramObject = userDataConverter.parseQueryValue(paramObject, bool);
    } 
    FieldFilter fieldFilter = FieldFilter.create(stringBuilder.getInternalPath(), paramOperator, (FieldValue)paramObject);
    validateNewFilter((Filter)fieldFilter);
    return new Query(this.query.filter((Filter)fieldFilter), this.firestore);
  }
  
  public ListenerRegistration addSnapshotListener(Activity paramActivity, EventListener<QuerySnapshot> paramEventListener) {
    return addSnapshotListener(paramActivity, MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Activity paramActivity, MetadataChanges paramMetadataChanges, EventListener<QuerySnapshot> paramEventListener) {
    Preconditions.checkNotNull(paramActivity, "Provided activity must not be null.");
    Preconditions.checkNotNull(paramMetadataChanges, "Provided MetadataChanges value must not be null.");
    Preconditions.checkNotNull(paramEventListener, "Provided EventListener must not be null.");
    return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, internalOptions(paramMetadataChanges), paramActivity, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(EventListener<QuerySnapshot> paramEventListener) {
    return addSnapshotListener(MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(MetadataChanges paramMetadataChanges, EventListener<QuerySnapshot> paramEventListener) {
    return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, paramMetadataChanges, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Executor paramExecutor, EventListener<QuerySnapshot> paramEventListener) {
    return addSnapshotListener(paramExecutor, MetadataChanges.EXCLUDE, paramEventListener);
  }
  
  public ListenerRegistration addSnapshotListener(Executor paramExecutor, MetadataChanges paramMetadataChanges, EventListener<QuerySnapshot> paramEventListener) {
    Preconditions.checkNotNull(paramExecutor, "Provided executor must not be null.");
    Preconditions.checkNotNull(paramMetadataChanges, "Provided MetadataChanges value must not be null.");
    Preconditions.checkNotNull(paramEventListener, "Provided EventListener must not be null.");
    return addSnapshotListenerInternal(paramExecutor, internalOptions(paramMetadataChanges), null, paramEventListener);
  }
  
  public Query endAt(DocumentSnapshot paramDocumentSnapshot) {
    Bound bound = boundFromDocumentSnapshot("endAt", paramDocumentSnapshot, false);
    return new Query(this.query.endAt(bound), this.firestore);
  }
  
  public Query endAt(Object... paramVarArgs) {
    Bound bound = boundFromFields("endAt", paramVarArgs, false);
    return new Query(this.query.endAt(bound), this.firestore);
  }
  
  public Query endBefore(DocumentSnapshot paramDocumentSnapshot) {
    Bound bound = boundFromDocumentSnapshot("endBefore", paramDocumentSnapshot, true);
    return new Query(this.query.endAt(bound), this.firestore);
  }
  
  public Query endBefore(Object... paramVarArgs) {
    Bound bound = boundFromFields("endBefore", paramVarArgs, true);
    return new Query(this.query.endAt(bound), this.firestore);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Query))
      return false; 
    paramObject = paramObject;
    if (!this.query.equals(((Query)paramObject).query) || !this.firestore.equals(((Query)paramObject).firestore))
      bool = false; 
    return bool;
  }
  
  public Task<QuerySnapshot> get() {
    return get(Source.DEFAULT);
  }
  
  public Task<QuerySnapshot> get(Source paramSource) {
    validateHasExplicitOrderByForLimitToLast();
    return (paramSource == Source.CACHE) ? this.firestore.getClient().getDocumentsFromLocalCache(this.query).continueWith(Executors.DIRECT_EXECUTOR, Query$$Lambda$1.lambdaFactory$(this)) : getViaSnapshotListener(paramSource);
  }
  
  public FirebaseFirestore getFirestore() {
    return this.firestore;
  }
  
  public int hashCode() {
    return this.query.hashCode() * 31 + this.firestore.hashCode();
  }
  
  public Query limit(long paramLong) {
    if (paramLong > 0L)
      return new Query(this.query.limitToFirst(paramLong), this.firestore); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid Query. Query limit (");
    stringBuilder.append(paramLong);
    stringBuilder.append(") is invalid. Limit must be positive.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Query limitToLast(long paramLong) {
    if (paramLong > 0L)
      return new Query(this.query.limitToLast(paramLong), this.firestore); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid Query. Query limitToLast (");
    stringBuilder.append(paramLong);
    stringBuilder.append(") is invalid. Limit must be positive.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Query orderBy(FieldPath paramFieldPath) {
    Preconditions.checkNotNull(paramFieldPath, "Provided field path must not be null.");
    return orderBy(paramFieldPath.getInternalPath(), Direction.ASCENDING);
  }
  
  public Query orderBy(FieldPath paramFieldPath, Direction paramDirection) {
    Preconditions.checkNotNull(paramFieldPath, "Provided field path must not be null.");
    return orderBy(paramFieldPath.getInternalPath(), paramDirection);
  }
  
  public Query orderBy(String paramString) {
    return orderBy(FieldPath.fromDotSeparatedPath(paramString), Direction.ASCENDING);
  }
  
  public Query orderBy(String paramString, Direction paramDirection) {
    return orderBy(FieldPath.fromDotSeparatedPath(paramString), paramDirection);
  }
  
  public Query startAfter(DocumentSnapshot paramDocumentSnapshot) {
    Bound bound = boundFromDocumentSnapshot("startAfter", paramDocumentSnapshot, false);
    return new Query(this.query.startAt(bound), this.firestore);
  }
  
  public Query startAfter(Object... paramVarArgs) {
    Bound bound = boundFromFields("startAfter", paramVarArgs, false);
    return new Query(this.query.startAt(bound), this.firestore);
  }
  
  public Query startAt(DocumentSnapshot paramDocumentSnapshot) {
    Bound bound = boundFromDocumentSnapshot("startAt", paramDocumentSnapshot, true);
    return new Query(this.query.startAt(bound), this.firestore);
  }
  
  public Query startAt(Object... paramVarArgs) {
    Bound bound = boundFromFields("startAt", paramVarArgs, true);
    return new Query(this.query.startAt(bound), this.firestore);
  }
  
  public Query whereArrayContains(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.ARRAY_CONTAINS, paramObject);
  }
  
  public Query whereArrayContains(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.ARRAY_CONTAINS, paramObject);
  }
  
  public Query whereArrayContainsAny(FieldPath paramFieldPath, List<? extends Object> paramList) {
    return whereHelper(paramFieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, paramList);
  }
  
  public Query whereArrayContainsAny(String paramString, List<? extends Object> paramList) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.ARRAY_CONTAINS_ANY, paramList);
  }
  
  public Query whereEqualTo(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.EQUAL, paramObject);
  }
  
  public Query whereEqualTo(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.EQUAL, paramObject);
  }
  
  public Query whereGreaterThan(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.GREATER_THAN, paramObject);
  }
  
  public Query whereGreaterThan(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.GREATER_THAN, paramObject);
  }
  
  public Query whereGreaterThanOrEqualTo(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.GREATER_THAN_OR_EQUAL, paramObject);
  }
  
  public Query whereGreaterThanOrEqualTo(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.GREATER_THAN_OR_EQUAL, paramObject);
  }
  
  public Query whereIn(FieldPath paramFieldPath, List<? extends Object> paramList) {
    return whereHelper(paramFieldPath, Filter.Operator.IN, paramList);
  }
  
  public Query whereIn(String paramString, List<? extends Object> paramList) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.IN, paramList);
  }
  
  public Query whereLessThan(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.LESS_THAN, paramObject);
  }
  
  public Query whereLessThan(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.LESS_THAN, paramObject);
  }
  
  public Query whereLessThanOrEqualTo(FieldPath paramFieldPath, Object paramObject) {
    return whereHelper(paramFieldPath, Filter.Operator.LESS_THAN_OR_EQUAL, paramObject);
  }
  
  public Query whereLessThanOrEqualTo(String paramString, Object paramObject) {
    return whereHelper(FieldPath.fromDotSeparatedPath(paramString), Filter.Operator.LESS_THAN_OR_EQUAL, paramObject);
  }
  
  public enum Direction {
    ASCENDING, DESCENDING;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\Query.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */