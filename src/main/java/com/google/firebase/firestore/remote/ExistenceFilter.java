package com.google.firebase.firestore.remote;

public final class ExistenceFilter {
  private final int count;
  
  public ExistenceFilter(int paramInt) {
    this.count = paramInt;
  }
  
  public int getCount() {
    return this.count;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ExistenceFilter{count=");
    stringBuilder.append(this.count);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\ExistenceFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */