package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DebugInfoOrBuilder extends MessageLiteOrBuilder {
  String getDetail();
  
  ByteString getDetailBytes();
  
  String getStackEntries(int paramInt);
  
  ByteString getStackEntriesBytes(int paramInt);
  
  int getStackEntriesCount();
  
  List<String> getStackEntriesList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\DebugInfoOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */