package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.Listener;

public class EmptyCredentialsProvider extends CredentialsProvider {
  public Task<String> getToken() {
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    taskCompletionSource.setResult(null);
    return taskCompletionSource.getTask();
  }
  
  public void invalidateToken() {}
  
  public void removeChangeListener() {}
  
  public void setChangeListener(Listener<User> paramListener) {
    paramListener.onValue(User.UNAUTHENTICATED);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\auth\EmptyCredentialsProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */