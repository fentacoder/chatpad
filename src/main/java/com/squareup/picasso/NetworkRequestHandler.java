package com.squareup.picasso;

import android.net.NetworkInfo;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Source;

class NetworkRequestHandler extends RequestHandler {
  private static final String SCHEME_HTTP = "http";
  
  private static final String SCHEME_HTTPS = "https";
  
  private final Downloader downloader;
  
  private final Stats stats;
  
  NetworkRequestHandler(Downloader paramDownloader, Stats paramStats) {
    this.downloader = paramDownloader;
    this.stats = paramStats;
  }
  
  private static Request createRequest(Request paramRequest, int paramInt) {
    CacheControl cacheControl;
    if (paramInt != 0) {
      if (NetworkPolicy.isOfflineOnly(paramInt)) {
        cacheControl = CacheControl.FORCE_CACHE;
      } else {
        CacheControl.Builder builder1 = new CacheControl.Builder();
        if (!NetworkPolicy.shouldReadFromDiskCache(paramInt))
          builder1.noCache(); 
        if (!NetworkPolicy.shouldWriteToDiskCache(paramInt))
          builder1.noStore(); 
        cacheControl = builder1.build();
      } 
    } else {
      cacheControl = null;
    } 
    Request.Builder builder = (new Request.Builder()).url(paramRequest.uri.toString());
    if (cacheControl != null)
      builder.cacheControl(cacheControl); 
    return builder.build();
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    String str = paramRequest.uri.getScheme();
    return ("http".equals(str) || "https".equals(str));
  }
  
  int getRetryCount() {
    return 2;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    Picasso.LoadedFrom loadedFrom;
    Request request = createRequest(paramRequest, paramInt);
    Response response = this.downloader.load(request);
    ResponseBody responseBody = response.body();
    if (response.isSuccessful()) {
      if (response.cacheResponse() == null) {
        loadedFrom = Picasso.LoadedFrom.NETWORK;
      } else {
        loadedFrom = Picasso.LoadedFrom.DISK;
      } 
      if (loadedFrom != Picasso.LoadedFrom.DISK || responseBody.contentLength() != 0L) {
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && responseBody.contentLength() > 0L)
          this.stats.dispatchDownloadFinished(responseBody.contentLength()); 
        return new RequestHandler.Result((Source)responseBody.source(), loadedFrom);
      } 
      responseBody.close();
      throw new ContentLengthException("Received response with 0 content-length header.");
    } 
    responseBody.close();
    throw new ResponseException(response.code(), loadedFrom.networkPolicy);
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo) {
    return (paramNetworkInfo == null || paramNetworkInfo.isConnected());
  }
  
  boolean supportsReplay() {
    return true;
  }
  
  static class ContentLengthException extends IOException {
    ContentLengthException(String param1String) {
      super(param1String);
    }
  }
  
  static final class ResponseException extends IOException {
    final int code;
    
    final int networkPolicy;
    
    ResponseException(int param1Int1, int param1Int2) {
      super(stringBuilder.toString());
      this.code = param1Int1;
      this.networkPolicy = param1Int2;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\NetworkRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */