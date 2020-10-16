package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.util.Assert;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class DocumentKey implements Comparable<DocumentKey> {
  private static final Comparator<DocumentKey> COMPARATOR = DocumentKey$$Lambda$1.lambdaFactory$();
  
  private static final ImmutableSortedSet<DocumentKey> EMPTY_KEY_SET = new ImmutableSortedSet(Collections.emptyList(), COMPARATOR);
  
  public static final String KEY_FIELD_NAME = "__name__";
  
  private final ResourcePath path;
  
  private DocumentKey(ResourcePath paramResourcePath) {
    Assert.hardAssert(isDocumentKey(paramResourcePath), "Not a document key path: %s", new Object[] { paramResourcePath });
    this.path = paramResourcePath;
  }
  
  public static Comparator<DocumentKey> comparator() {
    return COMPARATOR;
  }
  
  public static DocumentKey empty() {
    return fromSegments(Collections.emptyList());
  }
  
  public static ImmutableSortedSet<DocumentKey> emptyKeySet() {
    return EMPTY_KEY_SET;
  }
  
  public static DocumentKey fromPath(ResourcePath paramResourcePath) {
    return new DocumentKey(paramResourcePath);
  }
  
  public static DocumentKey fromPathString(String paramString) {
    return new DocumentKey(ResourcePath.fromString(paramString));
  }
  
  public static DocumentKey fromSegments(List<String> paramList) {
    return new DocumentKey(ResourcePath.fromSegments(paramList));
  }
  
  public static boolean isDocumentKey(ResourcePath paramResourcePath) {
    boolean bool;
    if (paramResourcePath.length() % 2 == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int compareTo(DocumentKey paramDocumentKey) {
    return this.path.compareTo(paramDocumentKey.path);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.path.equals(((DocumentKey)paramObject).path);
  }
  
  public ResourcePath getPath() {
    return this.path;
  }
  
  public boolean hasCollectionId(String paramString) {
    boolean bool;
    if (this.path.length() >= 2 && ((String)this.path.segments.get(this.path.length() - 2)).equals(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.path.hashCode();
  }
  
  public String toString() {
    return this.path.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\DocumentKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */