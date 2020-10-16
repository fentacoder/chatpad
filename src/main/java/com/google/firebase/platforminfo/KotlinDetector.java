package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

public final class KotlinDetector {
  public static String detectVersion() {
    try {
      return KotlinVersion.CURRENT.toString();
    } catch (NoClassDefFoundError noClassDefFoundError) {
      return null;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\platforminfo\KotlinDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */