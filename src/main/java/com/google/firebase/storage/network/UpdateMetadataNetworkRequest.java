package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import org.json.JSONObject;

public class UpdateMetadataNetworkRequest extends NetworkRequest {
  private final JSONObject metadata;
  
  public UpdateMetadataNetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp, JSONObject paramJSONObject) {
    super(paramUri, paramFirebaseApp);
    this.metadata = paramJSONObject;
    setCustomHeader("X-HTTP-Method-Override", "PATCH");
  }
  
  protected String getAction() {
    return "PUT";
  }
  
  protected JSONObject getOutputJSON() {
    return this.metadata;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\UpdateMetadataNetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */