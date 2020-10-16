package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzg;

public final class zzad {
  private static zzad zzb;
  
  private boolean zza = false;
  
  private static AuthCredential zza(Intent paramIntent) {
    Preconditions.checkNotNull(paramIntent);
    return (AuthCredential)zzg.zza(((zzfy)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzfy.CREATOR)).zzb(true));
  }
  
  public static zzad zza() {
    if (zzb == null)
      zzb = new zzad(); 
    return zzb;
  }
  
  private final void zza(Intent paramIntent, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth) {
    paramFirebaseAuth.signInWithCredential(zza(paramIntent)).addOnSuccessListener(new zzaf(this, paramTaskCompletionSource)).addOnFailureListener(new zzag(this, paramTaskCompletionSource));
  }
  
  private final void zza(Intent paramIntent, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseUser paramFirebaseUser) {
    paramFirebaseUser.linkWithCredential(zza(paramIntent)).addOnSuccessListener(new zzah(this, paramTaskCompletionSource)).addOnFailureListener(new zzai(this, paramTaskCompletionSource));
  }
  
  static void zzb() {
    zzb.zza = false;
  }
  
  private final void zzb(Intent paramIntent, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseUser paramFirebaseUser) {
    paramFirebaseUser.reauthenticateAndRetrieveData(zza(paramIntent)).addOnSuccessListener(new zzaj(this, paramTaskCompletionSource)).addOnFailureListener(new zzak(this, paramTaskCompletionSource));
  }
  
  public final boolean zza(Activity paramActivity, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth) {
    return zza(paramActivity, paramTaskCompletionSource, paramFirebaseAuth, (FirebaseUser)null);
  }
  
  public final boolean zza(Activity paramActivity, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {
    if (!this.zza) {
      LocalBroadcastManager.getInstance((Context)paramActivity).registerReceiver(new zzal(this, paramActivity, paramTaskCompletionSource, paramFirebaseAuth, paramFirebaseUser), new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
      this.zza = true;
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */