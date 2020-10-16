package com.google.protobuf;

public interface ValueOrBuilder extends MessageLiteOrBuilder {
  boolean getBoolValue();
  
  Value.KindCase getKindCase();
  
  ListValue getListValue();
  
  NullValue getNullValue();
  
  int getNullValueValue();
  
  double getNumberValue();
  
  String getStringValue();
  
  ByteString getStringValueBytes();
  
  Struct getStructValue();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\ValueOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */