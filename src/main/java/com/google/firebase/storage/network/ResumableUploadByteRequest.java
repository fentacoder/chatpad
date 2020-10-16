package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

public class ResumableUploadByteRequest extends ResumableNetworkRequest {
  private final int bytesToWrite;
  
  private final byte[] chunk;
  
  private final boolean isFinal;
  
  private final long offset;
  
  private final Uri uploadURL;
  
  public ResumableUploadByteRequest(Uri paramUri1, FirebaseApp paramFirebaseApp, Uri paramUri2, byte[] paramArrayOfbyte, long paramLong, int paramInt, boolean paramBoolean) {
    super(paramUri1, paramFirebaseApp);
    if (paramArrayOfbyte == null && paramInt != -1)
      this.mException = new IllegalArgumentException("contentType is null or empty"); 
    if (paramLong < 0L)
      this.mException = new IllegalArgumentException("offset cannot be negative"); 
    this.bytesToWrite = paramInt;
    this.uploadURL = paramUri2;
    if (paramInt <= 0)
      paramArrayOfbyte = null; 
    this.chunk = paramArrayOfbyte;
    this.offset = paramLong;
    this.isFinal = paramBoolean;
    setCustomHeader("X-Goog-Upload-Protocol", "resumable");
    if (this.isFinal && this.bytesToWrite > 0) {
      setCustomHeader("X-Goog-Upload-Command", "upload, finalize");
    } else if (this.isFinal) {
      setCustomHeader("X-Goog-Upload-Command", "finalize");
    } else {
      setCustomHeader("X-Goog-Upload-Command", "upload");
    } 
    setCustomHeader("X-Goog-Upload-Offset", Long.toString(this.offset));
  }
  
  protected String getAction() {
    return "POST";
  }
  
  protected byte[] getOutputRaw() {
    return this.chunk;
  }
  
  protected int getOutputRawSize() {
    int i = this.bytesToWrite;
    if (i <= 0)
      i = 0; 
    return i;
  }
  
  protected Uri getURL() {
    return this.uploadURL;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\ResumableUploadByteRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */