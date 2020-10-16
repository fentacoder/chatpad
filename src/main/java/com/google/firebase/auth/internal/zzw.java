package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.zzaa;
import com.google.firebase.auth.zzaf;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;

public final class zzw extends zzaa {
  public static final Parcelable.Creator<zzw> CREATOR = new zzv();
  
  private String zza;
  
  private String zzb;
  
  private List<zzaf> zzc;
  
  private zzw() {}
  
  zzw(String paramString1, String paramString2, List<zzaf> paramList) {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramList;
  }
  
  public static zzw zza(List<zzy> paramList, String paramString) {
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotEmpty(paramString);
    zzw zzw1 = new zzw();
    zzw1.zzc = new ArrayList<>();
    for (zzy zzy : paramList) {
      if (zzy instanceof zzaf)
        zzw1.zzc.add((zzaf)zzy); 
    } 
    zzw1.zzb = paramString;
    return zzw1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */