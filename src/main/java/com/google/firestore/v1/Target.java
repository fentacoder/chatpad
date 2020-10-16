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
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Target extends GeneratedMessageLite<Target, Target.Builder> implements TargetOrBuilder {
  private static final Target DEFAULT_INSTANCE = new Target();
  
  public static final int DOCUMENTS_FIELD_NUMBER = 3;
  
  public static final int ONCE_FIELD_NUMBER = 6;
  
  private static volatile Parser<Target> PARSER;
  
  public static final int QUERY_FIELD_NUMBER = 2;
  
  public static final int READ_TIME_FIELD_NUMBER = 11;
  
  public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
  
  public static final int TARGET_ID_FIELD_NUMBER = 5;
  
  private boolean once_;
  
  private int resumeTypeCase_ = 0;
  
  private Object resumeType_;
  
  private int targetId_;
  
  private int targetTypeCase_ = 0;
  
  private Object targetType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDocuments() {
    if (this.targetTypeCase_ == 3) {
      this.targetTypeCase_ = 0;
      this.targetType_ = null;
    } 
  }
  
  private void clearOnce() {
    this.once_ = false;
  }
  
  private void clearQuery() {
    if (this.targetTypeCase_ == 2) {
      this.targetTypeCase_ = 0;
      this.targetType_ = null;
    } 
  }
  
  private void clearReadTime() {
    if (this.resumeTypeCase_ == 11) {
      this.resumeTypeCase_ = 0;
      this.resumeType_ = null;
    } 
  }
  
  private void clearResumeToken() {
    if (this.resumeTypeCase_ == 4) {
      this.resumeTypeCase_ = 0;
      this.resumeType_ = null;
    } 
  }
  
  private void clearResumeType() {
    this.resumeTypeCase_ = 0;
    this.resumeType_ = null;
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
  
  private void mergeDocuments(DocumentsTarget paramDocumentsTarget) {
    if (this.targetTypeCase_ == 3 && this.targetType_ != DocumentsTarget.getDefaultInstance()) {
      this.targetType_ = ((DocumentsTarget.Builder)DocumentsTarget.newBuilder((DocumentsTarget)this.targetType_).mergeFrom(paramDocumentsTarget)).buildPartial();
    } else {
      this.targetType_ = paramDocumentsTarget;
    } 
    this.targetTypeCase_ = 3;
  }
  
  private void mergeQuery(QueryTarget paramQueryTarget) {
    if (this.targetTypeCase_ == 2 && this.targetType_ != QueryTarget.getDefaultInstance()) {
      this.targetType_ = ((QueryTarget.Builder)QueryTarget.newBuilder((QueryTarget)this.targetType_).mergeFrom(paramQueryTarget)).buildPartial();
    } else {
      this.targetType_ = paramQueryTarget;
    } 
    this.targetTypeCase_ = 2;
  }
  
  private void mergeReadTime(Timestamp paramTimestamp) {
    if (this.resumeTypeCase_ == 11 && this.resumeType_ != Timestamp.getDefaultInstance()) {
      this.resumeType_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.resumeType_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.resumeType_ = paramTimestamp;
    } 
    this.resumeTypeCase_ = 11;
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
  
  private void setDocuments(DocumentsTarget.Builder paramBuilder) {
    this.targetType_ = paramBuilder.build();
    this.targetTypeCase_ = 3;
  }
  
  private void setDocuments(DocumentsTarget paramDocumentsTarget) {
    if (paramDocumentsTarget != null) {
      this.targetType_ = paramDocumentsTarget;
      this.targetTypeCase_ = 3;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOnce(boolean paramBoolean) {
    this.once_ = paramBoolean;
  }
  
  private void setQuery(QueryTarget.Builder paramBuilder) {
    this.targetType_ = paramBuilder.build();
    this.targetTypeCase_ = 2;
  }
  
  private void setQuery(QueryTarget paramQueryTarget) {
    if (paramQueryTarget != null) {
      this.targetType_ = paramQueryTarget;
      this.targetTypeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReadTime(Timestamp.Builder paramBuilder) {
    this.resumeType_ = paramBuilder.build();
    this.resumeTypeCase_ = 11;
  }
  
  private void setReadTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.resumeType_ = paramTimestamp;
      this.resumeTypeCase_ = 11;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResumeToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.resumeTypeCase_ = 4;
      this.resumeType_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetId(int paramInt) {
    this.targetId_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 946, 2 -> 942, 3 -> 940, 4 -> 931, 5 -> 519, 6 -> 126, 7 -> 515, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/Target.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/Target
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/Target.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/Target.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/Target.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/Target
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/Target
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/Target.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 515
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 459
    //   152: iload #4
    //   154: bipush #18
    //   156: if_icmpeq -> 388
    //   159: iload #4
    //   161: bipush #26
    //   163: if_icmpeq -> 317
    //   166: iload #4
    //   168: bipush #34
    //   170: if_icmpeq -> 301
    //   173: iload #4
    //   175: bipush #40
    //   177: if_icmpeq -> 290
    //   180: iload #4
    //   182: bipush #48
    //   184: if_icmpeq -> 279
    //   187: iload #4
    //   189: bipush #90
    //   191: if_icmpeq -> 206
    //   194: aload_2
    //   195: iload #4
    //   197: invokevirtual skipField : (I)Z
    //   200: ifne -> 136
    //   203: goto -> 459
    //   206: aload_0
    //   207: getfield resumeTypeCase_ : I
    //   210: bipush #11
    //   212: if_icmpne -> 232
    //   215: aload_0
    //   216: getfield resumeType_ : Ljava/lang/Object;
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
    //   243: putfield resumeType_ : Ljava/lang/Object;
    //   246: aload_1
    //   247: ifnull -> 270
    //   250: aload_1
    //   251: aload_0
    //   252: getfield resumeType_ : Ljava/lang/Object;
    //   255: checkcast com/google/protobuf/Timestamp
    //   258: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   261: pop
    //   262: aload_0
    //   263: aload_1
    //   264: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   267: putfield resumeType_ : Ljava/lang/Object;
    //   270: aload_0
    //   271: bipush #11
    //   273: putfield resumeTypeCase_ : I
    //   276: goto -> 136
    //   279: aload_0
    //   280: aload_2
    //   281: invokevirtual readBool : ()Z
    //   284: putfield once_ : Z
    //   287: goto -> 136
    //   290: aload_0
    //   291: aload_2
    //   292: invokevirtual readInt32 : ()I
    //   295: putfield targetId_ : I
    //   298: goto -> 136
    //   301: aload_0
    //   302: iconst_4
    //   303: putfield resumeTypeCase_ : I
    //   306: aload_0
    //   307: aload_2
    //   308: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   311: putfield resumeType_ : Ljava/lang/Object;
    //   314: goto -> 136
    //   317: aload_0
    //   318: getfield targetTypeCase_ : I
    //   321: iconst_3
    //   322: if_icmpne -> 342
    //   325: aload_0
    //   326: getfield targetType_ : Ljava/lang/Object;
    //   329: checkcast com/google/firestore/v1/Target$DocumentsTarget
    //   332: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   335: checkcast com/google/firestore/v1/Target$DocumentsTarget$Builder
    //   338: astore_1
    //   339: goto -> 344
    //   342: aconst_null
    //   343: astore_1
    //   344: aload_0
    //   345: aload_2
    //   346: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   349: aload_3
    //   350: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   353: putfield targetType_ : Ljava/lang/Object;
    //   356: aload_1
    //   357: ifnull -> 380
    //   360: aload_1
    //   361: aload_0
    //   362: getfield targetType_ : Ljava/lang/Object;
    //   365: checkcast com/google/firestore/v1/Target$DocumentsTarget
    //   368: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   371: pop
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   377: putfield targetType_ : Ljava/lang/Object;
    //   380: aload_0
    //   381: iconst_3
    //   382: putfield targetTypeCase_ : I
    //   385: goto -> 136
    //   388: aload_0
    //   389: getfield targetTypeCase_ : I
    //   392: iconst_2
    //   393: if_icmpne -> 413
    //   396: aload_0
    //   397: getfield targetType_ : Ljava/lang/Object;
    //   400: checkcast com/google/firestore/v1/Target$QueryTarget
    //   403: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   406: checkcast com/google/firestore/v1/Target$QueryTarget$Builder
    //   409: astore_1
    //   410: goto -> 415
    //   413: aconst_null
    //   414: astore_1
    //   415: aload_0
    //   416: aload_2
    //   417: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   420: aload_3
    //   421: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   424: putfield targetType_ : Ljava/lang/Object;
    //   427: aload_1
    //   428: ifnull -> 451
    //   431: aload_1
    //   432: aload_0
    //   433: getfield targetType_ : Ljava/lang/Object;
    //   436: checkcast com/google/firestore/v1/Target$QueryTarget
    //   439: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   442: pop
    //   443: aload_0
    //   444: aload_1
    //   445: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   448: putfield targetType_ : Ljava/lang/Object;
    //   451: aload_0
    //   452: iconst_2
    //   453: putfield targetTypeCase_ : I
    //   456: goto -> 136
    //   459: iconst_1
    //   460: istore #8
    //   462: goto -> 136
    //   465: astore_1
    //   466: goto -> 513
    //   469: astore_1
    //   470: new java/lang/RuntimeException
    //   473: astore_3
    //   474: new com/google/protobuf/InvalidProtocolBufferException
    //   477: astore_2
    //   478: aload_2
    //   479: aload_1
    //   480: invokevirtual getMessage : ()Ljava/lang/String;
    //   483: invokespecial <init> : (Ljava/lang/String;)V
    //   486: aload_3
    //   487: aload_2
    //   488: aload_0
    //   489: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   492: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   495: aload_3
    //   496: athrow
    //   497: astore_2
    //   498: new java/lang/RuntimeException
    //   501: astore_1
    //   502: aload_1
    //   503: aload_2
    //   504: aload_0
    //   505: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   508: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   511: aload_1
    //   512: athrow
    //   513: aload_1
    //   514: athrow
    //   515: getstatic com/google/firestore/v1/Target.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target;
    //   518: areturn
    //   519: aload_2
    //   520: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   523: astore_1
    //   524: aload_3
    //   525: checkcast com/google/firestore/v1/Target
    //   528: astore_2
    //   529: aload_0
    //   530: getfield targetId_ : I
    //   533: ifeq -> 542
    //   536: iconst_1
    //   537: istore #9
    //   539: goto -> 545
    //   542: iconst_0
    //   543: istore #9
    //   545: aload_0
    //   546: getfield targetId_ : I
    //   549: istore #8
    //   551: aload_2
    //   552: getfield targetId_ : I
    //   555: ifeq -> 564
    //   558: iconst_1
    //   559: istore #10
    //   561: goto -> 567
    //   564: iconst_0
    //   565: istore #10
    //   567: aload_0
    //   568: aload_1
    //   569: iload #9
    //   571: iload #8
    //   573: iload #10
    //   575: aload_2
    //   576: getfield targetId_ : I
    //   579: invokeinterface visitInt : (ZIZI)I
    //   584: putfield targetId_ : I
    //   587: aload_0
    //   588: getfield once_ : Z
    //   591: istore #9
    //   593: aload_2
    //   594: getfield once_ : Z
    //   597: istore #10
    //   599: aload_0
    //   600: aload_1
    //   601: iload #9
    //   603: iload #9
    //   605: iload #10
    //   607: iload #10
    //   609: invokeinterface visitBoolean : (ZZZZ)Z
    //   614: putfield once_ : Z
    //   617: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$firestore$v1$Target$TargetTypeCase : [I
    //   620: aload_2
    //   621: invokevirtual getTargetTypeCase : ()Lcom/google/firestore/v1/Target$TargetTypeCase;
    //   624: invokevirtual ordinal : ()I
    //   627: iaload
    //   628: istore #8
    //   630: iload #8
    //   632: iconst_1
    //   633: if_icmpeq -> 718
    //   636: iload #8
    //   638: iconst_2
    //   639: if_icmpeq -> 678
    //   642: iload #8
    //   644: iconst_3
    //   645: if_icmpeq -> 651
    //   648: goto -> 755
    //   651: aload_0
    //   652: getfield targetTypeCase_ : I
    //   655: ifeq -> 664
    //   658: iconst_1
    //   659: istore #9
    //   661: goto -> 667
    //   664: iconst_0
    //   665: istore #9
    //   667: aload_1
    //   668: iload #9
    //   670: invokeinterface visitOneofNotSet : (Z)V
    //   675: goto -> 755
    //   678: aload_0
    //   679: getfield targetTypeCase_ : I
    //   682: iconst_3
    //   683: if_icmpne -> 692
    //   686: iconst_1
    //   687: istore #9
    //   689: goto -> 695
    //   692: iconst_0
    //   693: istore #9
    //   695: aload_0
    //   696: aload_1
    //   697: iload #9
    //   699: aload_0
    //   700: getfield targetType_ : Ljava/lang/Object;
    //   703: aload_2
    //   704: getfield targetType_ : Ljava/lang/Object;
    //   707: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   712: putfield targetType_ : Ljava/lang/Object;
    //   715: goto -> 755
    //   718: aload_0
    //   719: getfield targetTypeCase_ : I
    //   722: iconst_2
    //   723: if_icmpne -> 732
    //   726: iconst_1
    //   727: istore #9
    //   729: goto -> 735
    //   732: iconst_0
    //   733: istore #9
    //   735: aload_0
    //   736: aload_1
    //   737: iload #9
    //   739: aload_0
    //   740: getfield targetType_ : Ljava/lang/Object;
    //   743: aload_2
    //   744: getfield targetType_ : Ljava/lang/Object;
    //   747: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   752: putfield targetType_ : Ljava/lang/Object;
    //   755: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$firestore$v1$Target$ResumeTypeCase : [I
    //   758: aload_2
    //   759: invokevirtual getResumeTypeCase : ()Lcom/google/firestore/v1/Target$ResumeTypeCase;
    //   762: invokevirtual ordinal : ()I
    //   765: iaload
    //   766: istore #8
    //   768: iload #8
    //   770: iconst_1
    //   771: if_icmpeq -> 853
    //   774: iload #8
    //   776: iconst_2
    //   777: if_icmpeq -> 814
    //   780: iload #8
    //   782: iconst_3
    //   783: if_icmpeq -> 789
    //   786: goto -> 888
    //   789: iload #5
    //   791: istore #9
    //   793: aload_0
    //   794: getfield resumeTypeCase_ : I
    //   797: ifeq -> 803
    //   800: iconst_1
    //   801: istore #9
    //   803: aload_1
    //   804: iload #9
    //   806: invokeinterface visitOneofNotSet : (Z)V
    //   811: goto -> 888
    //   814: iload #6
    //   816: istore #9
    //   818: aload_0
    //   819: getfield resumeTypeCase_ : I
    //   822: bipush #11
    //   824: if_icmpne -> 830
    //   827: iconst_1
    //   828: istore #9
    //   830: aload_0
    //   831: aload_1
    //   832: iload #9
    //   834: aload_0
    //   835: getfield resumeType_ : Ljava/lang/Object;
    //   838: aload_2
    //   839: getfield resumeType_ : Ljava/lang/Object;
    //   842: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   847: putfield resumeType_ : Ljava/lang/Object;
    //   850: goto -> 888
    //   853: iload #7
    //   855: istore #9
    //   857: aload_0
    //   858: getfield resumeTypeCase_ : I
    //   861: iconst_4
    //   862: if_icmpne -> 868
    //   865: iconst_1
    //   866: istore #9
    //   868: aload_0
    //   869: aload_1
    //   870: iload #9
    //   872: aload_0
    //   873: getfield resumeType_ : Ljava/lang/Object;
    //   876: aload_2
    //   877: getfield resumeType_ : Ljava/lang/Object;
    //   880: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   885: putfield resumeType_ : Ljava/lang/Object;
    //   888: aload_1
    //   889: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   892: if_acmpne -> 929
    //   895: aload_2
    //   896: getfield targetTypeCase_ : I
    //   899: istore #8
    //   901: iload #8
    //   903: ifeq -> 912
    //   906: aload_0
    //   907: iload #8
    //   909: putfield targetTypeCase_ : I
    //   912: aload_2
    //   913: getfield resumeTypeCase_ : I
    //   916: istore #8
    //   918: iload #8
    //   920: ifeq -> 929
    //   923: aload_0
    //   924: iload #8
    //   926: putfield resumeTypeCase_ : I
    //   929: aload_0
    //   930: areturn
    //   931: new com/google/firestore/v1/Target$Builder
    //   934: dup
    //   935: aconst_null
    //   936: invokespecial <init> : (Lcom/google/firestore/v1/Target$1;)V
    //   939: areturn
    //   940: aconst_null
    //   941: areturn
    //   942: getstatic com/google/firestore/v1/Target.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target;
    //   945: areturn
    //   946: new com/google/firestore/v1/Target
    //   949: dup
    //   950: invokespecial <init> : ()V
    //   953: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	497	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	469	java/io/IOException
    //   141	147	465	finally
    //   194	203	497	com/google/protobuf/InvalidProtocolBufferException
    //   194	203	469	java/io/IOException
    //   194	203	465	finally
    //   206	229	497	com/google/protobuf/InvalidProtocolBufferException
    //   206	229	469	java/io/IOException
    //   206	229	465	finally
    //   234	246	497	com/google/protobuf/InvalidProtocolBufferException
    //   234	246	469	java/io/IOException
    //   234	246	465	finally
    //   250	270	497	com/google/protobuf/InvalidProtocolBufferException
    //   250	270	469	java/io/IOException
    //   250	270	465	finally
    //   270	276	497	com/google/protobuf/InvalidProtocolBufferException
    //   270	276	469	java/io/IOException
    //   270	276	465	finally
    //   279	287	497	com/google/protobuf/InvalidProtocolBufferException
    //   279	287	469	java/io/IOException
    //   279	287	465	finally
    //   290	298	497	com/google/protobuf/InvalidProtocolBufferException
    //   290	298	469	java/io/IOException
    //   290	298	465	finally
    //   301	314	497	com/google/protobuf/InvalidProtocolBufferException
    //   301	314	469	java/io/IOException
    //   301	314	465	finally
    //   317	339	497	com/google/protobuf/InvalidProtocolBufferException
    //   317	339	469	java/io/IOException
    //   317	339	465	finally
    //   344	356	497	com/google/protobuf/InvalidProtocolBufferException
    //   344	356	469	java/io/IOException
    //   344	356	465	finally
    //   360	380	497	com/google/protobuf/InvalidProtocolBufferException
    //   360	380	469	java/io/IOException
    //   360	380	465	finally
    //   380	385	497	com/google/protobuf/InvalidProtocolBufferException
    //   380	385	469	java/io/IOException
    //   380	385	465	finally
    //   388	410	497	com/google/protobuf/InvalidProtocolBufferException
    //   388	410	469	java/io/IOException
    //   388	410	465	finally
    //   415	427	497	com/google/protobuf/InvalidProtocolBufferException
    //   415	427	469	java/io/IOException
    //   415	427	465	finally
    //   431	451	497	com/google/protobuf/InvalidProtocolBufferException
    //   431	451	469	java/io/IOException
    //   431	451	465	finally
    //   451	456	497	com/google/protobuf/InvalidProtocolBufferException
    //   451	456	469	java/io/IOException
    //   451	456	465	finally
    //   470	497	465	finally
    //   498	513	465	finally
  }
  
  public DocumentsTarget getDocuments() {
    return (this.targetTypeCase_ == 3) ? (DocumentsTarget)this.targetType_ : DocumentsTarget.getDefaultInstance();
  }
  
  public boolean getOnce() {
    return this.once_;
  }
  
  public QueryTarget getQuery() {
    return (this.targetTypeCase_ == 2) ? (QueryTarget)this.targetType_ : QueryTarget.getDefaultInstance();
  }
  
  public Timestamp getReadTime() {
    return (this.resumeTypeCase_ == 11) ? (Timestamp)this.resumeType_ : Timestamp.getDefaultInstance();
  }
  
  public ByteString getResumeToken() {
    return (this.resumeTypeCase_ == 4) ? (ByteString)this.resumeType_ : ByteString.EMPTY;
  }
  
  public ResumeTypeCase getResumeTypeCase() {
    return ResumeTypeCase.forNumber(this.resumeTypeCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.targetTypeCase_ == 2)
      i = 0 + CodedOutputStream.computeMessageSize(2, (MessageLite)this.targetType_); 
    int j = i;
    if (this.targetTypeCase_ == 3)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.targetType_); 
    i = j;
    if (this.resumeTypeCase_ == 4)
      i = j + CodedOutputStream.computeBytesSize(4, (ByteString)this.resumeType_); 
    int k = this.targetId_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(5, k); 
    boolean bool = this.once_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(6, bool); 
    j = i;
    if (this.resumeTypeCase_ == 11)
      j = i + CodedOutputStream.computeMessageSize(11, (MessageLite)this.resumeType_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getTargetId() {
    return this.targetId_;
  }
  
  public TargetTypeCase getTargetTypeCase() {
    return TargetTypeCase.forNumber(this.targetTypeCase_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.targetTypeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.targetType_); 
    if (this.targetTypeCase_ == 3)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.targetType_); 
    if (this.resumeTypeCase_ == 4)
      paramCodedOutputStream.writeBytes(4, (ByteString)this.resumeType_); 
    int i = this.targetId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(5, i); 
    boolean bool = this.once_;
    if (bool)
      paramCodedOutputStream.writeBool(6, bool); 
    if (this.resumeTypeCase_ == 11)
      paramCodedOutputStream.writeMessage(11, (MessageLite)this.resumeType_); 
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
    
    public Builder clearOnce() {
      copyOnWrite();
      ((Target)this.instance).clearOnce();
      return this;
    }
    
    public Builder clearQuery() {
      copyOnWrite();
      ((Target)this.instance).clearQuery();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((Target)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearResumeToken() {
      copyOnWrite();
      ((Target)this.instance).clearResumeToken();
      return this;
    }
    
    public Builder clearResumeType() {
      copyOnWrite();
      ((Target)this.instance).clearResumeType();
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
    
    public Target.DocumentsTarget getDocuments() {
      return ((Target)this.instance).getDocuments();
    }
    
    public boolean getOnce() {
      return ((Target)this.instance).getOnce();
    }
    
    public Target.QueryTarget getQuery() {
      return ((Target)this.instance).getQuery();
    }
    
    public Timestamp getReadTime() {
      return ((Target)this.instance).getReadTime();
    }
    
    public ByteString getResumeToken() {
      return ((Target)this.instance).getResumeToken();
    }
    
    public Target.ResumeTypeCase getResumeTypeCase() {
      return ((Target)this.instance).getResumeTypeCase();
    }
    
    public int getTargetId() {
      return ((Target)this.instance).getTargetId();
    }
    
    public Target.TargetTypeCase getTargetTypeCase() {
      return ((Target)this.instance).getTargetTypeCase();
    }
    
    public Builder mergeDocuments(Target.DocumentsTarget param1DocumentsTarget) {
      copyOnWrite();
      ((Target)this.instance).mergeDocuments(param1DocumentsTarget);
      return this;
    }
    
    public Builder mergeQuery(Target.QueryTarget param1QueryTarget) {
      copyOnWrite();
      ((Target)this.instance).mergeQuery(param1QueryTarget);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setDocuments(Target.DocumentsTarget.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setDocuments(param1Builder);
      return this;
    }
    
    public Builder setDocuments(Target.DocumentsTarget param1DocumentsTarget) {
      copyOnWrite();
      ((Target)this.instance).setDocuments(param1DocumentsTarget);
      return this;
    }
    
    public Builder setOnce(boolean param1Boolean) {
      copyOnWrite();
      ((Target)this.instance).setOnce(param1Boolean);
      return this;
    }
    
    public Builder setQuery(Target.QueryTarget.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setQuery(param1Builder);
      return this;
    }
    
    public Builder setQuery(Target.QueryTarget param1QueryTarget) {
      copyOnWrite();
      ((Target)this.instance).setQuery(param1QueryTarget);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Target)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Target)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setResumeToken(ByteString param1ByteString) {
      copyOnWrite();
      ((Target)this.instance).setResumeToken(param1ByteString);
      return this;
    }
    
    public Builder setTargetId(int param1Int) {
      copyOnWrite();
      ((Target)this.instance).setTargetId(param1Int);
      return this;
    }
  }
  
  public static final class DocumentsTarget extends GeneratedMessageLite<DocumentsTarget, DocumentsTarget.Builder> implements DocumentsTargetOrBuilder {
    private static final DocumentsTarget DEFAULT_INSTANCE = new DocumentsTarget();
    
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    
    private static volatile Parser<DocumentsTarget> PARSER;
    
    private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllDocuments(Iterable<String> param1Iterable) {
      ensureDocumentsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.documents_);
    }
    
    private void addDocuments(String param1String) {
      if (param1String != null) {
        ensureDocumentsIsMutable();
        this.documents_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addDocumentsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        ensureDocumentsIsMutable();
        this.documents_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearDocuments() {
      this.documents_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void ensureDocumentsIsMutable() {
      if (!this.documents_.isModifiable())
        this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_); 
    }
    
    public static DocumentsTarget getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(DocumentsTarget param1DocumentsTarget) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1DocumentsTarget);
    }
    
    public static DocumentsTarget parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (DocumentsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DocumentsTarget parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DocumentsTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DocumentsTarget parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static DocumentsTarget parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static DocumentsTarget parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static DocumentsTarget parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static DocumentsTarget parseFrom(InputStream param1InputStream) throws IOException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static DocumentsTarget parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static DocumentsTarget parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static DocumentsTarget parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (DocumentsTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<DocumentsTarget> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDocuments(int param1Int, String param1String) {
      if (param1String != null) {
        ensureDocumentsIsMutable();
        this.documents_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 318, 2 -> 314, 3 -> 303, 4 -> 294, 5 -> 260, 6 -> 110, 7 -> 256, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firestore/v1/Target$DocumentsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firestore/v1/Target$DocumentsTarget
      //   72: monitorenter
      //   73: getstatic com/google/firestore/v1/Target$DocumentsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firestore/v1/Target$DocumentsTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$DocumentsTarget;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firestore/v1/Target$DocumentsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firestore/v1/Target$DocumentsTarget
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firestore/v1/Target$DocumentsTarget
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firestore/v1/Target$DocumentsTarget.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_2
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 256
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 200
      //   139: iload #5
      //   141: bipush #18
      //   143: if_icmpeq -> 158
      //   146: aload_1
      //   147: iload #5
      //   149: invokevirtual skipField : (I)Z
      //   152: ifne -> 123
      //   155: goto -> 200
      //   158: aload_1
      //   159: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   162: astore_2
      //   163: aload_0
      //   164: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   167: invokeinterface isModifiable : ()Z
      //   172: ifne -> 186
      //   175: aload_0
      //   176: aload_0
      //   177: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   180: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   183: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   186: aload_0
      //   187: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   190: aload_2
      //   191: invokeinterface add : (Ljava/lang/Object;)Z
      //   196: pop
      //   197: goto -> 123
      //   200: iconst_1
      //   201: istore #4
      //   203: goto -> 123
      //   206: astore_1
      //   207: goto -> 254
      //   210: astore_1
      //   211: new java/lang/RuntimeException
      //   214: astore_2
      //   215: new com/google/protobuf/InvalidProtocolBufferException
      //   218: astore_3
      //   219: aload_3
      //   220: aload_1
      //   221: invokevirtual getMessage : ()Ljava/lang/String;
      //   224: invokespecial <init> : (Ljava/lang/String;)V
      //   227: aload_2
      //   228: aload_3
      //   229: aload_0
      //   230: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   233: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   236: aload_2
      //   237: athrow
      //   238: astore_1
      //   239: new java/lang/RuntimeException
      //   242: astore_2
      //   243: aload_2
      //   244: aload_1
      //   245: aload_0
      //   246: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   249: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   252: aload_2
      //   253: athrow
      //   254: aload_1
      //   255: athrow
      //   256: getstatic com/google/firestore/v1/Target$DocumentsTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$DocumentsTarget;
      //   259: areturn
      //   260: aload_2
      //   261: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   264: astore_1
      //   265: aload_3
      //   266: checkcast com/google/firestore/v1/Target$DocumentsTarget
      //   269: astore_2
      //   270: aload_0
      //   271: aload_1
      //   272: aload_0
      //   273: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   276: aload_2
      //   277: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   280: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   285: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   288: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   291: astore_1
      //   292: aload_0
      //   293: areturn
      //   294: new com/google/firestore/v1/Target$DocumentsTarget$Builder
      //   297: dup
      //   298: aconst_null
      //   299: invokespecial <init> : (Lcom/google/firestore/v1/Target$1;)V
      //   302: areturn
      //   303: aload_0
      //   304: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   307: invokeinterface makeImmutable : ()V
      //   312: aconst_null
      //   313: areturn
      //   314: getstatic com/google/firestore/v1/Target$DocumentsTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$DocumentsTarget;
      //   317: areturn
      //   318: new com/google/firestore/v1/Target$DocumentsTarget
      //   321: dup
      //   322: invokespecial <init> : ()V
      //   325: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	238	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	210	java/io/IOException
      //   128	134	206	finally
      //   146	155	238	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	210	java/io/IOException
      //   146	155	206	finally
      //   158	186	238	com/google/protobuf/InvalidProtocolBufferException
      //   158	186	210	java/io/IOException
      //   158	186	206	finally
      //   186	197	238	com/google/protobuf/InvalidProtocolBufferException
      //   186	197	210	java/io/IOException
      //   186	197	206	finally
      //   211	238	206	finally
      //   239	254	206	finally
    }
    
    public String getDocuments(int param1Int) {
      return (String)this.documents_.get(param1Int);
    }
    
    public ByteString getDocumentsBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.documents_.get(param1Int));
    }
    
    public int getDocumentsCount() {
      return this.documents_.size();
    }
    
    public List<String> getDocumentsList() {
      return (List<String>)this.documents_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = i;
      while (i < this.documents_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.documents_.get(i));
        i++;
      } 
      i = 0 + j + getDocumentsList().size() * 1;
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.documents_.size(); b++)
        param1CodedOutputStream.writeString(2, (String)this.documents_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, Builder> implements Target.DocumentsTargetOrBuilder {
      private Builder() {
        super(Target.DocumentsTarget.DEFAULT_INSTANCE);
      }
      
      public Builder addAllDocuments(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((Target.DocumentsTarget)this.instance).addAllDocuments(param2Iterable);
        return this;
      }
      
      public Builder addDocuments(String param2String) {
        copyOnWrite();
        ((Target.DocumentsTarget)this.instance).addDocuments(param2String);
        return this;
      }
      
      public Builder addDocumentsBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Target.DocumentsTarget)this.instance).addDocumentsBytes(param2ByteString);
        return this;
      }
      
      public Builder clearDocuments() {
        copyOnWrite();
        ((Target.DocumentsTarget)this.instance).clearDocuments();
        return this;
      }
      
      public String getDocuments(int param2Int) {
        return ((Target.DocumentsTarget)this.instance).getDocuments(param2Int);
      }
      
      public ByteString getDocumentsBytes(int param2Int) {
        return ((Target.DocumentsTarget)this.instance).getDocumentsBytes(param2Int);
      }
      
      public int getDocumentsCount() {
        return ((Target.DocumentsTarget)this.instance).getDocumentsCount();
      }
      
      public List<String> getDocumentsList() {
        return Collections.unmodifiableList(((Target.DocumentsTarget)this.instance).getDocumentsList());
      }
      
      public Builder setDocuments(int param2Int, String param2String) {
        copyOnWrite();
        ((Target.DocumentsTarget)this.instance).setDocuments(param2Int, param2String);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, DocumentsTarget.Builder> implements DocumentsTargetOrBuilder {
    private Builder() {
      super(Target.DocumentsTarget.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDocuments(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((Target.DocumentsTarget)this.instance).addAllDocuments(param1Iterable);
      return this;
    }
    
    public Builder addDocuments(String param1String) {
      copyOnWrite();
      ((Target.DocumentsTarget)this.instance).addDocuments(param1String);
      return this;
    }
    
    public Builder addDocumentsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Target.DocumentsTarget)this.instance).addDocumentsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearDocuments() {
      copyOnWrite();
      ((Target.DocumentsTarget)this.instance).clearDocuments();
      return this;
    }
    
    public String getDocuments(int param1Int) {
      return ((Target.DocumentsTarget)this.instance).getDocuments(param1Int);
    }
    
    public ByteString getDocumentsBytes(int param1Int) {
      return ((Target.DocumentsTarget)this.instance).getDocumentsBytes(param1Int);
    }
    
    public int getDocumentsCount() {
      return ((Target.DocumentsTarget)this.instance).getDocumentsCount();
    }
    
    public List<String> getDocumentsList() {
      return Collections.unmodifiableList(((Target.DocumentsTarget)this.instance).getDocumentsList());
    }
    
    public Builder setDocuments(int param1Int, String param1String) {
      copyOnWrite();
      ((Target.DocumentsTarget)this.instance).setDocuments(param1Int, param1String);
      return this;
    }
  }
  
  public static interface DocumentsTargetOrBuilder extends MessageLiteOrBuilder {
    String getDocuments(int param1Int);
    
    ByteString getDocumentsBytes(int param1Int);
    
    int getDocumentsCount();
    
    List<String> getDocumentsList();
  }
  
  public static final class QueryTarget extends GeneratedMessageLite<QueryTarget, QueryTarget.Builder> implements QueryTargetOrBuilder {
    private static final QueryTarget DEFAULT_INSTANCE = new QueryTarget();
    
    public static final int PARENT_FIELD_NUMBER = 1;
    
    private static volatile Parser<QueryTarget> PARSER;
    
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    
    private String parent_ = "";
    
    private int queryTypeCase_ = 0;
    
    private Object queryType_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearParent() {
      this.parent_ = getDefaultInstance().getParent();
    }
    
    private void clearQueryType() {
      this.queryTypeCase_ = 0;
      this.queryType_ = null;
    }
    
    private void clearStructuredQuery() {
      if (this.queryTypeCase_ == 2) {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
      } 
    }
    
    public static QueryTarget getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeStructuredQuery(StructuredQuery param1StructuredQuery) {
      if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
        this.queryType_ = ((StructuredQuery.Builder)StructuredQuery.newBuilder((StructuredQuery)this.queryType_).mergeFrom(param1StructuredQuery)).buildPartial();
      } else {
        this.queryType_ = param1StructuredQuery;
      } 
      this.queryTypeCase_ = 2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(QueryTarget param1QueryTarget) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1QueryTarget);
    }
    
    public static QueryTarget parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (QueryTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static QueryTarget parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (QueryTarget)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static QueryTarget parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static QueryTarget parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static QueryTarget parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static QueryTarget parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static QueryTarget parseFrom(InputStream param1InputStream) throws IOException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static QueryTarget parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static QueryTarget parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static QueryTarget parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (QueryTarget)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<QueryTarget> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setParent(String param1String) {
      if (param1String != null) {
        this.parent_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.parent_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setStructuredQuery(StructuredQuery.Builder param1Builder) {
      this.queryType_ = param1Builder.build();
      this.queryTypeCase_ = 2;
    }
    
    private void setStructuredQuery(StructuredQuery param1StructuredQuery) {
      if (param1StructuredQuery != null) {
        this.queryType_ = param1StructuredQuery;
        this.queryTypeCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   19: iload #4
      //   21: tableswitch default -> 68, 1 -> 487, 2 -> 483, 3 -> 481, 4 -> 472, 5 -> 316, 6 -> 122, 7 -> 312, 8 -> 76
      //   68: new java/lang/UnsupportedOperationException
      //   71: dup
      //   72: invokespecial <init> : ()V
      //   75: athrow
      //   76: getstatic com/google/firestore/v1/Target$QueryTarget.PARSER : Lcom/google/protobuf/Parser;
      //   79: ifnonnull -> 118
      //   82: ldc com/google/firestore/v1/Target$QueryTarget
      //   84: monitorenter
      //   85: getstatic com/google/firestore/v1/Target$QueryTarget.PARSER : Lcom/google/protobuf/Parser;
      //   88: ifnonnull -> 106
      //   91: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   94: astore_1
      //   95: aload_1
      //   96: getstatic com/google/firestore/v1/Target$QueryTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$QueryTarget;
      //   99: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   102: aload_1
      //   103: putstatic com/google/firestore/v1/Target$QueryTarget.PARSER : Lcom/google/protobuf/Parser;
      //   106: ldc com/google/firestore/v1/Target$QueryTarget
      //   108: monitorexit
      //   109: goto -> 118
      //   112: astore_1
      //   113: ldc com/google/firestore/v1/Target$QueryTarget
      //   115: monitorexit
      //   116: aload_1
      //   117: athrow
      //   118: getstatic com/google/firestore/v1/Target$QueryTarget.PARSER : Lcom/google/protobuf/Parser;
      //   121: areturn
      //   122: aload_2
      //   123: checkcast com/google/protobuf/CodedInputStream
      //   126: astore_2
      //   127: aload_3
      //   128: checkcast com/google/protobuf/ExtensionRegistryLite
      //   131: astore_3
      //   132: iload #7
      //   134: ifne -> 312
      //   137: aload_2
      //   138: invokevirtual readTag : ()I
      //   141: istore #4
      //   143: iload #4
      //   145: ifeq -> 256
      //   148: iload #4
      //   150: bipush #10
      //   152: if_icmpeq -> 245
      //   155: iload #4
      //   157: bipush #18
      //   159: if_icmpeq -> 174
      //   162: aload_2
      //   163: iload #4
      //   165: invokevirtual skipField : (I)Z
      //   168: ifne -> 132
      //   171: goto -> 256
      //   174: aload_0
      //   175: getfield queryTypeCase_ : I
      //   178: iconst_2
      //   179: if_icmpne -> 199
      //   182: aload_0
      //   183: getfield queryType_ : Ljava/lang/Object;
      //   186: checkcast com/google/firestore/v1/StructuredQuery
      //   189: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   192: checkcast com/google/firestore/v1/StructuredQuery$Builder
      //   195: astore_1
      //   196: goto -> 201
      //   199: aconst_null
      //   200: astore_1
      //   201: aload_0
      //   202: aload_2
      //   203: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   206: aload_3
      //   207: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   210: putfield queryType_ : Ljava/lang/Object;
      //   213: aload_1
      //   214: ifnull -> 237
      //   217: aload_1
      //   218: aload_0
      //   219: getfield queryType_ : Ljava/lang/Object;
      //   222: checkcast com/google/firestore/v1/StructuredQuery
      //   225: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   228: pop
      //   229: aload_0
      //   230: aload_1
      //   231: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   234: putfield queryType_ : Ljava/lang/Object;
      //   237: aload_0
      //   238: iconst_2
      //   239: putfield queryTypeCase_ : I
      //   242: goto -> 132
      //   245: aload_0
      //   246: aload_2
      //   247: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   250: putfield parent_ : Ljava/lang/String;
      //   253: goto -> 132
      //   256: iconst_1
      //   257: istore #7
      //   259: goto -> 132
      //   262: astore_1
      //   263: goto -> 310
      //   266: astore_3
      //   267: new java/lang/RuntimeException
      //   270: astore_2
      //   271: new com/google/protobuf/InvalidProtocolBufferException
      //   274: astore_1
      //   275: aload_1
      //   276: aload_3
      //   277: invokevirtual getMessage : ()Ljava/lang/String;
      //   280: invokespecial <init> : (Ljava/lang/String;)V
      //   283: aload_2
      //   284: aload_1
      //   285: aload_0
      //   286: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   289: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   292: aload_2
      //   293: athrow
      //   294: astore_1
      //   295: new java/lang/RuntimeException
      //   298: astore_2
      //   299: aload_2
      //   300: aload_1
      //   301: aload_0
      //   302: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   305: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   308: aload_2
      //   309: athrow
      //   310: aload_1
      //   311: athrow
      //   312: getstatic com/google/firestore/v1/Target$QueryTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$QueryTarget;
      //   315: areturn
      //   316: aload_2
      //   317: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   320: astore_1
      //   321: aload_3
      //   322: checkcast com/google/firestore/v1/Target$QueryTarget
      //   325: astore_2
      //   326: aload_0
      //   327: aload_1
      //   328: aload_0
      //   329: getfield parent_ : Ljava/lang/String;
      //   332: invokevirtual isEmpty : ()Z
      //   335: iconst_1
      //   336: ixor
      //   337: aload_0
      //   338: getfield parent_ : Ljava/lang/String;
      //   341: aload_2
      //   342: getfield parent_ : Ljava/lang/String;
      //   345: invokevirtual isEmpty : ()Z
      //   348: iconst_1
      //   349: ixor
      //   350: aload_2
      //   351: getfield parent_ : Ljava/lang/String;
      //   354: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   359: putfield parent_ : Ljava/lang/String;
      //   362: getstatic com/google/firestore/v1/Target$1.$SwitchMap$com$google$firestore$v1$Target$QueryTarget$QueryTypeCase : [I
      //   365: aload_2
      //   366: invokevirtual getQueryTypeCase : ()Lcom/google/firestore/v1/Target$QueryTarget$QueryTypeCase;
      //   369: invokevirtual ordinal : ()I
      //   372: iaload
      //   373: istore #7
      //   375: iload #7
      //   377: iconst_1
      //   378: if_icmpeq -> 411
      //   381: iload #7
      //   383: iconst_2
      //   384: if_icmpeq -> 390
      //   387: goto -> 446
      //   390: aload_0
      //   391: getfield queryTypeCase_ : I
      //   394: ifeq -> 400
      //   397: iconst_1
      //   398: istore #5
      //   400: aload_1
      //   401: iload #5
      //   403: invokeinterface visitOneofNotSet : (Z)V
      //   408: goto -> 446
      //   411: iload #6
      //   413: istore #5
      //   415: aload_0
      //   416: getfield queryTypeCase_ : I
      //   419: iconst_2
      //   420: if_icmpne -> 426
      //   423: iconst_1
      //   424: istore #5
      //   426: aload_0
      //   427: aload_1
      //   428: iload #5
      //   430: aload_0
      //   431: getfield queryType_ : Ljava/lang/Object;
      //   434: aload_2
      //   435: getfield queryType_ : Ljava/lang/Object;
      //   438: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   443: putfield queryType_ : Ljava/lang/Object;
      //   446: aload_1
      //   447: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   450: if_acmpne -> 470
      //   453: aload_2
      //   454: getfield queryTypeCase_ : I
      //   457: istore #7
      //   459: iload #7
      //   461: ifeq -> 470
      //   464: aload_0
      //   465: iload #7
      //   467: putfield queryTypeCase_ : I
      //   470: aload_0
      //   471: areturn
      //   472: new com/google/firestore/v1/Target$QueryTarget$Builder
      //   475: dup
      //   476: aconst_null
      //   477: invokespecial <init> : (Lcom/google/firestore/v1/Target$1;)V
      //   480: areturn
      //   481: aconst_null
      //   482: areturn
      //   483: getstatic com/google/firestore/v1/Target$QueryTarget.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Target$QueryTarget;
      //   486: areturn
      //   487: new com/google/firestore/v1/Target$QueryTarget
      //   490: dup
      //   491: invokespecial <init> : ()V
      //   494: areturn
      // Exception table:
      //   from	to	target	type
      //   85	106	112	finally
      //   106	109	112	finally
      //   113	116	112	finally
      //   137	143	294	com/google/protobuf/InvalidProtocolBufferException
      //   137	143	266	java/io/IOException
      //   137	143	262	finally
      //   162	171	294	com/google/protobuf/InvalidProtocolBufferException
      //   162	171	266	java/io/IOException
      //   162	171	262	finally
      //   174	196	294	com/google/protobuf/InvalidProtocolBufferException
      //   174	196	266	java/io/IOException
      //   174	196	262	finally
      //   201	213	294	com/google/protobuf/InvalidProtocolBufferException
      //   201	213	266	java/io/IOException
      //   201	213	262	finally
      //   217	237	294	com/google/protobuf/InvalidProtocolBufferException
      //   217	237	266	java/io/IOException
      //   217	237	262	finally
      //   237	242	294	com/google/protobuf/InvalidProtocolBufferException
      //   237	242	266	java/io/IOException
      //   237	242	262	finally
      //   245	253	294	com/google/protobuf/InvalidProtocolBufferException
      //   245	253	266	java/io/IOException
      //   245	253	262	finally
      //   267	294	262	finally
      //   295	310	262	finally
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
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public StructuredQuery getStructuredQuery() {
      return (this.queryTypeCase_ == 2) ? (StructuredQuery)this.queryType_ : StructuredQuery.getDefaultInstance();
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.parent_.isEmpty())
        param1CodedOutputStream.writeString(1, getParent()); 
      if (this.queryTypeCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.queryType_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, Builder> implements Target.QueryTargetOrBuilder {
      private Builder() {
        super(Target.QueryTarget.DEFAULT_INSTANCE);
      }
      
      public Builder clearParent() {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).clearParent();
        return this;
      }
      
      public Builder clearQueryType() {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).clearQueryType();
        return this;
      }
      
      public Builder clearStructuredQuery() {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).clearStructuredQuery();
        return this;
      }
      
      public String getParent() {
        return ((Target.QueryTarget)this.instance).getParent();
      }
      
      public ByteString getParentBytes() {
        return ((Target.QueryTarget)this.instance).getParentBytes();
      }
      
      public Target.QueryTarget.QueryTypeCase getQueryTypeCase() {
        return ((Target.QueryTarget)this.instance).getQueryTypeCase();
      }
      
      public StructuredQuery getStructuredQuery() {
        return ((Target.QueryTarget)this.instance).getStructuredQuery();
      }
      
      public Builder mergeStructuredQuery(StructuredQuery param2StructuredQuery) {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).mergeStructuredQuery(param2StructuredQuery);
        return this;
      }
      
      public Builder setParent(String param2String) {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).setParent(param2String);
        return this;
      }
      
      public Builder setParentBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).setParentBytes(param2ByteString);
        return this;
      }
      
      public Builder setStructuredQuery(StructuredQuery.Builder param2Builder) {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).setStructuredQuery(param2Builder);
        return this;
      }
      
      public Builder setStructuredQuery(StructuredQuery param2StructuredQuery) {
        copyOnWrite();
        ((Target.QueryTarget)this.instance).setStructuredQuery(param2StructuredQuery);
        return this;
      }
    }
    
    public enum QueryTypeCase implements Internal.EnumLite {
      QUERYTYPE_NOT_SET,
      STRUCTURED_QUERY(2);
      
      private final int value;
      
      static {
      
      }
      
      QueryTypeCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static QueryTypeCase forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 2) ? null : STRUCTURED_QUERY) : QUERYTYPE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, QueryTarget.Builder> implements QueryTargetOrBuilder {
    private Builder() {
      super(Target.QueryTarget.DEFAULT_INSTANCE);
    }
    
    public Builder clearParent() {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).clearParent();
      return this;
    }
    
    public Builder clearQueryType() {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).clearQueryType();
      return this;
    }
    
    public Builder clearStructuredQuery() {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).clearStructuredQuery();
      return this;
    }
    
    public String getParent() {
      return ((Target.QueryTarget)this.instance).getParent();
    }
    
    public ByteString getParentBytes() {
      return ((Target.QueryTarget)this.instance).getParentBytes();
    }
    
    public Target.QueryTarget.QueryTypeCase getQueryTypeCase() {
      return ((Target.QueryTarget)this.instance).getQueryTypeCase();
    }
    
    public StructuredQuery getStructuredQuery() {
      return ((Target.QueryTarget)this.instance).getStructuredQuery();
    }
    
    public Builder mergeStructuredQuery(StructuredQuery param1StructuredQuery) {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).mergeStructuredQuery(param1StructuredQuery);
      return this;
    }
    
    public Builder setParent(String param1String) {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).setParent(param1String);
      return this;
    }
    
    public Builder setParentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).setParentBytes(param1ByteString);
      return this;
    }
    
    public Builder setStructuredQuery(StructuredQuery.Builder param1Builder) {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).setStructuredQuery(param1Builder);
      return this;
    }
    
    public Builder setStructuredQuery(StructuredQuery param1StructuredQuery) {
      copyOnWrite();
      ((Target.QueryTarget)this.instance).setStructuredQuery(param1StructuredQuery);
      return this;
    }
  }
  
  public enum QueryTypeCase implements Internal.EnumLite {
    QUERYTYPE_NOT_SET(2),
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
  
  public static interface QueryTargetOrBuilder extends MessageLiteOrBuilder {
    String getParent();
    
    ByteString getParentBytes();
    
    Target.QueryTarget.QueryTypeCase getQueryTypeCase();
    
    StructuredQuery getStructuredQuery();
  }
  
  public enum ResumeTypeCase implements Internal.EnumLite {
    READ_TIME(2),
    RESUMETYPE_NOT_SET(2),
    RESUME_TOKEN(4);
    
    private final int value;
    
    static {
      $VALUES = new ResumeTypeCase[] { RESUME_TOKEN, READ_TIME, RESUMETYPE_NOT_SET };
    }
    
    ResumeTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResumeTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 4) ? ((param1Int != 11) ? null : READ_TIME) : RESUME_TOKEN) : RESUMETYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public enum TargetTypeCase implements Internal.EnumLite {
    DOCUMENTS(4),
    QUERY(2),
    TARGETTYPE_NOT_SET(2);
    
    private final int value;
    
    static {
      $VALUES = new TargetTypeCase[] { QUERY, DOCUMENTS, TARGETTYPE_NOT_SET };
    }
    
    TargetTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TargetTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? ((param1Int != 3) ? null : DOCUMENTS) : QUERY) : TARGETTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Target.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */