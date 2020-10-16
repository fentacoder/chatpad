package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.zza;

public final class zzg implements ActionCodeResult {
  private final int zza;
  
  private final String zzb;
  
  private final String zzc;
  
  private final zza zzd;
  
  public zzg(zzfm paramzzfm) {
    zze zze;
    if (paramzzfm.zzg()) {
      str1 = paramzzfm.zzc();
    } else {
      str1 = paramzzfm.zzb();
    } 
    this.zzb = str1;
    this.zzc = paramzzfm.zzb();
    boolean bool = paramzzfm.zzh();
    String str1 = null;
    if (!bool) {
      this.zza = 3;
      this.zzd = null;
      return;
    } 
    String str2 = paramzzfm.zzd();
    int i = -1;
    switch (str2.hashCode()) {
      case 970484929:
        if (str2.equals("RECOVER_EMAIL"))
          i = 4; 
        break;
      case 870738373:
        if (str2.equals("EMAIL_SIGNIN"))
          i = 2; 
        break;
      case -1288726400:
        if (str2.equals("VERIFY_BEFORE_UPDATE_EMAIL"))
          i = 3; 
        break;
      case -1341836234:
        if (str2.equals("VERIFY_EMAIL"))
          i = 1; 
        break;
      case -1452371317:
        if (str2.equals("PASSWORD_RESET"))
          i = 0; 
        break;
      case -1874510116:
        if (str2.equals("REVERT_SECOND_FACTOR_ADDITION"))
          i = 5; 
        break;
    } 
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                i = 3;
              } else {
                i = 6;
              } 
            } else {
              i = 2;
            } 
          } else {
            i = 5;
          } 
        } else {
          i = 4;
        } 
      } else {
        i = 1;
      } 
    } else {
      i = 0;
    } 
    this.zza = i;
    i = this.zza;
    if (i == 4 || i == 3) {
      this.zzd = null;
      return;
    } 
    if (paramzzfm.zzi()) {
      zzd zzd = new zzd(paramzzfm.zzb(), zzar.zza(paramzzfm.zze()));
    } else if (paramzzfm.zzg()) {
      zzb zzb = new zzb(paramzzfm.zzc(), paramzzfm.zzb());
    } else if (paramzzfm.zzf()) {
      zze = new zze(paramzzfm.zzb());
    } 
    this.zzd = zze;
  }
  
  public final String getData(int paramInt) {
    return (this.zza == 4) ? null : ((paramInt != 0) ? ((paramInt != 1) ? null : this.zzc) : this.zzb);
  }
  
  public final int getOperation() {
    return this.zza;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */