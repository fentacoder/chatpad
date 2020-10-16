package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Value extends GeneratedMessageLite<Value, Value.Builder> implements ValueOrBuilder {
  public static final int BOOL_VALUE_FIELD_NUMBER = 4;
  
  private static final Value DEFAULT_INSTANCE = new Value();
  
  public static final int LIST_VALUE_FIELD_NUMBER = 6;
  
  public static final int NULL_VALUE_FIELD_NUMBER = 1;
  
  public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
  
  private static volatile Parser<Value> PARSER;
  
  public static final int STRING_VALUE_FIELD_NUMBER = 3;
  
  public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
  
  private int kindCase_ = 0;
  
  private Object kind_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearBoolValue() {
    if (this.kindCase_ == 4) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearKind() {
    this.kindCase_ = 0;
    this.kind_ = null;
  }
  
  private void clearListValue() {
    if (this.kindCase_ == 6) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearNullValue() {
    if (this.kindCase_ == 1) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearNumberValue() {
    if (this.kindCase_ == 2) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearStringValue() {
    if (this.kindCase_ == 3) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearStructValue() {
    if (this.kindCase_ == 5) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  public static Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeListValue(ListValue paramListValue) {
    if (this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance()) {
      this.kind_ = ListValue.newBuilder((ListValue)this.kind_).mergeFrom(paramListValue).buildPartial();
    } else {
      this.kind_ = paramListValue;
    } 
    this.kindCase_ = 6;
  }
  
  private void mergeStructValue(Struct paramStruct) {
    if (this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance()) {
      this.kind_ = Struct.newBuilder((Struct)this.kind_).mergeFrom(paramStruct).buildPartial();
    } else {
      this.kind_ = paramStruct;
    } 
    this.kindCase_ = 5;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Value paramValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramValue);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setBoolValue(boolean paramBoolean) {
    this.kindCase_ = 4;
    this.kind_ = Boolean.valueOf(paramBoolean);
  }
  
  private void setListValue(ListValue.Builder paramBuilder) {
    this.kind_ = paramBuilder.build();
    this.kindCase_ = 6;
  }
  
  private void setListValue(ListValue paramListValue) {
    if (paramListValue != null) {
      this.kind_ = paramListValue;
      this.kindCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValue(NullValue paramNullValue) {
    if (paramNullValue != null) {
      this.kindCase_ = 1;
      this.kind_ = Integer.valueOf(paramNullValue.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValueValue(int paramInt) {
    this.kindCase_ = 1;
    this.kind_ = Integer.valueOf(paramInt);
  }
  
  private void setNumberValue(double paramDouble) {
    this.kindCase_ = 2;
    this.kind_ = Double.valueOf(paramDouble);
  }
  
  private void setStringValue(String paramString) {
    if (paramString != null) {
      this.kindCase_ = 3;
      this.kind_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStringValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.kindCase_ = 3;
      this.kind_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStructValue(Struct.Builder paramBuilder) {
    this.kind_ = paramBuilder.build();
    this.kindCase_ = 5;
  }
  
  private void setStructValue(Struct paramStruct) {
    if (paramStruct != null) {
      this.kind_ = paramStruct;
      this.kindCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   25: iconst_0
    //   26: istore #10
    //   28: iconst_0
    //   29: istore #11
    //   31: iconst_0
    //   32: istore #12
    //   34: iload #4
    //   36: tableswitch default -> 84, 1 -> 855, 2 -> 851, 3 -> 849, 4 -> 840, 5 -> 501, 6 -> 138, 7 -> 497, 8 -> 92
    //   84: new java/lang/UnsupportedOperationException
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: athrow
    //   92: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   95: ifnonnull -> 134
    //   98: ldc com/google/protobuf/Value
    //   100: monitorenter
    //   101: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   104: ifnonnull -> 122
    //   107: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   110: astore_1
    //   111: aload_1
    //   112: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   115: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   118: aload_1
    //   119: putstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   122: ldc com/google/protobuf/Value
    //   124: monitorexit
    //   125: goto -> 134
    //   128: astore_1
    //   129: ldc com/google/protobuf/Value
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   137: areturn
    //   138: aload_2
    //   139: checkcast com/google/protobuf/CodedInputStream
    //   142: astore_2
    //   143: aload_3
    //   144: checkcast com/google/protobuf/ExtensionRegistryLite
    //   147: astore_3
    //   148: iload #12
    //   150: ifne -> 497
    //   153: aload_2
    //   154: invokevirtual readTag : ()I
    //   157: istore #4
    //   159: iload #4
    //   161: ifeq -> 441
    //   164: iload #4
    //   166: bipush #8
    //   168: if_icmpeq -> 418
    //   171: iload #4
    //   173: bipush #17
    //   175: if_icmpeq -> 399
    //   178: iload #4
    //   180: bipush #26
    //   182: if_icmpeq -> 381
    //   185: iload #4
    //   187: bipush #32
    //   189: if_icmpeq -> 362
    //   192: iload #4
    //   194: bipush #42
    //   196: if_icmpeq -> 291
    //   199: iload #4
    //   201: bipush #50
    //   203: if_icmpeq -> 218
    //   206: aload_2
    //   207: iload #4
    //   209: invokevirtual skipField : (I)Z
    //   212: ifne -> 148
    //   215: goto -> 441
    //   218: aload_0
    //   219: getfield kindCase_ : I
    //   222: bipush #6
    //   224: if_icmpne -> 244
    //   227: aload_0
    //   228: getfield kind_ : Ljava/lang/Object;
    //   231: checkcast com/google/protobuf/ListValue
    //   234: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   237: checkcast com/google/protobuf/ListValue$Builder
    //   240: astore_1
    //   241: goto -> 246
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_0
    //   247: aload_2
    //   248: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   251: aload_3
    //   252: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   255: putfield kind_ : Ljava/lang/Object;
    //   258: aload_1
    //   259: ifnull -> 282
    //   262: aload_1
    //   263: aload_0
    //   264: getfield kind_ : Ljava/lang/Object;
    //   267: checkcast com/google/protobuf/ListValue
    //   270: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   273: pop
    //   274: aload_0
    //   275: aload_1
    //   276: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   279: putfield kind_ : Ljava/lang/Object;
    //   282: aload_0
    //   283: bipush #6
    //   285: putfield kindCase_ : I
    //   288: goto -> 148
    //   291: aload_0
    //   292: getfield kindCase_ : I
    //   295: iconst_5
    //   296: if_icmpne -> 316
    //   299: aload_0
    //   300: getfield kind_ : Ljava/lang/Object;
    //   303: checkcast com/google/protobuf/Struct
    //   306: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   309: checkcast com/google/protobuf/Struct$Builder
    //   312: astore_1
    //   313: goto -> 318
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_0
    //   319: aload_2
    //   320: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   323: aload_3
    //   324: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   327: putfield kind_ : Ljava/lang/Object;
    //   330: aload_1
    //   331: ifnull -> 354
    //   334: aload_1
    //   335: aload_0
    //   336: getfield kind_ : Ljava/lang/Object;
    //   339: checkcast com/google/protobuf/Struct
    //   342: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   345: pop
    //   346: aload_0
    //   347: aload_1
    //   348: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   351: putfield kind_ : Ljava/lang/Object;
    //   354: aload_0
    //   355: iconst_5
    //   356: putfield kindCase_ : I
    //   359: goto -> 148
    //   362: aload_0
    //   363: iconst_4
    //   364: putfield kindCase_ : I
    //   367: aload_0
    //   368: aload_2
    //   369: invokevirtual readBool : ()Z
    //   372: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   375: putfield kind_ : Ljava/lang/Object;
    //   378: goto -> 148
    //   381: aload_2
    //   382: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   385: astore_1
    //   386: aload_0
    //   387: iconst_3
    //   388: putfield kindCase_ : I
    //   391: aload_0
    //   392: aload_1
    //   393: putfield kind_ : Ljava/lang/Object;
    //   396: goto -> 148
    //   399: aload_0
    //   400: iconst_2
    //   401: putfield kindCase_ : I
    //   404: aload_0
    //   405: aload_2
    //   406: invokevirtual readDouble : ()D
    //   409: invokestatic valueOf : (D)Ljava/lang/Double;
    //   412: putfield kind_ : Ljava/lang/Object;
    //   415: goto -> 148
    //   418: aload_2
    //   419: invokevirtual readEnum : ()I
    //   422: istore #4
    //   424: aload_0
    //   425: iconst_1
    //   426: putfield kindCase_ : I
    //   429: aload_0
    //   430: iload #4
    //   432: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   435: putfield kind_ : Ljava/lang/Object;
    //   438: goto -> 148
    //   441: iconst_1
    //   442: istore #12
    //   444: goto -> 148
    //   447: astore_1
    //   448: goto -> 495
    //   451: astore_1
    //   452: new java/lang/RuntimeException
    //   455: astore_3
    //   456: new com/google/protobuf/InvalidProtocolBufferException
    //   459: astore_2
    //   460: aload_2
    //   461: aload_1
    //   462: invokevirtual getMessage : ()Ljava/lang/String;
    //   465: invokespecial <init> : (Ljava/lang/String;)V
    //   468: aload_3
    //   469: aload_2
    //   470: aload_0
    //   471: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   474: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   477: aload_3
    //   478: athrow
    //   479: astore_2
    //   480: new java/lang/RuntimeException
    //   483: astore_1
    //   484: aload_1
    //   485: aload_2
    //   486: aload_0
    //   487: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   490: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   493: aload_1
    //   494: athrow
    //   495: aload_1
    //   496: athrow
    //   497: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   500: areturn
    //   501: aload_2
    //   502: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   505: astore_1
    //   506: aload_3
    //   507: checkcast com/google/protobuf/Value
    //   510: astore_2
    //   511: getstatic com/google/protobuf/Value$1.$SwitchMap$com$google$protobuf$Value$KindCase : [I
    //   514: aload_2
    //   515: invokevirtual getKindCase : ()Lcom/google/protobuf/Value$KindCase;
    //   518: invokevirtual ordinal : ()I
    //   521: iaload
    //   522: tableswitch default -> 564, 1 -> 779, 2 -> 741, 3 -> 703, 4 -> 665, 5 -> 627, 6 -> 588, 7 -> 567
    //   564: goto -> 814
    //   567: aload_0
    //   568: getfield kindCase_ : I
    //   571: ifeq -> 577
    //   574: iconst_1
    //   575: istore #5
    //   577: aload_1
    //   578: iload #5
    //   580: invokeinterface visitOneofNotSet : (Z)V
    //   585: goto -> 814
    //   588: iload #6
    //   590: istore #5
    //   592: aload_0
    //   593: getfield kindCase_ : I
    //   596: bipush #6
    //   598: if_icmpne -> 604
    //   601: iconst_1
    //   602: istore #5
    //   604: aload_0
    //   605: aload_1
    //   606: iload #5
    //   608: aload_0
    //   609: getfield kind_ : Ljava/lang/Object;
    //   612: aload_2
    //   613: getfield kind_ : Ljava/lang/Object;
    //   616: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: putfield kind_ : Ljava/lang/Object;
    //   624: goto -> 814
    //   627: iload #7
    //   629: istore #5
    //   631: aload_0
    //   632: getfield kindCase_ : I
    //   635: iconst_5
    //   636: if_icmpne -> 642
    //   639: iconst_1
    //   640: istore #5
    //   642: aload_0
    //   643: aload_1
    //   644: iload #5
    //   646: aload_0
    //   647: getfield kind_ : Ljava/lang/Object;
    //   650: aload_2
    //   651: getfield kind_ : Ljava/lang/Object;
    //   654: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   659: putfield kind_ : Ljava/lang/Object;
    //   662: goto -> 814
    //   665: iload #8
    //   667: istore #5
    //   669: aload_0
    //   670: getfield kindCase_ : I
    //   673: iconst_4
    //   674: if_icmpne -> 680
    //   677: iconst_1
    //   678: istore #5
    //   680: aload_0
    //   681: aload_1
    //   682: iload #5
    //   684: aload_0
    //   685: getfield kind_ : Ljava/lang/Object;
    //   688: aload_2
    //   689: getfield kind_ : Ljava/lang/Object;
    //   692: invokeinterface visitOneofBoolean : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   697: putfield kind_ : Ljava/lang/Object;
    //   700: goto -> 814
    //   703: iload #9
    //   705: istore #5
    //   707: aload_0
    //   708: getfield kindCase_ : I
    //   711: iconst_3
    //   712: if_icmpne -> 718
    //   715: iconst_1
    //   716: istore #5
    //   718: aload_0
    //   719: aload_1
    //   720: iload #5
    //   722: aload_0
    //   723: getfield kind_ : Ljava/lang/Object;
    //   726: aload_2
    //   727: getfield kind_ : Ljava/lang/Object;
    //   730: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   735: putfield kind_ : Ljava/lang/Object;
    //   738: goto -> 814
    //   741: iload #10
    //   743: istore #5
    //   745: aload_0
    //   746: getfield kindCase_ : I
    //   749: iconst_2
    //   750: if_icmpne -> 756
    //   753: iconst_1
    //   754: istore #5
    //   756: aload_0
    //   757: aload_1
    //   758: iload #5
    //   760: aload_0
    //   761: getfield kind_ : Ljava/lang/Object;
    //   764: aload_2
    //   765: getfield kind_ : Ljava/lang/Object;
    //   768: invokeinterface visitOneofDouble : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   773: putfield kind_ : Ljava/lang/Object;
    //   776: goto -> 814
    //   779: iload #11
    //   781: istore #5
    //   783: aload_0
    //   784: getfield kindCase_ : I
    //   787: iconst_1
    //   788: if_icmpne -> 794
    //   791: iconst_1
    //   792: istore #5
    //   794: aload_0
    //   795: aload_1
    //   796: iload #5
    //   798: aload_0
    //   799: getfield kind_ : Ljava/lang/Object;
    //   802: aload_2
    //   803: getfield kind_ : Ljava/lang/Object;
    //   806: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   811: putfield kind_ : Ljava/lang/Object;
    //   814: aload_1
    //   815: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   818: if_acmpne -> 838
    //   821: aload_2
    //   822: getfield kindCase_ : I
    //   825: istore #12
    //   827: iload #12
    //   829: ifeq -> 838
    //   832: aload_0
    //   833: iload #12
    //   835: putfield kindCase_ : I
    //   838: aload_0
    //   839: areturn
    //   840: new com/google/protobuf/Value$Builder
    //   843: dup
    //   844: aconst_null
    //   845: invokespecial <init> : (Lcom/google/protobuf/Value$1;)V
    //   848: areturn
    //   849: aconst_null
    //   850: areturn
    //   851: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   854: areturn
    //   855: new com/google/protobuf/Value
    //   858: dup
    //   859: invokespecial <init> : ()V
    //   862: areturn
    // Exception table:
    //   from	to	target	type
    //   101	122	128	finally
    //   122	125	128	finally
    //   129	132	128	finally
    //   153	159	479	com/google/protobuf/InvalidProtocolBufferException
    //   153	159	451	java/io/IOException
    //   153	159	447	finally
    //   206	215	479	com/google/protobuf/InvalidProtocolBufferException
    //   206	215	451	java/io/IOException
    //   206	215	447	finally
    //   218	241	479	com/google/protobuf/InvalidProtocolBufferException
    //   218	241	451	java/io/IOException
    //   218	241	447	finally
    //   246	258	479	com/google/protobuf/InvalidProtocolBufferException
    //   246	258	451	java/io/IOException
    //   246	258	447	finally
    //   262	282	479	com/google/protobuf/InvalidProtocolBufferException
    //   262	282	451	java/io/IOException
    //   262	282	447	finally
    //   282	288	479	com/google/protobuf/InvalidProtocolBufferException
    //   282	288	451	java/io/IOException
    //   282	288	447	finally
    //   291	313	479	com/google/protobuf/InvalidProtocolBufferException
    //   291	313	451	java/io/IOException
    //   291	313	447	finally
    //   318	330	479	com/google/protobuf/InvalidProtocolBufferException
    //   318	330	451	java/io/IOException
    //   318	330	447	finally
    //   334	354	479	com/google/protobuf/InvalidProtocolBufferException
    //   334	354	451	java/io/IOException
    //   334	354	447	finally
    //   354	359	479	com/google/protobuf/InvalidProtocolBufferException
    //   354	359	451	java/io/IOException
    //   354	359	447	finally
    //   362	378	479	com/google/protobuf/InvalidProtocolBufferException
    //   362	378	451	java/io/IOException
    //   362	378	447	finally
    //   381	396	479	com/google/protobuf/InvalidProtocolBufferException
    //   381	396	451	java/io/IOException
    //   381	396	447	finally
    //   399	415	479	com/google/protobuf/InvalidProtocolBufferException
    //   399	415	451	java/io/IOException
    //   399	415	447	finally
    //   418	438	479	com/google/protobuf/InvalidProtocolBufferException
    //   418	438	451	java/io/IOException
    //   418	438	447	finally
    //   452	479	447	finally
    //   480	495	447	finally
  }
  
  public boolean getBoolValue() {
    return (this.kindCase_ == 4) ? ((Boolean)this.kind_).booleanValue() : false;
  }
  
  public KindCase getKindCase() {
    return KindCase.forNumber(this.kindCase_);
  }
  
  public ListValue getListValue() {
    return (this.kindCase_ == 6) ? (ListValue)this.kind_ : ListValue.getDefaultInstance();
  }
  
  public NullValue getNullValue() {
    if (this.kindCase_ == 1) {
      NullValue nullValue1 = NullValue.forNumber(((Integer)this.kind_).intValue());
      NullValue nullValue2 = nullValue1;
      if (nullValue1 == null)
        nullValue2 = NullValue.UNRECOGNIZED; 
      return nullValue2;
    } 
    return NullValue.NULL_VALUE;
  }
  
  public int getNullValueValue() {
    return (this.kindCase_ == 1) ? ((Integer)this.kind_).intValue() : 0;
  }
  
  public double getNumberValue() {
    return (this.kindCase_ == 2) ? ((Double)this.kind_).doubleValue() : 0.0D;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.kindCase_ == 1)
      i = 0 + CodedOutputStream.computeEnumSize(1, ((Integer)this.kind_).intValue()); 
    int j = i;
    if (this.kindCase_ == 2)
      j = i + CodedOutputStream.computeDoubleSize(2, ((Double)this.kind_).doubleValue()); 
    i = j;
    if (this.kindCase_ == 3)
      i = j + CodedOutputStream.computeStringSize(3, getStringValue()); 
    j = i;
    if (this.kindCase_ == 4)
      j = i + CodedOutputStream.computeBoolSize(4, ((Boolean)this.kind_).booleanValue()); 
    i = j;
    if (this.kindCase_ == 5)
      i = j + CodedOutputStream.computeMessageSize(5, (Struct)this.kind_); 
    j = i;
    if (this.kindCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (ListValue)this.kind_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getStringValue() {
    String str;
    if (this.kindCase_ == 3) {
      str = (String)this.kind_;
    } else {
      str = "";
    } 
    return str;
  }
  
  public ByteString getStringValueBytes() {
    String str;
    if (this.kindCase_ == 3) {
      str = (String)this.kind_;
    } else {
      str = "";
    } 
    return ByteString.copyFromUtf8(str);
  }
  
  public Struct getStructValue() {
    return (this.kindCase_ == 5) ? (Struct)this.kind_ : Struct.getDefaultInstance();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.kindCase_ == 1)
      paramCodedOutputStream.writeEnum(1, ((Integer)this.kind_).intValue()); 
    if (this.kindCase_ == 2)
      paramCodedOutputStream.writeDouble(2, ((Double)this.kind_).doubleValue()); 
    if (this.kindCase_ == 3)
      paramCodedOutputStream.writeString(3, getStringValue()); 
    if (this.kindCase_ == 4)
      paramCodedOutputStream.writeBool(4, ((Boolean)this.kind_).booleanValue()); 
    if (this.kindCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (Struct)this.kind_); 
    if (this.kindCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (ListValue)this.kind_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
    private Builder() {
      super(Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearBoolValue() {
      copyOnWrite();
      this.instance.clearBoolValue();
      return this;
    }
    
    public Builder clearKind() {
      copyOnWrite();
      this.instance.clearKind();
      return this;
    }
    
    public Builder clearListValue() {
      copyOnWrite();
      this.instance.clearListValue();
      return this;
    }
    
    public Builder clearNullValue() {
      copyOnWrite();
      this.instance.clearNullValue();
      return this;
    }
    
    public Builder clearNumberValue() {
      copyOnWrite();
      this.instance.clearNumberValue();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      this.instance.clearStringValue();
      return this;
    }
    
    public Builder clearStructValue() {
      copyOnWrite();
      this.instance.clearStructValue();
      return this;
    }
    
    public boolean getBoolValue() {
      return this.instance.getBoolValue();
    }
    
    public Value.KindCase getKindCase() {
      return this.instance.getKindCase();
    }
    
    public ListValue getListValue() {
      return this.instance.getListValue();
    }
    
    public NullValue getNullValue() {
      return this.instance.getNullValue();
    }
    
    public int getNullValueValue() {
      return this.instance.getNullValueValue();
    }
    
    public double getNumberValue() {
      return this.instance.getNumberValue();
    }
    
    public String getStringValue() {
      return this.instance.getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return this.instance.getStringValueBytes();
    }
    
    public Struct getStructValue() {
      return this.instance.getStructValue();
    }
    
    public Builder mergeListValue(ListValue param1ListValue) {
      copyOnWrite();
      this.instance.mergeListValue(param1ListValue);
      return this;
    }
    
    public Builder mergeStructValue(Struct param1Struct) {
      copyOnWrite();
      this.instance.mergeStructValue(param1Struct);
      return this;
    }
    
    public Builder setBoolValue(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setBoolValue(param1Boolean);
      return this;
    }
    
    public Builder setListValue(ListValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.setListValue(param1Builder);
      return this;
    }
    
    public Builder setListValue(ListValue param1ListValue) {
      copyOnWrite();
      this.instance.setListValue(param1ListValue);
      return this;
    }
    
    public Builder setNullValue(NullValue param1NullValue) {
      copyOnWrite();
      this.instance.setNullValue(param1NullValue);
      return this;
    }
    
    public Builder setNullValueValue(int param1Int) {
      copyOnWrite();
      this.instance.setNullValueValue(param1Int);
      return this;
    }
    
    public Builder setNumberValue(double param1Double) {
      copyOnWrite();
      this.instance.setNumberValue(param1Double);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      this.instance.setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setStringValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setStructValue(Struct.Builder param1Builder) {
      copyOnWrite();
      this.instance.setStructValue(param1Builder);
      return this;
    }
    
    public Builder setStructValue(Struct param1Struct) {
      copyOnWrite();
      this.instance.setStructValue(param1Struct);
      return this;
    }
  }
  
  public enum KindCase implements Internal.EnumLite {
    BOOL_VALUE,
    KIND_NOT_SET,
    LIST_VALUE,
    NULL_VALUE(1),
    NUMBER_VALUE(2),
    STRING_VALUE(3),
    STRUCT_VALUE(3);
    
    private final int value;
    
    static {
      LIST_VALUE = new KindCase("LIST_VALUE", 5, 6);
      KIND_NOT_SET = new KindCase("KIND_NOT_SET", 6, 0);
      $VALUES = new KindCase[] { NULL_VALUE, NUMBER_VALUE, STRING_VALUE, BOOL_VALUE, STRUCT_VALUE, LIST_VALUE, KIND_NOT_SET };
    }
    
    KindCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static KindCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return LIST_VALUE;
        case 5:
          return STRUCT_VALUE;
        case 4:
          return BOOL_VALUE;
        case 3:
          return STRING_VALUE;
        case 2:
          return NUMBER_VALUE;
        case 1:
          return NULL_VALUE;
        case 0:
          break;
      } 
      return KIND_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */