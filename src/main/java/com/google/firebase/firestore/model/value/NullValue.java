package com.google.firebase.firestore.model.value;

public class NullValue extends FieldValue {
  private static final NullValue INSTANCE = new NullValue();
  
  public static NullValue nullValue() {
    return INSTANCE;
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof NullValue) ? 0 : defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    return paramObject instanceof NullValue;
  }
  
  public int hashCode() {
    return -1;
  }
  
  public int typeOrder() {
    return 0;
  }
  
  public Object value() {
    return null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\NullValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */