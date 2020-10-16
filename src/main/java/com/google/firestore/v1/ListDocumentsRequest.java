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

public final class ListDocumentsRequest extends GeneratedMessageLite<ListDocumentsRequest, ListDocumentsRequest.Builder> implements ListDocumentsRequestOrBuilder {
  public static final int COLLECTION_ID_FIELD_NUMBER = 2;
  
  private static final ListDocumentsRequest DEFAULT_INSTANCE = new ListDocumentsRequest();
  
  public static final int MASK_FIELD_NUMBER = 7;
  
  public static final int ORDER_BY_FIELD_NUMBER = 6;
  
  public static final int PAGE_SIZE_FIELD_NUMBER = 3;
  
  public static final int PAGE_TOKEN_FIELD_NUMBER = 4;
  
  public static final int PARENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<ListDocumentsRequest> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 10;
  
  public static final int SHOW_MISSING_FIELD_NUMBER = 12;
  
  public static final int TRANSACTION_FIELD_NUMBER = 8;
  
  private String collectionId_ = "";
  
  private int consistencySelectorCase_ = 0;
  
  private Object consistencySelector_;
  
  private DocumentMask mask_;
  
  private String orderBy_ = "";
  
  private int pageSize_;
  
  private String pageToken_ = "";
  
  private String parent_ = "";
  
  private boolean showMissing_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCollectionId() {
    this.collectionId_ = getDefaultInstance().getCollectionId();
  }
  
  private void clearConsistencySelector() {
    this.consistencySelectorCase_ = 0;
    this.consistencySelector_ = null;
  }
  
  private void clearMask() {
    this.mask_ = null;
  }
  
  private void clearOrderBy() {
    this.orderBy_ = getDefaultInstance().getOrderBy();
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
  
  private void clearReadTime() {
    if (this.consistencySelectorCase_ == 10) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  private void clearShowMissing() {
    this.showMissing_ = false;
  }
  
  private void clearTransaction() {
    if (this.consistencySelectorCase_ == 8) {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    } 
  }
  
  public static ListDocumentsRequest getDefaultInstance() {
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
    if (this.consistencySelectorCase_ == 10 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
      this.consistencySelector_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.consistencySelector_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.consistencySelector_ = paramTimestamp;
    } 
    this.consistencySelectorCase_ = 10;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListDocumentsRequest paramListDocumentsRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListDocumentsRequest);
  }
  
  public static ListDocumentsRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListDocumentsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListDocumentsRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListDocumentsRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListDocumentsRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListDocumentsRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListDocumentsRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListDocumentsRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListDocumentsRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCollectionId(String paramString) {
    if (paramString != null) {
      this.collectionId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCollectionIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.collectionId_ = paramByteString.toStringUtf8();
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
  
  private void setOrderBy(String paramString) {
    if (paramString != null) {
      this.orderBy_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOrderByBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.orderBy_ = paramByteString.toStringUtf8();
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
    this.consistencySelectorCase_ = 10;
  }
  
  private void setReadTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.consistencySelector_ = paramTimestamp;
      this.consistencySelectorCase_ = 10;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setShowMissing(boolean paramBoolean) {
    this.showMissing_ = paramBoolean;
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.consistencySelectorCase_ = 8;
      this.consistencySelector_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ListDocumentsRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 946, 2 -> 942, 3 -> 940, 4 -> 931, 5 -> 508, 6 -> 126, 7 -> 504, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/ListDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/ListDocumentsRequest
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/ListDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/ListDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsRequest;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/ListDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/ListDocumentsRequest
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/ListDocumentsRequest
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/ListDocumentsRequest.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 504
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 448
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 437
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 426
    //   166: iload #4
    //   168: bipush #24
    //   170: if_icmpeq -> 415
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 404
    //   180: iload #4
    //   182: bipush #50
    //   184: if_icmpeq -> 393
    //   187: iload #4
    //   189: bipush #58
    //   191: if_icmpeq -> 328
    //   194: iload #4
    //   196: bipush #66
    //   198: if_icmpeq -> 311
    //   201: iload #4
    //   203: bipush #82
    //   205: if_icmpeq -> 238
    //   208: iload #4
    //   210: bipush #96
    //   212: if_icmpeq -> 227
    //   215: aload_2
    //   216: iload #4
    //   218: invokevirtual skipField : (I)Z
    //   221: ifne -> 136
    //   224: goto -> 448
    //   227: aload_0
    //   228: aload_2
    //   229: invokevirtual readBool : ()Z
    //   232: putfield showMissing_ : Z
    //   235: goto -> 136
    //   238: aload_0
    //   239: getfield consistencySelectorCase_ : I
    //   242: bipush #10
    //   244: if_icmpne -> 264
    //   247: aload_0
    //   248: getfield consistencySelector_ : Ljava/lang/Object;
    //   251: checkcast com/google/protobuf/Timestamp
    //   254: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   257: checkcast com/google/protobuf/Timestamp$Builder
    //   260: astore_1
    //   261: goto -> 266
    //   264: aconst_null
    //   265: astore_1
    //   266: aload_0
    //   267: aload_2
    //   268: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   271: aload_3
    //   272: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   275: putfield consistencySelector_ : Ljava/lang/Object;
    //   278: aload_1
    //   279: ifnull -> 302
    //   282: aload_1
    //   283: aload_0
    //   284: getfield consistencySelector_ : Ljava/lang/Object;
    //   287: checkcast com/google/protobuf/Timestamp
    //   290: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   293: pop
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   299: putfield consistencySelector_ : Ljava/lang/Object;
    //   302: aload_0
    //   303: bipush #10
    //   305: putfield consistencySelectorCase_ : I
    //   308: goto -> 136
    //   311: aload_0
    //   312: bipush #8
    //   314: putfield consistencySelectorCase_ : I
    //   317: aload_0
    //   318: aload_2
    //   319: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   322: putfield consistencySelector_ : Ljava/lang/Object;
    //   325: goto -> 136
    //   328: aload_0
    //   329: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   332: ifnull -> 349
    //   335: aload_0
    //   336: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   339: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   342: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   345: astore_1
    //   346: goto -> 351
    //   349: aconst_null
    //   350: astore_1
    //   351: aload_0
    //   352: aload_2
    //   353: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   356: aload_3
    //   357: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   360: checkcast com/google/firestore/v1/DocumentMask
    //   363: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   366: aload_1
    //   367: ifnull -> 136
    //   370: aload_1
    //   371: aload_0
    //   372: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   375: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   378: pop
    //   379: aload_0
    //   380: aload_1
    //   381: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   384: checkcast com/google/firestore/v1/DocumentMask
    //   387: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   390: goto -> 136
    //   393: aload_0
    //   394: aload_2
    //   395: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   398: putfield orderBy_ : Ljava/lang/String;
    //   401: goto -> 136
    //   404: aload_0
    //   405: aload_2
    //   406: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   409: putfield pageToken_ : Ljava/lang/String;
    //   412: goto -> 136
    //   415: aload_0
    //   416: aload_2
    //   417: invokevirtual readInt32 : ()I
    //   420: putfield pageSize_ : I
    //   423: goto -> 136
    //   426: aload_0
    //   427: aload_2
    //   428: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   431: putfield collectionId_ : Ljava/lang/String;
    //   434: goto -> 136
    //   437: aload_0
    //   438: aload_2
    //   439: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   442: putfield parent_ : Ljava/lang/String;
    //   445: goto -> 136
    //   448: iconst_1
    //   449: istore #8
    //   451: goto -> 136
    //   454: astore_1
    //   455: goto -> 502
    //   458: astore_2
    //   459: new java/lang/RuntimeException
    //   462: astore_3
    //   463: new com/google/protobuf/InvalidProtocolBufferException
    //   466: astore_1
    //   467: aload_1
    //   468: aload_2
    //   469: invokevirtual getMessage : ()Ljava/lang/String;
    //   472: invokespecial <init> : (Ljava/lang/String;)V
    //   475: aload_3
    //   476: aload_1
    //   477: aload_0
    //   478: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   481: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   484: aload_3
    //   485: athrow
    //   486: astore_1
    //   487: new java/lang/RuntimeException
    //   490: astore_2
    //   491: aload_2
    //   492: aload_1
    //   493: aload_0
    //   494: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   497: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   500: aload_2
    //   501: athrow
    //   502: aload_1
    //   503: athrow
    //   504: getstatic com/google/firestore/v1/ListDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsRequest;
    //   507: areturn
    //   508: aload_2
    //   509: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   512: astore_1
    //   513: aload_3
    //   514: checkcast com/google/firestore/v1/ListDocumentsRequest
    //   517: astore_2
    //   518: aload_0
    //   519: aload_1
    //   520: aload_0
    //   521: getfield parent_ : Ljava/lang/String;
    //   524: invokevirtual isEmpty : ()Z
    //   527: iconst_1
    //   528: ixor
    //   529: aload_0
    //   530: getfield parent_ : Ljava/lang/String;
    //   533: aload_2
    //   534: getfield parent_ : Ljava/lang/String;
    //   537: invokevirtual isEmpty : ()Z
    //   540: iconst_1
    //   541: ixor
    //   542: aload_2
    //   543: getfield parent_ : Ljava/lang/String;
    //   546: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   551: putfield parent_ : Ljava/lang/String;
    //   554: aload_0
    //   555: aload_1
    //   556: aload_0
    //   557: getfield collectionId_ : Ljava/lang/String;
    //   560: invokevirtual isEmpty : ()Z
    //   563: iconst_1
    //   564: ixor
    //   565: aload_0
    //   566: getfield collectionId_ : Ljava/lang/String;
    //   569: aload_2
    //   570: getfield collectionId_ : Ljava/lang/String;
    //   573: invokevirtual isEmpty : ()Z
    //   576: iconst_1
    //   577: ixor
    //   578: aload_2
    //   579: getfield collectionId_ : Ljava/lang/String;
    //   582: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   587: putfield collectionId_ : Ljava/lang/String;
    //   590: aload_0
    //   591: getfield pageSize_ : I
    //   594: ifeq -> 603
    //   597: iconst_1
    //   598: istore #9
    //   600: goto -> 606
    //   603: iconst_0
    //   604: istore #9
    //   606: aload_0
    //   607: getfield pageSize_ : I
    //   610: istore #8
    //   612: aload_2
    //   613: getfield pageSize_ : I
    //   616: ifeq -> 625
    //   619: iconst_1
    //   620: istore #10
    //   622: goto -> 628
    //   625: iconst_0
    //   626: istore #10
    //   628: aload_0
    //   629: aload_1
    //   630: iload #9
    //   632: iload #8
    //   634: iload #10
    //   636: aload_2
    //   637: getfield pageSize_ : I
    //   640: invokeinterface visitInt : (ZIZI)I
    //   645: putfield pageSize_ : I
    //   648: aload_0
    //   649: aload_1
    //   650: aload_0
    //   651: getfield pageToken_ : Ljava/lang/String;
    //   654: invokevirtual isEmpty : ()Z
    //   657: iconst_1
    //   658: ixor
    //   659: aload_0
    //   660: getfield pageToken_ : Ljava/lang/String;
    //   663: aload_2
    //   664: getfield pageToken_ : Ljava/lang/String;
    //   667: invokevirtual isEmpty : ()Z
    //   670: iconst_1
    //   671: ixor
    //   672: aload_2
    //   673: getfield pageToken_ : Ljava/lang/String;
    //   676: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   681: putfield pageToken_ : Ljava/lang/String;
    //   684: aload_0
    //   685: aload_1
    //   686: aload_0
    //   687: getfield orderBy_ : Ljava/lang/String;
    //   690: invokevirtual isEmpty : ()Z
    //   693: iconst_1
    //   694: ixor
    //   695: aload_0
    //   696: getfield orderBy_ : Ljava/lang/String;
    //   699: aload_2
    //   700: getfield orderBy_ : Ljava/lang/String;
    //   703: invokevirtual isEmpty : ()Z
    //   706: iconst_1
    //   707: ixor
    //   708: aload_2
    //   709: getfield orderBy_ : Ljava/lang/String;
    //   712: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   717: putfield orderBy_ : Ljava/lang/String;
    //   720: aload_0
    //   721: aload_1
    //   722: aload_0
    //   723: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   726: aload_2
    //   727: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   730: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   735: checkcast com/google/firestore/v1/DocumentMask
    //   738: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   741: aload_0
    //   742: getfield showMissing_ : Z
    //   745: istore #9
    //   747: aload_2
    //   748: getfield showMissing_ : Z
    //   751: istore #10
    //   753: aload_0
    //   754: aload_1
    //   755: iload #9
    //   757: iload #9
    //   759: iload #10
    //   761: iload #10
    //   763: invokeinterface visitBoolean : (ZZZZ)Z
    //   768: putfield showMissing_ : Z
    //   771: getstatic com/google/firestore/v1/ListDocumentsRequest$1.$SwitchMap$com$google$firestore$v1$ListDocumentsRequest$ConsistencySelectorCase : [I
    //   774: aload_2
    //   775: invokevirtual getConsistencySelectorCase : ()Lcom/google/firestore/v1/ListDocumentsRequest$ConsistencySelectorCase;
    //   778: invokevirtual ordinal : ()I
    //   781: iaload
    //   782: istore #8
    //   784: iload #8
    //   786: iconst_1
    //   787: if_icmpeq -> 869
    //   790: iload #8
    //   792: iconst_2
    //   793: if_icmpeq -> 830
    //   796: iload #8
    //   798: iconst_3
    //   799: if_icmpeq -> 805
    //   802: goto -> 905
    //   805: iload #5
    //   807: istore #9
    //   809: aload_0
    //   810: getfield consistencySelectorCase_ : I
    //   813: ifeq -> 819
    //   816: iconst_1
    //   817: istore #9
    //   819: aload_1
    //   820: iload #9
    //   822: invokeinterface visitOneofNotSet : (Z)V
    //   827: goto -> 905
    //   830: iload #6
    //   832: istore #9
    //   834: aload_0
    //   835: getfield consistencySelectorCase_ : I
    //   838: bipush #10
    //   840: if_icmpne -> 846
    //   843: iconst_1
    //   844: istore #9
    //   846: aload_0
    //   847: aload_1
    //   848: iload #9
    //   850: aload_0
    //   851: getfield consistencySelector_ : Ljava/lang/Object;
    //   854: aload_2
    //   855: getfield consistencySelector_ : Ljava/lang/Object;
    //   858: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   863: putfield consistencySelector_ : Ljava/lang/Object;
    //   866: goto -> 905
    //   869: iload #7
    //   871: istore #9
    //   873: aload_0
    //   874: getfield consistencySelectorCase_ : I
    //   877: bipush #8
    //   879: if_icmpne -> 885
    //   882: iconst_1
    //   883: istore #9
    //   885: aload_0
    //   886: aload_1
    //   887: iload #9
    //   889: aload_0
    //   890: getfield consistencySelector_ : Ljava/lang/Object;
    //   893: aload_2
    //   894: getfield consistencySelector_ : Ljava/lang/Object;
    //   897: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   902: putfield consistencySelector_ : Ljava/lang/Object;
    //   905: aload_1
    //   906: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   909: if_acmpne -> 929
    //   912: aload_2
    //   913: getfield consistencySelectorCase_ : I
    //   916: istore #8
    //   918: iload #8
    //   920: ifeq -> 929
    //   923: aload_0
    //   924: iload #8
    //   926: putfield consistencySelectorCase_ : I
    //   929: aload_0
    //   930: areturn
    //   931: new com/google/firestore/v1/ListDocumentsRequest$Builder
    //   934: dup
    //   935: aconst_null
    //   936: invokespecial <init> : (Lcom/google/firestore/v1/ListDocumentsRequest$1;)V
    //   939: areturn
    //   940: aconst_null
    //   941: areturn
    //   942: getstatic com/google/firestore/v1/ListDocumentsRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsRequest;
    //   945: areturn
    //   946: new com/google/firestore/v1/ListDocumentsRequest
    //   949: dup
    //   950: invokespecial <init> : ()V
    //   953: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	486	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	458	java/io/IOException
    //   141	147	454	finally
    //   215	224	486	com/google/protobuf/InvalidProtocolBufferException
    //   215	224	458	java/io/IOException
    //   215	224	454	finally
    //   227	235	486	com/google/protobuf/InvalidProtocolBufferException
    //   227	235	458	java/io/IOException
    //   227	235	454	finally
    //   238	261	486	com/google/protobuf/InvalidProtocolBufferException
    //   238	261	458	java/io/IOException
    //   238	261	454	finally
    //   266	278	486	com/google/protobuf/InvalidProtocolBufferException
    //   266	278	458	java/io/IOException
    //   266	278	454	finally
    //   282	302	486	com/google/protobuf/InvalidProtocolBufferException
    //   282	302	458	java/io/IOException
    //   282	302	454	finally
    //   302	308	486	com/google/protobuf/InvalidProtocolBufferException
    //   302	308	458	java/io/IOException
    //   302	308	454	finally
    //   311	325	486	com/google/protobuf/InvalidProtocolBufferException
    //   311	325	458	java/io/IOException
    //   311	325	454	finally
    //   328	346	486	com/google/protobuf/InvalidProtocolBufferException
    //   328	346	458	java/io/IOException
    //   328	346	454	finally
    //   351	366	486	com/google/protobuf/InvalidProtocolBufferException
    //   351	366	458	java/io/IOException
    //   351	366	454	finally
    //   370	390	486	com/google/protobuf/InvalidProtocolBufferException
    //   370	390	458	java/io/IOException
    //   370	390	454	finally
    //   393	401	486	com/google/protobuf/InvalidProtocolBufferException
    //   393	401	458	java/io/IOException
    //   393	401	454	finally
    //   404	412	486	com/google/protobuf/InvalidProtocolBufferException
    //   404	412	458	java/io/IOException
    //   404	412	454	finally
    //   415	423	486	com/google/protobuf/InvalidProtocolBufferException
    //   415	423	458	java/io/IOException
    //   415	423	454	finally
    //   426	434	486	com/google/protobuf/InvalidProtocolBufferException
    //   426	434	458	java/io/IOException
    //   426	434	454	finally
    //   437	445	486	com/google/protobuf/InvalidProtocolBufferException
    //   437	445	458	java/io/IOException
    //   437	445	454	finally
    //   459	486	454	finally
    //   487	502	454	finally
  }
  
  public String getCollectionId() {
    return this.collectionId_;
  }
  
  public ByteString getCollectionIdBytes() {
    return ByteString.copyFromUtf8(this.collectionId_);
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
  
  public String getOrderBy() {
    return this.orderBy_;
  }
  
  public ByteString getOrderByBytes() {
    return ByteString.copyFromUtf8(this.orderBy_);
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
  
  public Timestamp getReadTime() {
    return (this.consistencySelectorCase_ == 10) ? (Timestamp)this.consistencySelector_ : Timestamp.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.parent_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getParent()); 
    int j = i;
    if (!this.collectionId_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getCollectionId()); 
    int k = this.pageSize_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(3, k); 
    j = i;
    if (!this.pageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getPageToken()); 
    i = j;
    if (!this.orderBy_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(6, getOrderBy()); 
    j = i;
    if (this.mask_ != null)
      j = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getMask()); 
    i = j;
    if (this.consistencySelectorCase_ == 8)
      i = j + CodedOutputStream.computeBytesSize(8, (ByteString)this.consistencySelector_); 
    j = i;
    if (this.consistencySelectorCase_ == 10)
      j = i + CodedOutputStream.computeMessageSize(10, (MessageLite)this.consistencySelector_); 
    boolean bool = this.showMissing_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(12, bool); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean getShowMissing() {
    return this.showMissing_;
  }
  
  public ByteString getTransaction() {
    return (this.consistencySelectorCase_ == 8) ? (ByteString)this.consistencySelector_ : ByteString.EMPTY;
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
    if (!this.parent_.isEmpty())
      paramCodedOutputStream.writeString(1, getParent()); 
    if (!this.collectionId_.isEmpty())
      paramCodedOutputStream.writeString(2, getCollectionId()); 
    int i = this.pageSize_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    if (!this.pageToken_.isEmpty())
      paramCodedOutputStream.writeString(4, getPageToken()); 
    if (!this.orderBy_.isEmpty())
      paramCodedOutputStream.writeString(6, getOrderBy()); 
    if (this.mask_ != null)
      paramCodedOutputStream.writeMessage(7, (MessageLite)getMask()); 
    if (this.consistencySelectorCase_ == 8)
      paramCodedOutputStream.writeBytes(8, (ByteString)this.consistencySelector_); 
    if (this.consistencySelectorCase_ == 10)
      paramCodedOutputStream.writeMessage(10, (MessageLite)this.consistencySelector_); 
    boolean bool = this.showMissing_;
    if (bool)
      paramCodedOutputStream.writeBool(12, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
    private Builder() {
      super(ListDocumentsRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCollectionId() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearCollectionId();
      return this;
    }
    
    public Builder clearConsistencySelector() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearConsistencySelector();
      return this;
    }
    
    public Builder clearMask() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearMask();
      return this;
    }
    
    public Builder clearOrderBy() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearOrderBy();
      return this;
    }
    
    public Builder clearPageSize() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearPageSize();
      return this;
    }
    
    public Builder clearPageToken() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearPageToken();
      return this;
    }
    
    public Builder clearParent() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearParent();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearShowMissing() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearShowMissing();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).clearTransaction();
      return this;
    }
    
    public String getCollectionId() {
      return ((ListDocumentsRequest)this.instance).getCollectionId();
    }
    
    public ByteString getCollectionIdBytes() {
      return ((ListDocumentsRequest)this.instance).getCollectionIdBytes();
    }
    
    public ListDocumentsRequest.ConsistencySelectorCase getConsistencySelectorCase() {
      return ((ListDocumentsRequest)this.instance).getConsistencySelectorCase();
    }
    
    public DocumentMask getMask() {
      return ((ListDocumentsRequest)this.instance).getMask();
    }
    
    public String getOrderBy() {
      return ((ListDocumentsRequest)this.instance).getOrderBy();
    }
    
    public ByteString getOrderByBytes() {
      return ((ListDocumentsRequest)this.instance).getOrderByBytes();
    }
    
    public int getPageSize() {
      return ((ListDocumentsRequest)this.instance).getPageSize();
    }
    
    public String getPageToken() {
      return ((ListDocumentsRequest)this.instance).getPageToken();
    }
    
    public ByteString getPageTokenBytes() {
      return ((ListDocumentsRequest)this.instance).getPageTokenBytes();
    }
    
    public String getParent() {
      return ((ListDocumentsRequest)this.instance).getParent();
    }
    
    public ByteString getParentBytes() {
      return ((ListDocumentsRequest)this.instance).getParentBytes();
    }
    
    public Timestamp getReadTime() {
      return ((ListDocumentsRequest)this.instance).getReadTime();
    }
    
    public boolean getShowMissing() {
      return ((ListDocumentsRequest)this.instance).getShowMissing();
    }
    
    public ByteString getTransaction() {
      return ((ListDocumentsRequest)this.instance).getTransaction();
    }
    
    public boolean hasMask() {
      return ((ListDocumentsRequest)this.instance).hasMask();
    }
    
    public Builder mergeMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).mergeMask(param1DocumentMask);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setCollectionId(String param1String) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setCollectionId(param1String);
      return this;
    }
    
    public Builder setCollectionIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setCollectionIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setMask(param1Builder);
      return this;
    }
    
    public Builder setMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setMask(param1DocumentMask);
      return this;
    }
    
    public Builder setOrderBy(String param1String) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setOrderBy(param1String);
      return this;
    }
    
    public Builder setOrderByBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setOrderByBytes(param1ByteString);
      return this;
    }
    
    public Builder setPageSize(int param1Int) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setPageSize(param1Int);
      return this;
    }
    
    public Builder setPageToken(String param1String) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setPageToken(param1String);
      return this;
    }
    
    public Builder setPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setPageTokenBytes(param1ByteString);
      return this;
    }
    
    public Builder setParent(String param1String) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setParent(param1String);
      return this;
    }
    
    public Builder setParentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setParentBytes(param1ByteString);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setShowMissing(boolean param1Boolean) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setShowMissing(param1Boolean);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsRequest)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
  
  public enum ConsistencySelectorCase implements Internal.EnumLite {
    CONSISTENCYSELECTOR_NOT_SET,
    READ_TIME,
    TRANSACTION(8);
    
    private final int value;
    
    static {
      CONSISTENCYSELECTOR_NOT_SET = new ConsistencySelectorCase("CONSISTENCYSELECTOR_NOT_SET", 2, 0);
      $VALUES = new ConsistencySelectorCase[] { TRANSACTION, READ_TIME, CONSISTENCYSELECTOR_NOT_SET };
    }
    
    ConsistencySelectorCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConsistencySelectorCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 8) ? ((param1Int != 10) ? null : READ_TIME) : TRANSACTION) : CONSISTENCYSELECTOR_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListDocumentsRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */