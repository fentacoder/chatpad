package com.google.firebase.firestore.model.mutation;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.List;

public final class MutationResult {
  private final List<FieldValue> transformResults;
  
  private final SnapshotVersion version;
  
  public MutationResult(SnapshotVersion paramSnapshotVersion, List<FieldValue> paramList) {
    this.version = (SnapshotVersion)Preconditions.checkNotNull(paramSnapshotVersion);
    this.transformResults = paramList;
  }
  
  public List<FieldValue> getTransformResults() {
    return this.transformResults;
  }
  
  public SnapshotVersion getVersion() {
    return this.version;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\MutationResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */