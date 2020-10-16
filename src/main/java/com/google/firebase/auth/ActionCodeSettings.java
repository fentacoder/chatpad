package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzgk;

public class ActionCodeSettings extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zze();
  
  private final String zza;
  
  private final String zzb;
  
  private final String zzc;
  
  private final String zzd;
  
  private final boolean zze;
  
  private final String zzf;
  
  private final boolean zzg;
  
  private String zzh;
  
  private int zzi;
  
  private String zzj;
  
  private ActionCodeSettings(Builder paramBuilder) {
    this.zza = Builder.zza(paramBuilder);
    this.zzb = Builder.zzb(paramBuilder);
    this.zzc = null;
    this.zzd = Builder.zzc(paramBuilder);
    this.zze = Builder.zzd(paramBuilder);
    this.zzf = Builder.zze(paramBuilder);
    this.zzg = Builder.zzf(paramBuilder);
    this.zzj = Builder.zzg(paramBuilder);
  }
  
  ActionCodeSettings(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, String paramString5, boolean paramBoolean2, String paramString6, int paramInt, String paramString7) {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zzd = paramString4;
    this.zze = paramBoolean1;
    this.zzf = paramString5;
    this.zzg = paramBoolean2;
    this.zzh = paramString6;
    this.zzi = paramInt;
    this.zzj = paramString7;
  }
  
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  public static ActionCodeSettings zza() {
    return new ActionCodeSettings(new Builder(null));
  }
  
  public boolean canHandleCodeInApp() {
    return this.zzg;
  }
  
  public boolean getAndroidInstallApp() {
    return this.zze;
  }
  
  public String getAndroidMinimumVersion() {
    return this.zzf;
  }
  
  public String getAndroidPackageName() {
    return this.zzd;
  }
  
  public String getIOSBundle() {
    return this.zzb;
  }
  
  public String getUrl() {
    return this.zza;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getUrl(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getIOSBundle(), false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 4, getAndroidPackageName(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, getAndroidInstallApp());
    SafeParcelWriter.writeString(paramParcel, 6, getAndroidMinimumVersion(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, canHandleCodeInApp());
    SafeParcelWriter.writeString(paramParcel, 8, this.zzh, false);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzi);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzj, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final void zza(zzgk paramzzgk) {
    this.zzi = paramzzgk.zza();
  }
  
  public final void zza(String paramString) {
    this.zzh = paramString;
  }
  
  public final String zzb() {
    return this.zzc;
  }
  
  public final String zzc() {
    return this.zzh;
  }
  
  public final int zzd() {
    return this.zzi;
  }
  
  public final String zze() {
    return this.zzj;
  }
  
  public static class Builder {
    private String zza;
    
    private String zzb;
    
    private String zzc;
    
    private boolean zzd;
    
    private String zze;
    
    private boolean zzf = false;
    
    private String zzg;
    
    private Builder() {}
    
    public ActionCodeSettings build() {
      if (this.zza != null)
        return new ActionCodeSettings(this, null); 
      throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
    }
    
    public Builder setAndroidPackageName(String param1String1, boolean param1Boolean, String param1String2) {
      this.zzc = param1String1;
      this.zzd = param1Boolean;
      this.zze = param1String2;
      return this;
    }
    
    public Builder setDynamicLinkDomain(String param1String) {
      this.zzg = param1String;
      return this;
    }
    
    public Builder setHandleCodeInApp(boolean param1Boolean) {
      this.zzf = param1Boolean;
      return this;
    }
    
    public Builder setIOSBundleId(String param1String) {
      this.zzb = param1String;
      return this;
    }
    
    public Builder setUrl(String param1String) {
      this.zza = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\ActionCodeSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */