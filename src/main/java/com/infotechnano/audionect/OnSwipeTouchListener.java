package com.infotechnano.audionect;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements View.OnTouchListener {
  private final GestureDetector gestureDetector;
  
  public OnSwipeTouchListener(Context paramContext) {
    this.gestureDetector = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)new GestureListener());
  }
  
  public boolean onSwipeBottom() {
    return false;
  }
  
  public boolean onSwipeLeft() {
    return false;
  }
  
  public boolean onSwipeRight() {
    return false;
  }
  
  public boolean onSwipeTop() {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    return this.gestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
    private static final int SWIPE_DISTANCE_THRESHOLD = 100;
    
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    
    private GestureListener() {}
    
    public boolean onDown(MotionEvent param1MotionEvent) {
      return true;
    }
    
    public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      boolean bool2;
      boolean bool1 = false;
      try {
        float f1 = param1MotionEvent2.getX() - param1MotionEvent1.getX();
        float f2 = param1MotionEvent2.getY() - param1MotionEvent1.getY();
        if (Math.abs(f1) > Math.abs(f2) && Math.abs(f1) > 100.0F && Math.abs(param1Float1) > 100.0F) {
          if (f1 > 0.0F) {
            bool2 = OnSwipeTouchListener.this.onSwipeRight();
          } else {
            bool2 = OnSwipeTouchListener.this.onSwipeLeft();
          } 
        } else {
          bool2 = bool1;
          if (Math.abs(f2) > 100.0F) {
            bool2 = bool1;
            if (Math.abs(param1Float2) > 100.0F)
              if (f2 > 0.0F) {
                bool2 = OnSwipeTouchListener.this.onSwipeBottom();
              } else {
                bool2 = OnSwipeTouchListener.this.onSwipeTop();
              }  
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        bool2 = bool1;
      } 
      return bool2;
    }
  }
}