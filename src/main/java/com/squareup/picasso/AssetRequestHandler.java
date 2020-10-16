package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.IOException;
import okio.Okio;

class AssetRequestHandler extends RequestHandler {
  protected static final String ANDROID_ASSET = "android_asset";
  
  private static final int ASSET_PREFIX_LENGTH = 22;
  
  private AssetManager assetManager;
  
  private final Context context;
  
  private final Object lock = new Object();
  
  AssetRequestHandler(Context paramContext) {
    this.context = paramContext;
  }
  
  static String getFilePath(Request paramRequest) {
    return paramRequest.uri.toString().substring(ASSET_PREFIX_LENGTH);
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    Uri uri = paramRequest.uri;
    boolean bool = "file".equals(uri.getScheme());
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (bool) {
      bool2 = bool1;
      if (!uri.getPathSegments().isEmpty()) {
        bool2 = bool1;
        if ("android_asset".equals(uri.getPathSegments().get(0)))
          bool2 = true; 
      } 
    } 
    return bool2;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    if (this.assetManager == null)
      synchronized (this.lock) {
        if (this.assetManager == null)
          this.assetManager = this.context.getAssets(); 
      }  
    return new RequestHandler.Result(Okio.source(this.assetManager.open(getFilePath(paramRequest))), Picasso.LoadedFrom.DISK);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\AssetRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */