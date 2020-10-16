package com.google.firebase.firestore.model.value;

public final class DoubleValue extends NumberValue {
  public static final DoubleValue NaN = new DoubleValue(Double.valueOf(Double.NaN));
  
  private final double internalValue;
  
  private DoubleValue(Double paramDouble) {
    this.internalValue = paramDouble.doubleValue();
  }
  
  public static DoubleValue valueOf(Double paramDouble) {
    return Double.isNaN(paramDouble.doubleValue()) ? NaN : new DoubleValue(paramDouble);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof DoubleValue && Double.doubleToLongBits(this.internalValue) == Double.doubleToLongBits(((DoubleValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public double getInternalValue() {
    return this.internalValue;
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.internalValue);
    return (int)(l ^ l >>> 32L);
  }
  
  public Double value() {
    return Double.valueOf(this.internalValue);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\DoubleValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */