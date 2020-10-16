package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

abstract class ResumableNetworkRequest extends NetworkRequest {
  static final String COMMAND = "X-Goog-Upload-Command";
  
  static final String CONTENT_TYPE = "X-Goog-Upload-Header-Content-Type";
  
  static final String OFFSET = "X-Goog-Upload-Offset";
  
  static final String PROTOCOL = "X-Goog-Upload-Protocol";
  
  ResumableNetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp) {
    super(paramUri, paramFirebaseApp);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\ResumableNetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */