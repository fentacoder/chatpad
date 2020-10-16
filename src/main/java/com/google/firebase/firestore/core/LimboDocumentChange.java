package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;

public class LimboDocumentChange {
  private final DocumentKey key;
  
  private final Type type;
  
  public LimboDocumentChange(Type paramType, DocumentKey paramDocumentKey) {
    this.type = paramType;
    this.key = paramDocumentKey;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof LimboDocumentChange;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.type.equals(paramObject.getType())) {
      bool = bool1;
      if (this.key.equals(paramObject.getKey()))
        bool = true; 
    } 
    return bool;
  }
  
  public DocumentKey getKey() {
    return this.key;
  }
  
  public Type getType() {
    return this.type;
  }
  
  public int hashCode() {
    return (2077 + this.type.hashCode()) * 31 + this.key.hashCode();
  }
  
  public enum Type {
    ADDED, REMOVED;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\LimboDocumentChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */