package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
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

public final class PluginProtos {
  static {
  
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, CodeGeneratorRequest.Builder> implements CodeGeneratorRequestOrBuilder {
    public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
    
    private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
    
    public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
    
    public static final int PARAMETER_FIELD_NUMBER = 2;
    
    private static volatile Parser<CodeGeneratorRequest> PARSER;
    
    public static final int PROTO_FILE_FIELD_NUMBER = 15;
    
    private int bitField0_;
    
    private PluginProtos.Version compilerVersion_;
    
    private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    
    private byte memoizedIsInitialized = (byte)-1;
    
    private String parameter_ = "";
    
    private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFileToGenerate(Iterable<String> param1Iterable) {
      ensureFileToGenerateIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.fileToGenerate_);
    }
    
    private void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param1Iterable) {
      ensureProtoFileIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.protoFile_);
    }
    
    private void addFileToGenerate(String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFileToGenerateBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1ByteString.toStringUtf8());
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.add(param1Int, param1Builder.build());
    }
    
    private void addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1Int, param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.add(param1Builder.build());
    }
    
    private void addProtoFile(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearCompilerVersion() {
      this.compilerVersion_ = null;
      this.bitField0_ &= 0xFFFFFFFD;
    }
    
    private void clearFileToGenerate() {
      this.fileToGenerate_ = GeneratedMessageLite.emptyProtobufList();
    }
    
    private void clearParameter() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.parameter_ = getDefaultInstance().getParameter();
    }
    
    private void clearProtoFile() {
      this.protoFile_ = emptyProtobufList();
    }
    
    private void ensureFileToGenerateIsMutable() {
      if (!this.fileToGenerate_.isModifiable())
        this.fileToGenerate_ = GeneratedMessageLite.mutableCopy(this.fileToGenerate_); 
    }
    
    private void ensureProtoFileIsMutable() {
      if (!this.protoFile_.isModifiable())
        this.protoFile_ = GeneratedMessageLite.mutableCopy(this.protoFile_); 
    }
    
    public static CodeGeneratorRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCompilerVersion(PluginProtos.Version param1Version) {
      PluginProtos.Version version = this.compilerVersion_;
      if (version != null && version != PluginProtos.Version.getDefaultInstance()) {
        this.compilerVersion_ = (PluginProtos.Version)((PluginProtos.Version.Builder)PluginProtos.Version.newBuilder(this.compilerVersion_).mergeFrom(param1Version)).buildPartial();
      } else {
        this.compilerVersion_ = param1Version;
      } 
      this.bitField0_ |= 0x2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorRequest param1CodeGeneratorRequest) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CodeGeneratorRequest);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorRequest> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeProtoFile(int param1Int) {
      ensureProtoFileIsMutable();
      this.protoFile_.remove(param1Int);
    }
    
    private void setCompilerVersion(PluginProtos.Version.Builder param1Builder) {
      this.compilerVersion_ = (PluginProtos.Version)param1Builder.build();
      this.bitField0_ |= 0x2;
    }
    
    private void setCompilerVersion(PluginProtos.Version param1Version) {
      if (param1Version != null) {
        this.compilerVersion_ = param1Version;
        this.bitField0_ |= 0x2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFileToGenerate(int param1Int, String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.set(param1Int, param1String);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParameter(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.parameter_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setParameterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.parameter_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      ensureProtoFileIsMutable();
      this.protoFile_.set(param1Int, param1Builder.build());
    }
    
    private void setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      if (param1FileDescriptorProto != null) {
        ensureProtoFileIsMutable();
        this.protoFile_.set(param1Int, param1FileDescriptorProto);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iload #4
      //   15: tableswitch default -> 60, 1 -> 665, 2 -> 575, 3 -> 555, 4 -> 546, 5 -> 431, 6 -> 114, 7 -> 427, 8 -> 68
      //   60: new java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial <init> : ()V
      //   67: athrow
      //   68: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   71: ifnonnull -> 110
      //   74: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   76: monitorenter
      //   77: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   80: ifnonnull -> 98
      //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   86: astore_1
      //   87: aload_1
      //   88: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   94: aload_1
      //   95: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   98: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   100: monitorexit
      //   101: goto -> 110
      //   104: astore_1
      //   105: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   107: monitorexit
      //   108: aload_1
      //   109: athrow
      //   110: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.PARSER : Lcom/google/protobuf/Parser;
      //   113: areturn
      //   114: aload_2
      //   115: checkcast com/google/protobuf/CodedInputStream
      //   118: astore_2
      //   119: aload_3
      //   120: checkcast com/google/protobuf/ExtensionRegistryLite
      //   123: astore_3
      //   124: iload #5
      //   126: ifne -> 427
      //   129: aload_2
      //   130: invokevirtual readTag : ()I
      //   133: istore #4
      //   135: iload #4
      //   137: ifeq -> 371
      //   140: iload #4
      //   142: bipush #10
      //   144: if_icmpeq -> 329
      //   147: iload #4
      //   149: bipush #18
      //   151: if_icmpeq -> 306
      //   154: iload #4
      //   156: bipush #26
      //   158: if_icmpeq -> 228
      //   161: iload #4
      //   163: bipush #122
      //   165: if_icmpeq -> 181
      //   168: aload_0
      //   169: iload #4
      //   171: aload_2
      //   172: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   175: ifne -> 124
      //   178: goto -> 371
      //   181: aload_0
      //   182: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   185: invokeinterface isModifiable : ()Z
      //   190: ifne -> 204
      //   193: aload_0
      //   194: aload_0
      //   195: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   198: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   201: putfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   204: aload_0
      //   205: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   208: aload_2
      //   209: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   212: aload_3
      //   213: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   216: checkcast com/google/protobuf/DescriptorProtos$FileDescriptorProto
      //   219: invokeinterface add : (Ljava/lang/Object;)Z
      //   224: pop
      //   225: goto -> 124
      //   228: aload_0
      //   229: getfield bitField0_ : I
      //   232: iconst_2
      //   233: iand
      //   234: iconst_2
      //   235: if_icmpne -> 252
      //   238: aload_0
      //   239: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   242: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   245: checkcast com/google/protobuf/compiler/PluginProtos$Version$Builder
      //   248: astore_1
      //   249: goto -> 254
      //   252: aconst_null
      //   253: astore_1
      //   254: aload_0
      //   255: aload_2
      //   256: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   259: aload_3
      //   260: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   263: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   266: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   269: aload_1
      //   270: ifnull -> 293
      //   273: aload_1
      //   274: aload_0
      //   275: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   278: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   281: pop
      //   282: aload_0
      //   283: aload_1
      //   284: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   287: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   290: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   293: aload_0
      //   294: aload_0
      //   295: getfield bitField0_ : I
      //   298: iconst_2
      //   299: ior
      //   300: putfield bitField0_ : I
      //   303: goto -> 124
      //   306: aload_2
      //   307: invokevirtual readString : ()Ljava/lang/String;
      //   310: astore_1
      //   311: aload_0
      //   312: aload_0
      //   313: getfield bitField0_ : I
      //   316: iconst_1
      //   317: ior
      //   318: putfield bitField0_ : I
      //   321: aload_0
      //   322: aload_1
      //   323: putfield parameter_ : Ljava/lang/String;
      //   326: goto -> 124
      //   329: aload_2
      //   330: invokevirtual readString : ()Ljava/lang/String;
      //   333: astore_1
      //   334: aload_0
      //   335: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   338: invokeinterface isModifiable : ()Z
      //   343: ifne -> 357
      //   346: aload_0
      //   347: aload_0
      //   348: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   351: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   354: putfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   357: aload_0
      //   358: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   361: aload_1
      //   362: invokeinterface add : (Ljava/lang/Object;)Z
      //   367: pop
      //   368: goto -> 124
      //   371: iconst_1
      //   372: istore #5
      //   374: goto -> 124
      //   377: astore_1
      //   378: goto -> 425
      //   381: astore_2
      //   382: new java/lang/RuntimeException
      //   385: astore_1
      //   386: new com/google/protobuf/InvalidProtocolBufferException
      //   389: astore_3
      //   390: aload_3
      //   391: aload_2
      //   392: invokevirtual getMessage : ()Ljava/lang/String;
      //   395: invokespecial <init> : (Ljava/lang/String;)V
      //   398: aload_1
      //   399: aload_3
      //   400: aload_0
      //   401: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   404: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   407: aload_1
      //   408: athrow
      //   409: astore_2
      //   410: new java/lang/RuntimeException
      //   413: astore_1
      //   414: aload_1
      //   415: aload_2
      //   416: aload_0
      //   417: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   420: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   423: aload_1
      //   424: athrow
      //   425: aload_1
      //   426: athrow
      //   427: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   430: areturn
      //   431: aload_2
      //   432: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   435: astore_1
      //   436: aload_3
      //   437: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   440: astore_2
      //   441: aload_0
      //   442: aload_1
      //   443: aload_0
      //   444: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   447: aload_2
      //   448: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   451: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   456: putfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   459: aload_0
      //   460: aload_1
      //   461: aload_0
      //   462: invokevirtual hasParameter : ()Z
      //   465: aload_0
      //   466: getfield parameter_ : Ljava/lang/String;
      //   469: aload_2
      //   470: invokevirtual hasParameter : ()Z
      //   473: aload_2
      //   474: getfield parameter_ : Ljava/lang/String;
      //   477: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   482: putfield parameter_ : Ljava/lang/String;
      //   485: aload_0
      //   486: aload_1
      //   487: aload_0
      //   488: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   491: aload_2
      //   492: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   495: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   500: putfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   503: aload_0
      //   504: aload_1
      //   505: aload_0
      //   506: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   509: aload_2
      //   510: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   513: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   518: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   521: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   524: aload_1
      //   525: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   528: if_acmpne -> 544
      //   531: aload_0
      //   532: aload_0
      //   533: getfield bitField0_ : I
      //   536: aload_2
      //   537: getfield bitField0_ : I
      //   540: ior
      //   541: putfield bitField0_ : I
      //   544: aload_0
      //   545: areturn
      //   546: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest$Builder
      //   549: dup
      //   550: aconst_null
      //   551: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   554: areturn
      //   555: aload_0
      //   556: getfield fileToGenerate_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   559: invokeinterface makeImmutable : ()V
      //   564: aload_0
      //   565: getfield protoFile_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   568: invokeinterface makeImmutable : ()V
      //   573: aconst_null
      //   574: areturn
      //   575: aload_0
      //   576: getfield memoizedIsInitialized : B
      //   579: istore #5
      //   581: iload #5
      //   583: iconst_1
      //   584: if_icmpne -> 591
      //   587: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   590: areturn
      //   591: iload #5
      //   593: ifne -> 598
      //   596: aconst_null
      //   597: areturn
      //   598: aload_2
      //   599: checkcast java/lang/Boolean
      //   602: invokevirtual booleanValue : ()Z
      //   605: istore #6
      //   607: iconst_0
      //   608: istore #5
      //   610: iload #5
      //   612: aload_0
      //   613: invokevirtual getProtoFileCount : ()I
      //   616: if_icmpge -> 650
      //   619: aload_0
      //   620: iload #5
      //   622: invokevirtual getProtoFile : (I)Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;
      //   625: invokevirtual isInitialized : ()Z
      //   628: ifne -> 644
      //   631: iload #6
      //   633: ifeq -> 642
      //   636: aload_0
      //   637: iconst_0
      //   638: i2b
      //   639: putfield memoizedIsInitialized : B
      //   642: aconst_null
      //   643: areturn
      //   644: iinc #5, 1
      //   647: goto -> 610
      //   650: iload #6
      //   652: ifeq -> 661
      //   655: aload_0
      //   656: iconst_1
      //   657: i2b
      //   658: putfield memoizedIsInitialized : B
      //   661: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest;
      //   664: areturn
      //   665: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorRequest
      //   668: dup
      //   669: invokespecial <init> : ()V
      //   672: areturn
      // Exception table:
      //   from	to	target	type
      //   77	98	104	finally
      //   98	101	104	finally
      //   105	108	104	finally
      //   129	135	409	com/google/protobuf/InvalidProtocolBufferException
      //   129	135	381	java/io/IOException
      //   129	135	377	finally
      //   168	178	409	com/google/protobuf/InvalidProtocolBufferException
      //   168	178	381	java/io/IOException
      //   168	178	377	finally
      //   181	204	409	com/google/protobuf/InvalidProtocolBufferException
      //   181	204	381	java/io/IOException
      //   181	204	377	finally
      //   204	225	409	com/google/protobuf/InvalidProtocolBufferException
      //   204	225	381	java/io/IOException
      //   204	225	377	finally
      //   228	249	409	com/google/protobuf/InvalidProtocolBufferException
      //   228	249	381	java/io/IOException
      //   228	249	377	finally
      //   254	269	409	com/google/protobuf/InvalidProtocolBufferException
      //   254	269	381	java/io/IOException
      //   254	269	377	finally
      //   273	293	409	com/google/protobuf/InvalidProtocolBufferException
      //   273	293	381	java/io/IOException
      //   273	293	377	finally
      //   293	303	409	com/google/protobuf/InvalidProtocolBufferException
      //   293	303	381	java/io/IOException
      //   293	303	377	finally
      //   306	326	409	com/google/protobuf/InvalidProtocolBufferException
      //   306	326	381	java/io/IOException
      //   306	326	377	finally
      //   329	357	409	com/google/protobuf/InvalidProtocolBufferException
      //   329	357	381	java/io/IOException
      //   329	357	377	finally
      //   357	368	409	com/google/protobuf/InvalidProtocolBufferException
      //   357	368	381	java/io/IOException
      //   357	368	377	finally
      //   382	409	377	finally
      //   410	425	377	finally
    }
    
    public PluginProtos.Version getCompilerVersion() {
      PluginProtos.Version version1 = this.compilerVersion_;
      PluginProtos.Version version2 = version1;
      if (version1 == null)
        version2 = PluginProtos.Version.getDefaultInstance(); 
      return version2;
    }
    
    public String getFileToGenerate(int param1Int) {
      return (String)this.fileToGenerate_.get(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return ByteString.copyFromUtf8((String)this.fileToGenerate_.get(param1Int));
    }
    
    public int getFileToGenerateCount() {
      return this.fileToGenerate_.size();
    }
    
    public List<String> getFileToGenerateList() {
      return (List<String>)this.fileToGenerate_;
    }
    
    public String getParameter() {
      return this.parameter_;
    }
    
    public ByteString getParameterBytes() {
      return ByteString.copyFromUtf8(this.parameter_);
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      return (DescriptorProtos.FileDescriptorProto)this.protoFile_.get(param1Int);
    }
    
    public int getProtoFileCount() {
      return this.protoFile_.size();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      return (List<DescriptorProtos.FileDescriptorProto>)this.protoFile_;
    }
    
    public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param1Int) {
      return (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(param1Int);
    }
    
    public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
      return (List)this.protoFile_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      byte b1 = 0;
      i = 0;
      int j = i;
      while (i < this.fileToGenerate_.size()) {
        j += CodedOutputStream.computeStringSizeNoTag((String)this.fileToGenerate_.get(i));
        i++;
      } 
      j = j + 0 + getFileToGenerateList().size() * 1;
      i = j;
      if ((this.bitField0_ & 0x1) == 1)
        i = j + CodedOutputStream.computeStringSize(2, getParameter()); 
      byte b2 = b1;
      j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCompilerVersion());
        b2 = b1;
      } 
      while (b2 < this.protoFile_.size()) {
        j += CodedOutputStream.computeMessageSize(15, (MessageLite)this.protoFile_.get(b2));
        b2++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCompilerVersion() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasParameter() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      boolean bool = false;
      byte b;
      for (b = 0; b < this.fileToGenerate_.size(); b++)
        param1CodedOutputStream.writeString(1, (String)this.fileToGenerate_.get(b)); 
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(2, getParameter()); 
      b = bool;
      if ((this.bitField0_ & 0x2) == 2) {
        param1CodedOutputStream.writeMessage(3, (MessageLite)getCompilerVersion());
        b = bool;
      } 
      while (b < this.protoFile_.size()) {
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.protoFile_.get(b));
        b++;
      } 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements PluginProtos.CodeGeneratorRequestOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorRequest.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFileToGenerate(Iterable<String> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllFileToGenerate(param2Iterable);
        return this;
      }
      
      public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addAllProtoFile(param2Iterable);
        return this;
      }
      
      public Builder addFileToGenerate(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerate(param2String);
        return this;
      }
      
      public Builder addFileToGenerateBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerateBytes(param2ByteString);
        return this;
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Int, param2FileDescriptorProto);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2Builder);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param2FileDescriptorProto);
        return this;
      }
      
      public Builder clearCompilerVersion() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearCompilerVersion();
        return this;
      }
      
      public Builder clearFileToGenerate() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearFileToGenerate();
        return this;
      }
      
      public Builder clearParameter() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearParameter();
        return this;
      }
      
      public Builder clearProtoFile() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).clearProtoFile();
        return this;
      }
      
      public PluginProtos.Version getCompilerVersion() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getCompilerVersion();
      }
      
      public String getFileToGenerate(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerate(param2Int);
      }
      
      public ByteString getFileToGenerateBytes(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateBytes(param2Int);
      }
      
      public int getFileToGenerateCount() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateCount();
      }
      
      public List<String> getFileToGenerateList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateList());
      }
      
      public String getParameter() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameter();
      }
      
      public ByteString getParameterBytes() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameterBytes();
      }
      
      public DescriptorProtos.FileDescriptorProto getProtoFile(int param2Int) {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFile(param2Int);
      }
      
      public int getProtoFileCount() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileCount();
      }
      
      public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileList());
      }
      
      public boolean hasCompilerVersion() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).hasCompilerVersion();
      }
      
      public boolean hasParameter() {
        return ((PluginProtos.CodeGeneratorRequest)this.instance).hasParameter();
      }
      
      public Builder mergeCompilerVersion(PluginProtos.Version param2Version) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).mergeCompilerVersion(param2Version);
        return this;
      }
      
      public Builder removeProtoFile(int param2Int) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).removeProtoFile(param2Int);
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param2Builder);
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version param2Version) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param2Version);
        return this;
      }
      
      public Builder setFileToGenerate(int param2Int, String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setFileToGenerate(param2Int, param2String);
        return this;
      }
      
      public Builder setParameter(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameter(param2String);
        return this;
      }
      
      public Builder setParameterBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setParameterBytes(param2ByteString);
        return this;
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param2Int, param2FileDescriptorProto);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, CodeGeneratorRequest.Builder> implements CodeGeneratorRequestOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorRequest.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFileToGenerate(Iterable<String> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addAllFileToGenerate(param1Iterable);
      return this;
    }
    
    public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addAllProtoFile(param1Iterable);
      return this;
    }
    
    public Builder addFileToGenerate(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerate(param1String);
      return this;
    }
    
    public Builder addFileToGenerateBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addFileToGenerateBytes(param1ByteString);
      return this;
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Int, param1FileDescriptorProto);
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1Builder);
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).addProtoFile(param1FileDescriptorProto);
      return this;
    }
    
    public Builder clearCompilerVersion() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearCompilerVersion();
      return this;
    }
    
    public Builder clearFileToGenerate() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearFileToGenerate();
      return this;
    }
    
    public Builder clearParameter() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearParameter();
      return this;
    }
    
    public Builder clearProtoFile() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).clearProtoFile();
      return this;
    }
    
    public PluginProtos.Version getCompilerVersion() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getCompilerVersion();
    }
    
    public String getFileToGenerate(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerate(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateBytes(param1Int);
    }
    
    public int getFileToGenerateCount() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateCount();
    }
    
    public List<String> getFileToGenerateList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getFileToGenerateList());
    }
    
    public String getParameter() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameter();
    }
    
    public ByteString getParameterBytes() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getParameterBytes();
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFile(param1Int);
    }
    
    public int getProtoFileCount() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileCount();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorRequest)this.instance).getProtoFileList());
    }
    
    public boolean hasCompilerVersion() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).hasCompilerVersion();
    }
    
    public boolean hasParameter() {
      return ((PluginProtos.CodeGeneratorRequest)this.instance).hasParameter();
    }
    
    public Builder mergeCompilerVersion(PluginProtos.Version param1Version) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).mergeCompilerVersion(param1Version);
      return this;
    }
    
    public Builder removeProtoFile(int param1Int) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).removeProtoFile(param1Int);
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param1Builder);
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version param1Version) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setCompilerVersion(param1Version);
      return this;
    }
    
    public Builder setFileToGenerate(int param1Int, String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setFileToGenerate(param1Int, param1String);
      return this;
    }
    
    public Builder setParameter(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setParameter(param1String);
      return this;
    }
    
    public Builder setParameterBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setParameterBytes(param1ByteString);
      return this;
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorRequest)this.instance).setProtoFile(param1Int, param1FileDescriptorProto);
      return this;
    }
  }
  
  public static interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
    PluginProtos.Version getCompilerVersion();
    
    String getFileToGenerate(int param1Int);
    
    ByteString getFileToGenerateBytes(int param1Int);
    
    int getFileToGenerateCount();
    
    List<String> getFileToGenerateList();
    
    String getParameter();
    
    ByteString getParameterBytes();
    
    DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int);
    
    int getProtoFileCount();
    
    List<DescriptorProtos.FileDescriptorProto> getProtoFileList();
    
    boolean hasCompilerVersion();
    
    boolean hasParameter();
  }
  
  public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, CodeGeneratorResponse.Builder> implements CodeGeneratorResponseOrBuilder {
    private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
    
    public static final int ERROR_FIELD_NUMBER = 1;
    
    public static final int FILE_FIELD_NUMBER = 15;
    
    private static volatile Parser<CodeGeneratorResponse> PARSER;
    
    private int bitField0_;
    
    private String error_ = "";
    
    private Internal.ProtobufList<File> file_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFile(Iterable<? extends File> param1Iterable) {
      ensureFileIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.file_);
    }
    
    private void addFile(int param1Int, File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.add(param1Int, param1Builder.build());
    }
    
    private void addFile(int param1Int, File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.add(param1Int, param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFile(File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.add(param1Builder.build());
    }
    
    private void addFile(File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.add(param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearError() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.error_ = getDefaultInstance().getError();
    }
    
    private void clearFile() {
      this.file_ = emptyProtobufList();
    }
    
    private void ensureFileIsMutable() {
      if (!this.file_.isModifiable())
        this.file_ = GeneratedMessageLite.mutableCopy(this.file_); 
    }
    
    public static CodeGeneratorResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorResponse param1CodeGeneratorResponse) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CodeGeneratorResponse);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorResponse> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeFile(int param1Int) {
      ensureFileIsMutable();
      this.file_.remove(param1Int);
    }
    
    private void setError(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setErrorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFile(int param1Int, File.Builder param1Builder) {
      ensureFileIsMutable();
      this.file_.set(param1Int, param1Builder.build());
    }
    
    private void setFile(int param1Int, File param1File) {
      if (param1File != null) {
        ensureFileIsMutable();
        this.file_.set(param1Int, param1File);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 396, 2 -> 392, 3 -> 381, 4 -> 372, 5 -> 296, 6 -> 110, 7 -> 292, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.PARSER : Lcom/google/protobuf/Parser;
      //   109: areturn
      //   110: aload_2
      //   111: checkcast com/google/protobuf/CodedInputStream
      //   114: astore_1
      //   115: aload_3
      //   116: checkcast com/google/protobuf/ExtensionRegistryLite
      //   119: astore_3
      //   120: iconst_0
      //   121: istore #4
      //   123: iload #4
      //   125: ifne -> 292
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 236
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 213
      //   146: iload #5
      //   148: bipush #122
      //   150: if_icmpeq -> 166
      //   153: aload_0
      //   154: iload #5
      //   156: aload_1
      //   157: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   160: ifne -> 123
      //   163: goto -> 236
      //   166: aload_0
      //   167: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   170: invokeinterface isModifiable : ()Z
      //   175: ifne -> 189
      //   178: aload_0
      //   179: aload_0
      //   180: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   183: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   186: putfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   189: aload_0
      //   190: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   193: aload_1
      //   194: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   197: aload_3
      //   198: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   201: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   204: invokeinterface add : (Ljava/lang/Object;)Z
      //   209: pop
      //   210: goto -> 123
      //   213: aload_1
      //   214: invokevirtual readString : ()Ljava/lang/String;
      //   217: astore_2
      //   218: aload_0
      //   219: iconst_1
      //   220: aload_0
      //   221: getfield bitField0_ : I
      //   224: ior
      //   225: putfield bitField0_ : I
      //   228: aload_0
      //   229: aload_2
      //   230: putfield error_ : Ljava/lang/String;
      //   233: goto -> 123
      //   236: iconst_1
      //   237: istore #4
      //   239: goto -> 123
      //   242: astore_1
      //   243: goto -> 290
      //   246: astore_2
      //   247: new java/lang/RuntimeException
      //   250: astore_1
      //   251: new com/google/protobuf/InvalidProtocolBufferException
      //   254: astore_3
      //   255: aload_3
      //   256: aload_2
      //   257: invokevirtual getMessage : ()Ljava/lang/String;
      //   260: invokespecial <init> : (Ljava/lang/String;)V
      //   263: aload_1
      //   264: aload_3
      //   265: aload_0
      //   266: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   269: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   272: aload_1
      //   273: athrow
      //   274: astore_1
      //   275: new java/lang/RuntimeException
      //   278: astore_2
      //   279: aload_2
      //   280: aload_1
      //   281: aload_0
      //   282: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   285: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   288: aload_2
      //   289: athrow
      //   290: aload_1
      //   291: athrow
      //   292: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   295: areturn
      //   296: aload_2
      //   297: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   300: astore_1
      //   301: aload_3
      //   302: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   305: astore_2
      //   306: aload_0
      //   307: aload_1
      //   308: aload_0
      //   309: invokevirtual hasError : ()Z
      //   312: aload_0
      //   313: getfield error_ : Ljava/lang/String;
      //   316: aload_2
      //   317: invokevirtual hasError : ()Z
      //   320: aload_2
      //   321: getfield error_ : Ljava/lang/String;
      //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   329: putfield error_ : Ljava/lang/String;
      //   332: aload_0
      //   333: aload_1
      //   334: aload_0
      //   335: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   338: aload_2
      //   339: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   342: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   347: putfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   350: aload_1
      //   351: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   354: if_acmpne -> 370
      //   357: aload_0
      //   358: aload_0
      //   359: getfield bitField0_ : I
      //   362: aload_2
      //   363: getfield bitField0_ : I
      //   366: ior
      //   367: putfield bitField0_ : I
      //   370: aload_0
      //   371: areturn
      //   372: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$Builder
      //   375: dup
      //   376: aconst_null
      //   377: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   380: areturn
      //   381: aload_0
      //   382: getfield file_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   385: invokeinterface makeImmutable : ()V
      //   390: aconst_null
      //   391: areturn
      //   392: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse;
      //   395: areturn
      //   396: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse
      //   399: dup
      //   400: invokespecial <init> : ()V
      //   403: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	274	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	246	java/io/IOException
      //   128	134	242	finally
      //   153	163	274	com/google/protobuf/InvalidProtocolBufferException
      //   153	163	246	java/io/IOException
      //   153	163	242	finally
      //   166	189	274	com/google/protobuf/InvalidProtocolBufferException
      //   166	189	246	java/io/IOException
      //   166	189	242	finally
      //   189	210	274	com/google/protobuf/InvalidProtocolBufferException
      //   189	210	246	java/io/IOException
      //   189	210	242	finally
      //   213	233	274	com/google/protobuf/InvalidProtocolBufferException
      //   213	233	246	java/io/IOException
      //   213	233	242	finally
      //   247	274	242	finally
      //   275	290	242	finally
    }
    
    public String getError() {
      return this.error_;
    }
    
    public ByteString getErrorBytes() {
      return ByteString.copyFromUtf8(this.error_);
    }
    
    public File getFile(int param1Int) {
      return (File)this.file_.get(param1Int);
    }
    
    public int getFileCount() {
      return this.file_.size();
    }
    
    public List<File> getFileList() {
      return (List<File>)this.file_;
    }
    
    public FileOrBuilder getFileOrBuilder(int param1Int) {
      return (FileOrBuilder)this.file_.get(param1Int);
    }
    
    public List<? extends FileOrBuilder> getFileOrBuilderList() {
      return (List)this.file_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      byte b = 0;
      if ((i & 0x1) == 1) {
        i = CodedOutputStream.computeStringSize(1, getError()) + 0;
      } else {
        i = 0;
      } 
      while (b < this.file_.size()) {
        i += CodedOutputStream.computeMessageSize(15, (MessageLite)this.file_.get(b));
        b++;
      } 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasError() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getError()); 
      for (byte b = 0; b < this.file_.size(); b++)
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.file_.get(b)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements PluginProtos.CodeGeneratorResponseOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param2Iterable) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addAllFile(param2Iterable);
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Int, param2File);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2Builder);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param2File);
        return this;
      }
      
      public Builder clearError() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearError();
        return this;
      }
      
      public Builder clearFile() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).clearFile();
        return this;
      }
      
      public String getError() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getError();
      }
      
      public ByteString getErrorBytes() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getErrorBytes();
      }
      
      public PluginProtos.CodeGeneratorResponse.File getFile(int param2Int) {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFile(param2Int);
      }
      
      public int getFileCount() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).getFileCount();
      }
      
      public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
        return Collections.unmodifiableList(((PluginProtos.CodeGeneratorResponse)this.instance).getFileList());
      }
      
      public boolean hasError() {
        return ((PluginProtos.CodeGeneratorResponse)this.instance).hasError();
      }
      
      public Builder removeFile(int param2Int) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).removeFile(param2Int);
        return this;
      }
      
      public Builder setError(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setError(param2String);
        return this;
      }
      
      public Builder setErrorBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setErrorBytes(param2ByteString);
        return this;
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param2Int, param2Builder);
        return this;
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param2Int, param2File);
        return this;
      }
    }
    
    public static final class File extends GeneratedMessageLite<File, File.Builder> implements FileOrBuilder {
      public static final int CONTENT_FIELD_NUMBER = 15;
      
      private static final File DEFAULT_INSTANCE = new File();
      
      public static final int INSERTION_POINT_FIELD_NUMBER = 2;
      
      public static final int NAME_FIELD_NUMBER = 1;
      
      private static volatile Parser<File> PARSER;
      
      private int bitField0_;
      
      private String content_ = "";
      
      private String insertionPoint_ = "";
      
      private String name_ = "";
      
      static {
        DEFAULT_INSTANCE.makeImmutable();
      }
      
      private void clearContent() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.content_ = getDefaultInstance().getContent();
      }
      
      private void clearInsertionPoint() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
      }
      
      private void clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = getDefaultInstance().getName();
      }
      
      public static File getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static Builder newBuilder() {
        return (Builder)DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(File param2File) {
        return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param2File);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString);
      }
      
      public static File parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(InputStream param2InputStream) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream);
      }
      
      public static File parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<File> parser() {
        return DEFAULT_INSTANCE.getParserForType();
      }
      
      private void setContent(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setContentBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setInsertionPoint(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setInsertionPointBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setName(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2String;
          return;
        } 
        throw new NullPointerException();
      }
      
      private void setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2ByteString.toStringUtf8();
          return;
        } 
        throw new NullPointerException();
      }
      
      protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param2MethodToInvoke, Object param2Object1, Object param2Object2) {
        // Byte code:
        //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
        //   3: aload_1
        //   4: invokevirtual ordinal : ()I
        //   7: iaload
        //   8: tableswitch default -> 56, 1 -> 427, 2 -> 423, 3 -> 421, 4 -> 412, 5 -> 302, 6 -> 110, 7 -> 298, 8 -> 64
        //   56: new java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial <init> : ()V
        //   63: athrow
        //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   67: ifnonnull -> 106
        //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   72: monitorenter
        //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   76: ifnonnull -> 94
        //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
        //   82: astore_1
        //   83: aload_1
        //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
        //   90: aload_1
        //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
        //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   96: monitorexit
        //   97: goto -> 106
        //   100: astore_1
        //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   103: monitorexit
        //   104: aload_1
        //   105: athrow
        //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
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
        //   125: ifne -> 298
        //   128: aload_1
        //   129: invokevirtual readTag : ()I
        //   132: istore #5
        //   134: iload #5
        //   136: ifeq -> 242
        //   139: iload #5
        //   141: bipush #10
        //   143: if_icmpeq -> 219
        //   146: iload #5
        //   148: bipush #18
        //   150: if_icmpeq -> 196
        //   153: iload #5
        //   155: bipush #122
        //   157: if_icmpeq -> 173
        //   160: aload_0
        //   161: iload #5
        //   163: aload_1
        //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
        //   167: ifne -> 123
        //   170: goto -> 242
        //   173: aload_1
        //   174: invokevirtual readString : ()Ljava/lang/String;
        //   177: astore_2
        //   178: aload_0
        //   179: aload_0
        //   180: getfield bitField0_ : I
        //   183: iconst_4
        //   184: ior
        //   185: putfield bitField0_ : I
        //   188: aload_0
        //   189: aload_2
        //   190: putfield content_ : Ljava/lang/String;
        //   193: goto -> 123
        //   196: aload_1
        //   197: invokevirtual readString : ()Ljava/lang/String;
        //   200: astore_2
        //   201: aload_0
        //   202: aload_0
        //   203: getfield bitField0_ : I
        //   206: iconst_2
        //   207: ior
        //   208: putfield bitField0_ : I
        //   211: aload_0
        //   212: aload_2
        //   213: putfield insertionPoint_ : Ljava/lang/String;
        //   216: goto -> 123
        //   219: aload_1
        //   220: invokevirtual readString : ()Ljava/lang/String;
        //   223: astore_2
        //   224: aload_0
        //   225: iconst_1
        //   226: aload_0
        //   227: getfield bitField0_ : I
        //   230: ior
        //   231: putfield bitField0_ : I
        //   234: aload_0
        //   235: aload_2
        //   236: putfield name_ : Ljava/lang/String;
        //   239: goto -> 123
        //   242: iconst_1
        //   243: istore #4
        //   245: goto -> 123
        //   248: astore_1
        //   249: goto -> 296
        //   252: astore_2
        //   253: new java/lang/RuntimeException
        //   256: astore_3
        //   257: new com/google/protobuf/InvalidProtocolBufferException
        //   260: astore_1
        //   261: aload_1
        //   262: aload_2
        //   263: invokevirtual getMessage : ()Ljava/lang/String;
        //   266: invokespecial <init> : (Ljava/lang/String;)V
        //   269: aload_3
        //   270: aload_1
        //   271: aload_0
        //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   278: aload_3
        //   279: athrow
        //   280: astore_2
        //   281: new java/lang/RuntimeException
        //   284: astore_1
        //   285: aload_1
        //   286: aload_2
        //   287: aload_0
        //   288: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
        //   291: invokespecial <init> : (Ljava/lang/Throwable;)V
        //   294: aload_1
        //   295: athrow
        //   296: aload_1
        //   297: athrow
        //   298: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   301: areturn
        //   302: aload_2
        //   303: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
        //   306: astore_1
        //   307: aload_3
        //   308: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   311: astore_2
        //   312: aload_0
        //   313: aload_1
        //   314: aload_0
        //   315: invokevirtual hasName : ()Z
        //   318: aload_0
        //   319: getfield name_ : Ljava/lang/String;
        //   322: aload_2
        //   323: invokevirtual hasName : ()Z
        //   326: aload_2
        //   327: getfield name_ : Ljava/lang/String;
        //   330: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   335: putfield name_ : Ljava/lang/String;
        //   338: aload_0
        //   339: aload_1
        //   340: aload_0
        //   341: invokevirtual hasInsertionPoint : ()Z
        //   344: aload_0
        //   345: getfield insertionPoint_ : Ljava/lang/String;
        //   348: aload_2
        //   349: invokevirtual hasInsertionPoint : ()Z
        //   352: aload_2
        //   353: getfield insertionPoint_ : Ljava/lang/String;
        //   356: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   361: putfield insertionPoint_ : Ljava/lang/String;
        //   364: aload_0
        //   365: aload_1
        //   366: aload_0
        //   367: invokevirtual hasContent : ()Z
        //   370: aload_0
        //   371: getfield content_ : Ljava/lang/String;
        //   374: aload_2
        //   375: invokevirtual hasContent : ()Z
        //   378: aload_2
        //   379: getfield content_ : Ljava/lang/String;
        //   382: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
        //   387: putfield content_ : Ljava/lang/String;
        //   390: aload_1
        //   391: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
        //   394: if_acmpne -> 410
        //   397: aload_0
        //   398: aload_0
        //   399: getfield bitField0_ : I
        //   402: aload_2
        //   403: getfield bitField0_ : I
        //   406: ior
        //   407: putfield bitField0_ : I
        //   410: aload_0
        //   411: areturn
        //   412: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder
        //   415: dup
        //   416: aconst_null
        //   417: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
        //   420: areturn
        //   421: aconst_null
        //   422: areturn
        //   423: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
        //   426: areturn
        //   427: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
        //   430: dup
        //   431: invokespecial <init> : ()V
        //   434: areturn
        // Exception table:
        //   from	to	target	type
        //   73	94	100	finally
        //   94	97	100	finally
        //   101	104	100	finally
        //   128	134	280	com/google/protobuf/InvalidProtocolBufferException
        //   128	134	252	java/io/IOException
        //   128	134	248	finally
        //   160	170	280	com/google/protobuf/InvalidProtocolBufferException
        //   160	170	252	java/io/IOException
        //   160	170	248	finally
        //   173	193	280	com/google/protobuf/InvalidProtocolBufferException
        //   173	193	252	java/io/IOException
        //   173	193	248	finally
        //   196	216	280	com/google/protobuf/InvalidProtocolBufferException
        //   196	216	252	java/io/IOException
        //   196	216	248	finally
        //   219	239	280	com/google/protobuf/InvalidProtocolBufferException
        //   219	239	252	java/io/IOException
        //   219	239	248	finally
        //   253	280	248	finally
        //   281	296	248	finally
      }
      
      public String getContent() {
        return this.content_;
      }
      
      public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
      }
      
      public String getInsertionPoint() {
        return this.insertionPoint_;
      }
      
      public ByteString getInsertionPointBytes() {
        return ByteString.copyFromUtf8(this.insertionPoint_);
      }
      
      public String getName() {
        return this.name_;
      }
      
      public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1)
          return i; 
        int j = 0;
        if ((this.bitField0_ & 0x1) == 1)
          j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
        i = j;
        if ((this.bitField0_ & 0x2) == 2)
          i = j + CodedOutputStream.computeStringSize(2, getInsertionPoint()); 
        j = i;
        if ((this.bitField0_ & 0x4) == 4)
          j = i + CodedOutputStream.computeStringSize(15, getContent()); 
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public boolean hasContent() {
        boolean bool;
        if ((this.bitField0_ & 0x4) == 4) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean hasInsertionPoint() {
        boolean bool;
        if ((this.bitField0_ & 0x2) == 2) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean hasName() {
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) != 1)
          bool = false; 
        return bool;
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) == 1)
          param2CodedOutputStream.writeString(1, getName()); 
        if ((this.bitField0_ & 0x2) == 2)
          param2CodedOutputStream.writeString(2, getInsertionPoint()); 
        if ((this.bitField0_ & 0x4) == 4)
          param2CodedOutputStream.writeString(15, getContent()); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
        private Builder() {
          super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
        }
        
        public Builder clearContent() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
          return this;
        }
        
        public Builder clearInsertionPoint() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
          return this;
        }
        
        public Builder clearName() {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
          return this;
        }
        
        public String getContent() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
        }
        
        public ByteString getContentBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
        }
        
        public String getInsertionPoint() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
        }
        
        public ByteString getInsertionPointBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
        }
        
        public String getName() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
        }
        
        public ByteString getNameBytes() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
        }
        
        public boolean hasContent() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
        }
        
        public boolean hasInsertionPoint() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
        }
        
        public boolean hasName() {
          return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
        }
        
        public Builder setContent(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param3String);
          return this;
        }
        
        public Builder setContentBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param3ByteString);
          return this;
        }
        
        public Builder setInsertionPoint(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param3String);
          return this;
        }
        
        public Builder setInsertionPointBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param3ByteString);
          return this;
        }
        
        public Builder setName(String param3String) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param3String);
          return this;
        }
        
        public Builder setNameBytes(ByteString param3ByteString) {
          copyOnWrite();
          ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param3ByteString);
          return this;
        }
      }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<File, File.Builder> implements FileOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
        return this;
      }
      
      public Builder clearInsertionPoint() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
        return this;
      }
      
      public String getContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
      }
      
      public ByteString getContentBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
      }
      
      public String getInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
      }
      
      public ByteString getInsertionPointBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
      }
      
      public String getName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
      }
      
      public boolean hasContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
      }
      
      public boolean hasInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
      }
      
      public boolean hasName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
      }
      
      public Builder setContent(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param2String);
        return this;
      }
      
      public Builder setContentBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param2ByteString);
        return this;
      }
      
      public Builder setInsertionPoint(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param2String);
        return this;
      }
      
      public Builder setInsertionPointBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param2ByteString);
        return this;
      }
      
      public Builder setName(String param2String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param2String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param2ByteString);
        return this;
      }
    }
    
    public static interface FileOrBuilder extends MessageLiteOrBuilder {
      String getContent();
      
      ByteString getContentBytes();
      
      String getInsertionPoint();
      
      ByteString getInsertionPointBytes();
      
      String getName();
      
      ByteString getNameBytes();
      
      boolean hasContent();
      
      boolean hasInsertionPoint();
      
      boolean hasName();
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, CodeGeneratorResponse.Builder> implements CodeGeneratorResponseOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorResponse.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param1Iterable) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addAllFile(param1Iterable);
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Int, param1File);
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1Builder);
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).addFile(param1File);
      return this;
    }
    
    public Builder clearError() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).clearError();
      return this;
    }
    
    public Builder clearFile() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).clearFile();
      return this;
    }
    
    public String getError() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getError();
    }
    
    public ByteString getErrorBytes() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getErrorBytes();
    }
    
    public PluginProtos.CodeGeneratorResponse.File getFile(int param1Int) {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getFile(param1Int);
    }
    
    public int getFileCount() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).getFileCount();
    }
    
    public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
      return Collections.unmodifiableList(((PluginProtos.CodeGeneratorResponse)this.instance).getFileList());
    }
    
    public boolean hasError() {
      return ((PluginProtos.CodeGeneratorResponse)this.instance).hasError();
    }
    
    public Builder removeFile(int param1Int) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).removeFile(param1Int);
      return this;
    }
    
    public Builder setError(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setError(param1String);
      return this;
    }
    
    public Builder setErrorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setErrorBytes(param1ByteString);
      return this;
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse)this.instance).setFile(param1Int, param1File);
      return this;
    }
  }
  
  public static final class File extends GeneratedMessageLite<CodeGeneratorResponse.File, CodeGeneratorResponse.File.Builder> implements CodeGeneratorResponse.FileOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 15;
    
    private static final File DEFAULT_INSTANCE = new File();
    
    public static final int INSERTION_POINT_FIELD_NUMBER = 2;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    private static volatile Parser<File> PARSER;
    
    private int bitField0_;
    
    private String content_ = "";
    
    private String insertionPoint_ = "";
    
    private String name_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearContent() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.content_ = getDefaultInstance().getContent();
    }
    
    private void clearInsertionPoint() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
    }
    
    private void clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = getDefaultInstance().getName();
    }
    
    public static File getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(File param1File) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1File);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static File parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(InputStream param1InputStream) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static File parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<File> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setContent(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setContentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setInsertionPoint(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setInsertionPointBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 427, 2 -> 423, 3 -> 421, 4 -> 412, 5 -> 302, 6 -> 110, 7 -> 298, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 298
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 242
      //   139: iload #5
      //   141: bipush #10
      //   143: if_icmpeq -> 219
      //   146: iload #5
      //   148: bipush #18
      //   150: if_icmpeq -> 196
      //   153: iload #5
      //   155: bipush #122
      //   157: if_icmpeq -> 173
      //   160: aload_0
      //   161: iload #5
      //   163: aload_1
      //   164: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   167: ifne -> 123
      //   170: goto -> 242
      //   173: aload_1
      //   174: invokevirtual readString : ()Ljava/lang/String;
      //   177: astore_2
      //   178: aload_0
      //   179: aload_0
      //   180: getfield bitField0_ : I
      //   183: iconst_4
      //   184: ior
      //   185: putfield bitField0_ : I
      //   188: aload_0
      //   189: aload_2
      //   190: putfield content_ : Ljava/lang/String;
      //   193: goto -> 123
      //   196: aload_1
      //   197: invokevirtual readString : ()Ljava/lang/String;
      //   200: astore_2
      //   201: aload_0
      //   202: aload_0
      //   203: getfield bitField0_ : I
      //   206: iconst_2
      //   207: ior
      //   208: putfield bitField0_ : I
      //   211: aload_0
      //   212: aload_2
      //   213: putfield insertionPoint_ : Ljava/lang/String;
      //   216: goto -> 123
      //   219: aload_1
      //   220: invokevirtual readString : ()Ljava/lang/String;
      //   223: astore_2
      //   224: aload_0
      //   225: iconst_1
      //   226: aload_0
      //   227: getfield bitField0_ : I
      //   230: ior
      //   231: putfield bitField0_ : I
      //   234: aload_0
      //   235: aload_2
      //   236: putfield name_ : Ljava/lang/String;
      //   239: goto -> 123
      //   242: iconst_1
      //   243: istore #4
      //   245: goto -> 123
      //   248: astore_1
      //   249: goto -> 296
      //   252: astore_2
      //   253: new java/lang/RuntimeException
      //   256: astore_3
      //   257: new com/google/protobuf/InvalidProtocolBufferException
      //   260: astore_1
      //   261: aload_1
      //   262: aload_2
      //   263: invokevirtual getMessage : ()Ljava/lang/String;
      //   266: invokespecial <init> : (Ljava/lang/String;)V
      //   269: aload_3
      //   270: aload_1
      //   271: aload_0
      //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   278: aload_3
      //   279: athrow
      //   280: astore_2
      //   281: new java/lang/RuntimeException
      //   284: astore_1
      //   285: aload_1
      //   286: aload_2
      //   287: aload_0
      //   288: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   291: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   294: aload_1
      //   295: athrow
      //   296: aload_1
      //   297: athrow
      //   298: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   301: areturn
      //   302: aload_2
      //   303: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   306: astore_1
      //   307: aload_3
      //   308: checkcast com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   311: astore_2
      //   312: aload_0
      //   313: aload_1
      //   314: aload_0
      //   315: invokevirtual hasName : ()Z
      //   318: aload_0
      //   319: getfield name_ : Ljava/lang/String;
      //   322: aload_2
      //   323: invokevirtual hasName : ()Z
      //   326: aload_2
      //   327: getfield name_ : Ljava/lang/String;
      //   330: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   335: putfield name_ : Ljava/lang/String;
      //   338: aload_0
      //   339: aload_1
      //   340: aload_0
      //   341: invokevirtual hasInsertionPoint : ()Z
      //   344: aload_0
      //   345: getfield insertionPoint_ : Ljava/lang/String;
      //   348: aload_2
      //   349: invokevirtual hasInsertionPoint : ()Z
      //   352: aload_2
      //   353: getfield insertionPoint_ : Ljava/lang/String;
      //   356: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   361: putfield insertionPoint_ : Ljava/lang/String;
      //   364: aload_0
      //   365: aload_1
      //   366: aload_0
      //   367: invokevirtual hasContent : ()Z
      //   370: aload_0
      //   371: getfield content_ : Ljava/lang/String;
      //   374: aload_2
      //   375: invokevirtual hasContent : ()Z
      //   378: aload_2
      //   379: getfield content_ : Ljava/lang/String;
      //   382: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   387: putfield content_ : Ljava/lang/String;
      //   390: aload_1
      //   391: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   394: if_acmpne -> 410
      //   397: aload_0
      //   398: aload_0
      //   399: getfield bitField0_ : I
      //   402: aload_2
      //   403: getfield bitField0_ : I
      //   406: ior
      //   407: putfield bitField0_ : I
      //   410: aload_0
      //   411: areturn
      //   412: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File$Builder
      //   415: dup
      //   416: aconst_null
      //   417: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   420: areturn
      //   421: aconst_null
      //   422: areturn
      //   423: getstatic com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File;
      //   426: areturn
      //   427: new com/google/protobuf/compiler/PluginProtos$CodeGeneratorResponse$File
      //   430: dup
      //   431: invokespecial <init> : ()V
      //   434: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	280	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	252	java/io/IOException
      //   128	134	248	finally
      //   160	170	280	com/google/protobuf/InvalidProtocolBufferException
      //   160	170	252	java/io/IOException
      //   160	170	248	finally
      //   173	193	280	com/google/protobuf/InvalidProtocolBufferException
      //   173	193	252	java/io/IOException
      //   173	193	248	finally
      //   196	216	280	com/google/protobuf/InvalidProtocolBufferException
      //   196	216	252	java/io/IOException
      //   196	216	248	finally
      //   219	239	280	com/google/protobuf/InvalidProtocolBufferException
      //   219	239	252	java/io/IOException
      //   219	239	248	finally
      //   253	280	248	finally
      //   281	296	248	finally
    }
    
    public String getContent() {
      return this.content_;
    }
    
    public ByteString getContentBytes() {
      return ByteString.copyFromUtf8(this.content_);
    }
    
    public String getInsertionPoint() {
      return this.insertionPoint_;
    }
    
    public ByteString getInsertionPointBytes() {
      return ByteString.copyFromUtf8(this.insertionPoint_);
    }
    
    public String getName() {
      return this.name_;
    }
    
    public ByteString getNameBytes() {
      return ByteString.copyFromUtf8(this.name_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1)
        j = 0 + CodedOutputStream.computeStringSize(1, getName()); 
      i = j;
      if ((this.bitField0_ & 0x2) == 2)
        i = j + CodedOutputStream.computeStringSize(2, getInsertionPoint()); 
      j = i;
      if ((this.bitField0_ & 0x4) == 4)
        j = i + CodedOutputStream.computeStringSize(15, getContent()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasContent() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasInsertionPoint() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasName() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeString(1, getName()); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeString(2, getInsertionPoint()); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeString(15, getContent()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
      private Builder() {
        super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
      }
      
      public Builder clearContent() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
        return this;
      }
      
      public Builder clearInsertionPoint() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
        return this;
      }
      
      public Builder clearName() {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
        return this;
      }
      
      public String getContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
      }
      
      public ByteString getContentBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
      }
      
      public String getInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
      }
      
      public ByteString getInsertionPointBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
      }
      
      public String getName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
      }
      
      public ByteString getNameBytes() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
      }
      
      public boolean hasContent() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
      }
      
      public boolean hasInsertionPoint() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
      }
      
      public boolean hasName() {
        return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
      }
      
      public Builder setContent(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param3String);
        return this;
      }
      
      public Builder setContentBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param3ByteString);
        return this;
      }
      
      public Builder setInsertionPoint(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param3String);
        return this;
      }
      
      public Builder setInsertionPointBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param3ByteString);
        return this;
      }
      
      public Builder setName(String param3String) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param3String);
        return this;
      }
      
      public Builder setNameBytes(ByteString param3ByteString) {
        copyOnWrite();
        ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param3ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse.File, CodeGeneratorResponse.File.Builder> implements CodeGeneratorResponse.FileOrBuilder {
    private Builder() {
      super(PluginProtos.CodeGeneratorResponse.File.DEFAULT_INSTANCE);
    }
    
    public Builder clearContent() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearContent();
      return this;
    }
    
    public Builder clearInsertionPoint() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearInsertionPoint();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).clearName();
      return this;
    }
    
    public String getContent() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContent();
    }
    
    public ByteString getContentBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getContentBytes();
    }
    
    public String getInsertionPoint() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPoint();
    }
    
    public ByteString getInsertionPointBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getInsertionPointBytes();
    }
    
    public String getName() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).getNameBytes();
    }
    
    public boolean hasContent() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasContent();
    }
    
    public boolean hasInsertionPoint() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasInsertionPoint();
    }
    
    public boolean hasName() {
      return ((PluginProtos.CodeGeneratorResponse.File)this.instance).hasName();
    }
    
    public Builder setContent(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContent(param1String);
      return this;
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setContentBytes(param1ByteString);
      return this;
    }
    
    public Builder setInsertionPoint(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPoint(param1String);
      return this;
    }
    
    public Builder setInsertionPointBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setInsertionPointBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.CodeGeneratorResponse.File)this.instance).setNameBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FileOrBuilder extends MessageLiteOrBuilder {
    String getContent();
    
    ByteString getContentBytes();
    
    String getInsertionPoint();
    
    ByteString getInsertionPointBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    boolean hasContent();
    
    boolean hasInsertionPoint();
    
    boolean hasName();
  }
  
  public static interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
    String getError();
    
    ByteString getErrorBytes();
    
    PluginProtos.CodeGeneratorResponse.File getFile(int param1Int);
    
    int getFileCount();
    
    List<PluginProtos.CodeGeneratorResponse.File> getFileList();
    
    boolean hasError();
  }
  
  public static final class Version extends GeneratedMessageLite<Version, Version.Builder> implements VersionOrBuilder {
    private static final Version DEFAULT_INSTANCE = new Version();
    
    public static final int MAJOR_FIELD_NUMBER = 1;
    
    public static final int MINOR_FIELD_NUMBER = 2;
    
    private static volatile Parser<Version> PARSER;
    
    public static final int PATCH_FIELD_NUMBER = 3;
    
    public static final int SUFFIX_FIELD_NUMBER = 4;
    
    private int bitField0_;
    
    private int major_;
    
    private int minor_;
    
    private int patch_;
    
    private String suffix_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearMajor() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.major_ = 0;
    }
    
    private void clearMinor() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.minor_ = 0;
    }
    
    private void clearPatch() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.patch_ = 0;
    }
    
    private void clearSuffix() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.suffix_ = getDefaultInstance().getSuffix();
    }
    
    public static Version getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Version param1Version) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Version);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Version)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Version parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(InputStream param1InputStream) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Version parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Version> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setMajor(int param1Int) {
      this.bitField0_ |= 0x1;
      this.major_ = param1Int;
    }
    
    private void setMinor(int param1Int) {
      this.bitField0_ |= 0x2;
      this.minor_ = param1Int;
    }
    
    private void setPatch(int param1Int) {
      this.bitField0_ |= 0x4;
      this.patch_ = param1Int;
    }
    
    private void setSuffix(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setSuffixBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/protobuf/compiler/PluginProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 478, 2 -> 474, 3 -> 472, 4 -> 463, 5 -> 327, 6 -> 110, 7 -> 323, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   72: monitorenter
      //   73: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/protobuf/compiler/PluginProtos$Version
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/protobuf/compiler/PluginProtos$Version.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 323
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 267
      //   139: iload #5
      //   141: bipush #8
      //   143: if_icmpeq -> 246
      //   146: iload #5
      //   148: bipush #16
      //   150: if_icmpeq -> 225
      //   153: iload #5
      //   155: bipush #24
      //   157: if_icmpeq -> 204
      //   160: iload #5
      //   162: bipush #34
      //   164: if_icmpeq -> 180
      //   167: aload_0
      //   168: iload #5
      //   170: aload_1
      //   171: invokevirtual parseUnknownField : (ILcom/google/protobuf/CodedInputStream;)Z
      //   174: ifne -> 123
      //   177: goto -> 267
      //   180: aload_1
      //   181: invokevirtual readString : ()Ljava/lang/String;
      //   184: astore_2
      //   185: aload_0
      //   186: aload_0
      //   187: getfield bitField0_ : I
      //   190: bipush #8
      //   192: ior
      //   193: putfield bitField0_ : I
      //   196: aload_0
      //   197: aload_2
      //   198: putfield suffix_ : Ljava/lang/String;
      //   201: goto -> 123
      //   204: aload_0
      //   205: aload_0
      //   206: getfield bitField0_ : I
      //   209: iconst_4
      //   210: ior
      //   211: putfield bitField0_ : I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual readInt32 : ()I
      //   219: putfield patch_ : I
      //   222: goto -> 123
      //   225: aload_0
      //   226: aload_0
      //   227: getfield bitField0_ : I
      //   230: iconst_2
      //   231: ior
      //   232: putfield bitField0_ : I
      //   235: aload_0
      //   236: aload_1
      //   237: invokevirtual readInt32 : ()I
      //   240: putfield minor_ : I
      //   243: goto -> 123
      //   246: aload_0
      //   247: aload_0
      //   248: getfield bitField0_ : I
      //   251: iconst_1
      //   252: ior
      //   253: putfield bitField0_ : I
      //   256: aload_0
      //   257: aload_1
      //   258: invokevirtual readInt32 : ()I
      //   261: putfield major_ : I
      //   264: goto -> 123
      //   267: iconst_1
      //   268: istore #4
      //   270: goto -> 123
      //   273: astore_1
      //   274: goto -> 321
      //   277: astore_2
      //   278: new java/lang/RuntimeException
      //   281: astore_3
      //   282: new com/google/protobuf/InvalidProtocolBufferException
      //   285: astore_1
      //   286: aload_1
      //   287: aload_2
      //   288: invokevirtual getMessage : ()Ljava/lang/String;
      //   291: invokespecial <init> : (Ljava/lang/String;)V
      //   294: aload_3
      //   295: aload_1
      //   296: aload_0
      //   297: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   300: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   303: aload_3
      //   304: athrow
      //   305: astore_2
      //   306: new java/lang/RuntimeException
      //   309: astore_1
      //   310: aload_1
      //   311: aload_2
      //   312: aload_0
      //   313: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   316: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   319: aload_1
      //   320: athrow
      //   321: aload_1
      //   322: athrow
      //   323: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   326: areturn
      //   327: aload_2
      //   328: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   331: astore_1
      //   332: aload_3
      //   333: checkcast com/google/protobuf/compiler/PluginProtos$Version
      //   336: astore_2
      //   337: aload_0
      //   338: aload_1
      //   339: aload_0
      //   340: invokevirtual hasMajor : ()Z
      //   343: aload_0
      //   344: getfield major_ : I
      //   347: aload_2
      //   348: invokevirtual hasMajor : ()Z
      //   351: aload_2
      //   352: getfield major_ : I
      //   355: invokeinterface visitInt : (ZIZI)I
      //   360: putfield major_ : I
      //   363: aload_0
      //   364: aload_1
      //   365: aload_0
      //   366: invokevirtual hasMinor : ()Z
      //   369: aload_0
      //   370: getfield minor_ : I
      //   373: aload_2
      //   374: invokevirtual hasMinor : ()Z
      //   377: aload_2
      //   378: getfield minor_ : I
      //   381: invokeinterface visitInt : (ZIZI)I
      //   386: putfield minor_ : I
      //   389: aload_0
      //   390: aload_1
      //   391: aload_0
      //   392: invokevirtual hasPatch : ()Z
      //   395: aload_0
      //   396: getfield patch_ : I
      //   399: aload_2
      //   400: invokevirtual hasPatch : ()Z
      //   403: aload_2
      //   404: getfield patch_ : I
      //   407: invokeinterface visitInt : (ZIZI)I
      //   412: putfield patch_ : I
      //   415: aload_0
      //   416: aload_1
      //   417: aload_0
      //   418: invokevirtual hasSuffix : ()Z
      //   421: aload_0
      //   422: getfield suffix_ : Ljava/lang/String;
      //   425: aload_2
      //   426: invokevirtual hasSuffix : ()Z
      //   429: aload_2
      //   430: getfield suffix_ : Ljava/lang/String;
      //   433: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   438: putfield suffix_ : Ljava/lang/String;
      //   441: aload_1
      //   442: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   445: if_acmpne -> 461
      //   448: aload_0
      //   449: aload_0
      //   450: getfield bitField0_ : I
      //   453: aload_2
      //   454: getfield bitField0_ : I
      //   457: ior
      //   458: putfield bitField0_ : I
      //   461: aload_0
      //   462: areturn
      //   463: new com/google/protobuf/compiler/PluginProtos$Version$Builder
      //   466: dup
      //   467: aconst_null
      //   468: invokespecial <init> : (Lcom/google/protobuf/compiler/PluginProtos$1;)V
      //   471: areturn
      //   472: aconst_null
      //   473: areturn
      //   474: getstatic com/google/protobuf/compiler/PluginProtos$Version.DEFAULT_INSTANCE : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   477: areturn
      //   478: new com/google/protobuf/compiler/PluginProtos$Version
      //   481: dup
      //   482: invokespecial <init> : ()V
      //   485: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	305	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	277	java/io/IOException
      //   128	134	273	finally
      //   167	177	305	com/google/protobuf/InvalidProtocolBufferException
      //   167	177	277	java/io/IOException
      //   167	177	273	finally
      //   180	201	305	com/google/protobuf/InvalidProtocolBufferException
      //   180	201	277	java/io/IOException
      //   180	201	273	finally
      //   204	222	305	com/google/protobuf/InvalidProtocolBufferException
      //   204	222	277	java/io/IOException
      //   204	222	273	finally
      //   225	243	305	com/google/protobuf/InvalidProtocolBufferException
      //   225	243	277	java/io/IOException
      //   225	243	273	finally
      //   246	264	305	com/google/protobuf/InvalidProtocolBufferException
      //   246	264	277	java/io/IOException
      //   246	264	273	finally
      //   278	305	273	finally
      //   306	321	273	finally
    }
    
    public int getMajor() {
      return this.major_;
    }
    
    public int getMinor() {
      return this.minor_;
    }
    
    public int getPatch() {
      return this.patch_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if ((this.bitField0_ & 0x1) == 1)
        i = 0 + CodedOutputStream.computeInt32Size(1, this.major_); 
      int j = i;
      if ((this.bitField0_ & 0x2) == 2)
        j = i + CodedOutputStream.computeInt32Size(2, this.minor_); 
      i = j;
      if ((this.bitField0_ & 0x4) == 4)
        i = j + CodedOutputStream.computeInt32Size(3, this.patch_); 
      j = i;
      if ((this.bitField0_ & 0x8) == 8)
        j = i + CodedOutputStream.computeStringSize(4, getSuffix()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getSuffix() {
      return this.suffix_;
    }
    
    public ByteString getSuffixBytes() {
      return ByteString.copyFromUtf8(this.suffix_);
    }
    
    public boolean hasMajor() {
      int i = this.bitField0_;
      boolean bool = true;
      if ((i & 0x1) != 1)
        bool = false; 
      return bool;
    }
    
    public boolean hasMinor() {
      boolean bool;
      if ((this.bitField0_ & 0x2) == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPatch() {
      boolean bool;
      if ((this.bitField0_ & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasSuffix() {
      boolean bool;
      if ((this.bitField0_ & 0x8) == 8) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) == 1)
        param1CodedOutputStream.writeInt32(1, this.major_); 
      if ((this.bitField0_ & 0x2) == 2)
        param1CodedOutputStream.writeInt32(2, this.minor_); 
      if ((this.bitField0_ & 0x4) == 4)
        param1CodedOutputStream.writeInt32(3, this.patch_); 
      if ((this.bitField0_ & 0x8) == 8)
        param1CodedOutputStream.writeString(4, getSuffix()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements PluginProtos.VersionOrBuilder {
      private Builder() {
        super(PluginProtos.Version.DEFAULT_INSTANCE);
      }
      
      public Builder clearMajor() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearMajor();
        return this;
      }
      
      public Builder clearMinor() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearMinor();
        return this;
      }
      
      public Builder clearPatch() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearPatch();
        return this;
      }
      
      public Builder clearSuffix() {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).clearSuffix();
        return this;
      }
      
      public int getMajor() {
        return ((PluginProtos.Version)this.instance).getMajor();
      }
      
      public int getMinor() {
        return ((PluginProtos.Version)this.instance).getMinor();
      }
      
      public int getPatch() {
        return ((PluginProtos.Version)this.instance).getPatch();
      }
      
      public String getSuffix() {
        return ((PluginProtos.Version)this.instance).getSuffix();
      }
      
      public ByteString getSuffixBytes() {
        return ((PluginProtos.Version)this.instance).getSuffixBytes();
      }
      
      public boolean hasMajor() {
        return ((PluginProtos.Version)this.instance).hasMajor();
      }
      
      public boolean hasMinor() {
        return ((PluginProtos.Version)this.instance).hasMinor();
      }
      
      public boolean hasPatch() {
        return ((PluginProtos.Version)this.instance).hasPatch();
      }
      
      public boolean hasSuffix() {
        return ((PluginProtos.Version)this.instance).hasSuffix();
      }
      
      public Builder setMajor(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setMajor(param2Int);
        return this;
      }
      
      public Builder setMinor(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setMinor(param2Int);
        return this;
      }
      
      public Builder setPatch(int param2Int) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setPatch(param2Int);
        return this;
      }
      
      public Builder setSuffix(String param2String) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setSuffix(param2String);
        return this;
      }
      
      public Builder setSuffixBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((PluginProtos.Version)this.instance).setSuffixBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Version, Version.Builder> implements VersionOrBuilder {
    private Builder() {
      super(PluginProtos.Version.DEFAULT_INSTANCE);
    }
    
    public Builder clearMajor() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearMajor();
      return this;
    }
    
    public Builder clearMinor() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearMinor();
      return this;
    }
    
    public Builder clearPatch() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearPatch();
      return this;
    }
    
    public Builder clearSuffix() {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).clearSuffix();
      return this;
    }
    
    public int getMajor() {
      return ((PluginProtos.Version)this.instance).getMajor();
    }
    
    public int getMinor() {
      return ((PluginProtos.Version)this.instance).getMinor();
    }
    
    public int getPatch() {
      return ((PluginProtos.Version)this.instance).getPatch();
    }
    
    public String getSuffix() {
      return ((PluginProtos.Version)this.instance).getSuffix();
    }
    
    public ByteString getSuffixBytes() {
      return ((PluginProtos.Version)this.instance).getSuffixBytes();
    }
    
    public boolean hasMajor() {
      return ((PluginProtos.Version)this.instance).hasMajor();
    }
    
    public boolean hasMinor() {
      return ((PluginProtos.Version)this.instance).hasMinor();
    }
    
    public boolean hasPatch() {
      return ((PluginProtos.Version)this.instance).hasPatch();
    }
    
    public boolean hasSuffix() {
      return ((PluginProtos.Version)this.instance).hasSuffix();
    }
    
    public Builder setMajor(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setMajor(param1Int);
      return this;
    }
    
    public Builder setMinor(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setMinor(param1Int);
      return this;
    }
    
    public Builder setPatch(int param1Int) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setPatch(param1Int);
      return this;
    }
    
    public Builder setSuffix(String param1String) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setSuffix(param1String);
      return this;
    }
    
    public Builder setSuffixBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((PluginProtos.Version)this.instance).setSuffixBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface VersionOrBuilder extends MessageLiteOrBuilder {
    int getMajor();
    
    int getMinor();
    
    int getPatch();
    
    String getSuffix();
    
    ByteString getSuffixBytes();
    
    boolean hasMajor();
    
    boolean hasMinor();
    
    boolean hasPatch();
    
    boolean hasSuffix();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\compiler\PluginProtos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */