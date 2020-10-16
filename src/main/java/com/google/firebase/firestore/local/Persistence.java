package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Supplier;

public abstract class Persistence {
  public static boolean INDEXING_SUPPORT_ENABLED;
  
  static final String TAG = Persistence.class.getSimpleName();
  
  static {
    INDEXING_SUPPORT_ENABLED = false;
  }
  
  abstract IndexManager getIndexManager();
  
  abstract MutationQueue getMutationQueue(User paramUser);
  
  abstract QueryCache getQueryCache();
  
  abstract ReferenceDelegate getReferenceDelegate();
  
  abstract RemoteDocumentCache getRemoteDocumentCache();
  
  public abstract boolean isStarted();
  
  abstract <T> T runTransaction(String paramString, Supplier<T> paramSupplier);
  
  abstract void runTransaction(String paramString, Runnable paramRunnable);
  
  public abstract void shutdown();
  
  public abstract void start();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\Persistence.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */