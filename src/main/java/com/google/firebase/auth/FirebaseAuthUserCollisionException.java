package com.google.firebase.auth;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
  private AuthCredential zza;
  
  private String zzb;
  
  private String zzc;
  
  public FirebaseAuthUserCollisionException(String paramString1, String paramString2) {
    super(paramString1, paramString2);
  }
  
  public final String getEmail() {
    return this.zzb;
  }
  
  public final AuthCredential getUpdatedCredential() {
    return this.zza;
  }
  
  public final FirebaseAuthUserCollisionException zza(AuthCredential paramAuthCredential) {
    this.zza = paramAuthCredential;
    return this;
  }
  
  public final FirebaseAuthUserCollisionException zza(String paramString) {
    this.zzb = paramString;
    return this;
  }
  
  public final FirebaseAuthUserCollisionException zzb(String paramString) {
    this.zzc = paramString;
    return this;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseAuthUserCollisionException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */