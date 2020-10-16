package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;

public final class zzau {
  private volatile int zza = 0;
  
  private final zzaa zzb;
  
  private volatile boolean zzc = false;
  
  private zzau(Context paramContext, zzaa paramzzaa) {
    this.zzb = paramzzaa;
    BackgroundDetector.initialize((Application)paramContext.getApplicationContext());
    BackgroundDetector.getInstance().addListener(new zzax(this));
  }
  
  public zzau(FirebaseApp paramFirebaseApp) {
    this(paramFirebaseApp.getApplicationContext(), new zzaa(paramFirebaseApp));
  }
  
  private final boolean zzb() {
    return (this.zza > 0 && !this.zzc);
  }
  
  public final void zza() {
    this.zzb.zzc();
  }
  
  public final void zza(int paramInt) {
    if (paramInt > 0 && this.zza == 0) {
      this.zza = paramInt;
      if (zzb())
        this.zzb.zza(); 
    } else if (paramInt == 0 && this.zza != 0) {
      this.zzb.zzc();
    } 
    this.zza = paramInt;
  }
  
  public final void zza(zzff paramzzff) {
    if (paramzzff == null)
      return; 
    long l1 = paramzzff.zze();
    long l2 = l1;
    if (l1 <= 0L)
      l2 = 3600L; 
    l1 = paramzzff.zzg();
    zzaa zzaa1 = this.zzb;
    zzaa1.zza = l1 + l2 * 1000L;
    zzaa1.zzb = -1L;
    if (zzb())
      this.zzb.zza(); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzau.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */