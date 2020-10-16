package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;

public class Blob implements Comparable<Blob> {
  private final ByteString bytes;
  
  private Blob(ByteString paramByteString) {
    this.bytes = paramByteString;
  }
  
  public static Blob fromByteString(ByteString paramByteString) {
    Preconditions.checkNotNull(paramByteString, "Provided ByteString must not be null.");
    return new Blob(paramByteString);
  }
  
  public static Blob fromBytes(byte[] paramArrayOfbyte) {
    Preconditions.checkNotNull(paramArrayOfbyte, "Provided bytes array must not be null.");
    return new Blob(ByteString.copyFrom(paramArrayOfbyte));
  }
  
  public int compareTo(Blob paramBlob) {
    int i = Math.min(this.bytes.size(), paramBlob.bytes.size());
    for (byte b = 0; b < i; b++) {
      int j = this.bytes.byteAt(b) & 0xFF;
      int k = paramBlob.bytes.byteAt(b) & 0xFF;
      if (j < k)
        return -1; 
      if (j > k)
        return 1; 
    } 
    return Util.compareIntegers(this.bytes.size(), paramBlob.bytes.size());
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof Blob && this.bytes.equals(((Blob)paramObject).bytes)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.bytes.hashCode();
  }
  
  public ByteString toByteString() {
    return this.bytes;
  }
  
  public byte[] toBytes() {
    return this.bytes.toByteArray();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blob { bytes=");
    stringBuilder.append(Util.toDebugString(this.bytes));
    stringBuilder.append(" }");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\Blob.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */