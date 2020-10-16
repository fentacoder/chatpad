package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzay {
  private static final long zzdn = TimeUnit.DAYS.toMillis(7L);
  
  private final long timestamp;
  
  final String zzbv;
  
  private final String zzdo;
  
  private zzay(String paramString1, String paramString2, long paramLong) {
    this.zzbv = paramString1;
    this.zzdo = paramString2;
    this.timestamp = paramLong;
  }
  
  static String zza(String paramString1, String paramString2, long paramLong) {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("token", paramString1);
      jSONObject.put("appVersion", paramString2);
      jSONObject.put("timestamp", paramLong);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      paramString2 = String.valueOf(jSONException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 24);
      stringBuilder.append("Failed to encode token: ");
      stringBuilder.append(paramString2);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      return null;
    } 
  }
  
  static String zzb(zzay paramzzay) {
    return (paramzzay == null) ? null : paramzzay.zzbv;
  }
  
  static zzay zzi(String paramString) {
    StringBuilder stringBuilder;
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith("{"))
      try {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        return new zzay(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
      } catch (JSONException jSONException) {
        String str = String.valueOf(jSONException);
        stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
        stringBuilder.append("Failed to parse token: ");
        stringBuilder.append(str);
        Log.w("FirebaseInstanceId", stringBuilder.toString());
        return null;
      }  
    return new zzay((String)stringBuilder, null, 0L);
  }
  
  final boolean zzj(String paramString) {
    return (System.currentTimeMillis() > this.timestamp + zzdn || !paramString.equals(this.zzdo));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */