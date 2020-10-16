package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;

final class PicassoDrawable extends BitmapDrawable {
  private static final Paint DEBUG_PAINT = new Paint();
  
  private static final float FADE_DURATION = 200.0F;
  
  int alpha;
  
  boolean animating;
  
  private final boolean debugging;
  
  private final float density;
  
  private final Picasso.LoadedFrom loadedFrom;
  
  Drawable placeholder;
  
  long startTimeMillis;
  
  PicassoDrawable(Context paramContext, Bitmap paramBitmap, Drawable paramDrawable, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramContext.getResources(), paramBitmap);
    boolean bool;
    this.alpha = 255;
    this.debugging = paramBoolean2;
    this.density = (paramContext.getResources().getDisplayMetrics()).density;
    this.loadedFrom = paramLoadedFrom;
    if (paramLoadedFrom != Picasso.LoadedFrom.MEMORY && !paramBoolean1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.placeholder = paramDrawable;
      this.animating = true;
      this.startTimeMillis = SystemClock.uptimeMillis();
    } 
  }
  
  private void drawDebugIndicator(Canvas paramCanvas) {
    DEBUG_PAINT.setColor(-1);
    paramCanvas.drawPath(getTrianglePath(0, 0, (int)(this.density * 16.0F)), DEBUG_PAINT);
    DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
    paramCanvas.drawPath(getTrianglePath(0, 0, (int)(this.density * 15.0F)), DEBUG_PAINT);
  }
  
  private static Path getTrianglePath(int paramInt1, int paramInt2, int paramInt3) {
    Path path = new Path();
    float f1 = paramInt1;
    float f2 = paramInt2;
    path.moveTo(f1, f2);
    path.lineTo((paramInt1 + paramInt3), f2);
    path.lineTo(f1, (paramInt2 + paramInt3));
    return path;
  }
  
  static void setBitmap(ImageView paramImageView, Context paramContext, Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom, boolean paramBoolean1, boolean paramBoolean2) {
    Drawable drawable = paramImageView.getDrawable();
    if (drawable instanceof Animatable)
      ((Animatable)drawable).stop(); 
    paramImageView.setImageDrawable((Drawable)new PicassoDrawable(paramContext, paramBitmap, drawable, paramLoadedFrom, paramBoolean1, paramBoolean2));
  }
  
  static void setPlaceholder(ImageView paramImageView, Drawable paramDrawable) {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramImageView.getDrawable() instanceof Animatable)
      ((Animatable)paramImageView.getDrawable()).start(); 
  }
  
  public void draw(Canvas paramCanvas) {
    if (!this.animating) {
      super.draw(paramCanvas);
    } else {
      float f = (float)(SystemClock.uptimeMillis() - this.startTimeMillis) / 200.0F;
      if (f >= 1.0F) {
        this.animating = false;
        this.placeholder = null;
        super.draw(paramCanvas);
      } else {
        Drawable drawable = this.placeholder;
        if (drawable != null)
          drawable.draw(paramCanvas); 
        super.setAlpha((int)(this.alpha * f));
        super.draw(paramCanvas);
        super.setAlpha(this.alpha);
      } 
    } 
    if (this.debugging)
      drawDebugIndicator(paramCanvas); 
  }
  
  protected void onBoundsChange(Rect paramRect) {
    Drawable drawable = this.placeholder;
    if (drawable != null)
      drawable.setBounds(paramRect); 
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt) {
    this.alpha = paramInt;
    Drawable drawable = this.placeholder;
    if (drawable != null)
      drawable.setAlpha(paramInt); 
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    Drawable drawable = this.placeholder;
    if (drawable != null)
      drawable.setColorFilter(paramColorFilter); 
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\PicassoDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */