package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzg;

final class zzay extends zzes<ActionCodeResult, zza> {
  private final zzcb zza;
  
  public zzay(String paramString1, String paramString2) {
    super(4);
    Preconditions.checkNotEmpty(paramString1, "code cannot be null or empty");
    this.zza = new zzcb(paramString1, paramString2);
  }
  
  public final String zza() {
    return "checkActionCode";
  }
  
  public final TaskApiCall<zzdt, ActionCodeResult> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzax(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzax(this)).build();
  }
  
  public final void zze() {
    zzb((ResultT)new zzg(this.zzn));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */