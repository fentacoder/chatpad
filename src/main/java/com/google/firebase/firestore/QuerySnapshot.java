package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuerySnapshot implements Iterable<QueryDocumentSnapshot> {
  private List<DocumentChange> cachedChanges;
  
  private MetadataChanges cachedChangesMetadataState;
  
  private final FirebaseFirestore firestore;
  
  private final SnapshotMetadata metadata;
  
  private final Query originalQuery;
  
  private final ViewSnapshot snapshot;
  
  QuerySnapshot(Query paramQuery, ViewSnapshot paramViewSnapshot, FirebaseFirestore paramFirebaseFirestore) {
    this.originalQuery = (Query)Preconditions.checkNotNull(paramQuery);
    this.snapshot = (ViewSnapshot)Preconditions.checkNotNull(paramViewSnapshot);
    this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(paramFirebaseFirestore);
    this.metadata = new SnapshotMetadata(paramViewSnapshot.hasPendingWrites(), paramViewSnapshot.isFromCache());
  }
  
  private QueryDocumentSnapshot convertDocument(Document paramDocument) {
    return QueryDocumentSnapshot.fromDocument(this.firestore, paramDocument, this.snapshot.isFromCache(), this.snapshot.getMutatedKeys().contains(paramDocument.getKey()));
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof QuerySnapshot))
      return false; 
    paramObject = paramObject;
    if (!this.firestore.equals(((QuerySnapshot)paramObject).firestore) || !this.originalQuery.equals(((QuerySnapshot)paramObject).originalQuery) || !this.snapshot.equals(((QuerySnapshot)paramObject).snapshot) || !this.metadata.equals(((QuerySnapshot)paramObject).metadata))
      bool = false; 
    return bool;
  }
  
  public List<DocumentChange> getDocumentChanges() {
    return getDocumentChanges(MetadataChanges.EXCLUDE);
  }
  
  public List<DocumentChange> getDocumentChanges(MetadataChanges paramMetadataChanges) {
    if (!MetadataChanges.INCLUDE.equals(paramMetadataChanges) || !this.snapshot.excludesMetadataChanges()) {
      if (this.cachedChanges == null || this.cachedChangesMetadataState != paramMetadataChanges) {
        this.cachedChanges = Collections.unmodifiableList(DocumentChange.changesFromSnapshot(this.firestore, paramMetadataChanges, this.snapshot));
        this.cachedChangesMetadataState = paramMetadataChanges;
      } 
      return this.cachedChanges;
    } 
    throw new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
  }
  
  public List<DocumentSnapshot> getDocuments() {
    ArrayList<QueryDocumentSnapshot> arrayList = new ArrayList(this.snapshot.getDocuments().size());
    Iterator<Document> iterator = this.snapshot.getDocuments().iterator();
    while (iterator.hasNext())
      arrayList.add(convertDocument(iterator.next())); 
    return (List)arrayList;
  }
  
  public SnapshotMetadata getMetadata() {
    return this.metadata;
  }
  
  public Query getQuery() {
    return this.originalQuery;
  }
  
  public int hashCode() {
    return ((this.firestore.hashCode() * 31 + this.originalQuery.hashCode()) * 31 + this.snapshot.hashCode()) * 31 + this.metadata.hashCode();
  }
  
  public boolean isEmpty() {
    return this.snapshot.getDocuments().isEmpty();
  }
  
  public Iterator<QueryDocumentSnapshot> iterator() {
    return new QuerySnapshotIterator(this.snapshot.getDocuments().iterator());
  }
  
  public int size() {
    return this.snapshot.getDocuments().size();
  }
  
  public <T> List<T> toObjects(Class<T> paramClass) {
    return toObjects(paramClass, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
  }
  
  public <T> List<T> toObjects(Class<T> paramClass, DocumentSnapshot.ServerTimestampBehavior paramServerTimestampBehavior) {
    Preconditions.checkNotNull(paramClass, "Provided POJO type must not be null.");
    ArrayList<T> arrayList = new ArrayList();
    Iterator<QueryDocumentSnapshot> iterator = iterator();
    while (iterator.hasNext())
      arrayList.add(((DocumentSnapshot)iterator.next()).toObject(paramClass, paramServerTimestampBehavior)); 
    return arrayList;
  }
  
  private class QuerySnapshotIterator implements Iterator<QueryDocumentSnapshot> {
    private final Iterator<Document> it;
    
    QuerySnapshotIterator(Iterator<Document> param1Iterator) {
      this.it = param1Iterator;
    }
    
    public boolean hasNext() {
      return this.it.hasNext();
    }
    
    public QueryDocumentSnapshot next() {
      return QuerySnapshot.this.convertDocument(this.it.next());
    }
    
    public void remove() {
      throw new UnsupportedOperationException("QuerySnapshot does not support remove().");
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\QuerySnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */