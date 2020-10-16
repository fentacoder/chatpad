package com.google.firebase.auth;

import android.net.Uri;

public interface UserInfo {
  String getDisplayName();
  
  String getEmail();
  
  String getPhoneNumber();
  
  Uri getPhotoUrl();
  
  String getProviderId();
  
  String getUid();
  
  boolean isEmailVerified();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\UserInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */