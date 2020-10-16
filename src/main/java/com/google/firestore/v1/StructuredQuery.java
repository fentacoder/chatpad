package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
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

public final class StructuredQuery extends GeneratedMessageLite<StructuredQuery, StructuredQuery.Builder> implements StructuredQueryOrBuilder {
  private static final StructuredQuery DEFAULT_INSTANCE = new StructuredQuery();
  
  public static final int END_AT_FIELD_NUMBER = 8;
  
  public static final int FROM_FIELD_NUMBER = 2;
  
  public static final int LIMIT_FIELD_NUMBER = 5;
  
  public static final int OFFSET_FIELD_NUMBER = 6;
  
  public static final int ORDER_BY_FIELD_NUMBER = 4;
  
  private static volatile Parser<StructuredQuery> PARSER;
  
  public static final int SELECT_FIELD_NUMBER = 1;
  
  public static final int START_AT_FIELD_NUMBER = 7;
  
  public static final int WHERE_FIELD_NUMBER = 3;
  
  private int bitField0_;
  
  private Cursor endAt_;
  
  private Internal.ProtobufList<CollectionSelector> from_ = emptyProtobufList();
  
  private Int32Value limit_;
  
  private int offset_;
  
  private Internal.ProtobufList<Order> orderBy_ = emptyProtobufList();
  
  private Projection select_;
  
  private Cursor startAt_;
  
  private Filter where_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFrom(Iterable<? extends CollectionSelector> paramIterable) {
    ensureFromIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.from_);
  }
  
  private void addAllOrderBy(Iterable<? extends Order> paramIterable) {
    ensureOrderByIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.orderBy_);
  }
  
  private void addFrom(int paramInt, CollectionSelector.Builder paramBuilder) {
    ensureFromIsMutable();
    this.from_.add(paramInt, paramBuilder.build());
  }
  
  private void addFrom(int paramInt, CollectionSelector paramCollectionSelector) {
    if (paramCollectionSelector != null) {
      ensureFromIsMutable();
      this.from_.add(paramInt, paramCollectionSelector);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFrom(CollectionSelector.Builder paramBuilder) {
    ensureFromIsMutable();
    this.from_.add(paramBuilder.build());
  }
  
  private void addFrom(CollectionSelector paramCollectionSelector) {
    if (paramCollectionSelector != null) {
      ensureFromIsMutable();
      this.from_.add(paramCollectionSelector);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOrderBy(int paramInt, Order.Builder paramBuilder) {
    ensureOrderByIsMutable();
    this.orderBy_.add(paramInt, paramBuilder.build());
  }
  
  private void addOrderBy(int paramInt, Order paramOrder) {
    if (paramOrder != null) {
      ensureOrderByIsMutable();
      this.orderBy_.add(paramInt, paramOrder);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOrderBy(Order.Builder paramBuilder) {
    ensureOrderByIsMutable();
    this.orderBy_.add(paramBuilder.build());
  }
  
  private void addOrderBy(Order paramOrder) {
    if (paramOrder != null) {
      ensureOrderByIsMutable();
      this.orderBy_.add(paramOrder);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearEndAt() {
    this.endAt_ = null;
  }
  
  private void clearFrom() {
    this.from_ = emptyProtobufList();
  }
  
  private void clearLimit() {
    this.limit_ = null;
  }
  
  private void clearOffset() {
    this.offset_ = 0;
  }
  
  private void clearOrderBy() {
    this.orderBy_ = emptyProtobufList();
  }
  
  private void clearSelect() {
    this.select_ = null;
  }
  
  private void clearStartAt() {
    this.startAt_ = null;
  }
  
  private void clearWhere() {
    this.where_ = null;
  }
  
  private void ensureFromIsMutable() {
    if (!this.from_.isModifiable())
      this.from_ = GeneratedMessageLite.mutableCopy(this.from_); 
  }
  
  private void ensureOrderByIsMutable() {
    if (!this.orderBy_.isModifiable())
      this.orderBy_ = GeneratedMessageLite.mutableCopy(this.orderBy_); 
  }
  
  public static StructuredQuery getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeEndAt(Cursor paramCursor) {
    Cursor cursor = this.endAt_;
    if (cursor != null && cursor != Cursor.getDefaultInstance()) {
      this.endAt_ = (Cursor)((Cursor.Builder)Cursor.newBuilder(this.endAt_).mergeFrom(paramCursor)).buildPartial();
    } else {
      this.endAt_ = paramCursor;
    } 
  }
  
  private void mergeLimit(Int32Value paramInt32Value) {
    Int32Value int32Value = this.limit_;
    if (int32Value != null && int32Value != Int32Value.getDefaultInstance()) {
      this.limit_ = (Int32Value)((Int32Value.Builder)Int32Value.newBuilder(this.limit_).mergeFrom((GeneratedMessageLite)paramInt32Value)).buildPartial();
    } else {
      this.limit_ = paramInt32Value;
    } 
  }
  
  private void mergeSelect(Projection paramProjection) {
    Projection projection = this.select_;
    if (projection != null && projection != Projection.getDefaultInstance()) {
      this.select_ = (Projection)((Projection.Builder)Projection.newBuilder(this.select_).mergeFrom(paramProjection)).buildPartial();
    } else {
      this.select_ = paramProjection;
    } 
  }
  
  private void mergeStartAt(Cursor paramCursor) {
    Cursor cursor = this.startAt_;
    if (cursor != null && cursor != Cursor.getDefaultInstance()) {
      this.startAt_ = (Cursor)((Cursor.Builder)Cursor.newBuilder(this.startAt_).mergeFrom(paramCursor)).buildPartial();
    } else {
      this.startAt_ = paramCursor;
    } 
  }
  
  private void mergeWhere(Filter paramFilter) {
    Filter filter = this.where_;
    if (filter != null && filter != Filter.getDefaultInstance()) {
      this.where_ = (Filter)((Filter.Builder)Filter.newBuilder(this.where_).mergeFrom(paramFilter)).buildPartial();
    } else {
      this.where_ = paramFilter;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(StructuredQuery paramStructuredQuery) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramStructuredQuery);
  }
  
  public static StructuredQuery parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (StructuredQuery)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StructuredQuery parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (StructuredQuery)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StructuredQuery parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static StructuredQuery parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static StructuredQuery parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static StructuredQuery parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static StructuredQuery parseFrom(InputStream paramInputStream) throws IOException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StructuredQuery parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StructuredQuery parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static StructuredQuery parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (StructuredQuery)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<StructuredQuery> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFrom(int paramInt) {
    ensureFromIsMutable();
    this.from_.remove(paramInt);
  }
  
  private void removeOrderBy(int paramInt) {
    ensureOrderByIsMutable();
    this.orderBy_.remove(paramInt);
  }
  
  private void setEndAt(Cursor.Builder paramBuilder) {
    this.endAt_ = (Cursor)paramBuilder.build();
  }
  
  private void setEndAt(Cursor paramCursor) {
    if (paramCursor != null) {
      this.endAt_ = paramCursor;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFrom(int paramInt, CollectionSelector.Builder paramBuilder) {
    ensureFromIsMutable();
    this.from_.set(paramInt, paramBuilder.build());
  }
  
  private void setFrom(int paramInt, CollectionSelector paramCollectionSelector) {
    if (paramCollectionSelector != null) {
      ensureFromIsMutable();
      this.from_.set(paramInt, paramCollectionSelector);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setLimit(Int32Value.Builder paramBuilder) {
    this.limit_ = (Int32Value)paramBuilder.build();
  }
  
  private void setLimit(Int32Value paramInt32Value) {
    if (paramInt32Value != null) {
      this.limit_ = paramInt32Value;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOffset(int paramInt) {
    this.offset_ = paramInt;
  }
  
  private void setOrderBy(int paramInt, Order.Builder paramBuilder) {
    ensureOrderByIsMutable();
    this.orderBy_.set(paramInt, paramBuilder.build());
  }
  
  private void setOrderBy(int paramInt, Order paramOrder) {
    if (paramOrder != null) {
      ensureOrderByIsMutable();
      this.orderBy_.set(paramInt, paramOrder);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelect(Projection.Builder paramBuilder) {
    this.select_ = (Projection)paramBuilder.build();
  }
  
  private void setSelect(Projection paramProjection) {
    if (paramProjection != null) {
      this.select_ = paramProjection;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStartAt(Cursor.Builder paramBuilder) {
    this.startAt_ = (Cursor)paramBuilder.build();
  }
  
  private void setStartAt(Cursor paramCursor) {
    if (paramCursor != null) {
      this.startAt_ = paramCursor;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setWhere(Filter.Builder paramBuilder) {
    this.where_ = (Filter)paramBuilder.build();
  }
  
  private void setWhere(Filter paramFilter) {
    if (paramFilter != null) {
      this.where_ = paramFilter;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 960, 2 -> 956, 3 -> 936, 4 -> 927, 5 -> 702, 6 -> 118, 7 -> 698, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/firestore/v1/StructuredQuery.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/firestore/v1/StructuredQuery
    //   80: monitorenter
    //   81: getstatic com/google/firestore/v1/StructuredQuery.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/firestore/v1/StructuredQuery.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/firestore/v1/StructuredQuery.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/firestore/v1/StructuredQuery
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/firestore/v1/StructuredQuery
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/firestore/v1/StructuredQuery.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 698
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 642
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 577
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 530
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 465
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 418
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 353
    //   179: iload #4
    //   181: bipush #48
    //   183: if_icmpeq -> 342
    //   186: iload #4
    //   188: bipush #58
    //   190: if_icmpeq -> 277
    //   193: iload #4
    //   195: bipush #66
    //   197: if_icmpeq -> 212
    //   200: aload_2
    //   201: iload #4
    //   203: invokevirtual skipField : (I)Z
    //   206: ifne -> 128
    //   209: goto -> 642
    //   212: aload_0
    //   213: getfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   216: ifnull -> 233
    //   219: aload_0
    //   220: getfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   223: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   226: checkcast com/google/firestore/v1/Cursor$Builder
    //   229: astore_1
    //   230: goto -> 235
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_0
    //   236: aload_2
    //   237: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   240: aload_3
    //   241: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   244: checkcast com/google/firestore/v1/Cursor
    //   247: putfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   250: aload_1
    //   251: ifnull -> 128
    //   254: aload_1
    //   255: aload_0
    //   256: getfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   259: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   268: checkcast com/google/firestore/v1/Cursor
    //   271: putfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   274: goto -> 128
    //   277: aload_0
    //   278: getfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   281: ifnull -> 298
    //   284: aload_0
    //   285: getfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   288: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   291: checkcast com/google/firestore/v1/Cursor$Builder
    //   294: astore_1
    //   295: goto -> 300
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_0
    //   301: aload_2
    //   302: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   305: aload_3
    //   306: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   309: checkcast com/google/firestore/v1/Cursor
    //   312: putfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   315: aload_1
    //   316: ifnull -> 128
    //   319: aload_1
    //   320: aload_0
    //   321: getfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   324: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   327: pop
    //   328: aload_0
    //   329: aload_1
    //   330: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   333: checkcast com/google/firestore/v1/Cursor
    //   336: putfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   339: goto -> 128
    //   342: aload_0
    //   343: aload_2
    //   344: invokevirtual readInt32 : ()I
    //   347: putfield offset_ : I
    //   350: goto -> 128
    //   353: aload_0
    //   354: getfield limit_ : Lcom/google/protobuf/Int32Value;
    //   357: ifnull -> 374
    //   360: aload_0
    //   361: getfield limit_ : Lcom/google/protobuf/Int32Value;
    //   364: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   367: checkcast com/google/protobuf/Int32Value$Builder
    //   370: astore_1
    //   371: goto -> 376
    //   374: aconst_null
    //   375: astore_1
    //   376: aload_0
    //   377: aload_2
    //   378: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   381: aload_3
    //   382: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   385: checkcast com/google/protobuf/Int32Value
    //   388: putfield limit_ : Lcom/google/protobuf/Int32Value;
    //   391: aload_1
    //   392: ifnull -> 128
    //   395: aload_1
    //   396: aload_0
    //   397: getfield limit_ : Lcom/google/protobuf/Int32Value;
    //   400: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   403: pop
    //   404: aload_0
    //   405: aload_1
    //   406: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   409: checkcast com/google/protobuf/Int32Value
    //   412: putfield limit_ : Lcom/google/protobuf/Int32Value;
    //   415: goto -> 128
    //   418: aload_0
    //   419: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   422: invokeinterface isModifiable : ()Z
    //   427: ifne -> 441
    //   430: aload_0
    //   431: aload_0
    //   432: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   435: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   438: putfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   441: aload_0
    //   442: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   445: aload_2
    //   446: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   449: aload_3
    //   450: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   453: checkcast com/google/firestore/v1/StructuredQuery$Order
    //   456: invokeinterface add : (Ljava/lang/Object;)Z
    //   461: pop
    //   462: goto -> 128
    //   465: aload_0
    //   466: getfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   469: ifnull -> 486
    //   472: aload_0
    //   473: getfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   476: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   479: checkcast com/google/firestore/v1/StructuredQuery$Filter$Builder
    //   482: astore_1
    //   483: goto -> 488
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_0
    //   489: aload_2
    //   490: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   493: aload_3
    //   494: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   497: checkcast com/google/firestore/v1/StructuredQuery$Filter
    //   500: putfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   503: aload_1
    //   504: ifnull -> 128
    //   507: aload_1
    //   508: aload_0
    //   509: getfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   512: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   515: pop
    //   516: aload_0
    //   517: aload_1
    //   518: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   521: checkcast com/google/firestore/v1/StructuredQuery$Filter
    //   524: putfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   527: goto -> 128
    //   530: aload_0
    //   531: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   534: invokeinterface isModifiable : ()Z
    //   539: ifne -> 553
    //   542: aload_0
    //   543: aload_0
    //   544: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   547: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   550: putfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   553: aload_0
    //   554: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   557: aload_2
    //   558: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   561: aload_3
    //   562: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   565: checkcast com/google/firestore/v1/StructuredQuery$CollectionSelector
    //   568: invokeinterface add : (Ljava/lang/Object;)Z
    //   573: pop
    //   574: goto -> 128
    //   577: aload_0
    //   578: getfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   581: ifnull -> 598
    //   584: aload_0
    //   585: getfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   588: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   591: checkcast com/google/firestore/v1/StructuredQuery$Projection$Builder
    //   594: astore_1
    //   595: goto -> 600
    //   598: aconst_null
    //   599: astore_1
    //   600: aload_0
    //   601: aload_2
    //   602: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   605: aload_3
    //   606: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   609: checkcast com/google/firestore/v1/StructuredQuery$Projection
    //   612: putfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   615: aload_1
    //   616: ifnull -> 128
    //   619: aload_1
    //   620: aload_0
    //   621: getfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   624: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   627: pop
    //   628: aload_0
    //   629: aload_1
    //   630: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   633: checkcast com/google/firestore/v1/StructuredQuery$Projection
    //   636: putfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   639: goto -> 128
    //   642: iconst_1
    //   643: istore #6
    //   645: goto -> 128
    //   648: astore_1
    //   649: goto -> 696
    //   652: astore_1
    //   653: new java/lang/RuntimeException
    //   656: astore_2
    //   657: new com/google/protobuf/InvalidProtocolBufferException
    //   660: astore_3
    //   661: aload_3
    //   662: aload_1
    //   663: invokevirtual getMessage : ()Ljava/lang/String;
    //   666: invokespecial <init> : (Ljava/lang/String;)V
    //   669: aload_2
    //   670: aload_3
    //   671: aload_0
    //   672: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   675: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   678: aload_2
    //   679: athrow
    //   680: astore_2
    //   681: new java/lang/RuntimeException
    //   684: astore_1
    //   685: aload_1
    //   686: aload_2
    //   687: aload_0
    //   688: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   691: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   694: aload_1
    //   695: athrow
    //   696: aload_1
    //   697: athrow
    //   698: getstatic com/google/firestore/v1/StructuredQuery.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery;
    //   701: areturn
    //   702: aload_2
    //   703: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   706: astore_1
    //   707: aload_3
    //   708: checkcast com/google/firestore/v1/StructuredQuery
    //   711: astore_2
    //   712: aload_0
    //   713: aload_1
    //   714: aload_0
    //   715: getfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   718: aload_2
    //   719: getfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   722: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   727: checkcast com/google/firestore/v1/StructuredQuery$Projection
    //   730: putfield select_ : Lcom/google/firestore/v1/StructuredQuery$Projection;
    //   733: aload_0
    //   734: aload_1
    //   735: aload_0
    //   736: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   739: aload_2
    //   740: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   743: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   748: putfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   751: aload_0
    //   752: aload_1
    //   753: aload_0
    //   754: getfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   757: aload_2
    //   758: getfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   761: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   766: checkcast com/google/firestore/v1/StructuredQuery$Filter
    //   769: putfield where_ : Lcom/google/firestore/v1/StructuredQuery$Filter;
    //   772: aload_0
    //   773: aload_1
    //   774: aload_0
    //   775: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   778: aload_2
    //   779: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   782: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   787: putfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   790: aload_0
    //   791: aload_1
    //   792: aload_0
    //   793: getfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   796: aload_2
    //   797: getfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   800: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   805: checkcast com/google/firestore/v1/Cursor
    //   808: putfield startAt_ : Lcom/google/firestore/v1/Cursor;
    //   811: aload_0
    //   812: aload_1
    //   813: aload_0
    //   814: getfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   817: aload_2
    //   818: getfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   821: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   826: checkcast com/google/firestore/v1/Cursor
    //   829: putfield endAt_ : Lcom/google/firestore/v1/Cursor;
    //   832: aload_0
    //   833: getfield offset_ : I
    //   836: ifeq -> 845
    //   839: iconst_1
    //   840: istore #7
    //   842: goto -> 848
    //   845: iconst_0
    //   846: istore #7
    //   848: aload_0
    //   849: getfield offset_ : I
    //   852: istore #6
    //   854: aload_2
    //   855: getfield offset_ : I
    //   858: ifeq -> 864
    //   861: iconst_1
    //   862: istore #5
    //   864: aload_0
    //   865: aload_1
    //   866: iload #7
    //   868: iload #6
    //   870: iload #5
    //   872: aload_2
    //   873: getfield offset_ : I
    //   876: invokeinterface visitInt : (ZIZI)I
    //   881: putfield offset_ : I
    //   884: aload_0
    //   885: aload_1
    //   886: aload_0
    //   887: getfield limit_ : Lcom/google/protobuf/Int32Value;
    //   890: aload_2
    //   891: getfield limit_ : Lcom/google/protobuf/Int32Value;
    //   894: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   899: checkcast com/google/protobuf/Int32Value
    //   902: putfield limit_ : Lcom/google/protobuf/Int32Value;
    //   905: aload_1
    //   906: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   909: if_acmpne -> 925
    //   912: aload_0
    //   913: aload_0
    //   914: getfield bitField0_ : I
    //   917: aload_2
    //   918: getfield bitField0_ : I
    //   921: ior
    //   922: putfield bitField0_ : I
    //   925: aload_0
    //   926: areturn
    //   927: new com/google/firestore/v1/StructuredQuery$Builder
    //   930: dup
    //   931: aconst_null
    //   932: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
    //   935: areturn
    //   936: aload_0
    //   937: getfield from_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   940: invokeinterface makeImmutable : ()V
    //   945: aload_0
    //   946: getfield orderBy_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   949: invokeinterface makeImmutable : ()V
    //   954: aconst_null
    //   955: areturn
    //   956: getstatic com/google/firestore/v1/StructuredQuery.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery;
    //   959: areturn
    //   960: new com/google/firestore/v1/StructuredQuery
    //   963: dup
    //   964: invokespecial <init> : ()V
    //   967: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	680	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	652	java/io/IOException
    //   133	139	648	finally
    //   200	209	680	com/google/protobuf/InvalidProtocolBufferException
    //   200	209	652	java/io/IOException
    //   200	209	648	finally
    //   212	230	680	com/google/protobuf/InvalidProtocolBufferException
    //   212	230	652	java/io/IOException
    //   212	230	648	finally
    //   235	250	680	com/google/protobuf/InvalidProtocolBufferException
    //   235	250	652	java/io/IOException
    //   235	250	648	finally
    //   254	274	680	com/google/protobuf/InvalidProtocolBufferException
    //   254	274	652	java/io/IOException
    //   254	274	648	finally
    //   277	295	680	com/google/protobuf/InvalidProtocolBufferException
    //   277	295	652	java/io/IOException
    //   277	295	648	finally
    //   300	315	680	com/google/protobuf/InvalidProtocolBufferException
    //   300	315	652	java/io/IOException
    //   300	315	648	finally
    //   319	339	680	com/google/protobuf/InvalidProtocolBufferException
    //   319	339	652	java/io/IOException
    //   319	339	648	finally
    //   342	350	680	com/google/protobuf/InvalidProtocolBufferException
    //   342	350	652	java/io/IOException
    //   342	350	648	finally
    //   353	371	680	com/google/protobuf/InvalidProtocolBufferException
    //   353	371	652	java/io/IOException
    //   353	371	648	finally
    //   376	391	680	com/google/protobuf/InvalidProtocolBufferException
    //   376	391	652	java/io/IOException
    //   376	391	648	finally
    //   395	415	680	com/google/protobuf/InvalidProtocolBufferException
    //   395	415	652	java/io/IOException
    //   395	415	648	finally
    //   418	441	680	com/google/protobuf/InvalidProtocolBufferException
    //   418	441	652	java/io/IOException
    //   418	441	648	finally
    //   441	462	680	com/google/protobuf/InvalidProtocolBufferException
    //   441	462	652	java/io/IOException
    //   441	462	648	finally
    //   465	483	680	com/google/protobuf/InvalidProtocolBufferException
    //   465	483	652	java/io/IOException
    //   465	483	648	finally
    //   488	503	680	com/google/protobuf/InvalidProtocolBufferException
    //   488	503	652	java/io/IOException
    //   488	503	648	finally
    //   507	527	680	com/google/protobuf/InvalidProtocolBufferException
    //   507	527	652	java/io/IOException
    //   507	527	648	finally
    //   530	553	680	com/google/protobuf/InvalidProtocolBufferException
    //   530	553	652	java/io/IOException
    //   530	553	648	finally
    //   553	574	680	com/google/protobuf/InvalidProtocolBufferException
    //   553	574	652	java/io/IOException
    //   553	574	648	finally
    //   577	595	680	com/google/protobuf/InvalidProtocolBufferException
    //   577	595	652	java/io/IOException
    //   577	595	648	finally
    //   600	615	680	com/google/protobuf/InvalidProtocolBufferException
    //   600	615	652	java/io/IOException
    //   600	615	648	finally
    //   619	639	680	com/google/protobuf/InvalidProtocolBufferException
    //   619	639	652	java/io/IOException
    //   619	639	648	finally
    //   653	680	648	finally
    //   681	696	648	finally
  }
  
  public Cursor getEndAt() {
    Cursor cursor1 = this.endAt_;
    Cursor cursor2 = cursor1;
    if (cursor1 == null)
      cursor2 = Cursor.getDefaultInstance(); 
    return cursor2;
  }
  
  public CollectionSelector getFrom(int paramInt) {
    return (CollectionSelector)this.from_.get(paramInt);
  }
  
  public int getFromCount() {
    return this.from_.size();
  }
  
  public List<CollectionSelector> getFromList() {
    return (List<CollectionSelector>)this.from_;
  }
  
  public CollectionSelectorOrBuilder getFromOrBuilder(int paramInt) {
    return (CollectionSelectorOrBuilder)this.from_.get(paramInt);
  }
  
  public List<? extends CollectionSelectorOrBuilder> getFromOrBuilderList() {
    return (List)this.from_;
  }
  
  public Int32Value getLimit() {
    Int32Value int32Value1 = this.limit_;
    Int32Value int32Value2 = int32Value1;
    if (int32Value1 == null)
      int32Value2 = Int32Value.getDefaultInstance(); 
    return int32Value2;
  }
  
  public int getOffset() {
    return this.offset_;
  }
  
  public Order getOrderBy(int paramInt) {
    return (Order)this.orderBy_.get(paramInt);
  }
  
  public int getOrderByCount() {
    return this.orderBy_.size();
  }
  
  public List<Order> getOrderByList() {
    return (List<Order>)this.orderBy_;
  }
  
  public OrderOrBuilder getOrderByOrBuilder(int paramInt) {
    return (OrderOrBuilder)this.orderBy_.get(paramInt);
  }
  
  public List<? extends OrderOrBuilder> getOrderByOrBuilderList() {
    return (List)this.orderBy_;
  }
  
  public Projection getSelect() {
    Projection projection1 = this.select_;
    Projection projection2 = projection1;
    if (projection1 == null)
      projection2 = Projection.getDefaultInstance(); 
    return projection2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    Projection projection = this.select_;
    byte b = 0;
    if (projection != null) {
      i = CodedOutputStream.computeMessageSize(1, (MessageLite)getSelect()) + 0;
    } else {
      i = 0;
    } 
    int j = 0;
    int k = i;
    for (i = j; i < this.from_.size(); i++)
      k += CodedOutputStream.computeMessageSize(2, (MessageLite)this.from_.get(i)); 
    j = b;
    i = k;
    if (this.where_ != null) {
      i = k + CodedOutputStream.computeMessageSize(3, (MessageLite)getWhere());
      j = b;
    } 
    while (j < this.orderBy_.size()) {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.orderBy_.get(j));
      j++;
    } 
    k = i;
    if (this.limit_ != null)
      k = i + CodedOutputStream.computeMessageSize(5, (MessageLite)getLimit()); 
    j = this.offset_;
    i = k;
    if (j != 0)
      i = k + CodedOutputStream.computeInt32Size(6, j); 
    k = i;
    if (this.startAt_ != null)
      k = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getStartAt()); 
    i = k;
    if (this.endAt_ != null)
      i = k + CodedOutputStream.computeMessageSize(8, (MessageLite)getEndAt()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public Cursor getStartAt() {
    Cursor cursor1 = this.startAt_;
    Cursor cursor2 = cursor1;
    if (cursor1 == null)
      cursor2 = Cursor.getDefaultInstance(); 
    return cursor2;
  }
  
  public Filter getWhere() {
    Filter filter1 = this.where_;
    Filter filter2 = filter1;
    if (filter1 == null)
      filter2 = Filter.getDefaultInstance(); 
    return filter2;
  }
  
  public boolean hasEndAt() {
    boolean bool;
    if (this.endAt_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasLimit() {
    boolean bool;
    if (this.limit_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasSelect() {
    boolean bool;
    if (this.select_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasStartAt() {
    boolean bool;
    if (this.startAt_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasWhere() {
    boolean bool;
    if (this.where_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.select_ != null)
      paramCodedOutputStream.writeMessage(1, (MessageLite)getSelect()); 
    byte b = 0;
    int i;
    for (i = 0; i < this.from_.size(); i++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.from_.get(i)); 
    i = b;
    if (this.where_ != null) {
      paramCodedOutputStream.writeMessage(3, (MessageLite)getWhere());
      i = b;
    } 
    while (i < this.orderBy_.size()) {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.orderBy_.get(i));
      i++;
    } 
    if (this.limit_ != null)
      paramCodedOutputStream.writeMessage(5, (MessageLite)getLimit()); 
    i = this.offset_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(6, i); 
    if (this.startAt_ != null)
      paramCodedOutputStream.writeMessage(7, (MessageLite)getStartAt()); 
    if (this.endAt_ != null)
      paramCodedOutputStream.writeMessage(8, (MessageLite)getEndAt()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
    private Builder() {
      super(StructuredQuery.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFrom(Iterable<? extends StructuredQuery.CollectionSelector> param1Iterable) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addAllFrom(param1Iterable);
      return this;
    }
    
    public Builder addAllOrderBy(Iterable<? extends StructuredQuery.Order> param1Iterable) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addAllOrderBy(param1Iterable);
      return this;
    }
    
    public Builder addFrom(int param1Int, StructuredQuery.CollectionSelector.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addFrom(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFrom(int param1Int, StructuredQuery.CollectionSelector param1CollectionSelector) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addFrom(param1Int, param1CollectionSelector);
      return this;
    }
    
    public Builder addFrom(StructuredQuery.CollectionSelector.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addFrom(param1Builder);
      return this;
    }
    
    public Builder addFrom(StructuredQuery.CollectionSelector param1CollectionSelector) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addFrom(param1CollectionSelector);
      return this;
    }
    
    public Builder addOrderBy(int param1Int, StructuredQuery.Order.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addOrderBy(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOrderBy(int param1Int, StructuredQuery.Order param1Order) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addOrderBy(param1Int, param1Order);
      return this;
    }
    
    public Builder addOrderBy(StructuredQuery.Order.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addOrderBy(param1Builder);
      return this;
    }
    
    public Builder addOrderBy(StructuredQuery.Order param1Order) {
      copyOnWrite();
      ((StructuredQuery)this.instance).addOrderBy(param1Order);
      return this;
    }
    
    public Builder clearEndAt() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearEndAt();
      return this;
    }
    
    public Builder clearFrom() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearFrom();
      return this;
    }
    
    public Builder clearLimit() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearLimit();
      return this;
    }
    
    public Builder clearOffset() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearOffset();
      return this;
    }
    
    public Builder clearOrderBy() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearOrderBy();
      return this;
    }
    
    public Builder clearSelect() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearSelect();
      return this;
    }
    
    public Builder clearStartAt() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearStartAt();
      return this;
    }
    
    public Builder clearWhere() {
      copyOnWrite();
      ((StructuredQuery)this.instance).clearWhere();
      return this;
    }
    
    public Cursor getEndAt() {
      return ((StructuredQuery)this.instance).getEndAt();
    }
    
    public StructuredQuery.CollectionSelector getFrom(int param1Int) {
      return ((StructuredQuery)this.instance).getFrom(param1Int);
    }
    
    public int getFromCount() {
      return ((StructuredQuery)this.instance).getFromCount();
    }
    
    public List<StructuredQuery.CollectionSelector> getFromList() {
      return Collections.unmodifiableList(((StructuredQuery)this.instance).getFromList());
    }
    
    public Int32Value getLimit() {
      return ((StructuredQuery)this.instance).getLimit();
    }
    
    public int getOffset() {
      return ((StructuredQuery)this.instance).getOffset();
    }
    
    public StructuredQuery.Order getOrderBy(int param1Int) {
      return ((StructuredQuery)this.instance).getOrderBy(param1Int);
    }
    
    public int getOrderByCount() {
      return ((StructuredQuery)this.instance).getOrderByCount();
    }
    
    public List<StructuredQuery.Order> getOrderByList() {
      return Collections.unmodifiableList(((StructuredQuery)this.instance).getOrderByList());
    }
    
    public StructuredQuery.Projection getSelect() {
      return ((StructuredQuery)this.instance).getSelect();
    }
    
    public Cursor getStartAt() {
      return ((StructuredQuery)this.instance).getStartAt();
    }
    
    public StructuredQuery.Filter getWhere() {
      return ((StructuredQuery)this.instance).getWhere();
    }
    
    public boolean hasEndAt() {
      return ((StructuredQuery)this.instance).hasEndAt();
    }
    
    public boolean hasLimit() {
      return ((StructuredQuery)this.instance).hasLimit();
    }
    
    public boolean hasSelect() {
      return ((StructuredQuery)this.instance).hasSelect();
    }
    
    public boolean hasStartAt() {
      return ((StructuredQuery)this.instance).hasStartAt();
    }
    
    public boolean hasWhere() {
      return ((StructuredQuery)this.instance).hasWhere();
    }
    
    public Builder mergeEndAt(Cursor param1Cursor) {
      copyOnWrite();
      ((StructuredQuery)this.instance).mergeEndAt(param1Cursor);
      return this;
    }
    
    public Builder mergeLimit(Int32Value param1Int32Value) {
      copyOnWrite();
      ((StructuredQuery)this.instance).mergeLimit(param1Int32Value);
      return this;
    }
    
    public Builder mergeSelect(StructuredQuery.Projection param1Projection) {
      copyOnWrite();
      ((StructuredQuery)this.instance).mergeSelect(param1Projection);
      return this;
    }
    
    public Builder mergeStartAt(Cursor param1Cursor) {
      copyOnWrite();
      ((StructuredQuery)this.instance).mergeStartAt(param1Cursor);
      return this;
    }
    
    public Builder mergeWhere(StructuredQuery.Filter param1Filter) {
      copyOnWrite();
      ((StructuredQuery)this.instance).mergeWhere(param1Filter);
      return this;
    }
    
    public Builder removeFrom(int param1Int) {
      copyOnWrite();
      ((StructuredQuery)this.instance).removeFrom(param1Int);
      return this;
    }
    
    public Builder removeOrderBy(int param1Int) {
      copyOnWrite();
      ((StructuredQuery)this.instance).removeOrderBy(param1Int);
      return this;
    }
    
    public Builder setEndAt(Cursor.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setEndAt(param1Builder);
      return this;
    }
    
    public Builder setEndAt(Cursor param1Cursor) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setEndAt(param1Cursor);
      return this;
    }
    
    public Builder setFrom(int param1Int, StructuredQuery.CollectionSelector.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setFrom(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFrom(int param1Int, StructuredQuery.CollectionSelector param1CollectionSelector) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setFrom(param1Int, param1CollectionSelector);
      return this;
    }
    
    public Builder setLimit(Int32Value.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setLimit(param1Builder);
      return this;
    }
    
    public Builder setLimit(Int32Value param1Int32Value) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setLimit(param1Int32Value);
      return this;
    }
    
    public Builder setOffset(int param1Int) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setOffset(param1Int);
      return this;
    }
    
    public Builder setOrderBy(int param1Int, StructuredQuery.Order.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setOrderBy(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOrderBy(int param1Int, StructuredQuery.Order param1Order) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setOrderBy(param1Int, param1Order);
      return this;
    }
    
    public Builder setSelect(StructuredQuery.Projection.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setSelect(param1Builder);
      return this;
    }
    
    public Builder setSelect(StructuredQuery.Projection param1Projection) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setSelect(param1Projection);
      return this;
    }
    
    public Builder setStartAt(Cursor.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setStartAt(param1Builder);
      return this;
    }
    
    public Builder setStartAt(Cursor param1Cursor) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setStartAt(param1Cursor);
      return this;
    }
    
    public Builder setWhere(StructuredQuery.Filter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setWhere(param1Builder);
      return this;
    }
    
    public Builder setWhere(StructuredQuery.Filter param1Filter) {
      copyOnWrite();
      ((StructuredQuery)this.instance).setWhere(param1Filter);
      return this;
    }
  }
  
  public static final class CollectionSelector extends GeneratedMessageLite<CollectionSelector, CollectionSelector.Builder> implements CollectionSelectorOrBuilder {
    public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
    
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    
    private static final CollectionSelector DEFAULT_INSTANCE = new CollectionSelector();
    
    private static volatile Parser<CollectionSelector> PARSER;
    
    private boolean allDescendants_;
    
    private String collectionId_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearAllDescendants() {
      this.allDescendants_ = false;
    }
    
    private void clearCollectionId() {
      this.collectionId_ = getDefaultInstance().getCollectionId();
    }
    
    public static CollectionSelector getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CollectionSelector param1CollectionSelector) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CollectionSelector);
    }
    
    public static CollectionSelector parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CollectionSelector)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CollectionSelector parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CollectionSelector)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CollectionSelector parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CollectionSelector parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CollectionSelector parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CollectionSelector parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CollectionSelector parseFrom(InputStream param1InputStream) throws IOException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CollectionSelector parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CollectionSelector parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CollectionSelector parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CollectionSelector)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CollectionSelector> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setAllDescendants(boolean param1Boolean) {
      this.allDescendants_ = param1Boolean;
    }
    
    private void setCollectionId(String param1String) {
      if (param1String != null) {
        this.collectionId_ = param1String;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setCollectionIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        checkByteStringIsUtf8(param1ByteString);
        this.collectionId_ = param1ByteString.toStringUtf8();
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 344, 2 -> 340, 3 -> 338, 4 -> 329, 5 -> 247, 6 -> 110, 7 -> 243, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firestore/v1/StructuredQuery$CollectionSelector
      //   72: monitorenter
      //   73: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CollectionSelector;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firestore/v1/StructuredQuery$CollectionSelector
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firestore/v1/StructuredQuery$CollectionSelector
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.PARSER : Lcom/google/protobuf/Parser;
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
      //   141: bipush #18
      //   143: if_icmpeq -> 176
      //   146: iload #5
      //   148: bipush #24
      //   150: if_icmpeq -> 165
      //   153: aload_1
      //   154: iload #5
      //   156: invokevirtual skipField : (I)Z
      //   159: ifne -> 123
      //   162: goto -> 187
      //   165: aload_0
      //   166: aload_1
      //   167: invokevirtual readBool : ()Z
      //   170: putfield allDescendants_ : Z
      //   173: goto -> 123
      //   176: aload_0
      //   177: aload_1
      //   178: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   181: putfield collectionId_ : Ljava/lang/String;
      //   184: goto -> 123
      //   187: iconst_1
      //   188: istore #4
      //   190: goto -> 123
      //   193: astore_1
      //   194: goto -> 241
      //   197: astore_2
      //   198: new java/lang/RuntimeException
      //   201: astore_3
      //   202: new com/google/protobuf/InvalidProtocolBufferException
      //   205: astore_1
      //   206: aload_1
      //   207: aload_2
      //   208: invokevirtual getMessage : ()Ljava/lang/String;
      //   211: invokespecial <init> : (Ljava/lang/String;)V
      //   214: aload_3
      //   215: aload_1
      //   216: aload_0
      //   217: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   220: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   223: aload_3
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
      //   243: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CollectionSelector;
      //   246: areturn
      //   247: aload_2
      //   248: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   251: astore_1
      //   252: aload_3
      //   253: checkcast com/google/firestore/v1/StructuredQuery$CollectionSelector
      //   256: astore_2
      //   257: aload_0
      //   258: aload_1
      //   259: aload_0
      //   260: getfield collectionId_ : Ljava/lang/String;
      //   263: invokevirtual isEmpty : ()Z
      //   266: iconst_1
      //   267: ixor
      //   268: aload_0
      //   269: getfield collectionId_ : Ljava/lang/String;
      //   272: iconst_1
      //   273: aload_2
      //   274: getfield collectionId_ : Ljava/lang/String;
      //   277: invokevirtual isEmpty : ()Z
      //   280: ixor
      //   281: aload_2
      //   282: getfield collectionId_ : Ljava/lang/String;
      //   285: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   290: putfield collectionId_ : Ljava/lang/String;
      //   293: aload_0
      //   294: getfield allDescendants_ : Z
      //   297: istore #6
      //   299: aload_2
      //   300: getfield allDescendants_ : Z
      //   303: istore #7
      //   305: aload_0
      //   306: aload_1
      //   307: iload #6
      //   309: iload #6
      //   311: iload #7
      //   313: iload #7
      //   315: invokeinterface visitBoolean : (ZZZZ)Z
      //   320: putfield allDescendants_ : Z
      //   323: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   326: astore_1
      //   327: aload_0
      //   328: areturn
      //   329: new com/google/firestore/v1/StructuredQuery$CollectionSelector$Builder
      //   332: dup
      //   333: aconst_null
      //   334: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   337: areturn
      //   338: aconst_null
      //   339: areturn
      //   340: getstatic com/google/firestore/v1/StructuredQuery$CollectionSelector.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CollectionSelector;
      //   343: areturn
      //   344: new com/google/firestore/v1/StructuredQuery$CollectionSelector
      //   347: dup
      //   348: invokespecial <init> : ()V
      //   351: areturn
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
    
    public boolean getAllDescendants() {
      return this.allDescendants_;
    }
    
    public String getCollectionId() {
      return this.collectionId_;
    }
    
    public ByteString getCollectionIdBytes() {
      return ByteString.copyFromUtf8(this.collectionId_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.collectionId_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(2, getCollectionId()); 
      boolean bool = this.allDescendants_;
      int j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(3, bool); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.collectionId_.isEmpty())
        param1CodedOutputStream.writeString(2, getCollectionId()); 
      boolean bool = this.allDescendants_;
      if (bool)
        param1CodedOutputStream.writeBool(3, bool); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CollectionSelector, Builder> implements StructuredQuery.CollectionSelectorOrBuilder {
      private Builder() {
        super(StructuredQuery.CollectionSelector.DEFAULT_INSTANCE);
      }
      
      public Builder clearAllDescendants() {
        copyOnWrite();
        ((StructuredQuery.CollectionSelector)this.instance).clearAllDescendants();
        return this;
      }
      
      public Builder clearCollectionId() {
        copyOnWrite();
        ((StructuredQuery.CollectionSelector)this.instance).clearCollectionId();
        return this;
      }
      
      public boolean getAllDescendants() {
        return ((StructuredQuery.CollectionSelector)this.instance).getAllDescendants();
      }
      
      public String getCollectionId() {
        return ((StructuredQuery.CollectionSelector)this.instance).getCollectionId();
      }
      
      public ByteString getCollectionIdBytes() {
        return ((StructuredQuery.CollectionSelector)this.instance).getCollectionIdBytes();
      }
      
      public Builder setAllDescendants(boolean param2Boolean) {
        copyOnWrite();
        ((StructuredQuery.CollectionSelector)this.instance).setAllDescendants(param2Boolean);
        return this;
      }
      
      public Builder setCollectionId(String param2String) {
        copyOnWrite();
        ((StructuredQuery.CollectionSelector)this.instance).setCollectionId(param2String);
        return this;
      }
      
      public Builder setCollectionIdBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((StructuredQuery.CollectionSelector)this.instance).setCollectionIdBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CollectionSelector, CollectionSelector.Builder> implements CollectionSelectorOrBuilder {
    private Builder() {
      super(StructuredQuery.CollectionSelector.DEFAULT_INSTANCE);
    }
    
    public Builder clearAllDescendants() {
      copyOnWrite();
      ((StructuredQuery.CollectionSelector)this.instance).clearAllDescendants();
      return this;
    }
    
    public Builder clearCollectionId() {
      copyOnWrite();
      ((StructuredQuery.CollectionSelector)this.instance).clearCollectionId();
      return this;
    }
    
    public boolean getAllDescendants() {
      return ((StructuredQuery.CollectionSelector)this.instance).getAllDescendants();
    }
    
    public String getCollectionId() {
      return ((StructuredQuery.CollectionSelector)this.instance).getCollectionId();
    }
    
    public ByteString getCollectionIdBytes() {
      return ((StructuredQuery.CollectionSelector)this.instance).getCollectionIdBytes();
    }
    
    public Builder setAllDescendants(boolean param1Boolean) {
      copyOnWrite();
      ((StructuredQuery.CollectionSelector)this.instance).setAllDescendants(param1Boolean);
      return this;
    }
    
    public Builder setCollectionId(String param1String) {
      copyOnWrite();
      ((StructuredQuery.CollectionSelector)this.instance).setCollectionId(param1String);
      return this;
    }
    
    public Builder setCollectionIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((StructuredQuery.CollectionSelector)this.instance).setCollectionIdBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface CollectionSelectorOrBuilder extends MessageLiteOrBuilder {
    boolean getAllDescendants();
    
    String getCollectionId();
    
    ByteString getCollectionIdBytes();
  }
  
  public static final class CompositeFilter extends GeneratedMessageLite<CompositeFilter, CompositeFilter.Builder> implements CompositeFilterOrBuilder {
    private static final CompositeFilter DEFAULT_INSTANCE = new CompositeFilter();
    
    public static final int FILTERS_FIELD_NUMBER = 2;
    
    public static final int OP_FIELD_NUMBER = 1;
    
    private static volatile Parser<CompositeFilter> PARSER;
    
    private int bitField0_;
    
    private Internal.ProtobufList<StructuredQuery.Filter> filters_ = emptyProtobufList();
    
    private int op_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFilters(Iterable<? extends StructuredQuery.Filter> param1Iterable) {
      ensureFiltersIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.filters_);
    }
    
    private void addFilters(int param1Int, StructuredQuery.Filter.Builder param1Builder) {
      ensureFiltersIsMutable();
      this.filters_.add(param1Int, param1Builder.build());
    }
    
    private void addFilters(int param1Int, StructuredQuery.Filter param1Filter) {
      if (param1Filter != null) {
        ensureFiltersIsMutable();
        this.filters_.add(param1Int, param1Filter);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFilters(StructuredQuery.Filter.Builder param1Builder) {
      ensureFiltersIsMutable();
      this.filters_.add(param1Builder.build());
    }
    
    private void addFilters(StructuredQuery.Filter param1Filter) {
      if (param1Filter != null) {
        ensureFiltersIsMutable();
        this.filters_.add(param1Filter);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearFilters() {
      this.filters_ = emptyProtobufList();
    }
    
    private void clearOp() {
      this.op_ = 0;
    }
    
    private void ensureFiltersIsMutable() {
      if (!this.filters_.isModifiable())
        this.filters_ = GeneratedMessageLite.mutableCopy(this.filters_); 
    }
    
    public static CompositeFilter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CompositeFilter param1CompositeFilter) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1CompositeFilter);
    }
    
    public static CompositeFilter parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CompositeFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CompositeFilter parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CompositeFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CompositeFilter parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static CompositeFilter parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CompositeFilter parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static CompositeFilter parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CompositeFilter parseFrom(InputStream param1InputStream) throws IOException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static CompositeFilter parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CompositeFilter parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static CompositeFilter parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CompositeFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CompositeFilter> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeFilters(int param1Int) {
      ensureFiltersIsMutable();
      this.filters_.remove(param1Int);
    }
    
    private void setFilters(int param1Int, StructuredQuery.Filter.Builder param1Builder) {
      ensureFiltersIsMutable();
      this.filters_.set(param1Int, param1Builder.build());
    }
    
    private void setFilters(int param1Int, StructuredQuery.Filter param1Filter) {
      if (param1Filter != null) {
        ensureFiltersIsMutable();
        this.filters_.set(param1Int, param1Filter);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOp(Operator param1Operator) {
      if (param1Operator != null) {
        this.op_ = param1Operator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOpValue(int param1Int) {
      this.op_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 414, 2 -> 410, 3 -> 399, 4 -> 390, 5 -> 288, 6 -> 118, 7 -> 284, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   80: monitorenter
      //   81: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CompositeFilter;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_1
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_2
      //   128: iload #6
      //   130: ifne -> 284
      //   133: aload_1
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 228
      //   144: iload #4
      //   146: bipush #8
      //   148: if_icmpeq -> 217
      //   151: iload #4
      //   153: bipush #18
      //   155: if_icmpeq -> 170
      //   158: aload_1
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: goto -> 228
      //   170: aload_0
      //   171: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   174: invokeinterface isModifiable : ()Z
      //   179: ifne -> 193
      //   182: aload_0
      //   183: aload_0
      //   184: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   187: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   190: putfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   193: aload_0
      //   194: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   197: aload_1
      //   198: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   201: aload_2
      //   202: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   205: checkcast com/google/firestore/v1/StructuredQuery$Filter
      //   208: invokeinterface add : (Ljava/lang/Object;)Z
      //   213: pop
      //   214: goto -> 128
      //   217: aload_0
      //   218: aload_1
      //   219: invokevirtual readEnum : ()I
      //   222: putfield op_ : I
      //   225: goto -> 128
      //   228: iconst_1
      //   229: istore #6
      //   231: goto -> 128
      //   234: astore_1
      //   235: goto -> 282
      //   238: astore_2
      //   239: new java/lang/RuntimeException
      //   242: astore_1
      //   243: new com/google/protobuf/InvalidProtocolBufferException
      //   246: astore_3
      //   247: aload_3
      //   248: aload_2
      //   249: invokevirtual getMessage : ()Ljava/lang/String;
      //   252: invokespecial <init> : (Ljava/lang/String;)V
      //   255: aload_1
      //   256: aload_3
      //   257: aload_0
      //   258: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   261: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   264: aload_1
      //   265: athrow
      //   266: astore_2
      //   267: new java/lang/RuntimeException
      //   270: astore_1
      //   271: aload_1
      //   272: aload_2
      //   273: aload_0
      //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   280: aload_1
      //   281: athrow
      //   282: aload_1
      //   283: athrow
      //   284: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CompositeFilter;
      //   287: areturn
      //   288: aload_2
      //   289: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   292: astore_1
      //   293: aload_3
      //   294: checkcast com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   297: astore_2
      //   298: aload_0
      //   299: getfield op_ : I
      //   302: ifeq -> 311
      //   305: iconst_1
      //   306: istore #7
      //   308: goto -> 314
      //   311: iconst_0
      //   312: istore #7
      //   314: aload_0
      //   315: getfield op_ : I
      //   318: istore #6
      //   320: aload_2
      //   321: getfield op_ : I
      //   324: ifeq -> 330
      //   327: iconst_1
      //   328: istore #5
      //   330: aload_0
      //   331: aload_1
      //   332: iload #7
      //   334: iload #6
      //   336: iload #5
      //   338: aload_2
      //   339: getfield op_ : I
      //   342: invokeinterface visitInt : (ZIZI)I
      //   347: putfield op_ : I
      //   350: aload_0
      //   351: aload_1
      //   352: aload_0
      //   353: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   356: aload_2
      //   357: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   360: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   365: putfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   368: aload_1
      //   369: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   372: if_acmpne -> 388
      //   375: aload_0
      //   376: aload_0
      //   377: getfield bitField0_ : I
      //   380: aload_2
      //   381: getfield bitField0_ : I
      //   384: ior
      //   385: putfield bitField0_ : I
      //   388: aload_0
      //   389: areturn
      //   390: new com/google/firestore/v1/StructuredQuery$CompositeFilter$Builder
      //   393: dup
      //   394: aconst_null
      //   395: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   398: areturn
      //   399: aload_0
      //   400: getfield filters_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   403: invokeinterface makeImmutable : ()V
      //   408: aconst_null
      //   409: areturn
      //   410: getstatic com/google/firestore/v1/StructuredQuery$CompositeFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$CompositeFilter;
      //   413: areturn
      //   414: new com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   417: dup
      //   418: invokespecial <init> : ()V
      //   421: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	266	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	238	java/io/IOException
      //   133	139	234	finally
      //   158	167	266	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	238	java/io/IOException
      //   158	167	234	finally
      //   170	193	266	com/google/protobuf/InvalidProtocolBufferException
      //   170	193	238	java/io/IOException
      //   170	193	234	finally
      //   193	214	266	com/google/protobuf/InvalidProtocolBufferException
      //   193	214	238	java/io/IOException
      //   193	214	234	finally
      //   217	225	266	com/google/protobuf/InvalidProtocolBufferException
      //   217	225	238	java/io/IOException
      //   217	225	234	finally
      //   239	266	234	finally
      //   267	282	234	finally
    }
    
    public StructuredQuery.Filter getFilters(int param1Int) {
      return (StructuredQuery.Filter)this.filters_.get(param1Int);
    }
    
    public int getFiltersCount() {
      return this.filters_.size();
    }
    
    public List<StructuredQuery.Filter> getFiltersList() {
      return (List<StructuredQuery.Filter>)this.filters_;
    }
    
    public StructuredQuery.FilterOrBuilder getFiltersOrBuilder(int param1Int) {
      return (StructuredQuery.FilterOrBuilder)this.filters_.get(param1Int);
    }
    
    public List<? extends StructuredQuery.FilterOrBuilder> getFiltersOrBuilderList() {
      return (List)this.filters_;
    }
    
    public Operator getOp() {
      Operator operator1 = Operator.forNumber(this.op_);
      Operator operator2 = operator1;
      if (operator1 == null)
        operator2 = Operator.UNRECOGNIZED; 
      return operator2;
    }
    
    public int getOpValue() {
      return this.op_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = this.op_;
      int j = Operator.OPERATOR_UNSPECIFIED.getNumber();
      byte b = 0;
      if (i != j) {
        i = CodedOutputStream.computeEnumSize(1, this.op_) + 0;
      } else {
        i = 0;
      } 
      while (b < this.filters_.size()) {
        i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.filters_.get(b));
        b++;
      } 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(1, this.op_); 
      for (byte b = 0; b < this.filters_.size(); b++)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.filters_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<CompositeFilter, Builder> implements StructuredQuery.CompositeFilterOrBuilder {
      private Builder() {
        super(StructuredQuery.CompositeFilter.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFilters(Iterable<? extends StructuredQuery.Filter> param2Iterable) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).addAllFilters(param2Iterable);
        return this;
      }
      
      public Builder addFilters(int param2Int, StructuredQuery.Filter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).addFilters(param2Int, param2Builder);
        return this;
      }
      
      public Builder addFilters(int param2Int, StructuredQuery.Filter param2Filter) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).addFilters(param2Int, param2Filter);
        return this;
      }
      
      public Builder addFilters(StructuredQuery.Filter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).addFilters(param2Builder);
        return this;
      }
      
      public Builder addFilters(StructuredQuery.Filter param2Filter) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).addFilters(param2Filter);
        return this;
      }
      
      public Builder clearFilters() {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).clearFilters();
        return this;
      }
      
      public Builder clearOp() {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).clearOp();
        return this;
      }
      
      public StructuredQuery.Filter getFilters(int param2Int) {
        return ((StructuredQuery.CompositeFilter)this.instance).getFilters(param2Int);
      }
      
      public int getFiltersCount() {
        return ((StructuredQuery.CompositeFilter)this.instance).getFiltersCount();
      }
      
      public List<StructuredQuery.Filter> getFiltersList() {
        return Collections.unmodifiableList(((StructuredQuery.CompositeFilter)this.instance).getFiltersList());
      }
      
      public StructuredQuery.CompositeFilter.Operator getOp() {
        return ((StructuredQuery.CompositeFilter)this.instance).getOp();
      }
      
      public int getOpValue() {
        return ((StructuredQuery.CompositeFilter)this.instance).getOpValue();
      }
      
      public Builder removeFilters(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).removeFilters(param2Int);
        return this;
      }
      
      public Builder setFilters(int param2Int, StructuredQuery.Filter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).setFilters(param2Int, param2Builder);
        return this;
      }
      
      public Builder setFilters(int param2Int, StructuredQuery.Filter param2Filter) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).setFilters(param2Int, param2Filter);
        return this;
      }
      
      public Builder setOp(StructuredQuery.CompositeFilter.Operator param2Operator) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).setOp(param2Operator);
        return this;
      }
      
      public Builder setOpValue(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.CompositeFilter)this.instance).setOpValue(param2Int);
        return this;
      }
    }
    
    public enum Operator implements Internal.EnumLite {
      AND,
      OPERATOR_UNSPECIFIED(0),
      UNRECOGNIZED(0);
      
      public static final int AND_VALUE = 1;
      
      public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
      
      private static final Internal.EnumLiteMap<Operator> internalValueMap = new Internal.EnumLiteMap<Operator>() {
          public StructuredQuery.CompositeFilter.Operator findValueByNumber(int param3Int) {
            return StructuredQuery.CompositeFilter.Operator.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      Operator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static Operator forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? null : AND) : OPERATOR_UNSPECIFIED;
      }
      
      public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<Operator> {
      public StructuredQuery.CompositeFilter.Operator findValueByNumber(int param2Int) {
        return StructuredQuery.CompositeFilter.Operator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<CompositeFilter, CompositeFilter.Builder> implements CompositeFilterOrBuilder {
    private Builder() {
      super(StructuredQuery.CompositeFilter.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFilters(Iterable<? extends StructuredQuery.Filter> param1Iterable) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).addAllFilters(param1Iterable);
      return this;
    }
    
    public Builder addFilters(int param1Int, StructuredQuery.Filter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).addFilters(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFilters(int param1Int, StructuredQuery.Filter param1Filter) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).addFilters(param1Int, param1Filter);
      return this;
    }
    
    public Builder addFilters(StructuredQuery.Filter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).addFilters(param1Builder);
      return this;
    }
    
    public Builder addFilters(StructuredQuery.Filter param1Filter) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).addFilters(param1Filter);
      return this;
    }
    
    public Builder clearFilters() {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).clearFilters();
      return this;
    }
    
    public Builder clearOp() {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).clearOp();
      return this;
    }
    
    public StructuredQuery.Filter getFilters(int param1Int) {
      return ((StructuredQuery.CompositeFilter)this.instance).getFilters(param1Int);
    }
    
    public int getFiltersCount() {
      return ((StructuredQuery.CompositeFilter)this.instance).getFiltersCount();
    }
    
    public List<StructuredQuery.Filter> getFiltersList() {
      return Collections.unmodifiableList(((StructuredQuery.CompositeFilter)this.instance).getFiltersList());
    }
    
    public StructuredQuery.CompositeFilter.Operator getOp() {
      return ((StructuredQuery.CompositeFilter)this.instance).getOp();
    }
    
    public int getOpValue() {
      return ((StructuredQuery.CompositeFilter)this.instance).getOpValue();
    }
    
    public Builder removeFilters(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).removeFilters(param1Int);
      return this;
    }
    
    public Builder setFilters(int param1Int, StructuredQuery.Filter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).setFilters(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFilters(int param1Int, StructuredQuery.Filter param1Filter) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).setFilters(param1Int, param1Filter);
      return this;
    }
    
    public Builder setOp(StructuredQuery.CompositeFilter.Operator param1Operator) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).setOp(param1Operator);
      return this;
    }
    
    public Builder setOpValue(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.CompositeFilter)this.instance).setOpValue(param1Int);
      return this;
    }
  }
  
  public enum Operator implements Internal.EnumLite {
    AND(0),
    OPERATOR_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int AND_VALUE = 1;
    
    public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Operator> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Operator[] { OPERATOR_UNSPECIFIED, AND, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Operator>() {
          public StructuredQuery.CompositeFilter.Operator findValueByNumber(int param3Int) {
            return StructuredQuery.CompositeFilter.Operator.forNumber(param3Int);
          }
        };
    }
    
    Operator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Operator forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : AND) : OPERATOR_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<CompositeFilter.Operator> {
    public StructuredQuery.CompositeFilter.Operator findValueByNumber(int param1Int) {
      return StructuredQuery.CompositeFilter.Operator.forNumber(param1Int);
    }
  }
  
  public static interface CompositeFilterOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.Filter getFilters(int param1Int);
    
    int getFiltersCount();
    
    List<StructuredQuery.Filter> getFiltersList();
    
    StructuredQuery.CompositeFilter.Operator getOp();
    
    int getOpValue();
  }
  
  public enum Direction implements Internal.EnumLite {
    ASCENDING(0),
    DESCENDING(0),
    DIRECTION_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int ASCENDING_VALUE = 1;
    
    public static final int DESCENDING_VALUE = 2;
    
    public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Direction> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Direction[] { DIRECTION_UNSPECIFIED, ASCENDING, DESCENDING, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Direction>() {
          public StructuredQuery.Direction findValueByNumber(int param2Int) {
            return StructuredQuery.Direction.forNumber(param2Int);
          }
        };
    }
    
    Direction(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Direction forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : DESCENDING) : ASCENDING) : DIRECTION_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<Direction> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<Direction> {
    public StructuredQuery.Direction findValueByNumber(int param1Int) {
      return StructuredQuery.Direction.forNumber(param1Int);
    }
  }
  
  public static final class FieldFilter extends GeneratedMessageLite<FieldFilter, FieldFilter.Builder> implements FieldFilterOrBuilder {
    private static final FieldFilter DEFAULT_INSTANCE = new FieldFilter();
    
    public static final int FIELD_FIELD_NUMBER = 1;
    
    public static final int OP_FIELD_NUMBER = 2;
    
    private static volatile Parser<FieldFilter> PARSER;
    
    public static final int VALUE_FIELD_NUMBER = 3;
    
    private StructuredQuery.FieldReference field_;
    
    private int op_;
    
    private Value value_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearField() {
      this.field_ = null;
    }
    
    private void clearOp() {
      this.op_ = 0;
    }
    
    private void clearValue() {
      this.value_ = null;
    }
    
    public static FieldFilter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeField(StructuredQuery.FieldReference param1FieldReference) {
      StructuredQuery.FieldReference fieldReference = this.field_;
      if (fieldReference != null && fieldReference != StructuredQuery.FieldReference.getDefaultInstance()) {
        this.field_ = (StructuredQuery.FieldReference)((StructuredQuery.FieldReference.Builder)StructuredQuery.FieldReference.newBuilder(this.field_).mergeFrom(param1FieldReference)).buildPartial();
      } else {
        this.field_ = param1FieldReference;
      } 
    }
    
    private void mergeValue(Value param1Value) {
      Value value = this.value_;
      if (value != null && value != Value.getDefaultInstance()) {
        this.value_ = (Value)((Value.Builder)Value.newBuilder(this.value_).mergeFrom(param1Value)).buildPartial();
      } else {
        this.value_ = param1Value;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldFilter param1FieldFilter) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldFilter);
    }
    
    public static FieldFilter parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldFilter parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldFilter parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldFilter parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldFilter parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldFilter parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldFilter parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldFilter parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldFilter parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldFilter parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldFilter> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setField(StructuredQuery.FieldReference.Builder param1Builder) {
      this.field_ = (StructuredQuery.FieldReference)param1Builder.build();
    }
    
    private void setField(StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        this.field_ = param1FieldReference;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOp(Operator param1Operator) {
      if (param1Operator != null) {
        this.op_ = param1Operator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOpValue(int param1Int) {
      this.op_ = param1Int;
    }
    
    private void setValue(Value.Builder param1Builder) {
      this.value_ = (Value)param1Builder.build();
    }
    
    private void setValue(Value param1Value) {
      if (param1Value != null) {
        this.value_ = param1Value;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 503, 2 -> 499, 3 -> 497, 4 -> 488, 5 -> 378, 6 -> 118, 7 -> 374, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firestore/v1/StructuredQuery$FieldFilter
      //   80: monitorenter
      //   81: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldFilter;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firestore/v1/StructuredQuery$FieldFilter.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firestore/v1/StructuredQuery$FieldFilter
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firestore/v1/StructuredQuery$FieldFilter
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_2
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_3
      //   128: iload #6
      //   130: ifne -> 374
      //   133: aload_2
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 318
      //   144: iload #4
      //   146: bipush #10
      //   148: if_icmpeq -> 253
      //   151: iload #4
      //   153: bipush #16
      //   155: if_icmpeq -> 242
      //   158: iload #4
      //   160: bipush #26
      //   162: if_icmpeq -> 177
      //   165: aload_2
      //   166: iload #4
      //   168: invokevirtual skipField : (I)Z
      //   171: ifne -> 128
      //   174: goto -> 318
      //   177: aload_0
      //   178: getfield value_ : Lcom/google/firestore/v1/Value;
      //   181: ifnull -> 198
      //   184: aload_0
      //   185: getfield value_ : Lcom/google/firestore/v1/Value;
      //   188: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   191: checkcast com/google/firestore/v1/Value$Builder
      //   194: astore_1
      //   195: goto -> 200
      //   198: aconst_null
      //   199: astore_1
      //   200: aload_0
      //   201: aload_2
      //   202: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   205: aload_3
      //   206: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   209: checkcast com/google/firestore/v1/Value
      //   212: putfield value_ : Lcom/google/firestore/v1/Value;
      //   215: aload_1
      //   216: ifnull -> 128
      //   219: aload_1
      //   220: aload_0
      //   221: getfield value_ : Lcom/google/firestore/v1/Value;
      //   224: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   227: pop
      //   228: aload_0
      //   229: aload_1
      //   230: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   233: checkcast com/google/firestore/v1/Value
      //   236: putfield value_ : Lcom/google/firestore/v1/Value;
      //   239: goto -> 128
      //   242: aload_0
      //   243: aload_2
      //   244: invokevirtual readEnum : ()I
      //   247: putfield op_ : I
      //   250: goto -> 128
      //   253: aload_0
      //   254: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   257: ifnull -> 274
      //   260: aload_0
      //   261: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   264: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   267: checkcast com/google/firestore/v1/StructuredQuery$FieldReference$Builder
      //   270: astore_1
      //   271: goto -> 276
      //   274: aconst_null
      //   275: astore_1
      //   276: aload_0
      //   277: aload_2
      //   278: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   281: aload_3
      //   282: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   285: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   288: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   291: aload_1
      //   292: ifnull -> 128
      //   295: aload_1
      //   296: aload_0
      //   297: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   300: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   303: pop
      //   304: aload_0
      //   305: aload_1
      //   306: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   309: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   312: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   315: goto -> 128
      //   318: iconst_1
      //   319: istore #6
      //   321: goto -> 128
      //   324: astore_1
      //   325: goto -> 372
      //   328: astore_1
      //   329: new java/lang/RuntimeException
      //   332: astore_2
      //   333: new com/google/protobuf/InvalidProtocolBufferException
      //   336: astore_3
      //   337: aload_3
      //   338: aload_1
      //   339: invokevirtual getMessage : ()Ljava/lang/String;
      //   342: invokespecial <init> : (Ljava/lang/String;)V
      //   345: aload_2
      //   346: aload_3
      //   347: aload_0
      //   348: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   351: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   354: aload_2
      //   355: athrow
      //   356: astore_1
      //   357: new java/lang/RuntimeException
      //   360: astore_2
      //   361: aload_2
      //   362: aload_1
      //   363: aload_0
      //   364: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   367: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   370: aload_2
      //   371: athrow
      //   372: aload_1
      //   373: athrow
      //   374: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldFilter;
      //   377: areturn
      //   378: aload_2
      //   379: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   382: astore_1
      //   383: aload_3
      //   384: checkcast com/google/firestore/v1/StructuredQuery$FieldFilter
      //   387: astore_2
      //   388: aload_0
      //   389: aload_1
      //   390: aload_0
      //   391: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   394: aload_2
      //   395: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   398: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   403: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   406: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   409: aload_0
      //   410: getfield op_ : I
      //   413: ifeq -> 422
      //   416: iconst_1
      //   417: istore #7
      //   419: goto -> 425
      //   422: iconst_0
      //   423: istore #7
      //   425: aload_0
      //   426: getfield op_ : I
      //   429: istore #6
      //   431: aload_2
      //   432: getfield op_ : I
      //   435: ifeq -> 441
      //   438: iconst_1
      //   439: istore #5
      //   441: aload_0
      //   442: aload_1
      //   443: iload #7
      //   445: iload #6
      //   447: iload #5
      //   449: aload_2
      //   450: getfield op_ : I
      //   453: invokeinterface visitInt : (ZIZI)I
      //   458: putfield op_ : I
      //   461: aload_0
      //   462: aload_1
      //   463: aload_0
      //   464: getfield value_ : Lcom/google/firestore/v1/Value;
      //   467: aload_2
      //   468: getfield value_ : Lcom/google/firestore/v1/Value;
      //   471: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   476: checkcast com/google/firestore/v1/Value
      //   479: putfield value_ : Lcom/google/firestore/v1/Value;
      //   482: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   485: astore_1
      //   486: aload_0
      //   487: areturn
      //   488: new com/google/firestore/v1/StructuredQuery$FieldFilter$Builder
      //   491: dup
      //   492: aconst_null
      //   493: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   496: areturn
      //   497: aconst_null
      //   498: areturn
      //   499: getstatic com/google/firestore/v1/StructuredQuery$FieldFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldFilter;
      //   502: areturn
      //   503: new com/google/firestore/v1/StructuredQuery$FieldFilter
      //   506: dup
      //   507: invokespecial <init> : ()V
      //   510: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	356	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	328	java/io/IOException
      //   133	139	324	finally
      //   165	174	356	com/google/protobuf/InvalidProtocolBufferException
      //   165	174	328	java/io/IOException
      //   165	174	324	finally
      //   177	195	356	com/google/protobuf/InvalidProtocolBufferException
      //   177	195	328	java/io/IOException
      //   177	195	324	finally
      //   200	215	356	com/google/protobuf/InvalidProtocolBufferException
      //   200	215	328	java/io/IOException
      //   200	215	324	finally
      //   219	239	356	com/google/protobuf/InvalidProtocolBufferException
      //   219	239	328	java/io/IOException
      //   219	239	324	finally
      //   242	250	356	com/google/protobuf/InvalidProtocolBufferException
      //   242	250	328	java/io/IOException
      //   242	250	324	finally
      //   253	271	356	com/google/protobuf/InvalidProtocolBufferException
      //   253	271	328	java/io/IOException
      //   253	271	324	finally
      //   276	291	356	com/google/protobuf/InvalidProtocolBufferException
      //   276	291	328	java/io/IOException
      //   276	291	324	finally
      //   295	315	356	com/google/protobuf/InvalidProtocolBufferException
      //   295	315	328	java/io/IOException
      //   295	315	324	finally
      //   329	356	324	finally
      //   357	372	324	finally
    }
    
    public StructuredQuery.FieldReference getField() {
      StructuredQuery.FieldReference fieldReference1 = this.field_;
      StructuredQuery.FieldReference fieldReference2 = fieldReference1;
      if (fieldReference1 == null)
        fieldReference2 = StructuredQuery.FieldReference.getDefaultInstance(); 
      return fieldReference2;
    }
    
    public Operator getOp() {
      Operator operator1 = Operator.forNumber(this.op_);
      Operator operator2 = operator1;
      if (operator1 == null)
        operator2 = Operator.UNRECOGNIZED; 
      return operator2;
    }
    
    public int getOpValue() {
      return this.op_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.field_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getField()); 
      i = j;
      if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber())
        i = j + CodedOutputStream.computeEnumSize(2, this.op_); 
      j = i;
      if (this.value_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getValue()); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public Value getValue() {
      Value value1 = this.value_;
      Value value2 = value1;
      if (value1 == null)
        value2 = Value.getDefaultInstance(); 
      return value2;
    }
    
    public boolean hasField() {
      boolean bool;
      if (this.field_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasValue() {
      boolean bool;
      if (this.value_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.field_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getField()); 
      if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(2, this.op_); 
      if (this.value_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getValue()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldFilter, Builder> implements StructuredQuery.FieldFilterOrBuilder {
      private Builder() {
        super(StructuredQuery.FieldFilter.DEFAULT_INSTANCE);
      }
      
      public Builder clearField() {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).clearField();
        return this;
      }
      
      public Builder clearOp() {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).clearOp();
        return this;
      }
      
      public Builder clearValue() {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).clearValue();
        return this;
      }
      
      public StructuredQuery.FieldReference getField() {
        return ((StructuredQuery.FieldFilter)this.instance).getField();
      }
      
      public StructuredQuery.FieldFilter.Operator getOp() {
        return ((StructuredQuery.FieldFilter)this.instance).getOp();
      }
      
      public int getOpValue() {
        return ((StructuredQuery.FieldFilter)this.instance).getOpValue();
      }
      
      public Value getValue() {
        return ((StructuredQuery.FieldFilter)this.instance).getValue();
      }
      
      public boolean hasField() {
        return ((StructuredQuery.FieldFilter)this.instance).hasField();
      }
      
      public boolean hasValue() {
        return ((StructuredQuery.FieldFilter)this.instance).hasValue();
      }
      
      public Builder mergeField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).mergeField(param2FieldReference);
        return this;
      }
      
      public Builder mergeValue(Value param2Value) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).mergeValue(param2Value);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setField(param2Builder);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setField(param2FieldReference);
        return this;
      }
      
      public Builder setOp(StructuredQuery.FieldFilter.Operator param2Operator) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setOp(param2Operator);
        return this;
      }
      
      public Builder setOpValue(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setOpValue(param2Int);
        return this;
      }
      
      public Builder setValue(Value.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setValue(param2Builder);
        return this;
      }
      
      public Builder setValue(Value param2Value) {
        copyOnWrite();
        ((StructuredQuery.FieldFilter)this.instance).setValue(param2Value);
        return this;
      }
    }
    
    public enum Operator implements Internal.EnumLite {
      ARRAY_CONTAINS(0),
      ARRAY_CONTAINS_ANY(0),
      EQUAL(0),
      GREATER_THAN(0),
      GREATER_THAN_OR_EQUAL(0),
      IN(0),
      LESS_THAN(0),
      LESS_THAN_OR_EQUAL(0),
      OPERATOR_UNSPECIFIED(0),
      UNRECOGNIZED(0);
      
      public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
      
      public static final int ARRAY_CONTAINS_VALUE = 7;
      
      public static final int EQUAL_VALUE = 5;
      
      public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
      
      public static final int GREATER_THAN_VALUE = 3;
      
      public static final int IN_VALUE = 8;
      
      public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
      
      public static final int LESS_THAN_VALUE = 1;
      
      public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
      
      private static final Internal.EnumLiteMap<Operator> internalValueMap;
      
      private final int value;
      
      static {
        EQUAL = new Operator("EQUAL", 5, 5);
        ARRAY_CONTAINS = new Operator("ARRAY_CONTAINS", 6, 7);
        IN = new Operator("IN", 7, 8);
        ARRAY_CONTAINS_ANY = new Operator("ARRAY_CONTAINS_ANY", 8, 9);
        UNRECOGNIZED = new Operator("UNRECOGNIZED", 9, -1);
        $VALUES = new Operator[] { OPERATOR_UNSPECIFIED, LESS_THAN, LESS_THAN_OR_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, EQUAL, ARRAY_CONTAINS, IN, ARRAY_CONTAINS_ANY, UNRECOGNIZED };
        internalValueMap = new Internal.EnumLiteMap<Operator>() {
            public StructuredQuery.FieldFilter.Operator findValueByNumber(int param3Int) {
              return StructuredQuery.FieldFilter.Operator.forNumber(param3Int);
            }
          };
      }
      
      Operator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static Operator forNumber(int param2Int) {
        switch (param2Int) {
          default:
            return null;
          case 9:
            return ARRAY_CONTAINS_ANY;
          case 8:
            return IN;
          case 7:
            return ARRAY_CONTAINS;
          case 5:
            return EQUAL;
          case 4:
            return GREATER_THAN_OR_EQUAL;
          case 3:
            return GREATER_THAN;
          case 2:
            return LESS_THAN_OR_EQUAL;
          case 1:
            return LESS_THAN;
          case 0:
            break;
        } 
        return OPERATOR_UNSPECIFIED;
      }
      
      public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<Operator> {
      public StructuredQuery.FieldFilter.Operator findValueByNumber(int param2Int) {
        return StructuredQuery.FieldFilter.Operator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldFilter, FieldFilter.Builder> implements FieldFilterOrBuilder {
    private Builder() {
      super(StructuredQuery.FieldFilter.DEFAULT_INSTANCE);
    }
    
    public Builder clearField() {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).clearField();
      return this;
    }
    
    public Builder clearOp() {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).clearOp();
      return this;
    }
    
    public Builder clearValue() {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).clearValue();
      return this;
    }
    
    public StructuredQuery.FieldReference getField() {
      return ((StructuredQuery.FieldFilter)this.instance).getField();
    }
    
    public StructuredQuery.FieldFilter.Operator getOp() {
      return ((StructuredQuery.FieldFilter)this.instance).getOp();
    }
    
    public int getOpValue() {
      return ((StructuredQuery.FieldFilter)this.instance).getOpValue();
    }
    
    public Value getValue() {
      return ((StructuredQuery.FieldFilter)this.instance).getValue();
    }
    
    public boolean hasField() {
      return ((StructuredQuery.FieldFilter)this.instance).hasField();
    }
    
    public boolean hasValue() {
      return ((StructuredQuery.FieldFilter)this.instance).hasValue();
    }
    
    public Builder mergeField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).mergeField(param1FieldReference);
      return this;
    }
    
    public Builder mergeValue(Value param1Value) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).mergeValue(param1Value);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setField(param1Builder);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setField(param1FieldReference);
      return this;
    }
    
    public Builder setOp(StructuredQuery.FieldFilter.Operator param1Operator) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setOp(param1Operator);
      return this;
    }
    
    public Builder setOpValue(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setOpValue(param1Int);
      return this;
    }
    
    public Builder setValue(Value.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setValue(param1Builder);
      return this;
    }
    
    public Builder setValue(Value param1Value) {
      copyOnWrite();
      ((StructuredQuery.FieldFilter)this.instance).setValue(param1Value);
      return this;
    }
  }
  
  public enum Operator implements Internal.EnumLite {
    ARRAY_CONTAINS(0),
    ARRAY_CONTAINS_ANY(0),
    EQUAL(0),
    GREATER_THAN(0),
    GREATER_THAN_OR_EQUAL(0),
    IN(0),
    LESS_THAN(0),
    LESS_THAN_OR_EQUAL(0),
    OPERATOR_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
    
    public static final int ARRAY_CONTAINS_VALUE = 7;
    
    public static final int EQUAL_VALUE = 5;
    
    public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
    
    public static final int GREATER_THAN_VALUE = 3;
    
    public static final int IN_VALUE = 8;
    
    public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
    
    public static final int LESS_THAN_VALUE = 1;
    
    public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Operator> internalValueMap;
    
    private final int value;
    
    static {
      GREATER_THAN = new Operator("GREATER_THAN", 3, 3);
      GREATER_THAN_OR_EQUAL = new Operator("GREATER_THAN_OR_EQUAL", 4, 4);
      EQUAL = new Operator("EQUAL", 5, 5);
      ARRAY_CONTAINS = new Operator("ARRAY_CONTAINS", 6, 7);
      IN = new Operator("IN", 7, 8);
      ARRAY_CONTAINS_ANY = new Operator("ARRAY_CONTAINS_ANY", 8, 9);
      UNRECOGNIZED = new Operator("UNRECOGNIZED", 9, -1);
      $VALUES = new Operator[] { OPERATOR_UNSPECIFIED, LESS_THAN, LESS_THAN_OR_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, EQUAL, ARRAY_CONTAINS, IN, ARRAY_CONTAINS_ANY, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Operator>() {
          public StructuredQuery.FieldFilter.Operator findValueByNumber(int param3Int) {
            return StructuredQuery.FieldFilter.Operator.forNumber(param3Int);
          }
        };
    }
    
    Operator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Operator forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 9:
          return ARRAY_CONTAINS_ANY;
        case 8:
          return IN;
        case 7:
          return ARRAY_CONTAINS;
        case 5:
          return EQUAL;
        case 4:
          return GREATER_THAN_OR_EQUAL;
        case 3:
          return GREATER_THAN;
        case 2:
          return LESS_THAN_OR_EQUAL;
        case 1:
          return LESS_THAN;
        case 0:
          break;
      } 
      return OPERATOR_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<FieldFilter.Operator> {
    public StructuredQuery.FieldFilter.Operator findValueByNumber(int param1Int) {
      return StructuredQuery.FieldFilter.Operator.forNumber(param1Int);
    }
  }
  
  public static interface FieldFilterOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.FieldReference getField();
    
    StructuredQuery.FieldFilter.Operator getOp();
    
    int getOpValue();
    
    Value getValue();
    
    boolean hasField();
    
    boolean hasValue();
  }
  
  public static final class FieldReference extends GeneratedMessageLite<FieldReference, FieldReference.Builder> implements FieldReferenceOrBuilder {
    private static final FieldReference DEFAULT_INSTANCE = new FieldReference();
    
    public static final int FIELD_PATH_FIELD_NUMBER = 2;
    
    private static volatile Parser<FieldReference> PARSER;
    
    private String fieldPath_ = "";
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearFieldPath() {
      this.fieldPath_ = getDefaultInstance().getFieldPath();
    }
    
    public static FieldReference getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(FieldReference param1FieldReference) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1FieldReference);
    }
    
    public static FieldReference parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (FieldReference)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldReference parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldReference)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldReference parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static FieldReference parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static FieldReference parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static FieldReference parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldReference parseFrom(InputStream param1InputStream) throws IOException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static FieldReference parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static FieldReference parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static FieldReference parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (FieldReference)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<FieldReference> parser() {
      return DEFAULT_INSTANCE.getParserForType();
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
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 296, 2 -> 292, 3 -> 290, 4 -> 281, 5 -> 229, 6 -> 110, 7 -> 225, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firestore/v1/StructuredQuery$FieldReference
      //   72: monitorenter
      //   73: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firestore/v1/StructuredQuery$FieldReference.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firestore/v1/StructuredQuery$FieldReference
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firestore/v1/StructuredQuery$FieldReference
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.PARSER : Lcom/google/protobuf/Parser;
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
      //   125: ifne -> 225
      //   128: aload_1
      //   129: invokevirtual readTag : ()I
      //   132: istore #5
      //   134: iload #5
      //   136: ifeq -> 169
      //   139: iload #5
      //   141: bipush #18
      //   143: if_icmpeq -> 158
      //   146: aload_1
      //   147: iload #5
      //   149: invokevirtual skipField : (I)Z
      //   152: ifne -> 123
      //   155: goto -> 169
      //   158: aload_0
      //   159: aload_1
      //   160: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
      //   163: putfield fieldPath_ : Ljava/lang/String;
      //   166: goto -> 123
      //   169: iconst_1
      //   170: istore #4
      //   172: goto -> 123
      //   175: astore_1
      //   176: goto -> 223
      //   179: astore_1
      //   180: new java/lang/RuntimeException
      //   183: astore_2
      //   184: new com/google/protobuf/InvalidProtocolBufferException
      //   187: astore_3
      //   188: aload_3
      //   189: aload_1
      //   190: invokevirtual getMessage : ()Ljava/lang/String;
      //   193: invokespecial <init> : (Ljava/lang/String;)V
      //   196: aload_2
      //   197: aload_3
      //   198: aload_0
      //   199: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   202: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   205: aload_2
      //   206: athrow
      //   207: astore_2
      //   208: new java/lang/RuntimeException
      //   211: astore_1
      //   212: aload_1
      //   213: aload_2
      //   214: aload_0
      //   215: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   218: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   221: aload_1
      //   222: athrow
      //   223: aload_1
      //   224: athrow
      //   225: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   228: areturn
      //   229: aload_2
      //   230: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   233: astore_1
      //   234: aload_3
      //   235: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   238: astore_2
      //   239: aload_0
      //   240: aload_1
      //   241: aload_0
      //   242: getfield fieldPath_ : Ljava/lang/String;
      //   245: invokevirtual isEmpty : ()Z
      //   248: iconst_1
      //   249: ixor
      //   250: aload_0
      //   251: getfield fieldPath_ : Ljava/lang/String;
      //   254: iconst_1
      //   255: aload_2
      //   256: getfield fieldPath_ : Ljava/lang/String;
      //   259: invokevirtual isEmpty : ()Z
      //   262: ixor
      //   263: aload_2
      //   264: getfield fieldPath_ : Ljava/lang/String;
      //   267: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
      //   272: putfield fieldPath_ : Ljava/lang/String;
      //   275: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   278: astore_1
      //   279: aload_0
      //   280: areturn
      //   281: new com/google/firestore/v1/StructuredQuery$FieldReference$Builder
      //   284: dup
      //   285: aconst_null
      //   286: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   289: areturn
      //   290: aconst_null
      //   291: areturn
      //   292: getstatic com/google/firestore/v1/StructuredQuery$FieldReference.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   295: areturn
      //   296: new com/google/firestore/v1/StructuredQuery$FieldReference
      //   299: dup
      //   300: invokespecial <init> : ()V
      //   303: areturn
      // Exception table:
      //   from	to	target	type
      //   73	94	100	finally
      //   94	97	100	finally
      //   101	104	100	finally
      //   128	134	207	com/google/protobuf/InvalidProtocolBufferException
      //   128	134	179	java/io/IOException
      //   128	134	175	finally
      //   146	155	207	com/google/protobuf/InvalidProtocolBufferException
      //   146	155	179	java/io/IOException
      //   146	155	175	finally
      //   158	166	207	com/google/protobuf/InvalidProtocolBufferException
      //   158	166	179	java/io/IOException
      //   158	166	175	finally
      //   180	207	175	finally
      //   208	223	175	finally
    }
    
    public String getFieldPath() {
      return this.fieldPath_;
    }
    
    public ByteString getFieldPathBytes() {
      return ByteString.copyFromUtf8(this.fieldPath_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!this.fieldPath_.isEmpty())
        i = 0 + CodedOutputStream.computeStringSize(2, getFieldPath()); 
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!this.fieldPath_.isEmpty())
        param1CodedOutputStream.writeString(2, getFieldPath()); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<FieldReference, Builder> implements StructuredQuery.FieldReferenceOrBuilder {
      private Builder() {
        super(StructuredQuery.FieldReference.DEFAULT_INSTANCE);
      }
      
      public Builder clearFieldPath() {
        copyOnWrite();
        ((StructuredQuery.FieldReference)this.instance).clearFieldPath();
        return this;
      }
      
      public String getFieldPath() {
        return ((StructuredQuery.FieldReference)this.instance).getFieldPath();
      }
      
      public ByteString getFieldPathBytes() {
        return ((StructuredQuery.FieldReference)this.instance).getFieldPathBytes();
      }
      
      public Builder setFieldPath(String param2String) {
        copyOnWrite();
        ((StructuredQuery.FieldReference)this.instance).setFieldPath(param2String);
        return this;
      }
      
      public Builder setFieldPathBytes(ByteString param2ByteString) {
        copyOnWrite();
        ((StructuredQuery.FieldReference)this.instance).setFieldPathBytes(param2ByteString);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<FieldReference, FieldReference.Builder> implements FieldReferenceOrBuilder {
    private Builder() {
      super(StructuredQuery.FieldReference.DEFAULT_INSTANCE);
    }
    
    public Builder clearFieldPath() {
      copyOnWrite();
      ((StructuredQuery.FieldReference)this.instance).clearFieldPath();
      return this;
    }
    
    public String getFieldPath() {
      return ((StructuredQuery.FieldReference)this.instance).getFieldPath();
    }
    
    public ByteString getFieldPathBytes() {
      return ((StructuredQuery.FieldReference)this.instance).getFieldPathBytes();
    }
    
    public Builder setFieldPath(String param1String) {
      copyOnWrite();
      ((StructuredQuery.FieldReference)this.instance).setFieldPath(param1String);
      return this;
    }
    
    public Builder setFieldPathBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((StructuredQuery.FieldReference)this.instance).setFieldPathBytes(param1ByteString);
      return this;
    }
  }
  
  public static interface FieldReferenceOrBuilder extends MessageLiteOrBuilder {
    String getFieldPath();
    
    ByteString getFieldPathBytes();
  }
  
  public static final class Filter extends GeneratedMessageLite<Filter, Filter.Builder> implements FilterOrBuilder {
    public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
    
    private static final Filter DEFAULT_INSTANCE = new Filter();
    
    public static final int FIELD_FILTER_FIELD_NUMBER = 2;
    
    private static volatile Parser<Filter> PARSER;
    
    public static final int UNARY_FILTER_FIELD_NUMBER = 3;
    
    private int filterTypeCase_ = 0;
    
    private Object filterType_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearCompositeFilter() {
      if (this.filterTypeCase_ == 1) {
        this.filterTypeCase_ = 0;
        this.filterType_ = null;
      } 
    }
    
    private void clearFieldFilter() {
      if (this.filterTypeCase_ == 2) {
        this.filterTypeCase_ = 0;
        this.filterType_ = null;
      } 
    }
    
    private void clearFilterType() {
      this.filterTypeCase_ = 0;
      this.filterType_ = null;
    }
    
    private void clearUnaryFilter() {
      if (this.filterTypeCase_ == 3) {
        this.filterTypeCase_ = 0;
        this.filterType_ = null;
      } 
    }
    
    public static Filter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeCompositeFilter(StructuredQuery.CompositeFilter param1CompositeFilter) {
      if (this.filterTypeCase_ == 1 && this.filterType_ != StructuredQuery.CompositeFilter.getDefaultInstance()) {
        this.filterType_ = ((StructuredQuery.CompositeFilter.Builder)StructuredQuery.CompositeFilter.newBuilder((StructuredQuery.CompositeFilter)this.filterType_).mergeFrom(param1CompositeFilter)).buildPartial();
      } else {
        this.filterType_ = param1CompositeFilter;
      } 
      this.filterTypeCase_ = 1;
    }
    
    private void mergeFieldFilter(StructuredQuery.FieldFilter param1FieldFilter) {
      if (this.filterTypeCase_ == 2 && this.filterType_ != StructuredQuery.FieldFilter.getDefaultInstance()) {
        this.filterType_ = ((StructuredQuery.FieldFilter.Builder)StructuredQuery.FieldFilter.newBuilder((StructuredQuery.FieldFilter)this.filterType_).mergeFrom(param1FieldFilter)).buildPartial();
      } else {
        this.filterType_ = param1FieldFilter;
      } 
      this.filterTypeCase_ = 2;
    }
    
    private void mergeUnaryFilter(StructuredQuery.UnaryFilter param1UnaryFilter) {
      if (this.filterTypeCase_ == 3 && this.filterType_ != StructuredQuery.UnaryFilter.getDefaultInstance()) {
        this.filterType_ = ((StructuredQuery.UnaryFilter.Builder)StructuredQuery.UnaryFilter.newBuilder((StructuredQuery.UnaryFilter)this.filterType_).mergeFrom(param1UnaryFilter)).buildPartial();
      } else {
        this.filterType_ = param1UnaryFilter;
      } 
      this.filterTypeCase_ = 3;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Filter param1Filter) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Filter);
    }
    
    public static Filter parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Filter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Filter parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Filter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Filter parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Filter parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Filter parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Filter parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Filter parseFrom(InputStream param1InputStream) throws IOException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Filter parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Filter parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Filter parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Filter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Filter> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setCompositeFilter(StructuredQuery.CompositeFilter.Builder param1Builder) {
      this.filterType_ = param1Builder.build();
      this.filterTypeCase_ = 1;
    }
    
    private void setCompositeFilter(StructuredQuery.CompositeFilter param1CompositeFilter) {
      if (param1CompositeFilter != null) {
        this.filterType_ = param1CompositeFilter;
        this.filterTypeCase_ = 1;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setFieldFilter(StructuredQuery.FieldFilter.Builder param1Builder) {
      this.filterType_ = param1Builder.build();
      this.filterTypeCase_ = 2;
    }
    
    private void setFieldFilter(StructuredQuery.FieldFilter param1FieldFilter) {
      if (param1FieldFilter != null) {
        this.filterType_ = param1FieldFilter;
        this.filterTypeCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setUnaryFilter(StructuredQuery.UnaryFilter.Builder param1Builder) {
      this.filterType_ = param1Builder.build();
      this.filterTypeCase_ = 3;
    }
    
    private void setUnaryFilter(StructuredQuery.UnaryFilter param1UnaryFilter) {
      if (param1UnaryFilter != null) {
        this.filterType_ = param1UnaryFilter;
        this.filterTypeCase_ = 3;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   25: iload #4
      //   27: tableswitch default -> 72, 1 -> 681, 2 -> 677, 3 -> 675, 4 -> 666, 5 -> 458, 6 -> 126, 7 -> 454, 8 -> 80
      //   72: new java/lang/UnsupportedOperationException
      //   75: dup
      //   76: invokespecial <init> : ()V
      //   79: athrow
      //   80: getstatic com/google/firestore/v1/StructuredQuery$Filter.PARSER : Lcom/google/protobuf/Parser;
      //   83: ifnonnull -> 122
      //   86: ldc com/google/firestore/v1/StructuredQuery$Filter
      //   88: monitorenter
      //   89: getstatic com/google/firestore/v1/StructuredQuery$Filter.PARSER : Lcom/google/protobuf/Parser;
      //   92: ifnonnull -> 110
      //   95: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   98: astore_1
      //   99: aload_1
      //   100: getstatic com/google/firestore/v1/StructuredQuery$Filter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Filter;
      //   103: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   106: aload_1
      //   107: putstatic com/google/firestore/v1/StructuredQuery$Filter.PARSER : Lcom/google/protobuf/Parser;
      //   110: ldc com/google/firestore/v1/StructuredQuery$Filter
      //   112: monitorexit
      //   113: goto -> 122
      //   116: astore_1
      //   117: ldc com/google/firestore/v1/StructuredQuery$Filter
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: getstatic com/google/firestore/v1/StructuredQuery$Filter.PARSER : Lcom/google/protobuf/Parser;
      //   125: areturn
      //   126: aload_2
      //   127: checkcast com/google/protobuf/CodedInputStream
      //   130: astore_2
      //   131: aload_3
      //   132: checkcast com/google/protobuf/ExtensionRegistryLite
      //   135: astore_3
      //   136: iload #9
      //   138: ifne -> 454
      //   141: aload_2
      //   142: invokevirtual readTag : ()I
      //   145: istore #4
      //   147: iload #4
      //   149: ifeq -> 398
      //   152: iload #4
      //   154: bipush #10
      //   156: if_icmpeq -> 327
      //   159: iload #4
      //   161: bipush #18
      //   163: if_icmpeq -> 256
      //   166: iload #4
      //   168: bipush #26
      //   170: if_icmpeq -> 185
      //   173: aload_2
      //   174: iload #4
      //   176: invokevirtual skipField : (I)Z
      //   179: ifne -> 136
      //   182: goto -> 398
      //   185: aload_0
      //   186: getfield filterTypeCase_ : I
      //   189: iconst_3
      //   190: if_icmpne -> 210
      //   193: aload_0
      //   194: getfield filterType_ : Ljava/lang/Object;
      //   197: checkcast com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   200: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   203: checkcast com/google/firestore/v1/StructuredQuery$UnaryFilter$Builder
      //   206: astore_1
      //   207: goto -> 212
      //   210: aconst_null
      //   211: astore_1
      //   212: aload_0
      //   213: aload_2
      //   214: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   217: aload_3
      //   218: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   221: putfield filterType_ : Ljava/lang/Object;
      //   224: aload_1
      //   225: ifnull -> 248
      //   228: aload_1
      //   229: aload_0
      //   230: getfield filterType_ : Ljava/lang/Object;
      //   233: checkcast com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   236: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   239: pop
      //   240: aload_0
      //   241: aload_1
      //   242: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   245: putfield filterType_ : Ljava/lang/Object;
      //   248: aload_0
      //   249: iconst_3
      //   250: putfield filterTypeCase_ : I
      //   253: goto -> 136
      //   256: aload_0
      //   257: getfield filterTypeCase_ : I
      //   260: iconst_2
      //   261: if_icmpne -> 281
      //   264: aload_0
      //   265: getfield filterType_ : Ljava/lang/Object;
      //   268: checkcast com/google/firestore/v1/StructuredQuery$FieldFilter
      //   271: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   274: checkcast com/google/firestore/v1/StructuredQuery$FieldFilter$Builder
      //   277: astore_1
      //   278: goto -> 283
      //   281: aconst_null
      //   282: astore_1
      //   283: aload_0
      //   284: aload_2
      //   285: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   288: aload_3
      //   289: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   292: putfield filterType_ : Ljava/lang/Object;
      //   295: aload_1
      //   296: ifnull -> 319
      //   299: aload_1
      //   300: aload_0
      //   301: getfield filterType_ : Ljava/lang/Object;
      //   304: checkcast com/google/firestore/v1/StructuredQuery$FieldFilter
      //   307: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   310: pop
      //   311: aload_0
      //   312: aload_1
      //   313: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   316: putfield filterType_ : Ljava/lang/Object;
      //   319: aload_0
      //   320: iconst_2
      //   321: putfield filterTypeCase_ : I
      //   324: goto -> 136
      //   327: aload_0
      //   328: getfield filterTypeCase_ : I
      //   331: iconst_1
      //   332: if_icmpne -> 352
      //   335: aload_0
      //   336: getfield filterType_ : Ljava/lang/Object;
      //   339: checkcast com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   342: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   345: checkcast com/google/firestore/v1/StructuredQuery$CompositeFilter$Builder
      //   348: astore_1
      //   349: goto -> 354
      //   352: aconst_null
      //   353: astore_1
      //   354: aload_0
      //   355: aload_2
      //   356: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   359: aload_3
      //   360: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   363: putfield filterType_ : Ljava/lang/Object;
      //   366: aload_1
      //   367: ifnull -> 390
      //   370: aload_1
      //   371: aload_0
      //   372: getfield filterType_ : Ljava/lang/Object;
      //   375: checkcast com/google/firestore/v1/StructuredQuery$CompositeFilter
      //   378: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   381: pop
      //   382: aload_0
      //   383: aload_1
      //   384: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   387: putfield filterType_ : Ljava/lang/Object;
      //   390: aload_0
      //   391: iconst_1
      //   392: putfield filterTypeCase_ : I
      //   395: goto -> 136
      //   398: iconst_1
      //   399: istore #9
      //   401: goto -> 136
      //   404: astore_1
      //   405: goto -> 452
      //   408: astore_1
      //   409: new java/lang/RuntimeException
      //   412: astore_2
      //   413: new com/google/protobuf/InvalidProtocolBufferException
      //   416: astore_3
      //   417: aload_3
      //   418: aload_1
      //   419: invokevirtual getMessage : ()Ljava/lang/String;
      //   422: invokespecial <init> : (Ljava/lang/String;)V
      //   425: aload_2
      //   426: aload_3
      //   427: aload_0
      //   428: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   431: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   434: aload_2
      //   435: athrow
      //   436: astore_2
      //   437: new java/lang/RuntimeException
      //   440: astore_1
      //   441: aload_1
      //   442: aload_2
      //   443: aload_0
      //   444: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   447: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   450: aload_1
      //   451: athrow
      //   452: aload_1
      //   453: athrow
      //   454: getstatic com/google/firestore/v1/StructuredQuery$Filter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Filter;
      //   457: areturn
      //   458: aload_2
      //   459: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   462: astore_1
      //   463: aload_3
      //   464: checkcast com/google/firestore/v1/StructuredQuery$Filter
      //   467: astore_2
      //   468: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase : [I
      //   471: aload_2
      //   472: invokevirtual getFilterTypeCase : ()Lcom/google/firestore/v1/StructuredQuery$Filter$FilterTypeCase;
      //   475: invokevirtual ordinal : ()I
      //   478: iaload
      //   479: istore #9
      //   481: iload #9
      //   483: iconst_1
      //   484: if_icmpeq -> 605
      //   487: iload #9
      //   489: iconst_2
      //   490: if_icmpeq -> 567
      //   493: iload #9
      //   495: iconst_3
      //   496: if_icmpeq -> 529
      //   499: iload #9
      //   501: iconst_4
      //   502: if_icmpeq -> 508
      //   505: goto -> 640
      //   508: aload_0
      //   509: getfield filterTypeCase_ : I
      //   512: ifeq -> 518
      //   515: iconst_1
      //   516: istore #5
      //   518: aload_1
      //   519: iload #5
      //   521: invokeinterface visitOneofNotSet : (Z)V
      //   526: goto -> 640
      //   529: iload #6
      //   531: istore #5
      //   533: aload_0
      //   534: getfield filterTypeCase_ : I
      //   537: iconst_3
      //   538: if_icmpne -> 544
      //   541: iconst_1
      //   542: istore #5
      //   544: aload_0
      //   545: aload_1
      //   546: iload #5
      //   548: aload_0
      //   549: getfield filterType_ : Ljava/lang/Object;
      //   552: aload_2
      //   553: getfield filterType_ : Ljava/lang/Object;
      //   556: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   561: putfield filterType_ : Ljava/lang/Object;
      //   564: goto -> 640
      //   567: iload #7
      //   569: istore #5
      //   571: aload_0
      //   572: getfield filterTypeCase_ : I
      //   575: iconst_2
      //   576: if_icmpne -> 582
      //   579: iconst_1
      //   580: istore #5
      //   582: aload_0
      //   583: aload_1
      //   584: iload #5
      //   586: aload_0
      //   587: getfield filterType_ : Ljava/lang/Object;
      //   590: aload_2
      //   591: getfield filterType_ : Ljava/lang/Object;
      //   594: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   599: putfield filterType_ : Ljava/lang/Object;
      //   602: goto -> 640
      //   605: iload #8
      //   607: istore #5
      //   609: aload_0
      //   610: getfield filterTypeCase_ : I
      //   613: iconst_1
      //   614: if_icmpne -> 620
      //   617: iconst_1
      //   618: istore #5
      //   620: aload_0
      //   621: aload_1
      //   622: iload #5
      //   624: aload_0
      //   625: getfield filterType_ : Ljava/lang/Object;
      //   628: aload_2
      //   629: getfield filterType_ : Ljava/lang/Object;
      //   632: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   637: putfield filterType_ : Ljava/lang/Object;
      //   640: aload_1
      //   641: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   644: if_acmpne -> 664
      //   647: aload_2
      //   648: getfield filterTypeCase_ : I
      //   651: istore #9
      //   653: iload #9
      //   655: ifeq -> 664
      //   658: aload_0
      //   659: iload #9
      //   661: putfield filterTypeCase_ : I
      //   664: aload_0
      //   665: areturn
      //   666: new com/google/firestore/v1/StructuredQuery$Filter$Builder
      //   669: dup
      //   670: aconst_null
      //   671: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   674: areturn
      //   675: aconst_null
      //   676: areturn
      //   677: getstatic com/google/firestore/v1/StructuredQuery$Filter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Filter;
      //   680: areturn
      //   681: new com/google/firestore/v1/StructuredQuery$Filter
      //   684: dup
      //   685: invokespecial <init> : ()V
      //   688: areturn
      // Exception table:
      //   from	to	target	type
      //   89	110	116	finally
      //   110	113	116	finally
      //   117	120	116	finally
      //   141	147	436	com/google/protobuf/InvalidProtocolBufferException
      //   141	147	408	java/io/IOException
      //   141	147	404	finally
      //   173	182	436	com/google/protobuf/InvalidProtocolBufferException
      //   173	182	408	java/io/IOException
      //   173	182	404	finally
      //   185	207	436	com/google/protobuf/InvalidProtocolBufferException
      //   185	207	408	java/io/IOException
      //   185	207	404	finally
      //   212	224	436	com/google/protobuf/InvalidProtocolBufferException
      //   212	224	408	java/io/IOException
      //   212	224	404	finally
      //   228	248	436	com/google/protobuf/InvalidProtocolBufferException
      //   228	248	408	java/io/IOException
      //   228	248	404	finally
      //   248	253	436	com/google/protobuf/InvalidProtocolBufferException
      //   248	253	408	java/io/IOException
      //   248	253	404	finally
      //   256	278	436	com/google/protobuf/InvalidProtocolBufferException
      //   256	278	408	java/io/IOException
      //   256	278	404	finally
      //   283	295	436	com/google/protobuf/InvalidProtocolBufferException
      //   283	295	408	java/io/IOException
      //   283	295	404	finally
      //   299	319	436	com/google/protobuf/InvalidProtocolBufferException
      //   299	319	408	java/io/IOException
      //   299	319	404	finally
      //   319	324	436	com/google/protobuf/InvalidProtocolBufferException
      //   319	324	408	java/io/IOException
      //   319	324	404	finally
      //   327	349	436	com/google/protobuf/InvalidProtocolBufferException
      //   327	349	408	java/io/IOException
      //   327	349	404	finally
      //   354	366	436	com/google/protobuf/InvalidProtocolBufferException
      //   354	366	408	java/io/IOException
      //   354	366	404	finally
      //   370	390	436	com/google/protobuf/InvalidProtocolBufferException
      //   370	390	408	java/io/IOException
      //   370	390	404	finally
      //   390	395	436	com/google/protobuf/InvalidProtocolBufferException
      //   390	395	408	java/io/IOException
      //   390	395	404	finally
      //   409	436	404	finally
      //   437	452	404	finally
    }
    
    public StructuredQuery.CompositeFilter getCompositeFilter() {
      return (this.filterTypeCase_ == 1) ? (StructuredQuery.CompositeFilter)this.filterType_ : StructuredQuery.CompositeFilter.getDefaultInstance();
    }
    
    public StructuredQuery.FieldFilter getFieldFilter() {
      return (this.filterTypeCase_ == 2) ? (StructuredQuery.FieldFilter)this.filterType_ : StructuredQuery.FieldFilter.getDefaultInstance();
    }
    
    public FilterTypeCase getFilterTypeCase() {
      return FilterTypeCase.forNumber(this.filterTypeCase_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.filterTypeCase_ == 1)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.filterType_); 
      i = j;
      if (this.filterTypeCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.filterType_); 
      j = i;
      if (this.filterTypeCase_ == 3)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.filterType_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public StructuredQuery.UnaryFilter getUnaryFilter() {
      return (this.filterTypeCase_ == 3) ? (StructuredQuery.UnaryFilter)this.filterType_ : StructuredQuery.UnaryFilter.getDefaultInstance();
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.filterTypeCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.filterType_); 
      if (this.filterTypeCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.filterType_); 
      if (this.filterTypeCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.filterType_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Filter, Builder> implements StructuredQuery.FilterOrBuilder {
      private Builder() {
        super(StructuredQuery.Filter.DEFAULT_INSTANCE);
      }
      
      public Builder clearCompositeFilter() {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).clearCompositeFilter();
        return this;
      }
      
      public Builder clearFieldFilter() {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).clearFieldFilter();
        return this;
      }
      
      public Builder clearFilterType() {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).clearFilterType();
        return this;
      }
      
      public Builder clearUnaryFilter() {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).clearUnaryFilter();
        return this;
      }
      
      public StructuredQuery.CompositeFilter getCompositeFilter() {
        return ((StructuredQuery.Filter)this.instance).getCompositeFilter();
      }
      
      public StructuredQuery.FieldFilter getFieldFilter() {
        return ((StructuredQuery.Filter)this.instance).getFieldFilter();
      }
      
      public StructuredQuery.Filter.FilterTypeCase getFilterTypeCase() {
        return ((StructuredQuery.Filter)this.instance).getFilterTypeCase();
      }
      
      public StructuredQuery.UnaryFilter getUnaryFilter() {
        return ((StructuredQuery.Filter)this.instance).getUnaryFilter();
      }
      
      public Builder mergeCompositeFilter(StructuredQuery.CompositeFilter param2CompositeFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).mergeCompositeFilter(param2CompositeFilter);
        return this;
      }
      
      public Builder mergeFieldFilter(StructuredQuery.FieldFilter param2FieldFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).mergeFieldFilter(param2FieldFilter);
        return this;
      }
      
      public Builder mergeUnaryFilter(StructuredQuery.UnaryFilter param2UnaryFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).mergeUnaryFilter(param2UnaryFilter);
        return this;
      }
      
      public Builder setCompositeFilter(StructuredQuery.CompositeFilter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setCompositeFilter(param2Builder);
        return this;
      }
      
      public Builder setCompositeFilter(StructuredQuery.CompositeFilter param2CompositeFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setCompositeFilter(param2CompositeFilter);
        return this;
      }
      
      public Builder setFieldFilter(StructuredQuery.FieldFilter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setFieldFilter(param2Builder);
        return this;
      }
      
      public Builder setFieldFilter(StructuredQuery.FieldFilter param2FieldFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setFieldFilter(param2FieldFilter);
        return this;
      }
      
      public Builder setUnaryFilter(StructuredQuery.UnaryFilter.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setUnaryFilter(param2Builder);
        return this;
      }
      
      public Builder setUnaryFilter(StructuredQuery.UnaryFilter param2UnaryFilter) {
        copyOnWrite();
        ((StructuredQuery.Filter)this.instance).setUnaryFilter(param2UnaryFilter);
        return this;
      }
    }
    
    public enum FilterTypeCase implements Internal.EnumLite {
      COMPOSITE_FILTER(1),
      FIELD_FILTER(2),
      FILTERTYPE_NOT_SET(2),
      UNARY_FILTER(3);
      
      private final int value;
      
      static {
      
      }
      
      FilterTypeCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static FilterTypeCase forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? ((param2Int != 3) ? null : UNARY_FILTER) : FIELD_FILTER) : COMPOSITE_FILTER) : FILTERTYPE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Filter, Filter.Builder> implements FilterOrBuilder {
    private Builder() {
      super(StructuredQuery.Filter.DEFAULT_INSTANCE);
    }
    
    public Builder clearCompositeFilter() {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).clearCompositeFilter();
      return this;
    }
    
    public Builder clearFieldFilter() {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).clearFieldFilter();
      return this;
    }
    
    public Builder clearFilterType() {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).clearFilterType();
      return this;
    }
    
    public Builder clearUnaryFilter() {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).clearUnaryFilter();
      return this;
    }
    
    public StructuredQuery.CompositeFilter getCompositeFilter() {
      return ((StructuredQuery.Filter)this.instance).getCompositeFilter();
    }
    
    public StructuredQuery.FieldFilter getFieldFilter() {
      return ((StructuredQuery.Filter)this.instance).getFieldFilter();
    }
    
    public StructuredQuery.Filter.FilterTypeCase getFilterTypeCase() {
      return ((StructuredQuery.Filter)this.instance).getFilterTypeCase();
    }
    
    public StructuredQuery.UnaryFilter getUnaryFilter() {
      return ((StructuredQuery.Filter)this.instance).getUnaryFilter();
    }
    
    public Builder mergeCompositeFilter(StructuredQuery.CompositeFilter param1CompositeFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).mergeCompositeFilter(param1CompositeFilter);
      return this;
    }
    
    public Builder mergeFieldFilter(StructuredQuery.FieldFilter param1FieldFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).mergeFieldFilter(param1FieldFilter);
      return this;
    }
    
    public Builder mergeUnaryFilter(StructuredQuery.UnaryFilter param1UnaryFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).mergeUnaryFilter(param1UnaryFilter);
      return this;
    }
    
    public Builder setCompositeFilter(StructuredQuery.CompositeFilter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setCompositeFilter(param1Builder);
      return this;
    }
    
    public Builder setCompositeFilter(StructuredQuery.CompositeFilter param1CompositeFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setCompositeFilter(param1CompositeFilter);
      return this;
    }
    
    public Builder setFieldFilter(StructuredQuery.FieldFilter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setFieldFilter(param1Builder);
      return this;
    }
    
    public Builder setFieldFilter(StructuredQuery.FieldFilter param1FieldFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setFieldFilter(param1FieldFilter);
      return this;
    }
    
    public Builder setUnaryFilter(StructuredQuery.UnaryFilter.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setUnaryFilter(param1Builder);
      return this;
    }
    
    public Builder setUnaryFilter(StructuredQuery.UnaryFilter param1UnaryFilter) {
      copyOnWrite();
      ((StructuredQuery.Filter)this.instance).setUnaryFilter(param1UnaryFilter);
      return this;
    }
  }
  
  public enum FilterTypeCase implements Internal.EnumLite {
    COMPOSITE_FILTER(1),
    FIELD_FILTER(2),
    FILTERTYPE_NOT_SET(2),
    UNARY_FILTER(3);
    
    private final int value;
    
    static {
      $VALUES = new FilterTypeCase[] { COMPOSITE_FILTER, FIELD_FILTER, UNARY_FILTER, FILTERTYPE_NOT_SET };
    }
    
    FilterTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static FilterTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : UNARY_FILTER) : FIELD_FILTER) : COMPOSITE_FILTER) : FILTERTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface FilterOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.CompositeFilter getCompositeFilter();
    
    StructuredQuery.FieldFilter getFieldFilter();
    
    StructuredQuery.Filter.FilterTypeCase getFilterTypeCase();
    
    StructuredQuery.UnaryFilter getUnaryFilter();
  }
  
  public static final class Order extends GeneratedMessageLite<Order, Order.Builder> implements OrderOrBuilder {
    private static final Order DEFAULT_INSTANCE = new Order();
    
    public static final int DIRECTION_FIELD_NUMBER = 2;
    
    public static final int FIELD_FIELD_NUMBER = 1;
    
    private static volatile Parser<Order> PARSER;
    
    private int direction_;
    
    private StructuredQuery.FieldReference field_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearDirection() {
      this.direction_ = 0;
    }
    
    private void clearField() {
      this.field_ = null;
    }
    
    public static Order getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeField(StructuredQuery.FieldReference param1FieldReference) {
      StructuredQuery.FieldReference fieldReference = this.field_;
      if (fieldReference != null && fieldReference != StructuredQuery.FieldReference.getDefaultInstance()) {
        this.field_ = (StructuredQuery.FieldReference)((StructuredQuery.FieldReference.Builder)StructuredQuery.FieldReference.newBuilder(this.field_).mergeFrom(param1FieldReference)).buildPartial();
      } else {
        this.field_ = param1FieldReference;
      } 
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Order param1Order) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Order);
    }
    
    public static Order parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Order)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Order parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Order)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Order parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Order parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Order parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Order parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Order parseFrom(InputStream param1InputStream) throws IOException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Order parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Order parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Order parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Order)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Order> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setDirection(StructuredQuery.Direction param1Direction) {
      if (param1Direction != null) {
        this.direction_ = param1Direction.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setDirectionValue(int param1Int) {
      this.direction_ = param1Int;
    }
    
    private void setField(StructuredQuery.FieldReference.Builder param1Builder) {
      this.field_ = (StructuredQuery.FieldReference)param1Builder.build();
    }
    
    private void setField(StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        this.field_ = param1FieldReference;
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: istore #4
      //   10: iconst_0
      //   11: istore #5
      //   13: iconst_0
      //   14: istore #6
      //   16: iload #4
      //   18: tableswitch default -> 64, 1 -> 410, 2 -> 406, 3 -> 404, 4 -> 395, 5 -> 306, 6 -> 118, 7 -> 302, 8 -> 72
      //   64: new java/lang/UnsupportedOperationException
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: athrow
      //   72: getstatic com/google/firestore/v1/StructuredQuery$Order.PARSER : Lcom/google/protobuf/Parser;
      //   75: ifnonnull -> 114
      //   78: ldc com/google/firestore/v1/StructuredQuery$Order
      //   80: monitorenter
      //   81: getstatic com/google/firestore/v1/StructuredQuery$Order.PARSER : Lcom/google/protobuf/Parser;
      //   84: ifnonnull -> 102
      //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   90: astore_1
      //   91: aload_1
      //   92: getstatic com/google/firestore/v1/StructuredQuery$Order.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Order;
      //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   98: aload_1
      //   99: putstatic com/google/firestore/v1/StructuredQuery$Order.PARSER : Lcom/google/protobuf/Parser;
      //   102: ldc com/google/firestore/v1/StructuredQuery$Order
      //   104: monitorexit
      //   105: goto -> 114
      //   108: astore_1
      //   109: ldc com/google/firestore/v1/StructuredQuery$Order
      //   111: monitorexit
      //   112: aload_1
      //   113: athrow
      //   114: getstatic com/google/firestore/v1/StructuredQuery$Order.PARSER : Lcom/google/protobuf/Parser;
      //   117: areturn
      //   118: aload_2
      //   119: checkcast com/google/protobuf/CodedInputStream
      //   122: astore_2
      //   123: aload_3
      //   124: checkcast com/google/protobuf/ExtensionRegistryLite
      //   127: astore_3
      //   128: iload #6
      //   130: ifne -> 302
      //   133: aload_2
      //   134: invokevirtual readTag : ()I
      //   137: istore #4
      //   139: iload #4
      //   141: ifeq -> 246
      //   144: iload #4
      //   146: bipush #10
      //   148: if_icmpeq -> 181
      //   151: iload #4
      //   153: bipush #16
      //   155: if_icmpeq -> 170
      //   158: aload_2
      //   159: iload #4
      //   161: invokevirtual skipField : (I)Z
      //   164: ifne -> 128
      //   167: goto -> 246
      //   170: aload_0
      //   171: aload_2
      //   172: invokevirtual readEnum : ()I
      //   175: putfield direction_ : I
      //   178: goto -> 128
      //   181: aload_0
      //   182: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   185: ifnull -> 202
      //   188: aload_0
      //   189: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   192: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   195: checkcast com/google/firestore/v1/StructuredQuery$FieldReference$Builder
      //   198: astore_1
      //   199: goto -> 204
      //   202: aconst_null
      //   203: astore_1
      //   204: aload_0
      //   205: aload_2
      //   206: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   209: aload_3
      //   210: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   213: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   216: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   219: aload_1
      //   220: ifnull -> 128
      //   223: aload_1
      //   224: aload_0
      //   225: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   228: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   231: pop
      //   232: aload_0
      //   233: aload_1
      //   234: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   237: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   240: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
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
      //   302: getstatic com/google/firestore/v1/StructuredQuery$Order.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Order;
      //   305: areturn
      //   306: aload_2
      //   307: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   310: astore_1
      //   311: aload_3
      //   312: checkcast com/google/firestore/v1/StructuredQuery$Order
      //   315: astore_2
      //   316: aload_0
      //   317: aload_1
      //   318: aload_0
      //   319: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   322: aload_2
      //   323: getfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   326: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
      //   331: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   334: putfield field_ : Lcom/google/firestore/v1/StructuredQuery$FieldReference;
      //   337: aload_0
      //   338: getfield direction_ : I
      //   341: ifeq -> 350
      //   344: iconst_1
      //   345: istore #7
      //   347: goto -> 353
      //   350: iconst_0
      //   351: istore #7
      //   353: aload_0
      //   354: getfield direction_ : I
      //   357: istore #6
      //   359: aload_2
      //   360: getfield direction_ : I
      //   363: ifeq -> 369
      //   366: iconst_1
      //   367: istore #5
      //   369: aload_0
      //   370: aload_1
      //   371: iload #7
      //   373: iload #6
      //   375: iload #5
      //   377: aload_2
      //   378: getfield direction_ : I
      //   381: invokeinterface visitInt : (ZIZI)I
      //   386: putfield direction_ : I
      //   389: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   392: astore_1
      //   393: aload_0
      //   394: areturn
      //   395: new com/google/firestore/v1/StructuredQuery$Order$Builder
      //   398: dup
      //   399: aconst_null
      //   400: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   403: areturn
      //   404: aconst_null
      //   405: areturn
      //   406: getstatic com/google/firestore/v1/StructuredQuery$Order.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Order;
      //   409: areturn
      //   410: new com/google/firestore/v1/StructuredQuery$Order
      //   413: dup
      //   414: invokespecial <init> : ()V
      //   417: areturn
      // Exception table:
      //   from	to	target	type
      //   81	102	108	finally
      //   102	105	108	finally
      //   109	112	108	finally
      //   133	139	284	com/google/protobuf/InvalidProtocolBufferException
      //   133	139	256	java/io/IOException
      //   133	139	252	finally
      //   158	167	284	com/google/protobuf/InvalidProtocolBufferException
      //   158	167	256	java/io/IOException
      //   158	167	252	finally
      //   170	178	284	com/google/protobuf/InvalidProtocolBufferException
      //   170	178	256	java/io/IOException
      //   170	178	252	finally
      //   181	199	284	com/google/protobuf/InvalidProtocolBufferException
      //   181	199	256	java/io/IOException
      //   181	199	252	finally
      //   204	219	284	com/google/protobuf/InvalidProtocolBufferException
      //   204	219	256	java/io/IOException
      //   204	219	252	finally
      //   223	243	284	com/google/protobuf/InvalidProtocolBufferException
      //   223	243	256	java/io/IOException
      //   223	243	252	finally
      //   257	284	252	finally
      //   285	300	252	finally
    }
    
    public StructuredQuery.Direction getDirection() {
      StructuredQuery.Direction direction1 = StructuredQuery.Direction.forNumber(this.direction_);
      StructuredQuery.Direction direction2 = direction1;
      if (direction1 == null)
        direction2 = StructuredQuery.Direction.UNRECOGNIZED; 
      return direction2;
    }
    
    public int getDirectionValue() {
      return this.direction_;
    }
    
    public StructuredQuery.FieldReference getField() {
      StructuredQuery.FieldReference fieldReference1 = this.field_;
      StructuredQuery.FieldReference fieldReference2 = fieldReference1;
      if (fieldReference1 == null)
        fieldReference2 = StructuredQuery.FieldReference.getDefaultInstance(); 
      return fieldReference2;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.field_ != null)
        i = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getField()); 
      int j = i;
      if (this.direction_ != StructuredQuery.Direction.DIRECTION_UNSPECIFIED.getNumber())
        j = i + CodedOutputStream.computeEnumSize(2, this.direction_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public boolean hasField() {
      boolean bool;
      if (this.field_ != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.field_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getField()); 
      if (this.direction_ != StructuredQuery.Direction.DIRECTION_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(2, this.direction_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Order, Builder> implements StructuredQuery.OrderOrBuilder {
      private Builder() {
        super(StructuredQuery.Order.DEFAULT_INSTANCE);
      }
      
      public Builder clearDirection() {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).clearDirection();
        return this;
      }
      
      public Builder clearField() {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).clearField();
        return this;
      }
      
      public StructuredQuery.Direction getDirection() {
        return ((StructuredQuery.Order)this.instance).getDirection();
      }
      
      public int getDirectionValue() {
        return ((StructuredQuery.Order)this.instance).getDirectionValue();
      }
      
      public StructuredQuery.FieldReference getField() {
        return ((StructuredQuery.Order)this.instance).getField();
      }
      
      public boolean hasField() {
        return ((StructuredQuery.Order)this.instance).hasField();
      }
      
      public Builder mergeField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).mergeField(param2FieldReference);
        return this;
      }
      
      public Builder setDirection(StructuredQuery.Direction param2Direction) {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).setDirection(param2Direction);
        return this;
      }
      
      public Builder setDirectionValue(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).setDirectionValue(param2Int);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).setField(param2Builder);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.Order)this.instance).setField(param2FieldReference);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Order, Order.Builder> implements OrderOrBuilder {
    private Builder() {
      super(StructuredQuery.Order.DEFAULT_INSTANCE);
    }
    
    public Builder clearDirection() {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).clearDirection();
      return this;
    }
    
    public Builder clearField() {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).clearField();
      return this;
    }
    
    public StructuredQuery.Direction getDirection() {
      return ((StructuredQuery.Order)this.instance).getDirection();
    }
    
    public int getDirectionValue() {
      return ((StructuredQuery.Order)this.instance).getDirectionValue();
    }
    
    public StructuredQuery.FieldReference getField() {
      return ((StructuredQuery.Order)this.instance).getField();
    }
    
    public boolean hasField() {
      return ((StructuredQuery.Order)this.instance).hasField();
    }
    
    public Builder mergeField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).mergeField(param1FieldReference);
      return this;
    }
    
    public Builder setDirection(StructuredQuery.Direction param1Direction) {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).setDirection(param1Direction);
      return this;
    }
    
    public Builder setDirectionValue(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).setDirectionValue(param1Int);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).setField(param1Builder);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.Order)this.instance).setField(param1FieldReference);
      return this;
    }
  }
  
  public static interface OrderOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.Direction getDirection();
    
    int getDirectionValue();
    
    StructuredQuery.FieldReference getField();
    
    boolean hasField();
  }
  
  public static final class Projection extends GeneratedMessageLite<Projection, Projection.Builder> implements ProjectionOrBuilder {
    private static final Projection DEFAULT_INSTANCE = new Projection();
    
    public static final int FIELDS_FIELD_NUMBER = 2;
    
    private static volatile Parser<Projection> PARSER;
    
    private Internal.ProtobufList<StructuredQuery.FieldReference> fields_ = emptyProtobufList();
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void addAllFields(Iterable<? extends StructuredQuery.FieldReference> param1Iterable) {
      ensureFieldsIsMutable();
      AbstractMessageLite.addAll(param1Iterable, (Collection)this.fields_);
    }
    
    private void addFields(int param1Int, StructuredQuery.FieldReference.Builder param1Builder) {
      ensureFieldsIsMutable();
      this.fields_.add(param1Int, param1Builder.build());
    }
    
    private void addFields(int param1Int, StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        ensureFieldsIsMutable();
        this.fields_.add(param1Int, param1FieldReference);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void addFields(StructuredQuery.FieldReference.Builder param1Builder) {
      ensureFieldsIsMutable();
      this.fields_.add(param1Builder.build());
    }
    
    private void addFields(StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        ensureFieldsIsMutable();
        this.fields_.add(param1FieldReference);
        return;
      } 
      throw new NullPointerException();
    }
    
    private void clearFields() {
      this.fields_ = emptyProtobufList();
    }
    
    private void ensureFieldsIsMutable() {
      if (!this.fields_.isModifiable())
        this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_); 
    }
    
    public static Projection getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Projection param1Projection) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1Projection);
    }
    
    public static Projection parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Projection)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Projection parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Projection)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Projection parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static Projection parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Projection parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static Projection parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Projection parseFrom(InputStream param1InputStream) throws IOException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static Projection parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Projection parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static Projection parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Projection)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Projection> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void removeFields(int param1Int) {
      ensureFieldsIsMutable();
      this.fields_.remove(param1Int);
    }
    
    private void setFields(int param1Int, StructuredQuery.FieldReference.Builder param1Builder) {
      ensureFieldsIsMutable();
      this.fields_.set(param1Int, param1Builder.build());
    }
    
    private void setFields(int param1Int, StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        ensureFieldsIsMutable();
        this.fields_.set(param1Int, param1FieldReference);
        return;
      } 
      throw new NullPointerException();
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
      //   3: aload_1
      //   4: invokevirtual ordinal : ()I
      //   7: iaload
      //   8: tableswitch default -> 56, 1 -> 323, 2 -> 319, 3 -> 308, 4 -> 299, 5 -> 265, 6 -> 110, 7 -> 261, 8 -> 64
      //   56: new java/lang/UnsupportedOperationException
      //   59: dup
      //   60: invokespecial <init> : ()V
      //   63: athrow
      //   64: getstatic com/google/firestore/v1/StructuredQuery$Projection.PARSER : Lcom/google/protobuf/Parser;
      //   67: ifnonnull -> 106
      //   70: ldc com/google/firestore/v1/StructuredQuery$Projection
      //   72: monitorenter
      //   73: getstatic com/google/firestore/v1/StructuredQuery$Projection.PARSER : Lcom/google/protobuf/Parser;
      //   76: ifnonnull -> 94
      //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   82: astore_1
      //   83: aload_1
      //   84: getstatic com/google/firestore/v1/StructuredQuery$Projection.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Projection;
      //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   90: aload_1
      //   91: putstatic com/google/firestore/v1/StructuredQuery$Projection.PARSER : Lcom/google/protobuf/Parser;
      //   94: ldc com/google/firestore/v1/StructuredQuery$Projection
      //   96: monitorexit
      //   97: goto -> 106
      //   100: astore_1
      //   101: ldc com/google/firestore/v1/StructuredQuery$Projection
      //   103: monitorexit
      //   104: aload_1
      //   105: athrow
      //   106: getstatic com/google/firestore/v1/StructuredQuery$Projection.PARSER : Lcom/google/protobuf/Parser;
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
      //   141: bipush #18
      //   143: if_icmpeq -> 158
      //   146: aload_1
      //   147: iload #5
      //   149: invokevirtual skipField : (I)Z
      //   152: ifne -> 123
      //   155: goto -> 205
      //   158: aload_0
      //   159: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   162: invokeinterface isModifiable : ()Z
      //   167: ifne -> 181
      //   170: aload_0
      //   171: aload_0
      //   172: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   175: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   178: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   181: aload_0
      //   182: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   185: aload_1
      //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   189: aload_2
      //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   193: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
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
      //   261: getstatic com/google/firestore/v1/StructuredQuery$Projection.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Projection;
      //   264: areturn
      //   265: aload_2
      //   266: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   269: astore_1
      //   270: aload_3
      //   271: checkcast com/google/firestore/v1/StructuredQuery$Projection
      //   274: astore_2
      //   275: aload_0
      //   276: aload_1
      //   277: aload_0
      //   278: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   281: aload_2
      //   282: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   285: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
      //   290: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   293: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   296: astore_1
      //   297: aload_0
      //   298: areturn
      //   299: new com/google/firestore/v1/StructuredQuery$Projection$Builder
      //   302: dup
      //   303: aconst_null
      //   304: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   307: areturn
      //   308: aload_0
      //   309: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
      //   312: invokeinterface makeImmutable : ()V
      //   317: aconst_null
      //   318: areturn
      //   319: getstatic com/google/firestore/v1/StructuredQuery$Projection.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$Projection;
      //   322: areturn
      //   323: new com/google/firestore/v1/StructuredQuery$Projection
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
    
    public StructuredQuery.FieldReference getFields(int param1Int) {
      return (StructuredQuery.FieldReference)this.fields_.get(param1Int);
    }
    
    public int getFieldsCount() {
      return this.fields_.size();
    }
    
    public List<StructuredQuery.FieldReference> getFieldsList() {
      return (List<StructuredQuery.FieldReference>)this.fields_;
    }
    
    public StructuredQuery.FieldReferenceOrBuilder getFieldsOrBuilder(int param1Int) {
      return (StructuredQuery.FieldReferenceOrBuilder)this.fields_.get(param1Int);
    }
    
    public List<? extends StructuredQuery.FieldReferenceOrBuilder> getFieldsOrBuilderList() {
      return (List)this.fields_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.fields_.size()) {
        j += CodedOutputStream.computeMessageSize(2, (MessageLite)this.fields_.get(i));
        i++;
      } 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (byte b = 0; b < this.fields_.size(); b++)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.fields_.get(b)); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Projection, Builder> implements StructuredQuery.ProjectionOrBuilder {
      private Builder() {
        super(StructuredQuery.Projection.DEFAULT_INSTANCE);
      }
      
      public Builder addAllFields(Iterable<? extends StructuredQuery.FieldReference> param2Iterable) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).addAllFields(param2Iterable);
        return this;
      }
      
      public Builder addFields(int param2Int, StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).addFields(param2Int, param2Builder);
        return this;
      }
      
      public Builder addFields(int param2Int, StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).addFields(param2Int, param2FieldReference);
        return this;
      }
      
      public Builder addFields(StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).addFields(param2Builder);
        return this;
      }
      
      public Builder addFields(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).addFields(param2FieldReference);
        return this;
      }
      
      public Builder clearFields() {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).clearFields();
        return this;
      }
      
      public StructuredQuery.FieldReference getFields(int param2Int) {
        return ((StructuredQuery.Projection)this.instance).getFields(param2Int);
      }
      
      public int getFieldsCount() {
        return ((StructuredQuery.Projection)this.instance).getFieldsCount();
      }
      
      public List<StructuredQuery.FieldReference> getFieldsList() {
        return Collections.unmodifiableList(((StructuredQuery.Projection)this.instance).getFieldsList());
      }
      
      public Builder removeFields(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).removeFields(param2Int);
        return this;
      }
      
      public Builder setFields(int param2Int, StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).setFields(param2Int, param2Builder);
        return this;
      }
      
      public Builder setFields(int param2Int, StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.Projection)this.instance).setFields(param2Int, param2FieldReference);
        return this;
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Projection, Projection.Builder> implements ProjectionOrBuilder {
    private Builder() {
      super(StructuredQuery.Projection.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFields(Iterable<? extends StructuredQuery.FieldReference> param1Iterable) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).addAllFields(param1Iterable);
      return this;
    }
    
    public Builder addFields(int param1Int, StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).addFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFields(int param1Int, StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).addFields(param1Int, param1FieldReference);
      return this;
    }
    
    public Builder addFields(StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).addFields(param1Builder);
      return this;
    }
    
    public Builder addFields(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).addFields(param1FieldReference);
      return this;
    }
    
    public Builder clearFields() {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).clearFields();
      return this;
    }
    
    public StructuredQuery.FieldReference getFields(int param1Int) {
      return ((StructuredQuery.Projection)this.instance).getFields(param1Int);
    }
    
    public int getFieldsCount() {
      return ((StructuredQuery.Projection)this.instance).getFieldsCount();
    }
    
    public List<StructuredQuery.FieldReference> getFieldsList() {
      return Collections.unmodifiableList(((StructuredQuery.Projection)this.instance).getFieldsList());
    }
    
    public Builder removeFields(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).removeFields(param1Int);
      return this;
    }
    
    public Builder setFields(int param1Int, StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).setFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFields(int param1Int, StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.Projection)this.instance).setFields(param1Int, param1FieldReference);
      return this;
    }
  }
  
  public static interface ProjectionOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.FieldReference getFields(int param1Int);
    
    int getFieldsCount();
    
    List<StructuredQuery.FieldReference> getFieldsList();
  }
  
  public static final class UnaryFilter extends GeneratedMessageLite<UnaryFilter, UnaryFilter.Builder> implements UnaryFilterOrBuilder {
    private static final UnaryFilter DEFAULT_INSTANCE = new UnaryFilter();
    
    public static final int FIELD_FIELD_NUMBER = 2;
    
    public static final int OP_FIELD_NUMBER = 1;
    
    private static volatile Parser<UnaryFilter> PARSER;
    
    private int op_;
    
    private int operandTypeCase_ = 0;
    
    private Object operandType_;
    
    static {
      DEFAULT_INSTANCE.makeImmutable();
    }
    
    private void clearField() {
      if (this.operandTypeCase_ == 2) {
        this.operandTypeCase_ = 0;
        this.operandType_ = null;
      } 
    }
    
    private void clearOp() {
      this.op_ = 0;
    }
    
    private void clearOperandType() {
      this.operandTypeCase_ = 0;
      this.operandType_ = null;
    }
    
    public static UnaryFilter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    private void mergeField(StructuredQuery.FieldReference param1FieldReference) {
      if (this.operandTypeCase_ == 2 && this.operandType_ != StructuredQuery.FieldReference.getDefaultInstance()) {
        this.operandType_ = ((StructuredQuery.FieldReference.Builder)StructuredQuery.FieldReference.newBuilder((StructuredQuery.FieldReference)this.operandType_).mergeFrom(param1FieldReference)).buildPartial();
      } else {
        this.operandType_ = param1FieldReference;
      } 
      this.operandTypeCase_ = 2;
    }
    
    public static Builder newBuilder() {
      return (Builder)DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(UnaryFilter param1UnaryFilter) {
      return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(param1UnaryFilter);
    }
    
    public static UnaryFilter parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (UnaryFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static UnaryFilter parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UnaryFilter)parseDelimitedFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UnaryFilter parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString);
    }
    
    public static UnaryFilter parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static UnaryFilter parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream);
    }
    
    public static UnaryFilter parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static UnaryFilter parseFrom(InputStream param1InputStream) throws IOException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream);
    }
    
    public static UnaryFilter parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static UnaryFilter parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte);
    }
    
    public static UnaryFilter parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (UnaryFilter)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<UnaryFilter> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    
    private void setField(StructuredQuery.FieldReference.Builder param1Builder) {
      this.operandType_ = param1Builder.build();
      this.operandTypeCase_ = 2;
    }
    
    private void setField(StructuredQuery.FieldReference param1FieldReference) {
      if (param1FieldReference != null) {
        this.operandType_ = param1FieldReference;
        this.operandTypeCase_ = 2;
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOp(Operator param1Operator) {
      if (param1Operator != null) {
        this.op_ = param1Operator.getNumber();
        return;
      } 
      throw new NullPointerException();
    }
    
    private void setOpValue(int param1Int) {
      this.op_ = param1Int;
    }
    
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke param1MethodToInvoke, Object param1Object1, Object param1Object2) {
      // Byte code:
      //   0: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
      //   19: iload #4
      //   21: tableswitch default -> 68, 1 -> 513, 2 -> 509, 3 -> 507, 4 -> 498, 5 -> 316, 6 -> 122, 7 -> 312, 8 -> 76
      //   68: new java/lang/UnsupportedOperationException
      //   71: dup
      //   72: invokespecial <init> : ()V
      //   75: athrow
      //   76: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.PARSER : Lcom/google/protobuf/Parser;
      //   79: ifnonnull -> 118
      //   82: ldc com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   84: monitorenter
      //   85: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.PARSER : Lcom/google/protobuf/Parser;
      //   88: ifnonnull -> 106
      //   91: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
      //   94: astore_1
      //   95: aload_1
      //   96: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$UnaryFilter;
      //   99: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
      //   102: aload_1
      //   103: putstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.PARSER : Lcom/google/protobuf/Parser;
      //   106: ldc com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   108: monitorexit
      //   109: goto -> 118
      //   112: astore_1
      //   113: ldc com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   115: monitorexit
      //   116: aload_1
      //   117: athrow
      //   118: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.PARSER : Lcom/google/protobuf/Parser;
      //   121: areturn
      //   122: aload_2
      //   123: checkcast com/google/protobuf/CodedInputStream
      //   126: astore_2
      //   127: aload_3
      //   128: checkcast com/google/protobuf/ExtensionRegistryLite
      //   131: astore_3
      //   132: iload #7
      //   134: ifne -> 312
      //   137: aload_2
      //   138: invokevirtual readTag : ()I
      //   141: istore #4
      //   143: iload #4
      //   145: ifeq -> 256
      //   148: iload #4
      //   150: bipush #8
      //   152: if_icmpeq -> 245
      //   155: iload #4
      //   157: bipush #18
      //   159: if_icmpeq -> 174
      //   162: aload_2
      //   163: iload #4
      //   165: invokevirtual skipField : (I)Z
      //   168: ifne -> 132
      //   171: goto -> 256
      //   174: aload_0
      //   175: getfield operandTypeCase_ : I
      //   178: iconst_2
      //   179: if_icmpne -> 199
      //   182: aload_0
      //   183: getfield operandType_ : Ljava/lang/Object;
      //   186: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   189: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   192: checkcast com/google/firestore/v1/StructuredQuery$FieldReference$Builder
      //   195: astore_1
      //   196: goto -> 201
      //   199: aconst_null
      //   200: astore_1
      //   201: aload_0
      //   202: aload_2
      //   203: invokestatic parser : ()Lcom/google/protobuf/Parser;
      //   206: aload_3
      //   207: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
      //   210: putfield operandType_ : Ljava/lang/Object;
      //   213: aload_1
      //   214: ifnull -> 237
      //   217: aload_1
      //   218: aload_0
      //   219: getfield operandType_ : Ljava/lang/Object;
      //   222: checkcast com/google/firestore/v1/StructuredQuery$FieldReference
      //   225: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
      //   228: pop
      //   229: aload_0
      //   230: aload_1
      //   231: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
      //   234: putfield operandType_ : Ljava/lang/Object;
      //   237: aload_0
      //   238: iconst_2
      //   239: putfield operandTypeCase_ : I
      //   242: goto -> 132
      //   245: aload_0
      //   246: aload_2
      //   247: invokevirtual readEnum : ()I
      //   250: putfield op_ : I
      //   253: goto -> 132
      //   256: iconst_1
      //   257: istore #7
      //   259: goto -> 132
      //   262: astore_1
      //   263: goto -> 310
      //   266: astore_2
      //   267: new java/lang/RuntimeException
      //   270: astore_1
      //   271: new com/google/protobuf/InvalidProtocolBufferException
      //   274: astore_3
      //   275: aload_3
      //   276: aload_2
      //   277: invokevirtual getMessage : ()Ljava/lang/String;
      //   280: invokespecial <init> : (Ljava/lang/String;)V
      //   283: aload_1
      //   284: aload_3
      //   285: aload_0
      //   286: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   289: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   292: aload_1
      //   293: athrow
      //   294: astore_1
      //   295: new java/lang/RuntimeException
      //   298: astore_2
      //   299: aload_2
      //   300: aload_1
      //   301: aload_0
      //   302: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
      //   305: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   308: aload_2
      //   309: athrow
      //   310: aload_1
      //   311: athrow
      //   312: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$UnaryFilter;
      //   315: areturn
      //   316: aload_2
      //   317: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
      //   320: astore_1
      //   321: aload_3
      //   322: checkcast com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   325: astore_2
      //   326: aload_0
      //   327: getfield op_ : I
      //   330: ifeq -> 339
      //   333: iconst_1
      //   334: istore #8
      //   336: goto -> 342
      //   339: iconst_0
      //   340: istore #8
      //   342: aload_0
      //   343: getfield op_ : I
      //   346: istore #7
      //   348: aload_2
      //   349: getfield op_ : I
      //   352: ifeq -> 361
      //   355: iconst_1
      //   356: istore #9
      //   358: goto -> 364
      //   361: iconst_0
      //   362: istore #9
      //   364: aload_0
      //   365: aload_1
      //   366: iload #8
      //   368: iload #7
      //   370: iload #9
      //   372: aload_2
      //   373: getfield op_ : I
      //   376: invokeinterface visitInt : (ZIZI)I
      //   381: putfield op_ : I
      //   384: getstatic com/google/firestore/v1/StructuredQuery$1.$SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$OperandTypeCase : [I
      //   387: aload_2
      //   388: invokevirtual getOperandTypeCase : ()Lcom/google/firestore/v1/StructuredQuery$UnaryFilter$OperandTypeCase;
      //   391: invokevirtual ordinal : ()I
      //   394: iaload
      //   395: istore #7
      //   397: iload #7
      //   399: iconst_1
      //   400: if_icmpeq -> 437
      //   403: iload #7
      //   405: iconst_2
      //   406: if_icmpeq -> 412
      //   409: goto -> 472
      //   412: iload #5
      //   414: istore #8
      //   416: aload_0
      //   417: getfield operandTypeCase_ : I
      //   420: ifeq -> 426
      //   423: iconst_1
      //   424: istore #8
      //   426: aload_1
      //   427: iload #8
      //   429: invokeinterface visitOneofNotSet : (Z)V
      //   434: goto -> 472
      //   437: iload #6
      //   439: istore #8
      //   441: aload_0
      //   442: getfield operandTypeCase_ : I
      //   445: iconst_2
      //   446: if_icmpne -> 452
      //   449: iconst_1
      //   450: istore #8
      //   452: aload_0
      //   453: aload_1
      //   454: iload #8
      //   456: aload_0
      //   457: getfield operandType_ : Ljava/lang/Object;
      //   460: aload_2
      //   461: getfield operandType_ : Ljava/lang/Object;
      //   464: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   469: putfield operandType_ : Ljava/lang/Object;
      //   472: aload_1
      //   473: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
      //   476: if_acmpne -> 496
      //   479: aload_2
      //   480: getfield operandTypeCase_ : I
      //   483: istore #7
      //   485: iload #7
      //   487: ifeq -> 496
      //   490: aload_0
      //   491: iload #7
      //   493: putfield operandTypeCase_ : I
      //   496: aload_0
      //   497: areturn
      //   498: new com/google/firestore/v1/StructuredQuery$UnaryFilter$Builder
      //   501: dup
      //   502: aconst_null
      //   503: invokespecial <init> : (Lcom/google/firestore/v1/StructuredQuery$1;)V
      //   506: areturn
      //   507: aconst_null
      //   508: areturn
      //   509: getstatic com/google/firestore/v1/StructuredQuery$UnaryFilter.DEFAULT_INSTANCE : Lcom/google/firestore/v1/StructuredQuery$UnaryFilter;
      //   512: areturn
      //   513: new com/google/firestore/v1/StructuredQuery$UnaryFilter
      //   516: dup
      //   517: invokespecial <init> : ()V
      //   520: areturn
      // Exception table:
      //   from	to	target	type
      //   85	106	112	finally
      //   106	109	112	finally
      //   113	116	112	finally
      //   137	143	294	com/google/protobuf/InvalidProtocolBufferException
      //   137	143	266	java/io/IOException
      //   137	143	262	finally
      //   162	171	294	com/google/protobuf/InvalidProtocolBufferException
      //   162	171	266	java/io/IOException
      //   162	171	262	finally
      //   174	196	294	com/google/protobuf/InvalidProtocolBufferException
      //   174	196	266	java/io/IOException
      //   174	196	262	finally
      //   201	213	294	com/google/protobuf/InvalidProtocolBufferException
      //   201	213	266	java/io/IOException
      //   201	213	262	finally
      //   217	237	294	com/google/protobuf/InvalidProtocolBufferException
      //   217	237	266	java/io/IOException
      //   217	237	262	finally
      //   237	242	294	com/google/protobuf/InvalidProtocolBufferException
      //   237	242	266	java/io/IOException
      //   237	242	262	finally
      //   245	253	294	com/google/protobuf/InvalidProtocolBufferException
      //   245	253	266	java/io/IOException
      //   245	253	262	finally
      //   267	294	262	finally
      //   295	310	262	finally
    }
    
    public StructuredQuery.FieldReference getField() {
      return (this.operandTypeCase_ == 2) ? (StructuredQuery.FieldReference)this.operandType_ : StructuredQuery.FieldReference.getDefaultInstance();
    }
    
    public Operator getOp() {
      Operator operator1 = Operator.forNumber(this.op_);
      Operator operator2 = operator1;
      if (operator1 == null)
        operator2 = Operator.UNRECOGNIZED; 
      return operator2;
    }
    
    public int getOpValue() {
      return this.op_;
    }
    
    public OperandTypeCase getOperandTypeCase() {
      return OperandTypeCase.forNumber(this.operandTypeCase_);
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSerializedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.op_); 
      int j = i;
      if (this.operandTypeCase_ == 2)
        j = i + CodedOutputStream.computeMessageSize(2, (MessageLite)this.operandType_); 
      this.memoizedSerializedSize = j;
      return j;
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.op_ != Operator.OPERATOR_UNSPECIFIED.getNumber())
        param1CodedOutputStream.writeEnum(1, this.op_); 
      if (this.operandTypeCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.operandType_); 
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<UnaryFilter, Builder> implements StructuredQuery.UnaryFilterOrBuilder {
      private Builder() {
        super(StructuredQuery.UnaryFilter.DEFAULT_INSTANCE);
      }
      
      public Builder clearField() {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).clearField();
        return this;
      }
      
      public Builder clearOp() {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).clearOp();
        return this;
      }
      
      public Builder clearOperandType() {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).clearOperandType();
        return this;
      }
      
      public StructuredQuery.FieldReference getField() {
        return ((StructuredQuery.UnaryFilter)this.instance).getField();
      }
      
      public StructuredQuery.UnaryFilter.Operator getOp() {
        return ((StructuredQuery.UnaryFilter)this.instance).getOp();
      }
      
      public int getOpValue() {
        return ((StructuredQuery.UnaryFilter)this.instance).getOpValue();
      }
      
      public StructuredQuery.UnaryFilter.OperandTypeCase getOperandTypeCase() {
        return ((StructuredQuery.UnaryFilter)this.instance).getOperandTypeCase();
      }
      
      public Builder mergeField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).mergeField(param2FieldReference);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference.Builder param2Builder) {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).setField(param2Builder);
        return this;
      }
      
      public Builder setField(StructuredQuery.FieldReference param2FieldReference) {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).setField(param2FieldReference);
        return this;
      }
      
      public Builder setOp(StructuredQuery.UnaryFilter.Operator param2Operator) {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).setOp(param2Operator);
        return this;
      }
      
      public Builder setOpValue(int param2Int) {
        copyOnWrite();
        ((StructuredQuery.UnaryFilter)this.instance).setOpValue(param2Int);
        return this;
      }
    }
    
    public enum OperandTypeCase implements Internal.EnumLite {
      FIELD(2),
      OPERANDTYPE_NOT_SET(0);
      
      private final int value;
      
      static {
      
      }
      
      OperandTypeCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static OperandTypeCase forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 2) ? null : FIELD) : OPERANDTYPE_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
    
    public enum Operator implements Internal.EnumLite {
      OPERATOR_UNSPECIFIED(0),
      UNRECOGNIZED(0),
      IS_NAN(0),
      IS_NULL(0);
      
      public static final int IS_NAN_VALUE = 2;
      
      public static final int IS_NULL_VALUE = 3;
      
      public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
      
      private static final Internal.EnumLiteMap<Operator> internalValueMap = new Internal.EnumLiteMap<Operator>() {
          public StructuredQuery.UnaryFilter.Operator findValueByNumber(int param3Int) {
            return StructuredQuery.UnaryFilter.Operator.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      Operator(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static Operator forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 2) ? ((param2Int != 3) ? null : IS_NULL) : IS_NAN) : OPERATOR_UNSPECIFIED;
      }
      
      public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final int getNumber() {
        return this.value;
      }
    }
    
    class null implements Internal.EnumLiteMap<Operator> {
      public StructuredQuery.UnaryFilter.Operator findValueByNumber(int param2Int) {
        return StructuredQuery.UnaryFilter.Operator.forNumber(param2Int);
      }
    }
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UnaryFilter, UnaryFilter.Builder> implements UnaryFilterOrBuilder {
    private Builder() {
      super(StructuredQuery.UnaryFilter.DEFAULT_INSTANCE);
    }
    
    public Builder clearField() {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).clearField();
      return this;
    }
    
    public Builder clearOp() {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).clearOp();
      return this;
    }
    
    public Builder clearOperandType() {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).clearOperandType();
      return this;
    }
    
    public StructuredQuery.FieldReference getField() {
      return ((StructuredQuery.UnaryFilter)this.instance).getField();
    }
    
    public StructuredQuery.UnaryFilter.Operator getOp() {
      return ((StructuredQuery.UnaryFilter)this.instance).getOp();
    }
    
    public int getOpValue() {
      return ((StructuredQuery.UnaryFilter)this.instance).getOpValue();
    }
    
    public StructuredQuery.UnaryFilter.OperandTypeCase getOperandTypeCase() {
      return ((StructuredQuery.UnaryFilter)this.instance).getOperandTypeCase();
    }
    
    public Builder mergeField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).mergeField(param1FieldReference);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference.Builder param1Builder) {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).setField(param1Builder);
      return this;
    }
    
    public Builder setField(StructuredQuery.FieldReference param1FieldReference) {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).setField(param1FieldReference);
      return this;
    }
    
    public Builder setOp(StructuredQuery.UnaryFilter.Operator param1Operator) {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).setOp(param1Operator);
      return this;
    }
    
    public Builder setOpValue(int param1Int) {
      copyOnWrite();
      ((StructuredQuery.UnaryFilter)this.instance).setOpValue(param1Int);
      return this;
    }
  }
  
  public enum OperandTypeCase implements Internal.EnumLite {
    FIELD(2),
    OPERANDTYPE_NOT_SET(0);
    
    private final int value;
    
    static {
    
    }
    
    OperandTypeCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OperandTypeCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? null : FIELD) : OPERANDTYPE_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public enum Operator implements Internal.EnumLite {
    OPERATOR_UNSPECIFIED(0),
    UNRECOGNIZED(0),
    IS_NAN(0),
    IS_NULL(0);
    
    public static final int IS_NAN_VALUE = 2;
    
    public static final int IS_NULL_VALUE = 3;
    
    public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Operator> internalValueMap;
    
    private final int value;
    
    static {
      $VALUES = new Operator[] { OPERATOR_UNSPECIFIED, IS_NAN, IS_NULL, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Operator>() {
          public StructuredQuery.UnaryFilter.Operator findValueByNumber(int param3Int) {
            return StructuredQuery.UnaryFilter.Operator.forNumber(param3Int);
          }
        };
    }
    
    Operator(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Operator forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 2) ? ((param1Int != 3) ? null : IS_NULL) : IS_NAN) : OPERATOR_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<UnaryFilter.Operator> {
    public StructuredQuery.UnaryFilter.Operator findValueByNumber(int param1Int) {
      return StructuredQuery.UnaryFilter.Operator.forNumber(param1Int);
    }
  }
  
  public static interface UnaryFilterOrBuilder extends MessageLiteOrBuilder {
    StructuredQuery.FieldReference getField();
    
    StructuredQuery.UnaryFilter.Operator getOp();
    
    int getOpValue();
    
    StructuredQuery.UnaryFilter.OperandTypeCase getOperandTypeCase();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\StructuredQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */