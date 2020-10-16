package com.google.firebase.firestore.model;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePath<B extends BasePath<B>> implements Comparable<B> {
  final List<String> segments;
  
  BasePath(List<String> paramList) {
    this.segments = paramList;
  }
  
  public B append(B paramB) {
    ArrayList<String> arrayList = new ArrayList<>(this.segments);
    arrayList.addAll(((BasePath)paramB).segments);
    return createPathWithSegments(arrayList);
  }
  
  public B append(String paramString) {
    ArrayList<String> arrayList = new ArrayList<>(this.segments);
    arrayList.add(paramString);
    return createPathWithSegments(arrayList);
  }
  
  public abstract String canonicalString();
  
  public int compareTo(B paramB) {
    int i = length();
    int j = paramB.length();
    for (byte b = 0; b < i && b < j; b++) {
      int k = getSegment(b).compareTo(paramB.getSegment(b));
      if (k != 0)
        return k; 
    } 
    return Util.compareIntegers(i, j);
  }
  
  abstract B createPathWithSegments(List<String> paramList);
  
  public final boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof BasePath) || compareTo((B)paramObject) != 0)
      bool = false; 
    return bool;
  }
  
  public String getFirstSegment() {
    return this.segments.get(0);
  }
  
  public String getLastSegment() {
    return this.segments.get(length() - 1);
  }
  
  public String getSegment(int paramInt) {
    return this.segments.get(paramInt);
  }
  
  public int hashCode() {
    return (getClass().hashCode() + 37) * 37 + this.segments.hashCode();
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isImmediateParentOf(B paramB) {
    if (length() + 1 != paramB.length())
      return false; 
    for (byte b = 0; b < length(); b++) {
      if (!getSegment(b).equals(paramB.getSegment(b)))
        return false; 
    } 
    return true;
  }
  
  public boolean isPrefixOf(B paramB) {
    if (length() > paramB.length())
      return false; 
    for (byte b = 0; b < length(); b++) {
      if (!getSegment(b).equals(paramB.getSegment(b)))
        return false; 
    } 
    return true;
  }
  
  public B keepFirst(int paramInt) {
    return createPathWithSegments(this.segments.subList(0, paramInt));
  }
  
  public int length() {
    return this.segments.size();
  }
  
  public B popFirst() {
    return popFirst(1);
  }
  
  public B popFirst(int paramInt) {
    boolean bool;
    int i = length();
    if (i >= paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Can't call popFirst with count > length() (%d > %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    return createPathWithSegments(this.segments.subList(paramInt, i));
  }
  
  public B popLast() {
    return createPathWithSegments(this.segments.subList(0, length() - 1));
  }
  
  public String toString() {
    return canonicalString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\BasePath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */