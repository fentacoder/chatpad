package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;

public final class Value extends GeneratedMessageLite<Value, Value.Builder> implements ValueOrBuilder {
  public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
  
  public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
  
  public static final int BYTES_VALUE_FIELD_NUMBER = 18;
  
  private static final Value DEFAULT_INSTANCE = new Value();
  
  public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
  
  public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
  
  public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
  
  public static final int MAP_VALUE_FIELD_NUMBER = 6;
  
  public static final int NULL_VALUE_FIELD_NUMBER = 11;
  
  private static volatile Parser<Value> PARSER;
  
  public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
  
  public static final int STRING_VALUE_FIELD_NUMBER = 17;
  
  public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
  
  private int valueTypeCase_ = 0;
  
  private Object valueType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearArrayValue() {
    if (this.valueTypeCase_ == 9) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearBooleanValue() {
    if (this.valueTypeCase_ == 1) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearBytesValue() {
    if (this.valueTypeCase_ == 18) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearDoubleValue() {
    if (this.valueTypeCase_ == 3) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearGeoPointValue() {
    if (this.valueTypeCase_ == 8) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearIntegerValue() {
    if (this.valueTypeCase_ == 2) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearMapValue() {
    if (this.valueTypeCase_ == 6) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearNullValue() {
    if (this.valueTypeCase_ == 11) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearReferenceValue() {
    if (this.valueTypeCase_ == 5) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearStringValue() {
    if (this.valueTypeCase_ == 17) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearTimestampValue() {
    if (this.valueTypeCase_ == 10) {
      this.valueTypeCase_ = 0;
      this.valueType_ = null;
    } 
  }
  
  private void clearValueType() {
    this.valueTypeCase_ = 0;
    this.valueType_ = null;
  }
  
  public static Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeArrayValue(ArrayValue paramArrayValue) {
    if (this.valueTypeCase_ == 9 && this.valueType_ != ArrayValue.getDefaultInstance()) {
      this.valueType_ = ((ArrayValue.Builder)ArrayValue.newBuilder((ArrayValue)this.valueType_).mergeFrom(paramArrayValue)).buildPartial();
    } else {
      this.valueType_ = paramArrayValue;
    } 
    this.valueTypeCase_ = 9;
  }
  
  private void mergeGeoPointValue(LatLng paramLatLng) {
    if (this.valueTypeCase_ == 8 && this.valueType_ != LatLng.getDefaultInstance()) {
      this.valueType_ = ((LatLng.Builder)LatLng.newBuilder((LatLng)this.valueType_).mergeFrom((GeneratedMessageLite)paramLatLng)).buildPartial();
    } else {
      this.valueType_ = paramLatLng;
    } 
    this.valueTypeCase_ = 8;
  }
  
  private void mergeMapValue(MapValue paramMapValue) {
    if (this.valueTypeCase_ == 6 && this.valueType_ != MapValue.getDefaultInstance()) {
      this.valueType_ = ((MapValue.Builder)MapValue.newBuilder((MapValue)this.valueType_).mergeFrom(paramMapValue)).buildPartial();
    } else {
      this.valueType_ = paramMapValue;
    } 
    this.valueTypeCase_ = 6;
  }
  
  private void mergeTimestampValue(Timestamp paramTimestamp) {
    if (this.valueTypeCase_ == 10 && this.valueType_ != Timestamp.getDefaultInstance()) {
      this.valueType_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.valueType_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.valueType_ = paramTimestamp;
    } 
    this.valueTypeCase_ = 10;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Value paramValue) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramValue);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(InputStream paramInputStream) throws IOException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Value)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setArrayValue(ArrayValue.Builder paramBuilder) {
    this.valueType_ = paramBuilder.build();
    this.valueTypeCase_ = 9;
  }
  
  private void setArrayValue(ArrayValue paramArrayValue) {
    if (paramArrayValue != null) {
      this.valueType_ = paramArrayValue;
      this.valueTypeCase_ = 9;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBooleanValue(boolean paramBoolean) {
    this.valueTypeCase_ = 1;
    this.valueType_ = Boolean.valueOf(paramBoolean);
  }
  
  private void setBytesValue(ByteString paramByteString) {
    if (paramByteString != null) {
      this.valueTypeCase_ = 18;
      this.valueType_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDoubleValue(double paramDouble) {
    this.valueTypeCase_ = 3;
    this.valueType_ = Double.valueOf(paramDouble);
  }
  
  private void setGeoPointValue(LatLng.Builder paramBuilder) {
    this.valueType_ = paramBuilder.build();
    this.valueTypeCase_ = 8;
  }
  
  private void setGeoPointValue(LatLng paramLatLng) {
    if (paramLatLng != null) {
      this.valueType_ = paramLatLng;
      this.valueTypeCase_ = 8;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setIntegerValue(long paramLong) {
    this.valueTypeCase_ = 2;
    this.valueType_ = Long.valueOf(paramLong);
  }
  
  private void setMapValue(MapValue.Builder paramBuilder) {
    this.valueType_ = paramBuilder.build();
    this.valueTypeCase_ = 6;
  }
  
  private void setMapValue(MapValue paramMapValue) {
    if (paramMapValue != null) {
      this.valueType_ = paramMapValue;
      this.valueTypeCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValue(NullValue paramNullValue) {
    if (paramNullValue != null) {
      this.valueTypeCase_ = 11;
      this.valueType_ = Integer.valueOf(paramNullValue.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValueValue(int paramInt) {
    this.valueTypeCase_ = 11;
    this.valueType_ = Integer.valueOf(paramInt);
  }
  
  private void setReferenceValue(String paramString) {
    if (paramString != null) {
      this.valueTypeCase_ = 5;
      this.valueType_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReferenceValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.valueTypeCase_ = 5;
      this.valueType_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStringValue(String paramString) {
    if (paramString != null) {
      this.valueTypeCase_ = 17;
      this.valueType_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStringValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.valueTypeCase_ = 17;
      this.valueType_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTimestampValue(Timestamp.Builder paramBuilder) {
    this.valueType_ = paramBuilder.build();
    this.valueTypeCase_ = 10;
  }
  
  private void setTimestampValue(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.valueType_ = paramTimestamp;
      this.valueTypeCase_ = 10;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   34: iconst_0
    //   35: istore #13
    //   37: iconst_0
    //   38: istore #14
    //   40: iconst_0
    //   41: istore #15
    //   43: iconst_0
    //   44: istore #16
    //   46: iconst_0
    //   47: istore #17
    //   49: iload #4
    //   51: tableswitch default -> 96, 1 -> 1359, 2 -> 1355, 3 -> 1353, 4 -> 1344, 5 -> 789, 6 -> 150, 7 -> 785, 8 -> 104
    //   96: new java/lang/UnsupportedOperationException
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: athrow
    //   104: getstatic com/google/firestore/v1/Value.PARSER : Lcom/google/protobuf/Parser;
    //   107: ifnonnull -> 146
    //   110: ldc com/google/firestore/v1/Value
    //   112: monitorenter
    //   113: getstatic com/google/firestore/v1/Value.PARSER : Lcom/google/protobuf/Parser;
    //   116: ifnonnull -> 134
    //   119: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   122: astore_1
    //   123: aload_1
    //   124: getstatic com/google/firestore/v1/Value.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Value;
    //   127: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   130: aload_1
    //   131: putstatic com/google/firestore/v1/Value.PARSER : Lcom/google/protobuf/Parser;
    //   134: ldc com/google/firestore/v1/Value
    //   136: monitorexit
    //   137: goto -> 146
    //   140: astore_1
    //   141: ldc com/google/firestore/v1/Value
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    //   146: getstatic com/google/firestore/v1/Value.PARSER : Lcom/google/protobuf/Parser;
    //   149: areturn
    //   150: aload_2
    //   151: checkcast com/google/protobuf/CodedInputStream
    //   154: astore_2
    //   155: aload_3
    //   156: checkcast com/google/protobuf/ExtensionRegistryLite
    //   159: astore_3
    //   160: iload #17
    //   162: ifne -> 785
    //   165: aload_2
    //   166: invokevirtual readTag : ()I
    //   169: istore #4
    //   171: iload #4
    //   173: lookupswitch default -> 280, 0 -> 718, 8 -> 699, 16 -> 680, 25 -> 661, 42 -> 643, 50 -> 570, 66 -> 497, 74 -> 424, 82 -> 351, 88 -> 327, 138 -> 308, 146 -> 291
    //   280: aload_2
    //   281: iload #4
    //   283: invokevirtual skipField : (I)Z
    //   286: istore #5
    //   288: goto -> 724
    //   291: aload_0
    //   292: bipush #18
    //   294: putfield valueTypeCase_ : I
    //   297: aload_0
    //   298: aload_2
    //   299: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   302: putfield valueType_ : Ljava/lang/Object;
    //   305: goto -> 732
    //   308: aload_2
    //   309: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   312: astore_1
    //   313: aload_0
    //   314: bipush #17
    //   316: putfield valueTypeCase_ : I
    //   319: aload_0
    //   320: aload_1
    //   321: putfield valueType_ : Ljava/lang/Object;
    //   324: goto -> 732
    //   327: aload_2
    //   328: invokevirtual readEnum : ()I
    //   331: istore #4
    //   333: aload_0
    //   334: bipush #11
    //   336: putfield valueTypeCase_ : I
    //   339: aload_0
    //   340: iload #4
    //   342: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   345: putfield valueType_ : Ljava/lang/Object;
    //   348: goto -> 732
    //   351: aload_0
    //   352: getfield valueTypeCase_ : I
    //   355: bipush #10
    //   357: if_icmpne -> 377
    //   360: aload_0
    //   361: getfield valueType_ : Ljava/lang/Object;
    //   364: checkcast com/google/protobuf/Timestamp
    //   367: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   370: checkcast com/google/protobuf/Timestamp$Builder
    //   373: astore_1
    //   374: goto -> 379
    //   377: aconst_null
    //   378: astore_1
    //   379: aload_0
    //   380: aload_2
    //   381: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   384: aload_3
    //   385: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   388: putfield valueType_ : Ljava/lang/Object;
    //   391: aload_1
    //   392: ifnull -> 415
    //   395: aload_1
    //   396: aload_0
    //   397: getfield valueType_ : Ljava/lang/Object;
    //   400: checkcast com/google/protobuf/Timestamp
    //   403: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   406: pop
    //   407: aload_0
    //   408: aload_1
    //   409: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   412: putfield valueType_ : Ljava/lang/Object;
    //   415: aload_0
    //   416: bipush #10
    //   418: putfield valueTypeCase_ : I
    //   421: goto -> 732
    //   424: aload_0
    //   425: getfield valueTypeCase_ : I
    //   428: bipush #9
    //   430: if_icmpne -> 450
    //   433: aload_0
    //   434: getfield valueType_ : Ljava/lang/Object;
    //   437: checkcast com/google/firestore/v1/ArrayValue
    //   440: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   443: checkcast com/google/firestore/v1/ArrayValue$Builder
    //   446: astore_1
    //   447: goto -> 452
    //   450: aconst_null
    //   451: astore_1
    //   452: aload_0
    //   453: aload_2
    //   454: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   457: aload_3
    //   458: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   461: putfield valueType_ : Ljava/lang/Object;
    //   464: aload_1
    //   465: ifnull -> 488
    //   468: aload_1
    //   469: aload_0
    //   470: getfield valueType_ : Ljava/lang/Object;
    //   473: checkcast com/google/firestore/v1/ArrayValue
    //   476: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   479: pop
    //   480: aload_0
    //   481: aload_1
    //   482: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   485: putfield valueType_ : Ljava/lang/Object;
    //   488: aload_0
    //   489: bipush #9
    //   491: putfield valueTypeCase_ : I
    //   494: goto -> 732
    //   497: aload_0
    //   498: getfield valueTypeCase_ : I
    //   501: bipush #8
    //   503: if_icmpne -> 523
    //   506: aload_0
    //   507: getfield valueType_ : Ljava/lang/Object;
    //   510: checkcast com/google/type/LatLng
    //   513: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   516: checkcast com/google/type/LatLng$Builder
    //   519: astore_1
    //   520: goto -> 525
    //   523: aconst_null
    //   524: astore_1
    //   525: aload_0
    //   526: aload_2
    //   527: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   530: aload_3
    //   531: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   534: putfield valueType_ : Ljava/lang/Object;
    //   537: aload_1
    //   538: ifnull -> 561
    //   541: aload_1
    //   542: aload_0
    //   543: getfield valueType_ : Ljava/lang/Object;
    //   546: checkcast com/google/type/LatLng
    //   549: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   552: pop
    //   553: aload_0
    //   554: aload_1
    //   555: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   558: putfield valueType_ : Ljava/lang/Object;
    //   561: aload_0
    //   562: bipush #8
    //   564: putfield valueTypeCase_ : I
    //   567: goto -> 732
    //   570: aload_0
    //   571: getfield valueTypeCase_ : I
    //   574: bipush #6
    //   576: if_icmpne -> 596
    //   579: aload_0
    //   580: getfield valueType_ : Ljava/lang/Object;
    //   583: checkcast com/google/firestore/v1/MapValue
    //   586: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   589: checkcast com/google/firestore/v1/MapValue$Builder
    //   592: astore_1
    //   593: goto -> 598
    //   596: aconst_null
    //   597: astore_1
    //   598: aload_0
    //   599: aload_2
    //   600: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   603: aload_3
    //   604: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   607: putfield valueType_ : Ljava/lang/Object;
    //   610: aload_1
    //   611: ifnull -> 634
    //   614: aload_1
    //   615: aload_0
    //   616: getfield valueType_ : Ljava/lang/Object;
    //   619: checkcast com/google/firestore/v1/MapValue
    //   622: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   625: pop
    //   626: aload_0
    //   627: aload_1
    //   628: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   631: putfield valueType_ : Ljava/lang/Object;
    //   634: aload_0
    //   635: bipush #6
    //   637: putfield valueTypeCase_ : I
    //   640: goto -> 732
    //   643: aload_2
    //   644: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   647: astore_1
    //   648: aload_0
    //   649: iconst_5
    //   650: putfield valueTypeCase_ : I
    //   653: aload_0
    //   654: aload_1
    //   655: putfield valueType_ : Ljava/lang/Object;
    //   658: goto -> 732
    //   661: aload_0
    //   662: iconst_3
    //   663: putfield valueTypeCase_ : I
    //   666: aload_0
    //   667: aload_2
    //   668: invokevirtual readDouble : ()D
    //   671: invokestatic valueOf : (D)Ljava/lang/Double;
    //   674: putfield valueType_ : Ljava/lang/Object;
    //   677: goto -> 732
    //   680: aload_0
    //   681: iconst_2
    //   682: putfield valueTypeCase_ : I
    //   685: aload_0
    //   686: aload_2
    //   687: invokevirtual readInt64 : ()J
    //   690: invokestatic valueOf : (J)Ljava/lang/Long;
    //   693: putfield valueType_ : Ljava/lang/Object;
    //   696: goto -> 732
    //   699: aload_0
    //   700: iconst_1
    //   701: putfield valueTypeCase_ : I
    //   704: aload_0
    //   705: aload_2
    //   706: invokevirtual readBool : ()Z
    //   709: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   712: putfield valueType_ : Ljava/lang/Object;
    //   715: goto -> 732
    //   718: iconst_1
    //   719: istore #17
    //   721: goto -> 732
    //   724: iload #5
    //   726: ifne -> 732
    //   729: goto -> 718
    //   732: goto -> 160
    //   735: astore_1
    //   736: goto -> 783
    //   739: astore_2
    //   740: new java/lang/RuntimeException
    //   743: astore_3
    //   744: new com/google/protobuf/InvalidProtocolBufferException
    //   747: astore_1
    //   748: aload_1
    //   749: aload_2
    //   750: invokevirtual getMessage : ()Ljava/lang/String;
    //   753: invokespecial <init> : (Ljava/lang/String;)V
    //   756: aload_3
    //   757: aload_1
    //   758: aload_0
    //   759: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   762: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   765: aload_3
    //   766: athrow
    //   767: astore_1
    //   768: new java/lang/RuntimeException
    //   771: astore_2
    //   772: aload_2
    //   773: aload_1
    //   774: aload_0
    //   775: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   778: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   781: aload_2
    //   782: athrow
    //   783: aload_1
    //   784: athrow
    //   785: getstatic com/google/firestore/v1/Value.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Value;
    //   788: areturn
    //   789: aload_2
    //   790: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   793: astore_1
    //   794: aload_3
    //   795: checkcast com/google/firestore/v1/Value
    //   798: astore_2
    //   799: getstatic com/google/firestore/v1/Value$1.$SwitchMap$com$google$firestore$v1$Value$ValueTypeCase : [I
    //   802: aload_2
    //   803: invokevirtual getValueTypeCase : ()Lcom/google/firestore/v1/Value$ValueTypeCase;
    //   806: invokevirtual ordinal : ()I
    //   809: iaload
    //   810: tableswitch default -> 872, 1 -> 1282, 2 -> 1244, 3 -> 1206, 4 -> 1168, 5 -> 1129, 6 -> 1090, 7 -> 1051, 8 -> 1013, 9 -> 974, 10 -> 935, 11 -> 896, 12 -> 875
    //   872: goto -> 1318
    //   875: aload_0
    //   876: getfield valueTypeCase_ : I
    //   879: ifeq -> 885
    //   882: iconst_1
    //   883: istore #5
    //   885: aload_1
    //   886: iload #5
    //   888: invokeinterface visitOneofNotSet : (Z)V
    //   893: goto -> 1318
    //   896: iload #6
    //   898: istore #5
    //   900: aload_0
    //   901: getfield valueTypeCase_ : I
    //   904: bipush #6
    //   906: if_icmpne -> 912
    //   909: iconst_1
    //   910: istore #5
    //   912: aload_0
    //   913: aload_1
    //   914: iload #5
    //   916: aload_0
    //   917: getfield valueType_ : Ljava/lang/Object;
    //   920: aload_2
    //   921: getfield valueType_ : Ljava/lang/Object;
    //   924: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   929: putfield valueType_ : Ljava/lang/Object;
    //   932: goto -> 1318
    //   935: iload #7
    //   937: istore #5
    //   939: aload_0
    //   940: getfield valueTypeCase_ : I
    //   943: bipush #9
    //   945: if_icmpne -> 951
    //   948: iconst_1
    //   949: istore #5
    //   951: aload_0
    //   952: aload_1
    //   953: iload #5
    //   955: aload_0
    //   956: getfield valueType_ : Ljava/lang/Object;
    //   959: aload_2
    //   960: getfield valueType_ : Ljava/lang/Object;
    //   963: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   968: putfield valueType_ : Ljava/lang/Object;
    //   971: goto -> 1318
    //   974: iload #8
    //   976: istore #5
    //   978: aload_0
    //   979: getfield valueTypeCase_ : I
    //   982: bipush #8
    //   984: if_icmpne -> 990
    //   987: iconst_1
    //   988: istore #5
    //   990: aload_0
    //   991: aload_1
    //   992: iload #5
    //   994: aload_0
    //   995: getfield valueType_ : Ljava/lang/Object;
    //   998: aload_2
    //   999: getfield valueType_ : Ljava/lang/Object;
    //   1002: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1007: putfield valueType_ : Ljava/lang/Object;
    //   1010: goto -> 1318
    //   1013: iload #9
    //   1015: istore #5
    //   1017: aload_0
    //   1018: getfield valueTypeCase_ : I
    //   1021: iconst_5
    //   1022: if_icmpne -> 1028
    //   1025: iconst_1
    //   1026: istore #5
    //   1028: aload_0
    //   1029: aload_1
    //   1030: iload #5
    //   1032: aload_0
    //   1033: getfield valueType_ : Ljava/lang/Object;
    //   1036: aload_2
    //   1037: getfield valueType_ : Ljava/lang/Object;
    //   1040: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: putfield valueType_ : Ljava/lang/Object;
    //   1048: goto -> 1318
    //   1051: iload #10
    //   1053: istore #5
    //   1055: aload_0
    //   1056: getfield valueTypeCase_ : I
    //   1059: bipush #18
    //   1061: if_icmpne -> 1067
    //   1064: iconst_1
    //   1065: istore #5
    //   1067: aload_0
    //   1068: aload_1
    //   1069: iload #5
    //   1071: aload_0
    //   1072: getfield valueType_ : Ljava/lang/Object;
    //   1075: aload_2
    //   1076: getfield valueType_ : Ljava/lang/Object;
    //   1079: invokeinterface visitOneofByteString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: putfield valueType_ : Ljava/lang/Object;
    //   1087: goto -> 1318
    //   1090: iload #11
    //   1092: istore #5
    //   1094: aload_0
    //   1095: getfield valueTypeCase_ : I
    //   1098: bipush #17
    //   1100: if_icmpne -> 1106
    //   1103: iconst_1
    //   1104: istore #5
    //   1106: aload_0
    //   1107: aload_1
    //   1108: iload #5
    //   1110: aload_0
    //   1111: getfield valueType_ : Ljava/lang/Object;
    //   1114: aload_2
    //   1115: getfield valueType_ : Ljava/lang/Object;
    //   1118: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: putfield valueType_ : Ljava/lang/Object;
    //   1126: goto -> 1318
    //   1129: iload #12
    //   1131: istore #5
    //   1133: aload_0
    //   1134: getfield valueTypeCase_ : I
    //   1137: bipush #10
    //   1139: if_icmpne -> 1145
    //   1142: iconst_1
    //   1143: istore #5
    //   1145: aload_0
    //   1146: aload_1
    //   1147: iload #5
    //   1149: aload_0
    //   1150: getfield valueType_ : Ljava/lang/Object;
    //   1153: aload_2
    //   1154: getfield valueType_ : Ljava/lang/Object;
    //   1157: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1162: putfield valueType_ : Ljava/lang/Object;
    //   1165: goto -> 1318
    //   1168: iload #13
    //   1170: istore #5
    //   1172: aload_0
    //   1173: getfield valueTypeCase_ : I
    //   1176: iconst_3
    //   1177: if_icmpne -> 1183
    //   1180: iconst_1
    //   1181: istore #5
    //   1183: aload_0
    //   1184: aload_1
    //   1185: iload #5
    //   1187: aload_0
    //   1188: getfield valueType_ : Ljava/lang/Object;
    //   1191: aload_2
    //   1192: getfield valueType_ : Ljava/lang/Object;
    //   1195: invokeinterface visitOneofDouble : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1200: putfield valueType_ : Ljava/lang/Object;
    //   1203: goto -> 1318
    //   1206: iload #14
    //   1208: istore #5
    //   1210: aload_0
    //   1211: getfield valueTypeCase_ : I
    //   1214: iconst_2
    //   1215: if_icmpne -> 1221
    //   1218: iconst_1
    //   1219: istore #5
    //   1221: aload_0
    //   1222: aload_1
    //   1223: iload #5
    //   1225: aload_0
    //   1226: getfield valueType_ : Ljava/lang/Object;
    //   1229: aload_2
    //   1230: getfield valueType_ : Ljava/lang/Object;
    //   1233: invokeinterface visitOneofLong : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1238: putfield valueType_ : Ljava/lang/Object;
    //   1241: goto -> 1318
    //   1244: iload #15
    //   1246: istore #5
    //   1248: aload_0
    //   1249: getfield valueTypeCase_ : I
    //   1252: iconst_1
    //   1253: if_icmpne -> 1259
    //   1256: iconst_1
    //   1257: istore #5
    //   1259: aload_0
    //   1260: aload_1
    //   1261: iload #5
    //   1263: aload_0
    //   1264: getfield valueType_ : Ljava/lang/Object;
    //   1267: aload_2
    //   1268: getfield valueType_ : Ljava/lang/Object;
    //   1271: invokeinterface visitOneofBoolean : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1276: putfield valueType_ : Ljava/lang/Object;
    //   1279: goto -> 1318
    //   1282: iload #16
    //   1284: istore #5
    //   1286: aload_0
    //   1287: getfield valueTypeCase_ : I
    //   1290: bipush #11
    //   1292: if_icmpne -> 1298
    //   1295: iconst_1
    //   1296: istore #5
    //   1298: aload_0
    //   1299: aload_1
    //   1300: iload #5
    //   1302: aload_0
    //   1303: getfield valueType_ : Ljava/lang/Object;
    //   1306: aload_2
    //   1307: getfield valueType_ : Ljava/lang/Object;
    //   1310: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1315: putfield valueType_ : Ljava/lang/Object;
    //   1318: aload_1
    //   1319: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   1322: if_acmpne -> 1342
    //   1325: aload_2
    //   1326: getfield valueTypeCase_ : I
    //   1329: istore #17
    //   1331: iload #17
    //   1333: ifeq -> 1342
    //   1336: aload_0
    //   1337: iload #17
    //   1339: putfield valueTypeCase_ : I
    //   1342: aload_0
    //   1343: areturn
    //   1344: new com/google/firestore/v1/Value$Builder
    //   1347: dup
    //   1348: aconst_null
    //   1349: invokespecial <init> : (Lcom/google/firestore/v1/Value$1;)V
    //   1352: areturn
    //   1353: aconst_null
    //   1354: areturn
    //   1355: getstatic com/google/firestore/v1/Value.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Value;
    //   1358: areturn
    //   1359: new com/google/firestore/v1/Value
    //   1362: dup
    //   1363: invokespecial <init> : ()V
    //   1366: areturn
    // Exception table:
    //   from	to	target	type
    //   113	134	140	finally
    //   134	137	140	finally
    //   141	144	140	finally
    //   165	171	767	com/google/protobuf/InvalidProtocolBufferException
    //   165	171	739	java/io/IOException
    //   165	171	735	finally
    //   280	288	767	com/google/protobuf/InvalidProtocolBufferException
    //   280	288	739	java/io/IOException
    //   280	288	735	finally
    //   291	305	767	com/google/protobuf/InvalidProtocolBufferException
    //   291	305	739	java/io/IOException
    //   291	305	735	finally
    //   308	324	767	com/google/protobuf/InvalidProtocolBufferException
    //   308	324	739	java/io/IOException
    //   308	324	735	finally
    //   327	348	767	com/google/protobuf/InvalidProtocolBufferException
    //   327	348	739	java/io/IOException
    //   327	348	735	finally
    //   351	374	767	com/google/protobuf/InvalidProtocolBufferException
    //   351	374	739	java/io/IOException
    //   351	374	735	finally
    //   379	391	767	com/google/protobuf/InvalidProtocolBufferException
    //   379	391	739	java/io/IOException
    //   379	391	735	finally
    //   395	415	767	com/google/protobuf/InvalidProtocolBufferException
    //   395	415	739	java/io/IOException
    //   395	415	735	finally
    //   415	421	767	com/google/protobuf/InvalidProtocolBufferException
    //   415	421	739	java/io/IOException
    //   415	421	735	finally
    //   424	447	767	com/google/protobuf/InvalidProtocolBufferException
    //   424	447	739	java/io/IOException
    //   424	447	735	finally
    //   452	464	767	com/google/protobuf/InvalidProtocolBufferException
    //   452	464	739	java/io/IOException
    //   452	464	735	finally
    //   468	488	767	com/google/protobuf/InvalidProtocolBufferException
    //   468	488	739	java/io/IOException
    //   468	488	735	finally
    //   488	494	767	com/google/protobuf/InvalidProtocolBufferException
    //   488	494	739	java/io/IOException
    //   488	494	735	finally
    //   497	520	767	com/google/protobuf/InvalidProtocolBufferException
    //   497	520	739	java/io/IOException
    //   497	520	735	finally
    //   525	537	767	com/google/protobuf/InvalidProtocolBufferException
    //   525	537	739	java/io/IOException
    //   525	537	735	finally
    //   541	561	767	com/google/protobuf/InvalidProtocolBufferException
    //   541	561	739	java/io/IOException
    //   541	561	735	finally
    //   561	567	767	com/google/protobuf/InvalidProtocolBufferException
    //   561	567	739	java/io/IOException
    //   561	567	735	finally
    //   570	593	767	com/google/protobuf/InvalidProtocolBufferException
    //   570	593	739	java/io/IOException
    //   570	593	735	finally
    //   598	610	767	com/google/protobuf/InvalidProtocolBufferException
    //   598	610	739	java/io/IOException
    //   598	610	735	finally
    //   614	634	767	com/google/protobuf/InvalidProtocolBufferException
    //   614	634	739	java/io/IOException
    //   614	634	735	finally
    //   634	640	767	com/google/protobuf/InvalidProtocolBufferException
    //   634	640	739	java/io/IOException
    //   634	640	735	finally
    //   643	658	767	com/google/protobuf/InvalidProtocolBufferException
    //   643	658	739	java/io/IOException
    //   643	658	735	finally
    //   661	677	767	com/google/protobuf/InvalidProtocolBufferException
    //   661	677	739	java/io/IOException
    //   661	677	735	finally
    //   680	696	767	com/google/protobuf/InvalidProtocolBufferException
    //   680	696	739	java/io/IOException
    //   680	696	735	finally
    //   699	715	767	com/google/protobuf/InvalidProtocolBufferException
    //   699	715	739	java/io/IOException
    //   699	715	735	finally
    //   740	767	735	finally
    //   768	783	735	finally
  }
  
  public ArrayValue getArrayValue() {
    return (this.valueTypeCase_ == 9) ? (ArrayValue)this.valueType_ : ArrayValue.getDefaultInstance();
  }
  
  public boolean getBooleanValue() {
    return (this.valueTypeCase_ == 1) ? ((Boolean)this.valueType_).booleanValue() : false;
  }
  
  public ByteString getBytesValue() {
    return (this.valueTypeCase_ == 18) ? (ByteString)this.valueType_ : ByteString.EMPTY;
  }
  
  public double getDoubleValue() {
    return (this.valueTypeCase_ == 3) ? ((Double)this.valueType_).doubleValue() : 0.0D;
  }
  
  public LatLng getGeoPointValue() {
    return (this.valueTypeCase_ == 8) ? (LatLng)this.valueType_ : LatLng.getDefaultInstance();
  }
  
  public long getIntegerValue() {
    return (this.valueTypeCase_ == 2) ? ((Long)this.valueType_).longValue() : 0L;
  }
  
  public MapValue getMapValue() {
    return (this.valueTypeCase_ == 6) ? (MapValue)this.valueType_ : MapValue.getDefaultInstance();
  }
  
  public NullValue getNullValue() {
    if (this.valueTypeCase_ == 11) {
      NullValue nullValue1 = NullValue.forNumber(((Integer)this.valueType_).intValue());
      NullValue nullValue2 = nullValue1;
      if (nullValue1 == null)
        nullValue2 = NullValue.UNRECOGNIZED; 
      return nullValue2;
    } 
    return NullValue.NULL_VALUE;
  }
  
  public int getNullValueValue() {
    return (this.valueTypeCase_ == 11) ? ((Integer)this.valueType_).intValue() : 0;
  }
  
  public String getReferenceValue() {
    String str;
    if (this.valueTypeCase_ == 5) {
      str = (String)this.valueType_;
    } else {
      str = "";
    } 
    return str;
  }
  
  public ByteString getReferenceValueBytes() {
    String str;
    if (this.valueTypeCase_ == 5) {
      str = (String)this.valueType_;
    } else {
      str = "";
    } 
    return ByteString.copyFromUtf8(str);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (this.valueTypeCase_ == 1)
      j = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean)this.valueType_).booleanValue()); 
    i = j;
    if (this.valueTypeCase_ == 2)
      i = j + CodedOutputStream.computeInt64Size(2, ((Long)this.valueType_).longValue()); 
    j = i;
    if (this.valueTypeCase_ == 3)
      j = i + CodedOutputStream.computeDoubleSize(3, ((Double)this.valueType_).doubleValue()); 
    i = j;
    if (this.valueTypeCase_ == 5)
      i = j + CodedOutputStream.computeStringSize(5, getReferenceValue()); 
    j = i;
    if (this.valueTypeCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.valueType_); 
    i = j;
    if (this.valueTypeCase_ == 8)
      i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)this.valueType_); 
    j = i;
    if (this.valueTypeCase_ == 9)
      j = i + CodedOutputStream.computeMessageSize(9, (MessageLite)this.valueType_); 
    i = j;
    if (this.valueTypeCase_ == 10)
      i = j + CodedOutputStream.computeMessageSize(10, (MessageLite)this.valueType_); 
    j = i;
    if (this.valueTypeCase_ == 11)
      j = i + CodedOutputStream.computeEnumSize(11, ((Integer)this.valueType_).intValue()); 
    i = j;
    if (this.valueTypeCase_ == 17)
      i = j + CodedOutputStream.computeStringSize(17, getStringValue()); 
    j = i;
    if (this.valueTypeCase_ == 18)
      j = i + CodedOutputStream.computeBytesSize(18, (ByteString)this.valueType_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getStringValue() {
    String str;
    if (this.valueTypeCase_ == 17) {
      str = (String)this.valueType_;
    } else {
      str = "";
    } 
    return str;
  }
  
  public ByteString getStringValueBytes() {
    String str;
    if (this.valueTypeCase_ == 17) {
      str = (String)this.valueType_;
    } else {
      str = "";
    } 
    return ByteString.copyFromUtf8(str);
  }
  
  public Timestamp getTimestampValue() {
    return (this.valueTypeCase_ == 10) ? (Timestamp)this.valueType_ : Timestamp.getDefaultInstance();
  }
  
  public ValueTypeCase getValueTypeCase() {
    return ValueTypeCase.forNumber(this.valueTypeCase_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.valueTypeCase_ == 1)
      paramCodedOutputStream.writeBool(1, ((Boolean)this.valueType_).booleanValue()); 
    if (this.valueTypeCase_ == 2)
      paramCodedOutputStream.writeInt64(2, ((Long)this.valueType_).longValue()); 
    if (this.valueTypeCase_ == 3)
      paramCodedOutputStream.writeDouble(3, ((Double)this.valueType_).doubleValue()); 
    if (this.valueTypeCase_ == 5)
      paramCodedOutputStream.writeString(5, getReferenceValue()); 
    if (this.valueTypeCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.valueType_); 
    if (this.valueTypeCase_ == 8)
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.valueType_); 
    if (this.valueTypeCase_ == 9)
      paramCodedOutputStream.writeMessage(9, (MessageLite)this.valueType_); 
    if (this.valueTypeCase_ == 10)
      paramCodedOutputStream.writeMessage(10, (MessageLite)this.valueType_); 
    if (this.valueTypeCase_ == 11)
      paramCodedOutputStream.writeEnum(11, ((Integer)this.valueType_).intValue()); 
    if (this.valueTypeCase_ == 17)
      paramCodedOutputStream.writeString(17, getStringValue()); 
    if (this.valueTypeCase_ == 18)
      paramCodedOutputStream.writeBytes(18, (ByteString)this.valueType_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
    private Builder() {
      super(Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearArrayValue() {
      copyOnWrite();
      ((Value)this.instance).clearArrayValue();
      return this;
    }
    
    public Builder clearBooleanValue() {
      copyOnWrite();
      ((Value)this.instance).clearBooleanValue();
      return this;
    }
    
    public Builder clearBytesValue() {
      copyOnWrite();
      ((Value)this.instance).clearBytesValue();
      return this;
    }
    
    public Builder clearDoubleValue() {
      copyOnWrite();
      ((Value)this.instance).clearDoubleValue();
      return this;
    }
    
    public Builder clearGeoPointValue() {
      copyOnWrite();
      ((Value)this.instance).clearGeoPointValue();
      return this;
    }
    
    public Builder clearIntegerValue() {
      copyOnWrite();
      ((Value)this.instance).clearIntegerValue();
      return this;
    }
    
    public Builder clearMapValue() {
      copyOnWrite();
      ((Value)this.instance).clearMapValue();
      return this;
    }
    
    public Builder clearNullValue() {
      copyOnWrite();
      ((Value)this.instance).clearNullValue();
      return this;
    }
    
    public Builder clearReferenceValue() {
      copyOnWrite();
      ((Value)this.instance).clearReferenceValue();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      ((Value)this.instance).clearStringValue();
      return this;
    }
    
    public Builder clearTimestampValue() {
      copyOnWrite();
      ((Value)this.instance).clearTimestampValue();
      return this;
    }
    
    public Builder clearValueType() {
      copyOnWrite();
      ((Value)this.instance).clearValueType();
      return this;
    }
    
    public ArrayValue getArrayValue() {
      return ((Value)this.instance).getArrayValue();
    }
    
    public boolean getBooleanValue() {
      return ((Value)this.instance).getBooleanValue();
    }
    
    public ByteString getBytesValue() {
      return ((Value)this.instance).getBytesValue();
    }
    
    public double getDoubleValue() {
      return ((Value)this.instance).getDoubleValue();
    }
    
    public LatLng getGeoPointValue() {
      return ((Value)this.instance).getGeoPointValue();
    }
    
    public long getIntegerValue() {
      return ((Value)this.instance).getIntegerValue();
    }
    
    public MapValue getMapValue() {
      return ((Value)this.instance).getMapValue();
    }
    
    public NullValue getNullValue() {
      return ((Value)this.instance).getNullValue();
    }
    
    public int getNullValueValue() {
      return ((Value)this.instance).getNullValueValue();
    }
    
    public String getReferenceValue() {
      return ((Value)this.instance).getReferenceValue();
    }
    
    public ByteString getReferenceValueBytes() {
      return ((Value)this.instance).getReferenceValueBytes();
    }
    
    public String getStringValue() {
      return ((Value)this.instance).getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return ((Value)this.instance).getStringValueBytes();
    }
    
    public Timestamp getTimestampValue() {
      return ((Value)this.instance).getTimestampValue();
    }
    
    public Value.ValueTypeCase getValueTypeCase() {
      return ((Value)this.instance).getValueTypeCase();
    }
    
    public Builder mergeArrayValue(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((Value)this.instance).mergeArrayValue(param1ArrayValue);
      return this;
    }
    
    public Builder mergeGeoPointValue(LatLng param1LatLng) {
      copyOnWrite();
      ((Value)this.instance).mergeGeoPointValue(param1LatLng);
      return this;
    }
    
    public Builder mergeMapValue(MapValue param1MapValue) {
      copyOnWrite();
      ((Value)this.instance).mergeMapValue(param1MapValue);
      return this;
    }
    
    public Builder mergeTimestampValue(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Value)this.instance).mergeTimestampValue(param1Timestamp);
      return this;
    }
    
    public Builder setArrayValue(ArrayValue.Builder param1Builder) {
      copyOnWrite();
      ((Value)this.instance).setArrayValue(param1Builder);
      return this;
    }
    
    public Builder setArrayValue(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((Value)this.instance).setArrayValue(param1ArrayValue);
      return this;
    }
    
    public Builder setBooleanValue(boolean param1Boolean) {
      copyOnWrite();
      ((Value)this.instance).setBooleanValue(param1Boolean);
      return this;
    }
    
    public Builder setBytesValue(ByteString param1ByteString) {
      copyOnWrite();
      ((Value)this.instance).setBytesValue(param1ByteString);
      return this;
    }
    
    public Builder setDoubleValue(double param1Double) {
      copyOnWrite();
      ((Value)this.instance).setDoubleValue(param1Double);
      return this;
    }
    
    public Builder setGeoPointValue(LatLng.Builder param1Builder) {
      copyOnWrite();
      ((Value)this.instance).setGeoPointValue(param1Builder);
      return this;
    }
    
    public Builder setGeoPointValue(LatLng param1LatLng) {
      copyOnWrite();
      ((Value)this.instance).setGeoPointValue(param1LatLng);
      return this;
    }
    
    public Builder setIntegerValue(long param1Long) {
      copyOnWrite();
      ((Value)this.instance).setIntegerValue(param1Long);
      return this;
    }
    
    public Builder setMapValue(MapValue.Builder param1Builder) {
      copyOnWrite();
      ((Value)this.instance).setMapValue(param1Builder);
      return this;
    }
    
    public Builder setMapValue(MapValue param1MapValue) {
      copyOnWrite();
      ((Value)this.instance).setMapValue(param1MapValue);
      return this;
    }
    
    public Builder setNullValue(NullValue param1NullValue) {
      copyOnWrite();
      ((Value)this.instance).setNullValue(param1NullValue);
      return this;
    }
    
    public Builder setNullValueValue(int param1Int) {
      copyOnWrite();
      ((Value)this.instance).setNullValueValue(param1Int);
      return this;
    }
    
    public Builder setReferenceValue(String param1String) {
      copyOnWrite();
      ((Value)this.instance).setReferenceValue(param1String);
      return this;
    }
    
    public Builder setReferenceValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Value)this.instance).setReferenceValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      ((Value)this.instance).setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Value)this.instance).setStringValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setTimestampValue(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Value)this.instance).setTimestampValue(param1Builder);
      return this;
    }
    
    public Builder setTimestampValue(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Value)this.instance).setTimestampValue(param1Timestamp);
      return this;
    }
  }
  
  public enum ValueTypeCase implements Internal.EnumLite {
    ARRAY_VALUE,
    BOOLEAN_VALUE,
    BYTES_VALUE,
    DOUBLE_VALUE,
    GEO_POINT_VALUE,
    INTEGER_VALUE,
    MAP_VALUE,
    NULL_VALUE(11),
    REFERENCE_VALUE(11),
    STRING_VALUE(11),
    TIMESTAMP_VALUE(11),
    VALUETYPE_NOT_SET(11);
    
    private final int value;
    
    static {
      DOUBLE_VALUE = new ValueTypeCase("DOUBLE_VALUE", 3, 3);
      TIMESTAMP_VALUE = new ValueTypeCase("TIMESTAMP_VALUE", 4, 10);
      STRING_VALUE = new ValueTypeCase("STRING_VALUE", 5, 17);
      BYTES_VALUE = new ValueTypeCase("BYTES_VALUE", 6, 18);
      REFERENCE_VALUE = new ValueTypeCase("REFERENCE_VALUE", 7, 5);
      GEO_POINT_VALUE = new ValueTypeCase("GEO_POINT_VALUE", 8, 8);
      ARRAY_VALUE = new ValueTypeCase("ARRAY_VALUE", 9, 9);
      MAP_VALUE = new ValueTypeCase("MAP_VALUE", 10, 6);
      VALUETYPE_NOT_SET = new ValueTypeCase("VALUETYPE_NOT_SET", 11, 0);
      $VALUES = new ValueTypeCase[] { 
          NULL_VALUE, BOOLEAN_VALUE, INTEGER_VALUE, DOUBLE_VALUE, TIMESTAMP_VALUE, STRING_VALUE, BYTES_VALUE, REFERENCE_VALUE, GEO_POINT_VALUE, ARRAY_VALUE, 
          MAP_VALUE, VALUETYPE_NOT_SET };
    }
    
    ValueTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ValueTypeCase forNumber(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int != 3) {
              if (param1Int != 5) {
                if (param1Int != 6) {
                  if (param1Int != 17) {
                    if (param1Int != 18) {
                      switch (param1Int) {
                        default:
                          return null;
                        case 11:
                          return NULL_VALUE;
                        case 10:
                          return TIMESTAMP_VALUE;
                        case 9:
                          return ARRAY_VALUE;
                        case 8:
                          break;
                      } 
                      return GEO_POINT_VALUE;
                    } 
                    return BYTES_VALUE;
                  } 
                  return STRING_VALUE;
                } 
                return MAP_VALUE;
              } 
              return REFERENCE_VALUE;
            } 
            return DOUBLE_VALUE;
          } 
          return INTEGER_VALUE;
        } 
        return BOOLEAN_VALUE;
      } 
      return VALUETYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */