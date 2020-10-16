package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class EmailAuthCredential extends AuthCredential {
  public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzj();
  
  private String zza;
  
  private String zzb;
  
  private final String zzc;
  
  private String zzd;
  
  private boolean zze;
  
  EmailAuthCredential(String paramString1, String paramString2) {
    this(paramString1, paramString2, null, null, false);
  }
  
  EmailAuthCredential(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    this.zza = Preconditions.checkNotEmpty(paramString1);
    if (!TextUtils.isEmpty(paramString2) || !TextUtils.isEmpty(paramString3)) {
      this.zzb = paramString2;
      this.zzc = paramString3;
      this.zzd = paramString4;
      this.zze = paramBoolean;
      return;
    } 
    throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
  }
  
  public static boolean zza(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    zzf zzf = zzf.zza(paramString);
    return (zzf != null && zzf.zza() == 4);
  }
  
  public String getProvider() {
    return "password";
  }
  
  public String getSignInMethod() {
    return !TextUtils.isEmpty(this.zzb) ? "password" : "emailLink";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zze);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
  }
  
  public final EmailAuthCredential zza(FirebaseUser paramFirebaseUser) {
    this.zzd = paramFirebaseUser.zzf();
    this.zze = true;
    return this;
  }
  
  public final String zzb() {
    return this.zza;
  }
  
  public final String zzc() {
    return this.zzb;
  }
  
  public final String zzd() {
    return this.zzc;
  }
  
  public final String zze() {
    return this.zzd;
  }
  
  public final boolean zzf() {
    return this.zze;
  }
  
  public final boolean zzg() {
    return !TextUtils.isEmpty(this.zzc);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\EmailAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */