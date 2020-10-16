package com.google.firebase.firestore.remote;

import io.grpc.Status;

public interface Stream<CallbackType extends Stream.StreamCallback> {
  void inhibitBackoff();
  
  boolean isOpen();
  
  boolean isStarted();
  
  void start();
  
  void stop();
  
  public enum State {
    Backoff, Error, Initial, Open, Starting;
    
    static {
      Error = new State("Error", 3);
      Backoff = new State("Backoff", 4);
      $VALUES = new State[] { Initial, Starting, Open, Error, Backoff };
    }
  }
  
  public static interface StreamCallback {
    void onClose(Status param1Status);
    
    void onOpen();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\Stream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */