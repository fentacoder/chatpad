package com.squareup.picasso;

public interface Callback {
  void onError(Exception paramException);
  
  void onSuccess();
  
  public static class EmptyCallback implements Callback {
    public void onError(Exception param1Exception) {}
    
    public void onSuccess() {}
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\Callback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */