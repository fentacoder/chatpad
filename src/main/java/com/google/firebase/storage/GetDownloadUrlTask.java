package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import org.json.JSONObject;

class GetDownloadUrlTask implements Runnable {
  private static final String DOWNLOAD_TOKENS_KEY = "downloadTokens";
  
  private static final String TAG = "GetMetadataTask";
  
  private TaskCompletionSource<Uri> pendingResult;
  
  private ExponentialBackoffSender sender;
  
  private StorageReference storageRef;
  
  GetDownloadUrlTask(StorageReference paramStorageReference, TaskCompletionSource<Uri> paramTaskCompletionSource) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramTaskCompletionSource);
    this.storageRef = paramStorageReference;
    this.pendingResult = paramTaskCompletionSource;
    if (!paramStorageReference.getRoot().getName().equals(paramStorageReference.getName())) {
      FirebaseStorage firebaseStorage = this.storageRef.getStorage();
      this.sender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxOperationRetryTimeMillis());
      return;
    } 
    throw new IllegalArgumentException("getDownloadUrl() is not supported at the root of the bucket.");
  }
  
  private Uri extractDownloadUrl(JSONObject paramJSONObject) {
    String str = paramJSONObject.optString("downloadTokens");
    if (!TextUtils.isEmpty(str)) {
      str = str.split(",", -1)[0];
      Uri.Builder builder = NetworkRequest.getDefaultURL(this.storageRef.getStorageUri()).buildUpon();
      builder.appendQueryParameter("alt", "media");
      builder.appendQueryParameter("token", str);
      return builder.build();
    } 
    return null;
  }
  
  public void run() {
    Object object;
    GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp());
    this.sender.sendWithExponentialBackoff((NetworkRequest)getMetadataNetworkRequest);
    if (getMetadataNetworkRequest.isResultSuccess()) {
      object = extractDownloadUrl(getMetadataNetworkRequest.getResultBody());
    } else {
      object = null;
    } 
    TaskCompletionSource<Uri> taskCompletionSource = this.pendingResult;
    if (taskCompletionSource != null)
      getMetadataNetworkRequest.completeTask(taskCompletionSource, object); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\GetDownloadUrlTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */