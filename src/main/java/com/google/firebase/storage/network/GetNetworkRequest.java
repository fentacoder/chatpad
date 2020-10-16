package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Map;

public class GetNetworkRequest extends NetworkRequest {
  private static final String TAG = "GetNetworkRequest";
  
  public GetNetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp, long paramLong) {
    super(paramUri, paramFirebaseApp);
    if (paramLong != 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bytes=");
      stringBuilder.append(paramLong);
      stringBuilder.append("-");
      setCustomHeader("Range", stringBuilder.toString());
    } 
  }
  
  protected String getAction() {
    return "GET";
  }
  
  protected Map<String, String> getQueryParameters() {
    return Collections.singletonMap("alt", "media");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\GetNetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */