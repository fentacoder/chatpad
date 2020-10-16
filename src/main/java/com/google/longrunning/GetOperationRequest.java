package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class GetOperationRequest extends GeneratedMessageLite<GetOperationRequest, GetOperationRequest.Builder> implements GetOperationRequestOrBuilder {
  private static final GetOperationRequest DEFAULT_INSTANCE = new GetOperationRequest();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<GetOperationRequest> PARSER;
  
  private String name_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  public static GetOperationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetOperationRequest paramGetOperationRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetOperationRequest);
  }
  
  public static GetOperationRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (GetOperationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetOperationRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetOperationRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetOperationRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetOperationRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetOperationRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetOperationRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetOperationRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetOperationRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetOperationRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static GetOperationRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetOperationRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetOperationRequest> parser() {
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/GetOperationRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 296, 2 -> 292, 3 -> 290, 4 -> 281, 5 -> 229, 6 -> 110, 7 -> 225, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/longrunning/GetOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/longrunning/GetOperationRequest
    //   72: monitorenter
    //   73: getstatic com/google/longrunning/GetOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/longrunning/GetOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/GetOperationRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/longrunning/GetOperationRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/longrunning/GetOperationRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/longrunning/GetOperationRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/longrunning/GetOperationRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   163: putfield name_ : Ljava/lang/String;
    //   166: goto -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: astore_1
    //   176: goto -> 223
    //   179: astore_2
    //   180: new java/lang/RuntimeException
    //   183: astore_1
    //   184: new com/google/protobuf/InvalidProtocolBufferException
    //   187: astore_3
    //   188: aload_3
    //   189: aload_2
    //   190: invokevirtual getMessage : ()Ljava/lang/String;
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: aload_1
    //   197: aload_3
    //   198: aload_0
    //   199: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   202: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   205: aload_1
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
    //   225: getstatic com/google/longrunning/GetOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/GetOperationRequest;
    //   228: areturn
    //   229: aload_2
    //   230: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   233: astore_1
    //   234: aload_3
    //   235: checkcast com/google/longrunning/GetOperationRequest
    //   238: astore_2
    //   239: aload_0
    //   240: aload_1
    //   241: aload_0
    //   242: getfield name_ : Ljava/lang/String;
    //   245: invokevirtual isEmpty : ()Z
    //   248: iconst_1
    //   249: ixor
    //   250: aload_0
    //   251: getfield name_ : Ljava/lang/String;
    //   254: iconst_1
    //   255: aload_2
    //   256: getfield name_ : Ljava/lang/String;
    //   259: invokevirtual isEmpty : ()Z
    //   262: ixor
    //   263: aload_2
    //   264: getfield name_ : Ljava/lang/String;
    //   267: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   272: putfield name_ : Ljava/lang/String;
    //   275: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   278: astore_1
    //   279: aload_0
    //   280: areturn
    //   281: new com/google/longrunning/GetOperationRequest$Builder
    //   284: dup
    //   285: aconst_null
    //   286: invokespecial <init> : (Lcom/google/longrunning/GetOperationRequest$1;)V
    //   289: areturn
    //   290: aconst_null
    //   291: areturn
    //   292: getstatic com/google/longrunning/GetOperationRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/GetOperationRequest;
    //   295: areturn
    //   296: new com/google/longrunning/GetOperationRequest
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
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.name_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GetOperationRequest, Builder> implements GetOperationRequestOrBuilder {
    private Builder() {
      super(GetOperationRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GetOperationRequest)this.instance).clearName();
      return this;
    }
    
    public String getName() {
      return ((GetOperationRequest)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GetOperationRequest)this.instance).getNameBytes();
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GetOperationRequest)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GetOperationRequest)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\longrunning\GetOperationRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */