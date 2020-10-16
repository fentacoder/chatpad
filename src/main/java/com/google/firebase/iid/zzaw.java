package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzaw {
  private static zzaw zzdf;
  
  private String zzdg = null;
  
  private Boolean zzdh = null;
  
  private Boolean zzdi = null;
  
  private final Queue<Intent> zzdj = new ArrayDeque<>();
  
  public static zzaw zzak() {
    // Byte code:
    //   0: ldc com/google/firebase/iid/zzaw
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/zzaw.zzdf : Lcom/google/firebase/iid/zzaw;
    //   6: ifnonnull -> 21
    //   9: new com/google/firebase/iid/zzaw
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/google/firebase/iid/zzaw.zzdf : Lcom/google/firebase/iid/zzaw;
    //   21: getstatic com/google/firebase/iid/zzaw.zzdf : Lcom/google/firebase/iid/zzaw;
    //   24: astore_0
    //   25: ldc com/google/firebase/iid/zzaw
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/google/firebase/iid/zzaw
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  private final int zzd(Context paramContext, Intent paramIntent) {
    String str = zze(paramContext, paramIntent);
    if (str != null) {
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        String str1 = String.valueOf(str);
        if (str1.length() != 0) {
          str1 = "Restricting intent to a specific service: ".concat(str1);
        } else {
          str1 = new String("Restricting intent to a specific service: ");
        } 
        Log.d("FirebaseInstanceId", str1);
      } 
      paramIntent.setClassName(paramContext.getPackageName(), str);
    } 
    try {
      ComponentName componentName;
      if (zzd(paramContext)) {
        componentName = WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
      } else {
        componentName = componentName.startService(paramIntent);
        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
      } 
      if (componentName == null) {
        Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
        return 404;
      } 
      return -1;
    } catch (SecurityException securityException) {
      Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", securityException);
      return 401;
    } catch (IllegalStateException illegalStateException) {
      String str1 = String.valueOf(illegalStateException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 45);
      stringBuilder.append("Failed to start service while in background: ");
      stringBuilder.append(str1);
      Log.e("FirebaseInstanceId", stringBuilder.toString());
      return 402;
    } 
  }
  
  private final String zze(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzdg : Ljava/lang/String;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield zzdg : Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_1
    //   19: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   22: aload_2
    //   23: iconst_0
    //   24: invokevirtual resolveService : (Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull -> 233
    //   32: aload_2
    //   33: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   36: ifnonnull -> 42
    //   39: goto -> 233
    //   42: aload_2
    //   43: getfield serviceInfo : Landroid/content/pm/ServiceInfo;
    //   46: astore_2
    //   47: aload_1
    //   48: invokevirtual getPackageName : ()Ljava/lang/String;
    //   51: aload_2
    //   52: getfield packageName : Ljava/lang/String;
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 149
    //   61: aload_2
    //   62: getfield name : Ljava/lang/String;
    //   65: ifnonnull -> 71
    //   68: goto -> 149
    //   71: aload_2
    //   72: getfield name : Ljava/lang/String;
    //   75: ldc '.'
    //   77: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   80: ifeq -> 132
    //   83: aload_1
    //   84: invokevirtual getPackageName : ()Ljava/lang/String;
    //   87: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore_1
    //   91: aload_2
    //   92: getfield name : Ljava/lang/String;
    //   95: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual length : ()I
    //   103: ifeq -> 115
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_1
    //   112: goto -> 124
    //   115: new java/lang/String
    //   118: dup
    //   119: aload_1
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: astore_1
    //   124: aload_0
    //   125: aload_1
    //   126: putfield zzdg : Ljava/lang/String;
    //   129: goto -> 140
    //   132: aload_0
    //   133: aload_2
    //   134: getfield name : Ljava/lang/String;
    //   137: putfield zzdg : Ljava/lang/String;
    //   140: aload_0
    //   141: getfield zzdg : Ljava/lang/String;
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: areturn
    //   149: aload_2
    //   150: getfield packageName : Ljava/lang/String;
    //   153: astore_1
    //   154: aload_2
    //   155: getfield name : Ljava/lang/String;
    //   158: astore_3
    //   159: aload_1
    //   160: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual length : ()I
    //   166: istore #4
    //   168: aload_3
    //   169: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokevirtual length : ()I
    //   175: istore #5
    //   177: new java/lang/StringBuilder
    //   180: astore_2
    //   181: aload_2
    //   182: iload #4
    //   184: bipush #94
    //   186: iadd
    //   187: iload #5
    //   189: iadd
    //   190: invokespecial <init> : (I)V
    //   193: aload_2
    //   194: ldc 'Error resolving target intent service, skipping classname enforcement. Resolved service was: '
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_2
    //   201: aload_1
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: ldc '/'
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 'FirebaseInstanceId'
    //   221: aload_2
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   228: pop
    //   229: aload_0
    //   230: monitorexit
    //   231: aconst_null
    //   232: areturn
    //   233: ldc 'FirebaseInstanceId'
    //   235: ldc 'Failed to resolve target intent service, skipping classname enforcement'
    //   237: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: aload_0
    //   242: monitorexit
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	245	finally
    //   18	28	245	finally
    //   32	39	245	finally
    //   42	68	245	finally
    //   71	112	245	finally
    //   115	124	245	finally
    //   124	129	245	finally
    //   132	140	245	finally
    //   140	145	245	finally
    //   149	229	245	finally
    //   233	241	245	finally
  }
  
  public final Intent zzal() {
    return this.zzdj.poll();
  }
  
  public final int zzc(Context paramContext, Intent paramIntent) {
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Starting service"); 
    this.zzdj.offer(paramIntent);
    paramIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
    paramIntent.setPackage(paramContext.getPackageName());
    return zzd(paramContext, paramIntent);
  }
  
  final boolean zzd(Context paramContext) {
    if (this.zzdh == null) {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zzdh = Boolean.valueOf(bool);
    } 
    if (!this.zzdh.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest"); 
    return this.zzdh.booleanValue();
  }
  
  final boolean zze(Context paramContext) {
    if (this.zzdi == null) {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zzdi = Boolean.valueOf(bool);
    } 
    if (!this.zzdh.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest"); 
    return this.zzdi.booleanValue();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzaw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */