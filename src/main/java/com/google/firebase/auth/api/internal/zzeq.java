package com.google.firebase.auth.api.internal;

import java.util.Locale;

public final class zzeq {
  public static String zza() {
    Locale locale = Locale.getDefault();
    StringBuilder stringBuilder = new StringBuilder();
    zza(stringBuilder, locale);
    if (!locale.equals(Locale.US)) {
      if (stringBuilder.length() > 0)
        stringBuilder.append(", "); 
      zza(stringBuilder, Locale.US);
    } 
    return stringBuilder.toString();
  }
  
  private static void zza(StringBuilder paramStringBuilder, Locale paramLocale) {
    String str = paramLocale.getLanguage();
    if (str != null) {
      paramStringBuilder.append(str);
      String str1 = paramLocale.getCountry();
      if (str1 != null) {
        paramStringBuilder.append("-");
        paramStringBuilder.append(str1);
      } 
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzeq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */