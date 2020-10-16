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

public final class Cursor extends GeneratedMessageLite<Cursor, Cursor.Builder> implements CursorOrBuilder {
  public static final int BEFORE_FIELD_NUMBER = 2;
  
  private static final Cursor DEFAULT_INSTANCE = new Cursor();
  
  private static volatile Parser<Cursor> PARSER;
  
  public static final int VALUES_FIELD_NUMBER = 1;
  
  private boolean before_;
  
  private int bitField0_;
  
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
  
  private void clearBefore() {
    this.before_ = false;
  }
  
  private void clearValues() {
    this.values_ = emptyProtobufList();
  }
  
  private void ensureValuesIsMutable() {
    if (!this.values_.isModifiable())
      this.values_ = GeneratedMessageLite.mutableCopy(this.values_); 
  }
  
  public static Cursor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Cursor paramCursor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramCursor);
  }
  
  public static Cursor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Cursor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Cursor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Cursor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Cursor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Cursor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Cursor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Cursor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Cursor parseFrom(InputStream paramInputStream) throws IOException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Cursor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Cursor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Cursor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Cursor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Cursor> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeValues(int paramInt) {
    ensureValuesIsMutable();
    this.values_.remove(paramInt);
  }
  
  private void setBefore(boolean paramBoolean) {
    this.before_ = paramBoolean;
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
    //   0: getstatic com/google/firestore/v1/Cursor$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 387, 2 -> 383, 3 -> 372, 4 -> 363, 5 -> 283, 6 -> 110, 7 -> 279, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/firestore/v1/Cursor.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/firestore/v1/Cursor
    //   72: monitorenter
    //   73: getstatic com/google/firestore/v1/Cursor.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/firestore/v1/Cursor.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Cursor;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/firestore/v1/Cursor.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/firestore/v1/Cursor
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/firestore/v1/Cursor
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/firestore/v1/Cursor.PARSER : Lcom/google/protobuf/Parser;
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
    //   148: bipush #16
    //   150: if_icmpeq -> 165
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: goto -> 223
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual readBool : ()Z
    //   170: putfield before_ : Z
    //   173: goto -> 123
    //   176: aload_0
    //   177: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   180: invokeinterface isModifiable : ()Z
    //   185: ifne -> 199
    //   188: aload_0
    //   189: aload_0
    //   190: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   193: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   196: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   199: aload_0
    //   200: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   203: aload_1
    //   204: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   207: aload_2
    //   208: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   211: checkcast com/google/firestore/v1/Value
    //   214: invokeinterface add : (Ljava/lang/Object;)Z
    //   219: pop
    //   220: goto -> 123
    //   223: iconst_1
    //   224: istore #4
    //   226: goto -> 123
    //   229: astore_1
    //   230: goto -> 277
    //   233: astore_1
    //   234: new java/lang/RuntimeException
    //   237: astore_2
    //   238: new com/google/protobuf/InvalidProtocolBufferException
    //   241: astore_3
    //   242: aload_3
    //   243: aload_1
    //   244: invokevirtual getMessage : ()Ljava/lang/String;
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: aload_2
    //   251: aload_3
    //   252: aload_0
    //   253: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   256: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   259: aload_2
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
    //   279: getstatic com/google/firestore/v1/Cursor.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Cursor;
    //   282: areturn
    //   283: aload_2
    //   284: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   287: astore_1
    //   288: aload_3
    //   289: checkcast com/google/firestore/v1/Cursor
    //   292: astore_2
    //   293: aload_0
    //   294: aload_1
    //   295: aload_0
    //   296: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   299: aload_2
    //   300: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   303: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   308: putfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   311: aload_0
    //   312: getfield before_ : Z
    //   315: istore #6
    //   317: aload_2
    //   318: getfield before_ : Z
    //   321: istore #7
    //   323: aload_0
    //   324: aload_1
    //   325: iload #6
    //   327: iload #6
    //   329: iload #7
    //   331: iload #7
    //   333: invokeinterface visitBoolean : (ZZZZ)Z
    //   338: putfield before_ : Z
    //   341: aload_1
    //   342: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   345: if_acmpne -> 361
    //   348: aload_0
    //   349: aload_0
    //   350: getfield bitField0_ : I
    //   353: aload_2
    //   354: getfield bitField0_ : I
    //   357: ior
    //   358: putfield bitField0_ : I
    //   361: aload_0
    //   362: areturn
    //   363: new com/google/firestore/v1/Cursor$Builder
    //   366: dup
    //   367: aconst_null
    //   368: invokespecial <init> : (Lcom/google/firestore/v1/Cursor$1;)V
    //   371: areturn
    //   372: aload_0
    //   373: getfield values_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   376: invokeinterface makeImmutable : ()V
    //   381: aconst_null
    //   382: areturn
    //   383: getstatic com/google/firestore/v1/Cursor.DEFAULT_INSTANCE : Lcom/google/firestore/v1/Cursor;
    //   386: areturn
    //   387: new com/google/firestore/v1/Cursor
    //   390: dup
    //   391: invokespecial <init> : ()V
    //   394: areturn
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
  
  public boolean getBefore() {
    return this.before_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    i = 0;
    while (j < this.values_.size()) {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.values_.get(j));
      j++;
    } 
    boolean bool = this.before_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(2, bool); 
    this.memoizedSerializedSize = j;
    return j;
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
    boolean bool = this.before_;
    if (bool)
      paramCodedOutputStream.writeBool(2, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Cursor, Builder> implements CursorOrBuilder {
    private Builder() {
      super(Cursor.DEFAULT_INSTANCE);
    }
    
    public Builder addAllValues(Iterable<? extends Value> param1Iterable) {
      copyOnWrite();
      ((Cursor)this.instance).addAllValues(param1Iterable);
      return this;
    }
    
    public Builder addValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((Cursor)this.instance).addValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder addValues(int param1Int, Value param1Value) {
      copyOnWrite();
      ((Cursor)this.instance).addValues(param1Int, param1Value);
      return this;
    }
    
    public Builder addValues(Value.Builder param1Builder) {
      copyOnWrite();
      ((Cursor)this.instance).addValues(param1Builder);
      return this;
    }
    
    public Builder addValues(Value param1Value) {
      copyOnWrite();
      ((Cursor)this.instance).addValues(param1Value);
      return this;
    }
    
    public Builder clearBefore() {
      copyOnWrite();
      ((Cursor)this.instance).clearBefore();
      return this;
    }
    
    public Builder clearValues() {
      copyOnWrite();
      ((Cursor)this.instance).clearValues();
      return this;
    }
    
    public boolean getBefore() {
      return ((Cursor)this.instance).getBefore();
    }
    
    public Value getValues(int param1Int) {
      return ((Cursor)this.instance).getValues(param1Int);
    }
    
    public int getValuesCount() {
      return ((Cursor)this.instance).getValuesCount();
    }
    
    public List<Value> getValuesList() {
      return Collections.unmodifiableList(((Cursor)this.instance).getValuesList());
    }
    
    public Builder removeValues(int param1Int) {
      copyOnWrite();
      ((Cursor)this.instance).removeValues(param1Int);
      return this;
    }
    
    public Builder setBefore(boolean param1Boolean) {
      copyOnWrite();
      ((Cursor)this.instance).setBefore(param1Boolean);
      return this;
    }
    
    public Builder setValues(int param1Int, Value.Builder param1Builder) {
      copyOnWrite();
      ((Cursor)this.instance).setValues(param1Int, param1Builder);
      return this;
    }
    
    public Builder setValues(int param1Int, Value param1Value) {
      copyOnWrite();
      ((Cursor)this.instance).setValues(param1Int, param1Value);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\Cursor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */