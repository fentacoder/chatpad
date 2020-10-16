package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzab;

final class zzq implements zzab {
  zzq(FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {}
  
  public final void zza() {
    if (FirebaseAuth.zze(this.zzb).getUid().equalsIgnoreCase(this.zza.getUid()))
      this.zzb.zza(); 
  }
  
  public final void zza(Status paramStatus) {
    if (paramStatus.getStatusCode() == 17011 || paramStatus.getStatusCode() == 17021 || paramStatus.getStatusCode() == 17005)
      this.zzb.signOut(); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */