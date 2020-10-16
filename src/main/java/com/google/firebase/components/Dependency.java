package com.google.firebase.components;

public final class Dependency {
  private final Class<?> anInterface;
  
  private final int injection;
  
  private final int type;
  
  private Dependency(Class<?> paramClass, int paramInt1, int paramInt2) {
    this.anInterface = Preconditions.<Class<?>>checkNotNull(paramClass, "Null dependency anInterface.");
    this.type = paramInt1;
    this.injection = paramInt2;
  }
  
  public static Dependency optional(Class<?> paramClass) {
    return new Dependency(paramClass, 0, 0);
  }
  
  public static Dependency optionalProvider(Class<?> paramClass) {
    return new Dependency(paramClass, 0, 1);
  }
  
  public static Dependency required(Class<?> paramClass) {
    return new Dependency(paramClass, 1, 0);
  }
  
  public static Dependency requiredProvider(Class<?> paramClass) {
    return new Dependency(paramClass, 1, 1);
  }
  
  public static Dependency setOf(Class<?> paramClass) {
    return new Dependency(paramClass, 2, 0);
  }
  
  public static Dependency setOfProvider(Class<?> paramClass) {
    return new Dependency(paramClass, 2, 1);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Dependency;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (bool) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.anInterface == ((Dependency)paramObject).anInterface) {
        bool2 = bool1;
        if (this.type == ((Dependency)paramObject).type) {
          bool2 = bool1;
          if (this.injection == ((Dependency)paramObject).injection)
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
  
  public Class<?> getInterface() {
    return this.anInterface;
  }
  
  public int hashCode() {
    return ((this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ this.type) * 1000003 ^ this.injection;
  }
  
  public boolean isDirectInjection() {
    boolean bool;
    if (this.injection == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isRequired() {
    int i = this.type;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isSet() {
    boolean bool;
    if (this.type == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder("Dependency{anInterface=");
    stringBuilder.append(this.anInterface);
    stringBuilder.append(", type=");
    int i = this.type;
    boolean bool = true;
    if (i == 1) {
      str = "required";
    } else if (i == 0) {
      str = "optional";
    } else {
      str = "set";
    } 
    stringBuilder.append(str);
    stringBuilder.append(", direct=");
    if (this.injection != 0)
      bool = false; 
    stringBuilder.append(bool);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\components\Dependency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */