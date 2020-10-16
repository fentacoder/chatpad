package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

public interface WriteBatchOrBuilder extends MessageLiteOrBuilder {
  Write getBaseWrites(int paramInt);
  
  int getBaseWritesCount();
  
  List<Write> getBaseWritesList();
  
  int getBatchId();
  
  Timestamp getLocalWriteTime();
  
  Write getWrites(int paramInt);
  
  int getWritesCount();
  
  List<Write> getWritesList();
  
  boolean hasLocalWriteTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\WriteBatchOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */