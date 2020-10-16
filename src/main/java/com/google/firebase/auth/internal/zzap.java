package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzbl;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.api.zza;
import java.util.Map;

public final class zzap {
  private static final Logger zza = new Logger("GetTokenResultFactory", new String[0]);
  
  public static GetTokenResult zza(String paramString) {
    zzbl zzbl;
    try {
      Map<String, Object> map = zzao.zza(paramString);
    } catch (zza zza) {
      zza.e("Error parsing token claims", (Throwable)zza, new Object[0]);
      zzbl = zzbl.zza();
    } 
    return new GetTokenResult(paramString, (Map)zzbl);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */