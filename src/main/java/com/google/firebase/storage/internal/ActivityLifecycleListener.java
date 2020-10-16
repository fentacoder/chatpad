package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityLifecycleListener {
  private static final ActivityLifecycleListener instance = new ActivityLifecycleListener();
  
  private final Map<Object, LifecycleEntry> cookieMap = new HashMap<>();
  
  private final Object sync = new Object();
  
  public static ActivityLifecycleListener getInstance() {
    return instance;
  }
  
  public void removeCookie(Object paramObject) {
    synchronized (this.sync) {
      paramObject = this.cookieMap.get(paramObject);
      if (paramObject != null)
        OnStopCallback.getInstance(paramObject.getActivity()).removeEntry((LifecycleEntry)paramObject); 
      return;
    } 
  }
  
  public void runOnActivityStopped(Activity paramActivity, Object paramObject, Runnable paramRunnable) {
    synchronized (this.sync) {
      LifecycleEntry lifecycleEntry = new LifecycleEntry();
      this(paramActivity, paramRunnable, paramObject);
      OnStopCallback.getInstance(paramActivity).addEntry(lifecycleEntry);
      this.cookieMap.put(paramObject, lifecycleEntry);
      return;
    } 
  }
  
  private static class LifecycleEntry {
    private final Activity activity;
    
    private final Object cookie;
    
    private final Runnable runnable;
    
    public LifecycleEntry(Activity param1Activity, Runnable param1Runnable, Object param1Object) {
      this.activity = param1Activity;
      this.runnable = param1Runnable;
      this.cookie = param1Object;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof LifecycleEntry;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (((LifecycleEntry)param1Object).cookie.equals(this.cookie)) {
        bool = bool1;
        if (((LifecycleEntry)param1Object).runnable == this.runnable) {
          bool = bool1;
          if (((LifecycleEntry)param1Object).activity == this.activity)
            bool = true; 
        } 
      } 
      return bool;
    }
    
    public Activity getActivity() {
      return this.activity;
    }
    
    public Object getCookie() {
      return this.cookie;
    }
    
    public Runnable getRunnable() {
      return this.runnable;
    }
    
    public int hashCode() {
      return this.cookie.hashCode();
    }
  }
  
  private static class OnStopCallback extends LifecycleCallback {
    private static final String TAG = "StorageOnStopCallback";
    
    private final List<ActivityLifecycleListener.LifecycleEntry> listeners = new ArrayList<>();
    
    private OnStopCallback(LifecycleFragment param1LifecycleFragment) {
      super(param1LifecycleFragment);
      this.mLifecycleFragment.addCallback("StorageOnStopCallback", this);
    }
    
    public static OnStopCallback getInstance(Activity param1Activity) {
      LifecycleFragment lifecycleFragment = getFragment(new LifecycleActivity(param1Activity));
      OnStopCallback onStopCallback2 = (OnStopCallback)lifecycleFragment.getCallbackOrNull("StorageOnStopCallback", OnStopCallback.class);
      OnStopCallback onStopCallback1 = onStopCallback2;
      if (onStopCallback2 == null)
        onStopCallback1 = new OnStopCallback(lifecycleFragment); 
      return onStopCallback1;
    }
    
    public void addEntry(ActivityLifecycleListener.LifecycleEntry param1LifecycleEntry) {
      synchronized (this.listeners) {
        this.listeners.add(param1LifecycleEntry);
        return;
      } 
    }
    
    public void onStop() {
      synchronized (this.listeners) {
        ArrayList arrayList = new ArrayList();
        this((Collection)this.listeners);
        this.listeners.clear();
        for (ActivityLifecycleListener.LifecycleEntry lifecycleEntry : arrayList) {
          if (lifecycleEntry != null) {
            Log.d("StorageOnStopCallback", "removing subscription from activity.");
            lifecycleEntry.getRunnable().run();
            ActivityLifecycleListener.getInstance().removeCookie(lifecycleEntry.getCookie());
          } 
        } 
        return;
      } 
    }
    
    public void removeEntry(ActivityLifecycleListener.LifecycleEntry param1LifecycleEntry) {
      synchronized (this.listeners) {
        this.listeners.remove(param1LifecycleEntry);
        return;
      } 
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\ActivityLifecycleListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */