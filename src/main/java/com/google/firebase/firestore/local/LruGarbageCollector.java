package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class LruGarbageCollector {
  private static final long INITIAL_GC_DELAY_MS = TimeUnit.MINUTES.toMillis(1L);
  
  private static final long REGULAR_GC_DELAY_MS = TimeUnit.MINUTES.toMillis(5L);
  
  private final LruDelegate delegate;
  
  private final Params params;
  
  LruGarbageCollector(LruDelegate paramLruDelegate, Params paramParams) {
    this.delegate = paramLruDelegate;
    this.params = paramParams;
  }
  
  private Results runGarbageCollection(SparseArray<?> paramSparseArray) {
    long l1 = System.currentTimeMillis();
    int i = calculateQueryCount(this.params.percentileToCollect);
    int j = i;
    if (i > this.params.maximumSequenceNumbersToCollect) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Capping sequence numbers to collect down to the maximum of ");
      stringBuilder.append(this.params.maximumSequenceNumbersToCollect);
      stringBuilder.append(" from ");
      stringBuilder.append(i);
      Logger.debug("LruGarbageCollector", stringBuilder.toString(), new Object[0]);
      j = this.params.maximumSequenceNumbersToCollect;
    } 
    long l2 = System.currentTimeMillis();
    long l3 = getNthSequenceNumber(j);
    long l4 = System.currentTimeMillis();
    i = removeTargets(l3, paramSparseArray);
    long l5 = System.currentTimeMillis();
    int k = removeOrphanedDocuments(l3);
    l3 = System.currentTimeMillis();
    if (Logger.isDebugEnabled()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("LRU Garbage Collection:\n");
      stringBuilder1.append("\tCounted targets in ");
      stringBuilder1.append(l2 - l1);
      stringBuilder1.append("ms\n");
      String str2 = stringBuilder1.toString();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(String.format(Locale.ROOT, "\tDetermined least recently used %d sequence numbers in %dms\n", new Object[] { Integer.valueOf(j), Long.valueOf(l4 - l2) }));
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(String.format(Locale.ROOT, "\tRemoved %d targets in %dms\n", new Object[] { Integer.valueOf(i), Long.valueOf(l5 - l4) }));
      str1 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(String.format(Locale.ROOT, "\tRemoved %d documents in %dms\n", new Object[] { Integer.valueOf(k), Long.valueOf(l3 - l5) }));
      str1 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(String.format(Locale.ROOT, "Total Duration: %dms", new Object[] { Long.valueOf(l3 - l1) }));
      Logger.debug("LruGarbageCollector", stringBuilder2.toString(), new Object[0]);
    } 
    return new Results(true, j, i, k);
  }
  
  int calculateQueryCount(int paramInt) {
    long l = this.delegate.getSequenceNumberCount();
    return (int)(paramInt / 100.0F * (float)l);
  }
  
  Results collect(SparseArray<?> paramSparseArray) {
    StringBuilder stringBuilder;
    if (this.params.minBytesThreshold == -1L) {
      Logger.debug("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
      return Results.DidNotRun();
    } 
    long l = getByteSize();
    if (l < this.params.minBytesThreshold) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Garbage collection skipped; Cache size ");
      stringBuilder.append(l);
      stringBuilder.append(" is lower than threshold ");
      stringBuilder.append(this.params.minBytesThreshold);
      Logger.debug("LruGarbageCollector", stringBuilder.toString(), new Object[0]);
      return Results.DidNotRun();
    } 
    return runGarbageCollection((SparseArray<?>)stringBuilder);
  }
  
  long getByteSize() {
    return this.delegate.getByteSize();
  }
  
  long getNthSequenceNumber(int paramInt) {
    if (paramInt == 0)
      return -1L; 
    RollingSequenceNumberBuffer rollingSequenceNumberBuffer = new RollingSequenceNumberBuffer(paramInt);
    this.delegate.forEachTarget(LruGarbageCollector$$Lambda$1.lambdaFactory$(rollingSequenceNumberBuffer));
    LruDelegate lruDelegate = this.delegate;
    rollingSequenceNumberBuffer.getClass();
    lruDelegate.forEachOrphanedDocumentSequenceNumber(LruGarbageCollector$$Lambda$2.lambdaFactory$(rollingSequenceNumberBuffer));
    return rollingSequenceNumberBuffer.getMaxValue();
  }
  
  public Scheduler newScheduler(AsyncQueue paramAsyncQueue, LocalStore paramLocalStore) {
    return new Scheduler(paramAsyncQueue, paramLocalStore);
  }
  
  int removeOrphanedDocuments(long paramLong) {
    return this.delegate.removeOrphanedDocuments(paramLong);
  }
  
  int removeTargets(long paramLong, SparseArray<?> paramSparseArray) {
    return this.delegate.removeTargets(paramLong, paramSparseArray);
  }
  
  public static class Params {
    private static final long COLLECTION_DISABLED = -1L;
    
    private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600L;
    
    private static final int DEFAULT_COLLECTION_PERCENTILE = 10;
    
    private static final int DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT = 1000;
    
    final int maximumSequenceNumbersToCollect;
    
    final long minBytesThreshold;
    
    final int percentileToCollect;
    
    Params(long param1Long, int param1Int1, int param1Int2) {
      this.minBytesThreshold = param1Long;
      this.percentileToCollect = param1Int1;
      this.maximumSequenceNumbersToCollect = param1Int2;
    }
    
    public static Params Default() {
      return new Params(104857600L, 10, 1000);
    }
    
    public static Params Disabled() {
      return new Params(-1L, 0, 0);
    }
    
    public static Params WithCacheSizeBytes(long param1Long) {
      return new Params(param1Long, 10, 1000);
    }
  }
  
  public static class Results {
    private final int documentsRemoved;
    
    private final boolean hasRun;
    
    private final int sequenceNumbersCollected;
    
    private final int targetsRemoved;
    
    Results(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3) {
      this.hasRun = param1Boolean;
      this.sequenceNumbersCollected = param1Int1;
      this.targetsRemoved = param1Int2;
      this.documentsRemoved = param1Int3;
    }
    
    static Results DidNotRun() {
      return new Results(false, 0, 0, 0);
    }
    
    public int getDocumentsRemoved() {
      return this.documentsRemoved;
    }
    
    public int getSequenceNumbersCollected() {
      return this.sequenceNumbersCollected;
    }
    
    public int getTargetsRemoved() {
      return this.targetsRemoved;
    }
    
    public boolean hasRun() {
      return this.hasRun;
    }
  }
  
  private static class RollingSequenceNumberBuffer {
    private static final Comparator<Long> COMPARATOR = LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1.lambdaFactory$();
    
    private final int maxElements;
    
    private final PriorityQueue<Long> queue;
    
    RollingSequenceNumberBuffer(int param1Int) {
      this.maxElements = param1Int;
      this.queue = new PriorityQueue<>(param1Int, COMPARATOR);
    }
    
    void addElement(Long param1Long) {
      if (this.queue.size() < this.maxElements) {
        this.queue.add(param1Long);
      } else {
        Long long_ = this.queue.peek();
        if (param1Long.longValue() < long_.longValue()) {
          this.queue.poll();
          this.queue.add(param1Long);
        } 
      } 
    }
    
    long getMaxValue() {
      return ((Long)this.queue.peek()).longValue();
    }
  }
  
  public class Scheduler {
    private final AsyncQueue asyncQueue;
    
    private AsyncQueue.DelayedTask gcTask;
    
    private boolean hasRun = false;
    
    private final LocalStore localStore;
    
    public Scheduler(AsyncQueue param1AsyncQueue, LocalStore param1LocalStore) {
      this.asyncQueue = param1AsyncQueue;
      this.localStore = param1LocalStore;
    }
    
    private void scheduleGC() {
      long l;
      if (this.hasRun) {
        l = LruGarbageCollector.REGULAR_GC_DELAY_MS;
      } else {
        l = LruGarbageCollector.INITIAL_GC_DELAY_MS;
      } 
      this.gcTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.GARBAGE_COLLECTION, l, LruGarbageCollector$Scheduler$$Lambda$1.lambdaFactory$(this));
    }
    
    public void start() {
      if (LruGarbageCollector.this.params.minBytesThreshold != -1L)
        scheduleGC(); 
    }
    
    public void stop() {
      AsyncQueue.DelayedTask delayedTask = this.gcTask;
      if (delayedTask != null)
        delayedTask.cancel(); 
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LruGarbageCollector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */