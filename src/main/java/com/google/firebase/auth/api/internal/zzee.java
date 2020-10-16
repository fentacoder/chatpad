package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

public final class zzee extends zzb implements zzec {
  zzee(IBinder paramIBinder) {
    super(paramIBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
  }
  
  public final void a_() throws RemoteException {
    zzb(6, zza());
  }
  
  public final void zza(Status paramStatus) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramStatus);
    zzb(5, parcel);
  }
  
  public final void zza(Status paramStatus, PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramStatus);
    zzd.zza(parcel, (Parcelable)paramPhoneAuthCredential);
    zzb(12, parcel);
  }
  
  public final void zza(zzeh paramzzeh) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzeh);
    zzb(14, parcel);
  }
  
  public final void zza(zzej paramzzej) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzej);
    zzb(15, parcel);
  }
  
  public final void zza(zzem paramzzem) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzem);
    zzb(3, parcel);
  }
  
  public final void zza(zzff paramzzff) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzff);
    zzb(1, parcel);
  }
  
  public final void zza(zzff paramzzff, zzew paramzzew) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzff);
    zzd.zza(parcel, (Parcelable)paramzzew);
    zzb(2, parcel);
  }
  
  public final void zza(zzfm paramzzfm) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramzzfm);
    zzb(4, parcel);
  }
  
  public final void zza(PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException {
    Parcel parcel = zza();
    zzd.zza(parcel, (Parcelable)paramPhoneAuthCredential);
    zzb(10, parcel);
  }
  
  public final void zza(String paramString) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzb(8, parcel);
  }
  
  public final void zzb() throws RemoteException {
    zzb(7, zza());
  }
  
  public final void zzb(String paramString) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzb(9, parcel);
  }
  
  public final void zzc() throws RemoteException {
    zzb(13, zza());
  }
  
  public final void zzc(String paramString) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzb(11, parcel);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */