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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class CommitRequest extends GeneratedMessageLite<CommitRequest, CommitRequest.Builder> implements CommitRequestOrBuilder {
  public static final int DATABASE_FIELD_NUMBER = 1;
  
  private static final CommitRequest DEFAULT_INSTANCE = new CommitRequest();
  
  private static volatile Parser<CommitRequest> PARSER;
  
  public static final int TRANSACTION_FIELD_NUMBER = 3;
  
  public static final int WRITES_FIELD_NUMBER = 2;
  
  private int bitField0_;
  
  private String database_ = "";
  
  private ByteString transaction_ = ByteString.EMPTY;
  
  private Internal.ProtobufList<Write> writes_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllWrites(Iterable<? extends Write> paramIterable) {
    ensureWritesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.writes_);
  }
  
  private void addWrites(int paramInt, Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.add(paramInt, paramBuilder.build());
  }
  
  private void addWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.add(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addWrites(Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.add(paramBuilder.build());
  }
  
  private void addWrites(Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.add(paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDatabase() {
    this.database_ = getDefaultInstance().getDatabase();
  }
  
  private void clearTransaction() {
    this.transaction_ = getDefaultInstance().getTransaction();
  }
  
  private void clearWrites() {
    this.writes_ = emptyProtobufList();
  }
  
  private void ensureWritesIsMutable() {
    if (!this.writes_.isModifiable())
      this.writes_ = GeneratedMessageLite.mutableCopy(this.writes_); 
  }
  
  public static CommitRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(CommitRequest paramCommitRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCommitRequest);
  }
  
  public static CommitRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (CommitRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CommitRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static CommitRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static CommitRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static CommitRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static CommitRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static CommitRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static CommitRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (CommitRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<CommitRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeWrites(int paramInt) {
    ensureWritesIsMutable();
    this.writes_.remove(paramInt);
  }
  
  private void setDatabase(String paramString) {
    if (paramString != null) {
      this.database_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDatabaseBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.database_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTransaction(ByteString paramByteString) {
    if (paramByteString != null) {
      this.transaction_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setWrites(int paramInt, Write.Builder paramBuilder) {
    ensureWritesIsMutable();
    this.writes_.set(paramInt, paramBuilder.build());
  }
  
  private void setWrites(int paramInt, Write paramWrite) {
    if (paramWrite != null) {
      ensureWritesIsMutable();
      this.writes_.set(paramInt, paramWrite);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/CommitRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 472, 2 -> 468, 3 -> 457, 4 -> 448, 5 -> 306, 6 -> 118, 7 -> 302, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/CommitRequest.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/CommitRequest
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/CommitRequest.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/CommitRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitRequest;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/CommitRequest.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/CommitRequest
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/CommitRequest
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/CommitRequest.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 302
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 246
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 235
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 188
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 177
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: goto -> 246
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   182: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   185: goto -> 128
    //   188: aload_0
    //   189: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   192: invokeinterface isModifiable : ()Z
    //   197: ifne -> 211
    //   200: aload_0
    //   201: aload_0
    //   202: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   205: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   208: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   211: aload_0
    //   212: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   215: aload_1
    //   216: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   219: aload_2
    //   220: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   223: checkcast com/google/firestore/v1/Write
    //   226: invokeinterface add : (Ljava/lang/Object;)Z
    //   231: pop
    //   232: goto -> 128
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   240: putfield database_ : Ljava/lang/String;
    //   243: goto -> 128
    //   246: iconst_1
    //   247: istore #6
    //   249: goto -> 128
    //   252: astore_1
    //   253: goto -> 300
    //   256: astore_3
    //   257: new java/lang/RuntimeException
    //   260: astore_1
    //   261: new com/google/protobuf/InvalidProtocolBufferException
    //   264: astore_2
    //   265: aload_2
    //   266: aload_3
    //   267: invokevirtual getMessage : ()Ljava/lang/String;
    //   270: invokespecial <init> : (Ljava/lang/String;)V
    //   273: aload_1
    //   274: aload_2
    //   275: aload_0
    //   276: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   279: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: new java/lang/RuntimeException
    //   288: astore_2
    //   289: aload_2
    //   290: aload_1
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_2
    //   299: athrow
    //   300: aload_1
    //   301: athrow
    //   302: getstatic com/google/firestore/v1/CommitRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitRequest;
    //   305: areturn
    //   306: aload_2
    //   307: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   310: astore_1
    //   311: aload_3
    //   312: checkcast com/google/firestore/v1/CommitRequest
    //   315: astore_2
    //   316: aload_0
    //   317: aload_1
    //   318: aload_0
    //   319: getfield database_ : Ljava/lang/String;
    //   322: invokevirtual isEmpty : ()Z
    //   325: iconst_1
    //   326: ixor
    //   327: aload_0
    //   328: getfield database_ : Ljava/lang/String;
    //   331: aload_2
    //   332: getfield database_ : Ljava/lang/String;
    //   335: invokevirtual isEmpty : ()Z
    //   338: iconst_1
    //   339: ixor
    //   340: aload_2
    //   341: getfield database_ : Ljava/lang/String;
    //   344: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   349: putfield database_ : Ljava/lang/String;
    //   352: aload_0
    //   353: aload_1
    //   354: aload_0
    //   355: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   358: aload_2
    //   359: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   362: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   367: putfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   370: aload_0
    //   371: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   374: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   377: if_acmpeq -> 386
    //   380: iconst_1
    //   381: istore #7
    //   383: goto -> 389
    //   386: iconst_0
    //   387: istore #7
    //   389: aload_0
    //   390: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   393: astore_3
    //   394: aload_2
    //   395: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   398: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   401: if_acmpeq -> 407
    //   404: iconst_1
    //   405: istore #5
    //   407: aload_0
    //   408: aload_1
    //   409: iload #7
    //   411: aload_3
    //   412: iload #5
    //   414: aload_2
    //   415: getfield transaction_ : Lcom/google/protobuf/ByteString;
    //   418: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   423: putfield transaction_ : Lcom/google/protobuf/ByteString;
    //   426: aload_1
    //   427: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   430: if_acmpne -> 446
    //   433: aload_0
    //   434: aload_0
    //   435: getfield bitField0_ : I
    //   438: aload_2
    //   439: getfield bitField0_ : I
    //   442: ior
    //   443: putfield bitField0_ : I
    //   446: aload_0
    //   447: areturn
    //   448: new com/google/firestore/v1/CommitRequest$Builder
    //   451: dup
    //   452: aconst_null
    //   453: invokespecial <init> : (Lcom/google/firestore/v1/CommitRequest$1;)V
    //   456: areturn
    //   457: aload_0
    //   458: getfield writes_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   461: invokeinterface makeImmutable : ()V
    //   466: aconst_null
    //   467: areturn
    //   468: getstatic com/google/firestore/v1/CommitRequest.DEFAULT_INSTANCE : Lcom/google/firestore/v1/CommitRequest;
    //   471: areturn
    //   472: new com/google/firestore/v1/CommitRequest
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	284	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	256	java/io/IOException
    //   133	139	252	finally
    //   165	174	284	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	256	java/io/IOException
    //   165	174	252	finally
    //   177	185	284	com/google/protobuf/InvalidProtocolBufferException
    //   177	185	256	java/io/IOException
    //   177	185	252	finally
    //   188	211	284	com/google/protobuf/InvalidProtocolBufferException
    //   188	211	256	java/io/IOException
    //   188	211	252	finally
    //   211	232	284	com/google/protobuf/InvalidProtocolBufferException
    //   211	232	256	java/io/IOException
    //   211	232	252	finally
    //   235	243	284	com/google/protobuf/InvalidProtocolBufferException
    //   235	243	256	java/io/IOException
    //   235	243	252	finally
    //   257	284	252	finally
    //   285	300	252	finally
  }
  
  public String getDatabase() {
    return this.database_;
  }
  
  public ByteString getDatabaseBytes() {
    return ByteString.copyFromUtf8(this.database_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.database_.isEmpty();
    int j = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getDatabase()) + 0;
    } else {
      i = 0;
    } 
    while (j < this.writes_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.writes_.get(j));
      j++;
    } 
    j = i;
    if (!this.transaction_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(3, this.transaction_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public ByteString getTransaction() {
    return this.transaction_;
  }
  
  public Write getWrites(int paramInt) {
    return (Write)this.writes_.get(paramInt);
  }
  
  public int getWritesCount() {
    return this.writes_.size();
  }
  
  public List<Write> getWritesList() {
    return (List<Write>)this.writes_;
  }
  
  public WriteOrBuilder getWritesOrBuilder(int paramInt) {
    return (WriteOrBuilder)this.writes_.get(paramInt);
  }
  
  public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
    return (List)this.writes_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.database_.isEmpty())
      paramCodedOutputStream.writeString(1, getDatabase()); 
    for (byte b = 0; b < this.writes_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.writes_.get(b)); 
    if (!this.transaction_.isEmpty())
      paramCodedOutputStream.writeBytes(3, this.transaction_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CommitRequest, Builder> implements CommitRequestOrBuilder {
    private Builder() {
      super(CommitRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllWrites(Iterable<? extends Write> param1Iterable) {
      copyOnWrite();
      ((CommitRequest)this.instance).addAllWrites(param1Iterable);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((CommitRequest)this.instance).addWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder addWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((CommitRequest)this.instance).addWrites(param1Int, param1Write);
      return this;
    }
    
    public Builder addWrites(Write.Builder param1Builder) {
      copyOnWrite();
      ((CommitRequest)this.instance).addWrites(param1Builder);
      return this;
    }
    
    public Builder addWrites(Write param1Write) {
      copyOnWrite();
      ((CommitRequest)this.instance).addWrites(param1Write);
      return this;
    }
    
    public Builder clearDatabase() {
      copyOnWrite();
      ((CommitRequest)this.instance).clearDatabase();
      return this;
    }
    
    public Builder clearTransaction() {
      copyOnWrite();
      ((CommitRequest)this.instance).clearTransaction();
      return this;
    }
    
    public Builder clearWrites() {
      copyOnWrite();
      ((CommitRequest)this.instance).clearWrites();
      return this;
    }
    
    public String getDatabase() {
      return ((CommitRequest)this.instance).getDatabase();
    }
    
    public ByteString getDatabaseBytes() {
      return ((CommitRequest)this.instance).getDatabaseBytes();
    }
    
    public ByteString getTransaction() {
      return ((CommitRequest)this.instance).getTransaction();
    }
    
    public Write getWrites(int param1Int) {
      return ((CommitRequest)this.instance).getWrites(param1Int);
    }
    
    public int getWritesCount() {
      return ((CommitRequest)this.instance).getWritesCount();
    }
    
    public List<Write> getWritesList() {
      return Collections.unmodifiableList(((CommitRequest)this.instance).getWritesList());
    }
    
    public Builder removeWrites(int param1Int) {
      copyOnWrite();
      ((CommitRequest)this.instance).removeWrites(param1Int);
      return this;
    }
    
    public Builder setDatabase(String param1String) {
      copyOnWrite();
      ((CommitRequest)this.instance).setDatabase(param1String);
      return this;
    }
    
    public Builder setDatabaseBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((CommitRequest)this.instance).setDatabaseBytes(param1ByteString);
      return this;
    }
    
    public Builder setTransaction(ByteString param1ByteString) {
      copyOnWrite();
      ((CommitRequest)this.instance).setTransaction(param1ByteString);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write.Builder param1Builder) {
      copyOnWrite();
      ((CommitRequest)this.instance).setWrites(param1Int, param1Builder);
      return this;
    }
    
    public Builder setWrites(int param1Int, Write param1Write) {
      copyOnWrite();
      ((CommitRequest)this.instance).setWrites(param1Int, param1Write);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\CommitRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */