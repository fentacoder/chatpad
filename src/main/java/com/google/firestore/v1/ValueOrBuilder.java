package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;

public interface ValueOrBuilder extends MessageLiteOrBuilder {
  ArrayValue getArrayValue();
  
  boolean getBooleanValue();
  
  ByteString getBytesValue();
  
  double getDoubleValue();
  
  LatLng getGeoPointValue();
  
  long getIntegerValue();
  
  MapValue getMapValue();
  
  NullValue getNullValue();
  
  int getNullValueValue();
  
  String getReferenceValue();
  
  ByteString getReferenceValueBytes();
  
  String getStringValue();
  
  ByteString getStringValueBytes();
  
  Timestamp getTimestampValue();
  
  Value.ValueTypeCase getValueTypeCase();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ValueOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */