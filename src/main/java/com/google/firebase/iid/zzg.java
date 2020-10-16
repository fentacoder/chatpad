package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzg extends Binder {
  private final zzc zzae;
  
  zzg(zzc paramzzc) {
    this.zzae = paramzzc;
  }
  
  public final void zza(zze paramzze) {
    if (Binder.getCallingUid() == Process.myUid()) {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "service received new intent via bind strategy"); 
      if (this.zzae.zzc(paramzze.intent)) {
        paramzze.finish();
        return;
      } 
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "intent being queued for bg execution"); 
      this.zzae.zzt.execute(new zzf(this, paramzze));
      return;
    } 
    throw new SecurityException("Binding only allowed within app");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */