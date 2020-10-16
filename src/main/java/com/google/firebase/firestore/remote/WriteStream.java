package com.google.firebase.firestore.remote;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteStream extends AbstractStream<WriteRequest, WriteResponse, WriteStream.Callback> {
  public static final ByteString EMPTY_STREAM_TOKEN = ByteString.EMPTY;
  
  protected boolean handshakeComplete = false;
  
  private ByteString lastStreamToken = EMPTY_STREAM_TOKEN;
  
  private final RemoteSerializer serializer;
  
  WriteStream(FirestoreChannel paramFirestoreChannel, AsyncQueue paramAsyncQueue, RemoteSerializer paramRemoteSerializer, Callback paramCallback) {
    super(paramFirestoreChannel, FirestoreGrpc.getWriteMethod(), paramAsyncQueue, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, paramCallback);
    this.serializer = paramRemoteSerializer;
  }
  
  ByteString getLastStreamToken() {
    return this.lastStreamToken;
  }
  
  boolean isHandshakeComplete() {
    return this.handshakeComplete;
  }
  
  public void onNext(WriteResponse paramWriteResponse) {
    this.lastStreamToken = paramWriteResponse.getStreamToken();
    if (!this.handshakeComplete) {
      this.handshakeComplete = true;
      this.listener.onHandshakeComplete();
    } else {
      this.backoff.reset();
      SnapshotVersion snapshotVersion = this.serializer.decodeVersion(paramWriteResponse.getCommitTime());
      int i = paramWriteResponse.getWriteResultsCount();
      ArrayList<MutationResult> arrayList = new ArrayList(i);
      for (byte b = 0; b < i; b++) {
        WriteResult writeResult = paramWriteResponse.getWriteResults(b);
        arrayList.add(this.serializer.decodeMutationResult(writeResult, snapshotVersion));
      } 
      this.listener.onWriteResponse(snapshotVersion, arrayList);
    } 
  }
  
  void setLastStreamToken(ByteString paramByteString) {
    this.lastStreamToken = (ByteString)Preconditions.checkNotNull(paramByteString);
  }
  
  public void start() {
    this.handshakeComplete = false;
    super.start();
  }
  
  protected void tearDown() {
    if (this.handshakeComplete)
      writeMutations(Collections.emptyList()); 
  }
  
  void writeHandshake() {
    Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[0]);
    Assert.hardAssert(this.handshakeComplete ^ true, "Handshake already completed", new Object[0]);
    writeRequest((WriteRequest)WriteRequest.newBuilder().setDatabase(this.serializer.databaseName()).build());
  }
  
  void writeMutations(List<Mutation> paramList) {
    Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[0]);
    Assert.hardAssert(this.handshakeComplete, "Handshake must be complete before writing mutations", new Object[0]);
    WriteRequest.Builder builder = WriteRequest.newBuilder();
    for (Mutation mutation : paramList)
      builder.addWrites(this.serializer.encodeMutation(mutation)); 
    builder.setStreamToken(this.lastStreamToken);
    writeRequest((WriteRequest)builder.build());
  }
  
  public static interface Callback extends Stream.StreamCallback {
    void onHandshakeComplete();
    
    void onWriteResponse(SnapshotVersion param1SnapshotVersion, List<MutationResult> param1List);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\WriteStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */