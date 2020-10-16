package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class HttpRequest extends GeneratedMessageLite<HttpRequest, HttpRequest.Builder> implements HttpRequestOrBuilder {
  public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
  
  public static final int CACHE_HIT_FIELD_NUMBER = 9;
  
  public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
  
  public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
  
  private static final HttpRequest DEFAULT_INSTANCE = new HttpRequest();
  
  public static final int LATENCY_FIELD_NUMBER = 14;
  
  private static volatile Parser<HttpRequest> PARSER;
  
  public static final int PROTOCOL_FIELD_NUMBER = 15;
  
  public static final int REFERER_FIELD_NUMBER = 8;
  
  public static final int REMOTE_IP_FIELD_NUMBER = 7;
  
  public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
  
  public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
  
  public static final int REQUEST_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
  
  public static final int SERVER_IP_FIELD_NUMBER = 13;
  
  public static final int STATUS_FIELD_NUMBER = 4;
  
  public static final int USER_AGENT_FIELD_NUMBER = 6;
  
  private long cacheFillBytes_;
  
  private boolean cacheHit_;
  
  private boolean cacheLookup_;
  
  private boolean cacheValidatedWithOriginServer_;
  
  private Duration latency_;
  
  private String protocol_ = "";
  
  private String referer_ = "";
  
  private String remoteIp_ = "";
  
  private String requestMethod_ = "";
  
  private long requestSize_;
  
  private String requestUrl_ = "";
  
  private long responseSize_;
  
  private String serverIp_ = "";
  
  private int status_;
  
  private String userAgent_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCacheFillBytes() {
    this.cacheFillBytes_ = 0L;
  }
  
  private void clearCacheHit() {
    this.cacheHit_ = false;
  }
  
  private void clearCacheLookup() {
    this.cacheLookup_ = false;
  }
  
  private void clearCacheValidatedWithOriginServer() {
    this.cacheValidatedWithOriginServer_ = false;
  }
  
  private void clearLatency() {
    this.latency_ = null;
  }
  
  private void clearProtocol() {
    this.protocol_ = getDefaultInstance().getProtocol();
  }
  
  private void clearReferer() {
    this.referer_ = getDefaultInstance().getReferer();
  }
  
  private void clearRemoteIp() {
    this.remoteIp_ = getDefaultInstance().getRemoteIp();
  }
  
  private void clearRequestMethod() {
    this.requestMethod_ = getDefaultInstance().getRequestMethod();
  }
  
  private void clearRequestSize() {
    this.requestSize_ = 0L;
  }
  
  private void clearRequestUrl() {
    this.requestUrl_ = getDefaultInstance().getRequestUrl();
  }
  
  private void clearResponseSize() {
    this.responseSize_ = 0L;
  }
  
  private void clearServerIp() {
    this.serverIp_ = getDefaultInstance().getServerIp();
  }
  
  private void clearStatus() {
    this.status_ = 0;
  }
  
  private void clearUserAgent() {
    this.userAgent_ = getDefaultInstance().getUserAgent();
  }
  
  public static HttpRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeLatency(Duration paramDuration) {
    Duration duration = this.latency_;
    if (duration != null && duration != Duration.getDefaultInstance()) {
      this.latency_ = (Duration)((Duration.Builder)Duration.newBuilder(this.latency_).mergeFrom((GeneratedMessageLite)paramDuration)).buildPartial();
    } else {
      this.latency_ = paramDuration;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpRequest paramHttpRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHttpRequest);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static HttpRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static HttpRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static HttpRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCacheFillBytes(long paramLong) {
    this.cacheFillBytes_ = paramLong;
  }
  
  private void setCacheHit(boolean paramBoolean) {
    this.cacheHit_ = paramBoolean;
  }
  
  private void setCacheLookup(boolean paramBoolean) {
    this.cacheLookup_ = paramBoolean;
  }
  
  private void setCacheValidatedWithOriginServer(boolean paramBoolean) {
    this.cacheValidatedWithOriginServer_ = paramBoolean;
  }
  
  private void setLatency(Duration.Builder paramBuilder) {
    this.latency_ = (Duration)paramBuilder.build();
  }
  
  private void setLatency(Duration paramDuration) {
    if (paramDuration != null) {
      this.latency_ = paramDuration;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProtocol(String paramString) {
    if (paramString != null) {
      this.protocol_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProtocolBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.protocol_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReferer(String paramString) {
    if (paramString != null) {
      this.referer_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRefererBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.referer_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRemoteIp(String paramString) {
    if (paramString != null) {
      this.remoteIp_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRemoteIpBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.remoteIp_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestMethod(String paramString) {
    if (paramString != null) {
      this.requestMethod_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestMethodBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestMethod_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestSize(long paramLong) {
    this.requestSize_ = paramLong;
  }
  
  private void setRequestUrl(String paramString) {
    if (paramString != null) {
      this.requestUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseSize(long paramLong) {
    this.responseSize_ = paramLong;
  }
  
  private void setServerIp(String paramString) {
    if (paramString != null) {
      this.serverIp_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setServerIpBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.serverIp_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStatus(int paramInt) {
    this.status_ = paramInt;
  }
  
  private void setUserAgent(String paramString) {
    if (paramString != null) {
      this.userAgent_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUserAgentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.userAgent_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/logging/type/HttpRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 1212, 2 -> 1208, 3 -> 1206, 4 -> 1197, 5 -> 574, 6 -> 114, 7 -> 570, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/logging/type/HttpRequest
    //   76: monitorenter
    //   77: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/logging/type/HttpRequest
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/logging/type/HttpRequest
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/logging/type/HttpRequest.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_2
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_3
    //   124: iload #5
    //   126: ifne -> 570
    //   129: aload_2
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: lookupswitch default -> 276, 0 -> 506, 10 -> 495, 18 -> 484, 24 -> 473, 32 -> 462, 40 -> 451, 50 -> 440, 58 -> 429, 66 -> 418, 72 -> 407, 80 -> 396, 88 -> 385, 96 -> 374, 106 -> 363, 114 -> 298, 122 -> 287
    //   276: aload_2
    //   277: iload #4
    //   279: invokevirtual skipField : (I)Z
    //   282: istore #6
    //   284: goto -> 512
    //   287: aload_0
    //   288: aload_2
    //   289: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   292: putfield protocol_ : Ljava/lang/String;
    //   295: goto -> 124
    //   298: aload_0
    //   299: getfield latency_ : Lcom/google/protobuf/Duration;
    //   302: ifnull -> 319
    //   305: aload_0
    //   306: getfield latency_ : Lcom/google/protobuf/Duration;
    //   309: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   312: checkcast com/google/protobuf/Duration$Builder
    //   315: astore_1
    //   316: goto -> 321
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_0
    //   322: aload_2
    //   323: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   326: aload_3
    //   327: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   330: checkcast com/google/protobuf/Duration
    //   333: putfield latency_ : Lcom/google/protobuf/Duration;
    //   336: aload_1
    //   337: ifnull -> 124
    //   340: aload_1
    //   341: aload_0
    //   342: getfield latency_ : Lcom/google/protobuf/Duration;
    //   345: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   348: pop
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   354: checkcast com/google/protobuf/Duration
    //   357: putfield latency_ : Lcom/google/protobuf/Duration;
    //   360: goto -> 124
    //   363: aload_0
    //   364: aload_2
    //   365: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   368: putfield serverIp_ : Ljava/lang/String;
    //   371: goto -> 124
    //   374: aload_0
    //   375: aload_2
    //   376: invokevirtual readInt64 : ()J
    //   379: putfield cacheFillBytes_ : J
    //   382: goto -> 124
    //   385: aload_0
    //   386: aload_2
    //   387: invokevirtual readBool : ()Z
    //   390: putfield cacheLookup_ : Z
    //   393: goto -> 124
    //   396: aload_0
    //   397: aload_2
    //   398: invokevirtual readBool : ()Z
    //   401: putfield cacheValidatedWithOriginServer_ : Z
    //   404: goto -> 124
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual readBool : ()Z
    //   412: putfield cacheHit_ : Z
    //   415: goto -> 124
    //   418: aload_0
    //   419: aload_2
    //   420: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   423: putfield referer_ : Ljava/lang/String;
    //   426: goto -> 124
    //   429: aload_0
    //   430: aload_2
    //   431: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   434: putfield remoteIp_ : Ljava/lang/String;
    //   437: goto -> 124
    //   440: aload_0
    //   441: aload_2
    //   442: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   445: putfield userAgent_ : Ljava/lang/String;
    //   448: goto -> 124
    //   451: aload_0
    //   452: aload_2
    //   453: invokevirtual readInt64 : ()J
    //   456: putfield responseSize_ : J
    //   459: goto -> 124
    //   462: aload_0
    //   463: aload_2
    //   464: invokevirtual readInt32 : ()I
    //   467: putfield status_ : I
    //   470: goto -> 124
    //   473: aload_0
    //   474: aload_2
    //   475: invokevirtual readInt64 : ()J
    //   478: putfield requestSize_ : J
    //   481: goto -> 124
    //   484: aload_0
    //   485: aload_2
    //   486: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   489: putfield requestUrl_ : Ljava/lang/String;
    //   492: goto -> 124
    //   495: aload_0
    //   496: aload_2
    //   497: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   500: putfield requestMethod_ : Ljava/lang/String;
    //   503: goto -> 124
    //   506: iconst_1
    //   507: istore #5
    //   509: goto -> 124
    //   512: iload #6
    //   514: ifne -> 124
    //   517: goto -> 506
    //   520: astore_1
    //   521: goto -> 568
    //   524: astore_2
    //   525: new java/lang/RuntimeException
    //   528: astore_3
    //   529: new com/google/protobuf/InvalidProtocolBufferException
    //   532: astore_1
    //   533: aload_1
    //   534: aload_2
    //   535: invokevirtual getMessage : ()Ljava/lang/String;
    //   538: invokespecial <init> : (Ljava/lang/String;)V
    //   541: aload_3
    //   542: aload_1
    //   543: aload_0
    //   544: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   547: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   550: aload_3
    //   551: athrow
    //   552: astore_2
    //   553: new java/lang/RuntimeException
    //   556: astore_1
    //   557: aload_1
    //   558: aload_2
    //   559: aload_0
    //   560: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   563: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   566: aload_1
    //   567: athrow
    //   568: aload_1
    //   569: athrow
    //   570: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   573: areturn
    //   574: aload_2
    //   575: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   578: astore_1
    //   579: aload_3
    //   580: checkcast com/google/logging/type/HttpRequest
    //   583: astore_2
    //   584: aload_0
    //   585: aload_1
    //   586: aload_0
    //   587: getfield requestMethod_ : Ljava/lang/String;
    //   590: invokevirtual isEmpty : ()Z
    //   593: iconst_1
    //   594: ixor
    //   595: aload_0
    //   596: getfield requestMethod_ : Ljava/lang/String;
    //   599: aload_2
    //   600: getfield requestMethod_ : Ljava/lang/String;
    //   603: invokevirtual isEmpty : ()Z
    //   606: iconst_1
    //   607: ixor
    //   608: aload_2
    //   609: getfield requestMethod_ : Ljava/lang/String;
    //   612: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   617: putfield requestMethod_ : Ljava/lang/String;
    //   620: aload_0
    //   621: aload_1
    //   622: aload_0
    //   623: getfield requestUrl_ : Ljava/lang/String;
    //   626: invokevirtual isEmpty : ()Z
    //   629: iconst_1
    //   630: ixor
    //   631: aload_0
    //   632: getfield requestUrl_ : Ljava/lang/String;
    //   635: aload_2
    //   636: getfield requestUrl_ : Ljava/lang/String;
    //   639: invokevirtual isEmpty : ()Z
    //   642: iconst_1
    //   643: ixor
    //   644: aload_2
    //   645: getfield requestUrl_ : Ljava/lang/String;
    //   648: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   653: putfield requestUrl_ : Ljava/lang/String;
    //   656: aload_0
    //   657: getfield requestSize_ : J
    //   660: lconst_0
    //   661: lcmp
    //   662: ifeq -> 671
    //   665: iconst_1
    //   666: istore #6
    //   668: goto -> 674
    //   671: iconst_0
    //   672: istore #6
    //   674: aload_0
    //   675: getfield requestSize_ : J
    //   678: lstore #7
    //   680: aload_2
    //   681: getfield requestSize_ : J
    //   684: lconst_0
    //   685: lcmp
    //   686: ifeq -> 695
    //   689: iconst_1
    //   690: istore #9
    //   692: goto -> 698
    //   695: iconst_0
    //   696: istore #9
    //   698: aload_0
    //   699: aload_1
    //   700: iload #6
    //   702: lload #7
    //   704: iload #9
    //   706: aload_2
    //   707: getfield requestSize_ : J
    //   710: invokeinterface visitLong : (ZJZJ)J
    //   715: putfield requestSize_ : J
    //   718: aload_0
    //   719: getfield status_ : I
    //   722: ifeq -> 731
    //   725: iconst_1
    //   726: istore #6
    //   728: goto -> 734
    //   731: iconst_0
    //   732: istore #6
    //   734: aload_0
    //   735: getfield status_ : I
    //   738: istore #5
    //   740: aload_2
    //   741: getfield status_ : I
    //   744: ifeq -> 753
    //   747: iconst_1
    //   748: istore #9
    //   750: goto -> 756
    //   753: iconst_0
    //   754: istore #9
    //   756: aload_0
    //   757: aload_1
    //   758: iload #6
    //   760: iload #5
    //   762: iload #9
    //   764: aload_2
    //   765: getfield status_ : I
    //   768: invokeinterface visitInt : (ZIZI)I
    //   773: putfield status_ : I
    //   776: aload_0
    //   777: getfield responseSize_ : J
    //   780: lconst_0
    //   781: lcmp
    //   782: ifeq -> 791
    //   785: iconst_1
    //   786: istore #6
    //   788: goto -> 794
    //   791: iconst_0
    //   792: istore #6
    //   794: aload_0
    //   795: getfield responseSize_ : J
    //   798: lstore #7
    //   800: aload_2
    //   801: getfield responseSize_ : J
    //   804: lconst_0
    //   805: lcmp
    //   806: ifeq -> 815
    //   809: iconst_1
    //   810: istore #9
    //   812: goto -> 818
    //   815: iconst_0
    //   816: istore #9
    //   818: aload_0
    //   819: aload_1
    //   820: iload #6
    //   822: lload #7
    //   824: iload #9
    //   826: aload_2
    //   827: getfield responseSize_ : J
    //   830: invokeinterface visitLong : (ZJZJ)J
    //   835: putfield responseSize_ : J
    //   838: aload_0
    //   839: aload_1
    //   840: aload_0
    //   841: getfield userAgent_ : Ljava/lang/String;
    //   844: invokevirtual isEmpty : ()Z
    //   847: iconst_1
    //   848: ixor
    //   849: aload_0
    //   850: getfield userAgent_ : Ljava/lang/String;
    //   853: aload_2
    //   854: getfield userAgent_ : Ljava/lang/String;
    //   857: invokevirtual isEmpty : ()Z
    //   860: iconst_1
    //   861: ixor
    //   862: aload_2
    //   863: getfield userAgent_ : Ljava/lang/String;
    //   866: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   871: putfield userAgent_ : Ljava/lang/String;
    //   874: aload_0
    //   875: aload_1
    //   876: aload_0
    //   877: getfield remoteIp_ : Ljava/lang/String;
    //   880: invokevirtual isEmpty : ()Z
    //   883: iconst_1
    //   884: ixor
    //   885: aload_0
    //   886: getfield remoteIp_ : Ljava/lang/String;
    //   889: aload_2
    //   890: getfield remoteIp_ : Ljava/lang/String;
    //   893: invokevirtual isEmpty : ()Z
    //   896: iconst_1
    //   897: ixor
    //   898: aload_2
    //   899: getfield remoteIp_ : Ljava/lang/String;
    //   902: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   907: putfield remoteIp_ : Ljava/lang/String;
    //   910: aload_0
    //   911: aload_1
    //   912: aload_0
    //   913: getfield serverIp_ : Ljava/lang/String;
    //   916: invokevirtual isEmpty : ()Z
    //   919: iconst_1
    //   920: ixor
    //   921: aload_0
    //   922: getfield serverIp_ : Ljava/lang/String;
    //   925: aload_2
    //   926: getfield serverIp_ : Ljava/lang/String;
    //   929: invokevirtual isEmpty : ()Z
    //   932: iconst_1
    //   933: ixor
    //   934: aload_2
    //   935: getfield serverIp_ : Ljava/lang/String;
    //   938: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   943: putfield serverIp_ : Ljava/lang/String;
    //   946: aload_0
    //   947: aload_1
    //   948: aload_0
    //   949: getfield referer_ : Ljava/lang/String;
    //   952: invokevirtual isEmpty : ()Z
    //   955: iconst_1
    //   956: ixor
    //   957: aload_0
    //   958: getfield referer_ : Ljava/lang/String;
    //   961: aload_2
    //   962: getfield referer_ : Ljava/lang/String;
    //   965: invokevirtual isEmpty : ()Z
    //   968: iconst_1
    //   969: ixor
    //   970: aload_2
    //   971: getfield referer_ : Ljava/lang/String;
    //   974: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   979: putfield referer_ : Ljava/lang/String;
    //   982: aload_0
    //   983: aload_1
    //   984: aload_0
    //   985: getfield latency_ : Lcom/google/protobuf/Duration;
    //   988: aload_2
    //   989: getfield latency_ : Lcom/google/protobuf/Duration;
    //   992: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   997: checkcast com/google/protobuf/Duration
    //   1000: putfield latency_ : Lcom/google/protobuf/Duration;
    //   1003: aload_0
    //   1004: getfield cacheLookup_ : Z
    //   1007: istore #9
    //   1009: aload_2
    //   1010: getfield cacheLookup_ : Z
    //   1013: istore #6
    //   1015: aload_0
    //   1016: aload_1
    //   1017: iload #9
    //   1019: iload #9
    //   1021: iload #6
    //   1023: iload #6
    //   1025: invokeinterface visitBoolean : (ZZZZ)Z
    //   1030: putfield cacheLookup_ : Z
    //   1033: aload_0
    //   1034: getfield cacheHit_ : Z
    //   1037: istore #6
    //   1039: aload_2
    //   1040: getfield cacheHit_ : Z
    //   1043: istore #9
    //   1045: aload_0
    //   1046: aload_1
    //   1047: iload #6
    //   1049: iload #6
    //   1051: iload #9
    //   1053: iload #9
    //   1055: invokeinterface visitBoolean : (ZZZZ)Z
    //   1060: putfield cacheHit_ : Z
    //   1063: aload_0
    //   1064: getfield cacheValidatedWithOriginServer_ : Z
    //   1067: istore #6
    //   1069: aload_2
    //   1070: getfield cacheValidatedWithOriginServer_ : Z
    //   1073: istore #9
    //   1075: aload_0
    //   1076: aload_1
    //   1077: iload #6
    //   1079: iload #6
    //   1081: iload #9
    //   1083: iload #9
    //   1085: invokeinterface visitBoolean : (ZZZZ)Z
    //   1090: putfield cacheValidatedWithOriginServer_ : Z
    //   1093: aload_0
    //   1094: getfield cacheFillBytes_ : J
    //   1097: lconst_0
    //   1098: lcmp
    //   1099: ifeq -> 1108
    //   1102: iconst_1
    //   1103: istore #6
    //   1105: goto -> 1111
    //   1108: iconst_0
    //   1109: istore #6
    //   1111: aload_0
    //   1112: getfield cacheFillBytes_ : J
    //   1115: lstore #7
    //   1117: aload_2
    //   1118: getfield cacheFillBytes_ : J
    //   1121: lconst_0
    //   1122: lcmp
    //   1123: ifeq -> 1132
    //   1126: iconst_1
    //   1127: istore #9
    //   1129: goto -> 1135
    //   1132: iconst_0
    //   1133: istore #9
    //   1135: aload_0
    //   1136: aload_1
    //   1137: iload #6
    //   1139: lload #7
    //   1141: iload #9
    //   1143: aload_2
    //   1144: getfield cacheFillBytes_ : J
    //   1147: invokeinterface visitLong : (ZJZJ)J
    //   1152: putfield cacheFillBytes_ : J
    //   1155: aload_0
    //   1156: aload_1
    //   1157: aload_0
    //   1158: getfield protocol_ : Ljava/lang/String;
    //   1161: invokevirtual isEmpty : ()Z
    //   1164: iconst_1
    //   1165: ixor
    //   1166: aload_0
    //   1167: getfield protocol_ : Ljava/lang/String;
    //   1170: aload_2
    //   1171: getfield protocol_ : Ljava/lang/String;
    //   1174: invokevirtual isEmpty : ()Z
    //   1177: iconst_1
    //   1178: ixor
    //   1179: aload_2
    //   1180: getfield protocol_ : Ljava/lang/String;
    //   1183: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   1188: putfield protocol_ : Ljava/lang/String;
    //   1191: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   1194: astore_1
    //   1195: aload_0
    //   1196: areturn
    //   1197: new com/google/logging/type/HttpRequest$Builder
    //   1200: dup
    //   1201: aconst_null
    //   1202: invokespecial <init> : (Lcom/google/logging/type/HttpRequest$1;)V
    //   1205: areturn
    //   1206: aconst_null
    //   1207: areturn
    //   1208: getstatic com/google/logging/type/HttpRequest.DEFAULT_INSTANCE : Lcom/google/logging/type/HttpRequest;
    //   1211: areturn
    //   1212: new com/google/logging/type/HttpRequest
    //   1215: dup
    //   1216: invokespecial <init> : ()V
    //   1219: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	552	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	524	java/io/IOException
    //   129	135	520	finally
    //   276	284	552	com/google/protobuf/InvalidProtocolBufferException
    //   276	284	524	java/io/IOException
    //   276	284	520	finally
    //   287	295	552	com/google/protobuf/InvalidProtocolBufferException
    //   287	295	524	java/io/IOException
    //   287	295	520	finally
    //   298	316	552	com/google/protobuf/InvalidProtocolBufferException
    //   298	316	524	java/io/IOException
    //   298	316	520	finally
    //   321	336	552	com/google/protobuf/InvalidProtocolBufferException
    //   321	336	524	java/io/IOException
    //   321	336	520	finally
    //   340	360	552	com/google/protobuf/InvalidProtocolBufferException
    //   340	360	524	java/io/IOException
    //   340	360	520	finally
    //   363	371	552	com/google/protobuf/InvalidProtocolBufferException
    //   363	371	524	java/io/IOException
    //   363	371	520	finally
    //   374	382	552	com/google/protobuf/InvalidProtocolBufferException
    //   374	382	524	java/io/IOException
    //   374	382	520	finally
    //   385	393	552	com/google/protobuf/InvalidProtocolBufferException
    //   385	393	524	java/io/IOException
    //   385	393	520	finally
    //   396	404	552	com/google/protobuf/InvalidProtocolBufferException
    //   396	404	524	java/io/IOException
    //   396	404	520	finally
    //   407	415	552	com/google/protobuf/InvalidProtocolBufferException
    //   407	415	524	java/io/IOException
    //   407	415	520	finally
    //   418	426	552	com/google/protobuf/InvalidProtocolBufferException
    //   418	426	524	java/io/IOException
    //   418	426	520	finally
    //   429	437	552	com/google/protobuf/InvalidProtocolBufferException
    //   429	437	524	java/io/IOException
    //   429	437	520	finally
    //   440	448	552	com/google/protobuf/InvalidProtocolBufferException
    //   440	448	524	java/io/IOException
    //   440	448	520	finally
    //   451	459	552	com/google/protobuf/InvalidProtocolBufferException
    //   451	459	524	java/io/IOException
    //   451	459	520	finally
    //   462	470	552	com/google/protobuf/InvalidProtocolBufferException
    //   462	470	524	java/io/IOException
    //   462	470	520	finally
    //   473	481	552	com/google/protobuf/InvalidProtocolBufferException
    //   473	481	524	java/io/IOException
    //   473	481	520	finally
    //   484	492	552	com/google/protobuf/InvalidProtocolBufferException
    //   484	492	524	java/io/IOException
    //   484	492	520	finally
    //   495	503	552	com/google/protobuf/InvalidProtocolBufferException
    //   495	503	524	java/io/IOException
    //   495	503	520	finally
    //   525	552	520	finally
    //   553	568	520	finally
  }
  
  public long getCacheFillBytes() {
    return this.cacheFillBytes_;
  }
  
  public boolean getCacheHit() {
    return this.cacheHit_;
  }
  
  public boolean getCacheLookup() {
    return this.cacheLookup_;
  }
  
  public boolean getCacheValidatedWithOriginServer() {
    return this.cacheValidatedWithOriginServer_;
  }
  
  public Duration getLatency() {
    Duration duration1 = this.latency_;
    Duration duration2 = duration1;
    if (duration1 == null)
      duration2 = Duration.getDefaultInstance(); 
    return duration2;
  }
  
  public String getProtocol() {
    return this.protocol_;
  }
  
  public ByteString getProtocolBytes() {
    return ByteString.copyFromUtf8(this.protocol_);
  }
  
  public String getReferer() {
    return this.referer_;
  }
  
  public ByteString getRefererBytes() {
    return ByteString.copyFromUtf8(this.referer_);
  }
  
  public String getRemoteIp() {
    return this.remoteIp_;
  }
  
  public ByteString getRemoteIpBytes() {
    return ByteString.copyFromUtf8(this.remoteIp_);
  }
  
  public String getRequestMethod() {
    return this.requestMethod_;
  }
  
  public ByteString getRequestMethodBytes() {
    return ByteString.copyFromUtf8(this.requestMethod_);
  }
  
  public long getRequestSize() {
    return this.requestSize_;
  }
  
  public String getRequestUrl() {
    return this.requestUrl_;
  }
  
  public ByteString getRequestUrlBytes() {
    return ByteString.copyFromUtf8(this.requestUrl_);
  }
  
  public long getResponseSize() {
    return this.responseSize_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.requestMethod_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getRequestMethod()); 
    i = j;
    if (!this.requestUrl_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getRequestUrl()); 
    long l = this.requestSize_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(3, l); 
    int k = this.status_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(4, k); 
    l = this.responseSize_;
    k = i;
    if (l != 0L)
      k = i + CodedOutputStream.computeInt64Size(5, l); 
    j = k;
    if (!this.userAgent_.isEmpty())
      j = k + CodedOutputStream.computeStringSize(6, getUserAgent()); 
    i = j;
    if (!this.remoteIp_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(7, getRemoteIp()); 
    j = i;
    if (!this.referer_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(8, getReferer()); 
    boolean bool = this.cacheHit_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(10, bool); 
    bool = this.cacheLookup_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(11, bool); 
    l = this.cacheFillBytes_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(12, l); 
    i = j;
    if (!this.serverIp_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(13, getServerIp()); 
    j = i;
    if (this.latency_ != null)
      j = i + CodedOutputStream.computeMessageSize(14, (MessageLite)getLatency()); 
    i = j;
    if (!this.protocol_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(15, getProtocol()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getServerIp() {
    return this.serverIp_;
  }
  
  public ByteString getServerIpBytes() {
    return ByteString.copyFromUtf8(this.serverIp_);
  }
  
  public int getStatus() {
    return this.status_;
  }
  
  public String getUserAgent() {
    return this.userAgent_;
  }
  
  public ByteString getUserAgentBytes() {
    return ByteString.copyFromUtf8(this.userAgent_);
  }
  
  public boolean hasLatency() {
    boolean bool;
    if (this.latency_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.requestMethod_.isEmpty())
      paramCodedOutputStream.writeString(1, getRequestMethod()); 
    if (!this.requestUrl_.isEmpty())
      paramCodedOutputStream.writeString(2, getRequestUrl()); 
    long l = this.requestSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(3, l); 
    int i = this.status_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
    l = this.responseSize_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(5, l); 
    if (!this.userAgent_.isEmpty())
      paramCodedOutputStream.writeString(6, getUserAgent()); 
    if (!this.remoteIp_.isEmpty())
      paramCodedOutputStream.writeString(7, getRemoteIp()); 
    if (!this.referer_.isEmpty())
      paramCodedOutputStream.writeString(8, getReferer()); 
    boolean bool = this.cacheHit_;
    if (bool)
      paramCodedOutputStream.writeBool(9, bool); 
    bool = this.cacheValidatedWithOriginServer_;
    if (bool)
      paramCodedOutputStream.writeBool(10, bool); 
    bool = this.cacheLookup_;
    if (bool)
      paramCodedOutputStream.writeBool(11, bool); 
    l = this.cacheFillBytes_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(12, l); 
    if (!this.serverIp_.isEmpty())
      paramCodedOutputStream.writeString(13, getServerIp()); 
    if (this.latency_ != null)
      paramCodedOutputStream.writeMessage(14, (MessageLite)getLatency()); 
    if (!this.protocol_.isEmpty())
      paramCodedOutputStream.writeString(15, getProtocol()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
    private Builder() {
      super(HttpRequest.DEFAULT_INSTANCE);
    }
    
    public Builder clearCacheFillBytes() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheFillBytes();
      return this;
    }
    
    public Builder clearCacheHit() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheHit();
      return this;
    }
    
    public Builder clearCacheLookup() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheLookup();
      return this;
    }
    
    public Builder clearCacheValidatedWithOriginServer() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearCacheValidatedWithOriginServer();
      return this;
    }
    
    public Builder clearLatency() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearLatency();
      return this;
    }
    
    public Builder clearProtocol() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearProtocol();
      return this;
    }
    
    public Builder clearReferer() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearReferer();
      return this;
    }
    
    public Builder clearRemoteIp() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRemoteIp();
      return this;
    }
    
    public Builder clearRequestMethod() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestMethod();
      return this;
    }
    
    public Builder clearRequestSize() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestSize();
      return this;
    }
    
    public Builder clearRequestUrl() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearRequestUrl();
      return this;
    }
    
    public Builder clearResponseSize() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearResponseSize();
      return this;
    }
    
    public Builder clearServerIp() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearServerIp();
      return this;
    }
    
    public Builder clearStatus() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearStatus();
      return this;
    }
    
    public Builder clearUserAgent() {
      copyOnWrite();
      ((HttpRequest)this.instance).clearUserAgent();
      return this;
    }
    
    public long getCacheFillBytes() {
      return ((HttpRequest)this.instance).getCacheFillBytes();
    }
    
    public boolean getCacheHit() {
      return ((HttpRequest)this.instance).getCacheHit();
    }
    
    public boolean getCacheLookup() {
      return ((HttpRequest)this.instance).getCacheLookup();
    }
    
    public boolean getCacheValidatedWithOriginServer() {
      return ((HttpRequest)this.instance).getCacheValidatedWithOriginServer();
    }
    
    public Duration getLatency() {
      return ((HttpRequest)this.instance).getLatency();
    }
    
    public String getProtocol() {
      return ((HttpRequest)this.instance).getProtocol();
    }
    
    public ByteString getProtocolBytes() {
      return ((HttpRequest)this.instance).getProtocolBytes();
    }
    
    public String getReferer() {
      return ((HttpRequest)this.instance).getReferer();
    }
    
    public ByteString getRefererBytes() {
      return ((HttpRequest)this.instance).getRefererBytes();
    }
    
    public String getRemoteIp() {
      return ((HttpRequest)this.instance).getRemoteIp();
    }
    
    public ByteString getRemoteIpBytes() {
      return ((HttpRequest)this.instance).getRemoteIpBytes();
    }
    
    public String getRequestMethod() {
      return ((HttpRequest)this.instance).getRequestMethod();
    }
    
    public ByteString getRequestMethodBytes() {
      return ((HttpRequest)this.instance).getRequestMethodBytes();
    }
    
    public long getRequestSize() {
      return ((HttpRequest)this.instance).getRequestSize();
    }
    
    public String getRequestUrl() {
      return ((HttpRequest)this.instance).getRequestUrl();
    }
    
    public ByteString getRequestUrlBytes() {
      return ((HttpRequest)this.instance).getRequestUrlBytes();
    }
    
    public long getResponseSize() {
      return ((HttpRequest)this.instance).getResponseSize();
    }
    
    public String getServerIp() {
      return ((HttpRequest)this.instance).getServerIp();
    }
    
    public ByteString getServerIpBytes() {
      return ((HttpRequest)this.instance).getServerIpBytes();
    }
    
    public int getStatus() {
      return ((HttpRequest)this.instance).getStatus();
    }
    
    public String getUserAgent() {
      return ((HttpRequest)this.instance).getUserAgent();
    }
    
    public ByteString getUserAgentBytes() {
      return ((HttpRequest)this.instance).getUserAgentBytes();
    }
    
    public boolean hasLatency() {
      return ((HttpRequest)this.instance).hasLatency();
    }
    
    public Builder mergeLatency(Duration param1Duration) {
      copyOnWrite();
      ((HttpRequest)this.instance).mergeLatency(param1Duration);
      return this;
    }
    
    public Builder setCacheFillBytes(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheFillBytes(param1Long);
      return this;
    }
    
    public Builder setCacheHit(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheHit(param1Boolean);
      return this;
    }
    
    public Builder setCacheLookup(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheLookup(param1Boolean);
      return this;
    }
    
    public Builder setCacheValidatedWithOriginServer(boolean param1Boolean) {
      copyOnWrite();
      ((HttpRequest)this.instance).setCacheValidatedWithOriginServer(param1Boolean);
      return this;
    }
    
    public Builder setLatency(Duration.Builder param1Builder) {
      copyOnWrite();
      ((HttpRequest)this.instance).setLatency(param1Builder);
      return this;
    }
    
    public Builder setLatency(Duration param1Duration) {
      copyOnWrite();
      ((HttpRequest)this.instance).setLatency(param1Duration);
      return this;
    }
    
    public Builder setProtocol(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setProtocol(param1String);
      return this;
    }
    
    public Builder setProtocolBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setProtocolBytes(param1ByteString);
      return this;
    }
    
    public Builder setReferer(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setReferer(param1String);
      return this;
    }
    
    public Builder setRefererBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRefererBytes(param1ByteString);
      return this;
    }
    
    public Builder setRemoteIp(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRemoteIp(param1String);
      return this;
    }
    
    public Builder setRemoteIpBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRemoteIpBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestMethod(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestMethod(param1String);
      return this;
    }
    
    public Builder setRequestMethodBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestMethodBytes(param1ByteString);
      return this;
    }
    
    public Builder setRequestSize(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestSize(param1Long);
      return this;
    }
    
    public Builder setRequestUrl(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestUrl(param1String);
      return this;
    }
    
    public Builder setRequestUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setRequestUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponseSize(long param1Long) {
      copyOnWrite();
      ((HttpRequest)this.instance).setResponseSize(param1Long);
      return this;
    }
    
    public Builder setServerIp(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setServerIp(param1String);
      return this;
    }
    
    public Builder setServerIpBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setServerIpBytes(param1ByteString);
      return this;
    }
    
    public Builder setStatus(int param1Int) {
      copyOnWrite();
      ((HttpRequest)this.instance).setStatus(param1Int);
      return this;
    }
    
    public Builder setUserAgent(String param1String) {
      copyOnWrite();
      ((HttpRequest)this.instance).setUserAgent(param1String);
      return this;
    }
    
    public Builder setUserAgentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpRequest)this.instance).setUserAgentBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\logging\type\HttpRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */