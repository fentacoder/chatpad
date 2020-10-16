package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ResumableUploadStartRequest extends ResumableNetworkRequest {
  private final String contentType;
  
  private final JSONObject metadata;
  
  public ResumableUploadStartRequest(Uri paramUri, FirebaseApp paramFirebaseApp, JSONObject paramJSONObject, String paramString) {
    super(paramUri, paramFirebaseApp);
    this.metadata = paramJSONObject;
    this.contentType = paramString;
    if (TextUtils.isEmpty(this.contentType))
      this.mException = new IllegalArgumentException("mContentType is null or empty"); 
    setCustomHeader("X-Goog-Upload-Protocol", "resumable");
    setCustomHeader("X-Goog-Upload-Command", "start");
    setCustomHeader("X-Goog-Upload-Header-Content-Type", this.contentType);
  }
  
  protected String getAction() {
    return "POST";
  }
  
  protected JSONObject getOutputJSON() {
    return this.metadata;
  }
  
  protected Map<String, String> getQueryParameters() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("name", getPathWithoutBucket());
    hashMap.put("uploadType", "resumable");
    return (Map)hashMap;
  }
  
  protected Uri getURL() {
    Uri.Builder builder = sNetworkRequestUrl.buildUpon();
    builder.appendPath("b");
    builder.appendPath(this.mGsUri.getAuthority());
    builder.appendPath("o");
    return builder.build();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\ResumableUploadStartRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */