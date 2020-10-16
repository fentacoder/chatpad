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

public final class ListDocumentsResponse extends GeneratedMessageLite<ListDocumentsResponse, ListDocumentsResponse.Builder> implements ListDocumentsResponseOrBuilder {
  private static final ListDocumentsResponse DEFAULT_INSTANCE = new ListDocumentsResponse();
  
  public static final int DOCUMENTS_FIELD_NUMBER = 1;
  
  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  
  private static volatile Parser<ListDocumentsResponse> PARSER;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Document> documents_ = emptyProtobufList();
  
  private String nextPageToken_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllDocuments(Iterable<? extends Document> paramIterable) {
    ensureDocumentsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.documents_);
  }
  
  private void addDocuments(int paramInt, Document.Builder paramBuilder) {
    ensureDocumentsIsMutable();
    this.documents_.add(paramInt, paramBuilder.build());
  }
  
  private void addDocuments(int paramInt, Document paramDocument) {
    if (paramDocument != null) {
      ensureDocumentsIsMutable();
      this.documents_.add(paramInt, paramDocument);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addDocuments(Document.Builder paramBuilder) {
    ensureDocumentsIsMutable();
    this.documents_.add(paramBuilder.build());
  }
  
  private void addDocuments(Document paramDocument) {
    if (paramDocument != null) {
      ensureDocumentsIsMutable();
      this.documents_.add(paramDocument);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDocuments() {
    this.documents_ = emptyProtobufList();
  }
  
  private void clearNextPageToken() {
    this.nextPageToken_ = getDefaultInstance().getNextPageToken();
  }
  
  private void ensureDocumentsIsMutable() {
    if (!this.documents_.isModifiable())
      this.documents_ = GeneratedMessageLite.mutableCopy(this.documents_); 
  }
  
  public static ListDocumentsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ListDocumentsResponse paramListDocumentsResponse) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramListDocumentsResponse);
  }
  
  public static ListDocumentsResponse parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ListDocumentsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListDocumentsResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsResponse)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsResponse parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ListDocumentsResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsResponse parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ListDocumentsResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsResponse parseFrom(InputStream paramInputStream) throws IOException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ListDocumentsResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ListDocumentsResponse parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ListDocumentsResponse parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ListDocumentsResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ListDocumentsResponse> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeDocuments(int paramInt) {
    ensureDocumentsIsMutable();
    this.documents_.remove(paramInt);
  }
  
  private void setDocuments(int paramInt, Document.Builder paramBuilder) {
    ensureDocumentsIsMutable();
    this.documents_.set(paramInt, paramBuilder.build());
  }
  
  private void setDocuments(int paramInt, Document paramDocument) {
    if (paramDocument != null) {
      ensureDocumentsIsMutable();
      this.documents_.set(paramInt, paramDocument);
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
    //   0: getstatic com/google/firestore/v1/ListDocumentsResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 393, 2 -> 389, 3 -> 378, 4 -> 369, 5 -> 283, 6 -> 110, 7 -> 279, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/ListDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/ListDocumentsResponse
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/ListDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/ListDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsResponse;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/ListDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/ListDocumentsResponse
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/ListDocumentsResponse
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/ListDocumentsResponse.PARSER : Lcom/google/protobuf/Parser;
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
    //   143: if_icmpeq -> 176
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 165
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 223
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   170: putfield nextPageToken_ : Ljava/lang/String;
    //   173: goto -> 123
    //   176: aload_0
    //   177: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   180: invokeinterface isModifiable : ()Z
    //   185: ifne -> 199
    //   188: aload_0
    //   189: aload_0
    //   190: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   193: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   196: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   199: aload_0
    //   200: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_1
    //   204: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   207: aload_2
    //   208: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   211: checkcast com/google/firestore/v1/Document
    //   214: invokeinterface add : (Ljava/lang/Object;)Z
    //   219: pop
    //   220: goto -> 123
    //   223: iconst_1
    //   224: istore #4
    //   226: goto -> 123
    //   229: astore_1
    //   230: goto -> 277
    //   233: astore_3
    //   234: new java/lang/RuntimeException
    //   237: astore_2
    //   238: new com/google/protobuf/InvalidProtocolBufferException
    //   241: astore_1
    //   242: aload_1
    //   243: aload_3
    //   244: invokevirtual getMessage : ()Ljava/lang/String;
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: aload_2
    //   251: aload_1
    //   252: aload_0
    //   253: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   256: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   259: aload_2
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
    //   279: getstatic com/google/firestore/v1/ListDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsResponse;
    //   282: areturn
    //   283: aload_2
    //   284: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   287: astore_1
    //   288: aload_3
    //   289: checkcast com/google/firestore/v1/ListDocumentsResponse
    //   292: astore_2
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   299: aload_2
    //   300: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   303: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   308: putfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   311: aload_0
    //   312: aload_1
    //   313: aload_0
    //   314: getfield nextPageToken_ : Ljava/lang/String;
    //   317: invokevirtual isEmpty : ()Z
    //   320: iconst_1
    //   321: ixor
    //   322: aload_0
    //   323: getfield nextPageToken_ : Ljava/lang/String;
    //   326: iconst_1
    //   327: aload_2
    //   328: getfield nextPageToken_ : Ljava/lang/String;
    //   331: invokevirtual isEmpty : ()Z
    //   334: ixor
    //   335: aload_2
    //   336: getfield nextPageToken_ : Ljava/lang/String;
    //   339: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   344: putfield nextPageToken_ : Ljava/lang/String;
    //   347: aload_1
    //   348: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   351: if_acmpne -> 367
    //   354: aload_0
    //   355: aload_0
    //   356: getfield bitField0_ : I
    //   359: aload_2
    //   360: getfield bitField0_ : I
    //   363: ior
    //   364: putfield bitField0_ : I
    //   367: aload_0
    //   368: areturn
    //   369: new com/google/firestore/v1/ListDocumentsResponse$Builder
    //   372: dup
    //   373: aconst_null
    //   374: invokespecial <init> : (Lcom/google/firestore/v1/ListDocumentsResponse$1;)V
    //   377: areturn
    //   378: aload_0
    //   379: getfield documents_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   382: invokeinterface makeImmutable : ()V
    //   387: aconst_null
    //   388: areturn
    //   389: getstatic com/google/firestore/v1/ListDocumentsResponse.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ListDocumentsResponse;
    //   392: areturn
    //   393: new com/google/firestore/v1/ListDocumentsResponse
    //   396: dup
    //   397: invokespecial <init> : ()V
    //   400: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	261	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	233	java/io/IOException
    //   128	134	229	finally
    //   153	162	261	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	233	java/io/IOException
    //   153	162	229	finally
    //   165	173	261	com/google/protobuf/InvalidProtocolBufferException
    //   165	173	233	java/io/IOException
    //   165	173	229	finally
    //   176	199	261	com/google/protobuf/InvalidProtocolBufferException
    //   176	199	233	java/io/IOException
    //   176	199	229	finally
    //   199	220	261	com/google/protobuf/InvalidProtocolBufferException
    //   199	220	233	java/io/IOException
    //   199	220	229	finally
    //   234	261	229	finally
    //   262	277	229	finally
  }
  
  public Document getDocuments(int paramInt) {
    return (Document)this.documents_.get(paramInt);
  }
  
  public int getDocumentsCount() {
    return this.documents_.size();
  }
  
  public List<Document> getDocumentsList() {
    return (List<Document>)this.documents_;
  }
  
  public DocumentOrBuilder getDocumentsOrBuilder(int paramInt) {
    return (DocumentOrBuilder)this.documents_.get(paramInt);
  }
  
  public List<? extends DocumentOrBuilder> getDocumentsOrBuilderList() {
    return (List)this.documents_;
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
    int j = 0;
    i = 0;
    while (j < this.documents_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.documents_.get(j));
      j++;
    } 
    j = i;
    if (!this.nextPageToken_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getNextPageToken()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.documents_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.documents_.get(b)); 
    if (!this.nextPageToken_.isEmpty())
      paramCodedOutputStream.writeString(2, getNextPageToken()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
    private Builder() {
      super(ListDocumentsResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllDocuments(Iterable<? extends Document> param1Iterable) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).addAllDocuments(param1Iterable);
      return this;
    }
    
    public Builder addDocuments(int param1Int, Document.Builder param1Builder) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).addDocuments(param1Int, param1Builder);
      return this;
    }
    
    public Builder addDocuments(int param1Int, Document param1Document) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).addDocuments(param1Int, param1Document);
      return this;
    }
    
    public Builder addDocuments(Document.Builder param1Builder) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).addDocuments(param1Builder);
      return this;
    }
    
    public Builder addDocuments(Document param1Document) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).addDocuments(param1Document);
      return this;
    }
    
    public Builder clearDocuments() {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).clearDocuments();
      return this;
    }
    
    public Builder clearNextPageToken() {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).clearNextPageToken();
      return this;
    }
    
    public Document getDocuments(int param1Int) {
      return ((ListDocumentsResponse)this.instance).getDocuments(param1Int);
    }
    
    public int getDocumentsCount() {
      return ((ListDocumentsResponse)this.instance).getDocumentsCount();
    }
    
    public List<Document> getDocumentsList() {
      return Collections.unmodifiableList(((ListDocumentsResponse)this.instance).getDocumentsList());
    }
    
    public String getNextPageToken() {
      return ((ListDocumentsResponse)this.instance).getNextPageToken();
    }
    
    public ByteString getNextPageTokenBytes() {
      return ((ListDocumentsResponse)this.instance).getNextPageTokenBytes();
    }
    
    public Builder removeDocuments(int param1Int) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).removeDocuments(param1Int);
      return this;
    }
    
    public Builder setDocuments(int param1Int, Document.Builder param1Builder) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).setDocuments(param1Int, param1Builder);
      return this;
    }
    
    public Builder setDocuments(int param1Int, Document param1Document) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).setDocuments(param1Int, param1Document);
      return this;
    }
    
    public Builder setNextPageToken(String param1String) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).setNextPageToken(param1String);
      return this;
    }
    
    public Builder setNextPageTokenBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ListDocumentsResponse)this.instance).setNextPageTokenBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ListDocumentsResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */