package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayValue extends FieldValue {
  private final List<FieldValue> internalValue;
  
  private ArrayValue(List<FieldValue> paramList) {
    this.internalValue = Collections.unmodifiableList(paramList);
  }
  
  public static ArrayValue fromList(List<FieldValue> paramList) {
    return new ArrayValue(paramList);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    if (paramFieldValue instanceof ArrayValue) {
      paramFieldValue = paramFieldValue;
      int i = Math.min(this.internalValue.size(), ((ArrayValue)paramFieldValue).internalValue.size());
      for (byte b = 0; b < i; b++) {
        int j = ((FieldValue)this.internalValue.get(b)).compareTo(((ArrayValue)paramFieldValue).internalValue.get(b));
        if (j != 0)
          return j; 
      } 
      return Util.compareIntegers(this.internalValue.size(), ((ArrayValue)paramFieldValue).internalValue.size());
    } 
    return defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof ArrayValue && this.internalValue.equals(((ArrayValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public List<FieldValue> getInternalValue() {
    return this.internalValue;
  }
  
  public int hashCode() {
    return this.internalValue.hashCode();
  }
  
  public int typeOrder() {
    return 8;
  }
  
  public List<Object> value() {
    ArrayList<Object> arrayList = new ArrayList(this.internalValue.size());
    Iterator<FieldValue> iterator = this.internalValue.iterator();
    while (iterator.hasNext())
      arrayList.add(((FieldValue)iterator.next()).value()); 
    return arrayList;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\ArrayValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */