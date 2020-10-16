package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

public class ListenerRegistrationImpl implements ListenerRegistration {
  private final AsyncEventListener<ViewSnapshot> asyncEventListener;
  
  private final FirestoreClient client;
  
  private final QueryListener queryListener;
  
  public ListenerRegistrationImpl(FirestoreClient paramFirestoreClient, QueryListener paramQueryListener, AsyncEventListener<ViewSnapshot> paramAsyncEventListener) {
    this.client = paramFirestoreClient;
    this.queryListener = paramQueryListener;
    this.asyncEventListener = paramAsyncEventListener;
  }
  
  public void remove() {
    this.asyncEventListener.mute();
    this.client.stopListening(this.queryListener);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ListenerRegistrationImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */