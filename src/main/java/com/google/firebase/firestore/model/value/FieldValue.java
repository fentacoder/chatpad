package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;

public abstract class FieldValue implements Comparable<FieldValue> {
  static final int TYPE_ORDER_ARRAY = 8;
  
  static final int TYPE_ORDER_BLOB = 5;
  
  static final int TYPE_ORDER_BOOLEAN = 1;
  
  static final int TYPE_ORDER_GEOPOINT = 7;
  
  static final int TYPE_ORDER_NULL = 0;
  
  static final int TYPE_ORDER_NUMBER = 2;
  
  static final int TYPE_ORDER_OBJECT = 9;
  
  static final int TYPE_ORDER_REFERENCE = 6;
  
  static final int TYPE_ORDER_STRING = 4;
  
  static final int TYPE_ORDER_TIMESTAMP = 3;
  
  public abstract int compareTo(FieldValue paramFieldValue);
  
  protected int defaultCompareTo(FieldValue paramFieldValue) {
    boolean bool;
    int i = Util.compareIntegers(typeOrder(), paramFieldValue.typeOrder());
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Default compareTo should not be used for values of same type.", new Object[0]);
    return i;
  }
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public String toString() {
    Object object = value();
    if (object == null) {
      object = "null";
    } else {
      object = object.toString();
    } 
    return (String)object;
  }
  
  public abstract int typeOrder();
  
  public abstract Object value();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\FieldValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */