package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException {
  private final String zza;
  
  public FirebaseAuthException(String paramString1, String paramString2) {
    super(paramString2);
    this.zza = Preconditions.checkNotEmpty(paramString1);
  }
  
  public String getErrorCode() {
    return this.zza;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseAuthException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */