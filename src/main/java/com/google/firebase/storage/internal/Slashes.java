package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

public class Slashes {
  public static String normalizeSlashes(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    if (paramString.startsWith("/") || paramString.endsWith("/") || paramString.contains("//")) {
      StringBuilder stringBuilder = new StringBuilder();
      for (String paramString : paramString.split("/", -1)) {
        if (!TextUtils.isEmpty(paramString))
          if (stringBuilder.length() > 0) {
            stringBuilder.append("/");
            stringBuilder.append(paramString);
          } else {
            stringBuilder.append(paramString);
          }  
      } 
      return stringBuilder.toString();
    } 
    return paramString;
  }
  
  public static String preserveSlashEncode(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : slashize(Uri.encode(paramString));
  }
  
  public static String slashize(String paramString) {
    Preconditions.checkNotNull(paramString);
    return paramString.replace("%2F", "/");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\Slashes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */