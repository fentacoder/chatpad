package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class UpdateDocumentRequest extends GeneratedMessageLite<UpdateDocumentRequest, UpdateDocumentRequest.Builder> implements UpdateDocumentRequestOrBuilder {
  public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
  
  private static final UpdateDocumentRequest DEFAULT_INSTANCE = new UpdateDocumentRequest();
  
  public static final int DOCUMENT_FIELD_NUMBER = 1;
  
  public static final int MASK_FIELD_NUMBER = 3;
  
  private static volatile Parser<UpdateDocumentRequest> PARSER;
  
  public static final int UPDATE_MASK_FIELD_NUMBER = 2;
  
  private Precondition currentDocument_;
  
  private Document document_;
  
  private DocumentMask mask_;
  
  private DocumentMask updateMask_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCurrentDocument() {
    this.currentDocument_ = null;
  }
  
  private void clearDocument() {
    this.document_ = null;
  }
  
  private void clearMask() {
    this.mask_ = null;
  }
  
  private void clearUpdateMask() {
    this.updateMask_ = null;
  }
  
  public static UpdateDocumentRequest getDefaultInstance() {
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
  
  private void mergeDocument(Document paramDocument) {
    Document document = this.document_;
    if (document != null && document != Document.getDefaultInstance()) {
      this.document_ = (Document)((Document.Builder)Document.newBuilder(this.document_).mergeFrom(paramDocument)).buildPartial();
    } else {
      this.document_ = paramDocument;
    } 
  }
  
  private void mergeMask(DocumentMask paramDocumentMask) {
    DocumentMask documentMask = this.mask_;
    if (documentMask != null && documentMask != DocumentMask.getDefaultInstance()) {
      this.mask_ = (DocumentMask)((DocumentMask.Builder)DocumentMask.newBuilder(this.mask_).mergeFrom(paramDocumentMask)).buildPartial();
    } else {
      this.mask_ = paramDocumentMask;
    } 
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
  
  public static Builder newBuilder(UpdateDocumentRequest paramUpdateDocumentRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUpdateDocumentRequest);
  }
  
  public static UpdateDocumentRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UpdateDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UpdateDocumentRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateDocumentRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UpdateDocumentRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UpdateDocumentRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UpdateDocumentRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateDocumentRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UpdateDocumentRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UpdateDocumentRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static UpdateDocumentRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UpdateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UpdateDocumentRequest> parser() {
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
    //   0: getstatic com/google/firestore/v1/UpdateDocumentRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 614, 2 -> 610, 3 -> 608, 4 -> 599, 5 -> 499, 6 -> 110, 7 -> 495, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/UpdateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/UpdateDocumentRequest
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/UpdateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/UpdateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/UpdateDocumentRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/UpdateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/UpdateDocumentRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/UpdateDocumentRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/UpdateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 495
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 439
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 374
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 309
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 244
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 179
    //   167: aload_2
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: goto -> 439
    //   179: aload_0
    //   180: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   183: ifnull -> 200
    //   186: aload_0
    //   187: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   190: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   193: checkcast com/google/firestore/v1/Precondition$Builder
    //   196: astore_1
    //   197: goto -> 202
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_0
    //   203: aload_2
    //   204: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   207: aload_3
    //   208: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   211: checkcast com/google/firestore/v1/Precondition
    //   214: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   217: aload_1
    //   218: ifnull -> 123
    //   221: aload_1
    //   222: aload_0
    //   223: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   226: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   229: pop
    //   230: aload_0
    //   231: aload_1
    //   232: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   235: checkcast com/google/firestore/v1/Precondition
    //   238: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   241: goto -> 123
    //   244: aload_0
    //   245: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   248: ifnull -> 265
    //   251: aload_0
    //   252: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   255: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   258: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   261: astore_1
    //   262: goto -> 267
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_0
    //   268: aload_2
    //   269: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   272: aload_3
    //   273: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   276: checkcast com/google/firestore/v1/DocumentMask
    //   279: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   282: aload_1
    //   283: ifnull -> 123
    //   286: aload_1
    //   287: aload_0
    //   288: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   291: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   294: pop
    //   295: aload_0
    //   296: aload_1
    //   297: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   300: checkcast com/google/firestore/v1/DocumentMask
    //   303: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   306: goto -> 123
    //   309: aload_0
    //   310: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   313: ifnull -> 330
    //   316: aload_0
    //   317: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   320: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   323: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   326: astore_1
    //   327: goto -> 332
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_0
    //   333: aload_2
    //   334: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   337: aload_3
    //   338: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   341: checkcast com/google/firestore/v1/DocumentMask
    //   344: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   347: aload_1
    //   348: ifnull -> 123
    //   351: aload_1
    //   352: aload_0
    //   353: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   356: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   359: pop
    //   360: aload_0
    //   361: aload_1
    //   362: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   365: checkcast com/google/firestore/v1/DocumentMask
    //   368: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   371: goto -> 123
    //   374: aload_0
    //   375: getfield document_ : Lcom/google/firestore/v1/Document;
    //   378: ifnull -> 395
    //   381: aload_0
    //   382: getfield document_ : Lcom/google/firestore/v1/Document;
    //   385: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   388: checkcast com/google/firestore/v1/Document$Builder
    //   391: astore_1
    //   392: goto -> 397
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_0
    //   398: aload_2
    //   399: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   402: aload_3
    //   403: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   406: checkcast com/google/firestore/v1/Document
    //   409: putfield document_ : Lcom/google/firestore/v1/Document;
    //   412: aload_1
    //   413: ifnull -> 123
    //   416: aload_1
    //   417: aload_0
    //   418: getfield document_ : Lcom/google/firestore/v1/Document;
    //   421: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   424: pop
    //   425: aload_0
    //   426: aload_1
    //   427: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   430: checkcast com/google/firestore/v1/Document
    //   433: putfield document_ : Lcom/google/firestore/v1/Document;
    //   436: goto -> 123
    //   439: iconst_1
    //   440: istore #4
    //   442: goto -> 123
    //   445: astore_1
    //   446: goto -> 493
    //   449: astore_3
    //   450: new java/lang/RuntimeException
    //   453: astore_2
    //   454: new com/google/protobuf/InvalidProtocolBufferException
    //   457: astore_1
    //   458: aload_1
    //   459: aload_3
    //   460: invokevirtual getMessage : ()Ljava/lang/String;
    //   463: invokespecial <init> : (Ljava/lang/String;)V
    //   466: aload_2
    //   467: aload_1
    //   468: aload_0
    //   469: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   472: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   475: aload_2
    //   476: athrow
    //   477: astore_2
    //   478: new java/lang/RuntimeException
    //   481: astore_1
    //   482: aload_1
    //   483: aload_2
    //   484: aload_0
    //   485: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   488: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   491: aload_1
    //   492: athrow
    //   493: aload_1
    //   494: athrow
    //   495: getstatic com/google/firestore/v1/UpdateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/UpdateDocumentRequest;
    //   498: areturn
    //   499: aload_2
    //   500: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   503: astore_1
    //   504: aload_3
    //   505: checkcast com/google/firestore/v1/UpdateDocumentRequest
    //   508: astore_2
    //   509: aload_0
    //   510: aload_1
    //   511: aload_0
    //   512: getfield document_ : Lcom/google/firestore/v1/Document;
    //   515: aload_2
    //   516: getfield document_ : Lcom/google/firestore/v1/Document;
    //   519: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   524: checkcast com/google/firestore/v1/Document
    //   527: putfield document_ : Lcom/google/firestore/v1/Document;
    //   530: aload_0
    //   531: aload_1
    //   532: aload_0
    //   533: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   536: aload_2
    //   537: getfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   540: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   545: checkcast com/google/firestore/v1/DocumentMask
    //   548: putfield updateMask_ : Lcom/google/firestore/v1/DocumentMask;
    //   551: aload_0
    //   552: aload_1
    //   553: aload_0
    //   554: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   557: aload_2
    //   558: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   561: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   566: checkcast com/google/firestore/v1/DocumentMask
    //   569: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   572: aload_0
    //   573: aload_1
    //   574: aload_0
    //   575: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   578: aload_2
    //   579: getfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   582: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   587: checkcast com/google/firestore/v1/Precondition
    //   590: putfield currentDocument_ : Lcom/google/firestore/v1/Precondition;
    //   593: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   596: astore_1
    //   597: aload_0
    //   598: areturn
    //   599: new com/google/firestore/v1/UpdateDocumentRequest$Builder
    //   602: dup
    //   603: aconst_null
    //   604: invokespecial <init> : (Lcom/google/firestore/v1/UpdateDocumentRequest$1;)V
    //   607: areturn
    //   608: aconst_null
    //   609: areturn
    //   610: getstatic com/google/firestore/v1/UpdateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/UpdateDocumentRequest;
    //   613: areturn
    //   614: new com/google/firestore/v1/UpdateDocumentRequest
    //   617: dup
    //   618: invokespecial <init> : ()V
    //   621: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	477	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	449	java/io/IOException
    //   128	134	445	finally
    //   167	176	477	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	449	java/io/IOException
    //   167	176	445	finally
    //   179	197	477	com/google/protobuf/InvalidProtocolBufferException
    //   179	197	449	java/io/IOException
    //   179	197	445	finally
    //   202	217	477	com/google/protobuf/InvalidProtocolBufferException
    //   202	217	449	java/io/IOException
    //   202	217	445	finally
    //   221	241	477	com/google/protobuf/InvalidProtocolBufferException
    //   221	241	449	java/io/IOException
    //   221	241	445	finally
    //   244	262	477	com/google/protobuf/InvalidProtocolBufferException
    //   244	262	449	java/io/IOException
    //   244	262	445	finally
    //   267	282	477	com/google/protobuf/InvalidProtocolBufferException
    //   267	282	449	java/io/IOException
    //   267	282	445	finally
    //   286	306	477	com/google/protobuf/InvalidProtocolBufferException
    //   286	306	449	java/io/IOException
    //   286	306	445	finally
    //   309	327	477	com/google/protobuf/InvalidProtocolBufferException
    //   309	327	449	java/io/IOException
    //   309	327	445	finally
    //   332	347	477	com/google/protobuf/InvalidProtocolBufferException
    //   332	347	449	java/io/IOException
    //   332	347	445	finally
    //   351	371	477	com/google/protobuf/InvalidProtocolBufferException
    //   351	371	449	java/io/IOException
    //   351	371	445	finally
    //   374	392	477	com/google/protobuf/InvalidProtocolBufferException
    //   374	392	449	java/io/IOException
    //   374	392	445	finally
    //   397	412	477	com/google/protobuf/InvalidProtocolBufferException
    //   397	412	449	java/io/IOException
    //   397	412	445	finally
    //   416	436	477	com/google/protobuf/InvalidProtocolBufferException
    //   416	436	449	java/io/IOException
    //   416	436	445	finally
    //   450	477	445	finally
    //   478	493	445	finally
  }
  
  public Precondition getCurrentDocument() {
    Precondition precondition1 = this.currentDocument_;
    Precondition precondition2 = precondition1;
    if (precondition1 == null)
      precondition2 = Precondition.getDefaultInstance(); 
    return precondition2;
  }
  
  public Document getDocument() {
    Document document1 = this.document_;
    Document document2 = document1;
    if (document1 == null)
      document2 = Document.getDefaultInstance(); 
    return document2;
  }
  
  public DocumentMask getMask() {
    DocumentMask documentMask1 = this.mask_;
    DocumentMask documentMask2 = documentMask1;
    if (documentMask1 == null)
      documentMask2 = DocumentMask.getDefaultInstance(); 
    return documentMask2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.document_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getDocument()); 
    int j = i;
    if (this.updateMask_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getUpdateMask()); 
    i = j;
    if (this.mask_ != null)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getMask()); 
    j = i;
    if (this.currentDocument_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getCurrentDocument()); 
    this.memoizedSerializedSize = j;
    return j;
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
  
  public boolean hasDocument() {
    boolean bool;
    if (this.document_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
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
    if (this.document_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getDocument()); 
    if (this.updateMask_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getUpdateMask()); 
    if (this.mask_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getMask()); 
    if (this.currentDocument_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getCurrentDocument()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
    private Builder() {
      super(UpdateDocumentRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCurrentDocument() {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).clearCurrentDocument();
      return this;
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearMask() {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).clearMask();
      return this;
    }
    
    public Builder clearUpdateMask() {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).clearUpdateMask();
      return this;
    }
    
    public Precondition getCurrentDocument() {
      return ((UpdateDocumentRequest)this.instance).getCurrentDocument();
    }
    
    public Document getDocument() {
      return ((UpdateDocumentRequest)this.instance).getDocument();
    }
    
    public DocumentMask getMask() {
      return ((UpdateDocumentRequest)this.instance).getMask();
    }
    
    public DocumentMask getUpdateMask() {
      return ((UpdateDocumentRequest)this.instance).getUpdateMask();
    }
    
    public boolean hasCurrentDocument() {
      return ((UpdateDocumentRequest)this.instance).hasCurrentDocument();
    }
    
    public boolean hasDocument() {
      return ((UpdateDocumentRequest)this.instance).hasDocument();
    }
    
    public boolean hasMask() {
      return ((UpdateDocumentRequest)this.instance).hasMask();
    }
    
    public boolean hasUpdateMask() {
      return ((UpdateDocumentRequest)this.instance).hasUpdateMask();
    }
    
    public Builder mergeCurrentDocument(Precondition param1Precondition) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).mergeCurrentDocument(param1Precondition);
      return this;
    }
    
    public Builder mergeDocument(Document param1Document) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).mergeDocument(param1Document);
      return this;
    }
    
    public Builder mergeMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).mergeMask(param1DocumentMask);
      return this;
    }
    
    public Builder mergeUpdateMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).mergeUpdateMask(param1DocumentMask);
      return this;
    }
    
    public Builder setCurrentDocument(Precondition.Builder param1Builder) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setCurrentDocument(param1Builder);
      return this;
    }
    
    public Builder setCurrentDocument(Precondition param1Precondition) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setCurrentDocument(param1Precondition);
      return this;
    }
    
    public Builder setDocument(Document.Builder param1Builder) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setDocument(param1Builder);
      return this;
    }
    
    public Builder setDocument(Document param1Document) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setDocument(param1Document);
      return this;
    }
    
    public Builder setMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setMask(param1Builder);
      return this;
    }
    
    public Builder setMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setMask(param1DocumentMask);
      return this;
    }
    
    public Builder setUpdateMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setUpdateMask(param1Builder);
      return this;
    }
    
    public Builder setUpdateMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((UpdateDocumentRequest)this.instance).setUpdateMask(param1DocumentMask);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\UpdateDocumentRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */