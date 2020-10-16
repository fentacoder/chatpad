package com.google.firestore.v1;

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

public final class ListCollectionIdsResponse extends GeneratedMessageLite<ListCollectionIdsResponse, ListCollectionIdsResponse.Builder> implements ListCollectionIdsResponseOrBuilder {
  public static final int COLLECTION_IDS_FIELD_NUMBER = 1;
  
  private static final ListCollectionIdsResponse DEFAULT_INSTANCE = new ListCollectionIdsResponse();
  
  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  
  private static volatile Parser<ListCollectionIdsResponse> PARSER;
  
  private int bitField0_;
  
  private Internal.ProtobufList<String> collectionIds_ = GeneratedMessageLite.emptyProtobufList();
  
  private String nextPageToken_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllCollectionIds(Iterable<String> paramIterable) {
    ensureCollectionIdsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.collectionIds_);
  }
  
  private void addCollectionIds(String paramString) {
    if (paramString != null) {
      ensureCollectionIdsIsMutable();
      this.collectionIds_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addCollectionIdsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureCollectionIdsIsMutable();
      this.collectionIds_.add(paramByteString.toStringUtf8());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearCollectionIds() {
    this.collectionIds_ = GeneratedMessageLite.emptyProtobufList();
  }
  
  private void clearNextPageToken() {
    this.nextPageToken_ = getDefaultInstance().getNextPageToken();
  }
  
  private void ensureCollectionIdsIsMutable() {
    if (!this.collectionIds_.isModifiable())
      this.collectionIds_ = GeneratedMessageLite.mutableCopy(this.collectionIds_); 
  }
  
  public static ListCollectionIdsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListCollectionIdsResponse paramListCollectionIdsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListCollectionIdsResponse);
  }
  
  public static ListCollectionIdsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListCollectionIdsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCollectionIdsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListCollectionIdsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListCollectionIdsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListCollectionIdsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListCollectionIdsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListCollectionIdsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListCollectionIdsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListCollectionIdsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setCollectionIds(int paramInt, String paramString) {
    if (paramString != null) {
      ensureCollectionIdsIsMutable();
      this.collectionIds_.set(paramInt, paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNextPageToken(String paramString) {
    if (paramString != null) {
      this.nextPageToken_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNextPageTokenBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.nextPageToken_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ListCollectionIdsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 388, 2 -> 384, 3 -> 373, 4 -> 364, 5 -> 278, 6 -> 110, 7 -> 274, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/ListCollectionIdsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/ListCollectionIdsResponse
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/ListCollectionIdsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/ListCollectionIdsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/ListCollectionIdsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/ListCollectionIdsResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/ListCollectionIdsResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/ListCollectionIdsResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   170: putfield nextPageToken_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_1
    //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   180: astore_2
    //   181: aload_0
    //   182: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: invokeinterface isModifiable : ()Z
    //   190: ifne -> 204
    //   193: aload_0
    //   194: aload_0
    //   195: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   198: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   201: putfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   204: aload_0
    //   205: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   208: aload_2
    //   209: invokeinterface add : (Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -> 123
    //   218: iconst_1
    //   219: istore #4
    //   221: goto -> 123
    //   224: astore_1
    //   225: goto -> 272
    //   228: astore_2
    //   229: new java/lang/RuntimeException
    //   232: astore_1
    //   233: new com/google/protobuf/InvalidProtocolBufferException
    //   236: astore_3
    //   237: aload_3
    //   238: aload_2
    //   239: invokevirtual getMessage : ()Ljava/lang/String;
    //   242: invokespecial <init> : (Ljava/lang/String;)V
    //   245: aload_1
    //   246: aload_3
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
    //   274: getstatic com/google/firestore/v1/ListCollectionIdsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsResponse;
    //   277: areturn
    //   278: aload_2
    //   279: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   282: astore_1
    //   283: aload_3
    //   284: checkcast com/google/firestore/v1/ListCollectionIdsResponse
    //   287: astore_2
    //   288: aload_0
    //   289: aload_1
    //   290: aload_0
    //   291: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   294: aload_2
    //   295: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   298: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   303: putfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   306: aload_0
    //   307: aload_1
    //   308: aload_0
    //   309: getfield nextPageToken_ : Ljava/lang/String;
    //   312: invokevirtual isEmpty : ()Z
    //   315: iconst_1
    //   316: ixor
    //   317: aload_0
    //   318: getfield nextPageToken_ : Ljava/lang/String;
    //   321: iconst_1
    //   322: aload_2
    //   323: getfield nextPageToken_ : Ljava/lang/String;
    //   326: invokevirtual isEmpty : ()Z
    //   329: ixor
    //   330: aload_2
    //   331: getfield nextPageToken_ : Ljava/lang/String;
    //   334: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   339: putfield nextPageToken_ : Ljava/lang/String;
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
    //   364: new com/google/firestore/v1/ListCollectionIdsResponse$Builder
    //   367: dup
    //   368: aconst_null
    //   369: invokespecial <init> : (Lcom/google/firestore/v1/ListCollectionIdsResponse$1;)V
    //   372: areturn
    //   373: aload_0
    //   374: getfield collectionIds_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   377: invokeinterface makeImmutable : ()V
    //   382: aconst_null
    //   383: areturn
    //   384: getstatic com/google/firestore/v1/ListCollectionIdsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListCollectionIdsResponse;
    //   387: areturn
    //   388: new com/google/firestore/v1/ListCollectionIdsResponse
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
  
  public String getCollectionIds(int paramInt) {
    return (String)this.collectionIds_.get(paramInt);
  }
  
  public ByteString getCollectionIdsBytes(int paramInt) {
    return ByteString.copyFromUtf8((String)this.collectionIds_.get(paramInt));
  }
  
  public int getCollectionIdsCount() {
    return this.collectionIds_.size();
  }
  
  public List<String> getCollectionIdsList() {
    return (List<String>)this.collectionIds_;
  }
  
  public String getNextPageToken() {
    return this.nextPageToken_;
  }
  
  public ByteString getNextPageTokenBytes() {
    return ByteString.copyFromUtf8(this.nextPageToken_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = i;
    while (i < this.collectionIds_.size()) {
      j += CodedOutputStream.computeStringSizeNoTag((String)this.collectionIds_.get(i));
      i++;
    } 
    j = 0 + j + getCollectionIdsList().size() * 1;
    i = j;
    if (!this.nextPageToken_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getNextPageToken()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.collectionIds_.size(); b++)
      paramCodedOutputStream.writeString(1, (String)this.collectionIds_.get(b)); 
    if (!this.nextPageToken_.isEmpty())
      paramCodedOutputStream.writeString(2, getNextPageToken()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
    private Builder() {
      super(ListCollectionIdsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllCollectionIds(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).addAllCollectionIds(param1Iterable);
      return this;
    }
    
    public Builder addCollectionIds(String param1String) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).addCollectionIds(param1String);
      return this;
    }
    
    public Builder addCollectionIdsBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).addCollectionIdsBytes(param1ByteString);
      return this;
    }
    
    public Builder clearCollectionIds() {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).clearCollectionIds();
      return this;
    }
    
    public Builder clearNextPageToken() {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).clearNextPageToken();
      return this;
    }
    
    public String getCollectionIds(int param1Int) {
      return ((ListCollectionIdsResponse)this.instance).getCollectionIds(param1Int);
    }
    
    public ByteString getCollectionIdsBytes(int param1Int) {
      return ((ListCollectionIdsResponse)this.instance).getCollectionIdsBytes(param1Int);
    }
    
    public int getCollectionIdsCount() {
      return ((ListCollectionIdsResponse)this.instance).getCollectionIdsCount();
    }
    
    public List<String> getCollectionIdsList() {
      return Collections.unmodifiableList(((ListCollectionIdsResponse)this.instance).getCollectionIdsList());
    }
    
    public String getNextPageToken() {
      return ((ListCollectionIdsResponse)this.instance).getNextPageToken();
    }
    
    public ByteString getNextPageTokenBytes() {
      return ((ListCollectionIdsResponse)this.instance).getNextPageTokenBytes();
    }
    
    public Builder setCollectionIds(int param1Int, String param1String) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).setCollectionIds(param1Int, param1String);
      return this;
    }
    
    public Builder setNextPageToken(String param1String) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).setNextPageToken(param1String);
      return this;
    }
    
    public Builder setNextPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListCollectionIdsResponse)this.instance).setNextPageTokenBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListCollectionIdsResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */