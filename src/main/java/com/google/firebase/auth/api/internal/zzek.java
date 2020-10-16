package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.firebase_auth.zzau;
import java.util.List;

public final class zzek {
  private final String zza;
  
  private final int zzb;
  
  private final int zzc;
  
  private zzek(String paramString, int paramInt) {
    this.zza = paramString;
    this.zzb = zzd(paramString);
    this.zzc = -1;
  }
  
  static String zzb() {
    return zzc("firebase-auth");
  }
  
  static zzek zzc() {
    return new zzek(zzc("firebase-auth-compat"), -1);
  }
  
  private static String zzc(String paramString) {
    String str = LibraryVersion.getInstance().getVersion(paramString);
    if (!TextUtils.isEmpty(str)) {
      paramString = str;
      return str.equals("UNKNOWN") ? "-1" : paramString;
    } 
    return "-1";
  }
  
  private static int zzd(String paramString) {
    try {
      List<String> list = zzau.zza("[.-]").zza(paramString);
      if (list.size() == 1)
        return Integer.parseInt(paramString); 
      if (list.size() >= 3) {
        int i = Integer.parseInt(list.get(0));
        int j = Integer.parseInt(list.get(1));
        int k = Integer.parseInt(list.get(2));
        return i * 1000000 + j * 1000 + k;
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      if (Log.isLoggable("LibraryVersionContainer", 3))
        Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", new Object[] { paramString, illegalArgumentException })); 
    } 
    return -1;
  }
  
  public final String zza() {
    int i = this.zzb;
    return (i != -1) ? String.format("X%s", new Object[] { Integer.toString(i) }) : Integer.toString(this.zzc);
  }
  
  final boolean zza(String paramString) {
    return (this.zzb >= zzd(paramString));
  }
  
  final boolean zzb(String paramString) {
    return (this.zzb >= zzd(paramString));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzek.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */