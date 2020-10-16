package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
  public static final String DEFAULT_APP_NAME = "[DEFAULT]";
  
  private static final String FIREBASE_ANDROID = "fire-android";
  
  private static final String FIREBASE_COMMON = "fire-core";
  
  static final Map<String, FirebaseApp> INSTANCES;
  
  private static final String KOTLIN = "kotlin";
  
  private static final Object LOCK = new Object();
  
  private static final String LOG_TAG = "FirebaseApp";
  
  private static final Executor UI_EXECUTOR = new UiExecutor();
  
  private final Context applicationContext;
  
  private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
  
  private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList<>();
  
  private final ComponentRuntime componentRuntime;
  
  private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
  
  private final AtomicBoolean deleted = new AtomicBoolean();
  
  private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();
  
  private final String name;
  
  private final FirebaseOptions options;
  
  static {
    INSTANCES = (Map<String, FirebaseApp>)new ArrayMap();
  }
  
  protected FirebaseApp(Context paramContext, String paramString, FirebaseOptions paramFirebaseOptions) {
    this.applicationContext = (Context)Preconditions.checkNotNull(paramContext);
    this.name = Preconditions.checkNotEmpty(paramString);
    this.options = (FirebaseOptions)Preconditions.checkNotNull(paramFirebaseOptions);
    List list = ComponentDiscovery.forContext(paramContext, ComponentDiscoveryService.class).discover();
    paramString = KotlinDetector.detectVersion();
    Executor executor = UI_EXECUTOR;
    Component component2 = Component.of(paramContext, Context.class, new Class[0]);
    Component component3 = Component.of(this, FirebaseApp.class, new Class[0]);
    Component component1 = Component.of(paramFirebaseOptions, FirebaseOptions.class, new Class[0]);
    Component component4 = LibraryVersionComponent.create("fire-android", "");
    Component component5 = LibraryVersionComponent.create("fire-core", "19.3.0");
    if (paramString != null) {
      Component component = LibraryVersionComponent.create("kotlin", paramString);
    } else {
      paramString = null;
    } 
    this.componentRuntime = new ComponentRuntime(executor, list, new Component[] { component2, component3, component1, component4, component5, (Component)paramString, DefaultUserAgentPublisher.component(), DefaultHeartBeatInfo.component() });
    this.dataCollectionConfigStorage = new Lazy(FirebaseApp$$Lambda$1.lambdaFactory$(this, paramContext));
  }
  
  private void checkNotDeleted() {
    Preconditions.checkState(this.deleted.get() ^ true, "FirebaseApp was deleted");
  }
  
  public static void clearInstancesForTest() {
    synchronized (LOCK) {
      INSTANCES.clear();
      return;
    } 
  }
  
  private static List<String> getAllAppNames() {
    ArrayList<String> arrayList = new ArrayList();
    synchronized (LOCK) {
      Iterator<FirebaseApp> iterator = INSTANCES.values().iterator();
      while (iterator.hasNext())
        arrayList.add(((FirebaseApp)iterator.next()).getName()); 
      Collections.sort(arrayList);
      return arrayList;
    } 
  }
  
  public static List<FirebaseApp> getApps(Context paramContext) {
    synchronized (LOCK) {
      ArrayList<FirebaseApp> arrayList = new ArrayList();
      this((Collection)INSTANCES.values());
      return arrayList;
    } 
  }
  
  public static FirebaseApp getInstance() {
    synchronized (LOCK) {
      FirebaseApp firebaseApp = INSTANCES.get("[DEFAULT]");
      if (firebaseApp != null)
        return firebaseApp; 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Default FirebaseApp is not initialized in this process ");
      stringBuilder.append(ProcessUtils.getMyProcessName());
      stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
  
  public static FirebaseApp getInstance(String paramString) {
    synchronized (LOCK) {
      FirebaseApp firebaseApp = INSTANCES.get(normalize(paramString));
      if (firebaseApp != null)
        return firebaseApp; 
      List<String> list = getAllAppNames();
      if (list.isEmpty()) {
        str = "";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Available app names: ");
        stringBuilder.append(TextUtils.join(", ", (Iterable)str));
        str = stringBuilder.toString();
      } 
      String str = String.format("FirebaseApp with name %s doesn't exist. %s", new Object[] { paramString, str });
      IllegalStateException illegalStateException = new IllegalStateException();
      this(str);
      throw illegalStateException;
    } 
  }
  
  public static String getPersistenceKey(String paramString, FirebaseOptions paramFirebaseOptions) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramString.getBytes(Charset.defaultCharset())));
    stringBuilder.append("+");
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramFirebaseOptions.getApplicationId().getBytes(Charset.defaultCharset())));
    return stringBuilder.toString();
  }
  
  private void initializeAllApis() {
    if ((UserManagerCompat.isUserUnlocked(this.applicationContext) ^ true) != 0) {
      UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
    } else {
      this.componentRuntime.initializeEagerComponents(isDefaultApp());
    } 
  }
  
  public static FirebaseApp initializeApp(Context paramContext) {
    synchronized (LOCK) {
      if (INSTANCES.containsKey("[DEFAULT]")) {
        firebaseApp = getInstance();
        return firebaseApp;
      } 
      FirebaseOptions firebaseOptions = FirebaseOptions.fromResource((Context)firebaseApp);
      if (firebaseOptions == null) {
        Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
        return null;
      } 
      FirebaseApp firebaseApp = initializeApp((Context)firebaseApp, firebaseOptions);
      return firebaseApp;
    } 
  }
  
  public static FirebaseApp initializeApp(Context paramContext, FirebaseOptions paramFirebaseOptions) {
    return initializeApp(paramContext, paramFirebaseOptions, "[DEFAULT]");
  }
  
  public static FirebaseApp initializeApp(Context paramContext, FirebaseOptions paramFirebaseOptions, String paramString) {
    GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(paramContext);
    paramString = normalize(paramString);
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext(); 
    synchronized (LOCK) {
      boolean bool;
      if (!INSTANCES.containsKey(paramString)) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("FirebaseApp name ");
      stringBuilder.append(paramString);
      stringBuilder.append(" already exists!");
      Preconditions.checkState(bool, stringBuilder.toString());
      Preconditions.checkNotNull(paramContext, "Application context cannot be null.");
      FirebaseApp firebaseApp = new FirebaseApp();
      this(paramContext, paramString, paramFirebaseOptions);
      INSTANCES.put(paramString, firebaseApp);
      firebaseApp.initializeAllApis();
      return firebaseApp;
    } 
  }
  
  private static String normalize(String paramString) {
    return paramString.trim();
  }
  
  private void notifyBackgroundStateChangeListeners(boolean paramBoolean) {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator<BackgroundStateChangeListener> iterator = this.backgroundStateChangeListeners.iterator();
    while (iterator.hasNext())
      ((BackgroundStateChangeListener)iterator.next()).onBackgroundStateChanged(paramBoolean); 
  }
  
  private void notifyOnAppDeleted() {
    Iterator<FirebaseAppLifecycleListener> iterator = this.lifecycleListeners.iterator();
    while (iterator.hasNext())
      ((FirebaseAppLifecycleListener)iterator.next()).onDeleted(this.name, this.options); 
  }
  
  public void addBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.get() && BackgroundDetector.getInstance().isInBackground())
      paramBackgroundStateChangeListener.onBackgroundStateChanged(true); 
    this.backgroundStateChangeListeners.add(paramBackgroundStateChangeListener);
  }
  
  public void addLifecycleEventListener(FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.add(paramFirebaseAppLifecycleListener);
  }
  
  public void delete() {
    if (!this.deleted.compareAndSet(false, true))
      return; 
    synchronized (LOCK) {
      INSTANCES.remove(this.name);
      notifyOnAppDeleted();
      return;
    } 
  }
  
  public boolean equals(Object paramObject) {
    return !(paramObject instanceof FirebaseApp) ? false : this.name.equals(((FirebaseApp)paramObject).getName());
  }
  
  public <T> T get(Class<T> paramClass) {
    checkNotDeleted();
    return (T)this.componentRuntime.get(paramClass);
  }
  
  public Context getApplicationContext() {
    checkNotDeleted();
    return this.applicationContext;
  }
  
  public String getName() {
    checkNotDeleted();
    return this.name;
  }
  
  public FirebaseOptions getOptions() {
    checkNotDeleted();
    return this.options;
  }
  
  public String getPersistenceKey() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())));
    stringBuilder.append("+");
    stringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset())));
    return stringBuilder.toString();
  }
  
  public int hashCode() {
    return this.name.hashCode();
  }
  
  public boolean isDataCollectionDefaultEnabled() {
    checkNotDeleted();
    return ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).isEnabled();
  }
  
  public boolean isDefaultApp() {
    return "[DEFAULT]".equals(getName());
  }
  
  public void removeBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    checkNotDeleted();
    this.backgroundStateChangeListeners.remove(paramBackgroundStateChangeListener);
  }
  
  public void removeLifecycleEventListener(FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener) {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.remove(paramFirebaseAppLifecycleListener);
  }
  
  public void setAutomaticResourceManagementEnabled(boolean paramBoolean) {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.compareAndSet(paramBoolean ^ true, paramBoolean)) {
      boolean bool = BackgroundDetector.getInstance().isInBackground();
      if (paramBoolean && bool) {
        notifyBackgroundStateChangeListeners(true);
      } else if (!paramBoolean && bool) {
        notifyBackgroundStateChangeListeners(false);
      } 
    } 
  }
  
  public void setDataCollectionDefaultEnabled(boolean paramBoolean) {
    checkNotDeleted();
    ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).setEnabled(paramBoolean);
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
  }
  
  public static interface BackgroundStateChangeListener {
    void onBackgroundStateChanged(boolean param1Boolean);
  }
  
  private static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
    private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();
    
    private static void ensureBackgroundStateListenerRegistered(Context param1Context) {
      if (PlatformVersion.isAtLeastIceCreamSandwich() && param1Context.getApplicationContext() instanceof Application) {
        Application application = (Application)param1Context.getApplicationContext();
        if (INSTANCE.get() == null) {
          GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
          if (INSTANCE.compareAndSet(null, globalBackgroundStateListener)) {
            BackgroundDetector.initialize(application);
            BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
          } 
        } 
      } 
    }
    
    public void onBackgroundStateChanged(boolean param1Boolean) {
      synchronized (FirebaseApp.LOCK) {
        ArrayList arrayList = new ArrayList();
        this((Collection)FirebaseApp.INSTANCES.values());
        for (FirebaseApp firebaseApp : arrayList) {
          if (firebaseApp.automaticResourceManagementEnabled.get())
            firebaseApp.notifyBackgroundStateChangeListeners(param1Boolean); 
        } 
        return;
      } 
    }
  }
  
  private static class UiExecutor implements Executor {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    
    private UiExecutor() {}
    
    public void execute(Runnable param1Runnable) {
      HANDLER.post(param1Runnable);
    }
  }
  
  private static class UserUnlockReceiver extends BroadcastReceiver {
    private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
    
    private final Context applicationContext;
    
    public UserUnlockReceiver(Context param1Context) {
      this.applicationContext = param1Context;
    }
    
    private static void ensureReceiverRegistered(Context param1Context) {
      if (INSTANCE.get() == null) {
        UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(param1Context);
        if (INSTANCE.compareAndSet(null, userUnlockReceiver))
          param1Context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED")); 
      } 
    }
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      synchronized (FirebaseApp.LOCK) {
        Iterator<FirebaseApp> iterator = FirebaseApp.INSTANCES.values().iterator();
        while (iterator.hasNext())
          ((FirebaseApp)iterator.next()).initializeAllApis(); 
        unregister();
        return;
      } 
    }
    
    public void unregister() {
      this.applicationContext.unregisterReceiver(this);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\FirebaseApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */