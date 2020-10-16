package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Int32Value extends GeneratedMessageLite<Int32Value, Int32Value.Builder> implements Int32ValueOrBuilder {
  private static final Int32Value DEFAULT_INSTANCE = new Int32Value();
  
  private static volatile Parser<Int32Value> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private int value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0;
  }
  
  public static Int32Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Int32Value paramInt32Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramInt32Value);
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Int32Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int32Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Int32Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Int32Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Int32Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int32Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Int32Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int32Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Int32Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(int paramInt) {
    this.value_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Int32Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 317, 2 -> 313, 3 -> 311, 4 -> 302, 5 -> 234, 6 -> 118, 7 -> 230, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Int32Value
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Int32Value
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Int32Value
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Int32Value.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
    //   148: if_icmpeq -> 163
    //   151: aload_1
    //   152: iload #4
    //   154: invokevirtual skipField : (I)Z
    //   157: ifne -> 128
    //   160: goto -> 174
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual readInt32 : ()I
    //   168: putfield value_ : I
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
    //   212: astore_2
    //   213: new java/lang/RuntimeException
    //   216: astore_1
    //   217: aload_1
    //   218: aload_2
    //   219: aload_0
    //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: athrow
    //   228: aload_1
    //   229: athrow
    //   230: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   233: areturn
    //   234: aload_2
    //   235: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   238: astore_1
    //   239: aload_3
    //   240: checkcast com/google/protobuf/Int32Value
    //   243: astore_2
    //   244: aload_0
    //   245: getfield value_ : I
    //   248: ifeq -> 257
    //   251: iconst_1
    //   252: istore #7
    //   254: goto -> 260
    //   257: iconst_0
    //   258: istore #7
    //   260: aload_0
    //   261: getfield value_ : I
    //   264: istore #6
    //   266: aload_2
    //   267: getfield value_ : I
    //   270: ifeq -> 276
    //   273: iconst_1
    //   274: istore #5
    //   276: aload_0
    //   277: aload_1
    //   278: iload #7
    //   280: iload #6
    //   282: iload #5
    //   284: aload_2
    //   285: getfield value_ : I
    //   288: invokeinterface visitInt : (ZIZI)I
    //   293: putfield value_ : I
    //   296: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   299: astore_1
    //   300: aload_0
    //   301: areturn
    //   302: new com/google/protobuf/Int32Value$Builder
    //   305: dup
    //   306: aconst_null
    //   307: invokespecial <init> : (Lcom/google/protobuf/Int32Value$1;)V
    //   310: areturn
    //   311: aconst_null
    //   312: areturn
    //   313: getstatic com/google/protobuf/Int32Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int32Value;
    //   316: areturn
    //   317: new com/google/protobuf/Int32Value
    //   320: dup
    //   321: invokespecial <init> : ()V
    //   324: areturn
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
    int j = this.value_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.value_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Int32Value, Builder> implements Int32ValueOrBuilder {
    private Builder() {
      super(Int32Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public int getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(int param1Int) {
      copyOnWrite();
      this.instance.setValue(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Int32Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */