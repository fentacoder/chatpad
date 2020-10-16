package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class zzei extends zzao implements Api.ApiOptions.HasOptions {
  private final String zzb;
  
  private zzei(String paramString) {
    this.zzb = Preconditions.checkNotEmpty(paramString, "A valid API key must be provided");
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzei))
      return false; 
    paramObject = paramObject;
    return Objects.equal(this.zzb, ((zzei)paramObject).zzb);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zzb });
  }
  
  public final String zzb() {
    return this.zzb;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzei.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */