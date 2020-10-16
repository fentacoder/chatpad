package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzap;

final class zzbi extends zzes<GetTokenResult, zza> {
  private final zzcn zza;
  
  public zzbi(String paramString) {
    super(1);
    Preconditions.checkNotEmpty(paramString, "refresh token cannot be null");
    this.zza = new zzcn(paramString);
  }
  
  public final String zza() {
    return "getAccessToken";
  }
  
  public final TaskApiCall<zzdt, GetTokenResult> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzbh(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzbh(this)).build();
  }
  
  public final void zze() {
    if (TextUtils.isEmpty(this.zzk.zzc()))
      this.zzk.zza(this.zza.zza()); 
    this.zzf.zza(this.zzk, this.zze);
    zzb((ResultT)zzap.zza(this.zzk.zzd()));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzbi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */