package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageLite<Api, Api.Builder> implements ApiOrBuilder {
  private static final Api DEFAULT_INSTANCE = new Api();
  
  public static final int METHODS_FIELD_NUMBER = 2;
  
  public static final int MIXINS_FIELD_NUMBER = 6;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Api> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  
  public static final int SYNTAX_FIELD_NUMBER = 7;
  
  public static final int VERSION_FIELD_NUMBER = 4;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Method> methods_ = emptyProtobufList();
  
  private Internal.ProtobufList<Mixin> mixins_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  private String version_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllMethods(Iterable<? extends Method> paramIterable) {
    ensureMethodsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.methods_);
  }
  
  private void addAllMixins(Iterable<? extends Mixin> paramIterable) {
    ensureMixinsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.mixins_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addMethods(int paramInt, Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.add(paramInt, paramBuilder.build());
  }
  
  private void addMethods(int paramInt, Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.add(paramInt, paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMethods(Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.add(paramBuilder.build());
  }
  
  private void addMethods(Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.add(paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMixins(int paramInt, Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.add(paramInt, paramBuilder.build());
  }
  
  private void addMixins(int paramInt, Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.add(paramInt, paramMixin);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMixins(Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.add(paramBuilder.build());
  }
  
  private void addMixins(Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.add(paramMixin);
      return;
    } 
    throw new NullPointerException();
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
  
  private void clearMethods() {
    this.methods_ = emptyProtobufList();
  }
  
  private void clearMixins() {
    this.mixins_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearSourceContext() {
    this.sourceContext_ = null;
  }
  
  private void clearSyntax() {
    this.syntax_ = 0;
  }
  
  private void clearVersion() {
    this.version_ = getDefaultInstance().getVersion();
  }
  
  private void ensureMethodsIsMutable() {
    if (!this.methods_.isModifiable())
      this.methods_ = GeneratedMessageLite.mutableCopy(this.methods_); 
  }
  
  private void ensureMixinsIsMutable() {
    if (!this.mixins_.isModifiable())
      this.mixins_ = GeneratedMessageLite.mutableCopy(this.mixins_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Api getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeSourceContext(SourceContext paramSourceContext) {
    SourceContext sourceContext = this.sourceContext_;
    if (sourceContext != null && sourceContext != SourceContext.getDefaultInstance()) {
      this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(paramSourceContext).buildPartial();
    } else {
      this.sourceContext_ = paramSourceContext;
    } 
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Api paramApi) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramApi);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Api parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Api parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Api> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeMethods(int paramInt) {
    ensureMethodsIsMutable();
    this.methods_.remove(paramInt);
  }
  
  private void removeMixins(int paramInt) {
    ensureMixinsIsMutable();
    this.mixins_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setMethods(int paramInt, Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.set(paramInt, paramBuilder.build());
  }
  
  private void setMethods(int paramInt, Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.set(paramInt, paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMixins(int paramInt, Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.set(paramInt, paramBuilder.build());
  }
  
  private void setMixins(int paramInt, Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.set(paramInt, paramMixin);
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
  
  private void setSourceContext(SourceContext.Builder paramBuilder) {
    this.sourceContext_ = paramBuilder.build();
  }
  
  private void setSourceContext(SourceContext paramSourceContext) {
    if (paramSourceContext != null) {
      this.sourceContext_ = paramSourceContext;
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
  
  private void setVersion(String paramString) {
    if (paramString != null) {
      this.version_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setVersionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.version_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Api$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 777, 2 -> 773, 3 -> 744, 4 -> 735, 5 -> 504, 6 -> 118, 7 -> 500, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Api
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Api
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Api
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 500
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 444
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 433
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 386
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 339
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 328
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 263
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 216
    //   186: iload #4
    //   188: bipush #56
    //   190: if_icmpeq -> 205
    //   193: aload_2
    //   194: iload #4
    //   196: invokevirtual skipField : (I)Z
    //   199: ifne -> 128
    //   202: goto -> 444
    //   205: aload_0
    //   206: aload_2
    //   207: invokevirtual readEnum : ()I
    //   210: putfield syntax_ : I
    //   213: goto -> 128
    //   216: aload_0
    //   217: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   220: invokeinterface isModifiable : ()Z
    //   225: ifne -> 239
    //   228: aload_0
    //   229: aload_0
    //   230: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   233: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   236: putfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   239: aload_0
    //   240: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   243: aload_2
    //   244: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   247: aload_3
    //   248: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   251: checkcast com/google/protobuf/Mixin
    //   254: invokeinterface add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: goto -> 128
    //   263: aload_0
    //   264: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   267: ifnull -> 284
    //   270: aload_0
    //   271: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   274: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   277: checkcast com/google/protobuf/SourceContext$Builder
    //   280: astore_1
    //   281: goto -> 286
    //   284: aconst_null
    //   285: astore_1
    //   286: aload_0
    //   287: aload_2
    //   288: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   291: aload_3
    //   292: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   295: checkcast com/google/protobuf/SourceContext
    //   298: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   301: aload_1
    //   302: ifnull -> 128
    //   305: aload_1
    //   306: aload_0
    //   307: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   310: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   313: pop
    //   314: aload_0
    //   315: aload_1
    //   316: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   319: checkcast com/google/protobuf/SourceContext
    //   322: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   325: goto -> 128
    //   328: aload_0
    //   329: aload_2
    //   330: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   333: putfield version_ : Ljava/lang/String;
    //   336: goto -> 128
    //   339: aload_0
    //   340: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   343: invokeinterface isModifiable : ()Z
    //   348: ifne -> 362
    //   351: aload_0
    //   352: aload_0
    //   353: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   359: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   362: aload_0
    //   363: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   366: aload_2
    //   367: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   370: aload_3
    //   371: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   374: checkcast com/google/protobuf/Option
    //   377: invokeinterface add : (Ljava/lang/Object;)Z
    //   382: pop
    //   383: goto -> 128
    //   386: aload_0
    //   387: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   390: invokeinterface isModifiable : ()Z
    //   395: ifne -> 409
    //   398: aload_0
    //   399: aload_0
    //   400: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   403: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   406: putfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   409: aload_0
    //   410: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   413: aload_2
    //   414: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   417: aload_3
    //   418: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   421: checkcast com/google/protobuf/Method
    //   424: invokeinterface add : (Ljava/lang/Object;)Z
    //   429: pop
    //   430: goto -> 128
    //   433: aload_0
    //   434: aload_2
    //   435: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   438: putfield name_ : Ljava/lang/String;
    //   441: goto -> 128
    //   444: iconst_1
    //   445: istore #6
    //   447: goto -> 128
    //   450: astore_1
    //   451: goto -> 498
    //   454: astore_2
    //   455: new java/lang/RuntimeException
    //   458: astore_3
    //   459: new com/google/protobuf/InvalidProtocolBufferException
    //   462: astore_1
    //   463: aload_1
    //   464: aload_2
    //   465: invokevirtual getMessage : ()Ljava/lang/String;
    //   468: invokespecial <init> : (Ljava/lang/String;)V
    //   471: aload_3
    //   472: aload_1
    //   473: aload_0
    //   474: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   477: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   480: aload_3
    //   481: athrow
    //   482: astore_1
    //   483: new java/lang/RuntimeException
    //   486: astore_2
    //   487: aload_2
    //   488: aload_1
    //   489: aload_0
    //   490: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   493: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   496: aload_2
    //   497: athrow
    //   498: aload_1
    //   499: athrow
    //   500: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   503: areturn
    //   504: aload_2
    //   505: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   508: astore_1
    //   509: aload_3
    //   510: checkcast com/google/protobuf/Api
    //   513: astore_2
    //   514: aload_0
    //   515: aload_1
    //   516: aload_0
    //   517: getfield name_ : Ljava/lang/String;
    //   520: invokevirtual isEmpty : ()Z
    //   523: iconst_1
    //   524: ixor
    //   525: aload_0
    //   526: getfield name_ : Ljava/lang/String;
    //   529: aload_2
    //   530: getfield name_ : Ljava/lang/String;
    //   533: invokevirtual isEmpty : ()Z
    //   536: iconst_1
    //   537: ixor
    //   538: aload_2
    //   539: getfield name_ : Ljava/lang/String;
    //   542: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   547: putfield name_ : Ljava/lang/String;
    //   550: aload_0
    //   551: aload_1
    //   552: aload_0
    //   553: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   556: aload_2
    //   557: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   560: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   565: putfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   568: aload_0
    //   569: aload_1
    //   570: aload_0
    //   571: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   574: aload_2
    //   575: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   578: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   583: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   586: aload_0
    //   587: aload_1
    //   588: aload_0
    //   589: getfield version_ : Ljava/lang/String;
    //   592: invokevirtual isEmpty : ()Z
    //   595: iconst_1
    //   596: ixor
    //   597: aload_0
    //   598: getfield version_ : Ljava/lang/String;
    //   601: aload_2
    //   602: getfield version_ : Ljava/lang/String;
    //   605: invokevirtual isEmpty : ()Z
    //   608: iconst_1
    //   609: ixor
    //   610: aload_2
    //   611: getfield version_ : Ljava/lang/String;
    //   614: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   619: putfield version_ : Ljava/lang/String;
    //   622: aload_0
    //   623: aload_1
    //   624: aload_0
    //   625: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   628: aload_2
    //   629: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   632: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   637: checkcast com/google/protobuf/SourceContext
    //   640: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   643: aload_0
    //   644: aload_1
    //   645: aload_0
    //   646: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   649: aload_2
    //   650: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   653: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   658: putfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   661: aload_0
    //   662: getfield syntax_ : I
    //   665: ifeq -> 674
    //   668: iconst_1
    //   669: istore #7
    //   671: goto -> 677
    //   674: iconst_0
    //   675: istore #7
    //   677: aload_0
    //   678: getfield syntax_ : I
    //   681: istore #6
    //   683: aload_2
    //   684: getfield syntax_ : I
    //   687: ifeq -> 693
    //   690: iconst_1
    //   691: istore #5
    //   693: aload_0
    //   694: aload_1
    //   695: iload #7
    //   697: iload #6
    //   699: iload #5
    //   701: aload_2
    //   702: getfield syntax_ : I
    //   705: invokeinterface visitInt : (ZIZI)I
    //   710: putfield syntax_ : I
    //   713: aload_1
    //   714: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   717: if_acmpne -> 733
    //   720: aload_0
    //   721: aload_0
    //   722: getfield bitField0_ : I
    //   725: aload_2
    //   726: getfield bitField0_ : I
    //   729: ior
    //   730: putfield bitField0_ : I
    //   733: aload_0
    //   734: areturn
    //   735: new com/google/protobuf/Api$Builder
    //   738: dup
    //   739: aconst_null
    //   740: invokespecial <init> : (Lcom/google/protobuf/Api$1;)V
    //   743: areturn
    //   744: aload_0
    //   745: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   748: invokeinterface makeImmutable : ()V
    //   753: aload_0
    //   754: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   757: invokeinterface makeImmutable : ()V
    //   762: aload_0
    //   763: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   766: invokeinterface makeImmutable : ()V
    //   771: aconst_null
    //   772: areturn
    //   773: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   776: areturn
    //   777: new com/google/protobuf/Api
    //   780: dup
    //   781: invokespecial <init> : ()V
    //   784: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	482	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	454	java/io/IOException
    //   133	139	450	finally
    //   193	202	482	com/google/protobuf/InvalidProtocolBufferException
    //   193	202	454	java/io/IOException
    //   193	202	450	finally
    //   205	213	482	com/google/protobuf/InvalidProtocolBufferException
    //   205	213	454	java/io/IOException
    //   205	213	450	finally
    //   216	239	482	com/google/protobuf/InvalidProtocolBufferException
    //   216	239	454	java/io/IOException
    //   216	239	450	finally
    //   239	260	482	com/google/protobuf/InvalidProtocolBufferException
    //   239	260	454	java/io/IOException
    //   239	260	450	finally
    //   263	281	482	com/google/protobuf/InvalidProtocolBufferException
    //   263	281	454	java/io/IOException
    //   263	281	450	finally
    //   286	301	482	com/google/protobuf/InvalidProtocolBufferException
    //   286	301	454	java/io/IOException
    //   286	301	450	finally
    //   305	325	482	com/google/protobuf/InvalidProtocolBufferException
    //   305	325	454	java/io/IOException
    //   305	325	450	finally
    //   328	336	482	com/google/protobuf/InvalidProtocolBufferException
    //   328	336	454	java/io/IOException
    //   328	336	450	finally
    //   339	362	482	com/google/protobuf/InvalidProtocolBufferException
    //   339	362	454	java/io/IOException
    //   339	362	450	finally
    //   362	383	482	com/google/protobuf/InvalidProtocolBufferException
    //   362	383	454	java/io/IOException
    //   362	383	450	finally
    //   386	409	482	com/google/protobuf/InvalidProtocolBufferException
    //   386	409	454	java/io/IOException
    //   386	409	450	finally
    //   409	430	482	com/google/protobuf/InvalidProtocolBufferException
    //   409	430	454	java/io/IOException
    //   409	430	450	finally
    //   433	441	482	com/google/protobuf/InvalidProtocolBufferException
    //   433	441	454	java/io/IOException
    //   433	441	450	finally
    //   455	482	450	finally
    //   483	498	450	finally
  }
  
  public Method getMethods(int paramInt) {
    return this.methods_.get(paramInt);
  }
  
  public int getMethodsCount() {
    return this.methods_.size();
  }
  
  public List<Method> getMethodsList() {
    return this.methods_;
  }
  
  public MethodOrBuilder getMethodsOrBuilder(int paramInt) {
    return this.methods_.get(paramInt);
  }
  
  public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
    return (List)this.methods_;
  }
  
  public Mixin getMixins(int paramInt) {
    return this.mixins_.get(paramInt);
  }
  
  public int getMixinsCount() {
    return this.mixins_.size();
  }
  
  public List<Mixin> getMixinsList() {
    return this.mixins_;
  }
  
  public MixinOrBuilder getMixinsOrBuilder(int paramInt) {
    return this.mixins_.get(paramInt);
  }
  
  public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
    return (List)this.mixins_;
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
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j < this.methods_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, this.methods_.get(j)); 
    for (j = 0; j < this.options_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(j)); 
    j = i;
    if (!this.version_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getVersion()); 
    byte b2 = b1;
    i = j;
    if (this.sourceContext_ != null) {
      i = j + CodedOutputStream.computeMessageSize(5, getSourceContext());
      b2 = b1;
    } 
    while (b2 < this.mixins_.size()) {
      i += CodedOutputStream.computeMessageSize(6, this.mixins_.get(b2));
      b2++;
    } 
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public SourceContext getSourceContext() {
    SourceContext sourceContext1 = this.sourceContext_;
    SourceContext sourceContext2 = sourceContext1;
    if (sourceContext1 == null)
      sourceContext2 = SourceContext.getDefaultInstance(); 
    return sourceContext2;
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
  
  public String getVersion() {
    return this.version_;
  }
  
  public ByteString getVersionBytes() {
    return ByteString.copyFromUtf8(this.version_);
  }
  
  public boolean hasSourceContext() {
    boolean bool;
    if (this.sourceContext_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    boolean bool = false;
    byte b;
    for (b = 0; b < this.methods_.size(); b++)
      paramCodedOutputStream.writeMessage(2, this.methods_.get(b)); 
    for (b = 0; b < this.options_.size(); b++)
      paramCodedOutputStream.writeMessage(3, this.options_.get(b)); 
    if (!this.version_.isEmpty())
      paramCodedOutputStream.writeString(4, getVersion()); 
    b = bool;
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.writeMessage(5, getSourceContext());
      b = bool;
    } 
    while (b < this.mixins_.size()) {
      paramCodedOutputStream.writeMessage(6, this.mixins_.get(b));
      b++;
    } 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(7, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
    private Builder() {
      super(Api.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMethods(Iterable<? extends Method> param1Iterable) {
      copyOnWrite();
      this.instance.addAllMethods(param1Iterable);
      return this;
    }
    
    public Builder addAllMixins(Iterable<? extends Mixin> param1Iterable) {
      copyOnWrite();
      this.instance.addAllMixins(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addMethods(int param1Int, Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMethods(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMethods(int param1Int, Method param1Method) {
      copyOnWrite();
      this.instance.addMethods(param1Int, param1Method);
      return this;
    }
    
    public Builder addMethods(Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMethods(param1Builder);
      return this;
    }
    
    public Builder addMethods(Method param1Method) {
      copyOnWrite();
      this.instance.addMethods(param1Method);
      return this;
    }
    
    public Builder addMixins(int param1Int, Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMixins(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMixins(int param1Int, Mixin param1Mixin) {
      copyOnWrite();
      this.instance.addMixins(param1Int, param1Mixin);
      return this;
    }
    
    public Builder addMixins(Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMixins(param1Builder);
      return this;
    }
    
    public Builder addMixins(Mixin param1Mixin) {
      copyOnWrite();
      this.instance.addMixins(param1Mixin);
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
    
    public Builder clearMethods() {
      copyOnWrite();
      this.instance.clearMethods();
      return this;
    }
    
    public Builder clearMixins() {
      copyOnWrite();
      this.instance.clearMixins();
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
    
    public Builder clearSourceContext() {
      copyOnWrite();
      this.instance.clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax() {
      copyOnWrite();
      this.instance.clearSyntax();
      return this;
    }
    
    public Builder clearVersion() {
      copyOnWrite();
      this.instance.clearVersion();
      return this;
    }
    
    public Method getMethods(int param1Int) {
      return this.instance.getMethods(param1Int);
    }
    
    public int getMethodsCount() {
      return this.instance.getMethodsCount();
    }
    
    public List<Method> getMethodsList() {
      return Collections.unmodifiableList(this.instance.getMethodsList());
    }
    
    public Mixin getMixins(int param1Int) {
      return this.instance.getMixins(param1Int);
    }
    
    public int getMixinsCount() {
      return this.instance.getMixinsCount();
    }
    
    public List<Mixin> getMixinsList() {
      return Collections.unmodifiableList(this.instance.getMixinsList());
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
    
    public SourceContext getSourceContext() {
      return this.instance.getSourceContext();
    }
    
    public Syntax getSyntax() {
      return this.instance.getSyntax();
    }
    
    public int getSyntaxValue() {
      return this.instance.getSyntaxValue();
    }
    
    public String getVersion() {
      return this.instance.getVersion();
    }
    
    public ByteString getVersionBytes() {
      return this.instance.getVersionBytes();
    }
    
    public boolean hasSourceContext() {
      return this.instance.hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.mergeSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder removeMethods(int param1Int) {
      copyOnWrite();
      this.instance.removeMethods(param1Int);
      return this;
    }
    
    public Builder removeMixins(int param1Int) {
      copyOnWrite();
      this.instance.removeMixins(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setMethods(int param1Int, Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.setMethods(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMethods(int param1Int, Method param1Method) {
      copyOnWrite();
      this.instance.setMethods(param1Int, param1Method);
      return this;
    }
    
    public Builder setMixins(int param1Int, Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.setMixins(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMixins(int param1Int, Mixin param1Mixin) {
      copyOnWrite();
      this.instance.setMixins(param1Int, param1Mixin);
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
    
    public Builder setSourceContext(SourceContext.Builder param1Builder) {
      copyOnWrite();
      this.instance.setSourceContext(param1Builder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.setSourceContext(param1SourceContext);
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
    
    public Builder setVersion(String param1String) {
      copyOnWrite();
      this.instance.setVersion(param1String);
      return this;
    }
    
    public Builder setVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setVersionBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Api.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */