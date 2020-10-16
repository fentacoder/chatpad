package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

public class zzg extends OAuthCredential {
  public static final Parcelable.Creator<zzg> CREATOR = new zzi();
  
  private final String zza;
  
  private final String zzb;
  
  private final String zzc;
  
  private final zzfy zzd;
  
  private final String zze;
  
  private final String zzf;
  
  private final String zzg;
  
  zzg(String paramString1, String paramString2, String paramString3, zzfy paramzzfy, String paramString4, String paramString5, String paramString6) {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zzd = paramzzfy;
    this.zze = paramString4;
    this.zzf = paramString5;
    this.zzg = paramString6;
  }
  
  public static zzfy zza(zzg paramzzg, String paramString) {
    Preconditions.checkNotNull(paramzzg);
    zzfy zzfy1 = paramzzg.zzd;
    return (zzfy1 != null) ? zzfy1 : new zzfy(paramzzg.getIdToken(), paramzzg.getAccessToken(), paramzzg.getProvider(), null, paramzzg.getSecret(), null, paramString, paramzzg.zze, paramzzg.zzg);
  }
  
  public static zzg zza(zzfy paramzzfy) {
    Preconditions.checkNotNull(paramzzfy, "Must specify a non-null webSignInCredential");
    return new zzg(null, null, null, paramzzfy, null, null, null);
  }
  
  public static zzg zza(String paramString1, String paramString2, String paramString3) {
    return zza(paramString1, paramString2, paramString3, null, null);
  }
  
  static zzg zza(String paramString1, String paramString2, String paramString3, String paramString4) {
    Preconditions.checkNotEmpty(paramString1, "Must specify a non-empty providerId");
    if (!TextUtils.isEmpty(paramString2) || !TextUtils.isEmpty(paramString3))
      return new zzg(paramString1, paramString2, paramString3, null, null, null, paramString4); 
    throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
  }
  
  public static zzg zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    Preconditions.checkNotEmpty(paramString1, "Must specify a non-empty providerId");
    if (!TextUtils.isEmpty(paramString2) || !TextUtils.isEmpty(paramString3))
      return new zzg(paramString1, paramString2, paramString3, null, paramString4, paramString5, null); 
    throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
  }
  
  public String getAccessToken() {
    return this.zzc;
  }
  
  public String getIdToken() {
    return this.zzb;
  }
  
  public String getProvider() {
    return this.zza;
  }
  
  public String getSecret() {
    return this.zzf;
  }
  
  public String getSignInMethod() {
    return this.zza;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, super.getProvider(), false);
    SafeParcelWriter.writeString(paramParcel, 2, super.getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 3, super.getAccessToken(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zzd, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zze, false);
    SafeParcelWriter.writeString(paramParcel, 6, super.getSecret(), false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzg, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final AuthCredential zza() {
    return new zzg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */