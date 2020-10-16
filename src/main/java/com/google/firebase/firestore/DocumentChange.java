package com.google.firebase.firestore;

import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DocumentChange {
  private final QueryDocumentSnapshot document;
  
  private final int newIndex;
  
  private final int oldIndex;
  
  private final Type type;
  
  DocumentChange(QueryDocumentSnapshot paramQueryDocumentSnapshot, Type paramType, int paramInt1, int paramInt2) {
    this.type = paramType;
    this.document = paramQueryDocumentSnapshot;
    this.oldIndex = paramInt1;
    this.newIndex = paramInt2;
  }
  
  static List<DocumentChange> changesFromSnapshot(FirebaseFirestore paramFirebaseFirestore, MetadataChanges paramMetadataChanges, ViewSnapshot paramViewSnapshot) {
    Document document;
    ArrayList<DocumentChange> arrayList = new ArrayList();
    if (paramViewSnapshot.getOldDocuments().isEmpty()) {
      paramMetadataChanges = null;
      Iterator<DocumentViewChange> iterator = paramViewSnapshot.getChanges().iterator();
      for (byte b = 0; iterator.hasNext(); b++) {
        boolean bool;
        DocumentViewChange documentViewChange = iterator.next();
        Document document1 = documentViewChange.getDocument();
        QueryDocumentSnapshot queryDocumentSnapshot = QueryDocumentSnapshot.fromDocument(paramFirebaseFirestore, document1, paramViewSnapshot.isFromCache(), paramViewSnapshot.getMutatedKeys().contains(document1.getKey()));
        if (documentViewChange.getType() == DocumentViewChange.Type.ADDED) {
          bool = true;
        } else {
          bool = false;
        } 
        Assert.hardAssert(bool, "Invalid added event for first snapshot", new Object[0]);
        if (paramMetadataChanges == null || paramViewSnapshot.getQuery().comparator().compare(paramMetadataChanges, document1) < 0) {
          bool = true;
        } else {
          bool = false;
        } 
        Assert.hardAssert(bool, "Got added events in wrong order", new Object[0]);
        arrayList.add(new DocumentChange(queryDocumentSnapshot, Type.ADDED, -1, b));
        document = document1;
      } 
    } else {
      DocumentSet documentSet = paramViewSnapshot.getOldDocuments();
      for (DocumentViewChange documentViewChange : paramViewSnapshot.getChanges()) {
        byte b1;
        byte b2;
        if (document == MetadataChanges.EXCLUDE && documentViewChange.getType() == DocumentViewChange.Type.METADATA)
          continue; 
        Document document1 = documentViewChange.getDocument();
        QueryDocumentSnapshot queryDocumentSnapshot = QueryDocumentSnapshot.fromDocument(paramFirebaseFirestore, document1, paramViewSnapshot.isFromCache(), paramViewSnapshot.getMutatedKeys().contains(document1.getKey()));
        Type type = getType(documentViewChange);
        if (type != Type.ADDED) {
          boolean bool;
          b1 = documentSet.indexOf(document1.getKey());
          if (b1 >= 0) {
            bool = true;
          } else {
            bool = false;
          } 
          Assert.hardAssert(bool, "Index for document not found", new Object[0]);
          documentSet = documentSet.remove(document1.getKey());
        } else {
          b1 = -1;
        } 
        if (type != Type.REMOVED) {
          boolean bool;
          documentSet = documentSet.add(document1);
          b2 = documentSet.indexOf(document1.getKey());
          if (b2 >= 0) {
            bool = true;
          } else {
            bool = false;
          } 
          Assert.hardAssert(bool, "Index for document not found", new Object[0]);
        } else {
          b2 = -1;
        } 
        arrayList.add(new DocumentChange(queryDocumentSnapshot, type, b1, b2));
      } 
    } 
    return arrayList;
  }
  
  private static Type getType(DocumentViewChange paramDocumentViewChange) {
    int i = null.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[paramDocumentViewChange.getType().ordinal()];
    if (i != 1) {
      if (i != 2 && i != 3) {
        if (i == 4)
          return Type.REMOVED; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown view change type: ");
        stringBuilder.append(paramDocumentViewChange.getType());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return Type.MODIFIED;
    } 
    return Type.ADDED;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof DocumentChange;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (bool) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.type.equals(((DocumentChange)paramObject).type)) {
        bool2 = bool1;
        if (this.document.equals(((DocumentChange)paramObject).document)) {
          bool2 = bool1;
          if (this.oldIndex == ((DocumentChange)paramObject).oldIndex) {
            bool2 = bool1;
            if (this.newIndex == ((DocumentChange)paramObject).newIndex)
              bool2 = true; 
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public QueryDocumentSnapshot getDocument() {
    return this.document;
  }
  
  public int getNewIndex() {
    return this.newIndex;
  }
  
  public int getOldIndex() {
    return this.oldIndex;
  }
  
  public Type getType() {
    return this.type;
  }
  
  public int hashCode() {
    return ((this.type.hashCode() * 31 + this.document.hashCode()) * 31 + this.oldIndex) * 31 + this.newIndex;
  }
  
  public enum Type {
    ADDED, MODIFIED, REMOVED;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\DocumentChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */