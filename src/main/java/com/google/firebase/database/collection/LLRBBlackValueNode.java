package com.google.firebase.database.collection;

public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {
  private int size = -1;
  
  LLRBBlackValueNode(K paramK, V paramV, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2) {
    super(paramK, paramV, paramLLRBNode1, paramLLRBNode2);
  }
  
  protected LLRBValueNode<K, V> copy(K paramK, V paramV, LLRBNode<K, V> paramLLRBNode1, LLRBNode<K, V> paramLLRBNode2) {
    K k = paramK;
    if (paramK == null)
      k = getKey(); 
    V v = paramV;
    if (paramV == null)
      v = getValue(); 
    LLRBNode<K, V> lLRBNode = paramLLRBNode1;
    if (paramLLRBNode1 == null)
      lLRBNode = getLeft(); 
    paramLLRBNode1 = paramLLRBNode2;
    if (paramLLRBNode2 == null)
      paramLLRBNode1 = getRight(); 
    return new LLRBBlackValueNode(k, v, lLRBNode, paramLLRBNode1);
  }
  
  protected LLRBNode.Color getColor() {
    return LLRBNode.Color.BLACK;
  }
  
  public boolean isRed() {
    return false;
  }
  
  void setLeft(LLRBNode<K, V> paramLLRBNode) {
    if (this.size == -1) {
      super.setLeft(paramLLRBNode);
      return;
    } 
    throw new IllegalStateException("Can't set left after using size");
  }
  
  public int size() {
    if (this.size == -1)
      this.size = getLeft().size() + 1 + getRight().size(); 
    return this.size;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\LLRBBlackValueNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */