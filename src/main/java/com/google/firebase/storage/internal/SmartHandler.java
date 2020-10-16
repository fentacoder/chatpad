package com.google.firebase.storage.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.StorageTaskScheduler;
import java.util.concurrent.Executor;

public class SmartHandler {
  static boolean testMode = false;
  
  private final Executor executor;
  
  private final Handler handler;
  
  public SmartHandler(Executor paramExecutor) {
    this.executor = paramExecutor;
    if (this.executor == null) {
      if (!testMode) {
        this.handler = new Handler(Looper.getMainLooper());
      } else {
        this.handler = null;
      } 
    } else {
      this.handler = null;
    } 
  }
  
  public void callBack(Runnable paramRunnable) {
    Executor executor;
    Preconditions.checkNotNull(paramRunnable);
    Handler handler = this.handler;
    if (handler == null) {
      executor = this.executor;
      if (executor != null) {
        executor.execute(paramRunnable);
      } else {
        StorageTaskScheduler.getInstance().scheduleCallback(paramRunnable);
      } 
    } else {
      executor.post(paramRunnable);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\SmartHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */