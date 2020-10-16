package com.google.protobuf;

import java.util.List;

public interface TypeOrBuilder extends MessageLiteOrBuilder {
  Field getFields(int paramInt);
  
  int getFieldsCount();
  
  List<Field> getFieldsList();
  
  String getName();
  
  ByteString getNameBytes();
  
  String getOneofs(int paramInt);
  
  ByteString getOneofsBytes(int paramInt);
  
  int getOneofsCount();
  
  List<String> getOneofsList();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  SourceContext getSourceContext();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
  
  boolean hasSourceContext();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\TypeOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */