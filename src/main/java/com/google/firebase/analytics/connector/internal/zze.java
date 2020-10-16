package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

public final class zze implements zza {
  private AnalyticsConnector.AnalyticsConnectorListener zza;
  
  private AppMeasurement zzb;
  
  private zzg zzc;
  
  public zze(AppMeasurement paramAppMeasurement, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    this.zza = paramAnalyticsConnectorListener;
    this.zzb = paramAppMeasurement;
    this.zzc = new zzg(this);
    this.zzb.registerOnMeasurementEventListener(this.zzc);
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza() {
    return this.zza;
  }
  
  public final void zza(Set<String> paramSet) {}
  
  public final void zzb() {}
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zze.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */