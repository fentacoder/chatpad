package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.firebase.auth.PhoneAuthCredential;

public final class zzff {
  public static zzgg zza(PhoneAuthCredential paramPhoneAuthCredential) {
    return !TextUtils.isEmpty(paramPhoneAuthCredential.zze()) ? zzgg.zzb(paramPhoneAuthCredential.zzc(), paramPhoneAuthCredential.zze(), paramPhoneAuthCredential.zzd()) : zzgg.zza(paramPhoneAuthCredential.zzb(), paramPhoneAuthCredential.getSmsCode(), paramPhoneAuthCredential.zzd());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */