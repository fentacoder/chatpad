package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
  private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
  
  private static final String UTC_ID = "UTC";
  
  private static boolean checkOffset(String paramString, int paramInt, char paramChar) {
    boolean bool;
    if (paramInt < paramString.length() && paramString.charAt(paramInt) == paramChar) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static String format(Date paramDate) {
    return format(paramDate, false, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean) {
    return format(paramDate, paramBoolean, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean, TimeZone paramTimeZone) {
    int i;
    GregorianCalendar gregorianCalendar = new GregorianCalendar(paramTimeZone, Locale.US);
    gregorianCalendar.setTime(paramDate);
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    } 
    if (paramTimeZone.getRawOffset() == 0) {
      b = 1;
    } else {
      b = 6;
    } 
    StringBuilder stringBuilder = new StringBuilder(19 + i + b);
    padInt(stringBuilder, gregorianCalendar.get(1), 4);
    byte b = 45;
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(2) + 1, 2);
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(5), 2);
    stringBuilder.append('T');
    padInt(stringBuilder, gregorianCalendar.get(11), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(12), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(13), 2);
    if (paramBoolean) {
      stringBuilder.append('.');
      padInt(stringBuilder, gregorianCalendar.get(14), 3);
    } 
    int j = paramTimeZone.getOffset(gregorianCalendar.getTimeInMillis());
    if (j != 0) {
      byte b1;
      int k = j / 60000;
      i = Math.abs(k / 60);
      k = Math.abs(k % 60);
      if (j < 0) {
        b1 = b;
      } else {
        b = 43;
        b1 = b;
      } 
      stringBuilder.append(b1);
      padInt(stringBuilder, i, 2);
      stringBuilder.append(':');
      padInt(stringBuilder, k, 2);
    } else {
      stringBuilder.append('Z');
    } 
    return stringBuilder.toString();
  }
  
  private static int indexOfNonDigit(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (c < '0' || c > '9')
        return paramInt; 
      paramInt++;
    } 
    return paramString.length();
  }
  
  private static void padInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    String str = Integer.toString(paramInt1);
    for (paramInt1 = paramInt2 - str.length(); paramInt1 > 0; paramInt1--)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(str);
  }
  
  public static Date parse(String paramString, ParsePosition paramParsePosition) throws ParseException {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getIndex : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_4
    //   7: iadd
    //   8: istore_3
    //   9: aload_0
    //   10: iload_2
    //   11: iload_3
    //   12: invokestatic parseInt : (Ljava/lang/String;II)I
    //   15: istore #4
    //   17: iload_3
    //   18: istore_2
    //   19: aload_0
    //   20: iload_3
    //   21: bipush #45
    //   23: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   26: ifeq -> 33
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_2
    //   35: iadd
    //   36: istore_3
    //   37: aload_0
    //   38: iload_2
    //   39: iload_3
    //   40: invokestatic parseInt : (Ljava/lang/String;II)I
    //   43: istore #5
    //   45: iload_3
    //   46: istore_2
    //   47: aload_0
    //   48: iload_3
    //   49: bipush #45
    //   51: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   54: ifeq -> 61
    //   57: iload_3
    //   58: iconst_1
    //   59: iadd
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_2
    //   63: iadd
    //   64: istore #6
    //   66: aload_0
    //   67: iload_2
    //   68: iload #6
    //   70: invokestatic parseInt : (Ljava/lang/String;II)I
    //   73: istore #7
    //   75: aload_0
    //   76: iload #6
    //   78: bipush #84
    //   80: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   83: istore #8
    //   85: iload #8
    //   87: ifne -> 129
    //   90: aload_0
    //   91: invokevirtual length : ()I
    //   94: iload #6
    //   96: if_icmpgt -> 129
    //   99: new java/util/GregorianCalendar
    //   102: astore #9
    //   104: aload #9
    //   106: iload #4
    //   108: iload #5
    //   110: iconst_1
    //   111: isub
    //   112: iload #7
    //   114: invokespecial <init> : (III)V
    //   117: aload_1
    //   118: iload #6
    //   120: invokevirtual setIndex : (I)V
    //   123: aload #9
    //   125: invokevirtual getTime : ()Ljava/util/Date;
    //   128: areturn
    //   129: iload #8
    //   131: ifeq -> 376
    //   134: iload #6
    //   136: iconst_1
    //   137: iadd
    //   138: istore_2
    //   139: iload_2
    //   140: iconst_2
    //   141: iadd
    //   142: istore_3
    //   143: aload_0
    //   144: iload_2
    //   145: iload_3
    //   146: invokestatic parseInt : (Ljava/lang/String;II)I
    //   149: istore #10
    //   151: iload_3
    //   152: istore_2
    //   153: aload_0
    //   154: iload_3
    //   155: bipush #58
    //   157: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   160: ifeq -> 167
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_2
    //   167: iload_2
    //   168: iconst_2
    //   169: iadd
    //   170: istore_3
    //   171: aload_0
    //   172: iload_2
    //   173: iload_3
    //   174: invokestatic parseInt : (Ljava/lang/String;II)I
    //   177: istore #11
    //   179: iload_3
    //   180: istore #6
    //   182: aload_0
    //   183: iload_3
    //   184: bipush #58
    //   186: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   189: ifeq -> 197
    //   192: iload_3
    //   193: iconst_1
    //   194: iadd
    //   195: istore #6
    //   197: aload_0
    //   198: invokevirtual length : ()I
    //   201: iload #6
    //   203: if_icmple -> 367
    //   206: aload_0
    //   207: iload #6
    //   209: invokevirtual charAt : (I)C
    //   212: istore_2
    //   213: iload_2
    //   214: bipush #90
    //   216: if_icmpeq -> 367
    //   219: iload_2
    //   220: bipush #43
    //   222: if_icmpeq -> 367
    //   225: iload_2
    //   226: bipush #45
    //   228: if_icmpeq -> 367
    //   231: iload #6
    //   233: iconst_2
    //   234: iadd
    //   235: istore_2
    //   236: aload_0
    //   237: iload #6
    //   239: iload_2
    //   240: invokestatic parseInt : (Ljava/lang/String;II)I
    //   243: istore_3
    //   244: iload_3
    //   245: bipush #59
    //   247: if_icmple -> 262
    //   250: iload_3
    //   251: bipush #63
    //   253: if_icmpge -> 262
    //   256: bipush #59
    //   258: istore_3
    //   259: goto -> 262
    //   262: aload_0
    //   263: iload_2
    //   264: bipush #46
    //   266: invokestatic checkOffset : (Ljava/lang/String;IC)Z
    //   269: ifeq -> 352
    //   272: iload_2
    //   273: iconst_1
    //   274: iadd
    //   275: istore #12
    //   277: aload_0
    //   278: iload #12
    //   280: iconst_1
    //   281: iadd
    //   282: invokestatic indexOfNonDigit : (Ljava/lang/String;I)I
    //   285: istore #6
    //   287: iload #6
    //   289: iload #12
    //   291: iconst_3
    //   292: iadd
    //   293: invokestatic min : (II)I
    //   296: istore #13
    //   298: aload_0
    //   299: iload #12
    //   301: iload #13
    //   303: invokestatic parseInt : (Ljava/lang/String;II)I
    //   306: istore_2
    //   307: iload #13
    //   309: iload #12
    //   311: isub
    //   312: istore #13
    //   314: iload #13
    //   316: iconst_1
    //   317: if_icmpeq -> 337
    //   320: iload #13
    //   322: iconst_2
    //   323: if_icmpeq -> 329
    //   326: goto -> 342
    //   329: iload_2
    //   330: bipush #10
    //   332: imul
    //   333: istore_2
    //   334: goto -> 342
    //   337: iload_2
    //   338: bipush #100
    //   340: imul
    //   341: istore_2
    //   342: iload #10
    //   344: istore #13
    //   346: iload_3
    //   347: istore #10
    //   349: goto -> 395
    //   352: iload_2
    //   353: istore #6
    //   355: iconst_0
    //   356: istore_2
    //   357: iload #10
    //   359: istore #13
    //   361: iload_3
    //   362: istore #10
    //   364: goto -> 395
    //   367: iload #10
    //   369: istore_2
    //   370: iload #11
    //   372: istore_3
    //   373: goto -> 380
    //   376: iconst_0
    //   377: istore_2
    //   378: iconst_0
    //   379: istore_3
    //   380: iconst_0
    //   381: istore #12
    //   383: iconst_0
    //   384: istore #10
    //   386: iload_3
    //   387: istore #11
    //   389: iload_2
    //   390: istore #13
    //   392: iload #12
    //   394: istore_2
    //   395: aload_0
    //   396: invokevirtual length : ()I
    //   399: iload #6
    //   401: if_icmple -> 824
    //   404: aload_0
    //   405: iload #6
    //   407: invokevirtual charAt : (I)C
    //   410: istore #14
    //   412: iload #14
    //   414: bipush #90
    //   416: if_icmpne -> 432
    //   419: getstatic com/google/gson/internal/bind/util/ISO8601Utils.TIMEZONE_UTC : Ljava/util/TimeZone;
    //   422: astore #9
    //   424: iload #6
    //   426: iconst_1
    //   427: iadd
    //   428: istore_3
    //   429: goto -> 734
    //   432: iload #14
    //   434: bipush #43
    //   436: if_icmpeq -> 501
    //   439: iload #14
    //   441: bipush #45
    //   443: if_icmpne -> 449
    //   446: goto -> 501
    //   449: new java/lang/IndexOutOfBoundsException
    //   452: astore #15
    //   454: new java/lang/StringBuilder
    //   457: astore #9
    //   459: aload #9
    //   461: invokespecial <init> : ()V
    //   464: aload #9
    //   466: ldc 'Invalid time zone indicator ''
    //   468: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload #9
    //   474: iload #14
    //   476: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload #9
    //   482: ldc '''
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload #15
    //   490: aload #9
    //   492: invokevirtual toString : ()Ljava/lang/String;
    //   495: invokespecial <init> : (Ljava/lang/String;)V
    //   498: aload #15
    //   500: athrow
    //   501: aload_0
    //   502: iload #6
    //   504: invokevirtual substring : (I)Ljava/lang/String;
    //   507: astore #9
    //   509: aload #9
    //   511: invokevirtual length : ()I
    //   514: iconst_5
    //   515: if_icmplt -> 521
    //   518: goto -> 554
    //   521: new java/lang/StringBuilder
    //   524: astore #15
    //   526: aload #15
    //   528: invokespecial <init> : ()V
    //   531: aload #15
    //   533: aload #9
    //   535: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload #15
    //   541: ldc '00'
    //   543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload #15
    //   549: invokevirtual toString : ()Ljava/lang/String;
    //   552: astore #9
    //   554: iload #6
    //   556: aload #9
    //   558: invokevirtual length : ()I
    //   561: iadd
    //   562: istore_3
    //   563: ldc '+0000'
    //   565: aload #9
    //   567: invokevirtual equals : (Ljava/lang/Object;)Z
    //   570: ifne -> 729
    //   573: ldc '+00:00'
    //   575: aload #9
    //   577: invokevirtual equals : (Ljava/lang/Object;)Z
    //   580: ifeq -> 586
    //   583: goto -> 729
    //   586: new java/lang/StringBuilder
    //   589: astore #15
    //   591: aload #15
    //   593: invokespecial <init> : ()V
    //   596: aload #15
    //   598: ldc 'GMT'
    //   600: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload #15
    //   606: aload #9
    //   608: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload #15
    //   614: invokevirtual toString : ()Ljava/lang/String;
    //   617: astore #15
    //   619: aload #15
    //   621: invokestatic getTimeZone : (Ljava/lang/String;)Ljava/util/TimeZone;
    //   624: astore #9
    //   626: aload #9
    //   628: invokevirtual getID : ()Ljava/lang/String;
    //   631: astore #16
    //   633: aload #16
    //   635: aload #15
    //   637: invokevirtual equals : (Ljava/lang/Object;)Z
    //   640: ifne -> 726
    //   643: aload #16
    //   645: ldc ':'
    //   647: ldc ''
    //   649: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   652: aload #15
    //   654: invokevirtual equals : (Ljava/lang/Object;)Z
    //   657: ifeq -> 663
    //   660: goto -> 726
    //   663: new java/lang/IndexOutOfBoundsException
    //   666: astore #16
    //   668: new java/lang/StringBuilder
    //   671: astore #17
    //   673: aload #17
    //   675: invokespecial <init> : ()V
    //   678: aload #17
    //   680: ldc 'Mismatching time zone indicator: '
    //   682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload #17
    //   688: aload #15
    //   690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload #17
    //   696: ldc ' given, resolves to '
    //   698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload #17
    //   704: aload #9
    //   706: invokevirtual getID : ()Ljava/lang/String;
    //   709: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #16
    //   715: aload #17
    //   717: invokevirtual toString : ()Ljava/lang/String;
    //   720: invokespecial <init> : (Ljava/lang/String;)V
    //   723: aload #16
    //   725: athrow
    //   726: goto -> 734
    //   729: getstatic com/google/gson/internal/bind/util/ISO8601Utils.TIMEZONE_UTC : Ljava/util/TimeZone;
    //   732: astore #9
    //   734: new java/util/GregorianCalendar
    //   737: astore #15
    //   739: aload #15
    //   741: aload #9
    //   743: invokespecial <init> : (Ljava/util/TimeZone;)V
    //   746: aload #15
    //   748: iconst_0
    //   749: invokevirtual setLenient : (Z)V
    //   752: aload #15
    //   754: iconst_1
    //   755: iload #4
    //   757: invokevirtual set : (II)V
    //   760: aload #15
    //   762: iconst_2
    //   763: iload #5
    //   765: iconst_1
    //   766: isub
    //   767: invokevirtual set : (II)V
    //   770: aload #15
    //   772: iconst_5
    //   773: iload #7
    //   775: invokevirtual set : (II)V
    //   778: aload #15
    //   780: bipush #11
    //   782: iload #13
    //   784: invokevirtual set : (II)V
    //   787: aload #15
    //   789: bipush #12
    //   791: iload #11
    //   793: invokevirtual set : (II)V
    //   796: aload #15
    //   798: bipush #13
    //   800: iload #10
    //   802: invokevirtual set : (II)V
    //   805: aload #15
    //   807: bipush #14
    //   809: iload_2
    //   810: invokevirtual set : (II)V
    //   813: aload_1
    //   814: iload_3
    //   815: invokevirtual setIndex : (I)V
    //   818: aload #15
    //   820: invokevirtual getTime : ()Ljava/util/Date;
    //   823: areturn
    //   824: new java/lang/IllegalArgumentException
    //   827: astore #9
    //   829: aload #9
    //   831: ldc 'No time zone indicator'
    //   833: invokespecial <init> : (Ljava/lang/String;)V
    //   836: aload #9
    //   838: athrow
    //   839: astore #9
    //   841: goto -> 851
    //   844: astore #9
    //   846: goto -> 851
    //   849: astore #9
    //   851: aload_0
    //   852: ifnonnull -> 860
    //   855: aconst_null
    //   856: astore_0
    //   857: goto -> 898
    //   860: new java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial <init> : ()V
    //   867: astore #15
    //   869: aload #15
    //   871: bipush #34
    //   873: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload #15
    //   879: aload_0
    //   880: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload #15
    //   886: ldc '''
    //   888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload #15
    //   894: invokevirtual toString : ()Ljava/lang/String;
    //   897: astore_0
    //   898: aload #9
    //   900: invokevirtual getMessage : ()Ljava/lang/String;
    //   903: astore #16
    //   905: aload #16
    //   907: ifnull -> 922
    //   910: aload #16
    //   912: astore #15
    //   914: aload #16
    //   916: invokevirtual isEmpty : ()Z
    //   919: ifeq -> 968
    //   922: new java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial <init> : ()V
    //   929: astore #15
    //   931: aload #15
    //   933: ldc '('
    //   935: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload #15
    //   941: aload #9
    //   943: invokevirtual getClass : ()Ljava/lang/Class;
    //   946: invokevirtual getName : ()Ljava/lang/String;
    //   949: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload #15
    //   955: ldc ')'
    //   957: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload #15
    //   963: invokevirtual toString : ()Ljava/lang/String;
    //   966: astore #15
    //   968: new java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial <init> : ()V
    //   975: astore #16
    //   977: aload #16
    //   979: ldc 'Failed to parse date ['
    //   981: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload #16
    //   987: aload_0
    //   988: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: pop
    //   992: aload #16
    //   994: ldc ']: '
    //   996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload #16
    //   1002: aload #15
    //   1004: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: new java/text/ParseException
    //   1011: dup
    //   1012: aload #16
    //   1014: invokevirtual toString : ()Ljava/lang/String;
    //   1017: aload_1
    //   1018: invokevirtual getIndex : ()I
    //   1021: invokespecial <init> : (Ljava/lang/String;I)V
    //   1024: astore_0
    //   1025: aload_0
    //   1026: aload #9
    //   1028: invokevirtual initCause : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1031: pop
    //   1032: aload_0
    //   1033: athrow
    // Exception table:
    //   from	to	target	type
    //   0	5	849	java/lang/IndexOutOfBoundsException
    //   0	5	844	java/lang/NumberFormatException
    //   0	5	839	java/lang/IllegalArgumentException
    //   9	17	849	java/lang/IndexOutOfBoundsException
    //   9	17	844	java/lang/NumberFormatException
    //   9	17	839	java/lang/IllegalArgumentException
    //   19	29	849	java/lang/IndexOutOfBoundsException
    //   19	29	844	java/lang/NumberFormatException
    //   19	29	839	java/lang/IllegalArgumentException
    //   37	45	849	java/lang/IndexOutOfBoundsException
    //   37	45	844	java/lang/NumberFormatException
    //   37	45	839	java/lang/IllegalArgumentException
    //   47	57	849	java/lang/IndexOutOfBoundsException
    //   47	57	844	java/lang/NumberFormatException
    //   47	57	839	java/lang/IllegalArgumentException
    //   66	85	849	java/lang/IndexOutOfBoundsException
    //   66	85	844	java/lang/NumberFormatException
    //   66	85	839	java/lang/IllegalArgumentException
    //   90	129	849	java/lang/IndexOutOfBoundsException
    //   90	129	844	java/lang/NumberFormatException
    //   90	129	839	java/lang/IllegalArgumentException
    //   143	151	849	java/lang/IndexOutOfBoundsException
    //   143	151	844	java/lang/NumberFormatException
    //   143	151	839	java/lang/IllegalArgumentException
    //   153	163	849	java/lang/IndexOutOfBoundsException
    //   153	163	844	java/lang/NumberFormatException
    //   153	163	839	java/lang/IllegalArgumentException
    //   171	179	849	java/lang/IndexOutOfBoundsException
    //   171	179	844	java/lang/NumberFormatException
    //   171	179	839	java/lang/IllegalArgumentException
    //   182	192	849	java/lang/IndexOutOfBoundsException
    //   182	192	844	java/lang/NumberFormatException
    //   182	192	839	java/lang/IllegalArgumentException
    //   197	213	849	java/lang/IndexOutOfBoundsException
    //   197	213	844	java/lang/NumberFormatException
    //   197	213	839	java/lang/IllegalArgumentException
    //   236	244	849	java/lang/IndexOutOfBoundsException
    //   236	244	844	java/lang/NumberFormatException
    //   236	244	839	java/lang/IllegalArgumentException
    //   262	272	849	java/lang/IndexOutOfBoundsException
    //   262	272	844	java/lang/NumberFormatException
    //   262	272	839	java/lang/IllegalArgumentException
    //   277	307	849	java/lang/IndexOutOfBoundsException
    //   277	307	844	java/lang/NumberFormatException
    //   277	307	839	java/lang/IllegalArgumentException
    //   395	412	849	java/lang/IndexOutOfBoundsException
    //   395	412	844	java/lang/NumberFormatException
    //   395	412	839	java/lang/IllegalArgumentException
    //   419	424	849	java/lang/IndexOutOfBoundsException
    //   419	424	844	java/lang/NumberFormatException
    //   419	424	839	java/lang/IllegalArgumentException
    //   449	501	849	java/lang/IndexOutOfBoundsException
    //   449	501	844	java/lang/NumberFormatException
    //   449	501	839	java/lang/IllegalArgumentException
    //   501	518	849	java/lang/IndexOutOfBoundsException
    //   501	518	844	java/lang/NumberFormatException
    //   501	518	839	java/lang/IllegalArgumentException
    //   521	554	849	java/lang/IndexOutOfBoundsException
    //   521	554	844	java/lang/NumberFormatException
    //   521	554	839	java/lang/IllegalArgumentException
    //   554	583	849	java/lang/IndexOutOfBoundsException
    //   554	583	844	java/lang/NumberFormatException
    //   554	583	839	java/lang/IllegalArgumentException
    //   586	660	849	java/lang/IndexOutOfBoundsException
    //   586	660	844	java/lang/NumberFormatException
    //   586	660	839	java/lang/IllegalArgumentException
    //   663	726	849	java/lang/IndexOutOfBoundsException
    //   663	726	844	java/lang/NumberFormatException
    //   663	726	839	java/lang/IllegalArgumentException
    //   729	734	849	java/lang/IndexOutOfBoundsException
    //   729	734	844	java/lang/NumberFormatException
    //   729	734	839	java/lang/IllegalArgumentException
    //   734	824	849	java/lang/IndexOutOfBoundsException
    //   734	824	844	java/lang/NumberFormatException
    //   734	824	839	java/lang/IllegalArgumentException
    //   824	839	849	java/lang/IndexOutOfBoundsException
    //   824	839	844	java/lang/NumberFormatException
    //   824	839	839	java/lang/IllegalArgumentException
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2) throws NumberFormatException {
    if (paramInt1 >= 0 && paramInt2 <= paramString.length() && paramInt1 <= paramInt2) {
      int i;
      int j;
      if (paramInt1 < paramInt2) {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0) {
          j = -j;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid number: ");
          stringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(stringBuilder.toString());
        } 
      } else {
        j = 0;
        i = paramInt1;
      } 
      while (i < paramInt2) {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0) {
          j = j * 10 - k;
          i++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid number: ");
        stringBuilder.append(paramString.substring(paramInt1, paramInt2));
        throw new NumberFormatException(stringBuilder.toString());
      } 
      return -j;
    } 
    throw new NumberFormatException(paramString);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\gson\internal\bin\\util\ISO8601Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */