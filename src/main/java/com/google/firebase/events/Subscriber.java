package com.google.firebase.events;

import java.util.concurrent.Executor;

public interface Subscriber {
  <T> void subscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
  
  <T> void subscribe(Class<T> paramClass, Executor paramExecutor, EventHandler<? super T> paramEventHandler);
  
  <T> void unsubscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\events\Subscriber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */