package com.google.firebase.firestore.model;

public final class DatabaseId implements Comparable<DatabaseId> {
  public static final String DEFAULT_DATABASE_ID = "(default)";
  
  private final String databaseId;
  
  private final String projectId;
  
  private DatabaseId(String paramString1, String paramString2) {
    this.projectId = paramString1;
    this.databaseId = paramString2;
  }
  
  public static DatabaseId forDatabase(String paramString1, String paramString2) {
    return new DatabaseId(paramString1, paramString2);
  }
  
  public static DatabaseId forProject(String paramString) {
    return forDatabase(paramString, "(default)");
  }
  
  public int compareTo(DatabaseId paramDatabaseId) {
    int i = this.projectId.compareTo(paramDatabaseId.projectId);
    if (i == 0)
      i = this.databaseId.compareTo(paramDatabaseId.databaseId); 
    return i;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!this.projectId.equals(((DatabaseId)paramObject).projectId) || !this.databaseId.equals(((DatabaseId)paramObject).databaseId))
      bool = false; 
    return bool;
  }
  
  public String getDatabaseId() {
    return this.databaseId;
  }
  
  public String getProjectId() {
    return this.projectId;
  }
  
  public int hashCode() {
    return this.projectId.hashCode() * 31 + this.databaseId.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DatabaseId(");
    stringBuilder.append(this.projectId);
    stringBuilder.append(", ");
    stringBuilder.append(this.databaseId);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\DatabaseId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */