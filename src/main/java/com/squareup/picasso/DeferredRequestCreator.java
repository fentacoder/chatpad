package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
  Callback callback;
  
  private final RequestCreator creator;
  
  final WeakReference<ImageView> target;
  
  DeferredRequestCreator(RequestCreator paramRequestCreator, ImageView paramImageView, Callback paramCallback) {
    this.creator = paramRequestCreator;
    this.target = new WeakReference<>(paramImageView);
    this.callback = paramCallback;
    paramImageView.addOnAttachStateChangeListener(this);
    if (paramImageView.getWindowToken() != null)
      onViewAttachedToWindow((View)paramImageView); 
  }
  
  void cancel() {
    this.creator.clearTag();
    this.callback = null;
    ImageView imageView = this.target.get();
    if (imageView == null)
      return; 
    this.target.clear();
    imageView.removeOnAttachStateChangeListener(this);
    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
    if (viewTreeObserver.isAlive())
      viewTreeObserver.removeOnPreDrawListener(this); 
  }
  
  Object getTag() {
    return this.creator.getTag();
  }
  
  public boolean onPreDraw() {
    ImageView imageView = this.target.get();
    if (imageView == null)
      return true; 
    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
    if (!viewTreeObserver.isAlive())
      return true; 
    int i = imageView.getWidth();
    int j = imageView.getHeight();
    if (i > 0 && j > 0) {
      imageView.removeOnAttachStateChangeListener(this);
      viewTreeObserver.removeOnPreDrawListener(this);
      this.target.clear();
      this.creator.unfit().resize(i, j).into(imageView, this.callback);
    } 
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {
    paramView.getViewTreeObserver().addOnPreDrawListener(this);
  }
  
  public void onViewDetachedFromWindow(View paramView) {
    paramView.getViewTreeObserver().removeOnPreDrawListener(this);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\DeferredRequestCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */