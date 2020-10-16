package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;

public class BooleanValue extends FieldValue {
  private static final BooleanValue FALSE_VALUE;
  
  private static final BooleanValue TRUE_VALUE = new BooleanValue(Boolean.TRUE);
  
  private final boolean internalValue;
  
  static {
    FALSE_VALUE = new BooleanValue(Boolean.FALSE);
  }
  
  private BooleanValue(Boolean paramBoolean) {
    this.internalValue = paramBoolean.booleanValue();
  }
  
  public static BooleanValue valueOf(Boolean paramBoolean) {
    BooleanValue booleanValue;
    if (paramBoolean.booleanValue()) {
      booleanValue = TRUE_VALUE;
    } else {
      booleanValue = FALSE_VALUE;
    } 
    return booleanValue;
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof BooleanValue) ? Util.compareBooleans(this.internalValue, ((BooleanValue)paramFieldValue).internalValue) : defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.internalValue;
  }
  
  public int typeOrder() {
    return 1;
  }
  
  public Boolean value() {
    return Boolean.valueOf(this.internalValue);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\BooleanValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */