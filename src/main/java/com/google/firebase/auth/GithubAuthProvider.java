package com.google.firebase.auth;

public class GithubAuthProvider {
  public static final String GITHUB_SIGN_IN_METHOD = "github.com";
  
  public static final String PROVIDER_ID = "github.com";
  
  public static AuthCredential getCredential(String paramString) {
    return new GithubAuthCredential(paramString);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\GithubAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */