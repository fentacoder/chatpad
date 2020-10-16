package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.FieldValue;

public interface TransformOperation {
  FieldValue applyToLocalView(FieldValue paramFieldValue, Timestamp paramTimestamp);
  
  FieldValue applyToRemoteDocument(FieldValue paramFieldValue1, FieldValue paramFieldValue2);
  
  FieldValue computeBaseValue(FieldValue paramFieldValue);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\TransformOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */