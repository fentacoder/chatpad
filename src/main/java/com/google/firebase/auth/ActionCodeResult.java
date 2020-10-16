package com.google.firebase.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ActionCodeResult {
  public static final int EMAIL = 0;
  
  public static final int ERROR = 3;
  
  public static final int FROM_EMAIL = 1;
  
  public static final int PASSWORD_RESET = 0;
  
  public static final int RECOVER_EMAIL = 2;
  
  public static final int SIGN_IN_WITH_EMAIL_LINK = 4;
  
  public static final int VERIFY_EMAIL = 1;
  
  String getData(int paramInt);
  
  int getOperation();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionDataKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Operation {}
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\ActionCodeResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */