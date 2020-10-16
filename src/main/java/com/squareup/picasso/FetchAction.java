package com.squareup.picasso;

import android.graphics.Bitmap;

class FetchAction extends Action<Object> {
  private Callback callback;
  
  private final Object target = new Object();
  
  FetchAction(Picasso paramPicasso, Request paramRequest, int paramInt1, int paramInt2, Object paramObject, String paramString, Callback paramCallback) {
    super(paramPicasso, null, paramRequest, paramInt1, paramInt2, 0, null, paramString, paramObject, false);
    this.callback = paramCallback;
  }
  
  void cancel() {
    super.cancel();
    this.callback = null;
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {
    Callback callback = this.callback;
    if (callback != null)
      callback.onSuccess(); 
  }
  
  void error(Exception paramException) {
    Callback callback = this.callback;
    if (callback != null)
      callback.onError(paramException); 
  }
  
  Object getTarget() {
    return this.target;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\FetchAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */