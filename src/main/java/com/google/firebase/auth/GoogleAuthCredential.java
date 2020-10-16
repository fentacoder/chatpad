package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class GoogleAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzx();
  
  private final String zza;
  
  private final String zzb;
  
  GoogleAuthCredential(String paramString1, String paramString2) {
    if (paramString1 != null || paramString2 != null) {
      this.zza = zza(paramString1, "idToken");
      this.zzb = zza(paramString2, "accessToken");
      return;
    } 
    throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
  }
  
  public static zzfy zza(GoogleAuthCredential paramGoogleAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramGoogleAuthCredential);
    return new zzfy(paramGoogleAuthCredential.zza, paramGoogleAuthCredential.zzb, paramGoogleAuthCredential.getProvider(), null, null, null, paramString, null, null);
  }
  
  private static String zza(String paramString1, String paramString2) {
    if (paramString1 == null || !TextUtils.isEmpty(paramString1))
      return paramString1; 
    throw new IllegalArgumentException(String.valueOf(paramString2).concat(" must not be empty"));
  }
  
  public String getProvider() {
    return "google.com";
  }
  
  public String getSignInMethod() {
    return "google.com";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new GoogleAuthCredential(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\GoogleAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */