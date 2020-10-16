package com.google.firebase.firestore.model.mutation;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.List;

public final class MutationBatchResult {
  private final MutationBatch batch;
  
  private final SnapshotVersion commitVersion;
  
  private final ImmutableSortedMap<DocumentKey, SnapshotVersion> docVersions;
  
  private final List<MutationResult> mutationResults;
  
  private final ByteString streamToken;
  
  private MutationBatchResult(MutationBatch paramMutationBatch, SnapshotVersion paramSnapshotVersion, List<MutationResult> paramList, ByteString paramByteString, ImmutableSortedMap<DocumentKey, SnapshotVersion> paramImmutableSortedMap) {
    this.batch = paramMutationBatch;
    this.commitVersion = paramSnapshotVersion;
    this.mutationResults = paramList;
    this.streamToken = paramByteString;
    this.docVersions = paramImmutableSortedMap;
  }
  
  public static MutationBatchResult create(MutationBatch paramMutationBatch, SnapshotVersion paramSnapshotVersion, List<MutationResult> paramList, ByteString paramByteString) {
    boolean bool;
    int i = paramMutationBatch.getMutations().size();
    int j = paramList.size();
    byte b = 0;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Mutations sent %d must equal results received %d", new Object[] { Integer.valueOf(paramMutationBatch.getMutations().size()), Integer.valueOf(paramList.size()) });
    ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMap = DocumentCollections.emptyVersionMap();
    List<Mutation> list = paramMutationBatch.getMutations();
    while (b < list.size()) {
      SnapshotVersion snapshotVersion = ((MutationResult)paramList.get(b)).getVersion();
      immutableSortedMap = immutableSortedMap.insert(((Mutation)list.get(b)).getKey(), snapshotVersion);
      b++;
    } 
    return new MutationBatchResult(paramMutationBatch, paramSnapshotVersion, paramList, paramByteString, immutableSortedMap);
  }
  
  public MutationBatch getBatch() {
    return this.batch;
  }
  
  public SnapshotVersion getCommitVersion() {
    return this.commitVersion;
  }
  
  public ImmutableSortedMap<DocumentKey, SnapshotVersion> getDocVersions() {
    return this.docVersions;
  }
  
  public List<MutationResult> getMutationResults() {
    return this.mutationResults;
  }
  
  public ByteString getStreamToken() {
    return this.streamToken;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\MutationBatchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */