package com.google.firebase.auth;

import com.google.firebase.FirebaseException;

final class zzr extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
  zzr(FirebaseAuth paramFirebaseAuth, PhoneAuthProvider.OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks) {}
  
  public final void onCodeAutoRetrievalTimeOut(String paramString) {}
  
  public final void onCodeSent(String paramString, PhoneAuthProvider.ForceResendingToken paramForceResendingToken) {
    this.zza.onVerificationCompleted(PhoneAuthProvider.getCredential(paramString, FirebaseAuth.zzd(this.zzb).zzb()));
  }
  
  public final void onVerificationCompleted(PhoneAuthCredential paramPhoneAuthCredential) {
    this.zza.onVerificationCompleted(paramPhoneAuthCredential);
  }
  
  public final void onVerificationFailed(FirebaseException paramFirebaseException) {
    this.zza.onVerificationFailed(paramFirebaseException);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */