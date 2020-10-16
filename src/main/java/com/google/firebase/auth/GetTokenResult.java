package com.google.firebase.auth;

import java.util.Map;

public class GetTokenResult {
  private String zza;
  
  private Map<String, Object> zzb;
  
  public GetTokenResult(String paramString, Map<String, Object> paramMap) {
    this.zza = paramString;
    this.zzb = paramMap;
  }
  
  private final long zza(String paramString) {
    Integer integer = (Integer)this.zzb.get(paramString);
    return (integer == null) ? 0L : integer.longValue();
  }
  
  public long getAuthTimestamp() {
    return zza("auth_time");
  }
  
  public Map<String, Object> getClaims() {
    return this.zzb;
  }
  
  public long getExpirationTimestamp() {
    return zza("exp");
  }
  
  public long getIssuedAtTimestamp() {
    return zza("iat");
  }
  
  public String getSignInProvider() {
    Map map = (Map)this.zzb.get("firebase");
    return (map != null) ? (String)map.get("sign_in_provider") : null;
  }
  
  public String getSignInSecondFactor() {
    Map map = (Map)this.zzb.get("firebase");
    return (map != null) ? (String)map.get("sign_in_second_factor") : null;
  }
  
  public String getToken() {
    return this.zza;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\GetTokenResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */