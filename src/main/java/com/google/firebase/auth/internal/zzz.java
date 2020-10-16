package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

final class zzz implements Runnable {
  private final String zzb;
  
  zzz(zzaa paramzzaa, String paramString) {
    this.zzb = Preconditions.checkNotEmpty(paramString);
  }
  
  public final void run() {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
    if (firebaseAuth.getCurrentUser() != null) {
      Task task = firebaseAuth.getAccessToken(true);
      zzaa.zzd().v("Token refreshing started", new Object[0]);
      task.addOnFailureListener(new zzac(this));
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzz.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */