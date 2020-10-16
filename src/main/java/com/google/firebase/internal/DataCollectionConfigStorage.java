package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataCollectionConfigStorage {
  public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
  
  private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
  
  private final Context applicationContext;
  
  private final AtomicBoolean dataCollectionDefaultEnabled;
  
  private final Publisher publisher;
  
  private final SharedPreferences sharedPreferences;
  
  public DataCollectionConfigStorage(Context paramContext, String paramString, Publisher paramPublisher) {
    this.applicationContext = directBootSafe(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.google.firebase.common.prefs:");
    stringBuilder.append(paramString);
    this.sharedPreferences = paramContext.getSharedPreferences(stringBuilder.toString(), 0);
    this.publisher = paramPublisher;
    this.dataCollectionDefaultEnabled = new AtomicBoolean(readAutoDataCollectionEnabled());
  }
  
  private static Context directBootSafe(Context paramContext) {
    Context context = paramContext;
    if (Build.VERSION.SDK_INT >= 24)
      if (ContextCompat.isDeviceProtectedStorage(paramContext)) {
        context = paramContext;
      } else {
        context = ContextCompat.createDeviceProtectedStorageContext(paramContext);
      }  
    return context;
  }
  
  private boolean readAutoDataCollectionEnabled() {
    if (this.sharedPreferences.contains("firebase_data_collection_default_enabled"))
      return this.sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true); 
    try {
      PackageManager packageManager = this.applicationContext.getPackageManager();
      if (packageManager != null) {
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.applicationContext.getPackageName(), 128);
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))
          return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled"); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return true;
  }
  
  public boolean isEnabled() {
    return this.dataCollectionDefaultEnabled.get();
  }
  
  public void setEnabled(boolean paramBoolean) {
    if (this.dataCollectionDefaultEnabled.compareAndSet(paramBoolean ^ true, paramBoolean)) {
      this.sharedPreferences.edit().putBoolean("firebase_data_collection_default_enabled", paramBoolean).apply();
      this.publisher.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(paramBoolean)));
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\internal\DataCollectionConfigStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */