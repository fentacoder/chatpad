package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class MapValue extends GeneratedMessageLite<MapValue, MapValue.Builder> implements MapValueOrBuilder {
  private static final MapValue DEFAULT_INSTANCE = new MapValue();
  
  public static final int FIELDS_FIELD_NUMBER = 1;
  
  private static volatile Parser<MapValue> PARSER;
  
  private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static MapValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Value> getMutableFieldsMap() {
    return (Map<String, Value>)internalGetMutableFields();
  }
  
  private MapFieldLite<String, Value> internalGetFields() {
    return this.fields_;
  }
  
  private MapFieldLite<String, Value> internalGetMutableFields() {
    if (!this.fields_.isMutable())
      this.fields_ = this.fields_.mutableCopy(); 
    return this.fields_;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MapValue paramMapValue) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMapValue);
  }
  
  public static MapValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MapValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MapValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MapValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MapValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MapValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MapValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MapValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MapValue parseFrom(InputStream paramInputStream) throws IOException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MapValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MapValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MapValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MapValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MapValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  public boolean containsFields(String paramString) {
    if (paramString != null)
      return internalGetFields().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/MapValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 310, 2 -> 306, 3 -> 297, 4 -> 288, 5 -> 254, 6 -> 110, 7 -> 250, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/MapValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/MapValue
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/MapValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/MapValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/MapValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/MapValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/MapValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/MapValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/MapValue.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_1
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_2
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 250
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 194
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 158
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 194
    //   158: aload_0
    //   159: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   162: invokevirtual isMutable : ()Z
    //   165: ifne -> 179
    //   168: aload_0
    //   169: aload_0
    //   170: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   173: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   176: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   179: getstatic com/google/firestore/v1/MapValue$FieldsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   182: aload_0
    //   183: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   186: aload_1
    //   187: aload_2
    //   188: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   191: goto -> 123
    //   194: iconst_1
    //   195: istore #4
    //   197: goto -> 123
    //   200: astore_1
    //   201: goto -> 248
    //   204: astore_3
    //   205: new java/lang/RuntimeException
    //   208: astore_2
    //   209: new com/google/protobuf/InvalidProtocolBufferException
    //   212: astore_1
    //   213: aload_1
    //   214: aload_3
    //   215: invokevirtual getMessage : ()Ljava/lang/String;
    //   218: invokespecial <init> : (Ljava/lang/String;)V
    //   221: aload_2
    //   222: aload_1
    //   223: aload_0
    //   224: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   227: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   230: aload_2
    //   231: athrow
    //   232: astore_2
    //   233: new java/lang/RuntimeException
    //   236: astore_1
    //   237: aload_1
    //   238: aload_2
    //   239: aload_0
    //   240: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   243: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: athrow
    //   248: aload_1
    //   249: athrow
    //   250: getstatic com/google/firestore/v1/MapValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/MapValue;
    //   253: areturn
    //   254: aload_2
    //   255: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   258: astore_1
    //   259: aload_3
    //   260: checkcast com/google/firestore/v1/MapValue
    //   263: astore_2
    //   264: aload_0
    //   265: aload_1
    //   266: aload_0
    //   267: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   270: aload_2
    //   271: invokespecial internalGetFields : ()Lcom/google/protobuf/MapFieldLite;
    //   274: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   279: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   282: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   285: astore_1
    //   286: aload_0
    //   287: areturn
    //   288: new com/google/firestore/v1/MapValue$Builder
    //   291: dup
    //   292: aconst_null
    //   293: invokespecial <init> : (Lcom/google/firestore/v1/MapValue$1;)V
    //   296: areturn
    //   297: aload_0
    //   298: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   301: invokevirtual makeImmutable : ()V
    //   304: aconst_null
    //   305: areturn
    //   306: getstatic com/google/firestore/v1/MapValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/MapValue;
    //   309: areturn
    //   310: new com/google/firestore/v1/MapValue
    //   313: dup
    //   314: invokespecial <init> : ()V
    //   317: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	232	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	204	java/io/IOException
    //   128	134	200	finally
    //   146	155	232	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	204	java/io/IOException
    //   146	155	200	finally
    //   158	179	232	com/google/protobuf/InvalidProtocolBufferException
    //   158	179	204	java/io/IOException
    //   158	179	200	finally
    //   179	191	232	com/google/protobuf/InvalidProtocolBufferException
    //   179	191	204	java/io/IOException
    //   179	191	200	finally
    //   205	232	200	finally
    //   233	248	200	finally
  }
  
  @Deprecated
  public Map<String, Value> getFields() {
    return getFieldsMap();
  }
  
  public int getFieldsCount() {
    return internalGetFields().size();
  }
  
  public Map<String, Value> getFieldsMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends Value>)internalGetFields());
  }
  
  public Value getFieldsOrDefault(String paramString, Value paramValue) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        paramValue = mapFieldLite.get(paramString); 
      return paramValue;
    } 
    throw new NullPointerException();
  }
  
  public Value getFieldsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        return mapFieldLite.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    for (Map.Entry entry : internalGetFields().entrySet())
      i += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(1, entry.getKey(), entry.getValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (Map.Entry entry : internalGetFields().entrySet())
      FieldsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 1, entry.getKey(), entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MapValue, Builder> implements MapValueOrBuilder {
    private Builder() {
      super(MapValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearFields() {
      copyOnWrite();
      ((MapValue)this.instance).getMutableFieldsMap().clear();
      return this;
    }
    
    public boolean containsFields(String param1String) {
      if (param1String != null)
        return ((MapValue)this.instance).getFieldsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    @Deprecated
    public Map<String, Value> getFields() {
      return getFieldsMap();
    }
    
    public int getFieldsCount() {
      return ((MapValue)this.instance).getFieldsMap().size();
    }
    
    public Map<String, Value> getFieldsMap() {
      return Collections.unmodifiableMap(((MapValue)this.instance).getFieldsMap());
    }
    
    public Value getFieldsOrDefault(String param1String, Value param1Value) {
      if (param1String != null) {
        Map<String, Value> map = ((MapValue)this.instance).getFieldsMap();
        if (map.containsKey(param1String))
          param1Value = map.get(param1String); 
        return param1Value;
      } 
      throw new NullPointerException();
    }
    
    public Value getFieldsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, Value> map = ((MapValue)this.instance).getFieldsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public Builder putAllFields(Map<String, Value> param1Map) {
      copyOnWrite();
      ((MapValue)this.instance).getMutableFieldsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putFields(String param1String, Value param1Value) {
      if (param1String != null) {
        if (param1Value != null) {
          copyOnWrite();
          ((MapValue)this.instance).getMutableFieldsMap().put(param1String, param1Value);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeFields(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((MapValue)this.instance).getMutableFieldsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  private static final class FieldsDefaultEntryHolder {
    static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\MapValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */