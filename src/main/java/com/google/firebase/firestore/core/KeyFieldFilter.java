package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ReferenceValue;

public class KeyFieldFilter extends FieldFilter {
  KeyFieldFilter(FieldPath paramFieldPath, Filter.Operator paramOperator, ReferenceValue paramReferenceValue) {
    super(paramFieldPath, paramOperator, (FieldValue)paramReferenceValue);
  }
  
  public boolean matches(Document paramDocument) {
    ReferenceValue referenceValue = (ReferenceValue)getValue();
    return matchesComparison(paramDocument.getKey().compareTo(referenceValue.value()));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\KeyFieldFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */