package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;

final class zzac implements OnFailureListener {
  zzac(zzz paramzzz) {}
  
  public final void onFailure(Exception paramException) {
    if (paramException instanceof com.google.firebase.FirebaseNetworkException) {
      zzaa.zzd().v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
      this.zza.zza.zzb();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */