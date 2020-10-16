package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Future;

public abstract class zzam<T extends zzao> {
  private static Logger zza = new Logger("BiChannelGoogleApi", new String[] { "FirebaseAuth: " });
  
  private zzal<T> zzb;
  
  private final GoogleApi<T> zza(String paramString) {
    zzal<T> zzal1 = zzc();
    if (zzal1.zzc.zza(paramString)) {
      Logger logger1 = zza;
      paramString = String.valueOf(zzal1.zzb);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(paramString).length() + 43);
      stringBuilder1.append("getGoogleApiForMethod() returned Fallback: ");
      stringBuilder1.append(paramString);
      logger1.i(stringBuilder1.toString(), new Object[0]);
      return zzal1.zzb;
    } 
    Logger logger = zza;
    String str = String.valueOf(zzal1.zza);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 38);
    stringBuilder.append("getGoogleApiForMethod() returned Gms: ");
    stringBuilder.append(str);
    logger.i(stringBuilder.toString(), new Object[0]);
    return zzal1.zza;
  }
  
  private static <ResultT> Task<ResultT> zzb() {
    return Tasks.forException((Exception)zzdv.zza(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
  }
  
  private final zzal<T> zzc() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzb : Lcom/google/firebase/auth/api/internal/zzal;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 77
    //   11: aload_0
    //   12: aload_0
    //   13: invokevirtual zza : ()Ljava/util/concurrent/Future;
    //   16: invokeinterface get : ()Ljava/lang/Object;
    //   21: checkcast com/google/firebase/auth/api/internal/zzal
    //   24: putfield zzb : Lcom/google/firebase/auth/api/internal/zzal;
    //   27: goto -> 77
    //   30: astore_1
    //   31: new java/lang/RuntimeException
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual getMessage : ()Ljava/lang/String;
    //   39: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual length : ()I
    //   47: ifeq -> 60
    //   50: ldc 'There was an error while initializing the connection to Google Play Services: '
    //   52: aload_1
    //   53: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: goto -> 70
    //   60: new java/lang/String
    //   63: dup
    //   64: ldc 'There was an error while initializing the connection to Google Play Services: '
    //   66: invokespecial <init> : (Ljava/lang/String;)V
    //   69: astore_1
    //   70: aload_2
    //   71: aload_1
    //   72: invokespecial <init> : (Ljava/lang/String;)V
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: getfield zzb : Lcom/google/firebase/auth/api/internal/zzal;
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: areturn
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	86	finally
    //   11	27	30	java/lang/Exception
    //   11	27	86	finally
    //   31	57	86	finally
    //   60	70	86	finally
    //   70	77	86	finally
    //   77	84	86	finally
    //   87	89	86	finally
  }
  
  public final <ResultT, A extends com.google.android.gms.common.api.Api.AnyClient> Task<ResultT> zza(zzap<A, ResultT> paramzzap) {
    GoogleApi<T> googleApi = zza(paramzzap.zza());
    if (googleApi == null)
      return zzb(); 
    if (((zzao)googleApi.getApiOptions()).zza)
      paramzzap.zzd(); 
    return googleApi.doRead(paramzzap.zzb());
  }
  
  abstract Future<zzal<T>> zza();
  
  public final <ResultT, A extends com.google.android.gms.common.api.Api.AnyClient> Task<ResultT> zzb(zzap<A, ResultT> paramzzap) {
    GoogleApi<T> googleApi = zza(paramzzap.zza());
    if (googleApi == null)
      return zzb(); 
    if (((zzao)googleApi.getApiOptions()).zza)
      paramzzap.zzd(); 
    return googleApi.doWrite(paramzzap.zzb());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */