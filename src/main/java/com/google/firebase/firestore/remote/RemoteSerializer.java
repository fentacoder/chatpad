package com.google.firebase.firestore.remote;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.BlobValue;
import com.google.firebase.firestore.model.value.BooleanValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.GeoPointValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.StringValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Precondition;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Target;
import com.google.firestore.v1.TargetChange;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import com.google.type.LatLng;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RemoteSerializer {
  private final DatabaseId databaseId;
  
  private final String databaseName;
  
  public RemoteSerializer(DatabaseId paramDatabaseId) {
    this.databaseId = paramDatabaseId;
    this.databaseName = encodedDatabaseId(paramDatabaseId).canonicalString();
  }
  
  private List<FieldValue> decodeArrayTransformElements(ArrayValue paramArrayValue) {
    int i = paramArrayValue.getValuesCount();
    ArrayList<FieldValue> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(decodeValue(paramArrayValue.getValues(b))); 
    return arrayList;
  }
  
  private ArrayValue decodeArrayValue(ArrayValue paramArrayValue) {
    int i = paramArrayValue.getValuesCount();
    ArrayList<FieldValue> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(decodeValue(paramArrayValue.getValues(b))); 
    return ArrayValue.fromList(arrayList);
  }
  
  private Bound decodeBound(Cursor paramCursor) {
    int i = paramCursor.getValuesCount();
    ArrayList<FieldValue> arrayList = new ArrayList(i);
    for (byte b = 0; b < i; b++)
      arrayList.add(decodeValue(paramCursor.getValues(b))); 
    return new Bound(arrayList, paramCursor.getBefore());
  }
  
  private FieldMask decodeDocumentMask(DocumentMask paramDocumentMask) {
    int i = paramDocumentMask.getFieldPathsCount();
    HashSet<FieldPath> hashSet = new HashSet(i);
    for (byte b = 0; b < i; b++)
      hashSet.add(FieldPath.fromServerFormat(paramDocumentMask.getFieldPaths(b))); 
    return FieldMask.fromSet(hashSet);
  }
  
  private Filter.Operator decodeFieldFilterOperator(StructuredQuery.FieldFilter.Operator paramOperator) {
    switch (paramOperator) {
      default:
        throw Assert.fail("Unhandled FieldFilter.operator %d", new Object[] { paramOperator });
      case null:
        return Filter.Operator.ARRAY_CONTAINS_ANY;
      case null:
        return Filter.Operator.IN;
      case RESPONSETYPE_NOT_SET:
        return Filter.Operator.ARRAY_CONTAINS;
      case FILTER:
        return Filter.Operator.GREATER_THAN;
      case DOCUMENT_REMOVE:
        return Filter.Operator.GREATER_THAN_OR_EQUAL;
      case DOCUMENT_DELETE:
        return Filter.Operator.EQUAL;
      case DOCUMENT_CHANGE:
        return Filter.Operator.LESS_THAN_OR_EQUAL;
      case TARGET_CHANGE:
        break;
    } 
    return Filter.Operator.LESS_THAN;
  }
  
  private FieldTransform decodeFieldTransform(DocumentTransform.FieldTransform paramFieldTransform) {
    boolean bool;
    int i = null.$SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[paramFieldTransform.getTransformTypeCase().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4) {
            FieldValue fieldValue = decodeValue(paramFieldTransform.getIncrement());
            Assert.hardAssert(fieldValue instanceof NumberValue, "Expected NUMERIC_ADD transform to be of number type, but was %s", new Object[] { fieldValue.getClass().getCanonicalName() });
            return new FieldTransform(FieldPath.fromServerFormat(paramFieldTransform.getFieldPath()), (TransformOperation)new NumericIncrementTransformOperation((NumberValue)decodeValue(paramFieldTransform.getIncrement())));
          } 
          throw Assert.fail("Unknown FieldTransform proto: %s", new Object[] { paramFieldTransform });
        } 
        return new FieldTransform(FieldPath.fromServerFormat(paramFieldTransform.getFieldPath()), (TransformOperation)new ArrayTransformOperation.Remove(decodeArrayTransformElements(paramFieldTransform.getRemoveAllFromArray())));
      } 
      return new FieldTransform(FieldPath.fromServerFormat(paramFieldTransform.getFieldPath()), (TransformOperation)new ArrayTransformOperation.Union(decodeArrayTransformElements(paramFieldTransform.getAppendMissingElements())));
    } 
    if (paramFieldTransform.getSetToServerValue() == DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Unknown transform setToServerValue: %s", new Object[] { paramFieldTransform.getSetToServerValue() });
    return new FieldTransform(FieldPath.fromServerFormat(paramFieldTransform.getFieldPath()), (TransformOperation)ServerTimestampOperation.getInstance());
  }
  
  private List<Filter> decodeFilters(StructuredQuery.Filter paramFilter) {
    List<List> list;
    if (paramFilter.getFilterTypeCase() == StructuredQuery.Filter.FilterTypeCase.COMPOSITE_FILTER) {
      boolean bool;
      if (paramFilter.getCompositeFilter().getOp() == StructuredQuery.CompositeFilter.Operator.AND) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Only AND-type composite filters are supported, got %d", new Object[] { paramFilter.getCompositeFilter().getOp() });
      list = paramFilter.getCompositeFilter().getFiltersList();
    } else {
      list = Collections.singletonList(list);
    } 
    ArrayList<Filter> arrayList = new ArrayList(list.size());
    for (StructuredQuery.Filter filter : list) {
      int i = null.$SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[filter.getFilterTypeCase().ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            arrayList.add(decodeUnaryFilter(filter.getUnaryFilter()));
            continue;
          } 
          throw Assert.fail("Unrecognized Filter.filterType %d", new Object[] { filter.getFilterTypeCase() });
        } 
        arrayList.add(decodeFieldFilter(filter.getFieldFilter()));
        continue;
      } 
      throw Assert.fail("Nested composite filters are not supported.", new Object[0]);
    } 
    return arrayList;
  }
  
  private Document decodeFoundDocument(BatchGetDocumentsResponse paramBatchGetDocumentsResponse) {
    Assert.hardAssert(paramBatchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
    DocumentKey documentKey = decodeKey(paramBatchGetDocumentsResponse.getFound().getName());
    SnapshotVersion snapshotVersion = decodeVersion(paramBatchGetDocumentsResponse.getFound().getUpdateTime());
    Assert.hardAssert(snapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Got a document response with no snapshot version", new Object[0]);
    return new Document(documentKey, snapshotVersion, Document.DocumentState.SYNCED, paramBatchGetDocumentsResponse.getFound(), RemoteSerializer$$Lambda$1.lambdaFactory$(this));
  }
  
  private GeoPoint decodeGeoPoint(LatLng paramLatLng) {
    return new GeoPoint(paramLatLng.getLatitude(), paramLatLng.getLongitude());
  }
  
  private ObjectValue decodeMapValue(MapValue paramMapValue) {
    return decodeFields(paramMapValue.getFieldsMap());
  }
  
  private NoDocument decodeMissingDocument(BatchGetDocumentsResponse paramBatchGetDocumentsResponse) {
    Assert.hardAssert(paramBatchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
    DocumentKey documentKey = decodeKey(paramBatchGetDocumentsResponse.getMissing());
    SnapshotVersion snapshotVersion = decodeVersion(paramBatchGetDocumentsResponse.getReadTime());
    Assert.hardAssert(snapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Got a no document response with no snapshot version", new Object[0]);
    return new NoDocument(documentKey, snapshotVersion, false);
  }
  
  private OrderBy decodeOrderBy(StructuredQuery.Order paramOrder) {
    OrderBy.Direction direction;
    FieldPath fieldPath = FieldPath.fromServerFormat(paramOrder.getField().getFieldPath());
    int i = null.$SwitchMap$com$google$firestore$v1$StructuredQuery$Direction[paramOrder.getDirection().ordinal()];
    if (i != 1) {
      if (i == 2) {
        direction = OrderBy.Direction.DESCENDING;
      } else {
        throw Assert.fail("Unrecognized direction %d", new Object[] { direction.getDirection() });
      } 
    } else {
      direction = OrderBy.Direction.ASCENDING;
    } 
    return OrderBy.getInstance(direction, fieldPath);
  }
  
  private Precondition decodePrecondition(Precondition paramPrecondition) {
    int i = null.$SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[paramPrecondition.getConditionTypeCase().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          return Precondition.NONE; 
        throw Assert.fail("Unknown precondition", new Object[0]);
      } 
      return Precondition.exists(paramPrecondition.getExists());
    } 
    return Precondition.updateTime(decodeVersion(paramPrecondition.getUpdateTime()));
  }
  
  private ResourcePath decodeQueryPath(String paramString) {
    ResourcePath resourcePath = decodeResourceName(paramString);
    return (resourcePath.length() == 4) ? ResourcePath.EMPTY : extractLocalPathFromResourceName(resourcePath);
  }
  
  private ResourcePath decodeResourceName(String paramString) {
    ResourcePath resourcePath = ResourcePath.fromString(paramString);
    Assert.hardAssert(isValidResourceName(resourcePath), "Tried to deserialize invalid key %s", new Object[] { resourcePath });
    return resourcePath;
  }
  
  private Filter decodeUnaryFilter(StructuredQuery.UnaryFilter paramUnaryFilter) {
    FieldPath fieldPath = FieldPath.fromServerFormat(paramUnaryFilter.getField().getFieldPath());
    int i = null.$SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[paramUnaryFilter.getOp().ordinal()];
    if (i != 1) {
      if (i == 2)
        return (Filter)FieldFilter.create(fieldPath, Filter.Operator.EQUAL, (FieldValue)NullValue.nullValue()); 
      throw Assert.fail("Unrecognized UnaryFilter.operator %d", new Object[] { paramUnaryFilter.getOp() });
    } 
    return (Filter)FieldFilter.create(fieldPath, Filter.Operator.EQUAL, (FieldValue)DoubleValue.NaN);
  }
  
  private ArrayValue encodeArrayTransformElements(List<FieldValue> paramList) {
    ArrayValue.Builder builder = ArrayValue.newBuilder();
    Iterator<FieldValue> iterator = paramList.iterator();
    while (iterator.hasNext())
      builder.addValues(encodeValue(iterator.next())); 
    return (ArrayValue)builder.build();
  }
  
  private ArrayValue encodeArrayValue(ArrayValue paramArrayValue) {
    List list = paramArrayValue.getInternalValue();
    ArrayValue.Builder builder = ArrayValue.newBuilder();
    Iterator<FieldValue> iterator = list.iterator();
    while (iterator.hasNext())
      builder.addValues(encodeValue(iterator.next())); 
    return (ArrayValue)builder.build();
  }
  
  private Cursor encodeBound(Bound paramBound) {
    Cursor.Builder builder = Cursor.newBuilder();
    builder.setBefore(paramBound.isBefore());
    Iterator<FieldValue> iterator = paramBound.getPosition().iterator();
    while (iterator.hasNext())
      builder.addValues(encodeValue(iterator.next())); 
    return (Cursor)builder.build();
  }
  
  private DocumentMask encodeDocumentMask(FieldMask paramFieldMask) {
    DocumentMask.Builder builder = DocumentMask.newBuilder();
    Iterator<FieldPath> iterator = paramFieldMask.getMask().iterator();
    while (iterator.hasNext())
      builder.addFieldPaths(((FieldPath)iterator.next()).canonicalString()); 
    return (DocumentMask)builder.build();
  }
  
  private StructuredQuery.FieldFilter.Operator encodeFieldFilterOperator(Filter.Operator paramOperator) {
    switch (paramOperator) {
      default:
        throw Assert.fail("Unknown operator %d", new Object[] { paramOperator });
      case null:
        return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY;
      case null:
        return StructuredQuery.FieldFilter.Operator.IN;
      case RESPONSETYPE_NOT_SET:
        return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS;
      case FILTER:
        return StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
      case DOCUMENT_REMOVE:
        return StructuredQuery.FieldFilter.Operator.GREATER_THAN;
      case DOCUMENT_DELETE:
        return StructuredQuery.FieldFilter.Operator.EQUAL;
      case DOCUMENT_CHANGE:
        return StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;
      case TARGET_CHANGE:
        break;
    } 
    return StructuredQuery.FieldFilter.Operator.LESS_THAN;
  }
  
  private StructuredQuery.FieldReference encodeFieldPath(FieldPath paramFieldPath) {
    return (StructuredQuery.FieldReference)StructuredQuery.FieldReference.newBuilder().setFieldPath(paramFieldPath.canonicalString()).build();
  }
  
  private DocumentTransform.FieldTransform encodeFieldTransform(FieldTransform paramFieldTransform) {
    ArrayTransformOperation.Union union;
    ArrayTransformOperation.Remove remove;
    NumericIncrementTransformOperation numericIncrementTransformOperation;
    TransformOperation transformOperation = paramFieldTransform.getOperation();
    if (transformOperation instanceof ServerTimestampOperation)
      return (DocumentTransform.FieldTransform)DocumentTransform.FieldTransform.newBuilder().setFieldPath(paramFieldTransform.getFieldPath().canonicalString()).setSetToServerValue(DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME).build(); 
    if (transformOperation instanceof ArrayTransformOperation.Union) {
      union = (ArrayTransformOperation.Union)transformOperation;
      return (DocumentTransform.FieldTransform)DocumentTransform.FieldTransform.newBuilder().setFieldPath(paramFieldTransform.getFieldPath().canonicalString()).setAppendMissingElements(encodeArrayTransformElements(union.getElements())).build();
    } 
    if (union instanceof ArrayTransformOperation.Remove) {
      remove = (ArrayTransformOperation.Remove)union;
      return (DocumentTransform.FieldTransform)DocumentTransform.FieldTransform.newBuilder().setFieldPath(paramFieldTransform.getFieldPath().canonicalString()).setRemoveAllFromArray(encodeArrayTransformElements(remove.getElements())).build();
    } 
    if (remove instanceof NumericIncrementTransformOperation) {
      numericIncrementTransformOperation = (NumericIncrementTransformOperation)remove;
      return (DocumentTransform.FieldTransform)DocumentTransform.FieldTransform.newBuilder().setFieldPath(paramFieldTransform.getFieldPath().canonicalString()).setIncrement(encodeValue(numericIncrementTransformOperation.getOperand())).build();
    } 
    throw Assert.fail("Unknown transform: %s", new Object[] { numericIncrementTransformOperation });
  }
  
  private StructuredQuery.Filter encodeFilters(List<Filter> paramList) {
    ArrayList<StructuredQuery.Filter> arrayList = new ArrayList(paramList.size());
    for (Filter filter : paramList) {
      if (filter instanceof FieldFilter)
        arrayList.add(encodeUnaryOrFieldFilter((FieldFilter)filter)); 
    } 
    if (paramList.size() == 1)
      return arrayList.get(0); 
    StructuredQuery.CompositeFilter.Builder builder = StructuredQuery.CompositeFilter.newBuilder();
    builder.setOp(StructuredQuery.CompositeFilter.Operator.AND);
    builder.addAllFilters(arrayList);
    return (StructuredQuery.Filter)StructuredQuery.Filter.newBuilder().setCompositeFilter(builder).build();
  }
  
  private LatLng encodeGeoPoint(GeoPoint paramGeoPoint) {
    return (LatLng)LatLng.newBuilder().setLatitude(paramGeoPoint.getLatitude()).setLongitude(paramGeoPoint.getLongitude()).build();
  }
  
  private String encodeLabel(QueryPurpose paramQueryPurpose) {
    int i = null.$SwitchMap$com$google$firebase$firestore$local$QueryPurpose[paramQueryPurpose.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          return "limbo-document"; 
        throw Assert.fail("Unrecognized query purpose: %s", new Object[] { paramQueryPurpose });
      } 
      return "existence-filter-mismatch";
    } 
    return null;
  }
  
  private MapValue encodeMapValue(ObjectValue paramObjectValue) {
    MapValue.Builder builder = MapValue.newBuilder();
    for (Map.Entry entry : paramObjectValue.getInternalValue())
      builder.putFields((String)entry.getKey(), encodeValue((FieldValue)entry.getValue())); 
    return (MapValue)builder.build();
  }
  
  private StructuredQuery.Order encodeOrderBy(OrderBy paramOrderBy) {
    StructuredQuery.Order.Builder builder = StructuredQuery.Order.newBuilder();
    if (paramOrderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
      builder.setDirection(StructuredQuery.Direction.ASCENDING);
    } else {
      builder.setDirection(StructuredQuery.Direction.DESCENDING);
    } 
    builder.setField(encodeFieldPath(paramOrderBy.getField()));
    return (StructuredQuery.Order)builder.build();
  }
  
  private Precondition encodePrecondition(Precondition paramPrecondition) {
    Assert.hardAssert(paramPrecondition.isNone() ^ true, "Can't serialize an empty precondition", new Object[0]);
    Precondition.Builder builder = Precondition.newBuilder();
    if (paramPrecondition.getUpdateTime() != null)
      return (Precondition)builder.setUpdateTime(encodeVersion(paramPrecondition.getUpdateTime())).build(); 
    if (paramPrecondition.getExists() != null)
      return (Precondition)builder.setExists(paramPrecondition.getExists().booleanValue()).build(); 
    throw Assert.fail("Unknown Precondition", new Object[0]);
  }
  
  private String encodeQueryPath(ResourcePath paramResourcePath) {
    return encodeResourceName(this.databaseId, paramResourcePath);
  }
  
  private String encodeResourceName(DatabaseId paramDatabaseId, ResourcePath paramResourcePath) {
    return ((ResourcePath)((ResourcePath)encodedDatabaseId(paramDatabaseId).append("documents")).append((BasePath)paramResourcePath)).canonicalString();
  }
  
  private static ResourcePath encodedDatabaseId(DatabaseId paramDatabaseId) {
    return ResourcePath.fromSegments(Arrays.asList(new String[] { "projects", paramDatabaseId.getProjectId(), "databases", paramDatabaseId.getDatabaseId() }));
  }
  
  private static ResourcePath extractLocalPathFromResourceName(ResourcePath paramResourcePath) {
    boolean bool;
    if (paramResourcePath.length() > 4 && paramResourcePath.getSegment(4).equals("documents")) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Tried to deserialize invalid key %s", new Object[] { paramResourcePath });
    return (ResourcePath)paramResourcePath.popFirst(5);
  }
  
  private Status fromStatus(Status paramStatus) {
    return Status.fromCodeValue(paramStatus.getCode()).withDescription(paramStatus.getMessage());
  }
  
  private static boolean isValidResourceName(ResourcePath paramResourcePath) {
    int i = paramResourcePath.length();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i >= 4) {
      bool2 = bool1;
      if (paramResourcePath.getSegment(0).equals("projects")) {
        bool2 = bool1;
        if (paramResourcePath.getSegment(2).equals("databases"))
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public String databaseName() {
    return this.databaseName;
  }
  
  public Target decodeDocumentsTarget(Target.DocumentsTarget paramDocumentsTarget) {
    boolean bool;
    int i = paramDocumentsTarget.getDocumentsCount();
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "DocumentsTarget contained other than 1 document %d", new Object[] { Integer.valueOf(i) });
    return Query.atPath(decodeQueryPath(paramDocumentsTarget.getDocuments(0))).toTarget();
  }
  
  FieldFilter decodeFieldFilter(StructuredQuery.FieldFilter paramFieldFilter) {
    return FieldFilter.create(FieldPath.fromServerFormat(paramFieldFilter.getField().getFieldPath()), decodeFieldFilterOperator(paramFieldFilter.getOp()), decodeValue(paramFieldFilter.getValue()));
  }
  
  public ObjectValue decodeFields(Map<String, Value> paramMap) {
    ObjectValue objectValue2 = ObjectValue.emptyObject();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    ObjectValue objectValue1;
    for (objectValue1 = objectValue2; iterator.hasNext(); objectValue1 = objectValue1.set(FieldPath.fromSingleSegment((String)entry.getKey()), decodeValue((Value)entry.getValue())))
      Map.Entry entry = iterator.next(); 
    return objectValue1;
  }
  
  public DocumentKey decodeKey(String paramString) {
    ResourcePath resourcePath = decodeResourceName(paramString);
    Assert.hardAssert(resourcePath.getSegment(1).equals(this.databaseId.getProjectId()), "Tried to deserialize key from different project.", new Object[0]);
    Assert.hardAssert(resourcePath.getSegment(3).equals(this.databaseId.getDatabaseId()), "Tried to deserialize key from different database.", new Object[0]);
    return DocumentKey.fromPath(extractLocalPathFromResourceName(resourcePath));
  }
  
  public MaybeDocument decodeMaybeDocument(BatchGetDocumentsResponse paramBatchGetDocumentsResponse) {
    if (paramBatchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND))
      return (MaybeDocument)decodeFoundDocument(paramBatchGetDocumentsResponse); 
    if (paramBatchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING))
      return (MaybeDocument)decodeMissingDocument(paramBatchGetDocumentsResponse); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unknown result case: ");
    stringBuilder.append(paramBatchGetDocumentsResponse.getResultCase());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Mutation decodeMutation(Write paramWrite) {
    Precondition precondition;
    Boolean bool;
    if (paramWrite.hasCurrentDocument()) {
      precondition = decodePrecondition(paramWrite.getCurrentDocument());
    } else {
      precondition = Precondition.NONE;
    } 
    int i = null.$SwitchMap$com$google$firestore$v1$Write$OperationCase[paramWrite.getOperationCase().ordinal()];
    boolean bool1 = true;
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {
          ArrayList<FieldTransform> arrayList = new ArrayList();
          Iterator<DocumentTransform.FieldTransform> iterator = paramWrite.getTransform().getFieldTransformsList().iterator();
          while (iterator.hasNext())
            arrayList.add(decodeFieldTransform(iterator.next())); 
          bool = precondition.getExists();
          if (bool == null || !bool.booleanValue())
            bool1 = false; 
          Assert.hardAssert(bool1, "Transforms only support precondition \"exists == true\"", new Object[0]);
          return (Mutation)new TransformMutation(decodeKey(paramWrite.getTransform().getDocument()), arrayList);
        } 
        throw Assert.fail("Unknown mutation operation: %d", new Object[] { paramWrite.getOperationCase() });
      } 
      return (Mutation)new DeleteMutation(decodeKey(paramWrite.getDelete()), (Precondition)bool);
    } 
    return (Mutation)(paramWrite.hasUpdateMask() ? new PatchMutation(decodeKey(paramWrite.getUpdate().getName()), decodeFields(paramWrite.getUpdate().getFieldsMap()), decodeDocumentMask(paramWrite.getUpdateMask()), (Precondition)bool) : new SetMutation(decodeKey(paramWrite.getUpdate().getName()), decodeFields(paramWrite.getUpdate().getFieldsMap()), (Precondition)bool));
  }
  
  public MutationResult decodeMutationResult(WriteResult paramWriteResult, SnapshotVersion paramSnapshotVersion) {
    ArrayList<FieldValue> arrayList;
    SnapshotVersion snapshotVersion = decodeVersion(paramWriteResult.getUpdateTime());
    if (!SnapshotVersion.NONE.equals(snapshotVersion))
      paramSnapshotVersion = snapshotVersion; 
    snapshotVersion = null;
    int i = paramWriteResult.getTransformResultsCount();
    if (i > 0) {
      ArrayList<FieldValue> arrayList1 = new ArrayList(i);
      byte b = 0;
      while (true) {
        arrayList = arrayList1;
        if (b < i) {
          arrayList1.add(decodeValue(paramWriteResult.getTransformResults(b)));
          b++;
          continue;
        } 
        break;
      } 
    } 
    return new MutationResult(paramSnapshotVersion, arrayList);
  }
  
  public Target decodeQueryTarget(Target.QueryTarget paramQueryTarget) {
    ResourcePath resourcePath2 = decodeQueryPath(paramQueryTarget.getParent());
    StructuredQuery structuredQuery = paramQueryTarget.getStructuredQuery();
    int i = structuredQuery.getFromCount();
    Bound bound = null;
    byte b = 0;
    ResourcePath resourcePath1 = resourcePath2;
    if (i > 0) {
      String str;
      List<?> list1;
      List<?> list2;
      Bound bound1;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      Assert.hardAssert(bool, "StructuredQuery.from with more than one collection is not supported.", new Object[0]);
      StructuredQuery.CollectionSelector collectionSelector = structuredQuery.getFrom(0);
      if (collectionSelector.getAllDescendants()) {
        str = collectionSelector.getCollectionId();
      } else {
        resourcePath1 = (ResourcePath)resourcePath2.append(str.getCollectionId());
        resourcePath2 = resourcePath1;
        resourcePath1 = null;
      } 
      if (structuredQuery.hasWhere()) {
        list1 = decodeFilters(structuredQuery.getWhere());
      } else {
        list1 = Collections.emptyList();
      } 
      i = structuredQuery.getOrderByCount();
      if (i > 0) {
        list2 = new ArrayList(i);
        while (b < i) {
          list2.add(decodeOrderBy(structuredQuery.getOrderBy(b)));
          b++;
        } 
      } else {
        list2 = Collections.emptyList();
      } 
      long l = -1L;
      if (structuredQuery.hasLimit())
        l = structuredQuery.getLimit().getValue(); 
      if (structuredQuery.hasStartAt()) {
        bound1 = decodeBound(structuredQuery.getStartAt());
      } else {
        bound1 = null;
      } 
      if (structuredQuery.hasEndAt())
        bound = decodeBound(structuredQuery.getEndAt()); 
      return (new Query(resourcePath2, (String)resourcePath1, list1, list2, l, Query.LimitType.LIMIT_TO_FIRST, bound1, bound)).toTarget();
    } 
    resourcePath2 = resourcePath1;
    resourcePath1 = null;
  }
  
  public Timestamp decodeTimestamp(Timestamp paramTimestamp) {
    return new Timestamp(paramTimestamp.getSeconds(), paramTimestamp.getNanos());
  }
  
  public FieldValue decodeValue(Value paramValue) {
    ResourcePath resourcePath;
    switch (paramValue.getValueTypeCase()) {
      default:
        throw Assert.fail("Unknown value %s", new Object[] { paramValue });
      case null:
        return (FieldValue)decodeMapValue(paramValue.getMapValue());
      case null:
        return (FieldValue)decodeArrayValue(paramValue.getArrayValue());
      case null:
        return (FieldValue)StringValue.valueOf(paramValue.getStringValue());
      case null:
        resourcePath = decodeResourceName(paramValue.getReferenceValue());
        return (FieldValue)ReferenceValue.valueOf(DatabaseId.forDatabase(resourcePath.getSegment(1), resourcePath.getSegment(3)), DocumentKey.fromPath(extractLocalPathFromResourceName(resourcePath)));
      case null:
        return (FieldValue)BlobValue.valueOf(Blob.fromByteString(resourcePath.getBytesValue()));
      case RESPONSETYPE_NOT_SET:
        return (FieldValue)GeoPointValue.valueOf(decodeGeoPoint(resourcePath.getGeoPointValue()));
      case FILTER:
        return (FieldValue)TimestampValue.valueOf(decodeTimestamp(resourcePath.getTimestampValue()));
      case DOCUMENT_REMOVE:
        return (FieldValue)DoubleValue.valueOf(Double.valueOf(resourcePath.getDoubleValue()));
      case DOCUMENT_DELETE:
        return (FieldValue)IntegerValue.valueOf(Long.valueOf(resourcePath.getIntegerValue()));
      case DOCUMENT_CHANGE:
        return (FieldValue)BooleanValue.valueOf(Boolean.valueOf(resourcePath.getBooleanValue()));
      case TARGET_CHANGE:
        break;
    } 
    return (FieldValue)NullValue.nullValue();
  }
  
  public SnapshotVersion decodeVersion(Timestamp paramTimestamp) {
    return (paramTimestamp.getSeconds() == 0L && paramTimestamp.getNanos() == 0) ? SnapshotVersion.NONE : new SnapshotVersion(decodeTimestamp(paramTimestamp));
  }
  
  public SnapshotVersion decodeVersionFromListenResponse(ListenResponse paramListenResponse) {
    return (paramListenResponse.getResponseTypeCase() != ListenResponse.ResponseTypeCase.TARGET_CHANGE) ? SnapshotVersion.NONE : ((paramListenResponse.getTargetChange().getTargetIdsCount() != 0) ? SnapshotVersion.NONE : decodeVersion(paramListenResponse.getTargetChange().getReadTime()));
  }
  
  public WatchChange decodeWatchChange(ListenResponse paramListenResponse) {
    WatchChange.DocumentChange documentChange;
    WatchChange.WatchTargetChange watchTargetChange;
    int i = null.$SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[paramListenResponse.getResponseTypeCase().ordinal()];
    ExistenceFilter existenceFilter = null;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          WatchChange.ExistenceFilterWatchChange existenceFilterWatchChange;
          if (i != 4) {
            if (i == 5) {
              existenceFilter = paramListenResponse.getFilter();
              ExistenceFilter existenceFilter1 = new ExistenceFilter(existenceFilter.getCount());
              existenceFilterWatchChange = new WatchChange.ExistenceFilterWatchChange(existenceFilter.getTargetId(), existenceFilter1);
            } else {
              throw new IllegalArgumentException("Unknown change type set");
            } 
          } else {
            DocumentRemove documentRemove = existenceFilterWatchChange.getDocumentRemove();
            List<Integer> list = documentRemove.getRemovedTargetIdsList();
            DocumentKey documentKey = decodeKey(documentRemove.getDocument());
            documentChange = new WatchChange.DocumentChange(Collections.emptyList(), list, documentKey, null);
          } 
        } else {
          DocumentDelete documentDelete = documentChange.getDocumentDelete();
          List<Integer> list = documentDelete.getRemovedTargetIdsList();
          NoDocument noDocument = new NoDocument(decodeKey(documentDelete.getDocument()), decodeVersion(documentDelete.getReadTime()), false);
          documentChange = new WatchChange.DocumentChange(Collections.emptyList(), list, noDocument.getKey(), (MaybeDocument)noDocument);
        } 
      } else {
        DocumentChange documentChange1 = documentChange.getDocumentChange();
        List<Integer> list1 = documentChange1.getTargetIdsList();
        List<Integer> list2 = documentChange1.getRemovedTargetIdsList();
        DocumentKey documentKey = decodeKey(documentChange1.getDocument().getName());
        SnapshotVersion snapshotVersion = decodeVersion(documentChange1.getDocument().getUpdateTime());
        Assert.hardAssert(snapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Got a document change without an update time", new Object[0]);
        Document document = new Document(documentKey, snapshotVersion, Document.DocumentState.SYNCED, documentChange1.getDocument(), RemoteSerializer$$Lambda$2.lambdaFactory$(this));
        documentChange = new WatchChange.DocumentChange(list1, list2, document.getKey(), (MaybeDocument)document);
      } 
    } else {
      WatchChange.WatchTargetChangeType watchTargetChangeType;
      Status status;
      TargetChange targetChange = documentChange.getTargetChange();
      i = null.$SwitchMap$com$google$firestore$v1$TargetChange$TargetChangeType[targetChange.getTargetChangeType().ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i == 5) {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.Reset;
              } else {
                throw new IllegalArgumentException("Unknown target change type");
              } 
            } else {
              watchTargetChangeType = WatchChange.WatchTargetChangeType.Current;
            } 
          } else {
            watchTargetChangeType = WatchChange.WatchTargetChangeType.Removed;
            status = fromStatus(targetChange.getCause());
          } 
        } else {
          watchTargetChangeType = WatchChange.WatchTargetChangeType.Added;
        } 
      } else {
        watchTargetChangeType = WatchChange.WatchTargetChangeType.NoChange;
      } 
      watchTargetChange = new WatchChange.WatchTargetChange(watchTargetChangeType, targetChange.getTargetIdsList(), targetChange.getResumeToken(), status);
    } 
    return watchTargetChange;
  }
  
  public Document encodeDocument(DocumentKey paramDocumentKey, ObjectValue paramObjectValue) {
    Document.Builder builder = Document.newBuilder();
    builder.setName(encodeKey(paramDocumentKey));
    for (Map.Entry entry : paramObjectValue.getInternalValue())
      builder.putFields((String)entry.getKey(), encodeValue((FieldValue)entry.getValue())); 
    return (Document)builder.build();
  }
  
  public Target.DocumentsTarget encodeDocumentsTarget(Target paramTarget) {
    Target.DocumentsTarget.Builder builder = Target.DocumentsTarget.newBuilder();
    builder.addDocuments(encodeQueryPath(paramTarget.getPath()));
    return (Target.DocumentsTarget)builder.build();
  }
  
  public String encodeKey(DocumentKey paramDocumentKey) {
    return encodeResourceName(this.databaseId, paramDocumentKey.getPath());
  }
  
  public Map<String, String> encodeListenRequestLabels(QueryData paramQueryData) {
    String str = encodeLabel(paramQueryData.getPurpose());
    if (str == null)
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<>(1);
    hashMap.put("goog-listen-tags", str);
    return (Map)hashMap;
  }
  
  public Write encodeMutation(Mutation paramMutation) {
    Write.Builder builder = Write.newBuilder();
    if (paramMutation instanceof SetMutation) {
      builder.setUpdate(encodeDocument(paramMutation.getKey(), ((SetMutation)paramMutation).getValue()));
    } else if (paramMutation instanceof PatchMutation) {
      DocumentKey documentKey = paramMutation.getKey();
      PatchMutation patchMutation = (PatchMutation)paramMutation;
      builder.setUpdate(encodeDocument(documentKey, patchMutation.getValue()));
      builder.setUpdateMask(encodeDocumentMask(patchMutation.getMask()));
    } else if (paramMutation instanceof TransformMutation) {
      TransformMutation transformMutation = (TransformMutation)paramMutation;
      DocumentTransform.Builder builder1 = DocumentTransform.newBuilder();
      builder1.setDocument(encodeKey(transformMutation.getKey()));
      Iterator<FieldTransform> iterator = transformMutation.getFieldTransforms().iterator();
      while (iterator.hasNext())
        builder1.addFieldTransforms(encodeFieldTransform(iterator.next())); 
      builder.setTransform(builder1);
    } else if (paramMutation instanceof DeleteMutation) {
      builder.setDelete(encodeKey(paramMutation.getKey()));
    } else {
      throw Assert.fail("unknown mutation type %s", new Object[] { paramMutation.getClass() });
    } 
    if (!paramMutation.getPrecondition().isNone())
      builder.setCurrentDocument(encodePrecondition(paramMutation.getPrecondition())); 
    return (Write)builder.build();
  }
  
  public Target.QueryTarget encodeQueryTarget(Target paramTarget) {
    StructuredQuery.CollectionSelector.Builder builder2;
    Target.QueryTarget.Builder builder = Target.QueryTarget.newBuilder();
    StructuredQuery.Builder builder1 = StructuredQuery.newBuilder();
    ResourcePath resourcePath = paramTarget.getPath();
    String str = paramTarget.getCollectionGroup();
    boolean bool = true;
    if (str != null) {
      if (resourcePath.length() % 2 == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Collection Group queries should be within a document path or root.", new Object[0]);
      builder.setParent(encodeQueryPath(resourcePath));
      builder2 = StructuredQuery.CollectionSelector.newBuilder();
      builder2.setCollectionId(paramTarget.getCollectionGroup());
      builder2.setAllDescendants(true);
      builder1.addFrom(builder2);
    } else {
      if (builder2.length() % 2 == 0)
        bool = false; 
      Assert.hardAssert(bool, "Document queries with filters are not supported.", new Object[0]);
      builder.setParent(encodeQueryPath((ResourcePath)builder2.popLast()));
      StructuredQuery.CollectionSelector.Builder builder3 = StructuredQuery.CollectionSelector.newBuilder();
      builder3.setCollectionId(builder2.getLastSegment());
      builder1.addFrom(builder3);
    } 
    if (paramTarget.getFilters().size() > 0)
      builder1.setWhere(encodeFilters(paramTarget.getFilters())); 
    Iterator<OrderBy> iterator = paramTarget.getOrderBy().iterator();
    while (iterator.hasNext())
      builder1.addOrderBy(encodeOrderBy(iterator.next())); 
    if (paramTarget.hasLimit())
      builder1.setLimit(Int32Value.newBuilder().setValue((int)paramTarget.getLimit())); 
    if (paramTarget.getStartAt() != null)
      builder1.setStartAt(encodeBound(paramTarget.getStartAt())); 
    if (paramTarget.getEndAt() != null)
      builder1.setEndAt(encodeBound(paramTarget.getEndAt())); 
    builder.setStructuredQuery(builder1);
    return (Target.QueryTarget)builder.build();
  }
  
  public Target encodeTarget(QueryData paramQueryData) {
    Target.Builder builder = Target.newBuilder();
    Target target = paramQueryData.getTarget();
    if (target.isDocumentQuery()) {
      builder.setDocuments(encodeDocumentsTarget(target));
    } else {
      builder.setQuery(encodeQueryTarget(target));
    } 
    builder.setTargetId(paramQueryData.getTargetId());
    builder.setResumeToken(paramQueryData.getResumeToken());
    return (Target)builder.build();
  }
  
  public Timestamp encodeTimestamp(Timestamp paramTimestamp) {
    Timestamp.Builder builder = Timestamp.newBuilder();
    builder.setSeconds(paramTimestamp.getSeconds());
    builder.setNanos(paramTimestamp.getNanoseconds());
    return (Timestamp)builder.build();
  }
  
  StructuredQuery.Filter encodeUnaryOrFieldFilter(FieldFilter paramFieldFilter) {
    if (paramFieldFilter.getOperator() == Filter.Operator.EQUAL) {
      StructuredQuery.UnaryFilter.Builder builder1 = StructuredQuery.UnaryFilter.newBuilder();
      builder1.setField(encodeFieldPath(paramFieldFilter.getField()));
      if (paramFieldFilter.getValue().equals(DoubleValue.NaN)) {
        builder1.setOp(StructuredQuery.UnaryFilter.Operator.IS_NAN);
        return (StructuredQuery.Filter)StructuredQuery.Filter.newBuilder().setUnaryFilter(builder1).build();
      } 
      if (paramFieldFilter.getValue().equals(NullValue.nullValue())) {
        builder1.setOp(StructuredQuery.UnaryFilter.Operator.IS_NULL);
        return (StructuredQuery.Filter)StructuredQuery.Filter.newBuilder().setUnaryFilter(builder1).build();
      } 
    } 
    StructuredQuery.FieldFilter.Builder builder = StructuredQuery.FieldFilter.newBuilder();
    builder.setField(encodeFieldPath(paramFieldFilter.getField()));
    builder.setOp(encodeFieldFilterOperator(paramFieldFilter.getOperator()));
    builder.setValue(encodeValue(paramFieldFilter.getValue()));
    return (StructuredQuery.Filter)StructuredQuery.Filter.newBuilder().setFieldFilter(builder).build();
  }
  
  public Value encodeValue(FieldValue paramFieldValue) {
    boolean bool;
    Value.Builder builder = Value.newBuilder();
    if (paramFieldValue instanceof NullValue) {
      builder.setNullValueValue(0);
      return (Value)builder.build();
    } 
    Object object = paramFieldValue.value();
    if (object != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Encoded field value should not be null.", new Object[0]);
    if (paramFieldValue instanceof BooleanValue) {
      builder.setBooleanValue(((Boolean)object).booleanValue());
    } else if (paramFieldValue instanceof IntegerValue) {
      builder.setIntegerValue(((Long)object).longValue());
    } else if (paramFieldValue instanceof DoubleValue) {
      builder.setDoubleValue(((Double)object).doubleValue());
    } else if (paramFieldValue instanceof StringValue) {
      builder.setStringValue((String)object);
    } else if (paramFieldValue instanceof ArrayValue) {
      builder.setArrayValue(encodeArrayValue((ArrayValue)paramFieldValue));
    } else if (paramFieldValue instanceof ObjectValue) {
      builder.setMapValue(encodeMapValue((ObjectValue)paramFieldValue));
    } else if (paramFieldValue instanceof TimestampValue) {
      builder.setTimestampValue(encodeTimestamp(((TimestampValue)paramFieldValue).getInternalValue()));
    } else if (paramFieldValue instanceof GeoPointValue) {
      builder.setGeoPointValue(encodeGeoPoint((GeoPoint)object));
    } else if (paramFieldValue instanceof BlobValue) {
      builder.setBytesValue(((Blob)object).toByteString());
    } else {
      if (paramFieldValue instanceof ReferenceValue) {
        builder.setReferenceValue(encodeResourceName(((ReferenceValue)paramFieldValue).getDatabaseId(), ((DocumentKey)object).getPath()));
        return (Value)builder.build();
      } 
      throw Assert.fail("Can't serialize %s", new Object[] { paramFieldValue });
    } 
    return (Value)builder.build();
  }
  
  public Timestamp encodeVersion(SnapshotVersion paramSnapshotVersion) {
    return encodeTimestamp(paramSnapshotVersion.getTimestamp());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\RemoteSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */