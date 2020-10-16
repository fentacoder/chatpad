package com.google.firebase.auth;

public class PlayGamesAuthProvider {
  public static final String PLAY_GAMES_SIGN_IN_METHOD = "playgames.google.com";
  
  public static final String PROVIDER_ID = "playgames.google.com";
  
  public static AuthCredential getCredential(String paramString) {
    return new PlayGamesAuthCredential(paramString);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\PlayGamesAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */