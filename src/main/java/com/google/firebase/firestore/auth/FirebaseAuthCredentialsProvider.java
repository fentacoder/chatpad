package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.internal.InternalTokenResult;

public final class FirebaseAuthCredentialsProvider extends CredentialsProvider {
  private final InternalAuthProvider authProvider;
  
  private Listener<User> changeListener;
  
  private User currentUser;
  
  private boolean forceRefresh;
  
  private final IdTokenListener idTokenListener;
  
  private int tokenCounter;
  
  public FirebaseAuthCredentialsProvider(InternalAuthProvider paramInternalAuthProvider) {
    this.authProvider = paramInternalAuthProvider;
    this.idTokenListener = FirebaseAuthCredentialsProvider$$Lambda$1.lambdaFactory$(this);
    this.currentUser = getUser();
    this.tokenCounter = 0;
    paramInternalAuthProvider.addIdTokenListener(this.idTokenListener);
  }
  
  private User getUser() {
    User user;
    String str = this.authProvider.getUid();
    if (str != null) {
      user = new User(str);
    } else {
      user = User.UNAUTHENTICATED;
    } 
    return user;
  }
  
  public Task<String> getToken() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield forceRefresh : Z
    //   6: istore_1
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield forceRefresh : Z
    //   12: aload_0
    //   13: getfield authProvider : Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   16: iload_1
    //   17: invokeinterface getAccessToken : (Z)Lcom/google/android/gms/tasks/Task;
    //   22: aload_0
    //   23: aload_0
    //   24: getfield tokenCounter : I
    //   27: invokestatic lambdaFactory$ : (Lcom/google/firebase/firestore/auth/FirebaseAuthCredentialsProvider;I)Lcom/google/android/gms/tasks/Continuation;
    //   30: invokevirtual continueWith : (Lcom/google/android/gms/tasks/Continuation;)Lcom/google/android/gms/tasks/Task;
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	38	finally
  }
  
  public void invalidateToken() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield forceRefresh : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void removeChangeListener() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield changeListener : Lcom/google/firebase/firestore/util/Listener;
    //   7: aload_0
    //   8: getfield authProvider : Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   11: aload_0
    //   12: getfield idTokenListener : Lcom/google/firebase/auth/internal/IdTokenListener;
    //   15: invokeinterface removeIdTokenListener : (Lcom/google/firebase/auth/internal/IdTokenListener;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void setChangeListener(Listener<User> paramListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield changeListener : Lcom/google/firebase/firestore/util/Listener;
    //   7: aload_1
    //   8: aload_0
    //   9: getfield currentUser : Lcom/google/firebase/firestore/auth/User;
    //   12: invokeinterface onValue : (Ljava/lang/Object;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\auth\FirebaseAuthCredentialsProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */