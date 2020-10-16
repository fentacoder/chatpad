package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Empty extends GeneratedMessageLite<Empty, Empty.Builder> implements EmptyOrBuilder {
  private static final Empty DEFAULT_INSTANCE = new Empty();
  
  private static volatile Parser<Empty> PARSER;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  public static Empty getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Empty paramEmpty) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEmpty);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Empty)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Empty parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Empty parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Empty parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Empty parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Empty>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Empty> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Empty$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 243, 2 -> 239, 3 -> 237, 4 -> 228, 5 -> 212, 6 -> 110, 7 -> 208, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/Empty
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/Empty
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/Empty
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/Empty.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 208
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 152
    //   139: aload_1
    //   140: iload #5
    //   142: invokevirtual skipField : (I)Z
    //   145: istore #6
    //   147: iload #6
    //   149: ifne -> 123
    //   152: iconst_1
    //   153: istore #4
    //   155: goto -> 123
    //   158: astore_1
    //   159: goto -> 206
    //   162: astore_3
    //   163: new java/lang/RuntimeException
    //   166: astore_2
    //   167: new com/google/protobuf/InvalidProtocolBufferException
    //   170: astore_1
    //   171: aload_1
    //   172: aload_3
    //   173: invokevirtual getMessage : ()Ljava/lang/String;
    //   176: invokespecial <init> : (Ljava/lang/String;)V
    //   179: aload_2
    //   180: aload_1
    //   181: aload_0
    //   182: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   185: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: new java/lang/RuntimeException
    //   194: astore_2
    //   195: aload_2
    //   196: aload_1
    //   197: aload_0
    //   198: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   201: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: athrow
    //   206: aload_1
    //   207: athrow
    //   208: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   211: areturn
    //   212: aload_2
    //   213: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   216: astore_1
    //   217: aload_3
    //   218: checkcast com/google/protobuf/Empty
    //   221: astore_1
    //   222: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   225: astore_1
    //   226: aload_0
    //   227: areturn
    //   228: new com/google/protobuf/Empty$Builder
    //   231: dup
    //   232: aconst_null
    //   233: invokespecial <init> : (Lcom/google/protobuf/Empty$1;)V
    //   236: areturn
    //   237: aconst_null
    //   238: areturn
    //   239: getstatic com/google/protobuf/Empty.DEFAULT_INSTANCE : Lcom/google/protobuf/Empty;
    //   242: areturn
    //   243: new com/google/protobuf/Empty
    //   246: dup
    //   247: invokespecial <init> : ()V
    //   250: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	190	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	162	java/io/IOException
    //   128	134	158	finally
    //   139	147	190	com/google/protobuf/InvalidProtocolBufferException
    //   139	147	162	java/io/IOException
    //   139	147	158	finally
    //   163	190	158	finally
    //   191	206	158	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    this.memoizedSerializedSize = 0;
    return 0;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {}
  
  public static final class Builder extends GeneratedMessageLite.Builder<Empty, Builder> implements EmptyOrBuilder {
    private Builder() {
      super(Empty.DEFAULT_INSTANCE);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Empty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */