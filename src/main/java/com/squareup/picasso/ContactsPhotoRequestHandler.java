package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

class ContactsPhotoRequestHandler extends RequestHandler {
  private static final int ID_CONTACT = 3;
  
  private static final int ID_DISPLAY_PHOTO = 4;
  
  private static final int ID_LOOKUP = 1;
  
  private static final int ID_THUMBNAIL = 2;
  
  private static final UriMatcher matcher = new UriMatcher(-1);
  
  private final Context context;
  
  static {
    matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
    matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
    matcher.addURI("com.android.contacts", "contacts/#", 3);
    matcher.addURI("com.android.contacts", "display_photo/#", 4);
  }
  
  ContactsPhotoRequestHandler(Context paramContext) {
    this.context = paramContext;
  }
  
  private InputStream getInputStream(Request paramRequest) throws IOException {
    Uri uri1;
    ContentResolver contentResolver = this.context.getContentResolver();
    Uri uri2 = paramRequest.uri;
    int i = matcher.match(uri2);
    if (i != 1) {
      if (i != 2) {
        uri1 = uri2;
        if (i != 3) {
          if (i != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid uri: ");
            stringBuilder.append(uri2);
            throw new IllegalStateException(stringBuilder.toString());
          } 
          return contentResolver.openInputStream(uri2);
        } 
      } else {
        return contentResolver.openInputStream(uri2);
      } 
    } else {
      uri2 = ContactsContract.Contacts.lookupContact(contentResolver, uri2);
      uri1 = uri2;
      if (uri2 == null)
        return null; 
    } 
    return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri1, true);
  }
  
  public boolean canHandleRequest(Request paramRequest) {
    boolean bool;
    Uri uri = paramRequest.uri;
    if ("content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(paramRequest.uri) != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public RequestHandler.Result load(Request paramRequest, int paramInt) throws IOException {
    InputStream inputStream = getInputStream(paramRequest);
    return (inputStream == null) ? null : new RequestHandler.Result(Okio.source(inputStream), Picasso.LoadedFrom.DISK);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\ContactsPhotoRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */