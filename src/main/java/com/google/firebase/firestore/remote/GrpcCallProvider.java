package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.android.AndroidChannelBuilder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GrpcCallProvider {
  private static final String LOG_TAG = "GrpcCallProvider";
  
  private static Supplier<ManagedChannelBuilder<?>> overrideChannelBuilderSupplier;
  
  private final AsyncQueue asyncQueue;
  
  private CallOptions callOptions;
  
  private final Task<ManagedChannel> channelTask;
  
  GrpcCallProvider(AsyncQueue paramAsyncQueue, Context paramContext, DatabaseInfo paramDatabaseInfo, CallCredentials paramCallCredentials) {
    this.asyncQueue = paramAsyncQueue;
    this.channelTask = Tasks.call(Executors.BACKGROUND_EXECUTOR, GrpcCallProvider$$Lambda$1.lambdaFactory$(this, paramContext, paramDatabaseInfo, paramCallCredentials, paramAsyncQueue));
  }
  
  private ManagedChannel initChannel(Context paramContext, DatabaseInfo paramDatabaseInfo) {
    ManagedChannelBuilder managedChannelBuilder;
    try {
      ProviderInstaller.installIfNeeded(paramContext);
    } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
      Logger.warn("GrpcCallProvider", "Failed to update ssl context: %s", new Object[] { googlePlayServicesNotAvailableException });
    } catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
    
    } catch (IllegalStateException illegalStateException) {}
    Supplier<ManagedChannelBuilder<?>> supplier = overrideChannelBuilderSupplier;
    if (supplier != null) {
      managedChannelBuilder = (ManagedChannelBuilder)supplier.get();
    } else {
      ManagedChannelBuilder managedChannelBuilder1 = ManagedChannelBuilder.forTarget(managedChannelBuilder.getHost());
      if (!managedChannelBuilder.isSslEnabled())
        managedChannelBuilder1.usePlaintext(); 
      managedChannelBuilder = managedChannelBuilder1;
    } 
    managedChannelBuilder.keepAliveTime(30L, TimeUnit.SECONDS);
    return AndroidChannelBuilder.fromBuilder(managedChannelBuilder).context(paramContext).build();
  }
  
  public static void overrideChannelBuilder(Supplier<ManagedChannelBuilder<?>> paramSupplier) {
    overrideChannelBuilderSupplier = paramSupplier;
  }
  
  <ReqT, RespT> Task<ClientCall<ReqT, RespT>> createClientCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor) {
    return this.channelTask.continueWithTask(this.asyncQueue.getExecutor(), GrpcCallProvider$$Lambda$2.lambdaFactory$(this, paramMethodDescriptor));
  }
  
  void shutdown() {
    try {
      ManagedChannel managedChannel = (ManagedChannel)Tasks.await(this.channelTask);
      managedChannel.shutdown();
      try {
        if (!managedChannel.awaitTermination(1L, TimeUnit.SECONDS)) {
          Logger.debug(FirestoreChannel.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
          managedChannel.shutdownNow();
          if (!managedChannel.awaitTermination(60L, TimeUnit.SECONDS))
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]); 
        } 
      } catch (InterruptedException interruptedException) {
        managedChannel.shutdownNow();
        Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
        Thread.currentThread().interrupt();
      } 
      return;
    } catch (ExecutionException executionException) {
      Logger.warn(FirestoreChannel.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", new Object[] { executionException });
      return;
    } catch (InterruptedException interruptedException) {
      Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
      Thread.currentThread().interrupt();
      return;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\GrpcCallProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */