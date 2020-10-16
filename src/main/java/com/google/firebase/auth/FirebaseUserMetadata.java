package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public interface FirebaseUserMetadata extends SafeParcelable {
  long getCreationTimestamp();
  
  long getLastSignInTimestamp();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseUserMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */