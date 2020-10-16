package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class BytesValue extends GeneratedMessageLite<BytesValue, BytesValue.Builder> implements BytesValueOrBuilder {
  private static final BytesValue DEFAULT_INSTANCE = new BytesValue();
  
  private static volatile Parser<BytesValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private ByteString value_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = getDefaultInstance().getValue();
  }
  
  public static BytesValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BytesValue paramBytesValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBytesValue);
  }
  
  public static BytesValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BytesValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BytesValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BytesValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BytesValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BytesValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BytesValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BytesValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BytesValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BytesValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BytesValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BytesValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BytesValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BytesValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(ByteString paramByteString) {
    if (paramByteString != null) {
      this.value_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/BytesValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 321, 2 -> 317, 3 -> 315, 4 -> 306, 5 -> 234, 6 -> 118, 7 -> 230, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/BytesValue.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/BytesValue
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/BytesValue.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/BytesValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BytesValue;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/BytesValue.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/BytesValue
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/BytesValue
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/BytesValue.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 230
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 174
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 163
    //   151: aload_1
    //   152: iload #4
    //   154: invokevirtual skipField : (I)Z
    //   157: ifne -> 128
    //   160: goto -> 174
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   168: putfield value_ : Lcom/google/protobuf/ByteString;
    //   171: goto -> 128
    //   174: iconst_1
    //   175: istore #6
    //   177: goto -> 128
    //   180: astore_1
    //   181: goto -> 228
    //   184: astore_3
    //   185: new java/lang/RuntimeException
    //   188: astore_1
    //   189: new com/google/protobuf/InvalidProtocolBufferException
    //   192: astore_2
    //   193: aload_2
    //   194: aload_3
    //   195: invokevirtual getMessage : ()Ljava/lang/String;
    //   198: invokespecial <init> : (Ljava/lang/String;)V
    //   201: aload_1
    //   202: aload_2
    //   203: aload_0
    //   204: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   207: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: new java/lang/RuntimeException
    //   216: astore_2
    //   217: aload_2
    //   218: aload_1
    //   219: aload_0
    //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: athrow
    //   228: aload_1
    //   229: athrow
    //   230: getstatic com/google/protobuf/BytesValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BytesValue;
    //   233: areturn
    //   234: aload_2
    //   235: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   238: astore_1
    //   239: aload_3
    //   240: checkcast com/google/protobuf/BytesValue
    //   243: astore_2
    //   244: aload_0
    //   245: getfield value_ : Lcom/google/protobuf/ByteString;
    //   248: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   251: if_acmpeq -> 260
    //   254: iconst_1
    //   255: istore #7
    //   257: goto -> 263
    //   260: iconst_0
    //   261: istore #7
    //   263: aload_0
    //   264: getfield value_ : Lcom/google/protobuf/ByteString;
    //   267: astore_3
    //   268: aload_2
    //   269: getfield value_ : Lcom/google/protobuf/ByteString;
    //   272: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   275: if_acmpeq -> 281
    //   278: iconst_1
    //   279: istore #5
    //   281: aload_0
    //   282: aload_1
    //   283: iload #7
    //   285: aload_3
    //   286: iload #5
    //   288: aload_2
    //   289: getfield value_ : Lcom/google/protobuf/ByteString;
    //   292: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   297: putfield value_ : Lcom/google/protobuf/ByteString;
    //   300: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   303: astore_1
    //   304: aload_0
    //   305: areturn
    //   306: new com/google/protobuf/BytesValue$Builder
    //   309: dup
    //   310: aconst_null
    //   311: invokespecial <init> : (Lcom/google/protobuf/BytesValue$1;)V
    //   314: areturn
    //   315: aconst_null
    //   316: areturn
    //   317: getstatic com/google/protobuf/BytesValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BytesValue;
    //   320: areturn
    //   321: new com/google/protobuf/BytesValue
    //   324: dup
    //   325: invokespecial <init> : ()V
    //   328: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	212	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	184	java/io/IOException
    //   133	139	180	finally
    //   151	160	212	com/google/protobuf/InvalidProtocolBufferException
    //   151	160	184	java/io/IOException
    //   151	160	180	finally
    //   163	171	212	com/google/protobuf/InvalidProtocolBufferException
    //   163	171	184	java/io/IOException
    //   163	171	180	finally
    //   185	212	180	finally
    //   213	228	180	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.value_.isEmpty())
      i = 0 + CodedOutputStream.computeBytesSize(1, this.value_); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ByteString getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.value_.isEmpty())
      paramCodedOutputStream.writeBytes(1, this.value_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BytesValue, Builder> implements BytesValueOrBuilder {
    private Builder() {
      super(BytesValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public ByteString getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setValue(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\BytesValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */