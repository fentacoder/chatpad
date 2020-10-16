package com.google.firebase.internal;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

public interface InternalTokenProvider {
  Task<GetTokenResult> getAccessToken(boolean paramBoolean);
  
  String getUid();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\internal\InternalTokenProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */