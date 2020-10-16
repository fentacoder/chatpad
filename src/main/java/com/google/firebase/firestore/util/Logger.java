package com.google.firebase.firestore.util;

import android.util.Log;

public class Logger {
  private static Level logLevel = Level.WARN;
  
  public static void debug(String paramString1, String paramString2, Object... paramVarArgs) {
    doLog(Level.DEBUG, paramString1, paramString2, paramVarArgs);
  }
  
  private static void doLog(Level paramLevel, String paramString1, String paramString2, Object... paramVarArgs) {
    if (paramLevel.ordinal() >= logLevel.ordinal()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(String.format("(%s) [%s]: ", new Object[] { "21.3.1", paramString1 }));
      stringBuilder.append(String.format(paramString2, paramVarArgs));
      paramString1 = stringBuilder.toString();
      int i = null.$SwitchMap$com$google$firebase$firestore$util$Logger$Level[paramLevel.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            throw new IllegalStateException("Trying to log something on level NONE"); 
        } else {
          Log.w("Firestore", paramString1);
          return;
        } 
      } else {
        Log.i("Firestore", paramString1);
      } 
    } 
  }
  
  public static boolean isDebugEnabled() {
    boolean bool;
    if (logLevel.ordinal() >= Level.DEBUG.ordinal()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static void setLogLevel(Level paramLevel) {
    logLevel = paramLevel;
  }
  
  public static void warn(String paramString1, String paramString2, Object... paramVarArgs) {
    doLog(Level.WARN, paramString1, paramString2, paramVarArgs);
  }
  
  public enum Level {
    DEBUG, NONE, WARN;
    
    static {
      $VALUES = new Level[] { DEBUG, WARN, NONE };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\Logger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */