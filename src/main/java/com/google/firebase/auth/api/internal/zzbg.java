package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzx;

final class zzbg extends zzes<SignInMethodQueryResult, zza> {
  private final zzcp zza;
  
  public zzbg(String paramString1, String paramString2) {
    super(3);
    Preconditions.checkNotEmpty(paramString1, "email cannot be null or empty");
    this.zza = new zzcp(paramString1, paramString2);
  }
  
  public final String zza() {
    return "fetchSignInMethodsForEmail";
  }
  
  public final TaskApiCall<zzdt, SignInMethodQueryResult> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzbf(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzbf(this)).build();
  }
  
  public final void zze() {
    zzb((ResultT)new zzx(this.zzm.zzb()));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzbg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */