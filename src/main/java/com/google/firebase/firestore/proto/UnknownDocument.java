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

public final class UnknownDocument extends GeneratedMessageLite<UnknownDocument, UnknownDocument.Builder> implements UnknownDocumentOrBuilder {
  private static final UnknownDocument DEFAULT_INSTANCE = new UnknownDocument();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<UnknownDocument> PARSER;
  
  public static final int VERSION_FIELD_NUMBER = 2;
  
  private String name_ = "";
  
  private Timestamp version_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearVersion() {
    this.version_ = null;
  }
  
  public static UnknownDocument getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeVersion(Timestamp paramTimestamp) {
    Timestamp timestamp = this.version_;
    if (timestamp != null && timestamp != Timestamp.getDefaultInstance()) {
      this.version_ = (Timestamp)((Timestamp.Builder)Timestamp.newBuilder(this.version_).mergeFrom((GeneratedMessageLite)paramTimestamp)).buildPartial();
    } else {
      this.version_ = paramTimestamp;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UnknownDocument paramUnknownDocument) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUnknownDocument);
  }
  
  public static UnknownDocument parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UnknownDocument)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UnknownDocument parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UnknownDocument)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UnknownDocument parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UnknownDocument parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UnknownDocument parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UnknownDocument parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UnknownDocument parseFrom(InputStream paramInputStream) throws IOException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UnknownDocument parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UnknownDocument parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static UnknownDocument parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UnknownDocument)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UnknownDocument> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setVersion(Timestamp.Builder paramBuilder) {
    this.version_ = (Timestamp)paramBuilder.build();
  }
  
  private void setVersion(Timestamp paramTimestamp) {
    if (paramTimestamp != null) {
      this.version_ = paramTimestamp;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firebase/firestore/proto/UnknownDocument$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 389, 2 -> 385, 3 -> 383, 4 -> 374, 5 -> 301, 6 -> 110, 7 -> 297, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firebase/firestore/proto/UnknownDocument.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firebase/firestore/proto/UnknownDocument
    //   72: monitorenter
    //   73: getstatic com/google/firebase/firestore/proto/UnknownDocument.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firebase/firestore/proto/UnknownDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/UnknownDocument;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firebase/firestore/proto/UnknownDocument.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firebase/firestore/proto/UnknownDocument
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firebase/firestore/proto/UnknownDocument
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firebase/firestore/proto/UnknownDocument.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 297
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 241
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
    //   162: goto -> 241
    //   165: aload_0
    //   166: getfield version_ : Lcom/google/protobuf/Timestamp;
    //   169: ifnull -> 186
    //   172: aload_0
    //   173: getfield version_ : Lcom/google/protobuf/Timestamp;
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
    //   200: putfield version_ : Lcom/google/protobuf/Timestamp;
    //   203: aload_1
    //   204: ifnull -> 123
    //   207: aload_1
    //   208: aload_0
    //   209: getfield version_ : Lcom/google/protobuf/Timestamp;
    //   212: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   215: pop
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   221: checkcast com/google/protobuf/Timestamp
    //   224: putfield version_ : Lcom/google/protobuf/Timestamp;
    //   227: goto -> 123
    //   230: aload_0
    //   231: aload_2
    //   232: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   235: putfield name_ : Ljava/lang/String;
    //   238: goto -> 123
    //   241: iconst_1
    //   242: istore #4
    //   244: goto -> 123
    //   247: astore_1
    //   248: goto -> 295
    //   251: astore_3
    //   252: new java/lang/RuntimeException
    //   255: astore_1
    //   256: new com/google/protobuf/InvalidProtocolBufferException
    //   259: astore_2
    //   260: aload_2
    //   261: aload_3
    //   262: invokevirtual getMessage : ()Ljava/lang/String;
    //   265: invokespecial <init> : (Ljava/lang/String;)V
    //   268: aload_1
    //   269: aload_2
    //   270: aload_0
    //   271: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   274: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: new java/lang/RuntimeException
    //   283: astore_2
    //   284: aload_2
    //   285: aload_1
    //   286: aload_0
    //   287: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   290: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   293: aload_2
    //   294: athrow
    //   295: aload_1
    //   296: athrow
    //   297: getstatic com/google/firebase/firestore/proto/UnknownDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/UnknownDocument;
    //   300: areturn
    //   301: aload_2
    //   302: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   305: astore_1
    //   306: aload_3
    //   307: checkcast com/google/firebase/firestore/proto/UnknownDocument
    //   310: astore_2
    //   311: aload_0
    //   312: aload_1
    //   313: aload_0
    //   314: getfield name_ : Ljava/lang/String;
    //   317: invokevirtual isEmpty : ()Z
    //   320: iconst_1
    //   321: ixor
    //   322: aload_0
    //   323: getfield name_ : Ljava/lang/String;
    //   326: iconst_1
    //   327: aload_2
    //   328: getfield name_ : Ljava/lang/String;
    //   331: invokevirtual isEmpty : ()Z
    //   334: ixor
    //   335: aload_2
    //   336: getfield name_ : Ljava/lang/String;
    //   339: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   344: putfield name_ : Ljava/lang/String;
    //   347: aload_0
    //   348: aload_1
    //   349: aload_0
    //   350: getfield version_ : Lcom/google/protobuf/Timestamp;
    //   353: aload_2
    //   354: getfield version_ : Lcom/google/protobuf/Timestamp;
    //   357: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   362: checkcast com/google/protobuf/Timestamp
    //   365: putfield version_ : Lcom/google/protobuf/Timestamp;
    //   368: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   371: astore_1
    //   372: aload_0
    //   373: areturn
    //   374: new com/google/firebase/firestore/proto/UnknownDocument$Builder
    //   377: dup
    //   378: aconst_null
    //   379: invokespecial <init> : (Lcom/google/firebase/firestore/proto/UnknownDocument$1;)V
    //   382: areturn
    //   383: aconst_null
    //   384: areturn
    //   385: getstatic com/google/firebase/firestore/proto/UnknownDocument.DEFAULT_INSTANCE : Lcom/google/firebase/firestore/proto/UnknownDocument;
    //   388: areturn
    //   389: new com/google/firebase/firestore/proto/UnknownDocument
    //   392: dup
    //   393: invokespecial <init> : ()V
    //   396: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	279	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	251	java/io/IOException
    //   128	134	247	finally
    //   153	162	279	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	251	java/io/IOException
    //   153	162	247	finally
    //   165	183	279	com/google/protobuf/InvalidProtocolBufferException
    //   165	183	251	java/io/IOException
    //   165	183	247	finally
    //   188	203	279	com/google/protobuf/InvalidProtocolBufferException
    //   188	203	251	java/io/IOException
    //   188	203	247	finally
    //   207	227	279	com/google/protobuf/InvalidProtocolBufferException
    //   207	227	251	java/io/IOException
    //   207	227	247	finally
    //   230	238	279	com/google/protobuf/InvalidProtocolBufferException
    //   230	238	251	java/io/IOException
    //   230	238	247	finally
    //   252	279	247	finally
    //   280	295	247	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.name_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getName()); 
    int j = i;
    if (this.version_ != null)
      j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)getVersion()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Timestamp getVersion() {
    Timestamp timestamp1 = this.version_;
    Timestamp timestamp2 = timestamp1;
    if (timestamp1 == null)
      timestamp2 = Timestamp.getDefaultInstance(); 
    return timestamp2;
  }
  
  public boolean hasVersion() {
    boolean bool;
    if (this.version_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (this.version_ != null)
      paramCodedOutputStream.writeMessage(2, (MessageLite)getVersion()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UnknownDocument, Builder> implements UnknownDocumentOrBuilder {
    private Builder() {
      super(UnknownDocument.DEFAULT_INSTANCE);
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((UnknownDocument)this.instance).clearName();
      return this;
    }
    
    public Builder clearVersion() {
      copyOnWrite();
      ((UnknownDocument)this.instance).clearVersion();
      return this;
    }
    
    public String getName() {
      return ((UnknownDocument)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((UnknownDocument)this.instance).getNameBytes();
    }
    
    public Timestamp getVersion() {
      return ((UnknownDocument)this.instance).getVersion();
    }
    
    public boolean hasVersion() {
      return ((UnknownDocument)this.instance).hasVersion();
    }
    
    public Builder mergeVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((UnknownDocument)this.instance).mergeVersion(param1Timestamp);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((UnknownDocument)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((UnknownDocument)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setVersion(Timestamp.Builder param1Builder) {
      copyOnWrite();
      ((UnknownDocument)this.instance).setVersion(param1Builder);
      return this;
    }
    
    public Builder setVersion(Timestamp param1Timestamp) {
      copyOnWrite();
      ((UnknownDocument)this.instance).setVersion(param1Timestamp);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\UnknownDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */