package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
  private final boolean isReverse;
  
  private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();
  
  ImmutableSortedMapIterator(LLRBNode<K, V> paramLLRBNode, K paramK, Comparator<K> paramComparator, boolean paramBoolean) {
    this.isReverse = paramBoolean;
    while (!paramLLRBNode.isEmpty()) {
      boolean bool;
      if (paramK != null) {
        if (paramBoolean) {
          bool = paramComparator.compare(paramK, paramLLRBNode.getKey());
        } else {
          bool = paramComparator.compare(paramLLRBNode.getKey(), paramK);
        } 
      } else {
        bool = true;
      } 
      if (bool) {
        if (paramBoolean) {
          paramLLRBNode = paramLLRBNode.getLeft();
          continue;
        } 
        paramLLRBNode = paramLLRBNode.getRight();
        continue;
      } 
      if (!bool) {
        this.nodeStack.push((LLRBValueNode<K, V>)paramLLRBNode);
        break;
      } 
      this.nodeStack.push((LLRBValueNode<K, V>)paramLLRBNode);
      if (paramBoolean) {
        paramLLRBNode = paramLLRBNode.getRight();
        continue;
      } 
      paramLLRBNode = paramLLRBNode.getLeft();
    } 
  }
  
  public boolean hasNext() {
    boolean bool;
    if (this.nodeStack.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Map.Entry<K, V> next() {
    try {
      LLRBNode lLRBNode = this.nodeStack.pop();
      AbstractMap.SimpleEntry<Object, Object> simpleEntry = new AbstractMap.SimpleEntry<>();
      this((K)lLRBNode.getKey(), (V)lLRBNode.getValue());
      if (this.isReverse) {
        for (lLRBNode = lLRBNode.getLeft(); !lLRBNode.isEmpty(); lLRBNode = lLRBNode.getRight())
          this.nodeStack.push((LLRBValueNode<K, V>)lLRBNode); 
      } else {
        for (lLRBNode = lLRBNode.getRight(); !lLRBNode.isEmpty(); lLRBNode = lLRBNode.getLeft())
          this.nodeStack.push((LLRBValueNode<K, V>)lLRBNode); 
      } 
      return (Map.Entry)simpleEntry;
    } catch (EmptyStackException emptyStackException) {
      throw new NoSuchElementException();
    } 
  }
  
  public void remove() {
    throw new UnsupportedOperationException("remove called on immutable collection");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\ImmutableSortedMapIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */