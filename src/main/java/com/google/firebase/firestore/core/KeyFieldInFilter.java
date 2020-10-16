package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;

public class KeyFieldInFilter extends FieldFilter {
  KeyFieldInFilter(FieldPath paramFieldPath, ArrayValue paramArrayValue) {
    super(paramFieldPath, Filter.Operator.IN, (FieldValue)paramArrayValue);
    Iterator iterator = ((ArrayValue)getValue()).getInternalValue().iterator();
    while (iterator.hasNext())
      Assert.hardAssert((FieldValue)iterator.next() instanceof ReferenceValue, "Comparing on key with IN, but an array value was not a ReferenceValue", new Object[0]); 
  }
  
  public boolean matches(Document paramDocument) {
    for (FieldValue fieldValue : ((ArrayValue)getValue()).getInternalValue()) {
      if (paramDocument.getKey().equals(((ReferenceValue)fieldValue).value()))
        return true; 
    } 
    return false;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\KeyFieldInFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */