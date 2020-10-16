package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzg;
import java.util.List;

public final class zzh implements AuthResult {
  public static final Parcelable.Creator<zzh> CREATOR = new zzk();
  
  private zzn zza;
  
  private zzf zzb;
  
  private zzg zzc;
  
  public zzh(zzn paramzzn) {
    this.zza = (zzn)Preconditions.checkNotNull(paramzzn);
    List<zzj> list = this.zza.zzi();
    this.zzb = null;
    for (byte b = 0; b < list.size(); b++) {
      if (!TextUtils.isEmpty(((zzj)list.get(b)).zza()))
        this.zzb = new zzf(((zzj)list.get(b)).getProviderId(), ((zzj)list.get(b)).zza(), paramzzn.zzj()); 
    } 
    if (this.zzb == null)
      this.zzb = new zzf(paramzzn.zzj()); 
    this.zzc = paramzzn.zzk();
  }
  
  zzh(zzn paramzzn, zzf paramzzf, zzg paramzzg) {
    this.zza = paramzzn;
    this.zzb = paramzzf;
    this.zzc = paramzzg;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final AdditionalUserInfo getAdditionalUserInfo() {
    return this.zzb;
  }
  
  public final AuthCredential getCredential() {
    return (AuthCredential)this.zzc;
  }
  
  public final FirebaseUser getUser() {
    return this.zza;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)getUser(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)getAdditionalUserInfo(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zzc, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */