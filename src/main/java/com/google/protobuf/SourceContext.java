package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class SourceContext extends GeneratedMessageLite<SourceContext, SourceContext.Builder> implements SourceContextOrBuilder {
  private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
  
  public static final int FILE_NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<SourceContext> PARSER;
  
  private String fileName_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFileName() {
    this.fileName_ = getDefaultInstance().getFileName();
  }
  
  public static SourceContext getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceContext paramSourceContext) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSourceContext);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceContext> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFileName(String paramString) {
    if (paramString != null) {
      this.fileName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFileNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.fileName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/SourceContext$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 296, 2 -> 292, 3 -> 290, 4 -> 281, 5 -> 229, 6 -> 110, 7 -> 225, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/SourceContext
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/SourceContext
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/SourceContext
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
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
    //   163: putfield fileName_ : Ljava/lang/String;
    //   166: goto -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: astore_1
    //   176: goto -> 223
    //   179: astore_3
    //   180: new java/lang/RuntimeException
    //   183: astore_2
    //   184: new com/google/protobuf/InvalidProtocolBufferException
    //   187: astore_1
    //   188: aload_1
    //   189: aload_3
    //   190: invokevirtual getMessage : ()Ljava/lang/String;
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: aload_2
    //   197: aload_1
    //   198: aload_0
    //   199: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   202: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: new java/lang/RuntimeException
    //   211: astore_2
    //   212: aload_2
    //   213: aload_1
    //   214: aload_0
    //   215: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   218: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   221: aload_2
    //   222: athrow
    //   223: aload_1
    //   224: athrow
    //   225: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   228: areturn
    //   229: aload_2
    //   230: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   233: astore_1
    //   234: aload_3
    //   235: checkcast com/google/protobuf/SourceContext
    //   238: astore_2
    //   239: aload_0
    //   240: aload_1
    //   241: aload_0
    //   242: getfield fileName_ : Ljava/lang/String;
    //   245: invokevirtual isEmpty : ()Z
    //   248: iconst_1
    //   249: ixor
    //   250: aload_0
    //   251: getfield fileName_ : Ljava/lang/String;
    //   254: iconst_1
    //   255: aload_2
    //   256: getfield fileName_ : Ljava/lang/String;
    //   259: invokevirtual isEmpty : ()Z
    //   262: ixor
    //   263: aload_2
    //   264: getfield fileName_ : Ljava/lang/String;
    //   267: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   272: putfield fileName_ : Ljava/lang/String;
    //   275: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   278: astore_1
    //   279: aload_0
    //   280: areturn
    //   281: new com/google/protobuf/SourceContext$Builder
    //   284: dup
    //   285: aconst_null
    //   286: invokespecial <init> : (Lcom/google/protobuf/SourceContext$1;)V
    //   289: areturn
    //   290: aconst_null
    //   291: areturn
    //   292: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   295: areturn
    //   296: new com/google/protobuf/SourceContext
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
  
  public String getFileName() {
    return this.fileName_;
  }
  
  public ByteString getFileNameBytes() {
    return ByteString.copyFromUtf8(this.fileName_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.fileName_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getFileName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.fileName_.isEmpty())
      paramCodedOutputStream.writeString(1, getFileName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<SourceContext, Builder> implements SourceContextOrBuilder {
    private Builder() {
      super(SourceContext.DEFAULT_INSTANCE);
    }
    
    public Builder clearFileName() {
      copyOnWrite();
      this.instance.clearFileName();
      return this;
    }
    
    public String getFileName() {
      return this.instance.getFileName();
    }
    
    public ByteString getFileNameBytes() {
      return this.instance.getFileNameBytes();
    }
    
    public Builder setFileName(String param1String) {
      copyOnWrite();
      this.instance.setFileName(param1String);
      return this;
    }
    
    public Builder setFileNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setFileNameBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\SourceContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */