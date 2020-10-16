package com.google.firebase.firestore.util;

import android.os.AsyncTask;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.Executor;

public final class Executors {
  private static final int ASYNC_THREAD_POOL_MAXIMUM_CONCURRENCY = 4;
  
  public static final Executor BACKGROUND_EXECUTOR;
  
  public static final Executor DEFAULT_CALLBACK_EXECUTOR = TaskExecutors.MAIN_THREAD;
  
  public static final Executor DIRECT_EXECUTOR = Executors$$Lambda$1.lambdaFactory$();
  
  static {
    BACKGROUND_EXECUTOR = new ThrottledForwardingExecutor(4, AsyncTask.THREAD_POOL_EXECUTOR);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\Executors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */