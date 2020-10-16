package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Collections;
import java.util.Iterator;

public class ReferenceSet {
  private ImmutableSortedSet<DocumentReference> referencesByKey = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_KEY);
  
  private ImmutableSortedSet<DocumentReference> referencesByTarget = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_TARGET);
  
  private void removeReference(DocumentReference paramDocumentReference) {
    this.referencesByKey = this.referencesByKey.remove(paramDocumentReference);
    this.referencesByTarget = this.referencesByTarget.remove(paramDocumentReference);
  }
  
  public void addReference(DocumentKey paramDocumentKey, int paramInt) {
    DocumentReference documentReference = new DocumentReference(paramDocumentKey, paramInt);
    this.referencesByKey = this.referencesByKey.insert(documentReference);
    this.referencesByTarget = this.referencesByTarget.insert(documentReference);
  }
  
  public void addReferences(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    Iterator<DocumentKey> iterator = paramImmutableSortedSet.iterator();
    while (iterator.hasNext())
      addReference(iterator.next(), paramInt); 
  }
  
  public boolean containsKey(DocumentKey paramDocumentKey) {
    DocumentReference documentReference = new DocumentReference(paramDocumentKey, 0);
    Iterator<DocumentReference> iterator = this.referencesByKey.iteratorFrom(documentReference);
    return !iterator.hasNext() ? false : ((DocumentReference)iterator.next()).getKey().equals(paramDocumentKey);
  }
  
  public boolean isEmpty() {
    return this.referencesByKey.isEmpty();
  }
  
  public ImmutableSortedSet<DocumentKey> referencesForId(int paramInt) {
    DocumentReference documentReference = new DocumentReference(DocumentKey.empty(), paramInt);
    Iterator<DocumentReference> iterator = this.referencesByTarget.iteratorFrom(documentReference);
    ImmutableSortedSet<DocumentKey> immutableSortedSet = DocumentKey.emptyKeySet();
    while (iterator.hasNext()) {
      DocumentReference documentReference1 = iterator.next();
      if (documentReference1.getId() == paramInt)
        immutableSortedSet = immutableSortedSet.insert(documentReference1.getKey()); 
    } 
    return immutableSortedSet;
  }
  
  public void removeAllReferences() {
    Iterator<DocumentReference> iterator = this.referencesByKey.iterator();
    while (iterator.hasNext())
      removeReference(iterator.next()); 
  }
  
  public void removeReference(DocumentKey paramDocumentKey, int paramInt) {
    removeReference(new DocumentReference(paramDocumentKey, paramInt));
  }
  
  public void removeReferences(ImmutableSortedSet<DocumentKey> paramImmutableSortedSet, int paramInt) {
    Iterator<DocumentKey> iterator = paramImmutableSortedSet.iterator();
    while (iterator.hasNext())
      removeReference(iterator.next(), paramInt); 
  }
  
  public ImmutableSortedSet<DocumentKey> removeReferencesForId(int paramInt) {
    DocumentReference documentReference = new DocumentReference(DocumentKey.empty(), paramInt);
    Iterator<DocumentReference> iterator = this.referencesByTarget.iteratorFrom(documentReference);
    ImmutableSortedSet<DocumentKey> immutableSortedSet = DocumentKey.emptyKeySet();
    while (iterator.hasNext()) {
      DocumentReference documentReference1 = iterator.next();
      if (documentReference1.getId() == paramInt) {
        immutableSortedSet = immutableSortedSet.insert(documentReference1.getKey());
        removeReference(documentReference1);
      } 
    } 
    return immutableSortedSet;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\ReferenceSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */