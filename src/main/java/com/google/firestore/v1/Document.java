package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class Document extends GeneratedMessageLite<Document, Document.Builder> implements DocumentOrBuilder {
  public static final int CREATE_TIME_FIELD_NUMBER = 3;
  
  private static final Document DEFAULT_INSTANCE = new Document();
  
  public static final int FIELDS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Document> PARSER;
  
  public static final int UPDATE_TIME_FIELD_NUMBER = 4;
  
  private int bitField0_;
  
  private Timestamp createTime_;
  
  private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
  
  private String name_ = "";
  
  private Timestamp updateTime_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCreateTime() {
    this.createTime_ = null;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearUpdateTime() {
    this.updateTime_ = null;
  }
  
  public static Document getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Value> getMutableFieldsMap() {
    return (Map<String, Value>)internalGetMutableFields();
  }
  
  private MapFieldLite<String, Value> internalGetFields() {
    return this.fields_;
  }
  
  private MapFieldLite<String, Value> internalGetMutableFields() {
    if (!this.fields_.isMutable())
      this.fields_ = this.fields_.mutableCopy(); 
    return this.fields_;
  }
  
  private void mergeCreateTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.createTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.createTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.createTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.createTime_ = paramTimestamp;
    } 
  }
  
  private void mergeUpdateTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.updateTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.updateTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.updateTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.updateTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Document paramDocument) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocument);
  }
  
  public static Document parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Document)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Document parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Document)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Document parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Document parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Document parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Document parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Document parseFrom(InputStream paramInputStream) throws IOException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Document parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Document parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Document parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Document)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Document> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCreateTime(Timestamp.Builder paramBuilder) {
    this.createTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setCreateTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.createTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUpdateTime(Timestamp.Builder paramBuilder) {
    this.updateTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setUpdateTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.updateTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  public boolean containsFields(String paramString) {
    if (paramString != null)
      return internalGetFields().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/Document$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 566, 2 -> 562, 3 -> 553, 4 -> 544, 5 -> 416, 6 -> 110, 7 -> 412, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/Document.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/Document
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/Document.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/Document.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Document;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/Document.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/Document
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/Document
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/Document.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 412
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 356
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 345
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
    //   176: goto -> 356
    //   179: aload_0
    //   180: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   183: ifnull -> 200
    //   186: aload_0
    //   187: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   190: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   193: checkcast com/google/protobuf/Timestamp$Builder
    //   196: astore_1
    //   197: goto -> 202
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_0
    //   203: aload_2
    //   204: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   207: aload_3
    //   208: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   211: checkcast com/google/protobuf/Timestamp
    //   214: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   217: aload_1
    //   218: ifnull -> 123
    //   221: aload_1
    //   222: aload_0
    //   223: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   226: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   229: pop
    //   230: aload_0
    //   231: aload_1
    //   232: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   235: checkcast com/google/protobuf/Timestamp
    //   238: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   241: goto -> 123
    //   244: aload_0
    //   245: getfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   248: ifnull -> 265
    //   251: aload_0
    //   252: getfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   255: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   258: checkcast com/google/protobuf/Timestamp$Builder
    //   261: astore_1
    //   262: goto -> 267
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_0
    //   268: aload_2
    //   269: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   272: aload_3
    //   273: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   276: checkcast com/google/protobuf/Timestamp
    //   279: putfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   282: aload_1
    //   283: ifnull -> 123
    //   286: aload_1
    //   287: aload_0
    //   288: getfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   291: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   294: pop
    //   295: aload_0
    //   296: aload_1
    //   297: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   300: checkcast com/google/protobuf/Timestamp
    //   303: putfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   306: goto -> 123
    //   309: aload_0
    //   310: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   313: invokevirtual isMutable : ()Z
    //   316: ifne -> 330
    //   319: aload_0
    //   320: aload_0
    //   321: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   324: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   327: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   330: getstatic com/google/firestore/v1/Document$FieldsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   333: aload_0
    //   334: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   337: aload_2
    //   338: aload_3
    //   339: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   342: goto -> 123
    //   345: aload_0
    //   346: aload_2
    //   347: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   350: putfield name_ : Ljava/lang/String;
    //   353: goto -> 123
    //   356: iconst_1
    //   357: istore #4
    //   359: goto -> 123
    //   362: astore_1
    //   363: goto -> 410
    //   366: astore_1
    //   367: new java/lang/RuntimeException
    //   370: astore_3
    //   371: new com/google/protobuf/InvalidProtocolBufferException
    //   374: astore_2
    //   375: aload_2
    //   376: aload_1
    //   377: invokevirtual getMessage : ()Ljava/lang/String;
    //   380: invokespecial <init> : (Ljava/lang/String;)V
    //   383: aload_3
    //   384: aload_2
    //   385: aload_0
    //   386: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   389: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   392: aload_3
    //   393: athrow
    //   394: astore_1
    //   395: new java/lang/RuntimeException
    //   398: astore_2
    //   399: aload_2
    //   400: aload_1
    //   401: aload_0
    //   402: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   405: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   408: aload_2
    //   409: athrow
    //   410: aload_1
    //   411: athrow
    //   412: getstatic com/google/firestore/v1/Document.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Document;
    //   415: areturn
    //   416: aload_2
    //   417: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   420: astore_1
    //   421: aload_3
    //   422: checkcast com/google/firestore/v1/Document
    //   425: astore_2
    //   426: aload_0
    //   427: aload_1
    //   428: aload_0
    //   429: getfield name_ : Ljava/lang/String;
    //   432: invokevirtual isEmpty : ()Z
    //   435: iconst_1
    //   436: ixor
    //   437: aload_0
    //   438: getfield name_ : Ljava/lang/String;
    //   441: iconst_1
    //   442: aload_2
    //   443: getfield name_ : Ljava/lang/String;
    //   446: invokevirtual isEmpty : ()Z
    //   449: ixor
    //   450: aload_2
    //   451: getfield name_ : Ljava/lang/String;
    //   454: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   459: putfield name_ : Ljava/lang/String;
    //   462: aload_0
    //   463: aload_1
    //   464: aload_0
    //   465: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   468: aload_2
    //   469: invokespecial internalGetFields : ()Lcom/google/protobuf/MapFieldLite;
    //   472: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   477: putfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   480: aload_0
    //   481: aload_1
    //   482: aload_0
    //   483: getfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   486: aload_2
    //   487: getfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   490: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   495: checkcast com/google/protobuf/Timestamp
    //   498: putfield createTime_ : Lcom/google/protobuf/Timestamp;
    //   501: aload_0
    //   502: aload_1
    //   503: aload_0
    //   504: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   507: aload_2
    //   508: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   511: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   516: checkcast com/google/protobuf/Timestamp
    //   519: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   522: aload_1
    //   523: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   526: if_acmpne -> 542
    //   529: aload_0
    //   530: aload_0
    //   531: getfield bitField0_ : I
    //   534: aload_2
    //   535: getfield bitField0_ : I
    //   538: ior
    //   539: putfield bitField0_ : I
    //   542: aload_0
    //   543: areturn
    //   544: new com/google/firestore/v1/Document$Builder
    //   547: dup
    //   548: aconst_null
    //   549: invokespecial <init> : (Lcom/google/firestore/v1/Document$1;)V
    //   552: areturn
    //   553: aload_0
    //   554: getfield fields_ : Lcom/google/protobuf/MapFieldLite;
    //   557: invokevirtual makeImmutable : ()V
    //   560: aconst_null
    //   561: areturn
    //   562: getstatic com/google/firestore/v1/Document.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Document;
    //   565: areturn
    //   566: new com/google/firestore/v1/Document
    //   569: dup
    //   570: invokespecial <init> : ()V
    //   573: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	394	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	366	java/io/IOException
    //   128	134	362	finally
    //   167	176	394	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	366	java/io/IOException
    //   167	176	362	finally
    //   179	197	394	com/google/protobuf/InvalidProtocolBufferException
    //   179	197	366	java/io/IOException
    //   179	197	362	finally
    //   202	217	394	com/google/protobuf/InvalidProtocolBufferException
    //   202	217	366	java/io/IOException
    //   202	217	362	finally
    //   221	241	394	com/google/protobuf/InvalidProtocolBufferException
    //   221	241	366	java/io/IOException
    //   221	241	362	finally
    //   244	262	394	com/google/protobuf/InvalidProtocolBufferException
    //   244	262	366	java/io/IOException
    //   244	262	362	finally
    //   267	282	394	com/google/protobuf/InvalidProtocolBufferException
    //   267	282	366	java/io/IOException
    //   267	282	362	finally
    //   286	306	394	com/google/protobuf/InvalidProtocolBufferException
    //   286	306	366	java/io/IOException
    //   286	306	362	finally
    //   309	330	394	com/google/protobuf/InvalidProtocolBufferException
    //   309	330	366	java/io/IOException
    //   309	330	362	finally
    //   330	342	394	com/google/protobuf/InvalidProtocolBufferException
    //   330	342	366	java/io/IOException
    //   330	342	362	finally
    //   345	353	394	com/google/protobuf/InvalidProtocolBufferException
    //   345	353	366	java/io/IOException
    //   345	353	362	finally
    //   367	394	362	finally
    //   395	410	362	finally
  }
  
  public Timestamp getCreateTime() {
    Timestamp timestamp1 = this.createTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  @Deprecated
  public Map<String, Value> getFields() {
    return getFieldsMap();
  }
  
  public int getFieldsCount() {
    return internalGetFields().size();
  }
  
  public Map<String, Value> getFieldsMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends Value>)internalGetFields());
  }
  
  public Value getFieldsOrDefault(String paramString, Value paramValue) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        paramValue = mapFieldLite.get(paramString); 
      return paramValue;
    } 
    throw new NullPointerException();
  }
  
  public Value getFieldsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, Value> mapFieldLite = internalGetFields();
      if (mapFieldLite.containsKey(paramString))
        return mapFieldLite.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.name_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    for (Map.Entry entry : internalGetFields().entrySet())
      j += FieldsDefaultEntryHolder.defaultEntry.computeMessageSize(2, entry.getKey(), entry.getValue()); 
    i = j;
    if (this.createTime_ != null)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getCreateTime()); 
    j = i;
    if (this.updateTime_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getUpdateTime()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Timestamp getUpdateTime() {
    Timestamp timestamp1 = this.updateTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public boolean hasCreateTime() {
    boolean bool;
    if (this.createTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasUpdateTime() {
    boolean bool;
    if (this.updateTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    for (Map.Entry entry : internalGetFields().entrySet())
      FieldsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 2, entry.getKey(), entry.getValue()); 
    if (this.createTime_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getCreateTime()); 
    if (this.updateTime_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getUpdateTime()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Document, Builder> implements DocumentOrBuilder {
    private Builder() {
      super(Document.DEFAULT_INSTANCE);
    }
    
    public Builder clearCreateTime() {
      copyOnWrite();
      ((Document)this.instance).clearCreateTime();
      return this;
    }
    
    public Builder clearFields() {
      copyOnWrite();
      ((Document)this.instance).getMutableFieldsMap().clear();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Document)this.instance).clearName();
      return this;
    }
    
    public Builder clearUpdateTime() {
      copyOnWrite();
      ((Document)this.instance).clearUpdateTime();
      return this;
    }
    
    public boolean containsFields(String param1String) {
      if (param1String != null)
        return ((Document)this.instance).getFieldsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public Timestamp getCreateTime() {
      return ((Document)this.instance).getCreateTime();
    }
    
    @Deprecated
    public Map<String, Value> getFields() {
      return getFieldsMap();
    }
    
    public int getFieldsCount() {
      return ((Document)this.instance).getFieldsMap().size();
    }
    
    public Map<String, Value> getFieldsMap() {
      return Collections.unmodifiableMap(((Document)this.instance).getFieldsMap());
    }
    
    public Value getFieldsOrDefault(String param1String, Value param1Value) {
      if (param1String != null) {
        Map<String, Value> map = ((Document)this.instance).getFieldsMap();
        if (map.containsKey(param1String))
          param1Value = map.get(param1String); 
        return param1Value;
      } 
      throw new NullPointerException();
    }
    
    public Value getFieldsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, Value> map = ((Document)this.instance).getFieldsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public String getName() {
      return ((Document)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Document)this.instance).getNameBytes();
    }
    
    public Timestamp getUpdateTime() {
      return ((Document)this.instance).getUpdateTime();
    }
    
    public boolean hasCreateTime() {
      return ((Document)this.instance).hasCreateTime();
    }
    
    public boolean hasUpdateTime() {
      return ((Document)this.instance).hasUpdateTime();
    }
    
    public Builder mergeCreateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Document)this.instance).mergeCreateTime(param1Timestamp);
      return this;
    }
    
    public Builder mergeUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Document)this.instance).mergeUpdateTime(param1Timestamp);
      return this;
    }
    
    public Builder putAllFields(Map<String, Value> param1Map) {
      copyOnWrite();
      ((Document)this.instance).getMutableFieldsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putFields(String param1String, Value param1Value) {
      if (param1String != null) {
        if (param1Value != null) {
          copyOnWrite();
          ((Document)this.instance).getMutableFieldsMap().put(param1String, param1Value);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeFields(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((Document)this.instance).getMutableFieldsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCreateTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Document)this.instance).setCreateTime(param1Builder);
      return this;
    }
    
    public Builder setCreateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Document)this.instance).setCreateTime(param1Timestamp);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Document)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Document)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Document)this.instance).setUpdateTime(param1Builder);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Document)this.instance).setUpdateTime(param1Timestamp);
      return this;
    }
  }
  
  private static final class FieldsDefaultEntryHolder {
    static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Document.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */