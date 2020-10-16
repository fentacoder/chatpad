package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

public interface BatchGetDocumentsResponseOrBuilder extends MessageLiteOrBuilder {
  Document getFound();
  
  String getMissing();
  
  ByteString getMissingBytes();
  
  Timestamp getReadTime();
  
  BatchGetDocumentsResponse.ResultCase getResultCase();
  
  ByteString getTransaction();
  
  boolean hasReadTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\BatchGetDocumentsResponseOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */