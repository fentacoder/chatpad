package com.google.firebase.storage;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public abstract class CancellableTask<StateT> extends Task<StateT> {
  public abstract CancellableTask<StateT> addOnProgressListener(Activity paramActivity, OnProgressListener<? super StateT> paramOnProgressListener);
  
  public abstract CancellableTask<StateT> addOnProgressListener(OnProgressListener<? super StateT> paramOnProgressListener);
  
  public abstract CancellableTask<StateT> addOnProgressListener(Executor paramExecutor, OnProgressListener<? super StateT> paramOnProgressListener);
  
  public abstract boolean cancel();
  
  public abstract boolean isCanceled();
  
  public abstract boolean isInProgress();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\CancellableTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */