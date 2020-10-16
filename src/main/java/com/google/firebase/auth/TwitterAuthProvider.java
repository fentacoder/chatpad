package com.google.firebase.auth;

public class TwitterAuthProvider {
  public static final String PROVIDER_ID = "twitter.com";
  
  public static final String TWITTER_SIGN_IN_METHOD = "twitter.com";
  
  public static AuthCredential getCredential(String paramString1, String paramString2) {
    return new TwitterAuthCredential(paramString1, paramString2);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\TwitterAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */