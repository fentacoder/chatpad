package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface CommitRequestOrBuilder extends MessageLiteOrBuilder {
  String getDatabase();
  
  ByteString getDatabaseBytes();
  
  ByteString getTransaction();
  
  Write getWrites(int paramInt);
  
  int getWritesCount();
  
  List<Write> getWritesList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\CommitRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */