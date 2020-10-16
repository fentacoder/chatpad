package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

public class ArrayContainsAnyFilter extends FieldFilter {
  ArrayContainsAnyFilter(FieldPath paramFieldPath, FieldValue paramFieldValue) {
    super(paramFieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, paramFieldValue);
  }
  
  public boolean matches(Document paramDocument) {
    ArrayValue arrayValue = (ArrayValue)getValue();
    FieldValue fieldValue = paramDocument.getField(getField());
    if (!(fieldValue instanceof ArrayValue))
      return false; 
    for (FieldValue fieldValue1 : ((ArrayValue)fieldValue).getInternalValue()) {
      if (arrayValue.getInternalValue().contains(fieldValue1))
        return true; 
    } 
    return false;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ArrayContainsAnyFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */