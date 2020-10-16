package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;

public final class FieldTransform {
  private final FieldPath fieldPath;
  
  private final TransformOperation operation;
  
  public FieldTransform(FieldPath paramFieldPath, TransformOperation paramTransformOperation) {
    this.fieldPath = paramFieldPath;
    this.operation = paramTransformOperation;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return !this.fieldPath.equals(((FieldTransform)paramObject).fieldPath) ? false : this.operation.equals(((FieldTransform)paramObject).operation);
  }
  
  public FieldPath getFieldPath() {
    return this.fieldPath;
  }
  
  public TransformOperation getOperation() {
    return this.operation;
  }
  
  public int hashCode() {
    return this.fieldPath.hashCode() * 31 + this.operation.hashCode();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\FieldTransform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */