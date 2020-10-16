package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

final class zzaz {
  private final zzav zzar;
  
  private int zzdp = 0;
  
  private final Map<Integer, TaskCompletionSource<Void>> zzdq = (Map<Integer, TaskCompletionSource<Void>>)new ArrayMap();
  
  zzaz(zzav paramzzav) {
    this.zzar = paramzzav;
  }
  
  private static boolean zza(FirebaseInstanceId paramFirebaseInstanceId, String paramString) {
    String[] arrayOfString = paramString.split("!");
    if (arrayOfString.length == 2) {
      paramString = arrayOfString[0];
      String str = arrayOfString[1];
      byte b = -1;
      try {
        int i = paramString.hashCode();
        if (i != 83) {
          if (i == 85 && paramString.equals("U"))
            b = 1; 
        } else if (paramString.equals("S")) {
          b = 0;
        } 
        if (b != 0) {
          if (b == 1) {
            paramFirebaseInstanceId.zzc(str);
            if (FirebaseInstanceId.zzm())
              Log.d("FirebaseInstanceId", "unsubscribe operation succeeded"); 
          } 
        } else {
          paramFirebaseInstanceId.zzb(str);
          if (FirebaseInstanceId.zzm())
            Log.d("FirebaseInstanceId", "subscribe operation succeeded"); 
        } 
      } catch (IOException iOException) {
        String str1 = String.valueOf(iOException.getMessage());
        if (str1.length() != 0) {
          str1 = "Topic sync failed: ".concat(str1);
        } else {
          str1 = new String("Topic sync failed: ");
        } 
        Log.e("FirebaseInstanceId", str1);
        return false;
      } 
    } 
    return true;
  }
  
  private final String zzap() {
    zzav zzav1;
    String[] arrayOfString;
    synchronized (this.zzar) {
      String str = this.zzar.zzai();
      if (!TextUtils.isEmpty(str)) {
        arrayOfString = str.split(",");
        if (arrayOfString.length > 1 && !TextUtils.isEmpty(arrayOfString[1]))
          return arrayOfString[1]; 
      } 
      return null;
    } 
  }
  
  private final boolean zzk(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   13: invokevirtual zzai : ()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_1
    //   18: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   21: astore #4
    //   23: aload #4
    //   25: invokevirtual length : ()I
    //   28: ifeq -> 43
    //   31: ldc ','
    //   33: aload #4
    //   35: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   38: astore #4
    //   40: goto -> 54
    //   43: new java/lang/String
    //   46: dup
    //   47: ldc ','
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore #4
    //   54: aload_3
    //   55: aload #4
    //   57: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   60: ifeq -> 118
    //   63: aload_1
    //   64: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual length : ()I
    //   72: ifeq -> 85
    //   75: ldc ','
    //   77: aload_1
    //   78: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_1
    //   82: goto -> 95
    //   85: new java/lang/String
    //   88: dup
    //   89: ldc ','
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: astore_1
    //   95: aload_3
    //   96: aload_1
    //   97: invokevirtual length : ()I
    //   100: invokevirtual substring : (I)Ljava/lang/String;
    //   103: astore_1
    //   104: aload_0
    //   105: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   108: aload_1
    //   109: invokevirtual zzf : (Ljava/lang/String;)V
    //   112: aload_2
    //   113: monitorexit
    //   114: aload_0
    //   115: monitorexit
    //   116: iconst_1
    //   117: ireturn
    //   118: aload_2
    //   119: monitorexit
    //   120: aload_0
    //   121: monitorexit
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_1
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	129	finally
    //   9	40	124	finally
    //   43	54	124	finally
    //   54	82	124	finally
    //   85	95	124	finally
    //   95	114	124	finally
    //   118	120	124	finally
    //   125	127	124	finally
    //   127	129	129	finally
  }
  
  final Task<Void> zza(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   13: invokevirtual zzai : ()Ljava/lang/String;
    //   16: astore_3
    //   17: aload_0
    //   18: getfield zzar : Lcom/google/firebase/iid/zzav;
    //   21: astore #4
    //   23: aload_3
    //   24: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokevirtual length : ()I
    //   30: istore #5
    //   32: aload_1
    //   33: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual length : ()I
    //   39: istore #6
    //   41: new java/lang/StringBuilder
    //   44: astore #7
    //   46: aload #7
    //   48: iload #5
    //   50: iconst_1
    //   51: iadd
    //   52: iload #6
    //   54: iadd
    //   55: invokespecial <init> : (I)V
    //   58: aload #7
    //   60: aload_3
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #7
    //   67: ldc ','
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #7
    //   75: aload_1
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #4
    //   82: aload #7
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual zzf : (Ljava/lang/String;)V
    //   90: aload_2
    //   91: monitorexit
    //   92: new com/google/android/gms/tasks/TaskCompletionSource
    //   95: astore_1
    //   96: aload_1
    //   97: invokespecial <init> : ()V
    //   100: aload_0
    //   101: getfield zzdq : Ljava/util/Map;
    //   104: astore_2
    //   105: aload_3
    //   106: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   109: ifeq -> 118
    //   112: iconst_0
    //   113: istore #5
    //   115: goto -> 129
    //   118: aload_3
    //   119: ldc ','
    //   121: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   124: arraylength
    //   125: iconst_1
    //   126: isub
    //   127: istore #5
    //   129: aload_2
    //   130: aload_0
    //   131: getfield zzdp : I
    //   134: iload #5
    //   136: iadd
    //   137: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   140: aload_1
    //   141: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload_1
    //   148: invokevirtual getTask : ()Lcom/google/android/gms/tasks/Task;
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: areturn
    //   156: astore_1
    //   157: aload_2
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	161	finally
    //   9	92	156	finally
    //   92	112	161	finally
    //   118	129	161	finally
    //   129	152	161	finally
    //   157	159	156	finally
    //   159	161	161	finally
  }
  
  final boolean zzao() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial zzap : ()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  final boolean zzc(FirebaseInstanceId paramFirebaseInstanceId) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial zzap : ()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull -> 29
    //   11: invokestatic zzm : ()Z
    //   14: ifeq -> 25
    //   17: ldc 'FirebaseInstanceId'
    //   19: ldc 'topic sync succeeded'
    //   21: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: iconst_1
    //   28: ireturn
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: aload_2
    //   33: invokestatic zza : (Lcom/google/firebase/iid/FirebaseInstanceId;Ljava/lang/String;)Z
    //   36: ifne -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_0
    //   44: getfield zzdq : Ljava/util/Map;
    //   47: aload_0
    //   48: getfield zzdp : I
    //   51: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   54: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast com/google/android/gms/tasks/TaskCompletionSource
    //   62: astore_3
    //   63: aload_0
    //   64: aload_2
    //   65: invokespecial zzk : (Ljava/lang/String;)Z
    //   68: pop
    //   69: aload_0
    //   70: aload_0
    //   71: getfield zzdp : I
    //   74: iconst_1
    //   75: iadd
    //   76: putfield zzdp : I
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: ifnull -> 0
    //   85: aload_3
    //   86: aconst_null
    //   87: invokevirtual setResult : (Ljava/lang/Object;)V
    //   90: goto -> 0
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	98	finally
    //   11	25	98	finally
    //   25	27	98	finally
    //   29	31	98	finally
    //   43	81	93	finally
    //   94	96	93	finally
    //   99	101	98	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzaz.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */