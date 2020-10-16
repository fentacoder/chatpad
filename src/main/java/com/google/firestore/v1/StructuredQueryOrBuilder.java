package com.google.firestore.v1;

import com.google.protobuf.Int32Value;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface StructuredQueryOrBuilder extends MessageLiteOrBuilder {
  Cursor getEndAt();
  
  StructuredQuery.CollectionSelector getFrom(int paramInt);
  
  int getFromCount();
  
  List<StructuredQuery.CollectionSelector> getFromList();
  
  Int32Value getLimit();
  
  int getOffset();
  
  StructuredQuery.Order getOrderBy(int paramInt);
  
  int getOrderByCount();
  
  List<StructuredQuery.Order> getOrderByList();
  
  StructuredQuery.Projection getSelect();
  
  Cursor getStartAt();
  
  StructuredQuery.Filter getWhere();
  
  boolean hasEndAt();
  
  boolean hasLimit();
  
  boolean hasSelect();
  
  boolean hasStartAt();
  
  boolean hasWhere();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\StructuredQueryOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */