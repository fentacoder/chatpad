package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloadTask extends StorageTask<FileDownloadTask.TaskSnapshot> {
  static final int PREFERRED_CHUNK_SIZE = 262144;
  
  private static final String TAG = "FileDownloadTask";
  
  private long mBytesDownloaded;
  
  private final Uri mDestinationFile;
  
  private String mETagVerification = null;
  
  private volatile Exception mException = null;
  
  private int mResultCode;
  
  private long mResumeOffset = 0L;
  
  private ExponentialBackoffSender mSender;
  
  private StorageReference mStorageRef;
  
  private long mTotalBytes = -1L;
  
  FileDownloadTask(StorageReference paramStorageReference, Uri paramUri) {
    this.mStorageRef = paramStorageReference;
    this.mDestinationFile = paramUri;
    FirebaseStorage firebaseStorage = this.mStorageRef.getStorage();
    this.mSender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
  }
  
  private int fillBuffer(InputStream paramInputStream, byte[] paramArrayOfbyte) {
    int i = 0;
    boolean bool = false;
    try {
      while (i != paramArrayOfbyte.length) {
        int j = paramInputStream.read(paramArrayOfbyte, i, paramArrayOfbyte.length - i);
        if (j != -1) {
          bool = true;
          i += j;
        } 
      } 
    } catch (IOException iOException) {
      this.mException = iOException;
    } 
    if (!bool)
      i = -1; 
    return i;
  }
  
  private boolean isValidHttpResponseCode(int paramInt) {
    return (paramInt == 308 || (paramInt >= 200 && paramInt < 300));
  }
  
  private boolean processResponse(NetworkRequest paramNetworkRequest) throws IOException {
    InputStream inputStream = paramNetworkRequest.getStream();
    boolean bool = false;
    if (inputStream != null) {
      FileOutputStream fileOutputStream;
      StringBuilder stringBuilder;
      File file = new File(this.mDestinationFile.getPath());
      if (!file.exists())
        if (this.mResumeOffset <= 0L) {
          if (!file.createNewFile()) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("unable to create file:");
            stringBuilder1.append(file.getAbsolutePath());
            Log.w("FileDownloadTask", stringBuilder1.toString());
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("The file downloading to has been deleted:");
          stringBuilder.append(file.getAbsolutePath());
          Log.e("FileDownloadTask", stringBuilder.toString());
          throw new IllegalStateException("expected a file to resume from.");
        }  
      long l = this.mResumeOffset;
      bool = true;
      if (l > 0L) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Resuming download file ");
        stringBuilder1.append(file.getAbsolutePath());
        stringBuilder1.append(" at ");
        stringBuilder1.append(this.mResumeOffset);
        Log.d("FileDownloadTask", stringBuilder1.toString());
        fileOutputStream = new FileOutputStream(file, true);
      } else {
        fileOutputStream = new FileOutputStream((File)fileOutputStream);
      } 
      try {
        byte[] arrayOfByte = new byte[262144];
        while (bool) {
          int i = fillBuffer((InputStream)stringBuilder, arrayOfByte);
          if (i != -1) {
            fileOutputStream.write(arrayOfByte, 0, i);
            this.mBytesDownloaded += i;
            if (this.mException != null) {
              Log.d("FileDownloadTask", "Exception occurred during file download. Retrying.", this.mException);
              this.mException = null;
              bool = false;
            } 
            boolean bool1 = tryChangeState(4, false);
            if (!bool1)
              bool = false; 
          } 
        } 
      } finally {
        fileOutputStream.flush();
        fileOutputStream.close();
        stringBuilder.close();
      } 
    } else {
      this.mException = new IllegalStateException("Unable to open Firebase Storage stream.");
    } 
    return bool;
  }
  
  long getDownloadedSizeInBytes() {
    return this.mBytesDownloaded;
  }
  
  StorageReference getStorage() {
    return this.mStorageRef;
  }
  
  long getTotalBytes() {
    return this.mTotalBytes;
  }
  
  protected void onCanceled() {
    this.mSender.cancel();
    this.mException = (Exception)StorageException.fromErrorStatus(Status.RESULT_CANCELED);
  }
  
  void run() {
    if (this.mException != null) {
      tryChangeState(64, false);
      return;
    } 
    if (!tryChangeState(4, false))
      return; 
    while (true) {
      Exception exception;
      this.mBytesDownloaded = 0L;
      this.mException = null;
      this.mSender.reset();
      GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mResumeOffset);
      this.mSender.sendWithExponentialBackoff((NetworkRequest)getNetworkRequest, false);
      this.mResultCode = getNetworkRequest.getResultCode();
      if (getNetworkRequest.getException() != null) {
        exception = getNetworkRequest.getException();
      } else {
        exception = this.mException;
      } 
      this.mException = exception;
      boolean bool1 = isValidHttpResponseCode(this.mResultCode);
      boolean bool = true;
      if (bool1 && this.mException == null && getInternalState() == 4) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      boolean bool2 = bool1;
      if (bool1) {
        this.mTotalBytes = getNetworkRequest.getResultingContentLength();
        String str = getNetworkRequest.getResultString("ETag");
        if (!TextUtils.isEmpty(str)) {
          String str1 = this.mETagVerification;
          if (str1 != null && !str1.equals(str)) {
            Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
            this.mResumeOffset = 0L;
            this.mETagVerification = null;
            getNetworkRequest.performRequestEnd();
            schedule();
            return;
          } 
        } 
        this.mETagVerification = str;
        try {
          bool2 = processResponse((NetworkRequest)getNetworkRequest);
        } catch (IOException iOException) {
          Log.e("FileDownloadTask", "Exception occurred during file write.  Aborting.", iOException);
          this.mException = iOException;
          bool2 = bool1;
        } 
      } 
      getNetworkRequest.performRequestEnd();
      if (!bool2 || this.mException != null || getInternalState() != 4)
        bool = false; 
      if (bool) {
        tryChangeState(128, false);
        return;
      } 
      File file = new File(this.mDestinationFile.getPath());
      if (file.exists()) {
        this.mResumeOffset = file.length();
      } else {
        this.mResumeOffset = 0L;
      } 
      if (getInternalState() == 8) {
        tryChangeState(16, false);
        return;
      } 
      if (getInternalState() == 32) {
        if (!tryChangeState(256, false)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unable to change download task to final state from ");
          stringBuilder.append(getInternalState());
          Log.w("FileDownloadTask", stringBuilder.toString());
        } 
        return;
      } 
      if (this.mBytesDownloaded <= 0L) {
        tryChangeState(64, false);
        return;
      } 
    } 
  }
  
  protected void schedule() {
    StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
  }
  
  TaskSnapshot snapStateImpl() {
    return new TaskSnapshot((Exception)StorageException.fromExceptionAndHttpCode(this.mException, this.mResultCode), this.mBytesDownloaded + this.mResumeOffset);
  }
  
  public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
    private final long mBytesDownloaded;
    
    TaskSnapshot(Exception param1Exception, long param1Long) {
      super(param1Exception);
      this.mBytesDownloaded = param1Long;
    }
    
    public long getBytesTransferred() {
      return this.mBytesDownloaded;
    }
    
    public long getTotalByteCount() {
      return FileDownloadTask.this.getTotalBytes();
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\FileDownloadTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */