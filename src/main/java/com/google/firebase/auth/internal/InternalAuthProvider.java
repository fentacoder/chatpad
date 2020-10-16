package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

public interface InternalAuthProvider extends InternalTokenProvider {
  void addIdTokenListener(IdTokenListener paramIdTokenListener);
  
  Task<GetTokenResult> getAccessToken(boolean paramBoolean);
  
  String getUid();
  
  void removeIdTokenListener(IdTokenListener paramIdTokenListener);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\InternalAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */