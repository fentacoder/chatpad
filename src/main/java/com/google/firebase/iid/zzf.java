package com.google.firebase.iid;

import android.util.Log;

final class zzf implements Runnable {
  zzf(zzg paramzzg, zze paramzze) {}
  
  public final void run() {
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "bg processing of the intent starting now"); 
    zzg.zza(this.zzad).zzd(this.zzac.intent);
    this.zzac.finish();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */