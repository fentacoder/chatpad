package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

public interface Variant {
  Protocol getProtocol();
  
  FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\framed\Variant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */