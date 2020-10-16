package com.google.firestore.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;

public final class FirestoreGrpc {
  private static final int METHODID_BATCH_GET_DOCUMENTS = 5;
  
  private static final int METHODID_BEGIN_TRANSACTION = 6;
  
  private static final int METHODID_COMMIT = 7;
  
  private static final int METHODID_CREATE_DOCUMENT = 2;
  
  private static final int METHODID_DELETE_DOCUMENT = 4;
  
  private static final int METHODID_GET_DOCUMENT = 0;
  
  private static final int METHODID_LISTEN = 12;
  
  private static final int METHODID_LIST_COLLECTION_IDS = 10;
  
  private static final int METHODID_LIST_DOCUMENTS = 1;
  
  private static final int METHODID_ROLLBACK = 8;
  
  private static final int METHODID_RUN_QUERY = 9;
  
  private static final int METHODID_UPDATE_DOCUMENT = 3;
  
  private static final int METHODID_WRITE = 11;
  
  public static final String SERVICE_NAME = "google.firestore.v1.Firestore";
  
  private static volatile MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> getBatchGetDocumentsMethod;
  
  private static volatile MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> getBeginTransactionMethod;
  
  private static volatile MethodDescriptor<CommitRequest, CommitResponse> getCommitMethod;
  
  private static volatile MethodDescriptor<CreateDocumentRequest, Document> getCreateDocumentMethod;
  
  private static volatile MethodDescriptor<DeleteDocumentRequest, Empty> getDeleteDocumentMethod;
  
  private static volatile MethodDescriptor<GetDocumentRequest, Document> getGetDocumentMethod;
  
  private static volatile MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> getListCollectionIdsMethod;
  
  private static volatile MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> getListDocumentsMethod;
  
  private static volatile MethodDescriptor<ListenRequest, ListenResponse> getListenMethod;
  
  private static volatile MethodDescriptor<RollbackRequest, Empty> getRollbackMethod;
  
  private static volatile MethodDescriptor<RunQueryRequest, RunQueryResponse> getRunQueryMethod;
  
  private static volatile MethodDescriptor<UpdateDocumentRequest, Document> getUpdateDocumentMethod;
  
  private static volatile MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  public static MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> getBatchGetDocumentsMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getBatchGetDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getBatchGetDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.SERVER_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'BatchGetDocuments'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/BatchGetDocumentsRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/BatchGetDocumentsResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getBatchGetDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> getBeginTransactionMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getBeginTransactionMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getBeginTransactionMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'BeginTransaction'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/BeginTransactionRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/BeginTransactionResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getBeginTransactionMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<CommitRequest, CommitResponse> getCommitMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getCommitMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getCommitMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'Commit'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/CommitRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/CommitResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getCommitMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<CreateDocumentRequest, Document> getCreateDocumentMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getCreateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getCreateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'CreateDocument'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/CreateDocumentRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/Document;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getCreateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<DeleteDocumentRequest, Empty> getDeleteDocumentMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getDeleteDocumentMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getDeleteDocumentMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'DeleteDocument'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/DeleteDocumentRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Empty;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getDeleteDocumentMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<GetDocumentRequest, Document> getGetDocumentMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getGetDocumentMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getGetDocumentMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'GetDocument'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/GetDocumentRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/Document;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getGetDocumentMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> getListCollectionIdsMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getListCollectionIdsMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getListCollectionIdsMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'ListCollectionIds'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListCollectionIdsRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListCollectionIdsResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getListCollectionIdsMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> getListDocumentsMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getListDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getListDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc 'ListDocuments'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListDocumentsRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListDocumentsResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/firestore/v1/FirestoreGrpc.getListDocumentsMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/firestore/v1/FirestoreGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/firestore/v1/FirestoreGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static MethodDescriptor<ListenRequest, ListenResponse> getListenMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getListenMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getListenMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.BIDI_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc_w 'Listen'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListenRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/ListenResponse;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/firestore/v1/FirestoreGrpc.getListenMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/firestore/v1/FirestoreGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/firestore/v1/FirestoreGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static MethodDescriptor<RollbackRequest, Empty> getRollbackMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getRollbackMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getRollbackMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc_w 'Rollback'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/RollbackRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Empty;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/firestore/v1/FirestoreGrpc.getRollbackMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/firestore/v1/FirestoreGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/firestore/v1/FirestoreGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static MethodDescriptor<RunQueryRequest, RunQueryResponse> getRunQueryMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getRunQueryMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getRunQueryMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.SERVER_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc_w 'RunQuery'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/RunQueryRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/RunQueryResponse;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/firestore/v1/FirestoreGrpc.getRunQueryMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/firestore/v1/FirestoreGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/firestore/v1/FirestoreGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static ServiceDescriptor getServiceDescriptor() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 126
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 114
    //   23: ldc 'google.firestore.v1.Firestore'
    //   25: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   28: invokestatic getGetDocumentMethod : ()Lio/grpc/MethodDescriptor;
    //   31: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   34: invokestatic getListDocumentsMethod : ()Lio/grpc/MethodDescriptor;
    //   37: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   40: invokestatic getCreateDocumentMethod : ()Lio/grpc/MethodDescriptor;
    //   43: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   46: invokestatic getUpdateDocumentMethod : ()Lio/grpc/MethodDescriptor;
    //   49: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   52: invokestatic getDeleteDocumentMethod : ()Lio/grpc/MethodDescriptor;
    //   55: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   58: invokestatic getBatchGetDocumentsMethod : ()Lio/grpc/MethodDescriptor;
    //   61: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   64: invokestatic getBeginTransactionMethod : ()Lio/grpc/MethodDescriptor;
    //   67: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   70: invokestatic getCommitMethod : ()Lio/grpc/MethodDescriptor;
    //   73: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   76: invokestatic getRollbackMethod : ()Lio/grpc/MethodDescriptor;
    //   79: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   82: invokestatic getRunQueryMethod : ()Lio/grpc/MethodDescriptor;
    //   85: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   88: invokestatic getWriteMethod : ()Lio/grpc/MethodDescriptor;
    //   91: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   94: invokestatic getListenMethod : ()Lio/grpc/MethodDescriptor;
    //   97: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   100: invokestatic getListCollectionIdsMethod : ()Lio/grpc/MethodDescriptor;
    //   103: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   106: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   109: astore_1
    //   110: aload_1
    //   111: putstatic com/google/firestore/v1/FirestoreGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   114: ldc com/google/firestore/v1/FirestoreGrpc
    //   116: monitorexit
    //   117: goto -> 126
    //   120: astore_1
    //   121: ldc com/google/firestore/v1/FirestoreGrpc
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: aload_1
    //   127: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	120	finally
    //   23	114	120	finally
    //   114	117	120	finally
    //   121	124	120	finally
  }
  
  public static MethodDescriptor<UpdateDocumentRequest, Document> getUpdateDocumentMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getUpdateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getUpdateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc_w 'UpdateDocument'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/UpdateDocumentRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/Document;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/firestore/v1/FirestoreGrpc.getUpdateDocumentMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/firestore/v1/FirestoreGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/firestore/v1/FirestoreGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod() {
    // Byte code:
    //   0: getstatic com/google/firestore/v1/FirestoreGrpc.getWriteMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/firestore/v1/FirestoreGrpc
    //   12: monitorenter
    //   13: getstatic com/google/firestore/v1/FirestoreGrpc.getWriteMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.BIDI_STREAMING : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.firestore.v1.Firestore'
    //   34: ldc_w 'Write'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/WriteRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/firestore/v1/WriteResponse;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/firestore/v1/FirestoreGrpc.getWriteMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/firestore/v1/FirestoreGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/firestore/v1/FirestoreGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static FirestoreBlockingStub newBlockingStub(Channel paramChannel) {
    return new FirestoreBlockingStub(paramChannel);
  }
  
  public static FirestoreFutureStub newFutureStub(Channel paramChannel) {
    return new FirestoreFutureStub(paramChannel);
  }
  
  public static FirestoreStub newStub(Channel paramChannel) {
    return new FirestoreStub(paramChannel);
  }
  
  public static final class FirestoreBlockingStub extends AbstractStub<FirestoreBlockingStub> {
    private FirestoreBlockingStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private FirestoreBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public Iterator<BatchGetDocumentsResponse> batchGetDocuments(BatchGetDocumentsRequest param1BatchGetDocumentsRequest) {
      return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions(), param1BatchGetDocumentsRequest);
    }
    
    public BeginTransactionResponse beginTransaction(BeginTransactionRequest param1BeginTransactionRequest) {
      return (BeginTransactionResponse)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getBeginTransactionMethod(), getCallOptions(), param1BeginTransactionRequest);
    }
    
    protected FirestoreBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new FirestoreBlockingStub(param1Channel, param1CallOptions);
    }
    
    public CommitResponse commit(CommitRequest param1CommitRequest) {
      return (CommitResponse)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCommitMethod(), getCallOptions(), param1CommitRequest);
    }
    
    public Document createDocument(CreateDocumentRequest param1CreateDocumentRequest) {
      return (Document)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCreateDocumentMethod(), getCallOptions(), param1CreateDocumentRequest);
    }
    
    public Empty deleteDocument(DeleteDocumentRequest param1DeleteDocumentRequest) {
      return (Empty)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions(), param1DeleteDocumentRequest);
    }
    
    public Document getDocument(GetDocumentRequest param1GetDocumentRequest) {
      return (Document)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getGetDocumentMethod(), getCallOptions(), param1GetDocumentRequest);
    }
    
    public ListCollectionIdsResponse listCollectionIds(ListCollectionIdsRequest param1ListCollectionIdsRequest) {
      return (ListCollectionIdsResponse)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions(), param1ListCollectionIdsRequest);
    }
    
    public ListDocumentsResponse listDocuments(ListDocumentsRequest param1ListDocumentsRequest) {
      return (ListDocumentsResponse)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListDocumentsMethod(), getCallOptions(), param1ListDocumentsRequest);
    }
    
    public Empty rollback(RollbackRequest param1RollbackRequest) {
      return (Empty)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getRollbackMethod(), getCallOptions(), param1RollbackRequest);
    }
    
    public Iterator<RunQueryResponse> runQuery(RunQueryRequest param1RunQueryRequest) {
      return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getRunQueryMethod(), getCallOptions(), param1RunQueryRequest);
    }
    
    public Document updateDocument(UpdateDocumentRequest param1UpdateDocumentRequest) {
      return (Document)ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions(), param1UpdateDocumentRequest);
    }
  }
  
  public static final class FirestoreFutureStub extends AbstractStub<FirestoreFutureStub> {
    private FirestoreFutureStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private FirestoreFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<BeginTransactionResponse> beginTransaction(BeginTransactionRequest param1BeginTransactionRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), param1BeginTransactionRequest);
    }
    
    protected FirestoreFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new FirestoreFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<CommitResponse> commit(CommitRequest param1CommitRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), param1CommitRequest);
    }
    
    public ListenableFuture<Document> createDocument(CreateDocumentRequest param1CreateDocumentRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), param1CreateDocumentRequest);
    }
    
    public ListenableFuture<Empty> deleteDocument(DeleteDocumentRequest param1DeleteDocumentRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), param1DeleteDocumentRequest);
    }
    
    public ListenableFuture<Document> getDocument(GetDocumentRequest param1GetDocumentRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), param1GetDocumentRequest);
    }
    
    public ListenableFuture<ListCollectionIdsResponse> listCollectionIds(ListCollectionIdsRequest param1ListCollectionIdsRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), param1ListCollectionIdsRequest);
    }
    
    public ListenableFuture<ListDocumentsResponse> listDocuments(ListDocumentsRequest param1ListDocumentsRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), param1ListDocumentsRequest);
    }
    
    public ListenableFuture<Empty> rollback(RollbackRequest param1RollbackRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), param1RollbackRequest);
    }
    
    public ListenableFuture<Document> updateDocument(UpdateDocumentRequest param1UpdateDocumentRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), param1UpdateDocumentRequest);
    }
  }
  
  public static abstract class FirestoreImplBase implements BindableService {
    public void batchGetDocuments(BatchGetDocumentsRequest param1BatchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBatchGetDocumentsMethod(), param1StreamObserver);
    }
    
    public void beginTransaction(BeginTransactionRequest param1BeginTransactionRequest, StreamObserver<BeginTransactionResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBeginTransactionMethod(), param1StreamObserver);
    }
    
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(FirestoreGrpc.getServiceDescriptor()).addMethod(FirestoreGrpc.getGetDocumentMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 0))).addMethod(FirestoreGrpc.getListDocumentsMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 1))).addMethod(FirestoreGrpc.getCreateDocumentMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 2))).addMethod(FirestoreGrpc.getUpdateDocumentMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 3))).addMethod(FirestoreGrpc.getDeleteDocumentMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 4))).addMethod(FirestoreGrpc.getBatchGetDocumentsMethod(), ServerCalls.asyncServerStreamingCall(new FirestoreGrpc.MethodHandlers<>(this, 5))).addMethod(FirestoreGrpc.getBeginTransactionMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 6))).addMethod(FirestoreGrpc.getCommitMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 7))).addMethod(FirestoreGrpc.getRollbackMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 8))).addMethod(FirestoreGrpc.getRunQueryMethod(), ServerCalls.asyncServerStreamingCall(new FirestoreGrpc.MethodHandlers<>(this, 9))).addMethod(FirestoreGrpc.getWriteMethod(), ServerCalls.asyncBidiStreamingCall(new FirestoreGrpc.MethodHandlers<>(this, 11))).addMethod(FirestoreGrpc.getListenMethod(), ServerCalls.asyncBidiStreamingCall(new FirestoreGrpc.MethodHandlers<>(this, 12))).addMethod(FirestoreGrpc.getListCollectionIdsMethod(), ServerCalls.asyncUnaryCall(new FirestoreGrpc.MethodHandlers<>(this, 10))).build();
    }
    
    public void commit(CommitRequest param1CommitRequest, StreamObserver<CommitResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCommitMethod(), param1StreamObserver);
    }
    
    public void createDocument(CreateDocumentRequest param1CreateDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCreateDocumentMethod(), param1StreamObserver);
    }
    
    public void deleteDocument(DeleteDocumentRequest param1DeleteDocumentRequest, StreamObserver<Empty> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getDeleteDocumentMethod(), param1StreamObserver);
    }
    
    public void getDocument(GetDocumentRequest param1GetDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getGetDocumentMethod(), param1StreamObserver);
    }
    
    public void listCollectionIds(ListCollectionIdsRequest param1ListCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListCollectionIdsMethod(), param1StreamObserver);
    }
    
    public void listDocuments(ListDocumentsRequest param1ListDocumentsRequest, StreamObserver<ListDocumentsResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListDocumentsMethod(), param1StreamObserver);
    }
    
    public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> param1StreamObserver) {
      return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getListenMethod(), param1StreamObserver);
    }
    
    public void rollback(RollbackRequest param1RollbackRequest, StreamObserver<Empty> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRollbackMethod(), param1StreamObserver);
    }
    
    public void runQuery(RunQueryRequest param1RunQueryRequest, StreamObserver<RunQueryResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRunQueryMethod(), param1StreamObserver);
    }
    
    public void updateDocument(UpdateDocumentRequest param1UpdateDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getUpdateDocumentMethod(), param1StreamObserver);
    }
    
    public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> param1StreamObserver) {
      return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getWriteMethod(), param1StreamObserver);
    }
  }
  
  public static final class FirestoreStub extends AbstractStub<FirestoreStub> {
    private FirestoreStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private FirestoreStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    public void batchGetDocuments(BatchGetDocumentsRequest param1BatchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> param1StreamObserver) {
      ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions()), param1BatchGetDocumentsRequest, param1StreamObserver);
    }
    
    public void beginTransaction(BeginTransactionRequest param1BeginTransactionRequest, StreamObserver<BeginTransactionResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), param1BeginTransactionRequest, param1StreamObserver);
    }
    
    protected FirestoreStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new FirestoreStub(param1Channel, param1CallOptions);
    }
    
    public void commit(CommitRequest param1CommitRequest, StreamObserver<CommitResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), param1CommitRequest, param1StreamObserver);
    }
    
    public void createDocument(CreateDocumentRequest param1CreateDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), param1CreateDocumentRequest, param1StreamObserver);
    }
    
    public void deleteDocument(DeleteDocumentRequest param1DeleteDocumentRequest, StreamObserver<Empty> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), param1DeleteDocumentRequest, param1StreamObserver);
    }
    
    public void getDocument(GetDocumentRequest param1GetDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), param1GetDocumentRequest, param1StreamObserver);
    }
    
    public void listCollectionIds(ListCollectionIdsRequest param1ListCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), param1ListCollectionIdsRequest, param1StreamObserver);
    }
    
    public void listDocuments(ListDocumentsRequest param1ListDocumentsRequest, StreamObserver<ListDocumentsResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), param1ListDocumentsRequest, param1StreamObserver);
    }
    
    public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> param1StreamObserver) {
      return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getListenMethod(), getCallOptions()), param1StreamObserver);
    }
    
    public void rollback(RollbackRequest param1RollbackRequest, StreamObserver<Empty> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), param1RollbackRequest, param1StreamObserver);
    }
    
    public void runQuery(RunQueryRequest param1RunQueryRequest, StreamObserver<RunQueryResponse> param1StreamObserver) {
      ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getRunQueryMethod(), getCallOptions()), param1RunQueryRequest, param1StreamObserver);
    }
    
    public void updateDocument(UpdateDocumentRequest param1UpdateDocumentRequest, StreamObserver<Document> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), param1UpdateDocumentRequest, param1StreamObserver);
    }
    
    public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> param1StreamObserver) {
      return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getWriteMethod(), getCallOptions()), param1StreamObserver);
    }
  }
  
  private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final int methodId;
    
    private final FirestoreGrpc.FirestoreImplBase serviceImpl;
    
    MethodHandlers(FirestoreGrpc.FirestoreImplBase param1FirestoreImplBase, int param1Int) {
      this.serviceImpl = param1FirestoreImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      if (i != 11) {
        if (i == 12)
          return (StreamObserver)this.serviceImpl.listen((StreamObserver)param1StreamObserver); 
        throw new AssertionError();
      } 
      return (StreamObserver)this.serviceImpl.write((StreamObserver)param1StreamObserver);
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      switch (this.methodId) {
        default:
          throw new AssertionError();
        case 10:
          this.serviceImpl.listCollectionIds((ListCollectionIdsRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 9:
          this.serviceImpl.runQuery((RunQueryRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 8:
          this.serviceImpl.rollback((RollbackRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 7:
          this.serviceImpl.commit((CommitRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 6:
          this.serviceImpl.beginTransaction((BeginTransactionRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 5:
          this.serviceImpl.batchGetDocuments((BatchGetDocumentsRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 4:
          this.serviceImpl.deleteDocument((DeleteDocumentRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 3:
          this.serviceImpl.updateDocument((UpdateDocumentRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 2:
          this.serviceImpl.createDocument((CreateDocumentRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 1:
          this.serviceImpl.listDocuments((ListDocumentsRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 0:
          break;
      } 
      this.serviceImpl.getDocument((GetDocumentRequest)param1Req, (StreamObserver)param1StreamObserver);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\FirestoreGrpc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */