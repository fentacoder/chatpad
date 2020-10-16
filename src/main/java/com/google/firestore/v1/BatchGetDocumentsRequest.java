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

public final class BatchGetDocumentsRequest extends GeneratedMessageLite<BatchGetDocumentsRequest, BatchGetDocumentsRequest.Builder> implements BatchGetDocumentsRequestOrBuilder {
  public static final int DATABASE_FIELD_NUMBER = 1;
  
  private static final BatchGetDocumentsRequest DEFAULT_INSTANCE = new BatchGetDocumentsRequest();
  
  public static final int DOCUMENTS_FIELD_NUMBER = 2;
  
  public static final int MASK_FIELD_NUMBER = 3;
  
  public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
  
  private static volatile Parser<BatchGetDocumentsRequest> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 7;
  
  public static final int TRANSACTION_FIELD_NUMBER = 4;
  
  private int bitField0_;
  
  private int consistencySelectorCase_ = 0;
  
  private Object consistencySelector_;
  
  private String database_ = "";
  
  private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.emptyProtobufList();
  
  private DocumentMask mask_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDocuments(Iterable<String> paramIterable) {
    ensureDocumentsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.documents_);
  }
  
  private void addDocuments(String paramString) {
    if (paramString != null) {
      ensureDocumentsIsMutable();
      this.documents_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDocumentsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureDocumentsIsMutable();
      this.documents_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearConsistencySelector() {
    this.consistencySelectorCase_ = 0;
    this.consistencySelector_ = null;
  }
  
  private void clearDatabase() {
    this.database_ = getDefaultInstance().getDatabase();
  }
  
  private void clearDocuments() {
    this.documents_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearMask() {
    this.mask_ = null;
  }
  
  private void clearNewTransaction() {
    if (this.consistencySelectorCase_ == 5) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearReadTime() {
    if (this.consistencySelectorCase_ == 7) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearTransaction() {
    if (this.consistencySelectorCase_ == 4) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void ensureDocumentsIsMutable() {
    if (!this.documents_.isModifiable())
      this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_); 
  }
  
  public static BatchGetDocumentsRequest getDefaultInstance() {
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
  
  private void mergeNewTransaction(TransactionOptions paramTransactionOptions) {
    if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
      this.consistencySelector_ = ((TransactionOptions.Builder)TransactionOptions.newBuilder((TransactionOptions)this.consistencySelector_).mergeFrom(paramTransactionOptions)).buildPartial();
    } else {
      this.consistencySelector_ = paramTransactionOptions;
    } 
    this.consistencySelectorCase_ = 5;
  }
  
  private void mergeReadTime(Timestamp paramTimestamp) {
    if (this.consistencySelectorCase_ == 7 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
      this.consistencySelector_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.consistencySelector_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.consistencySelector_ = paramTimestamp;
    } 
    this.consistencySelectorCase_ = 7;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BatchGetDocumentsRequest paramBatchGetDocumentsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBatchGetDocumentsRequest);
  }
  
  public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BatchGetDocumentsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BatchGetDocumentsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BatchGetDocumentsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BatchGetDocumentsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BatchGetDocumentsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BatchGetDocumentsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BatchGetDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BatchGetDocumentsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDatabase(String paramString) {
    if (paramString != null) {
      this.database_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDatabaseBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.database_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocuments(int paramInt, String paramString) {
    if (paramString != null) {
      ensureDocumentsIsMutable();
      this.documents_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
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
  
  private void setNewTransaction(TransactionOptions.Builder paramBuilder) {
    this.consistencySelector_ = paramBuilder.build();
    this.consistencySelectorCase_ = 5;
  }
  
  private void setNewTransaction(TransactionOptions paramTransactionOptions) {
    if (paramTransactionOptions != null) {
      this.consistencySelector_ = paramTransactionOptions;
      this.consistencySelectorCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReadTime(Timestamp.Builder paramBuilder) {
    this.consistencySelector_ = paramBuilder.build();
    this.consistencySelectorCase_ = 7;
  }
  
  private void setReadTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.consistencySelector_ = paramTimestamp;
      this.consistencySelectorCase_ = 7;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.consistencySelectorCase_ = 4;
      this.consistencySelector_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/BatchGetDocumentsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   22: iconst_0
    //   23: istore #9
    //   25: iload #4
    //   27: tableswitch default -> 72, 1 -> 865, 2 -> 861, 3 -> 850, 4 -> 841, 5 -> 544, 6 -> 126, 7 -> 540, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/BatchGetDocumentsRequest
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsRequest;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/BatchGetDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/BatchGetDocumentsRequest
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/BatchGetDocumentsRequest
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #9
    //   138: ifne -> 540
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 484
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 473
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 431
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 366
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 350
    //   180: iload #4
    //   182: bipush #42
    //   184: if_icmpeq -> 279
    //   187: iload #4
    //   189: bipush #58
    //   191: if_icmpeq -> 206
    //   194: aload_2
    //   195: iload #4
    //   197: invokevirtual skipField : (I)Z
    //   200: ifne -> 136
    //   203: goto -> 484
    //   206: aload_0
    //   207: getfield consistencySelectorCase_ : I
    //   210: bipush #7
    //   212: if_icmpne -> 232
    //   215: aload_0
    //   216: getfield consistencySelector_ : Ljava/lang/Object;
    //   219: checkcast com/google/protobuf/Timestamp
    //   222: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   225: checkcast com/google/protobuf/Timestamp$Builder
    //   228: astore_1
    //   229: goto -> 234
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_0
    //   235: aload_2
    //   236: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   239: aload_3
    //   240: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   243: putfield consistencySelector_ : Ljava/lang/Object;
    //   246: aload_1
    //   247: ifnull -> 270
    //   250: aload_1
    //   251: aload_0
    //   252: getfield consistencySelector_ : Ljava/lang/Object;
    //   255: checkcast com/google/protobuf/Timestamp
    //   258: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   261: pop
    //   262: aload_0
    //   263: aload_1
    //   264: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   267: putfield consistencySelector_ : Ljava/lang/Object;
    //   270: aload_0
    //   271: bipush #7
    //   273: putfield consistencySelectorCase_ : I
    //   276: goto -> 136
    //   279: aload_0
    //   280: getfield consistencySelectorCase_ : I
    //   283: iconst_5
    //   284: if_icmpne -> 304
    //   287: aload_0
    //   288: getfield consistencySelector_ : Ljava/lang/Object;
    //   291: checkcast com/google/firestore/v1/TransactionOptions
    //   294: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   297: checkcast com/google/firestore/v1/TransactionOptions$Builder
    //   300: astore_1
    //   301: goto -> 306
    //   304: aconst_null
    //   305: astore_1
    //   306: aload_0
    //   307: aload_2
    //   308: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   311: aload_3
    //   312: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   315: putfield consistencySelector_ : Ljava/lang/Object;
    //   318: aload_1
    //   319: ifnull -> 342
    //   322: aload_1
    //   323: aload_0
    //   324: getfield consistencySelector_ : Ljava/lang/Object;
    //   327: checkcast com/google/firestore/v1/TransactionOptions
    //   330: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   333: pop
    //   334: aload_0
    //   335: aload_1
    //   336: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   339: putfield consistencySelector_ : Ljava/lang/Object;
    //   342: aload_0
    //   343: iconst_5
    //   344: putfield consistencySelectorCase_ : I
    //   347: goto -> 136
    //   350: aload_0
    //   351: iconst_4
    //   352: putfield consistencySelectorCase_ : I
    //   355: aload_0
    //   356: aload_2
    //   357: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   360: putfield consistencySelector_ : Ljava/lang/Object;
    //   363: goto -> 136
    //   366: aload_0
    //   367: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   370: ifnull -> 387
    //   373: aload_0
    //   374: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   377: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   380: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   383: astore_1
    //   384: goto -> 389
    //   387: aconst_null
    //   388: astore_1
    //   389: aload_0
    //   390: aload_2
    //   391: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   394: aload_3
    //   395: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   398: checkcast com/google/firestore/v1/DocumentMask
    //   401: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   404: aload_1
    //   405: ifnull -> 136
    //   408: aload_1
    //   409: aload_0
    //   410: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   413: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   416: pop
    //   417: aload_0
    //   418: aload_1
    //   419: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   422: checkcast com/google/firestore/v1/DocumentMask
    //   425: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   428: goto -> 136
    //   431: aload_2
    //   432: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   435: astore_1
    //   436: aload_0
    //   437: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   440: invokeinterface isModifiable : ()Z
    //   445: ifne -> 459
    //   448: aload_0
    //   449: aload_0
    //   450: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   453: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   456: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   459: aload_0
    //   460: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   463: aload_1
    //   464: invokeinterface add : (Ljava/lang/Object;)Z
    //   469: pop
    //   470: goto -> 136
    //   473: aload_0
    //   474: aload_2
    //   475: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   478: putfield database_ : Ljava/lang/String;
    //   481: goto -> 136
    //   484: iconst_1
    //   485: istore #9
    //   487: goto -> 136
    //   490: astore_1
    //   491: goto -> 538
    //   494: astore_3
    //   495: new java/lang/RuntimeException
    //   498: astore_1
    //   499: new com/google/protobuf/InvalidProtocolBufferException
    //   502: astore_2
    //   503: aload_2
    //   504: aload_3
    //   505: invokevirtual getMessage : ()Ljava/lang/String;
    //   508: invokespecial <init> : (Ljava/lang/String;)V
    //   511: aload_1
    //   512: aload_2
    //   513: aload_0
    //   514: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   517: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   520: aload_1
    //   521: athrow
    //   522: astore_2
    //   523: new java/lang/RuntimeException
    //   526: astore_1
    //   527: aload_1
    //   528: aload_2
    //   529: aload_0
    //   530: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   533: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   536: aload_1
    //   537: athrow
    //   538: aload_1
    //   539: athrow
    //   540: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsRequest;
    //   543: areturn
    //   544: aload_2
    //   545: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   548: astore_1
    //   549: aload_3
    //   550: checkcast com/google/firestore/v1/BatchGetDocumentsRequest
    //   553: astore_2
    //   554: aload_0
    //   555: aload_1
    //   556: aload_0
    //   557: getfield database_ : Ljava/lang/String;
    //   560: invokevirtual isEmpty : ()Z
    //   563: iconst_1
    //   564: ixor
    //   565: aload_0
    //   566: getfield database_ : Ljava/lang/String;
    //   569: aload_2
    //   570: getfield database_ : Ljava/lang/String;
    //   573: invokevirtual isEmpty : ()Z
    //   576: iconst_1
    //   577: ixor
    //   578: aload_2
    //   579: getfield database_ : Ljava/lang/String;
    //   582: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   587: putfield database_ : Ljava/lang/String;
    //   590: aload_0
    //   591: aload_1
    //   592: aload_0
    //   593: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   596: aload_2
    //   597: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   600: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   605: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   608: aload_0
    //   609: aload_1
    //   610: aload_0
    //   611: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   614: aload_2
    //   615: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   618: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   623: checkcast com/google/firestore/v1/DocumentMask
    //   626: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   629: getstatic com/google/firestore/v1/BatchGetDocumentsRequest$1.$SwitchMap$com$google$firestore$v1$BatchGetDocumentsRequest$ConsistencySelectorCase : [I
    //   632: aload_2
    //   633: invokevirtual getConsistencySelectorCase : ()Lcom/google/firestore/v1/BatchGetDocumentsRequest$ConsistencySelectorCase;
    //   636: invokevirtual ordinal : ()I
    //   639: iaload
    //   640: istore #9
    //   642: iload #9
    //   644: iconst_1
    //   645: if_icmpeq -> 767
    //   648: iload #9
    //   650: iconst_2
    //   651: if_icmpeq -> 729
    //   654: iload #9
    //   656: iconst_3
    //   657: if_icmpeq -> 690
    //   660: iload #9
    //   662: iconst_4
    //   663: if_icmpeq -> 669
    //   666: goto -> 802
    //   669: aload_0
    //   670: getfield consistencySelectorCase_ : I
    //   673: ifeq -> 679
    //   676: iconst_1
    //   677: istore #5
    //   679: aload_1
    //   680: iload #5
    //   682: invokeinterface visitOneofNotSet : (Z)V
    //   687: goto -> 802
    //   690: iload #6
    //   692: istore #5
    //   694: aload_0
    //   695: getfield consistencySelectorCase_ : I
    //   698: bipush #7
    //   700: if_icmpne -> 706
    //   703: iconst_1
    //   704: istore #5
    //   706: aload_0
    //   707: aload_1
    //   708: iload #5
    //   710: aload_0
    //   711: getfield consistencySelector_ : Ljava/lang/Object;
    //   714: aload_2
    //   715: getfield consistencySelector_ : Ljava/lang/Object;
    //   718: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   723: putfield consistencySelector_ : Ljava/lang/Object;
    //   726: goto -> 802
    //   729: iload #7
    //   731: istore #5
    //   733: aload_0
    //   734: getfield consistencySelectorCase_ : I
    //   737: iconst_5
    //   738: if_icmpne -> 744
    //   741: iconst_1
    //   742: istore #5
    //   744: aload_0
    //   745: aload_1
    //   746: iload #5
    //   748: aload_0
    //   749: getfield consistencySelector_ : Ljava/lang/Object;
    //   752: aload_2
    //   753: getfield consistencySelector_ : Ljava/lang/Object;
    //   756: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   761: putfield consistencySelector_ : Ljava/lang/Object;
    //   764: goto -> 802
    //   767: iload #8
    //   769: istore #5
    //   771: aload_0
    //   772: getfield consistencySelectorCase_ : I
    //   775: iconst_4
    //   776: if_icmpne -> 782
    //   779: iconst_1
    //   780: istore #5
    //   782: aload_0
    //   783: aload_1
    //   784: iload #5
    //   786: aload_0
    //   787: getfield consistencySelector_ : Ljava/lang/Object;
    //   790: aload_2
    //   791: getfield consistencySelector_ : Ljava/lang/Object;
    //   794: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   799: putfield consistencySelector_ : Ljava/lang/Object;
    //   802: aload_1
    //   803: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   806: if_acmpne -> 839
    //   809: aload_2
    //   810: getfield consistencySelectorCase_ : I
    //   813: istore #9
    //   815: iload #9
    //   817: ifeq -> 826
    //   820: aload_0
    //   821: iload #9
    //   823: putfield consistencySelectorCase_ : I
    //   826: aload_0
    //   827: aload_0
    //   828: getfield bitField0_ : I
    //   831: aload_2
    //   832: getfield bitField0_ : I
    //   835: ior
    //   836: putfield bitField0_ : I
    //   839: aload_0
    //   840: areturn
    //   841: new com/google/firestore/v1/BatchGetDocumentsRequest$Builder
    //   844: dup
    //   845: aconst_null
    //   846: invokespecial <init> : (Lcom/google/firestore/v1/BatchGetDocumentsRequest$1;)V
    //   849: areturn
    //   850: aload_0
    //   851: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   854: invokeinterface makeImmutable : ()V
    //   859: aconst_null
    //   860: areturn
    //   861: getstatic com/google/firestore/v1/BatchGetDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/BatchGetDocumentsRequest;
    //   864: areturn
    //   865: new com/google/firestore/v1/BatchGetDocumentsRequest
    //   868: dup
    //   869: invokespecial <init> : ()V
    //   872: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	522	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	494	java/io/IOException
    //   141	147	490	finally
    //   194	203	522	com/google/protobuf/InvalidProtocolBufferException
    //   194	203	494	java/io/IOException
    //   194	203	490	finally
    //   206	229	522	com/google/protobuf/InvalidProtocolBufferException
    //   206	229	494	java/io/IOException
    //   206	229	490	finally
    //   234	246	522	com/google/protobuf/InvalidProtocolBufferException
    //   234	246	494	java/io/IOException
    //   234	246	490	finally
    //   250	270	522	com/google/protobuf/InvalidProtocolBufferException
    //   250	270	494	java/io/IOException
    //   250	270	490	finally
    //   270	276	522	com/google/protobuf/InvalidProtocolBufferException
    //   270	276	494	java/io/IOException
    //   270	276	490	finally
    //   279	301	522	com/google/protobuf/InvalidProtocolBufferException
    //   279	301	494	java/io/IOException
    //   279	301	490	finally
    //   306	318	522	com/google/protobuf/InvalidProtocolBufferException
    //   306	318	494	java/io/IOException
    //   306	318	490	finally
    //   322	342	522	com/google/protobuf/InvalidProtocolBufferException
    //   322	342	494	java/io/IOException
    //   322	342	490	finally
    //   342	347	522	com/google/protobuf/InvalidProtocolBufferException
    //   342	347	494	java/io/IOException
    //   342	347	490	finally
    //   350	363	522	com/google/protobuf/InvalidProtocolBufferException
    //   350	363	494	java/io/IOException
    //   350	363	490	finally
    //   366	384	522	com/google/protobuf/InvalidProtocolBufferException
    //   366	384	494	java/io/IOException
    //   366	384	490	finally
    //   389	404	522	com/google/protobuf/InvalidProtocolBufferException
    //   389	404	494	java/io/IOException
    //   389	404	490	finally
    //   408	428	522	com/google/protobuf/InvalidProtocolBufferException
    //   408	428	494	java/io/IOException
    //   408	428	490	finally
    //   431	459	522	com/google/protobuf/InvalidProtocolBufferException
    //   431	459	494	java/io/IOException
    //   431	459	490	finally
    //   459	470	522	com/google/protobuf/InvalidProtocolBufferException
    //   459	470	494	java/io/IOException
    //   459	470	490	finally
    //   473	481	522	com/google/protobuf/InvalidProtocolBufferException
    //   473	481	494	java/io/IOException
    //   473	481	490	finally
    //   495	522	490	finally
    //   523	538	490	finally
  }
  
  public ConsistencySelectorCase getConsistencySelectorCase() {
    return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
  }
  
  public String getDatabase() {
    return this.database_;
  }
  
  public ByteString getDatabaseBytes() {
    return ByteString.copyFromUtf8(this.database_);
  }
  
  public String getDocuments(int paramInt) {
    return (String)this.documents_.get(paramInt);
  }
  
  public ByteString getDocumentsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.documents_.get(paramInt));
  }
  
  public int getDocumentsCount() {
    return this.documents_.size();
  }
  
  public List<String> getDocumentsList() {
    return (List<String>)this.documents_;
  }
  
  public DocumentMask getMask() {
    DocumentMask documentMask1 = this.mask_;
    DocumentMask documentMask2 = documentMask1;
    if (documentMask1 == null)
      documentMask2 = DocumentMask.getDefaultInstance(); 
    return documentMask2;
  }
  
  public TransactionOptions getNewTransaction() {
    return (this.consistencySelectorCase_ == 5) ? (TransactionOptions)this.consistencySelector_ : TransactionOptions.getDefaultInstance();
  }
  
  public Timestamp getReadTime() {
    return (this.consistencySelectorCase_ == 7) ? (Timestamp)this.consistencySelector_ : Timestamp.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.database_.isEmpty();
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getDatabase()) + 0;
    } else {
      i = 0;
    } 
    int j = 0;
    while (b < this.documents_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.documents_.get(b));
      b++;
    } 
    i = i + j + getDocumentsList().size() * 1;
    j = i;
    if (this.mask_ != null)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getMask()); 
    i = j;
    if (this.consistencySelectorCase_ == 4)
      i = j + CodedOutputStream.computeBytesSize(4, (ByteString)this.consistencySelector_); 
    j = i;
    if (this.consistencySelectorCase_ == 5)
      j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)this.consistencySelector_); 
    i = j;
    if (this.consistencySelectorCase_ == 7)
      i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)this.consistencySelector_); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ByteString getTransaction() {
    return (this.consistencySelectorCase_ == 4) ? (ByteString)this.consistencySelector_ : ByteString.EMPTY;
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
    if (!this.database_.isEmpty())
      paramCodedOutputStream.writeString(1, getDatabase()); 
    for (byte b = 0; b < this.documents_.size(); b++)
      paramCodedOutputStream.writeString(2, (String)this.documents_.get(b)); 
    if (this.mask_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getMask()); 
    if (this.consistencySelectorCase_ == 4)
      paramCodedOutputStream.writeBytes(4, (ByteString)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 7)
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.consistencySelector_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
    private Builder() {
      super(BatchGetDocumentsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDocuments(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).addAllDocuments(param1Iterable);
      return this;
    }
    
    public Builder addDocuments(String param1String) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).addDocuments(param1String);
      return this;
    }
    
    public Builder addDocumentsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).addDocumentsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearConsistencySelector() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearConsistencySelector();
      return this;
    }
    
    public Builder clearDatabase() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearDatabase();
      return this;
    }
    
    public Builder clearDocuments() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearDocuments();
      return this;
    }
    
    public Builder clearMask() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearMask();
      return this;
    }
    
    public Builder clearNewTransaction() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearNewTransaction();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).clearTransaction();
      return this;
    }
    
    public BatchGetDocumentsRequest.ConsistencySelectorCase getConsistencySelectorCase() {
      return ((BatchGetDocumentsRequest)this.instance).getConsistencySelectorCase();
    }
    
    public String getDatabase() {
      return ((BatchGetDocumentsRequest)this.instance).getDatabase();
    }
    
    public ByteString getDatabaseBytes() {
      return ((BatchGetDocumentsRequest)this.instance).getDatabaseBytes();
    }
    
    public String getDocuments(int param1Int) {
      return ((BatchGetDocumentsRequest)this.instance).getDocuments(param1Int);
    }
    
    public ByteString getDocumentsBytes(int param1Int) {
      return ((BatchGetDocumentsRequest)this.instance).getDocumentsBytes(param1Int);
    }
    
    public int getDocumentsCount() {
      return ((BatchGetDocumentsRequest)this.instance).getDocumentsCount();
    }
    
    public List<String> getDocumentsList() {
      return Collections.unmodifiableList(((BatchGetDocumentsRequest)this.instance).getDocumentsList());
    }
    
    public DocumentMask getMask() {
      return ((BatchGetDocumentsRequest)this.instance).getMask();
    }
    
    public TransactionOptions getNewTransaction() {
      return ((BatchGetDocumentsRequest)this.instance).getNewTransaction();
    }
    
    public Timestamp getReadTime() {
      return ((BatchGetDocumentsRequest)this.instance).getReadTime();
    }
    
    public ByteString getTransaction() {
      return ((BatchGetDocumentsRequest)this.instance).getTransaction();
    }
    
    public boolean hasMask() {
      return ((BatchGetDocumentsRequest)this.instance).hasMask();
    }
    
    public Builder mergeMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).mergeMask(param1DocumentMask);
      return this;
    }
    
    public Builder mergeNewTransaction(TransactionOptions param1TransactionOptions) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).mergeNewTransaction(param1TransactionOptions);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setDatabase(String param1String) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setDatabase(param1String);
      return this;
    }
    
    public Builder setDatabaseBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setDatabaseBytes(param1ByteString);
      return this;
    }
    
    public Builder setDocuments(int param1Int, String param1String) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setDocuments(param1Int, param1String);
      return this;
    }
    
    public Builder setMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setMask(param1Builder);
      return this;
    }
    
    public Builder setMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setMask(param1DocumentMask);
      return this;
    }
    
    public Builder setNewTransaction(TransactionOptions.Builder param1Builder) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setNewTransaction(param1Builder);
      return this;
    }
    
    public Builder setNewTransaction(TransactionOptions param1TransactionOptions) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setNewTransaction(param1TransactionOptions);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((BatchGetDocumentsRequest)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
  
  public enum ConsistencySelectorCase implements Internal.EnumLite {
    CONSISTENCYSELECTOR_NOT_SET,
    NEW_TRANSACTION,
    READ_TIME,
    TRANSACTION(4);
    
    private final int value;
    
    static {
      CONSISTENCYSELECTOR_NOT_SET = new ConsistencySelectorCase("CONSISTENCYSELECTOR_NOT_SET", 3, 0);
      $VALUES = new ConsistencySelectorCase[] { TRANSACTION, NEW_TRANSACTION, READ_TIME, CONSISTENCYSELECTOR_NOT_SET };
    }
    
    ConsistencySelectorCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConsistencySelectorCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 7) ? ((param1Int != 4) ? ((param1Int != 5) ? null : NEW_TRANSACTION) : TRANSACTION) : READ_TIME) : CONSISTENCYSELECTOR_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\BatchGetDocumentsRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */