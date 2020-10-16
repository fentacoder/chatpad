package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class WriteResult extends GeneratedMessageLite<WriteResult, WriteResult.Builder> implements WriteResultOrBuilder {
  private static final WriteResult DEFAULT_INSTANCE = new WriteResult();
  
  private static volatile Parser<WriteResult> PARSER;
  
  public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
  
  public static final int UPDATE_TIME_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Value> transformResults_ = emptyProtobufList();
  
  private Timestamp updateTime_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllTransformResults(Iterable<? extends Value> paramIterable) {
    ensureTransformResultsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.transformResults_);
  }
  
  private void addTransformResults(int paramInt, Value.Builder paramBuilder) {
    ensureTransformResultsIsMutable();
    this.transformResults_.add(paramInt, paramBuilder.build());
  }
  
  private void addTransformResults(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureTransformResultsIsMutable();
      this.transformResults_.add(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addTransformResults(Value.Builder paramBuilder) {
    ensureTransformResultsIsMutable();
    this.transformResults_.add(paramBuilder.build());
  }
  
  private void addTransformResults(Value paramValue) {
    if (paramValue != null) {
      ensureTransformResultsIsMutable();
      this.transformResults_.add(paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearTransformResults() {
    this.transformResults_ = emptyProtobufList();
  }
  
  private void clearUpdateTime() {
    this.updateTime_ = null;
  }
  
  private void ensureTransformResultsIsMutable() {
    if (!this.transformResults_.isModifiable())
      this.transformResults_ = GeneratedMessageLite.mutableCopy(this.transformResults_); 
  }
  
  public static WriteResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeUpdateTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.updateTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.updateTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.updateTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.updateTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(WriteResult paramWriteResult) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramWriteResult);
  }
  
  public static WriteResult parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (WriteResult)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteResult parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResult)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResult parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static WriteResult parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static WriteResult parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static WriteResult parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResult parseFrom(InputStream paramInputStream) throws IOException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static WriteResult parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static WriteResult parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static WriteResult parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (WriteResult)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<WriteResult> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeTransformResults(int paramInt) {
    ensureTransformResultsIsMutable();
    this.transformResults_.remove(paramInt);
  }
  
  private void setTransformResults(int paramInt, Value.Builder paramBuilder) {
    ensureTransformResultsIsMutable();
    this.transformResults_.set(paramInt, paramBuilder.build());
  }
  
  private void setTransformResults(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureTransformResultsIsMutable();
      this.transformResults_.set(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUpdateTime(Timestamp.Builder paramBuilder) {
    this.updateTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setUpdateTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.updateTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/WriteResult$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 432, 2 -> 428, 3 -> 417, 4 -> 408, 5 -> 337, 6 -> 110, 7 -> 333, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/WriteResult.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/WriteResult
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/WriteResult.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/WriteResult.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResult;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/WriteResult.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/WriteResult
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/WriteResult
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/WriteResult.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 333
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 277
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 212
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 165
    //   153: aload_2
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 277
    //   165: aload_0
    //   166: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   169: invokeinterface isModifiable : ()Z
    //   174: ifne -> 188
    //   177: aload_0
    //   178: aload_0
    //   179: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   182: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   185: putfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_0
    //   189: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   192: aload_2
    //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   196: aload_3
    //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   200: checkcast com/google/firestore/v1/Value
    //   203: invokeinterface add : (Ljava/lang/Object;)Z
    //   208: pop
    //   209: goto -> 123
    //   212: aload_0
    //   213: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   216: ifnull -> 233
    //   219: aload_0
    //   220: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   223: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   226: checkcast com/google/protobuf/Timestamp$Builder
    //   229: astore_1
    //   230: goto -> 235
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_0
    //   236: aload_2
    //   237: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   240: aload_3
    //   241: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   244: checkcast com/google/protobuf/Timestamp
    //   247: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   250: aload_1
    //   251: ifnull -> 123
    //   254: aload_1
    //   255: aload_0
    //   256: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   259: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   268: checkcast com/google/protobuf/Timestamp
    //   271: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   274: goto -> 123
    //   277: iconst_1
    //   278: istore #4
    //   280: goto -> 123
    //   283: astore_1
    //   284: goto -> 331
    //   287: astore_1
    //   288: new java/lang/RuntimeException
    //   291: astore_3
    //   292: new com/google/protobuf/InvalidProtocolBufferException
    //   295: astore_2
    //   296: aload_2
    //   297: aload_1
    //   298: invokevirtual getMessage : ()Ljava/lang/String;
    //   301: invokespecial <init> : (Ljava/lang/String;)V
    //   304: aload_3
    //   305: aload_2
    //   306: aload_0
    //   307: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   310: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   313: aload_3
    //   314: athrow
    //   315: astore_1
    //   316: new java/lang/RuntimeException
    //   319: astore_2
    //   320: aload_2
    //   321: aload_1
    //   322: aload_0
    //   323: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   326: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   329: aload_2
    //   330: athrow
    //   331: aload_1
    //   332: athrow
    //   333: getstatic com/google/firestore/v1/WriteResult.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResult;
    //   336: areturn
    //   337: aload_2
    //   338: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   341: astore_1
    //   342: aload_3
    //   343: checkcast com/google/firestore/v1/WriteResult
    //   346: astore_2
    //   347: aload_0
    //   348: aload_1
    //   349: aload_0
    //   350: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   353: aload_2
    //   354: getfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   357: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   362: checkcast com/google/protobuf/Timestamp
    //   365: putfield updateTime_ : Lcom/google/protobuf/Timestamp;
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   374: aload_2
    //   375: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   378: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   383: putfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   386: aload_1
    //   387: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   390: if_acmpne -> 406
    //   393: aload_0
    //   394: aload_0
    //   395: getfield bitField0_ : I
    //   398: aload_2
    //   399: getfield bitField0_ : I
    //   402: ior
    //   403: putfield bitField0_ : I
    //   406: aload_0
    //   407: areturn
    //   408: new com/google/firestore/v1/WriteResult$Builder
    //   411: dup
    //   412: aconst_null
    //   413: invokespecial <init> : (Lcom/google/firestore/v1/WriteResult$1;)V
    //   416: areturn
    //   417: aload_0
    //   418: getfield transformResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   421: invokeinterface makeImmutable : ()V
    //   426: aconst_null
    //   427: areturn
    //   428: getstatic com/google/firestore/v1/WriteResult.DEFAULT_INSTANCE : Lcom/google/firestore/v1/WriteResult;
    //   431: areturn
    //   432: new com/google/firestore/v1/WriteResult
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	315	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	287	java/io/IOException
    //   128	134	283	finally
    //   153	162	315	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	287	java/io/IOException
    //   153	162	283	finally
    //   165	188	315	com/google/protobuf/InvalidProtocolBufferException
    //   165	188	287	java/io/IOException
    //   165	188	283	finally
    //   188	209	315	com/google/protobuf/InvalidProtocolBufferException
    //   188	209	287	java/io/IOException
    //   188	209	283	finally
    //   212	230	315	com/google/protobuf/InvalidProtocolBufferException
    //   212	230	287	java/io/IOException
    //   212	230	283	finally
    //   235	250	315	com/google/protobuf/InvalidProtocolBufferException
    //   235	250	287	java/io/IOException
    //   235	250	283	finally
    //   254	274	315	com/google/protobuf/InvalidProtocolBufferException
    //   254	274	287	java/io/IOException
    //   254	274	283	finally
    //   288	315	283	finally
    //   316	331	283	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    Timestamp timestamp = this.updateTime_;
    byte b = 0;
    if (timestamp != null) {
      i = CodedOutputStream.computeMessageSize(1, (MessageLite)getUpdateTime()) + 0;
    } else {
      i = 0;
    } 
    while (b < this.transformResults_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.transformResults_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Value getTransformResults(int paramInt) {
    return (Value)this.transformResults_.get(paramInt);
  }
  
  public int getTransformResultsCount() {
    return this.transformResults_.size();
  }
  
  public List<Value> getTransformResultsList() {
    return (List<Value>)this.transformResults_;
  }
  
  public ValueOrBuilder getTransformResultsOrBuilder(int paramInt) {
    return (ValueOrBuilder)this.transformResults_.get(paramInt);
  }
  
  public List<? extends ValueOrBuilder> getTransformResultsOrBuilderList() {
    return (List)this.transformResults_;
  }
  
  public Timestamp getUpdateTime() {
    Timestamp timestamp1 = this.updateTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public boolean hasUpdateTime() {
    boolean bool;
    if (this.updateTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.updateTime_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getUpdateTime()); 
    for (byte b = 0; b < this.transformResults_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.transformResults_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<WriteResult, Builder> implements WriteResultOrBuilder {
    private Builder() {
      super(WriteResult.DEFAULT_INSTANCE);
    }
    
    public Builder addAllTransformResults(Iterable<? extends Value> param1Iterable) {
      copyOnWrite();
      ((WriteResult)this.instance).addAllTransformResults(param1Iterable);
      return this;
    }
    
    public Builder addTransformResults(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((WriteResult)this.instance).addTransformResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder addTransformResults(int param1Int, Value param1Value) {
      copyOnWrite();
      ((WriteResult)this.instance).addTransformResults(param1Int, param1Value);
      return this;
    }
    
    public Builder addTransformResults(Value.Builder param1Builder) {
      copyOnWrite();
      ((WriteResult)this.instance).addTransformResults(param1Builder);
      return this;
    }
    
    public Builder addTransformResults(Value param1Value) {
      copyOnWrite();
      ((WriteResult)this.instance).addTransformResults(param1Value);
      return this;
    }
    
    public Builder clearTransformResults() {
      copyOnWrite();
      ((WriteResult)this.instance).clearTransformResults();
      return this;
    }
    
    public Builder clearUpdateTime() {
      copyOnWrite();
      ((WriteResult)this.instance).clearUpdateTime();
      return this;
    }
    
    public Value getTransformResults(int param1Int) {
      return ((WriteResult)this.instance).getTransformResults(param1Int);
    }
    
    public int getTransformResultsCount() {
      return ((WriteResult)this.instance).getTransformResultsCount();
    }
    
    public List<Value> getTransformResultsList() {
      return Collections.unmodifiableList(((WriteResult)this.instance).getTransformResultsList());
    }
    
    public Timestamp getUpdateTime() {
      return ((WriteResult)this.instance).getUpdateTime();
    }
    
    public boolean hasUpdateTime() {
      return ((WriteResult)this.instance).hasUpdateTime();
    }
    
    public Builder mergeUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteResult)this.instance).mergeUpdateTime(param1Timestamp);
      return this;
    }
    
    public Builder removeTransformResults(int param1Int) {
      copyOnWrite();
      ((WriteResult)this.instance).removeTransformResults(param1Int);
      return this;
    }
    
    public Builder setTransformResults(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((WriteResult)this.instance).setTransformResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder setTransformResults(int param1Int, Value param1Value) {
      copyOnWrite();
      ((WriteResult)this.instance).setTransformResults(param1Int, param1Value);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((WriteResult)this.instance).setUpdateTime(param1Builder);
      return this;
    }
    
    public Builder setUpdateTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((WriteResult)this.instance).setUpdateTime(param1Timestamp);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\WriteResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */