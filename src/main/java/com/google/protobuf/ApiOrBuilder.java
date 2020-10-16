package com.google.protobuf;

import java.util.List;

public interface ApiOrBuilder extends MessageLiteOrBuilder {
  Method getMethods(int paramInt);
  
  int getMethodsCount();
  
  List<Method> getMethodsList();
  
  Mixin getMixins(int paramInt);
  
  int getMixinsCount();
  
  List<Mixin> getMixinsList();
  
  String getName();
  
  ByteString getNameBytes();
  
  Option getOptions(int paramInt);
  
  int getOptionsCount();
  
  List<Option> getOptionsList();
  
  SourceContext getSourceContext();
  
  Syntax getSyntax();
  
  int getSyntaxValue();
  
  String getVersion();
  
  ByteString getVersionBytes();
  
  boolean hasSourceContext();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\ApiOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */