package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MutationBatch {
  public static final int UNKNOWN = -1;
  
  private final List<Mutation> baseMutations;
  
  private final int batchId;
  
  private final Timestamp localWriteTime;
  
  private final List<Mutation> mutations;
  
  public MutationBatch(int paramInt, Timestamp paramTimestamp, List<Mutation> paramList1, List<Mutation> paramList2) {
    Assert.hardAssert(paramList2.isEmpty() ^ true, "Cannot create an empty mutation batch", new Object[0]);
    this.batchId = paramInt;
    this.localWriteTime = paramTimestamp;
    this.baseMutations = paramList1;
    this.mutations = paramList2;
  }
  
  public ImmutableSortedMap<DocumentKey, MaybeDocument> applyToLocalDocumentSet(ImmutableSortedMap<DocumentKey, MaybeDocument> paramImmutableSortedMap) {
    for (DocumentKey documentKey : getKeys()) {
      MaybeDocument maybeDocument = applyToLocalView(documentKey, (MaybeDocument)paramImmutableSortedMap.get(documentKey));
      if (maybeDocument != null)
        paramImmutableSortedMap = paramImmutableSortedMap.insert(maybeDocument.getKey(), maybeDocument); 
    } 
    return paramImmutableSortedMap;
  }
  
  public MaybeDocument applyToLocalView(DocumentKey paramDocumentKey, MaybeDocument paramMaybeDocument) {
    boolean bool = false;
    if (paramMaybeDocument != null)
      Assert.hardAssert(paramMaybeDocument.getKey().equals(paramDocumentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", new Object[] { paramDocumentKey, paramMaybeDocument.getKey() }); 
    byte b = 0;
    while (b < this.baseMutations.size()) {
      Mutation mutation = this.baseMutations.get(b);
      MaybeDocument maybeDocument1 = paramMaybeDocument;
      if (mutation.getKey().equals(paramDocumentKey))
        maybeDocument1 = mutation.applyToLocalView(paramMaybeDocument, paramMaybeDocument, this.localWriteTime); 
      b++;
      paramMaybeDocument = maybeDocument1;
    } 
    MaybeDocument maybeDocument = paramMaybeDocument;
    b = bool;
    while (b < this.mutations.size()) {
      Mutation mutation = this.mutations.get(b);
      MaybeDocument maybeDocument1 = maybeDocument;
      if (mutation.getKey().equals(paramDocumentKey))
        maybeDocument1 = mutation.applyToLocalView(maybeDocument, paramMaybeDocument, this.localWriteTime); 
      b++;
      maybeDocument = maybeDocument1;
    } 
    return maybeDocument;
  }
  
  public MaybeDocument applyToRemoteDocument(DocumentKey paramDocumentKey, MaybeDocument paramMaybeDocument, MutationBatchResult paramMutationBatchResult) {
    boolean bool;
    byte b = 0;
    if (paramMaybeDocument != null)
      Assert.hardAssert(paramMaybeDocument.getKey().equals(paramDocumentKey), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", new Object[] { paramDocumentKey, paramMaybeDocument.getKey() }); 
    int i = this.mutations.size();
    List<MutationResult> list = paramMutationBatchResult.getMutationResults();
    if (list.size() == i) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Mismatch between mutations length (%d) and results length (%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(list.size()) });
    while (b < i) {
      Mutation mutation = this.mutations.get(b);
      MaybeDocument maybeDocument = paramMaybeDocument;
      if (mutation.getKey().equals(paramDocumentKey))
        maybeDocument = mutation.applyToRemoteDocument(paramMaybeDocument, list.get(b)); 
      b++;
      paramMaybeDocument = maybeDocument;
    } 
    return paramMaybeDocument;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.batchId != ((MutationBatch)paramObject).batchId || !this.localWriteTime.equals(((MutationBatch)paramObject).localWriteTime) || !this.baseMutations.equals(((MutationBatch)paramObject).baseMutations) || !this.mutations.equals(((MutationBatch)paramObject).mutations))
      bool = false; 
    return bool;
  }
  
  public List<Mutation> getBaseMutations() {
    return this.baseMutations;
  }
  
  public int getBatchId() {
    return this.batchId;
  }
  
  public Set<DocumentKey> getKeys() {
    HashSet<DocumentKey> hashSet = new HashSet();
    Iterator<Mutation> iterator = this.mutations.iterator();
    while (iterator.hasNext())
      hashSet.add(((Mutation)iterator.next()).getKey()); 
    return hashSet;
  }
  
  public Timestamp getLocalWriteTime() {
    return this.localWriteTime;
  }
  
  public List<Mutation> getMutations() {
    return this.mutations;
  }
  
  public int hashCode() {
    return ((this.batchId * 31 + this.localWriteTime.hashCode()) * 31 + this.baseMutations.hashCode()) * 31 + this.mutations.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MutationBatch(batchId=");
    stringBuilder.append(this.batchId);
    stringBuilder.append(", localWriteTime=");
    stringBuilder.append(this.localWriteTime);
    stringBuilder.append(", baseMutations=");
    stringBuilder.append(this.baseMutations);
    stringBuilder.append(", mutations=");
    stringBuilder.append(this.mutations);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\MutationBatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */