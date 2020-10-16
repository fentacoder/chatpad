package com.squareup.okhttp;

import java.io.IOException;

public interface Interceptor {
  Response intercept(Chain paramChain) throws IOException;
  
  public static interface Chain {
    Connection connection();
    
    Response proceed(Request param1Request) throws IOException;
    
    Request request();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\Interceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */