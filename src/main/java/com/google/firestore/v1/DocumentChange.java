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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DocumentChange extends GeneratedMessageLite<DocumentChange, DocumentChange.Builder> implements DocumentChangeOrBuilder {
  private static final DocumentChange DEFAULT_INSTANCE = new DocumentChange();
  
  public static final int DOCUMENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<DocumentChange> PARSER;
  
  public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
  
  public static final int TARGET_IDS_FIELD_NUMBER = 5;
  
  private int bitField0_;
  
  private Document document_;
  
  private Internal.IntList removedTargetIds_ = emptyIntList();
  
  private Internal.IntList targetIds_ = emptyIntList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRemovedTargetIds(Iterable<? extends Integer> paramIterable) {
    ensureRemovedTargetIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.removedTargetIds_);
  }
  
  private void addAllTargetIds(Iterable<? extends Integer> paramIterable) {
    ensureTargetIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.targetIds_);
  }
  
  private void addRemovedTargetIds(int paramInt) {
    ensureRemovedTargetIdsIsMutable();
    this.removedTargetIds_.addInt(paramInt);
  }
  
  private void addTargetIds(int paramInt) {
    ensureTargetIdsIsMutable();
    this.targetIds_.addInt(paramInt);
  }
  
  private void clearDocument() {
    this.document_ = null;
  }
  
  private void clearRemovedTargetIds() {
    this.removedTargetIds_ = emptyIntList();
  }
  
  private void clearTargetIds() {
    this.targetIds_ = emptyIntList();
  }
  
  private void ensureRemovedTargetIdsIsMutable() {
    if (!this.removedTargetIds_.isModifiable())
      this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_); 
  }
  
  private void ensureTargetIdsIsMutable() {
    if (!this.targetIds_.isModifiable())
      this.targetIds_ = GeneratedMessageLite.mutableCopy(this.targetIds_); 
  }
  
  public static DocumentChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeDocument(Document paramDocument) {
    Document document = this.document_;
    if (document != null && document != Document.getDefaultInstance()) {
      this.document_ = (Document)((Document.Builder)Document.newBuilder(this.document_).mergeFrom(paramDocument)).buildPartial();
    } else {
      this.document_ = paramDocument;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DocumentChange paramDocumentChange) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocumentChange);
  }
  
  public static DocumentChange parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DocumentChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentChange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentChange)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentChange parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DocumentChange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DocumentChange parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DocumentChange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentChange parseFrom(InputStream paramInputStream) throws IOException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentChange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentChange parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DocumentChange parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentChange)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DocumentChange> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDocument(Document.Builder paramBuilder) {
    this.document_ = (Document)paramBuilder.build();
  }
  
  private void setDocument(Document paramDocument) {
    if (paramDocument != null) {
      this.document_ = paramDocument;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRemovedTargetIds(int paramInt1, int paramInt2) {
    ensureRemovedTargetIdsIsMutable();
    this.removedTargetIds_.setInt(paramInt1, paramInt2);
  }
  
  private void setTargetIds(int paramInt1, int paramInt2) {
    ensureTargetIdsIsMutable();
    this.targetIds_.setInt(paramInt1, paramInt2);
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/DocumentChange$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 655, 2 -> 651, 3 -> 631, 4 -> 622, 5 -> 533, 6 -> 110, 7 -> 529, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/DocumentChange.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/DocumentChange
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/DocumentChange.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/DocumentChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentChange;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/DocumentChange.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/DocumentChange
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/DocumentChange
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/DocumentChange.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_2
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 529
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 473
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 408
    //   146: iload #5
    //   148: bipush #40
    //   150: if_icmpeq -> 369
    //   153: iload #5
    //   155: bipush #42
    //   157: if_icmpeq -> 297
    //   160: iload #5
    //   162: bipush #48
    //   164: if_icmpeq -> 258
    //   167: iload #5
    //   169: bipush #50
    //   171: if_icmpeq -> 186
    //   174: aload_2
    //   175: iload #5
    //   177: invokevirtual skipField : (I)Z
    //   180: ifne -> 123
    //   183: goto -> 473
    //   186: aload_2
    //   187: aload_2
    //   188: invokevirtual readRawVarint32 : ()I
    //   191: invokevirtual pushLimit : (I)I
    //   194: istore #5
    //   196: aload_0
    //   197: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   200: invokeinterface isModifiable : ()Z
    //   205: ifne -> 226
    //   208: aload_2
    //   209: invokevirtual getBytesUntilLimit : ()I
    //   212: ifle -> 226
    //   215: aload_0
    //   216: aload_0
    //   217: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   220: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   223: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   226: aload_2
    //   227: invokevirtual getBytesUntilLimit : ()I
    //   230: ifle -> 249
    //   233: aload_0
    //   234: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   237: aload_2
    //   238: invokevirtual readInt32 : ()I
    //   241: invokeinterface addInt : (I)V
    //   246: goto -> 226
    //   249: aload_2
    //   250: iload #5
    //   252: invokevirtual popLimit : (I)V
    //   255: goto -> 123
    //   258: aload_0
    //   259: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   262: invokeinterface isModifiable : ()Z
    //   267: ifne -> 281
    //   270: aload_0
    //   271: aload_0
    //   272: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   275: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   278: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   281: aload_0
    //   282: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   285: aload_2
    //   286: invokevirtual readInt32 : ()I
    //   289: invokeinterface addInt : (I)V
    //   294: goto -> 123
    //   297: aload_2
    //   298: aload_2
    //   299: invokevirtual readRawVarint32 : ()I
    //   302: invokevirtual pushLimit : (I)I
    //   305: istore #5
    //   307: aload_0
    //   308: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   311: invokeinterface isModifiable : ()Z
    //   316: ifne -> 337
    //   319: aload_2
    //   320: invokevirtual getBytesUntilLimit : ()I
    //   323: ifle -> 337
    //   326: aload_0
    //   327: aload_0
    //   328: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   331: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   334: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   337: aload_2
    //   338: invokevirtual getBytesUntilLimit : ()I
    //   341: ifle -> 360
    //   344: aload_0
    //   345: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   348: aload_2
    //   349: invokevirtual readInt32 : ()I
    //   352: invokeinterface addInt : (I)V
    //   357: goto -> 337
    //   360: aload_2
    //   361: iload #5
    //   363: invokevirtual popLimit : (I)V
    //   366: goto -> 123
    //   369: aload_0
    //   370: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   373: invokeinterface isModifiable : ()Z
    //   378: ifne -> 392
    //   381: aload_0
    //   382: aload_0
    //   383: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   386: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   389: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   392: aload_0
    //   393: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   396: aload_2
    //   397: invokevirtual readInt32 : ()I
    //   400: invokeinterface addInt : (I)V
    //   405: goto -> 123
    //   408: aload_0
    //   409: getfield document_ : Lcom/google/firestore/v1/Document;
    //   412: ifnull -> 429
    //   415: aload_0
    //   416: getfield document_ : Lcom/google/firestore/v1/Document;
    //   419: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   422: checkcast com/google/firestore/v1/Document$Builder
    //   425: astore_1
    //   426: goto -> 431
    //   429: aconst_null
    //   430: astore_1
    //   431: aload_0
    //   432: aload_2
    //   433: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   436: aload_3
    //   437: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   440: checkcast com/google/firestore/v1/Document
    //   443: putfield document_ : Lcom/google/firestore/v1/Document;
    //   446: aload_1
    //   447: ifnull -> 123
    //   450: aload_1
    //   451: aload_0
    //   452: getfield document_ : Lcom/google/firestore/v1/Document;
    //   455: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   464: checkcast com/google/firestore/v1/Document
    //   467: putfield document_ : Lcom/google/firestore/v1/Document;
    //   470: goto -> 123
    //   473: iconst_1
    //   474: istore #4
    //   476: goto -> 123
    //   479: astore_1
    //   480: goto -> 527
    //   483: astore_3
    //   484: new java/lang/RuntimeException
    //   487: astore_1
    //   488: new com/google/protobuf/InvalidProtocolBufferException
    //   491: astore_2
    //   492: aload_2
    //   493: aload_3
    //   494: invokevirtual getMessage : ()Ljava/lang/String;
    //   497: invokespecial <init> : (Ljava/lang/String;)V
    //   500: aload_1
    //   501: aload_2
    //   502: aload_0
    //   503: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   506: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   509: aload_1
    //   510: athrow
    //   511: astore_1
    //   512: new java/lang/RuntimeException
    //   515: astore_2
    //   516: aload_2
    //   517: aload_1
    //   518: aload_0
    //   519: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   522: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   525: aload_2
    //   526: athrow
    //   527: aload_1
    //   528: athrow
    //   529: getstatic com/google/firestore/v1/DocumentChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentChange;
    //   532: areturn
    //   533: aload_2
    //   534: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   537: astore_1
    //   538: aload_3
    //   539: checkcast com/google/firestore/v1/DocumentChange
    //   542: astore_2
    //   543: aload_0
    //   544: aload_1
    //   545: aload_0
    //   546: getfield document_ : Lcom/google/firestore/v1/Document;
    //   549: aload_2
    //   550: getfield document_ : Lcom/google/firestore/v1/Document;
    //   553: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   558: checkcast com/google/firestore/v1/Document
    //   561: putfield document_ : Lcom/google/firestore/v1/Document;
    //   564: aload_0
    //   565: aload_1
    //   566: aload_0
    //   567: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   570: aload_2
    //   571: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   574: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   579: putfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   582: aload_0
    //   583: aload_1
    //   584: aload_0
    //   585: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   588: aload_2
    //   589: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   592: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   597: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   600: aload_1
    //   601: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   604: if_acmpne -> 620
    //   607: aload_0
    //   608: aload_0
    //   609: getfield bitField0_ : I
    //   612: aload_2
    //   613: getfield bitField0_ : I
    //   616: ior
    //   617: putfield bitField0_ : I
    //   620: aload_0
    //   621: areturn
    //   622: new com/google/firestore/v1/DocumentChange$Builder
    //   625: dup
    //   626: aconst_null
    //   627: invokespecial <init> : (Lcom/google/firestore/v1/DocumentChange$1;)V
    //   630: areturn
    //   631: aload_0
    //   632: getfield targetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   635: invokeinterface makeImmutable : ()V
    //   640: aload_0
    //   641: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   644: invokeinterface makeImmutable : ()V
    //   649: aconst_null
    //   650: areturn
    //   651: getstatic com/google/firestore/v1/DocumentChange.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentChange;
    //   654: areturn
    //   655: new com/google/firestore/v1/DocumentChange
    //   658: dup
    //   659: invokespecial <init> : ()V
    //   662: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	511	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	483	java/io/IOException
    //   128	134	479	finally
    //   174	183	511	com/google/protobuf/InvalidProtocolBufferException
    //   174	183	483	java/io/IOException
    //   174	183	479	finally
    //   186	226	511	com/google/protobuf/InvalidProtocolBufferException
    //   186	226	483	java/io/IOException
    //   186	226	479	finally
    //   226	246	511	com/google/protobuf/InvalidProtocolBufferException
    //   226	246	483	java/io/IOException
    //   226	246	479	finally
    //   249	255	511	com/google/protobuf/InvalidProtocolBufferException
    //   249	255	483	java/io/IOException
    //   249	255	479	finally
    //   258	281	511	com/google/protobuf/InvalidProtocolBufferException
    //   258	281	483	java/io/IOException
    //   258	281	479	finally
    //   281	294	511	com/google/protobuf/InvalidProtocolBufferException
    //   281	294	483	java/io/IOException
    //   281	294	479	finally
    //   297	337	511	com/google/protobuf/InvalidProtocolBufferException
    //   297	337	483	java/io/IOException
    //   297	337	479	finally
    //   337	357	511	com/google/protobuf/InvalidProtocolBufferException
    //   337	357	483	java/io/IOException
    //   337	357	479	finally
    //   360	366	511	com/google/protobuf/InvalidProtocolBufferException
    //   360	366	483	java/io/IOException
    //   360	366	479	finally
    //   369	392	511	com/google/protobuf/InvalidProtocolBufferException
    //   369	392	483	java/io/IOException
    //   369	392	479	finally
    //   392	405	511	com/google/protobuf/InvalidProtocolBufferException
    //   392	405	483	java/io/IOException
    //   392	405	479	finally
    //   408	426	511	com/google/protobuf/InvalidProtocolBufferException
    //   408	426	483	java/io/IOException
    //   408	426	479	finally
    //   431	446	511	com/google/protobuf/InvalidProtocolBufferException
    //   431	446	483	java/io/IOException
    //   431	446	479	finally
    //   450	470	511	com/google/protobuf/InvalidProtocolBufferException
    //   450	470	483	java/io/IOException
    //   450	470	479	finally
    //   484	511	479	finally
    //   512	527	479	finally
  }
  
  public Document getDocument() {
    Document document1 = this.document_;
    Document document2 = document1;
    if (document1 == null)
      document2 = Document.getDefaultInstance(); 
    return document2;
  }
  
  public int getRemovedTargetIds(int paramInt) {
    return this.removedTargetIds_.getInt(paramInt);
  }
  
  public int getRemovedTargetIdsCount() {
    return this.removedTargetIds_.size();
  }
  
  public List<Integer> getRemovedTargetIdsList() {
    return (List<Integer>)this.removedTargetIds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    Document document = this.document_;
    byte b = 0;
    if (document != null) {
      i = CodedOutputStream.computeMessageSize(1, (MessageLite)getDocument()) + 0;
    } else {
      i = 0;
    } 
    int j = 0;
    int k = j;
    while (j < this.targetIds_.size()) {
      k += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(j));
      j++;
    } 
    int m = getTargetIdsList().size();
    j = 0;
    while (b < this.removedTargetIds_.size()) {
      j += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(b));
      b++;
    } 
    i = i + k + m * 1 + j + getRemovedTargetIdsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
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
  
  public boolean hasDocument() {
    boolean bool;
    if (this.document_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b3;
    getSerializedSize();
    if (this.document_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getDocument()); 
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.targetIds_.size()) {
        paramCodedOutputStream.writeInt32(5, this.targetIds_.getInt(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.removedTargetIds_.size()) {
      paramCodedOutputStream.writeInt32(6, this.removedTargetIds_.getInt(b3));
      b3++;
    } 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DocumentChange, Builder> implements DocumentChangeOrBuilder {
    private Builder() {
      super(DocumentChange.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRemovedTargetIds(Iterable<? extends Integer> param1Iterable) {
      copyOnWrite();
      ((DocumentChange)this.instance).addAllRemovedTargetIds(param1Iterable);
      return this;
    }
    
    public Builder addAllTargetIds(Iterable<? extends Integer> param1Iterable) {
      copyOnWrite();
      ((DocumentChange)this.instance).addAllTargetIds(param1Iterable);
      return this;
    }
    
    public Builder addRemovedTargetIds(int param1Int) {
      copyOnWrite();
      ((DocumentChange)this.instance).addRemovedTargetIds(param1Int);
      return this;
    }
    
    public Builder addTargetIds(int param1Int) {
      copyOnWrite();
      ((DocumentChange)this.instance).addTargetIds(param1Int);
      return this;
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((DocumentChange)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearRemovedTargetIds() {
      copyOnWrite();
      ((DocumentChange)this.instance).clearRemovedTargetIds();
      return this;
    }
    
    public Builder clearTargetIds() {
      copyOnWrite();
      ((DocumentChange)this.instance).clearTargetIds();
      return this;
    }
    
    public Document getDocument() {
      return ((DocumentChange)this.instance).getDocument();
    }
    
    public int getRemovedTargetIds(int param1Int) {
      return ((DocumentChange)this.instance).getRemovedTargetIds(param1Int);
    }
    
    public int getRemovedTargetIdsCount() {
      return ((DocumentChange)this.instance).getRemovedTargetIdsCount();
    }
    
    public List<Integer> getRemovedTargetIdsList() {
      return Collections.unmodifiableList(((DocumentChange)this.instance).getRemovedTargetIdsList());
    }
    
    public int getTargetIds(int param1Int) {
      return ((DocumentChange)this.instance).getTargetIds(param1Int);
    }
    
    public int getTargetIdsCount() {
      return ((DocumentChange)this.instance).getTargetIdsCount();
    }
    
    public List<Integer> getTargetIdsList() {
      return Collections.unmodifiableList(((DocumentChange)this.instance).getTargetIdsList());
    }
    
    public boolean hasDocument() {
      return ((DocumentChange)this.instance).hasDocument();
    }
    
    public Builder mergeDocument(Document param1Document) {
      copyOnWrite();
      ((DocumentChange)this.instance).mergeDocument(param1Document);
      return this;
    }
    
    public Builder setDocument(Document.Builder param1Builder) {
      copyOnWrite();
      ((DocumentChange)this.instance).setDocument(param1Builder);
      return this;
    }
    
    public Builder setDocument(Document param1Document) {
      copyOnWrite();
      ((DocumentChange)this.instance).setDocument(param1Document);
      return this;
    }
    
    public Builder setRemovedTargetIds(int param1Int1, int param1Int2) {
      copyOnWrite();
      ((DocumentChange)this.instance).setRemovedTargetIds(param1Int1, param1Int2);
      return this;
    }
    
    public Builder setTargetIds(int param1Int1, int param1Int2) {
      copyOnWrite();
      ((DocumentChange)this.instance).setTargetIds(param1Int1, param1Int2);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */