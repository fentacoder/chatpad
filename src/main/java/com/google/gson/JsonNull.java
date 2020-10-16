package com.google.gson;

public final class JsonNull extends JsonElement {
  public static final JsonNull INSTANCE = new JsonNull();
  
  JsonNull deepCopy() {
    return INSTANCE;
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject || paramObject instanceof JsonNull);
  }
  
  public int hashCode() {
    return JsonNull.class.hashCode();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\gson\JsonNull.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */