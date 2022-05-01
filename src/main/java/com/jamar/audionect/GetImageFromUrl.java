package com.jamar.audionect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.net.URL;

public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
  private ImageView img;
  
  public GetImageFromUrl(ImageView paramImageView) {
    this.img = paramImageView;
  }
  
  protected Bitmap doInBackground(String... paramVarArgs) {
    String str = paramVarArgs[0];
    try {
      URL uRL = new URL();
      this(str);
      Bitmap bitmap = BitmapFactory.decodeStream(uRL.openStream());
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (Bitmap)exception;
  }
  
  protected void onPostExecute(Bitmap paramBitmap) {
    super.onPostExecute(paramBitmap);
    this.img.setImageBitmap(paramBitmap);
  }
}
