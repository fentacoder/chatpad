package com.google.firebase.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class StreamDownloadTask extends StorageTask<StreamDownloadTask.TaskSnapshot> {
  static final long PREFERRED_CHUNK_SIZE = 262144L;
  
  private static final String TAG = "StreamDownloadTask";
  
  private long bytesDownloaded;
  
  private long bytesDownloadedSnapped;
  
  private String eTagVerification;
  
  private volatile Exception exception = null;
  
  private InputStream inputStream;
  
  private StreamProcessor processor;
  
  private NetworkRequest request;
  
  private volatile int resultCode = 0;
  
  private ExponentialBackoffSender sender;
  
  private StorageReference storageRef;
  
  private long totalBytes = -1L;
  
  StreamDownloadTask(StorageReference paramStorageReference) {
    this.storageRef = paramStorageReference;
    FirebaseStorage firebaseStorage = this.storageRef.getStorage();
    this.sender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
  }
  
  private InputStream createDownloadStream() throws Exception {
    Exception exception;
    this.sender.reset();
    NetworkRequest networkRequest = this.request;
    if (networkRequest != null)
      networkRequest.performRequestEnd(); 
    this.request = (NetworkRequest)new GetNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp(), this.bytesDownloaded);
    ExponentialBackoffSender exponentialBackoffSender = this.sender;
    networkRequest = this.request;
    boolean bool1 = false;
    exponentialBackoffSender.sendWithExponentialBackoff(networkRequest, false);
    this.resultCode = this.request.getResultCode();
    if (this.request.getException() != null) {
      exception = this.request.getException();
    } else {
      exception = this.exception;
    } 
    this.exception = exception;
    boolean bool2 = bool1;
    if (isValidHttpResponseCode(this.resultCode)) {
      bool2 = bool1;
      if (this.exception == null) {
        bool2 = bool1;
        if (getInternalState() == 4)
          bool2 = true; 
      } 
    } 
    if (bool2) {
      String str = this.request.getResultString("ETag");
      if (!TextUtils.isEmpty(str)) {
        String str1 = this.eTagVerification;
        if (str1 != null && !str1.equals(str)) {
          this.resultCode = 409;
          throw new IOException("The ETag on the server changed.");
        } 
      } 
      this.eTagVerification = str;
      if (this.totalBytes == -1L)
        this.totalBytes = this.request.getResultingContentLength(); 
      return this.request.getStream();
    } 
    throw new IOException("Could not open resulting stream.");
  }
  
  private boolean isValidHttpResponseCode(int paramInt) {
    return (paramInt == 308 || (paramInt >= 200 && paramInt < 300));
  }
  
  StorageReference getStorage() {
    return this.storageRef;
  }
  
  long getTotalBytes() {
    return this.totalBytes;
  }
  
  protected void onCanceled() {
    this.sender.cancel();
    this.exception = (Exception)StorageException.fromErrorStatus(Status.RESULT_CANCELED);
  }
  
  protected void onProgress() {
    this.bytesDownloadedSnapped = this.bytesDownloaded;
  }
  
  public boolean pause() {
    throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
  }
  
  void recordDownloadedBytes(long paramLong) {
    this.bytesDownloaded += paramLong;
    if (this.bytesDownloadedSnapped + 262144L <= this.bytesDownloaded)
      if (getInternalState() == 4) {
        tryChangeState(4, false);
      } else {
        this.bytesDownloadedSnapped = this.bytesDownloaded;
      }  
  }
  
  public boolean resume() {
    throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
  }
  
  void run() {
    char c2;
    Exception exception = this.exception;
    char c1 = '@';
    if (exception != null) {
      tryChangeState(64, false);
      return;
    } 
    if (!tryChangeState(4, false))
      return; 
    StreamProgressWrapper streamProgressWrapper = new StreamProgressWrapper(new Callable<InputStream>() {
          public InputStream call() throws Exception {
            return StreamDownloadTask.this.createDownloadStream();
          }
        },  this);
    this.inputStream = new BufferedInputStream(streamProgressWrapper);
    try {
      streamProgressWrapper.ensureStream();
      StreamProcessor streamProcessor = this.processor;
      if (streamProcessor != null)
        try {
          this.processor.doInBackground(snapState(), this.inputStream);
        } catch (Exception exception1) {
          Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", exception1);
          this.exception = exception1;
        }  
    } catch (IOException iOException) {
      Log.d("StreamDownloadTask", "Initial opening of Stream failed", iOException);
      this.exception = iOException;
    } 
    if (this.inputStream == null) {
      this.request.performRequestEnd();
      this.request = null;
    } 
    if (this.exception == null && getInternalState() == 4) {
      c2 = '\001';
    } else {
      c2 = Character.MIN_VALUE;
    } 
    if (c2) {
      tryChangeState(4, false);
      tryChangeState(128, false);
    } else {
      c2 = c1;
      if (getInternalState() == 32)
        c2 = 'Ā'; 
      if (!tryChangeState(c2, false)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to change download task to final state from ");
        stringBuilder.append(getInternalState());
        Log.w("StreamDownloadTask", stringBuilder.toString());
      } 
    } 
  }
  
  protected void schedule() {
    StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
  }
  
  StreamDownloadTask setStreamProcessor(StreamProcessor paramStreamProcessor) {
    boolean bool;
    Preconditions.checkNotNull(paramStreamProcessor);
    if (this.processor == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    this.processor = paramStreamProcessor;
    return this;
  }
  
  TaskSnapshot snapStateImpl() {
    return new TaskSnapshot((Exception)StorageException.fromExceptionAndHttpCode(this.exception, this.resultCode), this.bytesDownloadedSnapped);
  }
  
  public static interface StreamProcessor {
    void doInBackground(StreamDownloadTask.TaskSnapshot param1TaskSnapshot, InputStream param1InputStream) throws IOException;
  }
  
  static class StreamProgressWrapper extends InputStream {
    private long mDownloadedBytes;
    
    private Callable<InputStream> mInputStreamCallable;
    
    private long mLastExceptionPosition;
    
    private StreamDownloadTask mParentTask;
    
    private boolean mStreamClosed;
    
    private IOException mTemporaryException;
    
    private InputStream mWrappedStream;
    
    StreamProgressWrapper(Callable<InputStream> param1Callable, StreamDownloadTask param1StreamDownloadTask) {
      this.mParentTask = param1StreamDownloadTask;
      this.mInputStreamCallable = param1Callable;
    }
    
    private void checkCancel() throws IOException {
      StreamDownloadTask streamDownloadTask = this.mParentTask;
      if (streamDownloadTask == null || streamDownloadTask.getInternalState() != 32)
        return; 
      throw new CancelException();
    }
    
    private boolean ensureStream() throws IOException {
      checkCancel();
      if (this.mTemporaryException != null) {
        try {
          if (this.mWrappedStream != null)
            this.mWrappedStream.close(); 
        } catch (IOException iOException) {}
        this.mWrappedStream = null;
        if (this.mLastExceptionPosition == this.mDownloadedBytes) {
          Log.i("StreamDownloadTask", "Encountered exception during stream operation. Aborting.", this.mTemporaryException);
          return false;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Encountered exception during stream operation. Retrying at ");
        stringBuilder.append(this.mDownloadedBytes);
        Log.i("StreamDownloadTask", stringBuilder.toString(), this.mTemporaryException);
        this.mLastExceptionPosition = this.mDownloadedBytes;
        this.mTemporaryException = null;
      } 
      if (!this.mStreamClosed) {
        if (this.mWrappedStream == null)
          try {
            this.mWrappedStream = this.mInputStreamCallable.call();
          } catch (Exception exception) {
            if (exception instanceof IOException)
              throw (IOException)exception; 
            throw new IOException("Unable to open stream", exception);
          }  
        return true;
      } 
      throw new IOException("Can't perform operation on closed stream");
    }
    
    private void recordDownloadedBytes(long param1Long) {
      StreamDownloadTask streamDownloadTask = this.mParentTask;
      if (streamDownloadTask != null)
        streamDownloadTask.recordDownloadedBytes(param1Long); 
      this.mDownloadedBytes += param1Long;
    }
    
    public int available() throws IOException {
      while (ensureStream()) {
        try {
          return this.mWrappedStream.available();
        } catch (IOException iOException) {
          this.mTemporaryException = iOException;
        } 
      } 
      throw this.mTemporaryException;
    }
    
    public void close() throws IOException {
      InputStream inputStream = this.mWrappedStream;
      if (inputStream != null)
        inputStream.close(); 
      this.mStreamClosed = true;
      StreamDownloadTask streamDownloadTask = this.mParentTask;
      if (streamDownloadTask != null && streamDownloadTask.request != null) {
        this.mParentTask.request.performRequestEnd();
        StreamDownloadTask.access$202(this.mParentTask, (NetworkRequest)null);
      } 
      checkCancel();
    }
    
    public void mark(int param1Int) {}
    
    public boolean markSupported() {
      return false;
    }
    
    public int read() throws IOException {
      while (ensureStream()) {
        try {
          int i = this.mWrappedStream.read();
          if (i != -1)
            recordDownloadedBytes(1L); 
          return i;
        } catch (IOException iOException) {
          this.mTemporaryException = iOException;
        } 
      } 
      throw this.mTemporaryException;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      int i = 0;
      int j = param1Int1;
      param1Int1 = i;
      while (ensureStream()) {
        int k = j;
        while (param1Int2 > 262144L) {
          int n = param1Int1;
          j = k;
          i = param1Int2;
          try {
            int i1 = this.mWrappedStream.read(param1ArrayOfbyte, k, 262144);
            if (i1 == -1) {
              param1Int2 = param1Int1;
              if (param1Int1 == 0)
                param1Int2 = -1; 
              return param1Int2;
            } 
            param1Int1 += i1;
            k += i1;
            param1Int2 -= i1;
            n = param1Int1;
            j = k;
            i = param1Int2;
            recordDownloadedBytes(i1);
            n = param1Int1;
            j = k;
            i = param1Int2;
            checkCancel();
          } catch (IOException iOException) {
            this.mTemporaryException = iOException;
            param1Int1 = n;
            param1Int2 = i;
          } 
        } 
        i = param1Int1;
        j = k;
        int m = param1Int2;
        if (param1Int2 > 0) {
          m = param1Int1;
          j = k;
          i = param1Int2;
          int i1 = this.mWrappedStream.read(param1ArrayOfbyte, k, param1Int2);
          if (i1 == -1) {
            param1Int2 = param1Int1;
            if (param1Int1 == 0)
              param1Int2 = -1; 
            return param1Int2;
          } 
          k += i1;
          int n = param1Int1 + i1;
          param1Int1 = param1Int2 - i1;
          m = n;
          j = k;
          i = param1Int1;
          recordDownloadedBytes(i1);
          i = n;
          j = k;
          m = param1Int1;
        } 
        param1Int1 = i;
        param1Int2 = m;
        if (m == 0)
          return i; 
      } 
      throw this.mTemporaryException;
    }
    
    public long skip(long param1Long) throws IOException {
      long l = param1Long;
      param1Long = 0L;
      while (ensureStream()) {
        long l1 = l;
        while (l1 > 262144L) {
          l = l1;
          long l4 = param1Long;
          try {
            long l5 = this.mWrappedStream.skip(262144L);
            if (l5 < 0L) {
              l4 = param1Long;
              if (param1Long == 0L)
                l4 = -1L; 
              return l4;
            } 
            param1Long += l5;
            l1 -= l5;
            l = l1;
            l4 = param1Long;
            recordDownloadedBytes(l5);
            l = l1;
            l4 = param1Long;
            checkCancel();
          } catch (IOException iOException) {
            this.mTemporaryException = iOException;
            param1Long = l4;
          } 
        } 
        long l2 = l1;
        long l3 = param1Long;
        if (l1 > 0L) {
          l = l1;
          l2 = param1Long;
          long l4 = this.mWrappedStream.skip(l1);
          if (l4 < 0L) {
            l2 = param1Long;
            if (param1Long == 0L)
              l2 = -1L; 
            return l2;
          } 
          l3 = param1Long + l4;
          param1Long = l1 - l4;
          l = param1Long;
          l2 = l3;
          recordDownloadedBytes(l4);
          l2 = param1Long;
        } 
        l = l2;
        param1Long = l3;
        if (l2 == 0L)
          return l3; 
      } 
      throw this.mTemporaryException;
    }
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
    
    public InputStream getStream() {
      return StreamDownloadTask.this.inputStream;
    }
    
    public long getTotalByteCount() {
      return StreamDownloadTask.this.getTotalBytes();
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StreamDownloadTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */