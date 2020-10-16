package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;

public final class Operation extends GeneratedMessageLite<Operation, Operation.Builder> implements OperationOrBuilder {
  private static final Operation DEFAULT_INSTANCE = new Operation();
  
  public static final int DONE_FIELD_NUMBER = 3;
  
  public static final int ERROR_FIELD_NUMBER = 4;
  
  public static final int METADATA_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<Operation> PARSER;
  
  public static final int RESPONSE_FIELD_NUMBER = 5;
  
  private boolean done_;
  
  private Any metadata_;
  
  private String name_ = "";
  
  private int resultCase_ = 0;
  
  private Object result_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDone() {
    this.done_ = false;
  }
  
  private void clearError() {
    if (this.resultCase_ == 4) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearMetadata() {
    this.metadata_ = null;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearResponse() {
    if (this.resultCase_ == 5) {
      this.resultCase_ = 0;
      this.result_ = null;
    } 
  }
  
  private void clearResult() {
    this.resultCase_ = 0;
    this.result_ = null;
  }
  
  public static Operation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeError(Status paramStatus) {
    if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
      this.result_ = ((Status.Builder)Status.newBuilder((Status)this.result_).mergeFrom((GeneratedMessageLite)paramStatus)).buildPartial();
    } else {
      this.result_ = paramStatus;
    } 
    this.resultCase_ = 4;
  }
  
  private void mergeMetadata(Any paramAny) {
    Any any = this.metadata_;
    if (any != null && any != Any.getDefaultInstance()) {
      this.metadata_ = (Any)((Any.Builder)Any.newBuilder(this.metadata_).mergeFrom((GeneratedMessageLite)paramAny)).buildPartial();
    } else {
      this.metadata_ = paramAny;
    } 
  }
  
  private void mergeResponse(Any paramAny) {
    if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
      this.result_ = ((Any.Builder)Any.newBuilder((Any)this.result_).mergeFrom((GeneratedMessageLite)paramAny)).buildPartial();
    } else {
      this.result_ = paramAny;
    } 
    this.resultCase_ = 5;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Operation paramOperation) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramOperation);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Operation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Operation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Operation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Operation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(InputStream paramInputStream) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Operation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Operation parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Operation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Operation> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDone(boolean paramBoolean) {
    this.done_ = paramBoolean;
  }
  
  private void setError(Status.Builder paramBuilder) {
    this.result_ = paramBuilder.build();
    this.resultCase_ = 4;
  }
  
  private void setError(Status paramStatus) {
    if (paramStatus != null) {
      this.result_ = paramStatus;
      this.resultCase_ = 4;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetadata(Any.Builder paramBuilder) {
    this.metadata_ = (Any)paramBuilder.build();
  }
  
  private void setMetadata(Any paramAny) {
    if (paramAny != null) {
      this.metadata_ = paramAny;
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
  
  private void setResponse(Any.Builder paramBuilder) {
    this.result_ = paramBuilder.build();
    this.resultCase_ = 5;
  }
  
  private void setResponse(Any paramAny) {
    if (paramAny != null) {
      this.result_ = paramAny;
      this.resultCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/longrunning/Operation$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 754, 2 -> 750, 3 -> 748, 4 -> 739, 5 -> 488, 6 -> 126, 7 -> 484, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/longrunning/Operation
    //   88: monitorenter
    //   89: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/longrunning/Operation
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/longrunning/Operation
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/longrunning/Operation.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 484
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 428
    //   152: iload #4
    //   154: bipush #10
    //   156: if_icmpeq -> 417
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 352
    //   166: iload #4
    //   168: bipush #24
    //   170: if_icmpeq -> 341
    //   173: iload #4
    //   175: bipush #34
    //   177: if_icmpeq -> 270
    //   180: iload #4
    //   182: bipush #42
    //   184: if_icmpeq -> 199
    //   187: aload_2
    //   188: iload #4
    //   190: invokevirtual skipField : (I)Z
    //   193: ifne -> 136
    //   196: goto -> 428
    //   199: aload_0
    //   200: getfield resultCase_ : I
    //   203: iconst_5
    //   204: if_icmpne -> 224
    //   207: aload_0
    //   208: getfield result_ : Ljava/lang/Object;
    //   211: checkcast com/google/protobuf/Any
    //   214: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   217: checkcast com/google/protobuf/Any$Builder
    //   220: astore_1
    //   221: goto -> 226
    //   224: aconst_null
    //   225: astore_1
    //   226: aload_0
    //   227: aload_2
    //   228: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   231: aload_3
    //   232: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   235: putfield result_ : Ljava/lang/Object;
    //   238: aload_1
    //   239: ifnull -> 262
    //   242: aload_1
    //   243: aload_0
    //   244: getfield result_ : Ljava/lang/Object;
    //   247: checkcast com/google/protobuf/Any
    //   250: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   253: pop
    //   254: aload_0
    //   255: aload_1
    //   256: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   259: putfield result_ : Ljava/lang/Object;
    //   262: aload_0
    //   263: iconst_5
    //   264: putfield resultCase_ : I
    //   267: goto -> 136
    //   270: aload_0
    //   271: getfield resultCase_ : I
    //   274: iconst_4
    //   275: if_icmpne -> 295
    //   278: aload_0
    //   279: getfield result_ : Ljava/lang/Object;
    //   282: checkcast com/google/rpc/Status
    //   285: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   288: checkcast com/google/rpc/Status$Builder
    //   291: astore_1
    //   292: goto -> 297
    //   295: aconst_null
    //   296: astore_1
    //   297: aload_0
    //   298: aload_2
    //   299: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   302: aload_3
    //   303: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   306: putfield result_ : Ljava/lang/Object;
    //   309: aload_1
    //   310: ifnull -> 333
    //   313: aload_1
    //   314: aload_0
    //   315: getfield result_ : Ljava/lang/Object;
    //   318: checkcast com/google/rpc/Status
    //   321: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   324: pop
    //   325: aload_0
    //   326: aload_1
    //   327: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   330: putfield result_ : Ljava/lang/Object;
    //   333: aload_0
    //   334: iconst_4
    //   335: putfield resultCase_ : I
    //   338: goto -> 136
    //   341: aload_0
    //   342: aload_2
    //   343: invokevirtual readBool : ()Z
    //   346: putfield done_ : Z
    //   349: goto -> 136
    //   352: aload_0
    //   353: getfield metadata_ : Lcom/google/protobuf/Any;
    //   356: ifnull -> 373
    //   359: aload_0
    //   360: getfield metadata_ : Lcom/google/protobuf/Any;
    //   363: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   366: checkcast com/google/protobuf/Any$Builder
    //   369: astore_1
    //   370: goto -> 375
    //   373: aconst_null
    //   374: astore_1
    //   375: aload_0
    //   376: aload_2
    //   377: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   380: aload_3
    //   381: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   384: checkcast com/google/protobuf/Any
    //   387: putfield metadata_ : Lcom/google/protobuf/Any;
    //   390: aload_1
    //   391: ifnull -> 136
    //   394: aload_1
    //   395: aload_0
    //   396: getfield metadata_ : Lcom/google/protobuf/Any;
    //   399: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   402: pop
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   408: checkcast com/google/protobuf/Any
    //   411: putfield metadata_ : Lcom/google/protobuf/Any;
    //   414: goto -> 136
    //   417: aload_0
    //   418: aload_2
    //   419: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   422: putfield name_ : Ljava/lang/String;
    //   425: goto -> 136
    //   428: iconst_1
    //   429: istore #8
    //   431: goto -> 136
    //   434: astore_1
    //   435: goto -> 482
    //   438: astore_3
    //   439: new java/lang/RuntimeException
    //   442: astore_2
    //   443: new com/google/protobuf/InvalidProtocolBufferException
    //   446: astore_1
    //   447: aload_1
    //   448: aload_3
    //   449: invokevirtual getMessage : ()Ljava/lang/String;
    //   452: invokespecial <init> : (Ljava/lang/String;)V
    //   455: aload_2
    //   456: aload_1
    //   457: aload_0
    //   458: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   461: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   464: aload_2
    //   465: athrow
    //   466: astore_2
    //   467: new java/lang/RuntimeException
    //   470: astore_1
    //   471: aload_1
    //   472: aload_2
    //   473: aload_0
    //   474: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   477: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   480: aload_1
    //   481: athrow
    //   482: aload_1
    //   483: athrow
    //   484: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   487: areturn
    //   488: aload_2
    //   489: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   492: astore_1
    //   493: aload_3
    //   494: checkcast com/google/longrunning/Operation
    //   497: astore_2
    //   498: aload_0
    //   499: aload_1
    //   500: aload_0
    //   501: getfield name_ : Ljava/lang/String;
    //   504: invokevirtual isEmpty : ()Z
    //   507: iconst_1
    //   508: ixor
    //   509: aload_0
    //   510: getfield name_ : Ljava/lang/String;
    //   513: aload_2
    //   514: getfield name_ : Ljava/lang/String;
    //   517: invokevirtual isEmpty : ()Z
    //   520: iconst_1
    //   521: ixor
    //   522: aload_2
    //   523: getfield name_ : Ljava/lang/String;
    //   526: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   531: putfield name_ : Ljava/lang/String;
    //   534: aload_0
    //   535: aload_1
    //   536: aload_0
    //   537: getfield metadata_ : Lcom/google/protobuf/Any;
    //   540: aload_2
    //   541: getfield metadata_ : Lcom/google/protobuf/Any;
    //   544: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   549: checkcast com/google/protobuf/Any
    //   552: putfield metadata_ : Lcom/google/protobuf/Any;
    //   555: aload_0
    //   556: getfield done_ : Z
    //   559: istore #9
    //   561: aload_2
    //   562: getfield done_ : Z
    //   565: istore #10
    //   567: aload_0
    //   568: aload_1
    //   569: iload #9
    //   571: iload #9
    //   573: iload #10
    //   575: iload #10
    //   577: invokeinterface visitBoolean : (ZZZZ)Z
    //   582: putfield done_ : Z
    //   585: getstatic com/google/longrunning/Operation$1.$SwitchMap$com$google$longrunning$Operation$ResultCase : [I
    //   588: aload_2
    //   589: invokevirtual getResultCase : ()Lcom/google/longrunning/Operation$ResultCase;
    //   592: invokevirtual ordinal : ()I
    //   595: iaload
    //   596: istore #8
    //   598: iload #8
    //   600: iconst_1
    //   601: if_icmpeq -> 678
    //   604: iload #8
    //   606: iconst_2
    //   607: if_icmpeq -> 640
    //   610: iload #8
    //   612: iconst_3
    //   613: if_icmpeq -> 619
    //   616: goto -> 713
    //   619: aload_0
    //   620: getfield resultCase_ : I
    //   623: ifeq -> 629
    //   626: iconst_1
    //   627: istore #5
    //   629: aload_1
    //   630: iload #5
    //   632: invokeinterface visitOneofNotSet : (Z)V
    //   637: goto -> 713
    //   640: iload #6
    //   642: istore #5
    //   644: aload_0
    //   645: getfield resultCase_ : I
    //   648: iconst_5
    //   649: if_icmpne -> 655
    //   652: iconst_1
    //   653: istore #5
    //   655: aload_0
    //   656: aload_1
    //   657: iload #5
    //   659: aload_0
    //   660: getfield result_ : Ljava/lang/Object;
    //   663: aload_2
    //   664: getfield result_ : Ljava/lang/Object;
    //   667: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   672: putfield result_ : Ljava/lang/Object;
    //   675: goto -> 713
    //   678: iload #7
    //   680: istore #5
    //   682: aload_0
    //   683: getfield resultCase_ : I
    //   686: iconst_4
    //   687: if_icmpne -> 693
    //   690: iconst_1
    //   691: istore #5
    //   693: aload_0
    //   694: aload_1
    //   695: iload #5
    //   697: aload_0
    //   698: getfield result_ : Ljava/lang/Object;
    //   701: aload_2
    //   702: getfield result_ : Ljava/lang/Object;
    //   705: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   710: putfield result_ : Ljava/lang/Object;
    //   713: aload_1
    //   714: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   717: if_acmpne -> 737
    //   720: aload_2
    //   721: getfield resultCase_ : I
    //   724: istore #8
    //   726: iload #8
    //   728: ifeq -> 737
    //   731: aload_0
    //   732: iload #8
    //   734: putfield resultCase_ : I
    //   737: aload_0
    //   738: areturn
    //   739: new com/google/longrunning/Operation$Builder
    //   742: dup
    //   743: aconst_null
    //   744: invokespecial <init> : (Lcom/google/longrunning/Operation$1;)V
    //   747: areturn
    //   748: aconst_null
    //   749: areturn
    //   750: getstatic com/google/longrunning/Operation.DEFAULT_INSTANCE : Lcom/google/longrunning/Operation;
    //   753: areturn
    //   754: new com/google/longrunning/Operation
    //   757: dup
    //   758: invokespecial <init> : ()V
    //   761: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	466	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	438	java/io/IOException
    //   141	147	434	finally
    //   187	196	466	com/google/protobuf/InvalidProtocolBufferException
    //   187	196	438	java/io/IOException
    //   187	196	434	finally
    //   199	221	466	com/google/protobuf/InvalidProtocolBufferException
    //   199	221	438	java/io/IOException
    //   199	221	434	finally
    //   226	238	466	com/google/protobuf/InvalidProtocolBufferException
    //   226	238	438	java/io/IOException
    //   226	238	434	finally
    //   242	262	466	com/google/protobuf/InvalidProtocolBufferException
    //   242	262	438	java/io/IOException
    //   242	262	434	finally
    //   262	267	466	com/google/protobuf/InvalidProtocolBufferException
    //   262	267	438	java/io/IOException
    //   262	267	434	finally
    //   270	292	466	com/google/protobuf/InvalidProtocolBufferException
    //   270	292	438	java/io/IOException
    //   270	292	434	finally
    //   297	309	466	com/google/protobuf/InvalidProtocolBufferException
    //   297	309	438	java/io/IOException
    //   297	309	434	finally
    //   313	333	466	com/google/protobuf/InvalidProtocolBufferException
    //   313	333	438	java/io/IOException
    //   313	333	434	finally
    //   333	338	466	com/google/protobuf/InvalidProtocolBufferException
    //   333	338	438	java/io/IOException
    //   333	338	434	finally
    //   341	349	466	com/google/protobuf/InvalidProtocolBufferException
    //   341	349	438	java/io/IOException
    //   341	349	434	finally
    //   352	370	466	com/google/protobuf/InvalidProtocolBufferException
    //   352	370	438	java/io/IOException
    //   352	370	434	finally
    //   375	390	466	com/google/protobuf/InvalidProtocolBufferException
    //   375	390	438	java/io/IOException
    //   375	390	434	finally
    //   394	414	466	com/google/protobuf/InvalidProtocolBufferException
    //   394	414	438	java/io/IOException
    //   394	414	434	finally
    //   417	425	466	com/google/protobuf/InvalidProtocolBufferException
    //   417	425	438	java/io/IOException
    //   417	425	434	finally
    //   439	466	434	finally
    //   467	482	434	finally
  }
  
  public boolean getDone() {
    return this.done_;
  }
  
  public Status getError() {
    return (this.resultCase_ == 4) ? (Status)this.result_ : Status.getDefaultInstance();
  }
  
  public Any getMetadata() {
    Any any1 = this.metadata_;
    Any any2 = any1;
    if (any1 == null)
      any2 = Any.getDefaultInstance(); 
    return any2;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Any getResponse() {
    return (this.resultCase_ == 5) ? (Any)this.result_ : Any.getDefaultInstance();
  }
  
  public ResultCase getResultCase() {
    return ResultCase.forNumber(this.resultCase_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.name_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    i = j;
    if (this.metadata_ != null)
      i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    i = j;
    if (this.resultCase_ == 4)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)this.result_); 
    j = i;
    if (this.resultCase_ == 5)
      j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)this.result_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasMetadata() {
    boolean bool;
    if (this.metadata_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.metadata_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getMetadata()); 
    boolean bool = this.done_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (this.resultCase_ == 4)
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.result_); 
    if (this.resultCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.result_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
    private Builder() {
      super(Operation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDone() {
      copyOnWrite();
      ((Operation)this.instance).clearDone();
      return this;
    }
    
    public Builder clearError() {
      copyOnWrite();
      ((Operation)this.instance).clearError();
      return this;
    }
    
    public Builder clearMetadata() {
      copyOnWrite();
      ((Operation)this.instance).clearMetadata();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((Operation)this.instance).clearName();
      return this;
    }
    
    public Builder clearResponse() {
      copyOnWrite();
      ((Operation)this.instance).clearResponse();
      return this;
    }
    
    public Builder clearResult() {
      copyOnWrite();
      ((Operation)this.instance).clearResult();
      return this;
    }
    
    public boolean getDone() {
      return ((Operation)this.instance).getDone();
    }
    
    public Status getError() {
      return ((Operation)this.instance).getError();
    }
    
    public Any getMetadata() {
      return ((Operation)this.instance).getMetadata();
    }
    
    public String getName() {
      return ((Operation)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((Operation)this.instance).getNameBytes();
    }
    
    public Any getResponse() {
      return ((Operation)this.instance).getResponse();
    }
    
    public Operation.ResultCase getResultCase() {
      return ((Operation)this.instance).getResultCase();
    }
    
    public boolean hasMetadata() {
      return ((Operation)this.instance).hasMetadata();
    }
    
    public Builder mergeError(Status param1Status) {
      copyOnWrite();
      ((Operation)this.instance).mergeError(param1Status);
      return this;
    }
    
    public Builder mergeMetadata(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).mergeMetadata(param1Any);
      return this;
    }
    
    public Builder mergeResponse(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).mergeResponse(param1Any);
      return this;
    }
    
    public Builder setDone(boolean param1Boolean) {
      copyOnWrite();
      ((Operation)this.instance).setDone(param1Boolean);
      return this;
    }
    
    public Builder setError(Status.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setError(param1Builder);
      return this;
    }
    
    public Builder setError(Status param1Status) {
      copyOnWrite();
      ((Operation)this.instance).setError(param1Status);
      return this;
    }
    
    public Builder setMetadata(Any.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setMetadata(param1Builder);
      return this;
    }
    
    public Builder setMetadata(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).setMetadata(param1Any);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((Operation)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Operation)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponse(Any.Builder param1Builder) {
      copyOnWrite();
      ((Operation)this.instance).setResponse(param1Builder);
      return this;
    }
    
    public Builder setResponse(Any param1Any) {
      copyOnWrite();
      ((Operation)this.instance).setResponse(param1Any);
      return this;
    }
  }
  
  public enum ResultCase implements Internal.EnumLite {
    ERROR(4),
    RESPONSE(5),
    RESULT_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    ResultCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ResultCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 4) ? ((param1Int != 5) ? null : RESPONSE) : ERROR) : RESULT_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\longrunning\Operation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */