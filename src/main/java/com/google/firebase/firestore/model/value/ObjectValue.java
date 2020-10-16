package com.google.firebase.firestore.model.value;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ObjectValue extends FieldValue {
  private static final ObjectValue EMPTY_INSTANCE = new ObjectValue(ImmutableSortedMap.Builder.emptyMap(Util.comparator()));
  
  private final ImmutableSortedMap<String, FieldValue> internalValue;
  
  private ObjectValue(ImmutableSortedMap<String, FieldValue> paramImmutableSortedMap) {
    this.internalValue = paramImmutableSortedMap;
  }
  
  public static ObjectValue emptyObject() {
    return EMPTY_INSTANCE;
  }
  
  public static ObjectValue fromImmutableMap(ImmutableSortedMap<String, FieldValue> paramImmutableSortedMap) {
    return paramImmutableSortedMap.isEmpty() ? EMPTY_INSTANCE : new ObjectValue(paramImmutableSortedMap);
  }
  
  public static ObjectValue fromMap(Map<String, FieldValue> paramMap) {
    return fromImmutableMap(ImmutableSortedMap.Builder.fromMap(paramMap, Util.comparator()));
  }
  
  private ObjectValue setChild(String paramString, FieldValue paramFieldValue) {
    return fromImmutableMap(this.internalValue.insert(paramString, paramFieldValue));
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    Iterator<Map.Entry> iterator;
    if (paramFieldValue instanceof ObjectValue) {
      ObjectValue objectValue = (ObjectValue)paramFieldValue;
      iterator = this.internalValue.iterator();
      Iterator<Map.Entry> iterator1 = objectValue.internalValue.iterator();
      while (iterator.hasNext() && iterator1.hasNext()) {
        Map.Entry entry2 = iterator.next();
        Map.Entry entry1 = iterator1.next();
        int i = ((String)entry2.getKey()).compareTo((String)entry1.getKey());
        if (i != 0)
          return i; 
        i = ((FieldValue)entry2.getValue()).compareTo((FieldValue)entry1.getValue());
        if (i != 0)
          return i; 
      } 
      return Util.compareBooleans(iterator.hasNext(), iterator1.hasNext());
    } 
    return defaultCompareTo((FieldValue)iterator);
  }
  
  public ObjectValue delete(FieldPath paramFieldPath) {
    Assert.hardAssert(paramFieldPath.isEmpty() ^ true, "Cannot delete field for empty path on ObjectValue", new Object[0]);
    String str = paramFieldPath.getFirstSegment();
    if (paramFieldPath.length() == 1)
      return fromImmutableMap(this.internalValue.remove(str)); 
    FieldValue fieldValue = (FieldValue)this.internalValue.get(str);
    return (fieldValue instanceof ObjectValue) ? setChild(str, ((ObjectValue)fieldValue).delete((FieldPath)paramFieldPath.popFirst())) : this;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof ObjectValue && this.internalValue.equals(((ObjectValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public FieldValue get(FieldPath paramFieldPath) {
    byte b = 0;
    FieldValue fieldValue = this;
    while (b < paramFieldPath.length()) {
      if (!(fieldValue instanceof ObjectValue))
        return null; 
      fieldValue = (FieldValue)((ObjectValue)fieldValue).internalValue.get(paramFieldPath.getSegment(b));
      b++;
    } 
    return fieldValue;
  }
  
  public FieldMask getFieldMask() {
    HashSet<FieldPath> hashSet = new HashSet();
    for (Map.Entry entry : this.internalValue) {
      FieldPath fieldPath = FieldPath.fromSingleSegment((String)entry.getKey());
      FieldValue fieldValue = (FieldValue)entry.getValue();
      if (fieldValue instanceof ObjectValue) {
        Set set = ((ObjectValue)fieldValue).getFieldMask().getMask();
        if (set.isEmpty()) {
          hashSet.add(fieldPath);
          continue;
        } 
        Iterator<FieldPath> iterator = set.iterator();
        while (iterator.hasNext())
          hashSet.add((FieldPath)fieldPath.append((BasePath)iterator.next())); 
        continue;
      } 
      hashSet.add(fieldPath);
    } 
    return FieldMask.fromSet(hashSet);
  }
  
  public ImmutableSortedMap<String, FieldValue> getInternalValue() {
    return this.internalValue;
  }
  
  public int hashCode() {
    return this.internalValue.hashCode();
  }
  
  public ObjectValue set(FieldPath paramFieldPath, FieldValue paramFieldValue) {
    Assert.hardAssert(paramFieldPath.isEmpty() ^ true, "Cannot set field for empty path on ObjectValue", new Object[0]);
    String str = paramFieldPath.getFirstSegment();
    if (paramFieldPath.length() == 1)
      return setChild(str, paramFieldValue); 
    FieldValue fieldValue = (FieldValue)this.internalValue.get(str);
    if (fieldValue instanceof ObjectValue) {
      fieldValue = fieldValue;
    } else {
      fieldValue = emptyObject();
    } 
    return setChild(str, fieldValue.set((FieldPath)paramFieldPath.popFirst(), paramFieldValue));
  }
  
  public String toString() {
    return this.internalValue.toString();
  }
  
  public int typeOrder() {
    return 9;
  }
  
  public Map<String, Object> value() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (Map.Entry entry : this.internalValue)
      hashMap.put(entry.getKey(), ((FieldValue)entry.getValue()).value()); 
    return (Map)hashMap;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\ObjectValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */