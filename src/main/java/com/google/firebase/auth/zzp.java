package com.google.firebase.auth;

import java.util.Iterator;

final class zzp implements Runnable {
  zzp(FirebaseAuth paramFirebaseAuth) {}
  
  public final void run() {
    Iterator<FirebaseAuth.AuthStateListener> iterator = FirebaseAuth.zzc(this.zza).iterator();
    while (iterator.hasNext())
      ((FirebaseAuth.AuthStateListener)iterator.next()).onAuthStateChanged(this.zza); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */