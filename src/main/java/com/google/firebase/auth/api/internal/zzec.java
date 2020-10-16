package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

public interface zzec extends IInterface {
  void a_() throws RemoteException;
  
  void zza(Status paramStatus) throws RemoteException;
  
  void zza(Status paramStatus, PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException;
  
  void zza(zzeh paramzzeh) throws RemoteException;
  
  void zza(zzej paramzzej) throws RemoteException;
  
  void zza(zzem paramzzem) throws RemoteException;
  
  void zza(zzff paramzzff) throws RemoteException;
  
  void zza(zzff paramzzff, zzew paramzzew) throws RemoteException;
  
  void zza(zzfm paramzzfm) throws RemoteException;
  
  void zza(PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException;
  
  void zza(String paramString) throws RemoteException;
  
  void zzb() throws RemoteException;
  
  void zzb(String paramString) throws RemoteException;
  
  void zzc() throws RemoteException;
  
  void zzc(String paramString) throws RemoteException;
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */