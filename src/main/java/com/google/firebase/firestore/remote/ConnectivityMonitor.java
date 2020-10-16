package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Consumer;

public interface ConnectivityMonitor {
  void addCallback(Consumer<NetworkStatus> paramConsumer);
  
  void shutdown();
  
  public enum NetworkStatus {
    REACHABLE, UNREACHABLE;
    
    static {
      $VALUES = new NetworkStatus[] { UNREACHABLE, REACHABLE };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\ConnectivityMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */