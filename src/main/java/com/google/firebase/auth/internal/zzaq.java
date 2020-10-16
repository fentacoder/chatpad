package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.firebase.auth.zzaf;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaq extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzaq> CREATOR = new zzat();
  
  private final List<zzaf> zza;
  
  zzaq(List<zzaf> paramList) {
    zzbg zzbg;
    List<zzaf> list = paramList;
    if (paramList == null)
      zzbg = zzbg.zza(); 
    this.zza = (List<zzaf>)zzbg;
  }
  
  public static zzaq zza(List<zzy> paramList) {
    if (paramList == null || paramList.isEmpty())
      return null; 
    ArrayList<zzaf> arrayList = new ArrayList();
    for (zzy zzy : paramList) {
      if (zzy instanceof zzaf)
        arrayList.add((zzaf)zzy); 
    } 
    return new zzaq(arrayList);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final List<zzy> zza() {
    ArrayList<zzaf> arrayList = new ArrayList();
    Iterator<zzaf> iterator = this.zza.iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return (List)arrayList;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzaq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */