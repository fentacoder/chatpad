package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DocumentChangeOrBuilder extends MessageLiteOrBuilder {
  Document getDocument();
  
  int getRemovedTargetIds(int paramInt);
  
  int getRemovedTargetIdsCount();
  
  List<Integer> getRemovedTargetIdsList();
  
  int getTargetIds(int paramInt);
  
  int getTargetIdsCount();
  
  List<Integer> getTargetIdsList();
  
  boolean hasDocument();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentChangeOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */