package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

public class ResumableUploadQueryRequest extends ResumableNetworkRequest {
  private final Uri uploadURL;
  
  public ResumableUploadQueryRequest(Uri paramUri1, FirebaseApp paramFirebaseApp, Uri paramUri2) {
    super(paramUri1, paramFirebaseApp);
    this.uploadURL = paramUri2;
    setCustomHeader("X-Goog-Upload-Protocol", "resumable");
    setCustomHeader("X-Goog-Upload-Command", "query");
  }
  
  protected String getAction() {
    return "POST";
  }
  
  protected Uri getURL() {
    return this.uploadURL;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\ResumableUploadQueryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */