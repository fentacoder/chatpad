package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

public final class zzdu {
  private final zzec zza;
  
  private final Logger zzb;
  
  public zzdu(zzec paramzzec, Logger paramLogger) {
    this.zza = (zzec)Preconditions.checkNotNull(paramzzec);
    this.zzb = (Logger)Preconditions.checkNotNull(paramLogger);
  }
  
  public final void zza() {
    try {
      this.zza.a_();
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending delete account response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(Status paramStatus) {
    try {
      this.zza.zza(paramStatus);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending failure result.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(Status paramStatus, PhoneAuthCredential paramPhoneAuthCredential) {
    try {
      this.zza.zza(paramStatus, paramPhoneAuthCredential);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending failure result.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzeh paramzzeh) {
    try {
      this.zza.zza(paramzzeh);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending failure result with credential", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzej paramzzej) {
    try {
      this.zza.zza(paramzzej);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending failure result for mfa", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzem paramzzem) {
    try {
      this.zza.zza(paramzzem);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending create auth uri response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzff paramzzff) {
    try {
      this.zza.zza(paramzzff);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending token result.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzff paramzzff, zzew paramzzew) {
    try {
      this.zza.zza(paramzzff, paramzzew);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending get token and account info user response", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(zzfm paramzzfm) {
    try {
      this.zza.zza(paramzzfm);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending password reset response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zza(String paramString) {
    try {
      this.zza.zza(paramString);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending set account info response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zzb() {
    try {
      this.zza.zzb();
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending email verification response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zzb(String paramString) {
    try {
      this.zza.zzb(paramString);
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when sending send verification code response.", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
  
  public final void zzc() {
    try {
      this.zza.zzc();
      return;
    } catch (RemoteException remoteException) {
      this.zzb.e("RemoteException when setting FirebaseUI Version", (Throwable)remoteException, new Object[0]);
      return;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */