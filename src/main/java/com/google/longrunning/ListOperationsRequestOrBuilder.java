package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface ListOperationsRequestOrBuilder extends MessageLiteOrBuilder {
  String getFilter();
  
  ByteString getFilterBytes();
  
  String getName();
  
  ByteString getNameBytes();
  
  int getPageSize();
  
  String getPageToken();
  
  ByteString getPageTokenBytes();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */