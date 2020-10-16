package com.google.firebase.firestore.auth;

public final class Token {
  private final User user;
  
  private final String value;
  
  public Token(String paramString, User paramUser) {
    this.value = paramString;
    this.user = paramUser;
  }
  
  public User getUser() {
    return this.user;
  }
  
  public String getValue() {
    return this.value;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\auth\Token.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */