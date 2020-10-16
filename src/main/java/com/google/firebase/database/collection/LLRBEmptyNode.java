package com.google.firebase.database.collection;

import java.util.Comparator;

public class LLRBEmptyNode<K, V> implements LLRBNode<K, V> {
  private static final LLRBEmptyNode INSTANCE = new LLRBEmptyNode();
  
  public static <K, V> LLRBEmptyNode<K, V> getInstance() {
    return INSTANCE;
  }
  
  public LLRBNode<K, V> copy(K paramK, V paramV, LLRBNode.Color paramColor, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2) {
    return this;
  }
  
  public K getKey() {
    return null;
  }
  
  public LLRBNode<K, V> getLeft() {
    return this;
  }
  
  public LLRBNode<K, V> getMax() {
    return this;
  }
  
  public LLRBNode<K, V> getMin() {
    return this;
  }
  
  public LLRBNode<K, V> getRight() {
    return this;
  }
  
  public V getValue() {
    return null;
  }
  
  public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> paramNodeVisitor) {}
  
  public LLRBNode<K, V> insert(K paramK, V paramV, Comparator<K> paramComparator) {
    return new LLRBRedValueNode<>(paramK, paramV);
  }
  
  public boolean isEmpty() {
    return true;
  }
  
  public boolean isRed() {
    return false;
  }
  
  public LLRBNode<K, V> remove(K paramK, Comparator<K> paramComparator) {
    return this;
  }
  
  public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor) {
    return true;
  }
  
  public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor) {
    return true;
  }
  
  public int size() {
    return 0;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\LLRBEmptyNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */