package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Mixin extends GeneratedMessageLite<Mixin, Mixin.Builder> implements MixinOrBuilder {
  private static final Mixin DEFAULT_INSTANCE = new Mixin();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Mixin> PARSER;
  
  public static final int ROOT_FIELD_NUMBER = 2;
  
  private String name_ = "";
  
  private String root_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearRoot() {
    this.root_ = getDefaultInstance().getRoot();
  }
  
  public static Mixin getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Mixin paramMixin) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMixin);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Mixin)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Mixin parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Mixin)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Mixin parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Mixin parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Mixin parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Mixin parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Mixin>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Mixin> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRoot(String paramString) {
    if (paramString != null) {
      this.root_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRootBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.root_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Mixin$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 350, 2 -> 346, 3 -> 344, 4 -> 335, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/Mixin.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/Mixin
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/Mixin.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/Mixin.DEFAULT_INSTANCE : Lcom/google/protobuf/Mixin;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/Mixin.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/Mixin
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/Mixin
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/Mixin.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 243
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 187
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 176
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 165
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 187
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   170: putfield root_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   181: putfield name_ : Ljava/lang/String;
    //   184: goto -> 123
    //   187: iconst_1
    //   188: istore #4
    //   190: goto -> 123
    //   193: astore_1
    //   194: goto -> 241
    //   197: astore_1
    //   198: new java/lang/RuntimeException
    //   201: astore_3
    //   202: new com/google/protobuf/InvalidProtocolBufferException
    //   205: astore_2
    //   206: aload_2
    //   207: aload_1
    //   208: invokevirtual getMessage : ()Ljava/lang/String;
    //   211: invokespecial <init> : (Ljava/lang/String;)V
    //   214: aload_3
    //   215: aload_2
    //   216: aload_0
    //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   223: aload_3
    //   224: athrow
    //   225: astore_1
    //   226: new java/lang/RuntimeException
    //   229: astore_2
    //   230: aload_2
    //   231: aload_1
    //   232: aload_0
    //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   239: aload_2
    //   240: athrow
    //   241: aload_1
    //   242: athrow
    //   243: getstatic com/google/protobuf/Mixin.DEFAULT_INSTANCE : Lcom/google/protobuf/Mixin;
    //   246: areturn
    //   247: aload_2
    //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   251: astore_1
    //   252: aload_3
    //   253: checkcast com/google/protobuf/Mixin
    //   256: astore_2
    //   257: aload_0
    //   258: aload_1
    //   259: aload_0
    //   260: getfield name_ : Ljava/lang/String;
    //   263: invokevirtual isEmpty : ()Z
    //   266: iconst_1
    //   267: ixor
    //   268: aload_0
    //   269: getfield name_ : Ljava/lang/String;
    //   272: aload_2
    //   273: getfield name_ : Ljava/lang/String;
    //   276: invokevirtual isEmpty : ()Z
    //   279: iconst_1
    //   280: ixor
    //   281: aload_2
    //   282: getfield name_ : Ljava/lang/String;
    //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   290: putfield name_ : Ljava/lang/String;
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield root_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_0
    //   305: getfield root_ : Ljava/lang/String;
    //   308: iconst_1
    //   309: aload_2
    //   310: getfield root_ : Ljava/lang/String;
    //   313: invokevirtual isEmpty : ()Z
    //   316: ixor
    //   317: aload_2
    //   318: getfield root_ : Ljava/lang/String;
    //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   326: putfield root_ : Ljava/lang/String;
    //   329: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   332: astore_1
    //   333: aload_0
    //   334: areturn
    //   335: new com/google/protobuf/Mixin$Builder
    //   338: dup
    //   339: aconst_null
    //   340: invokespecial <init> : (Lcom/google/protobuf/Mixin$1;)V
    //   343: areturn
    //   344: aconst_null
    //   345: areturn
    //   346: getstatic com/google/protobuf/Mixin.DEFAULT_INSTANCE : Lcom/google/protobuf/Mixin;
    //   349: areturn
    //   350: new com/google/protobuf/Mixin
    //   353: dup
    //   354: invokespecial <init> : ()V
    //   357: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	225	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	197	java/io/IOException
    //   128	134	193	finally
    //   153	162	225	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	197	java/io/IOException
    //   153	162	193	finally
    //   165	173	225	com/google/protobuf/InvalidProtocolBufferException
    //   165	173	197	java/io/IOException
    //   165	173	193	finally
    //   176	184	225	com/google/protobuf/InvalidProtocolBufferException
    //   176	184	197	java/io/IOException
    //   176	184	193	finally
    //   198	225	193	finally
    //   226	241	193	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getRoot() {
    return this.root_;
  }
  
  public ByteString getRootBytes() {
    return ByteString.copyFromUtf8(this.root_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.name_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    int j = i;
    if (!this.root_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getRoot()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (!this.root_.isEmpty())
      paramCodedOutputStream.writeString(2, getRoot()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Mixin, Builder> implements MixinOrBuilder {
    private Builder() {
      super(Mixin.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearRoot() {
      copyOnWrite();
      this.instance.clearRoot();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public String getRoot() {
      return this.instance.getRoot();
    }
    
    public ByteString getRootBytes() {
      return this.instance.getRootBytes();
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setRoot(String param1String) {
      copyOnWrite();
      this.instance.setRoot(param1String);
      return this;
    }
    
    public Builder setRootBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setRootBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Mixin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */