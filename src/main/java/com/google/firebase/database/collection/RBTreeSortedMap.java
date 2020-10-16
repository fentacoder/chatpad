package com.google.firebase.database.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
  private Comparator<K> comparator;
  
  private LLRBNode<K, V> root;
  
  private RBTreeSortedMap(LLRBNode<K, V> paramLLRBNode, Comparator<K> paramComparator) {
    this.root = paramLLRBNode;
    this.comparator = paramComparator;
  }
  
  RBTreeSortedMap(Comparator<K> paramComparator) {
    this.root = LLRBEmptyNode.getInstance();
    this.comparator = paramComparator;
  }
  
  public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> paramList, Map<B, C> paramMap, ImmutableSortedMap.Builder.KeyTranslator<A, B> paramKeyTranslator, Comparator<A> paramComparator) {
    return Builder.buildFrom(paramList, paramMap, paramKeyTranslator, paramComparator);
  }
  
  public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> paramMap, Comparator<A> paramComparator) {
    return Builder.buildFrom(new ArrayList<>(paramMap.keySet()), paramMap, ImmutableSortedMap.Builder.identityTranslator(), paramComparator);
  }
  
  private LLRBNode<K, V> getNode(K paramK) {
    for (LLRBNode<K, V> lLRBNode = this.root; !lLRBNode.isEmpty(); lLRBNode = lLRBNode.getRight()) {
      int i = this.comparator.compare(paramK, lLRBNode.getKey());
      if (i < 0) {
        lLRBNode = lLRBNode.getLeft();
        continue;
      } 
      if (i == 0)
        return lLRBNode; 
    } 
    return null;
  }
  
  public boolean containsKey(K paramK) {
    boolean bool;
    if (getNode(paramK) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public V get(K paramK) {
    LLRBNode<K, V> lLRBNode = getNode(paramK);
    if (lLRBNode != null) {
      lLRBNode = (LLRBNode<K, V>)lLRBNode.getValue();
    } else {
      lLRBNode = null;
    } 
    return (V)lLRBNode;
  }
  
  public Comparator<K> getComparator() {
    return this.comparator;
  }
  
  public K getMaxKey() {
    return (K)this.root.getMax().getKey();
  }
  
  public K getMinKey() {
    return (K)this.root.getMin().getKey();
  }
  
  public K getPredecessorKey(K paramK) {
    LLRBNode<K, V> lLRBNode1;
    LLRBNode<K, V> lLRBNode2 = this.root;
    LLRBNode<K, V> lLRBNode3 = null;
    while (!lLRBNode2.isEmpty()) {
      int i = this.comparator.compare(paramK, lLRBNode2.getKey());
      if (i == 0) {
        if (!lLRBNode2.getLeft().isEmpty()) {
          for (lLRBNode1 = lLRBNode2.getLeft(); !lLRBNode1.getRight().isEmpty(); lLRBNode1 = lLRBNode1.getRight());
          return lLRBNode1.getKey();
        } 
        return (K)((lLRBNode3 != null) ? lLRBNode3.getKey() : null);
      } 
      if (i < 0) {
        lLRBNode2 = lLRBNode2.getLeft();
        continue;
      } 
      LLRBNode<K, V> lLRBNode = lLRBNode2.getRight();
      lLRBNode3 = lLRBNode2;
      lLRBNode2 = lLRBNode;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Couldn't find predecessor key of non-present key: ");
    stringBuilder.append(lLRBNode1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  LLRBNode<K, V> getRoot() {
    return this.root;
  }
  
  public K getSuccessorKey(K paramK) {
    LLRBNode<K, V> lLRBNode1;
    LLRBNode<K, V> lLRBNode2 = this.root;
    LLRBNode<K, V> lLRBNode3 = null;
    while (!lLRBNode2.isEmpty()) {
      int i = this.comparator.compare(lLRBNode2.getKey(), paramK);
      if (i == 0) {
        if (!lLRBNode2.getRight().isEmpty()) {
          for (lLRBNode1 = lLRBNode2.getRight(); !lLRBNode1.getLeft().isEmpty(); lLRBNode1 = lLRBNode1.getLeft());
          return lLRBNode1.getKey();
        } 
        return (K)((lLRBNode3 != null) ? lLRBNode3.getKey() : null);
      } 
      if (i < 0) {
        lLRBNode2 = lLRBNode2.getRight();
        continue;
      } 
      LLRBNode<K, V> lLRBNode = lLRBNode2.getLeft();
      lLRBNode3 = lLRBNode2;
      lLRBNode2 = lLRBNode;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Couldn't find successor key of non-present key: ");
    stringBuilder.append(lLRBNode1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> paramNodeVisitor) {
    this.root.inOrderTraversal(paramNodeVisitor);
  }
  
  public int indexOf(K paramK) {
    LLRBNode<K, V> lLRBNode = this.root;
    int i = 0;
    while (!lLRBNode.isEmpty()) {
      int j = this.comparator.compare(paramK, lLRBNode.getKey());
      if (j == 0)
        return i + lLRBNode.getLeft().size(); 
      if (j < 0) {
        lLRBNode = lLRBNode.getLeft();
        continue;
      } 
      i += lLRBNode.getLeft().size() + 1;
      lLRBNode = lLRBNode.getRight();
    } 
    return -1;
  }
  
  public ImmutableSortedMap<K, V> insert(K paramK, V paramV) {
    return new RBTreeSortedMap(this.root.insert(paramK, paramV, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
  }
  
  public boolean isEmpty() {
    return this.root.isEmpty();
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    return new ImmutableSortedMapIterator<>(this.root, null, this.comparator, false);
  }
  
  public Iterator<Map.Entry<K, V>> iteratorFrom(K paramK) {
    return new ImmutableSortedMapIterator<>(this.root, paramK, this.comparator, false);
  }
  
  public ImmutableSortedMap<K, V> remove(K paramK) {
    return !containsKey(paramK) ? this : new RBTreeSortedMap(this.root.remove(paramK, this.comparator).copy(null, null, LLRBNode.Color.BLACK, null, null), this.comparator);
  }
  
  public Iterator<Map.Entry<K, V>> reverseIterator() {
    return new ImmutableSortedMapIterator<>(this.root, null, this.comparator, true);
  }
  
  public Iterator<Map.Entry<K, V>> reverseIteratorFrom(K paramK) {
    return new ImmutableSortedMapIterator<>(this.root, paramK, this.comparator, true);
  }
  
  public int size() {
    return this.root.size();
  }
  
  private static class Builder<A, B, C> {
    private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
    
    private final List<A> keys;
    
    private LLRBValueNode<A, C> leaf;
    
    private LLRBValueNode<A, C> root;
    
    private final Map<B, C> values;
    
    private Builder(List<A> param1List, Map<B, C> param1Map, ImmutableSortedMap.Builder.KeyTranslator<A, B> param1KeyTranslator) {
      this.keys = param1List;
      this.values = param1Map;
      this.keyTranslator = param1KeyTranslator;
    }
    
    private LLRBNode<A, C> buildBalancedTree(int param1Int1, int param1Int2) {
      if (param1Int2 == 0)
        return LLRBEmptyNode.getInstance(); 
      if (param1Int2 == 1) {
        A a1 = this.keys.get(param1Int1);
        return new LLRBBlackValueNode<>(a1, getValue(a1), null, null);
      } 
      param1Int2 /= 2;
      int i = param1Int1 + param1Int2;
      LLRBNode<A, C> lLRBNode1 = buildBalancedTree(param1Int1, param1Int2);
      LLRBNode<A, C> lLRBNode2 = buildBalancedTree(i + 1, param1Int2);
      A a = this.keys.get(i);
      return new LLRBBlackValueNode<>(a, getValue(a), lLRBNode1, lLRBNode2);
    }
    
    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> param1List, Map<B, C> param1Map, ImmutableSortedMap.Builder.KeyTranslator<A, B> param1KeyTranslator, Comparator<A> param1Comparator) {
      LLRBEmptyNode<?, ?> lLRBEmptyNode;
      Builder<A, B, C> builder = new Builder<>(param1List, param1Map, param1KeyTranslator);
      Collections.sort(param1List, param1Comparator);
      Iterator<BooleanChunk> iterator = (new Base1_2(param1List.size())).iterator();
      int i = param1List.size();
      while (iterator.hasNext()) {
        BooleanChunk booleanChunk = iterator.next();
        i -= booleanChunk.chunkSize;
        if (booleanChunk.isOne) {
          builder.buildPennant(LLRBNode.Color.BLACK, booleanChunk.chunkSize, i);
          continue;
        } 
        builder.buildPennant(LLRBNode.Color.BLACK, booleanChunk.chunkSize, i);
        i -= booleanChunk.chunkSize;
        builder.buildPennant(LLRBNode.Color.RED, booleanChunk.chunkSize, i);
      } 
      LLRBValueNode<A, C> lLRBValueNode2 = builder.root;
      LLRBValueNode<A, C> lLRBValueNode1 = lLRBValueNode2;
      if (lLRBValueNode2 == null)
        lLRBEmptyNode = LLRBEmptyNode.getInstance(); 
      return new RBTreeSortedMap<>(lLRBEmptyNode, param1Comparator);
    }
    
    private void buildPennant(LLRBNode.Color param1Color, int param1Int1, int param1Int2) {
      LLRBBlackValueNode<A, C> lLRBBlackValueNode;
      LLRBNode<A, C> lLRBNode = buildBalancedTree(param1Int2 + 1, param1Int1 - 1);
      A a = this.keys.get(param1Int2);
      if (param1Color == LLRBNode.Color.RED) {
        LLRBRedValueNode<A, C> lLRBRedValueNode = new LLRBRedValueNode<>(a, getValue(a), null, lLRBNode);
      } else {
        lLRBBlackValueNode = new LLRBBlackValueNode<>(a, getValue(a), null, lLRBNode);
      } 
      if (this.root == null) {
        this.root = lLRBBlackValueNode;
        this.leaf = lLRBBlackValueNode;
      } else {
        this.leaf.setLeft(lLRBBlackValueNode);
        this.leaf = lLRBBlackValueNode;
      } 
    }
    
    private C getValue(A param1A) {
      return this.values.get(this.keyTranslator.translate(param1A));
    }
    
    static class Base1_2 implements Iterable<BooleanChunk> {
      private final int length;
      
      private long value;
      
      public Base1_2(int param2Int) {
        this.length = (int)Math.floor(Math.log(++param2Int) / Math.log(2.0D));
        this.value = (long)Math.pow(2.0D, this.length) - 1L & param2Int;
      }
      
      public Iterator<RBTreeSortedMap.Builder.BooleanChunk> iterator() {
        return new Iterator<RBTreeSortedMap.Builder.BooleanChunk>() {
            private int current = RBTreeSortedMap.Builder.Base1_2.this.length - 1;
            
            public boolean hasNext() {
              boolean bool;
              if (this.current >= 0) {
                bool = true;
              } else {
                bool = false;
              } 
              return bool;
            }
            
            public RBTreeSortedMap.Builder.BooleanChunk next() {
              boolean bool;
              long l1 = RBTreeSortedMap.Builder.Base1_2.this.value;
              long l2 = (1 << this.current);
              RBTreeSortedMap.Builder.BooleanChunk booleanChunk = new RBTreeSortedMap.Builder.BooleanChunk();
              if ((l1 & l2) == 0L) {
                bool = true;
              } else {
                bool = false;
              } 
              booleanChunk.isOne = bool;
              booleanChunk.chunkSize = (int)Math.pow(2.0D, this.current);
              this.current--;
              return booleanChunk;
            }
            
            public void remove() {}
          };
      }
    }
    
    class null implements Iterator<BooleanChunk> {
      private int current = this.this$0.length - 1;
      
      public boolean hasNext() {
        boolean bool;
        if (this.current >= 0) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public RBTreeSortedMap.Builder.BooleanChunk next() {
        boolean bool;
        long l1 = this.this$0.value;
        long l2 = (1 << this.current);
        RBTreeSortedMap.Builder.BooleanChunk booleanChunk = new RBTreeSortedMap.Builder.BooleanChunk();
        if ((l1 & l2) == 0L) {
          bool = true;
        } else {
          bool = false;
        } 
        booleanChunk.isOne = bool;
        booleanChunk.chunkSize = (int)Math.pow(2.0D, this.current);
        this.current--;
        return booleanChunk;
      }
      
      public void remove() {}
    }
    
    static class BooleanChunk {
      public int chunkSize;
      
      public boolean isOne;
    }
  }
  
  static class Base1_2 implements Iterable<Builder.BooleanChunk> {
    private final int length;
    
    private long value;
    
    public Base1_2(int param1Int) {
      this.length = (int)Math.floor(Math.log(++param1Int) / Math.log(2.0D));
      this.value = (long)Math.pow(2.0D, this.length) - 1L & param1Int;
    }
    
    public Iterator<RBTreeSortedMap.Builder.BooleanChunk> iterator() {
      return new Iterator<RBTreeSortedMap.Builder.BooleanChunk>() {
          private int current = RBTreeSortedMap.Builder.Base1_2.this.length - 1;
          
          public boolean hasNext() {
            boolean bool;
            if (this.current >= 0) {
              bool = true;
            } else {
              bool = false;
            } 
            return bool;
          }
          
          public RBTreeSortedMap.Builder.BooleanChunk next() {
            boolean bool;
            long l1 = RBTreeSortedMap.Builder.Base1_2.this.value;
            long l2 = (1 << this.current);
            RBTreeSortedMap.Builder.BooleanChunk booleanChunk = new RBTreeSortedMap.Builder.BooleanChunk();
            if ((l1 & l2) == 0L) {
              bool = true;
            } else {
              bool = false;
            } 
            booleanChunk.isOne = bool;
            booleanChunk.chunkSize = (int)Math.pow(2.0D, this.current);
            this.current--;
            return booleanChunk;
          }
          
          public void remove() {}
        };
    }
  }
  
  class null implements Iterator<Builder.BooleanChunk> {
    private int current = this.this$0.length - 1;
    
    public boolean hasNext() {
      boolean bool;
      if (this.current >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public RBTreeSortedMap.Builder.BooleanChunk next() {
      boolean bool;
      long l1 = this.this$0.value;
      long l2 = (1 << this.current);
      RBTreeSortedMap.Builder.BooleanChunk booleanChunk = new RBTreeSortedMap.Builder.BooleanChunk();
      if ((l1 & l2) == 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      booleanChunk.isOne = bool;
      booleanChunk.chunkSize = (int)Math.pow(2.0D, this.current);
      this.current--;
      return booleanChunk;
    }
    
    public void remove() {}
  }
  
  static class BooleanChunk {
    public int chunkSize;
    
    public boolean isOne;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\database\collection\RBTreeSortedMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */