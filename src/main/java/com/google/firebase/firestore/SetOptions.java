package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class SetOptions {
  private static final SetOptions MERGE_ALL_FIELDS;
  
  static final SetOptions OVERWRITE = new SetOptions(false, null);
  
  private final FieldMask fieldMask;
  
  private final boolean merge;
  
  static {
    MERGE_ALL_FIELDS = new SetOptions(true, null);
  }
  
  private SetOptions(boolean paramBoolean, FieldMask paramFieldMask) {
    boolean bool;
    if (paramFieldMask == null || paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot specify a fieldMask for non-merge sets()");
    this.merge = paramBoolean;
    this.fieldMask = paramFieldMask;
  }
  
  public static SetOptions merge() {
    return MERGE_ALL_FIELDS;
  }
  
  public static SetOptions mergeFieldPaths(List<FieldPath> paramList) {
    HashSet<FieldPath> hashSet = new HashSet();
    Iterator<FieldPath> iterator = paramList.iterator();
    while (iterator.hasNext())
      hashSet.add(((FieldPath)iterator.next()).getInternalPath()); 
    return new SetOptions(true, FieldMask.fromSet(hashSet));
  }
  
  public static SetOptions mergeFields(List<String> paramList) {
    HashSet<FieldPath> hashSet = new HashSet();
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      hashSet.add(FieldPath.fromDotSeparatedPath(iterator.next()).getInternalPath()); 
    return new SetOptions(true, FieldMask.fromSet(hashSet));
  }
  
  public static SetOptions mergeFields(String... paramVarArgs) {
    HashSet<FieldPath> hashSet = new HashSet();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      hashSet.add(FieldPath.fromDotSeparatedPath(paramVarArgs[b]).getInternalPath()); 
    return new SetOptions(true, FieldMask.fromSet(hashSet));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    SetOptions setOptions = (SetOptions)paramObject;
    if (this.merge != setOptions.merge)
      return false; 
    paramObject = this.fieldMask;
    FieldMask fieldMask = setOptions.fieldMask;
    if (paramObject != null) {
      bool = paramObject.equals(fieldMask);
    } else if (fieldMask != null) {
      bool = false;
    } 
    return bool;
  }
  
  public FieldMask getFieldMask() {
    return this.fieldMask;
  }
  
  public int hashCode() {
    byte b;
    boolean bool = this.merge;
    FieldMask fieldMask = this.fieldMask;
    if (fieldMask != null) {
      b = fieldMask.hashCode();
    } else {
      b = 0;
    } 
    return bool * 31 + b;
  }
  
  boolean isMerge() {
    return this.merge;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\SetOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */