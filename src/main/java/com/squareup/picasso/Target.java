package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface Target {
  void onBitmapFailed(Exception paramException, Drawable paramDrawable);
  
  void onBitmapLoaded(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom);
  
  void onPrepareLoad(Drawable paramDrawable);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\Target.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */