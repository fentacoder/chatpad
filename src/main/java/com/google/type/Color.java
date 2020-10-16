package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Color extends GeneratedMessageLite<Color, Color.Builder> implements ColorOrBuilder {
  public static final int ALPHA_FIELD_NUMBER = 4;
  
  public static final int BLUE_FIELD_NUMBER = 3;
  
  private static final Color DEFAULT_INSTANCE = new Color();
  
  public static final int GREEN_FIELD_NUMBER = 2;
  
  private static volatile Parser<Color> PARSER;
  
  public static final int RED_FIELD_NUMBER = 1;
  
  private FloatValue alpha_;
  
  private float blue_;
  
  private float green_;
  
  private float red_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAlpha() {
    this.alpha_ = null;
  }
  
  private void clearBlue() {
    this.blue_ = 0.0F;
  }
  
  private void clearGreen() {
    this.green_ = 0.0F;
  }
  
  private void clearRed() {
    this.red_ = 0.0F;
  }
  
  public static Color getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeAlpha(FloatValue paramFloatValue) {
    FloatValue floatValue = this.alpha_;
    if (floatValue != null && floatValue != FloatValue.getDefaultInstance()) {
      this.alpha_ = (FloatValue)((FloatValue.Builder)FloatValue.newBuilder(this.alpha_).mergeFrom((GeneratedMessageLite)paramFloatValue)).buildPartial();
    } else {
      this.alpha_ = paramFloatValue;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Color paramColor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramColor);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Color)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Color parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Color parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Color parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(InputStream paramInputStream) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Color parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Color parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Color)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Color> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAlpha(FloatValue.Builder paramBuilder) {
    this.alpha_ = (FloatValue)paramBuilder.build();
  }
  
  private void setAlpha(FloatValue paramFloatValue) {
    if (paramFloatValue != null) {
      this.alpha_ = paramFloatValue;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setBlue(float paramFloat) {
    this.blue_ = paramFloat;
  }
  
  private void setGreen(float paramFloat) {
    this.green_ = paramFloat;
  }
  
  private void setRed(float paramFloat) {
    this.red_ = paramFloat;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Color$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 578, 2 -> 574, 3 -> 572, 4 -> 563, 5 -> 342, 6 -> 118, 7 -> 338, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Color
    //   80: monitorenter
    //   81: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Color
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Color
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Color.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 338
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 282
    //   144: iload #4
    //   146: bipush #13
    //   148: if_icmpeq -> 271
    //   151: iload #4
    //   153: bipush #21
    //   155: if_icmpeq -> 260
    //   158: iload #4
    //   160: bipush #29
    //   162: if_icmpeq -> 249
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 184
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 282
    //   184: aload_0
    //   185: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   188: ifnull -> 205
    //   191: aload_0
    //   192: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   195: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   198: checkcast com/google/protobuf/FloatValue$Builder
    //   201: astore_1
    //   202: goto -> 207
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: aload_2
    //   209: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   212: aload_3
    //   213: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   216: checkcast com/google/protobuf/FloatValue
    //   219: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   222: aload_1
    //   223: ifnull -> 128
    //   226: aload_1
    //   227: aload_0
    //   228: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   231: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   234: pop
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   240: checkcast com/google/protobuf/FloatValue
    //   243: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   246: goto -> 128
    //   249: aload_0
    //   250: aload_2
    //   251: invokevirtual readFloat : ()F
    //   254: putfield blue_ : F
    //   257: goto -> 128
    //   260: aload_0
    //   261: aload_2
    //   262: invokevirtual readFloat : ()F
    //   265: putfield green_ : F
    //   268: goto -> 128
    //   271: aload_0
    //   272: aload_2
    //   273: invokevirtual readFloat : ()F
    //   276: putfield red_ : F
    //   279: goto -> 128
    //   282: iconst_1
    //   283: istore #6
    //   285: goto -> 128
    //   288: astore_1
    //   289: goto -> 336
    //   292: astore_2
    //   293: new java/lang/RuntimeException
    //   296: astore_3
    //   297: new com/google/protobuf/InvalidProtocolBufferException
    //   300: astore_1
    //   301: aload_1
    //   302: aload_2
    //   303: invokevirtual getMessage : ()Ljava/lang/String;
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: aload_3
    //   310: aload_1
    //   311: aload_0
    //   312: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   315: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   318: aload_3
    //   319: athrow
    //   320: astore_1
    //   321: new java/lang/RuntimeException
    //   324: astore_2
    //   325: aload_2
    //   326: aload_1
    //   327: aload_0
    //   328: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   331: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   334: aload_2
    //   335: athrow
    //   336: aload_1
    //   337: athrow
    //   338: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   341: areturn
    //   342: aload_2
    //   343: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   346: astore_1
    //   347: aload_3
    //   348: checkcast com/google/type/Color
    //   351: astore_2
    //   352: aload_0
    //   353: getfield red_ : F
    //   356: fconst_0
    //   357: fcmpl
    //   358: ifeq -> 367
    //   361: iconst_1
    //   362: istore #7
    //   364: goto -> 370
    //   367: iconst_0
    //   368: istore #7
    //   370: aload_0
    //   371: getfield red_ : F
    //   374: fstore #8
    //   376: aload_2
    //   377: getfield red_ : F
    //   380: fconst_0
    //   381: fcmpl
    //   382: ifeq -> 391
    //   385: iconst_1
    //   386: istore #9
    //   388: goto -> 394
    //   391: iconst_0
    //   392: istore #9
    //   394: aload_0
    //   395: aload_1
    //   396: iload #7
    //   398: fload #8
    //   400: iload #9
    //   402: aload_2
    //   403: getfield red_ : F
    //   406: invokeinterface visitFloat : (ZFZF)F
    //   411: putfield red_ : F
    //   414: aload_0
    //   415: getfield green_ : F
    //   418: fconst_0
    //   419: fcmpl
    //   420: ifeq -> 429
    //   423: iconst_1
    //   424: istore #7
    //   426: goto -> 432
    //   429: iconst_0
    //   430: istore #7
    //   432: aload_0
    //   433: getfield green_ : F
    //   436: fstore #8
    //   438: aload_2
    //   439: getfield green_ : F
    //   442: fconst_0
    //   443: fcmpl
    //   444: ifeq -> 453
    //   447: iconst_1
    //   448: istore #9
    //   450: goto -> 456
    //   453: iconst_0
    //   454: istore #9
    //   456: aload_0
    //   457: aload_1
    //   458: iload #7
    //   460: fload #8
    //   462: iload #9
    //   464: aload_2
    //   465: getfield green_ : F
    //   468: invokeinterface visitFloat : (ZFZF)F
    //   473: putfield green_ : F
    //   476: aload_0
    //   477: getfield blue_ : F
    //   480: fconst_0
    //   481: fcmpl
    //   482: ifeq -> 491
    //   485: iconst_1
    //   486: istore #7
    //   488: goto -> 494
    //   491: iconst_0
    //   492: istore #7
    //   494: aload_0
    //   495: getfield blue_ : F
    //   498: fstore #8
    //   500: iload #5
    //   502: istore #9
    //   504: aload_2
    //   505: getfield blue_ : F
    //   508: fconst_0
    //   509: fcmpl
    //   510: ifeq -> 516
    //   513: iconst_1
    //   514: istore #9
    //   516: aload_0
    //   517: aload_1
    //   518: iload #7
    //   520: fload #8
    //   522: iload #9
    //   524: aload_2
    //   525: getfield blue_ : F
    //   528: invokeinterface visitFloat : (ZFZF)F
    //   533: putfield blue_ : F
    //   536: aload_0
    //   537: aload_1
    //   538: aload_0
    //   539: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   542: aload_2
    //   543: getfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   546: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   551: checkcast com/google/protobuf/FloatValue
    //   554: putfield alpha_ : Lcom/google/protobuf/FloatValue;
    //   557: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   560: astore_1
    //   561: aload_0
    //   562: areturn
    //   563: new com/google/type/Color$Builder
    //   566: dup
    //   567: aconst_null
    //   568: invokespecial <init> : (Lcom/google/type/Color$1;)V
    //   571: areturn
    //   572: aconst_null
    //   573: areturn
    //   574: getstatic com/google/type/Color.DEFAULT_INSTANCE : Lcom/google/type/Color;
    //   577: areturn
    //   578: new com/google/type/Color
    //   581: dup
    //   582: invokespecial <init> : ()V
    //   585: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	320	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	292	java/io/IOException
    //   133	139	288	finally
    //   172	181	320	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	292	java/io/IOException
    //   172	181	288	finally
    //   184	202	320	com/google/protobuf/InvalidProtocolBufferException
    //   184	202	292	java/io/IOException
    //   184	202	288	finally
    //   207	222	320	com/google/protobuf/InvalidProtocolBufferException
    //   207	222	292	java/io/IOException
    //   207	222	288	finally
    //   226	246	320	com/google/protobuf/InvalidProtocolBufferException
    //   226	246	292	java/io/IOException
    //   226	246	288	finally
    //   249	257	320	com/google/protobuf/InvalidProtocolBufferException
    //   249	257	292	java/io/IOException
    //   249	257	288	finally
    //   260	268	320	com/google/protobuf/InvalidProtocolBufferException
    //   260	268	292	java/io/IOException
    //   260	268	288	finally
    //   271	279	320	com/google/protobuf/InvalidProtocolBufferException
    //   271	279	292	java/io/IOException
    //   271	279	288	finally
    //   293	320	288	finally
    //   321	336	288	finally
  }
  
  public FloatValue getAlpha() {
    FloatValue floatValue1 = this.alpha_;
    FloatValue floatValue2 = floatValue1;
    if (floatValue1 == null)
      floatValue2 = FloatValue.getDefaultInstance(); 
    return floatValue2;
  }
  
  public float getBlue() {
    return this.blue_;
  }
  
  public float getGreen() {
    return this.green_;
  }
  
  public float getRed() {
    return this.red_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    float f = this.red_;
    if (f != 0.0F)
      i = 0 + CodedOutputStream.computeFloatSize(1, f); 
    f = this.green_;
    int j = i;
    if (f != 0.0F)
      j = i + CodedOutputStream.computeFloatSize(2, f); 
    f = this.blue_;
    i = j;
    if (f != 0.0F)
      i = j + CodedOutputStream.computeFloatSize(3, f); 
    j = i;
    if (this.alpha_ != null)
      j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getAlpha()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean hasAlpha() {
    boolean bool;
    if (this.alpha_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    float f = this.red_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(1, f); 
    f = this.green_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(2, f); 
    f = this.blue_;
    if (f != 0.0F)
      paramCodedOutputStream.writeFloat(3, f); 
    if (this.alpha_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getAlpha()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Color, Builder> implements ColorOrBuilder {
    private Builder() {
      super(Color.DEFAULT_INSTANCE);
    }
    
    public Builder clearAlpha() {
      copyOnWrite();
      ((Color)this.instance).clearAlpha();
      return this;
    }
    
    public Builder clearBlue() {
      copyOnWrite();
      ((Color)this.instance).clearBlue();
      return this;
    }
    
    public Builder clearGreen() {
      copyOnWrite();
      ((Color)this.instance).clearGreen();
      return this;
    }
    
    public Builder clearRed() {
      copyOnWrite();
      ((Color)this.instance).clearRed();
      return this;
    }
    
    public FloatValue getAlpha() {
      return ((Color)this.instance).getAlpha();
    }
    
    public float getBlue() {
      return ((Color)this.instance).getBlue();
    }
    
    public float getGreen() {
      return ((Color)this.instance).getGreen();
    }
    
    public float getRed() {
      return ((Color)this.instance).getRed();
    }
    
    public boolean hasAlpha() {
      return ((Color)this.instance).hasAlpha();
    }
    
    public Builder mergeAlpha(FloatValue param1FloatValue) {
      copyOnWrite();
      ((Color)this.instance).mergeAlpha(param1FloatValue);
      return this;
    }
    
    public Builder setAlpha(FloatValue.Builder param1Builder) {
      copyOnWrite();
      ((Color)this.instance).setAlpha(param1Builder);
      return this;
    }
    
    public Builder setAlpha(FloatValue param1FloatValue) {
      copyOnWrite();
      ((Color)this.instance).setAlpha(param1FloatValue);
      return this;
    }
    
    public Builder setBlue(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setBlue(param1Float);
      return this;
    }
    
    public Builder setGreen(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setGreen(param1Float);
      return this;
    }
    
    public Builder setRed(float param1Float) {
      copyOnWrite();
      ((Color)this.instance).setRed(param1Float);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\Color.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */