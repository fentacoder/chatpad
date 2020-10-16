package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class PlayGamesAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzag();
  
  private final String zza;
  
  PlayGamesAuthCredential(String paramString) {
    this.zza = Preconditions.checkNotEmpty(paramString);
  }
  
  public static zzfy zza(PlayGamesAuthCredential paramPlayGamesAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramPlayGamesAuthCredential);
    return new zzfy(null, null, paramPlayGamesAuthCredential.getProvider(), null, null, paramPlayGamesAuthCredential.zza, paramString, null, null);
  }
  
  public String getProvider() {
    return "playgames.google.com";
  }
  
  public String getSignInMethod() {
    return "playgames.google.com";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new PlayGamesAuthCredential(this.zza);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\PlayGamesAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */