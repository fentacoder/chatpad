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

public final class Date extends GeneratedMessageLite<Date, Date.Builder> implements DateOrBuilder {
  public static final int DAY_FIELD_NUMBER = 3;
  
  private static final Date DEFAULT_INSTANCE = new Date();
  
  public static final int MONTH_FIELD_NUMBER = 2;
  
  private static volatile Parser<Date> PARSER;
  
  public static final int YEAR_FIELD_NUMBER = 1;
  
  private int day_;
  
  private int month_;
  
  private int year_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDay() {
    this.day_ = 0;
  }
  
  private void clearMonth() {
    this.month_ = 0;
  }
  
  private void clearYear() {
    this.year_ = 0;
  }
  
  public static Date getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Date paramDate) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDate);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Date)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Date parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Date parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Date parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(InputStream paramInputStream) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Date parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Date parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Date)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Date> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDay(int paramInt) {
    this.day_ = paramInt;
  }
  
  private void setMonth(int paramInt) {
    this.month_ = paramInt;
  }
  
  private void setYear(int paramInt) {
    this.year_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/Date$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 473, 2 -> 469, 3 -> 467, 4 -> 458, 5 -> 270, 6 -> 118, 7 -> 266, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/type/Date
    //   80: monitorenter
    //   81: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/type/Date
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/type/Date
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/type/Date.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
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
    //   182: putfield day_ : I
    //   185: goto -> 128
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual readInt32 : ()I
    //   193: putfield month_ : I
    //   196: goto -> 128
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual readInt32 : ()I
    //   204: putfield year_ : I
    //   207: goto -> 128
    //   210: iconst_1
    //   211: istore #6
    //   213: goto -> 128
    //   216: astore_1
    //   217: goto -> 264
    //   220: astore_2
    //   221: new java/lang/RuntimeException
    //   224: astore_1
    //   225: new com/google/protobuf/InvalidProtocolBufferException
    //   228: astore_3
    //   229: aload_3
    //   230: aload_2
    //   231: invokevirtual getMessage : ()Ljava/lang/String;
    //   234: invokespecial <init> : (Ljava/lang/String;)V
    //   237: aload_1
    //   238: aload_3
    //   239: aload_0
    //   240: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   243: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   246: aload_1
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
    //   266: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   269: areturn
    //   270: aload_2
    //   271: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   274: astore_1
    //   275: aload_3
    //   276: checkcast com/google/type/Date
    //   279: astore_2
    //   280: aload_0
    //   281: getfield year_ : I
    //   284: ifeq -> 293
    //   287: iconst_1
    //   288: istore #7
    //   290: goto -> 296
    //   293: iconst_0
    //   294: istore #7
    //   296: aload_0
    //   297: getfield year_ : I
    //   300: istore #6
    //   302: aload_2
    //   303: getfield year_ : I
    //   306: ifeq -> 315
    //   309: iconst_1
    //   310: istore #8
    //   312: goto -> 318
    //   315: iconst_0
    //   316: istore #8
    //   318: aload_0
    //   319: aload_1
    //   320: iload #7
    //   322: iload #6
    //   324: iload #8
    //   326: aload_2
    //   327: getfield year_ : I
    //   330: invokeinterface visitInt : (ZIZI)I
    //   335: putfield year_ : I
    //   338: aload_0
    //   339: getfield month_ : I
    //   342: ifeq -> 351
    //   345: iconst_1
    //   346: istore #7
    //   348: goto -> 354
    //   351: iconst_0
    //   352: istore #7
    //   354: aload_0
    //   355: getfield month_ : I
    //   358: istore #6
    //   360: aload_2
    //   361: getfield month_ : I
    //   364: ifeq -> 373
    //   367: iconst_1
    //   368: istore #8
    //   370: goto -> 376
    //   373: iconst_0
    //   374: istore #8
    //   376: aload_0
    //   377: aload_1
    //   378: iload #7
    //   380: iload #6
    //   382: iload #8
    //   384: aload_2
    //   385: getfield month_ : I
    //   388: invokeinterface visitInt : (ZIZI)I
    //   393: putfield month_ : I
    //   396: aload_0
    //   397: getfield day_ : I
    //   400: ifeq -> 409
    //   403: iconst_1
    //   404: istore #7
    //   406: goto -> 412
    //   409: iconst_0
    //   410: istore #7
    //   412: aload_0
    //   413: getfield day_ : I
    //   416: istore #6
    //   418: iload #5
    //   420: istore #8
    //   422: aload_2
    //   423: getfield day_ : I
    //   426: ifeq -> 432
    //   429: iconst_1
    //   430: istore #8
    //   432: aload_0
    //   433: aload_1
    //   434: iload #7
    //   436: iload #6
    //   438: iload #8
    //   440: aload_2
    //   441: getfield day_ : I
    //   444: invokeinterface visitInt : (ZIZI)I
    //   449: putfield day_ : I
    //   452: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   455: astore_1
    //   456: aload_0
    //   457: areturn
    //   458: new com/google/type/Date$Builder
    //   461: dup
    //   462: aconst_null
    //   463: invokespecial <init> : (Lcom/google/type/Date$1;)V
    //   466: areturn
    //   467: aconst_null
    //   468: areturn
    //   469: getstatic com/google/type/Date.DEFAULT_INSTANCE : Lcom/google/type/Date;
    //   472: areturn
    //   473: new com/google/type/Date
    //   476: dup
    //   477: invokespecial <init> : ()V
    //   480: areturn
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
  
  public int getDay() {
    return this.day_;
  }
  
  public int getMonth() {
    return this.month_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = this.year_;
    if (i != 0)
      j = 0 + CodedOutputStream.computeInt32Size(1, i); 
    int k = this.month_;
    i = j;
    if (k != 0)
      i = j + CodedOutputStream.computeInt32Size(2, k); 
    k = this.day_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getYear() {
    return this.year_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.year_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.month_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    i = this.day_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Date, Builder> implements DateOrBuilder {
    private Builder() {
      super(Date.DEFAULT_INSTANCE);
    }
    
    public Builder clearDay() {
      copyOnWrite();
      ((Date)this.instance).clearDay();
      return this;
    }
    
    public Builder clearMonth() {
      copyOnWrite();
      ((Date)this.instance).clearMonth();
      return this;
    }
    
    public Builder clearYear() {
      copyOnWrite();
      ((Date)this.instance).clearYear();
      return this;
    }
    
    public int getDay() {
      return ((Date)this.instance).getDay();
    }
    
    public int getMonth() {
      return ((Date)this.instance).getMonth();
    }
    
    public int getYear() {
      return ((Date)this.instance).getYear();
    }
    
    public Builder setDay(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setDay(param1Int);
      return this;
    }
    
    public Builder setMonth(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setMonth(param1Int);
      return this;
    }
    
    public Builder setYear(int param1Int) {
      copyOnWrite();
      ((Date)this.instance).setYear(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\Date.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */