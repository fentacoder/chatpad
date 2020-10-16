package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.List;

class FirestoreChannel {
  private static final Metadata.Key<String> RESOURCE_PREFIX_HEADER;
  
  private static final Metadata.Key<String> X_GOOG_API_CLIENT_HEADER = Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
  
  private static final String X_GOOG_API_CLIENT_VALUE = "gl-java/ fire/21.3.1 grpc/";
  
  private final AsyncQueue asyncQueue;
  
  private final GrpcCallProvider callProvider;
  
  private final CredentialsProvider credentialsProvider;
  
  private final GrpcMetadataProvider metadataProvider;
  
  private final String resourcePrefixValue;
  
  static {
    RESOURCE_PREFIX_HEADER = Metadata.Key.of("google-cloud-resource-prefix", Metadata.ASCII_STRING_MARSHALLER);
  }
  
  FirestoreChannel(AsyncQueue paramAsyncQueue, Context paramContext, CredentialsProvider paramCredentialsProvider, DatabaseInfo paramDatabaseInfo, GrpcMetadataProvider paramGrpcMetadataProvider) {
    this.asyncQueue = paramAsyncQueue;
    this.metadataProvider = paramGrpcMetadataProvider;
    this.credentialsProvider = paramCredentialsProvider;
    this.callProvider = new GrpcCallProvider(paramAsyncQueue, paramContext, paramDatabaseInfo, new FirestoreCallCredentials(paramCredentialsProvider));
    DatabaseId databaseId = paramDatabaseInfo.getDatabaseId();
    this.resourcePrefixValue = String.format("projects/%s/databases/%s", new Object[] { databaseId.getProjectId(), databaseId.getDatabaseId() });
  }
  
  private FirebaseFirestoreException exceptionFromStatus(Status paramStatus) {
    return Datastore.isMissingSslCiphers(paramStatus) ? new FirebaseFirestoreException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(paramStatus.getCode().value()), paramStatus.getCause()) : Util.exceptionFromStatus(paramStatus);
  }
  
  private Metadata requestHeaders() {
    Metadata metadata = new Metadata();
    metadata.put(X_GOOG_API_CLIENT_HEADER, "gl-java/ fire/21.3.1 grpc/");
    metadata.put(RESOURCE_PREFIX_HEADER, this.resourcePrefixValue);
    GrpcMetadataProvider grpcMetadataProvider = this.metadataProvider;
    if (grpcMetadataProvider != null)
      grpcMetadataProvider.updateMetadata(metadata); 
    return metadata;
  }
  
  public void invalidateToken() {
    this.credentialsProvider.invalidateToken();
  }
  
  <ReqT, RespT> ClientCall<ReqT, RespT> runBidiStreamingRpc(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, IncomingStreamObserver<RespT> paramIncomingStreamObserver) {
    final ClientCall[] call = new ClientCall[1];
    arrayOfClientCall[0] = null;
    final Task<ClientCall<ReqT, RespT>> clientCall = this.callProvider.createClientCall(paramMethodDescriptor);
    task.addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$1.lambdaFactory$(this, arrayOfClientCall, paramIncomingStreamObserver));
    return (ClientCall<ReqT, RespT>)new ForwardingClientCall<ReqT, RespT>() {
        protected ClientCall<ReqT, RespT> delegate() {
          boolean bool;
          if (call[0] != null) {
            bool = true;
          } else {
            bool = false;
          } 
          Assert.hardAssert(bool, "ClientCall used before onOpen() callback", new Object[0]);
          return call[0];
        }
        
        public void halfClose() {
          if (call[0] == null) {
            clientCall.addOnSuccessListener(FirestoreChannel.this.asyncQueue.getExecutor(), FirestoreChannel$2$$Lambda$1.lambdaFactory$());
          } else {
            super.halfClose();
          } 
        }
      };
  }
  
  <ReqT, RespT> Task<RespT> runRpc(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, ReqT paramReqT) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.callProvider.<ReqT, RespT>createClientCall(paramMethodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$3.lambdaFactory$(this, taskCompletionSource, paramReqT));
    return taskCompletionSource.getTask();
  }
  
  <ReqT, RespT> Task<List<RespT>> runStreamingResponseRpc(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, ReqT paramReqT) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.callProvider.<ReqT, RespT>createClientCall(paramMethodDescriptor).addOnCompleteListener(this.asyncQueue.getExecutor(), FirestoreChannel$$Lambda$2.lambdaFactory$(this, taskCompletionSource, paramReqT));
    return taskCompletionSource.getTask();
  }
  
  public void shutdown() {
    this.callProvider.shutdown();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\FirestoreChannel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */