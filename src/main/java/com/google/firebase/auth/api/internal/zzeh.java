package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

public final class zzeh {
  public static final Api<zzei> zza;
  
  private static final Api.ClientKey<zzdt> zzb = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<zzdt, zzei> zzc = new zzej();
  
  static {
    zza = new Api("InternalFirebaseAuth.FIREBASE_AUTH_API", zzc, zzb);
  }
  
  public static zzau zza(Context paramContext, zzei paramzzei) {
    return new zzau(paramContext, paramzzei);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzeh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */