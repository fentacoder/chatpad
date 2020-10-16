package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class PhoneAuthProvider {
  public static final String PHONE_SIGN_IN_METHOD = "phone";
  
  public static final String PROVIDER_ID = "phone";
  
  private FirebaseAuth zza;
  
  private PhoneAuthProvider(FirebaseAuth paramFirebaseAuth) {
    this.zza = paramFirebaseAuth;
  }
  
  public static PhoneAuthCredential getCredential(String paramString1, String paramString2) {
    return new PhoneAuthCredential(paramString1, paramString2, false, null, true, null, null);
  }
  
  public static PhoneAuthProvider getInstance() {
    return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
  }
  
  public static PhoneAuthProvider getInstance(FirebaseAuth paramFirebaseAuth) {
    return new PhoneAuthProvider(paramFirebaseAuth);
  }
  
  private final void zza(String paramString, long paramLong, TimeUnit paramTimeUnit, Activity paramActivity, Executor paramExecutor, OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, ForceResendingToken paramForceResendingToken) {
    boolean bool;
    FirebaseAuth firebaseAuth = this.zza;
    if (paramForceResendingToken != null) {
      bool = true;
    } else {
      bool = false;
    } 
    firebaseAuth.zza(paramString, paramLong, paramTimeUnit, paramOnVerificationStateChangedCallbacks, paramActivity, paramExecutor, bool, null);
  }
  
  public void verifyPhoneNumber(String paramString, long paramLong, TimeUnit paramTimeUnit, Activity paramActivity, OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks) {
    zza(Preconditions.checkNotEmpty(paramString), paramLong, paramTimeUnit, (Activity)Preconditions.checkNotNull(paramActivity), TaskExecutors.MAIN_THREAD, (OnVerificationStateChangedCallbacks)Preconditions.checkNotNull(paramOnVerificationStateChangedCallbacks), null);
  }
  
  public void verifyPhoneNumber(String paramString, long paramLong, TimeUnit paramTimeUnit, Activity paramActivity, OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, ForceResendingToken paramForceResendingToken) {
    zza(Preconditions.checkNotEmpty(paramString), paramLong, paramTimeUnit, (Activity)Preconditions.checkNotNull(paramActivity), TaskExecutors.MAIN_THREAD, (OnVerificationStateChangedCallbacks)Preconditions.checkNotNull(paramOnVerificationStateChangedCallbacks), paramForceResendingToken);
  }
  
  public void verifyPhoneNumber(String paramString, long paramLong, TimeUnit paramTimeUnit, Executor paramExecutor, OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks) {
    zza(Preconditions.checkNotEmpty(paramString), paramLong, paramTimeUnit, null, (Executor)Preconditions.checkNotNull(paramExecutor), (OnVerificationStateChangedCallbacks)Preconditions.checkNotNull(paramOnVerificationStateChangedCallbacks), null);
  }
  
  public void verifyPhoneNumber(String paramString, long paramLong, TimeUnit paramTimeUnit, Executor paramExecutor, OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, ForceResendingToken paramForceResendingToken) {
    zza(Preconditions.checkNotEmpty(paramString), paramLong, paramTimeUnit, null, (Executor)Preconditions.checkNotNull(paramExecutor), (OnVerificationStateChangedCallbacks)Preconditions.checkNotNull(paramOnVerificationStateChangedCallbacks), paramForceResendingToken);
  }
  
  public static class ForceResendingToken extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzh();
    
    public static ForceResendingToken zza() {
      return new ForceResendingToken();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      SafeParcelWriter.finishObjectHeader(param1Parcel, SafeParcelWriter.beginObjectHeader(param1Parcel));
    }
  }
  
  public static abstract class OnVerificationStateChangedCallbacks {
    private static final Logger zza = new Logger("PhoneAuthProvider", new String[0]);
    
    public void onCodeAutoRetrievalTimeOut(String param1String) {
      zza.i("Sms auto retrieval timed-out.", new Object[0]);
    }
    
    public void onCodeSent(String param1String, PhoneAuthProvider.ForceResendingToken param1ForceResendingToken) {}
    
    public abstract void onVerificationCompleted(PhoneAuthCredential param1PhoneAuthCredential);
    
    public abstract void onVerificationFailed(FirebaseException param1FirebaseException);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\PhoneAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */