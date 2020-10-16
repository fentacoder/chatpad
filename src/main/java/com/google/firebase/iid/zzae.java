package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.SparseArray;
import com.google.android.gms.internal.firebase_messaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzae implements ServiceConnection {
  int state = 0;
  
  final Messenger zzcd = new Messenger((Handler)new zze(Looper.getMainLooper(), new zzad(this)));
  
  zzah zzce;
  
  final Queue<zzaj<?>> zzcf = new ArrayDeque<>();
  
  final SparseArray<zzaj<?>> zzcg = new SparseArray();
  
  private zzae(zzac paramzzac) {}
  
  private final void zzy() {
    zzac.zzb(this.zzch).execute(new zzaf(this));
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_2
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'MessengerIpcClient'
    //   13: ldc 'Service connected'
    //   15: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_2
    //   20: ifnonnull -> 33
    //   23: aload_0
    //   24: iconst_0
    //   25: ldc 'Null service connection'
    //   27: invokevirtual zza : (ILjava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: new com/google/firebase/iid/zzah
    //   36: astore_1
    //   37: aload_1
    //   38: aload_2
    //   39: invokespecial <init> : (Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: aload_1
    //   44: putfield zzce : Lcom/google/firebase/iid/zzah;
    //   47: aload_0
    //   48: iconst_2
    //   49: putfield state : I
    //   52: aload_0
    //   53: invokespecial zzy : ()V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: iconst_0
    //   62: aload_1
    //   63: invokevirtual getMessage : ()Ljava/lang/String;
    //   66: invokevirtual zza : (ILjava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	72	finally
    //   23	30	72	finally
    //   33	47	59	android/os/RemoteException
    //   33	47	72	finally
    //   47	56	72	finally
    //   60	69	72	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_2
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 19
    //   11: ldc 'MessengerIpcClient'
    //   13: ldc 'Service disconnected'
    //   15: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: iconst_2
    //   21: ldc 'Service disconnected'
    //   23: invokevirtual zza : (ILjava/lang/String;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	29	finally
    //   19	26	29	finally
  }
  
  final void zza(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzcg : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual get : (I)Ljava/lang/Object;
    //   10: checkcast com/google/firebase/iid/zzaj
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 79
    //   18: new java/lang/StringBuilder
    //   21: astore_3
    //   22: aload_3
    //   23: bipush #31
    //   25: invokespecial <init> : (I)V
    //   28: aload_3
    //   29: ldc 'Timing out request: '
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: iload_1
    //   37: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 'MessengerIpcClient'
    //   43: aload_3
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: getfield zzcg : Landroid/util/SparseArray;
    //   55: iload_1
    //   56: invokevirtual remove : (I)V
    //   59: new com/google/firebase/iid/zzam
    //   62: astore_3
    //   63: aload_3
    //   64: iconst_3
    //   65: ldc 'Timed out waiting for response'
    //   67: invokespecial <init> : (ILjava/lang/String;)V
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual zza : (Lcom/google/firebase/iid/zzam;)V
    //   75: aload_0
    //   76: invokevirtual zzz : ()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	82	finally
    //   18	79	82	finally
  }
  
  final void zza(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'MessengerIpcClient'
    //   4: iconst_3
    //   5: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   8: ifeq -> 50
    //   11: aload_2
    //   12: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual length : ()I
    //   20: ifeq -> 33
    //   23: ldc 'Disconnected: '
    //   25: aload_3
    //   26: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: goto -> 43
    //   33: new java/lang/String
    //   36: dup
    //   37: ldc 'Disconnected: '
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: astore_3
    //   43: ldc 'MessengerIpcClient'
    //   45: aload_3
    //   46: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aload_0
    //   51: getfield state : I
    //   54: istore #4
    //   56: iload #4
    //   58: ifeq -> 272
    //   61: iload #4
    //   63: iconst_1
    //   64: if_icmpeq -> 138
    //   67: iload #4
    //   69: iconst_2
    //   70: if_icmpeq -> 138
    //   73: iload #4
    //   75: iconst_3
    //   76: if_icmpeq -> 130
    //   79: iload #4
    //   81: iconst_4
    //   82: if_icmpne -> 88
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: new java/lang/IllegalStateException
    //   91: astore_3
    //   92: aload_0
    //   93: getfield state : I
    //   96: istore_1
    //   97: new java/lang/StringBuilder
    //   100: astore_2
    //   101: aload_2
    //   102: bipush #26
    //   104: invokespecial <init> : (I)V
    //   107: aload_2
    //   108: ldc 'Unknown state: '
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: iload_1
    //   116: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: aload_2
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: invokespecial <init> : (Ljava/lang/String;)V
    //   128: aload_3
    //   129: athrow
    //   130: aload_0
    //   131: iconst_4
    //   132: putfield state : I
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: ldc 'MessengerIpcClient'
    //   140: iconst_2
    //   141: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   144: ifeq -> 155
    //   147: ldc 'MessengerIpcClient'
    //   149: ldc 'Unbinding service'
    //   151: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload_0
    //   156: iconst_4
    //   157: putfield state : I
    //   160: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   163: aload_0
    //   164: getfield zzch : Lcom/google/firebase/iid/zzac;
    //   167: invokestatic zza : (Lcom/google/firebase/iid/zzac;)Landroid/content/Context;
    //   170: aload_0
    //   171: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   174: new com/google/firebase/iid/zzam
    //   177: astore_3
    //   178: aload_3
    //   179: iload_1
    //   180: aload_2
    //   181: invokespecial <init> : (ILjava/lang/String;)V
    //   184: aload_0
    //   185: getfield zzcf : Ljava/util/Queue;
    //   188: invokeinterface iterator : ()Ljava/util/Iterator;
    //   193: astore_2
    //   194: aload_2
    //   195: invokeinterface hasNext : ()Z
    //   200: ifeq -> 219
    //   203: aload_2
    //   204: invokeinterface next : ()Ljava/lang/Object;
    //   209: checkcast com/google/firebase/iid/zzaj
    //   212: aload_3
    //   213: invokevirtual zza : (Lcom/google/firebase/iid/zzam;)V
    //   216: goto -> 194
    //   219: aload_0
    //   220: getfield zzcf : Ljava/util/Queue;
    //   223: invokeinterface clear : ()V
    //   228: iconst_0
    //   229: istore_1
    //   230: iload_1
    //   231: aload_0
    //   232: getfield zzcg : Landroid/util/SparseArray;
    //   235: invokevirtual size : ()I
    //   238: if_icmpge -> 262
    //   241: aload_0
    //   242: getfield zzcg : Landroid/util/SparseArray;
    //   245: iload_1
    //   246: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   249: checkcast com/google/firebase/iid/zzaj
    //   252: aload_3
    //   253: invokevirtual zza : (Lcom/google/firebase/iid/zzam;)V
    //   256: iinc #1, 1
    //   259: goto -> 230
    //   262: aload_0
    //   263: getfield zzcg : Landroid/util/SparseArray;
    //   266: invokevirtual clear : ()V
    //   269: aload_0
    //   270: monitorexit
    //   271: return
    //   272: new java/lang/IllegalStateException
    //   275: astore_2
    //   276: aload_2
    //   277: invokespecial <init> : ()V
    //   280: aload_2
    //   281: athrow
    //   282: astore_2
    //   283: aload_0
    //   284: monitorexit
    //   285: aload_2
    //   286: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	282	finally
    //   33	43	282	finally
    //   43	50	282	finally
    //   50	56	282	finally
    //   88	130	282	finally
    //   130	135	282	finally
    //   138	155	282	finally
    //   155	194	282	finally
    //   194	216	282	finally
    //   219	228	282	finally
    //   230	256	282	finally
    //   262	269	282	finally
    //   272	282	282	finally
  }
  
  final boolean zza(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield arg1 : I
    //   4: istore_2
    //   5: ldc 'MessengerIpcClient'
    //   7: iconst_3
    //   8: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   11: ifeq -> 47
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: bipush #41
    //   20: invokespecial <init> : (I)V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 'Received response to request: '
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 'MessengerIpcClient'
    //   39: aload_3
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield zzcg : Landroid/util/SparseArray;
    //   53: iload_2
    //   54: invokevirtual get : (I)Ljava/lang/Object;
    //   57: checkcast com/google/firebase/iid/zzaj
    //   60: astore_3
    //   61: aload_3
    //   62: ifnonnull -> 102
    //   65: new java/lang/StringBuilder
    //   68: astore_1
    //   69: aload_1
    //   70: bipush #50
    //   72: invokespecial <init> : (I)V
    //   75: aload_1
    //   76: ldc 'Received response for unknown request: '
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: iload_2
    //   84: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 'MessengerIpcClient'
    //   90: aload_1
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield zzcg : Landroid/util/SparseArray;
    //   106: iload_2
    //   107: invokevirtual remove : (I)V
    //   110: aload_0
    //   111: invokevirtual zzz : ()V
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: invokevirtual getData : ()Landroid/os/Bundle;
    //   120: astore_1
    //   121: aload_1
    //   122: ldc 'unsupported'
    //   124: iconst_0
    //   125: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   128: ifeq -> 149
    //   131: aload_3
    //   132: new com/google/firebase/iid/zzam
    //   135: dup
    //   136: iconst_4
    //   137: ldc_w 'Not supported by GmsCore'
    //   140: invokespecial <init> : (ILjava/lang/String;)V
    //   143: invokevirtual zza : (Lcom/google/firebase/iid/zzam;)V
    //   146: goto -> 154
    //   149: aload_3
    //   150: aload_1
    //   151: invokevirtual zzb : (Landroid/os/Bundle;)V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   49	61	156	finally
    //   65	100	156	finally
    //   102	116	156	finally
    //   157	159	156	finally
  }
  
  final void zzaa() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: iconst_1
    //   7: if_icmpne -> 18
    //   10: aload_0
    //   11: iconst_1
    //   12: ldc_w 'Timed out while binding'
    //   15: invokevirtual zza : (ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  final boolean zzb(zzaj paramzzaj) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 114
    //   11: iload_2
    //   12: iconst_1
    //   13: if_icmpeq -> 99
    //   16: iload_2
    //   17: iconst_2
    //   18: if_icmpeq -> 80
    //   21: iload_2
    //   22: iconst_3
    //   23: if_icmpeq -> 76
    //   26: iload_2
    //   27: iconst_4
    //   28: if_icmpne -> 34
    //   31: goto -> 76
    //   34: new java/lang/IllegalStateException
    //   37: astore_3
    //   38: aload_0
    //   39: getfield state : I
    //   42: istore_2
    //   43: new java/lang/StringBuilder
    //   46: astore_1
    //   47: aload_1
    //   48: bipush #26
    //   50: invokespecial <init> : (I)V
    //   53: aload_1
    //   54: ldc 'Unknown state: '
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: iload_2
    //   62: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual toString : ()Ljava/lang/String;
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: aload_3
    //   75: athrow
    //   76: aload_0
    //   77: monitorexit
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: getfield zzcf : Ljava/util/Queue;
    //   84: aload_1
    //   85: invokeinterface add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: aload_0
    //   92: invokespecial zzy : ()V
    //   95: aload_0
    //   96: monitorexit
    //   97: iconst_1
    //   98: ireturn
    //   99: aload_0
    //   100: getfield zzcf : Ljava/util/Queue;
    //   103: aload_1
    //   104: invokeinterface add : (Ljava/lang/Object;)Z
    //   109: pop
    //   110: aload_0
    //   111: monitorexit
    //   112: iconst_1
    //   113: ireturn
    //   114: aload_0
    //   115: getfield zzcf : Ljava/util/Queue;
    //   118: aload_1
    //   119: invokeinterface add : (Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_0
    //   126: getfield state : I
    //   129: ifne -> 138
    //   132: iconst_1
    //   133: istore #4
    //   135: goto -> 141
    //   138: iconst_0
    //   139: istore #4
    //   141: iload #4
    //   143: invokestatic checkState : (Z)V
    //   146: ldc 'MessengerIpcClient'
    //   148: iconst_2
    //   149: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   152: ifeq -> 164
    //   155: ldc 'MessengerIpcClient'
    //   157: ldc_w 'Starting bind to GmsCore'
    //   160: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield state : I
    //   169: new android/content/Intent
    //   172: astore_1
    //   173: aload_1
    //   174: ldc_w 'com.google.android.c2dm.intent.REGISTER'
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: aload_1
    //   181: ldc_w 'com.google.android.gms'
    //   184: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   187: pop
    //   188: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   191: aload_0
    //   192: getfield zzch : Lcom/google/firebase/iid/zzac;
    //   195: invokestatic zza : (Lcom/google/firebase/iid/zzac;)Landroid/content/Context;
    //   198: aload_1
    //   199: aload_0
    //   200: iconst_1
    //   201: invokevirtual bindService : (Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   204: ifne -> 218
    //   207: aload_0
    //   208: iconst_0
    //   209: ldc_w 'Unable to bind to service'
    //   212: invokevirtual zza : (ILjava/lang/String;)V
    //   215: goto -> 249
    //   218: aload_0
    //   219: getfield zzch : Lcom/google/firebase/iid/zzac;
    //   222: invokestatic zzb : (Lcom/google/firebase/iid/zzac;)Ljava/util/concurrent/ScheduledExecutorService;
    //   225: astore_3
    //   226: new com/google/firebase/iid/zzag
    //   229: astore_1
    //   230: aload_1
    //   231: aload_0
    //   232: invokespecial <init> : (Lcom/google/firebase/iid/zzae;)V
    //   235: aload_3
    //   236: aload_1
    //   237: ldc2_w 30
    //   240: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   243: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   248: pop
    //   249: aload_0
    //   250: monitorexit
    //   251: iconst_1
    //   252: ireturn
    //   253: astore_1
    //   254: aload_0
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	253	finally
    //   34	76	253	finally
    //   80	95	253	finally
    //   99	110	253	finally
    //   114	132	253	finally
    //   141	164	253	finally
    //   164	215	253	finally
    //   218	249	253	finally
  }
  
  final void zzz() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield state : I
    //   6: iconst_2
    //   7: if_icmpne -> 69
    //   10: aload_0
    //   11: getfield zzcf : Ljava/util/Queue;
    //   14: invokeinterface isEmpty : ()Z
    //   19: ifeq -> 69
    //   22: aload_0
    //   23: getfield zzcg : Landroid/util/SparseArray;
    //   26: invokevirtual size : ()I
    //   29: ifne -> 69
    //   32: ldc 'MessengerIpcClient'
    //   34: iconst_2
    //   35: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   38: ifeq -> 50
    //   41: ldc 'MessengerIpcClient'
    //   43: ldc_w 'Finished handling requests, unbinding'
    //   46: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aload_0
    //   51: iconst_3
    //   52: putfield state : I
    //   55: invokestatic getInstance : ()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   58: aload_0
    //   59: getfield zzch : Lcom/google/firebase/iid/zzac;
    //   62: invokestatic zza : (Lcom/google/firebase/iid/zzac;)Landroid/content/Context;
    //   65: aload_0
    //   66: invokevirtual unbindService : (Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	72	finally
    //   50	69	72	finally
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */