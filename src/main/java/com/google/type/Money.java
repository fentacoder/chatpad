package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Money extends GeneratedMessageLite<Money, Money.Builder> implements MoneyOrBuilder {
  public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
  
  private static final Money DEFAULT_INSTANCE = new Money();
  
  public static final int NANOS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Money> PARSER;
  
  public static final int UNITS_FIELD_NUMBER = 2;
  
  private String currencyCode_ = "";
  
  private int nanos_;
  
  private long units_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCurrencyCode() {
    this.currencyCode_ = getDefaultInstance().getCurrencyCode();
  }
  
  private void clearNanos() {
    this.nanos_ = 0;
  }
  
  private void clearUnits() {
    this.units_ = 0L;
  }
  
  public static Money getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Money paramMoney) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMoney);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Money)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Money parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(InputStream paramInputStream) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Money parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Money> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCurrencyCode(String paramString) {
    if (paramString != null) {
      this.currencyCode_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCurrencyCodeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.currencyCode_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNanos(int paramInt) {
    this.nanos_ = paramInt;
  }
  
  private void setUnits(long paramLong) {
    this.units_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Money$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 455, 2 -> 451, 3 -> 449, 4 -> 440, 5 -> 270, 6 -> 118, 7 -> 266, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Money
    //   80: monitorenter
    //   81: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Money
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Money
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Money.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 266
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 210
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 199
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 188
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 177
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: goto -> 210
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual readInt32 : ()I
    //   182: putfield nanos_ : I
    //   185: goto -> 128
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual readInt64 : ()J
    //   193: putfield units_ : J
    //   196: goto -> 128
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   204: putfield currencyCode_ : Ljava/lang/String;
    //   207: goto -> 128
    //   210: iconst_1
    //   211: istore #6
    //   213: goto -> 128
    //   216: astore_1
    //   217: goto -> 264
    //   220: astore_2
    //   221: new java/lang/RuntimeException
    //   224: astore_3
    //   225: new com/google/protobuf/InvalidProtocolBufferException
    //   228: astore_1
    //   229: aload_1
    //   230: aload_2
    //   231: invokevirtual getMessage : ()Ljava/lang/String;
    //   234: invokespecial <init> : (Ljava/lang/String;)V
    //   237: aload_3
    //   238: aload_1
    //   239: aload_0
    //   240: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   243: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   246: aload_3
    //   247: athrow
    //   248: astore_2
    //   249: new java/lang/RuntimeException
    //   252: astore_1
    //   253: aload_1
    //   254: aload_2
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_1
    //   263: athrow
    //   264: aload_1
    //   265: athrow
    //   266: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   269: areturn
    //   270: aload_2
    //   271: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   274: astore_1
    //   275: aload_3
    //   276: checkcast com/google/type/Money
    //   279: astore_2
    //   280: aload_0
    //   281: aload_1
    //   282: aload_0
    //   283: getfield currencyCode_ : Ljava/lang/String;
    //   286: invokevirtual isEmpty : ()Z
    //   289: iconst_1
    //   290: ixor
    //   291: aload_0
    //   292: getfield currencyCode_ : Ljava/lang/String;
    //   295: aload_2
    //   296: getfield currencyCode_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_2
    //   305: getfield currencyCode_ : Ljava/lang/String;
    //   308: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   313: putfield currencyCode_ : Ljava/lang/String;
    //   316: aload_0
    //   317: getfield units_ : J
    //   320: lconst_0
    //   321: lcmp
    //   322: ifeq -> 331
    //   325: iconst_1
    //   326: istore #7
    //   328: goto -> 334
    //   331: iconst_0
    //   332: istore #7
    //   334: aload_0
    //   335: getfield units_ : J
    //   338: lstore #8
    //   340: aload_2
    //   341: getfield units_ : J
    //   344: lconst_0
    //   345: lcmp
    //   346: ifeq -> 355
    //   349: iconst_1
    //   350: istore #10
    //   352: goto -> 358
    //   355: iconst_0
    //   356: istore #10
    //   358: aload_0
    //   359: aload_1
    //   360: iload #7
    //   362: lload #8
    //   364: iload #10
    //   366: aload_2
    //   367: getfield units_ : J
    //   370: invokeinterface visitLong : (ZJZJ)J
    //   375: putfield units_ : J
    //   378: aload_0
    //   379: getfield nanos_ : I
    //   382: ifeq -> 391
    //   385: iconst_1
    //   386: istore #7
    //   388: goto -> 394
    //   391: iconst_0
    //   392: istore #7
    //   394: aload_0
    //   395: getfield nanos_ : I
    //   398: istore #6
    //   400: iload #5
    //   402: istore #10
    //   404: aload_2
    //   405: getfield nanos_ : I
    //   408: ifeq -> 414
    //   411: iconst_1
    //   412: istore #10
    //   414: aload_0
    //   415: aload_1
    //   416: iload #7
    //   418: iload #6
    //   420: iload #10
    //   422: aload_2
    //   423: getfield nanos_ : I
    //   426: invokeinterface visitInt : (ZIZI)I
    //   431: putfield nanos_ : I
    //   434: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   437: astore_1
    //   438: aload_0
    //   439: areturn
    //   440: new com/google/type/Money$Builder
    //   443: dup
    //   444: aconst_null
    //   445: invokespecial <init> : (Lcom/google/type/Money$1;)V
    //   448: areturn
    //   449: aconst_null
    //   450: areturn
    //   451: getstatic com/google/type/Money.DEFAULT_INSTANCE : Lcom/google/type/Money;
    //   454: areturn
    //   455: new com/google/type/Money
    //   458: dup
    //   459: invokespecial <init> : ()V
    //   462: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	248	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	220	java/io/IOException
    //   133	139	216	finally
    //   165	174	248	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	220	java/io/IOException
    //   165	174	216	finally
    //   177	185	248	com/google/protobuf/InvalidProtocolBufferException
    //   177	185	220	java/io/IOException
    //   177	185	216	finally
    //   188	196	248	com/google/protobuf/InvalidProtocolBufferException
    //   188	196	220	java/io/IOException
    //   188	196	216	finally
    //   199	207	248	com/google/protobuf/InvalidProtocolBufferException
    //   199	207	220	java/io/IOException
    //   199	207	216	finally
    //   221	248	216	finally
    //   249	264	216	finally
  }
  
  public String getCurrencyCode() {
    return this.currencyCode_;
  }
  
  public ByteString getCurrencyCodeBytes() {
    return ByteString.copyFromUtf8(this.currencyCode_);
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.currencyCode_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getCurrencyCode()); 
    long l = this.units_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(2, l); 
    int k = this.nanos_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public long getUnits() {
    return this.units_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.currencyCode_.isEmpty())
      paramCodedOutputStream.writeString(1, getCurrencyCode()); 
    long l = this.units_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
    int i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Money, Builder> implements MoneyOrBuilder {
    private Builder() {
      super(Money.DEFAULT_INSTANCE);
    }
    
    public Builder clearCurrencyCode() {
      copyOnWrite();
      ((Money)this.instance).clearCurrencyCode();
      return this;
    }
    
    public Builder clearNanos() {
      copyOnWrite();
      ((Money)this.instance).clearNanos();
      return this;
    }
    
    public Builder clearUnits() {
      copyOnWrite();
      ((Money)this.instance).clearUnits();
      return this;
    }
    
    public String getCurrencyCode() {
      return ((Money)this.instance).getCurrencyCode();
    }
    
    public ByteString getCurrencyCodeBytes() {
      return ((Money)this.instance).getCurrencyCodeBytes();
    }
    
    public int getNanos() {
      return ((Money)this.instance).getNanos();
    }
    
    public long getUnits() {
      return ((Money)this.instance).getUnits();
    }
    
    public Builder setCurrencyCode(String param1String) {
      copyOnWrite();
      ((Money)this.instance).setCurrencyCode(param1String);
      return this;
    }
    
    public Builder setCurrencyCodeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Money)this.instance).setCurrencyCodeBytes(param1ByteString);
      return this;
    }
    
    public Builder setNanos(int param1Int) {
      copyOnWrite();
      ((Money)this.instance).setNanos(param1Int);
      return this;
    }
    
    public Builder setUnits(long param1Long) {
      copyOnWrite();
      ((Money)this.instance).setUnits(param1Long);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\Money.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */