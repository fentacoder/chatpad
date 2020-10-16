package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Document;
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

public final class MaybeDocument extends GeneratedMessageLite<MaybeDocument, MaybeDocument.Builder> implements MaybeDocumentOrBuilder {
  private static final MaybeDocument DEFAULT_INSTANCE = new MaybeDocument();
  
  public static final int DOCUMENT_FIELD_NUMBER = 2;
  
  public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
  
  public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<MaybeDocument> PARSER;
  
  public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
  
  private int documentTypeCase_ = 0;
  
  private Object documentType_;
  
  private boolean hasCommittedMutations_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDocument() {
    if (this.documentTypeCase_ == 2) {
      this.documentTypeCase_ = 0;
      this.documentType_ = null;
    } 
  }
  
  private void clearDocumentType() {
    this.documentTypeCase_ = 0;
    this.documentType_ = null;
  }
  
  private void clearHasCommittedMutations() {
    this.hasCommittedMutations_ = false;
  }
  
  private void clearNoDocument() {
    if (this.documentTypeCase_ == 1) {
      this.documentTypeCase_ = 0;
      this.documentType_ = null;
    } 
  }
  
  private void clearUnknownDocument() {
    if (this.documentTypeCase_ == 3) {
      this.documentTypeCase_ = 0;
      this.documentType_ = null;
    } 
  }
  
  public static MaybeDocument getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeDocument(Document paramDocument) {
    if (this.documentTypeCase_ == 2 && this.documentType_ != Document.getDefaultInstance()) {
      this.documentType_ = ((Document.Builder)Document.newBuilder((Document)this.documentType_).mergeFrom((GeneratedMessageLite)paramDocument)).buildPartial();
    } else {
      this.documentType_ = paramDocument;
    } 
    this.documentTypeCase_ = 2;
  }
  
  private void mergeNoDocument(NoDocument paramNoDocument) {
    if (this.documentTypeCase_ == 1 && this.documentType_ != NoDocument.getDefaultInstance()) {
      this.documentType_ = ((NoDocument.Builder)NoDocument.newBuilder((NoDocument)this.documentType_).mergeFrom(paramNoDocument)).buildPartial();
    } else {
      this.documentType_ = paramNoDocument;
    } 
    this.documentTypeCase_ = 1;
  }
  
  private void mergeUnknownDocument(UnknownDocument paramUnknownDocument) {
    if (this.documentTypeCase_ == 3 && this.documentType_ != UnknownDocument.getDefaultInstance()) {
      this.documentType_ = ((UnknownDocument.Builder)UnknownDocument.newBuilder((UnknownDocument)this.documentType_).mergeFrom(paramUnknownDocument)).buildPartial();
    } else {
      this.documentType_ = paramUnknownDocument;
    } 
    this.documentTypeCase_ = 3;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MaybeDocument paramMaybeDocument) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMaybeDocument);
  }
  
  public static MaybeDocument parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MaybeDocument)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MaybeDocument parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MaybeDocument)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MaybeDocument parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MaybeDocument parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MaybeDocument parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MaybeDocument parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MaybeDocument parseFrom(InputStream paramInputStream) throws IOException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MaybeDocument parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MaybeDocument parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MaybeDocument parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MaybeDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MaybeDocument> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDocument(Document.Builder paramBuilder) {
    this.documentType_ = paramBuilder.build();
    this.documentTypeCase_ = 2;
  }
  
  private void setDocument(Document paramDocument) {
    if (paramDocument != null) {
      this.documentType_ = paramDocument;
      this.documentTypeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setHasCommittedMutations(boolean paramBoolean) {
    this.hasCommittedMutations_ = paramBoolean;
  }
  
  private void setNoDocument(NoDocument.Builder paramBuilder) {
    this.documentType_ = paramBuilder.build();
    this.documentTypeCase_ = 1;
  }
  
  private void setNoDocument(NoDocument paramNoDocument) {
    if (paramNoDocument != null) {
      this.documentType_ = paramNoDocument;
      this.documentTypeCase_ = 1;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUnknownDocument(UnknownDocument.Builder paramBuilder) {
    this.documentType_ = paramBuilder.build();
    this.documentTypeCase_ = 3;
  }
  
  private void setUnknownDocument(UnknownDocument paramUnknownDocument) {
    if (paramUnknownDocument != null) {
      this.documentType_ = paramUnknownDocument;
      this.documentTypeCase_ = 3;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/MaybeDocument$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   27: tableswitch default -> 72, 1 -> 729, 2 -> 725, 3 -> 723, 4 -> 714, 5 -> 476, 6 -> 126, 7 -> 472, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firebase/firestore/proto/MaybeDocument.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firebase/firestore/proto/MaybeDocument
    //   88: monitorenter
    //   89: getstatic com/google/firebase/firestore/proto/MaybeDocument.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firebase/firestore/proto/MaybeDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MaybeDocument;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firebase/firestore/proto/MaybeDocument.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firebase/firestore/proto/MaybeDocument
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firebase/firestore/proto/MaybeDocument
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firebase/firestore/proto/MaybeDocument.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #9
    //   138: ifne -> 472
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 416
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 345
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 274
    //   166: iload #4
    //   168: bipush #26
    //   170: if_icmpeq -> 203
    //   173: iload #4
    //   175: bipush #32
    //   177: if_icmpeq -> 192
    //   180: aload_2
    //   181: iload #4
    //   183: invokevirtual skipField : (I)Z
    //   186: ifne -> 136
    //   189: goto -> 416
    //   192: aload_0
    //   193: aload_2
    //   194: invokevirtual readBool : ()Z
    //   197: putfield hasCommittedMutations_ : Z
    //   200: goto -> 136
    //   203: aload_0
    //   204: getfield documentTypeCase_ : I
    //   207: iconst_3
    //   208: if_icmpne -> 228
    //   211: aload_0
    //   212: getfield documentType_ : Ljava/lang/Object;
    //   215: checkcast com/google/firebase/firestore/proto/UnknownDocument
    //   218: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   221: checkcast com/google/firebase/firestore/proto/UnknownDocument$Builder
    //   224: astore_1
    //   225: goto -> 230
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_0
    //   231: aload_2
    //   232: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   235: aload_3
    //   236: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   239: putfield documentType_ : Ljava/lang/Object;
    //   242: aload_1
    //   243: ifnull -> 266
    //   246: aload_1
    //   247: aload_0
    //   248: getfield documentType_ : Ljava/lang/Object;
    //   251: checkcast com/google/firebase/firestore/proto/UnknownDocument
    //   254: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   257: pop
    //   258: aload_0
    //   259: aload_1
    //   260: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   263: putfield documentType_ : Ljava/lang/Object;
    //   266: aload_0
    //   267: iconst_3
    //   268: putfield documentTypeCase_ : I
    //   271: goto -> 136
    //   274: aload_0
    //   275: getfield documentTypeCase_ : I
    //   278: iconst_2
    //   279: if_icmpne -> 299
    //   282: aload_0
    //   283: getfield documentType_ : Ljava/lang/Object;
    //   286: checkcast com/google/firestore/v1/Document
    //   289: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   292: checkcast com/google/firestore/v1/Document$Builder
    //   295: astore_1
    //   296: goto -> 301
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_0
    //   302: aload_2
    //   303: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   306: aload_3
    //   307: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   310: putfield documentType_ : Ljava/lang/Object;
    //   313: aload_1
    //   314: ifnull -> 337
    //   317: aload_1
    //   318: aload_0
    //   319: getfield documentType_ : Ljava/lang/Object;
    //   322: checkcast com/google/firestore/v1/Document
    //   325: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   328: pop
    //   329: aload_0
    //   330: aload_1
    //   331: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   334: putfield documentType_ : Ljava/lang/Object;
    //   337: aload_0
    //   338: iconst_2
    //   339: putfield documentTypeCase_ : I
    //   342: goto -> 136
    //   345: aload_0
    //   346: getfield documentTypeCase_ : I
    //   349: iconst_1
    //   350: if_icmpne -> 370
    //   353: aload_0
    //   354: getfield documentType_ : Ljava/lang/Object;
    //   357: checkcast com/google/firebase/firestore/proto/NoDocument
    //   360: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   363: checkcast com/google/firebase/firestore/proto/NoDocument$Builder
    //   366: astore_1
    //   367: goto -> 372
    //   370: aconst_null
    //   371: astore_1
    //   372: aload_0
    //   373: aload_2
    //   374: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   377: aload_3
    //   378: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   381: putfield documentType_ : Ljava/lang/Object;
    //   384: aload_1
    //   385: ifnull -> 408
    //   388: aload_1
    //   389: aload_0
    //   390: getfield documentType_ : Ljava/lang/Object;
    //   393: checkcast com/google/firebase/firestore/proto/NoDocument
    //   396: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   399: pop
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   405: putfield documentType_ : Ljava/lang/Object;
    //   408: aload_0
    //   409: iconst_1
    //   410: putfield documentTypeCase_ : I
    //   413: goto -> 136
    //   416: iconst_1
    //   417: istore #9
    //   419: goto -> 136
    //   422: astore_1
    //   423: goto -> 470
    //   426: astore_3
    //   427: new java/lang/RuntimeException
    //   430: astore_2
    //   431: new com/google/protobuf/InvalidProtocolBufferException
    //   434: astore_1
    //   435: aload_1
    //   436: aload_3
    //   437: invokevirtual getMessage : ()Ljava/lang/String;
    //   440: invokespecial <init> : (Ljava/lang/String;)V
    //   443: aload_2
    //   444: aload_1
    //   445: aload_0
    //   446: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   449: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   452: aload_2
    //   453: athrow
    //   454: astore_1
    //   455: new java/lang/RuntimeException
    //   458: astore_2
    //   459: aload_2
    //   460: aload_1
    //   461: aload_0
    //   462: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   465: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   468: aload_2
    //   469: athrow
    //   470: aload_1
    //   471: athrow
    //   472: getstatic com/google/firebase/firestore/proto/MaybeDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MaybeDocument;
    //   475: areturn
    //   476: aload_2
    //   477: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   480: astore_1
    //   481: aload_3
    //   482: checkcast com/google/firebase/firestore/proto/MaybeDocument
    //   485: astore_2
    //   486: aload_0
    //   487: getfield hasCommittedMutations_ : Z
    //   490: istore #10
    //   492: aload_2
    //   493: getfield hasCommittedMutations_ : Z
    //   496: istore #11
    //   498: aload_0
    //   499: aload_1
    //   500: iload #10
    //   502: iload #10
    //   504: iload #11
    //   506: iload #11
    //   508: invokeinterface visitBoolean : (ZZZZ)Z
    //   513: putfield hasCommittedMutations_ : Z
    //   516: getstatic com/google/firebase/firestore/proto/MaybeDocument$1.$SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase : [I
    //   519: aload_2
    //   520: invokevirtual getDocumentTypeCase : ()Lcom/google/firebase/firestore/proto/MaybeDocument$DocumentTypeCase;
    //   523: invokevirtual ordinal : ()I
    //   526: iaload
    //   527: istore #9
    //   529: iload #9
    //   531: iconst_1
    //   532: if_icmpeq -> 653
    //   535: iload #9
    //   537: iconst_2
    //   538: if_icmpeq -> 615
    //   541: iload #9
    //   543: iconst_3
    //   544: if_icmpeq -> 577
    //   547: iload #9
    //   549: iconst_4
    //   550: if_icmpeq -> 556
    //   553: goto -> 688
    //   556: aload_0
    //   557: getfield documentTypeCase_ : I
    //   560: ifeq -> 566
    //   563: iconst_1
    //   564: istore #5
    //   566: aload_1
    //   567: iload #5
    //   569: invokeinterface visitOneofNotSet : (Z)V
    //   574: goto -> 688
    //   577: iload #6
    //   579: istore #5
    //   581: aload_0
    //   582: getfield documentTypeCase_ : I
    //   585: iconst_3
    //   586: if_icmpne -> 592
    //   589: iconst_1
    //   590: istore #5
    //   592: aload_0
    //   593: aload_1
    //   594: iload #5
    //   596: aload_0
    //   597: getfield documentType_ : Ljava/lang/Object;
    //   600: aload_2
    //   601: getfield documentType_ : Ljava/lang/Object;
    //   604: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   609: putfield documentType_ : Ljava/lang/Object;
    //   612: goto -> 688
    //   615: iload #7
    //   617: istore #5
    //   619: aload_0
    //   620: getfield documentTypeCase_ : I
    //   623: iconst_2
    //   624: if_icmpne -> 630
    //   627: iconst_1
    //   628: istore #5
    //   630: aload_0
    //   631: aload_1
    //   632: iload #5
    //   634: aload_0
    //   635: getfield documentType_ : Ljava/lang/Object;
    //   638: aload_2
    //   639: getfield documentType_ : Ljava/lang/Object;
    //   642: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   647: putfield documentType_ : Ljava/lang/Object;
    //   650: goto -> 688
    //   653: iload #8
    //   655: istore #5
    //   657: aload_0
    //   658: getfield documentTypeCase_ : I
    //   661: iconst_1
    //   662: if_icmpne -> 668
    //   665: iconst_1
    //   666: istore #5
    //   668: aload_0
    //   669: aload_1
    //   670: iload #5
    //   672: aload_0
    //   673: getfield documentType_ : Ljava/lang/Object;
    //   676: aload_2
    //   677: getfield documentType_ : Ljava/lang/Object;
    //   680: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   685: putfield documentType_ : Ljava/lang/Object;
    //   688: aload_1
    //   689: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   692: if_acmpne -> 712
    //   695: aload_2
    //   696: getfield documentTypeCase_ : I
    //   699: istore #9
    //   701: iload #9
    //   703: ifeq -> 712
    //   706: aload_0
    //   707: iload #9
    //   709: putfield documentTypeCase_ : I
    //   712: aload_0
    //   713: areturn
    //   714: new com/google/firebase/firestore/proto/MaybeDocument$Builder
    //   717: dup
    //   718: aconst_null
    //   719: invokespecial <init> : (Lcom/google/firebase/firestore/proto/MaybeDocument$1;)V
    //   722: areturn
    //   723: aconst_null
    //   724: areturn
    //   725: getstatic com/google/firebase/firestore/proto/MaybeDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MaybeDocument;
    //   728: areturn
    //   729: new com/google/firebase/firestore/proto/MaybeDocument
    //   732: dup
    //   733: invokespecial <init> : ()V
    //   736: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	454	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	426	java/io/IOException
    //   141	147	422	finally
    //   180	189	454	com/google/protobuf/InvalidProtocolBufferException
    //   180	189	426	java/io/IOException
    //   180	189	422	finally
    //   192	200	454	com/google/protobuf/InvalidProtocolBufferException
    //   192	200	426	java/io/IOException
    //   192	200	422	finally
    //   203	225	454	com/google/protobuf/InvalidProtocolBufferException
    //   203	225	426	java/io/IOException
    //   203	225	422	finally
    //   230	242	454	com/google/protobuf/InvalidProtocolBufferException
    //   230	242	426	java/io/IOException
    //   230	242	422	finally
    //   246	266	454	com/google/protobuf/InvalidProtocolBufferException
    //   246	266	426	java/io/IOException
    //   246	266	422	finally
    //   266	271	454	com/google/protobuf/InvalidProtocolBufferException
    //   266	271	426	java/io/IOException
    //   266	271	422	finally
    //   274	296	454	com/google/protobuf/InvalidProtocolBufferException
    //   274	296	426	java/io/IOException
    //   274	296	422	finally
    //   301	313	454	com/google/protobuf/InvalidProtocolBufferException
    //   301	313	426	java/io/IOException
    //   301	313	422	finally
    //   317	337	454	com/google/protobuf/InvalidProtocolBufferException
    //   317	337	426	java/io/IOException
    //   317	337	422	finally
    //   337	342	454	com/google/protobuf/InvalidProtocolBufferException
    //   337	342	426	java/io/IOException
    //   337	342	422	finally
    //   345	367	454	com/google/protobuf/InvalidProtocolBufferException
    //   345	367	426	java/io/IOException
    //   345	367	422	finally
    //   372	384	454	com/google/protobuf/InvalidProtocolBufferException
    //   372	384	426	java/io/IOException
    //   372	384	422	finally
    //   388	408	454	com/google/protobuf/InvalidProtocolBufferException
    //   388	408	426	java/io/IOException
    //   388	408	422	finally
    //   408	413	454	com/google/protobuf/InvalidProtocolBufferException
    //   408	413	426	java/io/IOException
    //   408	413	422	finally
    //   427	454	422	finally
    //   455	470	422	finally
  }
  
  public Document getDocument() {
    return (this.documentTypeCase_ == 2) ? (Document)this.documentType_ : Document.getDefaultInstance();
  }
  
  public DocumentTypeCase getDocumentTypeCase() {
    return DocumentTypeCase.forNumber(this.documentTypeCase_);
  }
  
  public boolean getHasCommittedMutations() {
    return this.hasCommittedMutations_;
  }
  
  public NoDocument getNoDocument() {
    return (this.documentTypeCase_ == 1) ? (NoDocument)this.documentType_ : NoDocument.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.documentTypeCase_ == 1)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.documentType_); 
    int j = i;
    if (this.documentTypeCase_ == 2)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)this.documentType_); 
    i = j;
    if (this.documentTypeCase_ == 3)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)this.documentType_); 
    boolean bool = this.hasCommittedMutations_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(4, bool); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public UnknownDocument getUnknownDocument() {
    return (this.documentTypeCase_ == 3) ? (UnknownDocument)this.documentType_ : UnknownDocument.getDefaultInstance();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.documentTypeCase_ == 1)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.documentType_); 
    if (this.documentTypeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.documentType_); 
    if (this.documentTypeCase_ == 3)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.documentType_); 
    boolean bool = this.hasCommittedMutations_;
    if (bool)
      paramCodedOutputStream.writeBool(4, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MaybeDocument, Builder> implements MaybeDocumentOrBuilder {
    private Builder() {
      super(MaybeDocument.DEFAULT_INSTANCE);
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((MaybeDocument)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearDocumentType() {
      copyOnWrite();
      ((MaybeDocument)this.instance).clearDocumentType();
      return this;
    }
    
    public Builder clearHasCommittedMutations() {
      copyOnWrite();
      ((MaybeDocument)this.instance).clearHasCommittedMutations();
      return this;
    }
    
    public Builder clearNoDocument() {
      copyOnWrite();
      ((MaybeDocument)this.instance).clearNoDocument();
      return this;
    }
    
    public Builder clearUnknownDocument() {
      copyOnWrite();
      ((MaybeDocument)this.instance).clearUnknownDocument();
      return this;
    }
    
    public Document getDocument() {
      return ((MaybeDocument)this.instance).getDocument();
    }
    
    public MaybeDocument.DocumentTypeCase getDocumentTypeCase() {
      return ((MaybeDocument)this.instance).getDocumentTypeCase();
    }
    
    public boolean getHasCommittedMutations() {
      return ((MaybeDocument)this.instance).getHasCommittedMutations();
    }
    
    public NoDocument getNoDocument() {
      return ((MaybeDocument)this.instance).getNoDocument();
    }
    
    public UnknownDocument getUnknownDocument() {
      return ((MaybeDocument)this.instance).getUnknownDocument();
    }
    
    public Builder mergeDocument(Document param1Document) {
      copyOnWrite();
      ((MaybeDocument)this.instance).mergeDocument(param1Document);
      return this;
    }
    
    public Builder mergeNoDocument(NoDocument param1NoDocument) {
      copyOnWrite();
      ((MaybeDocument)this.instance).mergeNoDocument(param1NoDocument);
      return this;
    }
    
    public Builder mergeUnknownDocument(UnknownDocument param1UnknownDocument) {
      copyOnWrite();
      ((MaybeDocument)this.instance).mergeUnknownDocument(param1UnknownDocument);
      return this;
    }
    
    public Builder setDocument(Document.Builder param1Builder) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setDocument(param1Builder);
      return this;
    }
    
    public Builder setDocument(Document param1Document) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setDocument(param1Document);
      return this;
    }
    
    public Builder setHasCommittedMutations(boolean param1Boolean) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setHasCommittedMutations(param1Boolean);
      return this;
    }
    
    public Builder setNoDocument(NoDocument.Builder param1Builder) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setNoDocument(param1Builder);
      return this;
    }
    
    public Builder setNoDocument(NoDocument param1NoDocument) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setNoDocument(param1NoDocument);
      return this;
    }
    
    public Builder setUnknownDocument(UnknownDocument.Builder param1Builder) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setUnknownDocument(param1Builder);
      return this;
    }
    
    public Builder setUnknownDocument(UnknownDocument param1UnknownDocument) {
      copyOnWrite();
      ((MaybeDocument)this.instance).setUnknownDocument(param1UnknownDocument);
      return this;
    }
  }
  
  public enum DocumentTypeCase implements Internal.EnumLite {
    DOCUMENT,
    DOCUMENTTYPE_NOT_SET,
    NO_DOCUMENT(1),
    UNKNOWN_DOCUMENT(1);
    
    private final int value;
    
    static {
      DOCUMENTTYPE_NOT_SET = new DocumentTypeCase("DOCUMENTTYPE_NOT_SET", 3, 0);
      $VALUES = new DocumentTypeCase[] { NO_DOCUMENT, DOCUMENT, UNKNOWN_DOCUMENT, DOCUMENTTYPE_NOT_SET };
    }
    
    DocumentTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static DocumentTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : UNKNOWN_DOCUMENT) : DOCUMENT) : NO_DOCUMENT) : DOCUMENTTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\MaybeDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */