package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import com.google.firebase.storage.internal.Util;
import java.io.UnsupportedEncodingException;

public class FirebaseStorage {
  private static final String STORAGE_BUCKET_WITH_PATH_EXCEPTION = "The storage Uri cannot contain a path element.";
  
  private static final String STORAGE_URI_PARSE_EXCEPTION = "The storage Uri could not be parsed.";
  
  private static final String TAG = "FirebaseStorage";
  
  private final FirebaseApp mApp;
  
  private final Provider<InternalAuthProvider> mAuthProvider;
  
  private final String mBucketName;
  
  private long sMaxDownloadRetry = 600000L;
  
  private long sMaxQueryRetry = 120000L;
  
  private long sMaxUploadRetry = 600000L;
  
  FirebaseStorage(String paramString, FirebaseApp paramFirebaseApp, Provider<InternalAuthProvider> paramProvider) {
    this.mBucketName = paramString;
    this.mApp = paramFirebaseApp;
    this.mAuthProvider = paramProvider;
  }
  
  private String getBucketName() {
    return this.mBucketName;
  }
  
  public static FirebaseStorage getInstance() {
    boolean bool;
    FirebaseApp firebaseApp = FirebaseApp.getInstance();
    if (firebaseApp != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "You must call FirebaseApp.initialize() first.");
    return getInstance(firebaseApp);
  }
  
  public static FirebaseStorage getInstance(FirebaseApp paramFirebaseApp) {
    boolean bool;
    if (paramFirebaseApp != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Null is not a valid value for the FirebaseApp.");
    String str = paramFirebaseApp.getOptions().getStorageBucket();
    if (str == null)
      return getInstanceImpl(paramFirebaseApp, null); 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("gs://");
      stringBuilder.append(paramFirebaseApp.getOptions().getStorageBucket());
      return getInstanceImpl(paramFirebaseApp, Util.normalize(paramFirebaseApp, stringBuilder.toString()));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to parse bucket:");
      stringBuilder.append(str);
      Log.e("FirebaseStorage", stringBuilder.toString(), unsupportedEncodingException);
      throw new IllegalArgumentException("The storage Uri could not be parsed.");
    } 
  }
  
  public static FirebaseStorage getInstance(FirebaseApp paramFirebaseApp, String paramString) {
    boolean bool2;
    boolean bool1 = true;
    if (paramFirebaseApp != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Null is not a valid value for the FirebaseApp.");
    if (paramString != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Null is not a valid value for the Firebase Storage URL.");
    if (paramString.toLowerCase().startsWith("gs://"))
      try {
        return getInstanceImpl(paramFirebaseApp, Util.normalize(paramFirebaseApp, paramString));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to parse url:");
        stringBuilder.append(paramString);
        Log.e("FirebaseStorage", stringBuilder.toString(), unsupportedEncodingException);
        throw new IllegalArgumentException("The storage Uri could not be parsed.");
      }  
    throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
  }
  
  public static FirebaseStorage getInstance(String paramString) {
    boolean bool;
    FirebaseApp firebaseApp = FirebaseApp.getInstance();
    if (firebaseApp != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "You must call FirebaseApp.initialize() first.");
    return getInstance(firebaseApp, paramString);
  }
  
  private static FirebaseStorage getInstanceImpl(FirebaseApp paramFirebaseApp, Uri paramUri) {
    String str;
    if (paramUri != null) {
      str = paramUri.getHost();
    } else {
      str = null;
    } 
    if (paramUri == null || TextUtils.isEmpty(paramUri.getPath())) {
      Preconditions.checkNotNull(paramFirebaseApp, "Provided FirebaseApp must not be null.");
      FirebaseStorageComponent firebaseStorageComponent = (FirebaseStorageComponent)paramFirebaseApp.get(FirebaseStorageComponent.class);
      Preconditions.checkNotNull(firebaseStorageComponent, "Firebase Storage component is not present.");
      return firebaseStorageComponent.get(str);
    } 
    throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
  }
  
  private StorageReference getReference(Uri paramUri) {
    Preconditions.checkNotNull(paramUri, "uri must not be null");
    String str = getBucketName();
    if (TextUtils.isEmpty(str) || paramUri.getAuthority().equalsIgnoreCase(str)) {
      boolean bool1 = true;
      Preconditions.checkArgument(bool1, "The supplied bucketname does not match the storage bucket of the current instance.");
      return new StorageReference(paramUri, this);
    } 
    boolean bool = false;
    Preconditions.checkArgument(bool, "The supplied bucketname does not match the storage bucket of the current instance.");
    return new StorageReference(paramUri, this);
  }
  
  public FirebaseApp getApp() {
    return this.mApp;
  }
  
  InternalAuthProvider getAuthProvider() {
    Provider<InternalAuthProvider> provider = this.mAuthProvider;
    if (provider != null) {
      InternalAuthProvider internalAuthProvider = (InternalAuthProvider)provider.get();
    } else {
      provider = null;
    } 
    return (InternalAuthProvider)provider;
  }
  
  public long getMaxDownloadRetryTimeMillis() {
    return this.sMaxDownloadRetry;
  }
  
  public long getMaxOperationRetryTimeMillis() {
    return this.sMaxQueryRetry;
  }
  
  public long getMaxUploadRetryTimeMillis() {
    return this.sMaxUploadRetry;
  }
  
  public StorageReference getReference() {
    if (!TextUtils.isEmpty(getBucketName()))
      return getReference((new Uri.Builder()).scheme("gs").authority(getBucketName()).path("/").build()); 
    throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
  }
  
  public StorageReference getReference(String paramString) {
    Preconditions.checkArgument(TextUtils.isEmpty(paramString) ^ true, "location must not be null or empty");
    String str = paramString.toLowerCase();
    if (!str.startsWith("gs://") && !str.startsWith("https://") && !str.startsWith("http://"))
      return getReference().child(paramString); 
    throw new IllegalArgumentException("location should not be a full URL.");
  }
  
  public StorageReference getReferenceFromUrl(String paramString) {
    Preconditions.checkArgument(TextUtils.isEmpty(paramString) ^ true, "location must not be null or empty");
    String str = paramString.toLowerCase();
    if (str.startsWith("gs://") || str.startsWith("https://") || str.startsWith("http://"))
      try {
        Uri uri = Util.normalize(this.mApp, paramString);
        if (uri != null)
          return getReference(uri); 
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        this("The storage Uri could not be parsed.");
        throw illegalArgumentException;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to parse location:");
        stringBuilder.append(paramString);
        Log.e("FirebaseStorage", stringBuilder.toString(), unsupportedEncodingException);
        throw new IllegalArgumentException("The storage Uri could not be parsed.");
      }  
    throw new IllegalArgumentException("The storage Uri could not be parsed.");
  }
  
  public void setMaxDownloadRetryTimeMillis(long paramLong) {
    this.sMaxDownloadRetry = paramLong;
  }
  
  public void setMaxOperationRetryTimeMillis(long paramLong) {
    this.sMaxQueryRetry = paramLong;
  }
  
  public void setMaxUploadRetryTimeMillis(long paramLong) {
    this.sMaxUploadRetry = paramLong;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\FirebaseStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */