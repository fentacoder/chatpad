package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;
import java.util.Set;

public final class RemoteEvent {
  private final Map<DocumentKey, MaybeDocument> documentUpdates;
  
  private final Set<DocumentKey> resolvedLimboDocuments;
  
  private final SnapshotVersion snapshotVersion;
  
  private final Map<Integer, TargetChange> targetChanges;
  
  private final Set<Integer> targetMismatches;
  
  public RemoteEvent(SnapshotVersion paramSnapshotVersion, Map<Integer, TargetChange> paramMap, Set<Integer> paramSet, Map<DocumentKey, MaybeDocument> paramMap1, Set<DocumentKey> paramSet1) {
    this.snapshotVersion = paramSnapshotVersion;
    this.targetChanges = paramMap;
    this.targetMismatches = paramSet;
    this.documentUpdates = paramMap1;
    this.resolvedLimboDocuments = paramSet1;
  }
  
  public Map<DocumentKey, MaybeDocument> getDocumentUpdates() {
    return this.documentUpdates;
  }
  
  public Set<DocumentKey> getResolvedLimboDocuments() {
    return this.resolvedLimboDocuments;
  }
  
  public SnapshotVersion getSnapshotVersion() {
    return this.snapshotVersion;
  }
  
  public Map<Integer, TargetChange> getTargetChanges() {
    return this.targetChanges;
  }
  
  public Set<Integer> getTargetMismatches() {
    return this.targetMismatches;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RemoteEvent{snapshotVersion=");
    stringBuilder.append(this.snapshotVersion);
    stringBuilder.append(", targetChanges=");
    stringBuilder.append(this.targetChanges);
    stringBuilder.append(", targetMismatches=");
    stringBuilder.append(this.targetMismatches);
    stringBuilder.append(", documentUpdates=");
    stringBuilder.append(this.documentUpdates);
    stringBuilder.append(", resolvedLimboDocuments=");
    stringBuilder.append(this.resolvedLimboDocuments);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\RemoteEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */