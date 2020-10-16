package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RemoteStore implements WatchChangeAggregator.TargetMetadataProvider {
  private static final String LOG_TAG = "RemoteStore";
  
  private static final int MAX_PENDING_WRITES = 10;
  
  private final ConnectivityMonitor connectivityMonitor;
  
  private final Datastore datastore;
  
  private final Map<Integer, QueryData> listenTargets;
  
  private final LocalStore localStore;
  
  private boolean networkEnabled = false;
  
  private final OnlineStateTracker onlineStateTracker;
  
  private final RemoteStoreCallback remoteStoreCallback;
  
  private WatchChangeAggregator watchChangeAggregator;
  
  private final WatchStream watchStream;
  
  private final Deque<MutationBatch> writePipeline;
  
  private final WriteStream writeStream;
  
  public RemoteStore(RemoteStoreCallback paramRemoteStoreCallback, LocalStore paramLocalStore, Datastore paramDatastore, AsyncQueue paramAsyncQueue, ConnectivityMonitor paramConnectivityMonitor) {
    this.remoteStoreCallback = paramRemoteStoreCallback;
    this.localStore = paramLocalStore;
    this.datastore = paramDatastore;
    this.connectivityMonitor = paramConnectivityMonitor;
    this.listenTargets = new HashMap<>();
    this.writePipeline = new ArrayDeque<>();
    paramRemoteStoreCallback.getClass();
    this.onlineStateTracker = new OnlineStateTracker(paramAsyncQueue, RemoteStore$$Lambda$1.lambdaFactory$(paramRemoteStoreCallback));
    this.watchStream = paramDatastore.createWatchStream(new WatchStream.Callback() {
          public void onClose(Status param1Status) {
            RemoteStore.this.handleWatchStreamClose(param1Status);
          }
          
          public void onOpen() {
            RemoteStore.this.handleWatchStreamOpen();
          }
          
          public void onWatchChange(SnapshotVersion param1SnapshotVersion, WatchChange param1WatchChange) {
            RemoteStore.this.handleWatchChange(param1SnapshotVersion, param1WatchChange);
          }
        });
    this.writeStream = paramDatastore.createWriteStream(new WriteStream.Callback() {
          public void onClose(Status param1Status) {
            RemoteStore.this.handleWriteStreamClose(param1Status);
          }
          
          public void onHandshakeComplete() {
            RemoteStore.this.handleWriteStreamHandshakeComplete();
          }
          
          public void onOpen() {
            RemoteStore.this.writeStream.writeHandshake();
          }
          
          public void onWriteResponse(SnapshotVersion param1SnapshotVersion, List<MutationResult> param1List) {
            RemoteStore.this.handleWriteStreamMutationResults(param1SnapshotVersion, param1List);
          }
        });
    paramConnectivityMonitor.addCallback(RemoteStore$$Lambda$2.lambdaFactory$(this, paramAsyncQueue));
  }
  
  private void addToWritePipeline(MutationBatch paramMutationBatch) {
    Assert.hardAssert(canAddToWritePipeline(), "addToWritePipeline called when pipeline is full", new Object[0]);
    this.writePipeline.add(paramMutationBatch);
    if (this.writeStream.isOpen() && this.writeStream.isHandshakeComplete())
      this.writeStream.writeMutations(paramMutationBatch.getMutations()); 
  }
  
  private boolean canAddToWritePipeline() {
    boolean bool;
    if (canUseNetwork() && this.writePipeline.size() < 10) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void cleanUpWatchStreamState() {
    this.watchChangeAggregator = null;
  }
  
  private void disableNetworkInternal() {
    this.watchStream.stop();
    this.writeStream.stop();
    if (!this.writePipeline.isEmpty()) {
      Logger.debug("RemoteStore", "Stopping write stream with %d pending writes", new Object[] { Integer.valueOf(this.writePipeline.size()) });
      this.writePipeline.clear();
    } 
    cleanUpWatchStreamState();
  }
  
  private void handleWatchChange(SnapshotVersion paramSnapshotVersion, WatchChange paramWatchChange) {
    WatchChange.WatchTargetChange watchTargetChange;
    this.onlineStateTracker.updateState(OnlineState.ONLINE);
    if (this.watchStream != null && this.watchChangeAggregator != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
    boolean bool = paramWatchChange instanceof WatchChange.WatchTargetChange;
    if (bool) {
      watchTargetChange = (WatchChange.WatchTargetChange)paramWatchChange;
    } else {
      watchTargetChange = null;
    } 
    if (watchTargetChange != null && watchTargetChange.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) && watchTargetChange.getCause() != null) {
      processTargetError(watchTargetChange);
    } else {
      if (paramWatchChange instanceof WatchChange.DocumentChange) {
        this.watchChangeAggregator.handleDocumentChange((WatchChange.DocumentChange)paramWatchChange);
      } else if (paramWatchChange instanceof WatchChange.ExistenceFilterWatchChange) {
        this.watchChangeAggregator.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange)paramWatchChange);
      } else {
        Assert.hardAssert(bool, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
        this.watchChangeAggregator.handleTargetChange((WatchChange.WatchTargetChange)paramWatchChange);
      } 
      if (!paramSnapshotVersion.equals(SnapshotVersion.NONE) && paramSnapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) >= 0)
        raiseWatchSnapshot(paramSnapshotVersion); 
    } 
  }
  
  private void handleWatchStreamClose(Status paramStatus) {
    if (Status.OK.equals(paramStatus))
      Assert.hardAssert(shouldStartWatchStream() ^ true, "Watch stream was stopped gracefully while still needed.", new Object[0]); 
    cleanUpWatchStreamState();
    if (shouldStartWatchStream()) {
      this.onlineStateTracker.handleWatchStreamFailure(paramStatus);
      startWatchStream();
    } else {
      this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    } 
  }
  
  private void handleWatchStreamOpen() {
    Iterator<QueryData> iterator = this.listenTargets.values().iterator();
    while (iterator.hasNext())
      sendWatchRequest(iterator.next()); 
  }
  
  private void handleWriteError(Status paramStatus) {
    Assert.hardAssert(paramStatus.isOk() ^ true, "Handling write error with status OK.", new Object[0]);
    if (Datastore.isPermanentWriteError(paramStatus)) {
      MutationBatch mutationBatch = this.writePipeline.poll();
      this.writeStream.inhibitBackoff();
      this.remoteStoreCallback.handleRejectedWrite(mutationBatch.getBatchId(), paramStatus);
      fillWritePipeline();
    } 
  }
  
  private void handleWriteHandshakeError(Status paramStatus) {
    Assert.hardAssert(paramStatus.isOk() ^ true, "Handling write error with status OK.", new Object[0]);
    if (Datastore.isPermanentError(paramStatus)) {
      Logger.debug("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", new Object[] { Util.toDebugString(this.writeStream.getLastStreamToken()), paramStatus });
      this.writeStream.setLastStreamToken(WriteStream.EMPTY_STREAM_TOKEN);
      this.localStore.setLastStreamToken(WriteStream.EMPTY_STREAM_TOKEN);
    } 
  }
  
  private void handleWriteStreamClose(Status paramStatus) {
    if (Status.OK.equals(paramStatus))
      Assert.hardAssert(shouldStartWriteStream() ^ true, "Write stream was stopped gracefully while still needed.", new Object[0]); 
    if (!paramStatus.isOk() && !this.writePipeline.isEmpty())
      if (this.writeStream.isHandshakeComplete()) {
        handleWriteError(paramStatus);
      } else {
        handleWriteHandshakeError(paramStatus);
      }  
    if (shouldStartWriteStream())
      startWriteStream(); 
  }
  
  private void handleWriteStreamHandshakeComplete() {
    this.localStore.setLastStreamToken(this.writeStream.getLastStreamToken());
    for (MutationBatch mutationBatch : this.writePipeline)
      this.writeStream.writeMutations(mutationBatch.getMutations()); 
  }
  
  private void handleWriteStreamMutationResults(SnapshotVersion paramSnapshotVersion, List<MutationResult> paramList) {
    MutationBatchResult mutationBatchResult = MutationBatchResult.create(this.writePipeline.poll(), paramSnapshotVersion, paramList, this.writeStream.getLastStreamToken());
    this.remoteStoreCallback.handleSuccessfulWrite(mutationBatchResult);
    fillWritePipeline();
  }
  
  private void processTargetError(WatchChange.WatchTargetChange paramWatchTargetChange) {
    boolean bool;
    if (paramWatchTargetChange.getCause() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Processing target error without a cause", new Object[0]);
    for (Integer integer : paramWatchTargetChange.getTargetIds()) {
      if (this.listenTargets.containsKey(integer)) {
        this.listenTargets.remove(integer);
        this.watchChangeAggregator.removeTarget(integer.intValue());
        this.remoteStoreCallback.handleRejectedListen(integer.intValue(), paramWatchTargetChange.getCause());
      } 
    } 
  }
  
  private void raiseWatchSnapshot(SnapshotVersion paramSnapshotVersion) {
    Assert.hardAssert(paramSnapshotVersion.equals(SnapshotVersion.NONE) ^ true, "Can't raise event for unknown SnapshotVersion", new Object[0]);
    RemoteEvent remoteEvent = this.watchChangeAggregator.createRemoteEvent(paramSnapshotVersion);
    for (Map.Entry<Integer, TargetChange> entry : remoteEvent.getTargetChanges().entrySet()) {
      TargetChange targetChange = (TargetChange)entry.getValue();
      if (!targetChange.getResumeToken().isEmpty()) {
        int i = ((Integer)entry.getKey()).intValue();
        QueryData queryData = this.listenTargets.get(Integer.valueOf(i));
        if (queryData != null)
          this.listenTargets.put(Integer.valueOf(i), queryData.withResumeToken(targetChange.getResumeToken(), paramSnapshotVersion)); 
      } 
    } 
    Iterator<Integer> iterator = remoteEvent.getTargetMismatches().iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      QueryData queryData = this.listenTargets.get(Integer.valueOf(i));
      if (queryData != null) {
        this.listenTargets.put(Integer.valueOf(i), queryData.withResumeToken(ByteString.EMPTY, queryData.getSnapshotVersion()));
        sendUnwatchRequest(i);
        sendWatchRequest(new QueryData(queryData.getTarget(), i, queryData.getSequenceNumber(), QueryPurpose.EXISTENCE_FILTER_MISMATCH));
      } 
    } 
    this.remoteStoreCallback.handleRemoteEvent(remoteEvent);
  }
  
  private void restartNetwork() {
    this.networkEnabled = false;
    disableNetworkInternal();
    this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    enableNetwork();
  }
  
  private void sendUnwatchRequest(int paramInt) {
    this.watchChangeAggregator.recordPendingTargetRequest(paramInt);
    this.watchStream.unwatchTarget(paramInt);
  }
  
  private void sendWatchRequest(QueryData paramQueryData) {
    this.watchChangeAggregator.recordPendingTargetRequest(paramQueryData.getTargetId());
    this.watchStream.watchQuery(paramQueryData);
  }
  
  private boolean shouldStartWatchStream() {
    boolean bool;
    if (canUseNetwork() && !this.watchStream.isStarted() && !this.listenTargets.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean shouldStartWriteStream() {
    boolean bool;
    if (canUseNetwork() && !this.writeStream.isStarted() && !this.writePipeline.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void startWatchStream() {
    Assert.hardAssert(shouldStartWatchStream(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
    this.watchChangeAggregator = new WatchChangeAggregator(this);
    this.watchStream.start();
    this.onlineStateTracker.handleWatchStreamStart();
  }
  
  private void startWriteStream() {
    Assert.hardAssert(shouldStartWriteStream(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
    this.writeStream.start();
  }
  
  public boolean canUseNetwork() {
    return this.networkEnabled;
  }
  
  public Transaction createTransaction() {
    return new Transaction(this.datastore);
  }
  
  public void disableNetwork() {
    this.networkEnabled = false;
    disableNetworkInternal();
    this.onlineStateTracker.updateState(OnlineState.OFFLINE);
  }
  
  public void enableNetwork() {
    this.networkEnabled = true;
    if (canUseNetwork()) {
      this.writeStream.setLastStreamToken(this.localStore.getLastStreamToken());
      if (shouldStartWatchStream()) {
        startWatchStream();
      } else {
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
      } 
      fillWritePipeline();
    } 
  }
  
  public void fillWritePipeline() {
    int i;
    if (this.writePipeline.isEmpty()) {
      i = -1;
    } else {
      i = ((MutationBatch)this.writePipeline.getLast()).getBatchId();
    } 
    while (canAddToWritePipeline()) {
      MutationBatch mutationBatch = this.localStore.getNextMutationBatch(i);
      if (mutationBatch == null) {
        if (this.writePipeline.size() == 0)
          this.writeStream.markIdle(); 
        break;
      } 
      addToWritePipeline(mutationBatch);
      i = mutationBatch.getBatchId();
    } 
    if (shouldStartWriteStream())
      startWriteStream(); 
  }
  
  void forceEnableNetwork() {
    enableNetwork();
    this.onlineStateTracker.updateState(OnlineState.ONLINE);
  }
  
  public QueryData getQueryDataForTarget(int paramInt) {
    return this.listenTargets.get(Integer.valueOf(paramInt));
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int paramInt) {
    return this.remoteStoreCallback.getRemoteKeysForTarget(paramInt);
  }
  
  public void handleCredentialChange() {
    if (canUseNetwork()) {
      Logger.debug("RemoteStore", "Restarting streams for new credential.", new Object[0]);
      restartNetwork();
    } 
  }
  
  public void listen(QueryData paramQueryData) {
    Integer integer = Integer.valueOf(paramQueryData.getTargetId());
    if (this.listenTargets.containsKey(integer))
      return; 
    this.listenTargets.put(integer, paramQueryData);
    if (shouldStartWatchStream()) {
      startWatchStream();
    } else if (this.watchStream.isOpen()) {
      sendWatchRequest(paramQueryData);
    } 
  }
  
  public void shutdown() {
    Logger.debug("RemoteStore", "Shutting down", new Object[0]);
    this.connectivityMonitor.shutdown();
    this.networkEnabled = false;
    disableNetworkInternal();
    this.datastore.shutdown();
    this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
  }
  
  public void start() {
    enableNetwork();
  }
  
  public void stopListening(int paramInt) {
    boolean bool;
    if ((QueryData)this.listenTargets.remove(Integer.valueOf(paramInt)) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "stopListening called on target no currently watched: %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.watchStream.isOpen())
      sendUnwatchRequest(paramInt); 
    if (this.listenTargets.isEmpty())
      if (this.watchStream.isOpen()) {
        this.watchStream.markIdle();
      } else if (canUseNetwork()) {
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
      }  
  }
  
  public static interface RemoteStoreCallback {
    ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int param1Int);
    
    void handleOnlineStateChange(OnlineState param1OnlineState);
    
    void handleRejectedListen(int param1Int, Status param1Status);
    
    void handleRejectedWrite(int param1Int, Status param1Status);
    
    void handleRemoteEvent(RemoteEvent param1RemoteEvent);
    
    void handleSuccessfulWrite(MutationBatchResult param1MutationBatchResult);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\RemoteStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */