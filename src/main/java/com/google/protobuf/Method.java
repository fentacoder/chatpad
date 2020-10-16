package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageLite<Method, Method.Builder> implements MethodOrBuilder {
  private static final Method DEFAULT_INSTANCE = new Method();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 6;
  
  private static volatile Parser<Method> PARSER;
  
  public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
  
  public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
  
  public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
  
  public static final int SYNTAX_FIELD_NUMBER = 7;
  
  private int bitField0_;
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private boolean requestStreaming_;
  
  private String requestTypeUrl_ = "";
  
  private boolean responseStreaming_;
  
  private String responseTypeUrl_ = "";
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearRequestStreaming() {
    this.requestStreaming_ = false;
  }
  
  private void clearRequestTypeUrl() {
    this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
  }
  
  private void clearResponseStreaming() {
    this.responseStreaming_ = false;
  }
  
  private void clearResponseTypeUrl() {
    this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
  }
  
  private void clearSyntax() {
    this.syntax_ = 0;
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Method getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Method paramMethod) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMethod);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Method parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Method> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
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
  
  private void setOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.set(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestStreaming(boolean paramBoolean) {
    this.requestStreaming_ = paramBoolean;
  }
  
  private void setRequestTypeUrl(String paramString) {
    if (paramString != null) {
      this.requestTypeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestTypeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseStreaming(boolean paramBoolean) {
    this.responseStreaming_ = paramBoolean;
  }
  
  private void setResponseTypeUrl(String paramString) {
    if (paramString != null) {
      this.responseTypeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.responseTypeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntax(Syntax paramSyntax) {
    if (paramSyntax != null) {
      this.syntax_ = paramSyntax.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntaxValue(int paramInt) {
    this.syntax_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Method$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 672, 2 -> 668, 3 -> 657, 4 -> 648, 5 -> 378, 6 -> 118, 7 -> 374, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Method
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Method
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Method
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 374
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 318
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 307
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 296
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 285
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 274
    //   172: iload #4
    //   174: bipush #40
    //   176: if_icmpeq -> 263
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 216
    //   186: iload #4
    //   188: bipush #56
    //   190: if_icmpeq -> 205
    //   193: aload_1
    //   194: iload #4
    //   196: invokevirtual skipField : (I)Z
    //   199: ifne -> 128
    //   202: goto -> 318
    //   205: aload_0
    //   206: aload_1
    //   207: invokevirtual readEnum : ()I
    //   210: putfield syntax_ : I
    //   213: goto -> 128
    //   216: aload_0
    //   217: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   220: invokeinterface isModifiable : ()Z
    //   225: ifne -> 239
    //   228: aload_0
    //   229: aload_0
    //   230: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   233: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   236: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   239: aload_0
    //   240: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   243: aload_1
    //   244: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   247: aload_2
    //   248: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   251: checkcast com/google/protobuf/Option
    //   254: invokeinterface add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: goto -> 128
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual readBool : ()Z
    //   268: putfield responseStreaming_ : Z
    //   271: goto -> 128
    //   274: aload_0
    //   275: aload_1
    //   276: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   279: putfield responseTypeUrl_ : Ljava/lang/String;
    //   282: goto -> 128
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual readBool : ()Z
    //   290: putfield requestStreaming_ : Z
    //   293: goto -> 128
    //   296: aload_0
    //   297: aload_1
    //   298: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   301: putfield requestTypeUrl_ : Ljava/lang/String;
    //   304: goto -> 128
    //   307: aload_0
    //   308: aload_1
    //   309: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   312: putfield name_ : Ljava/lang/String;
    //   315: goto -> 128
    //   318: iconst_1
    //   319: istore #6
    //   321: goto -> 128
    //   324: astore_1
    //   325: goto -> 372
    //   328: astore_2
    //   329: new java/lang/RuntimeException
    //   332: astore_1
    //   333: new com/google/protobuf/InvalidProtocolBufferException
    //   336: astore_3
    //   337: aload_3
    //   338: aload_2
    //   339: invokevirtual getMessage : ()Ljava/lang/String;
    //   342: invokespecial <init> : (Ljava/lang/String;)V
    //   345: aload_1
    //   346: aload_3
    //   347: aload_0
    //   348: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   351: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   354: aload_1
    //   355: athrow
    //   356: astore_1
    //   357: new java/lang/RuntimeException
    //   360: astore_2
    //   361: aload_2
    //   362: aload_1
    //   363: aload_0
    //   364: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   367: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   370: aload_2
    //   371: athrow
    //   372: aload_1
    //   373: athrow
    //   374: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   377: areturn
    //   378: aload_2
    //   379: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   382: astore_1
    //   383: aload_3
    //   384: checkcast com/google/protobuf/Method
    //   387: astore_2
    //   388: aload_0
    //   389: aload_1
    //   390: aload_0
    //   391: getfield name_ : Ljava/lang/String;
    //   394: invokevirtual isEmpty : ()Z
    //   397: iconst_1
    //   398: ixor
    //   399: aload_0
    //   400: getfield name_ : Ljava/lang/String;
    //   403: aload_2
    //   404: getfield name_ : Ljava/lang/String;
    //   407: invokevirtual isEmpty : ()Z
    //   410: iconst_1
    //   411: ixor
    //   412: aload_2
    //   413: getfield name_ : Ljava/lang/String;
    //   416: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   421: putfield name_ : Ljava/lang/String;
    //   424: aload_0
    //   425: aload_1
    //   426: aload_0
    //   427: getfield requestTypeUrl_ : Ljava/lang/String;
    //   430: invokevirtual isEmpty : ()Z
    //   433: iconst_1
    //   434: ixor
    //   435: aload_0
    //   436: getfield requestTypeUrl_ : Ljava/lang/String;
    //   439: aload_2
    //   440: getfield requestTypeUrl_ : Ljava/lang/String;
    //   443: invokevirtual isEmpty : ()Z
    //   446: iconst_1
    //   447: ixor
    //   448: aload_2
    //   449: getfield requestTypeUrl_ : Ljava/lang/String;
    //   452: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   457: putfield requestTypeUrl_ : Ljava/lang/String;
    //   460: aload_0
    //   461: getfield requestStreaming_ : Z
    //   464: istore #7
    //   466: aload_2
    //   467: getfield requestStreaming_ : Z
    //   470: istore #8
    //   472: aload_0
    //   473: aload_1
    //   474: iload #7
    //   476: iload #7
    //   478: iload #8
    //   480: iload #8
    //   482: invokeinterface visitBoolean : (ZZZZ)Z
    //   487: putfield requestStreaming_ : Z
    //   490: aload_0
    //   491: aload_1
    //   492: aload_0
    //   493: getfield responseTypeUrl_ : Ljava/lang/String;
    //   496: invokevirtual isEmpty : ()Z
    //   499: iconst_1
    //   500: ixor
    //   501: aload_0
    //   502: getfield responseTypeUrl_ : Ljava/lang/String;
    //   505: aload_2
    //   506: getfield responseTypeUrl_ : Ljava/lang/String;
    //   509: invokevirtual isEmpty : ()Z
    //   512: iconst_1
    //   513: ixor
    //   514: aload_2
    //   515: getfield responseTypeUrl_ : Ljava/lang/String;
    //   518: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   523: putfield responseTypeUrl_ : Ljava/lang/String;
    //   526: aload_0
    //   527: getfield responseStreaming_ : Z
    //   530: istore #7
    //   532: aload_2
    //   533: getfield responseStreaming_ : Z
    //   536: istore #8
    //   538: aload_0
    //   539: aload_1
    //   540: iload #7
    //   542: iload #7
    //   544: iload #8
    //   546: iload #8
    //   548: invokeinterface visitBoolean : (ZZZZ)Z
    //   553: putfield responseStreaming_ : Z
    //   556: aload_0
    //   557: aload_1
    //   558: aload_0
    //   559: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   562: aload_2
    //   563: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   566: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   571: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   574: aload_0
    //   575: getfield syntax_ : I
    //   578: ifeq -> 587
    //   581: iconst_1
    //   582: istore #7
    //   584: goto -> 590
    //   587: iconst_0
    //   588: istore #7
    //   590: aload_0
    //   591: getfield syntax_ : I
    //   594: istore #6
    //   596: aload_2
    //   597: getfield syntax_ : I
    //   600: ifeq -> 606
    //   603: iconst_1
    //   604: istore #5
    //   606: aload_0
    //   607: aload_1
    //   608: iload #7
    //   610: iload #6
    //   612: iload #5
    //   614: aload_2
    //   615: getfield syntax_ : I
    //   618: invokeinterface visitInt : (ZIZI)I
    //   623: putfield syntax_ : I
    //   626: aload_1
    //   627: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   630: if_acmpne -> 646
    //   633: aload_0
    //   634: aload_0
    //   635: getfield bitField0_ : I
    //   638: aload_2
    //   639: getfield bitField0_ : I
    //   642: ior
    //   643: putfield bitField0_ : I
    //   646: aload_0
    //   647: areturn
    //   648: new com/google/protobuf/Method$Builder
    //   651: dup
    //   652: aconst_null
    //   653: invokespecial <init> : (Lcom/google/protobuf/Method$1;)V
    //   656: areturn
    //   657: aload_0
    //   658: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   661: invokeinterface makeImmutable : ()V
    //   666: aconst_null
    //   667: areturn
    //   668: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   671: areturn
    //   672: new com/google/protobuf/Method
    //   675: dup
    //   676: invokespecial <init> : ()V
    //   679: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	356	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	328	java/io/IOException
    //   133	139	324	finally
    //   193	202	356	com/google/protobuf/InvalidProtocolBufferException
    //   193	202	328	java/io/IOException
    //   193	202	324	finally
    //   205	213	356	com/google/protobuf/InvalidProtocolBufferException
    //   205	213	328	java/io/IOException
    //   205	213	324	finally
    //   216	239	356	com/google/protobuf/InvalidProtocolBufferException
    //   216	239	328	java/io/IOException
    //   216	239	324	finally
    //   239	260	356	com/google/protobuf/InvalidProtocolBufferException
    //   239	260	328	java/io/IOException
    //   239	260	324	finally
    //   263	271	356	com/google/protobuf/InvalidProtocolBufferException
    //   263	271	328	java/io/IOException
    //   263	271	324	finally
    //   274	282	356	com/google/protobuf/InvalidProtocolBufferException
    //   274	282	328	java/io/IOException
    //   274	282	324	finally
    //   285	293	356	com/google/protobuf/InvalidProtocolBufferException
    //   285	293	328	java/io/IOException
    //   285	293	324	finally
    //   296	304	356	com/google/protobuf/InvalidProtocolBufferException
    //   296	304	328	java/io/IOException
    //   296	304	324	finally
    //   307	315	356	com/google/protobuf/InvalidProtocolBufferException
    //   307	315	328	java/io/IOException
    //   307	315	324	finally
    //   329	356	324	finally
    //   357	372	324	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public boolean getRequestStreaming() {
    return this.requestStreaming_;
  }
  
  public String getRequestTypeUrl() {
    return this.requestTypeUrl_;
  }
  
  public ByteString getRequestTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.requestTypeUrl_);
  }
  
  public boolean getResponseStreaming() {
    return this.responseStreaming_;
  }
  
  public String getResponseTypeUrl() {
    return this.responseTypeUrl_;
  }
  
  public ByteString getResponseTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.responseTypeUrl_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    boolean bool1 = false;
    if (!bool) {
      j = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (!this.requestTypeUrl_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getRequestTypeUrl()); 
    bool = this.requestStreaming_;
    int k = i;
    if (bool)
      k = i + CodedOutputStream.computeBoolSize(3, bool); 
    int j = k;
    if (!this.responseTypeUrl_.isEmpty())
      j = k + CodedOutputStream.computeStringSize(4, getResponseTypeUrl()); 
    bool = this.responseStreaming_;
    i = j;
    k = bool1;
    if (bool) {
      i = j + CodedOutputStream.computeBoolSize(5, bool);
      k = bool1;
    } 
    while (k < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(6, this.options_.get(k));
      k++;
    } 
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Syntax getSyntax() {
    Syntax syntax1 = Syntax.forNumber(this.syntax_);
    Syntax syntax2 = syntax1;
    if (syntax1 == null)
      syntax2 = Syntax.UNRECOGNIZED; 
    return syntax2;
  }
  
  public int getSyntaxValue() {
    return this.syntax_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (!this.requestTypeUrl_.isEmpty())
      paramCodedOutputStream.writeString(2, getRequestTypeUrl()); 
    boolean bool = this.requestStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (!this.responseTypeUrl_.isEmpty())
      paramCodedOutputStream.writeString(4, getResponseTypeUrl()); 
    bool = this.responseStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    for (byte b = 0; b < this.options_.size(); b++)
      paramCodedOutputStream.writeMessage(6, this.options_.get(b)); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(7, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
    private Builder() {
      super(Method.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Builder);
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Option);
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public Builder clearRequestStreaming() {
      copyOnWrite();
      this.instance.clearRequestStreaming();
      return this;
    }
    
    public Builder clearRequestTypeUrl() {
      copyOnWrite();
      this.instance.clearRequestTypeUrl();
      return this;
    }
    
    public Builder clearResponseStreaming() {
      copyOnWrite();
      this.instance.clearResponseStreaming();
      return this;
    }
    
    public Builder clearResponseTypeUrl() {
      copyOnWrite();
      this.instance.clearResponseTypeUrl();
      return this;
    }
    
    public Builder clearSyntax() {
      copyOnWrite();
      this.instance.clearSyntax();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public Option getOptions(int param1Int) {
      return this.instance.getOptions(param1Int);
    }
    
    public int getOptionsCount() {
      return this.instance.getOptionsCount();
    }
    
    public List<Option> getOptionsList() {
      return Collections.unmodifiableList(this.instance.getOptionsList());
    }
    
    public boolean getRequestStreaming() {
      return this.instance.getRequestStreaming();
    }
    
    public String getRequestTypeUrl() {
      return this.instance.getRequestTypeUrl();
    }
    
    public ByteString getRequestTypeUrlBytes() {
      return this.instance.getRequestTypeUrlBytes();
    }
    
    public boolean getResponseStreaming() {
      return this.instance.getResponseStreaming();
    }
    
    public String getResponseTypeUrl() {
      return this.instance.getResponseTypeUrl();
    }
    
    public ByteString getResponseTypeUrlBytes() {
      return this.instance.getResponseTypeUrlBytes();
    }
    
    public Syntax getSyntax() {
      return this.instance.getSyntax();
    }
    
    public int getSyntaxValue() {
      return this.instance.getSyntaxValue();
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder setRequestStreaming(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setRequestStreaming(param1Boolean);
      return this;
    }
    
    public Builder setRequestTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setRequestTypeUrl(param1String);
      return this;
    }
    
    public Builder setRequestTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setRequestTypeUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponseStreaming(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setResponseStreaming(param1Boolean);
      return this;
    }
    
    public Builder setResponseTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setResponseTypeUrl(param1String);
      return this;
    }
    
    public Builder setResponseTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setResponseTypeUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setSyntax(Syntax param1Syntax) {
      copyOnWrite();
      this.instance.setSyntax(param1Syntax);
      return this;
    }
    
    public Builder setSyntaxValue(int param1Int) {
      copyOnWrite();
      this.instance.setSyntaxValue(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Method.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */