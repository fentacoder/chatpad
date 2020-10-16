package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteOrBuilder;
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

public final class WriteBatch extends GeneratedMessageLite<WriteBatch, WriteBatch.Builder> implements WriteBatchOrBuilder {
  public static final int BASE_WRITES_FIELD_NUMBER = 4;
  
  public static final int BATCH_ID_FIELD_NUMBER = 1;
  
  private static final WriteBatch DEFAULT_INSTANCE = new WriteBatch();
  
  public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
  
  private static volatile Parser<WriteBatch> PARSER;
  
  public static final int WRITES_FIELD_NUMBER = 2;
  
  private Internal.ProtobufList<Write> baseWrites_ = emptyProtobufList();
  
  private int batchId_;
  
  private int bitField0_;
  
  private Timestamp localWriteTime_;
  
  private Internal.ProtobufList<Write> writes_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllBaseWrites(Iterable<? extends Write> paramIterable) {
    ensureBaseWritesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.baseWrites_);
  }
  
  private void addAllWrites(Iterable<? extends Write> paramIterable) {
    ensureWritesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.writes_);
  }
  
  private void addBaseWrites(int paramInt, Write.Builder paramBuilder) {
    ensureBaseWritesIsMutable();
    this.baseWrites_.add(paramInt, paramBuilder.build());
  }
  
  private void addBaseWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureBaseWritesIsMutable();
      this.baseWrites_.add(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addBaseWrites(Write.Builder paramBuilder) {
    ensureBaseWritesIsMutable();
    this.baseWrites_.add(paramBuilder.build());
  }
  
  private void addBaseWrites(Write paramWrite) {
    if (paramWrite != null) {
      ensureBaseWritesIsMutable();
      this.baseWrites_.add(paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addWrites(int paramInt, Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.add(paramInt, paramBuilder.build());
  }
  
  private void addWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.add(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addWrites(Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.add(paramBuilder.build());
  }
  
  private void addWrites(Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.add(paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearBaseWrites() {
    this.baseWrites_ = emptyProtobufList();
  }
  
  private void clearBatchId() {
    this.batchId_ = 0;
  }
  
  private void clearLocalWriteTime() {
    this.localWriteTime_ = null;
  }
  
  private void clearWrites() {
    this.writes_ = emptyProtobufList();
  }
  
  private void ensureBaseWritesIsMutable() {
    if (!this.baseWrites_.isModifiable())
      this.baseWrites_ = GeneratedMessageLite.mutableCopy(this.baseWrites_); 
  }
  
  private void ensureWritesIsMutable() {
    if (!this.writes_.isModifiable())
      this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_); 
  }
  
  public static WriteBatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeLocalWriteTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.localWriteTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.localWriteTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.localWriteTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.localWriteTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(WriteBatch paramWriteBatch) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWriteBatch);
  }
  
  public static WriteBatch parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (WriteBatch)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteBatch parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteBatch)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteBatch parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static WriteBatch parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static WriteBatch parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static WriteBatch parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteBatch parseFrom(InputStream paramInputStream) throws IOException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteBatch parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteBatch parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static WriteBatch parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteBatch)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<WriteBatch> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeBaseWrites(int paramInt) {
    ensureBaseWritesIsMutable();
    this.baseWrites_.remove(paramInt);
  }
  
  private void removeWrites(int paramInt) {
    ensureWritesIsMutable();
    this.writes_.remove(paramInt);
  }
  
  private void setBaseWrites(int paramInt, Write.Builder paramBuilder) {
    ensureBaseWritesIsMutable();
    this.baseWrites_.set(paramInt, paramBuilder.build());
  }
  
  private void setBaseWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureBaseWritesIsMutable();
      this.baseWrites_.set(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBatchId(int paramInt) {
    this.batchId_ = paramInt;
  }
  
  private void setLocalWriteTime(Timestamp.Builder paramBuilder) {
    this.localWriteTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setLocalWriteTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.localWriteTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setWrites(int paramInt, Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.set(paramInt, paramBuilder.build());
  }
  
  private void setWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.set(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/WriteBatch$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 588, 2 -> 584, 3 -> 564, 4 -> 555, 5 -> 414, 6 -> 118, 7 -> 410, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firebase/firestore/proto/WriteBatch.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firebase/firestore/proto/WriteBatch
    //   80: monitorenter
    //   81: getstatic com/google/firebase/firestore/proto/WriteBatch.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firebase/firestore/proto/WriteBatch.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/WriteBatch;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firebase/firestore/proto/WriteBatch.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firebase/firestore/proto/WriteBatch
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firebase/firestore/proto/WriteBatch
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firebase/firestore/proto/WriteBatch.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 410
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 354
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 343
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 296
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 231
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 184
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 354
    //   184: aload_0
    //   185: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: invokeinterface isModifiable : ()Z
    //   193: ifne -> 207
    //   196: aload_0
    //   197: aload_0
    //   198: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   201: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   204: putfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   207: aload_0
    //   208: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   211: aload_2
    //   212: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   215: aload_3
    //   216: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   219: checkcast com/google/firestore/v1/Write
    //   222: invokeinterface add : (Ljava/lang/Object;)Z
    //   227: pop
    //   228: goto -> 128
    //   231: aload_0
    //   232: getfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   235: ifnull -> 252
    //   238: aload_0
    //   239: getfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   242: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   245: checkcast com/google/protobuf/Timestamp$Builder
    //   248: astore_1
    //   249: goto -> 254
    //   252: aconst_null
    //   253: astore_1
    //   254: aload_0
    //   255: aload_2
    //   256: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   259: aload_3
    //   260: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   263: checkcast com/google/protobuf/Timestamp
    //   266: putfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   269: aload_1
    //   270: ifnull -> 128
    //   273: aload_1
    //   274: aload_0
    //   275: getfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   278: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   281: pop
    //   282: aload_0
    //   283: aload_1
    //   284: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   287: checkcast com/google/protobuf/Timestamp
    //   290: putfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   293: goto -> 128
    //   296: aload_0
    //   297: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   300: invokeinterface isModifiable : ()Z
    //   305: ifne -> 319
    //   308: aload_0
    //   309: aload_0
    //   310: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   313: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   316: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   319: aload_0
    //   320: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   323: aload_2
    //   324: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   327: aload_3
    //   328: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   331: checkcast com/google/firestore/v1/Write
    //   334: invokeinterface add : (Ljava/lang/Object;)Z
    //   339: pop
    //   340: goto -> 128
    //   343: aload_0
    //   344: aload_2
    //   345: invokevirtual readInt32 : ()I
    //   348: putfield batchId_ : I
    //   351: goto -> 128
    //   354: iconst_1
    //   355: istore #6
    //   357: goto -> 128
    //   360: astore_1
    //   361: goto -> 408
    //   364: astore_1
    //   365: new java/lang/RuntimeException
    //   368: astore_2
    //   369: new com/google/protobuf/InvalidProtocolBufferException
    //   372: astore_3
    //   373: aload_3
    //   374: aload_1
    //   375: invokevirtual getMessage : ()Ljava/lang/String;
    //   378: invokespecial <init> : (Ljava/lang/String;)V
    //   381: aload_2
    //   382: aload_3
    //   383: aload_0
    //   384: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   387: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   390: aload_2
    //   391: athrow
    //   392: astore_2
    //   393: new java/lang/RuntimeException
    //   396: astore_1
    //   397: aload_1
    //   398: aload_2
    //   399: aload_0
    //   400: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   403: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   406: aload_1
    //   407: athrow
    //   408: aload_1
    //   409: athrow
    //   410: getstatic com/google/firebase/firestore/proto/WriteBatch.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/WriteBatch;
    //   413: areturn
    //   414: aload_2
    //   415: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   418: astore_1
    //   419: aload_3
    //   420: checkcast com/google/firebase/firestore/proto/WriteBatch
    //   423: astore_2
    //   424: aload_0
    //   425: getfield batchId_ : I
    //   428: ifeq -> 437
    //   431: iconst_1
    //   432: istore #7
    //   434: goto -> 440
    //   437: iconst_0
    //   438: istore #7
    //   440: aload_0
    //   441: getfield batchId_ : I
    //   444: istore #6
    //   446: aload_2
    //   447: getfield batchId_ : I
    //   450: ifeq -> 456
    //   453: iconst_1
    //   454: istore #5
    //   456: aload_0
    //   457: aload_1
    //   458: iload #7
    //   460: iload #6
    //   462: iload #5
    //   464: aload_2
    //   465: getfield batchId_ : I
    //   468: invokeinterface visitInt : (ZIZI)I
    //   473: putfield batchId_ : I
    //   476: aload_0
    //   477: aload_1
    //   478: aload_0
    //   479: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   482: aload_2
    //   483: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   486: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   491: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   494: aload_0
    //   495: aload_1
    //   496: aload_0
    //   497: getfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   500: aload_2
    //   501: getfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   504: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   509: checkcast com/google/protobuf/Timestamp
    //   512: putfield localWriteTime_ : Lcom/google/protobuf/Timestamp;
    //   515: aload_0
    //   516: aload_1
    //   517: aload_0
    //   518: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   521: aload_2
    //   522: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   525: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   530: putfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   533: aload_1
    //   534: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   537: if_acmpne -> 553
    //   540: aload_0
    //   541: aload_0
    //   542: getfield bitField0_ : I
    //   545: aload_2
    //   546: getfield bitField0_ : I
    //   549: ior
    //   550: putfield bitField0_ : I
    //   553: aload_0
    //   554: areturn
    //   555: new com/google/firebase/firestore/proto/WriteBatch$Builder
    //   558: dup
    //   559: aconst_null
    //   560: invokespecial <init> : (Lcom/google/firebase/firestore/proto/WriteBatch$1;)V
    //   563: areturn
    //   564: aload_0
    //   565: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   568: invokeinterface makeImmutable : ()V
    //   573: aload_0
    //   574: getfield baseWrites_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   577: invokeinterface makeImmutable : ()V
    //   582: aconst_null
    //   583: areturn
    //   584: getstatic com/google/firebase/firestore/proto/WriteBatch.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/WriteBatch;
    //   587: areturn
    //   588: new com/google/firebase/firestore/proto/WriteBatch
    //   591: dup
    //   592: invokespecial <init> : ()V
    //   595: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	392	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	364	java/io/IOException
    //   133	139	360	finally
    //   172	181	392	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	364	java/io/IOException
    //   172	181	360	finally
    //   184	207	392	com/google/protobuf/InvalidProtocolBufferException
    //   184	207	364	java/io/IOException
    //   184	207	360	finally
    //   207	228	392	com/google/protobuf/InvalidProtocolBufferException
    //   207	228	364	java/io/IOException
    //   207	228	360	finally
    //   231	249	392	com/google/protobuf/InvalidProtocolBufferException
    //   231	249	364	java/io/IOException
    //   231	249	360	finally
    //   254	269	392	com/google/protobuf/InvalidProtocolBufferException
    //   254	269	364	java/io/IOException
    //   254	269	360	finally
    //   273	293	392	com/google/protobuf/InvalidProtocolBufferException
    //   273	293	364	java/io/IOException
    //   273	293	360	finally
    //   296	319	392	com/google/protobuf/InvalidProtocolBufferException
    //   296	319	364	java/io/IOException
    //   296	319	360	finally
    //   319	340	392	com/google/protobuf/InvalidProtocolBufferException
    //   319	340	364	java/io/IOException
    //   319	340	360	finally
    //   343	351	392	com/google/protobuf/InvalidProtocolBufferException
    //   343	351	364	java/io/IOException
    //   343	351	360	finally
    //   365	392	360	finally
    //   393	408	360	finally
  }
  
  public Write getBaseWrites(int paramInt) {
    return (Write)this.baseWrites_.get(paramInt);
  }
  
  public int getBaseWritesCount() {
    return this.baseWrites_.size();
  }
  
  public List<Write> getBaseWritesList() {
    return (List<Write>)this.baseWrites_;
  }
  
  public WriteOrBuilder getBaseWritesOrBuilder(int paramInt) {
    return (WriteOrBuilder)this.baseWrites_.get(paramInt);
  }
  
  public List<? extends WriteOrBuilder> getBaseWritesOrBuilderList() {
    return (List)this.baseWrites_;
  }
  
  public int getBatchId() {
    return this.batchId_;
  }
  
  public Timestamp getLocalWriteTime() {
    Timestamp timestamp1 = this.localWriteTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = this.batchId_;
    byte b1 = 0;
    if (i != 0) {
      i = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j < this.writes_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.writes_.get(j)); 
    byte b2 = b1;
    j = i;
    if (this.localWriteTime_ != null) {
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getLocalWriteTime());
      b2 = b1;
    } 
    while (b2 < this.baseWrites_.size()) {
      j += CodedOutputStream.computeMessageSize(4, (MessageLite)this.baseWrites_.get(b2));
      b2++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Write getWrites(int paramInt) {
    return (Write)this.writes_.get(paramInt);
  }
  
  public int getWritesCount() {
    return this.writes_.size();
  }
  
  public List<Write> getWritesList() {
    return (List<Write>)this.writes_;
  }
  
  public WriteOrBuilder getWritesOrBuilder(int paramInt) {
    return (WriteOrBuilder)this.writes_.get(paramInt);
  }
  
  public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
    return (List)this.writes_;
  }
  
  public boolean hasLocalWriteTime() {
    boolean bool;
    if (this.localWriteTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.batchId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    boolean bool = false;
    for (i = 0; i < this.writes_.size(); i++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.writes_.get(i)); 
    i = bool;
    if (this.localWriteTime_ != null) {
      paramCodedOutputStream.writeMessage(3, (MessageLite)getLocalWriteTime());
      i = bool;
    } 
    while (i < this.baseWrites_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.baseWrites_.get(i));
      i++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<WriteBatch, Builder> implements WriteBatchOrBuilder {
    private Builder() {
      super(WriteBatch.DEFAULT_INSTANCE);
    }
    
    public Builder addAllBaseWrites(Iterable<? extends Write> param1Iterable) {
      copyOnWrite();
      ((WriteBatch)this.instance).addAllBaseWrites(param1Iterable);
      return this;
    }
    
    public Builder addAllWrites(Iterable<? extends Write> param1Iterable) {
      copyOnWrite();
      ((WriteBatch)this.instance).addAllWrites(param1Iterable);
      return this;
    }
    
    public Builder addBaseWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).addBaseWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder addBaseWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).addBaseWrites(param1Int, param1Write);
      return this;
    }
    
    public Builder addBaseWrites(Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).addBaseWrites(param1Builder);
      return this;
    }
    
    public Builder addBaseWrites(Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).addBaseWrites(param1Write);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).addWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).addWrites(param1Int, param1Write);
      return this;
    }
    
    public Builder addWrites(Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).addWrites(param1Builder);
      return this;
    }
    
    public Builder addWrites(Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).addWrites(param1Write);
      return this;
    }
    
    public Builder clearBaseWrites() {
      copyOnWrite();
      ((WriteBatch)this.instance).clearBaseWrites();
      return this;
    }
    
    public Builder clearBatchId() {
      copyOnWrite();
      ((WriteBatch)this.instance).clearBatchId();
      return this;
    }
    
    public Builder clearLocalWriteTime() {
      copyOnWrite();
      ((WriteBatch)this.instance).clearLocalWriteTime();
      return this;
    }
    
    public Builder clearWrites() {
      copyOnWrite();
      ((WriteBatch)this.instance).clearWrites();
      return this;
    }
    
    public Write getBaseWrites(int param1Int) {
      return ((WriteBatch)this.instance).getBaseWrites(param1Int);
    }
    
    public int getBaseWritesCount() {
      return ((WriteBatch)this.instance).getBaseWritesCount();
    }
    
    public List<Write> getBaseWritesList() {
      return Collections.unmodifiableList(((WriteBatch)this.instance).getBaseWritesList());
    }
    
    public int getBatchId() {
      return ((WriteBatch)this.instance).getBatchId();
    }
    
    public Timestamp getLocalWriteTime() {
      return ((WriteBatch)this.instance).getLocalWriteTime();
    }
    
    public Write getWrites(int param1Int) {
      return ((WriteBatch)this.instance).getWrites(param1Int);
    }
    
    public int getWritesCount() {
      return ((WriteBatch)this.instance).getWritesCount();
    }
    
    public List<Write> getWritesList() {
      return Collections.unmodifiableList(((WriteBatch)this.instance).getWritesList());
    }
    
    public boolean hasLocalWriteTime() {
      return ((WriteBatch)this.instance).hasLocalWriteTime();
    }
    
    public Builder mergeLocalWriteTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteBatch)this.instance).mergeLocalWriteTime(param1Timestamp);
      return this;
    }
    
    public Builder removeBaseWrites(int param1Int) {
      copyOnWrite();
      ((WriteBatch)this.instance).removeBaseWrites(param1Int);
      return this;
    }
    
    public Builder removeWrites(int param1Int) {
      copyOnWrite();
      ((WriteBatch)this.instance).removeWrites(param1Int);
      return this;
    }
    
    public Builder setBaseWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).setBaseWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder setBaseWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).setBaseWrites(param1Int, param1Write);
      return this;
    }
    
    public Builder setBatchId(int param1Int) {
      copyOnWrite();
      ((WriteBatch)this.instance).setBatchId(param1Int);
      return this;
    }
    
    public Builder setLocalWriteTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).setLocalWriteTime(param1Builder);
      return this;
    }
    
    public Builder setLocalWriteTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteBatch)this.instance).setLocalWriteTime(param1Timestamp);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteBatch)this.instance).setWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteBatch)this.instance).setWrites(param1Int, param1Write);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\WriteBatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */