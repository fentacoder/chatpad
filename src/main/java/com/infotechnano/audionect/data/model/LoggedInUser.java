package com.infotechnano.audionect.data.model;

public class LoggedInUser {
  private String displayName;
  
  private String userId;
  
  public LoggedInUser(String paramString1, String paramString2) {
    this.userId = paramString1;
    this.displayName = paramString2;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getUserId() {
    return this.userId;
  }
}
