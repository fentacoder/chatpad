package com.google.rpc;

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

public final class BadRequest extends GeneratedMessageLite<BadRequest, BadRequest.Builder> implements BadRequestOrBuilder {
  private static final BadRequest DEFAULT_INSTANCE = new BadRequest();
  
  public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
  
  private static volatile Parser<BadRequest> PARSER;
  
  private Internal.ProtobufList<FieldViolation> fieldViolations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFieldViolations(Iterable<? extends FieldViolation> paramIterable) {
    ensureFieldViolationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.fieldViolations_);
  }
  
  private void addFieldViolations(int paramInt, FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.add(paramInt, paramBuilder.build());
  }
  
  private void addFieldViolations(int paramInt, FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.add(paramInt, paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFieldViolations(FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.add(paramBuilder.build());
  }
  
  private void addFieldViolations(FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.add(paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearFieldViolations() {
    this.fieldViolations_ = emptyProtobufList();
  }
  
  private void ensureFieldViolationsIsMutable() {
    if (!this.fieldViolations_.isModifiable())
      this.fieldViolations_ = GeneratedMessageLite.mutableCopy(this.fieldViolations_); 
  }
  
  public static BadRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BadRequest paramBadRequest) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBadRequest);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BadRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BadRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BadRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BadRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BadRequest parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BadRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BadRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFieldViolations(int paramInt) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.remove(paramInt);
  }
  
  private void setFieldViolations(int paramInt, FieldViolation.Builder paramBuilder) {
    ensureFieldViolationsIsMutable();
    this.fieldViolations_.set(paramInt, paramBuilder.build());
  }
  
  private void setFieldViolations(int paramInt, FieldViolation paramFieldViolation) {
    if (paramFieldViolation != null) {
      ensureFieldViolationsIsMutable();
      this.fieldViolations_.set(paramInt, paramFieldViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/BadRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 323, 2 -> 319, 3 -> 308, 4 -> 299, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/BadRequest
    //   72: monitorenter
    //   73: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/BadRequest
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/BadRequest
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/BadRequest.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 261
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 205
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 158
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: goto -> 205
    //   158: aload_0
    //   159: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   162: invokeinterface isModifiable : ()Z
    //   167: ifne -> 181
    //   170: aload_0
    //   171: aload_0
    //   172: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   175: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   178: putfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   181: aload_0
    //   182: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: aload_1
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_2
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/rpc/BadRequest$FieldViolation
    //   196: invokeinterface add : (Ljava/lang/Object;)Z
    //   201: pop
    //   202: goto -> 123
    //   205: iconst_1
    //   206: istore #4
    //   208: goto -> 123
    //   211: astore_1
    //   212: goto -> 259
    //   215: astore_1
    //   216: new java/lang/RuntimeException
    //   219: astore_3
    //   220: new com/google/protobuf/InvalidProtocolBufferException
    //   223: astore_2
    //   224: aload_2
    //   225: aload_1
    //   226: invokevirtual getMessage : ()Ljava/lang/String;
    //   229: invokespecial <init> : (Ljava/lang/String;)V
    //   232: aload_3
    //   233: aload_2
    //   234: aload_0
    //   235: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   238: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   241: aload_3
    //   242: athrow
    //   243: astore_1
    //   244: new java/lang/RuntimeException
    //   247: astore_2
    //   248: aload_2
    //   249: aload_1
    //   250: aload_0
    //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   257: aload_2
    //   258: athrow
    //   259: aload_1
    //   260: athrow
    //   261: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   264: areturn
    //   265: aload_2
    //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   269: astore_1
    //   270: aload_3
    //   271: checkcast com/google/rpc/BadRequest
    //   274: astore_2
    //   275: aload_0
    //   276: aload_1
    //   277: aload_0
    //   278: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   281: aload_2
    //   282: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   285: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   290: putfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   296: astore_1
    //   297: aload_0
    //   298: areturn
    //   299: new com/google/rpc/BadRequest$Builder
    //   302: dup
    //   303: aconst_null
    //   304: invokespecial <init> : (Lcom/google/rpc/BadRequest$1;)V
    //   307: areturn
    //   308: aload_0
    //   309: getfield fieldViolations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   312: invokeinterface makeImmutable : ()V
    //   317: aconst_null
    //   318: areturn
    //   319: getstatic com/google/rpc/BadRequest.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest;
    //   322: areturn
    //   323: new com/google/rpc/BadRequest
    //   326: dup
    //   327: invokespecial <init> : ()V
    //   330: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	243	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	215	java/io/IOException
    //   128	134	211	finally
    //   146	155	243	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	215	java/io/IOException
    //   146	155	211	finally
    //   158	181	243	com/google/protobuf/InvalidProtocolBufferException
    //   158	181	215	java/io/IOException
    //   158	181	211	finally
    //   181	202	243	com/google/protobuf/InvalidProtocolBufferException
    //   181	202	215	java/io/IOException
    //   181	202	211	finally
    //   216	243	211	finally
    //   244	259	211	finally
  }
  
  public FieldViolation getFieldViolations(int paramInt) {
    return (FieldViolation)this.fieldViolations_.get(paramInt);
  }
  
  public int getFieldViolationsCount() {
    return this.fieldViolations_.size();
  }
  
  public List<FieldViolation> getFieldViolationsList() {
    return (List<FieldViolation>)this.fieldViolations_;
  }
  
  public FieldViolationOrBuilder getFieldViolationsOrBuilder(int paramInt) {
    return (FieldViolationOrBuilder)this.fieldViolations_.get(paramInt);
  }
  
  public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
    return (List)this.fieldViolations_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.fieldViolations_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.fieldViolations_.get(i));
      i++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.fieldViolations_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.fieldViolations_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
    private Builder() {
      super(BadRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFieldViolations(Iterable<? extends BadRequest.FieldViolation> param1Iterable) {
      copyOnWrite();
      ((BadRequest)this.instance).addAllFieldViolations(param1Iterable);
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Int, param1FieldViolation);
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1Builder);
      return this;
    }
    
    public Builder addFieldViolations(BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).addFieldViolations(param1FieldViolation);
      return this;
    }
    
    public Builder clearFieldViolations() {
      copyOnWrite();
      ((BadRequest)this.instance).clearFieldViolations();
      return this;
    }
    
    public BadRequest.FieldViolation getFieldViolations(int param1Int) {
      return ((BadRequest)this.instance).getFieldViolations(param1Int);
    }
    
    public int getFieldViolationsCount() {
      return ((BadRequest)this.instance).getFieldViolationsCount();
    }
    
    public List<BadRequest.FieldViolation> getFieldViolationsList() {
      return Collections.unmodifiableList(((BadRequest)this.instance).getFieldViolationsList());
    }
    
    public Builder removeFieldViolations(int param1Int) {
      copyOnWrite();
      ((BadRequest)this.instance).removeFieldViolations(param1Int);
      return this;
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation.Builder param1Builder) {
      copyOnWrite();
      ((BadRequest)this.instance).setFieldViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFieldViolations(int param1Int, BadRequest.FieldViolation param1FieldViolation) {
      copyOnWrite();
      ((BadRequest)this.instance).setFieldViolations(param1Int, param1FieldViolation);
      return this;
    }
  }
  
  public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, FieldViolation.Builder> implements FieldViolationOrBuilder {
    private static final FieldViolation DEFAULT_INSTANCE = new FieldViolation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    
    public static final int FIELD_FIELD_NUMBER = 1;
    
    private static volatile Parser<FieldViolation> PARSER;
    
    private String description_ = "";
    
    private String field_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearField() {
      this.field_ = getDefaultInstance().getField();
    }
    
    public static FieldViolation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldViolation param1FieldViolation) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldViolation);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldViolation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldViolation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldViolation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldViolation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldViolation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldViolation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldViolation> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setField(String param1String) {
      if (param1String != null) {
        this.field_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFieldBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.field_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/BadRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 350, 2 -> 346, 3 -> 344, 4 -> 335, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/BadRequest$FieldViolation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/BadRequest$FieldViolation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/BadRequest$FieldViolation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/BadRequest$FieldViolation.PARSER : Lcom/google/protobuf/Parser;
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
      //   170: putfield description_ : Ljava/lang/String;
      //   173: goto -> 123
      //   176: aload_0
      //   177: aload_1
      //   178: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   181: putfield field_ : Ljava/lang/String;
      //   184: goto -> 123
      //   187: iconst_1
      //   188: istore #4
      //   190: goto -> 123
      //   193: astore_1
      //   194: goto -> 241
      //   197: astore_3
      //   198: new java/lang/RuntimeException
      //   201: astore_1
      //   202: new com/google/protobuf/InvalidProtocolBufferException
      //   205: astore_2
      //   206: aload_2
      //   207: aload_3
      //   208: invokevirtual getMessage : ()Ljava/lang/String;
      //   211: invokespecial <init> : (Ljava/lang/String;)V
      //   214: aload_1
      //   215: aload_2
      //   216: aload_0
      //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   223: aload_1
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
      //   243: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   246: areturn
      //   247: aload_2
      //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   251: astore_1
      //   252: aload_3
      //   253: checkcast com/google/rpc/BadRequest$FieldViolation
      //   256: astore_2
      //   257: aload_0
      //   258: aload_1
      //   259: aload_0
      //   260: getfield field_ : Ljava/lang/String;
      //   263: invokevirtual isEmpty : ()Z
      //   266: iconst_1
      //   267: ixor
      //   268: aload_0
      //   269: getfield field_ : Ljava/lang/String;
      //   272: aload_2
      //   273: getfield field_ : Ljava/lang/String;
      //   276: invokevirtual isEmpty : ()Z
      //   279: iconst_1
      //   280: ixor
      //   281: aload_2
      //   282: getfield field_ : Ljava/lang/String;
      //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   290: putfield field_ : Ljava/lang/String;
      //   293: aload_0
      //   294: aload_1
      //   295: aload_0
      //   296: getfield description_ : Ljava/lang/String;
      //   299: invokevirtual isEmpty : ()Z
      //   302: iconst_1
      //   303: ixor
      //   304: aload_0
      //   305: getfield description_ : Ljava/lang/String;
      //   308: iconst_1
      //   309: aload_2
      //   310: getfield description_ : Ljava/lang/String;
      //   313: invokevirtual isEmpty : ()Z
      //   316: ixor
      //   317: aload_2
      //   318: getfield description_ : Ljava/lang/String;
      //   321: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   326: putfield description_ : Ljava/lang/String;
      //   329: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   332: astore_1
      //   333: aload_0
      //   334: areturn
      //   335: new com/google/rpc/BadRequest$FieldViolation$Builder
      //   338: dup
      //   339: aconst_null
      //   340: invokespecial <init> : (Lcom/google/rpc/BadRequest$1;)V
      //   343: areturn
      //   344: aconst_null
      //   345: areturn
      //   346: getstatic com/google/rpc/BadRequest$FieldViolation.DEFAULT_INSTANCE : Lcom/google/rpc/BadRequest$FieldViolation;
      //   349: areturn
      //   350: new com/google/rpc/BadRequest$FieldViolation
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
    
    public String getDescription() {
      return this.description_;
    }
    
    public ByteString getDescriptionBytes() {
      return ByteString.copyFromUtf8(this.description_);
    }
    
    public String getField() {
      return this.field_;
    }
    
    public ByteString getFieldBytes() {
      return ByteString.copyFromUtf8(this.field_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.field_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getField()); 
      int j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.field_.isEmpty())
        param1CodedOutputStream.writeString(1, getField()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(2, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements BadRequest.FieldViolationOrBuilder {
      private Builder() {
        super(BadRequest.FieldViolation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearField() {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).clearField();
        return this;
      }
      
      public String getDescription() {
        return ((BadRequest.FieldViolation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((BadRequest.FieldViolation)this.instance).getDescriptionBytes();
      }
      
      public String getField() {
        return ((BadRequest.FieldViolation)this.instance).getField();
      }
      
      public ByteString getFieldBytes() {
        return ((BadRequest.FieldViolation)this.instance).getFieldBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setField(String param2String) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setField(param2String);
        return this;
      }
      
      public Builder setFieldBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((BadRequest.FieldViolation)this.instance).setFieldBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, FieldViolation.Builder> implements FieldViolationOrBuilder {
    private Builder() {
      super(BadRequest.FieldViolation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearField() {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).clearField();
      return this;
    }
    
    public String getDescription() {
      return ((BadRequest.FieldViolation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((BadRequest.FieldViolation)this.instance).getDescriptionBytes();
    }
    
    public String getField() {
      return ((BadRequest.FieldViolation)this.instance).getField();
    }
    
    public ByteString getFieldBytes() {
      return ((BadRequest.FieldViolation)this.instance).getFieldBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setField(String param1String) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setField(param1String);
      return this;
    }
    
    public Builder setFieldBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BadRequest.FieldViolation)this.instance).setFieldBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getField();
    
    ByteString getFieldBytes();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\BadRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */