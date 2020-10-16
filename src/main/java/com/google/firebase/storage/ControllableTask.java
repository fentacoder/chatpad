package com.google.firebase.storage;

import android.app.Activity;
import java.util.concurrent.Executor;

public abstract class ControllableTask<StateT> extends CancellableTask<StateT> {
  public abstract ControllableTask<StateT> addOnPausedListener(Activity paramActivity, OnPausedListener<? super StateT> paramOnPausedListener);
  
  public abstract ControllableTask<StateT> addOnPausedListener(OnPausedListener<? super StateT> paramOnPausedListener);
  
  public abstract ControllableTask<StateT> addOnPausedListener(Executor paramExecutor, OnPausedListener<? super StateT> paramOnPausedListener);
  
  public abstract boolean isPaused();
  
  public abstract boolean pause();
  
  public abstract boolean resume();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\ControllableTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */