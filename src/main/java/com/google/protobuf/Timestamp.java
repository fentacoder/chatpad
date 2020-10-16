package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Timestamp extends GeneratedMessageLite<Timestamp, Timestamp.Builder> implements TimestampOrBuilder {
  private static final Timestamp DEFAULT_INSTANCE = new Timestamp();
  
  public static final int NANOS_FIELD_NUMBER = 2;
  
  private static volatile Parser<Timestamp> PARSER;
  
  public static final int SECONDS_FIELD_NUMBER = 1;
  
  private int nanos_;
  
  private long seconds_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearNanos() {
    this.nanos_ = 0;
  }
  
  private void clearSeconds() {
    this.seconds_ = 0L;
  }
  
  public static Timestamp getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Timestamp paramTimestamp) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramTimestamp);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Timestamp)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Timestamp parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Timestamp)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Timestamp parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Timestamp parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Timestamp parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Timestamp parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Timestamp>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Timestamp> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setNanos(int paramInt) {
    this.nanos_ = paramInt;
  }
  
  private void setSeconds(long paramLong) {
    this.seconds_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Timestamp$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 401, 2 -> 397, 3 -> 395, 4 -> 386, 5 -> 252, 6 -> 118, 7 -> 248, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Timestamp.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Timestamp
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Timestamp.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Timestamp.DEFAULT_INSTANCE : Lcom/google/protobuf/Timestamp;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Timestamp.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Timestamp
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Timestamp
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Timestamp.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
    //   148: if_icmpeq -> 181
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 170
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: goto -> 192
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual readInt32 : ()I
    //   175: putfield nanos_ : I
    //   178: goto -> 128
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual readInt64 : ()J
    //   186: putfield seconds_ : J
    //   189: goto -> 128
    //   192: iconst_1
    //   193: istore #6
    //   195: goto -> 128
    //   198: astore_1
    //   199: goto -> 246
    //   202: astore_1
    //   203: new java/lang/RuntimeException
    //   206: astore_3
    //   207: new com/google/protobuf/InvalidProtocolBufferException
    //   210: astore_2
    //   211: aload_2
    //   212: aload_1
    //   213: invokevirtual getMessage : ()Ljava/lang/String;
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: aload_3
    //   220: aload_2
    //   221: aload_0
    //   222: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   225: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   228: aload_3
    //   229: athrow
    //   230: astore_2
    //   231: new java/lang/RuntimeException
    //   234: astore_1
    //   235: aload_1
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: athrow
    //   246: aload_1
    //   247: athrow
    //   248: getstatic com/google/protobuf/Timestamp.DEFAULT_INSTANCE : Lcom/google/protobuf/Timestamp;
    //   251: areturn
    //   252: aload_2
    //   253: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   256: astore_1
    //   257: aload_3
    //   258: checkcast com/google/protobuf/Timestamp
    //   261: astore_2
    //   262: aload_0
    //   263: getfield seconds_ : J
    //   266: lconst_0
    //   267: lcmp
    //   268: ifeq -> 277
    //   271: iconst_1
    //   272: istore #7
    //   274: goto -> 280
    //   277: iconst_0
    //   278: istore #7
    //   280: aload_0
    //   281: getfield seconds_ : J
    //   284: lstore #8
    //   286: aload_2
    //   287: getfield seconds_ : J
    //   290: lconst_0
    //   291: lcmp
    //   292: ifeq -> 301
    //   295: iconst_1
    //   296: istore #10
    //   298: goto -> 304
    //   301: iconst_0
    //   302: istore #10
    //   304: aload_0
    //   305: aload_1
    //   306: iload #7
    //   308: lload #8
    //   310: iload #10
    //   312: aload_2
    //   313: getfield seconds_ : J
    //   316: invokeinterface visitLong : (ZJZJ)J
    //   321: putfield seconds_ : J
    //   324: aload_0
    //   325: getfield nanos_ : I
    //   328: ifeq -> 337
    //   331: iconst_1
    //   332: istore #7
    //   334: goto -> 340
    //   337: iconst_0
    //   338: istore #7
    //   340: aload_0
    //   341: getfield nanos_ : I
    //   344: istore #6
    //   346: iload #5
    //   348: istore #10
    //   350: aload_2
    //   351: getfield nanos_ : I
    //   354: ifeq -> 360
    //   357: iconst_1
    //   358: istore #10
    //   360: aload_0
    //   361: aload_1
    //   362: iload #7
    //   364: iload #6
    //   366: iload #10
    //   368: aload_2
    //   369: getfield nanos_ : I
    //   372: invokeinterface visitInt : (ZIZI)I
    //   377: putfield nanos_ : I
    //   380: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   383: astore_1
    //   384: aload_0
    //   385: areturn
    //   386: new com/google/protobuf/Timestamp$Builder
    //   389: dup
    //   390: aconst_null
    //   391: invokespecial <init> : (Lcom/google/protobuf/Timestamp$1;)V
    //   394: areturn
    //   395: aconst_null
    //   396: areturn
    //   397: getstatic com/google/protobuf/Timestamp.DEFAULT_INSTANCE : Lcom/google/protobuf/Timestamp;
    //   400: areturn
    //   401: new com/google/protobuf/Timestamp
    //   404: dup
    //   405: invokespecial <init> : ()V
    //   408: areturn
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
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public long getSeconds() {
    return this.seconds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    long l = this.seconds_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    int j = this.nanos_;
    int k = i;
    if (j != 0)
      k = i + CodedOutputStream.computeInt32Size(2, j); 
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.seconds_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    int i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Timestamp, Builder> implements TimestampOrBuilder {
    private Builder() {
      super(Timestamp.DEFAULT_INSTANCE);
    }
    
    public Builder clearNanos() {
      copyOnWrite();
      this.instance.clearNanos();
      return this;
    }
    
    public Builder clearSeconds() {
      copyOnWrite();
      this.instance.clearSeconds();
      return this;
    }
    
    public int getNanos() {
      return this.instance.getNanos();
    }
    
    public long getSeconds() {
      return this.instance.getSeconds();
    }
    
    public Builder setNanos(int param1Int) {
      copyOnWrite();
      this.instance.setNanos(param1Int);
      return this;
    }
    
    public Builder setSeconds(long param1Long) {
      copyOnWrite();
      this.instance.setSeconds(param1Long);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Timestamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */