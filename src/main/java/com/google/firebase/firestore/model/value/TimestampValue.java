package com.google.firebase.firestore.model.value;

import com.google.firebase.Timestamp;

public final class TimestampValue extends FieldValue {
  private final Timestamp internalValue;
  
  TimestampValue(Timestamp paramTimestamp) {
    this.internalValue = paramTimestamp;
  }
  
  public static TimestampValue valueOf(Timestamp paramTimestamp) {
    return new TimestampValue(paramTimestamp);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof TimestampValue) ? this.internalValue.compareTo(((TimestampValue)paramFieldValue).internalValue) : ((paramFieldValue instanceof ServerTimestampValue) ? -1 : defaultCompareTo(paramFieldValue));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof TimestampValue && this.internalValue.equals(((TimestampValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Timestamp getInternalValue() {
    return this.internalValue;
  }
  
  public int hashCode() {
    return this.internalValue.hashCode();
  }
  
  public String toString() {
    return this.internalValue.toString();
  }
  
  public int typeOrder() {
    return 3;
  }
  
  public Timestamp value() {
    return this.internalValue;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\TimestampValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */