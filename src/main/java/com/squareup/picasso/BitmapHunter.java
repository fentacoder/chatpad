package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

class BitmapHunter implements Runnable {
  private static final Object DECODE_LOCK = new Object();
  
  private static final RequestHandler ERRORING_HANDLER;
  
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
      protected StringBuilder initialValue() {
        return new StringBuilder("Picasso-");
      }
    };
  
  private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
  
  Action action;
  
  List<Action> actions;
  
  final Cache cache;
  
  final Request data;
  
  final Dispatcher dispatcher;
  
  Exception exception;
  
  int exifOrientation;
  
  Future<?> future;
  
  final String key;
  
  Picasso.LoadedFrom loadedFrom;
  
  final int memoryPolicy;
  
  int networkPolicy;
  
  final Picasso picasso;
  
  Picasso.Priority priority;
  
  final RequestHandler requestHandler;
  
  Bitmap result;
  
  int retryCount;
  
  final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
  
  final Stats stats;
  
  static {
    ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request param1Request) {
          return true;
        }
        
        public RequestHandler.Result load(Request param1Request, int param1Int) throws IOException {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unrecognized type of request: ");
          stringBuilder.append(param1Request);
          throw new IllegalStateException(stringBuilder.toString());
        }
      };
  }
  
  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, RequestHandler paramRequestHandler) {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.action = paramAction;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.priority = paramAction.getPriority();
    this.memoryPolicy = paramAction.getMemoryPolicy();
    this.networkPolicy = paramAction.getNetworkPolicy();
    this.requestHandler = paramRequestHandler;
    this.retryCount = paramRequestHandler.getRetryCount();
  }
  
  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap) {
    Bitmap bitmap;
    int i = paramList.size();
    byte b = 0;
    while (b < i) {
      final Transformation transformation = paramList.get(b);
      try {
        final StringBuilder builder;
        Bitmap bitmap1 = transformation.transform(paramBitmap);
        if (bitmap1 == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Transformation ");
          stringBuilder.append(transformation.key());
          stringBuilder.append(" returned null after ");
          stringBuilder.append(b);
          stringBuilder.append(" previous transformation(s).\n\nTransformation list:\n");
          Iterator<Transformation> iterator = paramList.iterator();
          while (iterator.hasNext()) {
            stringBuilder.append(((Transformation)iterator.next()).key());
            stringBuilder.append('\n');
          } 
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  throw new NullPointerException(builder.toString());
                }
              });
          return null;
        } 
        if (bitmap1 == stringBuilder && stringBuilder.isRecycled()) {
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Transformation ");
                  stringBuilder.append(transformation.key());
                  stringBuilder.append(" returned input Bitmap but recycled it.");
                  throw new IllegalStateException(stringBuilder.toString());
                }
              });
          return null;
        } 
        if (bitmap1 != stringBuilder && !stringBuilder.isRecycled()) {
          Picasso.HANDLER.post(new Runnable() {
                public void run() {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Transformation ");
                  stringBuilder.append(transformation.key());
                  stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                  throw new IllegalStateException(stringBuilder.toString());
                }
              });
          return null;
        } 
        b++;
        bitmap = bitmap1;
      } catch (RuntimeException runtimeException) {
        Picasso.HANDLER.post(new Runnable() {
              public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Transformation ");
                stringBuilder.append(transformation.key());
                stringBuilder.append(" crashed with exception.");
                throw new RuntimeException(stringBuilder.toString(), e);
              }
            });
        return null;
      } 
    } 
    return bitmap;
  }
  
  private Picasso.Priority computeNewPriority() {
    byte b3;
    Picasso.Priority priority1 = Picasso.Priority.LOW;
    List<Action> list = this.actions;
    byte b1 = 1;
    byte b2 = 0;
    if (list != null && !list.isEmpty()) {
      b3 = 1;
    } else {
      b3 = 0;
    } 
    int i = b1;
    if (this.action == null)
      if (b3) {
        i = b1;
      } else {
        i = 0;
      }  
    if (!i)
      return priority1; 
    Action action = this.action;
    if (action != null)
      priority1 = action.getPriority(); 
    Picasso.Priority priority2 = priority1;
    if (b3) {
      i = this.actions.size();
      b3 = b2;
      while (true) {
        priority2 = priority1;
        if (b3 < i) {
          Picasso.Priority priority = ((Action)this.actions.get(b3)).getPriority();
          priority2 = priority1;
          if (priority.ordinal() > priority1.ordinal())
            priority2 = priority; 
          b3++;
          priority1 = priority2;
          continue;
        } 
        break;
      } 
    } 
    return priority2;
  }
  
  static Bitmap decodeStream(Source paramSource, Request paramRequest) throws IOException {
    byte[] arrayOfByte;
    boolean bool;
    BufferedSource bufferedSource = Okio.buffer(paramSource);
    boolean bool1 = Utils.isWebPFile(bufferedSource);
    if (paramRequest.purgeable && Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    } 
    BitmapFactory.Options options = RequestHandler.createBitmapOptions(paramRequest);
    boolean bool2 = RequestHandler.requiresInSampleSize(options);
    if (bool1 || bool) {
      arrayOfByte = bufferedSource.readByteArray();
      if (bool2) {
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
        RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      } 
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, options);
    } 
    InputStream inputStream2 = arrayOfByte.inputStream();
    InputStream inputStream1 = inputStream2;
    if (bool2) {
      inputStream1 = new MarkableInputStream(inputStream2);
      inputStream1.allowMarksToExpire(false);
      long l = inputStream1.savePosition(1024);
      BitmapFactory.decodeStream(inputStream1, null, options);
      RequestHandler.calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, options, paramRequest);
      inputStream1.reset(l);
      inputStream1.allowMarksToExpire(true);
    } 
    Bitmap bitmap = BitmapFactory.decodeStream(inputStream1, null, options);
    if (bitmap != null)
      return bitmap; 
    throw new IOException("Failed to decode stream.");
  }
  
  static BitmapHunter forRequest(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction) {
    Request request = paramAction.getRequest();
    List<RequestHandler> list = paramPicasso.getRequestHandlers();
    int i = list.size();
    for (byte b = 0; b < i; b++) {
      RequestHandler requestHandler = list.get(b);
      if (requestHandler.canHandleRequest(request))
        return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, requestHandler); 
    } 
    return new BitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, ERRORING_HANDLER);
  }
  
  static int getExifRotation(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 7:
      case 8:
        return 270;
      case 5:
      case 6:
        return 90;
      case 3:
      case 4:
        break;
    } 
    return 180;
  }
  
  static int getExifTranslation(int paramInt) {
    if (paramInt != 2 && paramInt != 7 && paramInt != 4 && paramInt != 5) {
      paramInt = 1;
    } else {
      paramInt = -1;
    } 
    return paramInt;
  }
  
  private static boolean shouldResize(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (!paramBoolean || (paramInt3 != 0 && paramInt1 > paramInt3) || (paramInt4 != 0 && paramInt2 > paramInt4));
  }
  
  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getWidth : ()I
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual getHeight : ()I
    //   9: istore #4
    //   11: aload_0
    //   12: getfield onlyScaleDown : Z
    //   15: istore #5
    //   17: new android/graphics/Matrix
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #6
    //   26: aload_0
    //   27: invokevirtual needsMatrixTransform : ()Z
    //   30: ifne -> 52
    //   33: iload_2
    //   34: ifeq -> 40
    //   37: goto -> 52
    //   40: iload #4
    //   42: istore #7
    //   44: aload #6
    //   46: astore_0
    //   47: iload_3
    //   48: istore_2
    //   49: goto -> 1251
    //   52: aload_0
    //   53: getfield targetWidth : I
    //   56: istore #7
    //   58: aload_0
    //   59: getfield targetHeight : I
    //   62: istore #8
    //   64: aload_0
    //   65: getfield rotationDegrees : F
    //   68: fstore #9
    //   70: fload #9
    //   72: fconst_0
    //   73: fcmpl
    //   74: ifeq -> 552
    //   77: fload #9
    //   79: f2d
    //   80: dstore #10
    //   82: dload #10
    //   84: invokestatic toRadians : (D)D
    //   87: invokestatic cos : (D)D
    //   90: dstore #12
    //   92: dload #10
    //   94: invokestatic toRadians : (D)D
    //   97: invokestatic sin : (D)D
    //   100: dstore #10
    //   102: aload_0
    //   103: getfield hasRotationPivot : Z
    //   106: ifeq -> 369
    //   109: aload #6
    //   111: fload #9
    //   113: aload_0
    //   114: getfield rotationPivotX : F
    //   117: aload_0
    //   118: getfield rotationPivotY : F
    //   121: invokevirtual setRotate : (FFF)V
    //   124: aload_0
    //   125: getfield rotationPivotX : F
    //   128: f2d
    //   129: dstore #14
    //   131: dconst_1
    //   132: dload #12
    //   134: dsub
    //   135: dstore #16
    //   137: dload #14
    //   139: dload #16
    //   141: dmul
    //   142: aload_0
    //   143: getfield rotationPivotY : F
    //   146: f2d
    //   147: dload #10
    //   149: dmul
    //   150: dadd
    //   151: dstore #18
    //   153: aload_0
    //   154: getfield rotationPivotY : F
    //   157: f2d
    //   158: dload #16
    //   160: dmul
    //   161: aload_0
    //   162: getfield rotationPivotX : F
    //   165: f2d
    //   166: dload #10
    //   168: dmul
    //   169: dsub
    //   170: dstore #14
    //   172: aload_0
    //   173: getfield targetWidth : I
    //   176: i2d
    //   177: dload #12
    //   179: dmul
    //   180: dload #18
    //   182: dadd
    //   183: dstore #20
    //   185: aload_0
    //   186: getfield targetWidth : I
    //   189: i2d
    //   190: dload #10
    //   192: dmul
    //   193: dload #14
    //   195: dadd
    //   196: dstore #22
    //   198: aload_0
    //   199: getfield targetWidth : I
    //   202: i2d
    //   203: dload #12
    //   205: dmul
    //   206: dload #18
    //   208: dadd
    //   209: aload_0
    //   210: getfield targetHeight : I
    //   213: i2d
    //   214: dload #10
    //   216: dmul
    //   217: dsub
    //   218: dstore #24
    //   220: aload_0
    //   221: getfield targetWidth : I
    //   224: i2d
    //   225: dload #10
    //   227: dmul
    //   228: dload #14
    //   230: dadd
    //   231: aload_0
    //   232: getfield targetHeight : I
    //   235: i2d
    //   236: dload #12
    //   238: dmul
    //   239: dadd
    //   240: dstore #16
    //   242: dload #18
    //   244: aload_0
    //   245: getfield targetHeight : I
    //   248: i2d
    //   249: dload #10
    //   251: dmul
    //   252: dsub
    //   253: dstore #26
    //   255: aload_0
    //   256: getfield targetHeight : I
    //   259: i2d
    //   260: dload #12
    //   262: dmul
    //   263: dload #14
    //   265: dadd
    //   266: dstore #10
    //   268: dload #26
    //   270: dload #24
    //   272: dload #18
    //   274: dload #20
    //   276: invokestatic max : (DD)D
    //   279: invokestatic max : (DD)D
    //   282: invokestatic max : (DD)D
    //   285: dstore #12
    //   287: dload #26
    //   289: dload #24
    //   291: dload #18
    //   293: dload #20
    //   295: invokestatic min : (DD)D
    //   298: invokestatic min : (DD)D
    //   301: invokestatic min : (DD)D
    //   304: dstore #18
    //   306: dload #10
    //   308: dload #16
    //   310: dload #14
    //   312: dload #22
    //   314: invokestatic max : (DD)D
    //   317: invokestatic max : (DD)D
    //   320: invokestatic max : (DD)D
    //   323: dstore #24
    //   325: dload #10
    //   327: dload #16
    //   329: dload #14
    //   331: dload #22
    //   333: invokestatic min : (DD)D
    //   336: invokestatic min : (DD)D
    //   339: invokestatic min : (DD)D
    //   342: dstore #10
    //   344: dload #12
    //   346: dload #18
    //   348: dsub
    //   349: invokestatic floor : (D)D
    //   352: d2i
    //   353: istore #7
    //   355: dload #24
    //   357: dload #10
    //   359: dsub
    //   360: invokestatic floor : (D)D
    //   363: d2i
    //   364: istore #8
    //   366: goto -> 552
    //   369: aload #6
    //   371: fload #9
    //   373: invokevirtual setRotate : (F)V
    //   376: aload_0
    //   377: getfield targetWidth : I
    //   380: i2d
    //   381: dload #12
    //   383: dmul
    //   384: dstore #18
    //   386: aload_0
    //   387: getfield targetWidth : I
    //   390: i2d
    //   391: dload #10
    //   393: dmul
    //   394: dstore #14
    //   396: aload_0
    //   397: getfield targetWidth : I
    //   400: i2d
    //   401: dload #12
    //   403: dmul
    //   404: aload_0
    //   405: getfield targetHeight : I
    //   408: i2d
    //   409: dload #10
    //   411: dmul
    //   412: dsub
    //   413: dstore #22
    //   415: aload_0
    //   416: getfield targetWidth : I
    //   419: i2d
    //   420: dload #10
    //   422: dmul
    //   423: aload_0
    //   424: getfield targetHeight : I
    //   427: i2d
    //   428: dload #12
    //   430: dmul
    //   431: dadd
    //   432: dstore #16
    //   434: aload_0
    //   435: getfield targetHeight : I
    //   438: i2d
    //   439: dload #10
    //   441: dmul
    //   442: dneg
    //   443: dstore #24
    //   445: aload_0
    //   446: getfield targetHeight : I
    //   449: i2d
    //   450: dload #12
    //   452: dmul
    //   453: dstore #10
    //   455: dload #24
    //   457: dload #22
    //   459: dconst_0
    //   460: dload #18
    //   462: invokestatic max : (DD)D
    //   465: invokestatic max : (DD)D
    //   468: invokestatic max : (DD)D
    //   471: dstore #12
    //   473: dload #24
    //   475: dload #22
    //   477: dconst_0
    //   478: dload #18
    //   480: invokestatic min : (DD)D
    //   483: invokestatic min : (DD)D
    //   486: invokestatic min : (DD)D
    //   489: dstore #18
    //   491: dload #10
    //   493: dload #16
    //   495: dconst_0
    //   496: dload #14
    //   498: invokestatic max : (DD)D
    //   501: invokestatic max : (DD)D
    //   504: invokestatic max : (DD)D
    //   507: dstore #22
    //   509: dload #10
    //   511: dload #16
    //   513: dconst_0
    //   514: dload #14
    //   516: invokestatic min : (DD)D
    //   519: invokestatic min : (DD)D
    //   522: invokestatic min : (DD)D
    //   525: dstore #10
    //   527: dload #12
    //   529: dload #18
    //   531: dsub
    //   532: invokestatic floor : (D)D
    //   535: d2i
    //   536: istore #7
    //   538: dload #22
    //   540: dload #10
    //   542: dsub
    //   543: invokestatic floor : (D)D
    //   546: d2i
    //   547: istore #8
    //   549: goto -> 552
    //   552: iload_2
    //   553: ifeq -> 654
    //   556: iload_2
    //   557: invokestatic getExifRotation : (I)I
    //   560: istore #28
    //   562: iload_2
    //   563: invokestatic getExifTranslation : (I)I
    //   566: istore #29
    //   568: iload #28
    //   570: ifeq -> 614
    //   573: aload #6
    //   575: iload #28
    //   577: i2f
    //   578: invokevirtual preRotate : (F)Z
    //   581: pop
    //   582: iload #28
    //   584: bipush #90
    //   586: if_icmpeq -> 604
    //   589: iload #7
    //   591: istore_2
    //   592: iload #8
    //   594: istore #30
    //   596: iload #28
    //   598: sipush #270
    //   601: if_icmpne -> 621
    //   604: iload #8
    //   606: istore_2
    //   607: iload #7
    //   609: istore #30
    //   611: goto -> 621
    //   614: iload #8
    //   616: istore #30
    //   618: iload #7
    //   620: istore_2
    //   621: iload_2
    //   622: istore #31
    //   624: iload #30
    //   626: istore #28
    //   628: iload #29
    //   630: iconst_1
    //   631: if_icmpeq -> 662
    //   634: aload #6
    //   636: iload #29
    //   638: i2f
    //   639: fconst_1
    //   640: invokevirtual postScale : (FF)Z
    //   643: pop
    //   644: iload_2
    //   645: istore #31
    //   647: iload #30
    //   649: istore #28
    //   651: goto -> 662
    //   654: iload #8
    //   656: istore #28
    //   658: iload #7
    //   660: istore #31
    //   662: aload_0
    //   663: getfield centerCrop : Z
    //   666: ifeq -> 963
    //   669: iload #31
    //   671: ifeq -> 685
    //   674: iload #31
    //   676: i2f
    //   677: iload_3
    //   678: i2f
    //   679: fdiv
    //   680: fstore #9
    //   682: goto -> 694
    //   685: iload #28
    //   687: i2f
    //   688: iload #4
    //   690: i2f
    //   691: fdiv
    //   692: fstore #9
    //   694: iload #28
    //   696: ifeq -> 712
    //   699: iload #28
    //   701: i2f
    //   702: fstore #32
    //   704: iload #4
    //   706: i2f
    //   707: fstore #33
    //   709: goto -> 721
    //   712: iload #31
    //   714: i2f
    //   715: fstore #32
    //   717: iload_3
    //   718: i2f
    //   719: fstore #33
    //   721: fload #32
    //   723: fload #33
    //   725: fdiv
    //   726: fstore #32
    //   728: fload #9
    //   730: fload #32
    //   732: fcmpl
    //   733: ifle -> 826
    //   736: iload #4
    //   738: i2f
    //   739: fload #32
    //   741: fload #9
    //   743: fdiv
    //   744: fmul
    //   745: f2d
    //   746: invokestatic ceil : (D)D
    //   749: d2i
    //   750: istore #7
    //   752: aload_0
    //   753: getfield centerCropGravity : I
    //   756: bipush #48
    //   758: iand
    //   759: bipush #48
    //   761: if_icmpne -> 770
    //   764: iconst_0
    //   765: istore #30
    //   767: goto -> 801
    //   770: aload_0
    //   771: getfield centerCropGravity : I
    //   774: bipush #80
    //   776: iand
    //   777: bipush #80
    //   779: if_icmpne -> 792
    //   782: iload #4
    //   784: iload #7
    //   786: isub
    //   787: istore #30
    //   789: goto -> 801
    //   792: iload #4
    //   794: iload #7
    //   796: isub
    //   797: iconst_2
    //   798: idiv
    //   799: istore #30
    //   801: iload #28
    //   803: i2f
    //   804: iload #7
    //   806: i2f
    //   807: fdiv
    //   808: fstore #33
    //   810: iload_3
    //   811: istore #8
    //   813: iconst_0
    //   814: istore_2
    //   815: fload #9
    //   817: fstore #32
    //   819: fload #33
    //   821: fstore #9
    //   823: goto -> 932
    //   826: fload #9
    //   828: fload #32
    //   830: fcmpg
    //   831: ifge -> 916
    //   834: iload_3
    //   835: i2f
    //   836: fload #9
    //   838: fload #32
    //   840: fdiv
    //   841: fmul
    //   842: f2d
    //   843: invokestatic ceil : (D)D
    //   846: d2i
    //   847: istore #8
    //   849: aload_0
    //   850: getfield centerCropGravity : I
    //   853: iconst_3
    //   854: iand
    //   855: iconst_3
    //   856: if_icmpne -> 864
    //   859: iconst_0
    //   860: istore_2
    //   861: goto -> 889
    //   864: aload_0
    //   865: getfield centerCropGravity : I
    //   868: iconst_5
    //   869: iand
    //   870: iconst_5
    //   871: if_icmpne -> 882
    //   874: iload_3
    //   875: iload #8
    //   877: isub
    //   878: istore_2
    //   879: goto -> 889
    //   882: iload_3
    //   883: iload #8
    //   885: isub
    //   886: iconst_2
    //   887: idiv
    //   888: istore_2
    //   889: iload #31
    //   891: i2f
    //   892: iload #8
    //   894: i2f
    //   895: fdiv
    //   896: fstore #33
    //   898: iload #4
    //   900: istore #7
    //   902: iconst_0
    //   903: istore #30
    //   905: fload #32
    //   907: fstore #9
    //   909: fload #33
    //   911: fstore #32
    //   913: goto -> 932
    //   916: iload_3
    //   917: istore #8
    //   919: iload #4
    //   921: istore #7
    //   923: fload #32
    //   925: fstore #9
    //   927: iconst_0
    //   928: istore #30
    //   930: iconst_0
    //   931: istore_2
    //   932: iload #5
    //   934: iload_3
    //   935: iload #4
    //   937: iload #31
    //   939: iload #28
    //   941: invokestatic shouldResize : (ZIIII)Z
    //   944: ifeq -> 957
    //   947: aload #6
    //   949: fload #32
    //   951: fload #9
    //   953: invokevirtual preScale : (FF)Z
    //   956: pop
    //   957: aload #6
    //   959: astore_0
    //   960: goto -> 1263
    //   963: aload_0
    //   964: getfield centerInside : Z
    //   967: ifeq -> 1099
    //   970: iload #31
    //   972: ifeq -> 987
    //   975: iload #31
    //   977: i2f
    //   978: fstore #9
    //   980: iload_3
    //   981: i2f
    //   982: fstore #32
    //   984: goto -> 997
    //   987: iload #28
    //   989: i2f
    //   990: fstore #9
    //   992: iload #4
    //   994: i2f
    //   995: fstore #32
    //   997: fload #9
    //   999: fload #32
    //   1001: fdiv
    //   1002: fstore #33
    //   1004: iload #28
    //   1006: ifeq -> 1022
    //   1009: iload #28
    //   1011: i2f
    //   1012: fstore #32
    //   1014: iload #4
    //   1016: i2f
    //   1017: fstore #9
    //   1019: goto -> 1031
    //   1022: iload #31
    //   1024: i2f
    //   1025: fstore #32
    //   1027: iload_3
    //   1028: i2f
    //   1029: fstore #9
    //   1031: fload #32
    //   1033: fload #9
    //   1035: fdiv
    //   1036: fstore #9
    //   1038: fload #33
    //   1040: fload #9
    //   1042: fcmpg
    //   1043: ifge -> 1053
    //   1046: fload #33
    //   1048: fstore #9
    //   1050: goto -> 1053
    //   1053: iload_3
    //   1054: istore_2
    //   1055: aload #6
    //   1057: astore_0
    //   1058: iload #4
    //   1060: istore #7
    //   1062: iload #5
    //   1064: iload_3
    //   1065: iload #4
    //   1067: iload #31
    //   1069: iload #28
    //   1071: invokestatic shouldResize : (ZIIII)Z
    //   1074: ifeq -> 1251
    //   1077: aload #6
    //   1079: fload #9
    //   1081: fload #9
    //   1083: invokevirtual preScale : (FF)Z
    //   1086: pop
    //   1087: iload_3
    //   1088: istore_2
    //   1089: aload #6
    //   1091: astore_0
    //   1092: iload #4
    //   1094: istore #7
    //   1096: goto -> 1251
    //   1099: iload #31
    //   1101: ifne -> 1118
    //   1104: iload_3
    //   1105: istore_2
    //   1106: aload #6
    //   1108: astore_0
    //   1109: iload #4
    //   1111: istore #7
    //   1113: iload #28
    //   1115: ifeq -> 1251
    //   1118: iload #31
    //   1120: iload_3
    //   1121: if_icmpne -> 1140
    //   1124: iload_3
    //   1125: istore_2
    //   1126: aload #6
    //   1128: astore_0
    //   1129: iload #4
    //   1131: istore #7
    //   1133: iload #28
    //   1135: iload #4
    //   1137: if_icmpeq -> 1251
    //   1140: iload #31
    //   1142: ifeq -> 1157
    //   1145: iload #31
    //   1147: i2f
    //   1148: fstore #9
    //   1150: iload_3
    //   1151: i2f
    //   1152: fstore #32
    //   1154: goto -> 1167
    //   1157: iload #28
    //   1159: i2f
    //   1160: fstore #9
    //   1162: iload #4
    //   1164: i2f
    //   1165: fstore #32
    //   1167: fload #9
    //   1169: fload #32
    //   1171: fdiv
    //   1172: fstore #33
    //   1174: iload #28
    //   1176: ifeq -> 1192
    //   1179: iload #28
    //   1181: i2f
    //   1182: fstore #32
    //   1184: iload #4
    //   1186: i2f
    //   1187: fstore #9
    //   1189: goto -> 1201
    //   1192: iload #31
    //   1194: i2f
    //   1195: fstore #32
    //   1197: iload_3
    //   1198: i2f
    //   1199: fstore #9
    //   1201: fload #32
    //   1203: fload #9
    //   1205: fdiv
    //   1206: fstore #9
    //   1208: iload_3
    //   1209: istore_2
    //   1210: aload #6
    //   1212: astore_0
    //   1213: iload #4
    //   1215: istore #7
    //   1217: iload #5
    //   1219: iload_3
    //   1220: iload #4
    //   1222: iload #31
    //   1224: iload #28
    //   1226: invokestatic shouldResize : (ZIIII)Z
    //   1229: ifeq -> 1251
    //   1232: aload #6
    //   1234: fload #33
    //   1236: fload #9
    //   1238: invokevirtual preScale : (FF)Z
    //   1241: pop
    //   1242: iload #4
    //   1244: istore #7
    //   1246: aload #6
    //   1248: astore_0
    //   1249: iload_3
    //   1250: istore_2
    //   1251: iconst_0
    //   1252: istore #4
    //   1254: iconst_0
    //   1255: istore #30
    //   1257: iload_2
    //   1258: istore #8
    //   1260: iload #4
    //   1262: istore_2
    //   1263: aload_1
    //   1264: iload_2
    //   1265: iload #30
    //   1267: iload #8
    //   1269: iload #7
    //   1271: aload_0
    //   1272: iconst_1
    //   1273: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   1276: astore_0
    //   1277: aload_0
    //   1278: aload_1
    //   1279: if_acmpeq -> 1289
    //   1282: aload_1
    //   1283: invokevirtual recycle : ()V
    //   1286: goto -> 1291
    //   1289: aload_1
    //   1290: astore_0
    //   1291: aload_0
    //   1292: areturn
  }
  
  static void updateThreadName(Request paramRequest) {
    String str = paramRequest.getName();
    StringBuilder stringBuilder = NAME_BUILDER.get();
    stringBuilder.ensureCapacity(str.length() + 8);
    stringBuilder.replace(8, stringBuilder.length(), str);
    Thread.currentThread().setName(stringBuilder.toString());
  }
  
  void attach(Action paramAction) {
    List<Action> list;
    boolean bool = this.picasso.loggingEnabled;
    Request request = paramAction.request;
    if (this.action == null) {
      this.action = paramAction;
      if (bool) {
        list = this.actions;
        if (list == null || list.isEmpty()) {
          Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
          return;
        } 
        Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
      } 
      return;
    } 
    if (this.actions == null)
      this.actions = new ArrayList<>(3); 
    this.actions.add(list);
    if (bool)
      Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to ")); 
    Picasso.Priority priority = list.getPriority();
    if (priority.ordinal() > this.priority.ordinal())
      this.priority = priority; 
  }
  
  boolean cancel() {
    // Byte code:
    //   0: aload_0
    //   1: getfield action : Lcom/squareup/picasso/Action;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_2
    //   8: istore_3
    //   9: aload_1
    //   10: ifnonnull -> 58
    //   13: aload_0
    //   14: getfield actions : Ljava/util/List;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull -> 33
    //   22: iload_2
    //   23: istore_3
    //   24: aload_1
    //   25: invokeinterface isEmpty : ()Z
    //   30: ifeq -> 58
    //   33: aload_0
    //   34: getfield future : Ljava/util/concurrent/Future;
    //   37: astore_1
    //   38: iload_2
    //   39: istore_3
    //   40: aload_1
    //   41: ifnull -> 58
    //   44: iload_2
    //   45: istore_3
    //   46: aload_1
    //   47: iconst_0
    //   48: invokeinterface cancel : (Z)Z
    //   53: ifeq -> 58
    //   56: iconst_1
    //   57: istore_3
    //   58: iload_3
    //   59: ireturn
  }
  
  void detach(Action paramAction) {
    boolean bool;
    if (this.action == paramAction) {
      this.action = null;
      bool = true;
    } else {
      List<Action> list = this.actions;
      if (list != null) {
        bool = list.remove(paramAction);
      } else {
        bool = false;
      } 
    } 
    if (bool && paramAction.getPriority() == this.priority)
      this.priority = computeNewPriority(); 
    if (this.picasso.loggingEnabled)
      Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from ")); 
  }
  
  Action getAction() {
    return this.action;
  }
  
  List<Action> getActions() {
    return this.actions;
  }
  
  Request getData() {
    return this.data;
  }
  
  Exception getException() {
    return this.exception;
  }
  
  String getKey() {
    return this.key;
  }
  
  Picasso.LoadedFrom getLoadedFrom() {
    return this.loadedFrom;
  }
  
  int getMemoryPolicy() {
    return this.memoryPolicy;
  }
  
  Picasso getPicasso() {
    return this.picasso;
  }
  
  Picasso.Priority getPriority() {
    return this.priority;
  }
  
  Bitmap getResult() {
    return this.result;
  }
  
  Bitmap hunt() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield memoryPolicy : I
    //   4: invokestatic shouldReadFromMemoryCache : (I)Z
    //   7: ifeq -> 75
    //   10: aload_0
    //   11: getfield cache : Lcom/squareup/picasso/Cache;
    //   14: aload_0
    //   15: getfield key : Ljava/lang/String;
    //   18: invokeinterface get : (Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull -> 77
    //   30: aload_0
    //   31: getfield stats : Lcom/squareup/picasso/Stats;
    //   34: invokevirtual dispatchCacheHit : ()V
    //   37: aload_0
    //   38: getstatic com/squareup/picasso/Picasso$LoadedFrom.MEMORY : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   41: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   44: aload_0
    //   45: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   48: getfield loggingEnabled : Z
    //   51: ifeq -> 73
    //   54: ldc_w 'Hunter'
    //   57: ldc_w 'decoded'
    //   60: aload_0
    //   61: getfield data : Lcom/squareup/picasso/Request;
    //   64: invokevirtual logId : ()Ljava/lang/String;
    //   67: ldc_w 'from cache'
    //   70: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_1
    //   74: areturn
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_0
    //   78: getfield retryCount : I
    //   81: ifne -> 94
    //   84: getstatic com/squareup/picasso/NetworkPolicy.OFFLINE : Lcom/squareup/picasso/NetworkPolicy;
    //   87: getfield index : I
    //   90: istore_3
    //   91: goto -> 99
    //   94: aload_0
    //   95: getfield networkPolicy : I
    //   98: istore_3
    //   99: aload_0
    //   100: iload_3
    //   101: putfield networkPolicy : I
    //   104: aload_0
    //   105: getfield requestHandler : Lcom/squareup/picasso/RequestHandler;
    //   108: aload_0
    //   109: getfield data : Lcom/squareup/picasso/Request;
    //   112: aload_0
    //   113: getfield networkPolicy : I
    //   116: invokevirtual load : (Lcom/squareup/picasso/Request;I)Lcom/squareup/picasso/RequestHandler$Result;
    //   119: astore #4
    //   121: aload #4
    //   123: ifnull -> 189
    //   126: aload_0
    //   127: aload #4
    //   129: invokevirtual getLoadedFrom : ()Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   132: putfield loadedFrom : Lcom/squareup/picasso/Picasso$LoadedFrom;
    //   135: aload_0
    //   136: aload #4
    //   138: invokevirtual getExifOrientation : ()I
    //   141: putfield exifOrientation : I
    //   144: aload #4
    //   146: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: aload_1
    //   153: ifnonnull -> 189
    //   156: aload #4
    //   158: invokevirtual getSource : ()Lokio/Source;
    //   161: astore_1
    //   162: aload_1
    //   163: aload_0
    //   164: getfield data : Lcom/squareup/picasso/Request;
    //   167: invokestatic decodeStream : (Lokio/Source;Lcom/squareup/picasso/Request;)Landroid/graphics/Bitmap;
    //   170: astore_2
    //   171: aload_1
    //   172: invokeinterface close : ()V
    //   177: goto -> 189
    //   180: astore_2
    //   181: aload_1
    //   182: invokeinterface close : ()V
    //   187: aload_2
    //   188: athrow
    //   189: aload_2
    //   190: astore_1
    //   191: aload_2
    //   192: ifnull -> 403
    //   195: aload_0
    //   196: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   199: getfield loggingEnabled : Z
    //   202: ifeq -> 221
    //   205: ldc_w 'Hunter'
    //   208: ldc_w 'decoded'
    //   211: aload_0
    //   212: getfield data : Lcom/squareup/picasso/Request;
    //   215: invokevirtual logId : ()Ljava/lang/String;
    //   218: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield stats : Lcom/squareup/picasso/Stats;
    //   225: aload_2
    //   226: invokevirtual dispatchBitmapDecoded : (Landroid/graphics/Bitmap;)V
    //   229: aload_0
    //   230: getfield data : Lcom/squareup/picasso/Request;
    //   233: invokevirtual needsTransformation : ()Z
    //   236: ifne -> 248
    //   239: aload_2
    //   240: astore_1
    //   241: aload_0
    //   242: getfield exifOrientation : I
    //   245: ifeq -> 403
    //   248: getstatic com/squareup/picasso/BitmapHunter.DECODE_LOCK : Ljava/lang/Object;
    //   251: astore #4
    //   253: aload #4
    //   255: monitorenter
    //   256: aload_0
    //   257: getfield data : Lcom/squareup/picasso/Request;
    //   260: invokevirtual needsMatrixTransform : ()Z
    //   263: ifne -> 275
    //   266: aload_2
    //   267: astore_1
    //   268: aload_0
    //   269: getfield exifOrientation : I
    //   272: ifeq -> 318
    //   275: aload_0
    //   276: getfield data : Lcom/squareup/picasso/Request;
    //   279: aload_2
    //   280: aload_0
    //   281: getfield exifOrientation : I
    //   284: invokestatic transformResult : (Lcom/squareup/picasso/Request;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   287: astore_2
    //   288: aload_2
    //   289: astore_1
    //   290: aload_0
    //   291: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   294: getfield loggingEnabled : Z
    //   297: ifeq -> 318
    //   300: ldc_w 'Hunter'
    //   303: ldc_w 'transformed'
    //   306: aload_0
    //   307: getfield data : Lcom/squareup/picasso/Request;
    //   310: invokevirtual logId : ()Ljava/lang/String;
    //   313: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_2
    //   317: astore_1
    //   318: aload_1
    //   319: astore_2
    //   320: aload_0
    //   321: getfield data : Lcom/squareup/picasso/Request;
    //   324: invokevirtual hasCustomTransformations : ()Z
    //   327: ifeq -> 375
    //   330: aload_0
    //   331: getfield data : Lcom/squareup/picasso/Request;
    //   334: getfield transformations : Ljava/util/List;
    //   337: aload_1
    //   338: invokestatic applyCustomTransformations : (Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   341: astore_1
    //   342: aload_1
    //   343: astore_2
    //   344: aload_0
    //   345: getfield picasso : Lcom/squareup/picasso/Picasso;
    //   348: getfield loggingEnabled : Z
    //   351: ifeq -> 375
    //   354: ldc_w 'Hunter'
    //   357: ldc_w 'transformed'
    //   360: aload_0
    //   361: getfield data : Lcom/squareup/picasso/Request;
    //   364: invokevirtual logId : ()Ljava/lang/String;
    //   367: ldc_w 'from custom transformations'
    //   370: invokestatic log : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_1
    //   374: astore_2
    //   375: aload #4
    //   377: monitorexit
    //   378: aload_2
    //   379: astore_1
    //   380: aload_2
    //   381: ifnull -> 403
    //   384: aload_0
    //   385: getfield stats : Lcom/squareup/picasso/Stats;
    //   388: aload_2
    //   389: invokevirtual dispatchBitmapTransformed : (Landroid/graphics/Bitmap;)V
    //   392: aload_2
    //   393: astore_1
    //   394: goto -> 403
    //   397: astore_2
    //   398: aload #4
    //   400: monitorexit
    //   401: aload_2
    //   402: athrow
    //   403: aload_1
    //   404: areturn
    //   405: astore_1
    //   406: goto -> 177
    //   409: astore_1
    //   410: goto -> 187
    // Exception table:
    //   from	to	target	type
    //   162	171	180	finally
    //   171	177	405	java/io/IOException
    //   181	187	409	java/io/IOException
    //   256	266	397	finally
    //   268	275	397	finally
    //   275	288	397	finally
    //   290	316	397	finally
    //   320	342	397	finally
    //   344	373	397	finally
    //   375	378	397	finally
    //   398	401	397	finally
  }
  
  boolean isCancelled() {
    boolean bool;
    Future<?> future = this.future;
    if (future != null && future.isCancelled()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void run() {
    try {
      updateThreadName(this.data);
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this)); 
      this.result = hunt();
      if (this.result == null) {
        this.dispatcher.dispatchFailed(this);
      } else {
        this.dispatcher.dispatchComplete(this);
      } 
      Thread.currentThread().setName("Picasso-Idle");
    } catch (ResponseException responseException) {
      if (!NetworkPolicy.isOfflineOnly(responseException.networkPolicy) || responseException.code != 504)
        this.exception = responseException; 
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (IOException iOException) {
      this.exception = iOException;
      this.dispatcher.dispatchRetry(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (OutOfMemoryError outOfMemoryError) {
      StringWriter stringWriter = new StringWriter();
      this();
      StatsSnapshot statsSnapshot = this.stats.createSnapshot();
      PrintWriter printWriter = new PrintWriter();
      this(stringWriter);
      statsSnapshot.dump(printWriter);
      RuntimeException runtimeException = new RuntimeException();
      this(stringWriter.toString(), outOfMemoryError);
      this.exception = runtimeException;
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } catch (Exception exception) {
      this.exception = exception;
      this.dispatcher.dispatchFailed(this);
      Thread.currentThread().setName("Picasso-Idle");
    } finally {
      Exception exception;
    } 
  }
  
  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo) {
    boolean bool;
    if (this.retryCount > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      return false; 
    this.retryCount--;
    return this.requestHandler.shouldRetry(paramBoolean, paramNetworkInfo);
  }
  
  boolean supportsReplay() {
    return this.requestHandler.supportsReplay();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\BitmapHunter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */