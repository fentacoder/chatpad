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

public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, PreconditionFailure.Builder> implements PreconditionFailureOrBuilder {
  private static final PreconditionFailure DEFAULT_INSTANCE = new PreconditionFailure();
  
  private static volatile Parser<PreconditionFailure> PARSER;
  
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
  
  public static PreconditionFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PreconditionFailure paramPreconditionFailure) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramPreconditionFailure);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PreconditionFailure parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static PreconditionFailure parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static PreconditionFailure parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static PreconditionFailure parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static PreconditionFailure parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PreconditionFailure)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PreconditionFailure> parser() {
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
    //   0: getstatic com/google/rpc/PreconditionFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 323, 2 -> 319, 3 -> 308, 4 -> 299, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/PreconditionFailure
    //   72: monitorenter
    //   73: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/PreconditionFailure
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/PreconditionFailure
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/PreconditionFailure.PARSER : Lcom/google/protobuf/Parser;
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
    //   193: checkcast com/google/rpc/PreconditionFailure$Violation
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
    //   219: astore_2
    //   220: new com/google/protobuf/InvalidProtocolBufferException
    //   223: astore_3
    //   224: aload_3
    //   225: aload_1
    //   226: invokevirtual getMessage : ()Ljava/lang/String;
    //   229: invokespecial <init> : (Ljava/lang/String;)V
    //   232: aload_2
    //   233: aload_3
    //   234: aload_0
    //   235: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   238: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   241: aload_2
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
    //   261: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   264: areturn
    //   265: aload_2
    //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   269: astore_1
    //   270: aload_3
    //   271: checkcast com/google/rpc/PreconditionFailure
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
    //   299: new com/google/rpc/PreconditionFailure$Builder
    //   302: dup
    //   303: aconst_null
    //   304: invokespecial <init> : (Lcom/google/rpc/PreconditionFailure$1;)V
    //   307: areturn
    //   308: aload_0
    //   309: getfield violations_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   312: invokeinterface makeImmutable : ()V
    //   317: aconst_null
    //   318: areturn
    //   319: getstatic com/google/rpc/PreconditionFailure.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure;
    //   322: areturn
    //   323: new com/google/rpc/PreconditionFailure
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
  
  public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    private Builder() {
      super(PreconditionFailure.DEFAULT_INSTANCE);
    }
    
    public Builder addAllViolations(Iterable<? extends PreconditionFailure.Violation> param1Iterable) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addAllViolations(param1Iterable);
      return this;
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder addViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Int, param1Violation);
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Builder);
      return this;
    }
    
    public Builder addViolations(PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).addViolations(param1Violation);
      return this;
    }
    
    public Builder clearViolations() {
      copyOnWrite();
      ((PreconditionFailure)this.instance).clearViolations();
      return this;
    }
    
    public PreconditionFailure.Violation getViolations(int param1Int) {
      return ((PreconditionFailure)this.instance).getViolations(param1Int);
    }
    
    public int getViolationsCount() {
      return ((PreconditionFailure)this.instance).getViolationsCount();
    }
    
    public List<PreconditionFailure.Violation> getViolationsList() {
      return Collections.unmodifiableList(((PreconditionFailure)this.instance).getViolationsList());
    }
    
    public Builder removeViolations(int param1Int) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).removeViolations(param1Int);
      return this;
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation.Builder param1Builder) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).setViolations(param1Int, param1Builder);
      return this;
    }
    
    public Builder setViolations(int param1Int, PreconditionFailure.Violation param1Violation) {
      copyOnWrite();
      ((PreconditionFailure)this.instance).setViolations(param1Int, param1Violation);
      return this;
    }
  }
  
  public static final class Violation extends GeneratedMessageLite<Violation, Violation.Builder> implements ViolationOrBuilder {
    private static final Violation DEFAULT_INSTANCE = new Violation();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    
    private static volatile Parser<Violation> PARSER;
    
    public static final int SUBJECT_FIELD_NUMBER = 2;
    
    public static final int TYPE_FIELD_NUMBER = 1;
    
    private String description_ = "";
    
    private String subject_ = "";
    
    private String type_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDescription() {
      this.description_ = getDefaultInstance().getDescription();
    }
    
    private void clearSubject() {
      this.subject_ = getDefaultInstance().getSubject();
    }
    
    private void clearType() {
      this.type_ = getDefaultInstance().getType();
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
    
    private void setType(String param1String) {
      if (param1String != null) {
        this.type_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setTypeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.type_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/rpc/PreconditionFailure$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 404, 2 -> 400, 3 -> 398, 4 -> 389, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/rpc/PreconditionFailure$Violation
      //   72: monitorenter
      //   73: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/rpc/PreconditionFailure$Violation
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/rpc/PreconditionFailure$Violation
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/rpc/PreconditionFailure$Violation.PARSER : Lcom/google/protobuf/Parser;
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
      //   143: if_icmpeq -> 194
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 183
      //   153: iload #5
      //   155: bipush #26
      //   157: if_icmpeq -> 172
      //   160: aload_1
      //   161: iload #5
      //   163: invokevirtual skipField : (I)Z
      //   166: ifne -> 123
      //   169: goto -> 205
      //   172: aload_0
      //   173: aload_1
      //   174: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   177: putfield description_ : Ljava/lang/String;
      //   180: goto -> 123
      //   183: aload_0
      //   184: aload_1
      //   185: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   188: putfield subject_ : Ljava/lang/String;
      //   191: goto -> 123
      //   194: aload_0
      //   195: aload_1
      //   196: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   199: putfield type_ : Ljava/lang/String;
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
      //   261: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   264: areturn
      //   265: aload_2
      //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   269: astore_1
      //   270: aload_3
      //   271: checkcast com/google/rpc/PreconditionFailure$Violation
      //   274: astore_2
      //   275: aload_0
      //   276: aload_1
      //   277: aload_0
      //   278: getfield type_ : Ljava/lang/String;
      //   281: invokevirtual isEmpty : ()Z
      //   284: iconst_1
      //   285: ixor
      //   286: aload_0
      //   287: getfield type_ : Ljava/lang/String;
      //   290: aload_2
      //   291: getfield type_ : Ljava/lang/String;
      //   294: invokevirtual isEmpty : ()Z
      //   297: iconst_1
      //   298: ixor
      //   299: aload_2
      //   300: getfield type_ : Ljava/lang/String;
      //   303: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   308: putfield type_ : Ljava/lang/String;
      //   311: aload_0
      //   312: aload_1
      //   313: aload_0
      //   314: getfield subject_ : Ljava/lang/String;
      //   317: invokevirtual isEmpty : ()Z
      //   320: iconst_1
      //   321: ixor
      //   322: aload_0
      //   323: getfield subject_ : Ljava/lang/String;
      //   326: aload_2
      //   327: getfield subject_ : Ljava/lang/String;
      //   330: invokevirtual isEmpty : ()Z
      //   333: iconst_1
      //   334: ixor
      //   335: aload_2
      //   336: getfield subject_ : Ljava/lang/String;
      //   339: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   344: putfield subject_ : Ljava/lang/String;
      //   347: aload_0
      //   348: aload_1
      //   349: aload_0
      //   350: getfield description_ : Ljava/lang/String;
      //   353: invokevirtual isEmpty : ()Z
      //   356: iconst_1
      //   357: ixor
      //   358: aload_0
      //   359: getfield description_ : Ljava/lang/String;
      //   362: iconst_1
      //   363: aload_2
      //   364: getfield description_ : Ljava/lang/String;
      //   367: invokevirtual isEmpty : ()Z
      //   370: ixor
      //   371: aload_2
      //   372: getfield description_ : Ljava/lang/String;
      //   375: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   380: putfield description_ : Ljava/lang/String;
      //   383: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   386: astore_1
      //   387: aload_0
      //   388: areturn
      //   389: new com/google/rpc/PreconditionFailure$Violation$Builder
      //   392: dup
      //   393: aconst_null
      //   394: invokespecial <init> : (Lcom/google/rpc/PreconditionFailure$1;)V
      //   397: areturn
      //   398: aconst_null
      //   399: areturn
      //   400: getstatic com/google/rpc/PreconditionFailure$Violation.DEFAULT_INSTANCE : Lcom/google/rpc/PreconditionFailure$Violation;
      //   403: areturn
      //   404: new com/google/rpc/PreconditionFailure$Violation
      //   407: dup
      //   408: invokespecial <init> : ()V
      //   411: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	243	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	215	java/io/IOException
      //   128	134	211	finally
      //   160	169	243	com/google/protobuf/InvalidProtocolBufferException
      //   160	169	215	java/io/IOException
      //   160	169	211	finally
      //   172	180	243	com/google/protobuf/InvalidProtocolBufferException
      //   172	180	215	java/io/IOException
      //   172	180	211	finally
      //   183	191	243	com/google/protobuf/InvalidProtocolBufferException
      //   183	191	215	java/io/IOException
      //   183	191	211	finally
      //   194	202	243	com/google/protobuf/InvalidProtocolBufferException
      //   194	202	215	java/io/IOException
      //   194	202	211	finally
      //   216	243	211	finally
      //   244	259	211	finally
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
      int j = 0;
      if (!this.type_.isEmpty())
        j = 0 + CodedOutputStream.computeStringSize(1, getType()); 
      i = j;
      if (!this.subject_.isEmpty())
        i = j + CodedOutputStream.computeStringSize(2, getSubject()); 
      j = i;
      if (!this.description_.isEmpty())
        j = i + CodedOutputStream.computeStringSize(3, getDescription()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public String getSubject() {
      return this.subject_;
    }
    
    public ByteString getSubjectBytes() {
      return ByteString.copyFromUtf8(this.subject_);
    }
    
    public String getType() {
      return this.type_;
    }
    
    public ByteString getTypeBytes() {
      return ByteString.copyFromUtf8(this.type_);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.type_.isEmpty())
        param1CodedOutputStream.writeString(1, getType()); 
      if (!this.subject_.isEmpty())
        param1CodedOutputStream.writeString(2, getSubject()); 
      if (!this.description_.isEmpty())
        param1CodedOutputStream.writeString(3, getDescription()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements PreconditionFailure.ViolationOrBuilder {
      private Builder() {
        super(PreconditionFailure.Violation.DEFAULT_INSTANCE);
      }
      
      public Builder clearDescription() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearDescription();
        return this;
      }
      
      public Builder clearSubject() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearSubject();
        return this;
      }
      
      public Builder clearType() {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).clearType();
        return this;
      }
      
      public String getDescription() {
        return ((PreconditionFailure.Violation)this.instance).getDescription();
      }
      
      public ByteString getDescriptionBytes() {
        return ((PreconditionFailure.Violation)this.instance).getDescriptionBytes();
      }
      
      public String getSubject() {
        return ((PreconditionFailure.Violation)this.instance).getSubject();
      }
      
      public ByteString getSubjectBytes() {
        return ((PreconditionFailure.Violation)this.instance).getSubjectBytes();
      }
      
      public String getType() {
        return ((PreconditionFailure.Violation)this.instance).getType();
      }
      
      public ByteString getTypeBytes() {
        return ((PreconditionFailure.Violation)this.instance).getTypeBytes();
      }
      
      public Builder setDescription(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setDescription(param2String);
        return this;
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setDescriptionBytes(param2ByteString);
        return this;
      }
      
      public Builder setSubject(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setSubject(param2String);
        return this;
      }
      
      public Builder setSubjectBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setSubjectBytes(param2ByteString);
        return this;
      }
      
      public Builder setType(String param2String) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setType(param2String);
        return this;
      }
      
      public Builder setTypeBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PreconditionFailure.Violation)this.instance).setTypeBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Violation, Violation.Builder> implements ViolationOrBuilder {
    private Builder() {
      super(PreconditionFailure.Violation.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearSubject() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearSubject();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).clearType();
      return this;
    }
    
    public String getDescription() {
      return ((PreconditionFailure.Violation)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((PreconditionFailure.Violation)this.instance).getDescriptionBytes();
    }
    
    public String getSubject() {
      return ((PreconditionFailure.Violation)this.instance).getSubject();
    }
    
    public ByteString getSubjectBytes() {
      return ((PreconditionFailure.Violation)this.instance).getSubjectBytes();
    }
    
    public String getType() {
      return ((PreconditionFailure.Violation)this.instance).getType();
    }
    
    public ByteString getTypeBytes() {
      return ((PreconditionFailure.Violation)this.instance).getTypeBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setSubject(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setSubject(param1String);
      return this;
    }
    
    public Builder setSubjectBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setSubjectBytes(param1ByteString);
      return this;
    }
    
    public Builder setType(String param1String) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setType(param1String);
      return this;
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PreconditionFailure.Violation)this.instance).setTypeBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface ViolationOrBuilder extends MessageLiteOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getSubject();
    
    ByteString getSubjectBytes();
    
    String getType();
    
    ByteString getTypeBytes();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\PreconditionFailure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */