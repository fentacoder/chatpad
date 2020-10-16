package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

public interface RunQueryRequestOrBuilder extends MessageLiteOrBuilder {
  RunQueryRequest.ConsistencySelectorCase getConsistencySelectorCase();
  
  TransactionOptions getNewTransaction();
  
  String getParent();
  
  ByteString getParentBytes();
  
  RunQueryRequest.QueryTypeCase getQueryTypeCase();
  
  Timestamp getReadTime();
  
  StructuredQuery getStructuredQuery();
  
  ByteString getTransaction();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\RunQueryRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */