package com.google.firebase.firestore.remote;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.WriteResult;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Datastore {
  static final String SSL_DEPENDENCY_ERROR_MESSAGE = "The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.";
  
  static final Set<String> WHITE_LISTED_HEADERS = new HashSet<>(Arrays.asList(new String[] { "date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace" }));
  
  private final FirestoreChannel channel;
  
  private final DatabaseInfo databaseInfo;
  
  private final RemoteSerializer serializer;
  
  private final AsyncQueue workerQueue;
  
  public Datastore(DatabaseInfo paramDatabaseInfo, AsyncQueue paramAsyncQueue, CredentialsProvider paramCredentialsProvider, Context paramContext, GrpcMetadataProvider paramGrpcMetadataProvider) {
    this.databaseInfo = paramDatabaseInfo;
    this.workerQueue = paramAsyncQueue;
    this.serializer = new RemoteSerializer(paramDatabaseInfo.getDatabaseId());
    this.channel = new FirestoreChannel(paramAsyncQueue, paramContext, paramCredentialsProvider, paramDatabaseInfo, paramGrpcMetadataProvider);
  }
  
  public static boolean isMissingSslCiphers(Status paramStatus) {
    boolean bool2;
    Status.Code code = paramStatus.getCode();
    Throwable throwable = paramStatus.getCause();
    boolean bool = throwable instanceof javax.net.ssl.SSLHandshakeException;
    boolean bool1 = true;
    if (bool && throwable.getMessage().contains("no ciphers available")) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (Build.VERSION.SDK_INT >= 21 || !code.equals(Status.Code.UNAVAILABLE) || !bool2)
      bool1 = false; 
    return bool1;
  }
  
  public static boolean isPermanentError(FirebaseFirestoreException.Code paramCode) {
    StringBuilder stringBuilder;
    switch (paramCode) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown gRPC status code: ");
        stringBuilder.append(paramCode);
        throw new IllegalArgumentException(stringBuilder.toString());
      case INVALID_ARGUMENT:
      case NOT_FOUND:
      case ALREADY_EXISTS:
      case PERMISSION_DENIED:
      case FAILED_PRECONDITION:
      case ABORTED:
      case OUT_OF_RANGE:
      case UNIMPLEMENTED:
      case DATA_LOSS:
        return true;
      case CANCELLED:
      case UNKNOWN:
      case DEADLINE_EXCEEDED:
      case RESOURCE_EXHAUSTED:
      case INTERNAL:
      case UNAVAILABLE:
      case UNAUTHENTICATED:
        return false;
      case OK:
        break;
    } 
    throw new IllegalArgumentException("Treated status OK as error");
  }
  
  public static boolean isPermanentError(Status paramStatus) {
    return isPermanentError(FirebaseFirestoreException.Code.fromValue(paramStatus.getCode().value()));
  }
  
  public static boolean isPermanentWriteError(Status paramStatus) {
    boolean bool;
    if (isPermanentError(paramStatus) && !paramStatus.getCode().equals(Status.Code.ABORTED)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Task<List<MutationResult>> commit(List<Mutation> paramList) {
    CommitRequest.Builder builder = CommitRequest.newBuilder();
    builder.setDatabase(this.serializer.databaseName());
    for (Mutation mutation : paramList)
      builder.addWrites(this.serializer.encodeMutation(mutation)); 
    return this.channel.<CommitRequest, RespT>runRpc(FirestoreGrpc.getCommitMethod(), (CommitRequest)builder.build()).continueWith(this.workerQueue.getExecutor(), Datastore$$Lambda$1.lambdaFactory$(this));
  }
  
  WatchStream createWatchStream(WatchStream.Callback paramCallback) {
    return new WatchStream(this.channel, this.workerQueue, this.serializer, paramCallback);
  }
  
  WriteStream createWriteStream(WriteStream.Callback paramCallback) {
    return new WriteStream(this.channel, this.workerQueue, this.serializer, paramCallback);
  }
  
  DatabaseInfo getDatabaseInfo() {
    return this.databaseInfo;
  }
  
  AsyncQueue getWorkerQueue() {
    return this.workerQueue;
  }
  
  public Task<List<MaybeDocument>> lookup(List<DocumentKey> paramList) {
    BatchGetDocumentsRequest.Builder builder = BatchGetDocumentsRequest.newBuilder();
    builder.setDatabase(this.serializer.databaseName());
    for (DocumentKey documentKey : paramList)
      builder.addDocuments(this.serializer.encodeKey(documentKey)); 
    return this.channel.<BatchGetDocumentsRequest, RespT>runStreamingResponseRpc(FirestoreGrpc.getBatchGetDocumentsMethod(), (BatchGetDocumentsRequest)builder.build()).continueWith(this.workerQueue.getExecutor(), Datastore$$Lambda$2.lambdaFactory$(this, paramList));
  }
  
  void shutdown() {
    this.channel.shutdown();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\Datastore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */