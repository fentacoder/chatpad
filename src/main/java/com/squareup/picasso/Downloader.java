package com.squareup.picasso;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public interface Downloader {
  Response load(Request paramRequest) throws IOException;
  
  void shutdown();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\Downloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */