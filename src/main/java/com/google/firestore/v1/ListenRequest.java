package com.google.firestore.v1;

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
import java.util.Collections;
import java.util.Map;

public final class ListenRequest extends GeneratedMessageLite<ListenRequest, ListenRequest.Builder> implements ListenRequestOrBuilder {
  public static final int ADD_TARGET_FIELD_NUMBER = 2;
  
  public static final int DATABASE_FIELD_NUMBER = 1;
  
  private static final ListenRequest DEFAULT_INSTANCE = new ListenRequest();
  
  public static final int LABELS_FIELD_NUMBER = 4;
  
  private static volatile Parser<ListenRequest> PARSER;
  
  public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private String database_ = "";
  
  private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
  
  private int targetChangeCase_ = 0;
  
  private Object targetChange_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAddTarget() {
    if (this.targetChangeCase_ == 2) {
      this.targetChangeCase_ = 0;
      this.targetChange_ = null;
    } 
  }
  
  private void clearDatabase() {
    this.database_ = getDefaultInstance().getDatabase();
  }
  
  private void clearRemoveTarget() {
    if (this.targetChangeCase_ == 3) {
      this.targetChangeCase_ = 0;
      this.targetChange_ = null;
    } 
  }
  
  private void clearTargetChange() {
    this.targetChangeCase_ = 0;
    this.targetChange_ = null;
  }
  
  public static ListenRequest getDefaultInstance() {
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
  
  private void mergeAddTarget(Target paramTarget) {
    if (this.targetChangeCase_ == 2 && this.targetChange_ != Target.getDefaultInstance()) {
      this.targetChange_ = ((Target.Builder)Target.newBuilder((Target)this.targetChange_).mergeFrom(paramTarget)).buildPartial();
    } else {
      this.targetChange_ = paramTarget;
    } 
    this.targetChangeCase_ = 2;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListenRequest paramListenRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListenRequest);
  }
  
  public static ListenRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListenRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListenRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListenRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListenRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListenRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListenRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListenRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListenRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListenRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListenRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAddTarget(Target.Builder paramBuilder) {
    this.targetChange_ = paramBuilder.build();
    this.targetChangeCase_ = 2;
  }
  
  private void setAddTarget(Target paramTarget) {
    if (paramTarget != null) {
      this.targetChange_ = paramTarget;
      this.targetChangeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
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
  
  private void setRemoveTarget(int paramInt) {
    this.targetChangeCase_ = 3;
    this.targetChange_ = Integer.valueOf(paramInt);
  }
  
  public boolean containsLabels(String paramString) {
    if (paramString != null)
      return internalGetLabels().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ListenRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   22: iload #4
    //   24: tableswitch default -> 72, 1 -> 642, 2 -> 638, 3 -> 629, 4 -> 620, 5 -> 389, 6 -> 126, 7 -> 385, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/ListenRequest.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/ListenRequest
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/ListenRequest.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/ListenRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenRequest;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/ListenRequest.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/ListenRequest
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/ListenRequest
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/ListenRequest.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 385
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 329
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 318
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 247
    //   166: iload #4
    //   168: bipush #24
    //   170: if_icmpeq -> 228
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 192
    //   180: aload_2
    //   181: iload #4
    //   183: invokevirtual skipField : (I)Z
    //   186: ifne -> 136
    //   189: goto -> 329
    //   192: aload_0
    //   193: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   196: invokevirtual isMutable : ()Z
    //   199: ifne -> 213
    //   202: aload_0
    //   203: aload_0
    //   204: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   207: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   210: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   213: getstatic com/google/firestore/v1/ListenRequest$LabelsDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   216: aload_0
    //   217: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   220: aload_2
    //   221: aload_3
    //   222: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   225: goto -> 136
    //   228: aload_0
    //   229: iconst_3
    //   230: putfield targetChangeCase_ : I
    //   233: aload_0
    //   234: aload_2
    //   235: invokevirtual readInt32 : ()I
    //   238: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   241: putfield targetChange_ : Ljava/lang/Object;
    //   244: goto -> 136
    //   247: aload_0
    //   248: getfield targetChangeCase_ : I
    //   251: iconst_2
    //   252: if_icmpne -> 272
    //   255: aload_0
    //   256: getfield targetChange_ : Ljava/lang/Object;
    //   259: checkcast com/google/firestore/v1/Target
    //   262: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   265: checkcast com/google/firestore/v1/Target$Builder
    //   268: astore_1
    //   269: goto -> 274
    //   272: aconst_null
    //   273: astore_1
    //   274: aload_0
    //   275: aload_2
    //   276: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   279: aload_3
    //   280: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   283: putfield targetChange_ : Ljava/lang/Object;
    //   286: aload_1
    //   287: ifnull -> 310
    //   290: aload_1
    //   291: aload_0
    //   292: getfield targetChange_ : Ljava/lang/Object;
    //   295: checkcast com/google/firestore/v1/Target
    //   298: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   301: pop
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   307: putfield targetChange_ : Ljava/lang/Object;
    //   310: aload_0
    //   311: iconst_2
    //   312: putfield targetChangeCase_ : I
    //   315: goto -> 136
    //   318: aload_0
    //   319: aload_2
    //   320: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   323: putfield database_ : Ljava/lang/String;
    //   326: goto -> 136
    //   329: iconst_1
    //   330: istore #8
    //   332: goto -> 136
    //   335: astore_1
    //   336: goto -> 383
    //   339: astore_2
    //   340: new java/lang/RuntimeException
    //   343: astore_3
    //   344: new com/google/protobuf/InvalidProtocolBufferException
    //   347: astore_1
    //   348: aload_1
    //   349: aload_2
    //   350: invokevirtual getMessage : ()Ljava/lang/String;
    //   353: invokespecial <init> : (Ljava/lang/String;)V
    //   356: aload_3
    //   357: aload_1
    //   358: aload_0
    //   359: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   362: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   365: aload_3
    //   366: athrow
    //   367: astore_2
    //   368: new java/lang/RuntimeException
    //   371: astore_1
    //   372: aload_1
    //   373: aload_2
    //   374: aload_0
    //   375: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   378: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   381: aload_1
    //   382: athrow
    //   383: aload_1
    //   384: athrow
    //   385: getstatic com/google/firestore/v1/ListenRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenRequest;
    //   388: areturn
    //   389: aload_2
    //   390: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   393: astore_1
    //   394: aload_3
    //   395: checkcast com/google/firestore/v1/ListenRequest
    //   398: astore_2
    //   399: aload_0
    //   400: aload_1
    //   401: aload_0
    //   402: getfield database_ : Ljava/lang/String;
    //   405: invokevirtual isEmpty : ()Z
    //   408: iconst_1
    //   409: ixor
    //   410: aload_0
    //   411: getfield database_ : Ljava/lang/String;
    //   414: aload_2
    //   415: getfield database_ : Ljava/lang/String;
    //   418: invokevirtual isEmpty : ()Z
    //   421: iconst_1
    //   422: ixor
    //   423: aload_2
    //   424: getfield database_ : Ljava/lang/String;
    //   427: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   432: putfield database_ : Ljava/lang/String;
    //   435: aload_0
    //   436: aload_1
    //   437: aload_0
    //   438: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   441: aload_2
    //   442: invokespecial internalGetLabels : ()Lcom/google/protobuf/MapFieldLite;
    //   445: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   450: putfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   453: getstatic com/google/firestore/v1/ListenRequest$1.$SwitchMap$com$google$firestore$v1$ListenRequest$TargetChangeCase : [I
    //   456: aload_2
    //   457: invokevirtual getTargetChangeCase : ()Lcom/google/firestore/v1/ListenRequest$TargetChangeCase;
    //   460: invokevirtual ordinal : ()I
    //   463: iaload
    //   464: istore #8
    //   466: iload #8
    //   468: iconst_1
    //   469: if_icmpeq -> 546
    //   472: iload #8
    //   474: iconst_2
    //   475: if_icmpeq -> 508
    //   478: iload #8
    //   480: iconst_3
    //   481: if_icmpeq -> 487
    //   484: goto -> 581
    //   487: aload_0
    //   488: getfield targetChangeCase_ : I
    //   491: ifeq -> 497
    //   494: iconst_1
    //   495: istore #5
    //   497: aload_1
    //   498: iload #5
    //   500: invokeinterface visitOneofNotSet : (Z)V
    //   505: goto -> 581
    //   508: iload #6
    //   510: istore #5
    //   512: aload_0
    //   513: getfield targetChangeCase_ : I
    //   516: iconst_3
    //   517: if_icmpne -> 523
    //   520: iconst_1
    //   521: istore #5
    //   523: aload_0
    //   524: aload_1
    //   525: iload #5
    //   527: aload_0
    //   528: getfield targetChange_ : Ljava/lang/Object;
    //   531: aload_2
    //   532: getfield targetChange_ : Ljava/lang/Object;
    //   535: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   540: putfield targetChange_ : Ljava/lang/Object;
    //   543: goto -> 581
    //   546: iload #7
    //   548: istore #5
    //   550: aload_0
    //   551: getfield targetChangeCase_ : I
    //   554: iconst_2
    //   555: if_icmpne -> 561
    //   558: iconst_1
    //   559: istore #5
    //   561: aload_0
    //   562: aload_1
    //   563: iload #5
    //   565: aload_0
    //   566: getfield targetChange_ : Ljava/lang/Object;
    //   569: aload_2
    //   570: getfield targetChange_ : Ljava/lang/Object;
    //   573: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   578: putfield targetChange_ : Ljava/lang/Object;
    //   581: aload_1
    //   582: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   585: if_acmpne -> 618
    //   588: aload_2
    //   589: getfield targetChangeCase_ : I
    //   592: istore #8
    //   594: iload #8
    //   596: ifeq -> 605
    //   599: aload_0
    //   600: iload #8
    //   602: putfield targetChangeCase_ : I
    //   605: aload_0
    //   606: aload_0
    //   607: getfield bitField0_ : I
    //   610: aload_2
    //   611: getfield bitField0_ : I
    //   614: ior
    //   615: putfield bitField0_ : I
    //   618: aload_0
    //   619: areturn
    //   620: new com/google/firestore/v1/ListenRequest$Builder
    //   623: dup
    //   624: aconst_null
    //   625: invokespecial <init> : (Lcom/google/firestore/v1/ListenRequest$1;)V
    //   628: areturn
    //   629: aload_0
    //   630: getfield labels_ : Lcom/google/protobuf/MapFieldLite;
    //   633: invokevirtual makeImmutable : ()V
    //   636: aconst_null
    //   637: areturn
    //   638: getstatic com/google/firestore/v1/ListenRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListenRequest;
    //   641: areturn
    //   642: new com/google/firestore/v1/ListenRequest
    //   645: dup
    //   646: invokespecial <init> : ()V
    //   649: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	367	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	339	java/io/IOException
    //   141	147	335	finally
    //   180	189	367	com/google/protobuf/InvalidProtocolBufferException
    //   180	189	339	java/io/IOException
    //   180	189	335	finally
    //   192	213	367	com/google/protobuf/InvalidProtocolBufferException
    //   192	213	339	java/io/IOException
    //   192	213	335	finally
    //   213	225	367	com/google/protobuf/InvalidProtocolBufferException
    //   213	225	339	java/io/IOException
    //   213	225	335	finally
    //   228	244	367	com/google/protobuf/InvalidProtocolBufferException
    //   228	244	339	java/io/IOException
    //   228	244	335	finally
    //   247	269	367	com/google/protobuf/InvalidProtocolBufferException
    //   247	269	339	java/io/IOException
    //   247	269	335	finally
    //   274	286	367	com/google/protobuf/InvalidProtocolBufferException
    //   274	286	339	java/io/IOException
    //   274	286	335	finally
    //   290	310	367	com/google/protobuf/InvalidProtocolBufferException
    //   290	310	339	java/io/IOException
    //   290	310	335	finally
    //   310	315	367	com/google/protobuf/InvalidProtocolBufferException
    //   310	315	339	java/io/IOException
    //   310	315	335	finally
    //   318	326	367	com/google/protobuf/InvalidProtocolBufferException
    //   318	326	339	java/io/IOException
    //   318	326	335	finally
    //   340	367	335	finally
    //   368	383	335	finally
  }
  
  public Target getAddTarget() {
    return (this.targetChangeCase_ == 2) ? (Target)this.targetChange_ : Target.getDefaultInstance();
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
  
  public int getRemoveTarget() {
    return (this.targetChangeCase_ == 3) ? ((Integer)this.targetChange_).intValue() : 0;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.database_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getDatabase()); 
    i = j;
    if (this.targetChangeCase_ == 2)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.targetChange_); 
    j = i;
    if (this.targetChangeCase_ == 3)
      j = i + CodedOutputStream.computeInt32Size(3, ((Integer)this.targetChange_).intValue()); 
    for (Map.Entry entry : internalGetLabels().entrySet())
      j += LabelsDefaultEntryHolder.defaultEntry.computeMessageSize(4, entry.getKey(), entry.getValue()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public TargetChangeCase getTargetChangeCase() {
    return TargetChangeCase.forNumber(this.targetChangeCase_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.database_.isEmpty())
      paramCodedOutputStream.writeString(1, getDatabase()); 
    if (this.targetChangeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.targetChange_); 
    if (this.targetChangeCase_ == 3)
      paramCodedOutputStream.writeInt32(3, ((Integer)this.targetChange_).intValue()); 
    for (Map.Entry entry : internalGetLabels().entrySet())
      LabelsDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 4, entry.getKey(), entry.getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListenRequest, Builder> implements ListenRequestOrBuilder {
    private Builder() {
      super(ListenRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearAddTarget() {
      copyOnWrite();
      ((ListenRequest)this.instance).clearAddTarget();
      return this;
    }
    
    public Builder clearDatabase() {
      copyOnWrite();
      ((ListenRequest)this.instance).clearDatabase();
      return this;
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((ListenRequest)this.instance).getMutableLabelsMap().clear();
      return this;
    }
    
    public Builder clearRemoveTarget() {
      copyOnWrite();
      ((ListenRequest)this.instance).clearRemoveTarget();
      return this;
    }
    
    public Builder clearTargetChange() {
      copyOnWrite();
      ((ListenRequest)this.instance).clearTargetChange();
      return this;
    }
    
    public boolean containsLabels(String param1String) {
      if (param1String != null)
        return ((ListenRequest)this.instance).getLabelsMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public Target getAddTarget() {
      return ((ListenRequest)this.instance).getAddTarget();
    }
    
    public String getDatabase() {
      return ((ListenRequest)this.instance).getDatabase();
    }
    
    public ByteString getDatabaseBytes() {
      return ((ListenRequest)this.instance).getDatabaseBytes();
    }
    
    @Deprecated
    public Map<String, String> getLabels() {
      return getLabelsMap();
    }
    
    public int getLabelsCount() {
      return ((ListenRequest)this.instance).getLabelsMap().size();
    }
    
    public Map<String, String> getLabelsMap() {
      return Collections.unmodifiableMap(((ListenRequest)this.instance).getLabelsMap());
    }
    
    public String getLabelsOrDefault(String param1String1, String param1String2) {
      if (param1String1 != null) {
        Map<String, String> map = ((ListenRequest)this.instance).getLabelsMap();
        if (map.containsKey(param1String1))
          param1String2 = map.get(param1String1); 
        return param1String2;
      } 
      throw new NullPointerException();
    }
    
    public String getLabelsOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, String> map = ((ListenRequest)this.instance).getLabelsMap();
        if (map.containsKey(param1String))
          return map.get(param1String); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public int getRemoveTarget() {
      return ((ListenRequest)this.instance).getRemoveTarget();
    }
    
    public ListenRequest.TargetChangeCase getTargetChangeCase() {
      return ((ListenRequest)this.instance).getTargetChangeCase();
    }
    
    public Builder mergeAddTarget(Target param1Target) {
      copyOnWrite();
      ((ListenRequest)this.instance).mergeAddTarget(param1Target);
      return this;
    }
    
    public Builder putAllLabels(Map<String, String> param1Map) {
      copyOnWrite();
      ((ListenRequest)this.instance).getMutableLabelsMap().putAll(param1Map);
      return this;
    }
    
    public Builder putLabels(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (param1String2 != null) {
          copyOnWrite();
          ((ListenRequest)this.instance).getMutableLabelsMap().put(param1String1, param1String2);
          return this;
        } 
        throw new NullPointerException();
      } 
      throw new NullPointerException();
    }
    
    public Builder removeLabels(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((ListenRequest)this.instance).getMutableLabelsMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAddTarget(Target.Builder param1Builder) {
      copyOnWrite();
      ((ListenRequest)this.instance).setAddTarget(param1Builder);
      return this;
    }
    
    public Builder setAddTarget(Target param1Target) {
      copyOnWrite();
      ((ListenRequest)this.instance).setAddTarget(param1Target);
      return this;
    }
    
    public Builder setDatabase(String param1String) {
      copyOnWrite();
      ((ListenRequest)this.instance).setDatabase(param1String);
      return this;
    }
    
    public Builder setDatabaseBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListenRequest)this.instance).setDatabaseBytes(param1ByteString);
      return this;
    }
    
    public Builder setRemoveTarget(int param1Int) {
      copyOnWrite();
      ((ListenRequest)this.instance).setRemoveTarget(param1Int);
      return this;
    }
  }
  
  private static final class LabelsDefaultEntryHolder {
    static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
  }
  
  public enum TargetChangeCase implements Internal.EnumLite {
    ADD_TARGET(2),
    REMOVE_TARGET(3),
    TARGETCHANGE_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    TargetChangeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TargetChangeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? ((param1Int != 3) ? null : REMOVE_TARGET) : ADD_TARGET) : TARGETCHANGE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListenRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */