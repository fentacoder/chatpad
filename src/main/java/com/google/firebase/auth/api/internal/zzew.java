package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

final class zzew implements zzez {
  zzew(zzeu paramzzeu, String paramString) {}
  
  public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, Object... paramVarArgs) {
    paramOnVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */