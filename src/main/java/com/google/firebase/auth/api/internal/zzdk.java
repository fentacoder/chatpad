package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcv;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;

final class zzdk extends zzes<Void, zza> {
  private final PhoneAuthCredential zza;
  
  public zzdk(PhoneAuthCredential paramPhoneAuthCredential) {
    super(2);
    this.zza = (PhoneAuthCredential)Preconditions.checkNotNull(paramPhoneAuthCredential);
  }
  
  public final String zza() {
    return "updatePhoneNumber";
  }
  
  public final TaskApiCall<zzdt, Void> zzb() {
    TaskApiCall.Builder builder = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
    if (this.zzu || this.zzv) {
      Feature[] arrayOfFeature1 = null;
      return builder.setFeatures(arrayOfFeature1).run(new zzdj(this)).build();
    } 
    Feature[] arrayOfFeature = new Feature[1];
    arrayOfFeature[0] = zze.zza;
    return builder.setFeatures(arrayOfFeature).run(new zzdj(this)).build();
  }
  
  public final void zze() {
    this.zzf.zza(this.zzk, (FirebaseUser)zzau.zza(this.zzd, this.zzl));
    zzb((ResultT)null);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */