package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;
import java.util.List;

public final class Bound {
  private final boolean before;
  
  private final List<FieldValue> position;
  
  public Bound(List<FieldValue> paramList, boolean paramBoolean) {
    this.position = paramList;
    this.before = paramBoolean;
  }
  
  public String canonicalString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.before) {
      stringBuilder.append("b:");
    } else {
      stringBuilder.append("a:");
    } 
    Iterator<FieldValue> iterator = this.position.iterator();
    while (iterator.hasNext())
      stringBuilder.append(((FieldValue)iterator.next()).toString()); 
    return stringBuilder.toString();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.before != ((Bound)paramObject).before || !this.position.equals(((Bound)paramObject).position))
      bool = false; 
    return bool;
  }
  
  public List<FieldValue> getPosition() {
    return this.position;
  }
  
  public int hashCode() {
    return this.before * 31 + this.position.hashCode();
  }
  
  public boolean isBefore() {
    return this.before;
  }
  
  public boolean sortsBeforeDocument(List<OrderBy> paramList, Document paramDocument) {
    int i = this.position.size();
    int j = paramList.size();
    boolean bool = true;
    if (i <= j) {
      null = true;
    } else {
      null = false;
    } 
    Assert.hardAssert(null, "Bound has more components than query's orderBy", new Object[0]);
    byte b = 0;
    j = b;
    while (b < this.position.size()) {
      OrderBy orderBy = paramList.get(b);
      FieldValue fieldValue = this.position.get(b);
      if (orderBy.field.equals(FieldPath.KEY_PATH)) {
        Object object = fieldValue.value();
        Assert.hardAssert(object instanceof DocumentKey, "Bound has a non-key value where the key path is being used %s", new Object[] { fieldValue });
        i = ((DocumentKey)object).compareTo(paramDocument.getKey());
      } else {
        FieldValue fieldValue1 = paramDocument.getField(orderBy.getField());
        if (fieldValue1 != null) {
          null = true;
        } else {
          null = false;
        } 
        Assert.hardAssert(null, "Field should exist since document matched the orderBy already.", new Object[0]);
        i = fieldValue.compareTo(fieldValue1);
      } 
      j = i;
      if (orderBy.getDirection().equals(OrderBy.Direction.DESCENDING))
        j = i * -1; 
      if (j != 0)
        break; 
      b++;
    } 
    if (this.before) {
      if (j <= 0)
        return bool; 
    } else if (j < 0) {
      return bool;
    } 
    return false;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bound{before=");
    stringBuilder.append(this.before);
    stringBuilder.append(", position=");
    stringBuilder.append(this.position);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\Bound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */