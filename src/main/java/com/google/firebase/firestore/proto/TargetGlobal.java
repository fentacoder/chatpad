package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;

public final class TargetGlobal extends GeneratedMessageLite<TargetGlobal, TargetGlobal.Builder> implements TargetGlobalOrBuilder {
  private static final TargetGlobal DEFAULT_INSTANCE = new TargetGlobal();
  
  public static final int HIGHEST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
  
  public static final int HIGHEST_TARGET_ID_FIELD_NUMBER = 1;
  
  public static final int LAST_REMOTE_SNAPSHOT_VERSION_FIELD_NUMBER = 3;
  
  private static volatile Parser<TargetGlobal> PARSER;
  
  public static final int TARGET_COUNT_FIELD_NUMBER = 4;
  
  private long highestListenSequenceNumber_;
  
  private int highestTargetId_;
  
  private Timestamp lastRemoteSnapshotVersion_;
  
  private int targetCount_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearHighestListenSequenceNumber() {
    this.highestListenSequenceNumber_ = 0L;
  }
  
  private void clearHighestTargetId() {
    this.highestTargetId_ = 0;
  }
  
  private void clearLastRemoteSnapshotVersion() {
    this.lastRemoteSnapshotVersion_ = null;
  }
  
  private void clearTargetCount() {
    this.targetCount_ = 0;
  }
  
  public static TargetGlobal getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeLastRemoteSnapshotVersion(Timestamp paramTimestamp) {
    Timestamp timestamp = this.lastRemoteSnapshotVersion_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.lastRemoteSnapshotVersion_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.lastRemoteSnapshotVersion_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.lastRemoteSnapshotVersion_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(TargetGlobal paramTargetGlobal) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramTargetGlobal);
  }
  
  public static TargetGlobal parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (TargetGlobal)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TargetGlobal parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetGlobal)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetGlobal parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static TargetGlobal parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static TargetGlobal parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static TargetGlobal parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetGlobal parseFrom(InputStream paramInputStream) throws IOException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static TargetGlobal parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static TargetGlobal parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static TargetGlobal parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (TargetGlobal)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<TargetGlobal> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setHighestListenSequenceNumber(long paramLong) {
    this.highestListenSequenceNumber_ = paramLong;
  }
  
  private void setHighestTargetId(int paramInt) {
    this.highestTargetId_ = paramInt;
  }
  
  private void setLastRemoteSnapshotVersion(Timestamp.Builder paramBuilder) {
    this.lastRemoteSnapshotVersion_ = (Timestamp)paramBuilder.build();
  }
  
  private void setLastRemoteSnapshotVersion(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.lastRemoteSnapshotVersion_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTargetCount(int paramInt) {
    this.targetCount_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/TargetGlobal$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 570, 2 -> 566, 3 -> 564, 4 -> 555, 5 -> 342, 6 -> 118, 7 -> 338, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firebase/firestore/proto/TargetGlobal.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firebase/firestore/proto/TargetGlobal
    //   80: monitorenter
    //   81: getstatic com/google/firebase/firestore/proto/TargetGlobal.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firebase/firestore/proto/TargetGlobal.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/TargetGlobal;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firebase/firestore/proto/TargetGlobal.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firebase/firestore/proto/TargetGlobal
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firebase/firestore/proto/TargetGlobal
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firebase/firestore/proto/TargetGlobal.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
    //   148: if_icmpeq -> 271
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 260
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 195
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 184
    //   172: aload_2
    //   173: iload #4
    //   175: invokevirtual skipField : (I)Z
    //   178: ifne -> 128
    //   181: goto -> 282
    //   184: aload_0
    //   185: aload_2
    //   186: invokevirtual readInt32 : ()I
    //   189: putfield targetCount_ : I
    //   192: goto -> 128
    //   195: aload_0
    //   196: getfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   199: ifnull -> 216
    //   202: aload_0
    //   203: getfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   206: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   209: checkcast com/google/protobuf/Timestamp$Builder
    //   212: astore_1
    //   213: goto -> 218
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_0
    //   219: aload_2
    //   220: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   223: aload_3
    //   224: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   227: checkcast com/google/protobuf/Timestamp
    //   230: putfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   233: aload_1
    //   234: ifnull -> 128
    //   237: aload_1
    //   238: aload_0
    //   239: getfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   242: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   245: pop
    //   246: aload_0
    //   247: aload_1
    //   248: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   251: checkcast com/google/protobuf/Timestamp
    //   254: putfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   257: goto -> 128
    //   260: aload_0
    //   261: aload_2
    //   262: invokevirtual readInt64 : ()J
    //   265: putfield highestListenSequenceNumber_ : J
    //   268: goto -> 128
    //   271: aload_0
    //   272: aload_2
    //   273: invokevirtual readInt32 : ()I
    //   276: putfield highestTargetId_ : I
    //   279: goto -> 128
    //   282: iconst_1
    //   283: istore #6
    //   285: goto -> 128
    //   288: astore_1
    //   289: goto -> 336
    //   292: astore_3
    //   293: new java/lang/RuntimeException
    //   296: astore_2
    //   297: new com/google/protobuf/InvalidProtocolBufferException
    //   300: astore_1
    //   301: aload_1
    //   302: aload_3
    //   303: invokevirtual getMessage : ()Ljava/lang/String;
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: aload_2
    //   310: aload_1
    //   311: aload_0
    //   312: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   315: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   318: aload_2
    //   319: athrow
    //   320: astore_2
    //   321: new java/lang/RuntimeException
    //   324: astore_1
    //   325: aload_1
    //   326: aload_2
    //   327: aload_0
    //   328: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   331: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   334: aload_1
    //   335: athrow
    //   336: aload_1
    //   337: athrow
    //   338: getstatic com/google/firebase/firestore/proto/TargetGlobal.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/TargetGlobal;
    //   341: areturn
    //   342: aload_2
    //   343: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   346: astore_1
    //   347: aload_3
    //   348: checkcast com/google/firebase/firestore/proto/TargetGlobal
    //   351: astore_2
    //   352: aload_0
    //   353: getfield highestTargetId_ : I
    //   356: ifeq -> 365
    //   359: iconst_1
    //   360: istore #7
    //   362: goto -> 368
    //   365: iconst_0
    //   366: istore #7
    //   368: aload_0
    //   369: getfield highestTargetId_ : I
    //   372: istore #6
    //   374: aload_2
    //   375: getfield highestTargetId_ : I
    //   378: ifeq -> 387
    //   381: iconst_1
    //   382: istore #8
    //   384: goto -> 390
    //   387: iconst_0
    //   388: istore #8
    //   390: aload_0
    //   391: aload_1
    //   392: iload #7
    //   394: iload #6
    //   396: iload #8
    //   398: aload_2
    //   399: getfield highestTargetId_ : I
    //   402: invokeinterface visitInt : (ZIZI)I
    //   407: putfield highestTargetId_ : I
    //   410: aload_0
    //   411: getfield highestListenSequenceNumber_ : J
    //   414: lconst_0
    //   415: lcmp
    //   416: ifeq -> 425
    //   419: iconst_1
    //   420: istore #7
    //   422: goto -> 428
    //   425: iconst_0
    //   426: istore #7
    //   428: aload_0
    //   429: getfield highestListenSequenceNumber_ : J
    //   432: lstore #9
    //   434: aload_2
    //   435: getfield highestListenSequenceNumber_ : J
    //   438: lconst_0
    //   439: lcmp
    //   440: ifeq -> 449
    //   443: iconst_1
    //   444: istore #8
    //   446: goto -> 452
    //   449: iconst_0
    //   450: istore #8
    //   452: aload_0
    //   453: aload_1
    //   454: iload #7
    //   456: lload #9
    //   458: iload #8
    //   460: aload_2
    //   461: getfield highestListenSequenceNumber_ : J
    //   464: invokeinterface visitLong : (ZJZJ)J
    //   469: putfield highestListenSequenceNumber_ : J
    //   472: aload_0
    //   473: aload_1
    //   474: aload_0
    //   475: getfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   478: aload_2
    //   479: getfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   482: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   487: checkcast com/google/protobuf/Timestamp
    //   490: putfield lastRemoteSnapshotVersion_ : Lcom/google/protobuf/Timestamp;
    //   493: aload_0
    //   494: getfield targetCount_ : I
    //   497: ifeq -> 506
    //   500: iconst_1
    //   501: istore #7
    //   503: goto -> 509
    //   506: iconst_0
    //   507: istore #7
    //   509: aload_0
    //   510: getfield targetCount_ : I
    //   513: istore #6
    //   515: iload #5
    //   517: istore #8
    //   519: aload_2
    //   520: getfield targetCount_ : I
    //   523: ifeq -> 529
    //   526: iconst_1
    //   527: istore #8
    //   529: aload_0
    //   530: aload_1
    //   531: iload #7
    //   533: iload #6
    //   535: iload #8
    //   537: aload_2
    //   538: getfield targetCount_ : I
    //   541: invokeinterface visitInt : (ZIZI)I
    //   546: putfield targetCount_ : I
    //   549: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   552: astore_1
    //   553: aload_0
    //   554: areturn
    //   555: new com/google/firebase/firestore/proto/TargetGlobal$Builder
    //   558: dup
    //   559: aconst_null
    //   560: invokespecial <init> : (Lcom/google/firebase/firestore/proto/TargetGlobal$1;)V
    //   563: areturn
    //   564: aconst_null
    //   565: areturn
    //   566: getstatic com/google/firebase/firestore/proto/TargetGlobal.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/TargetGlobal;
    //   569: areturn
    //   570: new com/google/firebase/firestore/proto/TargetGlobal
    //   573: dup
    //   574: invokespecial <init> : ()V
    //   577: areturn
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
    //   184	192	320	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	292	java/io/IOException
    //   184	192	288	finally
    //   195	213	320	com/google/protobuf/InvalidProtocolBufferException
    //   195	213	292	java/io/IOException
    //   195	213	288	finally
    //   218	233	320	com/google/protobuf/InvalidProtocolBufferException
    //   218	233	292	java/io/IOException
    //   218	233	288	finally
    //   237	257	320	com/google/protobuf/InvalidProtocolBufferException
    //   237	257	292	java/io/IOException
    //   237	257	288	finally
    //   260	268	320	com/google/protobuf/InvalidProtocolBufferException
    //   260	268	292	java/io/IOException
    //   260	268	288	finally
    //   271	279	320	com/google/protobuf/InvalidProtocolBufferException
    //   271	279	292	java/io/IOException
    //   271	279	288	finally
    //   293	320	288	finally
    //   321	336	288	finally
  }
  
  public long getHighestListenSequenceNumber() {
    return this.highestListenSequenceNumber_;
  }
  
  public int getHighestTargetId() {
    return this.highestTargetId_;
  }
  
  public Timestamp getLastRemoteSnapshotVersion() {
    Timestamp timestamp1 = this.lastRemoteSnapshotVersion_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.highestTargetId_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    long l = this.highestListenSequenceNumber_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(2, l); 
    i = j;
    if (this.lastRemoteSnapshotVersion_ != null)
      i = j + CodedOutputStream.computeMessageSize(3, (MessageLite)getLastRemoteSnapshotVersion()); 
    int k = this.targetCount_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(4, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getTargetCount() {
    return this.targetCount_;
  }
  
  public boolean hasLastRemoteSnapshotVersion() {
    boolean bool;
    if (this.lastRemoteSnapshotVersion_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.highestTargetId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    long l = this.highestListenSequenceNumber_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
    if (this.lastRemoteSnapshotVersion_ != null)
      paramCodedOutputStream.writeMessage(3, (MessageLite)getLastRemoteSnapshotVersion()); 
    i = this.targetCount_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(4, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<TargetGlobal, Builder> implements TargetGlobalOrBuilder {
    private Builder() {
      super(TargetGlobal.DEFAULT_INSTANCE);
    }
    
    public Builder clearHighestListenSequenceNumber() {
      copyOnWrite();
      ((TargetGlobal)this.instance).clearHighestListenSequenceNumber();
      return this;
    }
    
    public Builder clearHighestTargetId() {
      copyOnWrite();
      ((TargetGlobal)this.instance).clearHighestTargetId();
      return this;
    }
    
    public Builder clearLastRemoteSnapshotVersion() {
      copyOnWrite();
      ((TargetGlobal)this.instance).clearLastRemoteSnapshotVersion();
      return this;
    }
    
    public Builder clearTargetCount() {
      copyOnWrite();
      ((TargetGlobal)this.instance).clearTargetCount();
      return this;
    }
    
    public long getHighestListenSequenceNumber() {
      return ((TargetGlobal)this.instance).getHighestListenSequenceNumber();
    }
    
    public int getHighestTargetId() {
      return ((TargetGlobal)this.instance).getHighestTargetId();
    }
    
    public Timestamp getLastRemoteSnapshotVersion() {
      return ((TargetGlobal)this.instance).getLastRemoteSnapshotVersion();
    }
    
    public int getTargetCount() {
      return ((TargetGlobal)this.instance).getTargetCount();
    }
    
    public boolean hasLastRemoteSnapshotVersion() {
      return ((TargetGlobal)this.instance).hasLastRemoteSnapshotVersion();
    }
    
    public Builder mergeLastRemoteSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TargetGlobal)this.instance).mergeLastRemoteSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder setHighestListenSequenceNumber(long param1Long) {
      copyOnWrite();
      ((TargetGlobal)this.instance).setHighestListenSequenceNumber(param1Long);
      return this;
    }
    
    public Builder setHighestTargetId(int param1Int) {
      copyOnWrite();
      ((TargetGlobal)this.instance).setHighestTargetId(param1Int);
      return this;
    }
    
    public Builder setLastRemoteSnapshotVersion(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((TargetGlobal)this.instance).setLastRemoteSnapshotVersion(param1Builder);
      return this;
    }
    
    public Builder setLastRemoteSnapshotVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((TargetGlobal)this.instance).setLastRemoteSnapshotVersion(param1Timestamp);
      return this;
    }
    
    public Builder setTargetCount(int param1Int) {
      copyOnWrite();
      ((TargetGlobal)this.instance).setTargetCount(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\TargetGlobal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */