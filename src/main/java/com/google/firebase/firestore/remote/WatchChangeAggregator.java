package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WatchChangeAggregator {
  private Map<DocumentKey, Set<Integer>> pendingDocumentTargetMapping = new HashMap<>();
  
  private Map<DocumentKey, MaybeDocument> pendingDocumentUpdates = new HashMap<>();
  
  private Set<Integer> pendingTargetResets = new HashSet<>();
  
  private final TargetMetadataProvider targetMetadataProvider;
  
  private final Map<Integer, TargetState> targetStates = new HashMap<>();
  
  public WatchChangeAggregator(TargetMetadataProvider paramTargetMetadataProvider) {
    this.targetMetadataProvider = paramTargetMetadataProvider;
  }
  
  private void addDocumentToTarget(int paramInt, MaybeDocument paramMaybeDocument) {
    DocumentViewChange.Type type;
    if (!isActiveTarget(paramInt))
      return; 
    if (targetContainsDocument(paramInt, paramMaybeDocument.getKey())) {
      type = DocumentViewChange.Type.MODIFIED;
    } else {
      type = DocumentViewChange.Type.ADDED;
    } 
    ensureTargetState(paramInt).addDocumentChange(paramMaybeDocument.getKey(), type);
    this.pendingDocumentUpdates.put(paramMaybeDocument.getKey(), paramMaybeDocument);
    ensureDocumentTargetMapping(paramMaybeDocument.getKey()).add(Integer.valueOf(paramInt));
  }
  
  private Set<Integer> ensureDocumentTargetMapping(DocumentKey paramDocumentKey) {
    Set<Integer> set1 = this.pendingDocumentTargetMapping.get(paramDocumentKey);
    Set<Integer> set2 = set1;
    if (set1 == null) {
      set2 = new HashSet();
      this.pendingDocumentTargetMapping.put(paramDocumentKey, set2);
    } 
    return set2;
  }
  
  private TargetState ensureTargetState(int paramInt) {
    TargetState targetState1 = this.targetStates.get(Integer.valueOf(paramInt));
    TargetState targetState2 = targetState1;
    if (targetState1 == null) {
      targetState2 = new TargetState();
      this.targetStates.put(Integer.valueOf(paramInt), targetState2);
    } 
    return targetState2;
  }
  
  private int getCurrentDocumentCountForTarget(int paramInt) {
    TargetChange targetChange = ensureTargetState(paramInt).toTargetChange();
    return this.targetMetadataProvider.getRemoteKeysForTarget(paramInt).size() + targetChange.getAddedDocuments().size() - targetChange.getRemovedDocuments().size();
  }
  
  private Collection<Integer> getTargetIds(WatchChange.WatchTargetChange paramWatchTargetChange) {
    List<Integer> list = paramWatchTargetChange.getTargetIds();
    return (Collection<Integer>)(!list.isEmpty() ? list : this.targetStates.keySet());
  }
  
  private boolean isActiveTarget(int paramInt) {
    boolean bool;
    if (queryDataForActiveTarget(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private QueryData queryDataForActiveTarget(int paramInt) {
    QueryData queryData;
    TargetState targetState = this.targetStates.get(Integer.valueOf(paramInt));
    if (targetState != null && targetState.isPending()) {
      targetState = null;
    } else {
      queryData = this.targetMetadataProvider.getQueryDataForTarget(paramInt);
    } 
    return queryData;
  }
  
  private void removeDocumentFromTarget(int paramInt, DocumentKey paramDocumentKey, MaybeDocument paramMaybeDocument) {
    if (!isActiveTarget(paramInt))
      return; 
    TargetState targetState = ensureTargetState(paramInt);
    if (targetContainsDocument(paramInt, paramDocumentKey)) {
      targetState.addDocumentChange(paramDocumentKey, DocumentViewChange.Type.REMOVED);
    } else {
      targetState.removeDocumentChange(paramDocumentKey);
    } 
    ensureDocumentTargetMapping(paramDocumentKey).add(Integer.valueOf(paramInt));
    if (paramMaybeDocument != null)
      this.pendingDocumentUpdates.put(paramDocumentKey, paramMaybeDocument); 
  }
  
  private void resetTarget(int paramInt) {
    boolean bool;
    if (this.targetStates.get(Integer.valueOf(paramInt)) != null && !((TargetState)this.targetStates.get(Integer.valueOf(paramInt))).isPending()) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Should only reset active targets", new Object[0]);
    this.targetStates.put(Integer.valueOf(paramInt), new TargetState());
    Iterator<DocumentKey> iterator = this.targetMetadataProvider.getRemoteKeysForTarget(paramInt).iterator();
    while (iterator.hasNext())
      removeDocumentFromTarget(paramInt, iterator.next(), null); 
  }
  
  private boolean targetContainsDocument(int paramInt, DocumentKey paramDocumentKey) {
    return this.targetMetadataProvider.getRemoteKeysForTarget(paramInt).contains(paramDocumentKey);
  }
  
  public RemoteEvent createRemoteEvent(SnapshotVersion paramSnapshotVersion) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (Map.Entry<Integer, TargetState> entry : this.targetStates.entrySet()) {
      int i = ((Integer)entry.getKey()).intValue();
      TargetState targetState = (TargetState)entry.getValue();
      QueryData queryData = queryDataForActiveTarget(i);
      if (queryData != null) {
        if (targetState.isCurrent() && queryData.getTarget().isDocumentQuery()) {
          DocumentKey documentKey = DocumentKey.fromPath(queryData.getTarget().getPath());
          if (this.pendingDocumentUpdates.get(documentKey) == null && !targetContainsDocument(i, documentKey))
            removeDocumentFromTarget(i, documentKey, (MaybeDocument)new NoDocument(documentKey, paramSnapshotVersion, false)); 
        } 
        if (targetState.hasChanges()) {
          hashMap.put(Integer.valueOf(i), targetState.toTargetChange());
          targetState.clearChanges();
        } 
      } 
    } 
    HashSet<DocumentKey> hashSet = new HashSet();
    for (Map.Entry<DocumentKey, Set<Integer>> entry : this.pendingDocumentTargetMapping.entrySet()) {
      boolean bool1;
      DocumentKey documentKey = (DocumentKey)entry.getKey();
      Set set = (Set)entry.getValue();
      boolean bool2 = true;
      Iterator<Integer> iterator = set.iterator();
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          QueryData queryData = queryDataForActiveTarget(((Integer)iterator.next()).intValue());
          if (queryData != null && !queryData.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
            bool1 = false;
            break;
          } 
          continue;
        } 
        break;
      } 
      if (bool1)
        hashSet.add(documentKey); 
    } 
    RemoteEvent remoteEvent = new RemoteEvent(paramSnapshotVersion, (Map)Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(this.pendingTargetResets), Collections.unmodifiableMap(this.pendingDocumentUpdates), Collections.unmodifiableSet(hashSet));
    this.pendingDocumentUpdates = new HashMap<>();
    this.pendingDocumentTargetMapping = new HashMap<>();
    this.pendingTargetResets = new HashSet<>();
    return remoteEvent;
  }
  
  public void handleDocumentChange(WatchChange.DocumentChange paramDocumentChange) {
    MaybeDocument maybeDocument = paramDocumentChange.getNewDocument();
    DocumentKey documentKey = paramDocumentChange.getDocumentKey();
    Iterator<Integer> iterator2 = paramDocumentChange.getUpdatedTargetIds().iterator();
    while (iterator2.hasNext()) {
      int i = ((Integer)iterator2.next()).intValue();
      if (maybeDocument instanceof com.google.firebase.firestore.model.Document) {
        addDocumentToTarget(i, maybeDocument);
        continue;
      } 
      if (maybeDocument instanceof NoDocument)
        removeDocumentFromTarget(i, documentKey, maybeDocument); 
    } 
    Iterator<Integer> iterator1 = paramDocumentChange.getRemovedTargetIds().iterator();
    while (iterator1.hasNext())
      removeDocumentFromTarget(((Integer)iterator1.next()).intValue(), documentKey, paramDocumentChange.getNewDocument()); 
  }
  
  public void handleExistenceFilter(WatchChange.ExistenceFilterWatchChange paramExistenceFilterWatchChange) {
    int i = paramExistenceFilterWatchChange.getTargetId();
    int j = paramExistenceFilterWatchChange.getExistenceFilter().getCount();
    QueryData queryData = queryDataForActiveTarget(i);
    if (queryData != null) {
      Target target = queryData.getTarget();
      if (target.isDocumentQuery()) {
        if (j == 0) {
          DocumentKey documentKey = DocumentKey.fromPath(target.getPath());
          removeDocumentFromTarget(i, documentKey, (MaybeDocument)new NoDocument(documentKey, SnapshotVersion.NONE, false));
        } else {
          boolean bool;
          if (j == 1) {
            bool = true;
          } else {
            bool = false;
          } 
          Assert.hardAssert(bool, "Single document existence filter with count: %d", new Object[] { Integer.valueOf(j) });
        } 
      } else if (getCurrentDocumentCountForTarget(i) != j) {
        resetTarget(i);
        this.pendingTargetResets.add(Integer.valueOf(i));
      } 
    } 
  }
  
  public void handleTargetChange(WatchChange.WatchTargetChange paramWatchTargetChange) {
    Iterator<Integer> iterator = getTargetIds(paramWatchTargetChange).iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      TargetState targetState = ensureTargetState(i);
      int j = null.$SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType[paramWatchTargetChange.getChangeType().ordinal()];
      boolean bool = true;
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            if (j != 4) {
              if (j == 5) {
                if (isActiveTarget(i)) {
                  resetTarget(i);
                  targetState.updateResumeToken(paramWatchTargetChange.getResumeToken());
                } 
                continue;
              } 
              throw Assert.fail("Unknown target watch change state: %s", new Object[] { paramWatchTargetChange.getChangeType() });
            } 
            if (isActiveTarget(i)) {
              targetState.markCurrent();
              targetState.updateResumeToken(paramWatchTargetChange.getResumeToken());
            } 
            continue;
          } 
          targetState.recordTargetResponse();
          if (!targetState.isPending())
            removeTarget(i); 
          if (paramWatchTargetChange.getCause() != null)
            bool = false; 
          Assert.hardAssert(bool, "WatchChangeAggregator does not handle errored targets", new Object[0]);
          continue;
        } 
        targetState.recordTargetResponse();
        if (!targetState.isPending())
          targetState.clearChanges(); 
        targetState.updateResumeToken(paramWatchTargetChange.getResumeToken());
        continue;
      } 
      if (isActiveTarget(i))
        targetState.updateResumeToken(paramWatchTargetChange.getResumeToken()); 
    } 
  }
  
  void recordPendingTargetRequest(int paramInt) {
    ensureTargetState(paramInt).recordPendingTargetRequest();
  }
  
  void removeTarget(int paramInt) {
    this.targetStates.remove(Integer.valueOf(paramInt));
  }
  
  public static interface TargetMetadataProvider {
    QueryData getQueryDataForTarget(int param1Int);
    
    ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int param1Int);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\WatchChangeAggregator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */