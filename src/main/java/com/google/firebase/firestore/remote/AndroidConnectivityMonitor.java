package com.google.firebase.firestore.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AndroidConnectivityMonitor implements ConnectivityMonitor {
  private final List<Consumer<ConnectivityMonitor.NetworkStatus>> callbacks;
  
  private final ConnectivityManager connectivityManager;
  
  private final Context context;
  
  private Runnable unregisterRunnable;
  
  public AndroidConnectivityMonitor(Context paramContext) {
    boolean bool;
    this.callbacks = new ArrayList<>();
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Context must be non-null", new Object[0]);
    this.context = paramContext;
    this.connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    configureNetworkMonitoring();
  }
  
  private void configureNetworkMonitoring() {
    if (Build.VERSION.SDK_INT >= 24 && this.connectivityManager != null) {
      final DefaultNetworkCallback defaultNetworkCallback = new DefaultNetworkCallback();
      this.connectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback);
      this.unregisterRunnable = new Runnable() {
          public void run() {
            AndroidConnectivityMonitor.this.connectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
          }
        };
    } else {
      final NetworkReceiver networkReceiver = new NetworkReceiver();
      IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.context.registerReceiver(networkReceiver, intentFilter);
      this.unregisterRunnable = new Runnable() {
          public void run() {
            AndroidConnectivityMonitor.this.context.unregisterReceiver(networkReceiver);
          }
        };
    } 
  }
  
  public void addCallback(Consumer<ConnectivityMonitor.NetworkStatus> paramConsumer) {
    synchronized (this.callbacks) {
      this.callbacks.add(paramConsumer);
      return;
    } 
  }
  
  public void shutdown() {
    Runnable runnable = this.unregisterRunnable;
    if (runnable != null) {
      runnable.run();
      this.unregisterRunnable = null;
    } 
  }
  
  private class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
    private DefaultNetworkCallback() {}
    
    public void onAvailable(Network param1Network) {
      synchronized (AndroidConnectivityMonitor.this.callbacks) {
        Iterator<Consumer> iterator = AndroidConnectivityMonitor.this.callbacks.iterator();
        while (iterator.hasNext())
          ((Consumer)iterator.next()).accept(ConnectivityMonitor.NetworkStatus.REACHABLE); 
        return;
      } 
    }
    
    public void onLost(Network param1Network) {
      synchronized (AndroidConnectivityMonitor.this.callbacks) {
        Iterator<Consumer> iterator = AndroidConnectivityMonitor.this.callbacks.iterator();
        while (iterator.hasNext())
          ((Consumer)iterator.next()).accept(ConnectivityMonitor.NetworkStatus.UNREACHABLE); 
        return;
      } 
    }
  }
  
  private class NetworkReceiver extends BroadcastReceiver {
    private boolean isConnected = false;
    
    private NetworkReceiver() {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      boolean bool1;
      NetworkInfo networkInfo = ((ConnectivityManager)param1Context.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool = this.isConnected;
      if (networkInfo != null && networkInfo.isConnected()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.isConnected = bool1;
      if (this.isConnected && !bool) {
        synchronized (AndroidConnectivityMonitor.this.callbacks) {
          Iterator<Consumer> iterator = AndroidConnectivityMonitor.this.callbacks.iterator();
          while (iterator.hasNext())
            ((Consumer)iterator.next()).accept(ConnectivityMonitor.NetworkStatus.REACHABLE); 
        } 
      } else if (!this.isConnected && bool) {
        synchronized (AndroidConnectivityMonitor.this.callbacks) {
          Iterator<Consumer> iterator = AndroidConnectivityMonitor.this.callbacks.iterator();
          while (iterator.hasNext())
            ((Consumer)iterator.next()).accept(ConnectivityMonitor.NetworkStatus.UNREACHABLE); 
        } 
      } 
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\AndroidConnectivityMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */