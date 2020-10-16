package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

abstract class AbstractStream<ReqT, RespT, CallbackT extends Stream.StreamCallback> implements Stream<CallbackT> {
  private static final double BACKOFF_FACTOR = 1.5D;
  
  private static final long BACKOFF_INITIAL_DELAY_MS = TimeUnit.SECONDS.toMillis(1L);
  
  private static final long BACKOFF_MAX_DELAY_MS = TimeUnit.MINUTES.toMillis(1L);
  
  private static final long IDLE_TIMEOUT_MS = TimeUnit.MINUTES.toMillis(1L);
  
  final ExponentialBackoff backoff;
  
  private ClientCall<ReqT, RespT> call;
  
  private long closeCount = 0L;
  
  private final FirestoreChannel firestoreChannel;
  
  private final IdleTimeoutRunnable idleTimeoutRunnable;
  
  private AsyncQueue.DelayedTask idleTimer;
  
  private final AsyncQueue.TimerId idleTimerId;
  
  final CallbackT listener;
  
  private final MethodDescriptor<ReqT, RespT> methodDescriptor;
  
  private Stream.State state = Stream.State.Initial;
  
  private final AsyncQueue workerQueue;
  
  AbstractStream(FirestoreChannel paramFirestoreChannel, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, AsyncQueue paramAsyncQueue, AsyncQueue.TimerId paramTimerId1, AsyncQueue.TimerId paramTimerId2, CallbackT paramCallbackT) {
    this.firestoreChannel = paramFirestoreChannel;
    this.methodDescriptor = paramMethodDescriptor;
    this.workerQueue = paramAsyncQueue;
    this.idleTimerId = paramTimerId2;
    this.listener = paramCallbackT;
    this.idleTimeoutRunnable = new IdleTimeoutRunnable();
    this.backoff = new ExponentialBackoff(paramAsyncQueue, paramTimerId1, BACKOFF_INITIAL_DELAY_MS, 1.5D, BACKOFF_MAX_DELAY_MS);
  }
  
  private void cancelIdleCheck() {
    AsyncQueue.DelayedTask delayedTask = this.idleTimer;
    if (delayedTask != null) {
      delayedTask.cancel();
      this.idleTimer = null;
    } 
  }
  
  private void close(Stream.State paramState, Status paramStatus) {
    boolean bool;
    Assert.hardAssert(isStarted(), "Only started streams should be closed.", new Object[0]);
    if (paramState == Stream.State.Error || paramStatus.equals(Status.OK)) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Can't provide an error when not in an error state.", new Object[0]);
    this.workerQueue.verifyIsCurrentThread();
    if (Datastore.isMissingSslCiphers(paramStatus))
      Util.crashMainThread(new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", paramStatus.getCause())); 
    cancelIdleCheck();
    this.backoff.cancel();
    this.closeCount++;
    Status.Code code = paramStatus.getCode();
    if (code == Status.Code.OK) {
      this.backoff.reset();
    } else if (code == Status.Code.RESOURCE_EXHAUSTED) {
      Logger.debug(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
      this.backoff.resetToMax();
    } else if (code == Status.Code.UNAUTHENTICATED) {
      this.firestoreChannel.invalidateToken();
    } 
    if (paramState != Stream.State.Error) {
      Logger.debug(getClass().getSimpleName(), "(%x) Performing stream teardown", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
      tearDown();
    } 
    if (this.call != null) {
      if (paramStatus.isOk()) {
        Logger.debug(getClass().getSimpleName(), "(%x) Closing stream client-side", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
        this.call.halfClose();
      } 
      this.call = null;
    } 
    this.state = paramState;
    this.listener.onClose(paramStatus);
  }
  
  private void handleIdleCloseTimer() {
    if (isOpen())
      close(Stream.State.Initial, Status.OK); 
  }
  
  private void onOpen() {
    this.state = Stream.State.Open;
    this.listener.onOpen();
  }
  
  private void performBackoff() {
    boolean bool;
    if (this.state == Stream.State.Error) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Should only perform backoff in an error state", new Object[0]);
    this.state = Stream.State.Backoff;
    this.backoff.backoffAndRun(AbstractStream$$Lambda$1.lambdaFactory$(this));
  }
  
  void handleServerClose(Status paramStatus) {
    Assert.hardAssert(isStarted(), "Can't handle server close on non-started stream!", new Object[0]);
    close(Stream.State.Error, paramStatus);
  }
  
  public void inhibitBackoff() {
    Assert.hardAssert(isStarted() ^ true, "Can only inhibit backoff after in a stopped state", new Object[0]);
    this.workerQueue.verifyIsCurrentThread();
    this.state = Stream.State.Initial;
    this.backoff.reset();
  }
  
  public boolean isOpen() {
    boolean bool;
    this.workerQueue.verifyIsCurrentThread();
    if (this.state == Stream.State.Open) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isStarted() {
    this.workerQueue.verifyIsCurrentThread();
    return (this.state == Stream.State.Starting || this.state == Stream.State.Open || this.state == Stream.State.Backoff);
  }
  
  void markIdle() {
    if (isOpen() && this.idleTimer == null)
      this.idleTimer = this.workerQueue.enqueueAfterDelay(this.idleTimerId, IDLE_TIMEOUT_MS, this.idleTimeoutRunnable); 
  }
  
  public abstract void onNext(RespT paramRespT);
  
  public void start() {
    boolean bool2;
    this.workerQueue.verifyIsCurrentThread();
    ClientCall<ReqT, RespT> clientCall = this.call;
    boolean bool1 = true;
    if (clientCall == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Assert.hardAssert(bool2, "Last call still set", new Object[0]);
    if (this.idleTimer == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Assert.hardAssert(bool2, "Idle timer still set", new Object[0]);
    if (this.state == Stream.State.Error) {
      performBackoff();
      return;
    } 
    if (this.state == Stream.State.Initial) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Assert.hardAssert(bool2, "Already started", new Object[0]);
    StreamObserver streamObserver = new StreamObserver(new CloseGuardedRunner(this.closeCount));
    this.call = this.firestoreChannel.runBidiStreamingRpc(this.methodDescriptor, streamObserver);
    this.state = Stream.State.Starting;
  }
  
  public void stop() {
    if (isStarted())
      close(Stream.State.Initial, Status.OK); 
  }
  
  protected void tearDown() {}
  
  protected void writeRequest(ReqT paramReqT) {
    this.workerQueue.verifyIsCurrentThread();
    Logger.debug(getClass().getSimpleName(), "(%x) Stream sending: %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramReqT });
    cancelIdleCheck();
    this.call.sendMessage(paramReqT);
  }
  
  class CloseGuardedRunner {
    private final long initialCloseCount;
    
    CloseGuardedRunner(long param1Long) {
      this.initialCloseCount = param1Long;
    }
    
    void run(Runnable param1Runnable) {
      AbstractStream.this.workerQueue.verifyIsCurrentThread();
      if (AbstractStream.this.closeCount == this.initialCloseCount) {
        param1Runnable.run();
      } else {
        Logger.debug(AbstractStream.this.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
      } 
    }
  }
  
  class IdleTimeoutRunnable implements Runnable {
    public void run() {
      AbstractStream.this.handleIdleCloseTimer();
    }
  }
  
  class StreamObserver implements IncomingStreamObserver<RespT> {
    private final AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner dispatcher;
    
    StreamObserver(AbstractStream<ReqT, RespT, CallbackT>.CloseGuardedRunner param1CloseGuardedRunner) {
      this.dispatcher = param1CloseGuardedRunner;
    }
    
    public void onClose(Status param1Status) {
      this.dispatcher.run(AbstractStream$StreamObserver$$Lambda$4.lambdaFactory$(this, param1Status));
    }
    
    public void onHeaders(Metadata param1Metadata) {
      this.dispatcher.run(AbstractStream$StreamObserver$$Lambda$1.lambdaFactory$(this, param1Metadata));
    }
    
    public void onNext(RespT param1RespT) {
      this.dispatcher.run(AbstractStream$StreamObserver$$Lambda$2.lambdaFactory$(this, param1RespT));
    }
    
    public void onOpen() {
      this.dispatcher.run(AbstractStream$StreamObserver$$Lambda$3.lambdaFactory$(this));
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\AbstractStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */