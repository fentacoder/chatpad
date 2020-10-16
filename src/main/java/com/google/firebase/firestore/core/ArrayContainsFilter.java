package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

public class ArrayContainsFilter extends FieldFilter {
  ArrayContainsFilter(FieldPath paramFieldPath, FieldValue paramFieldValue) {
    super(paramFieldPath, Filter.Operator.ARRAY_CONTAINS, paramFieldValue);
  }
  
  public boolean matches(Document paramDocument) {
    boolean bool;
    FieldValue fieldValue = paramDocument.getField(getField());
    if (fieldValue instanceof ArrayValue && ((ArrayValue)fieldValue).getInternalValue().contains(getValue())) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ArrayContainsFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */