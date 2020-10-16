package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class FacebookAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzk();
  
  private final String zza;
  
  FacebookAuthCredential(String paramString) {
    this.zza = Preconditions.checkNotEmpty(paramString);
  }
  
  public static zzfy zza(FacebookAuthCredential paramFacebookAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramFacebookAuthCredential);
    return new zzfy(null, paramFacebookAuthCredential.zza, paramFacebookAuthCredential.getProvider(), null, null, null, paramString, null, null);
  }
  
  public String getProvider() {
    return "facebook.com";
  }
  
  public String getSignInMethod() {
    return "facebook.com";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new FacebookAuthCredential(this.zza);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FacebookAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */