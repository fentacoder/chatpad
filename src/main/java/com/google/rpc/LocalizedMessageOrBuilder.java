package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LocalizedMessageOrBuilder extends MessageLiteOrBuilder {
  String getLocale();
  
  ByteString getLocaleBytes();
  
  String getMessage();
  
  ByteString getMessageBytes();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\LocalizedMessageOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */