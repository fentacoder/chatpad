package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;

interface QueryCache {
  void addMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt);
  
  void addQueryData(QueryData paramQueryData);
  
  boolean containsKey(DocumentKey paramDocumentKey);
  
  void forEachTarget(Consumer<QueryData> paramConsumer);
  
  long getHighestListenSequenceNumber();
  
  int getHighestTargetId();
  
  SnapshotVersion getLastRemoteSnapshotVersion();
  
  ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int paramInt);
  
  QueryData getQueryData(Target paramTarget);
  
  long getTargetCount();
  
  void removeMatchingKeys(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt);
  
  void removeQueryData(QueryData paramQueryData);
  
  void setLastRemoteSnapshotVersion(SnapshotVersion paramSnapshotVersion);
  
  void updateQueryData(QueryData paramQueryData);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\QueryCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */