package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzy;

final class zzeu extends zzeb {
  zzeu(zzes paramzzes) {}
  
  private final void zza(Status paramStatus, AuthCredential paramAuthCredential, String paramString1, String paramString2) {
    zzes.zza(this.zza, paramStatus);
    zzes zzes1 = this.zza;
    zzes1.zzq = paramAuthCredential;
    zzes1.zzr = paramString1;
    zzes1.zzs = paramString2;
    if (zzes1.zzg != null)
      this.zza.zzg.zza(paramStatus); 
    this.zza.zza(paramStatus);
  }
  
  private final void zza(zzez paramzzez) {
    this.zza.zzj.execute(new zzfa(this, paramzzez));
  }
  
  public final void a_() throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes.zza(this.zza);
  }
  
  public final void zza(Status paramStatus) throws RemoteException {
    String str = paramStatus.getStatusMessage();
    Status status = paramStatus;
    if (str != null)
      if (str.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
        status = new Status(17081);
      } else if (str.contains("MISSING_MFA_ENROLLMENT_ID")) {
        status = new Status(17082);
      } else if (str.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
        status = new Status(17083);
      } else if (str.contains("MFA_ENROLLMENT_NOT_FOUND")) {
        status = new Status(17084);
      } else if (str.contains("ADMIN_ONLY_OPERATION")) {
        status = new Status(17085);
      } else if (str.contains("UNVERIFIED_EMAIL")) {
        status = new Status(17086);
      } else if (str.contains("SECOND_FACTOR_EXISTS")) {
        status = new Status(17087);
      } else if (str.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
        status = new Status(17088);
      } else if (str.contains("UNSUPPORTED_FIRST_FACTOR")) {
        status = new Status(17089);
      } else {
        status = paramStatus;
        if (str.contains("EMAIL_CHANGE_NEEDS_VERIFICATION"))
          status = new Status(17090); 
      }  
    if (this.zza.zzb == 8) {
      zzes.zza(this.zza, true);
      this.zza.zzw = false;
      zza(new zzex(this, status));
      return;
    } 
    zzes.zza(this.zza, status);
    this.zza.zza(status);
  }
  
  public final void zza(Status paramStatus, PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zza(paramStatus, (AuthCredential)paramPhoneAuthCredential, null, null);
  }
  
  public final void zza(zzeh paramzzeh) {
    zza(paramzzeh.zza(), (AuthCredential)paramzzeh.zzb(), paramzzeh.zzc(), paramzzeh.zzd());
  }
  
  public final void zza(zzej paramzzej) {
    zzes zzes1 = this.zza;
    zzes1.zzt = paramzzej;
    zzes1.zza(zzy.zza("REQUIRES_SECOND_FACTOR_AUTH"));
  }
  
  public final void zza(zzem paramzzem) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzm = paramzzem;
    zzes.zza(zzes1);
  }
  
  public final void zza(zzff paramzzff) throws RemoteException {
    int i = this.zza.zzb;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(37);
    stringBuilder.append("Unexpected response type: ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzk = paramzzff;
    zzes.zza(zzes1);
  }
  
  public final void zza(zzff paramzzff, zzew paramzzew) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(37);
    stringBuilder.append("Unexpected response type: ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzk = paramzzff;
    zzes1.zzl = paramzzew;
    zzes.zza(zzes1);
  }
  
  public final void zza(zzfm paramzzfm) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzn = paramzzfm;
    zzes.zza(zzes1);
  }
  
  public final void zza(PhoneAuthCredential paramPhoneAuthCredential) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes.zza(this.zza, true);
    this.zza.zzw = true;
    zza(new zzev(this, paramPhoneAuthCredential));
  }
  
  public final void zza(String paramString) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 7) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzo = paramString;
    zzes.zza(zzes1);
  }
  
  public final void zzb() throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 6) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes.zza(this.zza);
  }
  
  public final void zzb(String paramString) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    this.zza.zzp = paramString;
    zza(new zzew(this, paramString));
  }
  
  public final void zzc() throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 9) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes.zza(this.zza);
  }
  
  public final void zzc(String paramString) throws RemoteException {
    boolean bool;
    if (this.zza.zzb == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = this.zza.zzb;
    StringBuilder stringBuilder = new StringBuilder(36);
    stringBuilder.append("Unexpected response type ");
    stringBuilder.append(i);
    Preconditions.checkState(bool, stringBuilder.toString());
    zzes zzes1 = this.zza;
    zzes1.zzp = paramString;
    zzes.zza(zzes1, true);
    this.zza.zzw = true;
    zza(new zzey(this, paramString));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzeu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */