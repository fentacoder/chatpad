package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;

public final class zzac {
  private static zzac zzby;
  
  private final Context zzag;
  
  private final ScheduledExecutorService zzbz;
  
  private zzae zzca = new zzae(this, null);
  
  private int zzcb = 1;
  
  private zzac(Context paramContext, ScheduledExecutorService paramScheduledExecutorService) {
    this.zzbz = paramScheduledExecutorService;
    this.zzag = paramContext.getApplicationContext();
  }
  
  private final <T> Task<T> zza(zzaj<T> paramzzaj) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 64
    //   11: aload_1
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual length : ()I
    //   23: istore_3
    //   24: new java/lang/StringBuilder
    //   27: astore #4
    //   29: aload #4
    //   31: iload_3
    //   32: bipush #9
    //   34: iadd
    //   35: invokespecial <init> : (I)V
    //   38: aload #4
    //   40: ldc 'Queueing '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_2
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 'MessengerIpcClient'
    //   55: aload #4
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: getfield zzca : Lcom/google/firebase/iid/zzae;
    //   68: aload_1
    //   69: invokevirtual zzb : (Lcom/google/firebase/iid/zzaj;)Z
    //   72: ifne -> 99
    //   75: new com/google/firebase/iid/zzae
    //   78: astore_2
    //   79: aload_2
    //   80: aload_0
    //   81: aconst_null
    //   82: invokespecial <init> : (Lcom/google/firebase/iid/zzac;Lcom/google/firebase/iid/zzab;)V
    //   85: aload_0
    //   86: aload_2
    //   87: putfield zzca : Lcom/google/firebase/iid/zzae;
    //   90: aload_0
    //   91: getfield zzca : Lcom/google/firebase/iid/zzae;
    //   94: aload_1
    //   95: invokevirtual zzb : (Lcom/google/firebase/iid/zzaj;)Z
    //   98: pop
    //   99: aload_1
    //   100: getfield zzcl : Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   103: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: areturn
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	111	finally
    //   64	99	111	finally
    //   99	107	111	finally
  }
  
  public static zzac zzc(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzac
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzac.zzby : Lcom/google/firebase/iid/zzac;
    //   6: ifnonnull -> 47
    //   9: new com/google/firebase/iid/zzac
    //   12: astore_1
    //   13: invokestatic zza : ()Lcom/google/android/gms/internal/firebase_messaging/zzb;
    //   16: astore_2
    //   17: new com/google/android/gms/common/util/concurrent/NamedThreadFactory
    //   20: astore_3
    //   21: aload_3
    //   22: ldc 'MessengerIpcClient'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: iconst_1
    //   31: aload_3
    //   32: getstatic com/google/android/gms/internal/firebase_messaging/zzf.zze : I
    //   35: invokeinterface zza : (ILjava/util/concurrent/ThreadFactory;I)Ljava/util/concurrent/ScheduledExecutorService;
    //   40: invokespecial <init> : (Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   43: aload_1
    //   44: putstatic com/google/firebase/iid/zzac.zzby : Lcom/google/firebase/iid/zzac;
    //   47: getstatic com/google/firebase/iid/zzac.zzby : Lcom/google/firebase/iid/zzac;
    //   50: astore_0
    //   51: ldc com/google/firebase/iid/zzac
    //   53: monitorexit
    //   54: aload_0
    //   55: areturn
    //   56: astore_0
    //   57: ldc com/google/firebase/iid/zzac
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   3	47	56	finally
    //   47	51	56	finally
  }
  
  private final int zzx() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzcb : I
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: iconst_1
    //   10: iadd
    //   11: putfield zzcb : I
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
  
  public final Task<Void> zza(int paramInt, Bundle paramBundle) {
    return zza(new zzak(zzx(), 2, paramBundle));
  }
  
  public final Task<Bundle> zzb(int paramInt, Bundle paramBundle) {
    return zza(new zzal(zzx(), 1, paramBundle));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */