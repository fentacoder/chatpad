package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public abstract class zzc extends Service {
  private final Object lock;
  
  final ExecutorService zzt;
  
  private Binder zzu;
  
  private int zzv;
  
  private int zzw;
  
  public zzc() {
    zzb zzb = zza.zza();
    String str = String.valueOf(getClass().getSimpleName());
    if (str.length() != 0) {
      str = "Firebase-".concat(str);
    } else {
      str = new String("Firebase-");
    } 
    this.zzt = zzb.zza((ThreadFactory)new NamedThreadFactory(str), zzf.zze);
    this.lock = new Object();
    this.zzw = 0;
  }
  
  private final void zza(Intent paramIntent) {
    if (paramIntent != null)
      WakefulBroadcastReceiver.completeWakefulIntent(paramIntent); 
    synchronized (this.lock) {
      this.zzw--;
      if (this.zzw == 0)
        stopSelfResult(this.zzv); 
      return;
    } 
  }
  
  public final IBinder onBind(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'EnhancedIntentService'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'EnhancedIntentService'
    //   13: ldc 'Service received bind request'
    //   15: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: getfield zzu : Landroid/os/Binder;
    //   23: ifnonnull -> 40
    //   26: new com/google/firebase/iid/zzg
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: invokespecial <init> : (Lcom/google/firebase/iid/zzc;)V
    //   35: aload_0
    //   36: aload_1
    //   37: putfield zzu : Landroid/os/Binder;
    //   40: aload_0
    //   41: getfield zzu : Landroid/os/Binder;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	49	finally
    //   19	40	49	finally
    //   40	45	49	finally
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    synchronized (this.lock) {
      this.zzv = paramInt2;
      this.zzw++;
      null = zzb(paramIntent);
      if (null == null) {
        zza(paramIntent);
        return 2;
      } 
      if (zzc((Intent)null)) {
        zza(paramIntent);
        return 2;
      } 
      this.zzt.execute(new zzb(this, (Intent)null, paramIntent));
      return 3;
    } 
  }
  
  protected Intent zzb(Intent paramIntent) {
    return paramIntent;
  }
  
  public boolean zzc(Intent paramIntent) {
    return false;
  }
  
  public abstract void zzd(Intent paramIntent);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */