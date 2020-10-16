package com.squareup.picasso;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

class ContentStreamRequestHandler extends RequestHandler {
  final Context context;
  
  ContentStreamRequestHandler(Context paramContext) {
    this.context = paramContext;
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    return "content".equals(paramRequest.uri.getScheme());
  }
  
  InputStream getInputStream(Request paramRequest) throws FileNotFoundException {
    return this.context.getContentResolver().openInputStream(paramRequest.uri);
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    return new RequestHandler.Result(Okio.source(getInputStream(paramRequest)), Picasso.LoadedFrom.DISK);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\ContentStreamRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */