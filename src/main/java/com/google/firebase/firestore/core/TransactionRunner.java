package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Function;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;

public class TransactionRunner<TResult> {
  private static final int RETRY_COUNT = 5;
  
  private AsyncQueue asyncQueue;
  
  private ExponentialBackoff backoff;
  
  private RemoteStore remoteStore;
  
  private int retriesLeft;
  
  private TaskCompletionSource<TResult> taskSource = new TaskCompletionSource();
  
  private Function<Transaction, Task<TResult>> updateFunction;
  
  public TransactionRunner(AsyncQueue paramAsyncQueue, RemoteStore paramRemoteStore, Function<Transaction, Task<TResult>> paramFunction) {
    this.asyncQueue = paramAsyncQueue;
    this.remoteStore = paramRemoteStore;
    this.updateFunction = paramFunction;
    this.retriesLeft = 5;
    this.backoff = new ExponentialBackoff(paramAsyncQueue, AsyncQueue.TimerId.RETRY_TRANSACTION);
  }
  
  private void handleTransactionError(Task paramTask) {
    if (this.retriesLeft > 0 && isRetryableTransactionError(paramTask.getException())) {
      this.retriesLeft--;
      runWithBackoff();
    } else {
      this.taskSource.setException(paramTask.getException());
    } 
  }
  
  private static boolean isRetryableTransactionError(Exception paramException) {
    boolean bool = paramException instanceof FirebaseFirestoreException;
    boolean bool1 = false;
    null = bool1;
    if (bool) {
      FirebaseFirestoreException firebaseFirestoreException = (FirebaseFirestoreException)paramException;
      FirebaseFirestoreException.Code code = firebaseFirestoreException.getCode();
      if (code != FirebaseFirestoreException.Code.ABORTED && code != FirebaseFirestoreException.Code.FAILED_PRECONDITION) {
        null = bool1;
        return !Datastore.isPermanentError(firebaseFirestoreException.getCode()) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  private void runWithBackoff() {
    this.backoff.backoffAndRun(TransactionRunner$$Lambda$1.lambdaFactory$(this));
  }
  
  public Task<TResult> run() {
    runWithBackoff();
    return this.taskSource.getTask();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\TransactionRunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */