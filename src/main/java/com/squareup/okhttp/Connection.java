package com.squareup.okhttp;

import java.net.Socket;

public interface Connection {
  Handshake getHandshake();
  
  Protocol getProtocol();
  
  Route getRoute();
  
  Socket getSocket();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\Connection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */