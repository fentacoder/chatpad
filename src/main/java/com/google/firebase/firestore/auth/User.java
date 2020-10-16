package com.google.firebase.firestore.auth;

public final class User {
  public static final User UNAUTHENTICATED = new User(null);
  
  private final String uid;
  
  public User(String paramString) {
    this.uid = paramString;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    User user = (User)paramObject;
    paramObject = this.uid;
    String str = user.uid;
    if (paramObject != null) {
      bool = paramObject.equals(str);
    } else if (str != null) {
      bool = false;
    } 
    return bool;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public int hashCode() {
    boolean bool;
    String str = this.uid;
    if (str != null) {
      bool = str.hashCode();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isAuthenticated() {
    boolean bool;
    if (this.uid != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("User(uid:");
    stringBuilder.append(this.uid);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\auth\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */