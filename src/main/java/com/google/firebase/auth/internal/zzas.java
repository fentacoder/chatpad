package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public final class zzas {
  private static long zza = 3600000L;
  
  private static final zzbg<String> zzb = zzbg.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
  
  private static final zzas zzc = new zzas();
  
  private Task<AuthResult> zzd;
  
  private long zze = 0L;
  
  public static zzas zza() {
    return zzc;
  }
  
  public static void zza(Context paramContext, Status paramStatus) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
    editor.putInt("statusCode", paramStatus.getStatusCode());
    editor.putString("statusMessage", paramStatus.getStatusMessage());
    editor.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
    editor.commit();
  }
  
  public static void zza(Context paramContext, zzfy paramzzfy, String paramString1, String paramString2) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
    editor.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString((SafeParcelable)paramzzfy));
    editor.putString("operation", paramString1);
    editor.putString("tenantId", paramString2);
    editor.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
    editor.commit();
  }
  
  public static void zza(Context paramContext, FirebaseAuth paramFirebaseAuth) {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramFirebaseAuth);
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
    editor.putString("firebaseAppName", paramFirebaseAuth.zzb().getName());
    editor.commit();
  }
  
  public static void zza(Context paramContext, FirebaseAuth paramFirebaseAuth, FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramFirebaseAuth);
    Preconditions.checkNotNull(paramFirebaseUser);
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
    editor.putString("firebaseAppName", paramFirebaseAuth.zzb().getName());
    editor.putString("firebaseUserUid", paramFirebaseUser.getUid());
    editor.commit();
  }
  
  private static void zza(SharedPreferences paramSharedPreferences) {
    SharedPreferences.Editor editor = paramSharedPreferences.edit();
    zzbg<String> zzbg1 = zzb;
    int i = zzbg1.size();
    byte b = 0;
    while (b < i) {
      Object object = zzbg1.get(b);
      b++;
      editor.remove((String)object);
    } 
    editor.commit();
  }
  
  public final void zza(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    zza(paramContext.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
    this.zzd = null;
    this.zze = 0L;
  }
  
  public final void zza(FirebaseAuth paramFirebaseAuth) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokevirtual zzb : ()Lcom/google/firebase/FirebaseApp;
    //   9: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   12: astore_2
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_2
    //   16: ldc 'com.google.firebase.auth.internal.ProcessDeathHelper'
    //   18: iconst_0
    //   19: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 'firebaseAppName'
    //   26: ldc ''
    //   28: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore #4
    //   35: aload_1
    //   36: invokevirtual zzb : ()Lcom/google/firebase/FirebaseApp;
    //   39: invokevirtual getName : ()Ljava/lang/String;
    //   42: aload #4
    //   44: invokevirtual equals : (Ljava/lang/Object;)Z
    //   47: ifne -> 51
    //   50: return
    //   51: aload_2
    //   52: ldc 'verifyAssertionRequest'
    //   54: invokeinterface contains : (Ljava/lang/String;)Z
    //   59: ifeq -> 350
    //   62: aload_2
    //   63: ldc 'verifyAssertionRequest'
    //   65: ldc ''
    //   67: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: getstatic com/google/android/gms/internal/firebase_auth/zzfy.CREATOR : Landroid/os/Parcelable$Creator;
    //   75: invokestatic deserializeFromString : (Ljava/lang/String;Landroid/os/Parcelable$Creator;)Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;
    //   78: checkcast com/google/android/gms/internal/firebase_auth/zzfy
    //   81: astore #5
    //   83: aload_2
    //   84: ldc 'operation'
    //   86: ldc ''
    //   88: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore #6
    //   95: aload_2
    //   96: ldc 'tenantId'
    //   98: aconst_null
    //   99: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: astore #4
    //   106: aload_2
    //   107: ldc 'firebaseUserUid'
    //   109: ldc ''
    //   111: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore #7
    //   118: aload_0
    //   119: aload_2
    //   120: ldc 'timestamp'
    //   122: lconst_0
    //   123: invokeinterface getLong : (Ljava/lang/String;J)J
    //   128: putfield zze : J
    //   131: aload #4
    //   133: ifnull -> 150
    //   136: aload_1
    //   137: aload #4
    //   139: invokevirtual zza : (Ljava/lang/String;)V
    //   142: aload #5
    //   144: aload #4
    //   146: invokevirtual zzb : (Ljava/lang/String;)Lcom/google/android/gms/internal/firebase_auth/zzfy;
    //   149: pop
    //   150: aload #6
    //   152: invokevirtual hashCode : ()I
    //   155: istore #8
    //   157: iload #8
    //   159: ldc -1843829902
    //   161: if_icmpeq -> 209
    //   164: iload #8
    //   166: ldc -286760092
    //   168: if_icmpeq -> 194
    //   171: iload #8
    //   173: ldc 1731327805
    //   175: if_icmpeq -> 181
    //   178: goto -> 224
    //   181: aload #6
    //   183: ldc 'com.google.firebase.auth.internal.SIGN_IN'
    //   185: invokevirtual equals : (Ljava/lang/Object;)Z
    //   188: ifeq -> 224
    //   191: goto -> 226
    //   194: aload #6
    //   196: ldc 'com.google.firebase.auth.internal.LINK'
    //   198: invokevirtual equals : (Ljava/lang/Object;)Z
    //   201: ifeq -> 224
    //   204: iconst_1
    //   205: istore_3
    //   206: goto -> 226
    //   209: aload #6
    //   211: ldc 'com.google.firebase.auth.internal.REAUTHENTICATE'
    //   213: invokevirtual equals : (Ljava/lang/Object;)Z
    //   216: ifeq -> 224
    //   219: iconst_2
    //   220: istore_3
    //   221: goto -> 226
    //   224: iconst_m1
    //   225: istore_3
    //   226: iload_3
    //   227: ifeq -> 332
    //   230: iload_3
    //   231: iconst_1
    //   232: if_icmpeq -> 290
    //   235: iload_3
    //   236: iconst_2
    //   237: if_icmpeq -> 248
    //   240: aload_0
    //   241: aconst_null
    //   242: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   245: goto -> 345
    //   248: aload_1
    //   249: invokevirtual getCurrentUser : ()Lcom/google/firebase/auth/FirebaseUser;
    //   252: invokevirtual getUid : ()Ljava/lang/String;
    //   255: aload #7
    //   257: invokevirtual equals : (Ljava/lang/Object;)Z
    //   260: ifeq -> 282
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual getCurrentUser : ()Lcom/google/firebase/auth/FirebaseUser;
    //   268: aload #5
    //   270: invokestatic zza : (Lcom/google/android/gms/internal/firebase_auth/zzfy;)Lcom/google/firebase/auth/zzg;
    //   273: invokevirtual reauthenticateAndRetrieveData : (Lcom/google/firebase/auth/AuthCredential;)Lcom/google/android/gms/tasks/Task;
    //   276: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   279: goto -> 345
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   287: goto -> 345
    //   290: aload_1
    //   291: invokevirtual getCurrentUser : ()Lcom/google/firebase/auth/FirebaseUser;
    //   294: invokevirtual getUid : ()Ljava/lang/String;
    //   297: aload #7
    //   299: invokevirtual equals : (Ljava/lang/Object;)Z
    //   302: ifeq -> 324
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual getCurrentUser : ()Lcom/google/firebase/auth/FirebaseUser;
    //   310: aload #5
    //   312: invokestatic zza : (Lcom/google/android/gms/internal/firebase_auth/zzfy;)Lcom/google/firebase/auth/zzg;
    //   315: invokevirtual linkWithCredential : (Lcom/google/firebase/auth/AuthCredential;)Lcom/google/android/gms/tasks/Task;
    //   318: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   321: goto -> 345
    //   324: aload_0
    //   325: aconst_null
    //   326: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   329: goto -> 345
    //   332: aload_0
    //   333: aload_1
    //   334: aload #5
    //   336: invokestatic zza : (Lcom/google/android/gms/internal/firebase_auth/zzfy;)Lcom/google/firebase/auth/zzg;
    //   339: invokevirtual signInWithCredential : (Lcom/google/firebase/auth/AuthCredential;)Lcom/google/android/gms/tasks/Task;
    //   342: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   345: aload_2
    //   346: invokestatic zza : (Landroid/content/SharedPreferences;)V
    //   349: return
    //   350: aload_2
    //   351: ldc 'statusCode'
    //   353: invokeinterface contains : (Ljava/lang/String;)Z
    //   358: ifeq -> 418
    //   361: new com/google/android/gms/common/api/Status
    //   364: dup
    //   365: aload_2
    //   366: ldc 'statusCode'
    //   368: sipush #17062
    //   371: invokeinterface getInt : (Ljava/lang/String;I)I
    //   376: aload_2
    //   377: ldc 'statusMessage'
    //   379: ldc ''
    //   381: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   386: invokespecial <init> : (ILjava/lang/String;)V
    //   389: astore_1
    //   390: aload_0
    //   391: aload_2
    //   392: ldc 'timestamp'
    //   394: lconst_0
    //   395: invokeinterface getLong : (Ljava/lang/String;J)J
    //   400: putfield zze : J
    //   403: aload_2
    //   404: invokestatic zza : (Landroid/content/SharedPreferences;)V
    //   407: aload_0
    //   408: aload_1
    //   409: invokestatic zza : (Lcom/google/android/gms/common/api/Status;)Lcom/google/firebase/FirebaseException;
    //   412: invokestatic forException : (Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   415: putfield zzd : Lcom/google/android/gms/tasks/Task;
    //   418: return
  }
  
  public final Task<AuthResult> zzb() {
    return (DefaultClock.getInstance().currentTimeMillis() - this.zze < zza) ? this.zzd : null;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */