package com.google.firestore.v1;

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

public final class BatchGetDocumentsResponse extends GeneratedMessageLite<BatchGetDocumentsResponse, BatchGetDocumentsResponse.Builder> implements BatchGetDocumentsResponseOrBuilder {
  private static final BatchGetDocumentsResponse DEFAULT_INSTANCE = new BatchGetDocumentsResponse();
  
  public static final int FOUND_FIELD_NUMBER = 1;
  
  public static final int MISSING_FIELD_NUMBER = 2;
  
  private static volatile Parser<BatchGetDocumentsResponse> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 4;
  
  public static final int TRANSACTION_FIELD_NUMBER = 3;
  
  private Timestamp readTime_;
  
  private int resultCase_ = 0;
  
  private Object result_;
  
  private ByteString transaction_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFound() {
    if (this.resultCase_ == 1) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearMissing() {
    if (this.resultCase_ == 2) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearReadTime() {
    this.readTime_ = null;
  }
  
  private void clearResult() {
    this.resultCase_ = 0;
    this.result_ = null;
  }
  
  private void clearTransaction() {
    this.transaction_ = getDefaultInstance().getTransaction();
  }
  
  public static BatchGetDocumentsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeFound(Document paramDocument) {
    if (this.resultCase_ == 1 && this.result_ != Document.getDefaultInstance()) {
      this.result_ = ((Document.Builder)Document.newBuilder((Document)this.result_).mergeFrom(paramDocument)).buildPartial();
    } else {
      this.result_ = paramDocument;
    } 
    this.resultCase_ = 1;
  }
  
  private void mergeReadTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.readTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.readTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.readTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.readTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BatchGetDocumentsResponse paramBatchGetDocumentsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBatchGetDocumentsResponse);
  }
  
  public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BatchGetDocumentsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BatchGetDocumentsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BatchGetDocumentsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BatchGetDocumentsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BatchGetDocumentsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BatchGetDocumentsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFound(Document.Builder paramBuilder) {
    this.result_ = paramBuilder.build();
    this.resultCase_ = 1;
  }
  
  private void setFound(Document paramDocument) {
    if (paramDocument != null) {
      this.result_ = paramDocument;
      this.resultCase_ = 1;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMissing(String paramString) {
    if (paramString != null) {
      this.resultCase_ = 2;
      this.result_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMissingBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resultCase_ = 2;
      this.result_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReadTime(Timestamp.Builder paramBuilder) {
    this.readTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setReadTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.readTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.transaction_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/BatchGetDocumentsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iconst_0
    //   17: istore #7
    //   19: iconst_0
    //   20: istore #8
    //   22: iload #4
    //   24: tableswitch default -> 72, 1 -> 683, 2 -> 679, 3 -> 677, 4 -> 668, 5 -> 417, 6 -> 126, 7 -> 413, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/BatchGetDocumentsResponse
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsResponse;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/BatchGetDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/BatchGetDocumentsResponse
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/BatchGetDocumentsResponse
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 413
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 357
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 286
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 268
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 257
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 192
    //   180: aload_2
    //   181: iload #4
    //   183: invokevirtual skipField : (I)Z
    //   186: ifne -> 136
    //   189: goto -> 357
    //   192: aload_0
    //   193: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   196: ifnull -> 213
    //   199: aload_0
    //   200: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   203: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   206: checkcast com/google/protobuf/Timestamp$Builder
    //   209: astore_1
    //   210: goto -> 215
    //   213: aconst_null
    //   214: astore_1
    //   215: aload_0
    //   216: aload_2
    //   217: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   220: aload_3
    //   221: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   224: checkcast com/google/protobuf/Timestamp
    //   227: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   230: aload_1
    //   231: ifnull -> 136
    //   234: aload_1
    //   235: aload_0
    //   236: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   239: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   242: pop
    //   243: aload_0
    //   244: aload_1
    //   245: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   248: checkcast com/google/protobuf/Timestamp
    //   251: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   254: goto -> 136
    //   257: aload_0
    //   258: aload_2
    //   259: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   262: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   265: goto -> 136
    //   268: aload_2
    //   269: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   272: astore_1
    //   273: aload_0
    //   274: iconst_2
    //   275: putfield resultCase_ : I
    //   278: aload_0
    //   279: aload_1
    //   280: putfield result_ : Ljava/lang/Object;
    //   283: goto -> 136
    //   286: aload_0
    //   287: getfield resultCase_ : I
    //   290: iconst_1
    //   291: if_icmpne -> 311
    //   294: aload_0
    //   295: getfield result_ : Ljava/lang/Object;
    //   298: checkcast com/google/firestore/v1/Document
    //   301: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   304: checkcast com/google/firestore/v1/Document$Builder
    //   307: astore_1
    //   308: goto -> 313
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_0
    //   314: aload_2
    //   315: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   318: aload_3
    //   319: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   322: putfield result_ : Ljava/lang/Object;
    //   325: aload_1
    //   326: ifnull -> 349
    //   329: aload_1
    //   330: aload_0
    //   331: getfield result_ : Ljava/lang/Object;
    //   334: checkcast com/google/firestore/v1/Document
    //   337: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   340: pop
    //   341: aload_0
    //   342: aload_1
    //   343: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   346: putfield result_ : Ljava/lang/Object;
    //   349: aload_0
    //   350: iconst_1
    //   351: putfield resultCase_ : I
    //   354: goto -> 136
    //   357: iconst_1
    //   358: istore #8
    //   360: goto -> 136
    //   363: astore_1
    //   364: goto -> 411
    //   367: astore_3
    //   368: new java/lang/RuntimeException
    //   371: astore_1
    //   372: new com/google/protobuf/InvalidProtocolBufferException
    //   375: astore_2
    //   376: aload_2
    //   377: aload_3
    //   378: invokevirtual getMessage : ()Ljava/lang/String;
    //   381: invokespecial <init> : (Ljava/lang/String;)V
    //   384: aload_1
    //   385: aload_2
    //   386: aload_0
    //   387: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   390: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   393: aload_1
    //   394: athrow
    //   395: astore_1
    //   396: new java/lang/RuntimeException
    //   399: astore_2
    //   400: aload_2
    //   401: aload_1
    //   402: aload_0
    //   403: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   406: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   409: aload_2
    //   410: athrow
    //   411: aload_1
    //   412: athrow
    //   413: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsResponse;
    //   416: areturn
    //   417: aload_2
    //   418: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   421: astore_1
    //   422: aload_3
    //   423: checkcast com/google/firestore/v1/BatchGetDocumentsResponse
    //   426: astore_3
    //   427: aload_0
    //   428: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   431: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   434: if_acmpeq -> 443
    //   437: iconst_1
    //   438: istore #9
    //   440: goto -> 446
    //   443: iconst_0
    //   444: istore #9
    //   446: aload_0
    //   447: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   450: astore_2
    //   451: aload_3
    //   452: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   455: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   458: if_acmpeq -> 467
    //   461: iconst_1
    //   462: istore #10
    //   464: goto -> 470
    //   467: iconst_0
    //   468: istore #10
    //   470: aload_0
    //   471: aload_1
    //   472: iload #9
    //   474: aload_2
    //   475: iload #10
    //   477: aload_3
    //   478: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   481: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   486: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   489: aload_0
    //   490: aload_1
    //   491: aload_0
    //   492: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   495: aload_3
    //   496: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   499: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   504: checkcast com/google/protobuf/Timestamp
    //   507: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   510: getstatic com/google/firestore/v1/BatchGetDocumentsResponse$1.$SwitchMap$com$google$firestore$v1$BatchGetDocumentsResponse$ResultCase : [I
    //   513: aload_3
    //   514: invokevirtual getResultCase : ()Lcom/google/firestore/v1/BatchGetDocumentsResponse$ResultCase;
    //   517: invokevirtual ordinal : ()I
    //   520: iaload
    //   521: istore #8
    //   523: iload #8
    //   525: iconst_1
    //   526: if_icmpeq -> 607
    //   529: iload #8
    //   531: iconst_2
    //   532: if_icmpeq -> 569
    //   535: iload #8
    //   537: iconst_3
    //   538: if_icmpeq -> 544
    //   541: goto -> 642
    //   544: iload #5
    //   546: istore #9
    //   548: aload_0
    //   549: getfield resultCase_ : I
    //   552: ifeq -> 558
    //   555: iconst_1
    //   556: istore #9
    //   558: aload_1
    //   559: iload #9
    //   561: invokeinterface visitOneofNotSet : (Z)V
    //   566: goto -> 642
    //   569: iload #6
    //   571: istore #9
    //   573: aload_0
    //   574: getfield resultCase_ : I
    //   577: iconst_2
    //   578: if_icmpne -> 584
    //   581: iconst_1
    //   582: istore #9
    //   584: aload_0
    //   585: aload_1
    //   586: iload #9
    //   588: aload_0
    //   589: getfield result_ : Ljava/lang/Object;
    //   592: aload_3
    //   593: getfield result_ : Ljava/lang/Object;
    //   596: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   601: putfield result_ : Ljava/lang/Object;
    //   604: goto -> 642
    //   607: iload #7
    //   609: istore #9
    //   611: aload_0
    //   612: getfield resultCase_ : I
    //   615: iconst_1
    //   616: if_icmpne -> 622
    //   619: iconst_1
    //   620: istore #9
    //   622: aload_0
    //   623: aload_1
    //   624: iload #9
    //   626: aload_0
    //   627: getfield result_ : Ljava/lang/Object;
    //   630: aload_3
    //   631: getfield result_ : Ljava/lang/Object;
    //   634: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: putfield result_ : Ljava/lang/Object;
    //   642: aload_1
    //   643: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   646: if_acmpne -> 666
    //   649: aload_3
    //   650: getfield resultCase_ : I
    //   653: istore #8
    //   655: iload #8
    //   657: ifeq -> 666
    //   660: aload_0
    //   661: iload #8
    //   663: putfield resultCase_ : I
    //   666: aload_0
    //   667: areturn
    //   668: new com/google/firestore/v1/BatchGetDocumentsResponse$Builder
    //   671: dup
    //   672: aconst_null
    //   673: invokespecial <init> : (Lcom/google/firestore/v1/BatchGetDocumentsResponse$1;)V
    //   676: areturn
    //   677: aconst_null
    //   678: areturn
    //   679: getstatic com/google/firestore/v1/BatchGetDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsResponse;
    //   682: areturn
    //   683: new com/google/firestore/v1/BatchGetDocumentsResponse
    //   686: dup
    //   687: invokespecial <init> : ()V
    //   690: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	395	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	367	java/io/IOException
    //   141	147	363	finally
    //   180	189	395	com/google/protobuf/InvalidProtocolBufferException
    //   180	189	367	java/io/IOException
    //   180	189	363	finally
    //   192	210	395	com/google/protobuf/InvalidProtocolBufferException
    //   192	210	367	java/io/IOException
    //   192	210	363	finally
    //   215	230	395	com/google/protobuf/InvalidProtocolBufferException
    //   215	230	367	java/io/IOException
    //   215	230	363	finally
    //   234	254	395	com/google/protobuf/InvalidProtocolBufferException
    //   234	254	367	java/io/IOException
    //   234	254	363	finally
    //   257	265	395	com/google/protobuf/InvalidProtocolBufferException
    //   257	265	367	java/io/IOException
    //   257	265	363	finally
    //   268	283	395	com/google/protobuf/InvalidProtocolBufferException
    //   268	283	367	java/io/IOException
    //   268	283	363	finally
    //   286	308	395	com/google/protobuf/InvalidProtocolBufferException
    //   286	308	367	java/io/IOException
    //   286	308	363	finally
    //   313	325	395	com/google/protobuf/InvalidProtocolBufferException
    //   313	325	367	java/io/IOException
    //   313	325	363	finally
    //   329	349	395	com/google/protobuf/InvalidProtocolBufferException
    //   329	349	367	java/io/IOException
    //   329	349	363	finally
    //   349	354	395	com/google/protobuf/InvalidProtocolBufferException
    //   349	354	367	java/io/IOException
    //   349	354	363	finally
    //   368	395	363	finally
    //   396	411	363	finally
  }
  
  public Document getFound() {
    return (this.resultCase_ == 1) ? (Document)this.result_ : Document.getDefaultInstance();
  }
  
  public String getMissing() {
    String str;
    if (this.resultCase_ == 2) {
      str = (String)this.result_;
    } else {
      str = "";
    } 
    return str;
  }
  
  public ByteString getMissingBytes() {
    String str;
    if (this.resultCase_ == 2) {
      str = (String)this.result_;
    } else {
      str = "";
    } 
    return ByteString.copyFromUtf8(str);
  }
  
  public Timestamp getReadTime() {
    Timestamp timestamp1 = this.readTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public ResultCase getResultCase() {
    return ResultCase.forNumber(this.resultCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (this.resultCase_ == 1)
      j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.result_); 
    i = j;
    if (this.resultCase_ == 2)
      i = j + CodedOutputStream.computeStringSize(2, getMissing()); 
    j = i;
    if (!this.transaction_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(3, this.transaction_); 
    i = j;
    if (this.readTime_ != null)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getReadTime()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ByteString getTransaction() {
    return this.transaction_;
  }
  
  public boolean hasReadTime() {
    boolean bool;
    if (this.readTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.resultCase_ == 1)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.result_); 
    if (this.resultCase_ == 2)
      paramCodedOutputStream.writeString(2, getMissing()); 
    if (!this.transaction_.isEmpty())
      paramCodedOutputStream.writeBytes(3, this.transaction_); 
    if (this.readTime_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getReadTime()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
    private Builder() {
      super(BatchGetDocumentsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder clearFound() {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).clearFound();
      return this;
    }
    
    public Builder clearMissing() {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).clearMissing();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearResult() {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).clearResult();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).clearTransaction();
      return this;
    }
    
    public Document getFound() {
      return ((BatchGetDocumentsResponse)this.instance).getFound();
    }
    
    public String getMissing() {
      return ((BatchGetDocumentsResponse)this.instance).getMissing();
    }
    
    public ByteString getMissingBytes() {
      return ((BatchGetDocumentsResponse)this.instance).getMissingBytes();
    }
    
    public Timestamp getReadTime() {
      return ((BatchGetDocumentsResponse)this.instance).getReadTime();
    }
    
    public BatchGetDocumentsResponse.ResultCase getResultCase() {
      return ((BatchGetDocumentsResponse)this.instance).getResultCase();
    }
    
    public ByteString getTransaction() {
      return ((BatchGetDocumentsResponse)this.instance).getTransaction();
    }
    
    public boolean hasReadTime() {
      return ((BatchGetDocumentsResponse)this.instance).hasReadTime();
    }
    
    public Builder mergeFound(Document param1Document) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).mergeFound(param1Document);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setFound(Document.Builder param1Builder) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setFound(param1Builder);
      return this;
    }
    
    public Builder setFound(Document param1Document) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setFound(param1Document);
      return this;
    }
    
    public Builder setMissing(String param1String) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setMissing(param1String);
      return this;
    }
    
    public Builder setMissingBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setMissingBytes(param1ByteString);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((BatchGetDocumentsResponse)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
  
  public enum ResultCase implements Internal.EnumLite {
    FOUND(1),
    MISSING(2),
    RESULT_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    ResultCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResultCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : MISSING) : FOUND) : RESULT_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\BatchGetDocumentsResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */