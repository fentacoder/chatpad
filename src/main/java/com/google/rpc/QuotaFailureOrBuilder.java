package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface QuotaFailureOrBuilder extends MessageLiteOrBuilder {
  QuotaFailure.Violation getViolations(int paramInt);
  
  int getViolationsCount();
  
  List<QuotaFailure.Violation> getViolationsList();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\rpc\QuotaFailureOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */