package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zze {
  final Intent intent;
  
  private boolean zzaa = false;
  
  private final ScheduledFuture<?> zzab;
  
  private final BroadcastReceiver.PendingResult zzz;
  
  zze(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult, ScheduledExecutorService paramScheduledExecutorService) {
    this.intent = paramIntent;
    this.zzz = paramPendingResult;
    this.zzab = paramScheduledExecutorService.schedule(new zzd(this, paramIntent), 9000L, TimeUnit.MILLISECONDS);
  }
  
  final void finish() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzaa : Z
    //   6: ifne -> 32
    //   9: aload_0
    //   10: getfield zzz : Landroid/content/BroadcastReceiver$PendingResult;
    //   13: invokevirtual finish : ()V
    //   16: aload_0
    //   17: getfield zzab : Ljava/util/concurrent/ScheduledFuture;
    //   20: iconst_0
    //   21: invokeinterface cancel : (Z)Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield zzaa : Z
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	35	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zze.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */