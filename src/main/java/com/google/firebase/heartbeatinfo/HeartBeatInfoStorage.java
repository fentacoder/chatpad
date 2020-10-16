package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;

class HeartBeatInfoStorage {
  private static final String GLOBAL = "fire-global";
  
  private static HeartBeatInfoStorage instance;
  
  private static final String preferencesName = "FirebaseAppHeartBeat";
  
  private final SharedPreferences sharedPreferences;
  
  private HeartBeatInfoStorage(Context paramContext) {
    this.sharedPreferences = paramContext.getSharedPreferences("FirebaseAppHeartBeat", 0);
  }
  
  HeartBeatInfoStorage(SharedPreferences paramSharedPreferences) {
    this.sharedPreferences = paramSharedPreferences;
  }
  
  static HeartBeatInfoStorage getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/firebase/heartbeatinfo/HeartBeatInfoStorage
    //   2: monitorenter
    //   3: getstatic com/google/firebase/heartbeatinfo/HeartBeatInfoStorage.instance : Lcom/google/firebase/heartbeatinfo/HeartBeatInfoStorage;
    //   6: ifnonnull -> 22
    //   9: new com/google/firebase/heartbeatinfo/HeartBeatInfoStorage
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/google/firebase/heartbeatinfo/HeartBeatInfoStorage.instance : Lcom/google/firebase/heartbeatinfo/HeartBeatInfoStorage;
    //   22: getstatic com/google/firebase/heartbeatinfo/HeartBeatInfoStorage.instance : Lcom/google/firebase/heartbeatinfo/HeartBeatInfoStorage;
    //   25: astore_0
    //   26: ldc com/google/firebase/heartbeatinfo/HeartBeatInfoStorage
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/google/firebase/heartbeatinfo/HeartBeatInfoStorage
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  boolean shouldSendGlobalHeartBeat(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 'fire-global'
    //   5: lload_1
    //   6: invokevirtual shouldSendSdkHeartBeat : (Ljava/lang/String;J)Z
    //   9: istore_3
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_3
    //   13: ireturn
    //   14: astore #4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload #4
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  boolean shouldSendSdkHeartBeat(String paramString, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   6: aload_1
    //   7: invokeinterface contains : (Ljava/lang/String;)Z
    //   12: ifeq -> 66
    //   15: lload_2
    //   16: aload_0
    //   17: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   20: aload_1
    //   21: ldc2_w -1
    //   24: invokeinterface getLong : (Ljava/lang/String;J)J
    //   29: lsub
    //   30: ldc2_w 86400000
    //   33: lcmp
    //   34: iflt -> 62
    //   37: aload_0
    //   38: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   41: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   46: aload_1
    //   47: lload_2
    //   48: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   53: invokeinterface apply : ()V
    //   58: aload_0
    //   59: monitorexit
    //   60: iconst_1
    //   61: ireturn
    //   62: aload_0
    //   63: monitorexit
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_0
    //   67: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   70: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   75: aload_1
    //   76: lload_2
    //   77: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   82: invokeinterface apply : ()V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	58	91	finally
    //   66	87	91	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfoStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */