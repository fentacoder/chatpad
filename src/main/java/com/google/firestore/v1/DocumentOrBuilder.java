package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.Map;

public interface DocumentOrBuilder extends MessageLiteOrBuilder {
  boolean containsFields(String paramString);
  
  Timestamp getCreateTime();
  
  @Deprecated
  Map<String, Value> getFields();
  
  int getFieldsCount();
  
  Map<String, Value> getFieldsMap();
  
  Value getFieldsOrDefault(String paramString, Value paramValue);
  
  Value getFieldsOrThrow(String paramString);
  
  String getName();
  
  ByteString getNameBytes();
  
  Timestamp getUpdateTime();
  
  boolean hasCreateTime();
  
  boolean hasUpdateTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */