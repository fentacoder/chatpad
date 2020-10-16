package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.Slashes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class StorageReference implements Comparable<StorageReference> {
  private static final String TAG = "StorageReference";
  
  private final FirebaseStorage mFirebaseStorage;
  
  private final Uri mStorageUri;
  
  StorageReference(Uri paramUri, FirebaseStorage paramFirebaseStorage) {
    boolean bool2;
    boolean bool1 = true;
    if (paramUri != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "storageUri cannot be null");
    if (paramFirebaseStorage != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "FirebaseApp cannot be null");
    this.mStorageUri = paramUri;
    this.mFirebaseStorage = paramFirebaseStorage;
  }
  
  private Task<ListResult> listHelper(Integer paramInteger, String paramString) {
    TaskCompletionSource<ListResult> taskCompletionSource = new TaskCompletionSource();
    StorageTaskScheduler.getInstance().scheduleCommand(new ListTask(this, paramInteger, paramString, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public StorageReference child(String paramString) {
    Preconditions.checkArgument(TextUtils.isEmpty(paramString) ^ true, "childName cannot be null or empty");
    paramString = Slashes.normalizeSlashes(paramString);
    return new StorageReference(this.mStorageUri.buildUpon().appendEncodedPath(Slashes.preserveSlashEncode(paramString)).build(), this.mFirebaseStorage);
  }
  
  public int compareTo(StorageReference paramStorageReference) {
    return this.mStorageUri.compareTo(paramStorageReference.mStorageUri);
  }
  
  public Task<Void> delete() {
    TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource();
    StorageTaskScheduler.getInstance().scheduleCommand(new DeleteStorageTask(this, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public boolean equals(Object paramObject) {
    return !(paramObject instanceof StorageReference) ? false : ((StorageReference)paramObject).toString().equals(toString());
  }
  
  public List<FileDownloadTask> getActiveDownloadTasks() {
    return StorageTaskManager.getInstance().getDownloadTasksUnder(this);
  }
  
  public List<UploadTask> getActiveUploadTasks() {
    return StorageTaskManager.getInstance().getUploadTasksUnder(this);
  }
  
  FirebaseApp getApp() {
    return getStorage().getApp();
  }
  
  public String getBucket() {
    return this.mStorageUri.getAuthority();
  }
  
  public Task<byte[]> getBytes(final long maxDownloadSizeBytes) {
    final TaskCompletionSource pendingResult = new TaskCompletionSource();
    StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
    streamDownloadTask.setStreamProcessor(new StreamDownloadTask.StreamProcessor() {
          public void doInBackground(StreamDownloadTask.TaskSnapshot param1TaskSnapshot, InputStream param1InputStream) throws IOException {
            try {
              ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
              this();
              byte[] arrayOfByte = new byte[16384];
              int i = 0;
              while (true) {
                int j = param1InputStream.read(arrayOfByte, 0, arrayOfByte.length);
                if (j != -1) {
                  i += j;
                  if (i <= maxDownloadSizeBytes) {
                    byteArrayOutputStream.write(arrayOfByte, 0, j);
                    continue;
                  } 
                  Log.e("StorageReference", "the maximum allowed buffer size was exceeded.");
                  IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                  this("the maximum allowed buffer size was exceeded.");
                  throw indexOutOfBoundsException;
                } 
                byteArrayOutputStream.flush();
                pendingResult.setResult(byteArrayOutputStream.toByteArray());
                return;
              } 
            } finally {
              param1InputStream.close();
            } 
          }
        }).addOnSuccessListener(new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() {
          public void onSuccess(StreamDownloadTask.TaskSnapshot param1TaskSnapshot) {
            if (!pendingResult.getTask().isComplete()) {
              Log.e("StorageReference", "getBytes 'succeeded', but failed to set a Result.");
              pendingResult.setException((Exception)StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR));
            } 
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            StorageException storageException = StorageException.fromExceptionAndHttpCode(param1Exception, 0);
            pendingResult.setException((Exception)storageException);
          }
        });
    streamDownloadTask.queue();
    return taskCompletionSource.getTask();
  }
  
  public Task<Uri> getDownloadUrl() {
    TaskCompletionSource<Uri> taskCompletionSource = new TaskCompletionSource();
    StorageTaskScheduler.getInstance().scheduleCommand(new GetDownloadUrlTask(this, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public FileDownloadTask getFile(Uri paramUri) {
    FileDownloadTask fileDownloadTask = new FileDownloadTask(this, paramUri);
    fileDownloadTask.queue();
    return fileDownloadTask;
  }
  
  public FileDownloadTask getFile(File paramFile) {
    return getFile(Uri.fromFile(paramFile));
  }
  
  public Task<StorageMetadata> getMetadata() {
    TaskCompletionSource<StorageMetadata> taskCompletionSource = new TaskCompletionSource();
    StorageTaskScheduler.getInstance().scheduleCommand(new GetMetadataTask(this, taskCompletionSource));
    return taskCompletionSource.getTask();
  }
  
  public String getName() {
    String str1 = this.mStorageUri.getPath();
    int i = str1.lastIndexOf('/');
    String str2 = str1;
    if (i != -1)
      str2 = str1.substring(i + 1); 
    return str2;
  }
  
  public StorageReference getParent() {
    String str = this.mStorageUri.getPath();
    if (!TextUtils.isEmpty(str)) {
      String str1 = "/";
      if (!str.equals("/")) {
        int i = str.lastIndexOf('/');
        if (i != -1)
          str1 = str.substring(0, i); 
        return new StorageReference(this.mStorageUri.buildUpon().path(str1).build(), this.mFirebaseStorage);
      } 
    } 
    return null;
  }
  
  public String getPath() {
    return this.mStorageUri.getPath();
  }
  
  public StorageReference getRoot() {
    return new StorageReference(this.mStorageUri.buildUpon().path("").build(), this.mFirebaseStorage);
  }
  
  public FirebaseStorage getStorage() {
    return this.mFirebaseStorage;
  }
  
  Uri getStorageUri() {
    return this.mStorageUri;
  }
  
  public StreamDownloadTask getStream() {
    StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
    streamDownloadTask.queue();
    return streamDownloadTask;
  }
  
  public StreamDownloadTask getStream(StreamDownloadTask.StreamProcessor paramStreamProcessor) {
    StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
    streamDownloadTask.setStreamProcessor(paramStreamProcessor);
    streamDownloadTask.queue();
    return streamDownloadTask;
  }
  
  public int hashCode() {
    return toString().hashCode();
  }
  
  public Task<ListResult> list(int paramInt) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maxResults must be greater than zero");
    if (paramInt <= 1000) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maxResults must be at most 1000");
    return listHelper(Integer.valueOf(paramInt), null);
  }
  
  public Task<ListResult> list(int paramInt, String paramString) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maxResults must be greater than zero");
    if (paramInt <= 1000) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maxResults must be at most 1000");
    if (paramString != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "pageToken must be non-null to resume a previous list() operation");
    return listHelper(Integer.valueOf(paramInt), paramString);
  }
  
  public Task<ListResult> listAll() {
    final TaskCompletionSource pendingResult = new TaskCompletionSource();
    final ArrayList prefixes = new ArrayList();
    final ArrayList items = new ArrayList();
    final Executor executor = StorageTaskScheduler.getInstance().getCommandPoolExecutor();
    listHelper(null, null).continueWithTask(executor, new Continuation<ListResult, Task<Void>>() {
          public Task<Void> then(Task<ListResult> param1Task) {
            ListResult listResult;
            if (param1Task.isSuccessful()) {
              listResult = (ListResult)param1Task.getResult();
              prefixes.addAll(listResult.getPrefixes());
              items.addAll(listResult.getItems());
              if (listResult.getPageToken() != null) {
                StorageReference.this.listHelper(null, listResult.getPageToken()).continueWithTask(executor, this);
              } else {
                pendingResult.setResult(new ListResult(prefixes, items, null));
              } 
            } else {
              pendingResult.setException(listResult.getException());
            } 
            return Tasks.forResult(null);
          }
        });
    return taskCompletionSource.getTask();
  }
  
  public UploadTask putBytes(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "bytes cannot be null");
    UploadTask uploadTask = new UploadTask(this, null, paramArrayOfbyte);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putBytes(byte[] paramArrayOfbyte, StorageMetadata paramStorageMetadata) {
    boolean bool2;
    boolean bool1 = true;
    if (paramArrayOfbyte != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "bytes cannot be null");
    if (paramStorageMetadata != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "metadata cannot be null");
    UploadTask uploadTask = new UploadTask(this, paramStorageMetadata, paramArrayOfbyte);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putFile(Uri paramUri) {
    boolean bool;
    if (paramUri != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "uri cannot be null");
    UploadTask uploadTask = new UploadTask(this, null, paramUri, null);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putFile(Uri paramUri, StorageMetadata paramStorageMetadata) {
    boolean bool2;
    boolean bool1 = true;
    if (paramUri != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "uri cannot be null");
    if (paramStorageMetadata != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "metadata cannot be null");
    UploadTask uploadTask = new UploadTask(this, paramStorageMetadata, paramUri, null);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putFile(Uri paramUri1, StorageMetadata paramStorageMetadata, Uri paramUri2) {
    boolean bool2;
    boolean bool1 = true;
    if (paramUri1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "uri cannot be null");
    if (paramStorageMetadata != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "metadata cannot be null");
    UploadTask uploadTask = new UploadTask(this, paramStorageMetadata, paramUri1, paramUri2);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putStream(InputStream paramInputStream) {
    boolean bool;
    if (paramInputStream != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "stream cannot be null");
    UploadTask uploadTask = new UploadTask(this, null, paramInputStream);
    uploadTask.queue();
    return uploadTask;
  }
  
  public UploadTask putStream(InputStream paramInputStream, StorageMetadata paramStorageMetadata) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInputStream != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "stream cannot be null");
    if (paramStorageMetadata != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "metadata cannot be null");
    UploadTask uploadTask = new UploadTask(this, paramStorageMetadata, paramInputStream);
    uploadTask.queue();
    return uploadTask;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("gs://");
    stringBuilder.append(this.mStorageUri.getAuthority());
    stringBuilder.append(this.mStorageUri.getEncodedPath());
    return stringBuilder.toString();
  }
  
  public Task<StorageMetadata> updateMetadata(StorageMetadata paramStorageMetadata) {
    Preconditions.checkNotNull(paramStorageMetadata);
    TaskCompletionSource<StorageMetadata> taskCompletionSource = new TaskCompletionSource();
    StorageTaskScheduler.getInstance().scheduleCommand(new UpdateMetadataTask(this, taskCompletionSource, paramStorageMetadata));
    return taskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */