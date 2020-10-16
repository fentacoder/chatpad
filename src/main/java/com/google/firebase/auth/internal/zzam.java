package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public final class zzam {
  private static final zzam zzc = new zzam();
  
  private final zzas zza;
  
  private final zzad zzb;
  
  private zzam() {
    this(zzas.zza(), zzad.zza());
  }
  
  private zzam(zzas paramzzas, zzad paramzzad) {
    this.zza = paramzzas;
    this.zzb = paramzzad;
  }
  
  public static zzam zza() {
    return zzc;
  }
  
  public final void zza(Context paramContext) {
    this.zza.zza(paramContext);
  }
  
  public final void zza(FirebaseAuth paramFirebaseAuth) {
    this.zza.zza(paramFirebaseAuth);
  }
  
  public final boolean zza(Activity paramActivity, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth) {
    return this.zzb.zza(paramActivity, paramTaskCompletionSource, paramFirebaseAuth);
  }
  
  public final boolean zza(Activity paramActivity, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {
    return this.zzb.zza(paramActivity, paramTaskCompletionSource, paramFirebaseAuth, paramFirebaseUser);
  }
  
  public final Task<AuthResult> zzb() {
    return this.zza.zzb();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */