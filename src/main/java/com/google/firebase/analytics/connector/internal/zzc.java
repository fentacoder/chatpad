package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

public final class zzc implements zza {
  Set<String> zza;
  
  private AnalyticsConnector.AnalyticsConnectorListener zzb;
  
  private AppMeasurement zzc;
  
  private zzf zzd;
  
  public zzc(AppMeasurement paramAppMeasurement, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    this.zzb = paramAnalyticsConnectorListener;
    this.zzc = paramAppMeasurement;
    this.zzd = new zzf(this);
    this.zzc.registerOnMeasurementEventListener(this.zzd);
    this.zza = new HashSet<>();
  }
  
  public final AnalyticsConnector.AnalyticsConnectorListener zza() {
    return this.zzb;
  }
  
  public final void zza(Set<String> paramSet) {
    this.zza.clear();
    Set<String> set = this.zza;
    HashSet<String> hashSet = new HashSet();
    for (String str : paramSet) {
      if (hashSet.size() < 50)
        if (zzd.zzd(str) && zzd.zzc(str))
          hashSet.add(zzd.zzf(str));  
    } 
    set.addAll(hashSet);
  }
  
  public final void zzb() {
    this.zza.clear();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */