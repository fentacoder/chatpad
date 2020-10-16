package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;
import java.util.List;

public interface BatchGetDocumentsRequestOrBuilder extends MessageLiteOrBuilder {
  BatchGetDocumentsRequest.ConsistencySelectorCase getConsistencySelectorCase();
  
  String getDatabase();
  
  ByteString getDatabaseBytes();
  
  String getDocuments(int paramInt);
  
  ByteString getDocumentsBytes(int paramInt);
  
  int getDocumentsCount();
  
  List<String> getDocumentsList();
  
  DocumentMask getMask();
  
  TransactionOptions getNewTransaction();
  
  Timestamp getReadTime();
  
  ByteString getTransaction();
  
  boolean hasMask();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\BatchGetDocumentsRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */