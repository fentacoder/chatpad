package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzae;

final class zzo implements zza, zzae {
  zzo(FirebaseAuth paramFirebaseAuth) {}
  
  public final void zza(Status paramStatus) {
    int i = paramStatus.getStatusCode();
    if (i == 17011 || i == 17021 || i == 17005)
      this.zza.signOut(); 
  }
  
  public final void zza(zzff paramzzff, FirebaseUser paramFirebaseUser) {
    this.zza.zza(paramFirebaseUser, paramzzff, true, true);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */