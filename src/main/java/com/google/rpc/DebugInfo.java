package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DebugInfo extends GeneratedMessageLite<DebugInfo, DebugInfo.Builder> implements DebugInfoOrBuilder {
  private static final DebugInfo DEFAULT_INSTANCE = new DebugInfo();
  
  public static final int DETAIL_FIELD_NUMBER = 2;
  
  private static volatile Parser<DebugInfo> PARSER;
  
  public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
  
  private int bitField0_;
  
  private String detail_ = "";
  
  private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllStackEntries(Iterable<String> paramIterable) {
    ensureStackEntriesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.stackEntries_);
  }
  
  private void addStackEntries(String paramString) {
    if (paramString != null) {
      ensureStackEntriesIsMutable();
      this.stackEntries_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addStackEntriesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureStackEntriesIsMutable();
      this.stackEntries_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDetail() {
    this.detail_ = getDefaultInstance().getDetail();
  }
  
  private void clearStackEntries() {
    this.stackEntries_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void ensureStackEntriesIsMutable() {
    if (!this.stackEntries_.isModifiable())
      this.stackEntries_ = GeneratedMessageLite.mutableCopy(this.stackEntries_); 
  }
  
  public static DebugInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DebugInfo paramDebugInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDebugInfo);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DebugInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DebugInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DebugInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DebugInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DebugInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DebugInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDetail(String paramString) {
    if (paramString != null) {
      this.detail_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDetailBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.detail_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStackEntries(int paramInt, String paramString) {
    if (paramString != null) {
      ensureStackEntriesIsMutable();
      this.stackEntries_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/DebugInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 388, 2 -> 384, 3 -> 373, 4 -> 364, 5 -> 278, 6 -> 110, 7 -> 274, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/DebugInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/DebugInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/DebugInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/DebugInfo.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_1
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_2
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 274
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 218
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 176
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 165
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 218
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   170: putfield detail_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_1
    //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   180: astore_2
    //   181: aload_0
    //   182: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokeinterface isModifiable : ()Z
    //   190: ifne -> 204
    //   193: aload_0
    //   194: aload_0
    //   195: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   198: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   201: putfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   204: aload_0
    //   205: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   208: aload_2
    //   209: invokeinterface add : (Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -> 123
    //   218: iconst_1
    //   219: istore #4
    //   221: goto -> 123
    //   224: astore_1
    //   225: goto -> 272
    //   228: astore_3
    //   229: new java/lang/RuntimeException
    //   232: astore_1
    //   233: new com/google/protobuf/InvalidProtocolBufferException
    //   236: astore_2
    //   237: aload_2
    //   238: aload_3
    //   239: invokevirtual getMessage : ()Ljava/lang/String;
    //   242: invokespecial <init> : (Ljava/lang/String;)V
    //   245: aload_1
    //   246: aload_2
    //   247: aload_0
    //   248: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   251: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: new java/lang/RuntimeException
    //   260: astore_2
    //   261: aload_2
    //   262: aload_1
    //   263: aload_0
    //   264: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   267: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   270: aload_2
    //   271: athrow
    //   272: aload_1
    //   273: athrow
    //   274: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   277: areturn
    //   278: aload_2
    //   279: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   282: astore_1
    //   283: aload_3
    //   284: checkcast com/google/rpc/DebugInfo
    //   287: astore_2
    //   288: aload_0
    //   289: aload_1
    //   290: aload_0
    //   291: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   294: aload_2
    //   295: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   298: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   303: putfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   306: aload_0
    //   307: aload_1
    //   308: aload_0
    //   309: getfield detail_ : Ljava/lang/String;
    //   312: invokevirtual isEmpty : ()Z
    //   315: iconst_1
    //   316: ixor
    //   317: aload_0
    //   318: getfield detail_ : Ljava/lang/String;
    //   321: iconst_1
    //   322: aload_2
    //   323: getfield detail_ : Ljava/lang/String;
    //   326: invokevirtual isEmpty : ()Z
    //   329: ixor
    //   330: aload_2
    //   331: getfield detail_ : Ljava/lang/String;
    //   334: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   339: putfield detail_ : Ljava/lang/String;
    //   342: aload_1
    //   343: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   346: if_acmpne -> 362
    //   349: aload_0
    //   350: aload_0
    //   351: getfield bitField0_ : I
    //   354: aload_2
    //   355: getfield bitField0_ : I
    //   358: ior
    //   359: putfield bitField0_ : I
    //   362: aload_0
    //   363: areturn
    //   364: new com/google/rpc/DebugInfo$Builder
    //   367: dup
    //   368: aconst_null
    //   369: invokespecial <init> : (Lcom/google/rpc/DebugInfo$1;)V
    //   372: areturn
    //   373: aload_0
    //   374: getfield stackEntries_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   377: invokeinterface makeImmutable : ()V
    //   382: aconst_null
    //   383: areturn
    //   384: getstatic com/google/rpc/DebugInfo.DEFAULT_INSTANCE : Lcom/google/rpc/DebugInfo;
    //   387: areturn
    //   388: new com/google/rpc/DebugInfo
    //   391: dup
    //   392: invokespecial <init> : ()V
    //   395: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	256	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	228	java/io/IOException
    //   128	134	224	finally
    //   153	162	256	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	228	java/io/IOException
    //   153	162	224	finally
    //   165	173	256	com/google/protobuf/InvalidProtocolBufferException
    //   165	173	228	java/io/IOException
    //   165	173	224	finally
    //   176	204	256	com/google/protobuf/InvalidProtocolBufferException
    //   176	204	228	java/io/IOException
    //   176	204	224	finally
    //   204	215	256	com/google/protobuf/InvalidProtocolBufferException
    //   204	215	228	java/io/IOException
    //   204	215	224	finally
    //   229	256	224	finally
    //   257	272	224	finally
  }
  
  public String getDetail() {
    return this.detail_;
  }
  
  public ByteString getDetailBytes() {
    return ByteString.copyFromUtf8(this.detail_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = i;
    while (i < this.stackEntries_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.stackEntries_.get(i));
      i++;
    } 
    j = 0 + j + getStackEntriesList().size() * 1;
    i = j;
    if (!this.detail_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getDetail()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getStackEntries(int paramInt) {
    return (String)this.stackEntries_.get(paramInt);
  }
  
  public ByteString getStackEntriesBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.stackEntries_.get(paramInt));
  }
  
  public int getStackEntriesCount() {
    return this.stackEntries_.size();
  }
  
  public List<String> getStackEntriesList() {
    return (List<String>)this.stackEntries_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.stackEntries_.size(); b++)
      paramCodedOutputStream.writeString(1, (String)this.stackEntries_.get(b)); 
    if (!this.detail_.isEmpty())
      paramCodedOutputStream.writeString(2, getDetail()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
    private Builder() {
      super(DebugInfo.DEFAULT_INSTANCE);
    }
    
    public Builder addAllStackEntries(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((DebugInfo)this.instance).addAllStackEntries(param1Iterable);
      return this;
    }
    
    public Builder addStackEntries(String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntries(param1String);
      return this;
    }
    
    public Builder addStackEntriesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DebugInfo)this.instance).addStackEntriesBytes(param1ByteString);
      return this;
    }
    
    public Builder clearDetail() {
      copyOnWrite();
      ((DebugInfo)this.instance).clearDetail();
      return this;
    }
    
    public Builder clearStackEntries() {
      copyOnWrite();
      ((DebugInfo)this.instance).clearStackEntries();
      return this;
    }
    
    public String getDetail() {
      return ((DebugInfo)this.instance).getDetail();
    }
    
    public ByteString getDetailBytes() {
      return ((DebugInfo)this.instance).getDetailBytes();
    }
    
    public String getStackEntries(int param1Int) {
      return ((DebugInfo)this.instance).getStackEntries(param1Int);
    }
    
    public ByteString getStackEntriesBytes(int param1Int) {
      return ((DebugInfo)this.instance).getStackEntriesBytes(param1Int);
    }
    
    public int getStackEntriesCount() {
      return ((DebugInfo)this.instance).getStackEntriesCount();
    }
    
    public List<String> getStackEntriesList() {
      return Collections.unmodifiableList(((DebugInfo)this.instance).getStackEntriesList());
    }
    
    public Builder setDetail(String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetail(param1String);
      return this;
    }
    
    public Builder setDetailBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DebugInfo)this.instance).setDetailBytes(param1ByteString);
      return this;
    }
    
    public Builder setStackEntries(int param1Int, String param1String) {
      copyOnWrite();
      ((DebugInfo)this.instance).setStackEntries(param1Int, param1String);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\DebugInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */