package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import java.io.Closeable;

public class IndexCursor implements Closeable {
  public void close() {
    throw new RuntimeException("Not yet implemented.");
  }
  
  public DocumentKey getDocumentKey() {
    throw new RuntimeException("Not yet implemented.");
  }
  
  public boolean next() {
    throw new RuntimeException("Not yet implemented.");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\IndexCursor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */