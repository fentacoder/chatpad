package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzf implements AppMeasurement.OnEventListener {
  public zzf(zzc paramzzc) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    if (!this.zza.zza.contains(paramString2))
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("events", zzd.zze(paramString2));
    zzc.zza(this.zza).onMessageTriggered(2, bundle);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */