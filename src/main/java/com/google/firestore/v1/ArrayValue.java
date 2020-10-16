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

public final class ArrayValue extends GeneratedMessageLite<ArrayValue, ArrayValue.Builder> implements ArrayValueOrBuilder {
  private static final ArrayValue DEFAULT_INSTANCE = new ArrayValue();
  
  private static volatile Parser<ArrayValue> PARSER;
  
  public static final int VALUES_FIELD_NUMBER = 1;
  
  private Internal.ProtobufList<Value> values_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllValues(Iterable<? extends Value> paramIterable) {
    ensureValuesIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.values_);
  }
  
  private void addValues(int paramInt, Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.add(paramInt, paramBuilder.build());
  }
  
  private void addValues(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.add(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addValues(Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.add(paramBuilder.build());
  }
  
  private void addValues(Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.add(paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearValues() {
    this.values_ = emptyProtobufList();
  }
  
  private void ensureValuesIsMutable() {
    if (!this.values_.isModifiable())
      this.values_ = GeneratedMessageLite.mutableCopy(this.values_); 
  }
  
  public static ArrayValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ArrayValue paramArrayValue) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramArrayValue);
  }
  
  public static ArrayValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ArrayValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ArrayValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ArrayValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ArrayValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ArrayValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ArrayValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ArrayValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ArrayValue parseFrom(InputStream paramInputStream) throws IOException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ArrayValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ArrayValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ArrayValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ArrayValue)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ArrayValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeValues(int paramInt) {
    ensureValuesIsMutable();
    this.values_.remove(paramInt);
  }
  
  private void setValues(int paramInt, Value.Builder paramBuilder) {
    ensureValuesIsMutable();
    this.values_.set(paramInt, paramBuilder.build());
  }
  
  private void setValues(int paramInt, Value paramValue) {
    if (paramValue != null) {
      ensureValuesIsMutable();
      this.values_.set(paramInt, paramValue);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/ArrayValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 323, 2 -> 319, 3 -> 308, 4 -> 299, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/ArrayValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/ArrayValue
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/ArrayValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/ArrayValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ArrayValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/ArrayValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/ArrayValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/ArrayValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/ArrayValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   159: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   162: invokeinterface isModifiable : ()Z
    //   167: ifne -> 181
    //   170: aload_0
    //   171: aload_0
    //   172: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   175: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   178: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   181: aload_0
    //   182: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   185: aload_1
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_2
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/firestore/v1/Value
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
    //   219: astore_3
    //   220: new com/google/protobuf/InvalidProtocolBufferException
    //   223: astore_1
    //   224: aload_1
    //   225: aload_2
    //   226: invokevirtual getMessage : ()Ljava/lang/String;
    //   229: invokespecial <init> : (Ljava/lang/String;)V
    //   232: aload_3
    //   233: aload_1
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
    //   261: getstatic com/google/firestore/v1/ArrayValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ArrayValue;
    //   264: areturn
    //   265: aload_2
    //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   269: astore_1
    //   270: aload_3
    //   271: checkcast com/google/firestore/v1/ArrayValue
    //   274: astore_2
    //   275: aload_0
    //   276: aload_1
    //   277: aload_0
    //   278: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   281: aload_2
    //   282: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   285: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   290: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   293: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   296: astore_1
    //   297: aload_0
    //   298: areturn
    //   299: new com/google/firestore/v1/ArrayValue$Builder
    //   302: dup
    //   303: aconst_null
    //   304: invokespecial <init> : (Lcom/google/firestore/v1/ArrayValue$1;)V
    //   307: areturn
    //   308: aload_0
    //   309: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   312: invokeinterface makeImmutable : ()V
    //   317: aconst_null
    //   318: areturn
    //   319: getstatic com/google/firestore/v1/ArrayValue.DEFAULT_INSTANCE : Lcom/google/firestore/v1/ArrayValue;
    //   322: areturn
    //   323: new com/google/firestore/v1/ArrayValue
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
    while (b < this.values_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(b));
      b++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Value getValues(int paramInt) {
    return (Value)this.values_.get(paramInt);
  }
  
  public int getValuesCount() {
    return this.values_.size();
  }
  
  public List<Value> getValuesList() {
    return (List<Value>)this.values_;
  }
  
  public ValueOrBuilder getValuesOrBuilder(int paramInt) {
    return (ValueOrBuilder)this.values_.get(paramInt);
  }
  
  public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
    return (List)this.values_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.values_.size(); b++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.values_.get(b)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ArrayValue, Builder> implements ArrayValueOrBuilder {
    private Builder() {
      super(ArrayValue.DEFAULT_INSTANCE);
    }
    
    public Builder addAllValues(Iterable<? extends Value> param1Iterable) {
      copyOnWrite();
      ((ArrayValue)this.instance).addAllValues(param1Iterable);
      return this;
    }
    
    public Builder addValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((ArrayValue)this.instance).addValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder addValues(int param1Int, Value param1Value) {
      copyOnWrite();
      ((ArrayValue)this.instance).addValues(param1Int, param1Value);
      return this;
    }
    
    public Builder addValues(Value.Builder param1Builder) {
      copyOnWrite();
      ((ArrayValue)this.instance).addValues(param1Builder);
      return this;
    }
    
    public Builder addValues(Value param1Value) {
      copyOnWrite();
      ((ArrayValue)this.instance).addValues(param1Value);
      return this;
    }
    
    public Builder clearValues() {
      copyOnWrite();
      ((ArrayValue)this.instance).clearValues();
      return this;
    }
    
    public Value getValues(int param1Int) {
      return ((ArrayValue)this.instance).getValues(param1Int);
    }
    
    public int getValuesCount() {
      return ((ArrayValue)this.instance).getValuesCount();
    }
    
    public List<Value> getValuesList() {
      return Collections.unmodifiableList(((ArrayValue)this.instance).getValuesList());
    }
    
    public Builder removeValues(int param1Int) {
      copyOnWrite();
      ((ArrayValue)this.instance).removeValues(param1Int);
      return this;
    }
    
    public Builder setValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((ArrayValue)this.instance).setValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder setValues(int param1Int, Value param1Value) {
      copyOnWrite();
      ((ArrayValue)this.instance).setValues(param1Int, param1Value);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\ArrayValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */