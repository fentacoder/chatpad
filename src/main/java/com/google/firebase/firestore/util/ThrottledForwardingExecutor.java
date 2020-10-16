package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

class ThrottledForwardingExecutor implements Executor {
  private final Semaphore availableSlots;
  
  private final Executor executor;
  
  ThrottledForwardingExecutor(int paramInt, Executor paramExecutor) {
    this.availableSlots = new Semaphore(paramInt);
    this.executor = paramExecutor;
  }
  
  public void execute(Runnable paramRunnable) {
    if (this.availableSlots.tryAcquire()) {
      try {
        this.executor.execute(ThrottledForwardingExecutor$$Lambda$1.lambdaFactory$(this, paramRunnable));
      } catch (RejectedExecutionException rejectedExecutionException) {
        paramRunnable.run();
      } 
    } else {
      paramRunnable.run();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\ThrottledForwardingExecutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */