package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

public interface CommitResponseOrBuilder extends MessageLiteOrBuilder {
  Timestamp getCommitTime();
  
  WriteResult getWriteResults(int paramInt);
  
  int getWriteResultsCount();
  
  List<WriteResult> getWriteResultsList();
  
  boolean hasCommitTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\CommitResponseOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */