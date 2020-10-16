package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import org.json.JSONException;

class GetMetadataTask implements Runnable {
  private static final String TAG = "GetMetadataTask";
  
  private TaskCompletionSource<StorageMetadata> mPendingResult;
  
  private StorageMetadata mResultMetadata;
  
  private ExponentialBackoffSender mSender;
  
  private StorageReference mStorageRef;
  
  GetMetadataTask(StorageReference paramStorageReference, TaskCompletionSource<StorageMetadata> paramTaskCompletionSource) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramTaskCompletionSource);
    this.mStorageRef = paramStorageReference;
    this.mPendingResult = paramTaskCompletionSource;
    if (!paramStorageReference.getRoot().getName().equals(paramStorageReference.getName())) {
      FirebaseStorage firebaseStorage = this.mStorageRef.getStorage();
      this.mSender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
      return;
    } 
    throw new IllegalArgumentException("getMetadata() is not supported at the root of the bucket.");
  }
  
  public void run() {
    GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp());
    this.mSender.sendWithExponentialBackoff((NetworkRequest)getMetadataNetworkRequest);
    if (getMetadataNetworkRequest.isResultSuccess())
      try {
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        this(getMetadataNetworkRequest.getResultBody(), this.mStorageRef);
        this.mResultMetadata = builder.build();
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to parse resulting metadata. ");
        stringBuilder.append(getMetadataNetworkRequest.getRawResult());
        Log.e("GetMetadataTask", stringBuilder.toString(), (Throwable)jSONException);
        this.mPendingResult.setException((Exception)StorageException.fromException((Throwable)jSONException));
        return;
      }  
    TaskCompletionSource<StorageMetadata> taskCompletionSource = this.mPendingResult;
    if (taskCompletionSource != null)
      getMetadataNetworkRequest.completeTask(taskCompletionSource, this.mResultMetadata); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\GetMetadataTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */