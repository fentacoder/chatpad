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

public final class CommitResponse extends GeneratedMessageLite<CommitResponse, CommitResponse.Builder> implements CommitResponseOrBuilder {
  public static final int COMMIT_TIME_FIELD_NUMBER = 2;
  
  private static final CommitResponse DEFAULT_INSTANCE = new CommitResponse();
  
  private static volatile Parser<CommitResponse> PARSER;
  
  public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private Timestamp commitTime_;
  
  private Internal.ProtobufList<WriteResult> writeResults_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllWriteResults(Iterable<? extends WriteResult> paramIterable) {
    ensureWriteResultsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.writeResults_);
  }
  
  private void addWriteResults(int paramInt, WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.add(paramInt, paramBuilder.build());
  }
  
  private void addWriteResults(int paramInt, WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.add(paramInt, paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addWriteResults(WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.add(paramBuilder.build());
  }
  
  private void addWriteResults(WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.add(paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCommitTime() {
    this.commitTime_ = null;
  }
  
  private void clearWriteResults() {
    this.writeResults_ = emptyProtobufList();
  }
  
  private void ensureWriteResultsIsMutable() {
    if (!this.writeResults_.isModifiable())
      this.writeResults_ = GeneratedMessageLite.mutableCopy(this.writeResults_); 
  }
  
  public static CommitResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeCommitTime(Timestamp paramTimestamp) {
    Timestamp timestamp = this.commitTime_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.commitTime_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.commitTime_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.commitTime_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CommitResponse paramCommitResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCommitResponse);
  }
  
  public static CommitResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CommitResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CommitResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CommitResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CommitResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CommitResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CommitResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CommitResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CommitResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CommitResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeWriteResults(int paramInt) {
    ensureWriteResultsIsMutable();
    this.writeResults_.remove(paramInt);
  }
  
  private void setCommitTime(Timestamp.Builder paramBuilder) {
    this.commitTime_ = (Timestamp)paramBuilder.build();
  }
  
  private void setCommitTime(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.commitTime_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setWriteResults(int paramInt, WriteResult.Builder paramBuilder) {
    ensureWriteResultsIsMutable();
    this.writeResults_.set(paramInt, paramBuilder.build());
  }
  
  private void setWriteResults(int paramInt, WriteResult paramWriteResult) {
    if (paramWriteResult != null) {
      ensureWriteResultsIsMutable();
      this.writeResults_.set(paramInt, paramWriteResult);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/CommitResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 432, 2 -> 428, 3 -> 417, 4 -> 408, 5 -> 337, 6 -> 110, 7 -> 333, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/CommitResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/CommitResponse
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/CommitResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/CommitResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/CommitResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/CommitResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/CommitResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/CommitResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   143: if_icmpeq -> 230
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 165
    //   153: aload_2
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 277
    //   165: aload_0
    //   166: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   169: ifnull -> 186
    //   172: aload_0
    //   173: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   176: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   179: checkcast com/google/protobuf/Timestamp$Builder
    //   182: astore_1
    //   183: goto -> 188
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_0
    //   189: aload_2
    //   190: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   193: aload_3
    //   194: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   197: checkcast com/google/protobuf/Timestamp
    //   200: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   203: aload_1
    //   204: ifnull -> 123
    //   207: aload_1
    //   208: aload_0
    //   209: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   212: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   215: pop
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   221: checkcast com/google/protobuf/Timestamp
    //   224: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   227: goto -> 123
    //   230: aload_0
    //   231: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   234: invokeinterface isModifiable : ()Z
    //   239: ifne -> 253
    //   242: aload_0
    //   243: aload_0
    //   244: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   247: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   250: putfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   253: aload_0
    //   254: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   257: aload_2
    //   258: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   261: aload_3
    //   262: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   265: checkcast com/google/firestore/v1/WriteResult
    //   268: invokeinterface add : (Ljava/lang/Object;)Z
    //   273: pop
    //   274: goto -> 123
    //   277: iconst_1
    //   278: istore #4
    //   280: goto -> 123
    //   283: astore_1
    //   284: goto -> 331
    //   287: astore_3
    //   288: new java/lang/RuntimeException
    //   291: astore_1
    //   292: new com/google/protobuf/InvalidProtocolBufferException
    //   295: astore_2
    //   296: aload_2
    //   297: aload_3
    //   298: invokevirtual getMessage : ()Ljava/lang/String;
    //   301: invokespecial <init> : (Ljava/lang/String;)V
    //   304: aload_1
    //   305: aload_2
    //   306: aload_0
    //   307: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   310: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   313: aload_1
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
    //   333: getstatic com/google/firestore/v1/CommitResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitResponse;
    //   336: areturn
    //   337: aload_2
    //   338: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   341: astore_1
    //   342: aload_3
    //   343: checkcast com/google/firestore/v1/CommitResponse
    //   346: astore_2
    //   347: aload_0
    //   348: aload_1
    //   349: aload_0
    //   350: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   353: aload_2
    //   354: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   357: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   362: putfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   365: aload_0
    //   366: aload_1
    //   367: aload_0
    //   368: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   371: aload_2
    //   372: getfield commitTime_ : Lcom/google/protobuf/Timestamp;
    //   375: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   380: checkcast com/google/protobuf/Timestamp
    //   383: putfield commitTime_ : Lcom/google/protobuf/Timestamp;
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
    //   408: new com/google/firestore/v1/CommitResponse$Builder
    //   411: dup
    //   412: aconst_null
    //   413: invokespecial <init> : (Lcom/google/firestore/v1/CommitResponse$1;)V
    //   416: areturn
    //   417: aload_0
    //   418: getfield writeResults_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   421: invokeinterface makeImmutable : ()V
    //   426: aconst_null
    //   427: areturn
    //   428: getstatic com/google/firestore/v1/CommitResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitResponse;
    //   431: areturn
    //   432: new com/google/firestore/v1/CommitResponse
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
    //   165	183	315	com/google/protobuf/InvalidProtocolBufferException
    //   165	183	287	java/io/IOException
    //   165	183	283	finally
    //   188	203	315	com/google/protobuf/InvalidProtocolBufferException
    //   188	203	287	java/io/IOException
    //   188	203	283	finally
    //   207	227	315	com/google/protobuf/InvalidProtocolBufferException
    //   207	227	287	java/io/IOException
    //   207	227	283	finally
    //   230	253	315	com/google/protobuf/InvalidProtocolBufferException
    //   230	253	287	java/io/IOException
    //   230	253	283	finally
    //   253	274	315	com/google/protobuf/InvalidProtocolBufferException
    //   253	274	287	java/io/IOException
    //   253	274	283	finally
    //   288	315	283	finally
    //   316	331	283	finally
  }
  
  public Timestamp getCommitTime() {
    Timestamp timestamp1 = this.commitTime_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.writeResults_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.writeResults_.get(j));
      j++;
    } 
    j = i;
    if (this.commitTime_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getCommitTime()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public WriteResult getWriteResults(int paramInt) {
    return (WriteResult)this.writeResults_.get(paramInt);
  }
  
  public int getWriteResultsCount() {
    return this.writeResults_.size();
  }
  
  public List<WriteResult> getWriteResultsList() {
    return (List<WriteResult>)this.writeResults_;
  }
  
  public WriteResultOrBuilder getWriteResultsOrBuilder(int paramInt) {
    return (WriteResultOrBuilder)this.writeResults_.get(paramInt);
  }
  
  public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
    return (List)this.writeResults_;
  }
  
  public boolean hasCommitTime() {
    boolean bool;
    if (this.commitTime_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.writeResults_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.writeResults_.get(b)); 
    if (this.commitTime_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getCommitTime()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CommitResponse, Builder> implements CommitResponseOrBuilder {
    private Builder() {
      super(CommitResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllWriteResults(Iterable<? extends WriteResult> param1Iterable) {
      copyOnWrite();
      ((CommitResponse)this.instance).addAllWriteResults(param1Iterable);
      return this;
    }
    
    public Builder addWriteResults(int param1Int, WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((CommitResponse)this.instance).addWriteResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder addWriteResults(int param1Int, WriteResult param1WriteResult) {
      copyOnWrite();
      ((CommitResponse)this.instance).addWriteResults(param1Int, param1WriteResult);
      return this;
    }
    
    public Builder addWriteResults(WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((CommitResponse)this.instance).addWriteResults(param1Builder);
      return this;
    }
    
    public Builder addWriteResults(WriteResult param1WriteResult) {
      copyOnWrite();
      ((CommitResponse)this.instance).addWriteResults(param1WriteResult);
      return this;
    }
    
    public Builder clearCommitTime() {
      copyOnWrite();
      ((CommitResponse)this.instance).clearCommitTime();
      return this;
    }
    
    public Builder clearWriteResults() {
      copyOnWrite();
      ((CommitResponse)this.instance).clearWriteResults();
      return this;
    }
    
    public Timestamp getCommitTime() {
      return ((CommitResponse)this.instance).getCommitTime();
    }
    
    public WriteResult getWriteResults(int param1Int) {
      return ((CommitResponse)this.instance).getWriteResults(param1Int);
    }
    
    public int getWriteResultsCount() {
      return ((CommitResponse)this.instance).getWriteResultsCount();
    }
    
    public List<WriteResult> getWriteResultsList() {
      return Collections.unmodifiableList(((CommitResponse)this.instance).getWriteResultsList());
    }
    
    public boolean hasCommitTime() {
      return ((CommitResponse)this.instance).hasCommitTime();
    }
    
    public Builder mergeCommitTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CommitResponse)this.instance).mergeCommitTime(param1Timestamp);
      return this;
    }
    
    public Builder removeWriteResults(int param1Int) {
      copyOnWrite();
      ((CommitResponse)this.instance).removeWriteResults(param1Int);
      return this;
    }
    
    public Builder setCommitTime(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((CommitResponse)this.instance).setCommitTime(param1Builder);
      return this;
    }
    
    public Builder setCommitTime(Timestamp param1Timestamp) {
      copyOnWrite();
      ((CommitResponse)this.instance).setCommitTime(param1Timestamp);
      return this;
    }
    
    public Builder setWriteResults(int param1Int, WriteResult.Builder param1Builder) {
      copyOnWrite();
      ((CommitResponse)this.instance).setWriteResults(param1Int, param1Builder);
      return this;
    }
    
    public Builder setWriteResults(int param1Int, WriteResult param1WriteResult) {
      copyOnWrite();
      ((CommitResponse)this.instance).setWriteResults(param1Int, param1WriteResult);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\CommitResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */