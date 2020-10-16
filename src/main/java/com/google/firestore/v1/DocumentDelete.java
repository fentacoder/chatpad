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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DocumentDelete extends GeneratedMessageLite<DocumentDelete, DocumentDelete.Builder> implements DocumentDeleteOrBuilder {
  private static final DocumentDelete DEFAULT_INSTANCE = new DocumentDelete();
  
  public static final int DOCUMENT_FIELD_NUMBER = 1;
  
  private static volatile Parser<DocumentDelete> PARSER;
  
  public static final int READ_TIME_FIELD_NUMBER = 4;
  
  public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
  
  private int bitField0_;
  
  private String document_ = "";
  
  private Timestamp readTime_;
  
  private Internal.IntList removedTargetIds_ = emptyIntList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllRemovedTargetIds(Iterable<? extends Integer> paramIterable) {
    ensureRemovedTargetIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.removedTargetIds_);
  }
  
  private void addRemovedTargetIds(int paramInt) {
    ensureRemovedTargetIdsIsMutable();
    this.removedTargetIds_.addInt(paramInt);
  }
  
  private void clearDocument() {
    this.document_ = getDefaultInstance().getDocument();
  }
  
  private void clearReadTime() {
    this.readTime_ = null;
  }
  
  private void clearRemovedTargetIds() {
    this.removedTargetIds_ = emptyIntList();
  }
  
  private void ensureRemovedTargetIdsIsMutable() {
    if (!this.removedTargetIds_.isModifiable())
      this.removedTargetIds_ = GeneratedMessageLite.mutableCopy(this.removedTargetIds_); 
  }
  
  public static DocumentDelete getDefaultInstance() {
    return DEFAULT_INSTANCE;
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
  
  public static Builder newBuilder(DocumentDelete paramDocumentDelete) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocumentDelete);
  }
  
  public static DocumentDelete parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DocumentDelete)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentDelete parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentDelete)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentDelete parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DocumentDelete parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DocumentDelete parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DocumentDelete parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentDelete parseFrom(InputStream paramInputStream) throws IOException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentDelete parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentDelete parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DocumentDelete parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentDelete)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DocumentDelete> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDocument(String paramString) {
    if (paramString != null) {
      this.document_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.document_ = paramByteString.toStringUtf8();
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
  
  private void setRemovedTargetIds(int paramInt1, int paramInt2) {
    ensureRemovedTargetIdsIsMutable();
    this.removedTargetIds_.setInt(paramInt1, paramInt2);
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/DocumentDelete$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 557, 2 -> 553, 3 -> 542, 4 -> 533, 5 -> 426, 6 -> 110, 7 -> 422, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/DocumentDelete.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/DocumentDelete
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/DocumentDelete.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/DocumentDelete.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentDelete;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/DocumentDelete.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/DocumentDelete
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/DocumentDelete
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/DocumentDelete.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 422
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 366
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 355
    //   146: iload #5
    //   148: bipush #34
    //   150: if_icmpeq -> 290
    //   153: iload #5
    //   155: bipush #48
    //   157: if_icmpeq -> 251
    //   160: iload #5
    //   162: bipush #50
    //   164: if_icmpeq -> 179
    //   167: aload_2
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: goto -> 366
    //   179: aload_2
    //   180: aload_2
    //   181: invokevirtual readRawVarint32 : ()I
    //   184: invokevirtual pushLimit : (I)I
    //   187: istore #5
    //   189: aload_0
    //   190: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   193: invokeinterface isModifiable : ()Z
    //   198: ifne -> 219
    //   201: aload_2
    //   202: invokevirtual getBytesUntilLimit : ()I
    //   205: ifle -> 219
    //   208: aload_0
    //   209: aload_0
    //   210: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   213: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   216: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   219: aload_2
    //   220: invokevirtual getBytesUntilLimit : ()I
    //   223: ifle -> 242
    //   226: aload_0
    //   227: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   230: aload_2
    //   231: invokevirtual readInt32 : ()I
    //   234: invokeinterface addInt : (I)V
    //   239: goto -> 219
    //   242: aload_2
    //   243: iload #5
    //   245: invokevirtual popLimit : (I)V
    //   248: goto -> 123
    //   251: aload_0
    //   252: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   255: invokeinterface isModifiable : ()Z
    //   260: ifne -> 274
    //   263: aload_0
    //   264: aload_0
    //   265: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   268: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   271: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   274: aload_0
    //   275: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   278: aload_2
    //   279: invokevirtual readInt32 : ()I
    //   282: invokeinterface addInt : (I)V
    //   287: goto -> 123
    //   290: aload_0
    //   291: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   294: ifnull -> 311
    //   297: aload_0
    //   298: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   301: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   304: checkcast com/google/protobuf/Timestamp$Builder
    //   307: astore_1
    //   308: goto -> 313
    //   311: aconst_null
    //   312: astore_1
    //   313: aload_0
    //   314: aload_2
    //   315: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   318: aload_3
    //   319: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   322: checkcast com/google/protobuf/Timestamp
    //   325: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   328: aload_1
    //   329: ifnull -> 123
    //   332: aload_1
    //   333: aload_0
    //   334: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   337: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   340: pop
    //   341: aload_0
    //   342: aload_1
    //   343: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   346: checkcast com/google/protobuf/Timestamp
    //   349: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   352: goto -> 123
    //   355: aload_0
    //   356: aload_2
    //   357: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   360: putfield document_ : Ljava/lang/String;
    //   363: goto -> 123
    //   366: iconst_1
    //   367: istore #4
    //   369: goto -> 123
    //   372: astore_1
    //   373: goto -> 420
    //   376: astore_2
    //   377: new java/lang/RuntimeException
    //   380: astore_1
    //   381: new com/google/protobuf/InvalidProtocolBufferException
    //   384: astore_3
    //   385: aload_3
    //   386: aload_2
    //   387: invokevirtual getMessage : ()Ljava/lang/String;
    //   390: invokespecial <init> : (Ljava/lang/String;)V
    //   393: aload_1
    //   394: aload_3
    //   395: aload_0
    //   396: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   399: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   402: aload_1
    //   403: athrow
    //   404: astore_2
    //   405: new java/lang/RuntimeException
    //   408: astore_1
    //   409: aload_1
    //   410: aload_2
    //   411: aload_0
    //   412: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   415: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: athrow
    //   420: aload_1
    //   421: athrow
    //   422: getstatic com/google/firestore/v1/DocumentDelete.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentDelete;
    //   425: areturn
    //   426: aload_2
    //   427: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   430: astore_1
    //   431: aload_3
    //   432: checkcast com/google/firestore/v1/DocumentDelete
    //   435: astore_2
    //   436: aload_0
    //   437: aload_1
    //   438: aload_0
    //   439: getfield document_ : Ljava/lang/String;
    //   442: invokevirtual isEmpty : ()Z
    //   445: iconst_1
    //   446: ixor
    //   447: aload_0
    //   448: getfield document_ : Ljava/lang/String;
    //   451: iconst_1
    //   452: aload_2
    //   453: getfield document_ : Ljava/lang/String;
    //   456: invokevirtual isEmpty : ()Z
    //   459: ixor
    //   460: aload_2
    //   461: getfield document_ : Ljava/lang/String;
    //   464: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   469: putfield document_ : Ljava/lang/String;
    //   472: aload_0
    //   473: aload_1
    //   474: aload_0
    //   475: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   478: aload_2
    //   479: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   482: invokeinterface visitIntList : (Lcom/google/protobuf/Internal$IntList;Lcom/google/protobuf/Internal$IntList;)Lcom/google/protobuf/Internal$IntList;
    //   487: putfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   490: aload_0
    //   491: aload_1
    //   492: aload_0
    //   493: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   496: aload_2
    //   497: getfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   500: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   505: checkcast com/google/protobuf/Timestamp
    //   508: putfield readTime_ : Lcom/google/protobuf/Timestamp;
    //   511: aload_1
    //   512: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   515: if_acmpne -> 531
    //   518: aload_0
    //   519: aload_0
    //   520: getfield bitField0_ : I
    //   523: aload_2
    //   524: getfield bitField0_ : I
    //   527: ior
    //   528: putfield bitField0_ : I
    //   531: aload_0
    //   532: areturn
    //   533: new com/google/firestore/v1/DocumentDelete$Builder
    //   536: dup
    //   537: aconst_null
    //   538: invokespecial <init> : (Lcom/google/firestore/v1/DocumentDelete$1;)V
    //   541: areturn
    //   542: aload_0
    //   543: getfield removedTargetIds_ : Lcom/google/protobuf/Internal$IntList;
    //   546: invokeinterface makeImmutable : ()V
    //   551: aconst_null
    //   552: areturn
    //   553: getstatic com/google/firestore/v1/DocumentDelete.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentDelete;
    //   556: areturn
    //   557: new com/google/firestore/v1/DocumentDelete
    //   560: dup
    //   561: invokespecial <init> : ()V
    //   564: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	404	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	376	java/io/IOException
    //   128	134	372	finally
    //   167	176	404	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	376	java/io/IOException
    //   167	176	372	finally
    //   179	219	404	com/google/protobuf/InvalidProtocolBufferException
    //   179	219	376	java/io/IOException
    //   179	219	372	finally
    //   219	239	404	com/google/protobuf/InvalidProtocolBufferException
    //   219	239	376	java/io/IOException
    //   219	239	372	finally
    //   242	248	404	com/google/protobuf/InvalidProtocolBufferException
    //   242	248	376	java/io/IOException
    //   242	248	372	finally
    //   251	274	404	com/google/protobuf/InvalidProtocolBufferException
    //   251	274	376	java/io/IOException
    //   251	274	372	finally
    //   274	287	404	com/google/protobuf/InvalidProtocolBufferException
    //   274	287	376	java/io/IOException
    //   274	287	372	finally
    //   290	308	404	com/google/protobuf/InvalidProtocolBufferException
    //   290	308	376	java/io/IOException
    //   290	308	372	finally
    //   313	328	404	com/google/protobuf/InvalidProtocolBufferException
    //   313	328	376	java/io/IOException
    //   313	328	372	finally
    //   332	352	404	com/google/protobuf/InvalidProtocolBufferException
    //   332	352	376	java/io/IOException
    //   332	352	372	finally
    //   355	363	404	com/google/protobuf/InvalidProtocolBufferException
    //   355	363	376	java/io/IOException
    //   355	363	372	finally
    //   377	404	372	finally
    //   405	420	372	finally
  }
  
  public String getDocument() {
    return this.document_;
  }
  
  public ByteString getDocumentBytes() {
    return ByteString.copyFromUtf8(this.document_);
  }
  
  public Timestamp getReadTime() {
    Timestamp timestamp1 = this.readTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
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
    boolean bool = this.document_.isEmpty();
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getDocument()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.readTime_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getReadTime()); 
    i = 0;
    while (b < this.removedTargetIds_.size()) {
      i += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(b));
      b++;
    } 
    i = j + i + getRemovedTargetIdsList().size() * 1;
    this.memoizedSerializedSize = i;
    return i;
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
    if (!this.document_.isEmpty())
      paramCodedOutputStream.writeString(1, getDocument()); 
    if (this.readTime_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getReadTime()); 
    for (byte b = 0; b < this.removedTargetIds_.size(); b++)
      paramCodedOutputStream.writeInt32(6, this.removedTargetIds_.getInt(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DocumentDelete, Builder> implements DocumentDeleteOrBuilder {
    private Builder() {
      super(DocumentDelete.DEFAULT_INSTANCE);
    }
    
    public Builder addAllRemovedTargetIds(Iterable<? extends Integer> param1Iterable) {
      copyOnWrite();
      ((DocumentDelete)this.instance).addAllRemovedTargetIds(param1Iterable);
      return this;
    }
    
    public Builder addRemovedTargetIds(int param1Int) {
      copyOnWrite();
      ((DocumentDelete)this.instance).addRemovedTargetIds(param1Int);
      return this;
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((DocumentDelete)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((DocumentDelete)this.instance).clearReadTime();
      return this;
    }
    
    public Builder clearRemovedTargetIds() {
      copyOnWrite();
      ((DocumentDelete)this.instance).clearRemovedTargetIds();
      return this;
    }
    
    public String getDocument() {
      return ((DocumentDelete)this.instance).getDocument();
    }
    
    public ByteString getDocumentBytes() {
      return ((DocumentDelete)this.instance).getDocumentBytes();
    }
    
    public Timestamp getReadTime() {
      return ((DocumentDelete)this.instance).getReadTime();
    }
    
    public int getRemovedTargetIds(int param1Int) {
      return ((DocumentDelete)this.instance).getRemovedTargetIds(param1Int);
    }
    
    public int getRemovedTargetIdsCount() {
      return ((DocumentDelete)this.instance).getRemovedTargetIdsCount();
    }
    
    public List<Integer> getRemovedTargetIdsList() {
      return Collections.unmodifiableList(((DocumentDelete)this.instance).getRemovedTargetIdsList());
    }
    
    public boolean hasReadTime() {
      return ((DocumentDelete)this.instance).hasReadTime();
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((DocumentDelete)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setDocument(String param1String) {
      copyOnWrite();
      ((DocumentDelete)this.instance).setDocument(param1String);
      return this;
    }
    
    public Builder setDocumentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentDelete)this.instance).setDocumentBytes(param1ByteString);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((DocumentDelete)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((DocumentDelete)this.instance).setReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setRemovedTargetIds(int param1Int1, int param1Int2) {
      copyOnWrite();
      ((DocumentDelete)this.instance).setRemovedTargetIds(param1Int1, param1Int2);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentDelete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */