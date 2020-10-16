package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class TwitterAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzah();
  
  private String zza;
  
  private String zzb;
  
  TwitterAuthCredential(String paramString1, String paramString2) {
    this.zza = Preconditions.checkNotEmpty(paramString1);
    this.zzb = Preconditions.checkNotEmpty(paramString2);
  }
  
  public static zzfy zza(TwitterAuthCredential paramTwitterAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramTwitterAuthCredential);
    return new zzfy(null, paramTwitterAuthCredential.zza, paramTwitterAuthCredential.getProvider(), null, paramTwitterAuthCredential.zzb, null, paramString, null, null);
  }
  
  public String getProvider() {
    return "twitter.com";
  }
  
  public String getSignInMethod() {
    return "twitter.com";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new TwitterAuthCredential(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\TwitterAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */