package com.google.firebase.database.collection;

import java.util.Comparator;

public class StandardComparator<A extends Comparable<A>> implements Comparator<A> {
  private static StandardComparator INSTANCE = new StandardComparator();
  
  public static <T extends Comparable<T>> StandardComparator<T> getComparator(Class<T> paramClass) {
    return INSTANCE;
  }
  
  public int compare(A paramA1, A paramA2) {
    return paramA1.compareTo(paramA2);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\StandardComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */