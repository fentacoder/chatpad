package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class WriteRequest extends GeneratedMessageLite<WriteRequest, WriteRequest.Builder> implements WriteRequestOrBuilder {
  public static final int DATABASE_FIELD_NUMBER = 1;
  
  private static final WriteRequest DEFAULT_INSTANCE = new WriteRequest();
  
  public static final int LABELS_FIELD_NUMBER = 5;
  
  private static volatile Parser<WriteRequest> PARSER;
  
  public static final int STREAM_ID_FIELD_NUMBER = 2;
  
  public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
  
  public static final int WRITES_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private String database_ = "";
  
  private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
  
  private String streamId_ = "";
  
  private ByteString streamToken_ = ByteString.EMPTY;
  
  private Internal.ProtobufList<Write> writes_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllWrites(Iterable<? extends Write> paramIterable) {
    ensureWritesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.writes_);
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
  
  private void clearDatabase() {
    this.database_ = getDefaultInstance().getDatabase();
  }
  
  private void clearStreamId() {
    this.streamId_ = getDefaultInstance().getStreamId();
  }
  
  private void clearStreamToken() {
    this.streamToken_ = getDefaultInstance().getStreamToken();
  }
  
  private void clearWrites() {
    this.writes_ = emptyProtobufList();
  }
  
  private void ensureWritesIsMutable() {
    if (!this.writes_.isModifiable())
      this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_); 
  }
  
  public static WriteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, String> getMutableLabelsMap() {
    return (Map<String, String>)internalGetMutableLabels();
  }
  
  private MapFieldLite<String, String> internalGetLabels() {
    return this.labels_;
  }
  
  private MapFieldLite<String, String> internalGetMutableLabels() {
    if (!this.labels_.isMutable())
      this.labels_ = this.labels_.mutableCopy(); 
    return this.labels_;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(WriteRequest paramWriteRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWriteRequest);
  }
  
  public static WriteRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (WriteRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static WriteRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static WriteRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static WriteRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static WriteRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<WriteRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeWrites(int paramInt) {
    ensureWritesIsMutable();
    this.writes_.remove(paramInt);
  }
  
  private void setDatabase(String paramString) {
    if (paramString != null) {
      this.database_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDatabaseBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.database_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamId(String paramString) {
    if (paramString != null) {
      this.streamId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.streamId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStreamToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.streamToken_ = paramByteString;
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
  
  public boolean containsLabels(String paramString) {
    if (paramString != null)
      return internalGetLabels().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/WriteRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 594, 2 -> 590, 3 -> 572, 4 -> 563, 5 -> 367, 6 -> 118, 7 -> 363, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/WriteRequest.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/WriteRequest
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/WriteRequest.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/WriteRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteRequest;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/WriteRequest.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/WriteRequest
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/WriteRequest
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/WriteRequest.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 363
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 307
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 296
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 285
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 238
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 227
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 191
    //   179: aload_1
    //   180: iload #4
    //   182: invokevirtual skipField : (I)Z
    //   185: ifne -> 128
    //   188: goto -> 307
    //   191: aload_0
    //   192: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   195: invokevirtual isMutable : ()Z
    //   198: ifne -> 212
    //   201: aload_0
    //   202: aload_0
    //   203: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   206: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   209: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   212: getstatic com/google/firestore/v1/WriteRequest$LabelsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   215: aload_0
    //   216: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   219: aload_1
    //   220: aload_2
    //   221: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   224: goto -> 128
    //   227: aload_0
    //   228: aload_1
    //   229: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   232: putfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   235: goto -> 128
    //   238: aload_0
    //   239: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: invokeinterface isModifiable : ()Z
    //   247: ifne -> 261
    //   250: aload_0
    //   251: aload_0
    //   252: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   255: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   258: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   261: aload_0
    //   262: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   265: aload_1
    //   266: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   269: aload_2
    //   270: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   273: checkcast com/google/firestore/v1/Write
    //   276: invokeinterface add : (Ljava/lang/Object;)Z
    //   281: pop
    //   282: goto -> 128
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   290: putfield streamId_ : Ljava/lang/String;
    //   293: goto -> 128
    //   296: aload_0
    //   297: aload_1
    //   298: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   301: putfield database_ : Ljava/lang/String;
    //   304: goto -> 128
    //   307: iconst_1
    //   308: istore #6
    //   310: goto -> 128
    //   313: astore_1
    //   314: goto -> 361
    //   317: astore_1
    //   318: new java/lang/RuntimeException
    //   321: astore_3
    //   322: new com/google/protobuf/InvalidProtocolBufferException
    //   325: astore_2
    //   326: aload_2
    //   327: aload_1
    //   328: invokevirtual getMessage : ()Ljava/lang/String;
    //   331: invokespecial <init> : (Ljava/lang/String;)V
    //   334: aload_3
    //   335: aload_2
    //   336: aload_0
    //   337: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   340: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   343: aload_3
    //   344: athrow
    //   345: astore_2
    //   346: new java/lang/RuntimeException
    //   349: astore_1
    //   350: aload_1
    //   351: aload_2
    //   352: aload_0
    //   353: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   356: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   359: aload_1
    //   360: athrow
    //   361: aload_1
    //   362: athrow
    //   363: getstatic com/google/firestore/v1/WriteRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteRequest;
    //   366: areturn
    //   367: aload_2
    //   368: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   371: astore_1
    //   372: aload_3
    //   373: checkcast com/google/firestore/v1/WriteRequest
    //   376: astore_3
    //   377: aload_0
    //   378: aload_1
    //   379: aload_0
    //   380: getfield database_ : Ljava/lang/String;
    //   383: invokevirtual isEmpty : ()Z
    //   386: iconst_1
    //   387: ixor
    //   388: aload_0
    //   389: getfield database_ : Ljava/lang/String;
    //   392: aload_3
    //   393: getfield database_ : Ljava/lang/String;
    //   396: invokevirtual isEmpty : ()Z
    //   399: iconst_1
    //   400: ixor
    //   401: aload_3
    //   402: getfield database_ : Ljava/lang/String;
    //   405: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   410: putfield database_ : Ljava/lang/String;
    //   413: aload_0
    //   414: aload_1
    //   415: aload_0
    //   416: getfield streamId_ : Ljava/lang/String;
    //   419: invokevirtual isEmpty : ()Z
    //   422: iconst_1
    //   423: ixor
    //   424: aload_0
    //   425: getfield streamId_ : Ljava/lang/String;
    //   428: aload_3
    //   429: getfield streamId_ : Ljava/lang/String;
    //   432: invokevirtual isEmpty : ()Z
    //   435: iconst_1
    //   436: ixor
    //   437: aload_3
    //   438: getfield streamId_ : Ljava/lang/String;
    //   441: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   446: putfield streamId_ : Ljava/lang/String;
    //   449: aload_0
    //   450: aload_1
    //   451: aload_0
    //   452: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   455: aload_3
    //   456: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   459: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   464: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   467: aload_0
    //   468: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   471: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   474: if_acmpeq -> 483
    //   477: iconst_1
    //   478: istore #7
    //   480: goto -> 486
    //   483: iconst_0
    //   484: istore #7
    //   486: aload_0
    //   487: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   490: astore_2
    //   491: aload_3
    //   492: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   495: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   498: if_acmpeq -> 504
    //   501: iconst_1
    //   502: istore #5
    //   504: aload_0
    //   505: aload_1
    //   506: iload #7
    //   508: aload_2
    //   509: iload #5
    //   511: aload_3
    //   512: getfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   515: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   520: putfield streamToken_ : Lcom/google/protobuf/ByteString;
    //   523: aload_0
    //   524: aload_1
    //   525: aload_0
    //   526: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   529: aload_3
    //   530: invokespecial internalGetLabels : ()Lcom/google/protobuf/MapFieldLite;
    //   533: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   538: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   541: aload_1
    //   542: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   545: if_acmpne -> 561
    //   548: aload_0
    //   549: aload_0
    //   550: getfield bitField0_ : I
    //   553: aload_3
    //   554: getfield bitField0_ : I
    //   557: ior
    //   558: putfield bitField0_ : I
    //   561: aload_0
    //   562: areturn
    //   563: new com/google/firestore/v1/WriteRequest$Builder
    //   566: dup
    //   567: aconst_null
    //   568: invokespecial <init> : (Lcom/google/firestore/v1/WriteRequest$1;)V
    //   571: areturn
    //   572: aload_0
    //   573: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   576: invokeinterface makeImmutable : ()V
    //   581: aload_0
    //   582: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   585: invokevirtual makeImmutable : ()V
    //   588: aconst_null
    //   589: areturn
    //   590: getstatic com/google/firestore/v1/WriteRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteRequest;
    //   593: areturn
    //   594: new com/google/firestore/v1/WriteRequest
    //   597: dup
    //   598: invokespecial <init> : ()V
    //   601: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	345	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	317	java/io/IOException
    //   133	139	313	finally
    //   179	188	345	com/google/protobuf/InvalidProtocolBufferException
    //   179	188	317	java/io/IOException
    //   179	188	313	finally
    //   191	212	345	com/google/protobuf/InvalidProtocolBufferException
    //   191	212	317	java/io/IOException
    //   191	212	313	finally
    //   212	224	345	com/google/protobuf/InvalidProtocolBufferException
    //   212	224	317	java/io/IOException
    //   212	224	313	finally
    //   227	235	345	com/google/protobuf/InvalidProtocolBufferException
    //   227	235	317	java/io/IOException
    //   227	235	313	finally
    //   238	261	345	com/google/protobuf/InvalidProtocolBufferException
    //   238	261	317	java/io/IOException
    //   238	261	313	finally
    //   261	282	345	com/google/protobuf/InvalidProtocolBufferException
    //   261	282	317	java/io/IOException
    //   261	282	313	finally
    //   285	293	345	com/google/protobuf/InvalidProtocolBufferException
    //   285	293	317	java/io/IOException
    //   285	293	313	finally
    //   296	304	345	com/google/protobuf/InvalidProtocolBufferException
    //   296	304	317	java/io/IOException
    //   296	304	313	finally
    //   318	345	313	finally
    //   346	361	313	finally
  }
  
  public String getDatabase() {
    return this.database_;
  }
  
  public ByteString getDatabaseBytes() {
    return ByteString.copyFromUtf8(this.database_);
  }
  
  @Deprecated
  public Map<String, String> getLabels() {
    return getLabelsMap();
  }
  
  public int getLabelsCount() {
    return internalGetLabels().size();
  }
  
  public Map<String, String> getLabelsMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends String>)internalGetLabels());
  }
  
  public String getLabelsOrDefault(String paramString1, String paramString2) {
    if (paramString1 != null) {
      MapFieldLite<String, String> mapFieldLite = internalGetLabels();
      if (mapFieldLite.containsKey(paramString1))
        paramString2 = mapFieldLite.get(paramString1); 
      return paramString2;
    } 
    throw new NullPointerException();
  }
  
  public String getLabelsOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, String> mapFieldLite = internalGetLabels();
      if (mapFieldLite.containsKey(paramString))
        return mapFieldLite.get(paramString); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.database_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      j = CodedOutputStream.computeStringSize(1, getDatabase()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    byte b2 = b1;
    if (!this.streamId_.isEmpty()) {
      i = j + CodedOutputStream.computeStringSize(2, getStreamId());
      b2 = b1;
    } 
    while (b2 < this.writes_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.writes_.get(b2));
      b2++;
    } 
    int j = i;
    if (!this.streamToken_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(4, this.streamToken_); 
    for (Map.Entry entry : internalGetLabels().entrySet())
      j += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(5, entry.getKey(), entry.getValue()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getStreamId() {
    return this.streamId_;
  }
  
  public ByteString getStreamIdBytes() {
    return ByteString.copyFromUtf8(this.streamId_);
  }
  
  public ByteString getStreamToken() {
    return this.streamToken_;
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
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.database_.isEmpty())
      paramCodedOutputStream.writeString(1, getDatabase()); 
    if (!this.streamId_.isEmpty())
      paramCodedOutputStream.writeString(2, getStreamId()); 
    for (byte b = 0; b < this.writes_.size(); b++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.writes_.get(b)); 
    if (!this.streamToken_.isEmpty())
      paramCodedOutputStream.writeBytes(4, this.streamToken_); 
    for (Map.Entry entry : internalGetLabels().entrySet())
      LabelsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 5, entry.getKey(), entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<WriteRequest, Builder> implements WriteRequestOrBuilder {
    private Builder() {
      super(WriteRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllWrites(Iterable<? extends Write> param1Iterable) {
      copyOnWrite();
      ((WriteRequest)this.instance).addAllWrites(param1Iterable);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteRequest)this.instance).addWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteRequest)this.instance).addWrites(param1Int, param1Write);
      return this;
    }
    
    public Builder addWrites(Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteRequest)this.instance).addWrites(param1Builder);
      return this;
    }
    
    public Builder addWrites(Write param1Write) {
      copyOnWrite();
      ((WriteRequest)this.instance).addWrites(param1Write);
      return this;
    }
    
    public Builder clearDatabase() {
      copyOnWrite();
      ((WriteRequest)this.instance).clearDatabase();
      return this;
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((WriteRequest)this.instance).getMutableLabelsMap().clear();
      return this;
    }
    
    public Builder clearStreamId() {
      copyOnWrite();
      ((WriteRequest)this.instance).clearStreamId();
      return this;
    }
    
    public Builder clearStreamToken() {
      copyOnWrite();
      ((WriteRequest)this.instance).clearStreamToken();
      return this;
    }
    
    public Builder clearWrites() {
      copyOnWrite();
      ((WriteRequest)this.instance).clearWrites();
      return this;
    }
    
    public boolean containsLabels(String param1String) {
      if (param1String != null)
        return ((WriteRequest)this.instance).getLabelsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public String getDatabase() {
      return ((WriteRequest)this.instance).getDatabase();
    }
    
    public ByteString getDatabaseBytes() {
      return ((WriteRequest)this.instance).getDatabaseBytes();
    }
    
    @Deprecated
    public Map<String, String> getLabels() {
      return getLabelsMap();
    }
    
    public int getLabelsCount() {
      return ((WriteRequest)this.instance).getLabelsMap().size();
    }
    
    public Map<String, String> getLabelsMap() {
      return Collections.unmodifiableMap(((WriteRequest)this.instance).getLabelsMap());
    }
    
    public String getLabelsOrDefault(String param1String1, String param1String2) {
      if (param1String1 != null) {
        Map<String, String> map = ((WriteRequest)this.instance).getLabelsMap();
        if (map.containsKey(param1String1))
          param1String2 = map.get(param1String1); 
        return param1String2;
      } 
      throw new NullPointerException();
    }
    
    public String getLabelsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, String> map = ((WriteRequest)this.instance).getLabelsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public String getStreamId() {
      return ((WriteRequest)this.instance).getStreamId();
    }
    
    public ByteString getStreamIdBytes() {
      return ((WriteRequest)this.instance).getStreamIdBytes();
    }
    
    public ByteString getStreamToken() {
      return ((WriteRequest)this.instance).getStreamToken();
    }
    
    public Write getWrites(int param1Int) {
      return ((WriteRequest)this.instance).getWrites(param1Int);
    }
    
    public int getWritesCount() {
      return ((WriteRequest)this.instance).getWritesCount();
    }
    
    public List<Write> getWritesList() {
      return Collections.unmodifiableList(((WriteRequest)this.instance).getWritesList());
    }
    
    public Builder putAllLabels(Map<String, String> param1Map) {
      copyOnWrite();
      ((WriteRequest)this.instance).getMutableLabelsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putLabels(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (param1String2 != null) {
          copyOnWrite();
          ((WriteRequest)this.instance).getMutableLabelsMap().put(param1String1, param1String2);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeLabels(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((WriteRequest)this.instance).getMutableLabelsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder removeWrites(int param1Int) {
      copyOnWrite();
      ((WriteRequest)this.instance).removeWrites(param1Int);
      return this;
    }
    
    public Builder setDatabase(String param1String) {
      copyOnWrite();
      ((WriteRequest)this.instance).setDatabase(param1String);
      return this;
    }
    
    public Builder setDatabaseBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((WriteRequest)this.instance).setDatabaseBytes(param1ByteString);
      return this;
    }
    
    public Builder setStreamId(String param1String) {
      copyOnWrite();
      ((WriteRequest)this.instance).setStreamId(param1String);
      return this;
    }
    
    public Builder setStreamIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((WriteRequest)this.instance).setStreamIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setStreamToken(ByteString param1ByteString) {
      copyOnWrite();
      ((WriteRequest)this.instance).setStreamToken(param1ByteString);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((WriteRequest)this.instance).setWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((WriteRequest)this.instance).setWrites(param1Int, param1Write);
      return this;
    }
  }
  
  private static final class LabelsDefaultEntryHolder {
    static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */