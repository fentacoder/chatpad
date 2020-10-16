package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component<T> {
  private final Set<Dependency> dependencies;
  
  private final ComponentFactory<T> factory;
  
  private final int instantiation;
  
  private final Set<Class<? super T>> providedInterfaces;
  
  private final Set<Class<?>> publishedEvents;
  
  private final int type;
  
  private Component(Set<Class<? super T>> paramSet, Set<Dependency> paramSet1, int paramInt1, int paramInt2, ComponentFactory<T> paramComponentFactory, Set<Class<?>> paramSet2) {
    this.providedInterfaces = Collections.unmodifiableSet(paramSet);
    this.dependencies = Collections.unmodifiableSet(paramSet1);
    this.instantiation = paramInt1;
    this.type = paramInt2;
    this.factory = paramComponentFactory;
    this.publishedEvents = Collections.unmodifiableSet(paramSet2);
  }
  
  public static <T> Builder<T> builder(Class<T> paramClass) {
    return new Builder<>(paramClass, new Class[0]);
  }
  
  @SafeVarargs
  public static <T> Builder<T> builder(Class<T> paramClass, Class<? super T>... paramVarArgs) {
    return new Builder<>(paramClass, (Class[])paramVarArgs);
  }
  
  public static <T> Component<T> intoSet(T paramT, Class<T> paramClass) {
    return intoSetBuilder(paramClass).factory(Component$$Lambda$3.lambdaFactory$(paramT)).build();
  }
  
  public static <T> Builder<T> intoSetBuilder(Class<T> paramClass) {
    return builder(paramClass).intoSet();
  }
  
  @Deprecated
  public static <T> Component<T> of(Class<T> paramClass, T paramT) {
    return builder(paramClass).factory(Component$$Lambda$1.lambdaFactory$(paramT)).build();
  }
  
  @SafeVarargs
  public static <T> Component<T> of(T paramT, Class<T> paramClass, Class<? super T>... paramVarArgs) {
    return builder(paramClass, paramVarArgs).factory(Component$$Lambda$2.lambdaFactory$(paramT)).build();
  }
  
  public Set<Dependency> getDependencies() {
    return this.dependencies;
  }
  
  public ComponentFactory<T> getFactory() {
    return this.factory;
  }
  
  public Set<Class<? super T>> getProvidedInterfaces() {
    return this.providedInterfaces;
  }
  
  public Set<Class<?>> getPublishedEvents() {
    return this.publishedEvents;
  }
  
  public boolean isAlwaysEager() {
    int i = this.instantiation;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isEagerInDefaultApp() {
    boolean bool;
    if (this.instantiation == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isLazy() {
    boolean bool;
    if (this.instantiation == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isValue() {
    boolean bool;
    if (this.type == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("Component<");
    stringBuilder.append(Arrays.toString(this.providedInterfaces.toArray()));
    stringBuilder.append(">{");
    stringBuilder.append(this.instantiation);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", deps=");
    stringBuilder.append(Arrays.toString(this.dependencies.toArray()));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public static class Builder<T> {
    private final Set<Dependency> dependencies = new HashSet<>();
    
    private ComponentFactory<T> factory;
    
    private int instantiation;
    
    private final Set<Class<? super T>> providedInterfaces = new HashSet<>();
    
    private Set<Class<?>> publishedEvents;
    
    private int type;
    
    @SafeVarargs
    private Builder(Class<T> param1Class, Class<? super T>... param1VarArgs) {
      byte b = 0;
      this.instantiation = 0;
      this.type = 0;
      this.publishedEvents = new HashSet<>();
      Preconditions.checkNotNull(param1Class, "Null interface");
      this.providedInterfaces.add(param1Class);
      int i = param1VarArgs.length;
      while (b < i) {
        Preconditions.checkNotNull(param1VarArgs[b], "Null interface");
        b++;
      } 
      Collections.addAll(this.providedInterfaces, param1VarArgs);
    }
    
    private Builder<T> intoSet() {
      this.type = 1;
      return this;
    }
    
    private Builder<T> setInstantiation(int param1Int) {
      boolean bool;
      if (this.instantiation == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Instantiation type has already been set.");
      this.instantiation = param1Int;
      return this;
    }
    
    private void validateInterface(Class<?> param1Class) {
      Preconditions.checkArgument(this.providedInterfaces.contains(param1Class) ^ true, "Components are not allowed to depend on interfaces they themselves provide.");
    }
    
    public Builder<T> add(Dependency param1Dependency) {
      Preconditions.checkNotNull(param1Dependency, "Null dependency");
      validateInterface(param1Dependency.getInterface());
      this.dependencies.add(param1Dependency);
      return this;
    }
    
    public Builder<T> alwaysEager() {
      return setInstantiation(1);
    }
    
    public Component<T> build() {
      boolean bool;
      if (this.factory != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Missing required property: factory.");
      return new Component<>(new HashSet<>(this.providedInterfaces), new HashSet<>(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
    }
    
    public Builder<T> eagerInDefaultApp() {
      return setInstantiation(2);
    }
    
    public Builder<T> factory(ComponentFactory<T> param1ComponentFactory) {
      this.factory = Preconditions.<ComponentFactory<T>>checkNotNull(param1ComponentFactory, "Null factory");
      return this;
    }
    
    public Builder<T> publishes(Class<?> param1Class) {
      this.publishedEvents.add(param1Class);
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\components\Component.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */