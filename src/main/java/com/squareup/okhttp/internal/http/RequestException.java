package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException extends Exception {
  public RequestException(IOException paramIOException) {
    super(paramIOException);
  }
  
  public IOException getCause() {
    return (IOException)super.getCause();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\RequestException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */