package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageLite<Type, Type.Builder> implements TypeOrBuilder {
  private static final Type DEFAULT_INSTANCE = new Type();
  
  public static final int FIELDS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int ONEOFS_FIELD_NUMBER = 3;
  
  public static final int OPTIONS_FIELD_NUMBER = 4;
  
  private static volatile Parser<Type> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  
  public static final int SYNTAX_FIELD_NUMBER = 6;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Field> fields_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.emptyProtobufList();
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFields(Iterable<? extends Field> paramIterable) {
    ensureFieldsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.fields_);
  }
  
  private void addAllOneofs(Iterable<String> paramIterable) {
    ensureOneofsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.oneofs_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addFields(int paramInt, Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.add(paramInt, paramBuilder.build());
  }
  
  private void addFields(int paramInt, Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.add(paramInt, paramField);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFields(Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.add(paramBuilder.build());
  }
  
  private void addFields(Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.add(paramField);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOneofs(String paramString) {
    if (paramString != null) {
      ensureOneofsIsMutable();
      this.oneofs_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOneofsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureOneofsIsMutable();
      this.oneofs_.add(paramByteString.toStringUtf8());
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
  
  private void clearFields() {
    this.fields_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOneofs() {
    this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
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
  
  private void ensureFieldsIsMutable() {
    if (!this.fields_.isModifiable())
      this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_); 
  }
  
  private void ensureOneofsIsMutable() {
    if (!this.oneofs_.isModifiable())
      this.oneofs_ = GeneratedMessageLite.mutableCopy(this.oneofs_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Type getDefaultInstance() {
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
  
  public static Builder newBuilder(Type paramType) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramType);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Type parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Type> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFields(int paramInt) {
    ensureFieldsIsMutable();
    this.fields_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setFields(int paramInt, Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.set(paramInt, paramBuilder.build());
  }
  
  private void setFields(int paramInt, Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.set(paramInt, paramField);
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
  
  private void setOneofs(int paramInt, String paramString) {
    if (paramString != null) {
      ensureOneofsIsMutable();
      this.oneofs_.set(paramInt, paramString);
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
    //   0: getstatic com/google/protobuf/Type$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 718, 2 -> 714, 3 -> 685, 4 -> 676, 5 -> 481, 6 -> 118, 7 -> 477, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Type
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Type
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Type
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 477
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 421
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 410
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 363
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 321
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 274
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 209
    //   179: iload #4
    //   181: bipush #48
    //   183: if_icmpeq -> 198
    //   186: aload_2
    //   187: iload #4
    //   189: invokevirtual skipField : (I)Z
    //   192: ifne -> 128
    //   195: goto -> 421
    //   198: aload_0
    //   199: aload_2
    //   200: invokevirtual readEnum : ()I
    //   203: putfield syntax_ : I
    //   206: goto -> 128
    //   209: aload_0
    //   210: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   213: ifnull -> 230
    //   216: aload_0
    //   217: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   220: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   223: checkcast com/google/protobuf/SourceContext$Builder
    //   226: astore_1
    //   227: goto -> 232
    //   230: aconst_null
    //   231: astore_1
    //   232: aload_0
    //   233: aload_2
    //   234: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   237: aload_3
    //   238: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   241: checkcast com/google/protobuf/SourceContext
    //   244: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   247: aload_1
    //   248: ifnull -> 128
    //   251: aload_1
    //   252: aload_0
    //   253: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   256: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   259: pop
    //   260: aload_0
    //   261: aload_1
    //   262: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   265: checkcast com/google/protobuf/SourceContext
    //   268: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   271: goto -> 128
    //   274: aload_0
    //   275: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   278: invokeinterface isModifiable : ()Z
    //   283: ifne -> 297
    //   286: aload_0
    //   287: aload_0
    //   288: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   291: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   294: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   297: aload_0
    //   298: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   301: aload_2
    //   302: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   305: aload_3
    //   306: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   309: checkcast com/google/protobuf/Option
    //   312: invokeinterface add : (Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto -> 128
    //   321: aload_2
    //   322: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   325: astore_1
    //   326: aload_0
    //   327: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   330: invokeinterface isModifiable : ()Z
    //   335: ifne -> 349
    //   338: aload_0
    //   339: aload_0
    //   340: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   343: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   346: putfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   349: aload_0
    //   350: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   353: aload_1
    //   354: invokeinterface add : (Ljava/lang/Object;)Z
    //   359: pop
    //   360: goto -> 128
    //   363: aload_0
    //   364: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   367: invokeinterface isModifiable : ()Z
    //   372: ifne -> 386
    //   375: aload_0
    //   376: aload_0
    //   377: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   380: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   383: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   386: aload_0
    //   387: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   390: aload_2
    //   391: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   394: aload_3
    //   395: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   398: checkcast com/google/protobuf/Field
    //   401: invokeinterface add : (Ljava/lang/Object;)Z
    //   406: pop
    //   407: goto -> 128
    //   410: aload_0
    //   411: aload_2
    //   412: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   415: putfield name_ : Ljava/lang/String;
    //   418: goto -> 128
    //   421: iconst_1
    //   422: istore #6
    //   424: goto -> 128
    //   427: astore_1
    //   428: goto -> 475
    //   431: astore_2
    //   432: new java/lang/RuntimeException
    //   435: astore_1
    //   436: new com/google/protobuf/InvalidProtocolBufferException
    //   439: astore_3
    //   440: aload_3
    //   441: aload_2
    //   442: invokevirtual getMessage : ()Ljava/lang/String;
    //   445: invokespecial <init> : (Ljava/lang/String;)V
    //   448: aload_1
    //   449: aload_3
    //   450: aload_0
    //   451: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   454: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   457: aload_1
    //   458: athrow
    //   459: astore_1
    //   460: new java/lang/RuntimeException
    //   463: astore_2
    //   464: aload_2
    //   465: aload_1
    //   466: aload_0
    //   467: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   470: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   473: aload_2
    //   474: athrow
    //   475: aload_1
    //   476: athrow
    //   477: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   480: areturn
    //   481: aload_2
    //   482: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   485: astore_1
    //   486: aload_3
    //   487: checkcast com/google/protobuf/Type
    //   490: astore_2
    //   491: aload_0
    //   492: aload_1
    //   493: aload_0
    //   494: getfield name_ : Ljava/lang/String;
    //   497: invokevirtual isEmpty : ()Z
    //   500: iconst_1
    //   501: ixor
    //   502: aload_0
    //   503: getfield name_ : Ljava/lang/String;
    //   506: aload_2
    //   507: getfield name_ : Ljava/lang/String;
    //   510: invokevirtual isEmpty : ()Z
    //   513: iconst_1
    //   514: ixor
    //   515: aload_2
    //   516: getfield name_ : Ljava/lang/String;
    //   519: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   524: putfield name_ : Ljava/lang/String;
    //   527: aload_0
    //   528: aload_1
    //   529: aload_0
    //   530: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   533: aload_2
    //   534: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   537: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   542: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   545: aload_0
    //   546: aload_1
    //   547: aload_0
    //   548: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   551: aload_2
    //   552: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   555: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   560: putfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   563: aload_0
    //   564: aload_1
    //   565: aload_0
    //   566: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   569: aload_2
    //   570: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   573: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   578: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   581: aload_0
    //   582: aload_1
    //   583: aload_0
    //   584: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   587: aload_2
    //   588: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   591: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   596: checkcast com/google/protobuf/SourceContext
    //   599: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   602: aload_0
    //   603: getfield syntax_ : I
    //   606: ifeq -> 615
    //   609: iconst_1
    //   610: istore #7
    //   612: goto -> 618
    //   615: iconst_0
    //   616: istore #7
    //   618: aload_0
    //   619: getfield syntax_ : I
    //   622: istore #6
    //   624: aload_2
    //   625: getfield syntax_ : I
    //   628: ifeq -> 634
    //   631: iconst_1
    //   632: istore #5
    //   634: aload_0
    //   635: aload_1
    //   636: iload #7
    //   638: iload #6
    //   640: iload #5
    //   642: aload_2
    //   643: getfield syntax_ : I
    //   646: invokeinterface visitInt : (ZIZI)I
    //   651: putfield syntax_ : I
    //   654: aload_1
    //   655: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   658: if_acmpne -> 674
    //   661: aload_0
    //   662: aload_0
    //   663: getfield bitField0_ : I
    //   666: aload_2
    //   667: getfield bitField0_ : I
    //   670: ior
    //   671: putfield bitField0_ : I
    //   674: aload_0
    //   675: areturn
    //   676: new com/google/protobuf/Type$Builder
    //   679: dup
    //   680: aconst_null
    //   681: invokespecial <init> : (Lcom/google/protobuf/Type$1;)V
    //   684: areturn
    //   685: aload_0
    //   686: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   689: invokeinterface makeImmutable : ()V
    //   694: aload_0
    //   695: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   698: invokeinterface makeImmutable : ()V
    //   703: aload_0
    //   704: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   707: invokeinterface makeImmutable : ()V
    //   712: aconst_null
    //   713: areturn
    //   714: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   717: areturn
    //   718: new com/google/protobuf/Type
    //   721: dup
    //   722: invokespecial <init> : ()V
    //   725: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	459	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	431	java/io/IOException
    //   133	139	427	finally
    //   186	195	459	com/google/protobuf/InvalidProtocolBufferException
    //   186	195	431	java/io/IOException
    //   186	195	427	finally
    //   198	206	459	com/google/protobuf/InvalidProtocolBufferException
    //   198	206	431	java/io/IOException
    //   198	206	427	finally
    //   209	227	459	com/google/protobuf/InvalidProtocolBufferException
    //   209	227	431	java/io/IOException
    //   209	227	427	finally
    //   232	247	459	com/google/protobuf/InvalidProtocolBufferException
    //   232	247	431	java/io/IOException
    //   232	247	427	finally
    //   251	271	459	com/google/protobuf/InvalidProtocolBufferException
    //   251	271	431	java/io/IOException
    //   251	271	427	finally
    //   274	297	459	com/google/protobuf/InvalidProtocolBufferException
    //   274	297	431	java/io/IOException
    //   274	297	427	finally
    //   297	318	459	com/google/protobuf/InvalidProtocolBufferException
    //   297	318	431	java/io/IOException
    //   297	318	427	finally
    //   321	349	459	com/google/protobuf/InvalidProtocolBufferException
    //   321	349	431	java/io/IOException
    //   321	349	427	finally
    //   349	360	459	com/google/protobuf/InvalidProtocolBufferException
    //   349	360	431	java/io/IOException
    //   349	360	427	finally
    //   363	386	459	com/google/protobuf/InvalidProtocolBufferException
    //   363	386	431	java/io/IOException
    //   363	386	427	finally
    //   386	407	459	com/google/protobuf/InvalidProtocolBufferException
    //   386	407	431	java/io/IOException
    //   386	407	427	finally
    //   410	418	459	com/google/protobuf/InvalidProtocolBufferException
    //   410	418	431	java/io/IOException
    //   410	418	427	finally
    //   432	459	427	finally
    //   460	475	427	finally
  }
  
  public Field getFields(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public int getFieldsCount() {
    return this.fields_.size();
  }
  
  public List<Field> getFieldsList() {
    return this.fields_;
  }
  
  public FieldOrBuilder getFieldsOrBuilder(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
    return (List)this.fields_;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getOneofs(int paramInt) {
    return this.oneofs_.get(paramInt);
  }
  
  public ByteString getOneofsBytes(int paramInt) {
    return ByteString.copyFromUtf8(this.oneofs_.get(paramInt));
  }
  
  public int getOneofsCount() {
    return this.oneofs_.size();
  }
  
  public List<String> getOneofsList() {
    return this.oneofs_;
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
    boolean bool1 = false;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j < this.fields_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, this.fields_.get(j)); 
    byte b = 0;
    j = b;
    while (b < this.oneofs_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag(this.oneofs_.get(b));
      b++;
    } 
    i = i + j + getOneofsList().size() * 1;
    for (j = bool1; j < this.options_.size(); j++)
      i += CodedOutputStream.computeMessageSize(4, this.options_.get(j)); 
    j = i;
    if (this.sourceContext_ != null)
      j = i + CodedOutputStream.computeMessageSize(5, getSourceContext()); 
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      i = j + CodedOutputStream.computeEnumSize(6, this.syntax_); 
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
    byte b2;
    for (b2 = 0; b2 < this.fields_.size(); b2++)
      paramCodedOutputStream.writeMessage(2, this.fields_.get(b2)); 
    b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.oneofs_.size()) {
        paramCodedOutputStream.writeString(3, this.oneofs_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      paramCodedOutputStream.writeMessage(4, this.options_.get(b3));
      b3++;
    } 
    if (this.sourceContext_ != null)
      paramCodedOutputStream.writeMessage(5, getSourceContext()); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(6, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
    private Builder() {
      super(Type.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFields(Iterable<? extends Field> param1Iterable) {
      copyOnWrite();
      this.instance.addAllFields(param1Iterable);
      return this;
    }
    
    public Builder addAllOneofs(Iterable<String> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOneofs(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addFields(int param1Int, Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.addFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFields(int param1Int, Field param1Field) {
      copyOnWrite();
      this.instance.addFields(param1Int, param1Field);
      return this;
    }
    
    public Builder addFields(Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.addFields(param1Builder);
      return this;
    }
    
    public Builder addFields(Field param1Field) {
      copyOnWrite();
      this.instance.addFields(param1Field);
      return this;
    }
    
    public Builder addOneofs(String param1String) {
      copyOnWrite();
      this.instance.addOneofs(param1String);
      return this;
    }
    
    public Builder addOneofsBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.addOneofsBytes(param1ByteString);
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
    
    public Builder clearFields() {
      copyOnWrite();
      this.instance.clearFields();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearOneofs() {
      copyOnWrite();
      this.instance.clearOneofs();
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
    
    public Field getFields(int param1Int) {
      return this.instance.getFields(param1Int);
    }
    
    public int getFieldsCount() {
      return this.instance.getFieldsCount();
    }
    
    public List<Field> getFieldsList() {
      return Collections.unmodifiableList(this.instance.getFieldsList());
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public String getOneofs(int param1Int) {
      return this.instance.getOneofs(param1Int);
    }
    
    public ByteString getOneofsBytes(int param1Int) {
      return this.instance.getOneofsBytes(param1Int);
    }
    
    public int getOneofsCount() {
      return this.instance.getOneofsCount();
    }
    
    public List<String> getOneofsList() {
      return Collections.unmodifiableList(this.instance.getOneofsList());
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
    
    public Builder removeFields(int param1Int) {
      copyOnWrite();
      this.instance.removeFields(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setFields(int param1Int, Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.setFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFields(int param1Int, Field param1Field) {
      copyOnWrite();
      this.instance.setFields(param1Int, param1Field);
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
    
    public Builder setOneofs(int param1Int, String param1String) {
      copyOnWrite();
      this.instance.setOneofs(param1Int, param1String);
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


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Type.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */