package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.UpdateMetadataNetworkRequest;
import org.json.JSONException;

class UpdateMetadataTask implements Runnable {
  private static final String TAG = "UpdateMetadataTask";
  
  private final StorageMetadata mNewMetadata;
  
  private final TaskCompletionSource<StorageMetadata> mPendingResult;
  
  private StorageMetadata mResultMetadata = null;
  
  private ExponentialBackoffSender mSender;
  
  private final StorageReference mStorageRef;
  
  public UpdateMetadataTask(StorageReference paramStorageReference, TaskCompletionSource<StorageMetadata> paramTaskCompletionSource, StorageMetadata paramStorageMetadata) {
    this.mStorageRef = paramStorageReference;
    this.mPendingResult = paramTaskCompletionSource;
    this.mNewMetadata = paramStorageMetadata;
    FirebaseStorage firebaseStorage = this.mStorageRef.getStorage();
    this.mSender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxOperationRetryTimeMillis());
  }
  
  public void run() {
    UpdateMetadataNetworkRequest updateMetadataNetworkRequest = new UpdateMetadataNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mNewMetadata.createJSONObject());
    this.mSender.sendWithExponentialBackoff((NetworkRequest)updateMetadataNetworkRequest);
    if (updateMetadataNetworkRequest.isResultSuccess())
      try {
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        this(updateMetadataNetworkRequest.getResultBody(), this.mStorageRef);
        this.mResultMetadata = builder.build();
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to parse a valid JSON object from resulting metadata:");
        stringBuilder.append(updateMetadataNetworkRequest.getRawResult());
        Log.e("UpdateMetadataTask", stringBuilder.toString(), (Throwable)jSONException);
        this.mPendingResult.setException((Exception)StorageException.fromException((Throwable)jSONException));
        return;
      }  
    TaskCompletionSource<StorageMetadata> taskCompletionSource = this.mPendingResult;
    if (taskCompletionSource != null)
      updateMetadataNetworkRequest.completeTask(taskCompletionSource, this.mResultMetadata); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\UpdateMetadataTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */