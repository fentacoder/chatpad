package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class StringValue extends GeneratedMessageLite<StringValue, StringValue.Builder> implements StringValueOrBuilder {
  private static final StringValue DEFAULT_INSTANCE = new StringValue();
  
  private static volatile Parser<StringValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private String value_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = getDefaultInstance().getValue();
  }
  
  public static StringValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(StringValue paramStringValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramStringValue);
  }
  
  public static StringValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (StringValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StringValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (StringValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static StringValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static StringValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StringValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static StringValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<StringValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(String paramString) {
    if (paramString != null) {
      this.value_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.value_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/StringValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 296, 2 -> 292, 3 -> 290, 4 -> 281, 5 -> 229, 6 -> 110, 7 -> 225, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/StringValue
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/StringValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/StringValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 225
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 169
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 158
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 169
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   163: putfield value_ : Ljava/lang/String;
    //   166: goto -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: astore_1
    //   176: goto -> 223
    //   179: astore_2
    //   180: new java/lang/RuntimeException
    //   183: astore_3
    //   184: new com/google/protobuf/InvalidProtocolBufferException
    //   187: astore_1
    //   188: aload_1
    //   189: aload_2
    //   190: invokevirtual getMessage : ()Ljava/lang/String;
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: aload_3
    //   197: aload_1
    //   198: aload_0
    //   199: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   202: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   205: aload_3
    //   206: athrow
    //   207: astore_2
    //   208: new java/lang/RuntimeException
    //   211: astore_1
    //   212: aload_1
    //   213: aload_2
    //   214: aload_0
    //   215: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   218: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   221: aload_1
    //   222: athrow
    //   223: aload_1
    //   224: athrow
    //   225: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   228: areturn
    //   229: aload_2
    //   230: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   233: astore_1
    //   234: aload_3
    //   235: checkcast com/google/protobuf/StringValue
    //   238: astore_2
    //   239: aload_0
    //   240: aload_1
    //   241: aload_0
    //   242: getfield value_ : Ljava/lang/String;
    //   245: invokevirtual isEmpty : ()Z
    //   248: iconst_1
    //   249: ixor
    //   250: aload_0
    //   251: getfield value_ : Ljava/lang/String;
    //   254: iconst_1
    //   255: aload_2
    //   256: getfield value_ : Ljava/lang/String;
    //   259: invokevirtual isEmpty : ()Z
    //   262: ixor
    //   263: aload_2
    //   264: getfield value_ : Ljava/lang/String;
    //   267: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   272: putfield value_ : Ljava/lang/String;
    //   275: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   278: astore_1
    //   279: aload_0
    //   280: areturn
    //   281: new com/google/protobuf/StringValue$Builder
    //   284: dup
    //   285: aconst_null
    //   286: invokespecial <init> : (Lcom/google/protobuf/StringValue$1;)V
    //   289: areturn
    //   290: aconst_null
    //   291: areturn
    //   292: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   295: areturn
    //   296: new com/google/protobuf/StringValue
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	207	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	179	java/io/IOException
    //   128	134	175	finally
    //   146	155	207	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	179	java/io/IOException
    //   146	155	175	finally
    //   158	166	207	com/google/protobuf/InvalidProtocolBufferException
    //   158	166	179	java/io/IOException
    //   158	166	175	finally
    //   180	207	175	finally
    //   208	223	175	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.value_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getValue() {
    return this.value_;
  }
  
  public ByteString getValueBytes() {
    return ByteString.copyFromUtf8(this.value_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.value_.isEmpty())
      paramCodedOutputStream.writeString(1, getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<StringValue, Builder> implements StringValueOrBuilder {
    private Builder() {
      super(StringValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public String getValue() {
      return this.instance.getValue();
    }
    
    public ByteString getValueBytes() {
      return this.instance.getValueBytes();
    }
    
    public Builder setValue(String param1String) {
      copyOnWrite();
      this.instance.setValue(param1String);
      return this;
    }
    
    public Builder setValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setValueBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\StringValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */