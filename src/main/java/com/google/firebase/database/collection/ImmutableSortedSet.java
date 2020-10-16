package com.google.firebase.database.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImmutableSortedSet<T> implements Iterable<T> {
  private final ImmutableSortedMap<T, Void> map;
  
  private ImmutableSortedSet(ImmutableSortedMap<T, Void> paramImmutableSortedMap) {
    this.map = paramImmutableSortedMap;
  }
  
  public ImmutableSortedSet(List<T> paramList, Comparator<T> paramComparator) {
    this.map = ImmutableSortedMap.Builder.buildFrom(paramList, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), paramComparator);
  }
  
  public boolean contains(T paramT) {
    return this.map.containsKey(paramT);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ImmutableSortedSet))
      return false; 
    paramObject = paramObject;
    return this.map.equals(((ImmutableSortedSet)paramObject).map);
  }
  
  public T getMaxEntry() {
    return this.map.getMaxKey();
  }
  
  public T getMinEntry() {
    return this.map.getMinKey();
  }
  
  public T getPredecessorEntry(T paramT) {
    return this.map.getPredecessorKey(paramT);
  }
  
  public int hashCode() {
    return this.map.hashCode();
  }
  
  public int indexOf(T paramT) {
    return this.map.indexOf(paramT);
  }
  
  public ImmutableSortedSet<T> insert(T paramT) {
    return new ImmutableSortedSet(this.map.insert(paramT, null));
  }
  
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  public Iterator<T> iterator() {
    return new WrappedEntryIterator<>(this.map.iterator());
  }
  
  public Iterator<T> iteratorFrom(T paramT) {
    return new WrappedEntryIterator<>(this.map.iteratorFrom(paramT));
  }
  
  public ImmutableSortedSet<T> remove(T paramT) {
    ImmutableSortedSet<T> immutableSortedSet;
    ImmutableSortedMap<T, Void> immutableSortedMap = this.map.remove(paramT);
    if (immutableSortedMap == this.map) {
      immutableSortedSet = this;
    } else {
      immutableSortedSet = new ImmutableSortedSet((ImmutableSortedMap)immutableSortedSet);
    } 
    return immutableSortedSet;
  }
  
  public Iterator<T> reverseIterator() {
    return new WrappedEntryIterator<>(this.map.reverseIterator());
  }
  
  public Iterator<T> reverseIteratorFrom(T paramT) {
    return new WrappedEntryIterator<>(this.map.reverseIteratorFrom(paramT));
  }
  
  public int size() {
    return this.map.size();
  }
  
  private static class WrappedEntryIterator<T> implements Iterator<T> {
    final Iterator<Map.Entry<T, Void>> iterator;
    
    public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> param1Iterator) {
      this.iterator = param1Iterator;
    }
    
    public boolean hasNext() {
      return this.iterator.hasNext();
    }
    
    public T next() {
      return (T)((Map.Entry)this.iterator.next()).getKey();
    }
    
    public void remove() {
      this.iterator.remove();
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\ImmutableSortedSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */