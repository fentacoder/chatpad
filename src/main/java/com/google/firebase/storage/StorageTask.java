package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

public abstract class StorageTask<ResultT extends StorageTask.ProvideError> extends ControllableTask<ResultT> {
  static final int INTERNAL_STATE_CANCELED = 256;
  
  static final int INTERNAL_STATE_CANCELING = 32;
  
  static final int INTERNAL_STATE_FAILURE = 64;
  
  static final int INTERNAL_STATE_IN_PROGRESS = 4;
  
  static final int INTERNAL_STATE_NOT_STARTED = 1;
  
  static final int INTERNAL_STATE_PAUSED = 16;
  
  static final int INTERNAL_STATE_PAUSING = 8;
  
  static final int INTERNAL_STATE_QUEUED = 2;
  
  static final int INTERNAL_STATE_SUCCESS = 128;
  
  static final int STATES_CANCELED = 256;
  
  static final int STATES_COMPLETE = 448;
  
  static final int STATES_FAILURE = 64;
  
  static final int STATES_INPROGRESS = -465;
  
  static final int STATES_PAUSED = 16;
  
  static final int STATES_SUCCESS = 128;
  
  private static final String TAG = "StorageTask";
  
  private static final HashMap<Integer, HashSet<Integer>> ValidTaskInitiatedStateChanges;
  
  private static final HashMap<Integer, HashSet<Integer>> ValidUserInitiatedStateChanges = new HashMap<>();
  
  final TaskListenerImpl<OnCanceledListener, ResultT> cancelManager = new TaskListenerImpl<>(this, 256, StorageTask$$Lambda$6.lambdaFactory$(this));
  
  final TaskListenerImpl<OnCompleteListener<ResultT>, ResultT> completeListener = new TaskListenerImpl<>(this, 448, StorageTask$$Lambda$5.lambdaFactory$(this));
  
  private volatile int currentState = 1;
  
  final TaskListenerImpl<OnFailureListener, ResultT> failureManager = new TaskListenerImpl<>(this, 64, StorageTask$$Lambda$4.lambdaFactory$(this));
  
  private ResultT finalResult;
  
  final TaskListenerImpl<OnPausedListener<? super ResultT>, ResultT> pausedManager = new TaskListenerImpl<>(this, 16, StorageTask$$Lambda$8.lambdaFactory$());
  
  final TaskListenerImpl<OnProgressListener<? super ResultT>, ResultT> progressManager = new TaskListenerImpl<>(this, -465, StorageTask$$Lambda$7.lambdaFactory$());
  
  final TaskListenerImpl<OnSuccessListener<? super ResultT>, ResultT> successManager = new TaskListenerImpl<>(this, 128, StorageTask$$Lambda$1.lambdaFactory$(this));
  
  protected final Object syncObject = new Object();
  
  static {
    ValidTaskInitiatedStateChanges = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> hashMap1 = ValidUserInitiatedStateChanges;
    Integer integer2 = Integer.valueOf(2);
    Integer integer3 = Integer.valueOf(16);
    Integer integer4 = Integer.valueOf(256);
    hashMap1.put(Integer.valueOf(1), new HashSet<>(Arrays.asList(new Integer[] { integer3, integer4 })));
    HashMap<Integer, HashSet<Integer>> hashMap2 = ValidUserInitiatedStateChanges;
    Integer integer1 = Integer.valueOf(8);
    hashMap2.put(integer2, new HashSet<>(Arrays.asList(new Integer[] { integer1, Integer.valueOf(32) })));
    HashMap<Integer, HashSet<Integer>> hashMap3 = ValidUserInitiatedStateChanges;
    Integer integer5 = Integer.valueOf(4);
    hashMap3.put(integer5, new HashSet<>(Arrays.asList(new Integer[] { integer1, Integer.valueOf(32) })));
    ValidUserInitiatedStateChanges.put(integer3, new HashSet<>(Arrays.asList(new Integer[] { integer2, integer4 })));
    HashMap<Integer, HashSet<Integer>> hashMap4 = ValidUserInitiatedStateChanges;
    Integer integer6 = Integer.valueOf(64);
    hashMap4.put(integer6, new HashSet<>(Arrays.asList(new Integer[] { integer2, integer4 })));
    ValidTaskInitiatedStateChanges.put(Integer.valueOf(1), new HashSet<>(Arrays.asList(new Integer[] { integer2, integer6 })));
    hashMap4 = ValidTaskInitiatedStateChanges;
    Integer integer7 = Integer.valueOf(128);
    hashMap4.put(integer2, new HashSet<>(Arrays.asList(new Integer[] { integer5, integer6, integer7 })));
    ValidTaskInitiatedStateChanges.put(integer5, new HashSet<>(Arrays.asList(new Integer[] { integer5, integer6, integer7 })));
    ValidTaskInitiatedStateChanges.put(integer1, new HashSet<>(Arrays.asList(new Integer[] { integer3, integer6, integer7 })));
    ValidTaskInitiatedStateChanges.put(Integer.valueOf(32), new HashSet<>(Arrays.asList(new Integer[] { integer4, integer6, integer7 })));
  }
  
  private <ContinuationResultT> Task<ContinuationResultT> continueWithImpl(Executor paramExecutor, Continuation<ResultT, ContinuationResultT> paramContinuation) {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.completeListener.addListener(null, paramExecutor, StorageTask$$Lambda$9.lambdaFactory$(this, paramContinuation, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  private <ContinuationResultT> Task<ContinuationResultT> continueWithTaskImpl(Executor paramExecutor, Continuation<ResultT, Task<ContinuationResultT>> paramContinuation) {
    CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
    this.completeListener.addListener(null, paramExecutor, StorageTask$$Lambda$10.lambdaFactory$(this, paramContinuation, taskCompletionSource, cancellationTokenSource));
    return taskCompletionSource.getTask();
  }
  
  private void ensureFinalState() {
    if (!isComplete() && !isPaused() && getInternalState() != 2 && !tryChangeState(256, false))
      tryChangeState(64, false); 
  }
  
  private ResultT getFinalResult() {
    ResultT resultT = this.finalResult;
    if (resultT != null)
      return resultT; 
    if (!isComplete())
      return null; 
    if (this.finalResult == null)
      this.finalResult = snapState(); 
    return this.finalResult;
  }
  
  private String getStateString(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 4) ? ((paramInt != 8) ? ((paramInt != 16) ? ((paramInt != 32) ? ((paramInt != 64) ? ((paramInt != 128) ? ((paramInt != 256) ? "Unknown Internal State!" : "INTERNAL_STATE_CANCELED") : "INTERNAL_STATE_SUCCESS") : "INTERNAL_STATE_FAILURE") : "INTERNAL_STATE_CANCELING") : "INTERNAL_STATE_PAUSED") : "INTERNAL_STATE_PAUSING") : "INTERNAL_STATE_IN_PROGRESS") : "INTERNAL_STATE_QUEUED") : "INTERNAL_STATE_NOT_STARTED";
  }
  
  private String getStateString(int[] paramArrayOfint) {
    if (paramArrayOfint.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i; b++) {
      stringBuilder.append(getStateString(paramArrayOfint[b]));
      stringBuilder.append(", ");
    } 
    return stringBuilder.substring(0, stringBuilder.length() - 2);
  }
  
  private <ContinuationResultT> Task<ContinuationResultT> successTaskImpl(Executor paramExecutor, SuccessContinuation<ResultT, ContinuationResultT> paramSuccessContinuation) {
    CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
    this.successManager.addListener(null, paramExecutor, StorageTask$$Lambda$11.lambdaFactory$(paramSuccessContinuation, taskCompletionSource, cancellationTokenSource));
    return taskCompletionSource.getTask();
  }
  
  public StorageTask<ResultT> addOnCanceledListener(Activity paramActivity, OnCanceledListener paramOnCanceledListener) {
    Preconditions.checkNotNull(paramOnCanceledListener);
    Preconditions.checkNotNull(paramActivity);
    this.cancelManager.addListener(paramActivity, null, paramOnCanceledListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnCanceledListener(OnCanceledListener paramOnCanceledListener) {
    Preconditions.checkNotNull(paramOnCanceledListener);
    this.cancelManager.addListener(null, null, paramOnCanceledListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnCanceledListener(Executor paramExecutor, OnCanceledListener paramOnCanceledListener) {
    Preconditions.checkNotNull(paramOnCanceledListener);
    Preconditions.checkNotNull(paramExecutor);
    this.cancelManager.addListener(null, paramExecutor, paramOnCanceledListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnCompleteListener(Activity paramActivity, OnCompleteListener<ResultT> paramOnCompleteListener) {
    Preconditions.checkNotNull(paramOnCompleteListener);
    Preconditions.checkNotNull(paramActivity);
    this.completeListener.addListener(paramActivity, null, paramOnCompleteListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> paramOnCompleteListener) {
    Preconditions.checkNotNull(paramOnCompleteListener);
    this.completeListener.addListener(null, null, paramOnCompleteListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnCompleteListener(Executor paramExecutor, OnCompleteListener<ResultT> paramOnCompleteListener) {
    Preconditions.checkNotNull(paramOnCompleteListener);
    Preconditions.checkNotNull(paramExecutor);
    this.completeListener.addListener(null, paramExecutor, paramOnCompleteListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnFailureListener(Activity paramActivity, OnFailureListener paramOnFailureListener) {
    Preconditions.checkNotNull(paramOnFailureListener);
    Preconditions.checkNotNull(paramActivity);
    this.failureManager.addListener(paramActivity, null, paramOnFailureListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnFailureListener(OnFailureListener paramOnFailureListener) {
    Preconditions.checkNotNull(paramOnFailureListener);
    this.failureManager.addListener(null, null, paramOnFailureListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnFailureListener(Executor paramExecutor, OnFailureListener paramOnFailureListener) {
    Preconditions.checkNotNull(paramOnFailureListener);
    Preconditions.checkNotNull(paramExecutor);
    this.failureManager.addListener(null, paramExecutor, paramOnFailureListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnPausedListener(Activity paramActivity, OnPausedListener<? super ResultT> paramOnPausedListener) {
    Preconditions.checkNotNull(paramOnPausedListener);
    Preconditions.checkNotNull(paramActivity);
    this.pausedManager.addListener(paramActivity, null, paramOnPausedListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnPausedListener(OnPausedListener<? super ResultT> paramOnPausedListener) {
    Preconditions.checkNotNull(paramOnPausedListener);
    this.pausedManager.addListener(null, null, paramOnPausedListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnPausedListener(Executor paramExecutor, OnPausedListener<? super ResultT> paramOnPausedListener) {
    Preconditions.checkNotNull(paramOnPausedListener);
    Preconditions.checkNotNull(paramExecutor);
    this.pausedManager.addListener(null, paramExecutor, paramOnPausedListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnProgressListener(Activity paramActivity, OnProgressListener<? super ResultT> paramOnProgressListener) {
    Preconditions.checkNotNull(paramOnProgressListener);
    Preconditions.checkNotNull(paramActivity);
    this.progressManager.addListener(paramActivity, null, paramOnProgressListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnProgressListener(OnProgressListener<? super ResultT> paramOnProgressListener) {
    Preconditions.checkNotNull(paramOnProgressListener);
    this.progressManager.addListener(null, null, paramOnProgressListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnProgressListener(Executor paramExecutor, OnProgressListener<? super ResultT> paramOnProgressListener) {
    Preconditions.checkNotNull(paramOnProgressListener);
    Preconditions.checkNotNull(paramExecutor);
    this.progressManager.addListener(null, paramExecutor, paramOnProgressListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnSuccessListener(Activity paramActivity, OnSuccessListener<? super ResultT> paramOnSuccessListener) {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramOnSuccessListener);
    this.successManager.addListener(paramActivity, null, paramOnSuccessListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> paramOnSuccessListener) {
    Preconditions.checkNotNull(paramOnSuccessListener);
    this.successManager.addListener(null, null, paramOnSuccessListener);
    return this;
  }
  
  public StorageTask<ResultT> addOnSuccessListener(Executor paramExecutor, OnSuccessListener<? super ResultT> paramOnSuccessListener) {
    Preconditions.checkNotNull(paramExecutor);
    Preconditions.checkNotNull(paramOnSuccessListener);
    this.successManager.addListener(null, paramExecutor, paramOnSuccessListener);
    return this;
  }
  
  public boolean cancel() {
    return tryChangeState(new int[] { 256, 32 }, true);
  }
  
  public <ContinuationResultT> Task<ContinuationResultT> continueWith(Continuation<ResultT, ContinuationResultT> paramContinuation) {
    return continueWithImpl(null, paramContinuation);
  }
  
  public <ContinuationResultT> Task<ContinuationResultT> continueWith(Executor paramExecutor, Continuation<ResultT, ContinuationResultT> paramContinuation) {
    return continueWithImpl(paramExecutor, paramContinuation);
  }
  
  public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Continuation<ResultT, Task<ContinuationResultT>> paramContinuation) {
    return continueWithTaskImpl(null, paramContinuation);
  }
  
  public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Executor paramExecutor, Continuation<ResultT, Task<ContinuationResultT>> paramContinuation) {
    return continueWithTaskImpl(paramExecutor, paramContinuation);
  }
  
  public Exception getException() {
    return (getFinalResult() == null) ? null : getFinalResult().getError();
  }
  
  int getInternalState() {
    return this.currentState;
  }
  
  public ResultT getResult() {
    if (getFinalResult() != null) {
      Exception exception = getFinalResult().getError();
      if (exception == null)
        return getFinalResult(); 
      throw new RuntimeExecutionException(exception);
    } 
    throw new IllegalStateException();
  }
  
  public <X extends Throwable> ResultT getResult(Class<X> paramClass) throws X {
    if (getFinalResult() != null) {
      Exception exception;
      if (!paramClass.isInstance(getFinalResult().getError())) {
        exception = getFinalResult().getError();
        if (exception == null)
          return getFinalResult(); 
        throw (X)new RuntimeExecutionException(exception);
      } 
      throw (X)exception.cast(getFinalResult().getError());
    } 
    throw (X)new IllegalStateException();
  }
  
  Runnable getRunnable() {
    return StorageTask$$Lambda$12.lambdaFactory$(this);
  }
  
  public ResultT getSnapshot() {
    return snapState();
  }
  
  abstract StorageReference getStorage();
  
  Object getSyncObject() {
    return this.syncObject;
  }
  
  public boolean isCanceled() {
    boolean bool;
    if (getInternalState() == 256) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isComplete() {
    boolean bool;
    if ((getInternalState() & 0x1C0) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isInProgress() {
    boolean bool;
    if ((getInternalState() & 0xFFFFFE2F) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isPaused() {
    boolean bool;
    if ((getInternalState() & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isSuccessful() {
    boolean bool;
    if ((getInternalState() & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected void onCanceled() {}
  
  protected void onFailure() {}
  
  protected void onPaused() {}
  
  protected void onProgress() {}
  
  protected void onQueued() {}
  
  protected void onSuccess() {}
  
  public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(SuccessContinuation<ResultT, ContinuationResultT> paramSuccessContinuation) {
    return successTaskImpl(null, paramSuccessContinuation);
  }
  
  public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(Executor paramExecutor, SuccessContinuation<ResultT, ContinuationResultT> paramSuccessContinuation) {
    return successTaskImpl(paramExecutor, paramSuccessContinuation);
  }
  
  public boolean pause() {
    return tryChangeState(new int[] { 16, 8 }, true);
  }
  
  boolean queue() {
    boolean bool = false;
    if (tryChangeState(2, false)) {
      schedule();
      bool = true;
    } 
    return bool;
  }
  
  public StorageTask<ResultT> removeOnCanceledListener(OnCanceledListener paramOnCanceledListener) {
    Preconditions.checkNotNull(paramOnCanceledListener);
    this.cancelManager.removeListener(paramOnCanceledListener);
    return this;
  }
  
  public StorageTask<ResultT> removeOnCompleteListener(OnCompleteListener<ResultT> paramOnCompleteListener) {
    Preconditions.checkNotNull(paramOnCompleteListener);
    this.completeListener.removeListener(paramOnCompleteListener);
    return this;
  }
  
  public StorageTask<ResultT> removeOnFailureListener(OnFailureListener paramOnFailureListener) {
    Preconditions.checkNotNull(paramOnFailureListener);
    this.failureManager.removeListener(paramOnFailureListener);
    return this;
  }
  
  public StorageTask<ResultT> removeOnPausedListener(OnPausedListener<? super ResultT> paramOnPausedListener) {
    Preconditions.checkNotNull(paramOnPausedListener);
    this.pausedManager.removeListener(paramOnPausedListener);
    return this;
  }
  
  public StorageTask<ResultT> removeOnProgressListener(OnProgressListener<? super ResultT> paramOnProgressListener) {
    Preconditions.checkNotNull(paramOnProgressListener);
    this.progressManager.removeListener(paramOnProgressListener);
    return this;
  }
  
  public StorageTask<ResultT> removeOnSuccessListener(OnSuccessListener<? super ResultT> paramOnSuccessListener) {
    Preconditions.checkNotNull(paramOnSuccessListener);
    this.successManager.removeListener(paramOnSuccessListener);
    return this;
  }
  
  void resetState() {}
  
  public boolean resume() {
    if (tryChangeState(2, true)) {
      resetState();
      schedule();
      return true;
    } 
    return false;
  }
  
  abstract void run();
  
  abstract void schedule();
  
  ResultT snapState() {
    synchronized (this.syncObject) {
      return snapStateImpl();
    } 
  }
  
  abstract ResultT snapStateImpl();
  
  boolean tryChangeState(int paramInt, boolean paramBoolean) {
    return tryChangeState(new int[] { paramInt }, paramBoolean);
  }
  
  boolean tryChangeState(int[] paramArrayOfint, boolean paramBoolean) {
    HashMap<Integer, HashSet<Integer>> hashMap;
    if (paramBoolean) {
      hashMap = ValidUserInitiatedStateChanges;
    } else {
      hashMap = ValidTaskInitiatedStateChanges;
    } 
    synchronized (this.syncObject) {
      StringBuilder stringBuilder1;
      int i = paramArrayOfint.length;
      for (int j = 0; j < i; j++) {
        int k = paramArrayOfint[j];
        HashSet hashSet = hashMap.get(Integer.valueOf(getInternalState()));
        if (hashSet != null && hashSet.contains(Integer.valueOf(k))) {
          this.currentState = k;
          j = this.currentState;
          if (j != 2) {
            if (j != 4) {
              if (j != 16) {
                if (j != 64) {
                  if (j != 128) {
                    if (j == 256)
                      onCanceled(); 
                  } else {
                    onSuccess();
                  } 
                } else {
                  onFailure();
                } 
              } else {
                onPaused();
              } 
            } else {
              onProgress();
            } 
          } else {
            StorageTaskManager.getInstance().ensureRegistered(this);
            onQueued();
          } 
          this.successManager.onInternalStateChanged();
          this.failureManager.onInternalStateChanged();
          this.cancelManager.onInternalStateChanged();
          this.completeListener.onInternalStateChanged();
          this.pausedManager.onInternalStateChanged();
          this.progressManager.onInternalStateChanged();
          if (Log.isLoggable("StorageTask", 3)) {
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append("changed internal state to: ");
            stringBuilder1.append(getStateString(k));
            stringBuilder1.append(" isUser: ");
            stringBuilder1.append(paramBoolean);
            stringBuilder1.append(" from state:");
            stringBuilder1.append(getStateString(this.currentState));
            Log.d("StorageTask", stringBuilder1.toString());
          } 
          return true;
        } 
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append("unable to change internal state to: ");
      stringBuilder2.append(getStateString((int[])stringBuilder1));
      stringBuilder2.append(" isUser: ");
      stringBuilder2.append(paramBoolean);
      stringBuilder2.append(" from state:");
      stringBuilder2.append(getStateString(this.currentState));
      Log.w("StorageTask", stringBuilder2.toString());
      return false;
    } 
  }
  
  protected static interface ProvideError {
    Exception getError();
  }
  
  public class SnapshotBase implements ProvideError {
    private final Exception error;
    
    public SnapshotBase(Exception param1Exception) {
      if (param1Exception == null) {
        if (StorageTask.this.isCanceled()) {
          this.error = (Exception)StorageException.fromErrorStatus(Status.RESULT_CANCELED);
        } else if (StorageTask.this.getInternalState() == 64) {
          this.error = (Exception)StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR);
        } else {
          this.error = null;
        } 
      } else {
        this.error = param1Exception;
      } 
    }
    
    public Exception getError() {
      return this.error;
    }
    
    public StorageReference getStorage() {
      return getTask().getStorage();
    }
    
    public StorageTask<ResultT> getTask() {
      return StorageTask.this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */