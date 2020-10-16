package com.google.firebase.auth;

public class FacebookAuthProvider {
  public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";
  
  public static final String PROVIDER_ID = "facebook.com";
  
  public static AuthCredential getCredential(String paramString) {
    return new FacebookAuthCredential(paramString);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FacebookAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */