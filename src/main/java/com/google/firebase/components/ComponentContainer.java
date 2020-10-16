package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

public interface ComponentContainer {
  <T> T get(Class<T> paramClass);
  
  <T> Provider<T> getProvider(Class<T> paramClass);
  
  <T> Set<T> setOf(Class<T> paramClass);
  
  <T> Provider<Set<T>> setOfProvider(Class<T> paramClass);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\components\ComponentContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */