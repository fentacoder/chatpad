package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.zza;
import com.google.firebase.auth.zzaf;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzav {
  private Context zza;
  
  private String zzb;
  
  private SharedPreferences zzc;
  
  private Logger zzd;
  
  public zzav(Context paramContext, String paramString) {
    Preconditions.checkNotNull(paramContext);
    this.zzb = Preconditions.checkNotEmpty(paramString);
    this.zza = paramContext.getApplicationContext();
    String str = String.format("com.google.firebase.auth.api.Store.%s", new Object[] { this.zzb });
    this.zzc = this.zza.getSharedPreferences(str, 0);
    this.zzd = new Logger("StorageHelpers", new String[0]);
  }
  
  private final zzn zza(JSONObject paramJSONObject) {
    try {
      String str1 = paramJSONObject.getString("cachedTokenState");
      String str2 = paramJSONObject.getString("applicationName");
      boolean bool = paramJSONObject.getBoolean("anonymous");
      String str3 = "2";
      String str4 = paramJSONObject.getString("version");
      if (str4 != null)
        str3 = str4; 
      JSONArray jSONArray = paramJSONObject.getJSONArray("userInfos");
      int i = jSONArray.length();
      ArrayList<zzj> arrayList = new ArrayList();
      this(i);
      boolean bool1 = false;
      byte b;
      for (b = 0; b < i; b++)
        arrayList.add(zzj.zza(jSONArray.getString(b))); 
      FirebaseApp firebaseApp = FirebaseApp.getInstance(str2);
      zzn zzn = new zzn();
      this(firebaseApp, (List)arrayList);
      if (!TextUtils.isEmpty(str1))
        zzn.zza(zzff.zzb(str1)); 
      if (!bool)
        zzn.zzb(); 
      zzn.zza(str3);
      if (paramJSONObject.has("userMetadata")) {
        zzp zzp = zzp.zza(paramJSONObject.getJSONObject("userMetadata"));
        if (zzp != null)
          zzn.zza(zzp); 
      } 
      if (paramJSONObject.has("userMultiFactorInfo")) {
        JSONArray jSONArray1 = paramJSONObject.getJSONArray("userMultiFactorInfo");
        if (jSONArray1 != null) {
          ArrayList<String> arrayList1 = new ArrayList();
          this();
          for (b = bool1; b < jSONArray1.length(); b++) {
            String str = jSONArray1.getString(b);
            JSONObject jSONObject = new JSONObject();
            this(str);
            if ("phone".equals(jSONObject.optString("factorIdKey"))) {
              zzaf zzaf = zzaf.zza(jSONObject);
            } else {
              str = null;
            } 
            arrayList1.add(str);
          } 
          zzn.zzb(arrayList1);
        } 
      } 
      return zzn;
    } catch (JSONException jSONException) {
    
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (zza zza) {}
    this.zzd.wtf((Throwable)zza);
    return null;
  }
  
  private final String zzc(FirebaseUser paramFirebaseUser) {
    JSONObject jSONObject = new JSONObject();
    if (zzn.class.isAssignableFrom(paramFirebaseUser.getClass())) {
      zzn zzn = (zzn)paramFirebaseUser;
      try {
        jSONObject.put("cachedTokenState", zzn.zzf());
        jSONObject.put("applicationName", zzn.zzc().getName());
        jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
        if (zzn.zzi() != null) {
          JSONArray jSONArray = new JSONArray();
          this();
          List<zzj> list1 = zzn.zzi();
          for (byte b = 0; b < list1.size(); b++)
            jSONArray.put(((zzj)list1.get(b)).zzb()); 
          jSONObject.put("userInfos", jSONArray);
        } 
        jSONObject.put("anonymous", zzn.isAnonymous());
        jSONObject.put("version", "2");
        if (zzn.getMetadata() != null)
          jSONObject.put("userMetadata", ((zzp)zzn.getMetadata()).zza()); 
        List<zzy> list = ((zzr)zzn.zzh()).zza();
        if (list != null && !list.isEmpty()) {
          JSONArray jSONArray = new JSONArray();
          this();
          for (byte b = 0; b < list.size(); b++)
            jSONArray.put(((zzy)list.get(b)).zza()); 
          jSONObject.put("userMultiFactorInfo", jSONArray);
        } 
        return jSONObject.toString();
      } catch (Exception exception) {
        this.zzd.wtf("Failed to turn object into JSON", exception, new Object[0]);
        throw new zza(exception);
      } 
    } 
    return null;
  }
  
  public final FirebaseUser zza() {
    String str = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
    if (TextUtils.isEmpty(str))
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(str);
      if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type")))
        return zza(jSONObject); 
    } catch (Exception exception) {}
    return null;
  }
  
  public final void zza(FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramFirebaseUser);
    String str = zzc(paramFirebaseUser);
    if (!TextUtils.isEmpty(str))
      this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply(); 
  }
  
  public final void zza(FirebaseUser paramFirebaseUser, zzff paramzzff) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramzzff);
    this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[] { paramFirebaseUser.getUid() }), paramzzff.zzh()).apply();
  }
  
  public final void zza(String paramString) {
    this.zzc.edit().remove(paramString).apply();
  }
  
  public final zzff zzb(FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramFirebaseUser);
    String str = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[] { paramFirebaseUser.getUid() }), null);
    return (str != null) ? zzff.zzb(str) : null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzav.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */