package com.google.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PostalAddress extends GeneratedMessageLite<PostalAddress, PostalAddress.Builder> implements PostalAddressOrBuilder {
  public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
  
  public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
  
  private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
  
  public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
  
  public static final int LOCALITY_FIELD_NUMBER = 7;
  
  public static final int ORGANIZATION_FIELD_NUMBER = 11;
  
  private static volatile Parser<PostalAddress> PARSER;
  
  public static final int POSTAL_CODE_FIELD_NUMBER = 4;
  
  public static final int RECIPIENTS_FIELD_NUMBER = 10;
  
  public static final int REGION_CODE_FIELD_NUMBER = 2;
  
  public static final int REVISION_FIELD_NUMBER = 1;
  
  public static final int SORTING_CODE_FIELD_NUMBER = 5;
  
  public static final int SUBLOCALITY_FIELD_NUMBER = 8;
  
  private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
  
  private String administrativeArea_ = "";
  
  private int bitField0_;
  
  private String languageCode_ = "";
  
  private String locality_ = "";
  
  private String organization_ = "";
  
  private String postalCode_ = "";
  
  private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
  
  private String regionCode_ = "";
  
  private int revision_;
  
  private String sortingCode_ = "";
  
  private String sublocality_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAddressLines(String paramString) {
    if (paramString != null) {
      ensureAddressLinesIsMutable();
      this.addressLines_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAddressLinesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureAddressLinesIsMutable();
      this.addressLines_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addAllAddressLines(Iterable<String> paramIterable) {
    ensureAddressLinesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.addressLines_);
  }
  
  private void addAllRecipients(Iterable<String> paramIterable) {
    ensureRecipientsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.recipients_);
  }
  
  private void addRecipients(String paramString) {
    if (paramString != null) {
      ensureRecipientsIsMutable();
      this.recipients_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addRecipientsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureRecipientsIsMutable();
      this.recipients_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearAddressLines() {
    this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearAdministrativeArea() {
    this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
  }
  
  private void clearLanguageCode() {
    this.languageCode_ = getDefaultInstance().getLanguageCode();
  }
  
  private void clearLocality() {
    this.locality_ = getDefaultInstance().getLocality();
  }
  
  private void clearOrganization() {
    this.organization_ = getDefaultInstance().getOrganization();
  }
  
  private void clearPostalCode() {
    this.postalCode_ = getDefaultInstance().getPostalCode();
  }
  
  private void clearRecipients() {
    this.recipients_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearRegionCode() {
    this.regionCode_ = getDefaultInstance().getRegionCode();
  }
  
  private void clearRevision() {
    this.revision_ = 0;
  }
  
  private void clearSortingCode() {
    this.sortingCode_ = getDefaultInstance().getSortingCode();
  }
  
  private void clearSublocality() {
    this.sublocality_ = getDefaultInstance().getSublocality();
  }
  
  private void ensureAddressLinesIsMutable() {
    if (!this.addressLines_.isModifiable())
      this.addressLines_ = GeneratedMessageLite.mutableCopy(this.addressLines_); 
  }
  
  private void ensureRecipientsIsMutable() {
    if (!this.recipients_.isModifiable())
      this.recipients_ = GeneratedMessageLite.mutableCopy(this.recipients_); 
  }
  
  public static PostalAddress getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PostalAddress paramPostalAddress) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPostalAddress);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PostalAddress> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAddressLines(int paramInt, String paramString) {
    if (paramString != null) {
      ensureAddressLinesIsMutable();
      this.addressLines_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAdministrativeArea(String paramString) {
    if (paramString != null) {
      this.administrativeArea_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAdministrativeAreaBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.administrativeArea_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLanguageCode(String paramString) {
    if (paramString != null) {
      this.languageCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLanguageCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.languageCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLocality(String paramString) {
    if (paramString != null) {
      this.locality_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLocalityBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.locality_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOrganization(String paramString) {
    if (paramString != null) {
      this.organization_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOrganizationBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.organization_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPostalCode(String paramString) {
    if (paramString != null) {
      this.postalCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPostalCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.postalCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRecipients(int paramInt, String paramString) {
    if (paramString != null) {
      ensureRecipientsIsMutable();
      this.recipients_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRegionCode(String paramString) {
    if (paramString != null) {
      this.regionCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRegionCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.regionCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRevision(int paramInt) {
    this.revision_ = paramInt;
  }
  
  private void setSortingCode(String paramString) {
    if (paramString != null) {
      this.sortingCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSortingCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.sortingCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSublocality(String paramString) {
    if (paramString != null) {
      this.sublocality_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSublocalityBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.sublocality_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/PostalAddress$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 951, 2 -> 947, 3 -> 927, 4 -> 918, 5 -> 510, 6 -> 118, 7 -> 506, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/PostalAddress
    //   80: monitorenter
    //   81: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/PostalAddress
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/PostalAddress
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/PostalAddress.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 506
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: lookupswitch default -> 248, 0 -> 442, 8 -> 431, 18 -> 420, 26 -> 409, 34 -> 398, 42 -> 387, 50 -> 376, 58 -> 365, 66 -> 354, 74 -> 312, 82 -> 270, 90 -> 259
    //   248: aload_1
    //   249: iload #4
    //   251: invokevirtual skipField : (I)Z
    //   254: istore #7
    //   256: goto -> 448
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   264: putfield organization_ : Ljava/lang/String;
    //   267: goto -> 128
    //   270: aload_1
    //   271: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   274: astore_2
    //   275: aload_0
    //   276: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   279: invokeinterface isModifiable : ()Z
    //   284: ifne -> 298
    //   287: aload_0
    //   288: aload_0
    //   289: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   292: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   295: putfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   298: aload_0
    //   299: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   302: aload_2
    //   303: invokeinterface add : (Ljava/lang/Object;)Z
    //   308: pop
    //   309: goto -> 128
    //   312: aload_1
    //   313: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   316: astore_2
    //   317: aload_0
    //   318: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   321: invokeinterface isModifiable : ()Z
    //   326: ifne -> 340
    //   329: aload_0
    //   330: aload_0
    //   331: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   334: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   337: putfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   340: aload_0
    //   341: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   344: aload_2
    //   345: invokeinterface add : (Ljava/lang/Object;)Z
    //   350: pop
    //   351: goto -> 128
    //   354: aload_0
    //   355: aload_1
    //   356: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   359: putfield sublocality_ : Ljava/lang/String;
    //   362: goto -> 128
    //   365: aload_0
    //   366: aload_1
    //   367: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   370: putfield locality_ : Ljava/lang/String;
    //   373: goto -> 128
    //   376: aload_0
    //   377: aload_1
    //   378: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   381: putfield administrativeArea_ : Ljava/lang/String;
    //   384: goto -> 128
    //   387: aload_0
    //   388: aload_1
    //   389: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   392: putfield sortingCode_ : Ljava/lang/String;
    //   395: goto -> 128
    //   398: aload_0
    //   399: aload_1
    //   400: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   403: putfield postalCode_ : Ljava/lang/String;
    //   406: goto -> 128
    //   409: aload_0
    //   410: aload_1
    //   411: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   414: putfield languageCode_ : Ljava/lang/String;
    //   417: goto -> 128
    //   420: aload_0
    //   421: aload_1
    //   422: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   425: putfield regionCode_ : Ljava/lang/String;
    //   428: goto -> 128
    //   431: aload_0
    //   432: aload_1
    //   433: invokevirtual readInt32 : ()I
    //   436: putfield revision_ : I
    //   439: goto -> 128
    //   442: iconst_1
    //   443: istore #6
    //   445: goto -> 128
    //   448: iload #7
    //   450: ifne -> 128
    //   453: goto -> 442
    //   456: astore_1
    //   457: goto -> 504
    //   460: astore_1
    //   461: new java/lang/RuntimeException
    //   464: astore_3
    //   465: new com/google/protobuf/InvalidProtocolBufferException
    //   468: astore_2
    //   469: aload_2
    //   470: aload_1
    //   471: invokevirtual getMessage : ()Ljava/lang/String;
    //   474: invokespecial <init> : (Ljava/lang/String;)V
    //   477: aload_3
    //   478: aload_2
    //   479: aload_0
    //   480: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   483: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   486: aload_3
    //   487: athrow
    //   488: astore_2
    //   489: new java/lang/RuntimeException
    //   492: astore_1
    //   493: aload_1
    //   494: aload_2
    //   495: aload_0
    //   496: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   499: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   502: aload_1
    //   503: athrow
    //   504: aload_1
    //   505: athrow
    //   506: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   509: areturn
    //   510: aload_2
    //   511: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   514: astore_1
    //   515: aload_3
    //   516: checkcast com/google/type/PostalAddress
    //   519: astore_2
    //   520: aload_0
    //   521: getfield revision_ : I
    //   524: ifeq -> 533
    //   527: iconst_1
    //   528: istore #7
    //   530: goto -> 536
    //   533: iconst_0
    //   534: istore #7
    //   536: aload_0
    //   537: getfield revision_ : I
    //   540: istore #6
    //   542: aload_2
    //   543: getfield revision_ : I
    //   546: ifeq -> 552
    //   549: iconst_1
    //   550: istore #5
    //   552: aload_0
    //   553: aload_1
    //   554: iload #7
    //   556: iload #6
    //   558: iload #5
    //   560: aload_2
    //   561: getfield revision_ : I
    //   564: invokeinterface visitInt : (ZIZI)I
    //   569: putfield revision_ : I
    //   572: aload_0
    //   573: aload_1
    //   574: aload_0
    //   575: getfield regionCode_ : Ljava/lang/String;
    //   578: invokevirtual isEmpty : ()Z
    //   581: iconst_1
    //   582: ixor
    //   583: aload_0
    //   584: getfield regionCode_ : Ljava/lang/String;
    //   587: aload_2
    //   588: getfield regionCode_ : Ljava/lang/String;
    //   591: invokevirtual isEmpty : ()Z
    //   594: iconst_1
    //   595: ixor
    //   596: aload_2
    //   597: getfield regionCode_ : Ljava/lang/String;
    //   600: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   605: putfield regionCode_ : Ljava/lang/String;
    //   608: aload_0
    //   609: aload_1
    //   610: aload_0
    //   611: getfield languageCode_ : Ljava/lang/String;
    //   614: invokevirtual isEmpty : ()Z
    //   617: iconst_1
    //   618: ixor
    //   619: aload_0
    //   620: getfield languageCode_ : Ljava/lang/String;
    //   623: aload_2
    //   624: getfield languageCode_ : Ljava/lang/String;
    //   627: invokevirtual isEmpty : ()Z
    //   630: iconst_1
    //   631: ixor
    //   632: aload_2
    //   633: getfield languageCode_ : Ljava/lang/String;
    //   636: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   641: putfield languageCode_ : Ljava/lang/String;
    //   644: aload_0
    //   645: aload_1
    //   646: aload_0
    //   647: getfield postalCode_ : Ljava/lang/String;
    //   650: invokevirtual isEmpty : ()Z
    //   653: iconst_1
    //   654: ixor
    //   655: aload_0
    //   656: getfield postalCode_ : Ljava/lang/String;
    //   659: aload_2
    //   660: getfield postalCode_ : Ljava/lang/String;
    //   663: invokevirtual isEmpty : ()Z
    //   666: iconst_1
    //   667: ixor
    //   668: aload_2
    //   669: getfield postalCode_ : Ljava/lang/String;
    //   672: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   677: putfield postalCode_ : Ljava/lang/String;
    //   680: aload_0
    //   681: aload_1
    //   682: aload_0
    //   683: getfield sortingCode_ : Ljava/lang/String;
    //   686: invokevirtual isEmpty : ()Z
    //   689: iconst_1
    //   690: ixor
    //   691: aload_0
    //   692: getfield sortingCode_ : Ljava/lang/String;
    //   695: aload_2
    //   696: getfield sortingCode_ : Ljava/lang/String;
    //   699: invokevirtual isEmpty : ()Z
    //   702: iconst_1
    //   703: ixor
    //   704: aload_2
    //   705: getfield sortingCode_ : Ljava/lang/String;
    //   708: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   713: putfield sortingCode_ : Ljava/lang/String;
    //   716: aload_0
    //   717: aload_1
    //   718: aload_0
    //   719: getfield administrativeArea_ : Ljava/lang/String;
    //   722: invokevirtual isEmpty : ()Z
    //   725: iconst_1
    //   726: ixor
    //   727: aload_0
    //   728: getfield administrativeArea_ : Ljava/lang/String;
    //   731: aload_2
    //   732: getfield administrativeArea_ : Ljava/lang/String;
    //   735: invokevirtual isEmpty : ()Z
    //   738: iconst_1
    //   739: ixor
    //   740: aload_2
    //   741: getfield administrativeArea_ : Ljava/lang/String;
    //   744: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   749: putfield administrativeArea_ : Ljava/lang/String;
    //   752: aload_0
    //   753: aload_1
    //   754: aload_0
    //   755: getfield locality_ : Ljava/lang/String;
    //   758: invokevirtual isEmpty : ()Z
    //   761: iconst_1
    //   762: ixor
    //   763: aload_0
    //   764: getfield locality_ : Ljava/lang/String;
    //   767: aload_2
    //   768: getfield locality_ : Ljava/lang/String;
    //   771: invokevirtual isEmpty : ()Z
    //   774: iconst_1
    //   775: ixor
    //   776: aload_2
    //   777: getfield locality_ : Ljava/lang/String;
    //   780: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   785: putfield locality_ : Ljava/lang/String;
    //   788: aload_0
    //   789: aload_1
    //   790: aload_0
    //   791: getfield sublocality_ : Ljava/lang/String;
    //   794: invokevirtual isEmpty : ()Z
    //   797: iconst_1
    //   798: ixor
    //   799: aload_0
    //   800: getfield sublocality_ : Ljava/lang/String;
    //   803: aload_2
    //   804: getfield sublocality_ : Ljava/lang/String;
    //   807: invokevirtual isEmpty : ()Z
    //   810: iconst_1
    //   811: ixor
    //   812: aload_2
    //   813: getfield sublocality_ : Ljava/lang/String;
    //   816: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   821: putfield sublocality_ : Ljava/lang/String;
    //   824: aload_0
    //   825: aload_1
    //   826: aload_0
    //   827: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   830: aload_2
    //   831: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   834: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   839: putfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   842: aload_0
    //   843: aload_1
    //   844: aload_0
    //   845: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   848: aload_2
    //   849: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   852: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   857: putfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   860: aload_0
    //   861: aload_1
    //   862: aload_0
    //   863: getfield organization_ : Ljava/lang/String;
    //   866: invokevirtual isEmpty : ()Z
    //   869: iconst_1
    //   870: ixor
    //   871: aload_0
    //   872: getfield organization_ : Ljava/lang/String;
    //   875: aload_2
    //   876: getfield organization_ : Ljava/lang/String;
    //   879: invokevirtual isEmpty : ()Z
    //   882: iconst_1
    //   883: ixor
    //   884: aload_2
    //   885: getfield organization_ : Ljava/lang/String;
    //   888: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   893: putfield organization_ : Ljava/lang/String;
    //   896: aload_1
    //   897: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   900: if_acmpne -> 916
    //   903: aload_0
    //   904: aload_0
    //   905: getfield bitField0_ : I
    //   908: aload_2
    //   909: getfield bitField0_ : I
    //   912: ior
    //   913: putfield bitField0_ : I
    //   916: aload_0
    //   917: areturn
    //   918: new com/google/type/PostalAddress$Builder
    //   921: dup
    //   922: aconst_null
    //   923: invokespecial <init> : (Lcom/google/type/PostalAddress$1;)V
    //   926: areturn
    //   927: aload_0
    //   928: getfield addressLines_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   931: invokeinterface makeImmutable : ()V
    //   936: aload_0
    //   937: getfield recipients_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   940: invokeinterface makeImmutable : ()V
    //   945: aconst_null
    //   946: areturn
    //   947: getstatic com/google/type/PostalAddress.DEFAULT_INSTANCE : Lcom/google/type/PostalAddress;
    //   950: areturn
    //   951: new com/google/type/PostalAddress
    //   954: dup
    //   955: invokespecial <init> : ()V
    //   958: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	488	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	460	java/io/IOException
    //   133	139	456	finally
    //   248	256	488	com/google/protobuf/InvalidProtocolBufferException
    //   248	256	460	java/io/IOException
    //   248	256	456	finally
    //   259	267	488	com/google/protobuf/InvalidProtocolBufferException
    //   259	267	460	java/io/IOException
    //   259	267	456	finally
    //   270	298	488	com/google/protobuf/InvalidProtocolBufferException
    //   270	298	460	java/io/IOException
    //   270	298	456	finally
    //   298	309	488	com/google/protobuf/InvalidProtocolBufferException
    //   298	309	460	java/io/IOException
    //   298	309	456	finally
    //   312	340	488	com/google/protobuf/InvalidProtocolBufferException
    //   312	340	460	java/io/IOException
    //   312	340	456	finally
    //   340	351	488	com/google/protobuf/InvalidProtocolBufferException
    //   340	351	460	java/io/IOException
    //   340	351	456	finally
    //   354	362	488	com/google/protobuf/InvalidProtocolBufferException
    //   354	362	460	java/io/IOException
    //   354	362	456	finally
    //   365	373	488	com/google/protobuf/InvalidProtocolBufferException
    //   365	373	460	java/io/IOException
    //   365	373	456	finally
    //   376	384	488	com/google/protobuf/InvalidProtocolBufferException
    //   376	384	460	java/io/IOException
    //   376	384	456	finally
    //   387	395	488	com/google/protobuf/InvalidProtocolBufferException
    //   387	395	460	java/io/IOException
    //   387	395	456	finally
    //   398	406	488	com/google/protobuf/InvalidProtocolBufferException
    //   398	406	460	java/io/IOException
    //   398	406	456	finally
    //   409	417	488	com/google/protobuf/InvalidProtocolBufferException
    //   409	417	460	java/io/IOException
    //   409	417	456	finally
    //   420	428	488	com/google/protobuf/InvalidProtocolBufferException
    //   420	428	460	java/io/IOException
    //   420	428	456	finally
    //   431	439	488	com/google/protobuf/InvalidProtocolBufferException
    //   431	439	460	java/io/IOException
    //   431	439	456	finally
    //   461	488	456	finally
    //   489	504	456	finally
  }
  
  public String getAddressLines(int paramInt) {
    return (String)this.addressLines_.get(paramInt);
  }
  
  public ByteString getAddressLinesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.addressLines_.get(paramInt));
  }
  
  public int getAddressLinesCount() {
    return this.addressLines_.size();
  }
  
  public List<String> getAddressLinesList() {
    return (List<String>)this.addressLines_;
  }
  
  public String getAdministrativeArea() {
    return this.administrativeArea_;
  }
  
  public ByteString getAdministrativeAreaBytes() {
    return ByteString.copyFromUtf8(this.administrativeArea_);
  }
  
  public String getLanguageCode() {
    return this.languageCode_;
  }
  
  public ByteString getLanguageCodeBytes() {
    return ByteString.copyFromUtf8(this.languageCode_);
  }
  
  public String getLocality() {
    return this.locality_;
  }
  
  public ByteString getLocalityBytes() {
    return ByteString.copyFromUtf8(this.locality_);
  }
  
  public String getOrganization() {
    return this.organization_;
  }
  
  public ByteString getOrganizationBytes() {
    return ByteString.copyFromUtf8(this.organization_);
  }
  
  public String getPostalCode() {
    return this.postalCode_;
  }
  
  public ByteString getPostalCodeBytes() {
    return ByteString.copyFromUtf8(this.postalCode_);
  }
  
  public String getRecipients(int paramInt) {
    return (String)this.recipients_.get(paramInt);
  }
  
  public ByteString getRecipientsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.recipients_.get(paramInt));
  }
  
  public int getRecipientsCount() {
    return this.recipients_.size();
  }
  
  public List<String> getRecipientsList() {
    return (List<String>)this.recipients_;
  }
  
  public String getRegionCode() {
    return this.regionCode_;
  }
  
  public ByteString getRegionCodeBytes() {
    return ByteString.copyFromUtf8(this.regionCode_);
  }
  
  public int getRevision() {
    return this.revision_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = this.revision_;
    boolean bool = false;
    if (i != 0) {
      i = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.regionCode_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getRegionCode()); 
    i = j;
    if (!this.languageCode_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(3, getLanguageCode()); 
    j = i;
    if (!this.postalCode_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getPostalCode()); 
    int k = j;
    if (!this.sortingCode_.isEmpty())
      k = j + CodedOutputStream.computeStringSize(5, getSortingCode()); 
    i = k;
    if (!this.administrativeArea_.isEmpty())
      i = k + CodedOutputStream.computeStringSize(6, getAdministrativeArea()); 
    j = i;
    if (!this.locality_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getLocality()); 
    i = j;
    if (!this.sublocality_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(8, getSublocality()); 
    k = 0;
    j = k;
    while (k < this.addressLines_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.addressLines_.get(k));
      k++;
    } 
    int m = getAddressLinesList().size();
    int n = 0;
    for (k = bool; k < this.recipients_.size(); k++)
      n += CodedOutputStream.computeStringSizeNoTag((String)this.recipients_.get(k)); 
    j = i + j + m * 1 + n + getRecipientsList().size() * 1;
    i = j;
    if (!this.organization_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(11, getOrganization()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getSortingCode() {
    return this.sortingCode_;
  }
  
  public ByteString getSortingCodeBytes() {
    return ByteString.copyFromUtf8(this.sortingCode_);
  }
  
  public String getSublocality() {
    return this.sublocality_;
  }
  
  public ByteString getSublocalityBytes() {
    return ByteString.copyFromUtf8(this.sublocality_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    byte b2;
    int i = this.revision_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!this.regionCode_.isEmpty())
      paramCodedOutputStream.writeString(2, getRegionCode()); 
    if (!this.languageCode_.isEmpty())
      paramCodedOutputStream.writeString(3, getLanguageCode()); 
    if (!this.postalCode_.isEmpty())
      paramCodedOutputStream.writeString(4, getPostalCode()); 
    if (!this.sortingCode_.isEmpty())
      paramCodedOutputStream.writeString(5, getSortingCode()); 
    if (!this.administrativeArea_.isEmpty())
      paramCodedOutputStream.writeString(6, getAdministrativeArea()); 
    if (!this.locality_.isEmpty())
      paramCodedOutputStream.writeString(7, getLocality()); 
    if (!this.sublocality_.isEmpty())
      paramCodedOutputStream.writeString(8, getSublocality()); 
    byte b1 = 0;
    i = 0;
    while (true) {
      b2 = b1;
      if (i < this.addressLines_.size()) {
        paramCodedOutputStream.writeString(9, (String)this.addressLines_.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (b2 < this.recipients_.size()) {
      paramCodedOutputStream.writeString(10, (String)this.recipients_.get(b2));
      b2++;
    } 
    if (!this.organization_.isEmpty())
      paramCodedOutputStream.writeString(11, getOrganization()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
    private Builder() {
      super(PostalAddress.DEFAULT_INSTANCE);
    }
    
    public Builder addAddressLines(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAddressLines(param1String);
      return this;
    }
    
    public Builder addAddressLinesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAddressLinesBytes(param1ByteString);
      return this;
    }
    
    public Builder addAllAddressLines(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAllAddressLines(param1Iterable);
      return this;
    }
    
    public Builder addAllRecipients(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PostalAddress)this.instance).addAllRecipients(param1Iterable);
      return this;
    }
    
    public Builder addRecipients(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).addRecipients(param1String);
      return this;
    }
    
    public Builder addRecipientsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).addRecipientsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearAddressLines() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearAddressLines();
      return this;
    }
    
    public Builder clearAdministrativeArea() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearAdministrativeArea();
      return this;
    }
    
    public Builder clearLanguageCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearLanguageCode();
      return this;
    }
    
    public Builder clearLocality() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearLocality();
      return this;
    }
    
    public Builder clearOrganization() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearOrganization();
      return this;
    }
    
    public Builder clearPostalCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearPostalCode();
      return this;
    }
    
    public Builder clearRecipients() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRecipients();
      return this;
    }
    
    public Builder clearRegionCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRegionCode();
      return this;
    }
    
    public Builder clearRevision() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearRevision();
      return this;
    }
    
    public Builder clearSortingCode() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearSortingCode();
      return this;
    }
    
    public Builder clearSublocality() {
      copyOnWrite();
      ((PostalAddress)this.instance).clearSublocality();
      return this;
    }
    
    public String getAddressLines(int param1Int) {
      return ((PostalAddress)this.instance).getAddressLines(param1Int);
    }
    
    public ByteString getAddressLinesBytes(int param1Int) {
      return ((PostalAddress)this.instance).getAddressLinesBytes(param1Int);
    }
    
    public int getAddressLinesCount() {
      return ((PostalAddress)this.instance).getAddressLinesCount();
    }
    
    public List<String> getAddressLinesList() {
      return Collections.unmodifiableList(((PostalAddress)this.instance).getAddressLinesList());
    }
    
    public String getAdministrativeArea() {
      return ((PostalAddress)this.instance).getAdministrativeArea();
    }
    
    public ByteString getAdministrativeAreaBytes() {
      return ((PostalAddress)this.instance).getAdministrativeAreaBytes();
    }
    
    public String getLanguageCode() {
      return ((PostalAddress)this.instance).getLanguageCode();
    }
    
    public ByteString getLanguageCodeBytes() {
      return ((PostalAddress)this.instance).getLanguageCodeBytes();
    }
    
    public String getLocality() {
      return ((PostalAddress)this.instance).getLocality();
    }
    
    public ByteString getLocalityBytes() {
      return ((PostalAddress)this.instance).getLocalityBytes();
    }
    
    public String getOrganization() {
      return ((PostalAddress)this.instance).getOrganization();
    }
    
    public ByteString getOrganizationBytes() {
      return ((PostalAddress)this.instance).getOrganizationBytes();
    }
    
    public String getPostalCode() {
      return ((PostalAddress)this.instance).getPostalCode();
    }
    
    public ByteString getPostalCodeBytes() {
      return ((PostalAddress)this.instance).getPostalCodeBytes();
    }
    
    public String getRecipients(int param1Int) {
      return ((PostalAddress)this.instance).getRecipients(param1Int);
    }
    
    public ByteString getRecipientsBytes(int param1Int) {
      return ((PostalAddress)this.instance).getRecipientsBytes(param1Int);
    }
    
    public int getRecipientsCount() {
      return ((PostalAddress)this.instance).getRecipientsCount();
    }
    
    public List<String> getRecipientsList() {
      return Collections.unmodifiableList(((PostalAddress)this.instance).getRecipientsList());
    }
    
    public String getRegionCode() {
      return ((PostalAddress)this.instance).getRegionCode();
    }
    
    public ByteString getRegionCodeBytes() {
      return ((PostalAddress)this.instance).getRegionCodeBytes();
    }
    
    public int getRevision() {
      return ((PostalAddress)this.instance).getRevision();
    }
    
    public String getSortingCode() {
      return ((PostalAddress)this.instance).getSortingCode();
    }
    
    public ByteString getSortingCodeBytes() {
      return ((PostalAddress)this.instance).getSortingCodeBytes();
    }
    
    public String getSublocality() {
      return ((PostalAddress)this.instance).getSublocality();
    }
    
    public ByteString getSublocalityBytes() {
      return ((PostalAddress)this.instance).getSublocalityBytes();
    }
    
    public Builder setAddressLines(int param1Int, String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAddressLines(param1Int, param1String);
      return this;
    }
    
    public Builder setAdministrativeArea(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAdministrativeArea(param1String);
      return this;
    }
    
    public Builder setAdministrativeAreaBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setAdministrativeAreaBytes(param1ByteString);
      return this;
    }
    
    public Builder setLanguageCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLanguageCode(param1String);
      return this;
    }
    
    public Builder setLanguageCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLanguageCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setLocality(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLocality(param1String);
      return this;
    }
    
    public Builder setLocalityBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setLocalityBytes(param1ByteString);
      return this;
    }
    
    public Builder setOrganization(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setOrganization(param1String);
      return this;
    }
    
    public Builder setOrganizationBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setOrganizationBytes(param1ByteString);
      return this;
    }
    
    public Builder setPostalCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setPostalCode(param1String);
      return this;
    }
    
    public Builder setPostalCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setPostalCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setRecipients(int param1Int, String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRecipients(param1Int, param1String);
      return this;
    }
    
    public Builder setRegionCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRegionCode(param1String);
      return this;
    }
    
    public Builder setRegionCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRegionCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setRevision(int param1Int) {
      copyOnWrite();
      ((PostalAddress)this.instance).setRevision(param1Int);
      return this;
    }
    
    public Builder setSortingCode(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSortingCode(param1String);
      return this;
    }
    
    public Builder setSortingCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSortingCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setSublocality(String param1String) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSublocality(param1String);
      return this;
    }
    
    public Builder setSublocalityBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PostalAddress)this.instance).setSublocalityBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\PostalAddress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */