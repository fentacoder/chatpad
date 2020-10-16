package com.google.firebase.firestore.remote;

import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.grpc.Metadata;

public class FirebaseClientGrpcMetadataProvider implements GrpcMetadataProvider {
  private static final Metadata.Key<String> HEART_BEAT_HEADER = Metadata.Key.of("x-firebase-client-log-type", Metadata.ASCII_STRING_MARSHALLER);
  
  private static final Metadata.Key<String> USER_AGENT_HEADER = Metadata.Key.of("x-firebase-client", Metadata.ASCII_STRING_MARSHALLER);
  
  private final String firebaseFirestoreHeartBeatTag = "fire-fst";
  
  private final Provider<HeartBeatInfo> heartBeatInfoProvider;
  
  private final Provider<UserAgentPublisher> userAgentPublisherProvider;
  
  public FirebaseClientGrpcMetadataProvider(Provider<UserAgentPublisher> paramProvider, Provider<HeartBeatInfo> paramProvider1) {
    this.userAgentPublisherProvider = paramProvider;
    this.heartBeatInfoProvider = paramProvider1;
  }
  
  public void updateMetadata(Metadata paramMetadata) {
    if (this.heartBeatInfoProvider.get() != null && this.userAgentPublisherProvider.get() != null) {
      int i = ((HeartBeatInfo)this.heartBeatInfoProvider.get()).getHeartBeatCode("fire-fst").getCode();
      if (i != 0) {
        paramMetadata.put(HEART_BEAT_HEADER, Integer.toString(i));
        paramMetadata.put(USER_AGENT_HEADER, ((UserAgentPublisher)this.userAgentPublisherProvider.get()).getUserAgent());
      } 
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\FirebaseClientGrpcMetadataProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */