package com.google.firebase.firestore.model;

import com.google.common.base.Function;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Document extends MaybeDocument {
  private static final Comparator<Document> KEY_COMPARATOR = Document$$Lambda$1.lambdaFactory$();
  
  private final Function<Value, FieldValue> converter;
  
  private final DocumentState documentState;
  
  private Map<FieldPath, FieldValue> fieldValueCache;
  
  private ObjectValue objectValue;
  
  private final com.google.firestore.v1.Document proto;
  
  public Document(DocumentKey paramDocumentKey, SnapshotVersion paramSnapshotVersion, DocumentState paramDocumentState, ObjectValue paramObjectValue) {
    super(paramDocumentKey, paramSnapshotVersion);
    this.documentState = paramDocumentState;
    this.objectValue = paramObjectValue;
    this.proto = null;
    this.converter = null;
  }
  
  public Document(DocumentKey paramDocumentKey, SnapshotVersion paramSnapshotVersion, DocumentState paramDocumentState, com.google.firestore.v1.Document paramDocument, Function<Value, FieldValue> paramFunction) {
    super(paramDocumentKey, paramSnapshotVersion);
    this.documentState = paramDocumentState;
    this.proto = paramDocument;
    this.converter = paramFunction;
  }
  
  public static Comparator<Document> keyComparator() {
    return KEY_COMPARATOR;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Document))
      return false; 
    paramObject = paramObject;
    if (!getVersion().equals(paramObject.getVersion()) || !getKey().equals(paramObject.getKey()) || !this.documentState.equals(((Document)paramObject).documentState) || !getData().equals(paramObject.getData()))
      bool = false; 
    return bool;
  }
  
  public ObjectValue getData() {
    if (this.objectValue == null) {
      boolean bool;
      if (this.proto != null && this.converter != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Assert.hardAssert(bool, "Expected proto and converter to be non-null", new Object[0]);
      ObjectValue objectValue = ObjectValue.emptyObject();
      for (Map.Entry entry : this.proto.getFieldsMap().entrySet())
        objectValue = objectValue.set(FieldPath.fromSingleSegment((String)entry.getKey()), (FieldValue)this.converter.apply(entry.getValue())); 
      this.objectValue = objectValue;
      this.fieldValueCache = null;
    } 
    return this.objectValue;
  }
  
  public FieldValue getField(FieldPath paramFieldPath) {
    boolean bool;
    ObjectValue objectValue = this.objectValue;
    if (objectValue != null)
      return objectValue.get(paramFieldPath); 
    com.google.firestore.v1.Document document = this.proto;
    byte b = 1;
    if (document != null && this.converter != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Expected proto and converter to be non-null", new Object[0]);
    Map<FieldPath, FieldValue> map2 = this.fieldValueCache;
    Map<FieldPath, FieldValue> map1 = map2;
    if (map2 == null) {
      map1 = new ConcurrentHashMap<>();
      this.fieldValueCache = map1;
    } 
    FieldValue fieldValue2 = map1.get(paramFieldPath);
    FieldValue fieldValue1 = fieldValue2;
    if (fieldValue2 == null) {
      Value value = (Value)this.proto.getFieldsMap().get(paramFieldPath.getFirstSegment());
      while (value != null && b < paramFieldPath.length()) {
        if (value.getValueTypeCase() != Value.ValueTypeCase.MAP_VALUE)
          return null; 
        value = (Value)value.getMapValue().getFieldsMap().get(paramFieldPath.getSegment(b));
        b++;
      } 
      fieldValue1 = fieldValue2;
      if (value != null) {
        fieldValue1 = (FieldValue)this.converter.apply(value);
        map1.put(paramFieldPath, fieldValue1);
      } 
    } 
    return fieldValue1;
  }
  
  public Object getFieldValue(FieldPath paramFieldPath) {
    Object object = getField(paramFieldPath);
    if (object == null) {
      object = null;
    } else {
      object = object.value();
    } 
    return object;
  }
  
  public com.google.firestore.v1.Document getProto() {
    return this.proto;
  }
  
  public boolean hasCommittedMutations() {
    return this.documentState.equals(DocumentState.COMMITTED_MUTATIONS);
  }
  
  public boolean hasLocalMutations() {
    return this.documentState.equals(DocumentState.LOCAL_MUTATIONS);
  }
  
  public boolean hasPendingWrites() {
    return (hasLocalMutations() || hasCommittedMutations());
  }
  
  public int hashCode() {
    return (getKey().hashCode() * 31 + getVersion().hashCode()) * 31 + this.documentState.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Document{key=");
    stringBuilder.append(getKey());
    stringBuilder.append(", data=");
    stringBuilder.append(getData());
    stringBuilder.append(", version=");
    stringBuilder.append(getVersion());
    stringBuilder.append(", documentState=");
    stringBuilder.append(this.documentState.name());
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public enum DocumentState {
    COMMITTED_MUTATIONS, LOCAL_MUTATIONS, SYNCED;
    
    static {
      $VALUES = new DocumentState[] { LOCAL_MUTATIONS, COMMITTED_MUTATIONS, SYNCED };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\Document.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */