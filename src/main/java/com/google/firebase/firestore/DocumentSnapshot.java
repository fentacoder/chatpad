package com.google.firebase.firestore;

import com.google.common.base.Preconditions;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;
import com.google.firebase.firestore.model.value.TimestampValue;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DocumentSnapshot {
  private final Document doc;
  
  private final FirebaseFirestore firestore;
  
  private final DocumentKey key;
  
  private final SnapshotMetadata metadata;
  
  DocumentSnapshot(FirebaseFirestore paramFirebaseFirestore, DocumentKey paramDocumentKey, Document paramDocument, boolean paramBoolean1, boolean paramBoolean2) {
    this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(paramFirebaseFirestore);
    this.key = (DocumentKey)Preconditions.checkNotNull(paramDocumentKey);
    this.doc = paramDocument;
    this.metadata = new SnapshotMetadata(paramBoolean2, paramBoolean1);
  }
  
  private <T> T castTypedValue(Object paramObject, String paramString, Class<T> paramClass) {
    if (paramObject == null)
      return null; 
    if (paramClass.isInstance(paramObject))
      return paramClass.cast(paramObject); 
    paramObject = new StringBuilder();
    paramObject.append("Field '");
    paramObject.append(paramString);
    paramObject.append("' is not a ");
    paramObject.append(paramClass.getName());
    throw new RuntimeException(paramObject.toString());
  }
  
  private List<Object> convertArray(ArrayValue paramArrayValue, FieldValueOptions paramFieldValueOptions) {
    ArrayList<Object> arrayList = new ArrayList(paramArrayValue.getInternalValue().size());
    Iterator<FieldValue> iterator = paramArrayValue.getInternalValue().iterator();
    while (iterator.hasNext())
      arrayList.add(convertValue(iterator.next(), paramFieldValueOptions)); 
    return arrayList;
  }
  
  private Map<String, Object> convertObject(ObjectValue paramObjectValue, FieldValueOptions paramFieldValueOptions) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (Map.Entry entry : paramObjectValue.getInternalValue())
      hashMap.put(entry.getKey(), convertValue((FieldValue)entry.getValue(), paramFieldValueOptions)); 
    return (Map)hashMap;
  }
  
  private Object convertReference(ReferenceValue paramReferenceValue) {
    DocumentKey documentKey = paramReferenceValue.value();
    DatabaseId databaseId1 = paramReferenceValue.getDatabaseId();
    DatabaseId databaseId2 = this.firestore.getDatabaseId();
    if (!databaseId1.equals(databaseId2))
      Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", new Object[] { documentKey.getPath(), databaseId1.getProjectId(), databaseId1.getDatabaseId(), databaseId2.getProjectId(), databaseId2.getDatabaseId() }); 
    return new DocumentReference(documentKey, this.firestore);
  }
  
  private Object convertServerTimestamp(ServerTimestampValue paramServerTimestampValue, FieldValueOptions paramFieldValueOptions) {
    int i = null.$SwitchMap$com$google$firebase$firestore$DocumentSnapshot$ServerTimestampBehavior[paramFieldValueOptions.serverTimestampBehavior.ordinal()];
    return (i != 1) ? ((i != 2) ? paramServerTimestampValue.value() : paramServerTimestampValue.getLocalWriteTime()) : paramServerTimestampValue.getPreviousValue();
  }
  
  private Object convertTimestamp(TimestampValue paramTimestampValue, FieldValueOptions paramFieldValueOptions) {
    Timestamp timestamp = paramTimestampValue.value();
    return paramFieldValueOptions.timestampsInSnapshotsEnabled ? timestamp : timestamp.toDate();
  }
  
  private Object convertValue(FieldValue paramFieldValue, FieldValueOptions paramFieldValueOptions) {
    return (paramFieldValue instanceof ObjectValue) ? convertObject((ObjectValue)paramFieldValue, paramFieldValueOptions) : ((paramFieldValue instanceof ArrayValue) ? convertArray((ArrayValue)paramFieldValue, paramFieldValueOptions) : ((paramFieldValue instanceof ReferenceValue) ? convertReference((ReferenceValue)paramFieldValue) : ((paramFieldValue instanceof TimestampValue) ? convertTimestamp((TimestampValue)paramFieldValue, paramFieldValueOptions) : ((paramFieldValue instanceof ServerTimestampValue) ? convertServerTimestamp((ServerTimestampValue)paramFieldValue, paramFieldValueOptions) : paramFieldValue.value()))));
  }
  
  static DocumentSnapshot fromDocument(FirebaseFirestore paramFirebaseFirestore, Document paramDocument, boolean paramBoolean1, boolean paramBoolean2) {
    return new DocumentSnapshot(paramFirebaseFirestore, paramDocument.getKey(), paramDocument, paramBoolean1, paramBoolean2);
  }
  
  static DocumentSnapshot fromNoDocument(FirebaseFirestore paramFirebaseFirestore, DocumentKey paramDocumentKey, boolean paramBoolean1, boolean paramBoolean2) {
    return new DocumentSnapshot(paramFirebaseFirestore, paramDocumentKey, null, paramBoolean1, paramBoolean2);
  }
  
  private Object getInternal(FieldPath paramFieldPath, FieldValueOptions paramFieldValueOptions) {
    Document document = this.doc;
    if (document != null) {
      FieldValue fieldValue = document.getField(paramFieldPath);
      if (fieldValue != null)
        return convertValue(fieldValue, paramFieldValueOptions); 
    } 
    return null;
  }
  
  private <T> T getTypedValue(String paramString, Class<T> paramClass) {
    Preconditions.checkNotNull(paramString, "Provided field must not be null.");
    return castTypedValue(get(paramString, ServerTimestampBehavior.DEFAULT), paramString, paramClass);
  }
  
  public boolean contains(FieldPath paramFieldPath) {
    boolean bool;
    Preconditions.checkNotNull(paramFieldPath, "Provided field path must not be null.");
    Document document = this.doc;
    if (document != null && document.getField(paramFieldPath.getInternalPath()) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean contains(String paramString) {
    return contains(FieldPath.fromDotSeparatedPath(paramString));
  }
  
  public boolean equals(Object paramObject) {
    null = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DocumentSnapshot))
      return false; 
    paramObject = paramObject;
    if (this.firestore.equals(((DocumentSnapshot)paramObject).firestore) && this.key.equals(((DocumentSnapshot)paramObject).key)) {
      Document document = this.doc;
      if (((document == null) ? (((DocumentSnapshot)paramObject).doc == null) : document.equals(((DocumentSnapshot)paramObject).doc)) && this.metadata.equals(((DocumentSnapshot)paramObject).metadata))
        return null; 
    } 
    return false;
  }
  
  public boolean exists() {
    boolean bool;
    if (this.doc != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Object get(FieldPath paramFieldPath) {
    return get(paramFieldPath, ServerTimestampBehavior.DEFAULT);
  }
  
  public Object get(FieldPath paramFieldPath, ServerTimestampBehavior paramServerTimestampBehavior) {
    Preconditions.checkNotNull(paramFieldPath, "Provided field path must not be null.");
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    return getInternal(paramFieldPath.getInternalPath(), new FieldValueOptions(paramServerTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled()));
  }
  
  public <T> T get(FieldPath paramFieldPath, Class<T> paramClass) {
    return get(paramFieldPath, paramClass, ServerTimestampBehavior.DEFAULT);
  }
  
  public <T> T get(FieldPath paramFieldPath, Class<T> paramClass, ServerTimestampBehavior paramServerTimestampBehavior) {
    Object object = get(paramFieldPath, paramServerTimestampBehavior);
    if (object == null) {
      object = null;
    } else {
      object = CustomClassMapper.convertToCustomClass(object, paramClass, getReference());
    } 
    return (T)object;
  }
  
  public Object get(String paramString) {
    return get(FieldPath.fromDotSeparatedPath(paramString), ServerTimestampBehavior.DEFAULT);
  }
  
  public Object get(String paramString, ServerTimestampBehavior paramServerTimestampBehavior) {
    return get(FieldPath.fromDotSeparatedPath(paramString), paramServerTimestampBehavior);
  }
  
  public <T> T get(String paramString, Class<T> paramClass) {
    return get(FieldPath.fromDotSeparatedPath(paramString), paramClass, ServerTimestampBehavior.DEFAULT);
  }
  
  public <T> T get(String paramString, Class<T> paramClass, ServerTimestampBehavior paramServerTimestampBehavior) {
    return get(FieldPath.fromDotSeparatedPath(paramString), paramClass, paramServerTimestampBehavior);
  }
  
  public Blob getBlob(String paramString) {
    return getTypedValue(paramString, Blob.class);
  }
  
  public Boolean getBoolean(String paramString) {
    return getTypedValue(paramString, Boolean.class);
  }
  
  public Map<String, Object> getData() {
    return getData(ServerTimestampBehavior.DEFAULT);
  }
  
  public Map<String, Object> getData(ServerTimestampBehavior paramServerTimestampBehavior) {
    Map<String, Object> map;
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    Document document = this.doc;
    ServerTimestampBehavior serverTimestampBehavior = null;
    if (document == null) {
      paramServerTimestampBehavior = serverTimestampBehavior;
    } else {
      map = convertObject(document.getData(), new FieldValueOptions(paramServerTimestampBehavior, this.firestore.getFirestoreSettings().areTimestampsInSnapshotsEnabled()));
    } 
    return map;
  }
  
  public Date getDate(String paramString) {
    return getDate(paramString, ServerTimestampBehavior.DEFAULT);
  }
  
  public Date getDate(String paramString, ServerTimestampBehavior paramServerTimestampBehavior) {
    Preconditions.checkNotNull(paramString, "Provided field path must not be null.");
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    return castTypedValue(getInternal(FieldPath.fromDotSeparatedPath(paramString).getInternalPath(), new FieldValueOptions(paramServerTimestampBehavior, false)), paramString, Date.class);
  }
  
  Document getDocument() {
    return this.doc;
  }
  
  public DocumentReference getDocumentReference(String paramString) {
    return getTypedValue(paramString, DocumentReference.class);
  }
  
  public Double getDouble(String paramString) {
    Number number = getTypedValue(paramString, Number.class);
    if (number != null) {
      number = Double.valueOf(number.doubleValue());
    } else {
      number = null;
    } 
    return (Double)number;
  }
  
  public GeoPoint getGeoPoint(String paramString) {
    return getTypedValue(paramString, GeoPoint.class);
  }
  
  public String getId() {
    return this.key.getPath().getLastSegment();
  }
  
  public Long getLong(String paramString) {
    Number number = getTypedValue(paramString, Number.class);
    if (number != null) {
      number = Long.valueOf(number.longValue());
    } else {
      number = null;
    } 
    return (Long)number;
  }
  
  public SnapshotMetadata getMetadata() {
    return this.metadata;
  }
  
  public DocumentReference getReference() {
    return new DocumentReference(this.key, this.firestore);
  }
  
  public String getString(String paramString) {
    return getTypedValue(paramString, String.class);
  }
  
  public Timestamp getTimestamp(String paramString) {
    return getTimestamp(paramString, ServerTimestampBehavior.DEFAULT);
  }
  
  public Timestamp getTimestamp(String paramString, ServerTimestampBehavior paramServerTimestampBehavior) {
    Preconditions.checkNotNull(paramString, "Provided field path must not be null.");
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    return castTypedValue(getInternal(FieldPath.fromDotSeparatedPath(paramString).getInternalPath(), new FieldValueOptions(paramServerTimestampBehavior, true)), paramString, Timestamp.class);
  }
  
  public int hashCode() {
    byte b;
    int i = this.firestore.hashCode();
    int j = this.key.hashCode();
    Document document = this.doc;
    if (document != null) {
      b = document.hashCode();
    } else {
      b = 0;
    } 
    return ((i * 31 + j) * 31 + b) * 31 + this.metadata.hashCode();
  }
  
  public <T> T toObject(Class<T> paramClass) {
    return toObject(paramClass, ServerTimestampBehavior.DEFAULT);
  }
  
  public <T> T toObject(Class<T> paramClass, ServerTimestampBehavior paramServerTimestampBehavior) {
    Object object;
    Preconditions.checkNotNull(paramClass, "Provided POJO type must not be null.");
    Preconditions.checkNotNull(paramServerTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
    Map<String, Object> map = getData(paramServerTimestampBehavior);
    if (map == null) {
      paramClass = null;
    } else {
      object = CustomClassMapper.convertToCustomClass(map, paramClass, getReference());
    } 
    return (T)object;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DocumentSnapshot{key=");
    stringBuilder.append(this.key);
    stringBuilder.append(", metadata=");
    stringBuilder.append(this.metadata);
    stringBuilder.append(", doc=");
    stringBuilder.append(this.doc);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  static class FieldValueOptions {
    final DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior;
    
    final boolean timestampsInSnapshotsEnabled;
    
    private FieldValueOptions(DocumentSnapshot.ServerTimestampBehavior param1ServerTimestampBehavior, boolean param1Boolean) {
      this.serverTimestampBehavior = param1ServerTimestampBehavior;
      this.timestampsInSnapshotsEnabled = param1Boolean;
    }
  }
  
  public enum ServerTimestampBehavior {
    ESTIMATE, NONE, PREVIOUS;
    
    static final ServerTimestampBehavior DEFAULT;
    
    static {
      ServerTimestampBehavior serverTimestampBehavior = NONE;
      $VALUES = new ServerTimestampBehavior[] { serverTimestampBehavior, ESTIMATE, PREVIOUS };
      DEFAULT = serverTimestampBehavior;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\DocumentSnapshot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */