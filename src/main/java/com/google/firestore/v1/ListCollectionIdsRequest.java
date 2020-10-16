package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ListCollectionIdsRequest extends GeneratedMessageLite<ListCollectionIdsRequest, ListCollectionIdsRequest.Builder> implements ListCollectionIdsRequestOrBuilder {
  private static final ListCollectionIdsRequest DEFAULT_INSTANCE = new ListCollectionIdsRequest();
  
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  
  public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
  
  public static final int PARENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<ListCollectionIdsRequest> PARSER;
  
  private int pageSize_;
  
  private String pageToken_ = "";
  
  private String parent_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearPageSize() {
    this.pageSize_ = 0;
  }
  
  private void clearPageToken() {
    this.pageToken_ = getDefaultInstance().getPageToken();
  }
  
  private void clearParent() {
    this.parent_ = getDefaultInstance().getParent();
  }
  
  public static ListCollectionIdsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListCollectionIdsRequest paramListCollectionIdsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCollectionIdsRequest);
  }
  
  public static ListCollectionIdsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListCollectionIdsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCollectionIdsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListCollectionIdsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListCollectionIdsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCollectionIdsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListCollectionIdsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCollectionIdsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListCollectionIdsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setPageSize(int paramInt) {
    this.pageSize_ = paramInt;
  }
  
  private void setPageToken(String paramString) {
    if (paramString != null) {
      this.pageToken_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPageTokenBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.pageToken_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setParent(String paramString) {
    if (paramString != null) {
      this.parent_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setParentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.parent_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ListCollectionIdsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 425, 2 -> 421, 3 -> 419, 4 -> 410, 5 -> 270, 6 -> 118, 7 -> 266, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/ListCollectionIdsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/ListCollectionIdsRequest
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/ListCollectionIdsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/ListCollectionIdsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsRequest;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/ListCollectionIdsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/ListCollectionIdsRequest
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/ListCollectionIdsRequest
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/ListCollectionIdsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 266
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 210
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 199
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 188
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 177
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: goto -> 210
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   182: putfield pageToken_ : Ljava/lang/String;
    //   185: goto -> 128
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual readInt32 : ()I
    //   193: putfield pageSize_ : I
    //   196: goto -> 128
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   204: putfield parent_ : Ljava/lang/String;
    //   207: goto -> 128
    //   210: iconst_1
    //   211: istore #6
    //   213: goto -> 128
    //   216: astore_1
    //   217: goto -> 264
    //   220: astore_1
    //   221: new java/lang/RuntimeException
    //   224: astore_2
    //   225: new com/google/protobuf/InvalidProtocolBufferException
    //   228: astore_3
    //   229: aload_3
    //   230: aload_1
    //   231: invokevirtual getMessage : ()Ljava/lang/String;
    //   234: invokespecial <init> : (Ljava/lang/String;)V
    //   237: aload_2
    //   238: aload_3
    //   239: aload_0
    //   240: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   243: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   246: aload_2
    //   247: athrow
    //   248: astore_1
    //   249: new java/lang/RuntimeException
    //   252: astore_2
    //   253: aload_2
    //   254: aload_1
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_2
    //   263: athrow
    //   264: aload_1
    //   265: athrow
    //   266: getstatic com/google/firestore/v1/ListCollectionIdsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsRequest;
    //   269: areturn
    //   270: aload_2
    //   271: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   274: astore_1
    //   275: aload_3
    //   276: checkcast com/google/firestore/v1/ListCollectionIdsRequest
    //   279: astore_2
    //   280: aload_0
    //   281: aload_1
    //   282: aload_0
    //   283: getfield parent_ : Ljava/lang/String;
    //   286: invokevirtual isEmpty : ()Z
    //   289: iconst_1
    //   290: ixor
    //   291: aload_0
    //   292: getfield parent_ : Ljava/lang/String;
    //   295: aload_2
    //   296: getfield parent_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_2
    //   305: getfield parent_ : Ljava/lang/String;
    //   308: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   313: putfield parent_ : Ljava/lang/String;
    //   316: aload_0
    //   317: getfield pageSize_ : I
    //   320: ifeq -> 329
    //   323: iconst_1
    //   324: istore #7
    //   326: goto -> 332
    //   329: iconst_0
    //   330: istore #7
    //   332: aload_0
    //   333: getfield pageSize_ : I
    //   336: istore #6
    //   338: aload_2
    //   339: getfield pageSize_ : I
    //   342: ifeq -> 348
    //   345: iconst_1
    //   346: istore #5
    //   348: aload_0
    //   349: aload_1
    //   350: iload #7
    //   352: iload #6
    //   354: iload #5
    //   356: aload_2
    //   357: getfield pageSize_ : I
    //   360: invokeinterface visitInt : (ZIZI)I
    //   365: putfield pageSize_ : I
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield pageToken_ : Ljava/lang/String;
    //   374: invokevirtual isEmpty : ()Z
    //   377: iconst_1
    //   378: ixor
    //   379: aload_0
    //   380: getfield pageToken_ : Ljava/lang/String;
    //   383: aload_2
    //   384: getfield pageToken_ : Ljava/lang/String;
    //   387: invokevirtual isEmpty : ()Z
    //   390: iconst_1
    //   391: ixor
    //   392: aload_2
    //   393: getfield pageToken_ : Ljava/lang/String;
    //   396: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   401: putfield pageToken_ : Ljava/lang/String;
    //   404: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   407: astore_1
    //   408: aload_0
    //   409: areturn
    //   410: new com/google/firestore/v1/ListCollectionIdsRequest$Builder
    //   413: dup
    //   414: aconst_null
    //   415: invokespecial <init> : (Lcom/google/firestore/v1/ListCollectionIdsRequest$1;)V
    //   418: areturn
    //   419: aconst_null
    //   420: areturn
    //   421: getstatic com/google/firestore/v1/ListCollectionIdsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsRequest;
    //   424: areturn
    //   425: new com/google/firestore/v1/ListCollectionIdsRequest
    //   428: dup
    //   429: invokespecial <init> : ()V
    //   432: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	248	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	220	java/io/IOException
    //   133	139	216	finally
    //   165	174	248	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	220	java/io/IOException
    //   165	174	216	finally
    //   177	185	248	com/google/protobuf/InvalidProtocolBufferException
    //   177	185	220	java/io/IOException
    //   177	185	216	finally
    //   188	196	248	com/google/protobuf/InvalidProtocolBufferException
    //   188	196	220	java/io/IOException
    //   188	196	216	finally
    //   199	207	248	com/google/protobuf/InvalidProtocolBufferException
    //   199	207	220	java/io/IOException
    //   199	207	216	finally
    //   221	248	216	finally
    //   249	264	216	finally
  }
  
  public int getPageSize() {
    return this.pageSize_;
  }
  
  public String getPageToken() {
    return this.pageToken_;
  }
  
  public ByteString getPageTokenBytes() {
    return ByteString.copyFromUtf8(this.pageToken_);
  }
  
  public String getParent() {
    return this.parent_;
  }
  
  public ByteString getParentBytes() {
    return ByteString.copyFromUtf8(this.parent_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.parent_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getParent()); 
    int k = this.pageSize_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    j = i;
    if (!this.pageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getPageToken()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.parent_.isEmpty())
      paramCodedOutputStream.writeString(1, getParent()); 
    int i = this.pageSize_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    if (!this.pageToken_.isEmpty())
      paramCodedOutputStream.writeString(3, getPageToken()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsRequest, Builder> implements ListCollectionIdsRequestOrBuilder {
    private Builder() {
      super(ListCollectionIdsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearPageSize() {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).clearPageSize();
      return this;
    }
    
    public Builder clearPageToken() {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).clearPageToken();
      return this;
    }
    
    public Builder clearParent() {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).clearParent();
      return this;
    }
    
    public int getPageSize() {
      return ((ListCollectionIdsRequest)this.instance).getPageSize();
    }
    
    public String getPageToken() {
      return ((ListCollectionIdsRequest)this.instance).getPageToken();
    }
    
    public ByteString getPageTokenBytes() {
      return ((ListCollectionIdsRequest)this.instance).getPageTokenBytes();
    }
    
    public String getParent() {
      return ((ListCollectionIdsRequest)this.instance).getParent();
    }
    
    public ByteString getParentBytes() {
      return ((ListCollectionIdsRequest)this.instance).getParentBytes();
    }
    
    public Builder setPageSize(int param1Int) {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).setPageSize(param1Int);
      return this;
    }
    
    public Builder setPageToken(String param1String) {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).setPageToken(param1String);
      return this;
    }
    
    public Builder setPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).setPageTokenBytes(param1ByteString);
      return this;
    }
    
    public Builder setParent(String param1String) {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).setParent(param1String);
      return this;
    }
    
    public Builder setParentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListCollectionIdsRequest)this.instance).setParentBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListCollectionIdsRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */