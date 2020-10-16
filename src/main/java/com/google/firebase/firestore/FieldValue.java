package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;

public abstract class FieldValue {
  private static final DeleteFieldValue DELETE_INSTANCE = new DeleteFieldValue();
  
  private static final ServerTimestampFieldValue SERVER_TIMESTAMP_INSTANCE = new ServerTimestampFieldValue();
  
  public static FieldValue arrayRemove(Object... paramVarArgs) {
    return new ArrayRemoveFieldValue(Arrays.asList(paramVarArgs));
  }
  
  public static FieldValue arrayUnion(Object... paramVarArgs) {
    return new ArrayUnionFieldValue(Arrays.asList(paramVarArgs));
  }
  
  public static FieldValue delete() {
    return DELETE_INSTANCE;
  }
  
  public static FieldValue increment(double paramDouble) {
    return new NumericIncrementFieldValue(Double.valueOf(paramDouble));
  }
  
  public static FieldValue increment(long paramLong) {
    return new NumericIncrementFieldValue(Long.valueOf(paramLong));
  }
  
  public static FieldValue serverTimestamp() {
    return SERVER_TIMESTAMP_INSTANCE;
  }
  
  abstract String getMethodName();
  
  static class ArrayRemoveFieldValue extends FieldValue {
    private final List<Object> elements;
    
    ArrayRemoveFieldValue(List<Object> param1List) {
      this.elements = param1List;
    }
    
    List<Object> getElements() {
      return this.elements;
    }
    
    String getMethodName() {
      return "FieldValue.arrayRemove";
    }
  }
  
  static class ArrayUnionFieldValue extends FieldValue {
    private final List<Object> elements;
    
    ArrayUnionFieldValue(List<Object> param1List) {
      this.elements = param1List;
    }
    
    List<Object> getElements() {
      return this.elements;
    }
    
    String getMethodName() {
      return "FieldValue.arrayUnion";
    }
  }
  
  static class DeleteFieldValue extends FieldValue {
    String getMethodName() {
      return "FieldValue.delete";
    }
  }
  
  static class NumericIncrementFieldValue extends FieldValue {
    private final Number operand;
    
    NumericIncrementFieldValue(Number param1Number) {
      this.operand = param1Number;
    }
    
    String getMethodName() {
      return "FieldValue.increment";
    }
    
    Number getOperand() {
      return this.operand;
    }
  }
  
  static class ServerTimestampFieldValue extends FieldValue {
    String getMethodName() {
      return "FieldValue.serverTimestamp";
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FieldValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */