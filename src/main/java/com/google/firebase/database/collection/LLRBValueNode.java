package com.google.firebase.database.collection;

import java.util.Comparator;

public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {
  private final K key;
  
  private LLRBNode<K, V> left;
  
  private final LLRBNode<K, V> right;
  
  private final V value;
  
  LLRBValueNode(K paramK, V paramV, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2) {
    this.key = paramK;
    this.value = paramV;
    LLRBNode<K, V> lLRBNode = paramLLRBNode1;
    if (paramLLRBNode1 == null)
      lLRBNode = LLRBEmptyNode.getInstance(); 
    this.left = lLRBNode;
    lLRBNode = paramLLRBNode2;
    if (paramLLRBNode2 == null)
      lLRBNode = LLRBEmptyNode.getInstance(); 
    this.right = lLRBNode;
  }
  
  private LLRBValueNode<K, V> colorFlip() {
    LLRBNode<K, V> lLRBNode1 = this.left;
    lLRBNode1 = lLRBNode1.copy(null, null, oppositeColor(lLRBNode1), null, null);
    LLRBNode<K, V> lLRBNode2 = this.right;
    lLRBNode2 = lLRBNode2.copy(null, null, oppositeColor(lLRBNode2), null, null);
    return copy((K)null, (V)null, oppositeColor(this), lLRBNode1, lLRBNode2);
  }
  
  private LLRBValueNode<K, V> fixUp() {
    if (this.right.isRed() && !this.left.isRed()) {
      lLRBValueNode1 = rotateLeft();
    } else {
      lLRBValueNode1 = this;
    } 
    LLRBValueNode<K, V> lLRBValueNode2 = lLRBValueNode1;
    if (lLRBValueNode1.left.isRed()) {
      lLRBValueNode2 = lLRBValueNode1;
      if (((LLRBValueNode)lLRBValueNode1.left).left.isRed())
        lLRBValueNode2 = lLRBValueNode1.rotateRight(); 
    } 
    LLRBValueNode<K, V> lLRBValueNode1 = lLRBValueNode2;
    if (lLRBValueNode2.left.isRed()) {
      lLRBValueNode1 = lLRBValueNode2;
      if (lLRBValueNode2.right.isRed())
        lLRBValueNode1 = lLRBValueNode2.colorFlip(); 
    } 
    return lLRBValueNode1;
  }
  
  private LLRBValueNode<K, V> moveRedLeft() {
    LLRBValueNode<K, V> lLRBValueNode1 = colorFlip();
    LLRBValueNode<K, V> lLRBValueNode2 = lLRBValueNode1;
    if (lLRBValueNode1.getRight().getLeft().isRed())
      lLRBValueNode2 = lLRBValueNode1.copy(null, null, null, ((LLRBValueNode<K, V>)lLRBValueNode1.getRight()).rotateRight()).rotateLeft().colorFlip(); 
    return lLRBValueNode2;
  }
  
  private LLRBValueNode<K, V> moveRedRight() {
    LLRBValueNode<K, V> lLRBValueNode1 = colorFlip();
    LLRBValueNode<K, V> lLRBValueNode2 = lLRBValueNode1;
    if (lLRBValueNode1.getLeft().getLeft().isRed())
      lLRBValueNode2 = lLRBValueNode1.rotateRight().colorFlip(); 
    return lLRBValueNode2;
  }
  
  private static LLRBNode.Color oppositeColor(LLRBNode paramLLRBNode) {
    LLRBNode.Color color;
    if (paramLLRBNode.isRed()) {
      color = LLRBNode.Color.BLACK;
    } else {
      color = LLRBNode.Color.RED;
    } 
    return color;
  }
  
  private LLRBNode<K, V> removeMin() {
    LLRBValueNode<K, V> lLRBValueNode;
    if (this.left.isEmpty())
      return LLRBEmptyNode.getInstance(); 
    if (!getLeft().isRed() && !getLeft().getLeft().isRed()) {
      lLRBValueNode = moveRedLeft();
    } else {
      lLRBValueNode = this;
    } 
    return lLRBValueNode.copy(null, null, ((LLRBValueNode<K, V>)lLRBValueNode.left).removeMin(), null).fixUp();
  }
  
  private LLRBValueNode<K, V> rotateLeft() {
    LLRBValueNode<K, V> lLRBValueNode = copy((K)null, (V)null, LLRBNode.Color.RED, (LLRBNode<K, V>)null, ((LLRBValueNode)this.right).left);
    return (LLRBValueNode<K, V>)this.right.copy(null, null, getColor(), lLRBValueNode, null);
  }
  
  private LLRBValueNode<K, V> rotateRight() {
    LLRBValueNode<K, V> lLRBValueNode = copy((K)null, (V)null, LLRBNode.Color.RED, ((LLRBValueNode)this.left).right, (LLRBNode<K, V>)null);
    return (LLRBValueNode<K, V>)this.left.copy(null, null, getColor(), null, lLRBValueNode);
  }
  
  public LLRBValueNode<K, V> copy(K paramK, V paramV, LLRBNode.Color paramColor, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2) {
    K k = paramK;
    if (paramK == null)
      k = this.key; 
    V v = paramV;
    if (paramV == null)
      v = this.value; 
    LLRBNode<K, V> lLRBNode = paramLLRBNode1;
    if (paramLLRBNode1 == null)
      lLRBNode = this.left; 
    paramLLRBNode1 = paramLLRBNode2;
    if (paramLLRBNode2 == null)
      paramLLRBNode1 = this.right; 
    return (LLRBValueNode<K, V>)((paramColor == LLRBNode.Color.RED) ? new LLRBRedValueNode<>(k, v, lLRBNode, paramLLRBNode1) : new LLRBBlackValueNode<>(k, v, lLRBNode, paramLLRBNode1));
  }
  
  protected abstract LLRBValueNode<K, V> copy(K paramK, V paramV, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2);
  
  protected abstract LLRBNode.Color getColor();
  
  public K getKey() {
    return this.key;
  }
  
  public LLRBNode<K, V> getLeft() {
    return this.left;
  }
  
  public LLRBNode<K, V> getMax() {
    return this.right.isEmpty() ? this : this.right.getMax();
  }
  
  public LLRBNode<K, V> getMin() {
    return this.left.isEmpty() ? this : this.left.getMin();
  }
  
  public LLRBNode<K, V> getRight() {
    return this.right;
  }
  
  public V getValue() {
    return this.value;
  }
  
  public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> paramNodeVisitor) {
    this.left.inOrderTraversal(paramNodeVisitor);
    paramNodeVisitor.visitEntry(this.key, this.value);
    this.right.inOrderTraversal(paramNodeVisitor);
  }
  
  public LLRBNode<K, V> insert(K paramK, V paramV, Comparator<K> paramComparator) {
    LLRBValueNode<K, V> lLRBValueNode;
    int i = paramComparator.compare(paramK, this.key);
    if (i < 0) {
      lLRBValueNode = copy(null, null, this.left.insert(paramK, paramV, paramComparator), null);
    } else if (i == 0) {
      lLRBValueNode = copy((K)lLRBValueNode, paramV, null, null);
    } else {
      lLRBValueNode = copy(null, null, null, this.right.insert((K)lLRBValueNode, paramV, paramComparator));
    } 
    return lLRBValueNode.fixUp();
  }
  
  public boolean isEmpty() {
    return false;
  }
  
  public LLRBNode<K, V> remove(K paramK, Comparator<K> paramComparator) {
    LLRBValueNode<K, V> lLRBValueNode;
    if (paramComparator.compare(paramK, this.key) < 0) {
      LLRBValueNode lLRBValueNode1;
      if (!this.left.isEmpty() && !this.left.isRed() && !((LLRBValueNode)this.left).left.isRed()) {
        lLRBValueNode1 = moveRedLeft();
      } else {
        lLRBValueNode1 = this;
      } 
      lLRBValueNode = lLRBValueNode1.copy(null, null, lLRBValueNode1.left.remove(paramK, paramComparator), null);
    } else {
      if (this.left.isRed()) {
        lLRBNode = rotateRight();
      } else {
        lLRBNode = this;
      } 
      LLRBValueNode<K, V> lLRBValueNode1 = (LLRBValueNode<K, V>)lLRBNode;
      if (!((LLRBValueNode)lLRBNode).right.isEmpty()) {
        lLRBValueNode1 = (LLRBValueNode<K, V>)lLRBNode;
        if (!((LLRBValueNode)lLRBNode).right.isRed()) {
          lLRBValueNode1 = (LLRBValueNode<K, V>)lLRBNode;
          if (!((LLRBValueNode)((LLRBValueNode)lLRBNode).right).left.isRed())
            lLRBValueNode1 = lLRBNode.moveRedRight(); 
        } 
      } 
      LLRBNode<K, V> lLRBNode = lLRBValueNode1;
      if (paramComparator.compare((K)lLRBValueNode, lLRBValueNode1.key) == 0) {
        if (lLRBValueNode1.right.isEmpty())
          return LLRBEmptyNode.getInstance(); 
        lLRBNode = lLRBValueNode1.right.getMin();
        lLRBNode = lLRBValueNode1.copy(lLRBNode.getKey(), lLRBNode.getValue(), null, ((LLRBValueNode<K, V>)lLRBValueNode1.right).removeMin());
      } 
      lLRBValueNode = lLRBNode.copy(null, null, null, ((LLRBValueNode)lLRBNode).right.remove((K)lLRBValueNode, paramComparator));
    } 
    return lLRBValueNode.fixUp();
  }
  
  void setLeft(LLRBNode<K, V> paramLLRBNode) {
    this.left = paramLLRBNode;
  }
  
  public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor) {
    return (this.left.shortCircuitingInOrderTraversal(paramShortCircuitingNodeVisitor) && paramShortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) ? this.right.shortCircuitingInOrderTraversal(paramShortCircuitingNodeVisitor) : false;
  }
  
  public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> paramShortCircuitingNodeVisitor) {
    return (this.right.shortCircuitingReverseOrderTraversal(paramShortCircuitingNodeVisitor) && paramShortCircuitingNodeVisitor.shouldContinue(this.key, this.value)) ? this.left.shortCircuitingReverseOrderTraversal(paramShortCircuitingNodeVisitor) : false;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\LLRBValueNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */