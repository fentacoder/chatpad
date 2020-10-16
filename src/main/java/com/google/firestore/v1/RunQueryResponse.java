package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

public final class RunQueryResponse extends GeneratedMessageLite<RunQueryResponse, RunQueryResponse.Builder> implements RunQueryResponseOrBuilder {
  private static final RunQueryResponse DEFAULT_INSTANCE = new RunQueryResponse();
  
  public static final int DOCUMENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<RunQueryResponse> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 3;
  
  public static final int SKIPPED_RESULTS_FIELD_NUMBER = 4;
  
  public static final int TRANSACTION_FIELD_NUMBER = 2;
  
  private Document document_;
  
  private Timestamp readTime_;
  
  private int skippedResults_;
  
  private ByteString transaction_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDocument() {
    this.document_ = null;
  }
  
  private void clearReadTime() {
    this.readTime_ = null;
  }
  
  private void clearSkippedResults() {
    this.skippedResults_ = 0;
  }
  
  private void clearTransaction() {
    this.transaction_ = getDefaultInstance().getTransaction();
  }
  
  public static RunQueryResponse getDefaultInstance() {
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
  
  public static Builder newBuilder(RunQueryResponse paramRunQueryResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRunQueryResponse);
  }
  
  public static RunQueryResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RunQueryResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RunQueryResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RunQueryResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RunQueryResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RunQueryResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RunQueryResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RunQueryResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RunQueryResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RunQueryResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RunQueryResponse> parser() {
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
  
  private void setSkippedResults(int paramInt) {
    this.skippedResults_ = paramInt;
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.transaction_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/RunQueryResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 587, 2 -> 583, 3 -> 581, 4 -> 572, 5 -> 396, 6 -> 118, 7 -> 392, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/RunQueryResponse.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/RunQueryResponse
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/RunQueryResponse.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/RunQueryResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryResponse;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/RunQueryResponse.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/RunQueryResponse
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/RunQueryResponse
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/RunQueryResponse.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 392
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 336
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 271
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 260
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 195
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 184
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 336
    //   184: aload_0
    //   185: aload_2
    //   186: invokevirtual readInt32 : ()I
    //   189: putfield skippedResults_ : I
    //   192: goto -> 128
    //   195: aload_0
    //   196: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   199: ifnull -> 216
    //   202: aload_0
    //   203: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   206: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   209: checkcast com/google/protobuf/Timestamp$Builder
    //   212: astore_1
    //   213: goto -> 218
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_0
    //   219: aload_2
    //   220: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   223: aload_3
    //   224: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   227: checkcast com/google/protobuf/Timestamp
    //   230: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   233: aload_1
    //   234: ifnull -> 128
    //   237: aload_1
    //   238: aload_0
    //   239: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   242: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   245: pop
    //   246: aload_0
    //   247: aload_1
    //   248: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   251: checkcast com/google/protobuf/Timestamp
    //   254: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   257: goto -> 128
    //   260: aload_0
    //   261: aload_2
    //   262: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   265: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   268: goto -> 128
    //   271: aload_0
    //   272: getfield document_ : Lcom/google/firestore/v1/Document;
    //   275: ifnull -> 292
    //   278: aload_0
    //   279: getfield document_ : Lcom/google/firestore/v1/Document;
    //   282: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   285: checkcast com/google/firestore/v1/Document$Builder
    //   288: astore_1
    //   289: goto -> 294
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_0
    //   295: aload_2
    //   296: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   299: aload_3
    //   300: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   303: checkcast com/google/firestore/v1/Document
    //   306: putfield document_ : Lcom/google/firestore/v1/Document;
    //   309: aload_1
    //   310: ifnull -> 128
    //   313: aload_1
    //   314: aload_0
    //   315: getfield document_ : Lcom/google/firestore/v1/Document;
    //   318: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   321: pop
    //   322: aload_0
    //   323: aload_1
    //   324: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   327: checkcast com/google/firestore/v1/Document
    //   330: putfield document_ : Lcom/google/firestore/v1/Document;
    //   333: goto -> 128
    //   336: iconst_1
    //   337: istore #6
    //   339: goto -> 128
    //   342: astore_1
    //   343: goto -> 390
    //   346: astore_3
    //   347: new java/lang/RuntimeException
    //   350: astore_1
    //   351: new com/google/protobuf/InvalidProtocolBufferException
    //   354: astore_2
    //   355: aload_2
    //   356: aload_3
    //   357: invokevirtual getMessage : ()Ljava/lang/String;
    //   360: invokespecial <init> : (Ljava/lang/String;)V
    //   363: aload_1
    //   364: aload_2
    //   365: aload_0
    //   366: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   369: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: new java/lang/RuntimeException
    //   378: astore_2
    //   379: aload_2
    //   380: aload_1
    //   381: aload_0
    //   382: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   385: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   388: aload_2
    //   389: athrow
    //   390: aload_1
    //   391: athrow
    //   392: getstatic com/google/firestore/v1/RunQueryResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryResponse;
    //   395: areturn
    //   396: aload_2
    //   397: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   400: astore_1
    //   401: aload_3
    //   402: checkcast com/google/firestore/v1/RunQueryResponse
    //   405: astore_3
    //   406: aload_0
    //   407: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   410: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   413: if_acmpeq -> 422
    //   416: iconst_1
    //   417: istore #7
    //   419: goto -> 425
    //   422: iconst_0
    //   423: istore #7
    //   425: aload_0
    //   426: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   429: astore_2
    //   430: aload_3
    //   431: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   434: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   437: if_acmpeq -> 446
    //   440: iconst_1
    //   441: istore #8
    //   443: goto -> 449
    //   446: iconst_0
    //   447: istore #8
    //   449: aload_0
    //   450: aload_1
    //   451: iload #7
    //   453: aload_2
    //   454: iload #8
    //   456: aload_3
    //   457: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   460: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   465: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   468: aload_0
    //   469: aload_1
    //   470: aload_0
    //   471: getfield document_ : Lcom/google/firestore/v1/Document;
    //   474: aload_3
    //   475: getfield document_ : Lcom/google/firestore/v1/Document;
    //   478: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   483: checkcast com/google/firestore/v1/Document
    //   486: putfield document_ : Lcom/google/firestore/v1/Document;
    //   489: aload_0
    //   490: aload_1
    //   491: aload_0
    //   492: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   495: aload_3
    //   496: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   499: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   504: checkcast com/google/protobuf/Timestamp
    //   507: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   510: aload_0
    //   511: getfield skippedResults_ : I
    //   514: ifeq -> 523
    //   517: iconst_1
    //   518: istore #7
    //   520: goto -> 526
    //   523: iconst_0
    //   524: istore #7
    //   526: aload_0
    //   527: getfield skippedResults_ : I
    //   530: istore #6
    //   532: iload #5
    //   534: istore #8
    //   536: aload_3
    //   537: getfield skippedResults_ : I
    //   540: ifeq -> 546
    //   543: iconst_1
    //   544: istore #8
    //   546: aload_0
    //   547: aload_1
    //   548: iload #7
    //   550: iload #6
    //   552: iload #8
    //   554: aload_3
    //   555: getfield skippedResults_ : I
    //   558: invokeinterface visitInt : (ZIZI)I
    //   563: putfield skippedResults_ : I
    //   566: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   569: astore_1
    //   570: aload_0
    //   571: areturn
    //   572: new com/google/firestore/v1/RunQueryResponse$Builder
    //   575: dup
    //   576: aconst_null
    //   577: invokespecial <init> : (Lcom/google/firestore/v1/RunQueryResponse$1;)V
    //   580: areturn
    //   581: aconst_null
    //   582: areturn
    //   583: getstatic com/google/firestore/v1/RunQueryResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/RunQueryResponse;
    //   586: areturn
    //   587: new com/google/firestore/v1/RunQueryResponse
    //   590: dup
    //   591: invokespecial <init> : ()V
    //   594: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	374	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	346	java/io/IOException
    //   133	139	342	finally
    //   172	181	374	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	346	java/io/IOException
    //   172	181	342	finally
    //   184	192	374	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	346	java/io/IOException
    //   184	192	342	finally
    //   195	213	374	com/google/protobuf/InvalidProtocolBufferException
    //   195	213	346	java/io/IOException
    //   195	213	342	finally
    //   218	233	374	com/google/protobuf/InvalidProtocolBufferException
    //   218	233	346	java/io/IOException
    //   218	233	342	finally
    //   237	257	374	com/google/protobuf/InvalidProtocolBufferException
    //   237	257	346	java/io/IOException
    //   237	257	342	finally
    //   260	268	374	com/google/protobuf/InvalidProtocolBufferException
    //   260	268	346	java/io/IOException
    //   260	268	342	finally
    //   271	289	374	com/google/protobuf/InvalidProtocolBufferException
    //   271	289	346	java/io/IOException
    //   271	289	342	finally
    //   294	309	374	com/google/protobuf/InvalidProtocolBufferException
    //   294	309	346	java/io/IOException
    //   294	309	342	finally
    //   313	333	374	com/google/protobuf/InvalidProtocolBufferException
    //   313	333	346	java/io/IOException
    //   313	333	342	finally
    //   347	374	342	finally
    //   375	390	342	finally
  }
  
  public Document getDocument() {
    Document document1 = this.document_;
    Document document2 = document1;
    if (document1 == null)
      document2 = Document.getDefaultInstance(); 
    return document2;
  }
  
  public Timestamp getReadTime() {
    Timestamp timestamp1 = this.readTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.document_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getDocument()); 
    int j = i;
    if (!this.transaction_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(2, this.transaction_); 
    i = j;
    if (this.readTime_ != null)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getReadTime()); 
    int k = this.skippedResults_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(4, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getSkippedResults() {
    return this.skippedResults_;
  }
  
  public ByteString getTransaction() {
    return this.transaction_;
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
    if (this.document_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getDocument()); 
    if (!this.transaction_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.transaction_); 
    if (this.readTime_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getReadTime()); 
    int i = this.skippedResults_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
    private Builder() {
      super(RunQueryResponse.DEFAULT_INSTANCE);
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((RunQueryResponse)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((RunQueryResponse)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearSkippedResults() {
      copyOnWrite();
      ((RunQueryResponse)this.instance).clearSkippedResults();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((RunQueryResponse)this.instance).clearTransaction();
      return this;
    }
    
    public Document getDocument() {
      return ((RunQueryResponse)this.instance).getDocument();
    }
    
    public Timestamp getReadTime() {
      return ((RunQueryResponse)this.instance).getReadTime();
    }
    
    public int getSkippedResults() {
      return ((RunQueryResponse)this.instance).getSkippedResults();
    }
    
    public ByteString getTransaction() {
      return ((RunQueryResponse)this.instance).getTransaction();
    }
    
    public boolean hasDocument() {
      return ((RunQueryResponse)this.instance).hasDocument();
    }
    
    public boolean hasReadTime() {
      return ((RunQueryResponse)this.instance).hasReadTime();
    }
    
    public Builder mergeDocument(Document param1Document) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).mergeDocument(param1Document);
      return this;
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setDocument(Document.Builder param1Builder) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setDocument(param1Builder);
      return this;
    }
    
    public Builder setDocument(Document param1Document) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setDocument(param1Document);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setSkippedResults(int param1Int) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setSkippedResults(param1Int);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((RunQueryResponse)this.instance).setTransaction(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\RunQueryResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */