package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
  private static final long zzaq = TimeUnit.HOURS.toSeconds(8L);
  
  private static zzav zzar;
  
  private static ScheduledExecutorService zzas;
  
  private final Executor zzat;
  
  private final FirebaseApp zzau;
  
  private final zzan zzav;
  
  private MessagingChannel zzaw;
  
  private final zzaq zzax;
  
  private final zzaz zzay;
  
  private boolean zzaz;
  
  private final zza zzba;
  
  FirebaseInstanceId(FirebaseApp paramFirebaseApp, Subscriber paramSubscriber, UserAgentPublisher paramUserAgentPublisher) {
    this(paramFirebaseApp, new zzan(paramFirebaseApp.getApplicationContext()), zzh.zze(), zzh.zze(), paramSubscriber, paramUserAgentPublisher);
  }
  
  private FirebaseInstanceId(FirebaseApp paramFirebaseApp, zzan paramzzan, Executor paramExecutor1, Executor paramExecutor2, Subscriber paramSubscriber, UserAgentPublisher paramUserAgentPublisher) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield zzaz : Z
    //   9: aload_1
    //   10: invokestatic zza : (Lcom/google/firebase/FirebaseApp;)Ljava/lang/String;
    //   13: ifnull -> 190
    //   16: ldc com/google/firebase/iid/FirebaseInstanceId
    //   18: monitorenter
    //   19: getstatic com/google/firebase/iid/FirebaseInstanceId.zzar : Lcom/google/firebase/iid/zzav;
    //   22: ifnonnull -> 44
    //   25: new com/google/firebase/iid/zzav
    //   28: astore #7
    //   30: aload #7
    //   32: aload_1
    //   33: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   36: invokespecial <init> : (Landroid/content/Context;)V
    //   39: aload #7
    //   41: putstatic com/google/firebase/iid/FirebaseInstanceId.zzar : Lcom/google/firebase/iid/zzav;
    //   44: ldc com/google/firebase/iid/FirebaseInstanceId
    //   46: monitorexit
    //   47: aload_0
    //   48: aload_1
    //   49: putfield zzau : Lcom/google/firebase/FirebaseApp;
    //   52: aload_0
    //   53: aload_2
    //   54: putfield zzav : Lcom/google/firebase/iid/zzan;
    //   57: aload_0
    //   58: getfield zzaw : Lcom/google/firebase/iid/MessagingChannel;
    //   61: ifnonnull -> 115
    //   64: aload_1
    //   65: ldc com/google/firebase/iid/MessagingChannel
    //   67: invokevirtual get : (Ljava/lang/Class;)Ljava/lang/Object;
    //   70: checkcast com/google/firebase/iid/MessagingChannel
    //   73: astore #7
    //   75: aload #7
    //   77: ifnull -> 99
    //   80: aload #7
    //   82: invokeinterface isAvailable : ()Z
    //   87: ifeq -> 99
    //   90: aload_0
    //   91: aload #7
    //   93: putfield zzaw : Lcom/google/firebase/iid/MessagingChannel;
    //   96: goto -> 115
    //   99: aload_0
    //   100: new com/google/firebase/iid/zzs
    //   103: dup
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: aload #6
    //   109: invokespecial <init> : (Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/iid/zzan;Ljava/util/concurrent/Executor;Lcom/google/firebase/platforminfo/UserAgentPublisher;)V
    //   112: putfield zzaw : Lcom/google/firebase/iid/MessagingChannel;
    //   115: aload_0
    //   116: aload_0
    //   117: getfield zzaw : Lcom/google/firebase/iid/MessagingChannel;
    //   120: putfield zzaw : Lcom/google/firebase/iid/MessagingChannel;
    //   123: aload_0
    //   124: aload #4
    //   126: putfield zzat : Ljava/util/concurrent/Executor;
    //   129: aload_0
    //   130: new com/google/firebase/iid/zzaz
    //   133: dup
    //   134: getstatic com/google/firebase/iid/FirebaseInstanceId.zzar : Lcom/google/firebase/iid/zzav;
    //   137: invokespecial <init> : (Lcom/google/firebase/iid/zzav;)V
    //   140: putfield zzay : Lcom/google/firebase/iid/zzaz;
    //   143: aload_0
    //   144: new com/google/firebase/iid/FirebaseInstanceId$zza
    //   147: dup
    //   148: aload_0
    //   149: aload #5
    //   151: invokespecial <init> : (Lcom/google/firebase/iid/FirebaseInstanceId;Lcom/google/firebase/events/Subscriber;)V
    //   154: putfield zzba : Lcom/google/firebase/iid/FirebaseInstanceId$zza;
    //   157: aload_0
    //   158: new com/google/firebase/iid/zzaq
    //   161: dup
    //   162: aload_3
    //   163: invokespecial <init> : (Ljava/util/concurrent/Executor;)V
    //   166: putfield zzax : Lcom/google/firebase/iid/zzaq;
    //   169: aload_0
    //   170: getfield zzba : Lcom/google/firebase/iid/FirebaseInstanceId$zza;
    //   173: invokevirtual isEnabled : ()Z
    //   176: ifeq -> 183
    //   179: aload_0
    //   180: invokespecial zzh : ()V
    //   183: return
    //   184: astore_1
    //   185: ldc com/google/firebase/iid/FirebaseInstanceId
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: new java/lang/IllegalStateException
    //   193: dup
    //   194: ldc 'FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID'
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: athrow
    // Exception table:
    //   from	to	target	type
    //   19	44	184	finally
    //   44	47	184	finally
    //   185	188	184	finally
  }
  
  public static FirebaseInstanceId getInstance() {
    return getInstance(FirebaseApp.getInstance());
  }
  
  public static FirebaseInstanceId getInstance(FirebaseApp paramFirebaseApp) {
    return (FirebaseInstanceId)paramFirebaseApp.get(FirebaseInstanceId.class);
  }
  
  private final void startSync() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzaz : Z
    //   6: ifne -> 14
    //   9: aload_0
    //   10: lconst_0
    //   11: invokevirtual zza : (J)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  private final Task<InstanceIdResult> zza(String paramString1, String paramString2) {
    paramString2 = zzd(paramString2);
    return Tasks.forResult(null).continueWithTask(this.zzat, new zzo(this, paramString1, paramString2));
  }
  
  private final <T> T zza(Task<T> paramTask) throws IOException {
    try {
      return (T)Tasks.await(paramTask, 30000L, TimeUnit.MILLISECONDS);
    } catch (ExecutionException executionException) {
      Throwable throwable = executionException.getCause();
      if (throwable instanceof IOException) {
        if ("INSTANCE_ID_RESET".equals(throwable.getMessage()))
          zzn(); 
        throw (IOException)throwable;
      } 
      if (throwable instanceof RuntimeException)
        throw (RuntimeException)throwable; 
      throw new IOException(executionException);
    } catch (InterruptedException|java.util.concurrent.TimeoutException interruptedException) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    } 
  }
  
  static void zza(Runnable paramRunnable, long paramLong) {
    // Byte code:
    //   0: ldc com/google/firebase/iid/FirebaseInstanceId
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/FirebaseInstanceId.zzas : Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnonnull -> 36
    //   9: new java/util/concurrent/ScheduledThreadPoolExecutor
    //   12: astore_3
    //   13: new com/google/android/gms/common/util/concurrent/NamedThreadFactory
    //   16: astore #4
    //   18: aload #4
    //   20: ldc 'FirebaseInstanceId'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: aload_3
    //   26: iconst_1
    //   27: aload #4
    //   29: invokespecial <init> : (ILjava/util/concurrent/ThreadFactory;)V
    //   32: aload_3
    //   33: putstatic com/google/firebase/iid/FirebaseInstanceId.zzas : Ljava/util/concurrent/ScheduledExecutorService;
    //   36: getstatic com/google/firebase/iid/FirebaseInstanceId.zzas : Ljava/util/concurrent/ScheduledExecutorService;
    //   39: aload_0
    //   40: lload_1
    //   41: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   44: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   49: pop
    //   50: ldc com/google/firebase/iid/FirebaseInstanceId
    //   52: monitorexit
    //   53: return
    //   54: astore_0
    //   55: ldc com/google/firebase/iid/FirebaseInstanceId
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   3	36	54	finally
    //   36	53	54	finally
    //   55	58	54	finally
  }
  
  private static zzay zzb(String paramString1, String paramString2) {
    return zzar.zzb("", paramString1, paramString2);
  }
  
  private static String zzd(String paramString) {
    return (paramString.isEmpty() || paramString.equalsIgnoreCase("fcm") || paramString.equalsIgnoreCase("gcm")) ? "*" : paramString;
  }
  
  private final void zzh() {
    zzay zzay = zzk();
    if (zzr() || zza(zzay) || this.zzay.zzao())
      startSync(); 
  }
  
  private static String zzj() {
    return zzan.zza(zzar.zzg("").getKeyPair());
  }
  
  static boolean zzm() {
    return (Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3)));
  }
  
  public void deleteInstanceId() throws IOException {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      String str = zzj();
      zza(this.zzaw.deleteInstanceId(str));
      zzn();
      return;
    } 
    throw new IOException("MAIN_THREAD");
  }
  
  public void deleteToken(String paramString1, String paramString2) throws IOException {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      String str1 = zzd(paramString2);
      String str2 = zzj();
      paramString2 = zzay.zzb(zzb(paramString1, str1));
      zza(this.zzaw.deleteToken(str2, paramString2, paramString1, str1));
      zzar.zzc("", paramString1, str1);
      return;
    } 
    throw new IOException("MAIN_THREAD");
  }
  
  public long getCreationTime() {
    return zzar.zzg("").getCreationTime();
  }
  
  public String getId() {
    zzh();
    return zzj();
  }
  
  public Task<InstanceIdResult> getInstanceId() {
    return zza(zzan.zza(this.zzau), "*");
  }
  
  @Deprecated
  public String getToken() {
    zzay zzay = zzk();
    if (this.zzaw.needsRefresh() || zza(zzay))
      startSync(); 
    return zzay.zzb(zzay);
  }
  
  public String getToken(String paramString1, String paramString2) throws IOException {
    if (Looper.getMainLooper() != Looper.myLooper())
      return ((InstanceIdResult)zza(zza(paramString1, paramString2))).getToken(); 
    throw new IOException("MAIN_THREAD");
  }
  
  public final Task<Void> zza(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzay : Lcom/google/firebase/iid/zzaz;
    //   6: aload_1
    //   7: invokevirtual zza : (Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;
    //   10: astore_1
    //   11: aload_0
    //   12: invokespecial startSync : ()V
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	19	finally
  }
  
  final void zza(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 30
    //   5: lload_1
    //   6: iconst_1
    //   7: lshl
    //   8: invokestatic max : (JJ)J
    //   11: getstatic com/google/firebase/iid/FirebaseInstanceId.zzaq : J
    //   14: invokestatic min : (JJ)J
    //   17: lstore_3
    //   18: new com/google/firebase/iid/zzax
    //   21: astore #5
    //   23: aload #5
    //   25: aload_0
    //   26: aload_0
    //   27: getfield zzav : Lcom/google/firebase/iid/zzan;
    //   30: aload_0
    //   31: getfield zzay : Lcom/google/firebase/iid/zzaz;
    //   34: lload_3
    //   35: invokespecial <init> : (Lcom/google/firebase/iid/FirebaseInstanceId;Lcom/google/firebase/iid/zzan;Lcom/google/firebase/iid/zzaz;J)V
    //   38: aload #5
    //   40: lload_1
    //   41: invokestatic zza : (Ljava/lang/Runnable;J)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield zzaz : Z
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore #5
    //   54: aload_0
    //   55: monitorexit
    //   56: aload #5
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
  }
  
  final void zza(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield zzaz : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  final boolean zza(zzay paramzzay) {
    return (paramzzay == null || paramzzay.zzj(this.zzav.zzad()));
  }
  
  final void zzb(String paramString) throws IOException {
    zzay zzay = zzk();
    if (!zza(zzay)) {
      String str2 = zzj();
      String str1 = zzay.zzbv;
      zza(this.zzaw.subscribeToTopic(str2, str1, paramString));
      return;
    } 
    throw new IOException("token not available");
  }
  
  public final void zzb(boolean paramBoolean) {
    this.zzba.setEnabled(paramBoolean);
  }
  
  final void zzc(String paramString) throws IOException {
    zzay zzay = zzk();
    if (!zza(zzay)) {
      String str = zzj();
      zza(this.zzaw.unsubscribeFromTopic(str, zzay.zzbv, paramString));
      return;
    } 
    throw new IOException("token not available");
  }
  
  final FirebaseApp zzi() {
    return this.zzau;
  }
  
  final zzay zzk() {
    return zzb(zzan.zza(this.zzau), "*");
  }
  
  final String zzl() throws IOException {
    return getToken(zzan.zza(this.zzau), "*");
  }
  
  final void zzn() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/google/firebase/iid/FirebaseInstanceId.zzar : Lcom/google/firebase/iid/zzav;
    //   5: invokevirtual zzaj : ()V
    //   8: aload_0
    //   9: getfield zzba : Lcom/google/firebase/iid/FirebaseInstanceId$zza;
    //   12: invokevirtual isEnabled : ()Z
    //   15: ifeq -> 22
    //   18: aload_0
    //   19: invokespecial startSync : ()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  final boolean zzo() {
    return this.zzaw.isAvailable();
  }
  
  final void zzp() {
    zzar.zzh("");
    startSync();
  }
  
  public final boolean zzq() {
    return this.zzba.isEnabled();
  }
  
  final boolean zzr() {
    return this.zzaw.needsRefresh();
  }
  
  private final class zza {
    private final boolean zzbg;
    
    private final Subscriber zzbh;
    
    private EventHandler<DataCollectionDefaultChange> zzbi;
    
    private Boolean zzbj;
    
    zza(FirebaseInstanceId this$0, Subscriber param1Subscriber) {
      this.zzbh = param1Subscriber;
      this.zzbg = zzu();
      this.zzbj = zzt();
      if (this.zzbj == null && this.zzbg) {
        this.zzbi = new zzq(this);
        param1Subscriber.subscribe(DataCollectionDefaultChange.class, this.zzbi);
      } 
    }
    
    private final Boolean zzt() {
      Context context = FirebaseInstanceId.zza(this.zzbk).getApplicationContext();
      SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
      if (sharedPreferences.contains("auto_init"))
        return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false)); 
      try {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
          ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
          if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
            boolean bool = applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
            return Boolean.valueOf(bool);
          } 
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
      return null;
    }
    
    private final boolean zzu() {
      try {
        Class.forName("com.google.firebase.messaging.FirebaseMessaging");
        return true;
      } catch (ClassNotFoundException classNotFoundException) {
        Context context = FirebaseInstanceId.zza(this.zzbk).getApplicationContext();
        Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
        return (resolveInfo != null && resolveInfo.serviceInfo != null);
      } 
    }
    
    final boolean isEnabled() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zzbj : Ljava/lang/Boolean;
      //   6: ifnull -> 21
      //   9: aload_0
      //   10: getfield zzbj : Ljava/lang/Boolean;
      //   13: invokevirtual booleanValue : ()Z
      //   16: istore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: iload_1
      //   20: ireturn
      //   21: aload_0
      //   22: getfield zzbg : Z
      //   25: ifeq -> 47
      //   28: aload_0
      //   29: getfield zzbk : Lcom/google/firebase/iid/FirebaseInstanceId;
      //   32: invokestatic zza : (Lcom/google/firebase/iid/FirebaseInstanceId;)Lcom/google/firebase/FirebaseApp;
      //   35: invokevirtual isDataCollectionDefaultEnabled : ()Z
      //   38: istore_1
      //   39: iload_1
      //   40: ifeq -> 47
      //   43: aload_0
      //   44: monitorexit
      //   45: iconst_1
      //   46: ireturn
      //   47: aload_0
      //   48: monitorexit
      //   49: iconst_0
      //   50: ireturn
      //   51: astore_2
      //   52: aload_0
      //   53: monitorexit
      //   54: aload_2
      //   55: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	51	finally
      //   21	39	51	finally
    }
    
    final void setEnabled(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zzbi : Lcom/google/firebase/events/EventHandler;
      //   6: ifnull -> 29
      //   9: aload_0
      //   10: getfield zzbh : Lcom/google/firebase/events/Subscriber;
      //   13: ldc com/google/firebase/DataCollectionDefaultChange
      //   15: aload_0
      //   16: getfield zzbi : Lcom/google/firebase/events/EventHandler;
      //   19: invokeinterface unsubscribe : (Ljava/lang/Class;Lcom/google/firebase/events/EventHandler;)V
      //   24: aload_0
      //   25: aconst_null
      //   26: putfield zzbi : Lcom/google/firebase/events/EventHandler;
      //   29: aload_0
      //   30: getfield zzbk : Lcom/google/firebase/iid/FirebaseInstanceId;
      //   33: invokestatic zza : (Lcom/google/firebase/iid/FirebaseInstanceId;)Lcom/google/firebase/FirebaseApp;
      //   36: invokevirtual getApplicationContext : ()Landroid/content/Context;
      //   39: ldc 'com.google.firebase.messaging'
      //   41: iconst_0
      //   42: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   45: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
      //   50: astore_2
      //   51: aload_2
      //   52: ldc 'auto_init'
      //   54: iload_1
      //   55: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
      //   60: pop
      //   61: aload_2
      //   62: invokeinterface apply : ()V
      //   67: iload_1
      //   68: ifeq -> 78
      //   71: aload_0
      //   72: getfield zzbk : Lcom/google/firebase/iid/FirebaseInstanceId;
      //   75: invokestatic zzb : (Lcom/google/firebase/iid/FirebaseInstanceId;)V
      //   78: aload_0
      //   79: iload_1
      //   80: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   83: putfield zzbj : Ljava/lang/Boolean;
      //   86: aload_0
      //   87: monitorexit
      //   88: return
      //   89: astore_2
      //   90: aload_0
      //   91: monitorexit
      //   92: aload_2
      //   93: athrow
      // Exception table:
      //   from	to	target	type
      //   2	29	89	finally
      //   29	67	89	finally
      //   71	78	89	finally
      //   78	86	89	finally
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\FirebaseInstanceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */