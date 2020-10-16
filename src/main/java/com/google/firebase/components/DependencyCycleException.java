package com.google.firebase.components;

import java.util.List;

public class DependencyCycleException extends DependencyException {
  private final List<Component<?>> componentsInCycle;
  
  public DependencyCycleException(List<Component<?>> paramList) {
    super(stringBuilder.toString());
    this.componentsInCycle = paramList;
  }
  
  public List<Component<?>> getComponentsInCycle() {
    return this.componentsInCycle;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\components\DependencyCycleException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */