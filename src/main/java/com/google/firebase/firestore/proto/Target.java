package com.google.firebase.firestore.proto;

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

public final class Target extends GeneratedMessageLite<Target, Target.Builder> implements TargetOrBuilder {
  private static final Target DEFAULT_INSTANCE = new Target();
  
  public static final int DOCUMENTS_FIELD_NUMBER = 6;
  
  public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
  
  public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
  
  private static volatile Parser<Target> PARSER;
  
  public static final int QUERY_FIELD_NUMBER = 5;
  
  public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
  
  public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
  
  public static final int TARGET_ID_FIELD_NUMBER = 1;
  
  private Timestamp lastLimboFreeSnapshotVersion_;
  
  private long lastListenSequenceNumber_;
  
  private ByteString resumeToken_ = ByteString.EMPTY;
  
  private Timestamp snapshotVersion_;
  
  private int targetId_;
  
  private int targetTypeCase_ = 0;
  
  private Object targetType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDocuments() {
    if (this.targetTypeCase_ == 6) {
      this.targetTypeCase_ = 0;
      this.targetType_ = null;
    } 
  }
  
  private void clearLastLimboFreeSnapshotVersion() {
    this.lastLimboFreeSnapshotVersion_ = null;
  }
  
  private void clearLastListenSequenceNumber() {
    this.lastListenSequenceNumber_ = 0L;
  }
  
  private void clearQuery() {
    if (this.targetTypeCase_ == 5) {
      this.targetTypeCase_ = 0;
      this.targetType_ = null;
    } 
  }
  
  private void clearResumeToken() {
    this.resumeToken_ = getDefaultInstance().getResumeToken();
  }
  
  private void clearSnapshotVersion() {
    this.snapshotVersion_ = null;
  }
  
  private void clearTargetId() {
    this.targetId_ = 0;
  }
  
  private void clearTargetType() {
    this.targetTypeCase_ = 0;
    this.targetType_ = null;
  }
  
  public static Target getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeDocuments(com.google.firestore.v1.Target.DocumentsTarget paramDocumentsTarget) {
    if (this.targetTypeCase_ == 6 && this.targetType_ != com.google.firestore.v1.Target.DocumentsTarget.getDefaultInstance()) {
      this.targetType_ = ((com.google.firestore.v1.Target.DocumentsTarget.Builder)com.google.firestore.v1.Target.DocumentsTarget.newBuilder((com.google.firestore.v1.Target.DocumentsTarget)this.targetType_).mergeFrom((GeneratedMessageLite)paramDocumentsTarget)).buildPartial();
    } else {
      this.targetType_ = paramDocumentsTarget;
    } 
    this.targetTypeCase_ = 6;
  }
  
  private void mergeLastLimboFreeSnapshotVersion(Timestamp paramTimestamp) {
    Timestamp timestamp = this.lastLimboFreeSnapshotVersion_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.lastLimboFreeSnapshotVersion_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.lastLimboFreeSnapshotVersion_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.lastLimboFreeSnapshotVersion_ = paramTimestamp;
    } 
  }
  
  private void mergeQuery(com.google.firestore.v1.Target.QueryTarget paramQueryTarget) {
    if (this.targetTypeCase_ == 5 && this.targetType_ != com.google.firestore.v1.Target.QueryTarget.getDefaultInstance()) {
      this.targetType_ = ((com.google.firestore.v1.Target.QueryTarget.Builder)com.google.firestore.v1.Target.QueryTarget.newBuilder((com.google.firestore.v1.Target.QueryTarget)this.targetType_).mergeFrom((GeneratedMessageLite)paramQueryTarget)).buildPartial();
    } else {
      this.targetType_ = paramQueryTarget;
    } 
    this.targetTypeCase_ = 5;
  }
  
  private void mergeSnapshotVersion(Timestamp paramTimestamp) {
    Timestamp timestamp = this.snapshotVersion_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.snapshotVersion_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.snapshotVersion_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.snapshotVersion_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Target paramTarget) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTarget);
  }
  
  public static Target parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Target)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Target parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Target)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Target parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Target parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Target parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Target parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Target parseFrom(InputStream paramInputStream) throws IOException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Target parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Target parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Target parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Target)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Target> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDocuments(com.google.firestore.v1.Target.DocumentsTarget.Builder paramBuilder) {
    this.targetType_ = paramBuilder.build();
    this.targetTypeCase_ = 6;
  }
  
  private void setDocuments(com.google.firestore.v1.Target.DocumentsTarget paramDocumentsTarget) {
    if (paramDocumentsTarget != null) {
      this.targetType_ = paramDocumentsTarget;
      this.targetTypeCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLastLimboFreeSnapshotVersion(Timestamp.Builder paramBuilder) {
    this.lastLimboFreeSnapshotVersion_ = (Timestamp)paramBuilder.build();
  }
  
  private void setLastLimboFreeSnapshotVersion(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.lastLimboFreeSnapshotVersion_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLastListenSequenceNumber(long paramLong) {
    this.lastListenSequenceNumber_ = paramLong;
  }
  
  private void setQuery(com.google.firestore.v1.Target.QueryTarget.Builder paramBuilder) {
    this.targetType_ = paramBuilder.build();
    this.targetTypeCase_ = 5;
  }
  
  private void setQuery(com.google.firestore.v1.Target.QueryTarget paramQueryTarget) {
    if (paramQueryTarget != null) {
      this.targetType_ = paramQueryTarget;
      this.targetTypeCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResumeToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.resumeToken_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSnapshotVersion(Timestamp.Builder paramBuilder) {
    this.snapshotVersion_ = (Timestamp)paramBuilder.build();
  }
  
  private void setSnapshotVersion(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.snapshotVersion_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetId(int paramInt) {
    this.targetId_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/Target$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 988, 2 -> 984, 3 -> 982, 4 -> 973, 5 -> 580, 6 -> 126, 7 -> 576, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firebase/firestore/proto/Target.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firebase/firestore/proto/Target
    //   88: monitorenter
    //   89: getstatic com/google/firebase/firestore/proto/Target.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firebase/firestore/proto/Target.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/Target;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firebase/firestore/proto/Target.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firebase/firestore/proto/Target
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firebase/firestore/proto/Target
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firebase/firestore/proto/Target.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 576
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 520
    //   152: iload #4
    //   154: bipush #8
    //   156: if_icmpeq -> 509
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 444
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 433
    //   173: iload #4
    //   175: bipush #32
    //   177: if_icmpeq -> 422
    //   180: iload #4
    //   182: bipush #42
    //   184: if_icmpeq -> 351
    //   187: iload #4
    //   189: bipush #50
    //   191: if_icmpeq -> 278
    //   194: iload #4
    //   196: bipush #58
    //   198: if_icmpeq -> 213
    //   201: aload_2
    //   202: iload #4
    //   204: invokevirtual skipField : (I)Z
    //   207: ifne -> 136
    //   210: goto -> 520
    //   213: aload_0
    //   214: getfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   217: ifnull -> 234
    //   220: aload_0
    //   221: getfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   224: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   227: checkcast com/google/protobuf/Timestamp$Builder
    //   230: astore_1
    //   231: goto -> 236
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_0
    //   237: aload_2
    //   238: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   241: aload_3
    //   242: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   245: checkcast com/google/protobuf/Timestamp
    //   248: putfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   251: aload_1
    //   252: ifnull -> 136
    //   255: aload_1
    //   256: aload_0
    //   257: getfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   260: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   263: pop
    //   264: aload_0
    //   265: aload_1
    //   266: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   269: checkcast com/google/protobuf/Timestamp
    //   272: putfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   275: goto -> 136
    //   278: aload_0
    //   279: getfield targetTypeCase_ : I
    //   282: bipush #6
    //   284: if_icmpne -> 304
    //   287: aload_0
    //   288: getfield targetType_ : Ljava/lang/Object;
    //   291: checkcast com/google/firestore/v1/Target$DocumentsTarget
    //   294: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   297: checkcast com/google/firestore/v1/Target$DocumentsTarget$Builder
    //   300: astore_1
    //   301: goto -> 306
    //   304: aconst_null
    //   305: astore_1
    //   306: aload_0
    //   307: aload_2
    //   308: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   311: aload_3
    //   312: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   315: putfield targetType_ : Ljava/lang/Object;
    //   318: aload_1
    //   319: ifnull -> 342
    //   322: aload_1
    //   323: aload_0
    //   324: getfield targetType_ : Ljava/lang/Object;
    //   327: checkcast com/google/firestore/v1/Target$DocumentsTarget
    //   330: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   333: pop
    //   334: aload_0
    //   335: aload_1
    //   336: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   339: putfield targetType_ : Ljava/lang/Object;
    //   342: aload_0
    //   343: bipush #6
    //   345: putfield targetTypeCase_ : I
    //   348: goto -> 136
    //   351: aload_0
    //   352: getfield targetTypeCase_ : I
    //   355: iconst_5
    //   356: if_icmpne -> 376
    //   359: aload_0
    //   360: getfield targetType_ : Ljava/lang/Object;
    //   363: checkcast com/google/firestore/v1/Target$QueryTarget
    //   366: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   369: checkcast com/google/firestore/v1/Target$QueryTarget$Builder
    //   372: astore_1
    //   373: goto -> 378
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_0
    //   379: aload_2
    //   380: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   383: aload_3
    //   384: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   387: putfield targetType_ : Ljava/lang/Object;
    //   390: aload_1
    //   391: ifnull -> 414
    //   394: aload_1
    //   395: aload_0
    //   396: getfield targetType_ : Ljava/lang/Object;
    //   399: checkcast com/google/firestore/v1/Target$QueryTarget
    //   402: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   405: pop
    //   406: aload_0
    //   407: aload_1
    //   408: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   411: putfield targetType_ : Ljava/lang/Object;
    //   414: aload_0
    //   415: iconst_5
    //   416: putfield targetTypeCase_ : I
    //   419: goto -> 136
    //   422: aload_0
    //   423: aload_2
    //   424: invokevirtual readInt64 : ()J
    //   427: putfield lastListenSequenceNumber_ : J
    //   430: goto -> 136
    //   433: aload_0
    //   434: aload_2
    //   435: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   438: putfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   441: goto -> 136
    //   444: aload_0
    //   445: getfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   448: ifnull -> 465
    //   451: aload_0
    //   452: getfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   455: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   458: checkcast com/google/protobuf/Timestamp$Builder
    //   461: astore_1
    //   462: goto -> 467
    //   465: aconst_null
    //   466: astore_1
    //   467: aload_0
    //   468: aload_2
    //   469: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   472: aload_3
    //   473: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   476: checkcast com/google/protobuf/Timestamp
    //   479: putfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   482: aload_1
    //   483: ifnull -> 136
    //   486: aload_1
    //   487: aload_0
    //   488: getfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   491: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   494: pop
    //   495: aload_0
    //   496: aload_1
    //   497: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   500: checkcast com/google/protobuf/Timestamp
    //   503: putfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   506: goto -> 136
    //   509: aload_0
    //   510: aload_2
    //   511: invokevirtual readInt32 : ()I
    //   514: putfield targetId_ : I
    //   517: goto -> 136
    //   520: iconst_1
    //   521: istore #8
    //   523: goto -> 136
    //   526: astore_1
    //   527: goto -> 574
    //   530: astore_1
    //   531: new java/lang/RuntimeException
    //   534: astore_3
    //   535: new com/google/protobuf/InvalidProtocolBufferException
    //   538: astore_2
    //   539: aload_2
    //   540: aload_1
    //   541: invokevirtual getMessage : ()Ljava/lang/String;
    //   544: invokespecial <init> : (Ljava/lang/String;)V
    //   547: aload_3
    //   548: aload_2
    //   549: aload_0
    //   550: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   553: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   556: aload_3
    //   557: athrow
    //   558: astore_1
    //   559: new java/lang/RuntimeException
    //   562: astore_2
    //   563: aload_2
    //   564: aload_1
    //   565: aload_0
    //   566: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   569: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   572: aload_2
    //   573: athrow
    //   574: aload_1
    //   575: athrow
    //   576: getstatic com/google/firebase/firestore/proto/Target.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/Target;
    //   579: areturn
    //   580: aload_2
    //   581: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   584: astore_1
    //   585: aload_3
    //   586: checkcast com/google/firebase/firestore/proto/Target
    //   589: astore_3
    //   590: aload_0
    //   591: getfield targetId_ : I
    //   594: ifeq -> 603
    //   597: iconst_1
    //   598: istore #9
    //   600: goto -> 606
    //   603: iconst_0
    //   604: istore #9
    //   606: aload_0
    //   607: getfield targetId_ : I
    //   610: istore #8
    //   612: aload_3
    //   613: getfield targetId_ : I
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
    //   636: aload_3
    //   637: getfield targetId_ : I
    //   640: invokeinterface visitInt : (ZIZI)I
    //   645: putfield targetId_ : I
    //   648: aload_0
    //   649: aload_1
    //   650: aload_0
    //   651: getfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   654: aload_3
    //   655: getfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   658: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   663: checkcast com/google/protobuf/Timestamp
    //   666: putfield snapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   669: aload_0
    //   670: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   673: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   676: if_acmpeq -> 685
    //   679: iconst_1
    //   680: istore #9
    //   682: goto -> 688
    //   685: iconst_0
    //   686: istore #9
    //   688: aload_0
    //   689: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   692: astore_2
    //   693: aload_3
    //   694: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   697: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   700: if_acmpeq -> 709
    //   703: iconst_1
    //   704: istore #10
    //   706: goto -> 712
    //   709: iconst_0
    //   710: istore #10
    //   712: aload_0
    //   713: aload_1
    //   714: iload #9
    //   716: aload_2
    //   717: iload #10
    //   719: aload_3
    //   720: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   723: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   728: putfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   731: aload_0
    //   732: getfield lastListenSequenceNumber_ : J
    //   735: lconst_0
    //   736: lcmp
    //   737: ifeq -> 746
    //   740: iconst_1
    //   741: istore #9
    //   743: goto -> 749
    //   746: iconst_0
    //   747: istore #9
    //   749: aload_0
    //   750: getfield lastListenSequenceNumber_ : J
    //   753: lstore #11
    //   755: aload_3
    //   756: getfield lastListenSequenceNumber_ : J
    //   759: lconst_0
    //   760: lcmp
    //   761: ifeq -> 770
    //   764: iconst_1
    //   765: istore #10
    //   767: goto -> 773
    //   770: iconst_0
    //   771: istore #10
    //   773: aload_0
    //   774: aload_1
    //   775: iload #9
    //   777: lload #11
    //   779: iload #10
    //   781: aload_3
    //   782: getfield lastListenSequenceNumber_ : J
    //   785: invokeinterface visitLong : (ZJZJ)J
    //   790: putfield lastListenSequenceNumber_ : J
    //   793: aload_0
    //   794: aload_1
    //   795: aload_0
    //   796: getfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   799: aload_3
    //   800: getfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   803: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   808: checkcast com/google/protobuf/Timestamp
    //   811: putfield lastLimboFreeSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   814: getstatic com/google/firebase/firestore/proto/Target$1.$SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase : [I
    //   817: aload_3
    //   818: invokevirtual getTargetTypeCase : ()Lcom/google/firebase/firestore/proto/Target$TargetTypeCase;
    //   821: invokevirtual ordinal : ()I
    //   824: iaload
    //   825: istore #8
    //   827: iload #8
    //   829: iconst_1
    //   830: if_icmpeq -> 912
    //   833: iload #8
    //   835: iconst_2
    //   836: if_icmpeq -> 873
    //   839: iload #8
    //   841: iconst_3
    //   842: if_icmpeq -> 848
    //   845: goto -> 947
    //   848: iload #5
    //   850: istore #9
    //   852: aload_0
    //   853: getfield targetTypeCase_ : I
    //   856: ifeq -> 862
    //   859: iconst_1
    //   860: istore #9
    //   862: aload_1
    //   863: iload #9
    //   865: invokeinterface visitOneofNotSet : (Z)V
    //   870: goto -> 947
    //   873: iload #6
    //   875: istore #9
    //   877: aload_0
    //   878: getfield targetTypeCase_ : I
    //   881: bipush #6
    //   883: if_icmpne -> 889
    //   886: iconst_1
    //   887: istore #9
    //   889: aload_0
    //   890: aload_1
    //   891: iload #9
    //   893: aload_0
    //   894: getfield targetType_ : Ljava/lang/Object;
    //   897: aload_3
    //   898: getfield targetType_ : Ljava/lang/Object;
    //   901: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   906: putfield targetType_ : Ljava/lang/Object;
    //   909: goto -> 947
    //   912: iload #7
    //   914: istore #9
    //   916: aload_0
    //   917: getfield targetTypeCase_ : I
    //   920: iconst_5
    //   921: if_icmpne -> 927
    //   924: iconst_1
    //   925: istore #9
    //   927: aload_0
    //   928: aload_1
    //   929: iload #9
    //   931: aload_0
    //   932: getfield targetType_ : Ljava/lang/Object;
    //   935: aload_3
    //   936: getfield targetType_ : Ljava/lang/Object;
    //   939: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   944: putfield targetType_ : Ljava/lang/Object;
    //   947: aload_1
    //   948: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   951: if_acmpne -> 971
    //   954: aload_3
    //   955: getfield targetTypeCase_ : I
    //   958: istore #8
    //   960: iload #8
    //   962: ifeq -> 971
    //   965: aload_0
    //   966: iload #8
    //   968: putfield targetTypeCase_ : I
    //   971: aload_0
    //   972: areturn
    //   973: new com/google/firebase/firestore/proto/Target$Builder
    //   976: dup
    //   977: aconst_null
    //   978: invokespecial <init> : (Lcom/google/firebase/firestore/proto/Target$1;)V
    //   981: areturn
    //   982: aconst_null
    //   983: areturn
    //   984: getstatic com/google/firebase/firestore/proto/Target.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/Target;
    //   987: areturn
    //   988: new com/google/firebase/firestore/proto/Target
    //   991: dup
    //   992: invokespecial <init> : ()V
    //   995: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	558	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	530	java/io/IOException
    //   141	147	526	finally
    //   201	210	558	com/google/protobuf/InvalidProtocolBufferException
    //   201	210	530	java/io/IOException
    //   201	210	526	finally
    //   213	231	558	com/google/protobuf/InvalidProtocolBufferException
    //   213	231	530	java/io/IOException
    //   213	231	526	finally
    //   236	251	558	com/google/protobuf/InvalidProtocolBufferException
    //   236	251	530	java/io/IOException
    //   236	251	526	finally
    //   255	275	558	com/google/protobuf/InvalidProtocolBufferException
    //   255	275	530	java/io/IOException
    //   255	275	526	finally
    //   278	301	558	com/google/protobuf/InvalidProtocolBufferException
    //   278	301	530	java/io/IOException
    //   278	301	526	finally
    //   306	318	558	com/google/protobuf/InvalidProtocolBufferException
    //   306	318	530	java/io/IOException
    //   306	318	526	finally
    //   322	342	558	com/google/protobuf/InvalidProtocolBufferException
    //   322	342	530	java/io/IOException
    //   322	342	526	finally
    //   342	348	558	com/google/protobuf/InvalidProtocolBufferException
    //   342	348	530	java/io/IOException
    //   342	348	526	finally
    //   351	373	558	com/google/protobuf/InvalidProtocolBufferException
    //   351	373	530	java/io/IOException
    //   351	373	526	finally
    //   378	390	558	com/google/protobuf/InvalidProtocolBufferException
    //   378	390	530	java/io/IOException
    //   378	390	526	finally
    //   394	414	558	com/google/protobuf/InvalidProtocolBufferException
    //   394	414	530	java/io/IOException
    //   394	414	526	finally
    //   414	419	558	com/google/protobuf/InvalidProtocolBufferException
    //   414	419	530	java/io/IOException
    //   414	419	526	finally
    //   422	430	558	com/google/protobuf/InvalidProtocolBufferException
    //   422	430	530	java/io/IOException
    //   422	430	526	finally
    //   433	441	558	com/google/protobuf/InvalidProtocolBufferException
    //   433	441	530	java/io/IOException
    //   433	441	526	finally
    //   444	462	558	com/google/protobuf/InvalidProtocolBufferException
    //   444	462	530	java/io/IOException
    //   444	462	526	finally
    //   467	482	558	com/google/protobuf/InvalidProtocolBufferException
    //   467	482	530	java/io/IOException
    //   467	482	526	finally
    //   486	506	558	com/google/protobuf/InvalidProtocolBufferException
    //   486	506	530	java/io/IOException
    //   486	506	526	finally
    //   509	517	558	com/google/protobuf/InvalidProtocolBufferException
    //   509	517	530	java/io/IOException
    //   509	517	526	finally
    //   531	558	526	finally
    //   559	574	526	finally
  }
  
  public com.google.firestore.v1.Target.DocumentsTarget getDocuments() {
    return (this.targetTypeCase_ == 6) ? (com.google.firestore.v1.Target.DocumentsTarget)this.targetType_ : com.google.firestore.v1.Target.DocumentsTarget.getDefaultInstance();
  }
  
  public Timestamp getLastLimboFreeSnapshotVersion() {
    Timestamp timestamp1 = this.lastLimboFreeSnapshotVersion_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public long getLastListenSequenceNumber() {
    return this.lastListenSequenceNumber_;
  }
  
  public com.google.firestore.v1.Target.QueryTarget getQuery() {
    return (this.targetTypeCase_ == 5) ? (com.google.firestore.v1.Target.QueryTarget)this.targetType_ : com.google.firestore.v1.Target.QueryTarget.getDefaultInstance();
  }
  
  public ByteString getResumeToken() {
    return this.resumeToken_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.targetId_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    j = i;
    if (this.snapshotVersion_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getSnapshotVersion()); 
    i = j;
    if (!this.resumeToken_.isEmpty())
      i = j + CodedOutputStream.computeBytesSize(3, this.resumeToken_); 
    long l = this.lastListenSequenceNumber_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(4, l); 
    i = j;
    if (this.targetTypeCase_ == 5)
      i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)this.targetType_); 
    j = i;
    if (this.targetTypeCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.targetType_); 
    i = j;
    if (this.lastLimboFreeSnapshotVersion_ != null)
      i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)getLastLimboFreeSnapshotVersion()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Timestamp getSnapshotVersion() {
    Timestamp timestamp1 = this.snapshotVersion_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getTargetId() {
    return this.targetId_;
  }
  
  public TargetTypeCase getTargetTypeCase() {
    return TargetTypeCase.forNumber(this.targetTypeCase_);
  }
  
  public boolean hasLastLimboFreeSnapshotVersion() {
    boolean bool;
    if (this.lastLimboFreeSnapshotVersion_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasSnapshotVersion() {
    boolean bool;
    if (this.snapshotVersion_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.targetId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (this.snapshotVersion_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getSnapshotVersion()); 
    if (!this.resumeToken_.isEmpty())
      paramCodedOutputStream.writeBytes(3, this.resumeToken_); 
    long l = this.lastListenSequenceNumber_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(4, l); 
    if (this.targetTypeCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.targetType_); 
    if (this.targetTypeCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.targetType_); 
    if (this.lastLimboFreeSnapshotVersion_ != null)
      paramCodedOutputStream.writeMessage(7, (MessageLite)getLastLimboFreeSnapshotVersion()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
    private Builder() {
      super(Target.DEFAULT_INSTANCE);
    }
    
    public Builder clearDocuments() {
      copyOnWrite();
      ((Target)this.instance).clearDocuments();
      return this;
    }
    
    public Builder clearLastLimboFreeSnapshotVersion() {
      copyOnWrite();
      ((Target)this.instance).clearLastLimboFreeSnapshotVersion();
      return this;
    }
    
    public Builder clearLastListenSequenceNumber() {
      copyOnWrite();
      ((Target)this.instance).clearLastListenSequenceNumber();
      return this;
    }
    
    public Builder clearQuery() {
      copyOnWrite();
      ((Target)this.instance).clearQuery();
      return this;
    }
    
    public Builder clearResumeToken() {
      copyOnWrite();
      ((Target)this.instance).clearResumeToken();
      return this;
    }
    
    public Builder clearSnapshotVersion() {
      copyOnWrite();
      ((Target)this.instance).clearSnapshotVersion();
      return this;
    }
    
    public Builder clearTargetId() {
      copyOnWrite();
      ((Target)this.instance).clearTargetId();
      return this;
    }
    
    public Builder clearTargetType() {
      copyOnWrite();
      ((Target)this.instance).clearTargetType();
      return this;
    }
    
    public com.google.firestore.v1.Target.DocumentsTarget getDocuments() {
      return ((Target)this.instance).getDocuments();
    }
    
    public Timestamp getLastLimboFreeSnapshotVersion() {
      return ((Target)this.instance).getLastLimboFreeSnapshotVersion();
    }
    
    public long getLastListenSequenceNumber() {
      return ((Target)this.instance).getLastListenSequenceNumber();
    }
    
    public com.google.firestore.v1.Target.QueryTarget getQuery() {
      return ((Target)this.instance).getQuery();
    }
    
    public ByteString getResumeToken() {
      return ((Target)this.instance).getResumeToken();
    }
    
    public Timestamp getSnapshotVersion() {
      return ((Target)this.instance).getSnapshotVersion();
    }
    
    public int getTargetId() {
      return ((Target)this.instance).getTargetId();
    }
    
    public Target.TargetTypeCase getTargetTypeCase() {
      return ((Target)this.instance).getTargetTypeCase();
    }
    
    public boolean hasLastLimboFreeSnapshotVersion() {
      return ((Target)this.instance).hasLastLimboFreeSnapshotVersion();
    }
    
    public boolean hasSnapshotVersion() {
      return ((Target)this.instance).hasSnapshotVersion();
    }
    
    public Builder mergeDocuments(com.google.firestore.v1.Target.DocumentsTarget param1DocumentsTarget) {
      copyOnWrite();
      ((Target)this.instance).mergeDocuments(param1DocumentsTarget);
      return this;
    }
    
    public Builder mergeLastLimboFreeSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).mergeLastLimboFreeSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder mergeQuery(com.google.firestore.v1.Target.QueryTarget param1QueryTarget) {
      copyOnWrite();
      ((Target)this.instance).mergeQuery(param1QueryTarget);
      return this;
    }
    
    public Builder mergeSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).mergeSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder setDocuments(com.google.firestore.v1.Target.DocumentsTarget.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setDocuments(param1Builder);
      return this;
    }
    
    public Builder setDocuments(com.google.firestore.v1.Target.DocumentsTarget param1DocumentsTarget) {
      copyOnWrite();
      ((Target)this.instance).setDocuments(param1DocumentsTarget);
      return this;
    }
    
    public Builder setLastLimboFreeSnapshotVersion(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setLastLimboFreeSnapshotVersion(param1Builder);
      return this;
    }
    
    public Builder setLastLimboFreeSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).setLastLimboFreeSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder setLastListenSequenceNumber(long param1Long) {
      copyOnWrite();
      ((Target)this.instance).setLastListenSequenceNumber(param1Long);
      return this;
    }
    
    public Builder setQuery(com.google.firestore.v1.Target.QueryTarget.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setQuery(param1Builder);
      return this;
    }
    
    public Builder setQuery(com.google.firestore.v1.Target.QueryTarget param1QueryTarget) {
      copyOnWrite();
      ((Target)this.instance).setQuery(param1QueryTarget);
      return this;
    }
    
    public Builder setResumeToken(ByteString param1ByteString) {
      copyOnWrite();
      ((Target)this.instance).setResumeToken(param1ByteString);
      return this;
    }
    
    public Builder setSnapshotVersion(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setSnapshotVersion(param1Builder);
      return this;
    }
    
    public Builder setSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).setSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder setTargetId(int param1Int) {
      copyOnWrite();
      ((Target)this.instance).setTargetId(param1Int);
      return this;
    }
  }
  
  public enum TargetTypeCase implements Internal.EnumLite {
    DOCUMENTS,
    QUERY(5),
    TARGETTYPE_NOT_SET(5);
    
    private final int value;
    
    static {
      $VALUES = new TargetTypeCase[] { QUERY, DOCUMENTS, TARGETTYPE_NOT_SET };
    }
    
    TargetTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TargetTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 5) ? ((param1Int != 6) ? null : DOCUMENTS) : QUERY) : TARGETTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\Target.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */