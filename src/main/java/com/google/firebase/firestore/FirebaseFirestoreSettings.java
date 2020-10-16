package com.google.firebase.firestore;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public final class FirebaseFirestoreSettings {
  public static final long CACHE_SIZE_UNLIMITED = -1L;
  
  private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600L;
  
  private static final String DEFAULT_HOST = "firestore.googleapis.com";
  
  private static final boolean DEFAULT_TIMESTAMPS_IN_SNAPSHOTS_ENABLED = true;
  
  private static final long MINIMUM_CACHE_BYTES = 1048576L;
  
  private final long cacheSizeBytes;
  
  private final String host;
  
  private final boolean persistenceEnabled;
  
  private final boolean sslEnabled;
  
  private final boolean timestampsInSnapshotsEnabled;
  
  private FirebaseFirestoreSettings(Builder paramBuilder) {
    this.host = paramBuilder.host;
    this.sslEnabled = paramBuilder.sslEnabled;
    this.persistenceEnabled = paramBuilder.persistenceEnabled;
    this.timestampsInSnapshotsEnabled = paramBuilder.timestampsInSnapshotsEnabled;
    this.cacheSizeBytes = paramBuilder.cacheSizeBytes;
  }
  
  public boolean areTimestampsInSnapshotsEnabled() {
    return this.timestampsInSnapshotsEnabled;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!this.host.equals(((FirebaseFirestoreSettings)paramObject).host) || this.sslEnabled != ((FirebaseFirestoreSettings)paramObject).sslEnabled || this.persistenceEnabled != ((FirebaseFirestoreSettings)paramObject).persistenceEnabled || this.timestampsInSnapshotsEnabled != ((FirebaseFirestoreSettings)paramObject).timestampsInSnapshotsEnabled || this.cacheSizeBytes != ((FirebaseFirestoreSettings)paramObject).cacheSizeBytes)
      bool = false; 
    return bool;
  }
  
  public long getCacheSizeBytes() {
    return this.cacheSizeBytes;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public int hashCode() {
    return (((this.host.hashCode() * 31 + this.sslEnabled) * 31 + this.persistenceEnabled) * 31 + this.timestampsInSnapshotsEnabled) * 31 + (int)this.cacheSizeBytes;
  }
  
  public boolean isPersistenceEnabled() {
    return this.persistenceEnabled;
  }
  
  public boolean isSslEnabled() {
    return this.sslEnabled;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("host", this.host).add("sslEnabled", this.sslEnabled).add("persistenceEnabled", this.persistenceEnabled).add("timestampsInSnapshotsEnabled", this.timestampsInSnapshotsEnabled).toString();
  }
  
  public static final class Builder {
    private long cacheSizeBytes;
    
    private String host;
    
    private boolean persistenceEnabled;
    
    private boolean sslEnabled;
    
    private boolean timestampsInSnapshotsEnabled;
    
    public Builder() {
      this.host = "firestore.googleapis.com";
      this.sslEnabled = true;
      this.persistenceEnabled = true;
      this.timestampsInSnapshotsEnabled = true;
      this.cacheSizeBytes = 104857600L;
    }
    
    public Builder(FirebaseFirestoreSettings param1FirebaseFirestoreSettings) {
      Preconditions.checkNotNull(param1FirebaseFirestoreSettings, "Provided settings must not be null.");
      this.host = param1FirebaseFirestoreSettings.host;
      this.sslEnabled = param1FirebaseFirestoreSettings.sslEnabled;
      this.persistenceEnabled = param1FirebaseFirestoreSettings.persistenceEnabled;
      this.timestampsInSnapshotsEnabled = param1FirebaseFirestoreSettings.timestampsInSnapshotsEnabled;
    }
    
    public FirebaseFirestoreSettings build() {
      if (this.sslEnabled || !this.host.equals("firestore.googleapis.com"))
        return new FirebaseFirestoreSettings(this); 
      throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
    }
    
    public long getCacheSizeBytes() {
      return this.cacheSizeBytes;
    }
    
    public String getHost() {
      return this.host;
    }
    
    public boolean isPersistenceEnabled() {
      return this.persistenceEnabled;
    }
    
    public boolean isSslEnabled() {
      return this.sslEnabled;
    }
    
    public Builder setCacheSizeBytes(long param1Long) {
      if (param1Long == -1L || param1Long >= 1048576L) {
        this.cacheSizeBytes = param1Long;
        return this;
      } 
      throw new IllegalArgumentException("Cache size must be set to at least 1048576 bytes");
    }
    
    public Builder setHost(String param1String) {
      this.host = (String)Preconditions.checkNotNull(param1String, "Provided host must not be null.");
      return this;
    }
    
    public Builder setPersistenceEnabled(boolean param1Boolean) {
      this.persistenceEnabled = param1Boolean;
      return this;
    }
    
    public Builder setSslEnabled(boolean param1Boolean) {
      this.sslEnabled = param1Boolean;
      return this;
    }
    
    @Deprecated
    public Builder setTimestampsInSnapshotsEnabled(boolean param1Boolean) {
      this.timestampsInSnapshotsEnabled = param1Boolean;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FirebaseFirestoreSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */