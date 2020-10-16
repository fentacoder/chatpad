package com.google.firebase.storage.internal;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

public class AdaptiveStreamBuffer {
  private static final String TAG = "AdaptiveStreamBuffer";
  
  private static final Runtime runtime = Runtime.getRuntime();
  
  private boolean adaptiveMode;
  
  private int availableBytes;
  
  private byte[] buffer;
  
  private boolean reachedEnd;
  
  private final InputStream source;
  
  public AdaptiveStreamBuffer(InputStream paramInputStream, int paramInt) {
    this.source = paramInputStream;
    this.buffer = new byte[paramInt];
    this.availableBytes = 0;
    this.adaptiveMode = true;
    this.reachedEnd = false;
  }
  
  private int resize(int paramInt) {
    paramInt = Math.max(this.buffer.length * 2, paramInt);
    long l1 = runtime.totalMemory();
    long l2 = runtime.freeMemory();
    long l3 = runtime.maxMemory();
    if (this.adaptiveMode && paramInt < l3 - l1 - l2) {
      try {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.availableBytes);
        this.buffer = arrayOfByte;
      } catch (OutOfMemoryError outOfMemoryError) {
        Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
        this.adaptiveMode = false;
      } 
    } else {
      Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
    } 
    return this.buffer.length;
  }
  
  public int advance(int paramInt) throws IOException {
    int i = this.availableBytes;
    if (paramInt <= i) {
      this.availableBytes = i - paramInt;
      byte[] arrayOfByte = this.buffer;
      System.arraycopy(arrayOfByte, paramInt, arrayOfByte, 0, this.availableBytes);
    } else {
      this.availableBytes = 0;
      i = this.availableBytes;
      while (i < paramInt) {
        int j = (int)this.source.skip((paramInt - i));
        if (j > 0) {
          i += j;
          continue;
        } 
        if (j == 0) {
          if (this.source.read() == -1)
            break; 
          i++;
        } 
      } 
      paramInt = i;
    } 
    return paramInt;
  }
  
  public int available() {
    return this.availableBytes;
  }
  
  public void close() throws IOException {
    this.source.close();
  }
  
  public int fill(int paramInt) throws IOException {
    int i = paramInt;
    if (paramInt > this.buffer.length)
      i = Math.min(paramInt, resize(paramInt)); 
    while (true) {
      paramInt = this.availableBytes;
      if (paramInt < i) {
        paramInt = this.source.read(this.buffer, paramInt, i - paramInt);
        if (paramInt == -1) {
          this.reachedEnd = true;
          break;
        } 
        this.availableBytes += paramInt;
        continue;
      } 
      break;
    } 
    return this.availableBytes;
  }
  
  public byte[] get() {
    return this.buffer;
  }
  
  public boolean isFinished() {
    return this.reachedEnd;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\AdaptiveStreamBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */