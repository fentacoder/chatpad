package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.concurrent.Executor;

public class AsyncEventListener<T> implements EventListener<T> {
  private final EventListener<T> eventListener;
  
  private final Executor executor;
  
  private volatile boolean muted = false;
  
  public AsyncEventListener(Executor paramExecutor, EventListener<T> paramEventListener) {
    this.executor = paramExecutor;
    this.eventListener = paramEventListener;
  }
  
  public void mute() {
    this.muted = true;
  }
  
  public void onEvent(T paramT, FirebaseFirestoreException paramFirebaseFirestoreException) {
    this.executor.execute(AsyncEventListener$$Lambda$1.lambdaFactory$(this, paramT, paramFirebaseFirestoreException));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\AsyncEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */