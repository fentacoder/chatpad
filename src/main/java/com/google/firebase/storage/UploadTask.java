package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadTask extends StorageTask<UploadTask.TaskSnapshot> {
  private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
  
  private static final int MAXIMUM_CHUNK_SIZE = 33554432;
  
  static final int PREFERRED_CHUNK_SIZE = 262144;
  
  private static final String RESUMABLE_FINAL_STATUS = "final";
  
  private static final String TAG = "UploadTask";
  
  private static final String X_GOOG_UPLOAD_URL = "X-Goog-Upload-URL";
  
  private final InternalAuthProvider mAuthProvider;
  
  private final AtomicLong mBytesUploaded = new AtomicLong(0L);
  
  private int mCurrentChunkSize = 262144;
  
  private volatile Exception mException = null;
  
  private boolean mIsStreamOwned;
  
  private volatile StorageMetadata mMetadata;
  
  private volatile int mResultCode = 0;
  
  private ExponentialBackoffSender mSender;
  
  private volatile Exception mServerException = null;
  
  private volatile String mServerStatus;
  
  private final StorageReference mStorageRef;
  
  private final AdaptiveStreamBuffer mStreamBuffer;
  
  private final long mTotalByteCount;
  
  private volatile Uri mUploadUri = null;
  
  private final Uri mUri;
  
  UploadTask(StorageReference paramStorageReference, StorageMetadata paramStorageMetadata, Uri paramUri1, Uri paramUri2) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: new java/util/concurrent/atomic/AtomicLong
    //   8: dup
    //   9: lconst_0
    //   10: invokespecial <init> : (J)V
    //   13: putfield mBytesUploaded : Ljava/util/concurrent/atomic/AtomicLong;
    //   16: aload_0
    //   17: ldc 262144
    //   19: putfield mCurrentChunkSize : I
    //   22: aconst_null
    //   23: astore #5
    //   25: aconst_null
    //   26: astore #6
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield mUploadUri : Landroid/net/Uri;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield mException : Ljava/lang/Exception;
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield mServerException : Ljava/lang/Exception;
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield mResultCode : I
    //   48: aload_1
    //   49: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_3
    //   54: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual getStorage : ()Lcom/google/firebase/storage/FirebaseStorage;
    //   62: astore #7
    //   64: aload_0
    //   65: aload_1
    //   66: putfield mStorageRef : Lcom/google/firebase/storage/StorageReference;
    //   69: aload_0
    //   70: aload_2
    //   71: putfield mMetadata : Lcom/google/firebase/storage/StorageMetadata;
    //   74: aload_0
    //   75: aload #7
    //   77: invokevirtual getAuthProvider : ()Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   80: putfield mAuthProvider : Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   83: aload_0
    //   84: aload_3
    //   85: putfield mUri : Landroid/net/Uri;
    //   88: aload_0
    //   89: new com/google/firebase/storage/internal/ExponentialBackoffSender
    //   92: dup
    //   93: aload_0
    //   94: getfield mStorageRef : Lcom/google/firebase/storage/StorageReference;
    //   97: invokevirtual getApp : ()Lcom/google/firebase/FirebaseApp;
    //   100: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   103: aload_0
    //   104: getfield mAuthProvider : Lcom/google/firebase/auth/internal/InternalAuthProvider;
    //   107: aload #7
    //   109: invokevirtual getMaxUploadRetryTimeMillis : ()J
    //   112: invokespecial <init> : (Landroid/content/Context;Lcom/google/firebase/auth/internal/InternalAuthProvider;J)V
    //   115: putfield mSender : Lcom/google/firebase/storage/internal/ExponentialBackoffSender;
    //   118: ldc2_w -1
    //   121: lstore #8
    //   123: aload #5
    //   125: astore_1
    //   126: lload #8
    //   128: lstore #10
    //   130: aload_0
    //   131: getfield mStorageRef : Lcom/google/firebase/storage/StorageReference;
    //   134: invokevirtual getStorage : ()Lcom/google/firebase/storage/FirebaseStorage;
    //   137: invokevirtual getApp : ()Lcom/google/firebase/FirebaseApp;
    //   140: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   143: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   146: astore_3
    //   147: aload #5
    //   149: astore_1
    //   150: lload #8
    //   152: lstore #10
    //   154: aload_3
    //   155: aload_0
    //   156: getfield mUri : Landroid/net/Uri;
    //   159: ldc 'r'
    //   161: invokevirtual openFileDescriptor : (Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull -> 313
    //   169: aload #5
    //   171: astore_1
    //   172: lload #8
    //   174: lstore #10
    //   176: aload_2
    //   177: invokevirtual getStatSize : ()J
    //   180: lstore #8
    //   182: aload #6
    //   184: astore_1
    //   185: lload #8
    //   187: lstore #10
    //   189: aload_2
    //   190: invokevirtual close : ()V
    //   193: goto -> 318
    //   196: astore_2
    //   197: goto -> 210
    //   200: astore_2
    //   201: goto -> 297
    //   204: astore_2
    //   205: ldc2_w -1
    //   208: lstore #8
    //   210: aload #6
    //   212: astore_1
    //   213: lload #8
    //   215: lstore #10
    //   217: new java/lang/StringBuilder
    //   220: astore #5
    //   222: aload #6
    //   224: astore_1
    //   225: lload #8
    //   227: lstore #10
    //   229: aload #5
    //   231: invokespecial <init> : ()V
    //   234: aload #6
    //   236: astore_1
    //   237: lload #8
    //   239: lstore #10
    //   241: aload #5
    //   243: ldc 'could not retrieve file size for upload '
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload #6
    //   251: astore_1
    //   252: lload #8
    //   254: lstore #10
    //   256: aload #5
    //   258: aload_0
    //   259: getfield mUri : Landroid/net/Uri;
    //   262: invokevirtual toString : ()Ljava/lang/String;
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #6
    //   271: astore_1
    //   272: lload #8
    //   274: lstore #10
    //   276: ldc 'UploadTask'
    //   278: aload #5
    //   280: invokevirtual toString : ()Ljava/lang/String;
    //   283: aload_2
    //   284: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   287: pop
    //   288: goto -> 318
    //   291: astore_2
    //   292: ldc2_w -1
    //   295: lstore #8
    //   297: aload #6
    //   299: astore_1
    //   300: lload #8
    //   302: lstore #10
    //   304: ldc 'UploadTask'
    //   306: ldc 'NullPointerException during file size calculation.'
    //   308: aload_2
    //   309: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   312: pop
    //   313: ldc2_w -1
    //   316: lstore #8
    //   318: aload #6
    //   320: astore_1
    //   321: lload #8
    //   323: lstore #10
    //   325: aload_3
    //   326: aload_0
    //   327: getfield mUri : Landroid/net/Uri;
    //   330: invokevirtual openInputStream : (Landroid/net/Uri;)Ljava/io/InputStream;
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull -> 407
    //   338: lload #8
    //   340: lstore #10
    //   342: lload #8
    //   344: ldc2_w -1
    //   347: lcmp
    //   348: ifne -> 377
    //   351: aload_2
    //   352: astore_1
    //   353: lload #8
    //   355: lstore #10
    //   357: aload_2
    //   358: invokevirtual available : ()I
    //   361: istore #12
    //   363: lload #8
    //   365: lstore #10
    //   367: iload #12
    //   369: iflt -> 377
    //   372: iload #12
    //   374: i2l
    //   375: lstore #10
    //   377: lload #10
    //   379: lstore #8
    //   381: aload_2
    //   382: astore_1
    //   383: lload #8
    //   385: lstore #10
    //   387: new java/io/BufferedInputStream
    //   390: astore_3
    //   391: aload_2
    //   392: astore_1
    //   393: lload #8
    //   395: lstore #10
    //   397: aload_3
    //   398: aload_2
    //   399: invokespecial <init> : (Ljava/io/InputStream;)V
    //   402: aload_3
    //   403: astore_1
    //   404: goto -> 463
    //   407: aload_2
    //   408: astore_1
    //   409: goto -> 463
    //   412: astore_2
    //   413: goto -> 417
    //   416: astore_2
    //   417: new java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial <init> : ()V
    //   424: astore_3
    //   425: aload_3
    //   426: ldc 'could not locate file for uploading:'
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_3
    //   433: aload_0
    //   434: getfield mUri : Landroid/net/Uri;
    //   437: invokevirtual toString : ()Ljava/lang/String;
    //   440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: ldc 'UploadTask'
    //   446: aload_3
    //   447: invokevirtual toString : ()Ljava/lang/String;
    //   450: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   453: pop
    //   454: aload_0
    //   455: aload_2
    //   456: putfield mException : Ljava/lang/Exception;
    //   459: lload #10
    //   461: lstore #8
    //   463: aload_0
    //   464: lload #8
    //   466: putfield mTotalByteCount : J
    //   469: aload_0
    //   470: new com/google/firebase/storage/internal/AdaptiveStreamBuffer
    //   473: dup
    //   474: aload_1
    //   475: ldc 262144
    //   477: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   480: putfield mStreamBuffer : Lcom/google/firebase/storage/internal/AdaptiveStreamBuffer;
    //   483: aload_0
    //   484: iconst_1
    //   485: putfield mIsStreamOwned : Z
    //   488: aload_0
    //   489: aload #4
    //   491: putfield mUploadUri : Landroid/net/Uri;
    //   494: return
    //   495: astore_1
    //   496: lload #8
    //   498: lstore #10
    //   500: goto -> 377
    // Exception table:
    //   from	to	target	type
    //   130	147	416	java/io/FileNotFoundException
    //   154	165	291	java/lang/NullPointerException
    //   154	165	204	java/io/IOException
    //   154	165	416	java/io/FileNotFoundException
    //   176	182	291	java/lang/NullPointerException
    //   176	182	204	java/io/IOException
    //   176	182	416	java/io/FileNotFoundException
    //   189	193	200	java/lang/NullPointerException
    //   189	193	196	java/io/IOException
    //   189	193	412	java/io/FileNotFoundException
    //   217	222	412	java/io/FileNotFoundException
    //   229	234	412	java/io/FileNotFoundException
    //   241	249	412	java/io/FileNotFoundException
    //   256	269	412	java/io/FileNotFoundException
    //   276	288	412	java/io/FileNotFoundException
    //   304	313	412	java/io/FileNotFoundException
    //   325	334	412	java/io/FileNotFoundException
    //   357	363	495	java/io/IOException
    //   357	363	412	java/io/FileNotFoundException
    //   387	391	416	java/io/FileNotFoundException
    //   397	402	416	java/io/FileNotFoundException
  }
  
  UploadTask(StorageReference paramStorageReference, StorageMetadata paramStorageMetadata, InputStream paramInputStream) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramInputStream);
    FirebaseStorage firebaseStorage = paramStorageReference.getStorage();
    this.mTotalByteCount = -1L;
    this.mStorageRef = paramStorageReference;
    this.mMetadata = paramStorageMetadata;
    this.mAuthProvider = firebaseStorage.getAuthProvider();
    this.mStreamBuffer = new AdaptiveStreamBuffer(paramInputStream, 262144);
    this.mIsStreamOwned = false;
    this.mUri = null;
    this.mSender = new ExponentialBackoffSender(this.mStorageRef.getApp().getApplicationContext(), this.mAuthProvider, this.mStorageRef.getStorage().getMaxUploadRetryTimeMillis());
  }
  
  UploadTask(StorageReference paramStorageReference, StorageMetadata paramStorageMetadata, byte[] paramArrayOfbyte) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramArrayOfbyte);
    FirebaseStorage firebaseStorage = paramStorageReference.getStorage();
    this.mTotalByteCount = paramArrayOfbyte.length;
    this.mStorageRef = paramStorageReference;
    this.mMetadata = paramStorageMetadata;
    this.mAuthProvider = firebaseStorage.getAuthProvider();
    this.mUri = null;
    this.mStreamBuffer = new AdaptiveStreamBuffer(new ByteArrayInputStream(paramArrayOfbyte), 262144);
    this.mIsStreamOwned = true;
    this.mSender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
  }
  
  private void beginResumableUpload() {
    JSONObject jSONObject;
    StorageMetadata storageMetadata2;
    StorageMetadata storageMetadata1 = this.mMetadata;
    String str3 = null;
    if (storageMetadata1 != null) {
      storageMetadata2 = (StorageMetadata)this.mMetadata.getContentType();
    } else {
      storageMetadata2 = null;
    } 
    storageMetadata1 = storageMetadata2;
    if (this.mUri != null) {
      storageMetadata1 = storageMetadata2;
      if (TextUtils.isEmpty((CharSequence)storageMetadata2))
        str2 = this.mStorageRef.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri); 
    } 
    String str4 = str2;
    if (TextUtils.isEmpty(str2))
      str4 = "application/octet-stream"; 
    Uri uri = this.mStorageRef.getStorageUri();
    FirebaseApp firebaseApp = this.mStorageRef.getApp();
    String str2 = str3;
    if (this.mMetadata != null)
      jSONObject = this.mMetadata.createJSONObject(); 
    ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(uri, firebaseApp, jSONObject, str4);
    if (!sendWithRetry((NetworkRequest)resumableUploadStartRequest))
      return; 
    String str1 = resumableUploadStartRequest.getResultString("X-Goog-Upload-URL");
    if (!TextUtils.isEmpty(str1))
      this.mUploadUri = Uri.parse(str1); 
  }
  
  private boolean isValidHttpResponseCode(int paramInt) {
    return (paramInt == 308 || (paramInt >= 200 && paramInt < 300));
  }
  
  private boolean processResultValid(NetworkRequest paramNetworkRequest) {
    boolean bool;
    int i = paramNetworkRequest.getResultCode();
    int j = i;
    if (this.mSender.isRetryableError(i))
      j = -2; 
    this.mResultCode = j;
    this.mServerException = paramNetworkRequest.getException();
    this.mServerStatus = paramNetworkRequest.getResultString("X-Goog-Upload-Status");
    if (isValidHttpResponseCode(this.mResultCode) && this.mServerException == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean recoverStatus(boolean paramBoolean) {
    long l1;
    ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri);
    if ("final".equals(this.mServerStatus))
      return false; 
    if (paramBoolean) {
      if (!sendWithRetry((NetworkRequest)resumableUploadQueryRequest))
        return false; 
    } else if (!send((NetworkRequest)resumableUploadQueryRequest)) {
      return false;
    } 
    if ("final".equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
      this.mException = new IOException("The server has terminated the upload session");
      return false;
    } 
    String str = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
    if (!TextUtils.isEmpty(str)) {
      l1 = Long.parseLong(str);
    } else {
      l1 = 0L;
    } 
    long l2 = this.mBytesUploaded.get();
    int i = l2 cmp l1;
    if (i > 0) {
      this.mException = new IOException("Unexpected error. The server lost a chunk update.");
      return false;
    } 
    if (i < 0)
      try {
        AdaptiveStreamBuffer adaptiveStreamBuffer = this.mStreamBuffer;
        long l = l1 - l2;
        if (adaptiveStreamBuffer.advance((int)l) != l) {
          IOException iOException = new IOException();
          this("Unexpected end of stream encountered.");
          this.mException = iOException;
          return false;
        } 
        if (!this.mBytesUploaded.compareAndSet(l2, l1)) {
          Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
          IllegalStateException illegalStateException = new IllegalStateException();
          this("uploaded bytes changed unexpectedly.");
          this.mException = illegalStateException;
          return false;
        } 
      } catch (IOException iOException) {
        Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", iOException);
        this.mException = iOException;
        return false;
      }  
    return true;
  }
  
  private boolean send(NetworkRequest paramNetworkRequest) {
    paramNetworkRequest.performRequest(Util.getCurrentAuthToken(this.mAuthProvider), this.mStorageRef.getApp().getApplicationContext());
    return processResultValid(paramNetworkRequest);
  }
  
  private boolean sendWithRetry(NetworkRequest paramNetworkRequest) {
    this.mSender.sendWithExponentialBackoff(paramNetworkRequest);
    return processResultValid(paramNetworkRequest);
  }
  
  private boolean serverStateValid() {
    if ("final".equals(this.mServerStatus)) {
      if (this.mException == null)
        this.mException = new IOException("The server has terminated the upload session", this.mServerException); 
      tryChangeState(64, false);
      return false;
    } 
    return true;
  }
  
  private boolean shouldContinue() {
    boolean bool;
    if (getInternalState() == 128)
      return false; 
    if (Thread.interrupted()) {
      this.mException = new InterruptedException();
      tryChangeState(64, false);
      return false;
    } 
    if (getInternalState() == 32) {
      tryChangeState(256, false);
      return false;
    } 
    if (getInternalState() == 8) {
      tryChangeState(16, false);
      return false;
    } 
    if (!serverStateValid())
      return false; 
    if (this.mUploadUri == null) {
      if (this.mException == null)
        this.mException = new IllegalStateException("Unable to obtain an upload URL."); 
      tryChangeState(64, false);
      return false;
    } 
    if (this.mException != null) {
      tryChangeState(64, false);
      return false;
    } 
    if (this.mServerException != null || this.mResultCode < 200 || this.mResultCode >= 300) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && !recoverStatus(true)) {
      if (serverStateValid())
        tryChangeState(64, false); 
      return false;
    } 
    return true;
  }
  
  private void uploadChunk() {
    try {
      StringBuilder stringBuilder;
      this.mStreamBuffer.fill(this.mCurrentChunkSize);
      int i = Math.min(this.mCurrentChunkSize, this.mStreamBuffer.available());
      ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest();
      this(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri, this.mStreamBuffer.get(), this.mBytesUploaded.get(), i, this.mStreamBuffer.isFinished());
      if (!send((NetworkRequest)resumableUploadByteRequest)) {
        this.mCurrentChunkSize = 262144;
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Resetting chunk size to ");
        stringBuilder.append(this.mCurrentChunkSize);
        Log.d("UploadTask", stringBuilder.toString());
        return;
      } 
      this.mBytesUploaded.getAndAdd(i);
      if (!this.mStreamBuffer.isFinished()) {
        this.mStreamBuffer.advance(i);
        if (this.mCurrentChunkSize < 33554432) {
          this.mCurrentChunkSize *= 2;
          stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Increasing chunk size to ");
          stringBuilder.append(this.mCurrentChunkSize);
          Log.d("UploadTask", stringBuilder.toString());
        } 
      } else {
        try {
          StorageMetadata.Builder builder = new StorageMetadata.Builder();
          this(stringBuilder.getResultBody(), this.mStorageRef);
          this.mMetadata = builder.build();
          tryChangeState(4, false);
          tryChangeState(128, false);
        } catch (JSONException jSONException) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("Unable to parse resulting metadata from upload:");
          stringBuilder1.append(stringBuilder.getRawResult());
          Log.e("UploadTask", stringBuilder1.toString(), (Throwable)jSONException);
          this.mException = (Exception)jSONException;
          return;
        } 
      } 
    } catch (IOException iOException) {
      Log.e("UploadTask", "Unable to read bytes for uploading", iOException);
      this.mException = iOException;
    } 
  }
  
  StorageReference getStorage() {
    return this.mStorageRef;
  }
  
  long getTotalByteCount() {
    return this.mTotalByteCount;
  }
  
  protected void onCanceled() {
    final NetworkRequest finalCancelRequest;
    this.mSender.cancel();
    if (this.mUploadUri != null) {
      networkRequest = (NetworkRequest)new ResumableUploadCancelRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mUploadUri);
    } else {
      networkRequest = null;
    } 
    if (networkRequest != null)
      StorageTaskScheduler.getInstance().scheduleCommand(new Runnable() {
            public void run() {
              finalCancelRequest.performRequest(Util.getCurrentAuthToken(UploadTask.this.mAuthProvider), UploadTask.this.mStorageRef.getApp().getApplicationContext());
            }
          }); 
    this.mException = (Exception)StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    super.onCanceled();
  }
  
  protected void resetState() {
    this.mException = null;
    this.mServerException = null;
    this.mResultCode = 0;
    this.mServerStatus = null;
  }
  
  void run() {
    this.mSender.reset();
    if (!tryChangeState(4, false)) {
      Log.d("UploadTask", "The upload cannot continue as it is not in a valid state.");
      return;
    } 
    if (this.mStorageRef.getParent() == null)
      this.mException = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile..."); 
    if (this.mException != null)
      return; 
    if (this.mUploadUri == null) {
      beginResumableUpload();
    } else {
      recoverStatus(false);
    } 
    boolean bool = shouldContinue();
    while (bool) {
      uploadChunk();
      boolean bool1 = shouldContinue();
      bool = bool1;
      if (bool1) {
        tryChangeState(4, false);
        bool = bool1;
      } 
    } 
    if (this.mIsStreamOwned && getInternalState() != 16)
      try {
        this.mStreamBuffer.close();
      } catch (IOException iOException) {
        Log.e("UploadTask", "Unable to close stream.", iOException);
      }  
  }
  
  protected void schedule() {
    StorageTaskScheduler.getInstance().scheduleUpload(getRunnable());
  }
  
  TaskSnapshot snapStateImpl() {
    Exception exception;
    if (this.mException != null) {
      exception = this.mException;
    } else {
      exception = this.mServerException;
    } 
    return new TaskSnapshot((Exception)StorageException.fromExceptionAndHttpCode(exception, this.mResultCode), this.mBytesUploaded.get(), this.mUploadUri, this.mMetadata);
  }
  
  public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
    private final long mBytesUploaded;
    
    private final StorageMetadata mMetadata;
    
    private final Uri mUploadUri;
    
    TaskSnapshot(Exception param1Exception, long param1Long, Uri param1Uri, StorageMetadata param1StorageMetadata) {
      super(param1Exception);
      this.mBytesUploaded = param1Long;
      this.mUploadUri = param1Uri;
      this.mMetadata = param1StorageMetadata;
    }
    
    public long getBytesTransferred() {
      return this.mBytesUploaded;
    }
    
    public StorageMetadata getMetadata() {
      return this.mMetadata;
    }
    
    public long getTotalByteCount() {
      return UploadTask.this.getTotalByteCount();
    }
    
    public Uri getUploadSessionUri() {
      return this.mUploadUri;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\UploadTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */