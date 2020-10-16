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

public final class ListOperationsRequest extends GeneratedMessageLite<ListOperationsRequest, ListOperationsRequest.Builder> implements ListOperationsRequestOrBuilder {
  private static final ListOperationsRequest DEFAULT_INSTANCE = new ListOperationsRequest();
  
  public static final int FILTER_FIELD_NUMBER = 1;
  
  public static final int NAME_FIELD_NUMBER = 4;
  
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  
  public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
  
  private static volatile Parser<ListOperationsRequest> PARSER;
  
  private String filter_ = "";
  
  private String name_ = "";
  
  private int pageSize_;
  
  private String pageToken_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFilter() {
    this.filter_ = getDefaultInstance().getFilter();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearPageSize() {
    this.pageSize_ = 0;
  }
  
  private void clearPageToken() {
    this.pageToken_ = getDefaultInstance().getPageToken();
  }
  
  public static ListOperationsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListOperationsRequest paramListOperationsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListOperationsRequest);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListOperationsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListOperationsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListOperationsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListOperationsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListOperationsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListOperationsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFilter(String paramString) {
    if (paramString != null) {
      this.filter_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFilterBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.filter_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/ListOperationsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 479, 2 -> 475, 3 -> 473, 4 -> 464, 5 -> 288, 6 -> 118, 7 -> 284, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/longrunning/ListOperationsRequest
    //   80: monitorenter
    //   81: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/longrunning/ListOperationsRequest
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/longrunning/ListOperationsRequest
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/longrunning/ListOperationsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 284
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 228
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 217
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 206
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 195
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 184
    //   172: aload_1
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 228
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   189: putfield name_ : Ljava/lang/String;
    //   192: goto -> 128
    //   195: aload_0
    //   196: aload_1
    //   197: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   200: putfield pageToken_ : Ljava/lang/String;
    //   203: goto -> 128
    //   206: aload_0
    //   207: aload_1
    //   208: invokevirtual readInt32 : ()I
    //   211: putfield pageSize_ : I
    //   214: goto -> 128
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   222: putfield filter_ : Ljava/lang/String;
    //   225: goto -> 128
    //   228: iconst_1
    //   229: istore #6
    //   231: goto -> 128
    //   234: astore_1
    //   235: goto -> 282
    //   238: astore_3
    //   239: new java/lang/RuntimeException
    //   242: astore_1
    //   243: new com/google/protobuf/InvalidProtocolBufferException
    //   246: astore_2
    //   247: aload_2
    //   248: aload_3
    //   249: invokevirtual getMessage : ()Ljava/lang/String;
    //   252: invokespecial <init> : (Ljava/lang/String;)V
    //   255: aload_1
    //   256: aload_2
    //   257: aload_0
    //   258: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   261: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: new java/lang/RuntimeException
    //   270: astore_1
    //   271: aload_1
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_1
    //   281: athrow
    //   282: aload_1
    //   283: athrow
    //   284: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   287: areturn
    //   288: aload_2
    //   289: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   292: astore_1
    //   293: aload_3
    //   294: checkcast com/google/longrunning/ListOperationsRequest
    //   297: astore_2
    //   298: aload_0
    //   299: aload_1
    //   300: aload_0
    //   301: getfield name_ : Ljava/lang/String;
    //   304: invokevirtual isEmpty : ()Z
    //   307: iconst_1
    //   308: ixor
    //   309: aload_0
    //   310: getfield name_ : Ljava/lang/String;
    //   313: aload_2
    //   314: getfield name_ : Ljava/lang/String;
    //   317: invokevirtual isEmpty : ()Z
    //   320: iconst_1
    //   321: ixor
    //   322: aload_2
    //   323: getfield name_ : Ljava/lang/String;
    //   326: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   331: putfield name_ : Ljava/lang/String;
    //   334: aload_0
    //   335: aload_1
    //   336: aload_0
    //   337: getfield filter_ : Ljava/lang/String;
    //   340: invokevirtual isEmpty : ()Z
    //   343: iconst_1
    //   344: ixor
    //   345: aload_0
    //   346: getfield filter_ : Ljava/lang/String;
    //   349: aload_2
    //   350: getfield filter_ : Ljava/lang/String;
    //   353: invokevirtual isEmpty : ()Z
    //   356: iconst_1
    //   357: ixor
    //   358: aload_2
    //   359: getfield filter_ : Ljava/lang/String;
    //   362: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   367: putfield filter_ : Ljava/lang/String;
    //   370: aload_0
    //   371: getfield pageSize_ : I
    //   374: ifeq -> 383
    //   377: iconst_1
    //   378: istore #7
    //   380: goto -> 386
    //   383: iconst_0
    //   384: istore #7
    //   386: aload_0
    //   387: getfield pageSize_ : I
    //   390: istore #6
    //   392: aload_2
    //   393: getfield pageSize_ : I
    //   396: ifeq -> 402
    //   399: iconst_1
    //   400: istore #5
    //   402: aload_0
    //   403: aload_1
    //   404: iload #7
    //   406: iload #6
    //   408: iload #5
    //   410: aload_2
    //   411: getfield pageSize_ : I
    //   414: invokeinterface visitInt : (ZIZI)I
    //   419: putfield pageSize_ : I
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield pageToken_ : Ljava/lang/String;
    //   428: invokevirtual isEmpty : ()Z
    //   431: iconst_1
    //   432: ixor
    //   433: aload_0
    //   434: getfield pageToken_ : Ljava/lang/String;
    //   437: aload_2
    //   438: getfield pageToken_ : Ljava/lang/String;
    //   441: invokevirtual isEmpty : ()Z
    //   444: iconst_1
    //   445: ixor
    //   446: aload_2
    //   447: getfield pageToken_ : Ljava/lang/String;
    //   450: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   455: putfield pageToken_ : Ljava/lang/String;
    //   458: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   461: astore_1
    //   462: aload_0
    //   463: areturn
    //   464: new com/google/longrunning/ListOperationsRequest$Builder
    //   467: dup
    //   468: aconst_null
    //   469: invokespecial <init> : (Lcom/google/longrunning/ListOperationsRequest$1;)V
    //   472: areturn
    //   473: aconst_null
    //   474: areturn
    //   475: getstatic com/google/longrunning/ListOperationsRequest.DEFAULT_INSTANCE : Lcom/google/longrunning/ListOperationsRequest;
    //   478: areturn
    //   479: new com/google/longrunning/ListOperationsRequest
    //   482: dup
    //   483: invokespecial <init> : ()V
    //   486: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	266	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	238	java/io/IOException
    //   133	139	234	finally
    //   172	181	266	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	238	java/io/IOException
    //   172	181	234	finally
    //   184	192	266	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	238	java/io/IOException
    //   184	192	234	finally
    //   195	203	266	com/google/protobuf/InvalidProtocolBufferException
    //   195	203	238	java/io/IOException
    //   195	203	234	finally
    //   206	214	266	com/google/protobuf/InvalidProtocolBufferException
    //   206	214	238	java/io/IOException
    //   206	214	234	finally
    //   217	225	266	com/google/protobuf/InvalidProtocolBufferException
    //   217	225	238	java/io/IOException
    //   217	225	234	finally
    //   239	266	234	finally
    //   267	282	234	finally
  }
  
  public String getFilter() {
    return this.filter_;
  }
  
  public ByteString getFilterBytes() {
    return ByteString.copyFromUtf8(this.filter_);
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
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
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.filter_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getFilter()); 
    int k = this.pageSize_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    j = i;
    if (!this.pageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getPageToken()); 
    i = j;
    if (!this.name_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(4, getName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.filter_.isEmpty())
      paramCodedOutputStream.writeString(1, getFilter()); 
    int i = this.pageSize_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    if (!this.pageToken_.isEmpty())
      paramCodedOutputStream.writeString(3, getPageToken()); 
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(4, getName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
    private Builder() {
      super(ListOperationsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearFilter() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearFilter();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearName();
      return this;
    }
    
    public Builder clearPageSize() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearPageSize();
      return this;
    }
    
    public Builder clearPageToken() {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).clearPageToken();
      return this;
    }
    
    public String getFilter() {
      return ((ListOperationsRequest)this.instance).getFilter();
    }
    
    public ByteString getFilterBytes() {
      return ((ListOperationsRequest)this.instance).getFilterBytes();
    }
    
    public String getName() {
      return ((ListOperationsRequest)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((ListOperationsRequest)this.instance).getNameBytes();
    }
    
    public int getPageSize() {
      return ((ListOperationsRequest)this.instance).getPageSize();
    }
    
    public String getPageToken() {
      return ((ListOperationsRequest)this.instance).getPageToken();
    }
    
    public ByteString getPageTokenBytes() {
      return ((ListOperationsRequest)this.instance).getPageTokenBytes();
    }
    
    public Builder setFilter(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setFilter(param1String);
      return this;
    }
    
    public Builder setFilterBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setFilterBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setPageSize(int param1Int) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageSize(param1Int);
      return this;
    }
    
    public Builder setPageToken(String param1String) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageToken(param1String);
      return this;
    }
    
    public Builder setPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListOperationsRequest)this.instance).setPageTokenBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\longrunning\ListOperationsRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */