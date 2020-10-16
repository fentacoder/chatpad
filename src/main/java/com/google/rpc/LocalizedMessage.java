package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, LocalizedMessage.Builder> implements LocalizedMessageOrBuilder {
  private static final LocalizedMessage DEFAULT_INSTANCE = new LocalizedMessage();
  
  public static final int LOCALE_FIELD_NUMBER = 1;
  
  public static final int MESSAGE_FIELD_NUMBER = 2;
  
  private static volatile Parser<LocalizedMessage> PARSER;
  
  private String locale_ = "";
  
  private String message_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearLocale() {
    this.locale_ = getDefaultInstance().getLocale();
  }
  
  private void clearMessage() {
    this.message_ = getDefaultInstance().getMessage();
  }
  
  public static LocalizedMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(LocalizedMessage paramLocalizedMessage) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramLocalizedMessage);
  }
  
  public static LocalizedMessage parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (LocalizedMessage)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LocalizedMessage parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static LocalizedMessage parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static LocalizedMessage parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(InputStream paramInputStream) throws IOException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static LocalizedMessage parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static LocalizedMessage parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static LocalizedMessage parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (LocalizedMessage)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<LocalizedMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setLocale(String paramString) {
    if (paramString != null) {
      this.locale_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLocaleBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.locale_ = paramByteString.toStringUtf8();
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
    //   0: getstatic com/google/rpc/LocalizedMessage$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 350, 2 -> 346, 3 -> 344, 4 -> 335, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/LocalizedMessage.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/LocalizedMessage
    //   72: monitorenter
    //   73: getstatic com/google/rpc/LocalizedMessage.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/LocalizedMessage.DEFAULT_INSTANCE : Lcom/google/rpc/LocalizedMessage;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/LocalizedMessage.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/LocalizedMessage
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/LocalizedMessage
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/LocalizedMessage.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 243
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 187
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
    //   162: goto -> 187
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   170: putfield message_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   181: putfield locale_ : Ljava/lang/String;
    //   184: goto -> 123
    //   187: iconst_1
    //   188: istore #4
    //   190: goto -> 123
    //   193: astore_1
    //   194: goto -> 241
    //   197: astore_1
    //   198: new java/lang/RuntimeException
    //   201: astore_2
    //   202: new com/google/protobuf/InvalidProtocolBufferException
    //   205: astore_3
    //   206: aload_3
    //   207: aload_1
    //   208: invokevirtual getMessage : ()Ljava/lang/String;
    //   211: invokespecial <init> : (Ljava/lang/String;)V
    //   214: aload_2
    //   215: aload_3
    //   216: aload_0
    //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   223: aload_2
    //   224: athrow
    //   225: astore_2
    //   226: new java/lang/RuntimeException
    //   229: astore_1
    //   230: aload_1
    //   231: aload_2
    //   232: aload_0
    //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   239: aload_1
    //   240: athrow
    //   241: aload_1
    //   242: athrow
    //   243: getstatic com/google/rpc/LocalizedMessage.DEFAULT_INSTANCE : Lcom/google/rpc/LocalizedMessage;
    //   246: areturn
    //   247: aload_2
    //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   251: astore_1
    //   252: aload_3
    //   253: checkcast com/google/rpc/LocalizedMessage
    //   256: astore_2
    //   257: aload_0
    //   258: aload_1
    //   259: aload_0
    //   260: getfield locale_ : Ljava/lang/String;
    //   263: invokevirtual isEmpty : ()Z
    //   266: iconst_1
    //   267: ixor
    //   268: aload_0
    //   269: getfield locale_ : Ljava/lang/String;
    //   272: aload_2
    //   273: getfield locale_ : Ljava/lang/String;
    //   276: invokevirtual isEmpty : ()Z
    //   279: iconst_1
    //   280: ixor
    //   281: aload_2
    //   282: getfield locale_ : Ljava/lang/String;
    //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   290: putfield locale_ : Ljava/lang/String;
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield message_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_0
    //   305: getfield message_ : Ljava/lang/String;
    //   308: iconst_1
    //   309: aload_2
    //   310: getfield message_ : Ljava/lang/String;
    //   313: invokevirtual isEmpty : ()Z
    //   316: ixor
    //   317: aload_2
    //   318: getfield message_ : Ljava/lang/String;
    //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   326: putfield message_ : Ljava/lang/String;
    //   329: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   332: astore_1
    //   333: aload_0
    //   334: areturn
    //   335: new com/google/rpc/LocalizedMessage$Builder
    //   338: dup
    //   339: aconst_null
    //   340: invokespecial <init> : (Lcom/google/rpc/LocalizedMessage$1;)V
    //   343: areturn
    //   344: aconst_null
    //   345: areturn
    //   346: getstatic com/google/rpc/LocalizedMessage.DEFAULT_INSTANCE : Lcom/google/rpc/LocalizedMessage;
    //   349: areturn
    //   350: new com/google/rpc/LocalizedMessage
    //   353: dup
    //   354: invokespecial <init> : ()V
    //   357: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	225	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	197	java/io/IOException
    //   128	134	193	finally
    //   153	162	225	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	197	java/io/IOException
    //   153	162	193	finally
    //   165	173	225	com/google/protobuf/InvalidProtocolBufferException
    //   165	173	197	java/io/IOException
    //   165	173	193	finally
    //   176	184	225	com/google/protobuf/InvalidProtocolBufferException
    //   176	184	197	java/io/IOException
    //   176	184	193	finally
    //   198	225	193	finally
    //   226	241	193	finally
  }
  
  public String getLocale() {
    return this.locale_;
  }
  
  public ByteString getLocaleBytes() {
    return ByteString.copyFromUtf8(this.locale_);
  }
  
  public String getMessage() {
    return this.message_;
  }
  
  public ByteString getMessageBytes() {
    return ByteString.copyFromUtf8(this.message_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.locale_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getLocale()); 
    int j = i;
    if (!this.message_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getMessage()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.locale_.isEmpty())
      paramCodedOutputStream.writeString(1, getLocale()); 
    if (!this.message_.isEmpty())
      paramCodedOutputStream.writeString(2, getMessage()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
    private Builder() {
      super(LocalizedMessage.DEFAULT_INSTANCE);
    }
    
    public Builder clearLocale() {
      copyOnWrite();
      ((LocalizedMessage)this.instance).clearLocale();
      return this;
    }
    
    public Builder clearMessage() {
      copyOnWrite();
      ((LocalizedMessage)this.instance).clearMessage();
      return this;
    }
    
    public String getLocale() {
      return ((LocalizedMessage)this.instance).getLocale();
    }
    
    public ByteString getLocaleBytes() {
      return ((LocalizedMessage)this.instance).getLocaleBytes();
    }
    
    public String getMessage() {
      return ((LocalizedMessage)this.instance).getMessage();
    }
    
    public ByteString getMessageBytes() {
      return ((LocalizedMessage)this.instance).getMessageBytes();
    }
    
    public Builder setLocale(String param1String) {
      copyOnWrite();
      ((LocalizedMessage)this.instance).setLocale(param1String);
      return this;
    }
    
    public Builder setLocaleBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LocalizedMessage)this.instance).setLocaleBytes(param1ByteString);
      return this;
    }
    
    public Builder setMessage(String param1String) {
      copyOnWrite();
      ((LocalizedMessage)this.instance).setMessage(param1String);
      return this;
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((LocalizedMessage)this.instance).setMessageBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\LocalizedMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */