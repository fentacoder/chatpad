package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

abstract class LibraryVersion {
  static LibraryVersion create(String paramString1, String paramString2) {
    return new AutoValue_LibraryVersion(paramString1, paramString2);
  }
  
  @Nonnull
  public abstract String getLibraryName();
  
  @Nonnull
  public abstract String getVersion();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\platforminfo\LibraryVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */