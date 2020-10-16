package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfh;
import com.google.firebase.auth.zzaf;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzar {
  public static zzy zza(zzfh paramzzfh) {
    zzaf zzaf = null;
    if (paramzzfh == null)
      return null; 
    if (!TextUtils.isEmpty(paramzzfh.zza()))
      zzaf = new zzaf(paramzzfh.zzb(), paramzzfh.zzc(), paramzzfh.zzd(), paramzzfh.zza()); 
    return (zzy)zzaf;
  }
  
  public static List<zzy> zza(List<zzfh> paramList) {
    if (paramList == null || paramList.isEmpty())
      return (List<zzy>)zzbg.zza(); 
    ArrayList<zzy> arrayList = new ArrayList();
    Iterator<zzfh> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      zzy zzy = zza(iterator.next());
      if (zzy != null)
        arrayList.add(zzy); 
    } 
    return arrayList;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */