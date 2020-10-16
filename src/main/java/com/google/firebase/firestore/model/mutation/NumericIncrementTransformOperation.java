package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.util.Assert;

public class NumericIncrementTransformOperation implements TransformOperation {
  private NumberValue operand;
  
  public NumericIncrementTransformOperation(NumberValue paramNumberValue) {
    this.operand = paramNumberValue;
  }
  
  private double operandAsDouble() {
    NumberValue numberValue = this.operand;
    if (numberValue instanceof DoubleValue)
      return ((DoubleValue)numberValue).getInternalValue(); 
    if (numberValue instanceof IntegerValue)
      return ((IntegerValue)numberValue).getInternalValue(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected 'operand' to be of Number type, but was ");
    stringBuilder.append(this.operand.getClass().getCanonicalName());
    throw Assert.fail(stringBuilder.toString(), new Object[0]);
  }
  
  private long operandAsLong() {
    NumberValue numberValue = this.operand;
    if (numberValue instanceof DoubleValue)
      return (long)((DoubleValue)numberValue).getInternalValue(); 
    if (numberValue instanceof IntegerValue)
      return ((IntegerValue)numberValue).getInternalValue(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected 'operand' to be of Number type, but was ");
    stringBuilder.append(this.operand.getClass().getCanonicalName());
    throw Assert.fail(stringBuilder.toString(), new Object[0]);
  }
  
  private long safeIncrement(long paramLong1, long paramLong2) {
    long l = paramLong1 + paramLong2;
    return (((paramLong1 ^ l) & (paramLong2 ^ l)) >= 0L) ? l : ((l >= 0L) ? Long.MIN_VALUE : Long.MAX_VALUE);
  }
  
  public FieldValue applyToLocalView(FieldValue paramFieldValue, Timestamp paramTimestamp) {
    NumberValue numberValue = computeBaseValue(paramFieldValue);
    boolean bool = numberValue instanceof IntegerValue;
    if (bool && this.operand instanceof IntegerValue)
      return (FieldValue)IntegerValue.valueOf(Long.valueOf(safeIncrement(((IntegerValue)numberValue).getInternalValue(), operandAsLong()))); 
    if (bool)
      return (FieldValue)DoubleValue.valueOf(Double.valueOf(((IntegerValue)numberValue).getInternalValue() + operandAsDouble())); 
    Assert.hardAssert(numberValue instanceof DoubleValue, "Expected NumberValue to be of type DoubleValue, but was ", new Object[] { paramFieldValue.getClass().getCanonicalName() });
    return (FieldValue)DoubleValue.valueOf(Double.valueOf(((DoubleValue)numberValue).getInternalValue() + operandAsDouble()));
  }
  
  public FieldValue applyToRemoteDocument(FieldValue paramFieldValue1, FieldValue paramFieldValue2) {
    return paramFieldValue2;
  }
  
  public NumberValue computeBaseValue(FieldValue paramFieldValue) {
    IntegerValue integerValue;
    if (paramFieldValue instanceof NumberValue) {
      NumberValue numberValue = (NumberValue)paramFieldValue;
    } else {
      integerValue = IntegerValue.valueOf(Long.valueOf(0L));
    } 
    return (NumberValue)integerValue;
  }
  
  public FieldValue getOperand() {
    return (FieldValue)this.operand;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\NumericIncrementTransformOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */