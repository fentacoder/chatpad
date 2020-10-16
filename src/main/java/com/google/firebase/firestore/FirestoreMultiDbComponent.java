package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import java.util.HashMap;
import java.util.Map;

class FirestoreMultiDbComponent implements FirebaseAppLifecycleListener, FirebaseFirestore.InstanceRegistry {
  private final FirebaseApp app;
  
  private final InternalAuthProvider authProvider;
  
  private final Context context;
  
  private final Map<String, FirebaseFirestore> instances = new HashMap<>();
  
  private final GrpcMetadataProvider metadataProvider;
  
  FirestoreMultiDbComponent(Context paramContext, FirebaseApp paramFirebaseApp, InternalAuthProvider paramInternalAuthProvider, GrpcMetadataProvider paramGrpcMetadataProvider) {
    this.context = paramContext;
    this.app = paramFirebaseApp;
    this.authProvider = paramInternalAuthProvider;
    this.metadataProvider = paramGrpcMetadataProvider;
    this.app.addLifecycleEventListener(this);
  }
  
  FirebaseFirestore get(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/google/firebase/firestore/FirebaseFirestore
    //   15: astore_2
    //   16: aload_2
    //   17: astore_3
    //   18: aload_2
    //   19: ifnonnull -> 56
    //   22: aload_0
    //   23: getfield context : Landroid/content/Context;
    //   26: aload_0
    //   27: getfield app : Lcom/google/firebase/FirebaseApp;
    //   30: aload_0
    //   31: getfield authProvider : Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   34: aload_1
    //   35: aload_0
    //   36: aload_0
    //   37: getfield metadataProvider : Lcom/google/firebase/firestore/remote/GrpcMetadataProvider;
    //   40: invokestatic newInstance : (Landroid/content/Context;Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/auth/internal/InternalAuthProvider;Ljava/lang/String;Lcom/google/firebase/firestore/FirebaseFirestore$InstanceRegistry;Lcom/google/firebase/firestore/remote/GrpcMetadataProvider;)Lcom/google/firebase/firestore/FirebaseFirestore;
    //   43: astore_3
    //   44: aload_0
    //   45: getfield instances : Ljava/util/Map;
    //   48: aload_1
    //   49: aload_3
    //   50: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: areturn
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	60	finally
    //   22	56	60	finally
  }
  
  public void onDeleted(String paramString, FirebaseOptions paramFirebaseOptions) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/Map;
    //   6: invokeinterface entrySet : ()Ljava/util/Set;
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 68
    //   26: aload_1
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast java/util/Map$Entry
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface getValue : ()Ljava/lang/Object;
    //   42: checkcast com/google/firebase/firestore/FirebaseFirestore
    //   45: invokevirtual terminateInternal : ()Lcom/google/android/gms/tasks/Task;
    //   48: pop
    //   49: aload_0
    //   50: getfield instances : Ljava/util/Map;
    //   53: aload_2
    //   54: invokeinterface getKey : ()Ljava/lang/Object;
    //   59: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: goto -> 17
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	71	finally
    //   17	65	71	finally
  }
  
  public void remove(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FirestoreMultiDbComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */