package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;

public abstract class Filter {
  public abstract String getCanonicalId();
  
  public abstract FieldPath getField();
  
  public abstract boolean matches(Document paramDocument);
  
  public enum Operator {
    ARRAY_CONTAINS,
    ARRAY_CONTAINS_ANY,
    EQUAL,
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL,
    IN,
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<=");
    
    private final String text;
    
    static {
      ARRAY_CONTAINS = new Operator("ARRAY_CONTAINS", 5, "array_contains");
      ARRAY_CONTAINS_ANY = new Operator("ARRAY_CONTAINS_ANY", 6, "array_contains_any");
      IN = new Operator("IN", 7, "in");
      $VALUES = new Operator[] { LESS_THAN, LESS_THAN_OR_EQUAL, EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, ARRAY_CONTAINS, ARRAY_CONTAINS_ANY, IN };
    }
    
    Operator(String param1String1) {
      this.text = param1String1;
    }
    
    public String toString() {
      return this.text;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\Filter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */