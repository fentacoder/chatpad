package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

public interface CacheRequest {
  void abort();
  
  Sink body() throws IOException;
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\CacheRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */