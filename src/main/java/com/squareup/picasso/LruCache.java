package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;

public final class LruCache implements Cache {
  final android.util.LruCache<String, BitmapAndSize> cache;
  
  public LruCache(int paramInt) {
    this.cache = new android.util.LruCache<String, BitmapAndSize>(paramInt) {
        protected int sizeOf(String param1String, LruCache.BitmapAndSize param1BitmapAndSize) {
          return param1BitmapAndSize.byteCount;
        }
      };
  }
  
  public LruCache(Context paramContext) {
    this(Utils.calculateMemoryCacheSize(paramContext));
  }
  
  public void clear() {
    this.cache.evictAll();
  }
  
  public void clearKeyUri(String paramString) {
    for (String str : this.cache.snapshot().keySet()) {
      if (str.startsWith(paramString) && str.length() > paramString.length() && str.charAt(paramString.length()) == '\n')
        this.cache.remove(str); 
    } 
  }
  
  public int evictionCount() {
    return this.cache.evictionCount();
  }
  
  public Bitmap get(String paramString) {
    BitmapAndSize bitmapAndSize = (BitmapAndSize)this.cache.get(paramString);
    if (bitmapAndSize != null) {
      Bitmap bitmap = bitmapAndSize.bitmap;
    } else {
      bitmapAndSize = null;
    } 
    return (Bitmap)bitmapAndSize;
  }
  
  public int hitCount() {
    return this.cache.hitCount();
  }
  
  public int maxSize() {
    return this.cache.maxSize();
  }
  
  public int missCount() {
    return this.cache.missCount();
  }
  
  public int putCount() {
    return this.cache.putCount();
  }
  
  public void set(String paramString, Bitmap paramBitmap) {
    if (paramString != null && paramBitmap != null) {
      int i = Utils.getBitmapBytes(paramBitmap);
      if (i > maxSize()) {
        this.cache.remove(paramString);
        return;
      } 
      this.cache.put(paramString, new BitmapAndSize(paramBitmap, i));
      return;
    } 
    throw new NullPointerException("key == null || bitmap == null");
  }
  
  public int size() {
    return this.cache.size();
  }
  
  static final class BitmapAndSize {
    final Bitmap bitmap;
    
    final int byteCount;
    
    BitmapAndSize(Bitmap param1Bitmap, int param1Int) {
      this.bitmap = param1Bitmap;
      this.byteCount = param1Int;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\LruCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */