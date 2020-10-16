package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

public final class zzfg {
  private final String zza;
  
  private final String zzb;
  
  public zzfg(Context paramContext) {
    this(paramContext, paramContext.getPackageName());
  }
  
  private zzfg(Context paramContext, String paramString) {
    Preconditions.checkNotNull(paramContext);
    this.zza = Preconditions.checkNotEmpty(paramString);
    try {
      String str;
      byte[] arrayOfByte = AndroidUtilsLight.getPackageCertificateHashBytes(paramContext, this.zza);
      if (arrayOfByte == null) {
        str = String.valueOf(paramString);
        if (str.length() != 0) {
          str = "single cert required: ".concat(str);
        } else {
          str = new String("single cert required: ");
        } 
        Log.e("FBA-PackageInfo", str);
        this.zzb = null;
        return;
      } 
      this.zzb = Hex.bytesToStringUppercase((byte[])str, false);
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      String str = String.valueOf(paramString);
      if (str.length() != 0) {
        str = "no pkg: ".concat(str);
      } else {
        str = new String("no pkg: ");
      } 
      Log.e("FBA-PackageInfo", str);
      this.zzb = null;
      return;
    } 
  }
  
  public final String zza() {
    return this.zza;
  }
  
  public final String zzb() {
    return this.zzb;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzfg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */