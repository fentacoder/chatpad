package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.util.Logger;
import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.concurrent.Executor;

final class FirestoreCallCredentials extends CallCredentials {
  private static final Metadata.Key<String> AUTHORIZATION_HEADER = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
  
  private static final String LOG_TAG = "FirestoreCallCredentials";
  
  private final CredentialsProvider credentialsProvider;
  
  FirestoreCallCredentials(CredentialsProvider paramCredentialsProvider) {
    this.credentialsProvider = paramCredentialsProvider;
  }
  
  public void applyRequestMetadata(CallCredentials.RequestInfo paramRequestInfo, Executor paramExecutor, CallCredentials.MetadataApplier paramMetadataApplier) {
    this.credentialsProvider.getToken().addOnSuccessListener(paramExecutor, FirestoreCallCredentials$$Lambda$1.lambdaFactory$(paramMetadataApplier)).addOnFailureListener(paramExecutor, FirestoreCallCredentials$$Lambda$2.lambdaFactory$(paramMetadataApplier));
  }
  
  public void thisUsesUnstableApi() {}
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\FirestoreCallCredentials.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */