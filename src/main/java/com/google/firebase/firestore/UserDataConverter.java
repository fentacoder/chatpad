package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
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
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class UserDataConverter {
  private final DatabaseId databaseId;
  
  public UserDataConverter(DatabaseId paramDatabaseId) {
    this.databaseId = paramDatabaseId;
  }
  
  private ObjectValue convertAndParseDocumentData(Object paramObject, UserData.ParseContext paramParseContext) {
    if (!paramObject.getClass().isArray()) {
      FieldValue fieldValue = parseData(CustomClassMapper.convertToPlainJavaTypes(paramObject), paramParseContext);
      if (fieldValue instanceof ObjectValue)
        return (ObjectValue)fieldValue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was ");
      stringBuilder.append("of type: ");
      stringBuilder.append(Util.typeName(paramObject));
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    paramObject = new StringBuilder();
    paramObject.append("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was ");
    paramObject.append("an array");
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  private FieldValue convertAndParseFieldData(Object paramObject, UserData.ParseContext paramParseContext) {
    return parseData(CustomClassMapper.convertToPlainJavaTypes(paramObject), paramParseContext);
  }
  
  private List<FieldValue> parseArrayTransformElements(List<Object> paramList) {
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
    ArrayList<FieldValue> arrayList = new ArrayList(paramList.size());
    for (byte b = 0; b < paramList.size(); b++)
      arrayList.add(convertAndParseFieldData(paramList.get(b), parseAccumulator.rootContext().childContext(b))); 
    return arrayList;
  }
  
  private FieldValue parseData(Object paramObject, UserData.ParseContext paramParseContext) {
    if (paramObject instanceof Map)
      return (FieldValue)parseMap((Map<?, ?>)paramObject, paramParseContext); 
    if (paramObject instanceof FieldValue) {
      parseSentinelFieldValue((FieldValue)paramObject, paramParseContext);
      return null;
    } 
    if (paramParseContext.getPath() != null)
      paramParseContext.addToFieldMask(paramParseContext.getPath()); 
    if (paramObject instanceof List) {
      if (!paramParseContext.isArrayElement() || paramParseContext.getDataSource() == UserData.Source.ArrayArgument)
        return (FieldValue)parseList((List)paramObject, paramParseContext); 
      throw paramParseContext.createError("Nested arrays are not supported");
    } 
    return parseScalarValue(paramObject, paramParseContext);
  }
  
  private <T> ArrayValue parseList(List<T> paramList, UserData.ParseContext paramParseContext) {
    ArrayList<NullValue> arrayList = new ArrayList(paramList.size());
    Iterator<T> iterator = paramList.iterator();
    for (byte b = 0; iterator.hasNext(); b++) {
      NullValue nullValue;
      FieldValue fieldValue2 = parseData(iterator.next(), paramParseContext.childContext(b));
      FieldValue fieldValue1 = fieldValue2;
      if (fieldValue2 == null)
        nullValue = NullValue.nullValue(); 
      arrayList.add(nullValue);
    } 
    return ArrayValue.fromList(arrayList);
  }
  
  private <K, V> ObjectValue parseMap(Map<K, V> paramMap, UserData.ParseContext paramParseContext) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    if (paramMap.isEmpty()) {
      if (paramParseContext.getPath() != null && !paramParseContext.getPath().isEmpty())
        paramParseContext.addToFieldMask(paramParseContext.getPath()); 
      return ObjectValue.emptyObject();
    } 
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      FieldValue fieldValue;
      if (entry.getKey() instanceof String) {
        String str = (String)entry.getKey();
        fieldValue = parseData(entry.getValue(), paramParseContext.childContext(str));
        if (fieldValue != null)
          hashMap.put(str, fieldValue); 
        continue;
      } 
      throw paramParseContext.createError(String.format("Non-String Map key (%s) is not allowed", new Object[] { fieldValue.getValue() }));
    } 
    return ObjectValue.fromMap(hashMap);
  }
  
  private FieldValue parseScalarValue(Object paramObject, UserData.ParseContext paramParseContext) {
    if (paramObject == null)
      return (FieldValue)NullValue.nullValue(); 
    if (paramObject instanceof Integer)
      return (FieldValue)IntegerValue.valueOf(Long.valueOf(((Integer)paramObject).longValue())); 
    if (paramObject instanceof Long)
      return (FieldValue)IntegerValue.valueOf((Long)paramObject); 
    if (paramObject instanceof Float)
      return (FieldValue)DoubleValue.valueOf(Double.valueOf(((Float)paramObject).doubleValue())); 
    if (paramObject instanceof Double)
      return (FieldValue)DoubleValue.valueOf((Double)paramObject); 
    if (paramObject instanceof Boolean)
      return (FieldValue)BooleanValue.valueOf((Boolean)paramObject); 
    if (paramObject instanceof String)
      return (FieldValue)StringValue.valueOf((String)paramObject); 
    if (paramObject instanceof Date)
      return (FieldValue)TimestampValue.valueOf(new Timestamp((Date)paramObject)); 
    if (paramObject instanceof Timestamp) {
      paramObject = paramObject;
      return (FieldValue)TimestampValue.valueOf(new Timestamp(paramObject.getSeconds(), paramObject.getNanoseconds() / 1000 * 1000));
    } 
    if (paramObject instanceof GeoPoint)
      return (FieldValue)GeoPointValue.valueOf((GeoPoint)paramObject); 
    if (paramObject instanceof Blob)
      return (FieldValue)BlobValue.valueOf((Blob)paramObject); 
    if (paramObject instanceof DocumentReference) {
      DocumentReference documentReference = (DocumentReference)paramObject;
      if (documentReference.getFirestore() != null) {
        paramObject = documentReference.getFirestore().getDatabaseId();
        if (!paramObject.equals(this.databaseId))
          throw paramParseContext.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", new Object[] { paramObject.getProjectId(), paramObject.getDatabaseId(), this.databaseId.getProjectId(), this.databaseId.getDatabaseId() })); 
      } 
      return (FieldValue)ReferenceValue.valueOf(this.databaseId, documentReference.getKey());
    } 
    if (paramObject.getClass().isArray())
      throw paramParseContext.createError("Arrays are not supported; use a List instead"); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported type: ");
    stringBuilder.append(Util.typeName(paramObject));
    throw paramParseContext.createError(stringBuilder.toString());
  }
  
  private void parseSentinelFieldValue(FieldValue paramFieldValue, UserData.ParseContext paramParseContext) {
    NumericIncrementTransformOperation numericIncrementTransformOperation;
    boolean bool = paramParseContext.isWrite();
    boolean bool1 = true;
    if (bool) {
      if (paramParseContext.getPath() != null) {
        if (paramFieldValue instanceof FieldValue.DeleteFieldValue) {
          if (paramParseContext.getDataSource() == UserData.Source.MergeSet) {
            paramParseContext.addToFieldMask(paramParseContext.getPath());
          } else {
            if (paramParseContext.getDataSource() == UserData.Source.Update) {
              if (paramParseContext.getPath().length() <= 0)
                bool1 = false; 
              Assert.hardAssert(bool1, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
              throw paramParseContext.createError("FieldValue.delete() can only appear at the top level of your update data");
            } 
            throw paramParseContext.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
          } 
        } else if (paramFieldValue instanceof FieldValue.ServerTimestampFieldValue) {
          paramParseContext.addToFieldTransforms(paramParseContext.getPath(), (TransformOperation)ServerTimestampOperation.getInstance());
        } else {
          ArrayTransformOperation.Union union;
          if (paramFieldValue instanceof FieldValue.ArrayUnionFieldValue) {
            union = new ArrayTransformOperation.Union(parseArrayTransformElements(((FieldValue.ArrayUnionFieldValue)paramFieldValue).getElements()));
            paramParseContext.addToFieldTransforms(paramParseContext.getPath(), (TransformOperation)union);
          } else {
            ArrayTransformOperation.Remove remove;
            if (union instanceof FieldValue.ArrayRemoveFieldValue) {
              remove = new ArrayTransformOperation.Remove(parseArrayTransformElements(((FieldValue.ArrayRemoveFieldValue)union).getElements()));
              paramParseContext.addToFieldTransforms(paramParseContext.getPath(), (TransformOperation)remove);
            } else {
              if (remove instanceof FieldValue.NumericIncrementFieldValue) {
                numericIncrementTransformOperation = new NumericIncrementTransformOperation((NumberValue)parseQueryValue(((FieldValue.NumericIncrementFieldValue)remove).getOperand()));
                paramParseContext.addToFieldTransforms(paramParseContext.getPath(), (TransformOperation)numericIncrementTransformOperation);
                return;
              } 
              throw Assert.fail("Unknown FieldValue type: %s", new Object[] { Util.typeName(numericIncrementTransformOperation) });
            } 
          } 
        } 
        return;
      } 
      throw paramParseContext.createError(String.format("%s() is not currently supported inside arrays", new Object[] { numericIncrementTransformOperation.getMethodName() }));
    } 
    throw paramParseContext.createError(String.format("%s() can only be used with set() and update()", new Object[] { numericIncrementTransformOperation.getMethodName() }));
  }
  
  public UserData.ParsedSetData parseMergeData(Object paramObject, FieldMask paramFieldMask) {
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
    ObjectValue objectValue = convertAndParseDocumentData(paramObject, parseAccumulator.rootContext());
    if (paramFieldMask != null) {
      StringBuilder stringBuilder;
      for (Object paramObject : paramFieldMask.getMask()) {
        if (parseAccumulator.contains((FieldPath)paramObject))
          continue; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Field '");
        stringBuilder.append(paramObject.toString());
        stringBuilder.append("' is specified in your field mask but not in your input data.");
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return parseAccumulator.toMergeData(objectValue, (FieldMask)stringBuilder);
    } 
    return parseAccumulator.toMergeData(objectValue);
  }
  
  public FieldValue parseQueryValue(Object paramObject) {
    return parseQueryValue(paramObject, false);
  }
  
  public FieldValue parseQueryValue(Object paramObject, boolean paramBoolean) {
    UserData.Source source;
    if (paramBoolean) {
      source = UserData.Source.ArrayArgument;
    } else {
      source = UserData.Source.Argument;
    } 
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(source);
    paramObject = convertAndParseFieldData(paramObject, parseAccumulator.rootContext());
    if (paramObject != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    Assert.hardAssert(paramBoolean, "Parsed data should not be null.", new Object[0]);
    Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
    return (FieldValue)paramObject;
  }
  
  public UserData.ParsedSetData parseSetData(Object paramObject) {
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
    return parseAccumulator.toSetData(convertAndParseDocumentData(paramObject, parseAccumulator.rootContext()));
  }
  
  public UserData.ParsedUpdateData parseUpdateData(List<Object> paramList) {
    boolean bool;
    if (paramList.size() % 2 == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
    UserData.ParseContext parseContext = parseAccumulator.rootContext();
    ObjectValue objectValue2 = ObjectValue.emptyObject();
    Iterator<ObjectValue> iterator = paramList.iterator();
    ObjectValue objectValue1 = objectValue2;
    while (iterator.hasNext()) {
      FieldPath fieldPath;
      objectValue2 = iterator.next();
      FieldValue fieldValue = (FieldValue)iterator.next();
      boolean bool1 = objectValue2 instanceof String;
      if (bool1 || objectValue2 instanceof FieldPath) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Expected argument to be String or FieldPath.", new Object[0]);
      if (bool1) {
        fieldPath = FieldPath.fromDotSeparatedPath((String)objectValue2).getInternalPath();
      } else {
        fieldPath = ((FieldPath)fieldPath).getInternalPath();
      } 
      if (fieldValue instanceof FieldValue.DeleteFieldValue) {
        parseContext.addToFieldMask(fieldPath);
        continue;
      } 
      fieldValue = convertAndParseFieldData(fieldValue, parseContext.childContext(fieldPath));
      if (fieldValue != null) {
        parseContext.addToFieldMask(fieldPath);
        objectValue1 = objectValue1.set(fieldPath, fieldValue);
      } 
    } 
    return parseAccumulator.toUpdateData(objectValue1);
  }
  
  public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> paramMap) {
    Preconditions.checkNotNull(paramMap, "Provided update data must not be null.");
    UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
    UserData.ParseContext parseContext = parseAccumulator.rootContext();
    ObjectValue objectValue2 = ObjectValue.emptyObject();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    ObjectValue objectValue1 = objectValue2;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      FieldPath fieldPath = FieldPath.fromDotSeparatedPath((String)entry.getKey()).getInternalPath();
      entry = (Map.Entry)entry.getValue();
      if (entry instanceof FieldValue.DeleteFieldValue) {
        parseContext.addToFieldMask(fieldPath);
        continue;
      } 
      FieldValue fieldValue = convertAndParseFieldData(entry, parseContext.childContext(fieldPath));
      if (fieldValue != null) {
        parseContext.addToFieldMask(fieldPath);
        objectValue1 = objectValue1.set(fieldPath, fieldValue);
      } 
    } 
    return parseAccumulator.toUpdateData(objectValue1);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\UserDataConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */