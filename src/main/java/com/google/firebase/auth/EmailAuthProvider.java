package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;

public class EmailAuthProvider {
  public static final String EMAIL_LINK_SIGN_IN_METHOD = "emailLink";
  
  public static final String EMAIL_PASSWORD_SIGN_IN_METHOD = "password";
  
  public static final String PROVIDER_ID = "password";
  
  public static AuthCredential getCredential(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    return new EmailAuthCredential(paramString1, paramString2);
  }
  
  public static AuthCredential getCredentialWithLink(String paramString1, String paramString2) {
    if (EmailAuthCredential.zza(paramString2))
      return new EmailAuthCredential(paramString1, null, paramString2, null, false); 
    throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\EmailAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */