package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

public class DeleteNetworkRequest extends NetworkRequest {
  public DeleteNetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp) {
    super(paramUri, paramFirebaseApp);
  }
  
  protected String getAction() {
    return "DELETE";
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\DeleteNetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */