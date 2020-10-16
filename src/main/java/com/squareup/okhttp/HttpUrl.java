package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import okio.Buffer;

public final class HttpUrl {
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  
  static final String FRAGMENT_ENCODE_SET = "";
  
  static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  
  private static final char[] HEX_DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  
  static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  
  static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
  
  static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  
  static final String QUERY_ENCODE_SET = " \"'<>#";
  
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  
  private final String fragment;
  
  private final String host;
  
  private final String password;
  
  private final List<String> pathSegments;
  
  private final int port;
  
  private final List<String> queryNamesAndValues;
  
  private final String scheme;
  
  private final String url;
  
  private final String username;
  
  private HttpUrl(Builder paramBuilder) {
    String str;
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername, false);
    this.password = percentDecode(paramBuilder.encodedPassword, false);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments, false);
    List<String> list = paramBuilder.encodedQueryNamesAndValues;
    List list1 = null;
    if (list != null) {
      list = percentDecode(paramBuilder.encodedQueryNamesAndValues, true);
    } else {
      list = null;
    } 
    this.queryNamesAndValues = list;
    list = list1;
    if (paramBuilder.encodedFragment != null)
      str = percentDecode(paramBuilder.encodedFragment, false); 
    this.fragment = str;
    this.url = paramBuilder.toString();
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    for (int i = paramInt1; i < paramInt2; i += Character.charCount(j)) {
      int j = paramString1.codePointAt(i);
      if (j < 32 || j == 127 || (j >= 128 && paramBoolean3) || paramString2.indexOf(j) != -1 || (j == 37 && !paramBoolean1) || (j == 43 && paramBoolean2)) {
        Buffer buffer = new Buffer();
        buffer.writeUtf8(paramString1, paramInt1, i);
        canonicalize(buffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
        return buffer.readUtf8();
      } 
    } 
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  static void canonicalize(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: iload_2
    //   4: iload_3
    //   5: if_icmpge -> 280
    //   8: aload_1
    //   9: iload_2
    //   10: invokevirtual codePointAt : (I)I
    //   13: istore #9
    //   15: iload #5
    //   17: ifeq -> 67
    //   20: aload #8
    //   22: astore #10
    //   24: iload #9
    //   26: bipush #9
    //   28: if_icmpeq -> 265
    //   31: aload #8
    //   33: astore #10
    //   35: iload #9
    //   37: bipush #10
    //   39: if_icmpeq -> 265
    //   42: aload #8
    //   44: astore #10
    //   46: iload #9
    //   48: bipush #12
    //   50: if_icmpeq -> 265
    //   53: iload #9
    //   55: bipush #13
    //   57: if_icmpne -> 67
    //   60: aload #8
    //   62: astore #10
    //   64: goto -> 265
    //   67: iload #9
    //   69: bipush #43
    //   71: if_icmpne -> 109
    //   74: iload #6
    //   76: ifeq -> 109
    //   79: iload #5
    //   81: ifeq -> 91
    //   84: ldc '+'
    //   86: astore #11
    //   88: goto -> 95
    //   91: ldc '%2B'
    //   93: astore #11
    //   95: aload_0
    //   96: aload #11
    //   98: invokevirtual writeUtf8 : (Ljava/lang/String;)Lokio/Buffer;
    //   101: pop
    //   102: aload #8
    //   104: astore #10
    //   106: goto -> 265
    //   109: iload #9
    //   111: bipush #32
    //   113: if_icmplt -> 176
    //   116: iload #9
    //   118: bipush #127
    //   120: if_icmpeq -> 176
    //   123: iload #9
    //   125: sipush #128
    //   128: if_icmplt -> 136
    //   131: iload #7
    //   133: ifne -> 176
    //   136: aload #4
    //   138: iload #9
    //   140: invokevirtual indexOf : (I)I
    //   143: iconst_m1
    //   144: if_icmpne -> 176
    //   147: iload #9
    //   149: bipush #37
    //   151: if_icmpne -> 162
    //   154: iload #5
    //   156: ifne -> 162
    //   159: goto -> 176
    //   162: aload_0
    //   163: iload #9
    //   165: invokevirtual writeUtf8CodePoint : (I)Lokio/Buffer;
    //   168: pop
    //   169: aload #8
    //   171: astore #10
    //   173: goto -> 265
    //   176: aload #8
    //   178: astore #11
    //   180: aload #8
    //   182: ifnonnull -> 194
    //   185: new okio/Buffer
    //   188: dup
    //   189: invokespecial <init> : ()V
    //   192: astore #11
    //   194: aload #11
    //   196: iload #9
    //   198: invokevirtual writeUtf8CodePoint : (I)Lokio/Buffer;
    //   201: pop
    //   202: aload #11
    //   204: astore #10
    //   206: aload #11
    //   208: invokevirtual exhausted : ()Z
    //   211: ifne -> 265
    //   214: aload #11
    //   216: invokevirtual readByte : ()B
    //   219: sipush #255
    //   222: iand
    //   223: istore #12
    //   225: aload_0
    //   226: bipush #37
    //   228: invokevirtual writeByte : (I)Lokio/Buffer;
    //   231: pop
    //   232: aload_0
    //   233: getstatic com/squareup/okhttp/HttpUrl.HEX_DIGITS : [C
    //   236: iload #12
    //   238: iconst_4
    //   239: ishr
    //   240: bipush #15
    //   242: iand
    //   243: caload
    //   244: invokevirtual writeByte : (I)Lokio/Buffer;
    //   247: pop
    //   248: aload_0
    //   249: getstatic com/squareup/okhttp/HttpUrl.HEX_DIGITS : [C
    //   252: iload #12
    //   254: bipush #15
    //   256: iand
    //   257: caload
    //   258: invokevirtual writeByte : (I)Lokio/Buffer;
    //   261: pop
    //   262: goto -> 202
    //   265: iload_2
    //   266: iload #9
    //   268: invokestatic charCount : (I)I
    //   271: iadd
    //   272: istore_2
    //   273: aload #10
    //   275: astore #8
    //   277: goto -> 3
    //   280: return
  }
  
  static int decodeHexDigit(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    byte b = 97;
    if (paramChar < 'a' || paramChar > 'f') {
      b = 65;
      if (paramChar < 'A' || paramChar > 'F')
        return -1; 
    } 
    return paramChar - b + 10;
  }
  
  public static int defaultPort(String paramString) {
    return paramString.equals("http") ? 80 : (paramString.equals("https") ? 443 : -1);
  }
  
  private static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    while (paramInt1 < paramInt2) {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1)
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  public static HttpUrl get(URI paramURI) {
    return parse(paramURI.toString());
  }
  
  public static HttpUrl get(URL paramURL) {
    return parse(paramURL.toString());
  }
  
  static HttpUrl getChecked(String paramString) throws MalformedURLException, UnknownHostException {
    StringBuilder stringBuilder;
    Builder builder = new Builder();
    Builder.ParseResult parseResult = builder.parse(null, paramString);
    int i = null.$SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[parseResult.ordinal()];
    if (i != 1) {
      if (i != 2) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL: ");
        stringBuilder.append(parseResult);
        stringBuilder.append(" for ");
        stringBuilder.append(paramString);
        throw new MalformedURLException(stringBuilder.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid host: ");
      stringBuilder1.append(paramString);
      throw new UnknownHostException(stringBuilder1.toString());
    } 
    return stringBuilder.build();
  }
  
  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList) {
    int i = paramList.size();
    for (byte b = 0; b < i; b += 2) {
      String str1 = paramList.get(b);
      String str2 = paramList.get(b + 1);
      if (b > 0)
        paramStringBuilder.append('&'); 
      paramStringBuilder.append(str1);
      if (str2 != null) {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      } 
    } 
  }
  
  public static HttpUrl parse(String paramString) {
    Builder builder = new Builder();
    HttpUrl httpUrl = null;
    if (builder.parse(null, paramString) == Builder.ParseResult.SUCCESS)
      httpUrl = builder.build(); 
    return httpUrl;
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList) {
    int i = paramList.size();
    for (byte b = 0; b < i; b++) {
      paramStringBuilder.append('/');
      paramStringBuilder.append(paramList.get(b));
    } 
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    for (int i = paramInt1; i < paramInt2; i++) {
      char c = paramString.charAt(i);
      if (c == '%' || (c == '+' && paramBoolean)) {
        Buffer buffer = new Buffer();
        buffer.writeUtf8(paramString, paramInt1, i);
        percentDecode(buffer, paramString, i, paramInt2, paramBoolean);
        return buffer.readUtf8();
      } 
    } 
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String percentDecode(String paramString, boolean paramBoolean) {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> percentDecode(List<String> paramList, boolean paramBoolean) {
    ArrayList<String> arrayList = new ArrayList(paramList.size());
    for (String str : paramList) {
      if (str != null) {
        str = percentDecode(str, paramBoolean);
      } else {
        str = null;
      } 
      arrayList.add(str);
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  static void percentDecode(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: if_icmpge -> 123
    //   5: aload_1
    //   6: iload_2
    //   7: invokevirtual codePointAt : (I)I
    //   10: istore #5
    //   12: iload #5
    //   14: bipush #37
    //   16: if_icmpne -> 83
    //   19: iload_2
    //   20: iconst_2
    //   21: iadd
    //   22: istore #6
    //   24: iload #6
    //   26: iload_3
    //   27: if_icmpge -> 83
    //   30: aload_1
    //   31: iload_2
    //   32: iconst_1
    //   33: iadd
    //   34: invokevirtual charAt : (I)C
    //   37: invokestatic decodeHexDigit : (C)I
    //   40: istore #7
    //   42: aload_1
    //   43: iload #6
    //   45: invokevirtual charAt : (I)C
    //   48: invokestatic decodeHexDigit : (C)I
    //   51: istore #8
    //   53: iload #7
    //   55: iconst_m1
    //   56: if_icmpeq -> 105
    //   59: iload #8
    //   61: iconst_m1
    //   62: if_icmpeq -> 105
    //   65: aload_0
    //   66: iload #7
    //   68: iconst_4
    //   69: ishl
    //   70: iload #8
    //   72: iadd
    //   73: invokevirtual writeByte : (I)Lokio/Buffer;
    //   76: pop
    //   77: iload #6
    //   79: istore_2
    //   80: goto -> 112
    //   83: iload #5
    //   85: bipush #43
    //   87: if_icmpne -> 105
    //   90: iload #4
    //   92: ifeq -> 105
    //   95: aload_0
    //   96: bipush #32
    //   98: invokevirtual writeByte : (I)Lokio/Buffer;
    //   101: pop
    //   102: goto -> 112
    //   105: aload_0
    //   106: iload #5
    //   108: invokevirtual writeUtf8CodePoint : (I)Lokio/Buffer;
    //   111: pop
    //   112: iload_2
    //   113: iload #5
    //   115: invokestatic charCount : (I)I
    //   118: iadd
    //   119: istore_2
    //   120: goto -> 0
    //   123: return
  }
  
  static List<String> queryStringToNamesAndValues(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i <= paramString.length(); i = k + 1) {
      int j = paramString.indexOf('&', i);
      int k = j;
      if (j == -1)
        k = paramString.length(); 
      j = paramString.indexOf('=', i);
      if (j == -1 || j > k) {
        arrayList.add(paramString.substring(i, k));
        arrayList.add(null);
      } else {
        arrayList.add(paramString.substring(i, j));
        arrayList.add(paramString.substring(j + 1, k));
      } 
    } 
    return arrayList;
  }
  
  public String encodedFragment() {
    if (this.fragment == null)
      return null; 
    int i = this.url.indexOf('#');
    return this.url.substring(i + 1);
  }
  
  public String encodedPassword() {
    if (this.password.isEmpty())
      return ""; 
    int i = this.url.indexOf(':', this.scheme.length() + 3);
    int j = this.url.indexOf('@');
    return this.url.substring(i + 1, j);
  }
  
  public String encodedPath() {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), "?#");
    return this.url.substring(i, j);
  }
  
  public List<String> encodedPathSegments() {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), "?#");
    ArrayList<String> arrayList = new ArrayList();
    while (i < j) {
      int k = i + 1;
      i = delimiterOffset(this.url, k, j, "/");
      arrayList.add(this.url.substring(k, i));
    } 
    return arrayList;
  }
  
  public String encodedQuery() {
    if (this.queryNamesAndValues == null)
      return null; 
    int i = this.url.indexOf('?') + 1;
    String str = this.url;
    int j = delimiterOffset(str, i + 1, str.length(), "#");
    return this.url.substring(i, j);
  }
  
  public String encodedUsername() {
    if (this.username.isEmpty())
      return ""; 
    int i = this.scheme.length() + 3;
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), ":@");
    return this.url.substring(i, j);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof HttpUrl && ((HttpUrl)paramObject).url.equals(this.url)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String fragment() {
    return this.fragment;
  }
  
  public int hashCode() {
    return this.url.hashCode();
  }
  
  public String host() {
    return this.host;
  }
  
  public boolean isHttps() {
    return this.scheme.equals("https");
  }
  
  public Builder newBuilder() {
    byte b;
    Builder builder = new Builder();
    builder.scheme = this.scheme;
    builder.encodedUsername = encodedUsername();
    builder.encodedPassword = encodedPassword();
    builder.host = this.host;
    if (this.port != defaultPort(this.scheme)) {
      b = this.port;
    } else {
      b = -1;
    } 
    builder.port = b;
    builder.encodedPathSegments.clear();
    builder.encodedPathSegments.addAll(encodedPathSegments());
    builder.encodedQuery(encodedQuery());
    builder.encodedFragment = encodedFragment();
    return builder;
  }
  
  public String password() {
    return this.password;
  }
  
  public List<String> pathSegments() {
    return this.pathSegments;
  }
  
  public int pathSize() {
    return this.pathSegments.size();
  }
  
  public int port() {
    return this.port;
  }
  
  public String query() {
    if (this.queryNamesAndValues == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    namesAndValuesToQueryString(stringBuilder, this.queryNamesAndValues);
    return stringBuilder.toString();
  }
  
  public String queryParameter(String paramString) {
    List<String> list = this.queryNamesAndValues;
    if (list == null)
      return null; 
    byte b = 0;
    int i = list.size();
    while (b < i) {
      if (paramString.equals(this.queryNamesAndValues.get(b)))
        return this.queryNamesAndValues.get(b + 1); 
      b += 2;
    } 
    return null;
  }
  
  public String queryParameterName(int paramInt) {
    return this.queryNamesAndValues.get(paramInt * 2);
  }
  
  public Set<String> queryParameterNames() {
    if (this.queryNamesAndValues == null)
      return Collections.emptySet(); 
    LinkedHashSet<? extends String> linkedHashSet = new LinkedHashSet();
    byte b = 0;
    int i = this.queryNamesAndValues.size();
    while (b < i) {
      linkedHashSet.add(this.queryNamesAndValues.get(b));
      b += 2;
    } 
    return Collections.unmodifiableSet(linkedHashSet);
  }
  
  public String queryParameterValue(int paramInt) {
    return this.queryNamesAndValues.get(paramInt * 2 + 1);
  }
  
  public List<String> queryParameterValues(String paramString) {
    if (this.queryNamesAndValues == null)
      return Collections.emptyList(); 
    ArrayList<? extends String> arrayList = new ArrayList();
    byte b = 0;
    int i = this.queryNamesAndValues.size();
    while (b < i) {
      if (paramString.equals(this.queryNamesAndValues.get(b)))
        arrayList.add(this.queryNamesAndValues.get(b + 1)); 
      b += 2;
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  public int querySize() {
    boolean bool;
    List<String> list = this.queryNamesAndValues;
    if (list != null) {
      bool = list.size() / 2;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public HttpUrl resolve(String paramString) {
    Builder builder = new Builder();
    if (builder.parse(this, paramString) == Builder.ParseResult.SUCCESS) {
      HttpUrl httpUrl = builder.build();
    } else {
      paramString = null;
    } 
    return (HttpUrl)paramString;
  }
  
  public String scheme() {
    return this.scheme;
  }
  
  public String toString() {
    return this.url;
  }
  
  public URI uri() {
    try {
      return new URI(newBuilder().reencodeForUri().toString());
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not valid as a java.net.URI: ");
      stringBuilder.append(this.url);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  public URL url() {
    try {
      return new URL(this.url);
    } catch (MalformedURLException malformedURLException) {
      throw new RuntimeException(malformedURLException);
    } 
  }
  
  public String username() {
    return this.username;
  }
  
  public static final class Builder {
    String encodedFragment;
    
    String encodedPassword = "";
    
    final List<String> encodedPathSegments = new ArrayList<>();
    
    List<String> encodedQueryNamesAndValues;
    
    String encodedUsername = "";
    
    String host;
    
    int port = -1;
    
    String scheme;
    
    public Builder() {
      this.encodedPathSegments.add("");
    }
    
    private static String canonicalizeHost(String param1String, int param1Int1, int param1Int2) {
      byte[] arrayOfByte;
      param1String = HttpUrl.percentDecode(param1String, param1Int1, param1Int2, false);
      if (param1String.startsWith("[") && param1String.endsWith("]")) {
        InetAddress inetAddress = decodeIpv6(param1String, 1, param1String.length() - 1);
        if (inetAddress == null)
          return null; 
        arrayOfByte = inetAddress.getAddress();
        if (arrayOfByte.length == 16)
          return inet6AddressToAscii(arrayOfByte); 
        throw new AssertionError();
      } 
      return domainToAscii((String)arrayOfByte);
    }
    
    private static boolean containsInvalidHostnameAsciiCodes(String param1String) {
      for (byte b = 0; b < param1String.length(); b++) {
        char c = param1String.charAt(b);
        if (c <= '\037' || c >= '')
          return true; 
        if (" #%/:?@[\\]".indexOf(c) != -1)
          return true; 
      } 
      return false;
    }
    
    private static boolean decodeIpv4Suffix(String param1String, int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3) {
      int i = param1Int3;
      int j = param1Int1;
      while (j < param1Int2) {
        if (i == param1ArrayOfbyte.length)
          return false; 
        param1Int1 = j;
        if (i != param1Int3) {
          if (param1String.charAt(j) != '.')
            return false; 
          param1Int1 = j + 1;
        } 
        j = param1Int1;
        int k = 0;
        while (j < param1Int2) {
          char c = param1String.charAt(j);
          if (c < '0' || c > '9')
            break; 
          if (!k && param1Int1 != j)
            return false; 
          k = k * 10 + c - 48;
          if (k > 255)
            return false; 
          j++;
        } 
        if (j - param1Int1 == 0)
          return false; 
        param1ArrayOfbyte[i] = (byte)(byte)k;
        i++;
      } 
      return !(i != param1Int3 + 4);
    }
    
    private static InetAddress decodeIpv6(String param1String, int param1Int1, int param1Int2) {
      int m;
      int n;
      byte[] arrayOfByte = new byte[16];
      int i = -1;
      int j = i;
      int k = 0;
      while (true) {
        m = k;
        n = i;
        if (param1Int1 < param1Int2) {
          if (k == arrayOfByte.length)
            return null; 
          n = param1Int1 + 2;
          if (n <= param1Int2 && param1String.regionMatches(param1Int1, "::", 0, 2)) {
            if (i != -1)
              return null; 
            m = k + 2;
            param1Int1 = m;
            if (n == param1Int2) {
              n = param1Int1;
              break;
            } 
            j = n;
            k = m;
            i = param1Int1;
            param1Int1 = j;
          } else {
            m = param1Int1;
            if (k != 0)
              if (param1String.regionMatches(param1Int1, ":", 0, 1)) {
                m = param1Int1 + 1;
              } else {
                if (param1String.regionMatches(param1Int1, ".", 0, 1)) {
                  if (!decodeIpv4Suffix(param1String, j, param1Int2, arrayOfByte, k - 2))
                    return null; 
                  m = k + 2;
                  n = i;
                  break;
                } 
                return null;
              }  
            param1Int1 = m;
          } 
          j = 0;
          for (m = param1Int1; m < param1Int2; m++) {
            n = HttpUrl.decodeHexDigit(param1String.charAt(m));
            if (n == -1)
              break; 
            j = (j << 4) + n;
          } 
          n = m - param1Int1;
          if (n == 0 || n > 4)
            return null; 
          n = k + 1;
          arrayOfByte[k] = (byte)(byte)(j >>> 8 & 0xFF);
          k = n + 1;
          arrayOfByte[n] = (byte)(byte)(j & 0xFF);
          j = param1Int1;
          param1Int1 = m;
          continue;
        } 
        break;
      } 
      if (m != arrayOfByte.length) {
        if (n == -1)
          return null; 
        param1Int1 = arrayOfByte.length;
        param1Int2 = m - n;
        System.arraycopy(arrayOfByte, n, arrayOfByte, param1Int1 - param1Int2, param1Int2);
        Arrays.fill(arrayOfByte, n, arrayOfByte.length - m + n, (byte)0);
      } 
      try {
        return InetAddress.getByAddress(arrayOfByte);
      } catch (UnknownHostException unknownHostException) {
        throw new AssertionError();
      } 
    }
    
    private static String domainToAscii(String param1String) {
      try {
        param1String = IDN.toASCII(param1String).toLowerCase(Locale.US);
        if (param1String.isEmpty())
          return null; 
        boolean bool = containsInvalidHostnameAsciiCodes(param1String);
        return bool ? null : param1String;
      } catch (IllegalArgumentException illegalArgumentException) {
        return null;
      } 
    }
    
    private static String inet6AddressToAscii(byte[] param1ArrayOfbyte) {
      boolean bool = false;
      int i = 0;
      int j = -1;
      int k = i;
      while (k < param1ArrayOfbyte.length) {
        int m;
        for (m = k; m < 16 && param1ArrayOfbyte[m] == 0 && param1ArrayOfbyte[m + 1] == 0; m += 2);
        int n = m - k;
        int i1 = i;
        if (n > i) {
          i1 = n;
          j = k;
        } 
        k = m + 2;
        i = i1;
      } 
      Buffer buffer = new Buffer();
      for (k = bool; k < param1ArrayOfbyte.length; k += 2) {
        if (k == j) {
          buffer.writeByte(58);
          int m = k + i;
          k = m;
          if (m == 16) {
            buffer.writeByte(58);
            k = m;
          } 
          continue;
        } 
        if (k > 0)
          buffer.writeByte(58); 
        buffer.writeHexadecimalUnsignedLong(((param1ArrayOfbyte[k] & 0xFF) << 8 | param1ArrayOfbyte[k + 1] & 0xFF));
      } 
      return buffer.readUtf8();
    }
    
    private boolean isDot(String param1String) {
      return (param1String.equals(".") || param1String.equalsIgnoreCase("%2e"));
    }
    
    private boolean isDotDot(String param1String) {
      return (param1String.equals("..") || param1String.equalsIgnoreCase("%2e.") || param1String.equalsIgnoreCase(".%2e") || param1String.equalsIgnoreCase("%2e%2e"));
    }
    
    private static int parsePort(String param1String, int param1Int1, int param1Int2) {
      try {
        param1Int1 = Integer.parseInt(HttpUrl.canonicalize(param1String, param1Int1, param1Int2, "", false, false, true));
        if (param1Int1 > 0 && param1Int1 <= 65535)
          return param1Int1; 
      } catch (NumberFormatException numberFormatException) {}
      return -1;
    }
    
    private void pop() {
      List<String> list = this.encodedPathSegments;
      if (((String)list.remove(list.size() - 1)).isEmpty() && !this.encodedPathSegments.isEmpty()) {
        list = this.encodedPathSegments;
        list.set(list.size() - 1, "");
      } else {
        this.encodedPathSegments.add("");
      } 
    }
    
    private static int portColonOffset(String param1String, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c != ':') {
          int i = param1Int1;
          if (c != '[') {
            i = param1Int1;
          } else {
            while (true) {
              param1Int1 = i + 1;
              i = param1Int1;
              if (param1Int1 < param1Int2) {
                i = param1Int1;
                if (param1String.charAt(param1Int1) == ']') {
                  i = param1Int1;
                  break;
                } 
                continue;
              } 
              break;
            } 
          } 
          param1Int1 = i + 1;
          continue;
        } 
        return param1Int1;
      } 
      return param1Int2;
    }
    
    private void push(String param1String, int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2) {
      param1String = HttpUrl.canonicalize(param1String, param1Int1, param1Int2, " \"<>^`{}|/\\?#", param1Boolean2, false, true);
      if (isDot(param1String))
        return; 
      if (isDotDot(param1String)) {
        pop();
        return;
      } 
      List<String> list = this.encodedPathSegments;
      if (((String)list.get(list.size() - 1)).isEmpty()) {
        list = this.encodedPathSegments;
        list.set(list.size() - 1, param1String);
      } else {
        this.encodedPathSegments.add(param1String);
      } 
      if (param1Boolean1)
        this.encodedPathSegments.add(""); 
    }
    
    private void removeAllCanonicalQueryParameters(String param1String) {
      for (int i = this.encodedQueryNamesAndValues.size() - 2; i >= 0; i -= 2) {
        if (param1String.equals(this.encodedQueryNamesAndValues.get(i))) {
          this.encodedQueryNamesAndValues.remove(i + 1);
          this.encodedQueryNamesAndValues.remove(i);
          if (this.encodedQueryNamesAndValues.isEmpty()) {
            this.encodedQueryNamesAndValues = null;
            return;
          } 
        } 
      } 
    }
    
    private void resolvePath(String param1String, int param1Int1, int param1Int2) {
      if (param1Int1 == param1Int2)
        return; 
      char c = param1String.charAt(param1Int1);
      if (c == '/' || c == '\\') {
        this.encodedPathSegments.clear();
        this.encodedPathSegments.add("");
      } else {
        List<String> list = this.encodedPathSegments;
        list.set(list.size() - 1, "");
        while (true) {
          if (param1Int1 < param1Int2) {
            boolean bool;
            int i = HttpUrl.delimiterOffset(param1String, param1Int1, param1Int2, "/\\");
            if (i < param1Int2) {
              bool = true;
            } else {
              bool = false;
            } 
            push(param1String, param1Int1, i, bool, true);
            param1Int1 = i;
            if (bool) {
              param1Int1 = i;
            } else {
              continue;
            } 
          } else {
            break;
          } 
          param1Int1++;
        } 
        return;
      } 
      param1Int1++;
      continue;
    }
    
    private static int schemeDelimiterOffset(String param1String, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: iload_2
      //   1: iload_1
      //   2: isub
      //   3: iconst_2
      //   4: if_icmpge -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual charAt : (I)C
      //   14: istore_3
      //   15: iload_3
      //   16: bipush #97
      //   18: if_icmplt -> 30
      //   21: iload_1
      //   22: istore #4
      //   24: iload_3
      //   25: bipush #122
      //   27: if_icmple -> 48
      //   30: iload_3
      //   31: bipush #65
      //   33: if_icmplt -> 147
      //   36: iload_1
      //   37: istore #4
      //   39: iload_3
      //   40: bipush #90
      //   42: if_icmple -> 48
      //   45: goto -> 147
      //   48: iload #4
      //   50: iconst_1
      //   51: iadd
      //   52: istore_1
      //   53: iload_1
      //   54: iload_2
      //   55: if_icmpge -> 147
      //   58: aload_0
      //   59: iload_1
      //   60: invokevirtual charAt : (I)C
      //   63: istore_3
      //   64: iload_3
      //   65: bipush #97
      //   67: if_icmplt -> 79
      //   70: iload_1
      //   71: istore #4
      //   73: iload_3
      //   74: bipush #122
      //   76: if_icmple -> 48
      //   79: iload_3
      //   80: bipush #65
      //   82: if_icmplt -> 94
      //   85: iload_1
      //   86: istore #4
      //   88: iload_3
      //   89: bipush #90
      //   91: if_icmple -> 48
      //   94: iload_3
      //   95: bipush #48
      //   97: if_icmplt -> 109
      //   100: iload_1
      //   101: istore #4
      //   103: iload_3
      //   104: bipush #57
      //   106: if_icmple -> 48
      //   109: iload_1
      //   110: istore #4
      //   112: iload_3
      //   113: bipush #43
      //   115: if_icmpeq -> 48
      //   118: iload_1
      //   119: istore #4
      //   121: iload_3
      //   122: bipush #45
      //   124: if_icmpeq -> 48
      //   127: iload_3
      //   128: bipush #46
      //   130: if_icmpne -> 139
      //   133: iload_1
      //   134: istore #4
      //   136: goto -> 48
      //   139: iload_3
      //   140: bipush #58
      //   142: if_icmpne -> 147
      //   145: iload_1
      //   146: ireturn
      //   147: iconst_m1
      //   148: ireturn
    }
    
    private int skipLeadingAsciiWhitespace(String param1String, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ')
          return param1Int1; 
        param1Int1++;
      } 
      return param1Int2;
    }
    
    private int skipTrailingAsciiWhitespace(String param1String, int param1Int1, int param1Int2) {
      while (--param1Int2 >= param1Int1) {
        char c = param1String.charAt(param1Int2);
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ')
          return param1Int2 + 1; 
        param1Int2--;
      } 
      return param1Int1;
    }
    
    private static int slashCount(String param1String, int param1Int1, int param1Int2) {
      byte b = 0;
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c == '\\' || c == '/') {
          b++;
          param1Int1++;
        } 
      } 
      return b;
    }
    
    public Builder addEncodedPathSegment(String param1String) {
      if (param1String != null) {
        push(param1String, 0, param1String.length(), false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    
    public Builder addEncodedQueryParameter(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (this.encodedQueryNamesAndValues == null)
          this.encodedQueryNamesAndValues = new ArrayList<>(); 
        this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(param1String1, " \"'<>#&=", true, true, true));
        List<String> list = this.encodedQueryNamesAndValues;
        if (param1String2 != null) {
          param1String1 = HttpUrl.canonicalize(param1String2, " \"'<>#&=", true, true, true);
        } else {
          param1String1 = null;
        } 
        list.add(param1String1);
        return this;
      } 
      throw new IllegalArgumentException("encodedName == null");
    }
    
    public Builder addPathSegment(String param1String) {
      if (param1String != null) {
        push(param1String, 0, param1String.length(), false, false);
        return this;
      } 
      throw new IllegalArgumentException("pathSegment == null");
    }
    
    public Builder addQueryParameter(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (this.encodedQueryNamesAndValues == null)
          this.encodedQueryNamesAndValues = new ArrayList<>(); 
        this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(param1String1, " \"'<>#&=", false, true, true));
        List<String> list = this.encodedQueryNamesAndValues;
        if (param1String2 != null) {
          param1String1 = HttpUrl.canonicalize(param1String2, " \"'<>#&=", false, true, true);
        } else {
          param1String1 = null;
        } 
        list.add(param1String1);
        return this;
      } 
      throw new IllegalArgumentException("name == null");
    }
    
    public HttpUrl build() {
      if (this.scheme != null) {
        if (this.host != null)
          return new HttpUrl(this); 
        throw new IllegalStateException("host == null");
      } 
      throw new IllegalStateException("scheme == null");
    }
    
    int effectivePort() {
      int i = this.port;
      if (i == -1)
        i = HttpUrl.defaultPort(this.scheme); 
      return i;
    }
    
    public Builder encodedFragment(String param1String) {
      if (param1String != null) {
        param1String = HttpUrl.canonicalize(param1String, "", true, false, false);
      } else {
        param1String = null;
      } 
      this.encodedFragment = param1String;
      return this;
    }
    
    public Builder encodedPassword(String param1String) {
      if (param1String != null) {
        this.encodedPassword = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedPassword == null");
    }
    
    public Builder encodedPath(String param1String) {
      if (param1String != null) {
        if (param1String.startsWith("/")) {
          resolvePath(param1String, 0, param1String.length());
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected encodedPath: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("encodedPath == null");
    }
    
    public Builder encodedQuery(String param1String) {
      if (param1String != null) {
        List<String> list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(param1String, " \"'<>#", true, true, true));
      } else {
        param1String = null;
      } 
      this.encodedQueryNamesAndValues = (List<String>)param1String;
      return this;
    }
    
    public Builder encodedUsername(String param1String) {
      if (param1String != null) {
        this.encodedUsername = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedUsername == null");
    }
    
    public Builder fragment(String param1String) {
      if (param1String != null) {
        param1String = HttpUrl.canonicalize(param1String, "", false, false, false);
      } else {
        param1String = null;
      } 
      this.encodedFragment = param1String;
      return this;
    }
    
    public Builder host(String param1String) {
      if (param1String != null) {
        String str = canonicalizeHost(param1String, 0, param1String.length());
        if (str != null) {
          this.host = str;
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected host: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("host == null");
    }
    
    ParseResult parse(HttpUrl param1HttpUrl, String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: iconst_0
      //   3: aload_2
      //   4: invokevirtual length : ()I
      //   7: invokespecial skipLeadingAsciiWhitespace : (Ljava/lang/String;II)I
      //   10: istore_3
      //   11: aload_0
      //   12: aload_2
      //   13: iload_3
      //   14: aload_2
      //   15: invokevirtual length : ()I
      //   18: invokespecial skipTrailingAsciiWhitespace : (Ljava/lang/String;II)I
      //   21: istore #4
      //   23: aload_2
      //   24: iload_3
      //   25: iload #4
      //   27: invokestatic schemeDelimiterOffset : (Ljava/lang/String;II)I
      //   30: iconst_m1
      //   31: if_icmpeq -> 93
      //   34: aload_2
      //   35: iconst_1
      //   36: iload_3
      //   37: ldc_w 'https:'
      //   40: iconst_0
      //   41: bipush #6
      //   43: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
      //   46: ifeq -> 62
      //   49: aload_0
      //   50: ldc_w 'https'
      //   53: putfield scheme : Ljava/lang/String;
      //   56: iinc #3, 6
      //   59: goto -> 105
      //   62: aload_2
      //   63: iconst_1
      //   64: iload_3
      //   65: ldc_w 'http:'
      //   68: iconst_0
      //   69: iconst_5
      //   70: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
      //   73: ifeq -> 89
      //   76: aload_0
      //   77: ldc_w 'http'
      //   80: putfield scheme : Ljava/lang/String;
      //   83: iinc #3, 5
      //   86: goto -> 105
      //   89: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.UNSUPPORTED_SCHEME : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   92: areturn
      //   93: aload_1
      //   94: ifnull -> 714
      //   97: aload_0
      //   98: aload_1
      //   99: invokestatic access$100 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   102: putfield scheme : Ljava/lang/String;
      //   105: aload_2
      //   106: iload_3
      //   107: iload #4
      //   109: invokestatic slashCount : (Ljava/lang/String;II)I
      //   112: istore #5
      //   114: iload #5
      //   116: iconst_2
      //   117: if_icmpge -> 230
      //   120: aload_1
      //   121: ifnull -> 230
      //   124: aload_1
      //   125: invokestatic access$100 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   128: aload_0
      //   129: getfield scheme : Ljava/lang/String;
      //   132: invokevirtual equals : (Ljava/lang/Object;)Z
      //   135: ifne -> 141
      //   138: goto -> 230
      //   141: aload_0
      //   142: aload_1
      //   143: invokevirtual encodedUsername : ()Ljava/lang/String;
      //   146: putfield encodedUsername : Ljava/lang/String;
      //   149: aload_0
      //   150: aload_1
      //   151: invokevirtual encodedPassword : ()Ljava/lang/String;
      //   154: putfield encodedPassword : Ljava/lang/String;
      //   157: aload_0
      //   158: aload_1
      //   159: invokestatic access$300 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   162: putfield host : Ljava/lang/String;
      //   165: aload_0
      //   166: aload_1
      //   167: invokestatic access$400 : (Lcom/squareup/okhttp/HttpUrl;)I
      //   170: putfield port : I
      //   173: aload_0
      //   174: getfield encodedPathSegments : Ljava/util/List;
      //   177: invokeinterface clear : ()V
      //   182: aload_0
      //   183: getfield encodedPathSegments : Ljava/util/List;
      //   186: aload_1
      //   187: invokevirtual encodedPathSegments : ()Ljava/util/List;
      //   190: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   195: pop
      //   196: iload_3
      //   197: iload #4
      //   199: if_icmpeq -> 215
      //   202: iload_3
      //   203: istore #6
      //   205: aload_2
      //   206: iload_3
      //   207: invokevirtual charAt : (I)C
      //   210: bipush #35
      //   212: if_icmpne -> 596
      //   215: aload_0
      //   216: aload_1
      //   217: invokevirtual encodedQuery : ()Ljava/lang/String;
      //   220: invokevirtual encodedQuery : (Ljava/lang/String;)Lcom/squareup/okhttp/HttpUrl$Builder;
      //   223: pop
      //   224: iload_3
      //   225: istore #6
      //   227: goto -> 596
      //   230: iconst_0
      //   231: istore #6
      //   233: iload_3
      //   234: iload #5
      //   236: iadd
      //   237: istore #7
      //   239: iload #6
      //   241: istore_3
      //   242: aload_2
      //   243: iload #7
      //   245: iload #4
      //   247: ldc_w '@/\?#'
      //   250: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   253: istore #5
      //   255: iload #5
      //   257: iload #4
      //   259: if_icmpeq -> 273
      //   262: aload_2
      //   263: iload #5
      //   265: invokevirtual charAt : (I)C
      //   268: istore #8
      //   270: goto -> 276
      //   273: iconst_m1
      //   274: istore #8
      //   276: iload #8
      //   278: iconst_m1
      //   279: if_icmpeq -> 502
      //   282: iload #8
      //   284: bipush #35
      //   286: if_icmpeq -> 502
      //   289: iload #8
      //   291: bipush #47
      //   293: if_icmpeq -> 502
      //   296: iload #8
      //   298: bipush #92
      //   300: if_icmpeq -> 502
      //   303: iload #8
      //   305: bipush #63
      //   307: if_icmpeq -> 502
      //   310: iload #8
      //   312: bipush #64
      //   314: if_icmpeq -> 320
      //   317: goto -> 499
      //   320: iload_3
      //   321: ifne -> 441
      //   324: aload_2
      //   325: iload #7
      //   327: iload #5
      //   329: ldc ':'
      //   331: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   334: istore #9
      //   336: iload #5
      //   338: istore #8
      //   340: aload_2
      //   341: iload #7
      //   343: iload #9
      //   345: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   348: iconst_1
      //   349: iconst_0
      //   350: iconst_1
      //   351: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   354: astore #10
      //   356: aload #10
      //   358: astore_1
      //   359: iload #6
      //   361: ifeq -> 401
      //   364: new java/lang/StringBuilder
      //   367: dup
      //   368: invokespecial <init> : ()V
      //   371: astore_1
      //   372: aload_1
      //   373: aload_0
      //   374: getfield encodedUsername : Ljava/lang/String;
      //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   380: pop
      //   381: aload_1
      //   382: ldc_w '%40'
      //   385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   388: pop
      //   389: aload_1
      //   390: aload #10
      //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   395: pop
      //   396: aload_1
      //   397: invokevirtual toString : ()Ljava/lang/String;
      //   400: astore_1
      //   401: aload_0
      //   402: aload_1
      //   403: putfield encodedUsername : Ljava/lang/String;
      //   406: iload #9
      //   408: iload #8
      //   410: if_icmpeq -> 435
      //   413: aload_0
      //   414: aload_2
      //   415: iload #9
      //   417: iconst_1
      //   418: iadd
      //   419: iload #8
      //   421: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   424: iconst_1
      //   425: iconst_0
      //   426: iconst_1
      //   427: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   430: putfield encodedPassword : Ljava/lang/String;
      //   433: iconst_1
      //   434: istore_3
      //   435: iconst_1
      //   436: istore #6
      //   438: goto -> 493
      //   441: new java/lang/StringBuilder
      //   444: dup
      //   445: invokespecial <init> : ()V
      //   448: astore_1
      //   449: aload_1
      //   450: aload_0
      //   451: getfield encodedPassword : Ljava/lang/String;
      //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   457: pop
      //   458: aload_1
      //   459: ldc_w '%40'
      //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   465: pop
      //   466: aload_1
      //   467: aload_2
      //   468: iload #7
      //   470: iload #5
      //   472: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   475: iconst_1
      //   476: iconst_0
      //   477: iconst_1
      //   478: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   481: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   484: pop
      //   485: aload_0
      //   486: aload_1
      //   487: invokevirtual toString : ()Ljava/lang/String;
      //   490: putfield encodedPassword : Ljava/lang/String;
      //   493: iload #5
      //   495: iconst_1
      //   496: iadd
      //   497: istore #7
      //   499: goto -> 242
      //   502: aload_2
      //   503: iload #7
      //   505: iload #5
      //   507: invokestatic portColonOffset : (Ljava/lang/String;II)I
      //   510: istore #6
      //   512: iload #6
      //   514: iconst_1
      //   515: iadd
      //   516: istore_3
      //   517: iload_3
      //   518: iload #5
      //   520: if_icmpge -> 558
      //   523: aload_0
      //   524: aload_2
      //   525: iload #7
      //   527: iload #6
      //   529: invokestatic canonicalizeHost : (Ljava/lang/String;II)Ljava/lang/String;
      //   532: putfield host : Ljava/lang/String;
      //   535: aload_0
      //   536: aload_2
      //   537: iload_3
      //   538: iload #5
      //   540: invokestatic parsePort : (Ljava/lang/String;II)I
      //   543: putfield port : I
      //   546: aload_0
      //   547: getfield port : I
      //   550: iconst_m1
      //   551: if_icmpne -> 581
      //   554: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.INVALID_PORT : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   557: areturn
      //   558: aload_0
      //   559: aload_2
      //   560: iload #7
      //   562: iload #6
      //   564: invokestatic canonicalizeHost : (Ljava/lang/String;II)Ljava/lang/String;
      //   567: putfield host : Ljava/lang/String;
      //   570: aload_0
      //   571: aload_0
      //   572: getfield scheme : Ljava/lang/String;
      //   575: invokestatic defaultPort : (Ljava/lang/String;)I
      //   578: putfield port : I
      //   581: aload_0
      //   582: getfield host : Ljava/lang/String;
      //   585: ifnonnull -> 592
      //   588: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.INVALID_HOST : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   591: areturn
      //   592: iload #5
      //   594: istore #6
      //   596: aload_2
      //   597: iload #6
      //   599: iload #4
      //   601: ldc_w '?#'
      //   604: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   607: istore #5
      //   609: aload_0
      //   610: aload_2
      //   611: iload #6
      //   613: iload #5
      //   615: invokespecial resolvePath : (Ljava/lang/String;II)V
      //   618: iload #5
      //   620: istore_3
      //   621: iload #5
      //   623: iload #4
      //   625: if_icmpge -> 676
      //   628: iload #5
      //   630: istore_3
      //   631: aload_2
      //   632: iload #5
      //   634: invokevirtual charAt : (I)C
      //   637: bipush #63
      //   639: if_icmpne -> 676
      //   642: aload_2
      //   643: iload #5
      //   645: iload #4
      //   647: ldc_w '#'
      //   650: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   653: istore_3
      //   654: aload_0
      //   655: aload_2
      //   656: iload #5
      //   658: iconst_1
      //   659: iadd
      //   660: iload_3
      //   661: ldc_w ' "'<>#'
      //   664: iconst_1
      //   665: iconst_1
      //   666: iconst_1
      //   667: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   670: invokestatic queryStringToNamesAndValues : (Ljava/lang/String;)Ljava/util/List;
      //   673: putfield encodedQueryNamesAndValues : Ljava/util/List;
      //   676: iload_3
      //   677: iload #4
      //   679: if_icmpge -> 710
      //   682: aload_2
      //   683: iload_3
      //   684: invokevirtual charAt : (I)C
      //   687: bipush #35
      //   689: if_icmpne -> 710
      //   692: aload_0
      //   693: aload_2
      //   694: iconst_1
      //   695: iload_3
      //   696: iadd
      //   697: iload #4
      //   699: ldc ''
      //   701: iconst_1
      //   702: iconst_0
      //   703: iconst_0
      //   704: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   707: putfield encodedFragment : Ljava/lang/String;
      //   710: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.SUCCESS : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   713: areturn
      //   714: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.MISSING_SCHEME : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   717: areturn
    }
    
    public Builder password(String param1String) {
      if (param1String != null) {
        this.encodedPassword = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
        return this;
      } 
      throw new IllegalArgumentException("password == null");
    }
    
    public Builder port(int param1Int) {
      if (param1Int > 0 && param1Int <= 65535) {
        this.port = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected port: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder query(String param1String) {
      if (param1String != null) {
        List<String> list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(param1String, " \"'<>#", false, true, true));
      } else {
        param1String = null;
      } 
      this.encodedQueryNamesAndValues = (List<String>)param1String;
      return this;
    }
    
    Builder reencodeForUri() {
      int i = this.encodedPathSegments.size();
      byte b;
      for (b = 0; b < i; b++) {
        String str1 = this.encodedPathSegments.get(b);
        this.encodedPathSegments.set(b, HttpUrl.canonicalize(str1, "[]", true, false, true));
      } 
      List<String> list = this.encodedQueryNamesAndValues;
      if (list != null) {
        i = list.size();
        for (b = 0; b < i; b++) {
          String str1 = this.encodedQueryNamesAndValues.get(b);
          if (str1 != null)
            this.encodedQueryNamesAndValues.set(b, HttpUrl.canonicalize(str1, "\\^`{|}", true, true, true)); 
        } 
      } 
      String str = this.encodedFragment;
      if (str != null)
        this.encodedFragment = HttpUrl.canonicalize(str, " \"#<>\\^`{|}", true, false, false); 
      return this;
    }
    
    public Builder removeAllEncodedQueryParameters(String param1String) {
      if (param1String != null) {
        if (this.encodedQueryNamesAndValues == null)
          return this; 
        removeAllCanonicalQueryParameters(HttpUrl.canonicalize(param1String, " \"'<>#&=", true, true, true));
        return this;
      } 
      throw new IllegalArgumentException("encodedName == null");
    }
    
    public Builder removeAllQueryParameters(String param1String) {
      if (param1String != null) {
        if (this.encodedQueryNamesAndValues == null)
          return this; 
        removeAllCanonicalQueryParameters(HttpUrl.canonicalize(param1String, " \"'<>#&=", false, true, true));
        return this;
      } 
      throw new IllegalArgumentException("name == null");
    }
    
    public Builder removePathSegment(int param1Int) {
      this.encodedPathSegments.remove(param1Int);
      if (this.encodedPathSegments.isEmpty())
        this.encodedPathSegments.add(""); 
      return this;
    }
    
    public Builder scheme(String param1String) {
      if (param1String != null) {
        if (param1String.equalsIgnoreCase("http")) {
          this.scheme = "http";
        } else {
          if (param1String.equalsIgnoreCase("https")) {
            this.scheme = "https";
            return this;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("unexpected scheme: ");
          stringBuilder.append(param1String);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return this;
      } 
      throw new IllegalArgumentException("scheme == null");
    }
    
    public Builder setEncodedPathSegment(int param1Int, String param1String) {
      if (param1String != null) {
        String str = HttpUrl.canonicalize(param1String, 0, param1String.length(), " \"<>^`{}|/\\?#", true, false, true);
        this.encodedPathSegments.set(param1Int, str);
        if (!isDot(str) && !isDotDot(str))
          return this; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected path segment: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    
    public Builder setEncodedQueryParameter(String param1String1, String param1String2) {
      removeAllEncodedQueryParameters(param1String1);
      addEncodedQueryParameter(param1String1, param1String2);
      return this;
    }
    
    public Builder setPathSegment(int param1Int, String param1String) {
      if (param1String != null) {
        String str = HttpUrl.canonicalize(param1String, 0, param1String.length(), " \"<>^`{}|/\\?#", false, false, true);
        if (!isDot(str) && !isDotDot(str)) {
          this.encodedPathSegments.set(param1Int, str);
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected path segment: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("pathSegment == null");
    }
    
    public Builder setQueryParameter(String param1String1, String param1String2) {
      removeAllQueryParameters(param1String1);
      addQueryParameter(param1String1, param1String2);
      return this;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.scheme);
      stringBuilder.append("://");
      if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
        stringBuilder.append(this.encodedUsername);
        if (!this.encodedPassword.isEmpty()) {
          stringBuilder.append(':');
          stringBuilder.append(this.encodedPassword);
        } 
        stringBuilder.append('@');
      } 
      if (this.host.indexOf(':') != -1) {
        stringBuilder.append('[');
        stringBuilder.append(this.host);
        stringBuilder.append(']');
      } else {
        stringBuilder.append(this.host);
      } 
      int i = effectivePort();
      if (i != HttpUrl.defaultPort(this.scheme)) {
        stringBuilder.append(':');
        stringBuilder.append(i);
      } 
      HttpUrl.pathSegmentsToString(stringBuilder, this.encodedPathSegments);
      if (this.encodedQueryNamesAndValues != null) {
        stringBuilder.append('?');
        HttpUrl.namesAndValuesToQueryString(stringBuilder, this.encodedQueryNamesAndValues);
      } 
      if (this.encodedFragment != null) {
        stringBuilder.append('#');
        stringBuilder.append(this.encodedFragment);
      } 
      return stringBuilder.toString();
    }
    
    public Builder username(String param1String) {
      if (param1String != null) {
        this.encodedUsername = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
        return this;
      } 
      throw new IllegalArgumentException("username == null");
    }
    
    enum ParseResult {
      INVALID_HOST, INVALID_PORT, MISSING_SCHEME, SUCCESS, UNSUPPORTED_SCHEME;
      
      static {
        INVALID_HOST = new ParseResult("INVALID_HOST", 4);
        $VALUES = new ParseResult[] { SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, INVALID_HOST };
      }
    }
  }
  
  enum ParseResult {
    INVALID_HOST, INVALID_PORT, MISSING_SCHEME, SUCCESS, UNSUPPORTED_SCHEME;
    
    static {
      INVALID_PORT = new ParseResult("INVALID_PORT", 3);
      INVALID_HOST = new ParseResult("INVALID_HOST", 4);
      $VALUES = new ParseResult[] { SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, INVALID_HOST };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\HttpUrl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */