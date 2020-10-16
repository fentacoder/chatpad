package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

public final class Credentials {
  public static String basic(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append(paramString1);
      stringBuilder2.append(":");
      stringBuilder2.append(paramString2);
      paramString1 = ByteString.of(stringBuilder2.toString().getBytes("ISO-8859-1")).base64();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append("Basic ");
      stringBuilder1.append(paramString1);
      return stringBuilder1.toString();
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\Credentials.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */