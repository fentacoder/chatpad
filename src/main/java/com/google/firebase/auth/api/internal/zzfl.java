package com.google.firebase.auth.api.internal;

public final class zzfl {
  public static String zza(String paramString) {
    try {
      Object object = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      if (object != null && String.class.isAssignableFrom(object.getClass()))
        return (String)object; 
    } catch (Exception exception) {}
    return null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzfl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */