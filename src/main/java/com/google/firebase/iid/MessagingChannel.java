package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

public interface MessagingChannel {
  Task<Void> ackMessage(String paramString);
  
  Task<Void> buildChannel(String paramString1, @Nullable String paramString2);
  
  Task<Void> deleteInstanceId(String paramString);
  
  Task<Void> deleteToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  Task<String> getToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  boolean isAvailable();
  
  boolean isChannelBuilt();
  
  boolean needsRefresh();
  
  Task<Void> subscribeToTopic(String paramString1, String paramString2, String paramString3);
  
  Task<Void> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\MessagingChannel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */