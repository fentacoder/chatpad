package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

final class zzck extends zzes<Void, zza> {
  private final zzcz zza;
  
  public zzck(String paramString, ActionCodeSettings paramActionCodeSettings) {
    super(6);
    Preconditions.checkNotEmpty(paramString, "token cannot be null or empty");
    this.zza = new zzcz(paramString, paramActionCodeSettings);
  }
  
  public final String zza() {
    return "sendEmailVerification";
  }
  
  public final TaskApiCall<zzdt, Void> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzcj(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzcj(this)).build();
  }
  
  public final void zze() {
    zzb((ResultT)null);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */