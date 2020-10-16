package com.google.firebase.firestore.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Timestamp;

public interface NoDocumentOrBuilder extends MessageLiteOrBuilder {
  String getName();
  
  ByteString getNameBytes();
  
  Timestamp getReadTime();
  
  boolean hasReadTime();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\NoDocumentOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */