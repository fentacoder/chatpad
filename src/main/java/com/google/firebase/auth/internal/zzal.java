package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.internal.zzdv;
import java.lang.ref.WeakReference;

final class zzal extends BroadcastReceiver {
  private final WeakReference<Activity> zza;
  
  private final TaskCompletionSource<AuthResult> zzb;
  
  private final FirebaseAuth zzc;
  
  private final FirebaseUser zzd;
  
  zzal(zzad paramzzad, Activity paramActivity, TaskCompletionSource<AuthResult> paramTaskCompletionSource, FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {
    this.zza = new WeakReference<>(paramActivity);
    this.zzb = paramTaskCompletionSource;
    this.zzc = paramFirebaseAuth;
    this.zzd = paramFirebaseUser;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    TaskCompletionSource<AuthResult> taskCompletionSource;
    Activity activity = this.zza.get();
    if (activity == null) {
      Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
      this.zzb.setException((Exception)zzdv.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
      zzad.zzb();
      return;
    } 
    LocalBroadcastManager.getInstance((Context)activity).unregisterReceiver(this);
    if (paramIntent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
      String str = paramIntent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
      if ("com.google.firebase.auth.internal.SIGN_IN".equals(str)) {
        zzad.zza(this.zze, paramIntent, this.zzb, this.zzc);
        return;
      } 
      if ("com.google.firebase.auth.internal.LINK".equals(str)) {
        zzad.zza(this.zze, paramIntent, this.zzb, this.zzd);
        return;
      } 
      if ("com.google.firebase.auth.internal.REAUTHENTICATE".equals(str)) {
        zzad.zzb(this.zze, paramIntent, this.zzb, this.zzd);
        return;
      } 
      taskCompletionSource = this.zzb;
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 50);
      stringBuilder.append("WEB_CONTEXT_CANCELED:Unknown operation received (");
      stringBuilder.append(str);
      stringBuilder.append(")");
      taskCompletionSource.setException((Exception)zzdv.zza(zzy.zza(stringBuilder.toString())));
      return;
    } 
    if (zzay.zza((Intent)taskCompletionSource)) {
      Status status = zzay.zzb((Intent)taskCompletionSource);
      this.zzb.setException((Exception)zzdv.zza(status));
      zzad.zzb();
      return;
    } 
    if (taskCompletionSource.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
      this.zzb.setException((Exception)zzdv.zza(zzy.zza("WEB_CONTEXT_CANCELED")));
      zzad.zzb();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */