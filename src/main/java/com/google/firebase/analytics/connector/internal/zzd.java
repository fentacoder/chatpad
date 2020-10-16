package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzig;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzd {
  private static final Set<String> zza = new HashSet<>(Arrays.asList(new String[] { 
          "_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", 
          "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire" }));
  
  private static final List<String> zzb = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open" });
  
  private static final List<String> zzc = Arrays.asList(new String[] { "auto", "app", "am" });
  
  private static final List<String> zzd = Arrays.asList(new String[] { "_r", "_dbg" });
  
  private static final List<String> zze = Arrays.asList((String[])ArrayUtils.concat((Object[][])new String[][] { AppMeasurement.UserProperty.zza, AppMeasurement.UserProperty.zzb }));
  
  private static final List<String> zzf = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
  
  public static AnalyticsConnector.ConditionalUserProperty zza(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty) {
    AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
    conditionalUserProperty.origin = paramConditionalUserProperty.mOrigin;
    conditionalUserProperty.active = paramConditionalUserProperty.mActive;
    conditionalUserProperty.creationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
    conditionalUserProperty.expiredEventName = paramConditionalUserProperty.mExpiredEventName;
    if (paramConditionalUserProperty.mExpiredEventParams != null)
      conditionalUserProperty.expiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams); 
    conditionalUserProperty.name = paramConditionalUserProperty.mName;
    conditionalUserProperty.timedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
    if (paramConditionalUserProperty.mTimedOutEventParams != null)
      conditionalUserProperty.timedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams); 
    conditionalUserProperty.timeToLive = paramConditionalUserProperty.mTimeToLive;
    conditionalUserProperty.triggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
    if (paramConditionalUserProperty.mTriggeredEventParams != null)
      conditionalUserProperty.triggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams); 
    conditionalUserProperty.triggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
    conditionalUserProperty.triggerEventName = paramConditionalUserProperty.mTriggerEventName;
    conditionalUserProperty.triggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
    if (paramConditionalUserProperty.mValue != null)
      conditionalUserProperty.value = zzig.zza(paramConditionalUserProperty.mValue); 
    return conditionalUserProperty;
  }
  
  public static boolean zza(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    if (paramConditionalUserProperty == null)
      return false; 
    String str = paramConditionalUserProperty.origin;
    if (str == null || str.isEmpty())
      return false; 
    if (paramConditionalUserProperty.value != null && zzig.zza(paramConditionalUserProperty.value) == null)
      return false; 
    if (!zza(str))
      return false; 
    if (!zza(str, paramConditionalUserProperty.name))
      return false; 
    if (paramConditionalUserProperty.expiredEventName != null) {
      if (!zza(paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams))
        return false; 
      if (!zza(str, paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams))
        return false; 
    } 
    if (paramConditionalUserProperty.triggeredEventName != null) {
      if (!zza(paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams))
        return false; 
      if (!zza(str, paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams))
        return false; 
    } 
    if (paramConditionalUserProperty.timedOutEventName != null) {
      if (!zza(paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams))
        return false; 
      if (!zza(str, paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams))
        return false; 
    } 
    return true;
  }
  
  public static boolean zza(String paramString) {
    return !zzc.contains(paramString);
  }
  
  public static boolean zza(String paramString, Bundle paramBundle) {
    if (zzb.contains(paramString))
      return false; 
    if (paramBundle != null) {
      Iterator<String> iterator = zzd.iterator();
      while (iterator.hasNext()) {
        if (paramBundle.containsKey(iterator.next()))
          return false; 
      } 
    } 
    return true;
  }
  
  public static boolean zza(String paramString1, String paramString2) {
    if ("_ce1".equals(paramString2) || "_ce2".equals(paramString2))
      return (paramString1.equals("fcm") || paramString1.equals("frc")); 
    if ("_ln".equals(paramString2))
      return (paramString1.equals("fcm") || paramString1.equals("fiam")); 
    if (zze.contains(paramString2))
      return false; 
    Iterator<String> iterator = zzf.iterator();
    while (iterator.hasNext()) {
      if (paramString2.matches(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public static boolean zza(String paramString1, String paramString2, Bundle paramBundle) {
    if (!"_cmp".equals(paramString2))
      return true; 
    if (!zza(paramString1))
      return false; 
    if (paramBundle == null)
      return false; 
    Iterator<String> iterator = zzd.iterator();
    while (iterator.hasNext()) {
      if (paramBundle.containsKey(iterator.next()))
        return false; 
    } 
    byte b = -1;
    int i = paramString1.hashCode();
    if (i != 101200) {
      if (i != 101230) {
        if (i == 3142703 && paramString1.equals("fiam"))
          b = 2; 
      } else if (paramString1.equals("fdl")) {
        b = 1;
      } 
    } else if (paramString1.equals("fcm")) {
      b = 0;
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2)
          return false; 
        paramBundle.putString("_cis", "fiam_integration");
        return true;
      } 
      paramBundle.putString("_cis", "fdl_integration");
      return true;
    } 
    paramBundle.putString("_cis", "fcm_integration");
    return true;
  }
  
  public static AppMeasurement.ConditionalUserProperty zzb(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty) {
    AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
    conditionalUserProperty.mOrigin = paramConditionalUserProperty.origin;
    conditionalUserProperty.mActive = paramConditionalUserProperty.active;
    conditionalUserProperty.mCreationTimestamp = paramConditionalUserProperty.creationTimestamp;
    conditionalUserProperty.mExpiredEventName = paramConditionalUserProperty.expiredEventName;
    if (paramConditionalUserProperty.expiredEventParams != null)
      conditionalUserProperty.mExpiredEventParams = new Bundle(paramConditionalUserProperty.expiredEventParams); 
    conditionalUserProperty.mName = paramConditionalUserProperty.name;
    conditionalUserProperty.mTimedOutEventName = paramConditionalUserProperty.timedOutEventName;
    if (paramConditionalUserProperty.timedOutEventParams != null)
      conditionalUserProperty.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.timedOutEventParams); 
    conditionalUserProperty.mTimeToLive = paramConditionalUserProperty.timeToLive;
    conditionalUserProperty.mTriggeredEventName = paramConditionalUserProperty.triggeredEventName;
    if (paramConditionalUserProperty.triggeredEventParams != null)
      conditionalUserProperty.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.triggeredEventParams); 
    conditionalUserProperty.mTriggeredTimestamp = paramConditionalUserProperty.triggeredTimestamp;
    conditionalUserProperty.mTriggerEventName = paramConditionalUserProperty.triggerEventName;
    conditionalUserProperty.mTriggerTimeout = paramConditionalUserProperty.triggerTimeout;
    if (paramConditionalUserProperty.value != null)
      conditionalUserProperty.mValue = zzig.zza(paramConditionalUserProperty.value); 
    return conditionalUserProperty;
  }
  
  public static boolean zzb(String paramString) {
    return !zza.contains(paramString);
  }
  
  public static boolean zzc(String paramString) {
    if (paramString == null)
      return false; 
    if (paramString.length() == 0)
      return false; 
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i))
      return false; 
    int j = paramString.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k))
        return false; 
    } 
    return true;
  }
  
  public static boolean zzd(String paramString) {
    if (paramString == null)
      return false; 
    if (paramString.length() == 0)
      return false; 
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i) && i != 95)
      return false; 
    int j = paramString.length();
    for (i = Character.charCount(i); i < j; i += Character.charCount(k)) {
      int k = paramString.codePointAt(i);
      if (k != 95 && !Character.isLetterOrDigit(k))
        return false; 
    } 
    return true;
  }
  
  public static String zze(String paramString) {
    String str = AppMeasurement.Event.zza(paramString);
    return (str != null) ? str : paramString;
  }
  
  public static String zzf(String paramString) {
    String str = AppMeasurement.Event.zzb(paramString);
    return (str != null) ? str : paramString;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\internal\zzd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */