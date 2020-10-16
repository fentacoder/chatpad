package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DocumentTransformOrBuilder extends MessageLiteOrBuilder {
  String getDocument();
  
  ByteString getDocumentBytes();
  
  DocumentTransform.FieldTransform getFieldTransforms(int paramInt);
  
  int getFieldTransformsCount();
  
  List<DocumentTransform.FieldTransform> getFieldTransformsList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\DocumentTransformOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */