package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

public interface ListenRequestOrBuilder extends MessageLiteOrBuilder {
  boolean containsLabels(String paramString);
  
  Target getAddTarget();
  
  String getDatabase();
  
  ByteString getDatabaseBytes();
  
  @Deprecated
  Map<String, String> getLabels();
  
  int getLabelsCount();
  
  Map<String, String> getLabelsMap();
  
  String getLabelsOrDefault(String paramString1, String paramString2);
  
  String getLabelsOrThrow(String paramString);
  
  int getRemoveTarget();
  
  ListenRequest.TargetChangeCase getTargetChangeCase();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListenRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */