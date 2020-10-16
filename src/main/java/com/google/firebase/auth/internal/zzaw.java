package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.firebase_auth.zzj;
import java.util.concurrent.Executor;

public final class zzaw implements Executor {
  private static zzaw zza = new zzaw();
  
  private Handler zzb = (Handler)new zzj(Looper.getMainLooper());
  
  public static zzaw zza() {
    return zza;
  }
  
  public final void execute(Runnable paramRunnable) {
    this.zzb.post(paramRunnable);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzaw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */