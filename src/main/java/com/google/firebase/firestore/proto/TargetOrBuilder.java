package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Target;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

public interface TargetOrBuilder extends MessageLiteOrBuilder {
  Target.DocumentsTarget getDocuments();
  
  Timestamp getLastLimboFreeSnapshotVersion();
  
  long getLastListenSequenceNumber();
  
  Target.QueryTarget getQuery();
  
  ByteString getResumeToken();
  
  Timestamp getSnapshotVersion();
  
  int getTargetId();
  
  Target.TargetTypeCase getTargetTypeCase();
  
  boolean hasLastLimboFreeSnapshotVersion();
  
  boolean hasSnapshotVersion();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\TargetOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */