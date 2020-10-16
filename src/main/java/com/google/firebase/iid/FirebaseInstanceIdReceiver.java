package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.PlatformVersion;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
  private static zzi zzbl;
  
  public static int zza(BroadcastReceiver paramBroadcastReceiver, Context paramContext, Intent paramIntent) {
    boolean bool = PlatformVersion.isAtLeastO();
    boolean bool1 = true;
    if (bool && (paramContext.getApplicationInfo()).targetSdkVersion >= 26) {
      i = 1;
    } else {
      i = 0;
    } 
    if ((paramIntent.getFlags() & 0x10000000) == 0)
      bool1 = false; 
    if (i && !bool1)
      return zzb(paramBroadcastReceiver, paramContext, paramIntent); 
    int i = zzaw.zzak().zzc(paramContext, paramIntent);
    if (PlatformVersion.isAtLeastO() && i == 402) {
      zzb(paramBroadcastReceiver, paramContext, paramIntent);
      return 403;
    } 
    return i;
  }
  
  private static zzi zza(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/google/firebase/iid/FirebaseInstanceIdReceiver
    //   2: monitorenter
    //   3: getstatic com/google/firebase/iid/FirebaseInstanceIdReceiver.zzbl : Lcom/google/firebase/iid/zzi;
    //   6: ifnonnull -> 23
    //   9: new com/google/firebase/iid/zzi
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   19: aload_2
    //   20: putstatic com/google/firebase/iid/FirebaseInstanceIdReceiver.zzbl : Lcom/google/firebase/iid/zzi;
    //   23: getstatic com/google/firebase/iid/FirebaseInstanceIdReceiver.zzbl : Lcom/google/firebase/iid/zzi;
    //   26: astore_0
    //   27: ldc com/google/firebase/iid/FirebaseInstanceIdReceiver
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/google/firebase/iid/FirebaseInstanceIdReceiver
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	32	finally
    //   23	27	32	finally
  }
  
  private final void zza(Context paramContext, Intent paramIntent) {
    String str1;
    String str2;
    int i;
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18)
      paramIntent.removeCategory(paramContext.getPackageName()); 
    if ("google.com/iid".equals(paramIntent.getStringExtra("from"))) {
      str1 = paramIntent.getStringExtra("CMD");
      if (str1 != null) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
          str2 = String.valueOf(paramIntent.getExtras());
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 21 + String.valueOf(str2).length());
          stringBuilder.append("Received command: ");
          stringBuilder.append(str1);
          stringBuilder.append(" - ");
          stringBuilder.append(str2);
          Log.d("FirebaseInstanceId", stringBuilder.toString());
        } 
        if ("RST".equals(str1) || "RST_FULL".equals(str1)) {
          FirebaseInstanceId.getInstance().zzn();
        } else if ("SYNC".equals(str1)) {
          FirebaseInstanceId.getInstance().zzp();
        } 
      } 
      i = -1;
    } else {
      String str = str2.getStringExtra("gcm.rawData64");
      if (str != null) {
        str2.putExtra("rawData", Base64.decode(str, 0));
        str2.removeExtra("gcm.rawData64");
      } 
      i = zza((BroadcastReceiver)this, (Context)str1, (Intent)str2);
    } 
    if (isOrderedBroadcast())
      setResultCode(i); 
  }
  
  private static int zzb(BroadcastReceiver paramBroadcastReceiver, Context paramContext, Intent paramIntent) {
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Binding to service"); 
    if (paramBroadcastReceiver.isOrderedBroadcast())
      paramBroadcastReceiver.setResultCode(-1); 
    zza(paramContext, "com.google.firebase.MESSAGING_EVENT").zza(paramIntent, paramBroadcastReceiver.goAsync());
    return -1;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return; 
    Parcelable parcelable = paramIntent.getParcelableExtra("wrapped_intent");
    if (parcelable instanceof Intent) {
      Intent intent = (Intent)parcelable;
    } else {
      parcelable = null;
    } 
    if (parcelable != null) {
      zza(paramContext, (Intent)parcelable);
      return;
    } 
    zza(paramContext, paramIntent);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\FirebaseInstanceIdReceiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */