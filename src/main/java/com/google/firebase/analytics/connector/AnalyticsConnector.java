package com.google.firebase.analytics.connector;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnalyticsConnector {
  void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle);
  
  List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2);
  
  int getMaxUserProperties(String paramString);
  
  Map<String, Object> getUserProperties(boolean paramBoolean);
  
  void logEvent(String paramString1, String paramString2, Bundle paramBundle);
  
  AnalyticsConnectorHandle registerAnalyticsConnectorListener(String paramString, AnalyticsConnectorListener paramAnalyticsConnectorListener);
  
  void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty);
  
  void setUserProperty(String paramString1, String paramString2, Object paramObject);
  
  public static interface AnalyticsConnectorHandle {
    void registerEventNames(Set<String> param1Set);
    
    void unregister();
    
    void unregisterEventNames();
  }
  
  public static interface AnalyticsConnectorListener {
    void onMessageTriggered(int param1Int, Bundle param1Bundle);
  }
  
  public static class ConditionalUserProperty {
    public boolean active;
    
    public long creationTimestamp;
    
    public String expiredEventName;
    
    public Bundle expiredEventParams;
    
    public String name;
    
    public String origin;
    
    public long timeToLive;
    
    public String timedOutEventName;
    
    public Bundle timedOutEventParams;
    
    public String triggerEventName;
    
    public long triggerTimeout;
    
    public String triggeredEventName;
    
    public Bundle triggeredEventParams;
    
    public long triggeredTimestamp;
    
    public Object value;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */