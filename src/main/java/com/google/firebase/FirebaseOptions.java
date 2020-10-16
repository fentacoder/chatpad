package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions {
  private static final String API_KEY_RESOURCE_NAME = "google_api_key";
  
  private static final String APP_ID_RESOURCE_NAME = "google_app_id";
  
  private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
  
  private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
  
  private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
  
  private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
  
  private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
  
  private final String apiKey;
  
  private final String applicationId;
  
  private final String databaseUrl;
  
  private final String gaTrackingId;
  
  private final String gcmSenderId;
  
  private final String projectId;
  
  private final String storageBucket;
  
  private FirebaseOptions(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    Preconditions.checkState(Strings.isEmptyOrWhitespace(paramString1) ^ true, "ApplicationId must be set.");
    this.applicationId = paramString1;
    this.apiKey = paramString2;
    this.databaseUrl = paramString3;
    this.gaTrackingId = paramString4;
    this.gcmSenderId = paramString5;
    this.storageBucket = paramString6;
    this.projectId = paramString7;
  }
  
  public static FirebaseOptions fromResource(Context paramContext) {
    StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(paramContext);
    String str = stringResourceValueReader.getString("google_app_id");
    return TextUtils.isEmpty(str) ? null : new FirebaseOptions(str, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof FirebaseOptions;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (Objects.equal(this.applicationId, ((FirebaseOptions)paramObject).applicationId)) {
      bool = bool1;
      if (Objects.equal(this.apiKey, ((FirebaseOptions)paramObject).apiKey)) {
        bool = bool1;
        if (Objects.equal(this.databaseUrl, ((FirebaseOptions)paramObject).databaseUrl)) {
          bool = bool1;
          if (Objects.equal(this.gaTrackingId, ((FirebaseOptions)paramObject).gaTrackingId)) {
            bool = bool1;
            if (Objects.equal(this.gcmSenderId, ((FirebaseOptions)paramObject).gcmSenderId)) {
              bool = bool1;
              if (Objects.equal(this.storageBucket, ((FirebaseOptions)paramObject).storageBucket)) {
                bool = bool1;
                if (Objects.equal(this.projectId, ((FirebaseOptions)paramObject).projectId))
                  bool = true; 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  public String getApiKey() {
    return this.apiKey;
  }
  
  public String getApplicationId() {
    return this.applicationId;
  }
  
  public String getDatabaseUrl() {
    return this.databaseUrl;
  }
  
  public String getGaTrackingId() {
    return this.gaTrackingId;
  }
  
  public String getGcmSenderId() {
    return this.gcmSenderId;
  }
  
  public String getProjectId() {
    return this.projectId;
  }
  
  public String getStorageBucket() {
    return this.storageBucket;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("applicationId", this.applicationId).add("apiKey", this.apiKey).add("databaseUrl", this.databaseUrl).add("gcmSenderId", this.gcmSenderId).add("storageBucket", this.storageBucket).add("projectId", this.projectId).toString();
  }
  
  public static final class Builder {
    private String apiKey;
    
    private String applicationId;
    
    private String databaseUrl;
    
    private String gaTrackingId;
    
    private String gcmSenderId;
    
    private String projectId;
    
    private String storageBucket;
    
    public Builder() {}
    
    public Builder(FirebaseOptions param1FirebaseOptions) {
      this.applicationId = param1FirebaseOptions.applicationId;
      this.apiKey = param1FirebaseOptions.apiKey;
      this.databaseUrl = param1FirebaseOptions.databaseUrl;
      this.gaTrackingId = param1FirebaseOptions.gaTrackingId;
      this.gcmSenderId = param1FirebaseOptions.gcmSenderId;
      this.storageBucket = param1FirebaseOptions.storageBucket;
      this.projectId = param1FirebaseOptions.projectId;
    }
    
    public FirebaseOptions build() {
      return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }
    
    public Builder setApiKey(String param1String) {
      this.apiKey = Preconditions.checkNotEmpty(param1String, "ApiKey must be set.");
      return this;
    }
    
    public Builder setApplicationId(String param1String) {
      this.applicationId = Preconditions.checkNotEmpty(param1String, "ApplicationId must be set.");
      return this;
    }
    
    public Builder setDatabaseUrl(String param1String) {
      this.databaseUrl = param1String;
      return this;
    }
    
    public Builder setGaTrackingId(String param1String) {
      this.gaTrackingId = param1String;
      return this;
    }
    
    public Builder setGcmSenderId(String param1String) {
      this.gcmSenderId = param1String;
      return this;
    }
    
    public Builder setProjectId(String param1String) {
      this.projectId = param1String;
      return this;
    }
    
    public Builder setStorageBucket(String param1String) {
      this.storageBucket = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\FirebaseOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */