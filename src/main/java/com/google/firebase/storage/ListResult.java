package com.google.firebase.storage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ListResult {
  private static final String ITEMS_KEY = "items";
  
  private static final String NAME_KEY = "name";
  
  private static final String PAGE_TOKEN_KEY = "nextPageToken";
  
  private static final String PREFIXES_KEY = "prefixes";
  
  private final List<StorageReference> items;
  
  private final String pageToken;
  
  private final List<StorageReference> prefixes;
  
  ListResult(List<StorageReference> paramList1, List<StorageReference> paramList2, String paramString) {
    this.prefixes = paramList1;
    this.items = paramList2;
    this.pageToken = paramString;
  }
  
  static ListResult fromJSON(FirebaseStorage paramFirebaseStorage, JSONObject paramJSONObject) throws JSONException {
    ArrayList<StorageReference> arrayList1 = new ArrayList();
    ArrayList<StorageReference> arrayList2 = new ArrayList();
    boolean bool = paramJSONObject.has("prefixes");
    byte b = 0;
    if (bool) {
      JSONArray jSONArray = paramJSONObject.getJSONArray("prefixes");
      for (byte b1 = 0; b1 < jSONArray.length(); b1++) {
        String str1 = jSONArray.getString(b1);
        String str2 = str1;
        if (str1.endsWith("/"))
          str2 = str1.substring(0, str1.length() - 1); 
        arrayList1.add(paramFirebaseStorage.getReference(str2));
      } 
    } 
    if (paramJSONObject.has("items")) {
      JSONArray jSONArray = paramJSONObject.getJSONArray("items");
      for (byte b1 = b; b1 < jSONArray.length(); b1++)
        arrayList2.add(paramFirebaseStorage.getReference(jSONArray.getJSONObject(b1).getString("name"))); 
    } 
    return new ListResult(arrayList1, arrayList2, paramJSONObject.optString("nextPageToken", null));
  }
  
  public List<StorageReference> getItems() {
    return this.items;
  }
  
  public String getPageToken() {
    return this.pageToken;
  }
  
  public List<StorageReference> getPrefixes() {
    return this.prefixes;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\ListResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */