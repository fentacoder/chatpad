package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class UserProfileChangeRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzai();
  
  private String zza;
  
  private String zzb;
  
  private boolean zzc;
  
  private boolean zzd;
  
  private Uri zze;
  
  UserProfileChangeRequest(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
    Uri uri;
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramBoolean1;
    this.zzd = paramBoolean2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    } else {
      uri = Uri.parse(paramString2);
    } 
    this.zze = uri;
  }
  
  public String getDisplayName() {
    return this.zza;
  }
  
  public Uri getPhotoUri() {
    return this.zze;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getDisplayName(), false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzb, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzc);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final String zza() {
    return this.zzb;
  }
  
  public final boolean zzb() {
    return this.zzc;
  }
  
  public final boolean zzc() {
    return this.zzd;
  }
  
  public static class Builder {
    private String zza;
    
    private Uri zzb;
    
    private boolean zzc;
    
    private boolean zzd;
    
    public UserProfileChangeRequest build() {
      String str2;
      String str1 = this.zza;
      Uri uri = this.zzb;
      if (uri == null) {
        uri = null;
      } else {
        str2 = uri.toString();
      } 
      return new UserProfileChangeRequest(str1, str2, this.zzc, this.zzd);
    }
    
    public Builder setDisplayName(String param1String) {
      if (param1String == null) {
        this.zzc = true;
      } else {
        this.zza = param1String;
      } 
      return this;
    }
    
    public Builder setPhotoUri(Uri param1Uri) {
      if (param1Uri == null) {
        this.zzd = true;
      } else {
        this.zzb = param1Uri;
      } 
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\UserProfileChangeRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */