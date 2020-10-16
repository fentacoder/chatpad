package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class BackgroundQueue implements Executor {
  private Semaphore completedTasks = new Semaphore(0);
  
  private int pendingTaskCount = 0;
  
  public void drain() throws InterruptedException {
    this.completedTasks.acquire(this.pendingTaskCount);
    this.pendingTaskCount = 0;
  }
  
  public void execute(Runnable paramRunnable) {
    this.pendingTaskCount++;
    Executors.BACKGROUND_EXECUTOR.execute(BackgroundQueue$$Lambda$1.lambdaFactory$(this, paramRunnable));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\BackgroundQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */