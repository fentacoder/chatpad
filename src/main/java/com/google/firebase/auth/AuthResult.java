package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public interface AuthResult extends SafeParcelable {
  AdditionalUserInfo getAdditionalUserInfo();
  
  AuthCredential getCredential();
  
  FirebaseUser getUser();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\AuthResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */