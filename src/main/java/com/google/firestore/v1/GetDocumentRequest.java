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

public final class GetDocumentRequest extends GeneratedMessageLite<GetDocumentRequest, GetDocumentRequest.Builder> implements GetDocumentRequestOrBuilder {
  private static final GetDocumentRequest DEFAULT_INSTANCE = new GetDocumentRequest();
  
  public static final int MASK_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<GetDocumentRequest> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 5;
  
  public static final int TRANSACTION_FIELD_NUMBER = 3;
  
  private int consistencySelectorCase_ = 0;
  
  private Object consistencySelector_;
  
  private DocumentMask mask_;
  
  private String name_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearConsistencySelector() {
    this.consistencySelectorCase_ = 0;
    this.consistencySelector_ = null;
  }
  
  private void clearMask() {
    this.mask_ = null;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearReadTime() {
    if (this.consistencySelectorCase_ == 5) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearTransaction() {
    if (this.consistencySelectorCase_ == 3) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  public static GetDocumentRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeMask(DocumentMask paramDocumentMask) {
    DocumentMask documentMask = this.mask_;
    if (documentMask != null && documentMask != DocumentMask.getDefaultInstance()) {
      this.mask_ = (DocumentMask)((DocumentMask.Builder)DocumentMask.newBuilder(this.mask_).mergeFrom(paramDocumentMask)).buildPartial();
    } else {
      this.mask_ = paramDocumentMask;
    } 
  }
  
  private void mergeReadTime(Timestamp paramTimestamp) {
    if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
      this.consistencySelector_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.consistencySelector_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.consistencySelector_ = paramTimestamp;
    } 
    this.consistencySelectorCase_ = 5;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(GetDocumentRequest paramGetDocumentRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramGetDocumentRequest);
  }
  
  public static GetDocumentRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (GetDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetDocumentRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDocumentRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static GetDocumentRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static GetDocumentRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static GetDocumentRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDocumentRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static GetDocumentRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static GetDocumentRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static GetDocumentRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (GetDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<GetDocumentRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setMask(DocumentMask.Builder paramBuilder) {
    this.mask_ = (DocumentMask)paramBuilder.build();
  }
  
  private void setMask(DocumentMask paramDocumentMask) {
    if (paramDocumentMask != null) {
      this.mask_ = paramDocumentMask;
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
  
  private void setReadTime(Timestamp.Builder paramBuilder) {
    this.consistencySelector_ = paramBuilder.build();
    this.consistencySelectorCase_ = 5;
  }
  
  private void setReadTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.consistencySelector_ = paramTimestamp;
      this.consistencySelectorCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.consistencySelectorCase_ = 3;
      this.consistencySelector_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/GetDocumentRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 651, 2 -> 647, 3 -> 645, 4 -> 636, 5 -> 415, 6 -> 126, 7 -> 411, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/GetDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/GetDocumentRequest
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/GetDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/GetDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/GetDocumentRequest;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/GetDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/GetDocumentRequest
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/GetDocumentRequest
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/GetDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 411
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 355
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 344
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 279
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 263
    //   173: iload #4
    //   175: bipush #42
    //   177: if_icmpeq -> 192
    //   180: aload_2
    //   181: iload #4
    //   183: invokevirtual skipField : (I)Z
    //   186: ifne -> 136
    //   189: goto -> 355
    //   192: aload_0
    //   193: getfield consistencySelectorCase_ : I
    //   196: iconst_5
    //   197: if_icmpne -> 217
    //   200: aload_0
    //   201: getfield consistencySelector_ : Ljava/lang/Object;
    //   204: checkcast com/google/protobuf/Timestamp
    //   207: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   210: checkcast com/google/protobuf/Timestamp$Builder
    //   213: astore_1
    //   214: goto -> 219
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_0
    //   220: aload_2
    //   221: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   224: aload_3
    //   225: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   228: putfield consistencySelector_ : Ljava/lang/Object;
    //   231: aload_1
    //   232: ifnull -> 255
    //   235: aload_1
    //   236: aload_0
    //   237: getfield consistencySelector_ : Ljava/lang/Object;
    //   240: checkcast com/google/protobuf/Timestamp
    //   243: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   246: pop
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   252: putfield consistencySelector_ : Ljava/lang/Object;
    //   255: aload_0
    //   256: iconst_5
    //   257: putfield consistencySelectorCase_ : I
    //   260: goto -> 136
    //   263: aload_0
    //   264: iconst_3
    //   265: putfield consistencySelectorCase_ : I
    //   268: aload_0
    //   269: aload_2
    //   270: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   273: putfield consistencySelector_ : Ljava/lang/Object;
    //   276: goto -> 136
    //   279: aload_0
    //   280: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   283: ifnull -> 300
    //   286: aload_0
    //   287: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   290: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   293: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   296: astore_1
    //   297: goto -> 302
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_0
    //   303: aload_2
    //   304: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   307: aload_3
    //   308: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   311: checkcast com/google/firestore/v1/DocumentMask
    //   314: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   317: aload_1
    //   318: ifnull -> 136
    //   321: aload_1
    //   322: aload_0
    //   323: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   326: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   329: pop
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   335: checkcast com/google/firestore/v1/DocumentMask
    //   338: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   341: goto -> 136
    //   344: aload_0
    //   345: aload_2
    //   346: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   349: putfield name_ : Ljava/lang/String;
    //   352: goto -> 136
    //   355: iconst_1
    //   356: istore #8
    //   358: goto -> 136
    //   361: astore_1
    //   362: goto -> 409
    //   365: astore_1
    //   366: new java/lang/RuntimeException
    //   369: astore_2
    //   370: new com/google/protobuf/InvalidProtocolBufferException
    //   373: astore_3
    //   374: aload_3
    //   375: aload_1
    //   376: invokevirtual getMessage : ()Ljava/lang/String;
    //   379: invokespecial <init> : (Ljava/lang/String;)V
    //   382: aload_2
    //   383: aload_3
    //   384: aload_0
    //   385: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   388: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   391: aload_2
    //   392: athrow
    //   393: astore_1
    //   394: new java/lang/RuntimeException
    //   397: astore_2
    //   398: aload_2
    //   399: aload_1
    //   400: aload_0
    //   401: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   404: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   407: aload_2
    //   408: athrow
    //   409: aload_1
    //   410: athrow
    //   411: getstatic com/google/firestore/v1/GetDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/GetDocumentRequest;
    //   414: areturn
    //   415: aload_2
    //   416: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   419: astore_1
    //   420: aload_3
    //   421: checkcast com/google/firestore/v1/GetDocumentRequest
    //   424: astore_2
    //   425: aload_0
    //   426: aload_1
    //   427: aload_0
    //   428: getfield name_ : Ljava/lang/String;
    //   431: invokevirtual isEmpty : ()Z
    //   434: iconst_1
    //   435: ixor
    //   436: aload_0
    //   437: getfield name_ : Ljava/lang/String;
    //   440: aload_2
    //   441: getfield name_ : Ljava/lang/String;
    //   444: invokevirtual isEmpty : ()Z
    //   447: iconst_1
    //   448: ixor
    //   449: aload_2
    //   450: getfield name_ : Ljava/lang/String;
    //   453: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   458: putfield name_ : Ljava/lang/String;
    //   461: aload_0
    //   462: aload_1
    //   463: aload_0
    //   464: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   467: aload_2
    //   468: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   471: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   476: checkcast com/google/firestore/v1/DocumentMask
    //   479: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   482: getstatic com/google/firestore/v1/GetDocumentRequest$1.$SwitchMap$com$google$firestore$v1$GetDocumentRequest$ConsistencySelectorCase : [I
    //   485: aload_2
    //   486: invokevirtual getConsistencySelectorCase : ()Lcom/google/firestore/v1/GetDocumentRequest$ConsistencySelectorCase;
    //   489: invokevirtual ordinal : ()I
    //   492: iaload
    //   493: istore #8
    //   495: iload #8
    //   497: iconst_1
    //   498: if_icmpeq -> 575
    //   501: iload #8
    //   503: iconst_2
    //   504: if_icmpeq -> 537
    //   507: iload #8
    //   509: iconst_3
    //   510: if_icmpeq -> 516
    //   513: goto -> 610
    //   516: aload_0
    //   517: getfield consistencySelectorCase_ : I
    //   520: ifeq -> 526
    //   523: iconst_1
    //   524: istore #5
    //   526: aload_1
    //   527: iload #5
    //   529: invokeinterface visitOneofNotSet : (Z)V
    //   534: goto -> 610
    //   537: iload #6
    //   539: istore #5
    //   541: aload_0
    //   542: getfield consistencySelectorCase_ : I
    //   545: iconst_5
    //   546: if_icmpne -> 552
    //   549: iconst_1
    //   550: istore #5
    //   552: aload_0
    //   553: aload_1
    //   554: iload #5
    //   556: aload_0
    //   557: getfield consistencySelector_ : Ljava/lang/Object;
    //   560: aload_2
    //   561: getfield consistencySelector_ : Ljava/lang/Object;
    //   564: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: putfield consistencySelector_ : Ljava/lang/Object;
    //   572: goto -> 610
    //   575: iload #7
    //   577: istore #5
    //   579: aload_0
    //   580: getfield consistencySelectorCase_ : I
    //   583: iconst_3
    //   584: if_icmpne -> 590
    //   587: iconst_1
    //   588: istore #5
    //   590: aload_0
    //   591: aload_1
    //   592: iload #5
    //   594: aload_0
    //   595: getfield consistencySelector_ : Ljava/lang/Object;
    //   598: aload_2
    //   599: getfield consistencySelector_ : Ljava/lang/Object;
    //   602: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   607: putfield consistencySelector_ : Ljava/lang/Object;
    //   610: aload_1
    //   611: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   614: if_acmpne -> 634
    //   617: aload_2
    //   618: getfield consistencySelectorCase_ : I
    //   621: istore #8
    //   623: iload #8
    //   625: ifeq -> 634
    //   628: aload_0
    //   629: iload #8
    //   631: putfield consistencySelectorCase_ : I
    //   634: aload_0
    //   635: areturn
    //   636: new com/google/firestore/v1/GetDocumentRequest$Builder
    //   639: dup
    //   640: aconst_null
    //   641: invokespecial <init> : (Lcom/google/firestore/v1/GetDocumentRequest$1;)V
    //   644: areturn
    //   645: aconst_null
    //   646: areturn
    //   647: getstatic com/google/firestore/v1/GetDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/GetDocumentRequest;
    //   650: areturn
    //   651: new com/google/firestore/v1/GetDocumentRequest
    //   654: dup
    //   655: invokespecial <init> : ()V
    //   658: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	393	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	365	java/io/IOException
    //   141	147	361	finally
    //   180	189	393	com/google/protobuf/InvalidProtocolBufferException
    //   180	189	365	java/io/IOException
    //   180	189	361	finally
    //   192	214	393	com/google/protobuf/InvalidProtocolBufferException
    //   192	214	365	java/io/IOException
    //   192	214	361	finally
    //   219	231	393	com/google/protobuf/InvalidProtocolBufferException
    //   219	231	365	java/io/IOException
    //   219	231	361	finally
    //   235	255	393	com/google/protobuf/InvalidProtocolBufferException
    //   235	255	365	java/io/IOException
    //   235	255	361	finally
    //   255	260	393	com/google/protobuf/InvalidProtocolBufferException
    //   255	260	365	java/io/IOException
    //   255	260	361	finally
    //   263	276	393	com/google/protobuf/InvalidProtocolBufferException
    //   263	276	365	java/io/IOException
    //   263	276	361	finally
    //   279	297	393	com/google/protobuf/InvalidProtocolBufferException
    //   279	297	365	java/io/IOException
    //   279	297	361	finally
    //   302	317	393	com/google/protobuf/InvalidProtocolBufferException
    //   302	317	365	java/io/IOException
    //   302	317	361	finally
    //   321	341	393	com/google/protobuf/InvalidProtocolBufferException
    //   321	341	365	java/io/IOException
    //   321	341	361	finally
    //   344	352	393	com/google/protobuf/InvalidProtocolBufferException
    //   344	352	365	java/io/IOException
    //   344	352	361	finally
    //   366	393	361	finally
    //   394	409	361	finally
  }
  
  public ConsistencySelectorCase getConsistencySelectorCase() {
    return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
  }
  
  public DocumentMask getMask() {
    DocumentMask documentMask1 = this.mask_;
    DocumentMask documentMask2 = documentMask1;
    if (documentMask1 == null)
      documentMask2 = DocumentMask.getDefaultInstance(); 
    return documentMask2;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Timestamp getReadTime() {
    return (this.consistencySelectorCase_ == 5) ? (Timestamp)this.consistencySelector_ : Timestamp.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.name_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    i = j;
    if (this.mask_ != null)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getMask()); 
    j = i;
    if (this.consistencySelectorCase_ == 3)
      j = i + CodedOutputStream.computeBytesSize(3, (ByteString)this.consistencySelector_); 
    i = j;
    if (this.consistencySelectorCase_ == 5)
      i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)this.consistencySelector_); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ByteString getTransaction() {
    return (this.consistencySelectorCase_ == 3) ? (ByteString)this.consistencySelector_ : ByteString.EMPTY;
  }
  
  public boolean hasMask() {
    boolean bool;
    if (this.mask_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.mask_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getMask()); 
    if (this.consistencySelectorCase_ == 3)
      paramCodedOutputStream.writeBytes(3, (ByteString)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.consistencySelector_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
    private Builder() {
      super(GetDocumentRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearConsistencySelector() {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).clearConsistencySelector();
      return this;
    }
    
    public Builder clearMask() {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).clearMask();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).clearName();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).clearTransaction();
      return this;
    }
    
    public GetDocumentRequest.ConsistencySelectorCase getConsistencySelectorCase() {
      return ((GetDocumentRequest)this.instance).getConsistencySelectorCase();
    }
    
    public DocumentMask getMask() {
      return ((GetDocumentRequest)this.instance).getMask();
    }
    
    public String getName() {
      return ((GetDocumentRequest)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((GetDocumentRequest)this.instance).getNameBytes();
    }
    
    public Timestamp getReadTime() {
      return ((GetDocumentRequest)this.instance).getReadTime();
    }
    
    public ByteString getTransaction() {
      return ((GetDocumentRequest)this.instance).getTransaction();
    }
    
    public boolean hasMask() {
      return ((GetDocumentRequest)this.instance).hasMask();
    }
    
    public Builder mergeMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).mergeMask(param1DocumentMask);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setMask(param1Builder);
      return this;
    }
    
    public Builder setMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setMask(param1DocumentMask);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((GetDocumentRequest)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
  
  public enum ConsistencySelectorCase implements Internal.EnumLite {
    CONSISTENCYSELECTOR_NOT_SET,
    READ_TIME,
    TRANSACTION(3);
    
    private final int value;
    
    static {
      CONSISTENCYSELECTOR_NOT_SET = new ConsistencySelectorCase("CONSISTENCYSELECTOR_NOT_SET", 2, 0);
      $VALUES = new ConsistencySelectorCase[] { TRANSACTION, READ_TIME, CONSISTENCYSELECTOR_NOT_SET };
    }
    
    ConsistencySelectorCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConsistencySelectorCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 3) ? ((param1Int != 5) ? null : READ_TIME) : TRANSACTION) : CONSISTENCYSELECTOR_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\GetDocumentRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */