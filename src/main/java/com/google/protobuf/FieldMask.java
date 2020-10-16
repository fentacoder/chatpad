package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class FieldMask extends GeneratedMessageLite<FieldMask, FieldMask.Builder> implements FieldMaskOrBuilder {
  private static final FieldMask DEFAULT_INSTANCE = new FieldMask();
  
  private static volatile Parser<FieldMask> PARSER;
  
  public static final int PATHS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<String> paths_ = GeneratedMessageLite.emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllPaths(Iterable<String> paramIterable) {
    ensurePathsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.paths_);
  }
  
  private void addPaths(String paramString) {
    if (paramString != null) {
      ensurePathsIsMutable();
      this.paths_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addPathsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensurePathsIsMutable();
      this.paths_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearPaths() {
    this.paths_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensurePathsIsMutable() {
    if (!this.paths_.isModifiable())
      this.paths_ = GeneratedMessageLite.mutableCopy(this.paths_); 
  }
  
  public static FieldMask getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(FieldMask paramFieldMask) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramFieldMask);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (FieldMask)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static FieldMask parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static FieldMask parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static FieldMask parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static FieldMask parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<FieldMask>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<FieldMask> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setPaths(int paramInt, String paramString) {
    if (paramString != null) {
      ensurePathsIsMutable();
      this.paths_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/FieldMask$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 318, 2 -> 314, 3 -> 303, 4 -> 294, 5 -> 260, 6 -> 110, 7 -> 256, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/FieldMask
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/FieldMask
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/FieldMask
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/FieldMask.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 256
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 200
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 158
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 200
    //   158: aload_1
    //   159: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   162: astore_2
    //   163: aload_0
    //   164: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   167: invokeinterface isModifiable : ()Z
    //   172: ifne -> 186
    //   175: aload_0
    //   176: aload_0
    //   177: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   180: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   183: putfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   186: aload_0
    //   187: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   190: aload_2
    //   191: invokeinterface add : (Ljava/lang/Object;)Z
    //   196: pop
    //   197: goto -> 123
    //   200: iconst_1
    //   201: istore #4
    //   203: goto -> 123
    //   206: astore_1
    //   207: goto -> 254
    //   210: astore_1
    //   211: new java/lang/RuntimeException
    //   214: astore_3
    //   215: new com/google/protobuf/InvalidProtocolBufferException
    //   218: astore_2
    //   219: aload_2
    //   220: aload_1
    //   221: invokevirtual getMessage : ()Ljava/lang/String;
    //   224: invokespecial <init> : (Ljava/lang/String;)V
    //   227: aload_3
    //   228: aload_2
    //   229: aload_0
    //   230: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   233: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   236: aload_3
    //   237: athrow
    //   238: astore_1
    //   239: new java/lang/RuntimeException
    //   242: astore_2
    //   243: aload_2
    //   244: aload_1
    //   245: aload_0
    //   246: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   249: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   252: aload_2
    //   253: athrow
    //   254: aload_1
    //   255: athrow
    //   256: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   259: areturn
    //   260: aload_2
    //   261: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   264: astore_1
    //   265: aload_3
    //   266: checkcast com/google/protobuf/FieldMask
    //   269: astore_2
    //   270: aload_0
    //   271: aload_1
    //   272: aload_0
    //   273: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   276: aload_2
    //   277: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   280: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   285: putfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   288: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   291: astore_1
    //   292: aload_0
    //   293: areturn
    //   294: new com/google/protobuf/FieldMask$Builder
    //   297: dup
    //   298: aconst_null
    //   299: invokespecial <init> : (Lcom/google/protobuf/FieldMask$1;)V
    //   302: areturn
    //   303: aload_0
    //   304: getfield paths_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   307: invokeinterface makeImmutable : ()V
    //   312: aconst_null
    //   313: areturn
    //   314: getstatic com/google/protobuf/FieldMask.DEFAULT_INSTANCE : Lcom/google/protobuf/FieldMask;
    //   317: areturn
    //   318: new com/google/protobuf/FieldMask
    //   321: dup
    //   322: invokespecial <init> : ()V
    //   325: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	238	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	210	java/io/IOException
    //   128	134	206	finally
    //   146	155	238	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	210	java/io/IOException
    //   146	155	206	finally
    //   158	186	238	com/google/protobuf/InvalidProtocolBufferException
    //   158	186	210	java/io/IOException
    //   158	186	206	finally
    //   186	197	238	com/google/protobuf/InvalidProtocolBufferException
    //   186	197	210	java/io/IOException
    //   186	197	206	finally
    //   211	238	206	finally
    //   239	254	206	finally
  }
  
  public String getPaths(int paramInt) {
    return this.paths_.get(paramInt);
  }
  
  public ByteString getPathsBytes(int paramInt) {
    return ByteString.copyFromUtf8(this.paths_.get(paramInt));
  }
  
  public int getPathsCount() {
    return this.paths_.size();
  }
  
  public List<String> getPathsList() {
    return this.paths_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = i;
    while (i < this.paths_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag(this.paths_.get(i));
      i++;
    } 
    i = 0 + j + getPathsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.paths_.size(); b++)
      paramCodedOutputStream.writeString(1, this.paths_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldMask, Builder> implements FieldMaskOrBuilder {
    private Builder() {
      super(FieldMask.DEFAULT_INSTANCE);
    }
    
    public Builder addAllPaths(Iterable<String> param1Iterable) {
      copyOnWrite();
      this.instance.addAllPaths(param1Iterable);
      return this;
    }
    
    public Builder addPaths(String param1String) {
      copyOnWrite();
      this.instance.addPaths(param1String);
      return this;
    }
    
    public Builder addPathsBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.addPathsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearPaths() {
      copyOnWrite();
      this.instance.clearPaths();
      return this;
    }
    
    public String getPaths(int param1Int) {
      return this.instance.getPaths(param1Int);
    }
    
    public ByteString getPathsBytes(int param1Int) {
      return this.instance.getPathsBytes(param1Int);
    }
    
    public int getPathsCount() {
      return this.instance.getPathsCount();
    }
    
    public List<String> getPathsList() {
      return Collections.unmodifiableList(this.instance.getPathsList());
    }
    
    public Builder setPaths(int param1Int, String param1String) {
      copyOnWrite();
      this.instance.setPaths(param1Int, param1String);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\FieldMask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */