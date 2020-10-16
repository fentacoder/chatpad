package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {
  static final Handler HANDLER = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        List<Action> list;
        int i = param1Message.what;
        if (i != 3) {
          int j = 0;
          int k = 0;
          if (i != 8) {
            if (i == 13) {
              list = (List)param1Message.obj;
              j = list.size();
              while (k < j) {
                Action action = list.get(k);
                action.picasso.resumeAction(action);
                k++;
              } 
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown handler message received: ");
              stringBuilder.append(((Message)list).what);
              throw new AssertionError(stringBuilder.toString());
            } 
          } else {
            list = (List<Action>)((Message)list).obj;
            i = list.size();
            for (k = j; k < i; k++) {
              BitmapHunter bitmapHunter = (BitmapHunter)list.get(k);
              bitmapHunter.picasso.complete(bitmapHunter);
            } 
          } 
        } else {
          Action action = (Action)((Message)list).obj;
          if ((action.getPicasso()).loggingEnabled)
            Utils.log("Main", "canceled", action.request.logId(), "target got garbage collected"); 
          action.picasso.cancelExistingRequest(action.getTarget());
        } 
      }
    };
  
  static final String TAG = "Picasso";
  
  static volatile Picasso singleton = null;
  
  final Cache cache;
  
  private final CleanupThread cleanupThread;
  
  final Context context;
  
  final Bitmap.Config defaultBitmapConfig;
  
  final Dispatcher dispatcher;
  
  boolean indicatorsEnabled;
  
  private final Listener listener;
  
  volatile boolean loggingEnabled;
  
  final ReferenceQueue<Object> referenceQueue;
  
  private final List<RequestHandler> requestHandlers;
  
  private final RequestTransformer requestTransformer;
  
  boolean shutdown;
  
  final Stats stats;
  
  final Map<Object, Action> targetToAction;
  
  final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;
  
  Picasso(Context paramContext, Dispatcher paramDispatcher, Cache paramCache, Listener paramListener, RequestTransformer paramRequestTransformer, List<RequestHandler> paramList, Stats paramStats, Bitmap.Config paramConfig, boolean paramBoolean1, boolean paramBoolean2) {
    byte b;
    this.context = paramContext;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.listener = paramListener;
    this.requestTransformer = paramRequestTransformer;
    this.defaultBitmapConfig = paramConfig;
    if (paramList != null) {
      b = paramList.size();
    } else {
      b = 0;
    } 
    ArrayList<ResourceRequestHandler> arrayList = new ArrayList(b + 7);
    arrayList.add(new ResourceRequestHandler(paramContext));
    if (paramList != null)
      arrayList.addAll(paramList); 
    arrayList.add(new ContactsPhotoRequestHandler(paramContext));
    arrayList.add(new MediaStoreRequestHandler(paramContext));
    arrayList.add(new ContentStreamRequestHandler(paramContext));
    arrayList.add(new AssetRequestHandler(paramContext));
    arrayList.add(new FileRequestHandler(paramContext));
    arrayList.add(new NetworkRequestHandler(paramDispatcher.downloader, paramStats));
    this.requestHandlers = Collections.unmodifiableList((List)arrayList);
    this.stats = paramStats;
    this.targetToAction = new WeakHashMap<>();
    this.targetToDeferredRequestCreator = new WeakHashMap<>();
    this.indicatorsEnabled = paramBoolean1;
    this.loggingEnabled = paramBoolean2;
    this.referenceQueue = new ReferenceQueue();
    this.cleanupThread = new CleanupThread(this.referenceQueue, HANDLER);
    this.cleanupThread.start();
  }
  
  private void deliverAction(Bitmap paramBitmap, LoadedFrom paramLoadedFrom, Action paramAction, Exception paramException) {
    String str;
    if (paramAction.isCancelled())
      return; 
    if (!paramAction.willReplay())
      this.targetToAction.remove(paramAction.getTarget()); 
    if (paramBitmap != null) {
      if (paramLoadedFrom != null) {
        paramAction.complete(paramBitmap, paramLoadedFrom);
        if (this.loggingEnabled) {
          str = paramAction.request.logId();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("from ");
          stringBuilder.append(paramLoadedFrom);
          Utils.log("Main", "completed", str, stringBuilder.toString());
        } 
      } else {
        throw new AssertionError("LoadedFrom cannot be null.");
      } 
    } else {
      str.error(paramException);
      if (this.loggingEnabled)
        Utils.log("Main", "errored", ((Action)str).request.logId(), paramException.getMessage()); 
    } 
  }
  
  public static Picasso get() {
    // Byte code:
    //   0: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   3: ifnonnull -> 67
    //   6: ldc com/squareup/picasso/Picasso
    //   8: monitorenter
    //   9: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   12: ifnonnull -> 55
    //   15: getstatic com/squareup/picasso/PicassoProvider.context : Landroid/content/Context;
    //   18: ifnull -> 42
    //   21: new com/squareup/picasso/Picasso$Builder
    //   24: astore_0
    //   25: aload_0
    //   26: getstatic com/squareup/picasso/PicassoProvider.context : Landroid/content/Context;
    //   29: invokespecial <init> : (Landroid/content/Context;)V
    //   32: aload_0
    //   33: invokevirtual build : ()Lcom/squareup/picasso/Picasso;
    //   36: putstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   39: goto -> 55
    //   42: new java/lang/IllegalStateException
    //   45: astore_0
    //   46: aload_0
    //   47: ldc_w 'context == null'
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: aload_0
    //   54: athrow
    //   55: ldc com/squareup/picasso/Picasso
    //   57: monitorexit
    //   58: goto -> 67
    //   61: astore_0
    //   62: ldc com/squareup/picasso/Picasso
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    //   67: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   70: areturn
    // Exception table:
    //   from	to	target	type
    //   9	39	61	finally
    //   42	55	61	finally
    //   55	58	61	finally
    //   62	65	61	finally
  }
  
  public static void setSingletonInstance(Picasso paramPicasso) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 40
    //   4: ldc com/squareup/picasso/Picasso
    //   6: monitorenter
    //   7: getstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   10: ifnonnull -> 21
    //   13: aload_0
    //   14: putstatic com/squareup/picasso/Picasso.singleton : Lcom/squareup/picasso/Picasso;
    //   17: ldc com/squareup/picasso/Picasso
    //   19: monitorexit
    //   20: return
    //   21: new java/lang/IllegalStateException
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 'Singleton instance already exists.'
    //   29: invokespecial <init> : (Ljava/lang/String;)V
    //   32: aload_0
    //   33: athrow
    //   34: astore_0
    //   35: ldc com/squareup/picasso/Picasso
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: new java/lang/IllegalArgumentException
    //   43: dup
    //   44: ldc_w 'Picasso must not be null.'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   7	20	34	finally
    //   21	34	34	finally
    //   35	38	34	finally
  }
  
  public boolean areIndicatorsEnabled() {
    return this.indicatorsEnabled;
  }
  
  void cancelExistingRequest(Object paramObject) {
    Utils.checkMain();
    Action action = this.targetToAction.remove(paramObject);
    if (action != null) {
      action.cancel();
      this.dispatcher.dispatchCancel(action);
    } 
    if (paramObject instanceof ImageView) {
      paramObject = paramObject;
      paramObject = this.targetToDeferredRequestCreator.remove(paramObject);
      if (paramObject != null)
        paramObject.cancel(); 
    } 
  }
  
  public void cancelRequest(ImageView paramImageView) {
    if (paramImageView != null) {
      cancelExistingRequest(paramImageView);
      return;
    } 
    throw new IllegalArgumentException("view cannot be null.");
  }
  
  public void cancelRequest(RemoteViews paramRemoteViews, int paramInt) {
    if (paramRemoteViews != null) {
      cancelExistingRequest(new RemoteViewsAction.RemoteViewsTarget(paramRemoteViews, paramInt));
      return;
    } 
    throw new IllegalArgumentException("remoteViews cannot be null.");
  }
  
  public void cancelRequest(Target paramTarget) {
    if (paramTarget != null) {
      cancelExistingRequest(paramTarget);
      return;
    } 
    throw new IllegalArgumentException("target cannot be null.");
  }
  
  public void cancelTag(Object paramObject) {
    Utils.checkMain();
    if (paramObject != null) {
      ArrayList<Action> arrayList = new ArrayList(this.targetToAction.values());
      int i = arrayList.size();
      boolean bool = false;
      byte b;
      for (b = 0; b < i; b++) {
        Action action = arrayList.get(b);
        if (paramObject.equals(action.getTag()))
          cancelExistingRequest(action.getTarget()); 
      } 
      ArrayList<DeferredRequestCreator> arrayList1 = new ArrayList(this.targetToDeferredRequestCreator.values());
      i = arrayList1.size();
      for (b = bool; b < i; b++) {
        DeferredRequestCreator deferredRequestCreator = arrayList1.get(b);
        if (paramObject.equals(deferredRequestCreator.getTag()))
          deferredRequestCreator.cancel(); 
      } 
      return;
    } 
    throw new IllegalArgumentException("Cannot cancel requests with null tag.");
  }
  
  void complete(BitmapHunter paramBitmapHunter) {
    byte b3;
    Action action = paramBitmapHunter.getAction();
    List<Action> list = paramBitmapHunter.getActions();
    byte b1 = 1;
    byte b2 = 0;
    if (list != null && !list.isEmpty()) {
      b3 = 1;
    } else {
      b3 = 0;
    } 
    int i = b1;
    if (action == null)
      if (b3) {
        i = b1;
      } else {
        i = 0;
      }  
    if (!i)
      return; 
    Uri uri = (paramBitmapHunter.getData()).uri;
    Exception exception = paramBitmapHunter.getException();
    Bitmap bitmap = paramBitmapHunter.getResult();
    LoadedFrom loadedFrom = paramBitmapHunter.getLoadedFrom();
    if (action != null)
      deliverAction(bitmap, loadedFrom, action, exception); 
    if (b3) {
      i = list.size();
      for (b3 = b2; b3 < i; b3++)
        deliverAction(bitmap, loadedFrom, list.get(b3), exception); 
    } 
    Listener listener = this.listener;
    if (listener != null && exception != null)
      listener.onImageLoadFailed(this, uri, exception); 
  }
  
  void defer(ImageView paramImageView, DeferredRequestCreator paramDeferredRequestCreator) {
    if (this.targetToDeferredRequestCreator.containsKey(paramImageView))
      cancelExistingRequest(paramImageView); 
    this.targetToDeferredRequestCreator.put(paramImageView, paramDeferredRequestCreator);
  }
  
  void enqueueAndSubmit(Action<Object> paramAction) {
    Object object = paramAction.getTarget();
    if (object != null && this.targetToAction.get(object) != paramAction) {
      cancelExistingRequest(object);
      this.targetToAction.put(object, paramAction);
    } 
    submit(paramAction);
  }
  
  List<RequestHandler> getRequestHandlers() {
    return this.requestHandlers;
  }
  
  public StatsSnapshot getSnapshot() {
    return this.stats.createSnapshot();
  }
  
  public void invalidate(Uri paramUri) {
    if (paramUri != null)
      this.cache.clearKeyUri(paramUri.toString()); 
  }
  
  public void invalidate(File paramFile) {
    if (paramFile != null) {
      invalidate(Uri.fromFile(paramFile));
      return;
    } 
    throw new IllegalArgumentException("file == null");
  }
  
  public void invalidate(String paramString) {
    if (paramString != null)
      invalidate(Uri.parse(paramString)); 
  }
  
  public boolean isLoggingEnabled() {
    return this.loggingEnabled;
  }
  
  public RequestCreator load(int paramInt) {
    if (paramInt != 0)
      return new RequestCreator(this, null, paramInt); 
    throw new IllegalArgumentException("Resource ID must not be zero.");
  }
  
  public RequestCreator load(Uri paramUri) {
    return new RequestCreator(this, paramUri, 0);
  }
  
  public RequestCreator load(File paramFile) {
    return (paramFile == null) ? new RequestCreator(this, null, 0) : load(Uri.fromFile(paramFile));
  }
  
  public RequestCreator load(String paramString) {
    if (paramString == null)
      return new RequestCreator(this, null, 0); 
    if (paramString.trim().length() != 0)
      return load(Uri.parse(paramString)); 
    throw new IllegalArgumentException("Path must not be empty.");
  }
  
  public void pauseTag(Object paramObject) {
    if (paramObject != null) {
      this.dispatcher.dispatchPauseTag(paramObject);
      return;
    } 
    throw new IllegalArgumentException("tag == null");
  }
  
  Bitmap quickMemoryCacheCheck(String paramString) {
    Bitmap bitmap = this.cache.get(paramString);
    if (bitmap != null) {
      this.stats.dispatchCacheHit();
    } else {
      this.stats.dispatchCacheMiss();
    } 
    return bitmap;
  }
  
  void resumeAction(Action paramAction) {
    StringBuilder stringBuilder;
    Bitmap bitmap;
    if (MemoryPolicy.shouldReadFromMemoryCache(paramAction.memoryPolicy)) {
      bitmap = quickMemoryCacheCheck(paramAction.getKey());
    } else {
      bitmap = null;
    } 
    if (bitmap != null) {
      deliverAction(bitmap, LoadedFrom.MEMORY, paramAction, null);
      if (this.loggingEnabled) {
        String str = paramAction.request.logId();
        stringBuilder = new StringBuilder();
        stringBuilder.append("from ");
        stringBuilder.append(LoadedFrom.MEMORY);
        Utils.log("Main", "completed", str, stringBuilder.toString());
      } 
    } else {
      enqueueAndSubmit((Action)stringBuilder);
      if (this.loggingEnabled)
        Utils.log("Main", "resumed", ((Action)stringBuilder).request.logId()); 
    } 
  }
  
  public void resumeTag(Object paramObject) {
    if (paramObject != null) {
      this.dispatcher.dispatchResumeTag(paramObject);
      return;
    } 
    throw new IllegalArgumentException("tag == null");
  }
  
  public void setIndicatorsEnabled(boolean paramBoolean) {
    this.indicatorsEnabled = paramBoolean;
  }
  
  public void setLoggingEnabled(boolean paramBoolean) {
    this.loggingEnabled = paramBoolean;
  }
  
  public void shutdown() {
    if (this != singleton) {
      if (this.shutdown)
        return; 
      this.cache.clear();
      this.cleanupThread.shutdown();
      this.stats.shutdown();
      this.dispatcher.shutdown();
      Iterator<DeferredRequestCreator> iterator = this.targetToDeferredRequestCreator.values().iterator();
      while (iterator.hasNext())
        ((DeferredRequestCreator)iterator.next()).cancel(); 
      this.targetToDeferredRequestCreator.clear();
      this.shutdown = true;
      return;
    } 
    throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
  }
  
  void submit(Action paramAction) {
    this.dispatcher.dispatchSubmit(paramAction);
  }
  
  Request transformRequest(Request paramRequest) {
    Request request = this.requestTransformer.transformRequest(paramRequest);
    if (request != null)
      return request; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request transformer ");
    stringBuilder.append(this.requestTransformer.getClass().getCanonicalName());
    stringBuilder.append(" returned null for ");
    stringBuilder.append(paramRequest);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static class Builder {
    private Cache cache;
    
    private final Context context;
    
    private Bitmap.Config defaultBitmapConfig;
    
    private Downloader downloader;
    
    private boolean indicatorsEnabled;
    
    private Picasso.Listener listener;
    
    private boolean loggingEnabled;
    
    private List<RequestHandler> requestHandlers;
    
    private ExecutorService service;
    
    private Picasso.RequestTransformer transformer;
    
    public Builder(Context param1Context) {
      if (param1Context != null) {
        this.context = param1Context.getApplicationContext();
        return;
      } 
      throw new IllegalArgumentException("Context must not be null.");
    }
    
    public Builder addRequestHandler(RequestHandler param1RequestHandler) {
      if (param1RequestHandler != null) {
        if (this.requestHandlers == null)
          this.requestHandlers = new ArrayList<>(); 
        if (!this.requestHandlers.contains(param1RequestHandler)) {
          this.requestHandlers.add(param1RequestHandler);
          return this;
        } 
        throw new IllegalStateException("RequestHandler already registered.");
      } 
      throw new IllegalArgumentException("RequestHandler must not be null.");
    }
    
    public Picasso build() {
      Context context = this.context;
      if (this.downloader == null)
        this.downloader = new OkHttp3Downloader(context); 
      if (this.cache == null)
        this.cache = new LruCache(context); 
      if (this.service == null)
        this.service = new PicassoExecutorService(); 
      if (this.transformer == null)
        this.transformer = Picasso.RequestTransformer.IDENTITY; 
      Stats stats = new Stats(this.cache);
      return new Picasso(context, new Dispatcher(context, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
    }
    
    public Builder defaultBitmapConfig(Bitmap.Config param1Config) {
      if (param1Config != null) {
        this.defaultBitmapConfig = param1Config;
        return this;
      } 
      throw new IllegalArgumentException("Bitmap config must not be null.");
    }
    
    public Builder downloader(Downloader param1Downloader) {
      if (param1Downloader != null) {
        if (this.downloader == null) {
          this.downloader = param1Downloader;
          return this;
        } 
        throw new IllegalStateException("Downloader already set.");
      } 
      throw new IllegalArgumentException("Downloader must not be null.");
    }
    
    public Builder executor(ExecutorService param1ExecutorService) {
      if (param1ExecutorService != null) {
        if (this.service == null) {
          this.service = param1ExecutorService;
          return this;
        } 
        throw new IllegalStateException("Executor service already set.");
      } 
      throw new IllegalArgumentException("Executor service must not be null.");
    }
    
    public Builder indicatorsEnabled(boolean param1Boolean) {
      this.indicatorsEnabled = param1Boolean;
      return this;
    }
    
    public Builder listener(Picasso.Listener param1Listener) {
      if (param1Listener != null) {
        if (this.listener == null) {
          this.listener = param1Listener;
          return this;
        } 
        throw new IllegalStateException("Listener already set.");
      } 
      throw new IllegalArgumentException("Listener must not be null.");
    }
    
    public Builder loggingEnabled(boolean param1Boolean) {
      this.loggingEnabled = param1Boolean;
      return this;
    }
    
    public Builder memoryCache(Cache param1Cache) {
      if (param1Cache != null) {
        if (this.cache == null) {
          this.cache = param1Cache;
          return this;
        } 
        throw new IllegalStateException("Memory cache already set.");
      } 
      throw new IllegalArgumentException("Memory cache must not be null.");
    }
    
    public Builder requestTransformer(Picasso.RequestTransformer param1RequestTransformer) {
      if (param1RequestTransformer != null) {
        if (this.transformer == null) {
          this.transformer = param1RequestTransformer;
          return this;
        } 
        throw new IllegalStateException("Transformer already set.");
      } 
      throw new IllegalArgumentException("Transformer must not be null.");
    }
  }
  
  private static class CleanupThread extends Thread {
    private final Handler handler;
    
    private final ReferenceQueue<Object> referenceQueue;
    
    CleanupThread(ReferenceQueue<Object> param1ReferenceQueue, Handler param1Handler) {
      this.referenceQueue = param1ReferenceQueue;
      this.handler = param1Handler;
      setDaemon(true);
      setName("Picasso-refQueue");
    }
    
    public void run() {
      Process.setThreadPriority(10);
      try {
        while (true) {
          Action.RequestWeakReference requestWeakReference = (Action.RequestWeakReference)this.referenceQueue.remove(1000L);
          Message message = this.handler.obtainMessage();
          if (requestWeakReference != null) {
            message.what = 3;
            message.obj = requestWeakReference.action;
            this.handler.sendMessage(message);
            continue;
          } 
          message.recycle();
        } 
      } catch (InterruptedException interruptedException) {
      
      } catch (Exception exception) {
        this.handler.post(new Runnable() {
              public void run() {
                throw new RuntimeException(e);
              }
            });
      } 
    }
    
    void shutdown() {
      interrupt();
    }
  }
  
  class null implements Runnable {
    public void run() {
      throw new RuntimeException(e);
    }
  }
  
  public static interface Listener {
    void onImageLoadFailed(Picasso param1Picasso, Uri param1Uri, Exception param1Exception);
  }
  
  public enum LoadedFrom {
    DISK,
    MEMORY(-16711936),
    NETWORK(-16711936);
    
    final int debugColor;
    
    static {
      $VALUES = new LoadedFrom[] { MEMORY, DISK, NETWORK };
    }
    
    LoadedFrom(int param1Int1) {
      this.debugColor = param1Int1;
    }
  }
  
  public enum Priority {
    HIGH(-16711936),
    LOW,
    NORMAL;
    
    static {
      $VALUES = new Priority[] { LOW, NORMAL, HIGH };
    }
  }
  
  public static interface RequestTransformer {
    public static final RequestTransformer IDENTITY = new RequestTransformer() {
        public Request transformRequest(Request param2Request) {
          return param2Request;
        }
      };
    
    Request transformRequest(Request param1Request);
  }
  
  static final class null implements RequestTransformer {
    public Request transformRequest(Request param1Request) {
      return param1Request;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\Picasso.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */