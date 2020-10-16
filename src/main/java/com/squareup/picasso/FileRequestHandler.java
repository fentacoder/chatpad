package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import okio.Okio;

class FileRequestHandler extends ContentStreamRequestHandler {
  FileRequestHandler(Context paramContext) {
    super(paramContext);
  }
  
  static int getFileExifRotation(Uri paramUri) throws IOException {
    return (new ExifInterface(paramUri.getPath())).getAttributeInt("Orientation", 1);
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    return "file".equals(paramRequest.uri.getScheme());
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    return new RequestHandler.Result(null, Okio.source(getInputStream(paramRequest)), Picasso.LoadedFrom.DISK, getFileExifRotation(paramRequest.uri));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\FileRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */