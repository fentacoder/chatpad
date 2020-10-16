package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ArrayTransformOperation implements TransformOperation {
  private final List<FieldValue> elements;
  
  ArrayTransformOperation(List<FieldValue> paramList) {
    this.elements = Collections.unmodifiableList(paramList);
  }
  
  static ArrayList<FieldValue> coercedFieldValuesArray(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof ArrayValue) ? new ArrayList<>(((ArrayValue)paramFieldValue).getInternalValue()) : new ArrayList<>();
  }
  
  protected abstract ArrayValue apply(FieldValue paramFieldValue);
  
  public FieldValue applyToLocalView(FieldValue paramFieldValue, Timestamp paramTimestamp) {
    return (FieldValue)apply(paramFieldValue);
  }
  
  public FieldValue applyToRemoteDocument(FieldValue paramFieldValue1, FieldValue paramFieldValue2) {
    return (FieldValue)apply(paramFieldValue1);
  }
  
  public FieldValue computeBaseValue(FieldValue paramFieldValue) {
    return null;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.elements.equals(((ArrayTransformOperation)paramObject).elements);
  }
  
  public List<FieldValue> getElements() {
    return this.elements;
  }
  
  public int hashCode() {
    return getClass().hashCode() * 31 + this.elements.hashCode();
  }
  
  public static class Remove extends ArrayTransformOperation {
    public Remove(List<FieldValue> param1List) {
      super(param1List);
    }
    
    protected ArrayValue apply(FieldValue param1FieldValue) {
      ArrayList<FieldValue> arrayList = coercedFieldValuesArray(param1FieldValue);
      Iterator<FieldValue> iterator = getElements().iterator();
      while (iterator.hasNext())
        arrayList.removeAll(Collections.singleton(iterator.next())); 
      return ArrayValue.fromList(arrayList);
    }
  }
  
  public static class Union extends ArrayTransformOperation {
    public Union(List<FieldValue> param1List) {
      super(param1List);
    }
    
    protected ArrayValue apply(FieldValue param1FieldValue) {
      ArrayList<FieldValue> arrayList = coercedFieldValuesArray(param1FieldValue);
      for (FieldValue fieldValue : getElements()) {
        if (!arrayList.contains(fieldValue))
          arrayList.add(fieldValue); 
      } 
      return ArrayValue.fromList(arrayList);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\ArrayTransformOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */