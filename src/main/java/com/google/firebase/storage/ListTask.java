package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.ListNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import org.json.JSONException;

class ListTask implements Runnable {
  private static final String TAG = "ListTask";
  
  private final Integer maxResults;
  
  private final String pageToken;
  
  private final TaskCompletionSource<ListResult> pendingResult;
  
  private final ExponentialBackoffSender sender;
  
  private final StorageReference storageRef;
  
  ListTask(StorageReference paramStorageReference, Integer paramInteger, String paramString, TaskCompletionSource<ListResult> paramTaskCompletionSource) {
    Preconditions.checkNotNull(paramStorageReference);
    Preconditions.checkNotNull(paramTaskCompletionSource);
    this.storageRef = paramStorageReference;
    this.maxResults = paramInteger;
    this.pageToken = paramString;
    this.pendingResult = paramTaskCompletionSource;
    FirebaseStorage firebaseStorage = this.storageRef.getStorage();
    this.sender = new ExponentialBackoffSender(firebaseStorage.getApp().getApplicationContext(), firebaseStorage.getAuthProvider(), firebaseStorage.getMaxDownloadRetryTimeMillis());
  }
  
  public void run() {
    Object object;
    ListNetworkRequest listNetworkRequest = new ListNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp(), this.maxResults, this.pageToken);
    this.sender.sendWithExponentialBackoff((NetworkRequest)listNetworkRequest);
    if (listNetworkRequest.isResultSuccess()) {
      try {
        object = ListResult.fromJSON(this.storageRef.getStorage(), listNetworkRequest.getResultBody());
      } catch (JSONException jSONException) {
        object = new StringBuilder();
        object.append("Unable to parse response body. ");
        object.append(listNetworkRequest.getRawResult());
        Log.e("ListTask", object.toString(), (Throwable)jSONException);
        this.pendingResult.setException((Exception)StorageException.fromException((Throwable)jSONException));
        return;
      } 
    } else {
      object = null;
    } 
    TaskCompletionSource<ListResult> taskCompletionSource = this.pendingResult;
    if (taskCompletionSource != null)
      listNetworkRequest.completeTask(taskCompletionSource, object); 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\ListTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */