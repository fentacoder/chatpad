package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class BoolValue extends GeneratedMessageLite<BoolValue, BoolValue.Builder> implements BoolValueOrBuilder {
  private static final BoolValue DEFAULT_INSTANCE = new BoolValue();
  
  private static volatile Parser<BoolValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private boolean value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = false;
  }
  
  public static BoolValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BoolValue paramBoolValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBoolValue);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BoolValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(boolean paramBoolean) {
    this.value_ = paramBoolean;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/BoolValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 290, 2 -> 286, 3 -> 284, 4 -> 275, 5 -> 229, 6 -> 110, 7 -> 225, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/BoolValue
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/BoolValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/BoolValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   141: bipush #8
    //   143: if_icmpeq -> 158
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 169
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual readBool : ()Z
    //   163: putfield value_ : Z
    //   166: goto -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: astore_1
    //   176: goto -> 223
    //   179: astore_1
    //   180: new java/lang/RuntimeException
    //   183: astore_2
    //   184: new com/google/protobuf/InvalidProtocolBufferException
    //   187: astore_3
    //   188: aload_3
    //   189: aload_1
    //   190: invokevirtual getMessage : ()Ljava/lang/String;
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: aload_2
    //   197: aload_3
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
    //   225: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   228: areturn
    //   229: aload_2
    //   230: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   233: astore_1
    //   234: aload_3
    //   235: checkcast com/google/protobuf/BoolValue
    //   238: astore_2
    //   239: aload_0
    //   240: getfield value_ : Z
    //   243: istore #6
    //   245: aload_2
    //   246: getfield value_ : Z
    //   249: istore #7
    //   251: aload_0
    //   252: aload_1
    //   253: iload #6
    //   255: iload #6
    //   257: iload #7
    //   259: iload #7
    //   261: invokeinterface visitBoolean : (ZZZZ)Z
    //   266: putfield value_ : Z
    //   269: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   272: astore_1
    //   273: aload_0
    //   274: areturn
    //   275: new com/google/protobuf/BoolValue$Builder
    //   278: dup
    //   279: aconst_null
    //   280: invokespecial <init> : (Lcom/google/protobuf/BoolValue$1;)V
    //   283: areturn
    //   284: aconst_null
    //   285: areturn
    //   286: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   289: areturn
    //   290: new com/google/protobuf/BoolValue
    //   293: dup
    //   294: invokespecial <init> : ()V
    //   297: areturn
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
    boolean bool = this.value_;
    if (bool)
      i = 0 + CodedOutputStream.computeBoolSize(1, bool); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    boolean bool = this.value_;
    if (bool)
      paramCodedOutputStream.writeBool(1, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BoolValue, Builder> implements BoolValueOrBuilder {
    private Builder() {
      super(BoolValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public boolean getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setValue(param1Boolean);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\BoolValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */