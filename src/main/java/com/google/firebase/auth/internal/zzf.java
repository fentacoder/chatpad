package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzf implements AdditionalUserInfo {
  public static final Parcelable.Creator<zzf> CREATOR = new zzi();
  
  private final String zza;
  
  private final String zzb;
  
  private Map<String, Object> zzc;
  
  private boolean zzd;
  
  public zzf(String paramString1, String paramString2, boolean paramBoolean) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = zzao.zzb(paramString2);
    this.zzd = paramBoolean;
  }
  
  public zzf(boolean paramBoolean) {
    this.zzd = paramBoolean;
    this.zzb = null;
    this.zza = null;
    this.zzc = null;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  @Nullable
  public final Map<String, Object> getProfile() {
    return this.zzc;
  }
  
  @Nullable
  public final String getProviderId() {
    return this.zza;
  }
  
  @Nullable
  public final String getUsername() {
    return "github.com".equals(this.zza) ? (String)this.zzc.get("login") : ("twitter.com".equals(this.zza) ? (String)this.zzc.get("screen_name") : null);
  }
  
  public final boolean isNewUser() {
    return this.zzd;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getProviderId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, isNewUser());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */