package com.google.firebase.storage.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.util.Random;

public class ExponentialBackoffSender {
  private static final int MAXIMUM_WAIT_TIME_MILLI = 30000;
  
  private static final int NETWORK_STATUS_POLL_INTERVAL = 1000;
  
  public static final int RND_MAX = 250;
  
  private static final String TAG = "ExponenentialBackoff";
  
  static Clock clock;
  
  private static final Random random = new Random();
  
  static Sleeper sleeper = new SleeperImpl();
  
  private final InternalAuthProvider authProvider;
  
  private volatile boolean canceled;
  
  private final Context context;
  
  private long retryTime;
  
  static {
    clock = DefaultClock.getInstance();
  }
  
  public ExponentialBackoffSender(Context paramContext, InternalAuthProvider paramInternalAuthProvider, long paramLong) {
    this.context = paramContext;
    this.authProvider = paramInternalAuthProvider;
    this.retryTime = paramLong;
  }
  
  public void cancel() {
    this.canceled = true;
  }
  
  public boolean isRetryableError(int paramInt) {
    return ((paramInt >= 500 && paramInt < 600) || paramInt == -2 || paramInt == 429 || paramInt == 408);
  }
  
  public void reset() {
    this.canceled = false;
  }
  
  public void sendWithExponentialBackoff(NetworkRequest paramNetworkRequest) {
    sendWithExponentialBackoff(paramNetworkRequest, true);
  }
  
  public void sendWithExponentialBackoff(NetworkRequest paramNetworkRequest, boolean paramBoolean) {
    Preconditions.checkNotNull(paramNetworkRequest);
    long l1 = clock.elapsedRealtime();
    long l2 = this.retryTime;
    if (paramBoolean) {
      paramNetworkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), this.context);
    } else {
      paramNetworkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider));
    } 
    int i = 1000;
    while (clock.elapsedRealtime() + i <= l1 + l2 && !paramNetworkRequest.isResultSuccess() && isRetryableError(paramNetworkRequest.getResultCode())) {
      try {
        sleeper.sleep(random.nextInt(250) + i);
        int j = i;
        if (i < 30000)
          if (paramNetworkRequest.getResultCode() != -2) {
            j = i * 2;
            Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
          } else {
            Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
            j = 1000;
          }  
        if (this.canceled)
          return; 
        paramNetworkRequest.reset();
        if (paramBoolean) {
          paramNetworkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), this.context);
          i = j;
          continue;
        } 
        paramNetworkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider));
        i = j;
      } catch (InterruptedException interruptedException) {
        Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
        Thread.currentThread().interrupt();
        break;
      } 
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\ExponentialBackoffSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */