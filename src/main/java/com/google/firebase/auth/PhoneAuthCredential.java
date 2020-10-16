package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class PhoneAuthCredential extends AuthCredential implements Cloneable {
  public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzad();
  
  private String zza;
  
  private String zzb;
  
  private boolean zzc;
  
  private String zzd;
  
  private boolean zze;
  
  private String zzf;
  
  private String zzg;
  
  PhoneAuthCredential(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, String paramString4, String paramString5) {
    boolean bool;
    if ((paramBoolean1 && !TextUtils.isEmpty(paramString3) && TextUtils.isEmpty(paramString5)) || (paramBoolean1 && TextUtils.isEmpty(paramString3) && !TextUtils.isEmpty(paramString5)) || (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3) && !TextUtils.isEmpty(paramString4))) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramBoolean1;
    this.zzd = paramString3;
    this.zze = paramBoolean2;
    this.zzf = paramString4;
    this.zzg = paramString5;
  }
  
  public static PhoneAuthCredential zza(String paramString1, String paramString2) {
    return new PhoneAuthCredential(null, null, false, paramString1, true, paramString2, null);
  }
  
  public String getProvider() {
    return "phone";
  }
  
  public String getSignInMethod() {
    return "phone";
  }
  
  public String getSmsCode() {
    return this.zzb;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, getSmsCode(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zze);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzf, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzg, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final AuthCredential zza() {
    return (PhoneAuthCredential)clone();
  }
  
  public final PhoneAuthCredential zza(boolean paramBoolean) {
    this.zze = false;
    return this;
  }
  
  public final String zzb() {
    return this.zza;
  }
  
  public final String zzc() {
    return this.zzd;
  }
  
  public final boolean zzd() {
    return this.zze;
  }
  
  public final String zze() {
    return this.zzf;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\PhoneAuthCredential.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */