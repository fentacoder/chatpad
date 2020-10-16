package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;

public class ServerTimestampOperation implements TransformOperation {
  private static final ServerTimestampOperation SHARED_INSTANCE = new ServerTimestampOperation();
  
  public static ServerTimestampOperation getInstance() {
    return SHARED_INSTANCE;
  }
  
  public FieldValue applyToLocalView(FieldValue paramFieldValue, Timestamp paramTimestamp) {
    return (FieldValue)new ServerTimestampValue(paramTimestamp, paramFieldValue);
  }
  
  public FieldValue applyToRemoteDocument(FieldValue paramFieldValue1, FieldValue paramFieldValue2) {
    return paramFieldValue2;
  }
  
  public FieldValue computeBaseValue(FieldValue paramFieldValue) {
    return null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\ServerTimestampOperation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */