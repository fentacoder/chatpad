package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class DocumentSet implements Iterable<Document> {
  private final ImmutableSortedMap<DocumentKey, Document> keyIndex;
  
  private final ImmutableSortedSet<Document> sortedSet;
  
  private DocumentSet(ImmutableSortedMap<DocumentKey, Document> paramImmutableSortedMap, ImmutableSortedSet<Document> paramImmutableSortedSet) {
    this.keyIndex = paramImmutableSortedMap;
    this.sortedSet = paramImmutableSortedSet;
  }
  
  public static DocumentSet emptySet(Comparator<Document> paramComparator) {
    paramComparator = DocumentSet$$Lambda$1.lambdaFactory$(paramComparator);
    return new DocumentSet(DocumentCollections.emptyDocumentMap(), new ImmutableSortedSet(Collections.emptyList(), paramComparator));
  }
  
  public DocumentSet add(Document paramDocument) {
    DocumentSet documentSet = remove(paramDocument.getKey());
    return new DocumentSet(documentSet.keyIndex.insert(paramDocument.getKey(), paramDocument), documentSet.sortedSet.insert(paramDocument));
  }
  
  public boolean contains(DocumentKey paramDocumentKey) {
    return this.keyIndex.containsKey(paramDocumentKey);
  }
  
  public boolean equals(Object<Document> paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    DocumentSet documentSet = (DocumentSet)paramObject;
    if (size() != documentSet.size())
      return false; 
    paramObject = (Object<Document>)iterator();
    Iterator<Document> iterator = documentSet.iterator();
    while (paramObject.hasNext()) {
      if (!((Document)paramObject.next()).equals(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public Document getDocument(DocumentKey paramDocumentKey) {
    return (Document)this.keyIndex.get(paramDocumentKey);
  }
  
  public Document getFirstDocument() {
    return (Document)this.sortedSet.getMinEntry();
  }
  
  public Document getLastDocument() {
    return (Document)this.sortedSet.getMaxEntry();
  }
  
  public Document getPredecessor(DocumentKey paramDocumentKey) {
    Document document = (Document)this.keyIndex.get(paramDocumentKey);
    if (document != null)
      return (Document)this.sortedSet.getPredecessorEntry(document); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Key not contained in DocumentSet: ");
    stringBuilder.append(paramDocumentKey);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public int hashCode() {
    Iterator<Document> iterator = iterator();
    int i;
    for (i = 0; iterator.hasNext(); i = i * 31 + ((Document)iterator.next()).hashCode());
    return i;
  }
  
  public int indexOf(DocumentKey paramDocumentKey) {
    Document document = (Document)this.keyIndex.get(paramDocumentKey);
    return (document == null) ? -1 : this.sortedSet.indexOf(document);
  }
  
  public boolean isEmpty() {
    return this.keyIndex.isEmpty();
  }
  
  public Iterator<Document> iterator() {
    return this.sortedSet.iterator();
  }
  
  public DocumentSet remove(DocumentKey paramDocumentKey) {
    Document document = (Document)this.keyIndex.get(paramDocumentKey);
    return (document == null) ? this : new DocumentSet(this.keyIndex.remove(paramDocumentKey), this.sortedSet.remove(document));
  }
  
  public int size() {
    return this.keyIndex.size();
  }
  
  public List<Document> toList() {
    ArrayList<Document> arrayList = new ArrayList(size());
    Iterator<Document> iterator = iterator();
    while (iterator.hasNext())
      arrayList.add(iterator.next()); 
    return arrayList;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    Iterator<Document> iterator = iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Document document = iterator.next();
      if (bool) {
        bool = false;
      } else {
        stringBuilder.append(", ");
      } 
      stringBuilder.append(document);
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\DocumentSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */