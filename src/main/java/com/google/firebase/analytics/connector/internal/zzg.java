package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzg implements AppMeasurement.OnEventListener {
  public zzg(zze paramzze) {}
  
  public final void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong) {
    if (paramString1 != null && !paramString1.equals("crash") && zzd.zzb(paramString2)) {
      Bundle bundle = new Bundle();
      bundle.putString("name", paramString2);
      bundle.putLong("timestampInMillis", paramLong);
      bundle.putBundle("params", paramBundle);
      zze.zza(this.zza).onMessageTriggered(3, bundle);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */