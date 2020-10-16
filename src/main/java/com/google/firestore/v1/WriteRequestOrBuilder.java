package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

public interface WriteRequestOrBuilder extends MessageLiteOrBuilder {
  boolean containsLabels(String paramString);
  
  String getDatabase();
  
  ByteString getDatabaseBytes();
  
  @Deprecated
  Map<String, String> getLabels();
  
  int getLabelsCount();
  
  Map<String, String> getLabelsMap();
  
  String getLabelsOrDefault(String paramString1, String paramString2);
  
  String getLabelsOrThrow(String paramString);
  
  String getStreamId();
  
  ByteString getStreamIdBytes();
  
  ByteString getStreamToken();
  
  Write getWrites(int paramInt);
  
  int getWritesCount();
  
  List<Write> getWritesList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */