package com.google.firebase.auth;

public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
  private final String zza;
  
  public FirebaseAuthWeakPasswordException(String paramString1, String paramString2, String paramString3) {
    super(paramString1, paramString2);
    this.zza = paramString3;
  }
  
  public final String getReason() {
    return this.zza;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseAuthWeakPasswordException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */