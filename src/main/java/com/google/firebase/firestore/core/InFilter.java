package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

public class InFilter extends FieldFilter {
  InFilter(FieldPath paramFieldPath, ArrayValue paramArrayValue) {
    super(paramFieldPath, Filter.Operator.IN, (FieldValue)paramArrayValue);
  }
  
  public boolean matches(Document paramDocument) {
    boolean bool;
    ArrayValue arrayValue = (ArrayValue)getValue();
    FieldValue fieldValue = paramDocument.getField(getField());
    if (fieldValue != null && arrayValue.getInternalValue().contains(fieldValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\InFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */