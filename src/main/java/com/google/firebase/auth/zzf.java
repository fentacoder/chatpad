package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbl;
import java.util.Set;

public final class zzf {
  private static final zzbl<String, Integer> zzg = (new zzbk()).zza("recoverEmail", Integer.valueOf(2)).zza("resetPassword", Integer.valueOf(0)).zza("signIn", Integer.valueOf(4)).zza("verifyEmail", Integer.valueOf(1)).zza("verifyBeforeChangeEmail", Integer.valueOf(5)).zza("revertSecondFactorAddition", Integer.valueOf(6)).zza();
  
  private final String zza;
  
  private final String zzb;
  
  private final String zzc;
  
  private final String zzd;
  
  private final String zze;
  
  private final String zzf;
  
  private zzf(String paramString) {
    this.zza = zza(paramString, "apiKey");
    this.zzb = zza(paramString, "oobCode");
    this.zzc = zza(paramString, "mode");
    if (this.zza != null && this.zzb != null && this.zzc != null) {
      this.zzd = zza(paramString, "continueUrl");
      this.zze = zza(paramString, "languageCode");
      this.zzf = zza(paramString, "tenantId");
      return;
    } 
    throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", new Object[] { "apiKey", "oobCode", "mode" }));
  }
  
  public static zzf zza(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    try {
      return new zzf(paramString);
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    } 
  }
  
  private static String zza(String paramString1, String paramString2) {
    Uri uri = Uri.parse(paramString1);
    try {
      Set set = uri.getQueryParameterNames();
      if (set.contains(paramString2))
        return uri.getQueryParameter(paramString2); 
      if (set.contains("link"))
        return Uri.parse(uri.getQueryParameter("link")).getQueryParameter(paramString2); 
    } catch (UnsupportedOperationException unsupportedOperationException) {}
    return null;
  }
  
  public final int zza() {
    return ((Integer)zzg.getOrDefault(this.zzc, Integer.valueOf(3))).intValue();
  }
  
  public final String zzb() {
    return this.zzb;
  }
  
  public final String zzc() {
    return this.zzf;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */