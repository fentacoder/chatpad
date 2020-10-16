package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Enum extends GeneratedMessageLite<Enum, Enum.Builder> implements EnumOrBuilder {
  private static final Enum DEFAULT_INSTANCE = new Enum();
  
  public static final int ENUMVALUE_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Enum> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
  
  public static final int SYNTAX_FIELD_NUMBER = 5;
  
  private int bitField0_;
  
  private Internal.ProtobufList<EnumValue> enumvalue_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllEnumvalue(Iterable<? extends EnumValue> paramIterable) {
    ensureEnumvalueIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.enumvalue_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addEnumvalue(int paramInt, EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramInt, paramBuilder.build());
  }
  
  private void addEnumvalue(int paramInt, EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.add(paramInt, paramEnumValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addEnumvalue(EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.add(paramBuilder.build());
  }
  
  private void addEnumvalue(EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.add(paramEnumValue);
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
  
  private void clearEnumvalue() {
    this.enumvalue_ = emptyProtobufList();
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
  
  private void ensureEnumvalueIsMutable() {
    if (!this.enumvalue_.isModifiable())
      this.enumvalue_ = GeneratedMessageLite.mutableCopy(this.enumvalue_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Enum getDefaultInstance() {
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
  
  public static Builder newBuilder(Enum paramEnum) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEnum);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Enum)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Enum parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Enum parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Enum parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Enum parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Enum>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Enum> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeEnumvalue(int paramInt) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setEnumvalue(int paramInt, EnumValue.Builder paramBuilder) {
    ensureEnumvalueIsMutable();
    this.enumvalue_.set(paramInt, paramBuilder.build());
  }
  
  private void setEnumvalue(int paramInt, EnumValue paramEnumValue) {
    if (paramEnumValue != null) {
      ensureEnumvalueIsMutable();
      this.enumvalue_.set(paramInt, paramEnumValue);
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Enum$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 642, 2 -> 638, 3 -> 618, 4 -> 609, 5 -> 432, 6 -> 118, 7 -> 428, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Enum
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Enum
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Enum
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Enum.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 428
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 372
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 361
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 314
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 267
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 202
    //   172: iload #4
    //   174: bipush #40
    //   176: if_icmpeq -> 191
    //   179: aload_2
    //   180: iload #4
    //   182: invokevirtual skipField : (I)Z
    //   185: ifne -> 128
    //   188: goto -> 372
    //   191: aload_0
    //   192: aload_2
    //   193: invokevirtual readEnum : ()I
    //   196: putfield syntax_ : I
    //   199: goto -> 128
    //   202: aload_0
    //   203: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   206: ifnull -> 223
    //   209: aload_0
    //   210: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   213: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   216: checkcast com/google/protobuf/SourceContext$Builder
    //   219: astore_1
    //   220: goto -> 225
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_0
    //   226: aload_2
    //   227: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   230: aload_3
    //   231: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   234: checkcast com/google/protobuf/SourceContext
    //   237: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   240: aload_1
    //   241: ifnull -> 128
    //   244: aload_1
    //   245: aload_0
    //   246: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   249: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   252: pop
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   258: checkcast com/google/protobuf/SourceContext
    //   261: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   264: goto -> 128
    //   267: aload_0
    //   268: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   271: invokeinterface isModifiable : ()Z
    //   276: ifne -> 290
    //   279: aload_0
    //   280: aload_0
    //   281: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   284: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   287: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   290: aload_0
    //   291: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   294: aload_2
    //   295: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   298: aload_3
    //   299: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   302: checkcast com/google/protobuf/Option
    //   305: invokeinterface add : (Ljava/lang/Object;)Z
    //   310: pop
    //   311: goto -> 128
    //   314: aload_0
    //   315: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   318: invokeinterface isModifiable : ()Z
    //   323: ifne -> 337
    //   326: aload_0
    //   327: aload_0
    //   328: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   331: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   334: putfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   337: aload_0
    //   338: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   341: aload_2
    //   342: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   345: aload_3
    //   346: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   349: checkcast com/google/protobuf/EnumValue
    //   352: invokeinterface add : (Ljava/lang/Object;)Z
    //   357: pop
    //   358: goto -> 128
    //   361: aload_0
    //   362: aload_2
    //   363: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   366: putfield name_ : Ljava/lang/String;
    //   369: goto -> 128
    //   372: iconst_1
    //   373: istore #6
    //   375: goto -> 128
    //   378: astore_1
    //   379: goto -> 426
    //   382: astore_2
    //   383: new java/lang/RuntimeException
    //   386: astore_1
    //   387: new com/google/protobuf/InvalidProtocolBufferException
    //   390: astore_3
    //   391: aload_3
    //   392: aload_2
    //   393: invokevirtual getMessage : ()Ljava/lang/String;
    //   396: invokespecial <init> : (Ljava/lang/String;)V
    //   399: aload_1
    //   400: aload_3
    //   401: aload_0
    //   402: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   405: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: new java/lang/RuntimeException
    //   414: astore_2
    //   415: aload_2
    //   416: aload_1
    //   417: aload_0
    //   418: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   421: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   424: aload_2
    //   425: athrow
    //   426: aload_1
    //   427: athrow
    //   428: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   431: areturn
    //   432: aload_2
    //   433: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   436: astore_1
    //   437: aload_3
    //   438: checkcast com/google/protobuf/Enum
    //   441: astore_2
    //   442: aload_0
    //   443: aload_1
    //   444: aload_0
    //   445: getfield name_ : Ljava/lang/String;
    //   448: invokevirtual isEmpty : ()Z
    //   451: iconst_1
    //   452: ixor
    //   453: aload_0
    //   454: getfield name_ : Ljava/lang/String;
    //   457: aload_2
    //   458: getfield name_ : Ljava/lang/String;
    //   461: invokevirtual isEmpty : ()Z
    //   464: iconst_1
    //   465: ixor
    //   466: aload_2
    //   467: getfield name_ : Ljava/lang/String;
    //   470: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   475: putfield name_ : Ljava/lang/String;
    //   478: aload_0
    //   479: aload_1
    //   480: aload_0
    //   481: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   484: aload_2
    //   485: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   488: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   493: putfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   496: aload_0
    //   497: aload_1
    //   498: aload_0
    //   499: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   502: aload_2
    //   503: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   506: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   511: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   514: aload_0
    //   515: aload_1
    //   516: aload_0
    //   517: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   520: aload_2
    //   521: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   524: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   529: checkcast com/google/protobuf/SourceContext
    //   532: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   535: aload_0
    //   536: getfield syntax_ : I
    //   539: ifeq -> 548
    //   542: iconst_1
    //   543: istore #7
    //   545: goto -> 551
    //   548: iconst_0
    //   549: istore #7
    //   551: aload_0
    //   552: getfield syntax_ : I
    //   555: istore #6
    //   557: aload_2
    //   558: getfield syntax_ : I
    //   561: ifeq -> 567
    //   564: iconst_1
    //   565: istore #5
    //   567: aload_0
    //   568: aload_1
    //   569: iload #7
    //   571: iload #6
    //   573: iload #5
    //   575: aload_2
    //   576: getfield syntax_ : I
    //   579: invokeinterface visitInt : (ZIZI)I
    //   584: putfield syntax_ : I
    //   587: aload_1
    //   588: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   591: if_acmpne -> 607
    //   594: aload_0
    //   595: aload_0
    //   596: getfield bitField0_ : I
    //   599: aload_2
    //   600: getfield bitField0_ : I
    //   603: ior
    //   604: putfield bitField0_ : I
    //   607: aload_0
    //   608: areturn
    //   609: new com/google/protobuf/Enum$Builder
    //   612: dup
    //   613: aconst_null
    //   614: invokespecial <init> : (Lcom/google/protobuf/Enum$1;)V
    //   617: areturn
    //   618: aload_0
    //   619: getfield enumvalue_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   622: invokeinterface makeImmutable : ()V
    //   627: aload_0
    //   628: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   631: invokeinterface makeImmutable : ()V
    //   636: aconst_null
    //   637: areturn
    //   638: getstatic com/google/protobuf/Enum.DEFAULT_INSTANCE : Lcom/google/protobuf/Enum;
    //   641: areturn
    //   642: new com/google/protobuf/Enum
    //   645: dup
    //   646: invokespecial <init> : ()V
    //   649: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	410	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	382	java/io/IOException
    //   133	139	378	finally
    //   179	188	410	com/google/protobuf/InvalidProtocolBufferException
    //   179	188	382	java/io/IOException
    //   179	188	378	finally
    //   191	199	410	com/google/protobuf/InvalidProtocolBufferException
    //   191	199	382	java/io/IOException
    //   191	199	378	finally
    //   202	220	410	com/google/protobuf/InvalidProtocolBufferException
    //   202	220	382	java/io/IOException
    //   202	220	378	finally
    //   225	240	410	com/google/protobuf/InvalidProtocolBufferException
    //   225	240	382	java/io/IOException
    //   225	240	378	finally
    //   244	264	410	com/google/protobuf/InvalidProtocolBufferException
    //   244	264	382	java/io/IOException
    //   244	264	378	finally
    //   267	290	410	com/google/protobuf/InvalidProtocolBufferException
    //   267	290	382	java/io/IOException
    //   267	290	378	finally
    //   290	311	410	com/google/protobuf/InvalidProtocolBufferException
    //   290	311	382	java/io/IOException
    //   290	311	378	finally
    //   314	337	410	com/google/protobuf/InvalidProtocolBufferException
    //   314	337	382	java/io/IOException
    //   314	337	378	finally
    //   337	358	410	com/google/protobuf/InvalidProtocolBufferException
    //   337	358	382	java/io/IOException
    //   337	358	378	finally
    //   361	369	410	com/google/protobuf/InvalidProtocolBufferException
    //   361	369	382	java/io/IOException
    //   361	369	378	finally
    //   383	410	378	finally
    //   411	426	378	finally
  }
  
  public EnumValue getEnumvalue(int paramInt) {
    return this.enumvalue_.get(paramInt);
  }
  
  public int getEnumvalueCount() {
    return this.enumvalue_.size();
  }
  
  public List<EnumValue> getEnumvalueList() {
    return this.enumvalue_;
  }
  
  public EnumValueOrBuilder getEnumvalueOrBuilder(int paramInt) {
    return this.enumvalue_.get(paramInt);
  }
  
  public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
    return (List)this.enumvalue_;
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
    byte b3;
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
    byte b2 = 0;
    int j = i;
    while (true) {
      b3 = b1;
      i = j;
      if (b2 < this.enumvalue_.size()) {
        j += CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(b3));
      b3++;
    } 
    j = i;
    if (this.sourceContext_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, getSourceContext()); 
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      i = j + CodedOutputStream.computeEnumSize(5, this.syntax_); 
    this.memoizedSerializedSize = i;
    return i;
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
    byte b3;
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.enumvalue_.size()) {
        paramCodedOutputStream.writeMessage(2, this.enumvalue_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      paramCodedOutputStream.writeMessage(3, this.options_.get(b3));
      b3++;
    } 
    if (this.sourceContext_ != null)
      paramCodedOutputStream.writeMessage(4, getSourceContext()); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(5, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
    private Builder() {
      super(Enum.DEFAULT_INSTANCE);
    }
    
    public Builder addAllEnumvalue(Iterable<? extends EnumValue> param1Iterable) {
      copyOnWrite();
      this.instance.addAllEnumvalue(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addEnumvalue(int param1Int, EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Int, param1Builder);
      return this;
    }
    
    public Builder addEnumvalue(int param1Int, EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Int, param1EnumValue);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.addEnumvalue(param1Builder);
      return this;
    }
    
    public Builder addEnumvalue(EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.addEnumvalue(param1EnumValue);
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
    
    public Builder clearEnumvalue() {
      copyOnWrite();
      this.instance.clearEnumvalue();
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
    
    public EnumValue getEnumvalue(int param1Int) {
      return this.instance.getEnumvalue(param1Int);
    }
    
    public int getEnumvalueCount() {
      return this.instance.getEnumvalueCount();
    }
    
    public List<EnumValue> getEnumvalueList() {
      return Collections.unmodifiableList(this.instance.getEnumvalueList());
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
    
    public boolean hasSourceContext() {
      return this.instance.hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.mergeSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder removeEnumvalue(int param1Int) {
      copyOnWrite();
      this.instance.removeEnumvalue(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setEnumvalue(int param1Int, EnumValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.setEnumvalue(param1Int, param1Builder);
      return this;
    }
    
    public Builder setEnumvalue(int param1Int, EnumValue param1EnumValue) {
      copyOnWrite();
      this.instance.setEnumvalue(param1Int, param1EnumValue);
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
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Enum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */