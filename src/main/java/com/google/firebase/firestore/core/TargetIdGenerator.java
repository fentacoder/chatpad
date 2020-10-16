package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Assert;

public class TargetIdGenerator {
  private static final int QUERY_CACHE_ID = 0;
  
  private static final int RESERVED_BITS = 1;
  
  private static final int SYNC_ENGINE_ID = 1;
  
  private int generatorId;
  
  private int nextId;
  
  TargetIdGenerator(int paramInt1, int paramInt2) {
    boolean bool;
    if ((paramInt1 & 0x1) == paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Generator ID %d contains more than %d reserved bits", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(1) });
    this.generatorId = paramInt1;
    seek(paramInt2);
  }
  
  public static TargetIdGenerator forQueryCache(int paramInt) {
    TargetIdGenerator targetIdGenerator = new TargetIdGenerator(0, paramInt);
    targetIdGenerator.nextId();
    return targetIdGenerator;
  }
  
  public static TargetIdGenerator forSyncEngine() {
    return new TargetIdGenerator(1, 1);
  }
  
  private void seek(int paramInt) {
    boolean bool;
    if ((paramInt & 0x1) == this.generatorId) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Cannot supply target ID from different generator ID", new Object[0]);
    this.nextId = paramInt;
  }
  
  public int nextId() {
    int i = this.nextId;
    this.nextId = i + 2;
    return i;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\TargetIdGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */