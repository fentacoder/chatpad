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

public final class RunQueryRequest extends GeneratedMessageLite<RunQueryRequest, RunQueryRequest.Builder> implements RunQueryRequestOrBuilder {
  private static final RunQueryRequest DEFAULT_INSTANCE = new RunQueryRequest();
  
  public static final int NEW_TRANSACTION_FIELD_NUMBER = 6;
  
  public static final int PARENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<RunQueryRequest> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 7;
  
  public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
  
  public static final int TRANSACTION_FIELD_NUMBER = 5;
  
  private int consistencySelectorCase_ = 0;
  
  private Object consistencySelector_;
  
  private String parent_ = "";
  
  private int queryTypeCase_ = 0;
  
  private Object queryType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearConsistencySelector() {
    this.consistencySelectorCase_ = 0;
    this.consistencySelector_ = null;
  }
  
  private void clearNewTransaction() {
    if (this.consistencySelectorCase_ == 6) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearParent() {
    this.parent_ = getDefaultInstance().getParent();
  }
  
  private void clearQueryType() {
    this.queryTypeCase_ = 0;
    this.queryType_ = null;
  }
  
  private void clearReadTime() {
    if (this.consistencySelectorCase_ == 7) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearStructuredQuery() {
    if (this.queryTypeCase_ == 2) {
      this.queryTypeCase_ = 0;
      this.queryType_ = null;
    } 
  }
  
  private void clearTransaction() {
    if (this.consistencySelectorCase_ == 5) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  public static RunQueryRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeNewTransaction(TransactionOptions paramTransactionOptions) {
    if (this.consistencySelectorCase_ == 6 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
      this.consistencySelector_ = ((TransactionOptions.Builder)TransactionOptions.newBuilder((TransactionOptions)this.consistencySelector_).mergeFrom(paramTransactionOptions)).buildPartial();
    } else {
      this.consistencySelector_ = paramTransactionOptions;
    } 
    this.consistencySelectorCase_ = 6;
  }
  
  private void mergeReadTime(Timestamp paramTimestamp) {
    if (this.consistencySelectorCase_ == 7 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
      this.consistencySelector_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.consistencySelector_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.consistencySelector_ = paramTimestamp;
    } 
    this.consistencySelectorCase_ = 7;
  }
  
  private void mergeStructuredQuery(StructuredQuery paramStructuredQuery) {
    if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
      this.queryType_ = ((StructuredQuery.Builder)StructuredQuery.newBuilder((StructuredQuery)this.queryType_).mergeFrom(paramStructuredQuery)).buildPartial();
    } else {
      this.queryType_ = paramStructuredQuery;
    } 
    this.queryTypeCase_ = 2;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RunQueryRequest paramRunQueryRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRunQueryRequest);
  }
  
  public static RunQueryRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RunQueryRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RunQueryRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RunQueryRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RunQueryRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RunQueryRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RunQueryRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RunQueryRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RunQueryRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RunQueryRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setNewTransaction(TransactionOptions.Builder paramBuilder) {
    this.consistencySelector_ = paramBuilder.build();
    this.consistencySelectorCase_ = 6;
  }
  
  private void setNewTransaction(TransactionOptions paramTransactionOptions) {
    if (paramTransactionOptions != null) {
      this.consistencySelector_ = paramTransactionOptions;
      this.consistencySelectorCase_ = 6;
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
  
  private void setStructuredQuery(StructuredQuery.Builder paramBuilder) {
    this.queryType_ = paramBuilder.build();
    this.queryTypeCase_ = 2;
  }
  
  private void setStructuredQuery(StructuredQuery paramStructuredQuery) {
    if (paramStructuredQuery != null) {
      this.queryType_ = paramStructuredQuery;
      this.queryTypeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.consistencySelectorCase_ = 5;
      this.consistencySelector_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/RunQueryRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   27: tableswitch default -> 72, 1 -> 877, 2 -> 873, 3 -> 871, 4 -> 862, 5 -> 503, 6 -> 126, 7 -> 499, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/RunQueryRequest.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/RunQueryRequest
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/RunQueryRequest.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/RunQueryRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryRequest;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/RunQueryRequest.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/RunQueryRequest
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/RunQueryRequest
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/RunQueryRequest.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #9
    //   138: ifne -> 499
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 443
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 432
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 361
    //   166: iload #4
    //   168: bipush #42
    //   170: if_icmpeq -> 345
    //   173: iload #4
    //   175: bipush #50
    //   177: if_icmpeq -> 272
    //   180: iload #4
    //   182: bipush #58
    //   184: if_icmpeq -> 199
    //   187: aload_2
    //   188: iload #4
    //   190: invokevirtual skipField : (I)Z
    //   193: ifne -> 136
    //   196: goto -> 443
    //   199: aload_0
    //   200: getfield consistencySelectorCase_ : I
    //   203: bipush #7
    //   205: if_icmpne -> 225
    //   208: aload_0
    //   209: getfield consistencySelector_ : Ljava/lang/Object;
    //   212: checkcast com/google/protobuf/Timestamp
    //   215: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   218: checkcast com/google/protobuf/Timestamp$Builder
    //   221: astore_1
    //   222: goto -> 227
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_0
    //   228: aload_2
    //   229: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   232: aload_3
    //   233: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   236: putfield consistencySelector_ : Ljava/lang/Object;
    //   239: aload_1
    //   240: ifnull -> 263
    //   243: aload_1
    //   244: aload_0
    //   245: getfield consistencySelector_ : Ljava/lang/Object;
    //   248: checkcast com/google/protobuf/Timestamp
    //   251: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   254: pop
    //   255: aload_0
    //   256: aload_1
    //   257: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   260: putfield consistencySelector_ : Ljava/lang/Object;
    //   263: aload_0
    //   264: bipush #7
    //   266: putfield consistencySelectorCase_ : I
    //   269: goto -> 136
    //   272: aload_0
    //   273: getfield consistencySelectorCase_ : I
    //   276: bipush #6
    //   278: if_icmpne -> 298
    //   281: aload_0
    //   282: getfield consistencySelector_ : Ljava/lang/Object;
    //   285: checkcast com/google/firestore/v1/TransactionOptions
    //   288: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   291: checkcast com/google/firestore/v1/TransactionOptions$Builder
    //   294: astore_1
    //   295: goto -> 300
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_0
    //   301: aload_2
    //   302: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   305: aload_3
    //   306: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   309: putfield consistencySelector_ : Ljava/lang/Object;
    //   312: aload_1
    //   313: ifnull -> 336
    //   316: aload_1
    //   317: aload_0
    //   318: getfield consistencySelector_ : Ljava/lang/Object;
    //   321: checkcast com/google/firestore/v1/TransactionOptions
    //   324: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   327: pop
    //   328: aload_0
    //   329: aload_1
    //   330: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   333: putfield consistencySelector_ : Ljava/lang/Object;
    //   336: aload_0
    //   337: bipush #6
    //   339: putfield consistencySelectorCase_ : I
    //   342: goto -> 136
    //   345: aload_0
    //   346: iconst_5
    //   347: putfield consistencySelectorCase_ : I
    //   350: aload_0
    //   351: aload_2
    //   352: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   355: putfield consistencySelector_ : Ljava/lang/Object;
    //   358: goto -> 136
    //   361: aload_0
    //   362: getfield queryTypeCase_ : I
    //   365: iconst_2
    //   366: if_icmpne -> 386
    //   369: aload_0
    //   370: getfield queryType_ : Ljava/lang/Object;
    //   373: checkcast com/google/firestore/v1/StructuredQuery
    //   376: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   379: checkcast com/google/firestore/v1/StructuredQuery$Builder
    //   382: astore_1
    //   383: goto -> 388
    //   386: aconst_null
    //   387: astore_1
    //   388: aload_0
    //   389: aload_2
    //   390: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   393: aload_3
    //   394: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   397: putfield queryType_ : Ljava/lang/Object;
    //   400: aload_1
    //   401: ifnull -> 424
    //   404: aload_1
    //   405: aload_0
    //   406: getfield queryType_ : Ljava/lang/Object;
    //   409: checkcast com/google/firestore/v1/StructuredQuery
    //   412: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   415: pop
    //   416: aload_0
    //   417: aload_1
    //   418: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   421: putfield queryType_ : Ljava/lang/Object;
    //   424: aload_0
    //   425: iconst_2
    //   426: putfield queryTypeCase_ : I
    //   429: goto -> 136
    //   432: aload_0
    //   433: aload_2
    //   434: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   437: putfield parent_ : Ljava/lang/String;
    //   440: goto -> 136
    //   443: iconst_1
    //   444: istore #9
    //   446: goto -> 136
    //   449: astore_1
    //   450: goto -> 497
    //   453: astore_3
    //   454: new java/lang/RuntimeException
    //   457: astore_2
    //   458: new com/google/protobuf/InvalidProtocolBufferException
    //   461: astore_1
    //   462: aload_1
    //   463: aload_3
    //   464: invokevirtual getMessage : ()Ljava/lang/String;
    //   467: invokespecial <init> : (Ljava/lang/String;)V
    //   470: aload_2
    //   471: aload_1
    //   472: aload_0
    //   473: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   476: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   479: aload_2
    //   480: athrow
    //   481: astore_1
    //   482: new java/lang/RuntimeException
    //   485: astore_2
    //   486: aload_2
    //   487: aload_1
    //   488: aload_0
    //   489: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   492: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   495: aload_2
    //   496: athrow
    //   497: aload_1
    //   498: athrow
    //   499: getstatic com/google/firestore/v1/RunQueryRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryRequest;
    //   502: areturn
    //   503: aload_2
    //   504: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   507: astore_1
    //   508: aload_3
    //   509: checkcast com/google/firestore/v1/RunQueryRequest
    //   512: astore_2
    //   513: aload_0
    //   514: aload_1
    //   515: aload_0
    //   516: getfield parent_ : Ljava/lang/String;
    //   519: invokevirtual isEmpty : ()Z
    //   522: iconst_1
    //   523: ixor
    //   524: aload_0
    //   525: getfield parent_ : Ljava/lang/String;
    //   528: aload_2
    //   529: getfield parent_ : Ljava/lang/String;
    //   532: invokevirtual isEmpty : ()Z
    //   535: iconst_1
    //   536: ixor
    //   537: aload_2
    //   538: getfield parent_ : Ljava/lang/String;
    //   541: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   546: putfield parent_ : Ljava/lang/String;
    //   549: getstatic com/google/firestore/v1/RunQueryRequest$1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$QueryTypeCase : [I
    //   552: aload_2
    //   553: invokevirtual getQueryTypeCase : ()Lcom/google/firestore/v1/RunQueryRequest$QueryTypeCase;
    //   556: invokevirtual ordinal : ()I
    //   559: iaload
    //   560: istore #9
    //   562: iload #9
    //   564: iconst_1
    //   565: if_icmpeq -> 604
    //   568: iload #9
    //   570: iconst_2
    //   571: if_icmpeq -> 577
    //   574: goto -> 641
    //   577: aload_0
    //   578: getfield queryTypeCase_ : I
    //   581: ifeq -> 590
    //   584: iconst_1
    //   585: istore #10
    //   587: goto -> 593
    //   590: iconst_0
    //   591: istore #10
    //   593: aload_1
    //   594: iload #10
    //   596: invokeinterface visitOneofNotSet : (Z)V
    //   601: goto -> 641
    //   604: aload_0
    //   605: getfield queryTypeCase_ : I
    //   608: iconst_2
    //   609: if_icmpne -> 618
    //   612: iconst_1
    //   613: istore #10
    //   615: goto -> 621
    //   618: iconst_0
    //   619: istore #10
    //   621: aload_0
    //   622: aload_1
    //   623: iload #10
    //   625: aload_0
    //   626: getfield queryType_ : Ljava/lang/Object;
    //   629: aload_2
    //   630: getfield queryType_ : Ljava/lang/Object;
    //   633: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: putfield queryType_ : Ljava/lang/Object;
    //   641: getstatic com/google/firestore/v1/RunQueryRequest$1.$SwitchMap$com$google$firestore$v1$RunQueryRequest$ConsistencySelectorCase : [I
    //   644: aload_2
    //   645: invokevirtual getConsistencySelectorCase : ()Lcom/google/firestore/v1/RunQueryRequest$ConsistencySelectorCase;
    //   648: invokevirtual ordinal : ()I
    //   651: iaload
    //   652: istore #9
    //   654: iload #9
    //   656: iconst_1
    //   657: if_icmpeq -> 784
    //   660: iload #9
    //   662: iconst_2
    //   663: if_icmpeq -> 745
    //   666: iload #9
    //   668: iconst_3
    //   669: if_icmpeq -> 706
    //   672: iload #9
    //   674: iconst_4
    //   675: if_icmpeq -> 681
    //   678: goto -> 819
    //   681: iload #5
    //   683: istore #10
    //   685: aload_0
    //   686: getfield consistencySelectorCase_ : I
    //   689: ifeq -> 695
    //   692: iconst_1
    //   693: istore #10
    //   695: aload_1
    //   696: iload #10
    //   698: invokeinterface visitOneofNotSet : (Z)V
    //   703: goto -> 819
    //   706: iload #6
    //   708: istore #10
    //   710: aload_0
    //   711: getfield consistencySelectorCase_ : I
    //   714: bipush #7
    //   716: if_icmpne -> 722
    //   719: iconst_1
    //   720: istore #10
    //   722: aload_0
    //   723: aload_1
    //   724: iload #10
    //   726: aload_0
    //   727: getfield consistencySelector_ : Ljava/lang/Object;
    //   730: aload_2
    //   731: getfield consistencySelector_ : Ljava/lang/Object;
    //   734: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   739: putfield consistencySelector_ : Ljava/lang/Object;
    //   742: goto -> 819
    //   745: iload #7
    //   747: istore #10
    //   749: aload_0
    //   750: getfield consistencySelectorCase_ : I
    //   753: bipush #6
    //   755: if_icmpne -> 761
    //   758: iconst_1
    //   759: istore #10
    //   761: aload_0
    //   762: aload_1
    //   763: iload #10
    //   765: aload_0
    //   766: getfield consistencySelector_ : Ljava/lang/Object;
    //   769: aload_2
    //   770: getfield consistencySelector_ : Ljava/lang/Object;
    //   773: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   778: putfield consistencySelector_ : Ljava/lang/Object;
    //   781: goto -> 819
    //   784: iload #8
    //   786: istore #10
    //   788: aload_0
    //   789: getfield consistencySelectorCase_ : I
    //   792: iconst_5
    //   793: if_icmpne -> 799
    //   796: iconst_1
    //   797: istore #10
    //   799: aload_0
    //   800: aload_1
    //   801: iload #10
    //   803: aload_0
    //   804: getfield consistencySelector_ : Ljava/lang/Object;
    //   807: aload_2
    //   808: getfield consistencySelector_ : Ljava/lang/Object;
    //   811: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   816: putfield consistencySelector_ : Ljava/lang/Object;
    //   819: aload_1
    //   820: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   823: if_acmpne -> 860
    //   826: aload_2
    //   827: getfield queryTypeCase_ : I
    //   830: istore #9
    //   832: iload #9
    //   834: ifeq -> 843
    //   837: aload_0
    //   838: iload #9
    //   840: putfield queryTypeCase_ : I
    //   843: aload_2
    //   844: getfield consistencySelectorCase_ : I
    //   847: istore #9
    //   849: iload #9
    //   851: ifeq -> 860
    //   854: aload_0
    //   855: iload #9
    //   857: putfield consistencySelectorCase_ : I
    //   860: aload_0
    //   861: areturn
    //   862: new com/google/firestore/v1/RunQueryRequest$Builder
    //   865: dup
    //   866: aconst_null
    //   867: invokespecial <init> : (Lcom/google/firestore/v1/RunQueryRequest$1;)V
    //   870: areturn
    //   871: aconst_null
    //   872: areturn
    //   873: getstatic com/google/firestore/v1/RunQueryRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryRequest;
    //   876: areturn
    //   877: new com/google/firestore/v1/RunQueryRequest
    //   880: dup
    //   881: invokespecial <init> : ()V
    //   884: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	481	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	453	java/io/IOException
    //   141	147	449	finally
    //   187	196	481	com/google/protobuf/InvalidProtocolBufferException
    //   187	196	453	java/io/IOException
    //   187	196	449	finally
    //   199	222	481	com/google/protobuf/InvalidProtocolBufferException
    //   199	222	453	java/io/IOException
    //   199	222	449	finally
    //   227	239	481	com/google/protobuf/InvalidProtocolBufferException
    //   227	239	453	java/io/IOException
    //   227	239	449	finally
    //   243	263	481	com/google/protobuf/InvalidProtocolBufferException
    //   243	263	453	java/io/IOException
    //   243	263	449	finally
    //   263	269	481	com/google/protobuf/InvalidProtocolBufferException
    //   263	269	453	java/io/IOException
    //   263	269	449	finally
    //   272	295	481	com/google/protobuf/InvalidProtocolBufferException
    //   272	295	453	java/io/IOException
    //   272	295	449	finally
    //   300	312	481	com/google/protobuf/InvalidProtocolBufferException
    //   300	312	453	java/io/IOException
    //   300	312	449	finally
    //   316	336	481	com/google/protobuf/InvalidProtocolBufferException
    //   316	336	453	java/io/IOException
    //   316	336	449	finally
    //   336	342	481	com/google/protobuf/InvalidProtocolBufferException
    //   336	342	453	java/io/IOException
    //   336	342	449	finally
    //   345	358	481	com/google/protobuf/InvalidProtocolBufferException
    //   345	358	453	java/io/IOException
    //   345	358	449	finally
    //   361	383	481	com/google/protobuf/InvalidProtocolBufferException
    //   361	383	453	java/io/IOException
    //   361	383	449	finally
    //   388	400	481	com/google/protobuf/InvalidProtocolBufferException
    //   388	400	453	java/io/IOException
    //   388	400	449	finally
    //   404	424	481	com/google/protobuf/InvalidProtocolBufferException
    //   404	424	453	java/io/IOException
    //   404	424	449	finally
    //   424	429	481	com/google/protobuf/InvalidProtocolBufferException
    //   424	429	453	java/io/IOException
    //   424	429	449	finally
    //   432	440	481	com/google/protobuf/InvalidProtocolBufferException
    //   432	440	453	java/io/IOException
    //   432	440	449	finally
    //   454	481	449	finally
    //   482	497	449	finally
  }
  
  public ConsistencySelectorCase getConsistencySelectorCase() {
    return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
  }
  
  public TransactionOptions getNewTransaction() {
    return (this.consistencySelectorCase_ == 6) ? (TransactionOptions)this.consistencySelector_ : TransactionOptions.getDefaultInstance();
  }
  
  public String getParent() {
    return this.parent_;
  }
  
  public ByteString getParentBytes() {
    return ByteString.copyFromUtf8(this.parent_);
  }
  
  public QueryTypeCase getQueryTypeCase() {
    return QueryTypeCase.forNumber(this.queryTypeCase_);
  }
  
  public Timestamp getReadTime() {
    return (this.consistencySelectorCase_ == 7) ? (Timestamp)this.consistencySelector_ : Timestamp.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.parent_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getParent()); 
    int j = i;
    if (this.queryTypeCase_ == 2)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)this.queryType_); 
    i = j;
    if (this.consistencySelectorCase_ == 5)
      i = j + CodedOutputStream.computeBytesSize(5, (ByteString)this.consistencySelector_); 
    j = i;
    if (this.consistencySelectorCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.consistencySelector_); 
    i = j;
    if (this.consistencySelectorCase_ == 7)
      i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)this.consistencySelector_); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public StructuredQuery getStructuredQuery() {
    return (this.queryTypeCase_ == 2) ? (StructuredQuery)this.queryType_ : StructuredQuery.getDefaultInstance();
  }
  
  public ByteString getTransaction() {
    return (this.consistencySelectorCase_ == 5) ? (ByteString)this.consistencySelector_ : ByteString.EMPTY;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.parent_.isEmpty())
      paramCodedOutputStream.writeString(1, getParent()); 
    if (this.queryTypeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.queryType_); 
    if (this.consistencySelectorCase_ == 5)
      paramCodedOutputStream.writeBytes(5, (ByteString)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 7)
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.consistencySelector_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RunQueryRequest, Builder> implements RunQueryRequestOrBuilder {
    private Builder() {
      super(RunQueryRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearConsistencySelector() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearConsistencySelector();
      return this;
    }
    
    public Builder clearNewTransaction() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearNewTransaction();
      return this;
    }
    
    public Builder clearParent() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearParent();
      return this;
    }
    
    public Builder clearQueryType() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearQueryType();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearStructuredQuery() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearStructuredQuery();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((RunQueryRequest)this.instance).clearTransaction();
      return this;
    }
    
    public RunQueryRequest.ConsistencySelectorCase getConsistencySelectorCase() {
      return ((RunQueryRequest)this.instance).getConsistencySelectorCase();
    }
    
    public TransactionOptions getNewTransaction() {
      return ((RunQueryRequest)this.instance).getNewTransaction();
    }
    
    public String getParent() {
      return ((RunQueryRequest)this.instance).getParent();
    }
    
    public ByteString getParentBytes() {
      return ((RunQueryRequest)this.instance).getParentBytes();
    }
    
    public RunQueryRequest.QueryTypeCase getQueryTypeCase() {
      return ((RunQueryRequest)this.instance).getQueryTypeCase();
    }
    
    public Timestamp getReadTime() {
      return ((RunQueryRequest)this.instance).getReadTime();
    }
    
    public StructuredQuery getStructuredQuery() {
      return ((RunQueryRequest)this.instance).getStructuredQuery();
    }
    
    public ByteString getTransaction() {
      return ((RunQueryRequest)this.instance).getTransaction();
    }
    
    public Builder mergeNewTransaction(TransactionOptions param1TransactionOptions) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).mergeNewTransaction(param1TransactionOptions);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder mergeStructuredQuery(StructuredQuery param1StructuredQuery) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).mergeStructuredQuery(param1StructuredQuery);
      return this;
    }
    
    public Builder setNewTransaction(TransactionOptions.Builder param1Builder) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setNewTransaction(param1Builder);
      return this;
    }
    
    public Builder setNewTransaction(TransactionOptions param1TransactionOptions) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setNewTransaction(param1TransactionOptions);
      return this;
    }
    
    public Builder setParent(String param1String) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setParent(param1String);
      return this;
    }
    
    public Builder setParentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setParentBytes(param1ByteString);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setStructuredQuery(StructuredQuery.Builder param1Builder) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setStructuredQuery(param1Builder);
      return this;
    }
    
    public Builder setStructuredQuery(StructuredQuery param1StructuredQuery) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setStructuredQuery(param1StructuredQuery);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((RunQueryRequest)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
  
  public enum ConsistencySelectorCase implements Internal.EnumLite {
    CONSISTENCYSELECTOR_NOT_SET,
    NEW_TRANSACTION,
    READ_TIME,
    TRANSACTION(5);
    
    private final int value;
    
    static {
      CONSISTENCYSELECTOR_NOT_SET = new ConsistencySelectorCase("CONSISTENCYSELECTOR_NOT_SET", 3, 0);
      $VALUES = new ConsistencySelectorCase[] { TRANSACTION, NEW_TRANSACTION, READ_TIME, CONSISTENCYSELECTOR_NOT_SET };
    }
    
    ConsistencySelectorCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConsistencySelectorCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 5) ? ((param1Int != 6) ? ((param1Int != 7) ? null : READ_TIME) : NEW_TRANSACTION) : TRANSACTION) : CONSISTENCYSELECTOR_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public enum QueryTypeCase implements Internal.EnumLite {
    QUERYTYPE_NOT_SET(5),
    STRUCTURED_QUERY(2);
    
    private final int value;
    
    static {
      $VALUES = new QueryTypeCase[] { STRUCTURED_QUERY, QUERYTYPE_NOT_SET };
    }
    
    QueryTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static QueryTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? null : STRUCTURED_QUERY) : QUERYTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\RunQueryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */