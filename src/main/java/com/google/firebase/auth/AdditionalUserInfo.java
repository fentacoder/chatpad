package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

public interface AdditionalUserInfo extends SafeParcelable {
  Map<String, Object> getProfile();
  
  String getProviderId();
  
  String getUsername();
  
  boolean isNewUser();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\AdditionalUserInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */