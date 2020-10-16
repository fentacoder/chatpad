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

public final class TimeOfDay extends GeneratedMessageLite<TimeOfDay, TimeOfDay.Builder> implements TimeOfDayOrBuilder {
  private static final TimeOfDay DEFAULT_INSTANCE = new TimeOfDay();
  
  public static final int HOURS_FIELD_NUMBER = 1;
  
  public static final int MINUTES_FIELD_NUMBER = 2;
  
  public static final int NANOS_FIELD_NUMBER = 4;
  
  private static volatile Parser<TimeOfDay> PARSER;
  
  public static final int SECONDS_FIELD_NUMBER = 3;
  
  private int hours_;
  
  private int minutes_;
  
  private int nanos_;
  
  private int seconds_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearHours() {
    this.hours_ = 0;
  }
  
  private void clearMinutes() {
    this.minutes_ = 0;
  }
  
  private void clearNanos() {
    this.nanos_ = 0;
  }
  
  private void clearSeconds() {
    this.seconds_ = 0;
  }
  
  public static TimeOfDay getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TimeOfDay paramTimeOfDay) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTimeOfDay);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TimeOfDay parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TimeOfDay parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TimeOfDay parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TimeOfDay parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TimeOfDay parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TimeOfDay)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TimeOfDay> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setHours(int paramInt) {
    this.hours_ = paramInt;
  }
  
  private void setMinutes(int paramInt) {
    this.minutes_ = paramInt;
  }
  
  private void setNanos(int paramInt) {
    this.nanos_ = paramInt;
  }
  
  private void setSeconds(int paramInt) {
    this.seconds_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/TimeOfDay$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 549, 2 -> 545, 3 -> 543, 4 -> 534, 5 -> 288, 6 -> 118, 7 -> 284, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/TimeOfDay
    //   80: monitorenter
    //   81: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/TimeOfDay
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/TimeOfDay
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/TimeOfDay.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 284
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 228
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 217
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 206
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 195
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 184
    //   172: aload_1
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 228
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual readInt32 : ()I
    //   189: putfield nanos_ : I
    //   192: goto -> 128
    //   195: aload_0
    //   196: aload_1
    //   197: invokevirtual readInt32 : ()I
    //   200: putfield seconds_ : I
    //   203: goto -> 128
    //   206: aload_0
    //   207: aload_1
    //   208: invokevirtual readInt32 : ()I
    //   211: putfield minutes_ : I
    //   214: goto -> 128
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual readInt32 : ()I
    //   222: putfield hours_ : I
    //   225: goto -> 128
    //   228: iconst_1
    //   229: istore #6
    //   231: goto -> 128
    //   234: astore_1
    //   235: goto -> 282
    //   238: astore_2
    //   239: new java/lang/RuntimeException
    //   242: astore_1
    //   243: new com/google/protobuf/InvalidProtocolBufferException
    //   246: astore_3
    //   247: aload_3
    //   248: aload_2
    //   249: invokevirtual getMessage : ()Ljava/lang/String;
    //   252: invokespecial <init> : (Ljava/lang/String;)V
    //   255: aload_1
    //   256: aload_3
    //   257: aload_0
    //   258: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   261: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: new java/lang/RuntimeException
    //   270: astore_1
    //   271: aload_1
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_1
    //   281: athrow
    //   282: aload_1
    //   283: athrow
    //   284: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   287: areturn
    //   288: aload_2
    //   289: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   292: astore_1
    //   293: aload_3
    //   294: checkcast com/google/type/TimeOfDay
    //   297: astore_2
    //   298: aload_0
    //   299: getfield hours_ : I
    //   302: ifeq -> 311
    //   305: iconst_1
    //   306: istore #7
    //   308: goto -> 314
    //   311: iconst_0
    //   312: istore #7
    //   314: aload_0
    //   315: getfield hours_ : I
    //   318: istore #6
    //   320: aload_2
    //   321: getfield hours_ : I
    //   324: ifeq -> 333
    //   327: iconst_1
    //   328: istore #8
    //   330: goto -> 336
    //   333: iconst_0
    //   334: istore #8
    //   336: aload_0
    //   337: aload_1
    //   338: iload #7
    //   340: iload #6
    //   342: iload #8
    //   344: aload_2
    //   345: getfield hours_ : I
    //   348: invokeinterface visitInt : (ZIZI)I
    //   353: putfield hours_ : I
    //   356: aload_0
    //   357: getfield minutes_ : I
    //   360: ifeq -> 369
    //   363: iconst_1
    //   364: istore #7
    //   366: goto -> 372
    //   369: iconst_0
    //   370: istore #7
    //   372: aload_0
    //   373: getfield minutes_ : I
    //   376: istore #6
    //   378: aload_2
    //   379: getfield minutes_ : I
    //   382: ifeq -> 391
    //   385: iconst_1
    //   386: istore #8
    //   388: goto -> 394
    //   391: iconst_0
    //   392: istore #8
    //   394: aload_0
    //   395: aload_1
    //   396: iload #7
    //   398: iload #6
    //   400: iload #8
    //   402: aload_2
    //   403: getfield minutes_ : I
    //   406: invokeinterface visitInt : (ZIZI)I
    //   411: putfield minutes_ : I
    //   414: aload_0
    //   415: getfield seconds_ : I
    //   418: ifeq -> 427
    //   421: iconst_1
    //   422: istore #7
    //   424: goto -> 430
    //   427: iconst_0
    //   428: istore #7
    //   430: aload_0
    //   431: getfield seconds_ : I
    //   434: istore #6
    //   436: aload_2
    //   437: getfield seconds_ : I
    //   440: ifeq -> 449
    //   443: iconst_1
    //   444: istore #8
    //   446: goto -> 452
    //   449: iconst_0
    //   450: istore #8
    //   452: aload_0
    //   453: aload_1
    //   454: iload #7
    //   456: iload #6
    //   458: iload #8
    //   460: aload_2
    //   461: getfield seconds_ : I
    //   464: invokeinterface visitInt : (ZIZI)I
    //   469: putfield seconds_ : I
    //   472: aload_0
    //   473: getfield nanos_ : I
    //   476: ifeq -> 485
    //   479: iconst_1
    //   480: istore #7
    //   482: goto -> 488
    //   485: iconst_0
    //   486: istore #7
    //   488: aload_0
    //   489: getfield nanos_ : I
    //   492: istore #6
    //   494: iload #5
    //   496: istore #8
    //   498: aload_2
    //   499: getfield nanos_ : I
    //   502: ifeq -> 508
    //   505: iconst_1
    //   506: istore #8
    //   508: aload_0
    //   509: aload_1
    //   510: iload #7
    //   512: iload #6
    //   514: iload #8
    //   516: aload_2
    //   517: getfield nanos_ : I
    //   520: invokeinterface visitInt : (ZIZI)I
    //   525: putfield nanos_ : I
    //   528: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   531: astore_1
    //   532: aload_0
    //   533: areturn
    //   534: new com/google/type/TimeOfDay$Builder
    //   537: dup
    //   538: aconst_null
    //   539: invokespecial <init> : (Lcom/google/type/TimeOfDay$1;)V
    //   542: areturn
    //   543: aconst_null
    //   544: areturn
    //   545: getstatic com/google/type/TimeOfDay.DEFAULT_INSTANCE : Lcom/google/type/TimeOfDay;
    //   548: areturn
    //   549: new com/google/type/TimeOfDay
    //   552: dup
    //   553: invokespecial <init> : ()V
    //   556: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	266	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	238	java/io/IOException
    //   133	139	234	finally
    //   172	181	266	com/google/protobuf/InvalidProtocolBufferException
    //   172	181	238	java/io/IOException
    //   172	181	234	finally
    //   184	192	266	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	238	java/io/IOException
    //   184	192	234	finally
    //   195	203	266	com/google/protobuf/InvalidProtocolBufferException
    //   195	203	238	java/io/IOException
    //   195	203	234	finally
    //   206	214	266	com/google/protobuf/InvalidProtocolBufferException
    //   206	214	238	java/io/IOException
    //   206	214	234	finally
    //   217	225	266	com/google/protobuf/InvalidProtocolBufferException
    //   217	225	238	java/io/IOException
    //   217	225	234	finally
    //   239	266	234	finally
    //   267	282	234	finally
  }
  
  public int getHours() {
    return this.hours_;
  }
  
  public int getMinutes() {
    return this.minutes_;
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public int getSeconds() {
    return this.seconds_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.hours_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    int k = this.minutes_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(2, k); 
    k = this.seconds_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(3, k); 
    k = this.nanos_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(4, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.hours_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.minutes_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.seconds_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TimeOfDay, Builder> implements TimeOfDayOrBuilder {
    private Builder() {
      super(TimeOfDay.DEFAULT_INSTANCE);
    }
    
    public Builder clearHours() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearHours();
      return this;
    }
    
    public Builder clearMinutes() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearMinutes();
      return this;
    }
    
    public Builder clearNanos() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearNanos();
      return this;
    }
    
    public Builder clearSeconds() {
      copyOnWrite();
      ((TimeOfDay)this.instance).clearSeconds();
      return this;
    }
    
    public int getHours() {
      return ((TimeOfDay)this.instance).getHours();
    }
    
    public int getMinutes() {
      return ((TimeOfDay)this.instance).getMinutes();
    }
    
    public int getNanos() {
      return ((TimeOfDay)this.instance).getNanos();
    }
    
    public int getSeconds() {
      return ((TimeOfDay)this.instance).getSeconds();
    }
    
    public Builder setHours(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setHours(param1Int);
      return this;
    }
    
    public Builder setMinutes(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setMinutes(param1Int);
      return this;
    }
    
    public Builder setNanos(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setNanos(param1Int);
      return this;
    }
    
    public Builder setSeconds(int param1Int) {
      copyOnWrite();
      ((TimeOfDay)this.instance).setSeconds(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\TimeOfDay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */