package com.google.firebase.firestore.core;

import java.util.List;

public class ViewChange {
  private final List<LimboDocumentChange> limboChanges;
  
  private final ViewSnapshot snapshot;
  
  public ViewChange(ViewSnapshot paramViewSnapshot, List<LimboDocumentChange> paramList) {
    this.snapshot = paramViewSnapshot;
    this.limboChanges = paramList;
  }
  
  public List<LimboDocumentChange> getLimboChanges() {
    return this.limboChanges;
  }
  
  public ViewSnapshot getSnapshot() {
    return this.snapshot;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ViewChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */