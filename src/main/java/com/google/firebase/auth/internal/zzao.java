package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzbl;
import com.google.firebase.auth.api.zza;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzao {
  private static final Logger zza = new Logger("JSONParser", new String[0]);
  
  private static List<Object> zza(JSONArray paramJSONArray) throws JSONException {
    ArrayList<Object<String, Object>> arrayList = new ArrayList();
    for (byte b = 0; b < paramJSONArray.length(); b++) {
      Object<String, Object> object2;
      Object<String, Object> object1 = (Object<String, Object>)paramJSONArray.get(b);
      if (object1 instanceof JSONArray) {
        List<Object> list = zza((JSONArray)object1);
      } else {
        object2 = object1;
        if (object1 instanceof JSONObject)
          object2 = (Object<String, Object>)zza((JSONObject)object1); 
      } 
      arrayList.add(object2);
    } 
    return (List)arrayList;
  }
  
  public static Map<String, Object> zza(String paramString) {
    Logger<String> logger;
    Preconditions.checkNotEmpty(paramString);
    List list = zzau.zza('.').zza(paramString);
    if (list.size() < 2) {
      logger = zza;
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Invalid idToken ".concat(paramString);
      } else {
        paramString = new String("Invalid idToken ");
      } 
      logger.e(paramString, new Object[0]);
      return (Map<String, Object>)zzbl.zza();
    } 
    String str = logger.get(1);
    try {
      zzbl zzbl;
      paramString = new String();
      this(Base64Utils.decodeUrlSafeNoPadding(str), "UTF-8");
      Map<String, Object> map2 = zzb(paramString);
      Map<String, Object> map1 = map2;
      if (map2 == null)
        zzbl = zzbl.zza(); 
      return (Map<String, Object>)zzbl;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      zza.e("Unable to decode token", unsupportedEncodingException, new Object[0]);
      return (Map<String, Object>)zzbl.zza();
    } 
  }
  
  private static Map<String, Object> zza(JSONObject paramJSONObject) throws JSONException {
    ArrayMap<String, Object<String, Object>> arrayMap = new ArrayMap();
    Iterator<String> iterator = paramJSONObject.keys();
    while (iterator.hasNext()) {
      Object<String, Object> object2;
      String str = iterator.next();
      Object<String, Object> object1 = (Object<String, Object>)paramJSONObject.get(str);
      if (object1 instanceof JSONArray) {
        List<Object> list = zza((JSONArray)object1);
      } else {
        object2 = object1;
        if (object1 instanceof JSONObject)
          object2 = (Object<String, Object>)zza((JSONObject)object1); 
      } 
      arrayMap.put(str, object2);
    } 
    return (Map)arrayMap;
  }
  
  public static Map<String, Object> zzb(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      return (jSONObject != JSONObject.NULL) ? zza(jSONObject) : null;
    } catch (Exception exception) {
      Log.d("JSONParser", "Failed to parse JSONObject into Map.");
      throw new zza(exception);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */