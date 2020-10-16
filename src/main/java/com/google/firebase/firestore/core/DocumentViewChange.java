package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;

public class DocumentViewChange {
  private final Document document;
  
  private final Type type;
  
  private DocumentViewChange(Type paramType, Document paramDocument) {
    this.type = paramType;
    this.document = paramDocument;
  }
  
  public static DocumentViewChange create(Type paramType, Document paramDocument) {
    return new DocumentViewChange(paramType, paramDocument);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof DocumentViewChange;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.type.equals(((DocumentViewChange)paramObject).type)) {
      bool = bool1;
      if (this.document.equals(((DocumentViewChange)paramObject).document))
        bool = true; 
    } 
    return bool;
  }
  
  public Document getDocument() {
    return this.document;
  }
  
  public Type getType() {
    return this.type;
  }
  
  public int hashCode() {
    return (1891 + this.type.hashCode()) * 31 + this.document.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DocumentViewChange(");
    stringBuilder.append(this.document);
    stringBuilder.append(",");
    stringBuilder.append(this.type);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public enum Type {
    ADDED, METADATA, MODIFIED, REMOVED;
    
    static {
      METADATA = new Type("METADATA", 3);
      $VALUES = new Type[] { REMOVED, ADDED, MODIFIED, METADATA };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\DocumentViewChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */