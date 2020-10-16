package com.google.firebase.storage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.DeleteNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;

class DeleteStorageTask implements Runnable {
  private static final String TAG = "DeleteStorageTask";
  
  private TaskCompletionSource<Void> mPendingResult;
  
  private ExponentialBackoffSender mSender;
  
  private StorageReference mStorageRef;
  
  public DeleteStorageTask(StorageReference paramStorageReference, TaskCompletionSource<Void> paramTaskCompletionSource) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramTaskCompletionSource);
    this.mStorageRef = paramStorageReference;
    this.mPendingResult = paramTaskCompletionSource;
    FirebaseStorage firebaseStorage = this.mStorageRef.getStorage();
    this.mSender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
  }
  
  public void run() {
    DeleteNetworkRequest deleteNetworkRequest = new DeleteNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp());
    this.mSender.sendWithExponentialBackoff((NetworkRequest)deleteNetworkRequest);
    deleteNetworkRequest.completeTask(this.mPendingResult, null);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\DeleteStorageTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */