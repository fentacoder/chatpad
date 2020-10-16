package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zzax implements BackgroundDetector.BackgroundStateChangeListener {
  zzax(zzau paramzzau) {}
  
  public final void onBackgroundStateChanged(boolean paramBoolean) {
    if (paramBoolean) {
      zzau.zza(this.zza, true);
      this.zza.zza();
      return;
    } 
    zzau.zza(this.zza, false);
    if (zzau.zza(this.zza))
      zzau.zzb(this.zza).zza(); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzax.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */