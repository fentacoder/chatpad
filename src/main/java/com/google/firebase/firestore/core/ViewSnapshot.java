package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import java.util.ArrayList;
import java.util.List;

public class ViewSnapshot {
  private final List<DocumentViewChange> changes;
  
  private final boolean didSyncStateChange;
  
  private final DocumentSet documents;
  
  private boolean excludesMetadataChanges;
  
  private final boolean isFromCache;
  
  private final ImmutableSortedSet<DocumentKey> mutatedKeys;
  
  private final DocumentSet oldDocuments;
  
  private final Query query;
  
  public ViewSnapshot(Query paramQuery, DocumentSet paramDocumentSet1, DocumentSet paramDocumentSet2, List<DocumentViewChange> paramList, boolean paramBoolean1, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, boolean paramBoolean2, boolean paramBoolean3) {
    this.query = paramQuery;
    this.documents = paramDocumentSet1;
    this.oldDocuments = paramDocumentSet2;
    this.changes = paramList;
    this.isFromCache = paramBoolean1;
    this.mutatedKeys = paramImmutableSortedSet;
    this.didSyncStateChange = paramBoolean2;
    this.excludesMetadataChanges = paramBoolean3;
  }
  
  public static ViewSnapshot fromInitialDocuments(Query paramQuery, DocumentSet paramDocumentSet, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList<DocumentViewChange> arrayList = new ArrayList();
    for (Document document : paramDocumentSet)
      arrayList.add(DocumentViewChange.create(DocumentViewChange.Type.ADDED, document)); 
    return new ViewSnapshot(paramQuery, paramDocumentSet, DocumentSet.emptySet(paramQuery.comparator()), arrayList, paramBoolean1, paramImmutableSortedSet, true, paramBoolean2);
  }
  
  public boolean didSyncStateChange() {
    return this.didSyncStateChange;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ViewSnapshot))
      return false; 
    paramObject = paramObject;
    return (this.isFromCache != ((ViewSnapshot)paramObject).isFromCache) ? false : ((this.didSyncStateChange != ((ViewSnapshot)paramObject).didSyncStateChange) ? false : ((this.excludesMetadataChanges != ((ViewSnapshot)paramObject).excludesMetadataChanges) ? false : (!this.query.equals(((ViewSnapshot)paramObject).query) ? false : (!this.mutatedKeys.equals(((ViewSnapshot)paramObject).mutatedKeys) ? false : (!this.documents.equals(((ViewSnapshot)paramObject).documents) ? false : (!this.oldDocuments.equals(((ViewSnapshot)paramObject).oldDocuments) ? false : this.changes.equals(((ViewSnapshot)paramObject).changes)))))));
  }
  
  public boolean excludesMetadataChanges() {
    return this.excludesMetadataChanges;
  }
  
  public List<DocumentViewChange> getChanges() {
    return this.changes;
  }
  
  public DocumentSet getDocuments() {
    return this.documents;
  }
  
  public ImmutableSortedSet<DocumentKey> getMutatedKeys() {
    return this.mutatedKeys;
  }
  
  public DocumentSet getOldDocuments() {
    return this.oldDocuments;
  }
  
  public Query getQuery() {
    return this.query;
  }
  
  public boolean hasPendingWrites() {
    return this.mutatedKeys.isEmpty() ^ true;
  }
  
  public int hashCode() {
    return ((((((this.query.hashCode() * 31 + this.documents.hashCode()) * 31 + this.oldDocuments.hashCode()) * 31 + this.changes.hashCode()) * 31 + this.mutatedKeys.hashCode()) * 31 + this.isFromCache) * 31 + this.didSyncStateChange) * 31 + this.excludesMetadataChanges;
  }
  
  public boolean isFromCache() {
    return this.isFromCache;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ViewSnapshot(");
    stringBuilder.append(this.query);
    stringBuilder.append(", ");
    stringBuilder.append(this.documents);
    stringBuilder.append(", ");
    stringBuilder.append(this.oldDocuments);
    stringBuilder.append(", ");
    stringBuilder.append(this.changes);
    stringBuilder.append(", isFromCache=");
    stringBuilder.append(this.isFromCache);
    stringBuilder.append(", mutatedKeys=");
    stringBuilder.append(this.mutatedKeys.size());
    stringBuilder.append(", didSyncStateChange=");
    stringBuilder.append(this.didSyncStateChange);
    stringBuilder.append(", excludesMetadataChanges=");
    stringBuilder.append(this.excludesMetadataChanges);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public enum SyncState {
    LOCAL, NONE, SYNCED;
    
    static {
      $VALUES = new SyncState[] { NONE, LOCAL, SYNCED };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ViewSnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */