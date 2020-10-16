package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzga;
import com.google.android.gms.measurement.internal.zzia;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.ExecutorService;

public final class FirebaseAnalytics {
  private static volatile FirebaseAnalytics zza;
  
  private final zzga zzb;
  
  private final zzx zzc;
  
  private final boolean zzd;
  
  private String zze;
  
  private long zzf;
  
  private final Object zzg;
  
  private ExecutorService zzh;
  
  private FirebaseAnalytics(zzx paramzzx) {
    Preconditions.checkNotNull(paramzzx);
    this.zzb = null;
    this.zzc = paramzzx;
    this.zzd = true;
    this.zzg = new Object();
  }
  
  private FirebaseAnalytics(zzga paramzzga) {
    Preconditions.checkNotNull(paramzzga);
    this.zzb = paramzzga;
    this.zzc = null;
    this.zzd = false;
    this.zzg = new Object();
  }
  
  public static FirebaseAnalytics getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/firebase/analytics/FirebaseAnalytics.zza : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   3: ifnonnull -> 74
    //   6: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   8: monitorenter
    //   9: getstatic com/google/firebase/analytics/FirebaseAnalytics.zza : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   12: ifnonnull -> 62
    //   15: aload_0
    //   16: invokestatic zzb : (Landroid/content/Context;)Z
    //   19: ifeq -> 43
    //   22: aload_0
    //   23: invokestatic zza : (Landroid/content/Context;)Lcom/google/android/gms/internal/measurement/zzx;
    //   26: astore_0
    //   27: new com/google/firebase/analytics/FirebaseAnalytics
    //   30: astore_1
    //   31: aload_1
    //   32: aload_0
    //   33: invokespecial <init> : (Lcom/google/android/gms/internal/measurement/zzx;)V
    //   36: aload_1
    //   37: putstatic com/google/firebase/analytics/FirebaseAnalytics.zza : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   40: goto -> 62
    //   43: aload_0
    //   44: aconst_null
    //   45: invokestatic zza : (Landroid/content/Context;Lcom/google/android/gms/internal/measurement/zzv;)Lcom/google/android/gms/measurement/internal/zzga;
    //   48: astore_0
    //   49: new com/google/firebase/analytics/FirebaseAnalytics
    //   52: astore_1
    //   53: aload_1
    //   54: aload_0
    //   55: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzga;)V
    //   58: aload_1
    //   59: putstatic com/google/firebase/analytics/FirebaseAnalytics.zza : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   62: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   64: monitorexit
    //   65: goto -> 74
    //   68: astore_0
    //   69: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: getstatic com/google/firebase/analytics/FirebaseAnalytics.zza : Lcom/google/firebase/analytics/FirebaseAnalytics;
    //   77: areturn
    // Exception table:
    //   from	to	target	type
    //   9	40	68	finally
    //   43	62	68	finally
    //   62	65	68	finally
    //   69	72	68	finally
  }
  
  public static zzia getScionFrontendApiImplementation(Context paramContext, Bundle paramBundle) {
    if (!zzx.zzb(paramContext))
      return null; 
    zzx zzx1 = zzx.zza(paramContext, null, null, null, paramBundle);
    return (zzx1 == null) ? null : new zza(zzx1);
  }
  
  private final ExecutorService zza() {
    // Byte code:
    //   0: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield zzh : Ljava/util/concurrent/ExecutorService;
    //   7: ifnonnull -> 44
    //   10: new java/util/concurrent/ThreadPoolExecutor
    //   13: astore_1
    //   14: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   17: astore_2
    //   18: new java/util/concurrent/ArrayBlockingQueue
    //   21: astore_3
    //   22: aload_3
    //   23: bipush #100
    //   25: invokespecial <init> : (I)V
    //   28: aload_1
    //   29: iconst_0
    //   30: iconst_1
    //   31: ldc2_w 30
    //   34: aload_2
    //   35: aload_3
    //   36: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V
    //   39: aload_0
    //   40: aload_1
    //   41: putfield zzh : Ljava/util/concurrent/ExecutorService;
    //   44: aload_0
    //   45: getfield zzh : Ljava/util/concurrent/ExecutorService;
    //   48: astore_2
    //   49: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   51: monitorexit
    //   52: aload_2
    //   53: areturn
    //   54: astore_2
    //   55: ldc com/google/firebase/analytics/FirebaseAnalytics
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   3	44	54	finally
    //   44	52	54	finally
    //   55	58	54	finally
  }
  
  private final void zza(String paramString) {
    synchronized (this.zzg) {
      this.zze = paramString;
      if (this.zzd) {
        this.zzf = DefaultClock.getInstance().elapsedRealtime();
      } else {
        this.zzf = this.zzb.zzm().elapsedRealtime();
      } 
      return;
    } 
  }
  
  private final String zzb() {
    synchronized (this.zzg) {
      long l;
      if (this.zzd) {
        l = DefaultClock.getInstance().elapsedRealtime();
      } else {
        l = this.zzb.zzm().elapsedRealtime();
      } 
      if (Math.abs(l - this.zzf) < 1000L)
        return this.zze; 
      return null;
    } 
  }
  
  public final Task<String> getAppInstanceId() {
    try {
      String str = zzb();
      if (str != null)
        return Tasks.forResult(str); 
      ExecutorService executorService = zza();
      zzb zzb = new zzb();
      this(this);
      return Tasks.call(executorService, zzb);
    } catch (Exception exception) {
      if (this.zzd) {
        this.zzc.zza(5, "Failed to schedule task for getAppInstanceId", null, null, null);
      } else {
        this.zzb.zzr().zzi().zza("Failed to schedule task for getAppInstanceId");
      } 
      return Tasks.forException(exception);
    } 
  }
  
  public final String getFirebaseInstanceId() {
    return FirebaseInstanceId.getInstance().getId();
  }
  
  public final void logEvent(String paramString, Bundle paramBundle) {
    if (this.zzd) {
      this.zzc.zza(paramString, paramBundle);
      return;
    } 
    this.zzb.zzh().zza("app", paramString, paramBundle, true);
  }
  
  public final void resetAnalyticsData() {
    zza((String)null);
    if (this.zzd) {
      this.zzc.zzb();
      return;
    } 
    this.zzb.zzh().zzd(this.zzb.zzm().currentTimeMillis());
  }
  
  public final void setAnalyticsCollectionEnabled(boolean paramBoolean) {
    if (this.zzd) {
      this.zzc.zza(paramBoolean);
      return;
    } 
    this.zzb.zzh().zza(paramBoolean);
  }
  
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2) {
    if (this.zzd) {
      this.zzc.zza(paramActivity, paramString1, paramString2);
      return;
    } 
    if (!zzw.zza()) {
      this.zzb.zzr().zzi().zza("setCurrentScreen must be called from the main thread");
      return;
    } 
    this.zzb.zzv().zza(paramActivity, paramString1, paramString2);
  }
  
  @Deprecated
  public final void setMinimumSessionDuration(long paramLong) {
    if (this.zzd) {
      this.zzc.zza(paramLong);
      return;
    } 
    this.zzb.zzh().zza(paramLong);
  }
  
  public final void setSessionTimeoutDuration(long paramLong) {
    if (this.zzd) {
      this.zzc.zzb(paramLong);
      return;
    } 
    this.zzb.zzh().zzb(paramLong);
  }
  
  public final void setUserId(String paramString) {
    if (this.zzd) {
      this.zzc.zza(paramString);
      return;
    } 
    this.zzb.zzh().zza("app", "_id", paramString, true);
  }
  
  public final void setUserProperty(String paramString1, String paramString2) {
    if (this.zzd) {
      this.zzc.zza(paramString1, paramString2);
      return;
    } 
    this.zzb.zzh().zza("app", paramString1, paramString2, false);
  }
  
  public static class Event {
    public static final String ADD_PAYMENT_INFO = "add_payment_info";
    
    public static final String ADD_TO_CART = "add_to_cart";
    
    public static final String ADD_TO_WISHLIST = "add_to_wishlist";
    
    public static final String APP_OPEN = "app_open";
    
    public static final String BEGIN_CHECKOUT = "begin_checkout";
    
    public static final String CAMPAIGN_DETAILS = "campaign_details";
    
    public static final String CHECKOUT_PROGRESS = "checkout_progress";
    
    public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
    
    public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
    
    public static final String GENERATE_LEAD = "generate_lead";
    
    public static final String JOIN_GROUP = "join_group";
    
    public static final String LEVEL_END = "level_end";
    
    public static final String LEVEL_START = "level_start";
    
    public static final String LEVEL_UP = "level_up";
    
    public static final String LOGIN = "login";
    
    public static final String POST_SCORE = "post_score";
    
    public static final String PRESENT_OFFER = "present_offer";
    
    public static final String PURCHASE_REFUND = "purchase_refund";
    
    public static final String REMOVE_FROM_CART = "remove_from_cart";
    
    public static final String SEARCH = "search";
    
    public static final String SELECT_CONTENT = "select_content";
    
    public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
    
    public static final String SHARE = "share";
    
    public static final String SIGN_UP = "sign_up";
    
    public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
    
    public static final String TUTORIAL_BEGIN = "tutorial_begin";
    
    public static final String TUTORIAL_COMPLETE = "tutorial_complete";
    
    public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
    
    public static final String VIEW_ITEM = "view_item";
    
    public static final String VIEW_ITEM_LIST = "view_item_list";
    
    public static final String VIEW_SEARCH_RESULTS = "view_search_results";
  }
  
  public static class Param {
    public static final String ACHIEVEMENT_ID = "achievement_id";
    
    public static final String ACLID = "aclid";
    
    public static final String AFFILIATION = "affiliation";
    
    public static final String CAMPAIGN = "campaign";
    
    public static final String CHARACTER = "character";
    
    public static final String CHECKOUT_OPTION = "checkout_option";
    
    public static final String CHECKOUT_STEP = "checkout_step";
    
    public static final String CONTENT = "content";
    
    public static final String CONTENT_TYPE = "content_type";
    
    public static final String COUPON = "coupon";
    
    public static final String CP1 = "cp1";
    
    public static final String CREATIVE_NAME = "creative_name";
    
    public static final String CREATIVE_SLOT = "creative_slot";
    
    public static final String CURRENCY = "currency";
    
    public static final String DESTINATION = "destination";
    
    public static final String END_DATE = "end_date";
    
    public static final String EXTEND_SESSION = "extend_session";
    
    public static final String FLIGHT_NUMBER = "flight_number";
    
    public static final String GROUP_ID = "group_id";
    
    public static final String INDEX = "index";
    
    public static final String ITEM_BRAND = "item_brand";
    
    public static final String ITEM_CATEGORY = "item_category";
    
    public static final String ITEM_ID = "item_id";
    
    public static final String ITEM_LIST = "item_list";
    
    public static final String ITEM_LOCATION_ID = "item_location_id";
    
    public static final String ITEM_NAME = "item_name";
    
    public static final String ITEM_VARIANT = "item_variant";
    
    public static final String LEVEL = "level";
    
    public static final String LEVEL_NAME = "level_name";
    
    public static final String LOCATION = "location";
    
    public static final String MEDIUM = "medium";
    
    public static final String METHOD = "method";
    
    public static final String NUMBER_OF_NIGHTS = "number_of_nights";
    
    public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
    
    public static final String NUMBER_OF_ROOMS = "number_of_rooms";
    
    public static final String ORIGIN = "origin";
    
    public static final String PRICE = "price";
    
    public static final String QUANTITY = "quantity";
    
    public static final String SCORE = "score";
    
    public static final String SEARCH_TERM = "search_term";
    
    public static final String SHIPPING = "shipping";
    
    @Deprecated
    public static final String SIGN_UP_METHOD = "sign_up_method";
    
    public static final String SOURCE = "source";
    
    public static final String START_DATE = "start_date";
    
    public static final String SUCCESS = "success";
    
    public static final String TAX = "tax";
    
    public static final String TERM = "term";
    
    public static final String TRANSACTION_ID = "transaction_id";
    
    public static final String TRAVEL_CLASS = "travel_class";
    
    public static final String VALUE = "value";
    
    public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";
  }
  
  public static class UserProperty {
    public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
    
    public static final String SIGN_UP_METHOD = "sign_up_method";
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\FirebaseAnalytics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */