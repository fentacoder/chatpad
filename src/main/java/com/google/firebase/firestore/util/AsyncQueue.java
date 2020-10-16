package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

public class AsyncQueue {
  private final ArrayList<DelayedTask> delayedTasks = new ArrayList<>();
  
  private final SynchronizedShutdownAwareExecutor executor = new SynchronizedShutdownAwareExecutor();
  
  private final ArrayList<TimerId> timerIdsToSkip = new ArrayList<>();
  
  public static <TResult> Task<TResult> callTask(Executor paramExecutor, Callable<Task<TResult>> paramCallable) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    paramExecutor.execute(AsyncQueue$$Lambda$1.lambdaFactory$(paramCallable, paramExecutor, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  private DelayedTask createAndScheduleDelayedTask(TimerId paramTimerId, long paramLong, Runnable paramRunnable) {
    DelayedTask delayedTask = new DelayedTask(paramTimerId, System.currentTimeMillis() + paramLong, paramRunnable);
    delayedTask.start(paramLong);
    return delayedTask;
  }
  
  private void removeDelayedTask(DelayedTask paramDelayedTask) {
    Assert.hardAssert(this.delayedTasks.remove(paramDelayedTask), "Delayed task not found.", new Object[0]);
  }
  
  public boolean containsDelayedTask(TimerId paramTimerId) {
    Iterator<DelayedTask> iterator = this.delayedTasks.iterator();
    while (iterator.hasNext()) {
      if ((iterator.next()).timerId == paramTimerId)
        return true; 
    } 
    return false;
  }
  
  @CheckReturnValue
  public Task<Void> enqueue(Runnable paramRunnable) {
    return enqueue(AsyncQueue$$Lambda$2.lambdaFactory$(paramRunnable));
  }
  
  @CheckReturnValue
  public <T> Task<T> enqueue(Callable<T> paramCallable) {
    return this.executor.executeAndReportResult(paramCallable);
  }
  
  public DelayedTask enqueueAfterDelay(TimerId paramTimerId, long paramLong, Runnable paramRunnable) {
    if (this.timerIdsToSkip.contains(paramTimerId))
      paramLong = 0L; 
    DelayedTask delayedTask = createAndScheduleDelayedTask(paramTimerId, paramLong, paramRunnable);
    this.delayedTasks.add(delayedTask);
    return delayedTask;
  }
  
  public void enqueueAndForget(Runnable paramRunnable) {
    enqueue(paramRunnable);
  }
  
  public void enqueueAndForgetEvenAfterShutdown(Runnable paramRunnable) {
    this.executor.executeEvenAfterShutdown(paramRunnable);
  }
  
  public Task<Void> enqueueAndInitiateShutdown(Runnable paramRunnable) {
    return this.executor.executeAndInitiateShutdown(paramRunnable);
  }
  
  public Executor getExecutor() {
    return this.executor;
  }
  
  public boolean isShuttingDown() {
    return this.executor.isShuttingDown();
  }
  
  public void panic(Throwable paramThrowable) {
    this.executor.shutdownNow();
    (new Handler(Looper.getMainLooper())).post(AsyncQueue$$Lambda$3.lambdaFactory$(paramThrowable));
  }
  
  public void runDelayedTasksUntil(TimerId paramTimerId) throws InterruptedException {
    runSync(AsyncQueue$$Lambda$5.lambdaFactory$(this, paramTimerId));
  }
  
  public void runSync(Runnable paramRunnable) throws InterruptedException {
    Semaphore semaphore = new Semaphore(0);
    Throwable[] arrayOfThrowable = new Throwable[1];
    enqueueAndForget(AsyncQueue$$Lambda$4.lambdaFactory$(paramRunnable, arrayOfThrowable, semaphore));
    semaphore.acquire(1);
    if (arrayOfThrowable[0] == null)
      return; 
    throw new RuntimeException("Synchronous task failed", arrayOfThrowable[0]);
  }
  
  public void shutdown() {
    this.executor.setCorePoolSize(0);
  }
  
  public void skipDelaysForTimerId(TimerId paramTimerId) {
    this.timerIdsToSkip.add(paramTimerId);
  }
  
  public void verifyIsCurrentThread() {
    Thread thread = Thread.currentThread();
    if (this.executor.thread == thread)
      return; 
    throw Assert.fail("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", new Object[] { SynchronizedShutdownAwareExecutor.access$300(this.executor).getName(), Long.valueOf(SynchronizedShutdownAwareExecutor.access$300(this.executor).getId()), thread.getName(), Long.valueOf(thread.getId()) });
  }
  
  public class DelayedTask {
    private ScheduledFuture scheduledFuture;
    
    private final long targetTimeMs;
    
    private final Runnable task;
    
    private final AsyncQueue.TimerId timerId;
    
    private DelayedTask(AsyncQueue.TimerId param1TimerId, long param1Long, Runnable param1Runnable) {
      this.timerId = param1TimerId;
      this.targetTimeMs = param1Long;
      this.task = param1Runnable;
    }
    
    private void handleDelayElapsed() {
      AsyncQueue.this.verifyIsCurrentThread();
      if (this.scheduledFuture != null) {
        markDone();
        this.task.run();
      } 
    }
    
    private void markDone() {
      boolean bool;
      if (this.scheduledFuture != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
      this.scheduledFuture = null;
      AsyncQueue.this.removeDelayedTask(this);
    }
    
    private void start(long param1Long) {
      this.scheduledFuture = AsyncQueue.this.executor.schedule(AsyncQueue$DelayedTask$$Lambda$1.lambdaFactory$(this), param1Long, TimeUnit.MILLISECONDS);
    }
    
    public void cancel() {
      AsyncQueue.this.verifyIsCurrentThread();
      ScheduledFuture scheduledFuture = this.scheduledFuture;
      if (scheduledFuture != null) {
        scheduledFuture.cancel(false);
        markDone();
      } 
    }
    
    void skipDelay() {
      handleDelayElapsed();
    }
  }
  
  private class SynchronizedShutdownAwareExecutor implements Executor {
    private final ScheduledThreadPoolExecutor internalExecutor;
    
    private boolean isShuttingDown;
    
    private final Thread thread;
    
    SynchronizedShutdownAwareExecutor() {
      DelayedStartFactory delayedStartFactory = new DelayedStartFactory();
      this.thread = Executors.defaultThreadFactory().newThread(delayedStartFactory);
      this.thread.setName("FirestoreWorker");
      this.thread.setDaemon(true);
      this.thread.setUncaughtExceptionHandler(AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$1.lambdaFactory$(this));
      this.internalExecutor = new ScheduledThreadPoolExecutor(1, delayedStartFactory) {
          protected void afterExecute(Runnable param2Runnable, Throwable param2Throwable) {
            super.afterExecute(param2Runnable, param2Throwable);
            Throwable throwable = param2Throwable;
            if (param2Throwable == null) {
              throwable = param2Throwable;
              if (param2Runnable instanceof Future) {
                Future future = (Future)param2Runnable;
                throwable = param2Throwable;
                try {
                  if (future.isDone()) {
                    future.get();
                    throwable = param2Throwable;
                  } 
                } catch (CancellationException cancellationException) {
                  throwable = param2Throwable;
                } catch (ExecutionException executionException) {
                  throwable = executionException.getCause();
                } catch (InterruptedException interruptedException) {
                  Thread.currentThread().interrupt();
                  throwable = param2Throwable;
                } 
              } 
            } 
            if (throwable != null)
              AsyncQueue.this.panic(throwable); 
          }
        };
      this.internalExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
      this.isShuttingDown = false;
    }
    
    private Task<Void> executeAndInitiateShutdown(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial isShuttingDown : ()Z
      //   6: ifeq -> 31
      //   9: new com/google/android/gms/tasks/TaskCompletionSource
      //   12: astore_1
      //   13: aload_1
      //   14: invokespecial <init> : ()V
      //   17: aload_1
      //   18: aconst_null
      //   19: invokevirtual setResult : (Ljava/lang/Object;)V
      //   22: aload_1
      //   23: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
      //   26: astore_1
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_1
      //   30: areturn
      //   31: aload_0
      //   32: aload_1
      //   33: invokestatic lambdaFactory$ : (Ljava/lang/Runnable;)Ljava/util/concurrent/Callable;
      //   36: invokespecial executeAndReportResult : (Ljava/util/concurrent/Callable;)Lcom/google/android/gms/tasks/Task;
      //   39: astore_1
      //   40: aload_0
      //   41: iconst_1
      //   42: putfield isShuttingDown : Z
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: areturn
      //   49: astore_1
      //   50: aload_0
      //   51: monitorexit
      //   52: aload_1
      //   53: athrow
      // Exception table:
      //   from	to	target	type
      //   2	27	49	finally
      //   31	45	49	finally
    }
    
    private <T> Task<T> executeAndReportResult(Callable<T> param1Callable) {
      TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
      try {
        execute(AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$2.lambdaFactory$(taskCompletionSource, param1Callable));
      } catch (RejectedExecutionException rejectedExecutionException) {
        Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
      } 
      return taskCompletionSource.getTask();
    }
    
    private boolean isShuttingDown() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield isShuttingDown : Z
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    private ScheduledFuture<?> schedule(Runnable param1Runnable, long param1Long, TimeUnit param1TimeUnit) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield isShuttingDown : Z
      //   6: ifne -> 25
      //   9: aload_0
      //   10: getfield internalExecutor : Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      //   13: aload_1
      //   14: lload_2
      //   15: aload #4
      //   17: invokevirtual schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: aload_0
      //   26: monitorexit
      //   27: aconst_null
      //   28: areturn
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	21	29	finally
    }
    
    private void setCorePoolSize(int param1Int) {
      this.internalExecutor.setCorePoolSize(param1Int);
    }
    
    private void shutdownNow() {
      this.internalExecutor.shutdownNow();
    }
    
    public void execute(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield isShuttingDown : Z
      //   6: ifne -> 17
      //   9: aload_0
      //   10: getfield internalExecutor : Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      //   13: aload_1
      //   14: invokevirtual execute : (Ljava/lang/Runnable;)V
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	20	finally
    }
    
    public void executeEvenAfterShutdown(Runnable param1Runnable) {
      try {
        this.internalExecutor.execute(param1Runnable);
      } catch (RejectedExecutionException rejectedExecutionException) {
        Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
      } 
    }
    
    private class DelayedStartFactory implements Runnable, ThreadFactory {
      private Runnable delegate;
      
      private final CountDownLatch latch = new CountDownLatch(1);
      
      private DelayedStartFactory() {}
      
      public Thread newThread(Runnable param2Runnable) {
        boolean bool;
        if (this.delegate == null) {
          bool = true;
        } else {
          bool = false;
        } 
        Assert.hardAssert(bool, "Only one thread may be created in an AsyncQueue.", new Object[0]);
        this.delegate = param2Runnable;
        this.latch.countDown();
        return AsyncQueue.SynchronizedShutdownAwareExecutor.this.thread;
      }
      
      public void run() {
        try {
          this.latch.await();
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
        } 
        this.delegate.run();
      }
    }
  }
  
  class null extends ScheduledThreadPoolExecutor {
    null(int param1Int, ThreadFactory param1ThreadFactory) {
      super(param1Int, param1ThreadFactory);
    }
    
    protected void afterExecute(Runnable param1Runnable, Throwable param1Throwable) {
      super.afterExecute(param1Runnable, param1Throwable);
      Throwable throwable = param1Throwable;
      if (param1Throwable == null) {
        throwable = param1Throwable;
        if (param1Runnable instanceof Future) {
          Future future = (Future)param1Runnable;
          throwable = param1Throwable;
          try {
            if (future.isDone()) {
              future.get();
              throwable = param1Throwable;
            } 
          } catch (CancellationException cancellationException) {
            throwable = param1Throwable;
          } catch (ExecutionException executionException) {
            throwable = executionException.getCause();
          } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throwable = param1Throwable;
          } 
        } 
      } 
      if (throwable != null)
        AsyncQueue.this.panic(throwable); 
    }
  }
  
  private class DelayedStartFactory implements Runnable, ThreadFactory {
    private Runnable delegate;
    
    private final CountDownLatch latch = new CountDownLatch(1);
    
    private DelayedStartFactory() {}
    
    public Thread newThread(Runnable param1Runnable) {
      boolean bool;
      if (this.delegate == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Only one thread may be created in an AsyncQueue.", new Object[0]);
      this.delegate = param1Runnable;
      this.latch.countDown();
      return AsyncQueue.SynchronizedShutdownAwareExecutor.this.thread;
    }
    
    public void run() {
      try {
        this.latch.await();
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
      } 
      this.delegate.run();
    }
  }
  
  public enum TimerId {
    ALL, GARBAGE_COLLECTION, LISTEN_STREAM_CONNECTION_BACKOFF, LISTEN_STREAM_IDLE, ONLINE_STATE_TIMEOUT, RETRY_TRANSACTION, WRITE_STREAM_CONNECTION_BACKOFF, WRITE_STREAM_IDLE;
    
    static {
      WRITE_STREAM_CONNECTION_BACKOFF = new TimerId("WRITE_STREAM_CONNECTION_BACKOFF", 4);
      ONLINE_STATE_TIMEOUT = new TimerId("ONLINE_STATE_TIMEOUT", 5);
      GARBAGE_COLLECTION = new TimerId("GARBAGE_COLLECTION", 6);
      RETRY_TRANSACTION = new TimerId("RETRY_TRANSACTION", 7);
      $VALUES = new TimerId[] { ALL, LISTEN_STREAM_IDLE, LISTEN_STREAM_CONNECTION_BACKOFF, WRITE_STREAM_IDLE, WRITE_STREAM_CONNECTION_BACKOFF, ONLINE_STATE_TIMEOUT, GARBAGE_COLLECTION, RETRY_TRANSACTION };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\AsyncQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */