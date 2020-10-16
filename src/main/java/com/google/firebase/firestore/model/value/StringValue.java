package com.google.firebase.firestore.model.value;

public class StringValue extends FieldValue {
  private final String internalValue;
  
  private StringValue(String paramString) {
    this.internalValue = paramString;
  }
  
  public static StringValue valueOf(String paramString) {
    return new StringValue(paramString);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof StringValue) ? this.internalValue.compareTo(((StringValue)paramFieldValue).internalValue) : defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof StringValue && this.internalValue.equals(((StringValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.internalValue.hashCode();
  }
  
  public int typeOrder() {
    return 4;
  }
  
  public String value() {
    return this.internalValue;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\StringValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */