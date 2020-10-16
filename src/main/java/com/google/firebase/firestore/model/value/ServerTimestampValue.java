package com.google.firebase.firestore.model.value;

import com.google.firebase.Timestamp;

public final class ServerTimestampValue extends FieldValue {
  private final Timestamp localWriteTime;
  
  private final FieldValue previousValue;
  
  public ServerTimestampValue(Timestamp paramTimestamp, FieldValue paramFieldValue) {
    this.localWriteTime = paramTimestamp;
    this.previousValue = paramFieldValue;
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof ServerTimestampValue) ? this.localWriteTime.compareTo(((ServerTimestampValue)paramFieldValue).localWriteTime) : ((paramFieldValue instanceof TimestampValue) ? 1 : defaultCompareTo(paramFieldValue));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof ServerTimestampValue && this.localWriteTime.equals(((ServerTimestampValue)paramObject).localWriteTime)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Timestamp getLocalWriteTime() {
    return this.localWriteTime;
  }
  
  public Object getPreviousValue() {
    FieldValue fieldValue = this.previousValue;
    if (fieldValue instanceof ServerTimestampValue)
      return ((ServerTimestampValue)fieldValue).getPreviousValue(); 
    if (fieldValue != null) {
      Object object = fieldValue.value();
    } else {
      fieldValue = null;
    } 
    return fieldValue;
  }
  
  public int hashCode() {
    return this.localWriteTime.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<ServerTimestamp localTime=");
    stringBuilder.append(this.localWriteTime.toString());
    stringBuilder.append(">");
    return stringBuilder.toString();
  }
  
  public int typeOrder() {
    return 3;
  }
  
  public Object value() {
    return null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\ServerTimestampValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */