package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.api.zza;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzj extends AbstractSafeParcelable implements UserInfo {
  public static final Parcelable.Creator<zzj> CREATOR = new zzm();
  
  private String zza;
  
  private String zzb;
  
  private String zzc;
  
  private String zzd;
  
  private Uri zze;
  
  private String zzf;
  
  private String zzg;
  
  private boolean zzh;
  
  private String zzi;
  
  public zzj(zzew paramzzew, String paramString) {
    Preconditions.checkNotNull(paramzzew);
    Preconditions.checkNotEmpty(paramString);
    this.zza = Preconditions.checkNotEmpty(paramzzew.zzc());
    this.zzb = paramString;
    this.zzf = paramzzew.zza();
    this.zzc = paramzzew.zzd();
    Uri uri = paramzzew.zze();
    if (uri != null) {
      this.zzd = uri.toString();
      this.zze = uri;
    } 
    this.zzh = paramzzew.zzb();
    this.zzi = null;
    this.zzg = paramzzew.zzf();
  }
  
  public zzj(zzfj paramzzfj) {
    Preconditions.checkNotNull(paramzzfj);
    this.zza = paramzzfj.zza();
    this.zzb = Preconditions.checkNotEmpty(paramzzfj.zzd());
    this.zzc = paramzzfj.zzb();
    Uri uri = paramzzfj.zzc();
    if (uri != null) {
      this.zzd = uri.toString();
      this.zze = uri;
    } 
    this.zzf = paramzzfj.zzg();
    this.zzg = paramzzfj.zze();
    this.zzh = false;
    this.zzi = paramzzfj.zzf();
  }
  
  public zzj(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, String paramString7) {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzf = paramString3;
    this.zzg = paramString4;
    this.zzc = paramString5;
    this.zzd = paramString6;
    if (!TextUtils.isEmpty(this.zzd))
      this.zze = Uri.parse(this.zzd); 
    this.zzh = paramBoolean;
    this.zzi = paramString7;
  }
  
  public static zzj zza(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      return new zzj(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
    } catch (JSONException jSONException) {
      Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
      throw new zza(jSONException);
    } 
  }
  
  public final String getDisplayName() {
    return this.zzc;
  }
  
  public final String getEmail() {
    return this.zzf;
  }
  
  public final String getPhoneNumber() {
    return this.zzg;
  }
  
  public final Uri getPhotoUrl() {
    if (!TextUtils.isEmpty(this.zzd) && this.zze == null)
      this.zze = Uri.parse(this.zzd); 
    return this.zze;
  }
  
  public final String getProviderId() {
    return this.zzb;
  }
  
  public final String getUid() {
    return this.zza;
  }
  
  public final boolean isEmailVerified() {
    return this.zzh;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getUid(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getProviderId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDisplayName(), false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeString(paramParcel, 5, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 6, getPhoneNumber(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, isEmailVerified());
    SafeParcelWriter.writeString(paramParcel, 8, this.zzi, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final String zza() {
    return this.zzi;
  }
  
  public final String zzb() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("userId", this.zza);
      jSONObject.putOpt("providerId", this.zzb);
      jSONObject.putOpt("displayName", this.zzc);
      jSONObject.putOpt("photoUrl", this.zzd);
      jSONObject.putOpt("email", this.zzf);
      jSONObject.putOpt("phoneNumber", this.zzg);
      jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
      jSONObject.putOpt("rawUserInfo", this.zzi);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
      throw new zza(jSONException);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */