package com.google.firebase.database.collection;

import java.util.Comparator;

public interface LLRBNode<K, V> {
  LLRBNode<K, V> copy(K paramK, V paramV, Color paramColor, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2);
  
  K getKey();
  
  LLRBNode<K, V> getLeft();
  
  LLRBNode<K, V> getMax();
  
  LLRBNode<K, V> getMin();
  
  LLRBNode<K, V> getRight();
  
  V getValue();
  
  void inOrderTraversal(NodeVisitor<K, V> paramNodeVisitor);
  
  LLRBNode<K, V> insert(K paramK, V paramV, Comparator<K> paramComparator);
  
  boolean isEmpty();
  
  boolean isRed();
  
  LLRBNode<K, V> remove(K paramK, Comparator<K> paramComparator);
  
  boolean shortCircuitingInOrderTraversal(ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor);
  
  boolean shortCircuitingReverseOrderTraversal(ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor);
  
  int size();
  
  public enum Color {
    BLACK, RED;
    
    static {
      $VALUES = new Color[] { RED, BLACK };
    }
  }
  
  public static abstract class NodeVisitor<K, V> implements ShortCircuitingNodeVisitor<K, V> {
    public boolean shouldContinue(K param1K, V param1V) {
      visitEntry(param1K, param1V);
      return true;
    }
    
    public abstract void visitEntry(K param1K, V param1V);
  }
  
  public static interface ShortCircuitingNodeVisitor<K, V> {
    boolean shouldContinue(K param1K, V param1V);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\LLRBNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */