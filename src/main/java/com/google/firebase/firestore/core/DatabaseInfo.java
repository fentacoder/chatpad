package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DatabaseId;

public final class DatabaseInfo {
  private final DatabaseId databaseId;
  
  private final String host;
  
  private final String persistenceKey;
  
  private final boolean sslEnabled;
  
  public DatabaseInfo(DatabaseId paramDatabaseId, String paramString1, String paramString2, boolean paramBoolean) {
    this.databaseId = paramDatabaseId;
    this.persistenceKey = paramString1;
    this.host = paramString2;
    this.sslEnabled = paramBoolean;
  }
  
  public DatabaseId getDatabaseId() {
    return this.databaseId;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public String getPersistenceKey() {
    return this.persistenceKey;
  }
  
  public boolean isSslEnabled() {
    return this.sslEnabled;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DatabaseInfo(databaseId:");
    stringBuilder.append(this.databaseId);
    stringBuilder.append(" host:");
    stringBuilder.append(this.host);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\DatabaseInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */