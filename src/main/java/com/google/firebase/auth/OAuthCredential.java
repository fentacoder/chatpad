package com.google.firebase.auth;

public abstract class OAuthCredential extends AuthCredential {
  public abstract String getAccessToken();
  
  public abstract String getIdToken();
  
  public abstract String getSecret();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\OAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */