package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class UInt64Value extends GeneratedMessageLite<UInt64Value, UInt64Value.Builder> implements UInt64ValueOrBuilder {
  private static final UInt64Value DEFAULT_INSTANCE = new UInt64Value();
  
  private static volatile Parser<UInt64Value> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private long value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0L;
  }
  
  public static UInt64Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UInt64Value paramUInt64Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramUInt64Value);
  }
  
  public static UInt64Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UInt64Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UInt64Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UInt64Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UInt64Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UInt64Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UInt64Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UInt64Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static UInt64Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<UInt64Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UInt64Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(long paramLong) {
    this.value_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/UInt64Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 323, 2 -> 319, 3 -> 317, 4 -> 308, 5 -> 230, 6 -> 114, 7 -> 226, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/protobuf/UInt64Value.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/protobuf/UInt64Value
    //   76: monitorenter
    //   77: getstatic com/google/protobuf/UInt64Value.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/protobuf/UInt64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/UInt64Value;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/protobuf/UInt64Value.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/protobuf/UInt64Value
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/protobuf/UInt64Value
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/protobuf/UInt64Value.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 226
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 170
    //   140: iload #4
    //   142: bipush #8
    //   144: if_icmpeq -> 159
    //   147: aload_1
    //   148: iload #4
    //   150: invokevirtual skipField : (I)Z
    //   153: ifne -> 124
    //   156: goto -> 170
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual readUInt64 : ()J
    //   164: putfield value_ : J
    //   167: goto -> 124
    //   170: iconst_1
    //   171: istore #5
    //   173: goto -> 124
    //   176: astore_1
    //   177: goto -> 224
    //   180: astore_2
    //   181: new java/lang/RuntimeException
    //   184: astore_3
    //   185: new com/google/protobuf/InvalidProtocolBufferException
    //   188: astore_1
    //   189: aload_1
    //   190: aload_2
    //   191: invokevirtual getMessage : ()Ljava/lang/String;
    //   194: invokespecial <init> : (Ljava/lang/String;)V
    //   197: aload_3
    //   198: aload_1
    //   199: aload_0
    //   200: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   203: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   206: aload_3
    //   207: athrow
    //   208: astore_2
    //   209: new java/lang/RuntimeException
    //   212: astore_1
    //   213: aload_1
    //   214: aload_2
    //   215: aload_0
    //   216: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   219: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   222: aload_1
    //   223: athrow
    //   224: aload_1
    //   225: athrow
    //   226: getstatic com/google/protobuf/UInt64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/UInt64Value;
    //   229: areturn
    //   230: aload_2
    //   231: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   234: astore_1
    //   235: aload_3
    //   236: checkcast com/google/protobuf/UInt64Value
    //   239: astore_2
    //   240: aload_0
    //   241: getfield value_ : J
    //   244: lconst_0
    //   245: lcmp
    //   246: ifeq -> 255
    //   249: iconst_1
    //   250: istore #6
    //   252: goto -> 258
    //   255: iconst_0
    //   256: istore #6
    //   258: aload_0
    //   259: getfield value_ : J
    //   262: lstore #7
    //   264: aload_2
    //   265: getfield value_ : J
    //   268: lconst_0
    //   269: lcmp
    //   270: ifeq -> 279
    //   273: iconst_1
    //   274: istore #9
    //   276: goto -> 282
    //   279: iconst_0
    //   280: istore #9
    //   282: aload_0
    //   283: aload_1
    //   284: iload #6
    //   286: lload #7
    //   288: iload #9
    //   290: aload_2
    //   291: getfield value_ : J
    //   294: invokeinterface visitLong : (ZJZJ)J
    //   299: putfield value_ : J
    //   302: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   305: astore_1
    //   306: aload_0
    //   307: areturn
    //   308: new com/google/protobuf/UInt64Value$Builder
    //   311: dup
    //   312: aconst_null
    //   313: invokespecial <init> : (Lcom/google/protobuf/UInt64Value$1;)V
    //   316: areturn
    //   317: aconst_null
    //   318: areturn
    //   319: getstatic com/google/protobuf/UInt64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/UInt64Value;
    //   322: areturn
    //   323: new com/google/protobuf/UInt64Value
    //   326: dup
    //   327: invokespecial <init> : ()V
    //   330: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	208	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	180	java/io/IOException
    //   129	135	176	finally
    //   147	156	208	com/google/protobuf/InvalidProtocolBufferException
    //   147	156	180	java/io/IOException
    //   147	156	176	finally
    //   159	167	208	com/google/protobuf/InvalidProtocolBufferException
    //   159	167	180	java/io/IOException
    //   159	167	176	finally
    //   181	208	176	finally
    //   209	224	176	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.value_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeUInt64Size(1, l); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public long getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.value_;
    if (l != 0L)
      paramCodedOutputStream.writeUInt64(1, l); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UInt64Value, Builder> implements UInt64ValueOrBuilder {
    private Builder() {
      super(UInt64Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public long getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(long param1Long) {
      copyOnWrite();
      this.instance.setValue(param1Long);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\UInt64Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */