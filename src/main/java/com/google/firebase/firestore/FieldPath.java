package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.FieldPath;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class FieldPath {
  private static final FieldPath DOCUMENT_ID_INSTANCE;
  
  private static final Pattern RESERVED = Pattern.compile("[~*/\\[\\]]");
  
  private final FieldPath internalPath;
  
  static {
    DOCUMENT_ID_INSTANCE = new FieldPath(FieldPath.KEY_PATH);
  }
  
  private FieldPath(FieldPath paramFieldPath) {
    this.internalPath = paramFieldPath;
  }
  
  private FieldPath(List<String> paramList) {
    this.internalPath = FieldPath.fromSegments(paramList);
  }
  
  public static FieldPath documentId() {
    return DOCUMENT_ID_INSTANCE;
  }
  
  static FieldPath fromDotSeparatedPath(String paramString) {
    Preconditions.checkNotNull(paramString, "Provided field path must not be null.");
    Preconditions.checkArgument(RESERVED.matcher(paramString).find() ^ true, "Use FieldPath.of() for field names containing '~*/[]'.");
    try {
      return of(paramString.split("\\.", -1));
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid field path (");
      stringBuilder.append(paramString);
      stringBuilder.append("). Paths must not be empty, begin with '.', end with '.', or contain '..'");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public static FieldPath of(String... paramVarArgs) {
    boolean bool;
    if (paramVarArgs.length > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid field path. Provided path must not be empty.");
    byte b = 0;
    while (b < paramVarArgs.length) {
      if (paramVarArgs[b] != null && !paramVarArgs[b].isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid field name at argument ");
      stringBuilder.append(++b);
      stringBuilder.append(". Field names must not be null or empty.");
      Preconditions.checkArgument(bool, stringBuilder.toString());
    } 
    return new FieldPath(Arrays.asList(paramVarArgs));
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.internalPath.equals(((FieldPath)paramObject).internalPath);
  }
  
  FieldPath getInternalPath() {
    return this.internalPath;
  }
  
  public int hashCode() {
    return this.internalPath.hashCode();
  }
  
  public String toString() {
    return this.internalPath.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FieldPath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */