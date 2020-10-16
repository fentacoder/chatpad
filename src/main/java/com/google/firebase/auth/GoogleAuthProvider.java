package com.google.firebase.auth;

public class GoogleAuthProvider {
  public static final String GOOGLE_SIGN_IN_METHOD = "google.com";
  
  public static final String PROVIDER_ID = "google.com";
  
  public static AuthCredential getCredential(String paramString1, String paramString2) {
    return new GoogleAuthCredential(paramString1, paramString2);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\GoogleAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */