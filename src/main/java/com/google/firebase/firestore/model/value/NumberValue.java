package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;

public abstract class NumberValue extends FieldValue {
  public int compareTo(FieldValue paramFieldValue) {
    if (!(paramFieldValue instanceof NumberValue))
      return defaultCompareTo(paramFieldValue); 
    if (this instanceof DoubleValue) {
      double d = ((DoubleValue)this).getInternalValue();
      if (paramFieldValue instanceof DoubleValue)
        return Util.compareDoubles(d, ((DoubleValue)paramFieldValue).getInternalValue()); 
      Assert.hardAssert(paramFieldValue instanceof IntegerValue, "Unknown NumberValue: %s", new Object[] { paramFieldValue });
      return Util.compareMixed(d, ((IntegerValue)paramFieldValue).getInternalValue());
    } 
    Assert.hardAssert(this instanceof IntegerValue, "Unknown NumberValue: %s", new Object[] { this });
    long l = ((IntegerValue)this).getInternalValue();
    if (paramFieldValue instanceof IntegerValue)
      return Util.compareLongs(l, ((IntegerValue)paramFieldValue).getInternalValue()); 
    Assert.hardAssert(paramFieldValue instanceof DoubleValue, "Unknown NumberValue: %s", new Object[] { paramFieldValue });
    return Util.compareMixed(((DoubleValue)paramFieldValue).getInternalValue(), l) * -1;
  }
  
  public int typeOrder() {
    return 2;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\NumberValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */