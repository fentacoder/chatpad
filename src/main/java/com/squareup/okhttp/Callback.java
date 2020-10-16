package com.squareup.okhttp;

import java.io.IOException;

public interface Callback {
  void onFailure(Request paramRequest, IOException paramIOException);
  
  void onResponse(Response paramResponse) throws IOException;
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\Callback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */