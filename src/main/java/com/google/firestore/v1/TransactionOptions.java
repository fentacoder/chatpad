package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

public final class TransactionOptions extends GeneratedMessageLite<TransactionOptions, TransactionOptions.Builder> implements TransactionOptionsOrBuilder {
  private static final TransactionOptions DEFAULT_INSTANCE = new TransactionOptions();
  
  private static volatile Parser<TransactionOptions> PARSER;
  
  public static final int READ_ONLY_FIELD_NUMBER = 2;
  
  public static final int READ_WRITE_FIELD_NUMBER = 3;
  
  private int modeCase_ = 0;
  
  private Object mode_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearMode() {
    this.modeCase_ = 0;
    this.mode_ = null;
  }
  
  private void clearReadOnly() {
    if (this.modeCase_ == 2) {
      this.modeCase_ = 0;
      this.mode_ = null;
    } 
  }
  
  private void clearReadWrite() {
    if (this.modeCase_ == 3) {
      this.modeCase_ = 0;
      this.mode_ = null;
    } 
  }
  
  public static TransactionOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeReadOnly(ReadOnly paramReadOnly) {
    if (this.modeCase_ == 2 && this.mode_ != ReadOnly.getDefaultInstance()) {
      this.mode_ = ((ReadOnly.Builder)ReadOnly.newBuilder((ReadOnly)this.mode_).mergeFrom(paramReadOnly)).buildPartial();
    } else {
      this.mode_ = paramReadOnly;
    } 
    this.modeCase_ = 2;
  }
  
  private void mergeReadWrite(ReadWrite paramReadWrite) {
    if (this.modeCase_ == 3 && this.mode_ != ReadWrite.getDefaultInstance()) {
      this.mode_ = ((ReadWrite.Builder)ReadWrite.newBuilder((ReadWrite)this.mode_).mergeFrom(paramReadWrite)).buildPartial();
    } else {
      this.mode_ = paramReadWrite;
    } 
    this.modeCase_ = 3;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TransactionOptions paramTransactionOptions) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTransactionOptions);
  }
  
  public static TransactionOptions parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TransactionOptions)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TransactionOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TransactionOptions)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TransactionOptions parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TransactionOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TransactionOptions parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TransactionOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TransactionOptions parseFrom(InputStream paramInputStream) throws IOException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TransactionOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TransactionOptions parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TransactionOptions parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TransactionOptions)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TransactionOptions> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setReadOnly(ReadOnly.Builder paramBuilder) {
    this.mode_ = paramBuilder.build();
    this.modeCase_ = 2;
  }
  
  private void setReadOnly(ReadOnly paramReadOnly) {
    if (paramReadOnly != null) {
      this.mode_ = paramReadOnly;
      this.modeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setReadWrite(ReadWrite.Builder paramBuilder) {
    this.mode_ = paramBuilder.build();
    this.modeCase_ = 3;
  }
  
  private void setReadWrite(ReadWrite paramReadWrite) {
    if (paramReadWrite != null) {
      this.mode_ = paramReadWrite;
      this.modeCase_ = 3;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/TransactionOptions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 559, 2 -> 555, 3 -> 553, 4 -> 544, 5 -> 380, 6 -> 126, 7 -> 376, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/TransactionOptions.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/TransactionOptions
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/TransactionOptions.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/TransactionOptions.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/TransactionOptions.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/TransactionOptions
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/TransactionOptions
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/TransactionOptions.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 376
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 320
    //   152: iload #4
    //   154: bipush #18
    //   156: if_icmpeq -> 249
    //   159: iload #4
    //   161: bipush #26
    //   163: if_icmpeq -> 178
    //   166: aload_2
    //   167: iload #4
    //   169: invokevirtual skipField : (I)Z
    //   172: ifne -> 136
    //   175: goto -> 320
    //   178: aload_0
    //   179: getfield modeCase_ : I
    //   182: iconst_3
    //   183: if_icmpne -> 203
    //   186: aload_0
    //   187: getfield mode_ : Ljava/lang/Object;
    //   190: checkcast com/google/firestore/v1/TransactionOptions$ReadWrite
    //   193: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   196: checkcast com/google/firestore/v1/TransactionOptions$ReadWrite$Builder
    //   199: astore_1
    //   200: goto -> 205
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_0
    //   206: aload_2
    //   207: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   210: aload_3
    //   211: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   214: putfield mode_ : Ljava/lang/Object;
    //   217: aload_1
    //   218: ifnull -> 241
    //   221: aload_1
    //   222: aload_0
    //   223: getfield mode_ : Ljava/lang/Object;
    //   226: checkcast com/google/firestore/v1/TransactionOptions$ReadWrite
    //   229: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   232: pop
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   238: putfield mode_ : Ljava/lang/Object;
    //   241: aload_0
    //   242: iconst_3
    //   243: putfield modeCase_ : I
    //   246: goto -> 136
    //   249: aload_0
    //   250: getfield modeCase_ : I
    //   253: iconst_2
    //   254: if_icmpne -> 274
    //   257: aload_0
    //   258: getfield mode_ : Ljava/lang/Object;
    //   261: checkcast com/google/firestore/v1/TransactionOptions$ReadOnly
    //   264: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   267: checkcast com/google/firestore/v1/TransactionOptions$ReadOnly$Builder
    //   270: astore_1
    //   271: goto -> 276
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_0
    //   277: aload_2
    //   278: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   281: aload_3
    //   282: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   285: putfield mode_ : Ljava/lang/Object;
    //   288: aload_1
    //   289: ifnull -> 312
    //   292: aload_1
    //   293: aload_0
    //   294: getfield mode_ : Ljava/lang/Object;
    //   297: checkcast com/google/firestore/v1/TransactionOptions$ReadOnly
    //   300: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   303: pop
    //   304: aload_0
    //   305: aload_1
    //   306: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   309: putfield mode_ : Ljava/lang/Object;
    //   312: aload_0
    //   313: iconst_2
    //   314: putfield modeCase_ : I
    //   317: goto -> 136
    //   320: iconst_1
    //   321: istore #8
    //   323: goto -> 136
    //   326: astore_1
    //   327: goto -> 374
    //   330: astore_2
    //   331: new java/lang/RuntimeException
    //   334: astore_3
    //   335: new com/google/protobuf/InvalidProtocolBufferException
    //   338: astore_1
    //   339: aload_1
    //   340: aload_2
    //   341: invokevirtual getMessage : ()Ljava/lang/String;
    //   344: invokespecial <init> : (Ljava/lang/String;)V
    //   347: aload_3
    //   348: aload_1
    //   349: aload_0
    //   350: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   353: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   356: aload_3
    //   357: athrow
    //   358: astore_1
    //   359: new java/lang/RuntimeException
    //   362: astore_2
    //   363: aload_2
    //   364: aload_1
    //   365: aload_0
    //   366: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   369: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   372: aload_2
    //   373: athrow
    //   374: aload_1
    //   375: athrow
    //   376: getstatic com/google/firestore/v1/TransactionOptions.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions;
    //   379: areturn
    //   380: aload_2
    //   381: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   384: astore_1
    //   385: aload_3
    //   386: checkcast com/google/firestore/v1/TransactionOptions
    //   389: astore_2
    //   390: getstatic com/google/firestore/v1/TransactionOptions$1.$SwitchMap$com$google$firestore$v1$TransactionOptions$ModeCase : [I
    //   393: aload_2
    //   394: invokevirtual getModeCase : ()Lcom/google/firestore/v1/TransactionOptions$ModeCase;
    //   397: invokevirtual ordinal : ()I
    //   400: iaload
    //   401: istore #8
    //   403: iload #8
    //   405: iconst_1
    //   406: if_icmpeq -> 483
    //   409: iload #8
    //   411: iconst_2
    //   412: if_icmpeq -> 445
    //   415: iload #8
    //   417: iconst_3
    //   418: if_icmpeq -> 424
    //   421: goto -> 518
    //   424: aload_0
    //   425: getfield modeCase_ : I
    //   428: ifeq -> 434
    //   431: iconst_1
    //   432: istore #5
    //   434: aload_1
    //   435: iload #5
    //   437: invokeinterface visitOneofNotSet : (Z)V
    //   442: goto -> 518
    //   445: iload #6
    //   447: istore #5
    //   449: aload_0
    //   450: getfield modeCase_ : I
    //   453: iconst_3
    //   454: if_icmpne -> 460
    //   457: iconst_1
    //   458: istore #5
    //   460: aload_0
    //   461: aload_1
    //   462: iload #5
    //   464: aload_0
    //   465: getfield mode_ : Ljava/lang/Object;
    //   468: aload_2
    //   469: getfield mode_ : Ljava/lang/Object;
    //   472: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   477: putfield mode_ : Ljava/lang/Object;
    //   480: goto -> 518
    //   483: iload #7
    //   485: istore #5
    //   487: aload_0
    //   488: getfield modeCase_ : I
    //   491: iconst_2
    //   492: if_icmpne -> 498
    //   495: iconst_1
    //   496: istore #5
    //   498: aload_0
    //   499: aload_1
    //   500: iload #5
    //   502: aload_0
    //   503: getfield mode_ : Ljava/lang/Object;
    //   506: aload_2
    //   507: getfield mode_ : Ljava/lang/Object;
    //   510: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: putfield mode_ : Ljava/lang/Object;
    //   518: aload_1
    //   519: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   522: if_acmpne -> 542
    //   525: aload_2
    //   526: getfield modeCase_ : I
    //   529: istore #8
    //   531: iload #8
    //   533: ifeq -> 542
    //   536: aload_0
    //   537: iload #8
    //   539: putfield modeCase_ : I
    //   542: aload_0
    //   543: areturn
    //   544: new com/google/firestore/v1/TransactionOptions$Builder
    //   547: dup
    //   548: aconst_null
    //   549: invokespecial <init> : (Lcom/google/firestore/v1/TransactionOptions$1;)V
    //   552: areturn
    //   553: aconst_null
    //   554: areturn
    //   555: getstatic com/google/firestore/v1/TransactionOptions.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions;
    //   558: areturn
    //   559: new com/google/firestore/v1/TransactionOptions
    //   562: dup
    //   563: invokespecial <init> : ()V
    //   566: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	358	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	330	java/io/IOException
    //   141	147	326	finally
    //   166	175	358	com/google/protobuf/InvalidProtocolBufferException
    //   166	175	330	java/io/IOException
    //   166	175	326	finally
    //   178	200	358	com/google/protobuf/InvalidProtocolBufferException
    //   178	200	330	java/io/IOException
    //   178	200	326	finally
    //   205	217	358	com/google/protobuf/InvalidProtocolBufferException
    //   205	217	330	java/io/IOException
    //   205	217	326	finally
    //   221	241	358	com/google/protobuf/InvalidProtocolBufferException
    //   221	241	330	java/io/IOException
    //   221	241	326	finally
    //   241	246	358	com/google/protobuf/InvalidProtocolBufferException
    //   241	246	330	java/io/IOException
    //   241	246	326	finally
    //   249	271	358	com/google/protobuf/InvalidProtocolBufferException
    //   249	271	330	java/io/IOException
    //   249	271	326	finally
    //   276	288	358	com/google/protobuf/InvalidProtocolBufferException
    //   276	288	330	java/io/IOException
    //   276	288	326	finally
    //   292	312	358	com/google/protobuf/InvalidProtocolBufferException
    //   292	312	330	java/io/IOException
    //   292	312	326	finally
    //   312	317	358	com/google/protobuf/InvalidProtocolBufferException
    //   312	317	330	java/io/IOException
    //   312	317	326	finally
    //   331	358	326	finally
    //   359	374	326	finally
  }
  
  public ModeCase getModeCase() {
    return ModeCase.forNumber(this.modeCase_);
  }
  
  public ReadOnly getReadOnly() {
    return (this.modeCase_ == 2) ? (ReadOnly)this.mode_ : ReadOnly.getDefaultInstance();
  }
  
  public ReadWrite getReadWrite() {
    return (this.modeCase_ == 3) ? (ReadWrite)this.mode_ : ReadWrite.getDefaultInstance();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.modeCase_ == 2)
      i = 0 + CodedOutputStream.computeMessageSize(2, (MessageLite)this.mode_); 
    int j = i;
    if (this.modeCase_ == 3)
      j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.mode_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.modeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.mode_); 
    if (this.modeCase_ == 3)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.mode_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
    private Builder() {
      super(TransactionOptions.DEFAULT_INSTANCE);
    }
    
    public Builder clearMode() {
      copyOnWrite();
      ((TransactionOptions)this.instance).clearMode();
      return this;
    }
    
    public Builder clearReadOnly() {
      copyOnWrite();
      ((TransactionOptions)this.instance).clearReadOnly();
      return this;
    }
    
    public Builder clearReadWrite() {
      copyOnWrite();
      ((TransactionOptions)this.instance).clearReadWrite();
      return this;
    }
    
    public TransactionOptions.ModeCase getModeCase() {
      return ((TransactionOptions)this.instance).getModeCase();
    }
    
    public TransactionOptions.ReadOnly getReadOnly() {
      return ((TransactionOptions)this.instance).getReadOnly();
    }
    
    public TransactionOptions.ReadWrite getReadWrite() {
      return ((TransactionOptions)this.instance).getReadWrite();
    }
    
    public Builder mergeReadOnly(TransactionOptions.ReadOnly param1ReadOnly) {
      copyOnWrite();
      ((TransactionOptions)this.instance).mergeReadOnly(param1ReadOnly);
      return this;
    }
    
    public Builder mergeReadWrite(TransactionOptions.ReadWrite param1ReadWrite) {
      copyOnWrite();
      ((TransactionOptions)this.instance).mergeReadWrite(param1ReadWrite);
      return this;
    }
    
    public Builder setReadOnly(TransactionOptions.ReadOnly.Builder param1Builder) {
      copyOnWrite();
      ((TransactionOptions)this.instance).setReadOnly(param1Builder);
      return this;
    }
    
    public Builder setReadOnly(TransactionOptions.ReadOnly param1ReadOnly) {
      copyOnWrite();
      ((TransactionOptions)this.instance).setReadOnly(param1ReadOnly);
      return this;
    }
    
    public Builder setReadWrite(TransactionOptions.ReadWrite.Builder param1Builder) {
      copyOnWrite();
      ((TransactionOptions)this.instance).setReadWrite(param1Builder);
      return this;
    }
    
    public Builder setReadWrite(TransactionOptions.ReadWrite param1ReadWrite) {
      copyOnWrite();
      ((TransactionOptions)this.instance).setReadWrite(param1ReadWrite);
      return this;
    }
  }
  
  public enum ModeCase implements Internal.EnumLite {
    MODE_NOT_SET,
    READ_ONLY(2),
    READ_WRITE(3);
    
    private final int value;
    
    static {
      $VALUES = new ModeCase[] { READ_ONLY, READ_WRITE, MODE_NOT_SET };
    }
    
    ModeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ModeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? ((param1Int != 3) ? null : READ_WRITE) : READ_ONLY) : MODE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static final class ReadOnly extends GeneratedMessageLite<ReadOnly, ReadOnly.Builder> implements ReadOnlyOrBuilder {
    private static final ReadOnly DEFAULT_INSTANCE = new ReadOnly();
    
    private static volatile Parser<ReadOnly> PARSER;
    
    public static final int READ_TIME_FIELD_NUMBER = 2;
    
    private int consistencySelectorCase_ = 0;
    
    private Object consistencySelector_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearConsistencySelector() {
      this.consistencySelectorCase_ = 0;
      this.consistencySelector_ = null;
    }
    
    private void clearReadTime() {
      if (this.consistencySelectorCase_ == 2) {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
      } 
    }
    
    public static ReadOnly getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeReadTime(Timestamp param1Timestamp) {
      if (this.consistencySelectorCase_ == 2 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
        this.consistencySelector_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.consistencySelector_).mergeFrom((GeneratedMessageLite)param1Timestamp)).buildPartial();
      } else {
        this.consistencySelector_ = param1Timestamp;
      } 
      this.consistencySelectorCase_ = 2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ReadOnly param1ReadOnly) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ReadOnly);
    }
    
    public static ReadOnly parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ReadOnly)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ReadOnly parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadOnly)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadOnly parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ReadOnly parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ReadOnly parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ReadOnly parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadOnly parseFrom(InputStream param1InputStream) throws IOException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ReadOnly parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadOnly parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ReadOnly parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReadOnly)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ReadOnly> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setReadTime(Timestamp.Builder param1Builder) {
      this.consistencySelector_ = param1Builder.build();
      this.consistencySelectorCase_ = 2;
    }
    
    private void setReadTime(Timestamp param1Timestamp) {
      if (param1Timestamp != null) {
        this.consistencySelector_ = param1Timestamp;
        this.consistencySelectorCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/TransactionOptions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   19: iload #4
      //   21: tableswitch default -> 68, 1 -> 433, 2 -> 429, 3 -> 427, 4 -> 418, 5 -> 298, 6 -> 122, 7 -> 294, 8 -> 76
      //   68: new java/lang/UnsupportedOperationException
      //   71: dup
      //   72: invokespecial <init> : ()V
      //   75: athrow
      //   76: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.PARSER : Lcom/google/protobuf/Parser;
      //   79: ifnonnull -> 118
      //   82: ldc com/google/firestore/v1/TransactionOptions$ReadOnly
      //   84: monitorenter
      //   85: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.PARSER : Lcom/google/protobuf/Parser;
      //   88: ifnonnull -> 106
      //   91: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   94: astore_1
      //   95: aload_1
      //   96: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadOnly;
      //   99: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   102: aload_1
      //   103: putstatic com/google/firestore/v1/TransactionOptions$ReadOnly.PARSER : Lcom/google/protobuf/Parser;
      //   106: ldc com/google/firestore/v1/TransactionOptions$ReadOnly
      //   108: monitorexit
      //   109: goto -> 118
      //   112: astore_1
      //   113: ldc com/google/firestore/v1/TransactionOptions$ReadOnly
      //   115: monitorexit
      //   116: aload_1
      //   117: athrow
      //   118: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.PARSER : Lcom/google/protobuf/Parser;
      //   121: areturn
      //   122: aload_2
      //   123: checkcast com/google/protobuf/CodedInputStream
      //   126: astore_2
      //   127: aload_3
      //   128: checkcast com/google/protobuf/ExtensionRegistryLite
      //   131: astore_3
      //   132: iload #7
      //   134: ifne -> 294
      //   137: aload_2
      //   138: invokevirtual readTag : ()I
      //   141: istore #4
      //   143: iload #4
      //   145: ifeq -> 238
      //   148: iload #4
      //   150: bipush #18
      //   152: if_icmpeq -> 167
      //   155: aload_2
      //   156: iload #4
      //   158: invokevirtual skipField : (I)Z
      //   161: ifne -> 132
      //   164: goto -> 238
      //   167: aload_0
      //   168: getfield consistencySelectorCase_ : I
      //   171: iconst_2
      //   172: if_icmpne -> 192
      //   175: aload_0
      //   176: getfield consistencySelector_ : Ljava/lang/Object;
      //   179: checkcast com/google/protobuf/Timestamp
      //   182: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   185: checkcast com/google/protobuf/Timestamp$Builder
      //   188: astore_1
      //   189: goto -> 194
      //   192: aconst_null
      //   193: astore_1
      //   194: aload_0
      //   195: aload_2
      //   196: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   199: aload_3
      //   200: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   203: putfield consistencySelector_ : Ljava/lang/Object;
      //   206: aload_1
      //   207: ifnull -> 230
      //   210: aload_1
      //   211: aload_0
      //   212: getfield consistencySelector_ : Ljava/lang/Object;
      //   215: checkcast com/google/protobuf/Timestamp
      //   218: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   221: pop
      //   222: aload_0
      //   223: aload_1
      //   224: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   227: putfield consistencySelector_ : Ljava/lang/Object;
      //   230: aload_0
      //   231: iconst_2
      //   232: putfield consistencySelectorCase_ : I
      //   235: goto -> 132
      //   238: iconst_1
      //   239: istore #7
      //   241: goto -> 132
      //   244: astore_1
      //   245: goto -> 292
      //   248: astore_3
      //   249: new java/lang/RuntimeException
      //   252: astore_2
      //   253: new com/google/protobuf/InvalidProtocolBufferException
      //   256: astore_1
      //   257: aload_1
      //   258: aload_3
      //   259: invokevirtual getMessage : ()Ljava/lang/String;
      //   262: invokespecial <init> : (Ljava/lang/String;)V
      //   265: aload_2
      //   266: aload_1
      //   267: aload_0
      //   268: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   271: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   274: aload_2
      //   275: athrow
      //   276: astore_1
      //   277: new java/lang/RuntimeException
      //   280: astore_2
      //   281: aload_2
      //   282: aload_1
      //   283: aload_0
      //   284: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   287: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   290: aload_2
      //   291: athrow
      //   292: aload_1
      //   293: athrow
      //   294: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadOnly;
      //   297: areturn
      //   298: aload_2
      //   299: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   302: astore_1
      //   303: aload_3
      //   304: checkcast com/google/firestore/v1/TransactionOptions$ReadOnly
      //   307: astore_2
      //   308: getstatic com/google/firestore/v1/TransactionOptions$1.$SwitchMap$com$google$firestore$v1$TransactionOptions$ReadOnly$ConsistencySelectorCase : [I
      //   311: aload_2
      //   312: invokevirtual getConsistencySelectorCase : ()Lcom/google/firestore/v1/TransactionOptions$ReadOnly$ConsistencySelectorCase;
      //   315: invokevirtual ordinal : ()I
      //   318: iaload
      //   319: istore #7
      //   321: iload #7
      //   323: iconst_1
      //   324: if_icmpeq -> 357
      //   327: iload #7
      //   329: iconst_2
      //   330: if_icmpeq -> 336
      //   333: goto -> 392
      //   336: aload_0
      //   337: getfield consistencySelectorCase_ : I
      //   340: ifeq -> 346
      //   343: iconst_1
      //   344: istore #5
      //   346: aload_1
      //   347: iload #5
      //   349: invokeinterface visitOneofNotSet : (Z)V
      //   354: goto -> 392
      //   357: iload #6
      //   359: istore #5
      //   361: aload_0
      //   362: getfield consistencySelectorCase_ : I
      //   365: iconst_2
      //   366: if_icmpne -> 372
      //   369: iconst_1
      //   370: istore #5
      //   372: aload_0
      //   373: aload_1
      //   374: iload #5
      //   376: aload_0
      //   377: getfield consistencySelector_ : Ljava/lang/Object;
      //   380: aload_2
      //   381: getfield consistencySelector_ : Ljava/lang/Object;
      //   384: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   389: putfield consistencySelector_ : Ljava/lang/Object;
      //   392: aload_1
      //   393: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   396: if_acmpne -> 416
      //   399: aload_2
      //   400: getfield consistencySelectorCase_ : I
      //   403: istore #7
      //   405: iload #7
      //   407: ifeq -> 416
      //   410: aload_0
      //   411: iload #7
      //   413: putfield consistencySelectorCase_ : I
      //   416: aload_0
      //   417: areturn
      //   418: new com/google/firestore/v1/TransactionOptions$ReadOnly$Builder
      //   421: dup
      //   422: aconst_null
      //   423: invokespecial <init> : (Lcom/google/firestore/v1/TransactionOptions$1;)V
      //   426: areturn
      //   427: aconst_null
      //   428: areturn
      //   429: getstatic com/google/firestore/v1/TransactionOptions$ReadOnly.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadOnly;
      //   432: areturn
      //   433: new com/google/firestore/v1/TransactionOptions$ReadOnly
      //   436: dup
      //   437: invokespecial <init> : ()V
      //   440: areturn
      // Exception table:
      //   from	to	target	type
      //   85	106	112	finally
      //   106	109	112	finally
      //   113	116	112	finally
      //   137	143	276	com/google/protobuf/InvalidProtocolBufferException
      //   137	143	248	java/io/IOException
      //   137	143	244	finally
      //   155	164	276	com/google/protobuf/InvalidProtocolBufferException
      //   155	164	248	java/io/IOException
      //   155	164	244	finally
      //   167	189	276	com/google/protobuf/InvalidProtocolBufferException
      //   167	189	248	java/io/IOException
      //   167	189	244	finally
      //   194	206	276	com/google/protobuf/InvalidProtocolBufferException
      //   194	206	248	java/io/IOException
      //   194	206	244	finally
      //   210	230	276	com/google/protobuf/InvalidProtocolBufferException
      //   210	230	248	java/io/IOException
      //   210	230	244	finally
      //   230	235	276	com/google/protobuf/InvalidProtocolBufferException
      //   230	235	248	java/io/IOException
      //   230	235	244	finally
      //   249	276	244	finally
      //   277	292	244	finally
    }
    
    public ConsistencySelectorCase getConsistencySelectorCase() {
      return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }
    
    public Timestamp getReadTime() {
      return (this.consistencySelectorCase_ == 2) ? (Timestamp)this.consistencySelector_ : Timestamp.getDefaultInstance();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.consistencySelectorCase_ == 2)
        i = 0 + CodedOutputStream.computeMessageSize(2, (MessageLite)this.consistencySelector_); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.consistencySelectorCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.consistencySelector_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ReadOnly, Builder> implements TransactionOptions.ReadOnlyOrBuilder {
      private Builder() {
        super(TransactionOptions.ReadOnly.DEFAULT_INSTANCE);
      }
      
      public Builder clearConsistencySelector() {
        copyOnWrite();
        ((TransactionOptions.ReadOnly)this.instance).clearConsistencySelector();
        return this;
      }
      
      public Builder clearReadTime() {
        copyOnWrite();
        ((TransactionOptions.ReadOnly)this.instance).clearReadTime();
        return this;
      }
      
      public TransactionOptions.ReadOnly.ConsistencySelectorCase getConsistencySelectorCase() {
        return ((TransactionOptions.ReadOnly)this.instance).getConsistencySelectorCase();
      }
      
      public Timestamp getReadTime() {
        return ((TransactionOptions.ReadOnly)this.instance).getReadTime();
      }
      
      public Builder mergeReadTime(Timestamp param2Timestamp) {
        copyOnWrite();
        ((TransactionOptions.ReadOnly)this.instance).mergeReadTime(param2Timestamp);
        return this;
      }
      
      public Builder setReadTime(Timestamp.Builder param2Builder) {
        copyOnWrite();
        ((TransactionOptions.ReadOnly)this.instance).setReadTime(param2Builder);
        return this;
      }
      
      public Builder setReadTime(Timestamp param2Timestamp) {
        copyOnWrite();
        ((TransactionOptions.ReadOnly)this.instance).setReadTime(param2Timestamp);
        return this;
      }
    }
    
    public enum ConsistencySelectorCase implements Internal.EnumLite {
      READ_TIME(2),
      CONSISTENCYSELECTOR_NOT_SET(3);
      
      private final int value;
      
      static {
      
      }
      
      ConsistencySelectorCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ConsistencySelectorCase forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 2) ? null : READ_TIME) : CONSISTENCYSELECTOR_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ReadOnly, ReadOnly.Builder> implements ReadOnlyOrBuilder {
    private Builder() {
      super(TransactionOptions.ReadOnly.DEFAULT_INSTANCE);
    }
    
    public Builder clearConsistencySelector() {
      copyOnWrite();
      ((TransactionOptions.ReadOnly)this.instance).clearConsistencySelector();
      return this;
    }
    
    public Builder clearReadTime() {
      copyOnWrite();
      ((TransactionOptions.ReadOnly)this.instance).clearReadTime();
      return this;
    }
    
    public TransactionOptions.ReadOnly.ConsistencySelectorCase getConsistencySelectorCase() {
      return ((TransactionOptions.ReadOnly)this.instance).getConsistencySelectorCase();
    }
    
    public Timestamp getReadTime() {
      return ((TransactionOptions.ReadOnly)this.instance).getReadTime();
    }
    
    public Builder mergeReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TransactionOptions.ReadOnly)this.instance).mergeReadTime(param1Timestamp);
      return this;
    }
    
    public Builder setReadTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((TransactionOptions.ReadOnly)this.instance).setReadTime(param1Builder);
      return this;
    }
    
    public Builder setReadTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TransactionOptions.ReadOnly)this.instance).setReadTime(param1Timestamp);
      return this;
    }
  }
  
  public enum ConsistencySelectorCase implements Internal.EnumLite {
    CONSISTENCYSELECTOR_NOT_SET(2),
    READ_TIME(2);
    
    private final int value;
    
    static {
      $VALUES = new ConsistencySelectorCase[] { READ_TIME, CONSISTENCYSELECTOR_NOT_SET };
    }
    
    ConsistencySelectorCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConsistencySelectorCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? null : READ_TIME) : CONSISTENCYSELECTOR_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface ReadOnlyOrBuilder extends MessageLiteOrBuilder {
    TransactionOptions.ReadOnly.ConsistencySelectorCase getConsistencySelectorCase();
    
    Timestamp getReadTime();
  }
  
  public static final class ReadWrite extends GeneratedMessageLite<ReadWrite, ReadWrite.Builder> implements ReadWriteOrBuilder {
    private static final ReadWrite DEFAULT_INSTANCE = new ReadWrite();
    
    private static volatile Parser<ReadWrite> PARSER;
    
    public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
    
    private ByteString retryTransaction_ = ByteString.EMPTY;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearRetryTransaction() {
      this.retryTransaction_ = getDefaultInstance().getRetryTransaction();
    }
    
    public static ReadWrite getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ReadWrite param1ReadWrite) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1ReadWrite);
    }
    
    public static ReadWrite parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ReadWrite)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ReadWrite parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadWrite)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadWrite parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static ReadWrite parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ReadWrite parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static ReadWrite parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadWrite parseFrom(InputStream param1InputStream) throws IOException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static ReadWrite parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReadWrite parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static ReadWrite parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReadWrite)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ReadWrite> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setRetryTransaction(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.retryTransaction_ = param1ByteString;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/TransactionOptions$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 321, 2 -> 317, 3 -> 315, 4 -> 306, 5 -> 234, 6 -> 118, 7 -> 230, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firestore/v1/TransactionOptions$ReadWrite
      //   80: monitorenter
      //   81: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadWrite;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firestore/v1/TransactionOptions$ReadWrite.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firestore/v1/TransactionOptions$ReadWrite
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firestore/v1/TransactionOptions$ReadWrite
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 230
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 174
      //   144: iload #4
      //   146: bipush #10
      //   148: if_icmpeq -> 163
      //   151: aload_1
      //   152: iload #4
      //   154: invokevirtual skipField : (I)Z
      //   157: ifne -> 128
      //   160: goto -> 174
      //   163: aload_0
      //   164: aload_1
      //   165: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
      //   168: putfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   171: goto -> 128
      //   174: iconst_1
      //   175: istore #6
      //   177: goto -> 128
      //   180: astore_1
      //   181: goto -> 228
      //   184: astore_3
      //   185: new java/lang/RuntimeException
      //   188: astore_1
      //   189: new com/google/protobuf/InvalidProtocolBufferException
      //   192: astore_2
      //   193: aload_2
      //   194: aload_3
      //   195: invokevirtual getMessage : ()Ljava/lang/String;
      //   198: invokespecial <init> : (Ljava/lang/String;)V
      //   201: aload_1
      //   202: aload_2
      //   203: aload_0
      //   204: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   207: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   210: aload_1
      //   211: athrow
      //   212: astore_2
      //   213: new java/lang/RuntimeException
      //   216: astore_1
      //   217: aload_1
      //   218: aload_2
      //   219: aload_0
      //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   226: aload_1
      //   227: athrow
      //   228: aload_1
      //   229: athrow
      //   230: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadWrite;
      //   233: areturn
      //   234: aload_2
      //   235: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   238: astore_1
      //   239: aload_3
      //   240: checkcast com/google/firestore/v1/TransactionOptions$ReadWrite
      //   243: astore_2
      //   244: aload_0
      //   245: getfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   248: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
      //   251: if_acmpeq -> 260
      //   254: iconst_1
      //   255: istore #7
      //   257: goto -> 263
      //   260: iconst_0
      //   261: istore #7
      //   263: aload_0
      //   264: getfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   267: astore_3
      //   268: aload_2
      //   269: getfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   272: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
      //   275: if_acmpeq -> 281
      //   278: iconst_1
      //   279: istore #5
      //   281: aload_0
      //   282: aload_1
      //   283: iload #7
      //   285: aload_3
      //   286: iload #5
      //   288: aload_2
      //   289: getfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   292: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
      //   297: putfield retryTransaction_ : Lcom/google/protobuf/ByteString;
      //   300: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   303: astore_1
      //   304: aload_0
      //   305: areturn
      //   306: new com/google/firestore/v1/TransactionOptions$ReadWrite$Builder
      //   309: dup
      //   310: aconst_null
      //   311: invokespecial <init> : (Lcom/google/firestore/v1/TransactionOptions$1;)V
      //   314: areturn
      //   315: aconst_null
      //   316: areturn
      //   317: getstatic com/google/firestore/v1/TransactionOptions$ReadWrite.DEFAULT_INSTANCE : Lcom/google/firestore/v1/TransactionOptions$ReadWrite;
      //   320: areturn
      //   321: new com/google/firestore/v1/TransactionOptions$ReadWrite
      //   324: dup
      //   325: invokespecial <init> : ()V
      //   328: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	212	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	184	java/io/IOException
      //   133	139	180	finally
      //   151	160	212	com/google/protobuf/InvalidProtocolBufferException
      //   151	160	184	java/io/IOException
      //   151	160	180	finally
      //   163	171	212	com/google/protobuf/InvalidProtocolBufferException
      //   163	171	184	java/io/IOException
      //   163	171	180	finally
      //   185	212	180	finally
      //   213	228	180	finally
    }
    
    public ByteString getRetryTransaction() {
      return this.retryTransaction_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.retryTransaction_.isEmpty())
        i = 0 + CodedOutputStream.computeBytesSize(1, this.retryTransaction_); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.retryTransaction_.isEmpty())
        param1CodedOutputStream.writeBytes(1, this.retryTransaction_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ReadWrite, Builder> implements TransactionOptions.ReadWriteOrBuilder {
      private Builder() {
        super(TransactionOptions.ReadWrite.DEFAULT_INSTANCE);
      }
      
      public Builder clearRetryTransaction() {
        copyOnWrite();
        ((TransactionOptions.ReadWrite)this.instance).clearRetryTransaction();
        return this;
      }
      
      public ByteString getRetryTransaction() {
        return ((TransactionOptions.ReadWrite)this.instance).getRetryTransaction();
      }
      
      public Builder setRetryTransaction(ByteString param2ByteString) {
        copyOnWrite();
        ((TransactionOptions.ReadWrite)this.instance).setRetryTransaction(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ReadWrite, ReadWrite.Builder> implements ReadWriteOrBuilder {
    private Builder() {
      super(TransactionOptions.ReadWrite.DEFAULT_INSTANCE);
    }
    
    public Builder clearRetryTransaction() {
      copyOnWrite();
      ((TransactionOptions.ReadWrite)this.instance).clearRetryTransaction();
      return this;
    }
    
    public ByteString getRetryTransaction() {
      return ((TransactionOptions.ReadWrite)this.instance).getRetryTransaction();
    }
    
    public Builder setRetryTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((TransactionOptions.ReadWrite)this.instance).setRetryTransaction(param1ByteString);
      return this;
    }
  }
  
  public static interface ReadWriteOrBuilder extends MessageLiteOrBuilder {
    ByteString getRetryTransaction();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\TransactionOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */