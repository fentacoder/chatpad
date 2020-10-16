package com.google.firebase.firestore.core;

public class ListenSequence {
  public static final long INVALID = -1L;
  
  private long previousSequenceNumber;
  
  public ListenSequence(long paramLong) {
    this.previousSequenceNumber = paramLong;
  }
  
  public long next() {
    long l = this.previousSequenceNumber + 1L;
    this.previousSequenceNumber = l;
    return l;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ListenSequence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */