package com.google.firebase.storage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class StorageTaskScheduler {
  private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR;
  
  private static final ThreadPoolExecutor COMMAND_POOL_EXECUTOR;
  
  private static final ThreadPoolExecutor DOWNLOAD_QUEUE_EXECUTOR;
  
  private static final ThreadPoolExecutor UPLOAD_QUEUE_EXECUTOR;
  
  private static BlockingQueue<Runnable> mCallbackQueue;
  
  private static BlockingQueue<Runnable> mCommandQueue;
  
  private static BlockingQueue<Runnable> mDownloadQueue;
  
  private static BlockingQueue<Runnable> mUploadQueue;
  
  public static StorageTaskScheduler sInstance = new StorageTaskScheduler();
  
  static {
    mCommandQueue = new LinkedBlockingQueue<>();
    COMMAND_POOL_EXECUTOR = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, mCommandQueue, new StorageThreadFactory("Command-"));
    mUploadQueue = new LinkedBlockingQueue<>();
    UPLOAD_QUEUE_EXECUTOR = new ThreadPoolExecutor(2, 2, 5L, TimeUnit.SECONDS, mUploadQueue, new StorageThreadFactory("Upload-"));
    mDownloadQueue = new LinkedBlockingQueue<>();
    DOWNLOAD_QUEUE_EXECUTOR = new ThreadPoolExecutor(3, 3, 5L, TimeUnit.SECONDS, mDownloadQueue, new StorageThreadFactory("Download-"));
    mCallbackQueue = new LinkedBlockingQueue<>();
    CALLBACK_QUEUE_EXECUTOR = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, mCallbackQueue, new StorageThreadFactory("Callbacks-"));
    COMMAND_POOL_EXECUTOR.allowCoreThreadTimeOut(true);
    UPLOAD_QUEUE_EXECUTOR.allowCoreThreadTimeOut(true);
    DOWNLOAD_QUEUE_EXECUTOR.allowCoreThreadTimeOut(true);
    CALLBACK_QUEUE_EXECUTOR.allowCoreThreadTimeOut(true);
  }
  
  public static StorageTaskScheduler getInstance() {
    return sInstance;
  }
  
  public Executor getCommandPoolExecutor() {
    return COMMAND_POOL_EXECUTOR;
  }
  
  public void scheduleCallback(Runnable paramRunnable) {
    CALLBACK_QUEUE_EXECUTOR.execute(paramRunnable);
  }
  
  public void scheduleCommand(Runnable paramRunnable) {
    COMMAND_POOL_EXECUTOR.execute(paramRunnable);
  }
  
  public void scheduleDownload(Runnable paramRunnable) {
    DOWNLOAD_QUEUE_EXECUTOR.execute(paramRunnable);
  }
  
  public void scheduleUpload(Runnable paramRunnable) {
    UPLOAD_QUEUE_EXECUTOR.execute(paramRunnable);
  }
  
  static class StorageThreadFactory implements ThreadFactory {
    private final String mNameSuffix;
    
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    StorageThreadFactory(String param1String) {
      this.mNameSuffix = param1String;
    }
    
    public Thread newThread(Runnable param1Runnable) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FirebaseStorage-");
      stringBuilder.append(this.mNameSuffix);
      stringBuilder.append(this.threadNumber.getAndIncrement());
      param1Runnable = new Thread(param1Runnable, stringBuilder.toString());
      param1Runnable.setDaemon(false);
      param1Runnable.setPriority(9);
      return (Thread)param1Runnable;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageTaskScheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */