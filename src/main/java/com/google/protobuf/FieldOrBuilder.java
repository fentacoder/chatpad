package com.google.protobuf;

import java.util.List;

public interface FieldOrBuilder extends MessageLiteOrBuilder {
  Field.Cardinality getCardinality();
  
  int getCardinalityValue();
  
  String getDefaultValue();
  
  ByteString getDefaultValueBytes();
  
  String getJsonName();
  
  ByteString getJsonNameBytes();
  
  Field.Kind getKind();
  
  int getKindValue();
  
  String getName();
  
  ByteString getNameBytes();
  
  int getNumber();
  
  int getOneofIndex();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  boolean getPacked();
  
  String getTypeUrl();
  
  ByteString getTypeUrlBytes();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\FieldOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */