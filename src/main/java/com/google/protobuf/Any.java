package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Any extends GeneratedMessageLite<Any, Any.Builder> implements AnyOrBuilder {
  private static final Any DEFAULT_INSTANCE = new Any();
  
  private static volatile Parser<Any> PARSER;
  
  public static final int TYPE_URL_FIELD_NUMBER = 1;
  
  public static final int VALUE_FIELD_NUMBER = 2;
  
  private String typeUrl_ = "";
  
  private ByteString value_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearTypeUrl() {
    this.typeUrl_ = getDefaultInstance().getTypeUrl();
  }
  
  private void clearValue() {
    this.value_ = getDefaultInstance().getValue();
  }
  
  public static Any getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Any paramAny) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramAny);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Any)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Any parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Any)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Any parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Any parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Any parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Any parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Any parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Any>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Any> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setTypeUrl(String paramString) {
    if (paramString != null) {
      this.typeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.typeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
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
    //   0: getstatic com/google/protobuf/Any$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 375, 2 -> 371, 3 -> 369, 4 -> 360, 5 -> 252, 6 -> 118, 7 -> 248, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Any.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Any
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Any.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Any.DEFAULT_INSTANCE : Lcom/google/protobuf/Any;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Any.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Any
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Any
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Any.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 248
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 192
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 181
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 170
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: goto -> 192
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   175: putfield value_ : Lcom/google/protobuf/ByteString;
    //   178: goto -> 128
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   186: putfield typeUrl_ : Ljava/lang/String;
    //   189: goto -> 128
    //   192: iconst_1
    //   193: istore #6
    //   195: goto -> 128
    //   198: astore_1
    //   199: goto -> 246
    //   202: astore_3
    //   203: new java/lang/RuntimeException
    //   206: astore_1
    //   207: new com/google/protobuf/InvalidProtocolBufferException
    //   210: astore_2
    //   211: aload_2
    //   212: aload_3
    //   213: invokevirtual getMessage : ()Ljava/lang/String;
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: aload_1
    //   220: aload_2
    //   221: aload_0
    //   222: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   225: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: athrow
    //   230: astore_1
    //   231: new java/lang/RuntimeException
    //   234: astore_2
    //   235: aload_2
    //   236: aload_1
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_2
    //   245: athrow
    //   246: aload_1
    //   247: athrow
    //   248: getstatic com/google/protobuf/Any.DEFAULT_INSTANCE : Lcom/google/protobuf/Any;
    //   251: areturn
    //   252: aload_2
    //   253: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   256: astore_1
    //   257: aload_3
    //   258: checkcast com/google/protobuf/Any
    //   261: astore_2
    //   262: aload_0
    //   263: aload_1
    //   264: aload_0
    //   265: getfield typeUrl_ : Ljava/lang/String;
    //   268: invokevirtual isEmpty : ()Z
    //   271: iconst_1
    //   272: ixor
    //   273: aload_0
    //   274: getfield typeUrl_ : Ljava/lang/String;
    //   277: aload_2
    //   278: getfield typeUrl_ : Ljava/lang/String;
    //   281: invokevirtual isEmpty : ()Z
    //   284: iconst_1
    //   285: ixor
    //   286: aload_2
    //   287: getfield typeUrl_ : Ljava/lang/String;
    //   290: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   295: putfield typeUrl_ : Ljava/lang/String;
    //   298: aload_0
    //   299: getfield value_ : Lcom/google/protobuf/ByteString;
    //   302: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   305: if_acmpeq -> 314
    //   308: iconst_1
    //   309: istore #7
    //   311: goto -> 317
    //   314: iconst_0
    //   315: istore #7
    //   317: aload_0
    //   318: getfield value_ : Lcom/google/protobuf/ByteString;
    //   321: astore_3
    //   322: aload_2
    //   323: getfield value_ : Lcom/google/protobuf/ByteString;
    //   326: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   329: if_acmpeq -> 335
    //   332: iconst_1
    //   333: istore #5
    //   335: aload_0
    //   336: aload_1
    //   337: iload #7
    //   339: aload_3
    //   340: iload #5
    //   342: aload_2
    //   343: getfield value_ : Lcom/google/protobuf/ByteString;
    //   346: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   351: putfield value_ : Lcom/google/protobuf/ByteString;
    //   354: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   357: astore_1
    //   358: aload_0
    //   359: areturn
    //   360: new com/google/protobuf/Any$Builder
    //   363: dup
    //   364: aconst_null
    //   365: invokespecial <init> : (Lcom/google/protobuf/Any$1;)V
    //   368: areturn
    //   369: aconst_null
    //   370: areturn
    //   371: getstatic com/google/protobuf/Any.DEFAULT_INSTANCE : Lcom/google/protobuf/Any;
    //   374: areturn
    //   375: new com/google/protobuf/Any
    //   378: dup
    //   379: invokespecial <init> : ()V
    //   382: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	230	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	202	java/io/IOException
    //   133	139	198	finally
    //   158	167	230	com/google/protobuf/InvalidProtocolBufferException
    //   158	167	202	java/io/IOException
    //   158	167	198	finally
    //   170	178	230	com/google/protobuf/InvalidProtocolBufferException
    //   170	178	202	java/io/IOException
    //   170	178	198	finally
    //   181	189	230	com/google/protobuf/InvalidProtocolBufferException
    //   181	189	202	java/io/IOException
    //   181	189	198	finally
    //   203	230	198	finally
    //   231	246	198	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.typeUrl_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getTypeUrl()); 
    int j = i;
    if (!this.value_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(2, this.value_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getTypeUrl() {
    return this.typeUrl_;
  }
  
  public ByteString getTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.typeUrl_);
  }
  
  public ByteString getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.typeUrl_.isEmpty())
      paramCodedOutputStream.writeString(1, getTypeUrl()); 
    if (!this.value_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.value_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Any, Builder> implements AnyOrBuilder {
    private Builder() {
      super(Any.DEFAULT_INSTANCE);
    }
    
    public Builder clearTypeUrl() {
      copyOnWrite();
      this.instance.clearTypeUrl();
      return this;
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public String getTypeUrl() {
      return this.instance.getTypeUrl();
    }
    
    public ByteString getTypeUrlBytes() {
      return this.instance.getTypeUrlBytes();
    }
    
    public ByteString getValue() {
      return this.instance.getValue();
    }
    
    public Builder setTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setTypeUrl(param1String);
      return this;
    }
    
    public Builder setTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setTypeUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setValue(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setValue(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Any.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */