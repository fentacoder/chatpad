package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.internal.ActivityLifecycleListener;
import com.google.firebase.storage.internal.SmartHandler;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

class TaskListenerImpl<ListenerTypeT, ResultT extends StorageTask.ProvideError> {
  private final HashMap<ListenerTypeT, SmartHandler> handlerMap = new HashMap<>();
  
  private final Queue<ListenerTypeT> listenerQueue = new ConcurrentLinkedQueue<>();
  
  private OnRaise<ListenerTypeT, ResultT> onRaise;
  
  private int targetStates;
  
  private StorageTask<ResultT> task;
  
  public TaskListenerImpl(StorageTask<ResultT> paramStorageTask, int paramInt, OnRaise<ListenerTypeT, ResultT> paramOnRaise) {
    this.task = paramStorageTask;
    this.targetStates = paramInt;
    this.onRaise = paramOnRaise;
  }
  
  public void addListener(Activity paramActivity, Executor paramExecutor, ListenerTypeT paramListenerTypeT) {
    Preconditions.checkNotNull(paramListenerTypeT);
    synchronized (this.task.getSyncObject()) {
      int i = this.task.getInternalState();
      int j = this.targetStates;
      boolean bool = true;
      if ((i & j) != 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.listenerQueue.add(paramListenerTypeT);
      SmartHandler smartHandler = new SmartHandler();
      this(paramExecutor);
      this.handlerMap.put(paramListenerTypeT, smartHandler);
      if (paramActivity != null) {
        if (Build.VERSION.SDK_INT >= 17) {
          if (paramActivity.isDestroyed())
            bool = false; 
          Preconditions.checkArgument(bool, "Activity is already destroyed!");
        } 
        ActivityLifecycleListener.getInstance().runOnActivityStopped(paramActivity, paramListenerTypeT, TaskListenerImpl$$Lambda$1.lambdaFactory$(this, paramListenerTypeT));
      } 
      if (i != 0)
        smartHandler.callBack(TaskListenerImpl$$Lambda$2.lambdaFactory$(this, paramListenerTypeT, (StorageTask.ProvideError)this.task.snapState())); 
      return;
    } 
  }
  
  public int getListenerCount() {
    return Math.max(this.listenerQueue.size(), this.handlerMap.size());
  }
  
  public void onInternalStateChanged() {
    // Byte code:
    //   0: aload_0
    //   1: getfield task : Lcom/google/firebase/storage/StorageTask;
    //   4: invokevirtual getInternalState : ()I
    //   7: aload_0
    //   8: getfield targetStates : I
    //   11: iand
    //   12: ifeq -> 81
    //   15: aload_0
    //   16: getfield task : Lcom/google/firebase/storage/StorageTask;
    //   19: invokevirtual snapState : ()Lcom/google/firebase/storage/StorageTask$ProvideError;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield listenerQueue : Ljava/util/Queue;
    //   27: invokeinterface iterator : ()Ljava/util/Iterator;
    //   32: astore_2
    //   33: aload_2
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 81
    //   42: aload_2
    //   43: invokeinterface next : ()Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_0
    //   50: getfield handlerMap : Ljava/util/HashMap;
    //   53: aload_3
    //   54: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast com/google/firebase/storage/internal/SmartHandler
    //   60: astore #4
    //   62: aload #4
    //   64: ifnull -> 33
    //   67: aload #4
    //   69: aload_0
    //   70: aload_3
    //   71: aload_1
    //   72: invokestatic lambdaFactory$ : (Lcom/google/firebase/storage/TaskListenerImpl;Ljava/lang/Object;Lcom/google/firebase/storage/StorageTask$ProvideError;)Ljava/lang/Runnable;
    //   75: invokevirtual callBack : (Ljava/lang/Runnable;)V
    //   78: goto -> 33
    //   81: return
  }
  
  public void removeListener(ListenerTypeT paramListenerTypeT) {
    Preconditions.checkNotNull(paramListenerTypeT);
    synchronized (this.task.getSyncObject()) {
      this.handlerMap.remove(paramListenerTypeT);
      this.listenerQueue.remove(paramListenerTypeT);
      ActivityLifecycleListener.getInstance().removeCookie(paramListenerTypeT);
      return;
    } 
  }
  
  static interface OnRaise<ListenerTypeT, ResultT> {
    void raise(ListenerTypeT param1ListenerTypeT, ResultT param1ResultT);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\TaskListenerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */