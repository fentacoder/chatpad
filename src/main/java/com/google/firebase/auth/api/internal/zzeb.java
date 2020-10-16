package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

public abstract class zzeb extends zza implements zzec {
  public zzeb() {
    super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    switch (paramInt1) {
      default:
        return false;
      case 15:
        zza((zzej)zzd.zza(paramParcel1, zzej.CREATOR));
        return true;
      case 14:
        zza((zzeh)zzd.zza(paramParcel1, zzeh.CREATOR));
        return true;
      case 13:
        zzc();
        return true;
      case 12:
        zza((Status)zzd.zza(paramParcel1, Status.CREATOR), (PhoneAuthCredential)zzd.zza(paramParcel1, PhoneAuthCredential.CREATOR));
        return true;
      case 11:
        zzc(paramParcel1.readString());
        return true;
      case 10:
        zza((PhoneAuthCredential)zzd.zza(paramParcel1, PhoneAuthCredential.CREATOR));
        return true;
      case 9:
        zzb(paramParcel1.readString());
        return true;
      case 8:
        zza(paramParcel1.readString());
        return true;
      case 7:
        zzb();
        return true;
      case 6:
        a_();
        return true;
      case 5:
        zza((Status)zzd.zza(paramParcel1, Status.CREATOR));
        return true;
      case 4:
        zza((zzfm)zzd.zza(paramParcel1, zzfm.CREATOR));
        return true;
      case 3:
        zza((zzem)zzd.zza(paramParcel1, zzem.CREATOR));
        return true;
      case 2:
        zza((zzff)zzd.zza(paramParcel1, zzff.CREATOR), (zzew)zzd.zza(paramParcel1, zzew.CREATOR));
        return true;
      case 1:
        break;
    } 
    zza((zzff)zzd.zza(paramParcel1, zzff.CREATOR));
    return true;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzeb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */