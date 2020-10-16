package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class EnumValue extends GeneratedMessageLite<EnumValue, EnumValue.Builder> implements EnumValueOrBuilder {
  private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int NUMBER_FIELD_NUMBER = 2;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<EnumValue> PARSER;
  
  private int bitField0_;
  
  private String name_ = "";
  
  private int number_;
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearNumber() {
    this.number_ = 0;
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static EnumValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(EnumValue paramEnumValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramEnumValue);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (EnumValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static EnumValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static EnumValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static EnumValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static EnumValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<EnumValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<EnumValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNumber(int paramInt) {
    this.number_ = paramInt;
  }
  
  private void setOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.set(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/EnumValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 468, 2 -> 464, 3 -> 453, 4 -> 444, 5 -> 306, 6 -> 118, 7 -> 302, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/EnumValue
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/EnumValue
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/EnumValue
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/EnumValue.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 302
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 246
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 235
    //   151: iload #4
    //   153: bipush #16
    //   155: if_icmpeq -> 224
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 177
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual skipField : (I)Z
    //   171: ifne -> 128
    //   174: goto -> 246
    //   177: aload_0
    //   178: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   181: invokeinterface isModifiable : ()Z
    //   186: ifne -> 200
    //   189: aload_0
    //   190: aload_0
    //   191: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   194: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   197: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   200: aload_0
    //   201: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   204: aload_1
    //   205: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   208: aload_2
    //   209: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   212: checkcast com/google/protobuf/Option
    //   215: invokeinterface add : (Ljava/lang/Object;)Z
    //   220: pop
    //   221: goto -> 128
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual readInt32 : ()I
    //   229: putfield number_ : I
    //   232: goto -> 128
    //   235: aload_0
    //   236: aload_1
    //   237: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   240: putfield name_ : Ljava/lang/String;
    //   243: goto -> 128
    //   246: iconst_1
    //   247: istore #6
    //   249: goto -> 128
    //   252: astore_1
    //   253: goto -> 300
    //   256: astore_3
    //   257: new java/lang/RuntimeException
    //   260: astore_1
    //   261: new com/google/protobuf/InvalidProtocolBufferException
    //   264: astore_2
    //   265: aload_2
    //   266: aload_3
    //   267: invokevirtual getMessage : ()Ljava/lang/String;
    //   270: invokespecial <init> : (Ljava/lang/String;)V
    //   273: aload_1
    //   274: aload_2
    //   275: aload_0
    //   276: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   279: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   282: aload_1
    //   283: athrow
    //   284: astore_2
    //   285: new java/lang/RuntimeException
    //   288: astore_1
    //   289: aload_1
    //   290: aload_2
    //   291: aload_0
    //   292: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   295: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   298: aload_1
    //   299: athrow
    //   300: aload_1
    //   301: athrow
    //   302: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   305: areturn
    //   306: aload_2
    //   307: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   310: astore_1
    //   311: aload_3
    //   312: checkcast com/google/protobuf/EnumValue
    //   315: astore_2
    //   316: aload_0
    //   317: aload_1
    //   318: aload_0
    //   319: getfield name_ : Ljava/lang/String;
    //   322: invokevirtual isEmpty : ()Z
    //   325: iconst_1
    //   326: ixor
    //   327: aload_0
    //   328: getfield name_ : Ljava/lang/String;
    //   331: aload_2
    //   332: getfield name_ : Ljava/lang/String;
    //   335: invokevirtual isEmpty : ()Z
    //   338: iconst_1
    //   339: ixor
    //   340: aload_2
    //   341: getfield name_ : Ljava/lang/String;
    //   344: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   349: putfield name_ : Ljava/lang/String;
    //   352: aload_0
    //   353: getfield number_ : I
    //   356: ifeq -> 365
    //   359: iconst_1
    //   360: istore #7
    //   362: goto -> 368
    //   365: iconst_0
    //   366: istore #7
    //   368: aload_0
    //   369: getfield number_ : I
    //   372: istore #6
    //   374: aload_2
    //   375: getfield number_ : I
    //   378: ifeq -> 384
    //   381: iconst_1
    //   382: istore #5
    //   384: aload_0
    //   385: aload_1
    //   386: iload #7
    //   388: iload #6
    //   390: iload #5
    //   392: aload_2
    //   393: getfield number_ : I
    //   396: invokeinterface visitInt : (ZIZI)I
    //   401: putfield number_ : I
    //   404: aload_0
    //   405: aload_1
    //   406: aload_0
    //   407: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   410: aload_2
    //   411: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   414: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   419: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   422: aload_1
    //   423: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   426: if_acmpne -> 442
    //   429: aload_0
    //   430: aload_0
    //   431: getfield bitField0_ : I
    //   434: aload_2
    //   435: getfield bitField0_ : I
    //   438: ior
    //   439: putfield bitField0_ : I
    //   442: aload_0
    //   443: areturn
    //   444: new com/google/protobuf/EnumValue$Builder
    //   447: dup
    //   448: aconst_null
    //   449: invokespecial <init> : (Lcom/google/protobuf/EnumValue$1;)V
    //   452: areturn
    //   453: aload_0
    //   454: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   457: invokeinterface makeImmutable : ()V
    //   462: aconst_null
    //   463: areturn
    //   464: getstatic com/google/protobuf/EnumValue.DEFAULT_INSTANCE : Lcom/google/protobuf/EnumValue;
    //   467: areturn
    //   468: new com/google/protobuf/EnumValue
    //   471: dup
    //   472: invokespecial <init> : ()V
    //   475: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	284	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	256	java/io/IOException
    //   133	139	252	finally
    //   165	174	284	com/google/protobuf/InvalidProtocolBufferException
    //   165	174	256	java/io/IOException
    //   165	174	252	finally
    //   177	200	284	com/google/protobuf/InvalidProtocolBufferException
    //   177	200	256	java/io/IOException
    //   177	200	252	finally
    //   200	221	284	com/google/protobuf/InvalidProtocolBufferException
    //   200	221	256	java/io/IOException
    //   200	221	252	finally
    //   224	232	284	com/google/protobuf/InvalidProtocolBufferException
    //   224	232	256	java/io/IOException
    //   224	232	252	finally
    //   235	243	284	com/google/protobuf/InvalidProtocolBufferException
    //   235	243	256	java/io/IOException
    //   235	243	252	finally
    //   257	284	252	finally
    //   285	300	252	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getNumber() {
    return this.number_;
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public int getSerializedSize() {
    byte b2;
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      b2 = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      b2 = 0;
    } 
    int j = this.number_;
    i = b2;
    byte b3 = b1;
    if (j != 0) {
      i = b2 + CodedOutputStream.computeInt32Size(2, j);
      b3 = b1;
    } 
    while (b3 < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(b3));
      b3++;
    } 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    int i = this.number_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(2, i); 
    for (i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(3, this.options_.get(i)); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<EnumValue, Builder> implements EnumValueOrBuilder {
    private Builder() {
      super(EnumValue.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Builder);
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Option);
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearNumber() {
      copyOnWrite();
      this.instance.clearNumber();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public int getNumber() {
      return this.instance.getNumber();
    }
    
    public Option getOptions(int param1Int) {
      return this.instance.getOptions(param1Int);
    }
    
    public int getOptionsCount() {
      return this.instance.getOptionsCount();
    }
    
    public List<Option> getOptionsList() {
      return Collections.unmodifiableList(this.instance.getOptionsList());
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setNumber(int param1Int) {
      copyOnWrite();
      this.instance.setNumber(param1Int);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Option);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\EnumValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */