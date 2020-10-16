package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.util.Listener;

public abstract class CredentialsProvider {
  public abstract Task<String> getToken();
  
  public abstract void invalidateToken();
  
  public abstract void removeChangeListener();
  
  public abstract void setChangeListener(Listener<User> paramListener);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\auth\CredentialsProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */