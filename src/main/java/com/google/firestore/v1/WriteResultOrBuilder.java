package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

public interface WriteResultOrBuilder extends MessageLiteOrBuilder {
  Value getTransformResults(int paramInt);
  
  int getTransformResultsCount();
  
  List<Value> getTransformResultsList();
  
  Timestamp getUpdateTime();
  
  boolean hasUpdateTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteResultOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */