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

public final class ResourceInfo extends GeneratedMessageLite<ResourceInfo, ResourceInfo.Builder> implements ResourceInfoOrBuilder {
  private static final ResourceInfo DEFAULT_INSTANCE = new ResourceInfo();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  
  public static final int OWNER_FIELD_NUMBER = 3;
  
  private static volatile Parser<ResourceInfo> PARSER;
  
  public static final int RESOURCE_NAME_FIELD_NUMBER = 2;
  
  public static final int RESOURCE_TYPE_FIELD_NUMBER = 1;
  
  private String description_ = "";
  
  private String owner_ = "";
  
  private String resourceName_ = "";
  
  private String resourceType_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearOwner() {
    this.owner_ = getDefaultInstance().getOwner();
  }
  
  private void clearResourceName() {
    this.resourceName_ = getDefaultInstance().getResourceName();
  }
  
  private void clearResourceType() {
    this.resourceType_ = getDefaultInstance().getResourceType();
  }
  
  public static ResourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ResourceInfo paramResourceInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramResourceInfo);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ResourceInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDescription(String paramString) {
    if (paramString != null) {
      this.description_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDescriptionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.description_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOwner(String paramString) {
    if (paramString != null) {
      this.owner_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOwnerBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.owner_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceName(String paramString) {
    if (paramString != null) {
      this.resourceName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resourceName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceType(String paramString) {
    if (paramString != null) {
      this.resourceType_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceTypeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resourceType_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/ResourceInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 458, 2 -> 454, 3 -> 452, 4 -> 443, 5 -> 283, 6 -> 110, 7 -> 279, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/ResourceInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/ResourceInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/ResourceInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 279
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 223
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 212
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 201
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 190
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 179
    //   167: aload_1
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: goto -> 223
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   184: putfield description_ : Ljava/lang/String;
    //   187: goto -> 123
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   195: putfield owner_ : Ljava/lang/String;
    //   198: goto -> 123
    //   201: aload_0
    //   202: aload_1
    //   203: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   206: putfield resourceName_ : Ljava/lang/String;
    //   209: goto -> 123
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   217: putfield resourceType_ : Ljava/lang/String;
    //   220: goto -> 123
    //   223: iconst_1
    //   224: istore #4
    //   226: goto -> 123
    //   229: astore_1
    //   230: goto -> 277
    //   233: astore_2
    //   234: new java/lang/RuntimeException
    //   237: astore_3
    //   238: new com/google/protobuf/InvalidProtocolBufferException
    //   241: astore_1
    //   242: aload_1
    //   243: aload_2
    //   244: invokevirtual getMessage : ()Ljava/lang/String;
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: aload_3
    //   251: aload_1
    //   252: aload_0
    //   253: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   256: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_1
    //   262: new java/lang/RuntimeException
    //   265: astore_2
    //   266: aload_2
    //   267: aload_1
    //   268: aload_0
    //   269: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   272: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   275: aload_2
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   282: areturn
    //   283: aload_2
    //   284: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   287: astore_1
    //   288: aload_3
    //   289: checkcast com/google/rpc/ResourceInfo
    //   292: astore_2
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield resourceType_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_0
    //   305: getfield resourceType_ : Ljava/lang/String;
    //   308: aload_2
    //   309: getfield resourceType_ : Ljava/lang/String;
    //   312: invokevirtual isEmpty : ()Z
    //   315: iconst_1
    //   316: ixor
    //   317: aload_2
    //   318: getfield resourceType_ : Ljava/lang/String;
    //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   326: putfield resourceType_ : Ljava/lang/String;
    //   329: aload_0
    //   330: aload_1
    //   331: aload_0
    //   332: getfield resourceName_ : Ljava/lang/String;
    //   335: invokevirtual isEmpty : ()Z
    //   338: iconst_1
    //   339: ixor
    //   340: aload_0
    //   341: getfield resourceName_ : Ljava/lang/String;
    //   344: aload_2
    //   345: getfield resourceName_ : Ljava/lang/String;
    //   348: invokevirtual isEmpty : ()Z
    //   351: iconst_1
    //   352: ixor
    //   353: aload_2
    //   354: getfield resourceName_ : Ljava/lang/String;
    //   357: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   362: putfield resourceName_ : Ljava/lang/String;
    //   365: aload_0
    //   366: aload_1
    //   367: aload_0
    //   368: getfield owner_ : Ljava/lang/String;
    //   371: invokevirtual isEmpty : ()Z
    //   374: iconst_1
    //   375: ixor
    //   376: aload_0
    //   377: getfield owner_ : Ljava/lang/String;
    //   380: aload_2
    //   381: getfield owner_ : Ljava/lang/String;
    //   384: invokevirtual isEmpty : ()Z
    //   387: iconst_1
    //   388: ixor
    //   389: aload_2
    //   390: getfield owner_ : Ljava/lang/String;
    //   393: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   398: putfield owner_ : Ljava/lang/String;
    //   401: aload_0
    //   402: aload_1
    //   403: aload_0
    //   404: getfield description_ : Ljava/lang/String;
    //   407: invokevirtual isEmpty : ()Z
    //   410: iconst_1
    //   411: ixor
    //   412: aload_0
    //   413: getfield description_ : Ljava/lang/String;
    //   416: iconst_1
    //   417: aload_2
    //   418: getfield description_ : Ljava/lang/String;
    //   421: invokevirtual isEmpty : ()Z
    //   424: ixor
    //   425: aload_2
    //   426: getfield description_ : Ljava/lang/String;
    //   429: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   434: putfield description_ : Ljava/lang/String;
    //   437: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   440: astore_1
    //   441: aload_0
    //   442: areturn
    //   443: new com/google/rpc/ResourceInfo$Builder
    //   446: dup
    //   447: aconst_null
    //   448: invokespecial <init> : (Lcom/google/rpc/ResourceInfo$1;)V
    //   451: areturn
    //   452: aconst_null
    //   453: areturn
    //   454: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   457: areturn
    //   458: new com/google/rpc/ResourceInfo
    //   461: dup
    //   462: invokespecial <init> : ()V
    //   465: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	261	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	233	java/io/IOException
    //   128	134	229	finally
    //   167	176	261	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	233	java/io/IOException
    //   167	176	229	finally
    //   179	187	261	com/google/protobuf/InvalidProtocolBufferException
    //   179	187	233	java/io/IOException
    //   179	187	229	finally
    //   190	198	261	com/google/protobuf/InvalidProtocolBufferException
    //   190	198	233	java/io/IOException
    //   190	198	229	finally
    //   201	209	261	com/google/protobuf/InvalidProtocolBufferException
    //   201	209	233	java/io/IOException
    //   201	209	229	finally
    //   212	220	261	com/google/protobuf/InvalidProtocolBufferException
    //   212	220	233	java/io/IOException
    //   212	220	229	finally
    //   234	261	229	finally
    //   262	277	229	finally
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public String getOwner() {
    return this.owner_;
  }
  
  public ByteString getOwnerBytes() {
    return ByteString.copyFromUtf8(this.owner_);
  }
  
  public String getResourceName() {
    return this.resourceName_;
  }
  
  public ByteString getResourceNameBytes() {
    return ByteString.copyFromUtf8(this.resourceName_);
  }
  
  public String getResourceType() {
    return this.resourceType_;
  }
  
  public ByteString getResourceTypeBytes() {
    return ByteString.copyFromUtf8(this.resourceType_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.resourceType_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getResourceType()); 
    int j = i;
    if (!this.resourceName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getResourceName()); 
    i = j;
    if (!this.owner_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(3, getOwner()); 
    j = i;
    if (!this.description_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getDescription()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.resourceType_.isEmpty())
      paramCodedOutputStream.writeString(1, getResourceType()); 
    if (!this.resourceName_.isEmpty())
      paramCodedOutputStream.writeString(2, getResourceName()); 
    if (!this.owner_.isEmpty())
      paramCodedOutputStream.writeString(3, getOwner()); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(4, getDescription()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
    private Builder() {
      super(ResourceInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearOwner() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearOwner();
      return this;
    }
    
    public Builder clearResourceName() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearResourceName();
      return this;
    }
    
    public Builder clearResourceType() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearResourceType();
      return this;
    }
    
    public String getDescription() {
      return ((ResourceInfo)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((ResourceInfo)this.instance).getDescriptionBytes();
    }
    
    public String getOwner() {
      return ((ResourceInfo)this.instance).getOwner();
    }
    
    public ByteString getOwnerBytes() {
      return ((ResourceInfo)this.instance).getOwnerBytes();
    }
    
    public String getResourceName() {
      return ((ResourceInfo)this.instance).getResourceName();
    }
    
    public ByteString getResourceNameBytes() {
      return ((ResourceInfo)this.instance).getResourceNameBytes();
    }
    
    public String getResourceType() {
      return ((ResourceInfo)this.instance).getResourceType();
    }
    
    public ByteString getResourceTypeBytes() {
      return ((ResourceInfo)this.instance).getResourceTypeBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setOwner(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setOwner(param1String);
      return this;
    }
    
    public Builder setOwnerBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setOwnerBytes(param1ByteString);
      return this;
    }
    
    public Builder setResourceName(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceName(param1String);
      return this;
    }
    
    public Builder setResourceNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setResourceType(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceType(param1String);
      return this;
    }
    
    public Builder setResourceTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceTypeBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\ResourceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */