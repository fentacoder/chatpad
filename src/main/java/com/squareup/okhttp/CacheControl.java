package com.squareup.okhttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
  public static final CacheControl FORCE_CACHE;
  
  public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
  
  String headerValue;
  
  private final boolean isPrivate;
  
  private final boolean isPublic;
  
  private final int maxAgeSeconds;
  
  private final int maxStaleSeconds;
  
  private final int minFreshSeconds;
  
  private final boolean mustRevalidate;
  
  private final boolean noCache;
  
  private final boolean noStore;
  
  private final boolean noTransform;
  
  private final boolean onlyIfCached;
  
  private final int sMaxAgeSeconds;
  
  static {
    FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  }
  
  private CacheControl(Builder paramBuilder) {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString) {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.headerValue = paramString;
  }
  
  private String headerValue() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.noCache)
      stringBuilder.append("no-cache, "); 
    if (this.noStore)
      stringBuilder.append("no-store, "); 
    if (this.maxAgeSeconds != -1) {
      stringBuilder.append("max-age=");
      stringBuilder.append(this.maxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.sMaxAgeSeconds != -1) {
      stringBuilder.append("s-maxage=");
      stringBuilder.append(this.sMaxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.isPrivate)
      stringBuilder.append("private, "); 
    if (this.isPublic)
      stringBuilder.append("public, "); 
    if (this.mustRevalidate)
      stringBuilder.append("must-revalidate, "); 
    if (this.maxStaleSeconds != -1) {
      stringBuilder.append("max-stale=");
      stringBuilder.append(this.maxStaleSeconds);
      stringBuilder.append(", ");
    } 
    if (this.minFreshSeconds != -1) {
      stringBuilder.append("min-fresh=");
      stringBuilder.append(this.minFreshSeconds);
      stringBuilder.append(", ");
    } 
    if (this.onlyIfCached)
      stringBuilder.append("only-if-cached, "); 
    if (this.noTransform)
      stringBuilder.append("no-transform, "); 
    if (stringBuilder.length() == 0)
      return ""; 
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual size : ()I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iconst_1
    //   8: istore_3
    //   9: aconst_null
    //   10: astore #4
    //   12: iconst_0
    //   13: istore #5
    //   15: iconst_0
    //   16: istore #6
    //   18: iconst_m1
    //   19: istore #7
    //   21: iconst_m1
    //   22: istore #8
    //   24: iconst_0
    //   25: istore #9
    //   27: iconst_0
    //   28: istore #10
    //   30: iconst_0
    //   31: istore #11
    //   33: iconst_m1
    //   34: istore #12
    //   36: iconst_m1
    //   37: istore #13
    //   39: iconst_0
    //   40: istore #14
    //   42: iconst_0
    //   43: istore #15
    //   45: aload_0
    //   46: astore #16
    //   48: iload_2
    //   49: iload_1
    //   50: if_icmpge -> 1119
    //   53: aload #16
    //   55: iload_2
    //   56: invokevirtual name : (I)Ljava/lang/String;
    //   59: astore #17
    //   61: aload #16
    //   63: iload_2
    //   64: invokevirtual value : (I)Ljava/lang/String;
    //   67: astore #18
    //   69: aload #17
    //   71: ldc 'Cache-Control'
    //   73: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   76: ifeq -> 94
    //   79: aload #4
    //   81: ifnull -> 87
    //   84: goto -> 155
    //   87: aload #18
    //   89: astore #4
    //   91: goto -> 157
    //   94: iload_3
    //   95: istore #19
    //   97: aload #4
    //   99: astore #16
    //   101: iload #5
    //   103: istore #20
    //   105: iload #6
    //   107: istore #21
    //   109: iload #7
    //   111: istore #22
    //   113: iload #8
    //   115: istore #23
    //   117: iload #9
    //   119: istore #24
    //   121: iload #10
    //   123: istore #25
    //   125: iload #11
    //   127: istore #26
    //   129: iload #12
    //   131: istore #27
    //   133: iload #13
    //   135: istore #28
    //   137: iload #14
    //   139: istore #29
    //   141: iload #15
    //   143: istore #30
    //   145: aload #17
    //   147: ldc 'Pragma'
    //   149: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   152: ifeq -> 1062
    //   155: iconst_0
    //   156: istore_3
    //   157: iconst_0
    //   158: istore #31
    //   160: iload_3
    //   161: istore #19
    //   163: aload #4
    //   165: astore #16
    //   167: iload #5
    //   169: istore #20
    //   171: iload #6
    //   173: istore #21
    //   175: iload #7
    //   177: istore #22
    //   179: iload #8
    //   181: istore #23
    //   183: iload #9
    //   185: istore #24
    //   187: iload #10
    //   189: istore #25
    //   191: iload #11
    //   193: istore #26
    //   195: iload #12
    //   197: istore #27
    //   199: iload #13
    //   201: istore #28
    //   203: iload #14
    //   205: istore #29
    //   207: iload #15
    //   209: istore #30
    //   211: iload #31
    //   213: aload #18
    //   215: invokevirtual length : ()I
    //   218: if_icmpge -> 1062
    //   221: aload #18
    //   223: iload #31
    //   225: ldc '=,;'
    //   227: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   230: istore #22
    //   232: aload #18
    //   234: iload #31
    //   236: iload #22
    //   238: invokevirtual substring : (II)Ljava/lang/String;
    //   241: invokevirtual trim : ()Ljava/lang/String;
    //   244: astore #17
    //   246: iload #22
    //   248: aload #18
    //   250: invokevirtual length : ()I
    //   253: if_icmpeq -> 375
    //   256: aload #18
    //   258: iload #22
    //   260: invokevirtual charAt : (I)C
    //   263: bipush #44
    //   265: if_icmpeq -> 375
    //   268: aload #18
    //   270: iload #22
    //   272: invokevirtual charAt : (I)C
    //   275: bipush #59
    //   277: if_icmpne -> 283
    //   280: goto -> 375
    //   283: aload #18
    //   285: iload #22
    //   287: iconst_1
    //   288: iadd
    //   289: invokestatic skipWhitespace : (Ljava/lang/String;I)I
    //   292: istore #28
    //   294: iload #28
    //   296: aload #18
    //   298: invokevirtual length : ()I
    //   301: if_icmpge -> 347
    //   304: aload #18
    //   306: iload #28
    //   308: invokevirtual charAt : (I)C
    //   311: bipush #34
    //   313: if_icmpne -> 347
    //   316: iinc #28, 1
    //   319: aload #18
    //   321: iload #28
    //   323: ldc '"'
    //   325: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   328: istore #22
    //   330: aload #18
    //   332: iload #28
    //   334: iload #22
    //   336: invokevirtual substring : (II)Ljava/lang/String;
    //   339: astore #16
    //   341: iinc #22, 1
    //   344: goto -> 381
    //   347: aload #18
    //   349: iload #28
    //   351: ldc ',;'
    //   353: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   356: istore #22
    //   358: aload #18
    //   360: iload #28
    //   362: iload #22
    //   364: invokevirtual substring : (II)Ljava/lang/String;
    //   367: invokevirtual trim : ()Ljava/lang/String;
    //   370: astore #16
    //   372: goto -> 381
    //   375: iinc #22, 1
    //   378: aconst_null
    //   379: astore #16
    //   381: ldc 'no-cache'
    //   383: aload #17
    //   385: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   388: ifeq -> 433
    //   391: iconst_1
    //   392: istore #30
    //   394: iload #6
    //   396: istore #25
    //   398: iload #7
    //   400: istore #28
    //   402: iload #8
    //   404: istore #23
    //   406: iload #9
    //   408: istore #26
    //   410: iload #10
    //   412: istore #29
    //   414: iload #11
    //   416: istore #21
    //   418: iload #12
    //   420: istore #27
    //   422: iload #13
    //   424: istore #19
    //   426: iload #14
    //   428: istore #24
    //   430: goto -> 1015
    //   433: ldc 'no-store'
    //   435: aload #17
    //   437: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   440: ifeq -> 485
    //   443: iconst_1
    //   444: istore #25
    //   446: iload #5
    //   448: istore #30
    //   450: iload #7
    //   452: istore #28
    //   454: iload #8
    //   456: istore #23
    //   458: iload #9
    //   460: istore #26
    //   462: iload #10
    //   464: istore #29
    //   466: iload #11
    //   468: istore #21
    //   470: iload #12
    //   472: istore #27
    //   474: iload #13
    //   476: istore #19
    //   478: iload #14
    //   480: istore #24
    //   482: goto -> 1015
    //   485: ldc 'max-age'
    //   487: aload #17
    //   489: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   492: ifeq -> 542
    //   495: aload #16
    //   497: iconst_m1
    //   498: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   501: istore #28
    //   503: iload #5
    //   505: istore #30
    //   507: iload #6
    //   509: istore #25
    //   511: iload #8
    //   513: istore #23
    //   515: iload #9
    //   517: istore #26
    //   519: iload #10
    //   521: istore #29
    //   523: iload #11
    //   525: istore #21
    //   527: iload #12
    //   529: istore #27
    //   531: iload #13
    //   533: istore #19
    //   535: iload #14
    //   537: istore #24
    //   539: goto -> 1015
    //   542: ldc 's-maxage'
    //   544: aload #17
    //   546: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   549: ifeq -> 599
    //   552: aload #16
    //   554: iconst_m1
    //   555: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   558: istore #23
    //   560: iload #5
    //   562: istore #30
    //   564: iload #6
    //   566: istore #25
    //   568: iload #7
    //   570: istore #28
    //   572: iload #9
    //   574: istore #26
    //   576: iload #10
    //   578: istore #29
    //   580: iload #11
    //   582: istore #21
    //   584: iload #12
    //   586: istore #27
    //   588: iload #13
    //   590: istore #19
    //   592: iload #14
    //   594: istore #24
    //   596: goto -> 1015
    //   599: ldc 'private'
    //   601: aload #17
    //   603: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   606: ifeq -> 651
    //   609: iconst_1
    //   610: istore #26
    //   612: iload #5
    //   614: istore #30
    //   616: iload #6
    //   618: istore #25
    //   620: iload #7
    //   622: istore #28
    //   624: iload #8
    //   626: istore #23
    //   628: iload #10
    //   630: istore #29
    //   632: iload #11
    //   634: istore #21
    //   636: iload #12
    //   638: istore #27
    //   640: iload #13
    //   642: istore #19
    //   644: iload #14
    //   646: istore #24
    //   648: goto -> 1015
    //   651: ldc 'public'
    //   653: aload #17
    //   655: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   658: ifeq -> 703
    //   661: iconst_1
    //   662: istore #29
    //   664: iload #5
    //   666: istore #30
    //   668: iload #6
    //   670: istore #25
    //   672: iload #7
    //   674: istore #28
    //   676: iload #8
    //   678: istore #23
    //   680: iload #9
    //   682: istore #26
    //   684: iload #11
    //   686: istore #21
    //   688: iload #12
    //   690: istore #27
    //   692: iload #13
    //   694: istore #19
    //   696: iload #14
    //   698: istore #24
    //   700: goto -> 1015
    //   703: ldc 'must-revalidate'
    //   705: aload #17
    //   707: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   710: ifeq -> 755
    //   713: iconst_1
    //   714: istore #21
    //   716: iload #5
    //   718: istore #30
    //   720: iload #6
    //   722: istore #25
    //   724: iload #7
    //   726: istore #28
    //   728: iload #8
    //   730: istore #23
    //   732: iload #9
    //   734: istore #26
    //   736: iload #10
    //   738: istore #29
    //   740: iload #12
    //   742: istore #27
    //   744: iload #13
    //   746: istore #19
    //   748: iload #14
    //   750: istore #24
    //   752: goto -> 1015
    //   755: ldc 'max-stale'
    //   757: aload #17
    //   759: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   762: ifeq -> 813
    //   765: aload #16
    //   767: ldc 2147483647
    //   769: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   772: istore #27
    //   774: iload #5
    //   776: istore #30
    //   778: iload #6
    //   780: istore #25
    //   782: iload #7
    //   784: istore #28
    //   786: iload #8
    //   788: istore #23
    //   790: iload #9
    //   792: istore #26
    //   794: iload #10
    //   796: istore #29
    //   798: iload #11
    //   800: istore #21
    //   802: iload #13
    //   804: istore #19
    //   806: iload #14
    //   808: istore #24
    //   810: goto -> 1015
    //   813: ldc 'min-fresh'
    //   815: aload #17
    //   817: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   820: ifeq -> 870
    //   823: aload #16
    //   825: iconst_m1
    //   826: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   829: istore #19
    //   831: iload #5
    //   833: istore #30
    //   835: iload #6
    //   837: istore #25
    //   839: iload #7
    //   841: istore #28
    //   843: iload #8
    //   845: istore #23
    //   847: iload #9
    //   849: istore #26
    //   851: iload #10
    //   853: istore #29
    //   855: iload #11
    //   857: istore #21
    //   859: iload #12
    //   861: istore #27
    //   863: iload #14
    //   865: istore #24
    //   867: goto -> 1015
    //   870: ldc 'only-if-cached'
    //   872: aload #17
    //   874: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   877: ifeq -> 922
    //   880: iconst_1
    //   881: istore #24
    //   883: iload #5
    //   885: istore #30
    //   887: iload #6
    //   889: istore #25
    //   891: iload #7
    //   893: istore #28
    //   895: iload #8
    //   897: istore #23
    //   899: iload #9
    //   901: istore #26
    //   903: iload #10
    //   905: istore #29
    //   907: iload #11
    //   909: istore #21
    //   911: iload #12
    //   913: istore #27
    //   915: iload #13
    //   917: istore #19
    //   919: goto -> 1015
    //   922: iload #5
    //   924: istore #30
    //   926: iload #6
    //   928: istore #25
    //   930: iload #7
    //   932: istore #28
    //   934: iload #8
    //   936: istore #23
    //   938: iload #9
    //   940: istore #26
    //   942: iload #10
    //   944: istore #29
    //   946: iload #11
    //   948: istore #21
    //   950: iload #12
    //   952: istore #27
    //   954: iload #13
    //   956: istore #19
    //   958: iload #14
    //   960: istore #24
    //   962: ldc 'no-transform'
    //   964: aload #17
    //   966: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   969: ifeq -> 1015
    //   972: iconst_1
    //   973: istore #15
    //   975: iload #14
    //   977: istore #24
    //   979: iload #13
    //   981: istore #19
    //   983: iload #12
    //   985: istore #27
    //   987: iload #11
    //   989: istore #21
    //   991: iload #10
    //   993: istore #29
    //   995: iload #9
    //   997: istore #26
    //   999: iload #8
    //   1001: istore #23
    //   1003: iload #7
    //   1005: istore #28
    //   1007: iload #6
    //   1009: istore #25
    //   1011: iload #5
    //   1013: istore #30
    //   1015: iload #22
    //   1017: istore #31
    //   1019: iload #30
    //   1021: istore #5
    //   1023: iload #25
    //   1025: istore #6
    //   1027: iload #28
    //   1029: istore #7
    //   1031: iload #23
    //   1033: istore #8
    //   1035: iload #26
    //   1037: istore #9
    //   1039: iload #29
    //   1041: istore #10
    //   1043: iload #21
    //   1045: istore #11
    //   1047: iload #27
    //   1049: istore #12
    //   1051: iload #19
    //   1053: istore #13
    //   1055: iload #24
    //   1057: istore #14
    //   1059: goto -> 160
    //   1062: iinc #2, 1
    //   1065: iload #19
    //   1067: istore_3
    //   1068: aload #16
    //   1070: astore #4
    //   1072: iload #20
    //   1074: istore #5
    //   1076: iload #21
    //   1078: istore #6
    //   1080: iload #22
    //   1082: istore #7
    //   1084: iload #23
    //   1086: istore #8
    //   1088: iload #24
    //   1090: istore #9
    //   1092: iload #25
    //   1094: istore #10
    //   1096: iload #26
    //   1098: istore #11
    //   1100: iload #27
    //   1102: istore #12
    //   1104: iload #28
    //   1106: istore #13
    //   1108: iload #29
    //   1110: istore #14
    //   1112: iload #30
    //   1114: istore #15
    //   1116: goto -> 45
    //   1119: iload_3
    //   1120: ifne -> 1129
    //   1123: aconst_null
    //   1124: astore #4
    //   1126: goto -> 1129
    //   1129: new com/squareup/okhttp/CacheControl
    //   1132: dup
    //   1133: iload #5
    //   1135: iload #6
    //   1137: iload #7
    //   1139: iload #8
    //   1141: iload #9
    //   1143: iload #10
    //   1145: iload #11
    //   1147: iload #12
    //   1149: iload #13
    //   1151: iload #14
    //   1153: iload #15
    //   1155: aload #4
    //   1157: invokespecial <init> : (ZZIIZZZIIZZLjava/lang/String;)V
    //   1160: areturn
  }
  
  public boolean isPrivate() {
    return this.isPrivate;
  }
  
  public boolean isPublic() {
    return this.isPublic;
  }
  
  public int maxAgeSeconds() {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds() {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds() {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate() {
    return this.mustRevalidate;
  }
  
  public boolean noCache() {
    return this.noCache;
  }
  
  public boolean noStore() {
    return this.noStore;
  }
  
  public boolean noTransform() {
    return this.noTransform;
  }
  
  public boolean onlyIfCached() {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds() {
    return this.sMaxAgeSeconds;
  }
  
  public String toString() {
    String str = this.headerValue;
    if (str == null) {
      str = headerValue();
      this.headerValue = str;
    } 
    return str;
  }
  
  public static final class Builder {
    int maxAgeSeconds = -1;
    
    int maxStaleSeconds = -1;
    
    int minFreshSeconds = -1;
    
    boolean noCache;
    
    boolean noStore;
    
    boolean noTransform;
    
    boolean onlyIfCached;
    
    public CacheControl build() {
      return new CacheControl(this);
    }
    
    public Builder maxAge(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxAgeSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxAge < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder maxStale(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxStaleSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxStale < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder minFresh(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.minFreshSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("minFresh < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder noCache() {
      this.noCache = true;
      return this;
    }
    
    public Builder noStore() {
      this.noStore = true;
      return this;
    }
    
    public Builder noTransform() {
      this.noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached() {
      this.onlyIfCached = true;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\CacheControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */