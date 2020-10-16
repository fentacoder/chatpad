package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.protobuf.ByteString;
import java.util.List;

interface MutationQueue {
  void acknowledgeBatch(MutationBatch paramMutationBatch, ByteString paramByteString);
  
  MutationBatch addMutationBatch(Timestamp paramTimestamp, List<Mutation> paramList1, List<Mutation> paramList2);
  
  List<MutationBatch> getAllMutationBatches();
  
  List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey paramDocumentKey);
  
  List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> paramIterable);
  
  List<MutationBatch> getAllMutationBatchesAffectingQuery(Query paramQuery);
  
  int getHighestUnacknowledgedBatchId();
  
  ByteString getLastStreamToken();
  
  MutationBatch getNextMutationBatchAfterBatchId(int paramInt);
  
  boolean isEmpty();
  
  MutationBatch lookupMutationBatch(int paramInt);
  
  void performConsistencyCheck();
  
  void removeMutationBatch(MutationBatch paramMutationBatch);
  
  void setLastStreamToken(ByteString paramByteString);
  
  void start();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MutationQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */