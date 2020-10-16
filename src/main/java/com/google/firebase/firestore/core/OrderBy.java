package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;

public class OrderBy {
  private final Direction direction;
  
  final FieldPath field;
  
  private OrderBy(Direction paramDirection, FieldPath paramFieldPath) {
    this.direction = paramDirection;
    this.field = paramFieldPath;
  }
  
  public static OrderBy getInstance(Direction paramDirection, FieldPath paramFieldPath) {
    return new OrderBy(paramDirection, paramFieldPath);
  }
  
  int compare(Document paramDocument1, Document paramDocument2) {
    boolean bool;
    if (this.field.equals(FieldPath.KEY_PATH)) {
      int k = this.direction.getComparisonModifier();
      int m = paramDocument1.getKey().compareTo(paramDocument2.getKey());
      return k * m;
    } 
    FieldValue fieldValue1 = paramDocument1.getField(this.field);
    FieldValue fieldValue2 = paramDocument2.getField(this.field);
    if (fieldValue1 != null && fieldValue2 != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Trying to compare documents on fields that don't exist.", new Object[0]);
    int i = this.direction.getComparisonModifier();
    int j = fieldValue1.compareTo(fieldValue2);
    return i * j;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null)
      if (!(paramObject instanceof OrderBy)) {
        bool2 = bool1;
      } else {
        paramObject = paramObject;
        bool2 = bool1;
        if (this.direction == ((OrderBy)paramObject).direction) {
          bool2 = bool1;
          if (this.field.equals(((OrderBy)paramObject).field))
            bool2 = true; 
        } 
      }  
    return bool2;
  }
  
  public Direction getDirection() {
    return this.direction;
  }
  
  public FieldPath getField() {
    return this.field;
  }
  
  public int hashCode() {
    return (899 + this.direction.hashCode()) * 31 + this.field.hashCode();
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.direction == Direction.ASCENDING) {
      str = "";
    } else {
      str = "-";
    } 
    stringBuilder.append(str);
    stringBuilder.append(this.field.canonicalString());
    return stringBuilder.toString();
  }
  
  public enum Direction {
    ASCENDING(1),
    DESCENDING(-1);
    
    private final int comparisonModifier;
    
    static {
    
    }
    
    Direction(int param1Int1) {
      this.comparisonModifier = param1Int1;
    }
    
    int getComparisonModifier() {
      return this.comparisonModifier;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\OrderBy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */