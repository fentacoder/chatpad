package com.google.firebase.firestore.local;

import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class MemoryMutationQueue implements MutationQueue {
  private ImmutableSortedSet<DocumentReference> batchesByDocumentKey;
  
  private ByteString lastStreamToken;
  
  private int nextBatchId;
  
  private final MemoryPersistence persistence;
  
  private final List<MutationBatch> queue;
  
  MemoryMutationQueue(MemoryPersistence paramMemoryPersistence) {
    this.persistence = paramMemoryPersistence;
    this.queue = new ArrayList<>();
    this.batchesByDocumentKey = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_KEY);
    this.nextBatchId = 1;
    this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
  }
  
  private int indexOfBatchId(int paramInt) {
    return this.queue.isEmpty() ? 0 : (paramInt - ((MutationBatch)this.queue.get(0)).getBatchId());
  }
  
  private int indexOfExistingBatchId(int paramInt, String paramString) {
    boolean bool;
    paramInt = indexOfBatchId(paramInt);
    if (paramInt >= 0 && paramInt < this.queue.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Batches must exist to be %s", new Object[] { paramString });
    return paramInt;
  }
  
  private List<MutationBatch> lookupMutationBatches(ImmutableSortedSet<Integer> paramImmutableSortedSet) {
    ArrayList<MutationBatch> arrayList = new ArrayList();
    Iterator<Integer> iterator = paramImmutableSortedSet.iterator();
    while (iterator.hasNext()) {
      MutationBatch mutationBatch = lookupMutationBatch(((Integer)iterator.next()).intValue());
      if (mutationBatch != null)
        arrayList.add(mutationBatch); 
    } 
    return arrayList;
  }
  
  public void acknowledgeBatch(MutationBatch paramMutationBatch, ByteString paramByteString) {
    boolean bool;
    int i = paramMutationBatch.getBatchId();
    int j = indexOfExistingBatchId(i, "acknowledged");
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
    paramMutationBatch = this.queue.get(j);
    if (i == paramMutationBatch.getBatchId()) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Queue ordering failure: expected batch %d, got batch %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMutationBatch.getBatchId()) });
    this.lastStreamToken = (ByteString)Preconditions.checkNotNull(paramByteString);
  }
  
  public MutationBatch addMutationBatch(Timestamp paramTimestamp, List<Mutation> paramList1, List<Mutation> paramList2) {
    boolean bool = paramList2.isEmpty();
    boolean bool1 = true;
    Assert.hardAssert(bool ^ true, "Mutation batches should not be empty", new Object[0]);
    int i = this.nextBatchId;
    this.nextBatchId = i + 1;
    int j = this.queue.size();
    if (j > 0) {
      if (((MutationBatch)this.queue.get(j - 1)).getBatchId() >= i)
        bool1 = false; 
      Assert.hardAssert(bool1, "Mutation batchIds must be monotonically increasing order", new Object[0]);
    } 
    MutationBatch mutationBatch = new MutationBatch(i, paramTimestamp, paramList1, paramList2);
    this.queue.add(mutationBatch);
    for (Mutation mutation : paramList2) {
      this.batchesByDocumentKey = this.batchesByDocumentKey.insert(new DocumentReference(mutation.getKey(), i));
      this.persistence.getIndexManager().addToCollectionParentIndex((ResourcePath)mutation.getKey().getPath().popLast());
    } 
    return mutationBatch;
  }
  
  boolean containsKey(DocumentKey paramDocumentKey) {
    DocumentReference documentReference = new DocumentReference(paramDocumentKey, 0);
    Iterator<DocumentReference> iterator = this.batchesByDocumentKey.iteratorFrom(documentReference);
    return !iterator.hasNext() ? false : ((DocumentReference)iterator.next()).getKey().equals(paramDocumentKey);
  }
  
  public List<MutationBatch> getAllMutationBatches() {
    return Collections.unmodifiableList(this.queue);
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey paramDocumentKey) {
    DocumentReference documentReference = new DocumentReference(paramDocumentKey, 0);
    ArrayList<MutationBatch> arrayList = new ArrayList();
    Iterator<DocumentReference> iterator = this.batchesByDocumentKey.iteratorFrom(documentReference);
    while (iterator.hasNext()) {
      boolean bool;
      DocumentReference documentReference1 = iterator.next();
      if (!paramDocumentKey.equals(documentReference1.getKey()))
        break; 
      MutationBatch mutationBatch = lookupMutationBatch(documentReference1.getId());
      if (mutationBatch != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Batches in the index must exist in the main table", new Object[0]);
      arrayList.add(mutationBatch);
    } 
    return arrayList;
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> paramIterable) {
    ImmutableSortedSet<Integer> immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), Util.comparator());
    label16: for (DocumentKey documentKey : paramIterable) {
      DocumentReference documentReference = new DocumentReference(documentKey, 0);
      Iterator<DocumentReference> iterator = this.batchesByDocumentKey.iteratorFrom(documentReference);
      ImmutableSortedSet<Integer> immutableSortedSet1 = immutableSortedSet;
      while (true) {
        immutableSortedSet = immutableSortedSet1;
        if (iterator.hasNext()) {
          DocumentReference documentReference1 = iterator.next();
          if (!documentKey.equals(documentReference1.getKey())) {
            immutableSortedSet = immutableSortedSet1;
            continue label16;
          } 
          immutableSortedSet1 = immutableSortedSet1.insert(Integer.valueOf(immutableSortedSet.getId()));
          continue;
        } 
        continue label16;
      } 
    } 
    return lookupMutationBatches(immutableSortedSet);
  }
  
  public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query paramQuery) {
    ResourcePath resourcePath1;
    Assert.hardAssert(paramQuery.isCollectionGroupQuery() ^ true, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
    ResourcePath resourcePath2 = paramQuery.getPath();
    int i = resourcePath2.length();
    if (!DocumentKey.isDocumentKey(resourcePath2)) {
      resourcePath1 = (ResourcePath)resourcePath2.append("");
    } else {
      resourcePath1 = resourcePath2;
    } 
    DocumentReference documentReference = new DocumentReference(DocumentKey.fromPath(resourcePath1), 0);
    ImmutableSortedSet<Integer> immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), Util.comparator());
    Iterator<DocumentReference> iterator = this.batchesByDocumentKey.iteratorFrom(documentReference);
    while (iterator.hasNext()) {
      DocumentReference documentReference1 = iterator.next();
      ResourcePath resourcePath = documentReference1.getKey().getPath();
      if (!resourcePath2.isPrefixOf((BasePath)resourcePath))
        break; 
      if (resourcePath.length() == i + 1)
        immutableSortedSet = immutableSortedSet.insert(Integer.valueOf(documentReference1.getId())); 
    } 
    return lookupMutationBatches(immutableSortedSet);
  }
  
  long getByteSize(LocalSerializer paramLocalSerializer) {
    Iterator<MutationBatch> iterator = this.queue.iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += paramLocalSerializer.encodeMutationBatch(iterator.next()).getSerializedSize());
    return l;
  }
  
  public int getHighestUnacknowledgedBatchId() {
    int i;
    if (this.queue.isEmpty()) {
      i = -1;
    } else {
      i = this.nextBatchId - 1;
    } 
    return i;
  }
  
  public ByteString getLastStreamToken() {
    return this.lastStreamToken;
  }
  
  public MutationBatch getNextMutationBatchAfterBatchId(int paramInt) {
    MutationBatch mutationBatch;
    int i = indexOfBatchId(paramInt + 1);
    paramInt = i;
    if (i < 0)
      paramInt = 0; 
    if (this.queue.size() > paramInt) {
      mutationBatch = this.queue.get(paramInt);
    } else {
      mutationBatch = null;
    } 
    return mutationBatch;
  }
  
  public boolean isEmpty() {
    return this.queue.isEmpty();
  }
  
  public MutationBatch lookupMutationBatch(int paramInt) {
    boolean bool;
    int i = indexOfBatchId(paramInt);
    if (i < 0 || i >= this.queue.size())
      return null; 
    MutationBatch mutationBatch = this.queue.get(i);
    if (mutationBatch.getBatchId() == paramInt) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "If found batch must match", new Object[0]);
    return mutationBatch;
  }
  
  public void performConsistencyCheck() {
    if (this.queue.isEmpty())
      Assert.hardAssert(this.batchesByDocumentKey.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]); 
  }
  
  public void removeMutationBatch(MutationBatch paramMutationBatch) {
    boolean bool;
    if (indexOfExistingBatchId(paramMutationBatch.getBatchId(), "removed") == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Can only remove the first entry of the mutation queue", new Object[0]);
    this.queue.remove(0);
    ImmutableSortedSet<DocumentReference> immutableSortedSet = this.batchesByDocumentKey;
    Iterator<Mutation> iterator = paramMutationBatch.getMutations().iterator();
    while (iterator.hasNext()) {
      DocumentKey documentKey = ((Mutation)iterator.next()).getKey();
      this.persistence.getReferenceDelegate().removeMutationReference(documentKey);
      immutableSortedSet = immutableSortedSet.remove(new DocumentReference(documentKey, paramMutationBatch.getBatchId()));
    } 
    this.batchesByDocumentKey = immutableSortedSet;
  }
  
  public void setLastStreamToken(ByteString paramByteString) {
    this.lastStreamToken = (ByteString)Preconditions.checkNotNull(paramByteString);
  }
  
  public void start() {
    if (isEmpty())
      this.nextBatchId = 1; 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryMutationQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */