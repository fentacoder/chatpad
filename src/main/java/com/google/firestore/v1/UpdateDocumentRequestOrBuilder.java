package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;

public interface UpdateDocumentRequestOrBuilder extends MessageLiteOrBuilder {
  Precondition getCurrentDocument();
  
  Document getDocument();
  
  DocumentMask getMask();
  
  DocumentMask getUpdateMask();
  
  boolean hasCurrentDocument();
  
  boolean hasDocument();
  
  boolean hasMask();
  
  boolean hasUpdateMask();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\UpdateDocumentRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */