package com.google.firebase.storage.network.connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionFactoryImpl implements HttpURLConnectionFactory {
  public HttpURLConnection createInstance(URL paramURL) throws IOException {
    return (HttpURLConnection)paramURL.openConnection();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\connection\HttpURLConnectionFactoryImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */