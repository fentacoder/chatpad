package com.google.firebase.firestore.local;

public enum QueryPurpose {
  EXISTENCE_FILTER_MISMATCH, LIMBO_RESOLUTION, LISTEN;
  
  static {
    EXISTENCE_FILTER_MISMATCH = new QueryPurpose("EXISTENCE_FILTER_MISMATCH", 1);
    LIMBO_RESOLUTION = new QueryPurpose("LIMBO_RESOLUTION", 2);
    $VALUES = new QueryPurpose[] { LISTEN, EXISTENCE_FILTER_MISMATCH, LIMBO_RESOLUTION };
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\QueryPurpose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */