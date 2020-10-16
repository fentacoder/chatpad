package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

public final class Precondition extends GeneratedMessageLite<Precondition, Precondition.Builder> implements PreconditionOrBuilder {
  private static final Precondition DEFAULT_INSTANCE = new Precondition();
  
  public static final int EXISTS_FIELD_NUMBER = 1;
  
  private static volatile Parser<Precondition> PARSER;
  
  public static final int UPDATE_TIME_FIELD_NUMBER = 2;
  
  private int conditionTypeCase_ = 0;
  
  private Object conditionType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearConditionType() {
    this.conditionTypeCase_ = 0;
    this.conditionType_ = null;
  }
  
  private void clearExists() {
    if (this.conditionTypeCase_ == 1) {
      this.conditionTypeCase_ = 0;
      this.conditionType_ = null;
    } 
  }
  
  private void clearUpdateTime() {
    if (this.conditionTypeCase_ == 2) {
      this.conditionTypeCase_ = 0;
      this.conditionType_ = null;
    } 
  }
  
  public static Precondition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeUpdateTime(Timestamp paramTimestamp) {
    if (this.conditionTypeCase_ == 2 && this.conditionType_ != Timestamp.getDefaultInstance()) {
      this.conditionType_ = ((Timestamp.Builder)Timestamp.newBuilder((Timestamp)this.conditionType_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.conditionType_ = paramTimestamp;
    } 
    this.conditionTypeCase_ = 2;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Precondition paramPrecondition) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPrecondition);
  }
  
  public static Precondition parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Precondition)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Precondition parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Precondition)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Precondition parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Precondition parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Precondition parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Precondition parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Precondition parseFrom(InputStream paramInputStream) throws IOException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Precondition parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Precondition parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Precondition parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Precondition)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Precondition> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setExists(boolean paramBoolean) {
    this.conditionTypeCase_ = 1;
    this.conditionType_ = Boolean.valueOf(paramBoolean);
  }
  
  private void setUpdateTime(Timestamp.Builder paramBuilder) {
    this.conditionType_ = paramBuilder.build();
    this.conditionTypeCase_ = 2;
  }
  
  private void setUpdateTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.conditionType_ = paramTimestamp;
      this.conditionTypeCase_ = 2;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/Precondition$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   24: tableswitch default -> 72, 1 -> 507, 2 -> 503, 3 -> 501, 4 -> 492, 5 -> 328, 6 -> 126, 7 -> 324, 8 -> 80
    //   72: new java/lang/UnsupportedOperationException
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: athrow
    //   80: getstatic com/google/firestore/v1/Precondition.PARSER : Lcom/google/protobuf/Parser;
    //   83: ifnonnull -> 122
    //   86: ldc com/google/firestore/v1/Precondition
    //   88: monitorenter
    //   89: getstatic com/google/firestore/v1/Precondition.PARSER : Lcom/google/protobuf/Parser;
    //   92: ifnonnull -> 110
    //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/google/firestore/v1/Precondition.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Precondition;
    //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   106: aload_1
    //   107: putstatic com/google/firestore/v1/Precondition.PARSER : Lcom/google/protobuf/Parser;
    //   110: ldc com/google/firestore/v1/Precondition
    //   112: monitorexit
    //   113: goto -> 122
    //   116: astore_1
    //   117: ldc com/google/firestore/v1/Precondition
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: getstatic com/google/firestore/v1/Precondition.PARSER : Lcom/google/protobuf/Parser;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast com/google/protobuf/CodedInputStream
    //   130: astore_2
    //   131: aload_3
    //   132: checkcast com/google/protobuf/ExtensionRegistryLite
    //   135: astore_3
    //   136: iload #8
    //   138: ifne -> 324
    //   141: aload_2
    //   142: invokevirtual readTag : ()I
    //   145: istore #4
    //   147: iload #4
    //   149: ifeq -> 268
    //   152: iload #4
    //   154: bipush #8
    //   156: if_icmpeq -> 249
    //   159: iload #4
    //   161: bipush #18
    //   163: if_icmpeq -> 178
    //   166: aload_2
    //   167: iload #4
    //   169: invokevirtual skipField : (I)Z
    //   172: ifne -> 136
    //   175: goto -> 268
    //   178: aload_0
    //   179: getfield conditionTypeCase_ : I
    //   182: iconst_2
    //   183: if_icmpne -> 203
    //   186: aload_0
    //   187: getfield conditionType_ : Ljava/lang/Object;
    //   190: checkcast com/google/protobuf/Timestamp
    //   193: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   196: checkcast com/google/protobuf/Timestamp$Builder
    //   199: astore_1
    //   200: goto -> 205
    //   203: aconst_null
    //   204: astore_1
    //   205: aload_0
    //   206: aload_2
    //   207: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   210: aload_3
    //   211: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   214: putfield conditionType_ : Ljava/lang/Object;
    //   217: aload_1
    //   218: ifnull -> 241
    //   221: aload_1
    //   222: aload_0
    //   223: getfield conditionType_ : Ljava/lang/Object;
    //   226: checkcast com/google/protobuf/Timestamp
    //   229: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   232: pop
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   238: putfield conditionType_ : Ljava/lang/Object;
    //   241: aload_0
    //   242: iconst_2
    //   243: putfield conditionTypeCase_ : I
    //   246: goto -> 136
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield conditionTypeCase_ : I
    //   254: aload_0
    //   255: aload_2
    //   256: invokevirtual readBool : ()Z
    //   259: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   262: putfield conditionType_ : Ljava/lang/Object;
    //   265: goto -> 136
    //   268: iconst_1
    //   269: istore #8
    //   271: goto -> 136
    //   274: astore_1
    //   275: goto -> 322
    //   278: astore_2
    //   279: new java/lang/RuntimeException
    //   282: astore_1
    //   283: new com/google/protobuf/InvalidProtocolBufferException
    //   286: astore_3
    //   287: aload_3
    //   288: aload_2
    //   289: invokevirtual getMessage : ()Ljava/lang/String;
    //   292: invokespecial <init> : (Ljava/lang/String;)V
    //   295: aload_1
    //   296: aload_3
    //   297: aload_0
    //   298: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   301: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   304: aload_1
    //   305: athrow
    //   306: astore_1
    //   307: new java/lang/RuntimeException
    //   310: astore_2
    //   311: aload_2
    //   312: aload_1
    //   313: aload_0
    //   314: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   317: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   320: aload_2
    //   321: athrow
    //   322: aload_1
    //   323: athrow
    //   324: getstatic com/google/firestore/v1/Precondition.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Precondition;
    //   327: areturn
    //   328: aload_2
    //   329: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   332: astore_1
    //   333: aload_3
    //   334: checkcast com/google/firestore/v1/Precondition
    //   337: astore_2
    //   338: getstatic com/google/firestore/v1/Precondition$1.$SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase : [I
    //   341: aload_2
    //   342: invokevirtual getConditionTypeCase : ()Lcom/google/firestore/v1/Precondition$ConditionTypeCase;
    //   345: invokevirtual ordinal : ()I
    //   348: iaload
    //   349: istore #8
    //   351: iload #8
    //   353: iconst_1
    //   354: if_icmpeq -> 431
    //   357: iload #8
    //   359: iconst_2
    //   360: if_icmpeq -> 393
    //   363: iload #8
    //   365: iconst_3
    //   366: if_icmpeq -> 372
    //   369: goto -> 466
    //   372: aload_0
    //   373: getfield conditionTypeCase_ : I
    //   376: ifeq -> 382
    //   379: iconst_1
    //   380: istore #5
    //   382: aload_1
    //   383: iload #5
    //   385: invokeinterface visitOneofNotSet : (Z)V
    //   390: goto -> 466
    //   393: iload #6
    //   395: istore #5
    //   397: aload_0
    //   398: getfield conditionTypeCase_ : I
    //   401: iconst_2
    //   402: if_icmpne -> 408
    //   405: iconst_1
    //   406: istore #5
    //   408: aload_0
    //   409: aload_1
    //   410: iload #5
    //   412: aload_0
    //   413: getfield conditionType_ : Ljava/lang/Object;
    //   416: aload_2
    //   417: getfield conditionType_ : Ljava/lang/Object;
    //   420: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: putfield conditionType_ : Ljava/lang/Object;
    //   428: goto -> 466
    //   431: iload #7
    //   433: istore #5
    //   435: aload_0
    //   436: getfield conditionTypeCase_ : I
    //   439: iconst_1
    //   440: if_icmpne -> 446
    //   443: iconst_1
    //   444: istore #5
    //   446: aload_0
    //   447: aload_1
    //   448: iload #5
    //   450: aload_0
    //   451: getfield conditionType_ : Ljava/lang/Object;
    //   454: aload_2
    //   455: getfield conditionType_ : Ljava/lang/Object;
    //   458: invokeinterface visitOneofBoolean : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   463: putfield conditionType_ : Ljava/lang/Object;
    //   466: aload_1
    //   467: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   470: if_acmpne -> 490
    //   473: aload_2
    //   474: getfield conditionTypeCase_ : I
    //   477: istore #8
    //   479: iload #8
    //   481: ifeq -> 490
    //   484: aload_0
    //   485: iload #8
    //   487: putfield conditionTypeCase_ : I
    //   490: aload_0
    //   491: areturn
    //   492: new com/google/firestore/v1/Precondition$Builder
    //   495: dup
    //   496: aconst_null
    //   497: invokespecial <init> : (Lcom/google/firestore/v1/Precondition$1;)V
    //   500: areturn
    //   501: aconst_null
    //   502: areturn
    //   503: getstatic com/google/firestore/v1/Precondition.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Precondition;
    //   506: areturn
    //   507: new com/google/firestore/v1/Precondition
    //   510: dup
    //   511: invokespecial <init> : ()V
    //   514: areturn
    // Exception table:
    //   from	to	target	type
    //   89	110	116	finally
    //   110	113	116	finally
    //   117	120	116	finally
    //   141	147	306	com/google/protobuf/InvalidProtocolBufferException
    //   141	147	278	java/io/IOException
    //   141	147	274	finally
    //   166	175	306	com/google/protobuf/InvalidProtocolBufferException
    //   166	175	278	java/io/IOException
    //   166	175	274	finally
    //   178	200	306	com/google/protobuf/InvalidProtocolBufferException
    //   178	200	278	java/io/IOException
    //   178	200	274	finally
    //   205	217	306	com/google/protobuf/InvalidProtocolBufferException
    //   205	217	278	java/io/IOException
    //   205	217	274	finally
    //   221	241	306	com/google/protobuf/InvalidProtocolBufferException
    //   221	241	278	java/io/IOException
    //   221	241	274	finally
    //   241	246	306	com/google/protobuf/InvalidProtocolBufferException
    //   241	246	278	java/io/IOException
    //   241	246	274	finally
    //   249	265	306	com/google/protobuf/InvalidProtocolBufferException
    //   249	265	278	java/io/IOException
    //   249	265	274	finally
    //   279	306	274	finally
    //   307	322	274	finally
  }
  
  public ConditionTypeCase getConditionTypeCase() {
    return ConditionTypeCase.forNumber(this.conditionTypeCase_);
  }
  
  public boolean getExists() {
    return (this.conditionTypeCase_ == 1) ? ((Boolean)this.conditionType_).booleanValue() : false;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.conditionTypeCase_ == 1)
      i = 0 + CodedOutputStream.computeBoolSize(1, ((Boolean)this.conditionType_).booleanValue()); 
    int j = i;
    if (this.conditionTypeCase_ == 2)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)this.conditionType_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Timestamp getUpdateTime() {
    return (this.conditionTypeCase_ == 2) ? (Timestamp)this.conditionType_ : Timestamp.getDefaultInstance();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.conditionTypeCase_ == 1)
      paramCodedOutputStream.writeBool(1, ((Boolean)this.conditionType_).booleanValue()); 
    if (this.conditionTypeCase_ == 2)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.conditionType_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Precondition, Builder> implements PreconditionOrBuilder {
    private Builder() {
      super(Precondition.DEFAULT_INSTANCE);
    }
    
    public Builder clearConditionType() {
      copyOnWrite();
      ((Precondition)this.instance).clearConditionType();
      return this;
    }
    
    public Builder clearExists() {
      copyOnWrite();
      ((Precondition)this.instance).clearExists();
      return this;
    }
    
    public Builder clearUpdateTime() {
      copyOnWrite();
      ((Precondition)this.instance).clearUpdateTime();
      return this;
    }
    
    public Precondition.ConditionTypeCase getConditionTypeCase() {
      return ((Precondition)this.instance).getConditionTypeCase();
    }
    
    public boolean getExists() {
      return ((Precondition)this.instance).getExists();
    }
    
    public Timestamp getUpdateTime() {
      return ((Precondition)this.instance).getUpdateTime();
    }
    
    public Builder mergeUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Precondition)this.instance).mergeUpdateTime(param1Timestamp);
      return this;
    }
    
    public Builder setExists(boolean param1Boolean) {
      copyOnWrite();
      ((Precondition)this.instance).setExists(param1Boolean);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((Precondition)this.instance).setUpdateTime(param1Builder);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((Precondition)this.instance).setUpdateTime(param1Timestamp);
      return this;
    }
  }
  
  public enum ConditionTypeCase implements Internal.EnumLite {
    CONDITIONTYPE_NOT_SET,
    EXISTS(1),
    UPDATE_TIME(2);
    
    private final int value;
    
    static {
      $VALUES = new ConditionTypeCase[] { EXISTS, UPDATE_TIME, CONDITIONTYPE_NOT_SET };
    }
    
    ConditionTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ConditionTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : UPDATE_TIME) : EXISTS) : CONDITIONTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Precondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */