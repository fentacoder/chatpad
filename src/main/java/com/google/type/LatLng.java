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

public final class LatLng extends GeneratedMessageLite<LatLng, LatLng.Builder> implements LatLngOrBuilder {
  private static final LatLng DEFAULT_INSTANCE = new LatLng();
  
  public static final int LATITUDE_FIELD_NUMBER = 1;
  
  public static final int LONGITUDE_FIELD_NUMBER = 2;
  
  private static volatile Parser<LatLng> PARSER;
  
  private double latitude_;
  
  private double longitude_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearLatitude() {
    this.latitude_ = 0.0D;
  }
  
  private void clearLongitude() {
    this.longitude_ = 0.0D;
  }
  
  public static LatLng getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LatLng paramLatLng) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLatLng);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LatLng parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static LatLng parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static LatLng parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LatLng parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static LatLng parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LatLng)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LatLng> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setLatitude(double paramDouble) {
    this.latitude_ = paramDouble;
  }
  
  private void setLongitude(double paramDouble) {
    this.longitude_ = paramDouble;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/type/LatLng$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 403, 2 -> 399, 3 -> 397, 4 -> 388, 5 -> 248, 6 -> 114, 7 -> 244, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/type/LatLng
    //   76: monitorenter
    //   77: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/type/LatLng
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/type/LatLng
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/type/LatLng.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 244
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 188
    //   140: iload #4
    //   142: bipush #9
    //   144: if_icmpeq -> 177
    //   147: iload #4
    //   149: bipush #17
    //   151: if_icmpeq -> 166
    //   154: aload_1
    //   155: iload #4
    //   157: invokevirtual skipField : (I)Z
    //   160: ifne -> 124
    //   163: goto -> 188
    //   166: aload_0
    //   167: aload_1
    //   168: invokevirtual readDouble : ()D
    //   171: putfield longitude_ : D
    //   174: goto -> 124
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual readDouble : ()D
    //   182: putfield latitude_ : D
    //   185: goto -> 124
    //   188: iconst_1
    //   189: istore #5
    //   191: goto -> 124
    //   194: astore_1
    //   195: goto -> 242
    //   198: astore_2
    //   199: new java/lang/RuntimeException
    //   202: astore_3
    //   203: new com/google/protobuf/InvalidProtocolBufferException
    //   206: astore_1
    //   207: aload_1
    //   208: aload_2
    //   209: invokevirtual getMessage : ()Ljava/lang/String;
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: aload_3
    //   216: aload_1
    //   217: aload_0
    //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   224: aload_3
    //   225: athrow
    //   226: astore_1
    //   227: new java/lang/RuntimeException
    //   230: astore_2
    //   231: aload_2
    //   232: aload_1
    //   233: aload_0
    //   234: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   237: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   240: aload_2
    //   241: athrow
    //   242: aload_1
    //   243: athrow
    //   244: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   247: areturn
    //   248: aload_2
    //   249: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   252: astore_1
    //   253: aload_3
    //   254: checkcast com/google/type/LatLng
    //   257: astore_2
    //   258: aload_0
    //   259: getfield latitude_ : D
    //   262: dconst_0
    //   263: dcmpl
    //   264: ifeq -> 273
    //   267: iconst_1
    //   268: istore #6
    //   270: goto -> 276
    //   273: iconst_0
    //   274: istore #6
    //   276: aload_0
    //   277: getfield latitude_ : D
    //   280: dstore #7
    //   282: aload_2
    //   283: getfield latitude_ : D
    //   286: dconst_0
    //   287: dcmpl
    //   288: ifeq -> 297
    //   291: iconst_1
    //   292: istore #9
    //   294: goto -> 300
    //   297: iconst_0
    //   298: istore #9
    //   300: aload_0
    //   301: aload_1
    //   302: iload #6
    //   304: dload #7
    //   306: iload #9
    //   308: aload_2
    //   309: getfield latitude_ : D
    //   312: invokeinterface visitDouble : (ZDZD)D
    //   317: putfield latitude_ : D
    //   320: aload_0
    //   321: getfield longitude_ : D
    //   324: dconst_0
    //   325: dcmpl
    //   326: ifeq -> 335
    //   329: iconst_1
    //   330: istore #6
    //   332: goto -> 338
    //   335: iconst_0
    //   336: istore #6
    //   338: aload_0
    //   339: getfield longitude_ : D
    //   342: dstore #7
    //   344: aload_2
    //   345: getfield longitude_ : D
    //   348: dconst_0
    //   349: dcmpl
    //   350: ifeq -> 359
    //   353: iconst_1
    //   354: istore #9
    //   356: goto -> 362
    //   359: iconst_0
    //   360: istore #9
    //   362: aload_0
    //   363: aload_1
    //   364: iload #6
    //   366: dload #7
    //   368: iload #9
    //   370: aload_2
    //   371: getfield longitude_ : D
    //   374: invokeinterface visitDouble : (ZDZD)D
    //   379: putfield longitude_ : D
    //   382: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   385: astore_1
    //   386: aload_0
    //   387: areturn
    //   388: new com/google/type/LatLng$Builder
    //   391: dup
    //   392: aconst_null
    //   393: invokespecial <init> : (Lcom/google/type/LatLng$1;)V
    //   396: areturn
    //   397: aconst_null
    //   398: areturn
    //   399: getstatic com/google/type/LatLng.DEFAULT_INSTANCE : Lcom/google/type/LatLng;
    //   402: areturn
    //   403: new com/google/type/LatLng
    //   406: dup
    //   407: invokespecial <init> : ()V
    //   410: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	226	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	198	java/io/IOException
    //   129	135	194	finally
    //   154	163	226	com/google/protobuf/InvalidProtocolBufferException
    //   154	163	198	java/io/IOException
    //   154	163	194	finally
    //   166	174	226	com/google/protobuf/InvalidProtocolBufferException
    //   166	174	198	java/io/IOException
    //   166	174	194	finally
    //   177	185	226	com/google/protobuf/InvalidProtocolBufferException
    //   177	185	198	java/io/IOException
    //   177	185	194	finally
    //   199	226	194	finally
    //   227	242	194	finally
  }
  
  public double getLatitude() {
    return this.latitude_;
  }
  
  public double getLongitude() {
    return this.longitude_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    double d = this.latitude_;
    if (d != 0.0D)
      i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
    d = this.longitude_;
    int j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(2, d); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    double d = this.latitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(1, d); 
    d = this.longitude_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LatLng, Builder> implements LatLngOrBuilder {
    private Builder() {
      super(LatLng.DEFAULT_INSTANCE);
    }
    
    public Builder clearLatitude() {
      copyOnWrite();
      ((LatLng)this.instance).clearLatitude();
      return this;
    }
    
    public Builder clearLongitude() {
      copyOnWrite();
      ((LatLng)this.instance).clearLongitude();
      return this;
    }
    
    public double getLatitude() {
      return ((LatLng)this.instance).getLatitude();
    }
    
    public double getLongitude() {
      return ((LatLng)this.instance).getLongitude();
    }
    
    public Builder setLatitude(double param1Double) {
      copyOnWrite();
      ((LatLng)this.instance).setLatitude(param1Double);
      return this;
    }
    
    public Builder setLongitude(double param1Double) {
      copyOnWrite();
      ((LatLng)this.instance).setLongitude(param1Double);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\type\LatLng.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */