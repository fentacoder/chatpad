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
import java.io.IOException;
import java.io.InputStream;

public final class ListenResponse extends GeneratedMessageLite<ListenResponse, ListenResponse.Builder> implements ListenResponseOrBuilder {
  private static final ListenResponse DEFAULT_INSTANCE = new ListenResponse();
  
  public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
  
  public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
  
  public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
  
  public static final int FILTER_FIELD_NUMBER = 5;
  
  private static volatile Parser<ListenResponse> PARSER;
  
  public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
  
  private int responseTypeCase_ = 0;
  
  private Object responseType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDocumentChange() {
    if (this.responseTypeCase_ == 3) {
      this.responseTypeCase_ = 0;
      this.responseType_ = null;
    } 
  }
  
  private void clearDocumentDelete() {
    if (this.responseTypeCase_ == 4) {
      this.responseTypeCase_ = 0;
      this.responseType_ = null;
    } 
  }
  
  private void clearDocumentRemove() {
    if (this.responseTypeCase_ == 6) {
      this.responseTypeCase_ = 0;
      this.responseType_ = null;
    } 
  }
  
  private void clearFilter() {
    if (this.responseTypeCase_ == 5) {
      this.responseTypeCase_ = 0;
      this.responseType_ = null;
    } 
  }
  
  private void clearResponseType() {
    this.responseTypeCase_ = 0;
    this.responseType_ = null;
  }
  
  private void clearTargetChange() {
    if (this.responseTypeCase_ == 2) {
      this.responseTypeCase_ = 0;
      this.responseType_ = null;
    } 
  }
  
  public static ListenResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeDocumentChange(DocumentChange paramDocumentChange) {
    if (this.responseTypeCase_ == 3 && this.responseType_ != DocumentChange.getDefaultInstance()) {
      this.responseType_ = ((DocumentChange.Builder)DocumentChange.newBuilder((DocumentChange)this.responseType_).mergeFrom(paramDocumentChange)).buildPartial();
    } else {
      this.responseType_ = paramDocumentChange;
    } 
    this.responseTypeCase_ = 3;
  }
  
  private void mergeDocumentDelete(DocumentDelete paramDocumentDelete) {
    if (this.responseTypeCase_ == 4 && this.responseType_ != DocumentDelete.getDefaultInstance()) {
      this.responseType_ = ((DocumentDelete.Builder)DocumentDelete.newBuilder((DocumentDelete)this.responseType_).mergeFrom(paramDocumentDelete)).buildPartial();
    } else {
      this.responseType_ = paramDocumentDelete;
    } 
    this.responseTypeCase_ = 4;
  }
  
  private void mergeDocumentRemove(DocumentRemove paramDocumentRemove) {
    if (this.responseTypeCase_ == 6 && this.responseType_ != DocumentRemove.getDefaultInstance()) {
      this.responseType_ = ((DocumentRemove.Builder)DocumentRemove.newBuilder((DocumentRemove)this.responseType_).mergeFrom(paramDocumentRemove)).buildPartial();
    } else {
      this.responseType_ = paramDocumentRemove;
    } 
    this.responseTypeCase_ = 6;
  }
  
  private void mergeFilter(ExistenceFilter paramExistenceFilter) {
    if (this.responseTypeCase_ == 5 && this.responseType_ != ExistenceFilter.getDefaultInstance()) {
      this.responseType_ = ((ExistenceFilter.Builder)ExistenceFilter.newBuilder((ExistenceFilter)this.responseType_).mergeFrom(paramExistenceFilter)).buildPartial();
    } else {
      this.responseType_ = paramExistenceFilter;
    } 
    this.responseTypeCase_ = 5;
  }
  
  private void mergeTargetChange(TargetChange paramTargetChange) {
    if (this.responseTypeCase_ == 2 && this.responseType_ != TargetChange.getDefaultInstance()) {
      this.responseType_ = ((TargetChange.Builder)TargetChange.newBuilder((TargetChange)this.responseType_).mergeFrom(paramTargetChange)).buildPartial();
    } else {
      this.responseType_ = paramTargetChange;
    } 
    this.responseTypeCase_ = 2;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListenResponse paramListenResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListenResponse);
  }
  
  public static ListenResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListenResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListenResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListenResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListenResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListenResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListenResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListenResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListenResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListenResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDocumentChange(DocumentChange.Builder paramBuilder) {
    this.responseType_ = paramBuilder.build();
    this.responseTypeCase_ = 3;
  }
  
  private void setDocumentChange(DocumentChange paramDocumentChange) {
    if (paramDocumentChange != null) {
      this.responseType_ = paramDocumentChange;
      this.responseTypeCase_ = 3;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentDelete(DocumentDelete.Builder paramBuilder) {
    this.responseType_ = paramBuilder.build();
    this.responseTypeCase_ = 4;
  }
  
  private void setDocumentDelete(DocumentDelete paramDocumentDelete) {
    if (paramDocumentDelete != null) {
      this.responseType_ = paramDocumentDelete;
      this.responseTypeCase_ = 4;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentRemove(DocumentRemove.Builder paramBuilder) {
    this.responseType_ = paramBuilder.build();
    this.responseTypeCase_ = 6;
  }
  
  private void setDocumentRemove(DocumentRemove paramDocumentRemove) {
    if (paramDocumentRemove != null) {
      this.responseType_ = paramDocumentRemove;
      this.responseTypeCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFilter(ExistenceFilter.Builder paramBuilder) {
    this.responseType_ = paramBuilder.build();
    this.responseTypeCase_ = 5;
  }
  
  private void setFilter(ExistenceFilter paramExistenceFilter) {
    if (paramExistenceFilter != null) {
      this.responseType_ = paramExistenceFilter;
      this.responseTypeCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetChange(TargetChange.Builder paramBuilder) {
    this.responseType_ = paramBuilder.build();
    this.responseTypeCase_ = 2;
  }
  
  private void setTargetChange(TargetChange paramTargetChange) {
    if (paramTargetChange != null) {
      this.responseType_ = paramTargetChange;
      this.responseTypeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ListenResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   25: iconst_0
    //   26: istore #10
    //   28: iconst_0
    //   29: istore #11
    //   31: iload #4
    //   33: tableswitch default -> 80, 1 -> 937, 2 -> 933, 3 -> 931, 4 -> 922, 5 -> 624, 6 -> 134, 7 -> 620, 8 -> 88
    //   80: new java/lang/UnsupportedOperationException
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: athrow
    //   88: getstatic com/google/firestore/v1/ListenResponse.PARSER : Lcom/google/protobuf/Parser;
    //   91: ifnonnull -> 130
    //   94: ldc com/google/firestore/v1/ListenResponse
    //   96: monitorenter
    //   97: getstatic com/google/firestore/v1/ListenResponse.PARSER : Lcom/google/protobuf/Parser;
    //   100: ifnonnull -> 118
    //   103: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   106: astore_1
    //   107: aload_1
    //   108: getstatic com/google/firestore/v1/ListenResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenResponse;
    //   111: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   114: aload_1
    //   115: putstatic com/google/firestore/v1/ListenResponse.PARSER : Lcom/google/protobuf/Parser;
    //   118: ldc com/google/firestore/v1/ListenResponse
    //   120: monitorexit
    //   121: goto -> 130
    //   124: astore_1
    //   125: ldc com/google/firestore/v1/ListenResponse
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: getstatic com/google/firestore/v1/ListenResponse.PARSER : Lcom/google/protobuf/Parser;
    //   133: areturn
    //   134: aload_2
    //   135: checkcast com/google/protobuf/CodedInputStream
    //   138: astore_2
    //   139: aload_3
    //   140: checkcast com/google/protobuf/ExtensionRegistryLite
    //   143: astore_3
    //   144: iload #11
    //   146: ifne -> 620
    //   149: aload_2
    //   150: invokevirtual readTag : ()I
    //   153: istore #4
    //   155: iload #4
    //   157: ifeq -> 564
    //   160: iload #4
    //   162: bipush #18
    //   164: if_icmpeq -> 493
    //   167: iload #4
    //   169: bipush #26
    //   171: if_icmpeq -> 422
    //   174: iload #4
    //   176: bipush #34
    //   178: if_icmpeq -> 351
    //   181: iload #4
    //   183: bipush #42
    //   185: if_icmpeq -> 280
    //   188: iload #4
    //   190: bipush #50
    //   192: if_icmpeq -> 207
    //   195: aload_2
    //   196: iload #4
    //   198: invokevirtual skipField : (I)Z
    //   201: ifne -> 144
    //   204: goto -> 564
    //   207: aload_0
    //   208: getfield responseTypeCase_ : I
    //   211: bipush #6
    //   213: if_icmpne -> 233
    //   216: aload_0
    //   217: getfield responseType_ : Ljava/lang/Object;
    //   220: checkcast com/google/firestore/v1/DocumentRemove
    //   223: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   226: checkcast com/google/firestore/v1/DocumentRemove$Builder
    //   229: astore_1
    //   230: goto -> 235
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_0
    //   236: aload_2
    //   237: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   240: aload_3
    //   241: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   244: putfield responseType_ : Ljava/lang/Object;
    //   247: aload_1
    //   248: ifnull -> 271
    //   251: aload_1
    //   252: aload_0
    //   253: getfield responseType_ : Ljava/lang/Object;
    //   256: checkcast com/google/firestore/v1/DocumentRemove
    //   259: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   268: putfield responseType_ : Ljava/lang/Object;
    //   271: aload_0
    //   272: bipush #6
    //   274: putfield responseTypeCase_ : I
    //   277: goto -> 144
    //   280: aload_0
    //   281: getfield responseTypeCase_ : I
    //   284: iconst_5
    //   285: if_icmpne -> 305
    //   288: aload_0
    //   289: getfield responseType_ : Ljava/lang/Object;
    //   292: checkcast com/google/firestore/v1/ExistenceFilter
    //   295: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   298: checkcast com/google/firestore/v1/ExistenceFilter$Builder
    //   301: astore_1
    //   302: goto -> 307
    //   305: aconst_null
    //   306: astore_1
    //   307: aload_0
    //   308: aload_2
    //   309: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   312: aload_3
    //   313: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   316: putfield responseType_ : Ljava/lang/Object;
    //   319: aload_1
    //   320: ifnull -> 343
    //   323: aload_1
    //   324: aload_0
    //   325: getfield responseType_ : Ljava/lang/Object;
    //   328: checkcast com/google/firestore/v1/ExistenceFilter
    //   331: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   334: pop
    //   335: aload_0
    //   336: aload_1
    //   337: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   340: putfield responseType_ : Ljava/lang/Object;
    //   343: aload_0
    //   344: iconst_5
    //   345: putfield responseTypeCase_ : I
    //   348: goto -> 144
    //   351: aload_0
    //   352: getfield responseTypeCase_ : I
    //   355: iconst_4
    //   356: if_icmpne -> 376
    //   359: aload_0
    //   360: getfield responseType_ : Ljava/lang/Object;
    //   363: checkcast com/google/firestore/v1/DocumentDelete
    //   366: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   369: checkcast com/google/firestore/v1/DocumentDelete$Builder
    //   372: astore_1
    //   373: goto -> 378
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_0
    //   379: aload_2
    //   380: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   383: aload_3
    //   384: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   387: putfield responseType_ : Ljava/lang/Object;
    //   390: aload_1
    //   391: ifnull -> 414
    //   394: aload_1
    //   395: aload_0
    //   396: getfield responseType_ : Ljava/lang/Object;
    //   399: checkcast com/google/firestore/v1/DocumentDelete
    //   402: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   405: pop
    //   406: aload_0
    //   407: aload_1
    //   408: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   411: putfield responseType_ : Ljava/lang/Object;
    //   414: aload_0
    //   415: iconst_4
    //   416: putfield responseTypeCase_ : I
    //   419: goto -> 144
    //   422: aload_0
    //   423: getfield responseTypeCase_ : I
    //   426: iconst_3
    //   427: if_icmpne -> 447
    //   430: aload_0
    //   431: getfield responseType_ : Ljava/lang/Object;
    //   434: checkcast com/google/firestore/v1/DocumentChange
    //   437: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   440: checkcast com/google/firestore/v1/DocumentChange$Builder
    //   443: astore_1
    //   444: goto -> 449
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_0
    //   450: aload_2
    //   451: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   454: aload_3
    //   455: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   458: putfield responseType_ : Ljava/lang/Object;
    //   461: aload_1
    //   462: ifnull -> 485
    //   465: aload_1
    //   466: aload_0
    //   467: getfield responseType_ : Ljava/lang/Object;
    //   470: checkcast com/google/firestore/v1/DocumentChange
    //   473: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   476: pop
    //   477: aload_0
    //   478: aload_1
    //   479: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   482: putfield responseType_ : Ljava/lang/Object;
    //   485: aload_0
    //   486: iconst_3
    //   487: putfield responseTypeCase_ : I
    //   490: goto -> 144
    //   493: aload_0
    //   494: getfield responseTypeCase_ : I
    //   497: iconst_2
    //   498: if_icmpne -> 518
    //   501: aload_0
    //   502: getfield responseType_ : Ljava/lang/Object;
    //   505: checkcast com/google/firestore/v1/TargetChange
    //   508: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   511: checkcast com/google/firestore/v1/TargetChange$Builder
    //   514: astore_1
    //   515: goto -> 520
    //   518: aconst_null
    //   519: astore_1
    //   520: aload_0
    //   521: aload_2
    //   522: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   525: aload_3
    //   526: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   529: putfield responseType_ : Ljava/lang/Object;
    //   532: aload_1
    //   533: ifnull -> 556
    //   536: aload_1
    //   537: aload_0
    //   538: getfield responseType_ : Ljava/lang/Object;
    //   541: checkcast com/google/firestore/v1/TargetChange
    //   544: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   547: pop
    //   548: aload_0
    //   549: aload_1
    //   550: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   553: putfield responseType_ : Ljava/lang/Object;
    //   556: aload_0
    //   557: iconst_2
    //   558: putfield responseTypeCase_ : I
    //   561: goto -> 144
    //   564: iconst_1
    //   565: istore #11
    //   567: goto -> 144
    //   570: astore_1
    //   571: goto -> 618
    //   574: astore_2
    //   575: new java/lang/RuntimeException
    //   578: astore_3
    //   579: new com/google/protobuf/InvalidProtocolBufferException
    //   582: astore_1
    //   583: aload_1
    //   584: aload_2
    //   585: invokevirtual getMessage : ()Ljava/lang/String;
    //   588: invokespecial <init> : (Ljava/lang/String;)V
    //   591: aload_3
    //   592: aload_1
    //   593: aload_0
    //   594: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   597: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   600: aload_3
    //   601: athrow
    //   602: astore_2
    //   603: new java/lang/RuntimeException
    //   606: astore_1
    //   607: aload_1
    //   608: aload_2
    //   609: aload_0
    //   610: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   613: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   616: aload_1
    //   617: athrow
    //   618: aload_1
    //   619: athrow
    //   620: getstatic com/google/firestore/v1/ListenResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenResponse;
    //   623: areturn
    //   624: aload_2
    //   625: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   628: astore_1
    //   629: aload_3
    //   630: checkcast com/google/firestore/v1/ListenResponse
    //   633: astore_2
    //   634: getstatic com/google/firestore/v1/ListenResponse$1.$SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase : [I
    //   637: aload_2
    //   638: invokevirtual getResponseTypeCase : ()Lcom/google/firestore/v1/ListenResponse$ResponseTypeCase;
    //   641: invokevirtual ordinal : ()I
    //   644: iaload
    //   645: tableswitch default -> 684, 1 -> 861, 2 -> 823, 3 -> 785, 4 -> 746, 5 -> 708, 6 -> 687
    //   684: goto -> 896
    //   687: aload_0
    //   688: getfield responseTypeCase_ : I
    //   691: ifeq -> 697
    //   694: iconst_1
    //   695: istore #5
    //   697: aload_1
    //   698: iload #5
    //   700: invokeinterface visitOneofNotSet : (Z)V
    //   705: goto -> 896
    //   708: iload #6
    //   710: istore #5
    //   712: aload_0
    //   713: getfield responseTypeCase_ : I
    //   716: iconst_5
    //   717: if_icmpne -> 723
    //   720: iconst_1
    //   721: istore #5
    //   723: aload_0
    //   724: aload_1
    //   725: iload #5
    //   727: aload_0
    //   728: getfield responseType_ : Ljava/lang/Object;
    //   731: aload_2
    //   732: getfield responseType_ : Ljava/lang/Object;
    //   735: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   740: putfield responseType_ : Ljava/lang/Object;
    //   743: goto -> 896
    //   746: iload #7
    //   748: istore #5
    //   750: aload_0
    //   751: getfield responseTypeCase_ : I
    //   754: bipush #6
    //   756: if_icmpne -> 762
    //   759: iconst_1
    //   760: istore #5
    //   762: aload_0
    //   763: aload_1
    //   764: iload #5
    //   766: aload_0
    //   767: getfield responseType_ : Ljava/lang/Object;
    //   770: aload_2
    //   771: getfield responseType_ : Ljava/lang/Object;
    //   774: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   779: putfield responseType_ : Ljava/lang/Object;
    //   782: goto -> 896
    //   785: iload #8
    //   787: istore #5
    //   789: aload_0
    //   790: getfield responseTypeCase_ : I
    //   793: iconst_4
    //   794: if_icmpne -> 800
    //   797: iconst_1
    //   798: istore #5
    //   800: aload_0
    //   801: aload_1
    //   802: iload #5
    //   804: aload_0
    //   805: getfield responseType_ : Ljava/lang/Object;
    //   808: aload_2
    //   809: getfield responseType_ : Ljava/lang/Object;
    //   812: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   817: putfield responseType_ : Ljava/lang/Object;
    //   820: goto -> 896
    //   823: iload #9
    //   825: istore #5
    //   827: aload_0
    //   828: getfield responseTypeCase_ : I
    //   831: iconst_3
    //   832: if_icmpne -> 838
    //   835: iconst_1
    //   836: istore #5
    //   838: aload_0
    //   839: aload_1
    //   840: iload #5
    //   842: aload_0
    //   843: getfield responseType_ : Ljava/lang/Object;
    //   846: aload_2
    //   847: getfield responseType_ : Ljava/lang/Object;
    //   850: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   855: putfield responseType_ : Ljava/lang/Object;
    //   858: goto -> 896
    //   861: iload #10
    //   863: istore #5
    //   865: aload_0
    //   866: getfield responseTypeCase_ : I
    //   869: iconst_2
    //   870: if_icmpne -> 876
    //   873: iconst_1
    //   874: istore #5
    //   876: aload_0
    //   877: aload_1
    //   878: iload #5
    //   880: aload_0
    //   881: getfield responseType_ : Ljava/lang/Object;
    //   884: aload_2
    //   885: getfield responseType_ : Ljava/lang/Object;
    //   888: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   893: putfield responseType_ : Ljava/lang/Object;
    //   896: aload_1
    //   897: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   900: if_acmpne -> 920
    //   903: aload_2
    //   904: getfield responseTypeCase_ : I
    //   907: istore #11
    //   909: iload #11
    //   911: ifeq -> 920
    //   914: aload_0
    //   915: iload #11
    //   917: putfield responseTypeCase_ : I
    //   920: aload_0
    //   921: areturn
    //   922: new com/google/firestore/v1/ListenResponse$Builder
    //   925: dup
    //   926: aconst_null
    //   927: invokespecial <init> : (Lcom/google/firestore/v1/ListenResponse$1;)V
    //   930: areturn
    //   931: aconst_null
    //   932: areturn
    //   933: getstatic com/google/firestore/v1/ListenResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenResponse;
    //   936: areturn
    //   937: new com/google/firestore/v1/ListenResponse
    //   940: dup
    //   941: invokespecial <init> : ()V
    //   944: areturn
    // Exception table:
    //   from	to	target	type
    //   97	118	124	finally
    //   118	121	124	finally
    //   125	128	124	finally
    //   149	155	602	com/google/protobuf/InvalidProtocolBufferException
    //   149	155	574	java/io/IOException
    //   149	155	570	finally
    //   195	204	602	com/google/protobuf/InvalidProtocolBufferException
    //   195	204	574	java/io/IOException
    //   195	204	570	finally
    //   207	230	602	com/google/protobuf/InvalidProtocolBufferException
    //   207	230	574	java/io/IOException
    //   207	230	570	finally
    //   235	247	602	com/google/protobuf/InvalidProtocolBufferException
    //   235	247	574	java/io/IOException
    //   235	247	570	finally
    //   251	271	602	com/google/protobuf/InvalidProtocolBufferException
    //   251	271	574	java/io/IOException
    //   251	271	570	finally
    //   271	277	602	com/google/protobuf/InvalidProtocolBufferException
    //   271	277	574	java/io/IOException
    //   271	277	570	finally
    //   280	302	602	com/google/protobuf/InvalidProtocolBufferException
    //   280	302	574	java/io/IOException
    //   280	302	570	finally
    //   307	319	602	com/google/protobuf/InvalidProtocolBufferException
    //   307	319	574	java/io/IOException
    //   307	319	570	finally
    //   323	343	602	com/google/protobuf/InvalidProtocolBufferException
    //   323	343	574	java/io/IOException
    //   323	343	570	finally
    //   343	348	602	com/google/protobuf/InvalidProtocolBufferException
    //   343	348	574	java/io/IOException
    //   343	348	570	finally
    //   351	373	602	com/google/protobuf/InvalidProtocolBufferException
    //   351	373	574	java/io/IOException
    //   351	373	570	finally
    //   378	390	602	com/google/protobuf/InvalidProtocolBufferException
    //   378	390	574	java/io/IOException
    //   378	390	570	finally
    //   394	414	602	com/google/protobuf/InvalidProtocolBufferException
    //   394	414	574	java/io/IOException
    //   394	414	570	finally
    //   414	419	602	com/google/protobuf/InvalidProtocolBufferException
    //   414	419	574	java/io/IOException
    //   414	419	570	finally
    //   422	444	602	com/google/protobuf/InvalidProtocolBufferException
    //   422	444	574	java/io/IOException
    //   422	444	570	finally
    //   449	461	602	com/google/protobuf/InvalidProtocolBufferException
    //   449	461	574	java/io/IOException
    //   449	461	570	finally
    //   465	485	602	com/google/protobuf/InvalidProtocolBufferException
    //   465	485	574	java/io/IOException
    //   465	485	570	finally
    //   485	490	602	com/google/protobuf/InvalidProtocolBufferException
    //   485	490	574	java/io/IOException
    //   485	490	570	finally
    //   493	515	602	com/google/protobuf/InvalidProtocolBufferException
    //   493	515	574	java/io/IOException
    //   493	515	570	finally
    //   520	532	602	com/google/protobuf/InvalidProtocolBufferException
    //   520	532	574	java/io/IOException
    //   520	532	570	finally
    //   536	556	602	com/google/protobuf/InvalidProtocolBufferException
    //   536	556	574	java/io/IOException
    //   536	556	570	finally
    //   556	561	602	com/google/protobuf/InvalidProtocolBufferException
    //   556	561	574	java/io/IOException
    //   556	561	570	finally
    //   575	602	570	finally
    //   603	618	570	finally
  }
  
  public DocumentChange getDocumentChange() {
    return (this.responseTypeCase_ == 3) ? (DocumentChange)this.responseType_ : DocumentChange.getDefaultInstance();
  }
  
  public DocumentDelete getDocumentDelete() {
    return (this.responseTypeCase_ == 4) ? (DocumentDelete)this.responseType_ : DocumentDelete.getDefaultInstance();
  }
  
  public DocumentRemove getDocumentRemove() {
    return (this.responseTypeCase_ == 6) ? (DocumentRemove)this.responseType_ : DocumentRemove.getDefaultInstance();
  }
  
  public ExistenceFilter getFilter() {
    return (this.responseTypeCase_ == 5) ? (ExistenceFilter)this.responseType_ : ExistenceFilter.getDefaultInstance();
  }
  
  public ResponseTypeCase getResponseTypeCase() {
    return ResponseTypeCase.forNumber(this.responseTypeCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (this.responseTypeCase_ == 2)
      j = 0 + CodedOutputStream.computeMessageSize(2, (MessageLite)this.responseType_); 
    i = j;
    if (this.responseTypeCase_ == 3)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)this.responseType_); 
    j = i;
    if (this.responseTypeCase_ == 4)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)this.responseType_); 
    i = j;
    if (this.responseTypeCase_ == 5)
      i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)this.responseType_); 
    j = i;
    if (this.responseTypeCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.responseType_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public TargetChange getTargetChange() {
    return (this.responseTypeCase_ == 2) ? (TargetChange)this.responseType_ : TargetChange.getDefaultInstance();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.responseTypeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.responseType_); 
    if (this.responseTypeCase_ == 3)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.responseType_); 
    if (this.responseTypeCase_ == 4)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.responseType_); 
    if (this.responseTypeCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.responseType_); 
    if (this.responseTypeCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.responseType_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListenResponse, Builder> implements ListenResponseOrBuilder {
    private Builder() {
      super(ListenResponse.DEFAULT_INSTANCE);
    }
    
    public Builder clearDocumentChange() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearDocumentChange();
      return this;
    }
    
    public Builder clearDocumentDelete() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearDocumentDelete();
      return this;
    }
    
    public Builder clearDocumentRemove() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearDocumentRemove();
      return this;
    }
    
    public Builder clearFilter() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearFilter();
      return this;
    }
    
    public Builder clearResponseType() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearResponseType();
      return this;
    }
    
    public Builder clearTargetChange() {
      copyOnWrite();
      ((ListenResponse)this.instance).clearTargetChange();
      return this;
    }
    
    public DocumentChange getDocumentChange() {
      return ((ListenResponse)this.instance).getDocumentChange();
    }
    
    public DocumentDelete getDocumentDelete() {
      return ((ListenResponse)this.instance).getDocumentDelete();
    }
    
    public DocumentRemove getDocumentRemove() {
      return ((ListenResponse)this.instance).getDocumentRemove();
    }
    
    public ExistenceFilter getFilter() {
      return ((ListenResponse)this.instance).getFilter();
    }
    
    public ListenResponse.ResponseTypeCase getResponseTypeCase() {
      return ((ListenResponse)this.instance).getResponseTypeCase();
    }
    
    public TargetChange getTargetChange() {
      return ((ListenResponse)this.instance).getTargetChange();
    }
    
    public Builder mergeDocumentChange(DocumentChange param1DocumentChange) {
      copyOnWrite();
      ((ListenResponse)this.instance).mergeDocumentChange(param1DocumentChange);
      return this;
    }
    
    public Builder mergeDocumentDelete(DocumentDelete param1DocumentDelete) {
      copyOnWrite();
      ((ListenResponse)this.instance).mergeDocumentDelete(param1DocumentDelete);
      return this;
    }
    
    public Builder mergeDocumentRemove(DocumentRemove param1DocumentRemove) {
      copyOnWrite();
      ((ListenResponse)this.instance).mergeDocumentRemove(param1DocumentRemove);
      return this;
    }
    
    public Builder mergeFilter(ExistenceFilter param1ExistenceFilter) {
      copyOnWrite();
      ((ListenResponse)this.instance).mergeFilter(param1ExistenceFilter);
      return this;
    }
    
    public Builder mergeTargetChange(TargetChange param1TargetChange) {
      copyOnWrite();
      ((ListenResponse)this.instance).mergeTargetChange(param1TargetChange);
      return this;
    }
    
    public Builder setDocumentChange(DocumentChange.Builder param1Builder) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentChange(param1Builder);
      return this;
    }
    
    public Builder setDocumentChange(DocumentChange param1DocumentChange) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentChange(param1DocumentChange);
      return this;
    }
    
    public Builder setDocumentDelete(DocumentDelete.Builder param1Builder) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentDelete(param1Builder);
      return this;
    }
    
    public Builder setDocumentDelete(DocumentDelete param1DocumentDelete) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentDelete(param1DocumentDelete);
      return this;
    }
    
    public Builder setDocumentRemove(DocumentRemove.Builder param1Builder) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentRemove(param1Builder);
      return this;
    }
    
    public Builder setDocumentRemove(DocumentRemove param1DocumentRemove) {
      copyOnWrite();
      ((ListenResponse)this.instance).setDocumentRemove(param1DocumentRemove);
      return this;
    }
    
    public Builder setFilter(ExistenceFilter.Builder param1Builder) {
      copyOnWrite();
      ((ListenResponse)this.instance).setFilter(param1Builder);
      return this;
    }
    
    public Builder setFilter(ExistenceFilter param1ExistenceFilter) {
      copyOnWrite();
      ((ListenResponse)this.instance).setFilter(param1ExistenceFilter);
      return this;
    }
    
    public Builder setTargetChange(TargetChange.Builder param1Builder) {
      copyOnWrite();
      ((ListenResponse)this.instance).setTargetChange(param1Builder);
      return this;
    }
    
    public Builder setTargetChange(TargetChange param1TargetChange) {
      copyOnWrite();
      ((ListenResponse)this.instance).setTargetChange(param1TargetChange);
      return this;
    }
  }
  
  public enum ResponseTypeCase implements Internal.EnumLite {
    DOCUMENT_CHANGE,
    DOCUMENT_DELETE,
    DOCUMENT_REMOVE,
    FILTER,
    RESPONSETYPE_NOT_SET,
    TARGET_CHANGE(2);
    
    private final int value;
    
    static {
      $VALUES = new ResponseTypeCase[] { TARGET_CHANGE, DOCUMENT_CHANGE, DOCUMENT_DELETE, DOCUMENT_REMOVE, FILTER, RESPONSETYPE_NOT_SET };
    }
    
    ResponseTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResponseTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? ((param1Int != 6) ? null : DOCUMENT_REMOVE) : FILTER) : DOCUMENT_DELETE) : DOCUMENT_CHANGE) : TARGET_CHANGE) : RESPONSETYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListenResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */