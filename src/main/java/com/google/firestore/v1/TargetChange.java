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
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class TargetChange extends GeneratedMessageLite<TargetChange, TargetChange.Builder> implements TargetChangeOrBuilder {
  public static final int CAUSE_FIELD_NUMBER = 3;
  
  private static final TargetChange DEFAULT_INSTANCE = new TargetChange();
  
  private static volatile Parser<TargetChange> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 6;
  
  public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
  
  public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
  
  public static final int TARGET_IDS_FIELD_NUMBER = 2;
  
  private int bitField0_;
  
  private Status cause_;
  
  private Timestamp readTime_;
  
  private ByteString resumeToken_ = ByteString.EMPTY;
  
  private int targetChangeType_;
  
  private Internal.IntList targetIds_ = emptyIntList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllTargetIds(Iterable<? extends Integer> paramIterable) {
    ensureTargetIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.targetIds_);
  }
  
  private void addTargetIds(int paramInt) {
    ensureTargetIdsIsMutable();
    this.targetIds_.addInt(paramInt);
  }
  
  private void clearCause() {
    this.cause_ = null;
  }
  
  private void clearReadTime() {
    this.readTime_ = null;
  }
  
  private void clearResumeToken() {
    this.resumeToken_ = getDefaultInstance().getResumeToken();
  }
  
  private void clearTargetChangeType() {
    this.targetChangeType_ = 0;
  }
  
  private void clearTargetIds() {
    this.targetIds_ = emptyIntList();
  }
  
  private void ensureTargetIdsIsMutable() {
    if (!this.targetIds_.isModifiable())
      this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_); 
  }
  
  public static TargetChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCause(Status paramStatus) {
    Status status = this.cause_;
    if (status != null && status != Status.getDefaultInstance()) {
      this.cause_ = (Status)((Status.Builder)Status.newBuilder(this.cause_).mergeFrom((GeneratedMessageLite)paramStatus)).buildPartial();
    } else {
      this.cause_ = paramStatus;
    } 
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
  
  public static Builder newBuilder(TargetChange paramTargetChange) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTargetChange);
  }
  
  public static TargetChange parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TargetChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TargetChange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetChange parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TargetChange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TargetChange parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TargetChange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetChange parseFrom(InputStream paramInputStream) throws IOException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TargetChange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetChange parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TargetChange parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TargetChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TargetChange> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCause(Status.Builder paramBuilder) {
    this.cause_ = (Status)paramBuilder.build();
  }
  
  private void setCause(Status paramStatus) {
    if (paramStatus != null) {
      this.cause_ = paramStatus;
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
  
  private void setResumeToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.resumeToken_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetChangeType(TargetChangeType paramTargetChangeType) {
    if (paramTargetChangeType != null) {
      this.targetChangeType_ = paramTargetChangeType.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetChangeTypeValue(int paramInt) {
    this.targetChangeType_ = paramInt;
  }
  
  private void setTargetIds(int paramInt1, int paramInt2) {
    ensureTargetIdsIsMutable();
    this.targetIds_.setInt(paramInt1, paramInt2);
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/TargetChange$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 755, 2 -> 751, 3 -> 740, 4 -> 731, 5 -> 521, 6 -> 118, 7 -> 517, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/TargetChange.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/TargetChange
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/TargetChange.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/TargetChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TargetChange;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/TargetChange.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/TargetChange
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/TargetChange
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/TargetChange.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 517
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 461
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 450
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 411
    //   158: iload #4
    //   160: bipush #18
    //   162: if_icmpeq -> 339
    //   165: iload #4
    //   167: bipush #26
    //   169: if_icmpeq -> 274
    //   172: iload #4
    //   174: bipush #34
    //   176: if_icmpeq -> 263
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 198
    //   186: aload_2
    //   187: iload #4
    //   189: invokevirtual skipField : (I)Z
    //   192: ifne -> 128
    //   195: goto -> 461
    //   198: aload_0
    //   199: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   202: ifnull -> 219
    //   205: aload_0
    //   206: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   209: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   212: checkcast com/google/protobuf/Timestamp$Builder
    //   215: astore_1
    //   216: goto -> 221
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_0
    //   222: aload_2
    //   223: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   226: aload_3
    //   227: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   230: checkcast com/google/protobuf/Timestamp
    //   233: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   236: aload_1
    //   237: ifnull -> 128
    //   240: aload_1
    //   241: aload_0
    //   242: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   245: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   248: pop
    //   249: aload_0
    //   250: aload_1
    //   251: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   254: checkcast com/google/protobuf/Timestamp
    //   257: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   260: goto -> 128
    //   263: aload_0
    //   264: aload_2
    //   265: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   268: putfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   271: goto -> 128
    //   274: aload_0
    //   275: getfield cause_ : Lcom/google/rpc/Status;
    //   278: ifnull -> 295
    //   281: aload_0
    //   282: getfield cause_ : Lcom/google/rpc/Status;
    //   285: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   288: checkcast com/google/rpc/Status$Builder
    //   291: astore_1
    //   292: goto -> 297
    //   295: aconst_null
    //   296: astore_1
    //   297: aload_0
    //   298: aload_2
    //   299: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   302: aload_3
    //   303: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   306: checkcast com/google/rpc/Status
    //   309: putfield cause_ : Lcom/google/rpc/Status;
    //   312: aload_1
    //   313: ifnull -> 128
    //   316: aload_1
    //   317: aload_0
    //   318: getfield cause_ : Lcom/google/rpc/Status;
    //   321: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   324: pop
    //   325: aload_0
    //   326: aload_1
    //   327: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   330: checkcast com/google/rpc/Status
    //   333: putfield cause_ : Lcom/google/rpc/Status;
    //   336: goto -> 128
    //   339: aload_2
    //   340: aload_2
    //   341: invokevirtual readRawVarint32 : ()I
    //   344: invokevirtual pushLimit : (I)I
    //   347: istore #4
    //   349: aload_0
    //   350: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   353: invokeinterface isModifiable : ()Z
    //   358: ifne -> 379
    //   361: aload_2
    //   362: invokevirtual getBytesUntilLimit : ()I
    //   365: ifle -> 379
    //   368: aload_0
    //   369: aload_0
    //   370: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   373: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   376: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   379: aload_2
    //   380: invokevirtual getBytesUntilLimit : ()I
    //   383: ifle -> 402
    //   386: aload_0
    //   387: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   390: aload_2
    //   391: invokevirtual readInt32 : ()I
    //   394: invokeinterface addInt : (I)V
    //   399: goto -> 379
    //   402: aload_2
    //   403: iload #4
    //   405: invokevirtual popLimit : (I)V
    //   408: goto -> 128
    //   411: aload_0
    //   412: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   415: invokeinterface isModifiable : ()Z
    //   420: ifne -> 434
    //   423: aload_0
    //   424: aload_0
    //   425: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   428: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   431: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   434: aload_0
    //   435: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   438: aload_2
    //   439: invokevirtual readInt32 : ()I
    //   442: invokeinterface addInt : (I)V
    //   447: goto -> 128
    //   450: aload_0
    //   451: aload_2
    //   452: invokevirtual readEnum : ()I
    //   455: putfield targetChangeType_ : I
    //   458: goto -> 128
    //   461: iconst_1
    //   462: istore #6
    //   464: goto -> 128
    //   467: astore_1
    //   468: goto -> 515
    //   471: astore_2
    //   472: new java/lang/RuntimeException
    //   475: astore_3
    //   476: new com/google/protobuf/InvalidProtocolBufferException
    //   479: astore_1
    //   480: aload_1
    //   481: aload_2
    //   482: invokevirtual getMessage : ()Ljava/lang/String;
    //   485: invokespecial <init> : (Ljava/lang/String;)V
    //   488: aload_3
    //   489: aload_1
    //   490: aload_0
    //   491: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   494: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   497: aload_3
    //   498: athrow
    //   499: astore_1
    //   500: new java/lang/RuntimeException
    //   503: astore_2
    //   504: aload_2
    //   505: aload_1
    //   506: aload_0
    //   507: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   510: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   513: aload_2
    //   514: athrow
    //   515: aload_1
    //   516: athrow
    //   517: getstatic com/google/firestore/v1/TargetChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TargetChange;
    //   520: areturn
    //   521: aload_2
    //   522: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   525: astore_1
    //   526: aload_3
    //   527: checkcast com/google/firestore/v1/TargetChange
    //   530: astore_2
    //   531: aload_0
    //   532: getfield targetChangeType_ : I
    //   535: ifeq -> 544
    //   538: iconst_1
    //   539: istore #7
    //   541: goto -> 547
    //   544: iconst_0
    //   545: istore #7
    //   547: aload_0
    //   548: getfield targetChangeType_ : I
    //   551: istore #6
    //   553: aload_2
    //   554: getfield targetChangeType_ : I
    //   557: ifeq -> 566
    //   560: iconst_1
    //   561: istore #8
    //   563: goto -> 569
    //   566: iconst_0
    //   567: istore #8
    //   569: aload_0
    //   570: aload_1
    //   571: iload #7
    //   573: iload #6
    //   575: iload #8
    //   577: aload_2
    //   578: getfield targetChangeType_ : I
    //   581: invokeinterface visitInt : (ZIZI)I
    //   586: putfield targetChangeType_ : I
    //   589: aload_0
    //   590: aload_1
    //   591: aload_0
    //   592: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   595: aload_2
    //   596: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   599: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   604: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   607: aload_0
    //   608: aload_1
    //   609: aload_0
    //   610: getfield cause_ : Lcom/google/rpc/Status;
    //   613: aload_2
    //   614: getfield cause_ : Lcom/google/rpc/Status;
    //   617: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   622: checkcast com/google/rpc/Status
    //   625: putfield cause_ : Lcom/google/rpc/Status;
    //   628: aload_0
    //   629: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   632: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   635: if_acmpeq -> 644
    //   638: iconst_1
    //   639: istore #7
    //   641: goto -> 647
    //   644: iconst_0
    //   645: istore #7
    //   647: aload_0
    //   648: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   651: astore_3
    //   652: iload #5
    //   654: istore #8
    //   656: aload_2
    //   657: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   660: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   663: if_acmpeq -> 669
    //   666: iconst_1
    //   667: istore #8
    //   669: aload_0
    //   670: aload_1
    //   671: iload #7
    //   673: aload_3
    //   674: iload #8
    //   676: aload_2
    //   677: getfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   680: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   685: putfield resumeToken_ : Lcom/google/protobuf/ByteString;
    //   688: aload_0
    //   689: aload_1
    //   690: aload_0
    //   691: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   694: aload_2
    //   695: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   698: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   703: checkcast com/google/protobuf/Timestamp
    //   706: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   709: aload_1
    //   710: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   713: if_acmpne -> 729
    //   716: aload_0
    //   717: aload_0
    //   718: getfield bitField0_ : I
    //   721: aload_2
    //   722: getfield bitField0_ : I
    //   725: ior
    //   726: putfield bitField0_ : I
    //   729: aload_0
    //   730: areturn
    //   731: new com/google/firestore/v1/TargetChange$Builder
    //   734: dup
    //   735: aconst_null
    //   736: invokespecial <init> : (Lcom/google/firestore/v1/TargetChange$1;)V
    //   739: areturn
    //   740: aload_0
    //   741: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   744: invokeinterface makeImmutable : ()V
    //   749: aconst_null
    //   750: areturn
    //   751: getstatic com/google/firestore/v1/TargetChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TargetChange;
    //   754: areturn
    //   755: new com/google/firestore/v1/TargetChange
    //   758: dup
    //   759: invokespecial <init> : ()V
    //   762: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	499	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	471	java/io/IOException
    //   133	139	467	finally
    //   186	195	499	com/google/protobuf/InvalidProtocolBufferException
    //   186	195	471	java/io/IOException
    //   186	195	467	finally
    //   198	216	499	com/google/protobuf/InvalidProtocolBufferException
    //   198	216	471	java/io/IOException
    //   198	216	467	finally
    //   221	236	499	com/google/protobuf/InvalidProtocolBufferException
    //   221	236	471	java/io/IOException
    //   221	236	467	finally
    //   240	260	499	com/google/protobuf/InvalidProtocolBufferException
    //   240	260	471	java/io/IOException
    //   240	260	467	finally
    //   263	271	499	com/google/protobuf/InvalidProtocolBufferException
    //   263	271	471	java/io/IOException
    //   263	271	467	finally
    //   274	292	499	com/google/protobuf/InvalidProtocolBufferException
    //   274	292	471	java/io/IOException
    //   274	292	467	finally
    //   297	312	499	com/google/protobuf/InvalidProtocolBufferException
    //   297	312	471	java/io/IOException
    //   297	312	467	finally
    //   316	336	499	com/google/protobuf/InvalidProtocolBufferException
    //   316	336	471	java/io/IOException
    //   316	336	467	finally
    //   339	379	499	com/google/protobuf/InvalidProtocolBufferException
    //   339	379	471	java/io/IOException
    //   339	379	467	finally
    //   379	399	499	com/google/protobuf/InvalidProtocolBufferException
    //   379	399	471	java/io/IOException
    //   379	399	467	finally
    //   402	408	499	com/google/protobuf/InvalidProtocolBufferException
    //   402	408	471	java/io/IOException
    //   402	408	467	finally
    //   411	434	499	com/google/protobuf/InvalidProtocolBufferException
    //   411	434	471	java/io/IOException
    //   411	434	467	finally
    //   434	447	499	com/google/protobuf/InvalidProtocolBufferException
    //   434	447	471	java/io/IOException
    //   434	447	467	finally
    //   450	458	499	com/google/protobuf/InvalidProtocolBufferException
    //   450	458	471	java/io/IOException
    //   450	458	467	finally
    //   472	499	467	finally
    //   500	515	467	finally
  }
  
  public Status getCause() {
    Status status1 = this.cause_;
    Status status2 = status1;
    if (status1 == null)
      status2 = Status.getDefaultInstance(); 
    return status2;
  }
  
  public Timestamp getReadTime() {
    Timestamp timestamp1 = this.readTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public ByteString getResumeToken() {
    return this.resumeToken_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = this.targetChangeType_;
    i = TargetChangeType.NO_CHANGE.getNumber();
    int k = 0;
    if (j != i) {
      i = CodedOutputStream.computeEnumSize(1, this.targetChangeType_) + 0;
    } else {
      i = 0;
    } 
    j = 0;
    while (k < this.targetIds_.size()) {
      j += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(k));
      k++;
    } 
    i = i + j + getTargetIdsList().size() * 1;
    k = i;
    if (this.cause_ != null)
      k = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCause()); 
    i = k;
    if (!this.resumeToken_.isEmpty())
      i = k + CodedOutputStream.computeBytesSize(4, this.resumeToken_); 
    k = i;
    if (this.readTime_ != null)
      k = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getReadTime()); 
    this.memoizedSerializedSize = k;
    return k;
  }
  
  public TargetChangeType getTargetChangeType() {
    TargetChangeType targetChangeType1 = TargetChangeType.forNumber(this.targetChangeType_);
    TargetChangeType targetChangeType2 = targetChangeType1;
    if (targetChangeType1 == null)
      targetChangeType2 = TargetChangeType.UNRECOGNIZED; 
    return targetChangeType2;
  }
  
  public int getTargetChangeTypeValue() {
    return this.targetChangeType_;
  }
  
  public int getTargetIds(int paramInt) {
    return this.targetIds_.getInt(paramInt);
  }
  
  public int getTargetIdsCount() {
    return this.targetIds_.size();
  }
  
  public List<Integer> getTargetIdsList() {
    return (List<Integer>)this.targetIds_;
  }
  
  public boolean hasCause() {
    boolean bool;
    if (this.cause_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
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
    getSerializedSize();
    if (this.targetChangeType_ != TargetChangeType.NO_CHANGE.getNumber())
      paramCodedOutputStream.writeEnum(1, this.targetChangeType_); 
    for (byte b = 0; b < this.targetIds_.size(); b++)
      paramCodedOutputStream.writeInt32(2, this.targetIds_.getInt(b)); 
    if (this.cause_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getCause()); 
    if (!this.resumeToken_.isEmpty())
      paramCodedOutputStream.writeBytes(4, this.resumeToken_); 
    if (this.readTime_ != null)
      paramCodedOutputStream.writeMessage(6, (MessageLite)getReadTime()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TargetChange, Builder> implements TargetChangeOrBuilder {
    private Builder() {
      super(TargetChange.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTargetIds(Iterable<? extends Integer> param1Iterable) {
      copyOnWrite();
      ((TargetChange)this.instance).addAllTargetIds(param1Iterable);
      return this;
    }
    
    public Builder addTargetIds(int param1Int) {
      copyOnWrite();
      ((TargetChange)this.instance).addTargetIds(param1Int);
      return this;
    }
    
    public Builder clearCause() {
      copyOnWrite();
      ((TargetChange)this.instance).clearCause();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((TargetChange)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearResumeToken() {
      copyOnWrite();
      ((TargetChange)this.instance).clearResumeToken();
      return this;
    }
    
    public Builder clearTargetChangeType() {
      copyOnWrite();
      ((TargetChange)this.instance).clearTargetChangeType();
      return this;
    }
    
    public Builder clearTargetIds() {
      copyOnWrite();
      ((TargetChange)this.instance).clearTargetIds();
      return this;
    }
    
    public Status getCause() {
      return ((TargetChange)this.instance).getCause();
    }
    
    public Timestamp getReadTime() {
      return ((TargetChange)this.instance).getReadTime();
    }
    
    public ByteString getResumeToken() {
      return ((TargetChange)this.instance).getResumeToken();
    }
    
    public TargetChange.TargetChangeType getTargetChangeType() {
      return ((TargetChange)this.instance).getTargetChangeType();
    }
    
    public int getTargetChangeTypeValue() {
      return ((TargetChange)this.instance).getTargetChangeTypeValue();
    }
    
    public int getTargetIds(int param1Int) {
      return ((TargetChange)this.instance).getTargetIds(param1Int);
    }
    
    public int getTargetIdsCount() {
      return ((TargetChange)this.instance).getTargetIdsCount();
    }
    
    public List<Integer> getTargetIdsList() {
      return Collections.unmodifiableList(((TargetChange)this.instance).getTargetIdsList());
    }
    
    public boolean hasCause() {
      return ((TargetChange)this.instance).hasCause();
    }
    
    public boolean hasReadTime() {
      return ((TargetChange)this.instance).hasReadTime();
    }
    
    public Builder mergeCause(Status param1Status) {
      copyOnWrite();
      ((TargetChange)this.instance).mergeCause(param1Status);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TargetChange)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setCause(Status.Builder param1Builder) {
      copyOnWrite();
      ((TargetChange)this.instance).setCause(param1Builder);
      return this;
    }
    
    public Builder setCause(Status param1Status) {
      copyOnWrite();
      ((TargetChange)this.instance).setCause(param1Status);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((TargetChange)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TargetChange)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setResumeToken(ByteString param1ByteString) {
      copyOnWrite();
      ((TargetChange)this.instance).setResumeToken(param1ByteString);
      return this;
    }
    
    public Builder setTargetChangeType(TargetChange.TargetChangeType param1TargetChangeType) {
      copyOnWrite();
      ((TargetChange)this.instance).setTargetChangeType(param1TargetChangeType);
      return this;
    }
    
    public Builder setTargetChangeTypeValue(int param1Int) {
      copyOnWrite();
      ((TargetChange)this.instance).setTargetChangeTypeValue(param1Int);
      return this;
    }
    
    public Builder setTargetIds(int param1Int1, int param1Int2) {
      copyOnWrite();
      ((TargetChange)this.instance).setTargetIds(param1Int1, param1Int2);
      return this;
    }
  }
  
  public enum TargetChangeType implements Internal.EnumLite {
    ADD,
    CURRENT,
    NO_CHANGE(0),
    REMOVE(0),
    RESET(0),
    UNRECOGNIZED(0);
    
    public static final int ADD_VALUE = 1;
    
    public static final int CURRENT_VALUE = 3;
    
    public static final int NO_CHANGE_VALUE = 0;
    
    public static final int REMOVE_VALUE = 2;
    
    public static final int RESET_VALUE = 4;
    
    private static final Internal.EnumLiteMap<TargetChangeType> internalValueMap;
    
    private final int value;
    
    static {
      CURRENT = new TargetChangeType("CURRENT", 3, 3);
      RESET = new TargetChangeType("RESET", 4, 4);
      UNRECOGNIZED = new TargetChangeType("UNRECOGNIZED", 5, -1);
      $VALUES = new TargetChangeType[] { NO_CHANGE, ADD, REMOVE, CURRENT, RESET, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<TargetChangeType>() {
          public TargetChange.TargetChangeType findValueByNumber(int param2Int) {
            return TargetChange.TargetChangeType.forNumber(param2Int);
          }
        };
    }
    
    TargetChangeType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TargetChangeType forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : RESET) : CURRENT) : REMOVE) : ADD) : NO_CHANGE;
    }
    
    public static Internal.EnumLiteMap<TargetChangeType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<TargetChangeType> {
    public TargetChange.TargetChangeType findValueByNumber(int param1Int) {
      return TargetChange.TargetChangeType.forNumber(param1Int);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\TargetChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */