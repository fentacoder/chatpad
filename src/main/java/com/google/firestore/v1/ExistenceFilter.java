package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ExistenceFilter extends GeneratedMessageLite<ExistenceFilter, ExistenceFilter.Builder> implements ExistenceFilterOrBuilder {
  public static final int COUNT_FIELD_NUMBER = 2;
  
  private static final ExistenceFilter DEFAULT_INSTANCE = new ExistenceFilter();
  
  private static volatile Parser<ExistenceFilter> PARSER;
  
  public static final int TARGET_ID_FIELD_NUMBER = 1;
  
  private int count_;
  
  private int targetId_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearCount() {
    this.count_ = 0;
  }
  
  private void clearTargetId() {
    this.targetId_ = 0;
  }
  
  public static ExistenceFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ExistenceFilter paramExistenceFilter) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramExistenceFilter);
  }
  
  public static ExistenceFilter parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ExistenceFilter)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ExistenceFilter parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ExistenceFilter)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ExistenceFilter parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ExistenceFilter parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ExistenceFilter parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ExistenceFilter parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ExistenceFilter parseFrom(InputStream paramInputStream) throws IOException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ExistenceFilter parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ExistenceFilter parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ExistenceFilter parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ExistenceFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ExistenceFilter> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCount(int paramInt) {
    this.count_ = paramInt;
  }
  
  private void setTargetId(int paramInt) {
    this.targetId_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ExistenceFilter$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 397, 2 -> 393, 3 -> 391, 4 -> 382, 5 -> 252, 6 -> 118, 7 -> 248, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/ExistenceFilter.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/ExistenceFilter
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/ExistenceFilter.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/ExistenceFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ExistenceFilter;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/ExistenceFilter.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/ExistenceFilter
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/ExistenceFilter
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/ExistenceFilter.PARSER : Lcom/google/protobuf/Parser;
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
    //   153: bipush #16
    //   155: if_icmpeq -> 170
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: goto -> 192
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual readInt32 : ()I
    //   175: putfield count_ : I
    //   178: goto -> 128
    //   181: aload_0
    //   182: aload_1
    //   183: invokevirtual readInt32 : ()I
    //   186: putfield targetId_ : I
    //   189: goto -> 128
    //   192: iconst_1
    //   193: istore #6
    //   195: goto -> 128
    //   198: astore_1
    //   199: goto -> 246
    //   202: astore_1
    //   203: new java/lang/RuntimeException
    //   206: astore_3
    //   207: new com/google/protobuf/InvalidProtocolBufferException
    //   210: astore_2
    //   211: aload_2
    //   212: aload_1
    //   213: invokevirtual getMessage : ()Ljava/lang/String;
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: aload_3
    //   220: aload_2
    //   221: aload_0
    //   222: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   225: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   228: aload_3
    //   229: athrow
    //   230: astore_1
    //   231: new java/lang/RuntimeException
    //   234: astore_2
    //   235: aload_2
    //   236: aload_1
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_2
    //   245: athrow
    //   246: aload_1
    //   247: athrow
    //   248: getstatic com/google/firestore/v1/ExistenceFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ExistenceFilter;
    //   251: areturn
    //   252: aload_2
    //   253: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   256: astore_1
    //   257: aload_3
    //   258: checkcast com/google/firestore/v1/ExistenceFilter
    //   261: astore_2
    //   262: aload_0
    //   263: getfield targetId_ : I
    //   266: ifeq -> 275
    //   269: iconst_1
    //   270: istore #7
    //   272: goto -> 278
    //   275: iconst_0
    //   276: istore #7
    //   278: aload_0
    //   279: getfield targetId_ : I
    //   282: istore #6
    //   284: aload_2
    //   285: getfield targetId_ : I
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
    //   309: getfield targetId_ : I
    //   312: invokeinterface visitInt : (ZIZI)I
    //   317: putfield targetId_ : I
    //   320: aload_0
    //   321: getfield count_ : I
    //   324: ifeq -> 333
    //   327: iconst_1
    //   328: istore #7
    //   330: goto -> 336
    //   333: iconst_0
    //   334: istore #7
    //   336: aload_0
    //   337: getfield count_ : I
    //   340: istore #6
    //   342: iload #5
    //   344: istore #8
    //   346: aload_2
    //   347: getfield count_ : I
    //   350: ifeq -> 356
    //   353: iconst_1
    //   354: istore #8
    //   356: aload_0
    //   357: aload_1
    //   358: iload #7
    //   360: iload #6
    //   362: iload #8
    //   364: aload_2
    //   365: getfield count_ : I
    //   368: invokeinterface visitInt : (ZIZI)I
    //   373: putfield count_ : I
    //   376: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   379: astore_1
    //   380: aload_0
    //   381: areturn
    //   382: new com/google/firestore/v1/ExistenceFilter$Builder
    //   385: dup
    //   386: aconst_null
    //   387: invokespecial <init> : (Lcom/google/firestore/v1/ExistenceFilter$1;)V
    //   390: areturn
    //   391: aconst_null
    //   392: areturn
    //   393: getstatic com/google/firestore/v1/ExistenceFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ExistenceFilter;
    //   396: areturn
    //   397: new com/google/firestore/v1/ExistenceFilter
    //   400: dup
    //   401: invokespecial <init> : ()V
    //   404: areturn
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
  
  public int getCount() {
    return this.count_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = this.targetId_;
    if (j != 0)
      i = 0 + CodedOutputStream.computeInt32Size(1, j); 
    int k = this.count_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(2, k); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int getTargetId() {
    return this.targetId_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.targetId_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    i = this.count_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
    private Builder() {
      super(ExistenceFilter.DEFAULT_INSTANCE);
    }
    
    public Builder clearCount() {
      copyOnWrite();
      ((ExistenceFilter)this.instance).clearCount();
      return this;
    }
    
    public Builder clearTargetId() {
      copyOnWrite();
      ((ExistenceFilter)this.instance).clearTargetId();
      return this;
    }
    
    public int getCount() {
      return ((ExistenceFilter)this.instance).getCount();
    }
    
    public int getTargetId() {
      return ((ExistenceFilter)this.instance).getTargetId();
    }
    
    public Builder setCount(int param1Int) {
      copyOnWrite();
      ((ExistenceFilter)this.instance).setCount(param1Int);
      return this;
    }
    
    public Builder setTargetId(int param1Int) {
      copyOnWrite();
      ((ExistenceFilter)this.instance).setTargetId(param1Int);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ExistenceFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */