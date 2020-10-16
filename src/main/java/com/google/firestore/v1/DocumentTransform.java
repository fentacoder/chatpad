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
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DocumentTransform extends GeneratedMessageLite<DocumentTransform, DocumentTransform.Builder> implements DocumentTransformOrBuilder {
  private static final DocumentTransform DEFAULT_INSTANCE = new DocumentTransform();
  
  public static final int DOCUMENT_FIELD_NUMBER = 1;
  
  public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
  
  private static volatile Parser<DocumentTransform> PARSER;
  
  private int bitField0_;
  
  private String document_ = "";
  
  private Internal.ProtobufList<FieldTransform> fieldTransforms_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFieldTransforms(Iterable<? extends FieldTransform> paramIterable) {
    ensureFieldTransformsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.fieldTransforms_);
  }
  
  private void addFieldTransforms(int paramInt, FieldTransform.Builder paramBuilder) {
    ensureFieldTransformsIsMutable();
    this.fieldTransforms_.add(paramInt, paramBuilder.build());
  }
  
  private void addFieldTransforms(int paramInt, FieldTransform paramFieldTransform) {
    if (paramFieldTransform != null) {
      ensureFieldTransformsIsMutable();
      this.fieldTransforms_.add(paramInt, paramFieldTransform);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFieldTransforms(FieldTransform.Builder paramBuilder) {
    ensureFieldTransformsIsMutable();
    this.fieldTransforms_.add(paramBuilder.build());
  }
  
  private void addFieldTransforms(FieldTransform paramFieldTransform) {
    if (paramFieldTransform != null) {
      ensureFieldTransformsIsMutable();
      this.fieldTransforms_.add(paramFieldTransform);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDocument() {
    this.document_ = getDefaultInstance().getDocument();
  }
  
  private void clearFieldTransforms() {
    this.fieldTransforms_ = emptyProtobufList();
  }
  
  private void ensureFieldTransformsIsMutable() {
    if (!this.fieldTransforms_.isModifiable())
      this.fieldTransforms_ = GeneratedMessageLite.mutableCopy(this.fieldTransforms_); 
  }
  
  public static DocumentTransform getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DocumentTransform paramDocumentTransform) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocumentTransform);
  }
  
  public static DocumentTransform parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DocumentTransform)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentTransform parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentTransform)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentTransform parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DocumentTransform parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DocumentTransform parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DocumentTransform parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentTransform parseFrom(InputStream paramInputStream) throws IOException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentTransform parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentTransform parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DocumentTransform parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DocumentTransform> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFieldTransforms(int paramInt) {
    ensureFieldTransformsIsMutable();
    this.fieldTransforms_.remove(paramInt);
  }
  
  private void setDocument(String paramString) {
    if (paramString != null) {
      this.document_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDocumentBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.document_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFieldTransforms(int paramInt, FieldTransform.Builder paramBuilder) {
    ensureFieldTransformsIsMutable();
    this.fieldTransforms_.set(paramInt, paramBuilder.build());
  }
  
  private void setFieldTransforms(int paramInt, FieldTransform paramFieldTransform) {
    if (paramFieldTransform != null) {
      ensureFieldTransformsIsMutable();
      this.fieldTransforms_.set(paramInt, paramFieldTransform);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/DocumentTransform$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 393, 2 -> 389, 3 -> 378, 4 -> 369, 5 -> 283, 6 -> 110, 7 -> 279, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/DocumentTransform.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/DocumentTransform
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/DocumentTransform.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/DocumentTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/DocumentTransform.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/DocumentTransform
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/DocumentTransform
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/DocumentTransform.PARSER : Lcom/google/protobuf/Parser;
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
    //   150: if_icmpeq -> 165
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 223
    //   165: aload_0
    //   166: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   169: invokeinterface isModifiable : ()Z
    //   174: ifne -> 188
    //   177: aload_0
    //   178: aload_0
    //   179: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   182: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   185: putfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   188: aload_0
    //   189: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   192: aload_1
    //   193: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   196: aload_2
    //   197: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   200: checkcast com/google/firestore/v1/DocumentTransform$FieldTransform
    //   203: invokeinterface add : (Ljava/lang/Object;)Z
    //   208: pop
    //   209: goto -> 123
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   217: putfield document_ : Ljava/lang/String;
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
    //   261: astore_2
    //   262: new java/lang/RuntimeException
    //   265: astore_1
    //   266: aload_1
    //   267: aload_2
    //   268: aload_0
    //   269: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   272: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   275: aload_1
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: getstatic com/google/firestore/v1/DocumentTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform;
    //   282: areturn
    //   283: aload_2
    //   284: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   287: astore_1
    //   288: aload_3
    //   289: checkcast com/google/firestore/v1/DocumentTransform
    //   292: astore_2
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield document_ : Ljava/lang/String;
    //   299: invokevirtual isEmpty : ()Z
    //   302: iconst_1
    //   303: ixor
    //   304: aload_0
    //   305: getfield document_ : Ljava/lang/String;
    //   308: iconst_1
    //   309: aload_2
    //   310: getfield document_ : Ljava/lang/String;
    //   313: invokevirtual isEmpty : ()Z
    //   316: ixor
    //   317: aload_2
    //   318: getfield document_ : Ljava/lang/String;
    //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   326: putfield document_ : Ljava/lang/String;
    //   329: aload_0
    //   330: aload_1
    //   331: aload_0
    //   332: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   335: aload_2
    //   336: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   339: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   344: putfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
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
    //   369: new com/google/firestore/v1/DocumentTransform$Builder
    //   372: dup
    //   373: aconst_null
    //   374: invokespecial <init> : (Lcom/google/firestore/v1/DocumentTransform$1;)V
    //   377: areturn
    //   378: aload_0
    //   379: getfield fieldTransforms_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   382: invokeinterface makeImmutable : ()V
    //   387: aconst_null
    //   388: areturn
    //   389: getstatic com/google/firestore/v1/DocumentTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform;
    //   392: areturn
    //   393: new com/google/firestore/v1/DocumentTransform
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
    //   165	188	261	com/google/protobuf/InvalidProtocolBufferException
    //   165	188	233	java/io/IOException
    //   165	188	229	finally
    //   188	209	261	com/google/protobuf/InvalidProtocolBufferException
    //   188	209	233	java/io/IOException
    //   188	209	229	finally
    //   212	220	261	com/google/protobuf/InvalidProtocolBufferException
    //   212	220	233	java/io/IOException
    //   212	220	229	finally
    //   234	261	229	finally
    //   262	277	229	finally
  }
  
  public String getDocument() {
    return this.document_;
  }
  
  public ByteString getDocumentBytes() {
    return ByteString.copyFromUtf8(this.document_);
  }
  
  public FieldTransform getFieldTransforms(int paramInt) {
    return (FieldTransform)this.fieldTransforms_.get(paramInt);
  }
  
  public int getFieldTransformsCount() {
    return this.fieldTransforms_.size();
  }
  
  public List<FieldTransform> getFieldTransformsList() {
    return (List<FieldTransform>)this.fieldTransforms_;
  }
  
  public FieldTransformOrBuilder getFieldTransformsOrBuilder(int paramInt) {
    return (FieldTransformOrBuilder)this.fieldTransforms_.get(paramInt);
  }
  
  public List<? extends FieldTransformOrBuilder> getFieldTransformsOrBuilderList() {
    return (List)this.fieldTransforms_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.document_.isEmpty();
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getDocument()) + 0;
    } else {
      i = 0;
    } 
    while (b < this.fieldTransforms_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.fieldTransforms_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.document_.isEmpty())
      paramCodedOutputStream.writeString(1, getDocument()); 
    for (byte b = 0; b < this.fieldTransforms_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.fieldTransforms_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
    private Builder() {
      super(DocumentTransform.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFieldTransforms(Iterable<? extends DocumentTransform.FieldTransform> param1Iterable) {
      copyOnWrite();
      ((DocumentTransform)this.instance).addAllFieldTransforms(param1Iterable);
      return this;
    }
    
    public Builder addFieldTransforms(int param1Int, DocumentTransform.FieldTransform.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform)this.instance).addFieldTransforms(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFieldTransforms(int param1Int, DocumentTransform.FieldTransform param1FieldTransform) {
      copyOnWrite();
      ((DocumentTransform)this.instance).addFieldTransforms(param1Int, param1FieldTransform);
      return this;
    }
    
    public Builder addFieldTransforms(DocumentTransform.FieldTransform.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform)this.instance).addFieldTransforms(param1Builder);
      return this;
    }
    
    public Builder addFieldTransforms(DocumentTransform.FieldTransform param1FieldTransform) {
      copyOnWrite();
      ((DocumentTransform)this.instance).addFieldTransforms(param1FieldTransform);
      return this;
    }
    
    public Builder clearDocument() {
      copyOnWrite();
      ((DocumentTransform)this.instance).clearDocument();
      return this;
    }
    
    public Builder clearFieldTransforms() {
      copyOnWrite();
      ((DocumentTransform)this.instance).clearFieldTransforms();
      return this;
    }
    
    public String getDocument() {
      return ((DocumentTransform)this.instance).getDocument();
    }
    
    public ByteString getDocumentBytes() {
      return ((DocumentTransform)this.instance).getDocumentBytes();
    }
    
    public DocumentTransform.FieldTransform getFieldTransforms(int param1Int) {
      return ((DocumentTransform)this.instance).getFieldTransforms(param1Int);
    }
    
    public int getFieldTransformsCount() {
      return ((DocumentTransform)this.instance).getFieldTransformsCount();
    }
    
    public List<DocumentTransform.FieldTransform> getFieldTransformsList() {
      return Collections.unmodifiableList(((DocumentTransform)this.instance).getFieldTransformsList());
    }
    
    public Builder removeFieldTransforms(int param1Int) {
      copyOnWrite();
      ((DocumentTransform)this.instance).removeFieldTransforms(param1Int);
      return this;
    }
    
    public Builder setDocument(String param1String) {
      copyOnWrite();
      ((DocumentTransform)this.instance).setDocument(param1String);
      return this;
    }
    
    public Builder setDocumentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentTransform)this.instance).setDocumentBytes(param1ByteString);
      return this;
    }
    
    public Builder setFieldTransforms(int param1Int, DocumentTransform.FieldTransform.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform)this.instance).setFieldTransforms(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFieldTransforms(int param1Int, DocumentTransform.FieldTransform param1FieldTransform) {
      copyOnWrite();
      ((DocumentTransform)this.instance).setFieldTransforms(param1Int, param1FieldTransform);
      return this;
    }
  }
  
  public static final class FieldTransform extends GeneratedMessageLite<FieldTransform, FieldTransform.Builder> implements FieldTransformOrBuilder {
    public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
    
    private static final FieldTransform DEFAULT_INSTANCE = new FieldTransform();
    
    public static final int FIELD_PATH_FIELD_NUMBER = 1;
    
    public static final int INCREMENT_FIELD_NUMBER = 3;
    
    public static final int MAXIMUM_FIELD_NUMBER = 4;
    
    public static final int MINIMUM_FIELD_NUMBER = 5;
    
    private static volatile Parser<FieldTransform> PARSER;
    
    public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
    
    public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
    
    private String fieldPath_ = "";
    
    private int transformTypeCase_ = 0;
    
    private Object transformType_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAppendMissingElements() {
      if (this.transformTypeCase_ == 6) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearFieldPath() {
      this.fieldPath_ = getDefaultInstance().getFieldPath();
    }
    
    private void clearIncrement() {
      if (this.transformTypeCase_ == 3) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearMaximum() {
      if (this.transformTypeCase_ == 4) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearMinimum() {
      if (this.transformTypeCase_ == 5) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearRemoveAllFromArray() {
      if (this.transformTypeCase_ == 7) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearSetToServerValue() {
      if (this.transformTypeCase_ == 2) {
        this.transformTypeCase_ = 0;
        this.transformType_ = null;
      } 
    }
    
    private void clearTransformType() {
      this.transformTypeCase_ = 0;
      this.transformType_ = null;
    }
    
    public static FieldTransform getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeAppendMissingElements(ArrayValue param1ArrayValue) {
      if (this.transformTypeCase_ == 6 && this.transformType_ != ArrayValue.getDefaultInstance()) {
        this.transformType_ = ((ArrayValue.Builder)ArrayValue.newBuilder((ArrayValue)this.transformType_).mergeFrom(param1ArrayValue)).buildPartial();
      } else {
        this.transformType_ = param1ArrayValue;
      } 
      this.transformTypeCase_ = 6;
    }
    
    private void mergeIncrement(Value param1Value) {
      if (this.transformTypeCase_ == 3 && this.transformType_ != Value.getDefaultInstance()) {
        this.transformType_ = ((Value.Builder)Value.newBuilder((Value)this.transformType_).mergeFrom(param1Value)).buildPartial();
      } else {
        this.transformType_ = param1Value;
      } 
      this.transformTypeCase_ = 3;
    }
    
    private void mergeMaximum(Value param1Value) {
      if (this.transformTypeCase_ == 4 && this.transformType_ != Value.getDefaultInstance()) {
        this.transformType_ = ((Value.Builder)Value.newBuilder((Value)this.transformType_).mergeFrom(param1Value)).buildPartial();
      } else {
        this.transformType_ = param1Value;
      } 
      this.transformTypeCase_ = 4;
    }
    
    private void mergeMinimum(Value param1Value) {
      if (this.transformTypeCase_ == 5 && this.transformType_ != Value.getDefaultInstance()) {
        this.transformType_ = ((Value.Builder)Value.newBuilder((Value)this.transformType_).mergeFrom(param1Value)).buildPartial();
      } else {
        this.transformType_ = param1Value;
      } 
      this.transformTypeCase_ = 5;
    }
    
    private void mergeRemoveAllFromArray(ArrayValue param1ArrayValue) {
      if (this.transformTypeCase_ == 7 && this.transformType_ != ArrayValue.getDefaultInstance()) {
        this.transformType_ = ((ArrayValue.Builder)ArrayValue.newBuilder((ArrayValue)this.transformType_).mergeFrom(param1ArrayValue)).buildPartial();
      } else {
        this.transformType_ = param1ArrayValue;
      } 
      this.transformTypeCase_ = 7;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldTransform param1FieldTransform) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldTransform);
    }
    
    public static FieldTransform parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldTransform)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldTransform parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldTransform)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldTransform parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldTransform parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldTransform parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldTransform parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldTransform parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldTransform parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldTransform parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldTransform parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldTransform)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldTransform> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAppendMissingElements(ArrayValue.Builder param1Builder) {
      this.transformType_ = param1Builder.build();
      this.transformTypeCase_ = 6;
    }
    
    private void setAppendMissingElements(ArrayValue param1ArrayValue) {
      if (param1ArrayValue != null) {
        this.transformType_ = param1ArrayValue;
        this.transformTypeCase_ = 6;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFieldPath(String param1String) {
      if (param1String != null) {
        this.fieldPath_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFieldPathBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.fieldPath_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setIncrement(Value.Builder param1Builder) {
      this.transformType_ = param1Builder.build();
      this.transformTypeCase_ = 3;
    }
    
    private void setIncrement(Value param1Value) {
      if (param1Value != null) {
        this.transformType_ = param1Value;
        this.transformTypeCase_ = 3;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setMaximum(Value.Builder param1Builder) {
      this.transformType_ = param1Builder.build();
      this.transformTypeCase_ = 4;
    }
    
    private void setMaximum(Value param1Value) {
      if (param1Value != null) {
        this.transformType_ = param1Value;
        this.transformTypeCase_ = 4;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setMinimum(Value.Builder param1Builder) {
      this.transformType_ = param1Builder.build();
      this.transformTypeCase_ = 5;
    }
    
    private void setMinimum(Value param1Value) {
      if (param1Value != null) {
        this.transformType_ = param1Value;
        this.transformTypeCase_ = 5;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setRemoveAllFromArray(ArrayValue.Builder param1Builder) {
      this.transformType_ = param1Builder.build();
      this.transformTypeCase_ = 7;
    }
    
    private void setRemoveAllFromArray(ArrayValue param1ArrayValue) {
      if (param1ArrayValue != null) {
        this.transformType_ = param1ArrayValue;
        this.transformTypeCase_ = 7;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSetToServerValue(ServerValue param1ServerValue) {
      if (param1ServerValue != null) {
        this.transformTypeCase_ = 2;
        this.transformType_ = Integer.valueOf(param1ServerValue.getNumber());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSetToServerValueValue(int param1Int) {
      this.transformTypeCase_ = 2;
      this.transformType_ = Integer.valueOf(param1Int);
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/DocumentTransform$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iconst_0
      //   17: istore #7
      //   19: iconst_0
      //   20: istore #8
      //   22: iconst_0
      //   23: istore #9
      //   25: iconst_0
      //   26: istore #10
      //   28: iconst_0
      //   29: istore #11
      //   31: iconst_0
      //   32: istore #12
      //   34: iload #4
      //   36: tableswitch default -> 84, 1 -> 1068, 2 -> 1064, 3 -> 1062, 4 -> 1053, 5 -> 678, 6 -> 138, 7 -> 674, 8 -> 92
      //   84: new java/lang/UnsupportedOperationException
      //   87: dup
      //   88: invokespecial <init> : ()V
      //   91: athrow
      //   92: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.PARSER : Lcom/google/protobuf/Parser;
      //   95: ifnonnull -> 134
      //   98: ldc com/google/firestore/v1/DocumentTransform$FieldTransform
      //   100: monitorenter
      //   101: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.PARSER : Lcom/google/protobuf/Parser;
      //   104: ifnonnull -> 122
      //   107: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   110: astore_1
      //   111: aload_1
      //   112: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform$FieldTransform;
      //   115: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   118: aload_1
      //   119: putstatic com/google/firestore/v1/DocumentTransform$FieldTransform.PARSER : Lcom/google/protobuf/Parser;
      //   122: ldc com/google/firestore/v1/DocumentTransform$FieldTransform
      //   124: monitorexit
      //   125: goto -> 134
      //   128: astore_1
      //   129: ldc com/google/firestore/v1/DocumentTransform$FieldTransform
      //   131: monitorexit
      //   132: aload_1
      //   133: athrow
      //   134: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.PARSER : Lcom/google/protobuf/Parser;
      //   137: areturn
      //   138: aload_2
      //   139: checkcast com/google/protobuf/CodedInputStream
      //   142: astore_2
      //   143: aload_3
      //   144: checkcast com/google/protobuf/ExtensionRegistryLite
      //   147: astore_3
      //   148: iload #12
      //   150: ifne -> 674
      //   153: aload_2
      //   154: invokevirtual readTag : ()I
      //   157: istore #4
      //   159: iload #4
      //   161: ifeq -> 618
      //   164: iload #4
      //   166: bipush #10
      //   168: if_icmpeq -> 607
      //   171: iload #4
      //   173: bipush #16
      //   175: if_icmpeq -> 584
      //   178: iload #4
      //   180: bipush #26
      //   182: if_icmpeq -> 513
      //   185: iload #4
      //   187: bipush #34
      //   189: if_icmpeq -> 442
      //   192: iload #4
      //   194: bipush #42
      //   196: if_icmpeq -> 371
      //   199: iload #4
      //   201: bipush #50
      //   203: if_icmpeq -> 298
      //   206: iload #4
      //   208: bipush #58
      //   210: if_icmpeq -> 225
      //   213: aload_2
      //   214: iload #4
      //   216: invokevirtual skipField : (I)Z
      //   219: ifne -> 148
      //   222: goto -> 618
      //   225: aload_0
      //   226: getfield transformTypeCase_ : I
      //   229: bipush #7
      //   231: if_icmpne -> 251
      //   234: aload_0
      //   235: getfield transformType_ : Ljava/lang/Object;
      //   238: checkcast com/google/firestore/v1/ArrayValue
      //   241: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   244: checkcast com/google/firestore/v1/ArrayValue$Builder
      //   247: astore_1
      //   248: goto -> 253
      //   251: aconst_null
      //   252: astore_1
      //   253: aload_0
      //   254: aload_2
      //   255: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   258: aload_3
      //   259: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   262: putfield transformType_ : Ljava/lang/Object;
      //   265: aload_1
      //   266: ifnull -> 289
      //   269: aload_1
      //   270: aload_0
      //   271: getfield transformType_ : Ljava/lang/Object;
      //   274: checkcast com/google/firestore/v1/ArrayValue
      //   277: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   280: pop
      //   281: aload_0
      //   282: aload_1
      //   283: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   286: putfield transformType_ : Ljava/lang/Object;
      //   289: aload_0
      //   290: bipush #7
      //   292: putfield transformTypeCase_ : I
      //   295: goto -> 148
      //   298: aload_0
      //   299: getfield transformTypeCase_ : I
      //   302: bipush #6
      //   304: if_icmpne -> 324
      //   307: aload_0
      //   308: getfield transformType_ : Ljava/lang/Object;
      //   311: checkcast com/google/firestore/v1/ArrayValue
      //   314: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   317: checkcast com/google/firestore/v1/ArrayValue$Builder
      //   320: astore_1
      //   321: goto -> 326
      //   324: aconst_null
      //   325: astore_1
      //   326: aload_0
      //   327: aload_2
      //   328: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   331: aload_3
      //   332: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   335: putfield transformType_ : Ljava/lang/Object;
      //   338: aload_1
      //   339: ifnull -> 362
      //   342: aload_1
      //   343: aload_0
      //   344: getfield transformType_ : Ljava/lang/Object;
      //   347: checkcast com/google/firestore/v1/ArrayValue
      //   350: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   353: pop
      //   354: aload_0
      //   355: aload_1
      //   356: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   359: putfield transformType_ : Ljava/lang/Object;
      //   362: aload_0
      //   363: bipush #6
      //   365: putfield transformTypeCase_ : I
      //   368: goto -> 148
      //   371: aload_0
      //   372: getfield transformTypeCase_ : I
      //   375: iconst_5
      //   376: if_icmpne -> 396
      //   379: aload_0
      //   380: getfield transformType_ : Ljava/lang/Object;
      //   383: checkcast com/google/firestore/v1/Value
      //   386: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   389: checkcast com/google/firestore/v1/Value$Builder
      //   392: astore_1
      //   393: goto -> 398
      //   396: aconst_null
      //   397: astore_1
      //   398: aload_0
      //   399: aload_2
      //   400: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   403: aload_3
      //   404: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   407: putfield transformType_ : Ljava/lang/Object;
      //   410: aload_1
      //   411: ifnull -> 434
      //   414: aload_1
      //   415: aload_0
      //   416: getfield transformType_ : Ljava/lang/Object;
      //   419: checkcast com/google/firestore/v1/Value
      //   422: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   425: pop
      //   426: aload_0
      //   427: aload_1
      //   428: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   431: putfield transformType_ : Ljava/lang/Object;
      //   434: aload_0
      //   435: iconst_5
      //   436: putfield transformTypeCase_ : I
      //   439: goto -> 148
      //   442: aload_0
      //   443: getfield transformTypeCase_ : I
      //   446: iconst_4
      //   447: if_icmpne -> 467
      //   450: aload_0
      //   451: getfield transformType_ : Ljava/lang/Object;
      //   454: checkcast com/google/firestore/v1/Value
      //   457: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   460: checkcast com/google/firestore/v1/Value$Builder
      //   463: astore_1
      //   464: goto -> 469
      //   467: aconst_null
      //   468: astore_1
      //   469: aload_0
      //   470: aload_2
      //   471: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   474: aload_3
      //   475: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   478: putfield transformType_ : Ljava/lang/Object;
      //   481: aload_1
      //   482: ifnull -> 505
      //   485: aload_1
      //   486: aload_0
      //   487: getfield transformType_ : Ljava/lang/Object;
      //   490: checkcast com/google/firestore/v1/Value
      //   493: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   496: pop
      //   497: aload_0
      //   498: aload_1
      //   499: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   502: putfield transformType_ : Ljava/lang/Object;
      //   505: aload_0
      //   506: iconst_4
      //   507: putfield transformTypeCase_ : I
      //   510: goto -> 148
      //   513: aload_0
      //   514: getfield transformTypeCase_ : I
      //   517: iconst_3
      //   518: if_icmpne -> 538
      //   521: aload_0
      //   522: getfield transformType_ : Ljava/lang/Object;
      //   525: checkcast com/google/firestore/v1/Value
      //   528: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   531: checkcast com/google/firestore/v1/Value$Builder
      //   534: astore_1
      //   535: goto -> 540
      //   538: aconst_null
      //   539: astore_1
      //   540: aload_0
      //   541: aload_2
      //   542: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   545: aload_3
      //   546: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   549: putfield transformType_ : Ljava/lang/Object;
      //   552: aload_1
      //   553: ifnull -> 576
      //   556: aload_1
      //   557: aload_0
      //   558: getfield transformType_ : Ljava/lang/Object;
      //   561: checkcast com/google/firestore/v1/Value
      //   564: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   567: pop
      //   568: aload_0
      //   569: aload_1
      //   570: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   573: putfield transformType_ : Ljava/lang/Object;
      //   576: aload_0
      //   577: iconst_3
      //   578: putfield transformTypeCase_ : I
      //   581: goto -> 148
      //   584: aload_2
      //   585: invokevirtual readEnum : ()I
      //   588: istore #4
      //   590: aload_0
      //   591: iconst_2
      //   592: putfield transformTypeCase_ : I
      //   595: aload_0
      //   596: iload #4
      //   598: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   601: putfield transformType_ : Ljava/lang/Object;
      //   604: goto -> 148
      //   607: aload_0
      //   608: aload_2
      //   609: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   612: putfield fieldPath_ : Ljava/lang/String;
      //   615: goto -> 148
      //   618: iconst_1
      //   619: istore #12
      //   621: goto -> 148
      //   624: astore_1
      //   625: goto -> 672
      //   628: astore_3
      //   629: new java/lang/RuntimeException
      //   632: astore_1
      //   633: new com/google/protobuf/InvalidProtocolBufferException
      //   636: astore_2
      //   637: aload_2
      //   638: aload_3
      //   639: invokevirtual getMessage : ()Ljava/lang/String;
      //   642: invokespecial <init> : (Ljava/lang/String;)V
      //   645: aload_1
      //   646: aload_2
      //   647: aload_0
      //   648: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   651: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   654: aload_1
      //   655: athrow
      //   656: astore_2
      //   657: new java/lang/RuntimeException
      //   660: astore_1
      //   661: aload_1
      //   662: aload_2
      //   663: aload_0
      //   664: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   667: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   670: aload_1
      //   671: athrow
      //   672: aload_1
      //   673: athrow
      //   674: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform$FieldTransform;
      //   677: areturn
      //   678: aload_2
      //   679: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   682: astore_1
      //   683: aload_3
      //   684: checkcast com/google/firestore/v1/DocumentTransform$FieldTransform
      //   687: astore_2
      //   688: aload_0
      //   689: aload_1
      //   690: aload_0
      //   691: getfield fieldPath_ : Ljava/lang/String;
      //   694: invokevirtual isEmpty : ()Z
      //   697: iconst_1
      //   698: ixor
      //   699: aload_0
      //   700: getfield fieldPath_ : Ljava/lang/String;
      //   703: aload_2
      //   704: getfield fieldPath_ : Ljava/lang/String;
      //   707: invokevirtual isEmpty : ()Z
      //   710: iconst_1
      //   711: ixor
      //   712: aload_2
      //   713: getfield fieldPath_ : Ljava/lang/String;
      //   716: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   721: putfield fieldPath_ : Ljava/lang/String;
      //   724: getstatic com/google/firestore/v1/DocumentTransform$1.$SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase : [I
      //   727: aload_2
      //   728: invokevirtual getTransformTypeCase : ()Lcom/google/firestore/v1/DocumentTransform$FieldTransform$TransformTypeCase;
      //   731: invokevirtual ordinal : ()I
      //   734: iaload
      //   735: tableswitch default -> 776, 1 -> 992, 2 -> 954, 3 -> 916, 4 -> 878, 5 -> 839, 6 -> 800, 7 -> 779
      //   776: goto -> 1027
      //   779: aload_0
      //   780: getfield transformTypeCase_ : I
      //   783: ifeq -> 789
      //   786: iconst_1
      //   787: istore #5
      //   789: aload_1
      //   790: iload #5
      //   792: invokeinterface visitOneofNotSet : (Z)V
      //   797: goto -> 1027
      //   800: iload #6
      //   802: istore #5
      //   804: aload_0
      //   805: getfield transformTypeCase_ : I
      //   808: bipush #7
      //   810: if_icmpne -> 816
      //   813: iconst_1
      //   814: istore #5
      //   816: aload_0
      //   817: aload_1
      //   818: iload #5
      //   820: aload_0
      //   821: getfield transformType_ : Ljava/lang/Object;
      //   824: aload_2
      //   825: getfield transformType_ : Ljava/lang/Object;
      //   828: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   833: putfield transformType_ : Ljava/lang/Object;
      //   836: goto -> 1027
      //   839: iload #7
      //   841: istore #5
      //   843: aload_0
      //   844: getfield transformTypeCase_ : I
      //   847: bipush #6
      //   849: if_icmpne -> 855
      //   852: iconst_1
      //   853: istore #5
      //   855: aload_0
      //   856: aload_1
      //   857: iload #5
      //   859: aload_0
      //   860: getfield transformType_ : Ljava/lang/Object;
      //   863: aload_2
      //   864: getfield transformType_ : Ljava/lang/Object;
      //   867: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   872: putfield transformType_ : Ljava/lang/Object;
      //   875: goto -> 1027
      //   878: iload #8
      //   880: istore #5
      //   882: aload_0
      //   883: getfield transformTypeCase_ : I
      //   886: iconst_5
      //   887: if_icmpne -> 893
      //   890: iconst_1
      //   891: istore #5
      //   893: aload_0
      //   894: aload_1
      //   895: iload #5
      //   897: aload_0
      //   898: getfield transformType_ : Ljava/lang/Object;
      //   901: aload_2
      //   902: getfield transformType_ : Ljava/lang/Object;
      //   905: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   910: putfield transformType_ : Ljava/lang/Object;
      //   913: goto -> 1027
      //   916: iload #9
      //   918: istore #5
      //   920: aload_0
      //   921: getfield transformTypeCase_ : I
      //   924: iconst_4
      //   925: if_icmpne -> 931
      //   928: iconst_1
      //   929: istore #5
      //   931: aload_0
      //   932: aload_1
      //   933: iload #5
      //   935: aload_0
      //   936: getfield transformType_ : Ljava/lang/Object;
      //   939: aload_2
      //   940: getfield transformType_ : Ljava/lang/Object;
      //   943: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   948: putfield transformType_ : Ljava/lang/Object;
      //   951: goto -> 1027
      //   954: iload #10
      //   956: istore #5
      //   958: aload_0
      //   959: getfield transformTypeCase_ : I
      //   962: iconst_3
      //   963: if_icmpne -> 969
      //   966: iconst_1
      //   967: istore #5
      //   969: aload_0
      //   970: aload_1
      //   971: iload #5
      //   973: aload_0
      //   974: getfield transformType_ : Ljava/lang/Object;
      //   977: aload_2
      //   978: getfield transformType_ : Ljava/lang/Object;
      //   981: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   986: putfield transformType_ : Ljava/lang/Object;
      //   989: goto -> 1027
      //   992: iload #11
      //   994: istore #5
      //   996: aload_0
      //   997: getfield transformTypeCase_ : I
      //   1000: iconst_2
      //   1001: if_icmpne -> 1007
      //   1004: iconst_1
      //   1005: istore #5
      //   1007: aload_0
      //   1008: aload_1
      //   1009: iload #5
      //   1011: aload_0
      //   1012: getfield transformType_ : Ljava/lang/Object;
      //   1015: aload_2
      //   1016: getfield transformType_ : Ljava/lang/Object;
      //   1019: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1024: putfield transformType_ : Ljava/lang/Object;
      //   1027: aload_1
      //   1028: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   1031: if_acmpne -> 1051
      //   1034: aload_2
      //   1035: getfield transformTypeCase_ : I
      //   1038: istore #12
      //   1040: iload #12
      //   1042: ifeq -> 1051
      //   1045: aload_0
      //   1046: iload #12
      //   1048: putfield transformTypeCase_ : I
      //   1051: aload_0
      //   1052: areturn
      //   1053: new com/google/firestore/v1/DocumentTransform$FieldTransform$Builder
      //   1056: dup
      //   1057: aconst_null
      //   1058: invokespecial <init> : (Lcom/google/firestore/v1/DocumentTransform$1;)V
      //   1061: areturn
      //   1062: aconst_null
      //   1063: areturn
      //   1064: getstatic com/google/firestore/v1/DocumentTransform$FieldTransform.DEFAULT_INSTANCE : Lcom/google/firestore/v1/DocumentTransform$FieldTransform;
      //   1067: areturn
      //   1068: new com/google/firestore/v1/DocumentTransform$FieldTransform
      //   1071: dup
      //   1072: invokespecial <init> : ()V
      //   1075: areturn
      // Exception table:
      //   from	to	target	type
      //   101	122	128	finally
      //   122	125	128	finally
      //   129	132	128	finally
      //   153	159	656	com/google/protobuf/InvalidProtocolBufferException
      //   153	159	628	java/io/IOException
      //   153	159	624	finally
      //   213	222	656	com/google/protobuf/InvalidProtocolBufferException
      //   213	222	628	java/io/IOException
      //   213	222	624	finally
      //   225	248	656	com/google/protobuf/InvalidProtocolBufferException
      //   225	248	628	java/io/IOException
      //   225	248	624	finally
      //   253	265	656	com/google/protobuf/InvalidProtocolBufferException
      //   253	265	628	java/io/IOException
      //   253	265	624	finally
      //   269	289	656	com/google/protobuf/InvalidProtocolBufferException
      //   269	289	628	java/io/IOException
      //   269	289	624	finally
      //   289	295	656	com/google/protobuf/InvalidProtocolBufferException
      //   289	295	628	java/io/IOException
      //   289	295	624	finally
      //   298	321	656	com/google/protobuf/InvalidProtocolBufferException
      //   298	321	628	java/io/IOException
      //   298	321	624	finally
      //   326	338	656	com/google/protobuf/InvalidProtocolBufferException
      //   326	338	628	java/io/IOException
      //   326	338	624	finally
      //   342	362	656	com/google/protobuf/InvalidProtocolBufferException
      //   342	362	628	java/io/IOException
      //   342	362	624	finally
      //   362	368	656	com/google/protobuf/InvalidProtocolBufferException
      //   362	368	628	java/io/IOException
      //   362	368	624	finally
      //   371	393	656	com/google/protobuf/InvalidProtocolBufferException
      //   371	393	628	java/io/IOException
      //   371	393	624	finally
      //   398	410	656	com/google/protobuf/InvalidProtocolBufferException
      //   398	410	628	java/io/IOException
      //   398	410	624	finally
      //   414	434	656	com/google/protobuf/InvalidProtocolBufferException
      //   414	434	628	java/io/IOException
      //   414	434	624	finally
      //   434	439	656	com/google/protobuf/InvalidProtocolBufferException
      //   434	439	628	java/io/IOException
      //   434	439	624	finally
      //   442	464	656	com/google/protobuf/InvalidProtocolBufferException
      //   442	464	628	java/io/IOException
      //   442	464	624	finally
      //   469	481	656	com/google/protobuf/InvalidProtocolBufferException
      //   469	481	628	java/io/IOException
      //   469	481	624	finally
      //   485	505	656	com/google/protobuf/InvalidProtocolBufferException
      //   485	505	628	java/io/IOException
      //   485	505	624	finally
      //   505	510	656	com/google/protobuf/InvalidProtocolBufferException
      //   505	510	628	java/io/IOException
      //   505	510	624	finally
      //   513	535	656	com/google/protobuf/InvalidProtocolBufferException
      //   513	535	628	java/io/IOException
      //   513	535	624	finally
      //   540	552	656	com/google/protobuf/InvalidProtocolBufferException
      //   540	552	628	java/io/IOException
      //   540	552	624	finally
      //   556	576	656	com/google/protobuf/InvalidProtocolBufferException
      //   556	576	628	java/io/IOException
      //   556	576	624	finally
      //   576	581	656	com/google/protobuf/InvalidProtocolBufferException
      //   576	581	628	java/io/IOException
      //   576	581	624	finally
      //   584	604	656	com/google/protobuf/InvalidProtocolBufferException
      //   584	604	628	java/io/IOException
      //   584	604	624	finally
      //   607	615	656	com/google/protobuf/InvalidProtocolBufferException
      //   607	615	628	java/io/IOException
      //   607	615	624	finally
      //   629	656	624	finally
      //   657	672	624	finally
    }
    
    public ArrayValue getAppendMissingElements() {
      return (this.transformTypeCase_ == 6) ? (ArrayValue)this.transformType_ : ArrayValue.getDefaultInstance();
    }
    
    public String getFieldPath() {
      return this.fieldPath_;
    }
    
    public ByteString getFieldPathBytes() {
      return ByteString.copyFromUtf8(this.fieldPath_);
    }
    
    public Value getIncrement() {
      return (this.transformTypeCase_ == 3) ? (Value)this.transformType_ : Value.getDefaultInstance();
    }
    
    public Value getMaximum() {
      return (this.transformTypeCase_ == 4) ? (Value)this.transformType_ : Value.getDefaultInstance();
    }
    
    public Value getMinimum() {
      return (this.transformTypeCase_ == 5) ? (Value)this.transformType_ : Value.getDefaultInstance();
    }
    
    public ArrayValue getRemoveAllFromArray() {
      return (this.transformTypeCase_ == 7) ? (ArrayValue)this.transformType_ : ArrayValue.getDefaultInstance();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!this.fieldPath_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getFieldPath()); 
      i = j;
      if (this.transformTypeCase_ == 2)
        i = j + CodedOutputStream.computeEnumSize(2, ((Integer)this.transformType_).intValue()); 
      int k = i;
      if (this.transformTypeCase_ == 3)
        k = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.transformType_); 
      j = k;
      if (this.transformTypeCase_ == 4)
        j = k + CodedOutputStream.computeMessageSize(4, (MessageLite)this.transformType_); 
      i = j;
      if (this.transformTypeCase_ == 5)
        i = j + CodedOutputStream.computeMessageSize(5, (MessageLite)this.transformType_); 
      j = i;
      if (this.transformTypeCase_ == 6)
        j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)this.transformType_); 
      i = j;
      if (this.transformTypeCase_ == 7)
        i = j + CodedOutputStream.computeMessageSize(7, (MessageLite)this.transformType_); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public ServerValue getSetToServerValue() {
      if (this.transformTypeCase_ == 2) {
        ServerValue serverValue1 = ServerValue.forNumber(((Integer)this.transformType_).intValue());
        ServerValue serverValue2 = serverValue1;
        if (serverValue1 == null)
          serverValue2 = ServerValue.UNRECOGNIZED; 
        return serverValue2;
      } 
      return ServerValue.SERVER_VALUE_UNSPECIFIED;
    }
    
    public int getSetToServerValueValue() {
      return (this.transformTypeCase_ == 2) ? ((Integer)this.transformType_).intValue() : 0;
    }
    
    public TransformTypeCase getTransformTypeCase() {
      return TransformTypeCase.forNumber(this.transformTypeCase_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.fieldPath_.isEmpty())
        param1CodedOutputStream.writeString(1, getFieldPath()); 
      if (this.transformTypeCase_ == 2)
        param1CodedOutputStream.writeEnum(2, ((Integer)this.transformType_).intValue()); 
      if (this.transformTypeCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.transformType_); 
      if (this.transformTypeCase_ == 4)
        param1CodedOutputStream.writeMessage(4, (MessageLite)this.transformType_); 
      if (this.transformTypeCase_ == 5)
        param1CodedOutputStream.writeMessage(5, (MessageLite)this.transformType_); 
      if (this.transformTypeCase_ == 6)
        param1CodedOutputStream.writeMessage(6, (MessageLite)this.transformType_); 
      if (this.transformTypeCase_ == 7)
        param1CodedOutputStream.writeMessage(7, (MessageLite)this.transformType_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldTransform, Builder> implements DocumentTransform.FieldTransformOrBuilder {
      private Builder() {
        super(DocumentTransform.FieldTransform.DEFAULT_INSTANCE);
      }
      
      public Builder clearAppendMissingElements() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearAppendMissingElements();
        return this;
      }
      
      public Builder clearFieldPath() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearFieldPath();
        return this;
      }
      
      public Builder clearIncrement() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearIncrement();
        return this;
      }
      
      public Builder clearMaximum() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearMaximum();
        return this;
      }
      
      public Builder clearMinimum() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearMinimum();
        return this;
      }
      
      public Builder clearRemoveAllFromArray() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearRemoveAllFromArray();
        return this;
      }
      
      public Builder clearSetToServerValue() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearSetToServerValue();
        return this;
      }
      
      public Builder clearTransformType() {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).clearTransformType();
        return this;
      }
      
      public ArrayValue getAppendMissingElements() {
        return ((DocumentTransform.FieldTransform)this.instance).getAppendMissingElements();
      }
      
      public String getFieldPath() {
        return ((DocumentTransform.FieldTransform)this.instance).getFieldPath();
      }
      
      public ByteString getFieldPathBytes() {
        return ((DocumentTransform.FieldTransform)this.instance).getFieldPathBytes();
      }
      
      public Value getIncrement() {
        return ((DocumentTransform.FieldTransform)this.instance).getIncrement();
      }
      
      public Value getMaximum() {
        return ((DocumentTransform.FieldTransform)this.instance).getMaximum();
      }
      
      public Value getMinimum() {
        return ((DocumentTransform.FieldTransform)this.instance).getMinimum();
      }
      
      public ArrayValue getRemoveAllFromArray() {
        return ((DocumentTransform.FieldTransform)this.instance).getRemoveAllFromArray();
      }
      
      public DocumentTransform.FieldTransform.ServerValue getSetToServerValue() {
        return ((DocumentTransform.FieldTransform)this.instance).getSetToServerValue();
      }
      
      public int getSetToServerValueValue() {
        return ((DocumentTransform.FieldTransform)this.instance).getSetToServerValueValue();
      }
      
      public DocumentTransform.FieldTransform.TransformTypeCase getTransformTypeCase() {
        return ((DocumentTransform.FieldTransform)this.instance).getTransformTypeCase();
      }
      
      public Builder mergeAppendMissingElements(ArrayValue param2ArrayValue) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).mergeAppendMissingElements(param2ArrayValue);
        return this;
      }
      
      public Builder mergeIncrement(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).mergeIncrement(param2Value);
        return this;
      }
      
      public Builder mergeMaximum(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).mergeMaximum(param2Value);
        return this;
      }
      
      public Builder mergeMinimum(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).mergeMinimum(param2Value);
        return this;
      }
      
      public Builder mergeRemoveAllFromArray(ArrayValue param2ArrayValue) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).mergeRemoveAllFromArray(param2ArrayValue);
        return this;
      }
      
      public Builder setAppendMissingElements(ArrayValue.Builder param2Builder) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setAppendMissingElements(param2Builder);
        return this;
      }
      
      public Builder setAppendMissingElements(ArrayValue param2ArrayValue) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setAppendMissingElements(param2ArrayValue);
        return this;
      }
      
      public Builder setFieldPath(String param2String) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setFieldPath(param2String);
        return this;
      }
      
      public Builder setFieldPathBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setFieldPathBytes(param2ByteString);
        return this;
      }
      
      public Builder setIncrement(Value.Builder param2Builder) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setIncrement(param2Builder);
        return this;
      }
      
      public Builder setIncrement(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setIncrement(param2Value);
        return this;
      }
      
      public Builder setMaximum(Value.Builder param2Builder) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setMaximum(param2Builder);
        return this;
      }
      
      public Builder setMaximum(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setMaximum(param2Value);
        return this;
      }
      
      public Builder setMinimum(Value.Builder param2Builder) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setMinimum(param2Builder);
        return this;
      }
      
      public Builder setMinimum(Value param2Value) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setMinimum(param2Value);
        return this;
      }
      
      public Builder setRemoveAllFromArray(ArrayValue.Builder param2Builder) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setRemoveAllFromArray(param2Builder);
        return this;
      }
      
      public Builder setRemoveAllFromArray(ArrayValue param2ArrayValue) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setRemoveAllFromArray(param2ArrayValue);
        return this;
      }
      
      public Builder setSetToServerValue(DocumentTransform.FieldTransform.ServerValue param2ServerValue) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setSetToServerValue(param2ServerValue);
        return this;
      }
      
      public Builder setSetToServerValueValue(int param2Int) {
        copyOnWrite();
        ((DocumentTransform.FieldTransform)this.instance).setSetToServerValueValue(param2Int);
        return this;
      }
    }
    
    public enum ServerValue implements Internal.EnumLite {
      REQUEST_TIME,
      SERVER_VALUE_UNSPECIFIED(0),
      UNRECOGNIZED(0);
      
      public static final int REQUEST_TIME_VALUE = 1;
      
      public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;
      
      private static final Internal.EnumLiteMap<ServerValue> internalValueMap = new Internal.EnumLiteMap<ServerValue>() {
          public DocumentTransform.FieldTransform.ServerValue findValueByNumber(int param3Int) {
            return DocumentTransform.FieldTransform.ServerValue.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      ServerValue(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static ServerValue forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? null : REQUEST_TIME) : SERVER_VALUE_UNSPECIFIED;
      }
      
      public static Internal.EnumLiteMap<ServerValue> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<ServerValue> {
      public DocumentTransform.FieldTransform.ServerValue findValueByNumber(int param2Int) {
        return DocumentTransform.FieldTransform.ServerValue.forNumber(param2Int);
      }
    }
    
    public enum TransformTypeCase implements Internal.EnumLite {
      APPEND_MISSING_ELEMENTS(0),
      INCREMENT(0),
      MAXIMUM(0),
      MINIMUM(0),
      REMOVE_ALL_FROM_ARRAY(0),
      SET_TO_SERVER_VALUE(2),
      TRANSFORMTYPE_NOT_SET(2);
      
      private final int value;
      
      static {
        $VALUES = new TransformTypeCase[] { SET_TO_SERVER_VALUE, INCREMENT, MAXIMUM, MINIMUM, APPEND_MISSING_ELEMENTS, REMOVE_ALL_FROM_ARRAY, TRANSFORMTYPE_NOT_SET };
      }
      
      TransformTypeCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static TransformTypeCase forNumber(int param2Int) {
        if (param2Int != 0) {
          switch (param2Int) {
            default:
              return null;
            case 7:
              return REMOVE_ALL_FROM_ARRAY;
            case 6:
              return APPEND_MISSING_ELEMENTS;
            case 5:
              return MINIMUM;
            case 4:
              return MAXIMUM;
            case 3:
              return INCREMENT;
            case 2:
              break;
          } 
          return SET_TO_SERVER_VALUE;
        } 
        return TRANSFORMTYPE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldTransform, FieldTransform.Builder> implements FieldTransformOrBuilder {
    private Builder() {
      super(DocumentTransform.FieldTransform.DEFAULT_INSTANCE);
    }
    
    public Builder clearAppendMissingElements() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearAppendMissingElements();
      return this;
    }
    
    public Builder clearFieldPath() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearFieldPath();
      return this;
    }
    
    public Builder clearIncrement() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearIncrement();
      return this;
    }
    
    public Builder clearMaximum() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearMaximum();
      return this;
    }
    
    public Builder clearMinimum() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearMinimum();
      return this;
    }
    
    public Builder clearRemoveAllFromArray() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearRemoveAllFromArray();
      return this;
    }
    
    public Builder clearSetToServerValue() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearSetToServerValue();
      return this;
    }
    
    public Builder clearTransformType() {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).clearTransformType();
      return this;
    }
    
    public ArrayValue getAppendMissingElements() {
      return ((DocumentTransform.FieldTransform)this.instance).getAppendMissingElements();
    }
    
    public String getFieldPath() {
      return ((DocumentTransform.FieldTransform)this.instance).getFieldPath();
    }
    
    public ByteString getFieldPathBytes() {
      return ((DocumentTransform.FieldTransform)this.instance).getFieldPathBytes();
    }
    
    public Value getIncrement() {
      return ((DocumentTransform.FieldTransform)this.instance).getIncrement();
    }
    
    public Value getMaximum() {
      return ((DocumentTransform.FieldTransform)this.instance).getMaximum();
    }
    
    public Value getMinimum() {
      return ((DocumentTransform.FieldTransform)this.instance).getMinimum();
    }
    
    public ArrayValue getRemoveAllFromArray() {
      return ((DocumentTransform.FieldTransform)this.instance).getRemoveAllFromArray();
    }
    
    public DocumentTransform.FieldTransform.ServerValue getSetToServerValue() {
      return ((DocumentTransform.FieldTransform)this.instance).getSetToServerValue();
    }
    
    public int getSetToServerValueValue() {
      return ((DocumentTransform.FieldTransform)this.instance).getSetToServerValueValue();
    }
    
    public DocumentTransform.FieldTransform.TransformTypeCase getTransformTypeCase() {
      return ((DocumentTransform.FieldTransform)this.instance).getTransformTypeCase();
    }
    
    public Builder mergeAppendMissingElements(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).mergeAppendMissingElements(param1ArrayValue);
      return this;
    }
    
    public Builder mergeIncrement(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).mergeIncrement(param1Value);
      return this;
    }
    
    public Builder mergeMaximum(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).mergeMaximum(param1Value);
      return this;
    }
    
    public Builder mergeMinimum(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).mergeMinimum(param1Value);
      return this;
    }
    
    public Builder mergeRemoveAllFromArray(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).mergeRemoveAllFromArray(param1ArrayValue);
      return this;
    }
    
    public Builder setAppendMissingElements(ArrayValue.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setAppendMissingElements(param1Builder);
      return this;
    }
    
    public Builder setAppendMissingElements(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setAppendMissingElements(param1ArrayValue);
      return this;
    }
    
    public Builder setFieldPath(String param1String) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setFieldPath(param1String);
      return this;
    }
    
    public Builder setFieldPathBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setFieldPathBytes(param1ByteString);
      return this;
    }
    
    public Builder setIncrement(Value.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setIncrement(param1Builder);
      return this;
    }
    
    public Builder setIncrement(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setIncrement(param1Value);
      return this;
    }
    
    public Builder setMaximum(Value.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setMaximum(param1Builder);
      return this;
    }
    
    public Builder setMaximum(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setMaximum(param1Value);
      return this;
    }
    
    public Builder setMinimum(Value.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setMinimum(param1Builder);
      return this;
    }
    
    public Builder setMinimum(Value param1Value) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setMinimum(param1Value);
      return this;
    }
    
    public Builder setRemoveAllFromArray(ArrayValue.Builder param1Builder) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setRemoveAllFromArray(param1Builder);
      return this;
    }
    
    public Builder setRemoveAllFromArray(ArrayValue param1ArrayValue) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setRemoveAllFromArray(param1ArrayValue);
      return this;
    }
    
    public Builder setSetToServerValue(DocumentTransform.FieldTransform.ServerValue param1ServerValue) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setSetToServerValue(param1ServerValue);
      return this;
    }
    
    public Builder setSetToServerValueValue(int param1Int) {
      copyOnWrite();
      ((DocumentTransform.FieldTransform)this.instance).setSetToServerValueValue(param1Int);
      return this;
    }
  }
  
  public enum ServerValue implements Internal.EnumLite {
    REQUEST_TIME(2),
    SERVER_VALUE_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int REQUEST_TIME_VALUE = 1;
    
    public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ServerValue> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new ServerValue[] { SERVER_VALUE_UNSPECIFIED, REQUEST_TIME, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ServerValue>() {
          public DocumentTransform.FieldTransform.ServerValue findValueByNumber(int param3Int) {
            return DocumentTransform.FieldTransform.ServerValue.forNumber(param3Int);
          }
        };
    }
    
    ServerValue(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ServerValue forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : REQUEST_TIME) : SERVER_VALUE_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<ServerValue> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<FieldTransform.ServerValue> {
    public DocumentTransform.FieldTransform.ServerValue findValueByNumber(int param1Int) {
      return DocumentTransform.FieldTransform.ServerValue.forNumber(param1Int);
    }
  }
  
  public enum TransformTypeCase implements Internal.EnumLite {
    APPEND_MISSING_ELEMENTS(0),
    INCREMENT(0),
    MAXIMUM(0),
    MINIMUM(0),
    REMOVE_ALL_FROM_ARRAY(0),
    SET_TO_SERVER_VALUE(2),
    TRANSFORMTYPE_NOT_SET(2);
    
    private final int value;
    
    static {
      APPEND_MISSING_ELEMENTS = new TransformTypeCase("APPEND_MISSING_ELEMENTS", 4, 6);
      REMOVE_ALL_FROM_ARRAY = new TransformTypeCase("REMOVE_ALL_FROM_ARRAY", 5, 7);
      TRANSFORMTYPE_NOT_SET = new TransformTypeCase("TRANSFORMTYPE_NOT_SET", 6, 0);
      $VALUES = new TransformTypeCase[] { SET_TO_SERVER_VALUE, INCREMENT, MAXIMUM, MINIMUM, APPEND_MISSING_ELEMENTS, REMOVE_ALL_FROM_ARRAY, TRANSFORMTYPE_NOT_SET };
    }
    
    TransformTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static TransformTypeCase forNumber(int param1Int) {
      if (param1Int != 0) {
        switch (param1Int) {
          default:
            return null;
          case 7:
            return REMOVE_ALL_FROM_ARRAY;
          case 6:
            return APPEND_MISSING_ELEMENTS;
          case 5:
            return MINIMUM;
          case 4:
            return MAXIMUM;
          case 3:
            return INCREMENT;
          case 2:
            break;
        } 
        return SET_TO_SERVER_VALUE;
      } 
      return TRANSFORMTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface FieldTransformOrBuilder extends MessageLiteOrBuilder {
    ArrayValue getAppendMissingElements();
    
    String getFieldPath();
    
    ByteString getFieldPathBytes();
    
    Value getIncrement();
    
    Value getMaximum();
    
    Value getMinimum();
    
    ArrayValue getRemoveAllFromArray();
    
    DocumentTransform.FieldTransform.ServerValue getSetToServerValue();
    
    int getSetToServerValueValue();
    
    DocumentTransform.FieldTransform.TransformTypeCase getTransformTypeCase();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentTransform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */