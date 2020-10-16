package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.Locale;

class OnlineStateTracker {
  private static final String LOG_TAG = "OnlineStateTracker";
  
  private static final int MAX_WATCH_STREAM_FAILURES = 1;
  
  private static final int ONLINE_STATE_TIMEOUT_MS = 10000;
  
  private final OnlineStateCallback onlineStateCallback;
  
  private AsyncQueue.DelayedTask onlineStateTimer;
  
  private boolean shouldWarnClientIsOffline;
  
  private OnlineState state;
  
  private int watchStreamFailures;
  
  private final AsyncQueue workerQueue;
  
  OnlineStateTracker(AsyncQueue paramAsyncQueue, OnlineStateCallback paramOnlineStateCallback) {
    this.workerQueue = paramAsyncQueue;
    this.onlineStateCallback = paramOnlineStateCallback;
    this.state = OnlineState.UNKNOWN;
    this.shouldWarnClientIsOffline = true;
  }
  
  private void clearOnlineStateTimer() {
    AsyncQueue.DelayedTask delayedTask = this.onlineStateTimer;
    if (delayedTask != null) {
      delayedTask.cancel();
      this.onlineStateTimer = null;
    } 
  }
  
  private void logClientOfflineWarningIfNecessary(String paramString) {
    paramString = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", new Object[] { paramString });
    if (this.shouldWarnClientIsOffline) {
      Logger.warn("OnlineStateTracker", "%s", new Object[] { paramString });
      this.shouldWarnClientIsOffline = false;
    } else {
      Logger.debug("OnlineStateTracker", "%s", new Object[] { paramString });
    } 
  }
  
  private void setAndBroadcastState(OnlineState paramOnlineState) {
    if (paramOnlineState != this.state) {
      this.state = paramOnlineState;
      this.onlineStateCallback.handleOnlineStateChange(paramOnlineState);
    } 
  }
  
  void handleWatchStreamFailure(Status paramStatus) {
    OnlineState onlineState1 = this.state;
    OnlineState onlineState2 = OnlineState.ONLINE;
    boolean bool = true;
    if (onlineState1 == onlineState2) {
      boolean bool1;
      setAndBroadcastState(OnlineState.UNKNOWN);
      if (this.watchStreamFailures == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Assert.hardAssert(bool1, "watchStreamFailures must be 0", new Object[0]);
      if (this.onlineStateTimer == null) {
        bool1 = bool;
      } else {
        bool1 = false;
      } 
      Assert.hardAssert(bool1, "onlineStateTimer must be null", new Object[0]);
    } else {
      this.watchStreamFailures++;
      if (this.watchStreamFailures >= 1) {
        clearOnlineStateTimer();
        logClientOfflineWarningIfNecessary(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", new Object[] { Integer.valueOf(1), paramStatus }));
        setAndBroadcastState(OnlineState.OFFLINE);
      } 
    } 
  }
  
  void handleWatchStreamStart() {
    if (this.watchStreamFailures == 0) {
      boolean bool;
      setAndBroadcastState(OnlineState.UNKNOWN);
      if (this.onlineStateTimer == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "onlineStateTimer shouldn't be started yet", new Object[0]);
      this.onlineStateTimer = this.workerQueue.enqueueAfterDelay(AsyncQueue.TimerId.ONLINE_STATE_TIMEOUT, 10000L, OnlineStateTracker$$Lambda$1.lambdaFactory$(this));
    } 
  }
  
  void updateState(OnlineState paramOnlineState) {
    clearOnlineStateTimer();
    this.watchStreamFailures = 0;
    if (paramOnlineState == OnlineState.ONLINE)
      this.shouldWarnClientIsOffline = false; 
    setAndBroadcastState(paramOnlineState);
  }
  
  static interface OnlineStateCallback {
    void handleOnlineStateChange(OnlineState param1OnlineState);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\OnlineStateTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */