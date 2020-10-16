package com.google.firebase.storage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

class FirebaseStorageComponent {
  private final FirebaseApp app;
  
  private final Provider<InternalAuthProvider> authProvider;
  
  private final Map<String, FirebaseStorage> instances = new HashMap<>();
  
  FirebaseStorageComponent(FirebaseApp paramFirebaseApp, Provider<InternalAuthProvider> paramProvider) {
    this.app = paramFirebaseApp;
    this.authProvider = paramProvider;
  }
  
  void clearInstancesForTesting() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/Map;
    //   6: invokeinterface clear : ()V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  FirebaseStorage get(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/google/firebase/storage/FirebaseStorage
    //   15: astore_2
    //   16: aload_2
    //   17: astore_3
    //   18: aload_2
    //   19: ifnonnull -> 51
    //   22: new com/google/firebase/storage/FirebaseStorage
    //   25: astore_3
    //   26: aload_3
    //   27: aload_1
    //   28: aload_0
    //   29: getfield app : Lcom/google/firebase/FirebaseApp;
    //   32: aload_0
    //   33: getfield authProvider : Lcom/google/firebase/inject/Provider;
    //   36: invokespecial <init> : (Ljava/lang/String;Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/inject/Provider;)V
    //   39: aload_0
    //   40: getfield instances : Ljava/util/Map;
    //   43: aload_1
    //   44: aload_3
    //   45: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: areturn
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	55	finally
    //   22	51	55	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\FirebaseStorageComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */