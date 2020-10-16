package com.squareup.picasso;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class OkHttp3Downloader implements Downloader {
  private final Cache cache;
  
  final Call.Factory client;
  
  private boolean sharedClient = true;
  
  public OkHttp3Downloader(Context paramContext) {
    this(Utils.createDefaultCacheDir(paramContext));
  }
  
  public OkHttp3Downloader(Context paramContext, long paramLong) {
    this(Utils.createDefaultCacheDir(paramContext), paramLong);
  }
  
  public OkHttp3Downloader(File paramFile) {
    this(paramFile, Utils.calculateDiskCacheSize(paramFile));
  }
  
  public OkHttp3Downloader(File paramFile, long paramLong) {
    this((new OkHttpClient.Builder()).cache(new Cache(paramFile, paramLong)).build());
    this.sharedClient = false;
  }
  
  public OkHttp3Downloader(Call.Factory paramFactory) {
    this.client = paramFactory;
    this.cache = null;
  }
  
  public OkHttp3Downloader(OkHttpClient paramOkHttpClient) {
    this.client = (Call.Factory)paramOkHttpClient;
    this.cache = paramOkHttpClient.cache();
  }
  
  public Response load(Request paramRequest) throws IOException {
    return this.client.newCall(paramRequest).execute();
  }
  
  public void shutdown() {
    if (!this.sharedClient) {
      Cache cache = this.cache;
      if (cache != null)
        try {
          cache.close();
        } catch (IOException iOException) {} 
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\OkHttp3Downloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */