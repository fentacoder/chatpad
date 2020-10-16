package com.google.firebase.firestore;

public enum Source {
  CACHE, DEFAULT, SERVER;
  
  static {
    CACHE = new Source("CACHE", 2);
    $VALUES = new Source[] { DEFAULT, SERVER, CACHE };
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\Source.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */