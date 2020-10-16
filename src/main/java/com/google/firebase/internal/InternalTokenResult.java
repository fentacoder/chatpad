package com.google.firebase.internal;

import com.google.android.gms.common.internal.Objects;

public class InternalTokenResult {
  private String zza;
  
  public InternalTokenResult(String paramString) {
    this.zza = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof InternalTokenResult))
      return false; 
    paramObject = paramObject;
    return Objects.equal(this.zza, ((InternalTokenResult)paramObject).zza);
  }
  
  public String getToken() {
    return this.zza;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.zza });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("token", this.zza).toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\internal\InternalTokenResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */