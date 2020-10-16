package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;
import java.util.Iterator;
import java.util.Set;

public final class FieldMask {
  private final Set<FieldPath> mask;
  
  private FieldMask(Set<FieldPath> paramSet) {
    this.mask = paramSet;
  }
  
  public static FieldMask fromSet(Set<FieldPath> paramSet) {
    return new FieldMask(paramSet);
  }
  
  public boolean covers(FieldPath paramFieldPath) {
    Iterator<FieldPath> iterator = this.mask.iterator();
    while (iterator.hasNext()) {
      if (((FieldPath)iterator.next()).isPrefixOf((BasePath)paramFieldPath))
        return true; 
    } 
    return false;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.mask.equals(((FieldMask)paramObject).mask);
  }
  
  public Set<FieldPath> getMask() {
    return this.mask;
  }
  
  public int hashCode() {
    return this.mask.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FieldMask{mask=");
    stringBuilder.append(this.mask.toString());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\FieldMask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */