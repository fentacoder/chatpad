package com.google.firebase.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.Iterator;

final class zzm implements Runnable {
  zzm(FirebaseAuth paramFirebaseAuth, InternalTokenResult paramInternalTokenResult) {}
  
  public final void run() {
    Iterator<IdTokenListener> iterator = FirebaseAuth.zza(this.zzb).iterator();
    while (iterator.hasNext())
      ((IdTokenListener)iterator.next()).onIdTokenChanged(this.zza); 
    iterator = FirebaseAuth.zzb(this.zzb).iterator();
    while (iterator.hasNext())
      ((FirebaseAuth.IdTokenListener)iterator.next()).onIdTokenChanged(this.zzb); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */