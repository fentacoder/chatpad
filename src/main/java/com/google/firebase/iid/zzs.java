package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.Executor;

final class zzs implements MessagingChannel {
  private final Executor executor;
  
  private final FirebaseApp zzau;
  
  private final zzan zzav;
  
  private final zzau zzbq;
  
  private final UserAgentPublisher zzbr;
  
  private zzs(FirebaseApp paramFirebaseApp, zzan paramzzan, Executor paramExecutor, zzau paramzzau, UserAgentPublisher paramUserAgentPublisher) {
    this.zzau = paramFirebaseApp;
    this.zzav = paramzzan;
    this.zzbq = paramzzau;
    this.executor = paramExecutor;
    this.zzbr = paramUserAgentPublisher;
  }
  
  zzs(FirebaseApp paramFirebaseApp, zzan paramzzan, Executor paramExecutor, UserAgentPublisher paramUserAgentPublisher) {
    this(paramFirebaseApp, paramzzan, paramExecutor, new zzau(paramFirebaseApp.getApplicationContext(), paramzzan), paramUserAgentPublisher);
  }
  
  private final Task<Bundle> zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    paramBundle.putString("scope", paramString3);
    paramBundle.putString("sender", paramString2);
    paramBundle.putString("subtype", paramString2);
    paramBundle.putString("appid", paramString1);
    paramBundle.putString("gmp_app_id", this.zzau.getOptions().getApplicationId());
    paramBundle.putString("gmsv", Integer.toString(this.zzav.zzaf()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.zzav.zzad());
    paramBundle.putString("app_ver_name", this.zzav.zzae());
    paramBundle.putString("cliv", "fiid-12451000");
    paramBundle.putString("Firebase-Client", this.zzbr.getUserAgent());
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.executor.execute(new zzr(this, paramBundle, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  private static String zza(Bundle paramBundle) throws IOException {
    if (paramBundle != null) {
      String str = paramBundle.getString("registration_id");
      if (str != null)
        return str; 
      str = paramBundle.getString("unregistered");
      if (str != null)
        return str; 
      str = paramBundle.getString("error");
      if (!"RST".equals(str)) {
        if (str != null)
          throw new IOException(str); 
        String str1 = String.valueOf(paramBundle);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 21);
        stringBuilder.append("Unexpected response: ");
        stringBuilder.append(str1);
        Log.w("FirebaseInstanceId", stringBuilder.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
      } 
      throw new IOException("INSTANCE_ID_RESET");
    } 
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  private final <T> Task<Void> zzb(Task<T> paramTask) {
    return paramTask.continueWith(zzh.zzd(), new zzu(this));
  }
  
  private final Task<String> zzc(Task<Bundle> paramTask) {
    return paramTask.continueWith(this.executor, new zzt(this));
  }
  
  public final Task<Void> ackMessage(String paramString) {
    return null;
  }
  
  public final Task<Void> buildChannel(String paramString1, String paramString2) {
    return Tasks.forResult(null);
  }
  
  public final Task<Void> deleteInstanceId(String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("iid-operation", "delete");
    bundle.putString("delete", "1");
    return zzb(zzc(zza(paramString, "*", "*", bundle)));
  }
  
  public final Task<Void> deleteToken(String paramString1, String paramString2, String paramString3, String paramString4) {
    Bundle bundle = new Bundle();
    bundle.putString("delete", "1");
    return zzb(zzc(zza(paramString1, paramString3, paramString4, bundle)));
  }
  
  public final Task<String> getToken(String paramString1, String paramString2, String paramString3, String paramString4) {
    return zzc(zza(paramString1, paramString3, paramString4, new Bundle()));
  }
  
  public final boolean isAvailable() {
    return (this.zzav.zzac() != 0);
  }
  
  public final boolean isChannelBuilt() {
    return true;
  }
  
  public final boolean needsRefresh() {
    return false;
  }
  
  public final Task<Void> subscribeToTopic(String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    } 
    bundle.putString("gcm.topic", str);
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    } 
    return zzb(zzc(zza(paramString1, paramString2, paramString3, bundle)));
  }
  
  public final Task<Void> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    String str = String.valueOf(paramString3);
    if (str.length() != 0) {
      str = "/topics/".concat(str);
    } else {
      str = new String("/topics/");
    } 
    bundle.putString("gcm.topic", str);
    bundle.putString("delete", "1");
    paramString3 = String.valueOf(paramString3);
    if (paramString3.length() != 0) {
      paramString3 = "/topics/".concat(paramString3);
    } else {
      paramString3 = new String("/topics/");
    } 
    return zzb(zzc(zza(paramString1, paramString2, paramString3, bundle)));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */