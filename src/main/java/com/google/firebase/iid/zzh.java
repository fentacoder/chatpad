package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzh {
  private static final Executor zzaf = zzj.zzam;
  
  static Executor zzd() {
    return zzaf;
  }
  
  static Executor zze() {
    return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), zzk.zzan);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */