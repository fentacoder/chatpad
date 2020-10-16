package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class MutationQueue extends GeneratedMessageLite<MutationQueue, MutationQueue.Builder> implements MutationQueueOrBuilder {
  private static final MutationQueue DEFAULT_INSTANCE = new MutationQueue();
  
  public static final int LAST_ACKNOWLEDGED_BATCH_ID_FIELD_NUMBER = 1;
  
  public static final int LAST_STREAM_TOKEN_FIELD_NUMBER = 2;
  
  private static volatile Parser<MutationQueue> PARSER;
  
  private int lastAcknowledgedBatchId_;
  
  private ByteString lastStreamToken_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearLastAcknowledgedBatchId() {
    this.lastAcknowledgedBatchId_ = 0;
  }
  
  private void clearLastStreamToken() {
    this.lastStreamToken_ = getDefaultInstance().getLastStreamToken();
  }
  
  public static MutationQueue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MutationQueue paramMutationQueue) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMutationQueue);
  }
  
  public static MutationQueue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MutationQueue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MutationQueue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MutationQueue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MutationQueue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MutationQueue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MutationQueue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MutationQueue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MutationQueue parseFrom(InputStream paramInputStream) throws IOException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MutationQueue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MutationQueue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MutationQueue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MutationQueue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MutationQueue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setLastAcknowledgedBatchId(int paramInt) {
    this.lastAcknowledgedBatchId_ = paramInt;
  }
  
  private void setLastStreamToken(ByteString paramByteString) {
    if (paramByteString != null) {
      this.lastStreamToken_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/MutationQueue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 401, 2 -> 397, 3 -> 395, 4 -> 386, 5 -> 252, 6 -> 118, 7 -> 248, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firebase/firestore/proto/MutationQueue.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firebase/firestore/proto/MutationQueue
    //   80: monitorenter
    //   81: getstatic com/google/firebase/firestore/proto/MutationQueue.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firebase/firestore/proto/MutationQueue.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MutationQueue;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firebase/firestore/proto/MutationQueue.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firebase/firestore/proto/MutationQueue
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firebase/firestore/proto/MutationQueue
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firebase/firestore/proto/MutationQueue.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 248
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 192
    //   144: iload #4
    //   146: bipush #8
    //   148: if_icmpeq -> 181
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 170
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: goto -> 192
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   175: putfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   178: goto -> 128
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual readInt32 : ()I
    //   186: putfield lastAcknowledgedBatchId_ : I
    //   189: goto -> 128
    //   192: iconst_1
    //   193: istore #6
    //   195: goto -> 128
    //   198: astore_1
    //   199: goto -> 246
    //   202: astore_2
    //   203: new java/lang/RuntimeException
    //   206: astore_3
    //   207: new com/google/protobuf/InvalidProtocolBufferException
    //   210: astore_1
    //   211: aload_1
    //   212: aload_2
    //   213: invokevirtual getMessage : ()Ljava/lang/String;
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: aload_3
    //   220: aload_1
    //   221: aload_0
    //   222: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   225: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   228: aload_3
    //   229: athrow
    //   230: astore_2
    //   231: new java/lang/RuntimeException
    //   234: astore_1
    //   235: aload_1
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_1
    //   245: athrow
    //   246: aload_1
    //   247: athrow
    //   248: getstatic com/google/firebase/firestore/proto/MutationQueue.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MutationQueue;
    //   251: areturn
    //   252: aload_2
    //   253: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   256: astore_1
    //   257: aload_3
    //   258: checkcast com/google/firebase/firestore/proto/MutationQueue
    //   261: astore_2
    //   262: aload_0
    //   263: getfield lastAcknowledgedBatchId_ : I
    //   266: ifeq -> 275
    //   269: iconst_1
    //   270: istore #7
    //   272: goto -> 278
    //   275: iconst_0
    //   276: istore #7
    //   278: aload_0
    //   279: getfield lastAcknowledgedBatchId_ : I
    //   282: istore #6
    //   284: aload_2
    //   285: getfield lastAcknowledgedBatchId_ : I
    //   288: ifeq -> 297
    //   291: iconst_1
    //   292: istore #8
    //   294: goto -> 300
    //   297: iconst_0
    //   298: istore #8
    //   300: aload_0
    //   301: aload_1
    //   302: iload #7
    //   304: iload #6
    //   306: iload #8
    //   308: aload_2
    //   309: getfield lastAcknowledgedBatchId_ : I
    //   312: invokeinterface visitInt : (ZIZI)I
    //   317: putfield lastAcknowledgedBatchId_ : I
    //   320: aload_0
    //   321: getfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   324: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   327: if_acmpeq -> 336
    //   330: iconst_1
    //   331: istore #7
    //   333: goto -> 339
    //   336: iconst_0
    //   337: istore #7
    //   339: aload_0
    //   340: getfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   343: astore_3
    //   344: iload #5
    //   346: istore #8
    //   348: aload_2
    //   349: getfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   352: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   355: if_acmpeq -> 361
    //   358: iconst_1
    //   359: istore #8
    //   361: aload_0
    //   362: aload_1
    //   363: iload #7
    //   365: aload_3
    //   366: iload #8
    //   368: aload_2
    //   369: getfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   372: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   377: putfield lastStreamToken_ : Lcom/google/protobuf/ByteString;
    //   380: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   383: astore_1
    //   384: aload_0
    //   385: areturn
    //   386: new com/google/firebase/firestore/proto/MutationQueue$Builder
    //   389: dup
    //   390: aconst_null
    //   391: invokespecial <init> : (Lcom/google/firebase/firestore/proto/MutationQueue$1;)V
    //   394: areturn
    //   395: aconst_null
    //   396: areturn
    //   397: getstatic com/google/firebase/firestore/proto/MutationQueue.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/MutationQueue;
    //   400: areturn
    //   401: new com/google/firebase/firestore/proto/MutationQueue
    //   404: dup
    //   405: invokespecial <init> : ()V
    //   408: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	230	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	202	java/io/IOException
    //   133	139	198	finally
    //   158	167	230	com/google/protobuf/InvalidProtocolBufferException
    //   158	167	202	java/io/IOException
    //   158	167	198	finally
    //   170	178	230	com/google/protobuf/InvalidProtocolBufferException
    //   170	178	202	java/io/IOException
    //   170	178	198	finally
    //   181	189	230	com/google/protobuf/InvalidProtocolBufferException
    //   181	189	202	java/io/IOException
    //   181	189	198	finally
    //   203	230	198	finally
    //   231	246	198	finally
  }
  
  public int getLastAcknowledgedBatchId() {
    return this.lastAcknowledgedBatchId_;
  }
  
  public ByteString getLastStreamToken() {
    return this.lastStreamToken_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.lastAcknowledgedBatchId_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    j = i;
    if (!this.lastStreamToken_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(2, this.lastStreamToken_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.lastAcknowledgedBatchId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!this.lastStreamToken_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.lastStreamToken_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MutationQueue, Builder> implements MutationQueueOrBuilder {
    private Builder() {
      super(MutationQueue.DEFAULT_INSTANCE);
    }
    
    public Builder clearLastAcknowledgedBatchId() {
      copyOnWrite();
      ((MutationQueue)this.instance).clearLastAcknowledgedBatchId();
      return this;
    }
    
    public Builder clearLastStreamToken() {
      copyOnWrite();
      ((MutationQueue)this.instance).clearLastStreamToken();
      return this;
    }
    
    public int getLastAcknowledgedBatchId() {
      return ((MutationQueue)this.instance).getLastAcknowledgedBatchId();
    }
    
    public ByteString getLastStreamToken() {
      return ((MutationQueue)this.instance).getLastStreamToken();
    }
    
    public Builder setLastAcknowledgedBatchId(int param1Int) {
      copyOnWrite();
      ((MutationQueue)this.instance).setLastAcknowledgedBatchId(param1Int);
      return this;
    }
    
    public Builder setLastStreamToken(ByteString param1ByteString) {
      copyOnWrite();
      ((MutationQueue)this.instance).setLastStreamToken(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\MutationQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */