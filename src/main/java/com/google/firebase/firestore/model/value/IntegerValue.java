package com.google.firebase.firestore.model.value;

public final class IntegerValue extends NumberValue {
  private final long internalValue;
  
  private IntegerValue(Long paramLong) {
    this.internalValue = paramLong.longValue();
  }
  
  public static IntegerValue valueOf(Long paramLong) {
    return new IntegerValue(paramLong);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof IntegerValue && this.internalValue == ((IntegerValue)paramObject).internalValue) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public long getInternalValue() {
    return this.internalValue;
  }
  
  public int hashCode() {
    long l = this.internalValue;
    return (int)(l ^ l >>> 32L);
  }
  
  public Long value() {
    return Long.valueOf(this.internalValue);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\IntegerValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */