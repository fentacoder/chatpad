package com.google.firebase.firestore.core;

public enum OnlineState {
  OFFLINE, ONLINE, UNKNOWN;
  
  static {
    ONLINE = new OnlineState("ONLINE", 1);
    OFFLINE = new OnlineState("OFFLINE", 2);
    $VALUES = new OnlineState[] { UNKNOWN, ONLINE, OFFLINE };
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\OnlineState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */