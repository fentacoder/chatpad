package com.google.firebase.database.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class ImmutableSortedMap<K, V> implements Iterable<Map.Entry<K, V>> {
  public abstract boolean containsKey(K paramK);
  
  public boolean equals(Object<Map.Entry<K, V>> paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ImmutableSortedMap))
      return false; 
    ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap)paramObject;
    if (!getComparator().equals(immutableSortedMap.getComparator()))
      return false; 
    if (size() != immutableSortedMap.size())
      return false; 
    paramObject = (Object<Map.Entry<K, V>>)iterator();
    Iterator iterator = immutableSortedMap.iterator();
    while (paramObject.hasNext()) {
      if (!((Map.Entry)paramObject.next()).equals(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public abstract V get(K paramK);
  
  public abstract Comparator<K> getComparator();
  
  public abstract K getMaxKey();
  
  public abstract K getMinKey();
  
  public abstract K getPredecessorKey(K paramK);
  
  public abstract K getSuccessorKey(K paramK);
  
  public int hashCode() {
    int i = getComparator().hashCode();
    Iterator<Map.Entry<K, V>> iterator = iterator();
    while (iterator.hasNext())
      i = i * 31 + ((Map.Entry)iterator.next()).hashCode(); 
    return i;
  }
  
  public abstract void inOrderTraversal(LLRBNode.NodeVisitor<K, V> paramNodeVisitor);
  
  public abstract int indexOf(K paramK);
  
  public abstract ImmutableSortedMap<K, V> insert(K paramK, V paramV);
  
  public abstract boolean isEmpty();
  
  public abstract Iterator<Map.Entry<K, V>> iterator();
  
  public abstract Iterator<Map.Entry<K, V>> iteratorFrom(K paramK);
  
  public abstract ImmutableSortedMap<K, V> remove(K paramK);
  
  public abstract Iterator<Map.Entry<K, V>> reverseIterator();
  
  public abstract Iterator<Map.Entry<K, V>> reverseIteratorFrom(K paramK);
  
  public abstract int size();
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("{");
    Iterator<Map.Entry<K, V>> iterator = iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (bool) {
        bool = false;
      } else {
        stringBuilder.append(", ");
      } 
      stringBuilder.append("(");
      stringBuilder.append(entry.getKey());
      stringBuilder.append("=>");
      stringBuilder.append(entry.getValue());
      stringBuilder.append(")");
    } 
    stringBuilder.append("};");
    return stringBuilder.toString();
  }
  
  public static class Builder {
    static final int ARRAY_TO_RB_TREE_SIZE_THRESHOLD = 25;
    
    private static final KeyTranslator IDENTITY_TRANSLATOR = ImmutableSortedMap$Builder$$Lambda$1.lambdaFactory$();
    
    public static <A, B, C> ImmutableSortedMap<A, C> buildFrom(List<A> param1List, Map<B, C> param1Map, KeyTranslator<A, B> param1KeyTranslator, Comparator<A> param1Comparator) {
      return (ImmutableSortedMap<A, C>)((param1List.size() < 25) ? ArraySortedMap.buildFrom(param1List, param1Map, param1KeyTranslator, param1Comparator) : RBTreeSortedMap.buildFrom(param1List, param1Map, param1KeyTranslator, param1Comparator));
    }
    
    public static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<K> param1Comparator) {
      return new ArraySortedMap<>(param1Comparator);
    }
    
    public static <A, B> ImmutableSortedMap<A, B> fromMap(Map<A, B> param1Map, Comparator<A> param1Comparator) {
      return (ImmutableSortedMap<A, B>)((param1Map.size() < 25) ? ArraySortedMap.fromMap(param1Map, param1Comparator) : RBTreeSortedMap.fromMap(param1Map, param1Comparator));
    }
    
    public static <A> KeyTranslator<A, A> identityTranslator() {
      return IDENTITY_TRANSLATOR;
    }
    
    public static interface KeyTranslator<C, D> {
      D translate(C param2C);
    }
  }
  
  public static interface KeyTranslator<C, D> {
    D translate(C param1C);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\ImmutableSortedMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */