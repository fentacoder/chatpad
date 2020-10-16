package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.FirebaseApp;

public final class zzaa {
  private static Logger zzc = new Logger("TokenRefresher", new String[] { "FirebaseAuth:" });
  
  volatile long zza;
  
  volatile long zzb;
  
  private final FirebaseApp zzd;
  
  private long zze;
  
  private HandlerThread zzf;
  
  private Handler zzg;
  
  private Runnable zzh;
  
  public zzaa(FirebaseApp paramFirebaseApp) {
    zzc.v("Initializing TokenRefresher", new Object[0]);
    this.zzd = (FirebaseApp)Preconditions.checkNotNull(paramFirebaseApp);
    this.zzf = new HandlerThread("TokenRefresher", 10);
    this.zzf.start();
    this.zzg = (Handler)new zzj(this.zzf.getLooper());
    this.zzh = new zzz(this, this.zzd.getName());
    this.zze = 300000L;
  }
  
  public final void zza() {
    Logger logger = zzc;
    long l1 = this.zza;
    long l2 = this.zze;
    StringBuilder stringBuilder = new StringBuilder(43);
    stringBuilder.append("Scheduling refresh for ");
    stringBuilder.append(l1 - l2);
    logger.v(stringBuilder.toString(), new Object[0]);
    zzc();
    l1 = DefaultClock.getInstance().currentTimeMillis();
    this.zzb = Math.max(this.zza - l1 - this.zze, 0L) / 1000L;
    this.zzg.postDelayed(this.zzh, this.zzb * 1000L);
  }
  
  final void zzb() {
    int i = (int)this.zzb;
    if (i != 30 && i != 60 && i != 120 && i != 240 && i != 480) {
      if (i != 960) {
        l = 30L;
      } else {
        l = 960L;
      } 
    } else {
      l = 2L * this.zzb;
    } 
    this.zzb = l;
    this.zza = DefaultClock.getInstance().currentTimeMillis() + this.zzb * 1000L;
    Logger logger = zzc;
    long l = this.zza;
    StringBuilder stringBuilder = new StringBuilder(43);
    stringBuilder.append("Scheduling refresh for ");
    stringBuilder.append(l);
    logger.v(stringBuilder.toString(), new Object[0]);
    this.zzg.postDelayed(this.zzh, this.zzb * 1000L);
  }
  
  public final void zzc() {
    this.zzg.removeCallbacks(this.zzh);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzaa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */