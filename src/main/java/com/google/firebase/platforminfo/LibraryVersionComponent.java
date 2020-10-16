package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;

public class LibraryVersionComponent {
  public static Component<?> create(String paramString1, String paramString2) {
    return Component.intoSet(LibraryVersion.create(paramString1, paramString2), LibraryVersion.class);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\platforminfo\LibraryVersionComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */