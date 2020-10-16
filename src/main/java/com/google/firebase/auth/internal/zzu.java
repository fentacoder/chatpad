package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzab;
import com.google.firebase.auth.zzaf;
import com.google.firebase.auth.zzg;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;

public final class zzu extends zzab {
  public static final Parcelable.Creator<zzu> CREATOR = new zzt();
  
  private final List<zzaf> zza = new ArrayList<>();
  
  private final zzw zzb;
  
  private final String zzc;
  
  private final zzg zzd;
  
  private final zzn zze;
  
  public zzu(List<zzaf> paramList, zzw paramzzw, String paramString, zzg paramzzg, zzn paramzzn) {
    for (zzy zzy : paramList) {
      if (zzy instanceof zzaf)
        this.zza.add((zzaf)zzy); 
    } 
    this.zzb = (zzw)Preconditions.checkNotNull(paramzzw);
    this.zzc = Preconditions.checkNotEmpty(paramString);
    this.zzd = paramzzg;
    this.zze = paramzzn;
  }
  
  public static zzu zza(zzej paramzzej, FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {
    List list = paramzzej.zzc();
    ArrayList<zzaf> arrayList = new ArrayList();
    for (zzy zzy : list) {
      if (zzy instanceof zzaf)
        arrayList.add((zzaf)zzy); 
    } 
    return new zzu(arrayList, zzw.zza(paramzzej.zzc(), paramzzej.zza()), paramFirebaseAuth.zzb().getName(), paramzzej.zzb(), (zzn)paramFirebaseUser);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zzd, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, (Parcelable)this.zze, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */