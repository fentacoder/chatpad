package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.DefaultClock;

public class FederatedSignInActivity extends FragmentActivity {
  private static long zza;
  
  private static final zzam zzc = zzam.zza();
  
  private static Handler zzd;
  
  private static Runnable zze;
  
  private boolean zzb = false;
  
  private final void zza() {
    zza = 0L;
    this.zzb = false;
    Intent intent = new Intent();
    intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
    intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
    if (!LocalBroadcastManager.getInstance((Context)this).sendBroadcast(intent)) {
      zzas.zza((Context)this, zzy.zza("WEB_CONTEXT_CANCELED"));
    } else {
      zzc.zza((Context)this);
    } 
    finish();
  }
  
  private final void zza(Status paramStatus) {
    zza = 0L;
    this.zzb = false;
    Intent intent = new Intent();
    zzay.zza(intent, paramStatus);
    intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
    if (!LocalBroadcastManager.getInstance((Context)this).sendBroadcast(intent)) {
      zzas.zza(getApplicationContext(), paramStatus);
    } else {
      zzc.zza((Context)this);
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    String str1;
    super.onCreate(paramBundle);
    String str2 = getIntent().getAction();
    if (!"com.google.firebase.auth.internal.SIGN_IN".equals(str2) && !"com.google.firebase.auth.internal.LINK".equals(str2) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(str2)) {
      str1 = String.valueOf(str2);
      if (str1.length() != 0) {
        str1 = "Could not do operation - unknown action: ".concat(str1);
      } else {
        str1 = new String("Could not do operation - unknown action: ");
      } 
      Log.e("IdpSignInActivity", str1);
      zza();
      return;
    } 
    long l = DefaultClock.getInstance().currentTimeMillis();
    if (l - zza < 30000L) {
      Log.e("IdpSignInActivity", "Could not start operation - already in progress");
      return;
    } 
    zza = l;
    if (str1 != null)
      this.zzb = str1.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN"); 
  }
  
  public void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    Handler handler = zzd;
    if (handler != null) {
      Runnable runnable = zze;
      if (runnable != null) {
        handler.removeCallbacks(runnable);
        zze = null;
      } 
    } 
    setIntent(paramIntent);
  }
  
  protected void onResume() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial onResume : ()V
    //   4: aload_0
    //   5: invokevirtual getIntent : ()Landroid/content/Intent;
    //   8: astore_1
    //   9: ldc 'com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED'
    //   11: aload_1
    //   12: invokevirtual getAction : ()Ljava/lang/String;
    //   15: invokevirtual equals : (Ljava/lang/Object;)Z
    //   18: istore_2
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_2
    //   22: ifeq -> 61
    //   25: ldc 'IdpSignInActivity'
    //   27: ldc 'Web sign-in failed, finishing'
    //   29: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: aload_1
    //   34: invokestatic zza : (Landroid/content/Intent;)Z
    //   37: ifeq -> 51
    //   40: aload_0
    //   41: aload_1
    //   42: invokestatic zzb : (Landroid/content/Intent;)Lcom/google/android/gms/common/api/Status;
    //   45: invokespecial zza : (Lcom/google/android/gms/common/api/Status;)V
    //   48: goto -> 55
    //   51: aload_0
    //   52: invokespecial zza : ()V
    //   55: iconst_1
    //   56: istore #4
    //   58: goto -> 240
    //   61: iload_3
    //   62: istore #4
    //   64: aload_1
    //   65: ldc 'com.google.firebase.auth.internal.OPERATION'
    //   67: invokevirtual hasExtra : (Ljava/lang/String;)Z
    //   70: ifeq -> 240
    //   73: iload_3
    //   74: istore #4
    //   76: aload_1
    //   77: ldc 'com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST'
    //   79: invokevirtual hasExtra : (Ljava/lang/String;)Z
    //   82: ifeq -> 240
    //   85: aload_1
    //   86: ldc 'com.google.firebase.auth.internal.OPERATION'
    //   88: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   91: astore #5
    //   93: ldc 'com.google.firebase.auth.internal.SIGN_IN'
    //   95: aload #5
    //   97: invokevirtual equals : (Ljava/lang/Object;)Z
    //   100: ifne -> 126
    //   103: ldc 'com.google.firebase.auth.internal.LINK'
    //   105: aload #5
    //   107: invokevirtual equals : (Ljava/lang/Object;)Z
    //   110: ifne -> 126
    //   113: iload_3
    //   114: istore #4
    //   116: ldc 'com.google.firebase.auth.internal.REAUTHENTICATE'
    //   118: aload #5
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifeq -> 240
    //   126: aload_1
    //   127: ldc 'com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST'
    //   129: getstatic com/google/android/gms/internal/firebase_auth/zzfy.CREATOR : Landroid/os/Parcelable$Creator;
    //   132: invokestatic deserializeFromIntentExtra : (Landroid/content/Intent;Ljava/lang/String;Landroid/os/Parcelable$Creator;)Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;
    //   135: checkcast com/google/android/gms/internal/firebase_auth/zzfy
    //   138: astore #6
    //   140: aload_1
    //   141: ldc 'com.google.firebase.auth.internal.EXTRA_TENANT_ID'
    //   143: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   146: astore_1
    //   147: aload #6
    //   149: aload_1
    //   150: invokevirtual zzb : (Ljava/lang/String;)Lcom/google/android/gms/internal/firebase_auth/zzfy;
    //   153: pop
    //   154: lconst_0
    //   155: putstatic com/google/firebase/auth/internal/FederatedSignInActivity.zza : J
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield zzb : Z
    //   163: new android/content/Intent
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: astore #7
    //   172: aload #6
    //   174: aload #7
    //   176: ldc 'com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST'
    //   178: invokestatic serializeToIntentExtra : (Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;Landroid/content/Intent;Ljava/lang/String;)V
    //   181: aload #7
    //   183: ldc 'com.google.firebase.auth.internal.OPERATION'
    //   185: aload #5
    //   187: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   190: pop
    //   191: aload #7
    //   193: ldc 'com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT'
    //   195: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   198: pop
    //   199: aload_0
    //   200: invokestatic getInstance : (Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;
    //   203: aload #7
    //   205: invokevirtual sendBroadcast : (Landroid/content/Intent;)Z
    //   208: ifne -> 226
    //   211: aload_0
    //   212: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   215: aload #6
    //   217: aload #5
    //   219: aload_1
    //   220: invokestatic zza : (Landroid/content/Context;Lcom/google/android/gms/internal/firebase_auth/zzfy;Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -> 233
    //   226: getstatic com/google/firebase/auth/internal/FederatedSignInActivity.zzc : Lcom/google/firebase/auth/internal/zzam;
    //   229: aload_0
    //   230: invokevirtual zza : (Landroid/content/Context;)V
    //   233: aload_0
    //   234: invokevirtual finish : ()V
    //   237: goto -> 55
    //   240: iload #4
    //   242: ifeq -> 246
    //   245: return
    //   246: aload_0
    //   247: getfield zzb : Z
    //   250: ifne -> 343
    //   253: new android/content/Intent
    //   256: dup
    //   257: ldc 'com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN'
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: astore #6
    //   264: aload #6
    //   266: ldc 'com.google.android.gms'
    //   268: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   271: pop
    //   272: aload #6
    //   274: aload_0
    //   275: invokevirtual getIntent : ()Landroid/content/Intent;
    //   278: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   281: invokevirtual putExtras : (Landroid/os/Bundle;)Landroid/content/Intent;
    //   284: pop
    //   285: aload #6
    //   287: ldc 'com.google.firebase.auth.internal.OPERATION'
    //   289: aload_0
    //   290: invokevirtual getIntent : ()Landroid/content/Intent;
    //   293: invokevirtual getAction : ()Ljava/lang/String;
    //   296: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   299: pop
    //   300: aload_0
    //   301: aload #6
    //   303: ldc 40963
    //   305: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   308: goto -> 337
    //   311: astore #6
    //   313: ldc 'IdpSignInActivity'
    //   315: ldc 'Could not launch web sign-in Intent. Google Play service is unavailable'
    //   317: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   320: pop
    //   321: aload_0
    //   322: new com/google/android/gms/common/api/Status
    //   325: dup
    //   326: sipush #17499
    //   329: ldc 'Could not launch web sign-in Intent. Google Play service is unavailable'
    //   331: invokespecial <init> : (ILjava/lang/String;)V
    //   334: invokespecial zza : (Lcom/google/android/gms/common/api/Status;)V
    //   337: aload_0
    //   338: iconst_1
    //   339: putfield zzb : Z
    //   342: return
    //   343: new com/google/firebase/auth/internal/zzan
    //   346: dup
    //   347: aload_0
    //   348: invokespecial <init> : (Lcom/google/firebase/auth/internal/FederatedSignInActivity;)V
    //   351: putstatic com/google/firebase/auth/internal/FederatedSignInActivity.zze : Ljava/lang/Runnable;
    //   354: getstatic com/google/firebase/auth/internal/FederatedSignInActivity.zzd : Landroid/os/Handler;
    //   357: ifnonnull -> 370
    //   360: new com/google/android/gms/internal/firebase_auth/zzj
    //   363: dup
    //   364: invokespecial <init> : ()V
    //   367: putstatic com/google/firebase/auth/internal/FederatedSignInActivity.zzd : Landroid/os/Handler;
    //   370: getstatic com/google/firebase/auth/internal/FederatedSignInActivity.zzd : Landroid/os/Handler;
    //   373: getstatic com/google/firebase/auth/internal/FederatedSignInActivity.zze : Ljava/lang/Runnable;
    //   376: ldc2_w 800
    //   379: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   382: pop
    //   383: return
    // Exception table:
    //   from	to	target	type
    //   300	308	311	android/content/ActivityNotFoundException
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzb);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\FederatedSignInActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */