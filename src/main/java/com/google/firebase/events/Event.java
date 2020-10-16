package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

public class Event<T> {
  private final T payload;
  
  private final Class<T> type;
  
  public Event(Class<T> paramClass, T paramT) {
    this.type = (Class<T>)Preconditions.checkNotNull(paramClass);
    this.payload = (T)Preconditions.checkNotNull(paramT);
  }
  
  public T getPayload() {
    return this.payload;
  }
  
  public Class<T> getType() {
    return this.type;
  }
  
  public String toString() {
    return String.format("Event{type: %s, payload: %s}", new Object[] { this.type, this.payload });
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\events\Event.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */