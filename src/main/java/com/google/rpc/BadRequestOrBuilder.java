package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface BadRequestOrBuilder extends MessageLiteOrBuilder {
  BadRequest.FieldViolation getFieldViolations(int paramInt);
  
  int getFieldViolationsCount();
  
  List<BadRequest.FieldViolation> getFieldViolationsList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\BadRequestOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */