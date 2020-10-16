package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class GithubAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzw();
  
  private String zza;
  
  GithubAuthCredential(String paramString) {
    this.zza = Preconditions.checkNotEmpty(paramString);
  }
  
  public static zzfy zza(GithubAuthCredential paramGithubAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramGithubAuthCredential);
    return new zzfy(null, paramGithubAuthCredential.zza, paramGithubAuthCredential.getProvider(), null, null, null, paramString, null, null);
  }
  
  public String getProvider() {
    return "github.com";
  }
  
  public String getSignInMethod() {
    return "github.com";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new GithubAuthCredential(this.zza);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\GithubAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */