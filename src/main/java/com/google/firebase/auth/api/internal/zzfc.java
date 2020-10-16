package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public final class zzfc<ResultT, CallbackT> implements zzet<ResultT> {
  private final zzes<ResultT, CallbackT> zza;
  
  private final TaskCompletionSource<ResultT> zzb;
  
  public zzfc(zzes<ResultT, CallbackT> paramzzes, TaskCompletionSource<ResultT> paramTaskCompletionSource) {
    this.zza = paramzzes;
    this.zzb = paramTaskCompletionSource;
  }
  
  public final void zza(ResultT paramResultT, Status paramStatus) {
    Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
    if (paramStatus != null) {
      TaskCompletionSource<ResultT> taskCompletionSource;
      if (this.zza.zzt != null) {
        taskCompletionSource = this.zzb;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(this.zza.zzd);
        zzej zzej = this.zza.zzt;
        if ("reauthenticateWithCredential".equals(this.zza.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
          FirebaseUser firebaseUser = this.zza.zze;
        } else {
          paramResultT = null;
        } 
        taskCompletionSource.setException((Exception)zzdv.zza(firebaseAuth, zzej, (FirebaseUser)paramResultT));
        return;
      } 
      if (this.zza.zzq != null) {
        this.zzb.setException((Exception)zzdv.zza((Status)taskCompletionSource, this.zza.zzq, this.zza.zzr, this.zza.zzs));
        return;
      } 
      this.zzb.setException((Exception)zzdv.zza((Status)taskCompletionSource));
      return;
    } 
    this.zzb.setResult(paramResultT);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzfc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */