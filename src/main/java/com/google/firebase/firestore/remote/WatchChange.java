package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.List;

public abstract class WatchChange {
  private WatchChange() {}
  
  public static final class DocumentChange extends WatchChange {
    private final DocumentKey documentKey;
    
    private final MaybeDocument newDocument;
    
    private final List<Integer> removedTargetIds;
    
    private final List<Integer> updatedTargetIds;
    
    public DocumentChange(List<Integer> param1List1, List<Integer> param1List2, DocumentKey param1DocumentKey, MaybeDocument param1MaybeDocument) {
      this.updatedTargetIds = param1List1;
      this.removedTargetIds = param1List2;
      this.documentKey = param1DocumentKey;
      this.newDocument = param1MaybeDocument;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = true;
      if (this == param1Object)
        return true; 
      if (param1Object == null || getClass() != param1Object.getClass())
        return false; 
      DocumentChange documentChange = (DocumentChange)param1Object;
      if (!this.updatedTargetIds.equals(documentChange.updatedTargetIds))
        return false; 
      if (!this.removedTargetIds.equals(documentChange.removedTargetIds))
        return false; 
      if (!this.documentKey.equals(documentChange.documentKey))
        return false; 
      param1Object = this.newDocument;
      MaybeDocument maybeDocument = documentChange.newDocument;
      if (param1Object != null) {
        bool = param1Object.equals(maybeDocument);
      } else if (maybeDocument != null) {
        bool = false;
      } 
      return bool;
    }
    
    public DocumentKey getDocumentKey() {
      return this.documentKey;
    }
    
    public MaybeDocument getNewDocument() {
      return this.newDocument;
    }
    
    public List<Integer> getRemovedTargetIds() {
      return this.removedTargetIds;
    }
    
    public List<Integer> getUpdatedTargetIds() {
      return this.updatedTargetIds;
    }
    
    public int hashCode() {
      byte b;
      int i = this.updatedTargetIds.hashCode();
      int j = this.removedTargetIds.hashCode();
      int k = this.documentKey.hashCode();
      MaybeDocument maybeDocument = this.newDocument;
      if (maybeDocument != null) {
        b = maybeDocument.hashCode();
      } else {
        b = 0;
      } 
      return ((i * 31 + j) * 31 + k) * 31 + b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DocumentChange{updatedTargetIds=");
      stringBuilder.append(this.updatedTargetIds);
      stringBuilder.append(", removedTargetIds=");
      stringBuilder.append(this.removedTargetIds);
      stringBuilder.append(", key=");
      stringBuilder.append(this.documentKey);
      stringBuilder.append(", newDocument=");
      stringBuilder.append(this.newDocument);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static final class ExistenceFilterWatchChange extends WatchChange {
    private final ExistenceFilter existenceFilter;
    
    private final int targetId;
    
    public ExistenceFilterWatchChange(int param1Int, ExistenceFilter param1ExistenceFilter) {
      this.targetId = param1Int;
      this.existenceFilter = param1ExistenceFilter;
    }
    
    public ExistenceFilter getExistenceFilter() {
      return this.existenceFilter;
    }
    
    public int getTargetId() {
      return this.targetId;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ExistenceFilterWatchChange{targetId=");
      stringBuilder.append(this.targetId);
      stringBuilder.append(", existenceFilter=");
      stringBuilder.append(this.existenceFilter);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static final class WatchTargetChange extends WatchChange {
    private final Status cause;
    
    private final WatchChange.WatchTargetChangeType changeType;
    
    private final ByteString resumeToken;
    
    private final List<Integer> targetIds;
    
    public WatchTargetChange(WatchChange.WatchTargetChangeType param1WatchTargetChangeType, List<Integer> param1List) {
      this(param1WatchTargetChangeType, param1List, WatchStream.EMPTY_RESUME_TOKEN, null);
    }
    
    public WatchTargetChange(WatchChange.WatchTargetChangeType param1WatchTargetChangeType, List<Integer> param1List, ByteString param1ByteString) {
      this(param1WatchTargetChangeType, param1List, param1ByteString, null);
    }
    
    public WatchTargetChange(WatchChange.WatchTargetChangeType param1WatchTargetChangeType, List<Integer> param1List, ByteString param1ByteString, Status param1Status) {
      boolean bool;
      if (param1Status == null || param1WatchTargetChangeType == WatchChange.WatchTargetChangeType.Removed) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Got cause for a target change that was not a removal", new Object[0]);
      this.changeType = param1WatchTargetChangeType;
      this.targetIds = param1List;
      this.resumeToken = param1ByteString;
      if (param1Status != null && !param1Status.isOk()) {
        this.cause = param1Status;
      } else {
        this.cause = null;
      } 
    }
    
    public boolean equals(Object param1Object) {
      boolean bool1 = true;
      boolean bool2 = true;
      if (this == param1Object)
        return true; 
      if (param1Object == null || getClass() != param1Object.getClass())
        return false; 
      WatchTargetChange watchTargetChange = (WatchTargetChange)param1Object;
      if (this.changeType != watchTargetChange.changeType)
        return false; 
      if (!this.targetIds.equals(watchTargetChange.targetIds))
        return false; 
      if (!this.resumeToken.equals(watchTargetChange.resumeToken))
        return false; 
      param1Object = this.cause;
      if (param1Object != null) {
        if (watchTargetChange.cause == null || !param1Object.getCode().equals(watchTargetChange.cause.getCode()))
          bool2 = false; 
        return bool2;
      } 
      if (watchTargetChange.cause == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      return bool2;
    }
    
    public Status getCause() {
      return this.cause;
    }
    
    public WatchChange.WatchTargetChangeType getChangeType() {
      return this.changeType;
    }
    
    public ByteString getResumeToken() {
      return this.resumeToken;
    }
    
    public List<Integer> getTargetIds() {
      return this.targetIds;
    }
    
    public int hashCode() {
      byte b;
      int i = this.changeType.hashCode();
      int j = this.targetIds.hashCode();
      int k = this.resumeToken.hashCode();
      Status status = this.cause;
      if (status != null) {
        b = status.getCode().hashCode();
      } else {
        b = 0;
      } 
      return ((i * 31 + j) * 31 + k) * 31 + b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("WatchTargetChange{changeType=");
      stringBuilder.append(this.changeType);
      stringBuilder.append(", targetIds=");
      stringBuilder.append(this.targetIds);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public enum WatchTargetChangeType {
    Added, Current, NoChange, Removed, Reset;
    
    static {
      Current = new WatchTargetChangeType("Current", 3);
      Reset = new WatchTargetChangeType("Reset", 4);
      $VALUES = new WatchTargetChangeType[] { NoChange, Added, Removed, Current, Reset };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\remote\WatchChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */