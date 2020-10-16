package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;

public class IndexRange {
  private final FieldValue end;
  
  private final FieldPath fieldPath;
  
  private final FieldValue start;
  
  private IndexRange(Builder paramBuilder) {
    this.fieldPath = paramBuilder.fieldPath;
    this.start = paramBuilder.start;
    this.end = paramBuilder.end;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  public FieldValue getEnd() {
    return this.end;
  }
  
  public FieldPath getFieldPath() {
    return this.fieldPath;
  }
  
  public FieldValue getStart() {
    return this.start;
  }
  
  public static class Builder {
    private FieldValue end;
    
    private FieldPath fieldPath;
    
    private FieldValue start;
    
    public IndexRange build() {
      boolean bool;
      if (this.fieldPath != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Field path must be specified", new Object[0]);
      return new IndexRange(this);
    }
    
    public Builder setEnd(FieldValue param1FieldValue) {
      this.end = param1FieldValue;
      return this;
    }
    
    public Builder setFieldPath(FieldPath param1FieldPath) {
      this.fieldPath = param1FieldPath;
      return this;
    }
    
    public Builder setStart(FieldValue param1FieldValue) {
      this.start = param1FieldValue;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\IndexRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */