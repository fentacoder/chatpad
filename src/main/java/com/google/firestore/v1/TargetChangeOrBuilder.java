package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.util.List;

public interface TargetChangeOrBuilder extends MessageLiteOrBuilder {
  Status getCause();
  
  Timestamp getReadTime();
  
  ByteString getResumeToken();
  
  TargetChange.TargetChangeType getTargetChangeType();
  
  int getTargetChangeTypeValue();
  
  int getTargetIds(int paramInt);
  
  int getTargetIdsCount();
  
  List<Integer> getTargetIdsList();
  
  boolean hasCause();
  
  boolean hasReadTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\TargetChangeOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */