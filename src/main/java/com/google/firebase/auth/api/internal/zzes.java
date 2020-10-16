package com.google.firebase.auth.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzae;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

abstract class zzes<ResultT, CallbackT> implements zzap<zzdt, ResultT> {
  private Activity zza;
  
  protected final int zzb;
  
  final zzeu zzc = new zzeu(this);
  
  protected FirebaseApp zzd;
  
  protected FirebaseUser zze;
  
  protected CallbackT zzf;
  
  protected zzae zzg;
  
  protected zzet<ResultT> zzh;
  
  protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzi = new ArrayList<>();
  
  protected Executor zzj;
  
  protected zzff zzk;
  
  protected zzew zzl;
  
  protected zzem zzm;
  
  protected zzfm zzn;
  
  protected String zzo;
  
  protected String zzp;
  
  protected AuthCredential zzq;
  
  protected String zzr;
  
  protected String zzs;
  
  protected zzej zzt;
  
  protected boolean zzu;
  
  protected boolean zzv;
  
  boolean zzw;
  
  private boolean zzx;
  
  private ResultT zzy;
  
  private Status zzz;
  
  public zzes(int paramInt) {
    this.zzb = paramInt;
  }
  
  private final void zzb(Status paramStatus) {
    zzae zzae1 = this.zzg;
    if (zzae1 != null)
      zzae1.zza(paramStatus); 
  }
  
  private final void zzf() {
    zze();
    Preconditions.checkState(this.zzx, "no success or failure set on method implementation");
  }
  
  public final zzes<ResultT, CallbackT> zza(FirebaseApp paramFirebaseApp) {
    this.zzd = (FirebaseApp)Preconditions.checkNotNull(paramFirebaseApp, "firebaseApp cannot be null");
    return this;
  }
  
  public final zzes<ResultT, CallbackT> zza(FirebaseUser paramFirebaseUser) {
    this.zze = (FirebaseUser)Preconditions.checkNotNull(paramFirebaseUser, "firebaseUser cannot be null");
    return this;
  }
  
  public final zzes<ResultT, CallbackT> zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, Activity paramActivity, Executor paramExecutor) {
    synchronized (this.zzi) {
      this.zzi.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks)Preconditions.checkNotNull(paramOnVerificationStateChangedCallbacks));
      this.zza = paramActivity;
      if (this.zza != null)
        zza.zza(paramActivity, this.zzi); 
      this.zzj = (Executor)Preconditions.checkNotNull(paramExecutor);
      return this;
    } 
  }
  
  public final zzes<ResultT, CallbackT> zza(zzae paramzzae) {
    this.zzg = (zzae)Preconditions.checkNotNull(paramzzae, "external failure callback cannot be null");
    return this;
  }
  
  public final zzes<ResultT, CallbackT> zza(CallbackT paramCallbackT) {
    this.zzf = (CallbackT)Preconditions.checkNotNull(paramCallbackT, "external callback cannot be null");
    return this;
  }
  
  public final void zza(Status paramStatus) {
    this.zzx = true;
    this.zzw = false;
    this.zzz = paramStatus;
    this.zzh.zza(null, paramStatus);
  }
  
  public final void zzb(ResultT paramResultT) {
    this.zzx = true;
    this.zzw = true;
    this.zzy = paramResultT;
    this.zzh.zza(paramResultT, null);
  }
  
  public final zzap<zzdt, ResultT> zzc() {
    this.zzu = true;
    return this;
  }
  
  public final zzap<zzdt, ResultT> zzd() {
    this.zzv = true;
    return this;
  }
  
  public abstract void zze();
  
  static class zza extends LifecycleCallback {
    private final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zza;
    
    private zza(LifecycleFragment param1LifecycleFragment, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> param1List) {
      super(param1LifecycleFragment);
      this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
      this.zza = param1List;
    }
    
    public static void zza(Activity param1Activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> param1List) {
      LifecycleFragment lifecycleFragment = getFragment(param1Activity);
      if ((zza)lifecycleFragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class) == null)
        new zza(lifecycleFragment, param1List); 
    }
    
    public void onStop() {
      synchronized (this.zza) {
        this.zza.clear();
        return;
      } 
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */