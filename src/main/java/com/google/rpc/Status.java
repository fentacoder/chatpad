package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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

public final class Status extends GeneratedMessageLite<Status, Status.Builder> implements StatusOrBuilder {
  public static final int CODE_FIELD_NUMBER = 1;
  
  private static final Status DEFAULT_INSTANCE = new Status();
  
  public static final int DETAILS_FIELD_NUMBER = 3;
  
  public static final int MESSAGE_FIELD_NUMBER = 2;
  
  private static volatile Parser<Status> PARSER;
  
  private int bitField0_;
  
  private int code_;
  
  private Internal.ProtobufList<Any> details_ = emptyProtobufList();
  
  private String message_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDetails(Iterable<? extends Any> paramIterable) {
    ensureDetailsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.details_);
  }
  
  private void addDetails(int paramInt, Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.add(paramInt, paramBuilder.build());
  }
  
  private void addDetails(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.add(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDetails(Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.add(paramBuilder.build());
  }
  
  private void addDetails(Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.add(paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCode() {
    this.code_ = 0;
  }
  
  private void clearDetails() {
    this.details_ = emptyProtobufList();
  }
  
  private void clearMessage() {
    this.message_ = getDefaultInstance().getMessage();
  }
  
  private void ensureDetailsIsMutable() {
    if (!this.details_.isModifiable())
      this.details_ = GeneratedMessageLite.mutableCopy(this.details_); 
  }
  
  public static Status getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Status paramStatus) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramStatus);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Status parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Status parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(InputStream paramInputStream) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Status parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Status parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Status)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Status> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeDetails(int paramInt) {
    ensureDetailsIsMutable();
    this.details_.remove(paramInt);
  }
  
  private void setCode(int paramInt) {
    this.code_ = paramInt;
  }
  
  private void setDetails(int paramInt, Any.Builder paramBuilder) {
    ensureDetailsIsMutable();
    this.details_.set(paramInt, paramBuilder.build());
  }
  
  private void setDetails(int paramInt, Any paramAny) {
    if (paramAny != null) {
      ensureDetailsIsMutable();
      this.details_.set(paramInt, paramAny);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMessage(String paramString) {
    if (paramString != null) {
      this.message_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMessageBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.message_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/Status$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 468, 2 -> 464, 3 -> 453, 4 -> 444, 5 -> 306, 6 -> 118, 7 -> 302, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/rpc/Status
    //   80: monitorenter
    //   81: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/rpc/Status
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/rpc/Status
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/rpc/Status.PARSER : Lcom/google/protobuf/Parser;
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
    //   146: bipush #8
    //   148: if_icmpeq -> 235
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 224
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 177
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: goto -> 246
    //   177: aload_0
    //   178: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   181: invokeinterface isModifiable : ()Z
    //   186: ifne -> 200
    //   189: aload_0
    //   190: aload_0
    //   191: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   194: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   197: putfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   200: aload_0
    //   201: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   204: aload_1
    //   205: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   208: aload_2
    //   209: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   212: checkcast com/google/protobuf/Any
    //   215: invokeinterface add : (Ljava/lang/Object;)Z
    //   220: pop
    //   221: goto -> 128
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   229: putfield message_ : Ljava/lang/String;
    //   232: goto -> 128
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual readInt32 : ()I
    //   240: putfield code_ : I
    //   243: goto -> 128
    //   246: iconst_1
    //   247: istore #6
    //   249: goto -> 128
    //   252: astore_1
    //   253: goto -> 300
    //   256: astore_2
    //   257: new java/lang/RuntimeException
    //   260: astore_1
    //   261: new com/google/protobuf/InvalidProtocolBufferException
    //   264: astore_3
    //   265: aload_3
    //   266: aload_2
    //   267: invokevirtual getMessage : ()Ljava/lang/String;
    //   270: invokespecial <init> : (Ljava/lang/String;)V
    //   273: aload_1
    //   274: aload_3
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
    //   302: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   305: areturn
    //   306: aload_2
    //   307: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   310: astore_1
    //   311: aload_3
    //   312: checkcast com/google/rpc/Status
    //   315: astore_2
    //   316: aload_0
    //   317: getfield code_ : I
    //   320: ifeq -> 329
    //   323: iconst_1
    //   324: istore #7
    //   326: goto -> 332
    //   329: iconst_0
    //   330: istore #7
    //   332: aload_0
    //   333: getfield code_ : I
    //   336: istore #6
    //   338: aload_2
    //   339: getfield code_ : I
    //   342: ifeq -> 348
    //   345: iconst_1
    //   346: istore #5
    //   348: aload_0
    //   349: aload_1
    //   350: iload #7
    //   352: iload #6
    //   354: iload #5
    //   356: aload_2
    //   357: getfield code_ : I
    //   360: invokeinterface visitInt : (ZIZI)I
    //   365: putfield code_ : I
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield message_ : Ljava/lang/String;
    //   374: invokevirtual isEmpty : ()Z
    //   377: iconst_1
    //   378: ixor
    //   379: aload_0
    //   380: getfield message_ : Ljava/lang/String;
    //   383: aload_2
    //   384: getfield message_ : Ljava/lang/String;
    //   387: invokevirtual isEmpty : ()Z
    //   390: iconst_1
    //   391: ixor
    //   392: aload_2
    //   393: getfield message_ : Ljava/lang/String;
    //   396: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   401: putfield message_ : Ljava/lang/String;
    //   404: aload_0
    //   405: aload_1
    //   406: aload_0
    //   407: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   410: aload_2
    //   411: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   414: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   419: putfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   422: aload_1
    //   423: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   426: if_acmpne -> 442
    //   429: aload_0
    //   430: aload_0
    //   431: getfield bitField0_ : I
    //   434: aload_2
    //   435: getfield bitField0_ : I
    //   438: ior
    //   439: putfield bitField0_ : I
    //   442: aload_0
    //   443: areturn
    //   444: new com/google/rpc/Status$Builder
    //   447: dup
    //   448: aconst_null
    //   449: invokespecial <init> : (Lcom/google/rpc/Status$1;)V
    //   452: areturn
    //   453: aload_0
    //   454: getfield details_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   457: invokeinterface makeImmutable : ()V
    //   462: aconst_null
    //   463: areturn
    //   464: getstatic com/google/rpc/Status.DEFAULT_INSTANCE : Lcom/google/rpc/Status;
    //   467: areturn
    //   468: new com/google/rpc/Status
    //   471: dup
    //   472: invokespecial <init> : ()V
    //   475: areturn
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
    //   177	200	284	com/google/protobuf/InvalidProtocolBufferException
    //   177	200	256	java/io/IOException
    //   177	200	252	finally
    //   200	221	284	com/google/protobuf/InvalidProtocolBufferException
    //   200	221	256	java/io/IOException
    //   200	221	252	finally
    //   224	232	284	com/google/protobuf/InvalidProtocolBufferException
    //   224	232	256	java/io/IOException
    //   224	232	252	finally
    //   235	243	284	com/google/protobuf/InvalidProtocolBufferException
    //   235	243	256	java/io/IOException
    //   235	243	252	finally
    //   257	284	252	finally
    //   285	300	252	finally
  }
  
  public int getCode() {
    return this.code_;
  }
  
  public Any getDetails(int paramInt) {
    return (Any)this.details_.get(paramInt);
  }
  
  public int getDetailsCount() {
    return this.details_.size();
  }
  
  public List<Any> getDetailsList() {
    return (List<Any>)this.details_;
  }
  
  public AnyOrBuilder getDetailsOrBuilder(int paramInt) {
    return (AnyOrBuilder)this.details_.get(paramInt);
  }
  
  public List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
    return (List)this.details_;
  }
  
  public String getMessage() {
    return this.message_;
  }
  
  public ByteString getMessageBytes() {
    return ByteString.copyFromUtf8(this.message_);
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = this.code_;
    byte b1 = 0;
    if (i != 0) {
      b2 = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      b2 = 0;
    } 
    i = b2;
    byte b3 = b1;
    if (!this.message_.isEmpty()) {
      i = b2 + CodedOutputStream.computeStringSize(2, getMessage());
      b3 = b1;
    } 
    while (b3 < this.details_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.details_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    int i = this.code_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!this.message_.isEmpty())
      paramCodedOutputStream.writeString(2, getMessage()); 
    for (i = 0; i < this.details_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.details_.get(i)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
    private Builder() {
      super(Status.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDetails(Iterable<? extends Any> param1Iterable) {
      copyOnWrite();
      ((Status)this.instance).addAllDetails(param1Iterable);
      return this;
    }
    
    public Builder addDetails(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDetails(int param1Int, Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Int, param1Any);
      return this;
    }
    
    public Builder addDetails(Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Builder);
      return this;
    }
    
    public Builder addDetails(Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).addDetails(param1Any);
      return this;
    }
    
    public Builder clearCode() {
      copyOnWrite();
      ((Status)this.instance).clearCode();
      return this;
    }
    
    public Builder clearDetails() {
      copyOnWrite();
      ((Status)this.instance).clearDetails();
      return this;
    }
    
    public Builder clearMessage() {
      copyOnWrite();
      ((Status)this.instance).clearMessage();
      return this;
    }
    
    public int getCode() {
      return ((Status)this.instance).getCode();
    }
    
    public Any getDetails(int param1Int) {
      return ((Status)this.instance).getDetails(param1Int);
    }
    
    public int getDetailsCount() {
      return ((Status)this.instance).getDetailsCount();
    }
    
    public List<Any> getDetailsList() {
      return Collections.unmodifiableList(((Status)this.instance).getDetailsList());
    }
    
    public String getMessage() {
      return ((Status)this.instance).getMessage();
    }
    
    public ByteString getMessageBytes() {
      return ((Status)this.instance).getMessageBytes();
    }
    
    public Builder removeDetails(int param1Int) {
      copyOnWrite();
      ((Status)this.instance).removeDetails(param1Int);
      return this;
    }
    
    public Builder setCode(int param1Int) {
      copyOnWrite();
      ((Status)this.instance).setCode(param1Int);
      return this;
    }
    
    public Builder setDetails(int param1Int, Any.Builder param1Builder) {
      copyOnWrite();
      ((Status)this.instance).setDetails(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDetails(int param1Int, Any param1Any) {
      copyOnWrite();
      ((Status)this.instance).setDetails(param1Int, param1Any);
      return this;
    }
    
    public Builder setMessage(String param1String) {
      copyOnWrite();
      ((Status)this.instance).setMessage(param1String);
      return this;
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((Status)this.instance).setMessageBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\Status.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */