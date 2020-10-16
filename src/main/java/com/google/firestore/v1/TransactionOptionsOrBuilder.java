package com.google.firestore.v1;

import com.google.protobuf.MessageLiteOrBuilder;

public interface TransactionOptionsOrBuilder extends MessageLiteOrBuilder {
  TransactionOptions.ModeCase getModeCase();
  
  TransactionOptions.ReadOnly getReadOnly();
  
  TransactionOptions.ReadWrite getReadWrite();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firestore\v1\TransactionOptionsOrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */