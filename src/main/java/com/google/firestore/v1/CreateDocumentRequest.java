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

public final class CreateDocumentRequest extends GeneratedMessageLite<CreateDocumentRequest, CreateDocumentRequest.Builder> implements CreateDocumentRequestOrBuilder {
  public static final int COLLECTION_ID_FIELD_NUMBER = 2;
  
  private static final CreateDocumentRequest DEFAULT_INSTANCE = new CreateDocumentRequest();
  
  public static final int DOCUMENT_FIELD_NUMBER = 4;
  
  public static final int DOCUMENT_ID_FIELD_NUMBER = 3;
  
  public static final int MASK_FIELD_NUMBER = 5;
  
  public static final int PARENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<CreateDocumentRequest> PARSER;
  
  private String collectionId_ = "";
  
  private String documentId_ = "";
  
  private Document document_;
  
  private DocumentMask mask_;
  
  private String parent_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCollectionId() {
    this.collectionId_ = getDefaultInstance().getCollectionId();
  }
  
  private void clearDocument() {
    this.document_ = null;
  }
  
  private void clearDocumentId() {
    this.documentId_ = getDefaultInstance().getDocumentId();
  }
  
  private void clearMask() {
    this.mask_ = null;
  }
  
  private void clearParent() {
    this.parent_ = getDefaultInstance().getParent();
  }
  
  public static CreateDocumentRequest getDefaultInstance() {
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
  
  private void mergeMask(DocumentMask paramDocumentMask) {
    DocumentMask documentMask = this.mask_;
    if (documentMask != null && documentMask != DocumentMask.getDefaultInstance()) {
      this.mask_ = (DocumentMask)((DocumentMask.Builder)DocumentMask.newBuilder(this.mask_).mergeFrom(paramDocumentMask)).buildPartial();
    } else {
      this.mask_ = paramDocumentMask;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CreateDocumentRequest paramCreateDocumentRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCreateDocumentRequest);
  }
  
  public static CreateDocumentRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CreateDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CreateDocumentRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CreateDocumentRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CreateDocumentRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CreateDocumentRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CreateDocumentRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CreateDocumentRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CreateDocumentRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CreateDocumentRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CreateDocumentRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CreateDocumentRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CreateDocumentRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CreateDocumentRequest> parser() {
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
  
  private void setDocumentId(String paramString) {
    if (paramString != null) {
      this.documentId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.documentId_ = paramByteString.toStringUtf8();
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/CreateDocumentRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 590, 2 -> 586, 3 -> 584, 4 -> 575, 5 -> 409, 6 -> 110, 7 -> 405, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/CreateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/CreateDocumentRequest
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/CreateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/CreateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CreateDocumentRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/CreateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/CreateDocumentRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/CreateDocumentRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/CreateDocumentRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 405
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 349
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 338
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 327
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 316
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 251
    //   167: iload #5
    //   169: bipush #42
    //   171: if_icmpeq -> 186
    //   174: aload_2
    //   175: iload #5
    //   177: invokevirtual skipField : (I)Z
    //   180: ifne -> 123
    //   183: goto -> 349
    //   186: aload_0
    //   187: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   190: ifnull -> 207
    //   193: aload_0
    //   194: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   197: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   200: checkcast com/google/firestore/v1/DocumentMask$Builder
    //   203: astore_1
    //   204: goto -> 209
    //   207: aconst_null
    //   208: astore_1
    //   209: aload_0
    //   210: aload_2
    //   211: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   214: aload_3
    //   215: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   218: checkcast com/google/firestore/v1/DocumentMask
    //   221: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   224: aload_1
    //   225: ifnull -> 123
    //   228: aload_1
    //   229: aload_0
    //   230: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   233: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   236: pop
    //   237: aload_0
    //   238: aload_1
    //   239: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   242: checkcast com/google/firestore/v1/DocumentMask
    //   245: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   248: goto -> 123
    //   251: aload_0
    //   252: getfield document_ : Lcom/google/firestore/v1/Document;
    //   255: ifnull -> 272
    //   258: aload_0
    //   259: getfield document_ : Lcom/google/firestore/v1/Document;
    //   262: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   265: checkcast com/google/firestore/v1/Document$Builder
    //   268: astore_1
    //   269: goto -> 274
    //   272: aconst_null
    //   273: astore_1
    //   274: aload_0
    //   275: aload_2
    //   276: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   279: aload_3
    //   280: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   283: checkcast com/google/firestore/v1/Document
    //   286: putfield document_ : Lcom/google/firestore/v1/Document;
    //   289: aload_1
    //   290: ifnull -> 123
    //   293: aload_1
    //   294: aload_0
    //   295: getfield document_ : Lcom/google/firestore/v1/Document;
    //   298: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   301: pop
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   307: checkcast com/google/firestore/v1/Document
    //   310: putfield document_ : Lcom/google/firestore/v1/Document;
    //   313: goto -> 123
    //   316: aload_0
    //   317: aload_2
    //   318: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   321: putfield documentId_ : Ljava/lang/String;
    //   324: goto -> 123
    //   327: aload_0
    //   328: aload_2
    //   329: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   332: putfield collectionId_ : Ljava/lang/String;
    //   335: goto -> 123
    //   338: aload_0
    //   339: aload_2
    //   340: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   343: putfield parent_ : Ljava/lang/String;
    //   346: goto -> 123
    //   349: iconst_1
    //   350: istore #4
    //   352: goto -> 123
    //   355: astore_1
    //   356: goto -> 403
    //   359: astore_1
    //   360: new java/lang/RuntimeException
    //   363: astore_2
    //   364: new com/google/protobuf/InvalidProtocolBufferException
    //   367: astore_3
    //   368: aload_3
    //   369: aload_1
    //   370: invokevirtual getMessage : ()Ljava/lang/String;
    //   373: invokespecial <init> : (Ljava/lang/String;)V
    //   376: aload_2
    //   377: aload_3
    //   378: aload_0
    //   379: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   382: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   385: aload_2
    //   386: athrow
    //   387: astore_2
    //   388: new java/lang/RuntimeException
    //   391: astore_1
    //   392: aload_1
    //   393: aload_2
    //   394: aload_0
    //   395: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   398: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   401: aload_1
    //   402: athrow
    //   403: aload_1
    //   404: athrow
    //   405: getstatic com/google/firestore/v1/CreateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CreateDocumentRequest;
    //   408: areturn
    //   409: aload_2
    //   410: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   413: astore_1
    //   414: aload_3
    //   415: checkcast com/google/firestore/v1/CreateDocumentRequest
    //   418: astore_2
    //   419: aload_0
    //   420: aload_1
    //   421: aload_0
    //   422: getfield parent_ : Ljava/lang/String;
    //   425: invokevirtual isEmpty : ()Z
    //   428: iconst_1
    //   429: ixor
    //   430: aload_0
    //   431: getfield parent_ : Ljava/lang/String;
    //   434: aload_2
    //   435: getfield parent_ : Ljava/lang/String;
    //   438: invokevirtual isEmpty : ()Z
    //   441: iconst_1
    //   442: ixor
    //   443: aload_2
    //   444: getfield parent_ : Ljava/lang/String;
    //   447: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   452: putfield parent_ : Ljava/lang/String;
    //   455: aload_0
    //   456: aload_1
    //   457: aload_0
    //   458: getfield collectionId_ : Ljava/lang/String;
    //   461: invokevirtual isEmpty : ()Z
    //   464: iconst_1
    //   465: ixor
    //   466: aload_0
    //   467: getfield collectionId_ : Ljava/lang/String;
    //   470: aload_2
    //   471: getfield collectionId_ : Ljava/lang/String;
    //   474: invokevirtual isEmpty : ()Z
    //   477: iconst_1
    //   478: ixor
    //   479: aload_2
    //   480: getfield collectionId_ : Ljava/lang/String;
    //   483: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   488: putfield collectionId_ : Ljava/lang/String;
    //   491: aload_0
    //   492: aload_1
    //   493: aload_0
    //   494: getfield documentId_ : Ljava/lang/String;
    //   497: invokevirtual isEmpty : ()Z
    //   500: iconst_1
    //   501: ixor
    //   502: aload_0
    //   503: getfield documentId_ : Ljava/lang/String;
    //   506: iconst_1
    //   507: aload_2
    //   508: getfield documentId_ : Ljava/lang/String;
    //   511: invokevirtual isEmpty : ()Z
    //   514: ixor
    //   515: aload_2
    //   516: getfield documentId_ : Ljava/lang/String;
    //   519: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   524: putfield documentId_ : Ljava/lang/String;
    //   527: aload_0
    //   528: aload_1
    //   529: aload_0
    //   530: getfield document_ : Lcom/google/firestore/v1/Document;
    //   533: aload_2
    //   534: getfield document_ : Lcom/google/firestore/v1/Document;
    //   537: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   542: checkcast com/google/firestore/v1/Document
    //   545: putfield document_ : Lcom/google/firestore/v1/Document;
    //   548: aload_0
    //   549: aload_1
    //   550: aload_0
    //   551: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   554: aload_2
    //   555: getfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   558: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   563: checkcast com/google/firestore/v1/DocumentMask
    //   566: putfield mask_ : Lcom/google/firestore/v1/DocumentMask;
    //   569: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   572: astore_1
    //   573: aload_0
    //   574: areturn
    //   575: new com/google/firestore/v1/CreateDocumentRequest$Builder
    //   578: dup
    //   579: aconst_null
    //   580: invokespecial <init> : (Lcom/google/firestore/v1/CreateDocumentRequest$1;)V
    //   583: areturn
    //   584: aconst_null
    //   585: areturn
    //   586: getstatic com/google/firestore/v1/CreateDocumentRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CreateDocumentRequest;
    //   589: areturn
    //   590: new com/google/firestore/v1/CreateDocumentRequest
    //   593: dup
    //   594: invokespecial <init> : ()V
    //   597: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	387	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	359	java/io/IOException
    //   128	134	355	finally
    //   174	183	387	com/google/protobuf/InvalidProtocolBufferException
    //   174	183	359	java/io/IOException
    //   174	183	355	finally
    //   186	204	387	com/google/protobuf/InvalidProtocolBufferException
    //   186	204	359	java/io/IOException
    //   186	204	355	finally
    //   209	224	387	com/google/protobuf/InvalidProtocolBufferException
    //   209	224	359	java/io/IOException
    //   209	224	355	finally
    //   228	248	387	com/google/protobuf/InvalidProtocolBufferException
    //   228	248	359	java/io/IOException
    //   228	248	355	finally
    //   251	269	387	com/google/protobuf/InvalidProtocolBufferException
    //   251	269	359	java/io/IOException
    //   251	269	355	finally
    //   274	289	387	com/google/protobuf/InvalidProtocolBufferException
    //   274	289	359	java/io/IOException
    //   274	289	355	finally
    //   293	313	387	com/google/protobuf/InvalidProtocolBufferException
    //   293	313	359	java/io/IOException
    //   293	313	355	finally
    //   316	324	387	com/google/protobuf/InvalidProtocolBufferException
    //   316	324	359	java/io/IOException
    //   316	324	355	finally
    //   327	335	387	com/google/protobuf/InvalidProtocolBufferException
    //   327	335	359	java/io/IOException
    //   327	335	355	finally
    //   338	346	387	com/google/protobuf/InvalidProtocolBufferException
    //   338	346	359	java/io/IOException
    //   338	346	355	finally
    //   360	387	355	finally
    //   388	403	355	finally
  }
  
  public String getCollectionId() {
    return this.collectionId_;
  }
  
  public ByteString getCollectionIdBytes() {
    return ByteString.copyFromUtf8(this.collectionId_);
  }
  
  public Document getDocument() {
    Document document1 = this.document_;
    Document document2 = document1;
    if (document1 == null)
      document2 = Document.getDefaultInstance(); 
    return document2;
  }
  
  public String getDocumentId() {
    return this.documentId_;
  }
  
  public ByteString getDocumentIdBytes() {
    return ByteString.copyFromUtf8(this.documentId_);
  }
  
  public DocumentMask getMask() {
    DocumentMask documentMask1 = this.mask_;
    DocumentMask documentMask2 = documentMask1;
    if (documentMask1 == null)
      documentMask2 = DocumentMask.getDefaultInstance(); 
    return documentMask2;
  }
  
  public String getParent() {
    return this.parent_;
  }
  
  public ByteString getParentBytes() {
    return ByteString.copyFromUtf8(this.parent_);
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
    i = j;
    if (!this.documentId_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(3, getDocumentId()); 
    j = i;
    if (this.document_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getDocument()); 
    i = j;
    if (this.mask_ != null)
      i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)getMask()); 
    this.memoizedSerializedSize = i;
    return i;
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
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.parent_.isEmpty())
      paramCodedOutputStream.writeString(1, getParent()); 
    if (!this.collectionId_.isEmpty())
      paramCodedOutputStream.writeString(2, getCollectionId()); 
    if (!this.documentId_.isEmpty())
      paramCodedOutputStream.writeString(3, getDocumentId()); 
    if (this.document_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getDocument()); 
    if (this.mask_ != null)
      paramCodedOutputStream.writeMessage(5, (MessageLite)getMask()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
    private Builder() {
      super(CreateDocumentRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCollectionId() {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).clearCollectionId();
      return this;
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearDocumentId() {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).clearDocumentId();
      return this;
    }
    
    public Builder clearMask() {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).clearMask();
      return this;
    }
    
    public Builder clearParent() {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).clearParent();
      return this;
    }
    
    public String getCollectionId() {
      return ((CreateDocumentRequest)this.instance).getCollectionId();
    }
    
    public ByteString getCollectionIdBytes() {
      return ((CreateDocumentRequest)this.instance).getCollectionIdBytes();
    }
    
    public Document getDocument() {
      return ((CreateDocumentRequest)this.instance).getDocument();
    }
    
    public String getDocumentId() {
      return ((CreateDocumentRequest)this.instance).getDocumentId();
    }
    
    public ByteString getDocumentIdBytes() {
      return ((CreateDocumentRequest)this.instance).getDocumentIdBytes();
    }
    
    public DocumentMask getMask() {
      return ((CreateDocumentRequest)this.instance).getMask();
    }
    
    public String getParent() {
      return ((CreateDocumentRequest)this.instance).getParent();
    }
    
    public ByteString getParentBytes() {
      return ((CreateDocumentRequest)this.instance).getParentBytes();
    }
    
    public boolean hasDocument() {
      return ((CreateDocumentRequest)this.instance).hasDocument();
    }
    
    public boolean hasMask() {
      return ((CreateDocumentRequest)this.instance).hasMask();
    }
    
    public Builder mergeDocument(Document param1Document) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).mergeDocument(param1Document);
      return this;
    }
    
    public Builder mergeMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).mergeMask(param1DocumentMask);
      return this;
    }
    
    public Builder setCollectionId(String param1String) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setCollectionId(param1String);
      return this;
    }
    
    public Builder setCollectionIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setCollectionIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setDocument(Document.Builder param1Builder) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setDocument(param1Builder);
      return this;
    }
    
    public Builder setDocument(Document param1Document) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setDocument(param1Document);
      return this;
    }
    
    public Builder setDocumentId(String param1String) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setDocumentId(param1String);
      return this;
    }
    
    public Builder setDocumentIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setDocumentIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setMask(DocumentMask.Builder param1Builder) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setMask(param1Builder);
      return this;
    }
    
    public Builder setMask(DocumentMask param1DocumentMask) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setMask(param1DocumentMask);
      return this;
    }
    
    public Builder setParent(String param1String) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setParent(param1String);
      return this;
    }
    
    public Builder setParentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CreateDocumentRequest)this.instance).setParentBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\CreateDocumentRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */