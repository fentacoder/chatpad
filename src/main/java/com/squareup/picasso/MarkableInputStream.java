package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream {
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  
  private static final int DEFAULT_LIMIT_INCREMENT = 1024;
  
  private boolean allowExpire = true;
  
  private long defaultMark = -1L;
  
  private final InputStream in;
  
  private long limit;
  
  private int limitIncrement = -1;
  
  private long offset;
  
  private long reset;
  
  MarkableInputStream(InputStream paramInputStream) {
    this(paramInputStream, 4096);
  }
  
  MarkableInputStream(InputStream paramInputStream, int paramInt) {
    this(paramInputStream, paramInt, 1024);
  }
  
  private MarkableInputStream(InputStream paramInputStream, int paramInt1, int paramInt2) {
    InputStream inputStream = paramInputStream;
    if (!paramInputStream.markSupported())
      inputStream = new BufferedInputStream(paramInputStream, paramInt1); 
    this.in = inputStream;
    this.limitIncrement = paramInt2;
  }
  
  private void setLimit(long paramLong) {
    try {
      if (this.reset < this.offset && this.offset <= this.limit) {
        this.in.reset();
        this.in.mark((int)(paramLong - this.reset));
        skip(this.reset, this.offset);
      } else {
        this.reset = this.offset;
        this.in.mark((int)(paramLong - this.offset));
      } 
      this.limit = paramLong;
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to mark: ");
      stringBuilder.append(iOException);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private void skip(long paramLong1, long paramLong2) throws IOException {
    while (paramLong1 < paramLong2) {
      long l1 = this.in.skip(paramLong2 - paramLong1);
      long l2 = l1;
      if (l1 == 0L) {
        if (read() == -1)
          break; 
        l2 = 1L;
      } 
      paramLong1 += l2;
    } 
  }
  
  public void allowMarksToExpire(boolean paramBoolean) {
    this.allowExpire = paramBoolean;
  }
  
  public int available() throws IOException {
    return this.in.available();
  }
  
  public void close() throws IOException {
    this.in.close();
  }
  
  public void mark(int paramInt) {
    this.defaultMark = savePosition(paramInt);
  }
  
  public boolean markSupported() {
    return this.in.markSupported();
  }
  
  public int read() throws IOException {
    if (!this.allowExpire) {
      long l1 = this.offset;
      long l2 = this.limit;
      if (l1 + 1L > l2)
        setLimit(l2 + this.limitIncrement); 
    } 
    int i = this.in.read();
    if (i != -1)
      this.offset++; 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    if (!this.allowExpire) {
      long l = this.offset;
      if (paramArrayOfbyte.length + l > this.limit)
        setLimit(l + paramArrayOfbyte.length + this.limitIncrement); 
    } 
    int i = this.in.read(paramArrayOfbyte);
    if (i != -1)
      this.offset += i; 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (!this.allowExpire) {
      long l1 = this.offset;
      long l2 = paramInt2;
      if (l1 + l2 > this.limit)
        setLimit(l1 + l2 + this.limitIncrement); 
    } 
    paramInt1 = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt1 != -1)
      this.offset += paramInt1; 
    return paramInt1;
  }
  
  public void reset() throws IOException {
    reset(this.defaultMark);
  }
  
  public void reset(long paramLong) throws IOException {
    if (this.offset <= this.limit && paramLong >= this.reset) {
      this.in.reset();
      skip(this.reset, paramLong);
      this.offset = paramLong;
      return;
    } 
    throw new IOException("Cannot reset");
  }
  
  public long savePosition(int paramInt) {
    long l = this.offset + paramInt;
    if (this.limit < l)
      setLimit(l); 
    return this.offset;
  }
  
  public long skip(long paramLong) throws IOException {
    if (!this.allowExpire) {
      long l = this.offset;
      if (l + paramLong > this.limit)
        setLimit(l + paramLong + this.limitIncrement); 
    } 
    paramLong = this.in.skip(paramLong);
    this.offset += paramLong;
    return paramLong;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\MarkableInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */