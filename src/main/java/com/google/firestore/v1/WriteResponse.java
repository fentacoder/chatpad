package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class WriteResponse extends GeneratedMessageLite<WriteResponse, WriteResponse.Builder> implements WriteResponseOrBuilder {
  public static final int COMMIT_TIME_FIELD_NUMBER = 4;
  
  private static final WriteResponse DEFAULT_INSTANCE = new WriteResponse();
  
  private static volatile Parser<WriteResponse> PARSER;
  
  public static final int STREAM_ID_FIELD_NUMBER = 1;
  
  public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
  
  public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private Timestamp commitTime_;
  
  private String streamId_ = "";
  
  private ByteString streamToken_ = ByteString.EMPTY;
  
  private Internal.ProtobufList<WriteResult> writeResults_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllWriteResults(Iterable<? extends WriteResult> paramIterable) {
    ensureWriteResultsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.writeResults_);
  }
  
  private void addWriteResults(int paramInt, WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.add(paramInt, paramBuilder.build());
  }
  
  private void addWriteResults(int paramInt, WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.add(paramInt, paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addWriteResults(WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.add(paramBuilder.build());
  }
  
  private void addWriteResults(WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.add(paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCommitTime() {
    this.commitTime_ = null;
  }
  
  private void clearStreamId() {
    this.streamId_ = getDefaultInstance().getStreamId();
  }
  
  private void clearStreamToken() {
    this.streamToken_ = getDefaultInstance().getStreamToken();
  }
  
  private void clearWriteResults() {
    this.writeResults_ = emptyProtobufList();
  }
  
  private void ensureWriteResultsIsMutable() {
    if (!this.writeResults_.isModifiable())
      this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_); 
  }
  
  public static WriteResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCommitTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.commitTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.commitTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.commitTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.commitTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(WriteResponse paramWriteResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWriteResponse);
  }
  
  public static WriteResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (WriteResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static WriteResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static WriteResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static WriteResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static WriteResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<WriteResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeWriteResults(int paramInt) {
    ensureWriteResultsIsMutable();
    this.writeResults_.remove(paramInt);
  }
  
  private void setCommitTime(Timestamp.Builder paramBuilder) {
    this.commitTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setCommitTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.commitTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamId(String paramString) {
    if (paramString != null) {
      this.streamId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.streamId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.streamToken_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setWriteResults(int paramInt, WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.set(paramInt, paramBuilder.build());
  }
  
  private void setWriteResults(int paramInt, WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.set(paramInt, paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/WriteResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 565, 2 -> 561, 3 -> 550, 4 -> 541, 5 -> 378, 6 -> 118, 7 -> 374, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/WriteResponse.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/WriteResponse
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/WriteResponse.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/WriteResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResponse;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/WriteResponse.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/WriteResponse
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/WriteResponse
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/WriteResponse.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 374
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 318
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 307
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 296
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 249
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 184
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 318
    //   184: aload_0
    //   185: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   188: ifnull -> 205
    //   191: aload_0
    //   192: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   195: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   198: checkcast com/google/protobuf/Timestamp$Builder
    //   201: astore_1
    //   202: goto -> 207
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: aload_2
    //   209: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   212: aload_3
    //   213: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   216: checkcast com/google/protobuf/Timestamp
    //   219: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   222: aload_1
    //   223: ifnull -> 128
    //   226: aload_1
    //   227: aload_0
    //   228: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   231: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   234: pop
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   240: checkcast com/google/protobuf/Timestamp
    //   243: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   246: goto -> 128
    //   249: aload_0
    //   250: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   253: invokeinterface isModifiable : ()Z
    //   258: ifne -> 272
    //   261: aload_0
    //   262: aload_0
    //   263: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   266: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   269: putfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   272: aload_0
    //   273: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   276: aload_2
    //   277: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   280: aload_3
    //   281: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   284: checkcast com/google/firestore/v1/WriteResult
    //   287: invokeinterface add : (Ljava/lang/Object;)Z
    //   292: pop
    //   293: goto -> 128
    //   296: aload_0
    //   297: aload_2
    //   298: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   301: putfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   304: goto -> 128
    //   307: aload_0
    //   308: aload_2
    //   309: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   312: putfield streamId_ : Ljava/lang/String;
    //   315: goto -> 128
    //   318: iconst_1
    //   319: istore #6
    //   321: goto -> 128
    //   324: astore_1
    //   325: goto -> 372
    //   328: astore_1
    //   329: new java/lang/RuntimeException
    //   332: astore_2
    //   333: new com/google/protobuf/InvalidProtocolBufferException
    //   336: astore_3
    //   337: aload_3
    //   338: aload_1
    //   339: invokevirtual getMessage : ()Ljava/lang/String;
    //   342: invokespecial <init> : (Ljava/lang/String;)V
    //   345: aload_2
    //   346: aload_3
    //   347: aload_0
    //   348: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   351: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   354: aload_2
    //   355: athrow
    //   356: astore_2
    //   357: new java/lang/RuntimeException
    //   360: astore_1
    //   361: aload_1
    //   362: aload_2
    //   363: aload_0
    //   364: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   367: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   370: aload_1
    //   371: athrow
    //   372: aload_1
    //   373: athrow
    //   374: getstatic com/google/firestore/v1/WriteResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResponse;
    //   377: areturn
    //   378: aload_2
    //   379: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   382: astore_1
    //   383: aload_3
    //   384: checkcast com/google/firestore/v1/WriteResponse
    //   387: astore_3
    //   388: aload_0
    //   389: aload_1
    //   390: aload_0
    //   391: getfield streamId_ : Ljava/lang/String;
    //   394: invokevirtual isEmpty : ()Z
    //   397: iconst_1
    //   398: ixor
    //   399: aload_0
    //   400: getfield streamId_ : Ljava/lang/String;
    //   403: aload_3
    //   404: getfield streamId_ : Ljava/lang/String;
    //   407: invokevirtual isEmpty : ()Z
    //   410: iconst_1
    //   411: ixor
    //   412: aload_3
    //   413: getfield streamId_ : Ljava/lang/String;
    //   416: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   421: putfield streamId_ : Ljava/lang/String;
    //   424: aload_0
    //   425: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   428: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   431: if_acmpeq -> 440
    //   434: iconst_1
    //   435: istore #7
    //   437: goto -> 443
    //   440: iconst_0
    //   441: istore #7
    //   443: aload_0
    //   444: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   447: astore_2
    //   448: aload_3
    //   449: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   452: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   455: if_acmpeq -> 461
    //   458: iconst_1
    //   459: istore #5
    //   461: aload_0
    //   462: aload_1
    //   463: iload #7
    //   465: aload_2
    //   466: iload #5
    //   468: aload_3
    //   469: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   472: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   477: putfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   480: aload_0
    //   481: aload_1
    //   482: aload_0
    //   483: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   486: aload_3
    //   487: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   490: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   495: putfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   498: aload_0
    //   499: aload_1
    //   500: aload_0
    //   501: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   504: aload_3
    //   505: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   508: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   513: checkcast com/google/protobuf/Timestamp
    //   516: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   519: aload_1
    //   520: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   523: if_acmpne -> 539
    //   526: aload_0
    //   527: aload_0
    //   528: getfield bitField0_ : I
    //   531: aload_3
    //   532: getfield bitField0_ : I
    //   535: ior
    //   536: putfield bitField0_ : I
    //   539: aload_0
    //   540: areturn
    //   541: new com/google/firestore/v1/WriteResponse$Builder
    //   544: dup
    //   545: aconst_null
    //   546: invokespecial <init> : (Lcom/google/firestore/v1/WriteResponse$1;)V
    //   549: areturn
    //   550: aload_0
    //   551: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   554: invokeinterface makeImmutable : ()V
    //   559: aconst_null
    //   560: areturn
    //   561: getstatic com/google/firestore/v1/WriteResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResponse;
    //   564: areturn
    //   565: new com/google/firestore/v1/WriteResponse
    //   568: dup
    //   569: invokespecial <init> : ()V
    //   572: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	356	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	328	java/io/IOException
    //   133	139	324	finally
    //   172	181	356	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	328	java/io/IOException
    //   172	181	324	finally
    //   184	202	356	com/google/protobuf/InvalidProtocolBufferException
    //   184	202	328	java/io/IOException
    //   184	202	324	finally
    //   207	222	356	com/google/protobuf/InvalidProtocolBufferException
    //   207	222	328	java/io/IOException
    //   207	222	324	finally
    //   226	246	356	com/google/protobuf/InvalidProtocolBufferException
    //   226	246	328	java/io/IOException
    //   226	246	324	finally
    //   249	272	356	com/google/protobuf/InvalidProtocolBufferException
    //   249	272	328	java/io/IOException
    //   249	272	324	finally
    //   272	293	356	com/google/protobuf/InvalidProtocolBufferException
    //   272	293	328	java/io/IOException
    //   272	293	324	finally
    //   296	304	356	com/google/protobuf/InvalidProtocolBufferException
    //   296	304	328	java/io/IOException
    //   296	304	324	finally
    //   307	315	356	com/google/protobuf/InvalidProtocolBufferException
    //   307	315	328	java/io/IOException
    //   307	315	324	finally
    //   329	356	324	finally
    //   357	372	324	finally
  }
  
  public Timestamp getCommitTime() {
    Timestamp timestamp1 = this.commitTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.streamId_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      j = CodedOutputStream.computeStringSize(1, getStreamId()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    byte b2 = b1;
    if (!this.streamToken_.isEmpty()) {
      i = j + CodedOutputStream.computeBytesSize(2, this.streamToken_);
      b2 = b1;
    } 
    while (b2 < this.writeResults_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.writeResults_.get(b2));
      b2++;
    } 
    int j = i;
    if (this.commitTime_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getCommitTime()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getStreamId() {
    return this.streamId_;
  }
  
  public ByteString getStreamIdBytes() {
    return ByteString.copyFromUtf8(this.streamId_);
  }
  
  public ByteString getStreamToken() {
    return this.streamToken_;
  }
  
  public WriteResult getWriteResults(int paramInt) {
    return (WriteResult)this.writeResults_.get(paramInt);
  }
  
  public int getWriteResultsCount() {
    return this.writeResults_.size();
  }
  
  public List<WriteResult> getWriteResultsList() {
    return (List<WriteResult>)this.writeResults_;
  }
  
  public WriteResultOrBuilder getWriteResultsOrBuilder(int paramInt) {
    return (WriteResultOrBuilder)this.writeResults_.get(paramInt);
  }
  
  public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
    return (List)this.writeResults_;
  }
  
  public boolean hasCommitTime() {
    boolean bool;
    if (this.commitTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.streamId_.isEmpty())
      paramCodedOutputStream.writeString(1, getStreamId()); 
    if (!this.streamToken_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.streamToken_); 
    for (byte b = 0; b < this.writeResults_.size(); b++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.writeResults_.get(b)); 
    if (this.commitTime_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getCommitTime()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<WriteResponse, Builder> implements WriteResponseOrBuilder {
    private Builder() {
      super(WriteResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllWriteResults(Iterable<? extends WriteResult> param1Iterable) {
      copyOnWrite();
      ((WriteResponse)this.instance).addAllWriteResults(param1Iterable);
      return this;
    }
    
    public Builder addWriteResults(int param1Int, WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((WriteResponse)this.instance).addWriteResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder addWriteResults(int param1Int, WriteResult param1WriteResult) {
      copyOnWrite();
      ((WriteResponse)this.instance).addWriteResults(param1Int, param1WriteResult);
      return this;
    }
    
    public Builder addWriteResults(WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((WriteResponse)this.instance).addWriteResults(param1Builder);
      return this;
    }
    
    public Builder addWriteResults(WriteResult param1WriteResult) {
      copyOnWrite();
      ((WriteResponse)this.instance).addWriteResults(param1WriteResult);
      return this;
    }
    
    public Builder clearCommitTime() {
      copyOnWrite();
      ((WriteResponse)this.instance).clearCommitTime();
      return this;
    }
    
    public Builder clearStreamId() {
      copyOnWrite();
      ((WriteResponse)this.instance).clearStreamId();
      return this;
    }
    
    public Builder clearStreamToken() {
      copyOnWrite();
      ((WriteResponse)this.instance).clearStreamToken();
      return this;
    }
    
    public Builder clearWriteResults() {
      copyOnWrite();
      ((WriteResponse)this.instance).clearWriteResults();
      return this;
    }
    
    public Timestamp getCommitTime() {
      return ((WriteResponse)this.instance).getCommitTime();
    }
    
    public String getStreamId() {
      return ((WriteResponse)this.instance).getStreamId();
    }
    
    public ByteString getStreamIdBytes() {
      return ((WriteResponse)this.instance).getStreamIdBytes();
    }
    
    public ByteString getStreamToken() {
      return ((WriteResponse)this.instance).getStreamToken();
    }
    
    public WriteResult getWriteResults(int param1Int) {
      return ((WriteResponse)this.instance).getWriteResults(param1Int);
    }
    
    public int getWriteResultsCount() {
      return ((WriteResponse)this.instance).getWriteResultsCount();
    }
    
    public List<WriteResult> getWriteResultsList() {
      return Collections.unmodifiableList(((WriteResponse)this.instance).getWriteResultsList());
    }
    
    public boolean hasCommitTime() {
      return ((WriteResponse)this.instance).hasCommitTime();
    }
    
    public Builder mergeCommitTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteResponse)this.instance).mergeCommitTime(param1Timestamp);
      return this;
    }
    
    public Builder removeWriteResults(int param1Int) {
      copyOnWrite();
      ((WriteResponse)this.instance).removeWriteResults(param1Int);
      return this;
    }
    
    public Builder setCommitTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((WriteResponse)this.instance).setCommitTime(param1Builder);
      return this;
    }
    
    public Builder setCommitTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteResponse)this.instance).setCommitTime(param1Timestamp);
      return this;
    }
    
    public Builder setStreamId(String param1String) {
      copyOnWrite();
      ((WriteResponse)this.instance).setStreamId(param1String);
      return this;
    }
    
    public Builder setStreamIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((WriteResponse)this.instance).setStreamIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setStreamToken(ByteString param1ByteString) {
      copyOnWrite();
      ((WriteResponse)this.instance).setStreamToken(param1ByteString);
      return this;
    }
    
    public Builder setWriteResults(int param1Int, WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((WriteResponse)this.instance).setWriteResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder setWriteResults(int param1Int, WriteResult param1WriteResult) {
      copyOnWrite();
      ((WriteResponse)this.instance).setWriteResults(param1Int, param1WriteResult);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */