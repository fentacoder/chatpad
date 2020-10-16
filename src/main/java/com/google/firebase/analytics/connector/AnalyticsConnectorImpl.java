package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
  private static volatile AnalyticsConnector zzb;
  
  final Map<String, zza> zza;
  
  private final AppMeasurement zzc;
  
  private AnalyticsConnectorImpl(AppMeasurement paramAppMeasurement) {
    Preconditions.checkNotNull(paramAppMeasurement);
    this.zzc = paramAppMeasurement;
    this.zza = new ConcurrentHashMap<>();
  }
  
  public static AnalyticsConnector getInstance() {
    return getInstance(FirebaseApp.getInstance());
  }
  
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp) {
    return (AnalyticsConnector)paramFirebaseApp.get(AnalyticsConnector.class);
  }
  
  public static AnalyticsConnector getInstance(FirebaseApp paramFirebaseApp, Context paramContext, Subscriber paramSubscriber) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_1
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: pop
    //   23: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzb : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   26: ifnonnull -> 107
    //   29: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   31: monitorenter
    //   32: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzb : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   35: ifnonnull -> 95
    //   38: new android/os/Bundle
    //   41: astore_3
    //   42: aload_3
    //   43: iconst_1
    //   44: invokespecial <init> : (I)V
    //   47: aload_0
    //   48: invokevirtual isDefaultApp : ()Z
    //   51: ifeq -> 78
    //   54: aload_2
    //   55: ldc com/google/firebase/DataCollectionDefaultChange
    //   57: getstatic com/google/firebase/analytics/connector/zzb.zza : Ljava/util/concurrent/Executor;
    //   60: getstatic com/google/firebase/analytics/connector/zza.zza : Lcom/google/firebase/events/EventHandler;
    //   63: invokeinterface subscribe : (Ljava/lang/Class;Ljava/util/concurrent/Executor;Lcom/google/firebase/events/EventHandler;)V
    //   68: aload_3
    //   69: ldc 'dataCollectionDefaultEnabled'
    //   71: aload_0
    //   72: invokevirtual isDataCollectionDefaultEnabled : ()Z
    //   75: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   78: new com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: invokestatic zza : (Landroid/content/Context;Landroid/os/Bundle;)Lcom/google/android/gms/measurement/AppMeasurement;
    //   88: invokespecial <init> : (Lcom/google/android/gms/measurement/AppMeasurement;)V
    //   91: aload_0
    //   92: putstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzb : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   95: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   97: monitorexit
    //   98: goto -> 107
    //   101: astore_0
    //   102: ldc com/google/firebase/analytics/connector/AnalyticsConnectorImpl
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    //   107: getstatic com/google/firebase/analytics/connector/AnalyticsConnectorImpl.zzb : Lcom/google/firebase/analytics/connector/AnalyticsConnector;
    //   110: areturn
    // Exception table:
    //   from	to	target	type
    //   32	78	101	finally
    //   78	95	101	finally
    //   95	98	101	finally
    //   102	105	101	finally
  }
  
  private final boolean zza(String paramString) {
    return (!paramString.isEmpty() && this.zza.containsKey(paramString) && this.zza.get(paramString) != null);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) {
    if (paramString2 != null && !zzd.zza(paramString2, paramBundle))
      return; 
    this.zzc.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2) {
    ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList();
    Iterator<AppMeasurement.ConditionalUserProperty> iterator = this.zzc.getConditionalUserProperties(paramString1, paramString2).iterator();
    while (iterator.hasNext())
      arrayList.add(zzd.zza(iterator.next())); 
    return arrayList;
  }
  
  public int getMaxUserProperties(String paramString) {
    return this.zzc.getMaxUserProperties(paramString);
  }
  
  public Map<String, Object> getUserProperties(boolean paramBoolean) {
    return this.zzc.getUserProperties(paramBoolean);
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    if (!zzd.zza(paramString1))
      return; 
    if (!zzd.zza(paramString2, bundle))
      return; 
    if (!zzd.zza(paramString1, paramString2, bundle))
      return; 
    this.zzc.logEventInternal(paramString1, paramString2, bundle);
  }
  
  public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String paramString, AnalyticsConnector.AnalyticsConnectorListener paramAnalyticsConnectorListener) {
    zzc zzc;
    Preconditions.checkNotNull(paramAnalyticsConnectorListener);
    if (!zzd.zza(paramString))
      return null; 
    if (zza(paramString))
      return null; 
    AppMeasurement appMeasurement = this.zzc;
    if ("fiam".equals(paramString)) {
      zzc = new zzc(appMeasurement, paramAnalyticsConnectorListener);
    } else if ("crash".equals(paramString)) {
      zze zze = new zze(appMeasurement, (AnalyticsConnector.AnalyticsConnectorListener)zzc);
    } else {
      zzc = null;
    } 
    if (zzc != null) {
      this.zza.put(paramString, zzc);
      return new AnalyticsConnector.AnalyticsConnectorHandle(this, paramString) {
          public void registerEventNames(Set<String> param1Set) {
            if (AnalyticsConnectorImpl.zza(this.zzb, this.zza) && this.zza.equals("fiam") && param1Set != null && !param1Set.isEmpty())
              ((zza)this.zzb.zza.get(this.zza)).zza(param1Set); 
          }
          
          public void unregister() {
            if (!AnalyticsConnectorImpl.zza(this.zzb, this.zza))
              return; 
            AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener = ((zza)this.zzb.zza.get(this.zza)).zza();
            if (analyticsConnectorListener != null)
              analyticsConnectorListener.onMessageTriggered(0, null); 
            this.zzb.zza.remove(this.zza);
          }
          
          public void unregisterEventNames() {
            if (AnalyticsConnectorImpl.zza(this.zzb, this.zza) && this.zza.equals("fiam"))
              ((zza)this.zzb.zza.get(this.zza)).zzb(); 
          }
        };
    } 
    return null;
  }
  
  public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    if (!zzd.zza(paramConditionalUserProperty))
      return; 
    this.zzc.setConditionalUserProperty(zzd.zzb(paramConditionalUserProperty));
  }
  
  public void setUserProperty(String paramString1, String paramString2, Object paramObject) {
    if (!zzd.zza(paramString1))
      return; 
    if (!zzd.zza(paramString1, paramString2))
      return; 
    this.zzc.setUserPropertyInternal(paramString1, paramString2, paramObject);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnectorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */