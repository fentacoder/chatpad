package com.google.firebase.firestore.core;

final class QueryView {
  private final Query query;
  
  private final int targetId;
  
  private final View view;
  
  QueryView(Query paramQuery, int paramInt, View paramView) {
    this.query = paramQuery;
    this.targetId = paramInt;
    this.view = paramView;
  }
  
  public Query getQuery() {
    return this.query;
  }
  
  public int getTargetId() {
    return this.targetId;
  }
  
  public View getView() {
    return this.view;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\QueryView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */