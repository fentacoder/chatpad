package com.google.firebase.firestore.remote;

import io.grpc.Metadata;
import io.grpc.Status;

interface IncomingStreamObserver<RespT> {
  void onClose(Status paramStatus);
  
  void onHeaders(Metadata paramMetadata);
  
  void onNext(RespT paramRespT);
  
  void onOpen();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\IncomingStreamObserver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */