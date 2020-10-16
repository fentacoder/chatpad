package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.local.QueryData;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.protobuf.ByteString;
import java.util.Map;

public class WatchStream extends AbstractStream<ListenRequest, ListenResponse, WatchStream.Callback> {
  public static final ByteString EMPTY_RESUME_TOKEN = ByteString.EMPTY;
  
  private final RemoteSerializer serializer;
  
  WatchStream(FirestoreChannel paramFirestoreChannel, AsyncQueue paramAsyncQueue, RemoteSerializer paramRemoteSerializer, Callback paramCallback) {
    super(paramFirestoreChannel, FirestoreGrpc.getListenMethod(), paramAsyncQueue, AsyncQueue.TimerId.LISTEN_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.LISTEN_STREAM_IDLE, paramCallback);
    this.serializer = paramRemoteSerializer;
  }
  
  public void onNext(ListenResponse paramListenResponse) {
    this.backoff.reset();
    WatchChange watchChange = this.serializer.decodeWatchChange(paramListenResponse);
    SnapshotVersion snapshotVersion = this.serializer.decodeVersionFromListenResponse(paramListenResponse);
    this.listener.onWatchChange(snapshotVersion, watchChange);
  }
  
  public void unwatchTarget(int paramInt) {
    Assert.hardAssert(isOpen(), "Unwatching targets requires an open stream", new Object[0]);
    writeRequest((ListenRequest)ListenRequest.newBuilder().setDatabase(this.serializer.databaseName()).setRemoveTarget(paramInt).build());
  }
  
  public void watchQuery(QueryData paramQueryData) {
    Assert.hardAssert(isOpen(), "Watching queries requires an open stream", new Object[0]);
    ListenRequest.Builder builder = ListenRequest.newBuilder().setDatabase(this.serializer.databaseName()).setAddTarget(this.serializer.encodeTarget(paramQueryData));
    Map<String, String> map = this.serializer.encodeListenRequestLabels(paramQueryData);
    if (map != null)
      builder.putAllLabels(map); 
    writeRequest((ListenRequest)builder.build());
  }
  
  static interface Callback extends Stream.StreamCallback {
    void onWatchChange(SnapshotVersion param1SnapshotVersion, WatchChange param1WatchChange);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\WatchStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */