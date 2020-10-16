package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.Blob;

public class BlobValue extends FieldValue {
  private final Blob internalValue;
  
  private BlobValue(Blob paramBlob) {
    this.internalValue = paramBlob;
  }
  
  public static BlobValue valueOf(Blob paramBlob) {
    return new BlobValue(paramBlob);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof BlobValue) ? this.internalValue.compareTo(((BlobValue)paramFieldValue).internalValue) : defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof BlobValue && this.internalValue.equals(((BlobValue)paramObject).internalValue)) {
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
    return 5;
  }
  
  public Blob value() {
    return this.internalValue;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\BlobValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */