package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzg;

final class zzdo extends zzes<String, zza> {
  private final zzcb zza;
  
  public zzdo(String paramString1, String paramString2) {
    super(4);
    Preconditions.checkNotEmpty(paramString1, "code cannot be null or empty");
    this.zza = new zzcb(paramString1, paramString2);
  }
  
  public final String zza() {
    return "verifyPasswordResetCode";
  }
  
  public final TaskApiCall<zzdt, String> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzdn(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzdn(this)).build();
  }
  
  public final void zze() {
    if ((new zzg(this.zzn)).getOperation() != 0) {
      zza(new Status(17499));
      return;
    } 
    zzb((ResultT)this.zzn.zzb());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */