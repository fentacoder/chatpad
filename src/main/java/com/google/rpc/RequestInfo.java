package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class RequestInfo extends GeneratedMessageLite<RequestInfo, RequestInfo.Builder> implements RequestInfoOrBuilder {
  private static final RequestInfo DEFAULT_INSTANCE = new RequestInfo();
  
  private static volatile Parser<RequestInfo> PARSER;
  
  public static final int REQUEST_ID_FIELD_NUMBER = 1;
  
  public static final int SERVING_DATA_FIELD_NUMBER = 2;
  
  private String requestId_ = "";
  
  private String servingData_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearRequestId() {
    this.requestId_ = getDefaultInstance().getRequestId();
  }
  
  private void clearServingData() {
    this.servingData_ = getDefaultInstance().getServingData();
  }
  
  public static RequestInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RequestInfo paramRequestInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRequestInfo);
  }
  
  public static RequestInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RequestInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RequestInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RequestInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RequestInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RequestInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RequestInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RequestInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RequestInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RequestInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setRequestId(String paramString) {
    if (paramString != null) {
      this.requestId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServingData(String paramString) {
    if (paramString != null) {
      this.servingData_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServingDataBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.servingData_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/RequestInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 350, 2 -> 346, 3 -> 344, 4 -> 335, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/RequestInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/RequestInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/RequestInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/RequestInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RequestInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/RequestInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/RequestInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/RequestInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/RequestInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   170: putfield servingData_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   181: putfield requestId_ : Ljava/lang/String;
    //   184: goto -> 123
    //   187: iconst_1
    //   188: istore #4
    //   190: goto -> 123
    //   193: astore_1
    //   194: goto -> 241
    //   197: astore_3
    //   198: new java/lang/RuntimeException
    //   201: astore_2
    //   202: new com/google/protobuf/InvalidProtocolBufferException
    //   205: astore_1
    //   206: aload_1
    //   207: aload_3
    //   208: invokevirtual getMessage : ()Ljava/lang/String;
    //   211: invokespecial <init> : (Ljava/lang/String;)V
    //   214: aload_2
    //   215: aload_1
    //   216: aload_0
    //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   223: aload_2
    //   224: athrow
    //   225: astore_2
    //   226: new java/lang/RuntimeException
    //   229: astore_1
    //   230: aload_1
    //   231: aload_2
    //   232: aload_0
    //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   239: aload_1
    //   240: athrow
    //   241: aload_1
    //   242: athrow
    //   243: getstatic com/google/rpc/RequestInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RequestInfo;
    //   246: areturn
    //   247: aload_2
    //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   251: astore_1
    //   252: aload_3
    //   253: checkcast com/google/rpc/RequestInfo
    //   256: astore_2
    //   257: aload_0
    //   258: aload_1
    //   259: aload_0
    //   260: getfield requestId_ : Ljava/lang/String;
    //   263: invokevirtual isEmpty : ()Z
    //   266: iconst_1
    //   267: ixor
    //   268: aload_0
    //   269: getfield requestId_ : Ljava/lang/String;
    //   272: aload_2
    //   273: getfield requestId_ : Ljava/lang/String;
    //   276: invokevirtual isEmpty : ()Z
    //   279: iconst_1
    //   280: ixor
    //   281: aload_2
    //   282: getfield requestId_ : Ljava/lang/String;
    //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   290: putfield requestId_ : Ljava/lang/String;
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield servingData_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_0
    //   305: getfield servingData_ : Ljava/lang/String;
    //   308: iconst_1
    //   309: aload_2
    //   310: getfield servingData_ : Ljava/lang/String;
    //   313: invokevirtual isEmpty : ()Z
    //   316: ixor
    //   317: aload_2
    //   318: getfield servingData_ : Ljava/lang/String;
    //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   326: putfield servingData_ : Ljava/lang/String;
    //   329: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   332: astore_1
    //   333: aload_0
    //   334: areturn
    //   335: new com/google/rpc/RequestInfo$Builder
    //   338: dup
    //   339: aconst_null
    //   340: invokespecial <init> : (Lcom/google/rpc/RequestInfo$1;)V
    //   343: areturn
    //   344: aconst_null
    //   345: areturn
    //   346: getstatic com/google/rpc/RequestInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RequestInfo;
    //   349: areturn
    //   350: new com/google/rpc/RequestInfo
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
  
  public String getRequestId() {
    return this.requestId_;
  }
  
  public ByteString getRequestIdBytes() {
    return ByteString.copyFromUtf8(this.requestId_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.requestId_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getRequestId()); 
    int j = i;
    if (!this.servingData_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getServingData()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getServingData() {
    return this.servingData_;
  }
  
  public ByteString getServingDataBytes() {
    return ByteString.copyFromUtf8(this.servingData_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.requestId_.isEmpty())
      paramCodedOutputStream.writeString(1, getRequestId()); 
    if (!this.servingData_.isEmpty())
      paramCodedOutputStream.writeString(2, getServingData()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
    private Builder() {
      super(RequestInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearRequestId() {
      copyOnWrite();
      ((RequestInfo)this.instance).clearRequestId();
      return this;
    }
    
    public Builder clearServingData() {
      copyOnWrite();
      ((RequestInfo)this.instance).clearServingData();
      return this;
    }
    
    public String getRequestId() {
      return ((RequestInfo)this.instance).getRequestId();
    }
    
    public ByteString getRequestIdBytes() {
      return ((RequestInfo)this.instance).getRequestIdBytes();
    }
    
    public String getServingData() {
      return ((RequestInfo)this.instance).getServingData();
    }
    
    public ByteString getServingDataBytes() {
      return ((RequestInfo)this.instance).getServingDataBytes();
    }
    
    public Builder setRequestId(String param1String) {
      copyOnWrite();
      ((RequestInfo)this.instance).setRequestId(param1String);
      return this;
    }
    
    public Builder setRequestIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RequestInfo)this.instance).setRequestIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setServingData(String param1String) {
      copyOnWrite();
      ((RequestInfo)this.instance).setServingData(param1String);
      return this;
    }
    
    public Builder setServingDataBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RequestInfo)this.instance).setServingDataBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\RequestInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */