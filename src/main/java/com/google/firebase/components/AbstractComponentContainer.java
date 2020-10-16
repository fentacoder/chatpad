package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

abstract class AbstractComponentContainer implements ComponentContainer {
  public <T> T get(Class<T> paramClass) {
    Provider<T> provider = getProvider(paramClass);
    return (T)((provider == null) ? null : provider.get());
  }
  
  public <T> Set<T> setOf(Class<T> paramClass) {
    return (Set<T>)setOfProvider(paramClass).get();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\components\AbstractComponentContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */