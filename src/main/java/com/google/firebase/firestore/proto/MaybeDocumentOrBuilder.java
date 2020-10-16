package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Document;
import com.google.protobuf.MessageLiteOrBuilder;

public interface MaybeDocumentOrBuilder extends MessageLiteOrBuilder {
  Document getDocument();
  
  MaybeDocument.DocumentTypeCase getDocumentTypeCase();
  
  boolean getHasCommittedMutations();
  
  NoDocument getNoDocument();
  
  UnknownDocument getUnknownDocument();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\proto\MaybeDocumentOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */