package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

final class zzax implements Runnable {
  private final zzaz zzay;
  
  private final long zzdk;
  
  private final PowerManager.WakeLock zzdl;
  
  private final FirebaseInstanceId zzdm;
  
  zzax(FirebaseInstanceId paramFirebaseInstanceId, zzan paramzzan, zzaz paramzzaz, long paramLong) {
    this.zzdm = paramFirebaseInstanceId;
    this.zzay = paramzzaz;
    this.zzdk = paramLong;
    this.zzdl = ((PowerManager)getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.zzdl.setReferenceCounted(false);
  }
  
  private final boolean zzam() {
    zzay zzay = this.zzdm.zzk();
    if (!this.zzdm.zzr() && !this.zzdm.zza(zzay))
      return true; 
    try {
      String str1 = this.zzdm.zzl();
      if (str1 == null) {
        Log.e("FirebaseInstanceId", "Token retrieval failed: null");
        return false;
      } 
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Token successfully retrieved"); 
      if (zzay == null || (zzay != null && !str1.equals(zzay.zzbv))) {
        Intent intent1 = new Intent();
        this("com.google.firebase.messaging.NEW_TOKEN");
        intent1.putExtra("token", str1);
        Context context = getContext();
        Intent intent2 = new Intent();
        this(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", (Parcelable)intent1);
        context.sendBroadcast(intent2);
      } 
      return true;
    } catch (IOException iOException) {
    
    } catch (SecurityException securityException) {}
    String str = String.valueOf(securityException.getMessage());
    if (str.length() != 0) {
      str = "Token retrieval failed: ".concat(str);
    } else {
      str = new String("Token retrieval failed: ");
    } 
    Log.e("FirebaseInstanceId", str);
    return false;
  }
  
  final Context getContext() {
    return this.zzdm.zzi().getApplicationContext();
  }
  
  public final void run() {
    try {
      if (zzaw.zzak().zzd(getContext()))
        this.zzdl.acquire(); 
      this.zzdm.zza(true);
      if (!this.zzdm.zzo()) {
        this.zzdm.zza(false);
        return;
      } 
      if (zzaw.zzak().zze(getContext()) && !zzan()) {
        zzba zzba = new zzba();
        this(this);
        zzba.zzaq();
        return;
      } 
      if (zzam() && this.zzay.zzc(this.zzdm)) {
        this.zzdm.zza(false);
      } else {
        this.zzdm.zza(this.zzdk);
      } 
      return;
    } finally {
      if (zzaw.zzak().zzd(getContext()))
        this.zzdl.release(); 
    } 
  }
  
  final boolean zzan() {
    ConnectivityManager connectivityManager = (ConnectivityManager)getContext().getSystemService("connectivity");
    if (connectivityManager != null) {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    } else {
      connectivityManager = null;
    } 
    return (connectivityManager != null && connectivityManager.isConnected());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzax.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */