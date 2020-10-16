package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Supplier;
import java.util.HashMap;
import java.util.Map;

public final class MemoryPersistence extends Persistence {
  private final MemoryIndexManager indexManager = new MemoryIndexManager();
  
  private final Map<User, MemoryMutationQueue> mutationQueues = new HashMap<>();
  
  private final MemoryQueryCache queryCache = new MemoryQueryCache(this);
  
  private ReferenceDelegate referenceDelegate;
  
  private final MemoryRemoteDocumentCache remoteDocumentCache = new MemoryRemoteDocumentCache(this);
  
  private boolean started;
  
  public static MemoryPersistence createEagerGcMemoryPersistence() {
    MemoryPersistence memoryPersistence = new MemoryPersistence();
    memoryPersistence.setReferenceDelegate(new MemoryEagerReferenceDelegate(memoryPersistence));
    return memoryPersistence;
  }
  
  public static MemoryPersistence createLruGcMemoryPersistence(LruGarbageCollector.Params paramParams, LocalSerializer paramLocalSerializer) {
    MemoryPersistence memoryPersistence = new MemoryPersistence();
    memoryPersistence.setReferenceDelegate(new MemoryLruReferenceDelegate(memoryPersistence, paramParams, paramLocalSerializer));
    return memoryPersistence;
  }
  
  private void setReferenceDelegate(ReferenceDelegate paramReferenceDelegate) {
    this.referenceDelegate = paramReferenceDelegate;
  }
  
  IndexManager getIndexManager() {
    return this.indexManager;
  }
  
  MutationQueue getMutationQueue(User paramUser) {
    MemoryMutationQueue memoryMutationQueue1 = this.mutationQueues.get(paramUser);
    MemoryMutationQueue memoryMutationQueue2 = memoryMutationQueue1;
    if (memoryMutationQueue1 == null) {
      memoryMutationQueue2 = new MemoryMutationQueue(this);
      this.mutationQueues.put(paramUser, memoryMutationQueue2);
    } 
    return memoryMutationQueue2;
  }
  
  Iterable<MemoryMutationQueue> getMutationQueues() {
    return this.mutationQueues.values();
  }
  
  MemoryQueryCache getQueryCache() {
    return this.queryCache;
  }
  
  ReferenceDelegate getReferenceDelegate() {
    return this.referenceDelegate;
  }
  
  MemoryRemoteDocumentCache getRemoteDocumentCache() {
    return this.remoteDocumentCache;
  }
  
  public boolean isStarted() {
    return this.started;
  }
  
  <T> T runTransaction(String paramString, Supplier<T> paramSupplier) {
    this.referenceDelegate.onTransactionStarted();
    try {
      return (T)paramSupplier.get();
    } finally {
      this.referenceDelegate.onTransactionCommitted();
    } 
  }
  
  void runTransaction(String paramString, Runnable paramRunnable) {
    this.referenceDelegate.onTransactionStarted();
    try {
      paramRunnable.run();
      return;
    } finally {
      this.referenceDelegate.onTransactionCommitted();
    } 
  }
  
  public void shutdown() {
    Assert.hardAssert(this.started, "MemoryPersistence shutdown without start", new Object[0]);
    this.started = false;
  }
  
  public void start() {
    Assert.hardAssert(this.started ^ true, "MemoryPersistence double-started!", new Object[0]);
    this.started = true;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryPersistence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */