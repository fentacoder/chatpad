package com.google.firebase.firestore.util;

import java.util.Date;

public class ExponentialBackoff {
  public static final double DEFAULT_BACKOFF_FACTOR = 1.5D;
  
  public static final long DEFAULT_BACKOFF_INITIAL_DELAY_MS = 1000L;
  
  public static final long DEFAULT_BACKOFF_MAX_DELAY_MS = 60000L;
  
  private final double backoffFactor;
  
  private long currentBaseMs;
  
  private final long initialDelayMs;
  
  private long lastAttemptTime;
  
  private final long maxDelayMs;
  
  private final AsyncQueue queue;
  
  private final AsyncQueue.TimerId timerId;
  
  private AsyncQueue.DelayedTask timerTask;
  
  public ExponentialBackoff(AsyncQueue paramAsyncQueue, AsyncQueue.TimerId paramTimerId) {
    this(paramAsyncQueue, paramTimerId, 1000L, 1.5D, 60000L);
  }
  
  public ExponentialBackoff(AsyncQueue paramAsyncQueue, AsyncQueue.TimerId paramTimerId, long paramLong1, double paramDouble, long paramLong2) {
    this.queue = paramAsyncQueue;
    this.timerId = paramTimerId;
    this.initialDelayMs = paramLong1;
    this.backoffFactor = paramDouble;
    this.maxDelayMs = paramLong2;
    this.lastAttemptTime = (new Date()).getTime();
    reset();
  }
  
  private long jitterDelayMs() {
    return (long)((Math.random() - 0.5D) * this.currentBaseMs);
  }
  
  public void backoffAndRun(Runnable paramRunnable) {
    cancel();
    long l1 = this.currentBaseMs + jitterDelayMs();
    long l2 = Math.max(0L, (new Date()).getTime() - this.lastAttemptTime);
    long l3 = Math.max(0L, l1 - l2);
    if (this.currentBaseMs > 0L)
      Logger.debug(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", new Object[] { Long.valueOf(l3), Long.valueOf(this.currentBaseMs), Long.valueOf(l1), Long.valueOf(l2) }); 
    this.timerTask = this.queue.enqueueAfterDelay(this.timerId, l3, ExponentialBackoff$$Lambda$1.lambdaFactory$(this, paramRunnable));
    this.currentBaseMs = (long)(this.currentBaseMs * this.backoffFactor);
    l3 = this.currentBaseMs;
    l1 = this.initialDelayMs;
    if (l3 < l1) {
      this.currentBaseMs = l1;
    } else {
      l1 = this.maxDelayMs;
      if (l3 > l1)
        this.currentBaseMs = l1; 
    } 
  }
  
  public void cancel() {
    AsyncQueue.DelayedTask delayedTask = this.timerTask;
    if (delayedTask != null) {
      delayedTask.cancel();
      this.timerTask = null;
    } 
  }
  
  public void reset() {
    this.currentBaseMs = 0L;
  }
  
  public void resetToMax() {
    this.currentBaseMs = this.maxDelayMs;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\ExponentialBackoff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */