package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TransformMutation extends Mutation {
  private final List<FieldTransform> fieldTransforms;
  
  public TransformMutation(DocumentKey paramDocumentKey, List<FieldTransform> paramList) {
    super(paramDocumentKey, Precondition.exists(true));
    this.fieldTransforms = paramList;
  }
  
  private List<FieldValue> localTransformResults(Timestamp paramTimestamp, MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2) {
    ArrayList<FieldValue> arrayList = new ArrayList(this.fieldTransforms.size());
    for (FieldTransform fieldTransform : this.fieldTransforms) {
      TransformOperation transformOperation = fieldTransform.getOperation();
      FieldValue fieldValue1 = null;
      if (paramMaybeDocument1 instanceof Document)
        fieldValue1 = ((Document)paramMaybeDocument1).getField(fieldTransform.getFieldPath()); 
      FieldValue fieldValue2 = fieldValue1;
      if (fieldValue1 == null) {
        fieldValue2 = fieldValue1;
        if (paramMaybeDocument2 instanceof Document)
          fieldValue2 = ((Document)paramMaybeDocument2).getField(fieldTransform.getFieldPath()); 
      } 
      arrayList.add(transformOperation.applyToLocalView(fieldValue2, paramTimestamp));
    } 
    return arrayList;
  }
  
  private Document requireDocument(MaybeDocument paramMaybeDocument) {
    Assert.hardAssert(paramMaybeDocument instanceof Document, "Unknown MaybeDocument type %s", new Object[] { paramMaybeDocument });
    Document document = (Document)paramMaybeDocument;
    Assert.hardAssert(document.getKey().equals(getKey()), "Can only transform a document with the same key", new Object[0]);
    return document;
  }
  
  private List<FieldValue> serverTransformResults(MaybeDocument paramMaybeDocument, List<FieldValue> paramList) {
    boolean bool;
    ArrayList<FieldValue> arrayList = new ArrayList(this.fieldTransforms.size());
    int i = this.fieldTransforms.size();
    int j = paramList.size();
    byte b = 0;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "server transform count (%d) should match field transform count (%d)", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.fieldTransforms.size()) });
    while (b < paramList.size()) {
      FieldTransform fieldTransform = this.fieldTransforms.get(b);
      TransformOperation transformOperation = fieldTransform.getOperation();
      FieldValue fieldValue = null;
      if (paramMaybeDocument instanceof Document)
        fieldValue = ((Document)paramMaybeDocument).getField(fieldTransform.getFieldPath()); 
      arrayList.add(transformOperation.applyToRemoteDocument(fieldValue, paramList.get(b)));
      b++;
    } 
    return arrayList;
  }
  
  private ObjectValue transformObject(ObjectValue paramObjectValue, List<FieldValue> paramList) {
    boolean bool;
    int i = paramList.size();
    int j = this.fieldTransforms.size();
    byte b = 0;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Transform results length mismatch.", new Object[0]);
    while (b < this.fieldTransforms.size()) {
      paramObjectValue = paramObjectValue.set(((FieldTransform)this.fieldTransforms.get(b)).getFieldPath(), paramList.get(b));
      b++;
    } 
    return paramObjectValue;
  }
  
  public MaybeDocument applyToLocalView(MaybeDocument paramMaybeDocument1, MaybeDocument paramMaybeDocument2, Timestamp paramTimestamp) {
    verifyKeyMatches(paramMaybeDocument1);
    if (!getPrecondition().isValidFor(paramMaybeDocument1))
      return paramMaybeDocument1; 
    Document document = requireDocument(paramMaybeDocument1);
    List<FieldValue> list = localTransformResults(paramTimestamp, paramMaybeDocument1, paramMaybeDocument2);
    ObjectValue objectValue = transformObject(document.getData(), list);
    return (MaybeDocument)new Document(getKey(), document.getVersion(), Document.DocumentState.LOCAL_MUTATIONS, objectValue);
  }
  
  public MaybeDocument applyToRemoteDocument(MaybeDocument paramMaybeDocument, MutationResult paramMutationResult) {
    boolean bool;
    verifyKeyMatches(paramMaybeDocument);
    if (paramMutationResult.getTransformResults() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Transform results missing for TransformMutation.", new Object[0]);
    if (!getPrecondition().isValidFor(paramMaybeDocument))
      return (MaybeDocument)new UnknownDocument(getKey(), paramMutationResult.getVersion()); 
    Document document = requireDocument(paramMaybeDocument);
    List<FieldValue> list = serverTransformResults((MaybeDocument)document, paramMutationResult.getTransformResults());
    ObjectValue objectValue = transformObject(document.getData(), list);
    return (MaybeDocument)new Document(getKey(), paramMutationResult.getVersion(), Document.DocumentState.COMMITTED_MUTATIONS, objectValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (!hasSameKeyAndPrecondition((Mutation)paramObject) || !this.fieldTransforms.equals(((TransformMutation)paramObject).fieldTransforms))
      bool = false; 
    return bool;
  }
  
  public ObjectValue extractBaseValue(MaybeDocument paramMaybeDocument) {
    Iterator<FieldTransform> iterator = this.fieldTransforms.iterator();
    ObjectValue objectValue = null;
    while (iterator.hasNext()) {
      FieldTransform fieldTransform = iterator.next();
      if (paramMaybeDocument instanceof Document) {
        fieldValue = ((Document)paramMaybeDocument).getField(fieldTransform.getFieldPath());
      } else {
        fieldValue = null;
      } 
      FieldValue fieldValue = fieldTransform.getOperation().computeBaseValue(fieldValue);
      if (fieldValue != null) {
        if (objectValue == null) {
          objectValue = ObjectValue.emptyObject().set(fieldTransform.getFieldPath(), fieldValue);
          continue;
        } 
        objectValue = objectValue.set(fieldTransform.getFieldPath(), fieldValue);
      } 
    } 
    return objectValue;
  }
  
  public List<FieldTransform> getFieldTransforms() {
    return this.fieldTransforms;
  }
  
  public int hashCode() {
    return keyAndPreconditionHashCode() * 31 + this.fieldTransforms.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TransformMutation{");
    stringBuilder.append(keyAndPreconditionToString());
    stringBuilder.append(", fieldTransforms=");
    stringBuilder.append(this.fieldTransforms);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\TransformMutation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */