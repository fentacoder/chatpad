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

public final class Write extends GeneratedMessageLite<Write, Write.Builder> implements WriteOrBuilder {
  public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
  
  private static final Write DEFAULT_INSTANCE = new Write();
  
  public static final int DELETE_FIELD_NUMBER = 2;
  
  private static volatile Parser<Write> PARSER;
  
  public static final int TRANSFORM_FIELD_NUMBER = 6;
  
  public static final int UPDATE_FIELD_NUMBER = 1;
  
  public static final int UPDATE_MASK_FIELD_NUMBER = 3;
  
  private Precondition currentDocument_;
  
  private int operationCase_ = 0;
  
  private Object operation_;
  
  private DocumentMask updateMask_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCurrentDocument() {
    this.currentDocument_ = null;
  }
  
  private void clearDelete() {
    if (this.operationCase_ == 2) {
      this.operationCase_ = 0;
      this.operation_ = null;
    } 
  }
  
  private void clearOperation() {
    this.operationCase_ = 0;
    this.operation_ = null;
  }
  
  private void clearTransform() {
    if (this.operationCase_ == 6) {
      this.operationCase_ = 0;
      this.operation_ = null;
    } 
  }
  
  private void clearUpdate() {
    if (this.operationCase_ == 1) {
      this.operationCase_ = 0;
      this.operation_ = null;
    } 
  }
  
  private void clearUpdateMask() {
    this.updateMask_ = null;
  }
  
  public static Write getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCurrentDocument(Precondition paramPrecondition) {
    Precondition precondition = this.currentDocument_;
    if (precondition != null && precondition != Precondition.getDefaultInstance()) {
      this.currentDocument_ = (Precondition)((Precondition.Builder)Precondition.newBuilder(this.currentDocument_).mergeFrom(paramPrecondition)).buildPartial();
    } else {
      this.currentDocument_ = paramPrecondition;
    } 
  }
  
  private void mergeTransform(DocumentTransform paramDocumentTransform) {
    if (this.operationCase_ == 6 && this.operation_ != DocumentTransform.getDefaultInstance()) {
      this.operation_ = ((DocumentTransform.Builder)DocumentTransform.newBuilder((DocumentTransform)this.operation_).mergeFrom(paramDocumentTransform)).buildPartial();
    } else {
      this.operation_ = paramDocumentTransform;
    } 
    this.operationCase_ = 6;
  }
  
  private void mergeUpdate(Document paramDocument) {
    if (this.operationCase_ == 1 && this.operation_ != Document.getDefaultInstance()) {
      this.operation_ = ((Document.Builder)Document.newBuilder((Document)this.operation_).mergeFrom(paramDocument)).buildPartial();
    } else {
      this.operation_ = paramDocument;
    } 
    this.operationCase_ = 1;
  }
  
  private void mergeUpdateMask(DocumentMask paramDocumentMask) {
    DocumentMask documentMask = this.updateMask_;
    if (documentMask != null && documentMask != DocumentMask.getDefaultInstance()) {
      this.updateMask_ = (DocumentMask)((DocumentMask.Builder)DocumentMask.newBuilder(this.updateMask_).mergeFrom(paramDocumentMask)).buildPartial();
    } else {
      this.updateMask_ = paramDocumentMask;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Write paramWrite) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWrite);
  }
  
  public static Write parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Write)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Write parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Write)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Write parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Write parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Write parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Write parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Write parseFrom(InputStream paramInputStream) throws IOException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Write parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Write parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Write parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Write)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Write> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCurrentDocument(Precondition.Builder paramBuilder) {
    this.currentDocument_ = (Precondition)paramBuilder.build();
  }
  
  private void setCurrentDocument(Precondition paramPrecondition) {
    if (paramPrecondition != null) {
      this.currentDocument_ = paramPrecondition;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDelete(String paramString) {
    if (paramString != null) {
      this.operationCase_ = 2;
      this.operation_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDeleteBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.operationCase_ = 2;
      this.operation_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransform(DocumentTransform.Builder paramBuilder) {
    this.operation_ = paramBuilder.build();
    this.operationCase_ = 6;
  }
  
  private void setTransform(DocumentTransform paramDocumentTransform) {
    if (paramDocumentTransform != null) {
      this.operation_ = paramDocumentTransform;
      this.operationCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUpdate(Document.Builder paramBuilder) {
    this.operation_ = paramBuilder.build();
    this.operationCase_ = 1;
  }
  
  private void setUpdate(Document paramDocument) {
    if (paramDocument != null) {
      this.operation_ = paramDocument;
      this.operationCase_ = 1;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUpdateMask(DocumentMask.Builder paramBuilder) {
    this.updateMask_ = (DocumentMask)paramBuilder.build();
  }
  
  private void setUpdateMask(DocumentMask paramDocumentMask) {
    if (paramDocumentMask != null) {
      this.updateMask_ = paramDocumentMask;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/Write$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   27: tableswitch default -> 72, 1 -> 817, 2 -> 813, 3 -> 811, 4 -> 802, 5 -> 551, 6 -> 126, 7 -> 547, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/Write.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/Write
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/Write.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/Write.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Write;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/Write.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/Write
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/Write
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/Write.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #9
    //   138: ifne -> 547
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 491
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 420
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 402
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 337
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 272
    //   180: iload #4
    //   182: bipush #50
    //   184: if_icmpeq -> 199
    //   187: aload_2
    //   188: iload #4
    //   190: invokevirtual skipField : (I)Z
    //   193: ifne -> 136
    //   196: goto -> 491
    //   199: aload_0
    //   200: getfield operationCase_ : I
    //   203: bipush #6
    //   205: if_icmpne -> 225
    //   208: aload_0
    //   209: getfield operation_ : Ljava/lang/Object;
    //   212: checkcast com/google/firestore/v1/DocumentTransform
    //   215: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   218: checkcast com/google/firestore/v1/DocumentTransform$Builder
    //   221: astore_1
    //   222: goto -> 227
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_0
    //   228: aload_2
    //   229: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   232: aload_3
    //   233: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   236: putfield operation_ : Ljava/lang/Object;
    //   239: aload_1
    //   240: ifnull -> 263
    //   243: aload_1
    //   244: aload_0
    //   245: getfield operation_ : Ljava/lang/Object;
    //   248: checkcast com/google/firestore/v1/DocumentTransform
    //   251: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   254: pop
    //   255: aload_0
    //   256: aload_1
    //   257: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   260: putfield operation_ : Ljava/lang/Object;
    //   263: aload_0
    //   264: bipush #6
    //   266: putfield operationCase_ : I
    //   269: goto -> 136
    //   272: aload_0
    //   273: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   276: ifnull -> 293
    //   279: aload_0
    //   280: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   283: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   286: checkcast com/google/firestore/v1/Precondition$Builder
    //   289: astore_1
    //   290: goto -> 295
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_0
    //   296: aload_2
    //   297: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   300: aload_3
    //   301: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   304: checkcast com/google/firestore/v1/Precondition
    //   307: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   310: aload_1
    //   311: ifnull -> 136
    //   314: aload_1
    //   315: aload_0
    //   316: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   319: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   322: pop
    //   323: aload_0
    //   324: aload_1
    //   325: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   328: checkcast com/google/firestore/v1/Precondition
    //   331: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   334: goto -> 136
    //   337: aload_0
    //   338: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   341: ifnull -> 358
    //   344: aload_0
    //   345: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   348: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   351: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   354: astore_1
    //   355: goto -> 360
    //   358: aconst_null
    //   359: astore_1
    //   360: aload_0
    //   361: aload_2
    //   362: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   365: aload_3
    //   366: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   369: checkcast com/google/firestore/v1/DocumentMask
    //   372: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   375: aload_1
    //   376: ifnull -> 136
    //   379: aload_1
    //   380: aload_0
    //   381: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   384: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   387: pop
    //   388: aload_0
    //   389: aload_1
    //   390: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   393: checkcast com/google/firestore/v1/DocumentMask
    //   396: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   399: goto -> 136
    //   402: aload_2
    //   403: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   406: astore_1
    //   407: aload_0
    //   408: iconst_2
    //   409: putfield operationCase_ : I
    //   412: aload_0
    //   413: aload_1
    //   414: putfield operation_ : Ljava/lang/Object;
    //   417: goto -> 136
    //   420: aload_0
    //   421: getfield operationCase_ : I
    //   424: iconst_1
    //   425: if_icmpne -> 445
    //   428: aload_0
    //   429: getfield operation_ : Ljava/lang/Object;
    //   432: checkcast com/google/firestore/v1/Document
    //   435: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   438: checkcast com/google/firestore/v1/Document$Builder
    //   441: astore_1
    //   442: goto -> 447
    //   445: aconst_null
    //   446: astore_1
    //   447: aload_0
    //   448: aload_2
    //   449: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   452: aload_3
    //   453: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   456: putfield operation_ : Ljava/lang/Object;
    //   459: aload_1
    //   460: ifnull -> 483
    //   463: aload_1
    //   464: aload_0
    //   465: getfield operation_ : Ljava/lang/Object;
    //   468: checkcast com/google/firestore/v1/Document
    //   471: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   474: pop
    //   475: aload_0
    //   476: aload_1
    //   477: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   480: putfield operation_ : Ljava/lang/Object;
    //   483: aload_0
    //   484: iconst_1
    //   485: putfield operationCase_ : I
    //   488: goto -> 136
    //   491: iconst_1
    //   492: istore #9
    //   494: goto -> 136
    //   497: astore_1
    //   498: goto -> 545
    //   501: astore_3
    //   502: new java/lang/RuntimeException
    //   505: astore_2
    //   506: new com/google/protobuf/InvalidProtocolBufferException
    //   509: astore_1
    //   510: aload_1
    //   511: aload_3
    //   512: invokevirtual getMessage : ()Ljava/lang/String;
    //   515: invokespecial <init> : (Ljava/lang/String;)V
    //   518: aload_2
    //   519: aload_1
    //   520: aload_0
    //   521: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   524: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   527: aload_2
    //   528: athrow
    //   529: astore_2
    //   530: new java/lang/RuntimeException
    //   533: astore_1
    //   534: aload_1
    //   535: aload_2
    //   536: aload_0
    //   537: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   540: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   543: aload_1
    //   544: athrow
    //   545: aload_1
    //   546: athrow
    //   547: getstatic com/google/firestore/v1/Write.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Write;
    //   550: areturn
    //   551: aload_2
    //   552: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   555: astore_1
    //   556: aload_3
    //   557: checkcast com/google/firestore/v1/Write
    //   560: astore_2
    //   561: aload_0
    //   562: aload_1
    //   563: aload_0
    //   564: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   567: aload_2
    //   568: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   571: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   576: checkcast com/google/firestore/v1/DocumentMask
    //   579: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   582: aload_0
    //   583: aload_1
    //   584: aload_0
    //   585: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   588: aload_2
    //   589: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   592: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   597: checkcast com/google/firestore/v1/Precondition
    //   600: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   603: getstatic com/google/firestore/v1/Write$1.$SwitchMap$com$google$firestore$v1$Write$OperationCase : [I
    //   606: aload_2
    //   607: invokevirtual getOperationCase : ()Lcom/google/firestore/v1/Write$OperationCase;
    //   610: invokevirtual ordinal : ()I
    //   613: iaload
    //   614: istore #9
    //   616: iload #9
    //   618: iconst_1
    //   619: if_icmpeq -> 741
    //   622: iload #9
    //   624: iconst_2
    //   625: if_icmpeq -> 703
    //   628: iload #9
    //   630: iconst_3
    //   631: if_icmpeq -> 664
    //   634: iload #9
    //   636: iconst_4
    //   637: if_icmpeq -> 643
    //   640: goto -> 776
    //   643: aload_0
    //   644: getfield operationCase_ : I
    //   647: ifeq -> 653
    //   650: iconst_1
    //   651: istore #5
    //   653: aload_1
    //   654: iload #5
    //   656: invokeinterface visitOneofNotSet : (Z)V
    //   661: goto -> 776
    //   664: iload #6
    //   666: istore #5
    //   668: aload_0
    //   669: getfield operationCase_ : I
    //   672: bipush #6
    //   674: if_icmpne -> 680
    //   677: iconst_1
    //   678: istore #5
    //   680: aload_0
    //   681: aload_1
    //   682: iload #5
    //   684: aload_0
    //   685: getfield operation_ : Ljava/lang/Object;
    //   688: aload_2
    //   689: getfield operation_ : Ljava/lang/Object;
    //   692: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   697: putfield operation_ : Ljava/lang/Object;
    //   700: goto -> 776
    //   703: iload #7
    //   705: istore #5
    //   707: aload_0
    //   708: getfield operationCase_ : I
    //   711: iconst_2
    //   712: if_icmpne -> 718
    //   715: iconst_1
    //   716: istore #5
    //   718: aload_0
    //   719: aload_1
    //   720: iload #5
    //   722: aload_0
    //   723: getfield operation_ : Ljava/lang/Object;
    //   726: aload_2
    //   727: getfield operation_ : Ljava/lang/Object;
    //   730: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: putfield operation_ : Ljava/lang/Object;
    //   738: goto -> 776
    //   741: iload #8
    //   743: istore #5
    //   745: aload_0
    //   746: getfield operationCase_ : I
    //   749: iconst_1
    //   750: if_icmpne -> 756
    //   753: iconst_1
    //   754: istore #5
    //   756: aload_0
    //   757: aload_1
    //   758: iload #5
    //   760: aload_0
    //   761: getfield operation_ : Ljava/lang/Object;
    //   764: aload_2
    //   765: getfield operation_ : Ljava/lang/Object;
    //   768: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   773: putfield operation_ : Ljava/lang/Object;
    //   776: aload_1
    //   777: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   780: if_acmpne -> 800
    //   783: aload_2
    //   784: getfield operationCase_ : I
    //   787: istore #9
    //   789: iload #9
    //   791: ifeq -> 800
    //   794: aload_0
    //   795: iload #9
    //   797: putfield operationCase_ : I
    //   800: aload_0
    //   801: areturn
    //   802: new com/google/firestore/v1/Write$Builder
    //   805: dup
    //   806: aconst_null
    //   807: invokespecial <init> : (Lcom/google/firestore/v1/Write$1;)V
    //   810: areturn
    //   811: aconst_null
    //   812: areturn
    //   813: getstatic com/google/firestore/v1/Write.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Write;
    //   816: areturn
    //   817: new com/google/firestore/v1/Write
    //   820: dup
    //   821: invokespecial <init> : ()V
    //   824: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	529	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	501	java/io/IOException
    //   141	147	497	finally
    //   187	196	529	com/google/protobuf/InvalidProtocolBufferException
    //   187	196	501	java/io/IOException
    //   187	196	497	finally
    //   199	222	529	com/google/protobuf/InvalidProtocolBufferException
    //   199	222	501	java/io/IOException
    //   199	222	497	finally
    //   227	239	529	com/google/protobuf/InvalidProtocolBufferException
    //   227	239	501	java/io/IOException
    //   227	239	497	finally
    //   243	263	529	com/google/protobuf/InvalidProtocolBufferException
    //   243	263	501	java/io/IOException
    //   243	263	497	finally
    //   263	269	529	com/google/protobuf/InvalidProtocolBufferException
    //   263	269	501	java/io/IOException
    //   263	269	497	finally
    //   272	290	529	com/google/protobuf/InvalidProtocolBufferException
    //   272	290	501	java/io/IOException
    //   272	290	497	finally
    //   295	310	529	com/google/protobuf/InvalidProtocolBufferException
    //   295	310	501	java/io/IOException
    //   295	310	497	finally
    //   314	334	529	com/google/protobuf/InvalidProtocolBufferException
    //   314	334	501	java/io/IOException
    //   314	334	497	finally
    //   337	355	529	com/google/protobuf/InvalidProtocolBufferException
    //   337	355	501	java/io/IOException
    //   337	355	497	finally
    //   360	375	529	com/google/protobuf/InvalidProtocolBufferException
    //   360	375	501	java/io/IOException
    //   360	375	497	finally
    //   379	399	529	com/google/protobuf/InvalidProtocolBufferException
    //   379	399	501	java/io/IOException
    //   379	399	497	finally
    //   402	417	529	com/google/protobuf/InvalidProtocolBufferException
    //   402	417	501	java/io/IOException
    //   402	417	497	finally
    //   420	442	529	com/google/protobuf/InvalidProtocolBufferException
    //   420	442	501	java/io/IOException
    //   420	442	497	finally
    //   447	459	529	com/google/protobuf/InvalidProtocolBufferException
    //   447	459	501	java/io/IOException
    //   447	459	497	finally
    //   463	483	529	com/google/protobuf/InvalidProtocolBufferException
    //   463	483	501	java/io/IOException
    //   463	483	497	finally
    //   483	488	529	com/google/protobuf/InvalidProtocolBufferException
    //   483	488	501	java/io/IOException
    //   483	488	497	finally
    //   502	529	497	finally
    //   530	545	497	finally
  }
  
  public Precondition getCurrentDocument() {
    Precondition precondition1 = this.currentDocument_;
    Precondition precondition2 = precondition1;
    if (precondition1 == null)
      precondition2 = Precondition.getDefaultInstance(); 
    return precondition2;
  }
  
  public String getDelete() {
    String str;
    if (this.operationCase_ == 2) {
      str = (String)this.operation_;
    } else {
      str = "";
    } 
    return str;
  }
  
  public ByteString getDeleteBytes() {
    String str;
    if (this.operationCase_ == 2) {
      str = (String)this.operation_;
    } else {
      str = "";
    } 
    return ByteString.copyFromUtf8(str);
  }
  
  public OperationCase getOperationCase() {
    return OperationCase.forNumber(this.operationCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (this.operationCase_ == 1)
      j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.operation_); 
    i = j;
    if (this.operationCase_ == 2)
      i = j + CodedOutputStream.computeStringSize(2, getDelete()); 
    j = i;
    if (this.updateMask_ != null)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getUpdateMask()); 
    i = j;
    if (this.currentDocument_ != null)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getCurrentDocument()); 
    j = i;
    if (this.operationCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.operation_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public DocumentTransform getTransform() {
    return (this.operationCase_ == 6) ? (DocumentTransform)this.operation_ : DocumentTransform.getDefaultInstance();
  }
  
  public Document getUpdate() {
    return (this.operationCase_ == 1) ? (Document)this.operation_ : Document.getDefaultInstance();
  }
  
  public DocumentMask getUpdateMask() {
    DocumentMask documentMask1 = this.updateMask_;
    DocumentMask documentMask2 = documentMask1;
    if (documentMask1 == null)
      documentMask2 = DocumentMask.getDefaultInstance(); 
    return documentMask2;
  }
  
  public boolean hasCurrentDocument() {
    boolean bool;
    if (this.currentDocument_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasUpdateMask() {
    boolean bool;
    if (this.updateMask_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.operationCase_ == 1)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.operation_); 
    if (this.operationCase_ == 2)
      paramCodedOutputStream.writeString(2, getDelete()); 
    if (this.updateMask_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getUpdateMask()); 
    if (this.currentDocument_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getCurrentDocument()); 
    if (this.operationCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.operation_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Write, Builder> implements WriteOrBuilder {
    private Builder() {
      super(Write.DEFAULT_INSTANCE);
    }
    
    public Builder clearCurrentDocument() {
      copyOnWrite();
      ((Write)this.instance).clearCurrentDocument();
      return this;
    }
    
    public Builder clearDelete() {
      copyOnWrite();
      ((Write)this.instance).clearDelete();
      return this;
    }
    
    public Builder clearOperation() {
      copyOnWrite();
      ((Write)this.instance).clearOperation();
      return this;
    }
    
    public Builder clearTransform() {
      copyOnWrite();
      ((Write)this.instance).clearTransform();
      return this;
    }
    
    public Builder clearUpdate() {
      copyOnWrite();
      ((Write)this.instance).clearUpdate();
      return this;
    }
    
    public Builder clearUpdateMask() {
      copyOnWrite();
      ((Write)this.instance).clearUpdateMask();
      return this;
    }
    
    public Precondition getCurrentDocument() {
      return ((Write)this.instance).getCurrentDocument();
    }
    
    public String getDelete() {
      return ((Write)this.instance).getDelete();
    }
    
    public ByteString getDeleteBytes() {
      return ((Write)this.instance).getDeleteBytes();
    }
    
    public Write.OperationCase getOperationCase() {
      return ((Write)this.instance).getOperationCase();
    }
    
    public DocumentTransform getTransform() {
      return ((Write)this.instance).getTransform();
    }
    
    public Document getUpdate() {
      return ((Write)this.instance).getUpdate();
    }
    
    public DocumentMask getUpdateMask() {
      return ((Write)this.instance).getUpdateMask();
    }
    
    public boolean hasCurrentDocument() {
      return ((Write)this.instance).hasCurrentDocument();
    }
    
    public boolean hasUpdateMask() {
      return ((Write)this.instance).hasUpdateMask();
    }
    
    public Builder mergeCurrentDocument(Precondition param1Precondition) {
      copyOnWrite();
      ((Write)this.instance).mergeCurrentDocument(param1Precondition);
      return this;
    }
    
    public Builder mergeTransform(DocumentTransform param1DocumentTransform) {
      copyOnWrite();
      ((Write)this.instance).mergeTransform(param1DocumentTransform);
      return this;
    }
    
    public Builder mergeUpdate(Document param1Document) {
      copyOnWrite();
      ((Write)this.instance).mergeUpdate(param1Document);
      return this;
    }
    
    public Builder mergeUpdateMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((Write)this.instance).mergeUpdateMask(param1DocumentMask);
      return this;
    }
    
    public Builder setCurrentDocument(Precondition.Builder param1Builder) {
      copyOnWrite();
      ((Write)this.instance).setCurrentDocument(param1Builder);
      return this;
    }
    
    public Builder setCurrentDocument(Precondition param1Precondition) {
      copyOnWrite();
      ((Write)this.instance).setCurrentDocument(param1Precondition);
      return this;
    }
    
    public Builder setDelete(String param1String) {
      copyOnWrite();
      ((Write)this.instance).setDelete(param1String);
      return this;
    }
    
    public Builder setDeleteBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Write)this.instance).setDeleteBytes(param1ByteString);
      return this;
    }
    
    public Builder setTransform(DocumentTransform.Builder param1Builder) {
      copyOnWrite();
      ((Write)this.instance).setTransform(param1Builder);
      return this;
    }
    
    public Builder setTransform(DocumentTransform param1DocumentTransform) {
      copyOnWrite();
      ((Write)this.instance).setTransform(param1DocumentTransform);
      return this;
    }
    
    public Builder setUpdate(Document.Builder param1Builder) {
      copyOnWrite();
      ((Write)this.instance).setUpdate(param1Builder);
      return this;
    }
    
    public Builder setUpdate(Document param1Document) {
      copyOnWrite();
      ((Write)this.instance).setUpdate(param1Document);
      return this;
    }
    
    public Builder setUpdateMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((Write)this.instance).setUpdateMask(param1Builder);
      return this;
    }
    
    public Builder setUpdateMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((Write)this.instance).setUpdateMask(param1DocumentMask);
      return this;
    }
  }
  
  public enum OperationCase implements Internal.EnumLite {
    DELETE,
    OPERATION_NOT_SET,
    TRANSFORM,
    UPDATE(1);
    
    private final int value;
    
    static {
      OPERATION_NOT_SET = new OperationCase("OPERATION_NOT_SET", 3, 0);
      $VALUES = new OperationCase[] { UPDATE, DELETE, TRANSFORM, OPERATION_NOT_SET };
    }
    
    OperationCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OperationCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 6) ? null : TRANSFORM) : DELETE) : UPDATE) : OPERATION_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Write.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */