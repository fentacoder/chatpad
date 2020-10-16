package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

abstract class RemoteViewsAction extends Action<RemoteViewsAction.RemoteViewsTarget> {
  Callback callback;
  
  final RemoteViews remoteViews;
  
  private RemoteViewsTarget target;
  
  final int viewId;
  
  RemoteViewsAction(Picasso paramPicasso, Request paramRequest, RemoteViews paramRemoteViews, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, String paramString, Callback paramCallback) {
    super(paramPicasso, null, paramRequest, paramInt3, paramInt4, paramInt2, null, paramString, paramObject, false);
    this.remoteViews = paramRemoteViews;
    this.viewId = paramInt1;
    this.callback = paramCallback;
  }
  
  void cancel() {
    super.cancel();
    if (this.callback != null)
      this.callback = null; 
  }
  
  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom) {
    this.remoteViews.setImageViewBitmap(this.viewId, paramBitmap);
    update();
    Callback callback = this.callback;
    if (callback != null)
      callback.onSuccess(); 
  }
  
  public void error(Exception paramException) {
    if (this.errorResId != 0)
      setImageResource(this.errorResId); 
    Callback callback = this.callback;
    if (callback != null)
      callback.onError(paramException); 
  }
  
  RemoteViewsTarget getTarget() {
    if (this.target == null)
      this.target = new RemoteViewsTarget(this.remoteViews, this.viewId); 
    return this.target;
  }
  
  void setImageResource(int paramInt) {
    this.remoteViews.setImageViewResource(this.viewId, paramInt);
    update();
  }
  
  abstract void update();
  
  static class AppWidgetAction extends RemoteViewsAction {
    private final int[] appWidgetIds;
    
    AppWidgetAction(Picasso param1Picasso, Request param1Request, RemoteViews param1RemoteViews, int param1Int1, int[] param1ArrayOfint, int param1Int2, int param1Int3, String param1String, Object param1Object, int param1Int4, Callback param1Callback) {
      super(param1Picasso, param1Request, param1RemoteViews, param1Int1, param1Int4, param1Int2, param1Int3, param1Object, param1String, param1Callback);
      this.appWidgetIds = param1ArrayOfint;
    }
    
    void update() {
      AppWidgetManager.getInstance(this.picasso.context).updateAppWidget(this.appWidgetIds, this.remoteViews);
    }
  }
  
  static class NotificationAction extends RemoteViewsAction {
    private final Notification notification;
    
    private final int notificationId;
    
    private final String notificationTag;
    
    NotificationAction(Picasso param1Picasso, Request param1Request, RemoteViews param1RemoteViews, int param1Int1, int param1Int2, Notification param1Notification, String param1String1, int param1Int3, int param1Int4, String param1String2, Object param1Object, int param1Int5, Callback param1Callback) {
      super(param1Picasso, param1Request, param1RemoteViews, param1Int1, param1Int5, param1Int3, param1Int4, param1Object, param1String2, param1Callback);
      this.notificationId = param1Int2;
      this.notificationTag = param1String1;
      this.notification = param1Notification;
    }
    
    void update() {
      ((NotificationManager)Utils.<NotificationManager>getService(this.picasso.context, "notification")).notify(this.notificationTag, this.notificationId, this.notification);
    }
  }
  
  static class RemoteViewsTarget {
    final RemoteViews remoteViews;
    
    final int viewId;
    
    RemoteViewsTarget(RemoteViews param1RemoteViews, int param1Int) {
      this.remoteViews = param1RemoteViews;
      this.viewId = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = true;
      if (this == param1Object)
        return true; 
      if (param1Object == null || getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      if (this.viewId != ((RemoteViewsTarget)param1Object).viewId || !this.remoteViews.equals(((RemoteViewsTarget)param1Object).remoteViews))
        bool = false; 
      return bool;
    }
    
    public int hashCode() {
      return this.remoteViews.hashCode() * 31 + this.viewId;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\RemoteViewsAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */