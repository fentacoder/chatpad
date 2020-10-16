package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;

public class ListNetworkRequest extends NetworkRequest {
  private final Integer maxPageSize;
  
  private final String nextPageToken;
  
  public ListNetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp, Integer paramInteger, String paramString) {
    super(paramUri, paramFirebaseApp);
    this.maxPageSize = paramInteger;
    this.nextPageToken = paramString;
  }
  
  protected String getAction() {
    return "GET";
  }
  
  protected Map<String, String> getQueryParameters() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    String str = getPathWithoutBucket();
    if (!str.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("/");
      hashMap.put("prefix", stringBuilder.toString());
    } 
    hashMap.put("delimiter", "/");
    Integer integer = this.maxPageSize;
    if (integer != null)
      hashMap.put("maxResults", Integer.toString(integer.intValue())); 
    if (!TextUtils.isEmpty(this.nextPageToken))
      hashMap.put("pageToken", this.nextPageToken); 
    return (Map)hashMap;
  }
  
  protected Uri getURL() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(sNetworkRequestUrl);
    stringBuilder.append("/b/");
    stringBuilder.append(this.mGsUri.getAuthority());
    stringBuilder.append("/o");
    return Uri.parse(stringBuilder.toString());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\ListNetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */