package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class StorageMetadata {
  private static final String BUCKET_KEY = "bucket";
  
  private static final String CACHE_CONTROL = "cacheControl";
  
  private static final String CONTENT_DISPOSITION = "contentDisposition";
  
  private static final String CONTENT_ENCODING = "contentEncoding";
  
  private static final String CONTENT_LANGUAGE = "contentLanguage";
  
  private static final String CONTENT_TYPE_KEY = "contentType";
  
  private static final String CUSTOM_METADATA_KEY = "metadata";
  
  private static final String GENERATION_KEY = "generation";
  
  private static final String MD5_HASH_KEY = "md5Hash";
  
  private static final String META_GENERATION_KEY = "metageneration";
  
  private static final String NAME_KEY = "name";
  
  private static final String SIZE_KEY = "size";
  
  private static final String TAG = "StorageMetadata";
  
  private static final String TIME_CREATED_KEY = "timeCreated";
  
  private static final String TIME_UPDATED_KEY = "updated";
  
  private String mBucket = null;
  
  private MetadataValue<String> mCacheControl = MetadataValue.withDefaultValue("");
  
  private MetadataValue<String> mContentDisposition = MetadataValue.withDefaultValue("");
  
  private MetadataValue<String> mContentEncoding = MetadataValue.withDefaultValue("");
  
  private MetadataValue<String> mContentLanguage = MetadataValue.withDefaultValue("");
  
  private MetadataValue<String> mContentType = MetadataValue.withDefaultValue("");
  
  private String mCreationTime = null;
  
  private MetadataValue<Map<String, String>> mCustomMetadata = MetadataValue.withDefaultValue(Collections.emptyMap());
  
  private String mGeneration = null;
  
  private String mMD5Hash = null;
  
  private String mMetadataGeneration = null;
  
  private String mPath = null;
  
  private long mSize;
  
  private FirebaseStorage mStorage = null;
  
  private StorageReference mStorageRef = null;
  
  private String mUpdatedTime = null;
  
  public StorageMetadata() {}
  
  private StorageMetadata(StorageMetadata paramStorageMetadata, boolean paramBoolean) {
    Preconditions.checkNotNull(paramStorageMetadata);
    this.mPath = paramStorageMetadata.mPath;
    this.mStorage = paramStorageMetadata.mStorage;
    this.mStorageRef = paramStorageMetadata.mStorageRef;
    this.mBucket = paramStorageMetadata.mBucket;
    this.mContentType = paramStorageMetadata.mContentType;
    this.mCacheControl = paramStorageMetadata.mCacheControl;
    this.mContentDisposition = paramStorageMetadata.mContentDisposition;
    this.mContentEncoding = paramStorageMetadata.mContentEncoding;
    this.mContentLanguage = paramStorageMetadata.mContentLanguage;
    this.mCustomMetadata = paramStorageMetadata.mCustomMetadata;
    if (paramBoolean) {
      this.mMD5Hash = paramStorageMetadata.mMD5Hash;
      this.mSize = paramStorageMetadata.mSize;
      this.mUpdatedTime = paramStorageMetadata.mUpdatedTime;
      this.mCreationTime = paramStorageMetadata.mCreationTime;
      this.mMetadataGeneration = paramStorageMetadata.mMetadataGeneration;
      this.mGeneration = paramStorageMetadata.mGeneration;
    } 
  }
  
  JSONObject createJSONObject() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    if (this.mContentType.isUserProvided())
      hashMap.put("contentType", getContentType()); 
    if (this.mCustomMetadata.isUserProvided())
      hashMap.put("metadata", new JSONObject(this.mCustomMetadata.getValue())); 
    if (this.mCacheControl.isUserProvided())
      hashMap.put("cacheControl", getCacheControl()); 
    if (this.mContentDisposition.isUserProvided())
      hashMap.put("contentDisposition", getContentDisposition()); 
    if (this.mContentEncoding.isUserProvided())
      hashMap.put("contentEncoding", getContentEncoding()); 
    if (this.mContentLanguage.isUserProvided())
      hashMap.put("contentLanguage", getContentLanguage()); 
    return new JSONObject(hashMap);
  }
  
  public String getBucket() {
    return this.mBucket;
  }
  
  public String getCacheControl() {
    return this.mCacheControl.getValue();
  }
  
  public String getContentDisposition() {
    return this.mContentDisposition.getValue();
  }
  
  public String getContentEncoding() {
    return this.mContentEncoding.getValue();
  }
  
  public String getContentLanguage() {
    return this.mContentLanguage.getValue();
  }
  
  public String getContentType() {
    return this.mContentType.getValue();
  }
  
  public long getCreationTimeMillis() {
    return Util.parseDateTime(this.mCreationTime);
  }
  
  public String getCustomMetadata(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : (String)((Map)this.mCustomMetadata.getValue()).get(paramString);
  }
  
  public Set<String> getCustomMetadataKeys() {
    return ((Map)this.mCustomMetadata.getValue()).keySet();
  }
  
  public String getGeneration() {
    return this.mGeneration;
  }
  
  public String getMd5Hash() {
    return this.mMD5Hash;
  }
  
  public String getMetadataGeneration() {
    return this.mMetadataGeneration;
  }
  
  public String getName() {
    String str1 = getPath();
    if (TextUtils.isEmpty(str1))
      return null; 
    int i = str1.lastIndexOf('/');
    String str2 = str1;
    if (i != -1)
      str2 = str1.substring(i + 1); 
    return str2;
  }
  
  public String getPath() {
    String str = this.mPath;
    if (str == null)
      str = ""; 
    return str;
  }
  
  public StorageReference getReference() {
    if (this.mStorageRef == null && this.mStorage != null) {
      String str1 = getBucket();
      String str2 = getPath();
      return (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)) ? null : new StorageReference((new Uri.Builder()).scheme("gs").authority(str1).encodedPath(Slashes.preserveSlashEncode(str2)).build(), this.mStorage);
    } 
    return this.mStorageRef;
  }
  
  public long getSizeBytes() {
    return this.mSize;
  }
  
  public long getUpdatedTimeMillis() {
    return Util.parseDateTime(this.mUpdatedTime);
  }
  
  public static class Builder {
    boolean mFromJSON;
    
    StorageMetadata mMetadata = new StorageMetadata();
    
    public Builder() {}
    
    public Builder(StorageMetadata param1StorageMetadata) {}
    
    Builder(JSONObject param1JSONObject) throws JSONException {
      if (param1JSONObject != null) {
        parseJSON(param1JSONObject);
        this.mFromJSON = true;
      } 
    }
    
    Builder(JSONObject param1JSONObject, StorageReference param1StorageReference) throws JSONException {
      this(param1JSONObject);
      StorageMetadata.access$102(this.mMetadata, param1StorageReference);
    }
    
    private String extractString(JSONObject param1JSONObject, String param1String) throws JSONException {
      return (param1JSONObject.has(param1String) && !param1JSONObject.isNull(param1String)) ? param1JSONObject.getString(param1String) : null;
    }
    
    private void parseJSON(JSONObject param1JSONObject) throws JSONException {
      StorageMetadata.access$202(this.mMetadata, param1JSONObject.optString("generation"));
      StorageMetadata.access$302(this.mMetadata, param1JSONObject.optString("name"));
      StorageMetadata.access$402(this.mMetadata, param1JSONObject.optString("bucket"));
      StorageMetadata.access$502(this.mMetadata, param1JSONObject.optString("metageneration"));
      StorageMetadata.access$602(this.mMetadata, param1JSONObject.optString("timeCreated"));
      StorageMetadata.access$702(this.mMetadata, param1JSONObject.optString("updated"));
      StorageMetadata.access$802(this.mMetadata, param1JSONObject.optLong("size"));
      StorageMetadata.access$902(this.mMetadata, param1JSONObject.optString("md5Hash"));
      if (param1JSONObject.has("metadata") && !param1JSONObject.isNull("metadata")) {
        JSONObject jSONObject = param1JSONObject.getJSONObject("metadata");
        Iterator<String> iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          setCustomMetadata(str, jSONObject.getString(str));
        } 
      } 
      String str2 = extractString(param1JSONObject, "contentType");
      if (str2 != null)
        setContentType(str2); 
      str2 = extractString(param1JSONObject, "cacheControl");
      if (str2 != null)
        setCacheControl(str2); 
      str2 = extractString(param1JSONObject, "contentDisposition");
      if (str2 != null)
        setContentDisposition(str2); 
      str2 = extractString(param1JSONObject, "contentEncoding");
      if (str2 != null)
        setContentEncoding(str2); 
      String str1 = extractString(param1JSONObject, "contentLanguage");
      if (str1 != null)
        setContentLanguage(str1); 
    }
    
    public StorageMetadata build() {
      return new StorageMetadata(this.mMetadata, this.mFromJSON);
    }
    
    public String getCacheControl() {
      return this.mMetadata.mCacheControl.getValue();
    }
    
    public String getContentDisposition() {
      return this.mMetadata.mContentDisposition.getValue();
    }
    
    public String getContentEncoding() {
      return this.mMetadata.mContentEncoding.getValue();
    }
    
    public String getContentLanguage() {
      return this.mMetadata.mContentLanguage.getValue();
    }
    
    public String getContentType() {
      return this.mMetadata.mContentType.getValue();
    }
    
    public Builder setCacheControl(String param1String) {
      StorageMetadata.access$1302(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(param1String));
      return this;
    }
    
    public Builder setContentDisposition(String param1String) {
      StorageMetadata.access$1202(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(param1String));
      return this;
    }
    
    public Builder setContentEncoding(String param1String) {
      StorageMetadata.access$1102(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(param1String));
      return this;
    }
    
    public Builder setContentLanguage(String param1String) {
      StorageMetadata.access$1002(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(param1String));
      return this;
    }
    
    public Builder setContentType(String param1String) {
      StorageMetadata.access$1502(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(param1String));
      return this;
    }
    
    public Builder setCustomMetadata(String param1String1, String param1String2) {
      if (!this.mMetadata.mCustomMetadata.isUserProvided())
        StorageMetadata.access$1402(this.mMetadata, StorageMetadata.MetadataValue.withUserValue(new HashMap<>())); 
      ((Map<String, String>)this.mMetadata.mCustomMetadata.getValue()).put(param1String1, param1String2);
      return this;
    }
  }
  
  private static class MetadataValue<T> {
    private final boolean userProvided;
    
    private final T value;
    
    MetadataValue(T param1T, boolean param1Boolean) {
      this.userProvided = param1Boolean;
      this.value = param1T;
    }
    
    static <T> MetadataValue<T> withDefaultValue(T param1T) {
      return new MetadataValue<>(param1T, false);
    }
    
    static <T> MetadataValue<T> withUserValue(T param1T) {
      return new MetadataValue<>(param1T, true);
    }
    
    T getValue() {
      return this.value;
    }
    
    boolean isUserProvided() {
      return this.userProvided;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageMetadata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */