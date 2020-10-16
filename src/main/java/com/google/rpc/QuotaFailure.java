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

public final class QuotaFailure extends GeneratedMessageLite<QuotaFailure, QuotaFailure.Builder> implements QuotaFailureOrBuilder {
  private static final QuotaFailure DEFAULT_INSTANCE = new QuotaFailure();
  
  private static volatile Parser<QuotaFailure> PARSER;
  
  public static final int VIOLATIONS_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Violation> violations_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllViolations(Iterable<? extends Violation> paramIterable) {
    ensureViolationsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.violations_);
  }
  
  private void addViolations(int paramInt, Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.add(paramInt, paramBuilder.build());
  }
  
  private void addViolations(int paramInt, Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.add(paramInt, paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addViolations(Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.add(paramBuilder.build());
  }
  
  private void addViolations(Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.add(paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearViolations() {
    this.violations_ = emptyProtobufList();
  }
  
  private void ensureViolationsIsMutable() {
    if (!this.violations_.isModifiable())
      this.violations_ = GeneratedMessageLite.mutableCopy(this.violations_); 
  }
  
  public static QuotaFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(QuotaFailure paramQuotaFailure) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuotaFailure);
  }
  
  public static QuotaFailure parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (QuotaFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaFailure parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static QuotaFailure parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static QuotaFailure parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(InputStream paramInputStream) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaFailure parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaFailure parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static QuotaFailure parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<QuotaFailure> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeViolations(int paramInt) {
    ensureViolationsIsMutable();
    this.violations_.remove(paramInt);
  }
  
  private void setViolations(int paramInt, Violation.Builder paramBuilder) {
    ensureViolationsIsMutable();
    this.violations_.set(paramInt, paramBuilder.build());
  }
  
  private void setViolations(int paramInt, Violation paramViolation) {
    if (paramViolation != null) {
      ensureViolationsIsMutable();
      this.violations_.set(paramInt, paramViolation);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/QuotaFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 323, 2 -> 319, 3 -> 308, 4 -> 299, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/QuotaFailure
    //   72: monitorenter
    //   73: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/QuotaFailure
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/QuotaFailure
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/QuotaFailure.PARSER : Lcom/google/protobuf/Parser;
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
    //   159: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   162: invokeinterface isModifiable : ()Z
    //   167: ifne -> 181
    //   170: aload_0
    //   171: aload_0
    //   172: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   175: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   178: putfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   181: aload_0
    //   182: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: aload_1
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_2
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/rpc/QuotaFailure$Violation
    //   196: invokeinterface add : (Ljava/lang/Object;)Z
    //   201: pop
    //   202: goto -> 123
    //   205: iconst_1
    //   206: istore #4
    //   208: goto -> 123
    //   211: astore_1
    //   212: goto -> 259
    //   215: astore_2
    //   216: new java/lang/RuntimeException
    //   219: astore_1
    //   220: new com/google/protobuf/InvalidProtocolBufferException
    //   223: astore_3
    //   224: aload_3
    //   225: aload_2
    //   226: invokevirtual getMessage : ()Ljava/lang/String;
    //   229: invokespecial <init> : (Ljava/lang/String;)V
    //   232: aload_1
    //   233: aload_3
    //   234: aload_0
    //   235: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   238: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   241: aload_1
    //   242: athrow
    //   243: astore_2
    //   244: new java/lang/RuntimeException
    //   247: astore_1
    //   248: aload_1
    //   249: aload_2
    //   250: aload_0
    //   251: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   254: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: athrow
    //   259: aload_1
    //   260: athrow
    //   261: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   264: areturn
    //   265: aload_2
    //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   269: astore_1
    //   270: aload_3
    //   271: checkcast com/google/rpc/QuotaFailure
    //   274: astore_2
    //   275: aload_0
    //   276: aload_1
    //   277: aload_0
    //   278: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   281: aload_2
    //   282: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   285: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   290: putfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   296: astore_1
    //   297: aload_0
    //   298: areturn
    //   299: new com/google/rpc/QuotaFailure$Builder
    //   302: dup
    //   303: aconst_null
    //   304: invokespecial <init> : (Lcom/google/rpc/QuotaFailure$1;)V
    //   307: areturn
    //   308: aload_0
    //   309: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   312: invokeinterface makeImmutable : ()V
    //   317: aconst_null
    //   318: areturn
    //   319: getstatic com/google/rpc/QuotaFailure.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure;
    //   322: areturn
    //   323: new com/google/rpc/QuotaFailure
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
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    i = 0;
    while (b < this.violations_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.violations_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Violation getViolations(int paramInt) {
    return (Violation)this.violations_.get(paramInt);
  }
  
  public int getViolationsCount() {
    return this.violations_.size();
  }
  
  public List<Violation> getViolationsList() {
    return (List<Violation>)this.violations_;
  }
  
  public ViolationOrBuilder getViolationsOrBuilder(int paramInt) {
    return (ViolationOrBuilder)this.violations_.get(paramInt);
  }
  
  public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
    return (List)this.violations_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.violations_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.violations_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<QuotaFailure, Builder> implements QuotaFailureOrBuilder {
    private Builder() {
      super(QuotaFailure.DEFAULT_INSTANCE);
    }
    
    public Builder addAllViolations(Iterable<? extends QuotaFailure.Violation> param1Iterable) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addAllViolations(param1Iterable);
      return this;
    }
    
    public Builder addViolations(int param1Int, QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addViolations(int param1Int, QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Int, param1Violation);
      return this;
    }
    
    public Builder addViolations(QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Builder);
      return this;
    }
    
    public Builder addViolations(QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).addViolations(param1Violation);
      return this;
    }
    
    public Builder clearViolations() {
      copyOnWrite();
      ((QuotaFailure)this.instance).clearViolations();
      return this;
    }
    
    public QuotaFailure.Violation getViolations(int param1Int) {
      return ((QuotaFailure)this.instance).getViolations(param1Int);
    }
    
    public int getViolationsCount() {
      return ((QuotaFailure)this.instance).getViolationsCount();
    }
    
    public List<QuotaFailure.Violation> getViolationsList() {
      return Collections.unmodifiableList(((QuotaFailure)this.instance).getViolationsList());
    }
    
    public Builder removeViolations(int param1Int) {
      copyOnWrite();
      ((QuotaFailure)this.instance).removeViolations(param1Int);
      return this;
    }
    
    public Builder setViolations(int param1Int, QuotaFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((QuotaFailure)this.instance).setViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setViolations(int param1Int, QuotaFailure.Violation param1Violation) {
      copyOnWrite();
      ((QuotaFailure)this.instance).setViolations(param1Int, param1Violation);
      return this;
    }
  }
  
  public static final class Violation extends GeneratedMessageLite<Violation, Violation.Builder> implements ViolationOrBuilder {
    private static final Violation DEFAULT_INSTANCE = new Violation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    
    private static volatile Parser<Violation> PARSER;
    
    public static final int SUBJECT_FIELD_NUMBER = 1;
    
    private String description_ = "";
    
    private String subject_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearSubject() {
      this.subject_ = getDefaultInstance().getSubject();
    }
    
    public static Violation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Violation param1Violation) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Violation);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Violation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Violation parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Violation parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Violation parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(InputStream param1InputStream) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Violation parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Violation parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Violation)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Violation> parser() {
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
    
    private void setSubject(String param1String) {
      if (param1String != null) {
        this.subject_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSubjectBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.subject_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/QuotaFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 350, 2 -> 346, 3 -> 344, 4 -> 335, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/QuotaFailure$Violation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/QuotaFailure$Violation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/QuotaFailure$Violation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/QuotaFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
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
      //   181: putfield subject_ : Ljava/lang/String;
      //   184: goto -> 123
      //   187: iconst_1
      //   188: istore #4
      //   190: goto -> 123
      //   193: astore_1
      //   194: goto -> 241
      //   197: astore_3
      //   198: new java/lang/RuntimeException
      //   201: astore_2
      //   202: new com/google/protobuf/InvalidProtocolBufferException
      //   205: astore_1
      //   206: aload_1
      //   207: aload_3
      //   208: invokevirtual getMessage : ()Ljava/lang/String;
      //   211: invokespecial <init> : (Ljava/lang/String;)V
      //   214: aload_2
      //   215: aload_1
      //   216: aload_0
      //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   223: aload_2
      //   224: athrow
      //   225: astore_1
      //   226: new java/lang/RuntimeException
      //   229: astore_2
      //   230: aload_2
      //   231: aload_1
      //   232: aload_0
      //   233: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   236: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   239: aload_2
      //   240: athrow
      //   241: aload_1
      //   242: athrow
      //   243: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   246: areturn
      //   247: aload_2
      //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   251: astore_1
      //   252: aload_3
      //   253: checkcast com/google/rpc/QuotaFailure$Violation
      //   256: astore_2
      //   257: aload_0
      //   258: aload_1
      //   259: aload_0
      //   260: getfield subject_ : Ljava/lang/String;
      //   263: invokevirtual isEmpty : ()Z
      //   266: iconst_1
      //   267: ixor
      //   268: aload_0
      //   269: getfield subject_ : Ljava/lang/String;
      //   272: aload_2
      //   273: getfield subject_ : Ljava/lang/String;
      //   276: invokevirtual isEmpty : ()Z
      //   279: iconst_1
      //   280: ixor
      //   281: aload_2
      //   282: getfield subject_ : Ljava/lang/String;
      //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   290: putfield subject_ : Ljava/lang/String;
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
      //   335: new com/google/rpc/QuotaFailure$Violation$Builder
      //   338: dup
      //   339: aconst_null
      //   340: invokespecial <init> : (Lcom/google/rpc/QuotaFailure$1;)V
      //   343: areturn
      //   344: aconst_null
      //   345: areturn
      //   346: getstatic com/google/rpc/QuotaFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/QuotaFailure$Violation;
      //   349: areturn
      //   350: new com/google/rpc/QuotaFailure$Violation
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
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.subject_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(1, getSubject()); 
      int j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(2, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getSubject() {
      return this.subject_;
    }
    
    public ByteString getSubjectBytes() {
      return ByteString.copyFromUtf8(this.subject_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.subject_.isEmpty())
        param1CodedOutputStream.writeString(1, getSubject()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(2, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements QuotaFailure.ViolationOrBuilder {
      private Builder() {
        super(QuotaFailure.Violation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearSubject() {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).clearSubject();
        return this;
      }
      
      public String getDescription() {
        return ((QuotaFailure.Violation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((QuotaFailure.Violation)this.instance).getDescriptionBytes();
      }
      
      public String getSubject() {
        return ((QuotaFailure.Violation)this.instance).getSubject();
      }
      
      public ByteString getSubjectBytes() {
        return ((QuotaFailure.Violation)this.instance).getSubjectBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setSubject(String param2String) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setSubject(param2String);
        return this;
      }
      
      public Builder setSubjectBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((QuotaFailure.Violation)this.instance).setSubjectBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Violation, Violation.Builder> implements ViolationOrBuilder {
    private Builder() {
      super(QuotaFailure.Violation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearSubject() {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).clearSubject();
      return this;
    }
    
    public String getDescription() {
      return ((QuotaFailure.Violation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((QuotaFailure.Violation)this.instance).getDescriptionBytes();
    }
    
    public String getSubject() {
      return ((QuotaFailure.Violation)this.instance).getSubject();
    }
    
    public ByteString getSubjectBytes() {
      return ((QuotaFailure.Violation)this.instance).getSubjectBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setSubject(String param1String) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setSubject(param1String);
      return this;
    }
    
    public Builder setSubjectBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaFailure.Violation)this.instance).setSubjectBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getSubject();
    
    ByteString getSubjectBytes();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\QuotaFailure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */