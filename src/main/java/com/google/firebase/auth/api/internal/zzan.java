package com.google.firebase.auth.api.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

final class zzan implements zzas {
  private final int zza;
  
  private final int zzb;
  
  private final Map<String, Integer> zzc;
  
  public zzan(int paramInt1, int paramInt2, Map<String, Integer> paramMap) {
    if (zza())
      paramInt1 = 0; 
    this.zza = paramInt1;
    this.zzb = paramInt2;
    this.zzc = (Map<String, Integer>)Preconditions.checkNotNull(paramMap);
    zza();
  }
  
  private static boolean zza() {
    boolean bool = "local".equals(zzfl.zza("firebear.preference"));
    if (bool)
      Log.e("BiChannelGoogleApi", "Found local preference, will always use local service instance"); 
    return bool;
  }
  
  public final boolean zza(String paramString) {
    int i = this.zza;
    if (i == 0)
      return true; 
    if (this.zzb <= i)
      return false; 
    Integer integer2 = this.zzc.get(paramString);
    Integer integer1 = integer2;
    if (integer2 == null)
      integer1 = Integer.valueOf(0); 
    return (integer1.intValue() > this.zza && this.zzb >= integer1.intValue());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */