package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EventManager implements SyncEngine.SyncEngineCallback {
  private OnlineState onlineState = OnlineState.UNKNOWN;
  
  private final Map<Query, QueryListenersInfo> queries;
  
  private final Set<EventListener<Void>> snapshotsInSyncListeners = new HashSet<>();
  
  private final SyncEngine syncEngine;
  
  public EventManager(SyncEngine paramSyncEngine) {
    this.syncEngine = paramSyncEngine;
    this.queries = new HashMap<>();
    paramSyncEngine.setCallback(this);
  }
  
  private void raiseSnapshotsInSyncEvent() {
    Iterator<EventListener<Void>> iterator = this.snapshotsInSyncListeners.iterator();
    while (iterator.hasNext())
      ((EventListener)iterator.next()).onEvent(null, null); 
  }
  
  public int addQueryListener(QueryListener paramQueryListener) {
    boolean bool;
    Query query = paramQueryListener.getQuery();
    QueryListenersInfo queryListenersInfo = this.queries.get(query);
    if (queryListenersInfo == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      queryListenersInfo = new QueryListenersInfo();
      this.queries.put(query, queryListenersInfo);
    } 
    queryListenersInfo.listeners.add(paramQueryListener);
    Assert.hardAssert(true ^ paramQueryListener.onOnlineStateChanged(this.onlineState), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
    if (queryListenersInfo.viewSnapshot != null && paramQueryListener.onViewSnapshot(queryListenersInfo.viewSnapshot))
      raiseSnapshotsInSyncEvent(); 
    if (bool)
      QueryListenersInfo.access$202(queryListenersInfo, this.syncEngine.listen(query)); 
    return queryListenersInfo.targetId;
  }
  
  public void addSnapshotsInSyncListener(EventListener<Void> paramEventListener) {
    this.snapshotsInSyncListeners.add(paramEventListener);
    paramEventListener.onEvent(null, null);
  }
  
  public void handleOnlineStateChange(OnlineState paramOnlineState) {
    this.onlineState = paramOnlineState;
    Iterator<QueryListenersInfo> iterator = this.queries.values().iterator();
    boolean bool = false;
    label14: while (iterator.hasNext()) {
      Iterator<QueryListener> iterator1 = (iterator.next()).listeners.iterator();
      boolean bool1 = bool;
      while (true) {
        bool = bool1;
        if (iterator1.hasNext()) {
          if (((QueryListener)iterator1.next()).onOnlineStateChanged(paramOnlineState))
            bool1 = true; 
          continue;
        } 
        continue label14;
      } 
    } 
    if (bool)
      raiseSnapshotsInSyncEvent(); 
  }
  
  public void onError(Query paramQuery, Status paramStatus) {
    QueryListenersInfo queryListenersInfo = this.queries.get(paramQuery);
    if (queryListenersInfo != null) {
      Iterator<QueryListener> iterator = queryListenersInfo.listeners.iterator();
      while (iterator.hasNext())
        ((QueryListener)iterator.next()).onError(Util.exceptionFromStatus(paramStatus)); 
    } 
    this.queries.remove(paramQuery);
  }
  
  public void onViewSnapshots(List<ViewSnapshot> paramList) {
    Iterator<ViewSnapshot> iterator = paramList.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      ViewSnapshot viewSnapshot = iterator.next();
      Query query = viewSnapshot.getQuery();
      QueryListenersInfo queryListenersInfo = this.queries.get(query);
      if (queryListenersInfo != null) {
        Iterator<QueryListener> iterator1 = queryListenersInfo.listeners.iterator();
        while (iterator1.hasNext()) {
          if (((QueryListener)iterator1.next()).onViewSnapshot(viewSnapshot))
            bool = true; 
        } 
        QueryListenersInfo.access$102(queryListenersInfo, viewSnapshot);
      } 
    } 
    if (bool)
      raiseSnapshotsInSyncEvent(); 
  }
  
  public void removeQueryListener(QueryListener paramQueryListener) {
    boolean bool;
    Query query = paramQueryListener.getQuery();
    QueryListenersInfo queryListenersInfo = this.queries.get(query);
    if (queryListenersInfo != null) {
      queryListenersInfo.listeners.remove(paramQueryListener);
      bool = queryListenersInfo.listeners.isEmpty();
    } else {
      bool = false;
    } 
    if (bool) {
      this.queries.remove(query);
      this.syncEngine.stopListening(query);
    } 
  }
  
  public void removeSnapshotsInSyncListener(EventListener<Void> paramEventListener) {
    this.snapshotsInSyncListeners.remove(paramEventListener);
  }
  
  public static class ListenOptions {
    public boolean includeDocumentMetadataChanges;
    
    public boolean includeQueryMetadataChanges;
    
    public boolean waitForSyncWhenOnline;
  }
  
  private static class QueryListenersInfo {
    private final List<QueryListener> listeners = new ArrayList<>();
    
    private int targetId;
    
    private ViewSnapshot viewSnapshot;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\EventManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */