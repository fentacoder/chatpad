package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;

public class QueryListener {
  private final EventListener<ViewSnapshot> listener;
  
  private OnlineState onlineState = OnlineState.UNKNOWN;
  
  private final EventManager.ListenOptions options;
  
  private final Query query;
  
  private boolean raisedInitialEvent = false;
  
  private ViewSnapshot snapshot;
  
  public QueryListener(Query paramQuery, EventManager.ListenOptions paramListenOptions, EventListener<ViewSnapshot> paramEventListener) {
    this.query = paramQuery;
    this.listener = paramEventListener;
    this.options = paramListenOptions;
  }
  
  private void raiseInitialEvent(ViewSnapshot paramViewSnapshot) {
    Assert.hardAssert(this.raisedInitialEvent ^ true, "Trying to raise initial event for second time", new Object[0]);
    paramViewSnapshot = ViewSnapshot.fromInitialDocuments(paramViewSnapshot.getQuery(), paramViewSnapshot.getDocuments(), paramViewSnapshot.getMutatedKeys(), paramViewSnapshot.isFromCache(), paramViewSnapshot.excludesMetadataChanges());
    this.raisedInitialEvent = true;
    this.listener.onEvent(paramViewSnapshot, null);
  }
  
  private boolean shouldRaiseEvent(ViewSnapshot paramViewSnapshot) {
    boolean bool = paramViewSnapshot.getChanges().isEmpty();
    boolean bool1 = true;
    if (!bool)
      return true; 
    ViewSnapshot viewSnapshot = this.snapshot;
    if (viewSnapshot == null || viewSnapshot.hasPendingWrites() == paramViewSnapshot.hasPendingWrites())
      bool1 = false; 
    return (paramViewSnapshot.didSyncStateChange() || bool1) ? this.options.includeQueryMetadataChanges : false;
  }
  
  private boolean shouldRaiseInitialEvent(ViewSnapshot paramViewSnapshot, OnlineState paramOnlineState) {
    boolean bool = this.raisedInitialEvent;
    boolean bool1 = true;
    Assert.hardAssert(bool ^ true, "Determining whether to raise first event but already had first event.", new Object[0]);
    if (!paramViewSnapshot.isFromCache())
      return true; 
    bool = paramOnlineState.equals(OnlineState.OFFLINE);
    if (this.options.waitForSyncWhenOnline && (bool ^ true) != 0) {
      Assert.hardAssert(paramViewSnapshot.isFromCache(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
      return false;
    } 
    bool = bool1;
    if (paramViewSnapshot.getDocuments().isEmpty())
      if (paramOnlineState.equals(OnlineState.OFFLINE)) {
        bool = bool1;
      } else {
        bool = false;
      }  
    return bool;
  }
  
  public Query getQuery() {
    return this.query;
  }
  
  public void onError(FirebaseFirestoreException paramFirebaseFirestoreException) {
    this.listener.onEvent(null, paramFirebaseFirestoreException);
  }
  
  public boolean onOnlineStateChanged(OnlineState paramOnlineState) {
    boolean bool;
    this.onlineState = paramOnlineState;
    ViewSnapshot viewSnapshot = this.snapshot;
    if (viewSnapshot != null && !this.raisedInitialEvent && shouldRaiseInitialEvent(viewSnapshot, paramOnlineState)) {
      raiseInitialEvent(this.snapshot);
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean onViewSnapshot(ViewSnapshot paramViewSnapshot) {
    boolean bool = paramViewSnapshot.getChanges().isEmpty();
    boolean bool1 = true;
    if (!bool || paramViewSnapshot.didSyncStateChange()) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "We got a new snapshot with no changes?", new Object[0]);
    ViewSnapshot viewSnapshot = paramViewSnapshot;
    if (!this.options.includeDocumentMetadataChanges) {
      ArrayList<DocumentViewChange> arrayList = new ArrayList();
      for (DocumentViewChange documentViewChange : paramViewSnapshot.getChanges()) {
        if (documentViewChange.getType() != DocumentViewChange.Type.METADATA)
          arrayList.add(documentViewChange); 
      } 
      viewSnapshot = new ViewSnapshot(paramViewSnapshot.getQuery(), paramViewSnapshot.getDocuments(), paramViewSnapshot.getOldDocuments(), arrayList, paramViewSnapshot.isFromCache(), paramViewSnapshot.getMutatedKeys(), paramViewSnapshot.didSyncStateChange(), true);
    } 
    if (!this.raisedInitialEvent) {
      if (shouldRaiseInitialEvent(viewSnapshot, this.onlineState)) {
        raiseInitialEvent(viewSnapshot);
        bool = bool1;
        this.snapshot = viewSnapshot;
        return bool;
      } 
    } else if (shouldRaiseEvent(viewSnapshot)) {
      this.listener.onEvent(viewSnapshot, null);
      bool = bool1;
      this.snapshot = viewSnapshot;
      return bool;
    } 
    bool = false;
    this.snapshot = viewSnapshot;
    return bool;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\QueryListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */