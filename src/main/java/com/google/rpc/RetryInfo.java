package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class RetryInfo extends GeneratedMessageLite<RetryInfo, RetryInfo.Builder> implements RetryInfoOrBuilder {
  private static final RetryInfo DEFAULT_INSTANCE = new RetryInfo();
  
  private static volatile Parser<RetryInfo> PARSER;
  
  public static final int RETRY_DELAY_FIELD_NUMBER = 1;
  
  private Duration retryDelay_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearRetryDelay() {
    this.retryDelay_ = null;
  }
  
  public static RetryInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeRetryDelay(Duration paramDuration) {
    Duration duration = this.retryDelay_;
    if (duration != null && duration != Duration.getDefaultInstance()) {
      this.retryDelay_ = (Duration)((Duration.Builder)Duration.newBuilder(this.retryDelay_).mergeFrom((GeneratedMessageLite)paramDuration)).buildPartial();
    } else {
      this.retryDelay_ = paramDuration;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(RetryInfo paramRetryInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramRetryInfo);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RetryInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static RetryInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static RetryInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static RetryInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static RetryInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (RetryInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<RetryInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setRetryDelay(Duration.Builder paramBuilder) {
    this.retryDelay_ = (Duration)paramBuilder.build();
  }
  
  private void setRetryDelay(Duration paramDuration) {
    if (paramDuration != null) {
      this.retryDelay_ = paramDuration;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/RetryInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 335, 2 -> 331, 3 -> 329, 4 -> 320, 5 -> 283, 6 -> 110, 7 -> 279, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/RetryInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/RetryInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/RetryInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/RetryInfo.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_2
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 279
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 223
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 158
    //   146: aload_2
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 223
    //   158: aload_0
    //   159: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   162: ifnull -> 179
    //   165: aload_0
    //   166: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   169: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   172: checkcast com/google/protobuf/Duration$Builder
    //   175: astore_1
    //   176: goto -> 181
    //   179: aconst_null
    //   180: astore_1
    //   181: aload_0
    //   182: aload_2
    //   183: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   186: aload_3
    //   187: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   190: checkcast com/google/protobuf/Duration
    //   193: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   196: aload_1
    //   197: ifnull -> 123
    //   200: aload_1
    //   201: aload_0
    //   202: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   205: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   208: pop
    //   209: aload_0
    //   210: aload_1
    //   211: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   214: checkcast com/google/protobuf/Duration
    //   217: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   220: goto -> 123
    //   223: iconst_1
    //   224: istore #4
    //   226: goto -> 123
    //   229: astore_1
    //   230: goto -> 277
    //   233: astore_2
    //   234: new java/lang/RuntimeException
    //   237: astore_3
    //   238: new com/google/protobuf/InvalidProtocolBufferException
    //   241: astore_1
    //   242: aload_1
    //   243: aload_2
    //   244: invokevirtual getMessage : ()Ljava/lang/String;
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: aload_3
    //   251: aload_1
    //   252: aload_0
    //   253: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   256: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_1
    //   262: new java/lang/RuntimeException
    //   265: astore_2
    //   266: aload_2
    //   267: aload_1
    //   268: aload_0
    //   269: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   272: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   282: areturn
    //   283: aload_2
    //   284: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   287: astore_1
    //   288: aload_3
    //   289: checkcast com/google/rpc/RetryInfo
    //   292: astore_2
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   299: aload_2
    //   300: getfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   303: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   308: checkcast com/google/protobuf/Duration
    //   311: putfield retryDelay_ : Lcom/google/protobuf/Duration;
    //   314: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   317: astore_1
    //   318: aload_0
    //   319: areturn
    //   320: new com/google/rpc/RetryInfo$Builder
    //   323: dup
    //   324: aconst_null
    //   325: invokespecial <init> : (Lcom/google/rpc/RetryInfo$1;)V
    //   328: areturn
    //   329: aconst_null
    //   330: areturn
    //   331: getstatic com/google/rpc/RetryInfo.DEFAULT_INSTANCE : Lcom/google/rpc/RetryInfo;
    //   334: areturn
    //   335: new com/google/rpc/RetryInfo
    //   338: dup
    //   339: invokespecial <init> : ()V
    //   342: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	261	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	233	java/io/IOException
    //   128	134	229	finally
    //   146	155	261	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	233	java/io/IOException
    //   146	155	229	finally
    //   158	176	261	com/google/protobuf/InvalidProtocolBufferException
    //   158	176	233	java/io/IOException
    //   158	176	229	finally
    //   181	196	261	com/google/protobuf/InvalidProtocolBufferException
    //   181	196	233	java/io/IOException
    //   181	196	229	finally
    //   200	220	261	com/google/protobuf/InvalidProtocolBufferException
    //   200	220	233	java/io/IOException
    //   200	220	229	finally
    //   234	261	229	finally
    //   262	277	229	finally
  }
  
  public Duration getRetryDelay() {
    Duration duration1 = this.retryDelay_;
    Duration duration2 = duration1;
    if (duration1 == null)
      duration2 = Duration.getDefaultInstance(); 
    return duration2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.retryDelay_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getRetryDelay()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasRetryDelay() {
    boolean bool;
    if (this.retryDelay_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.retryDelay_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getRetryDelay()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<RetryInfo, Builder> implements RetryInfoOrBuilder {
    private Builder() {
      super(RetryInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearRetryDelay() {
      copyOnWrite();
      ((RetryInfo)this.instance).clearRetryDelay();
      return this;
    }
    
    public Duration getRetryDelay() {
      return ((RetryInfo)this.instance).getRetryDelay();
    }
    
    public boolean hasRetryDelay() {
      return ((RetryInfo)this.instance).hasRetryDelay();
    }
    
    public Builder mergeRetryDelay(Duration param1Duration) {
      copyOnWrite();
      ((RetryInfo)this.instance).mergeRetryDelay(param1Duration);
      return this;
    }
    
    public Builder setRetryDelay(Duration.Builder param1Builder) {
      copyOnWrite();
      ((RetryInfo)this.instance).setRetryDelay(param1Builder);
      return this;
    }
    
    public Builder setRetryDelay(Duration param1Duration) {
      copyOnWrite();
      ((RetryInfo)this.instance).setRetryDelay(param1Duration);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\RetryInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */