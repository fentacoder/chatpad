package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform {
  private static final Platform PLATFORM = findPlatform();
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList) {
    Buffer buffer = new Buffer();
    int i = paramList.size();
    for (byte b = 0; b < i; b++) {
      Protocol protocol = paramList.get(b);
      if (protocol != Protocol.HTTP_1_0) {
        buffer.writeByte(protocol.toString().length());
        buffer.writeUtf8(protocol.toString());
      } 
    } 
    return buffer.readByteArray();
  }
  
  private static Platform findPlatform() {
    // Byte code:
    //   0: ldc 'com.android.org.conscrypt.SSLParametersImpl'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_0
    //   6: goto -> 19
    //   9: astore_1
    //   10: ldc 'org.apache.harmony.xnet.provider.jsse.SSLParametersImpl'
    //   12: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore_0
    //   16: goto -> 6
    //   19: new com/squareup/okhttp/internal/OptionalMethod
    //   22: astore_2
    //   23: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   26: astore_1
    //   27: aconst_null
    //   28: astore_3
    //   29: aload_2
    //   30: aconst_null
    //   31: ldc 'setUseSessionTickets'
    //   33: iconst_1
    //   34: anewarray java/lang/Class
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   44: new com/squareup/okhttp/internal/OptionalMethod
    //   47: astore #4
    //   49: aload #4
    //   51: aconst_null
    //   52: ldc 'setHostname'
    //   54: iconst_1
    //   55: anewarray java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: ldc java/lang/String
    //   62: aastore
    //   63: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   66: ldc 'android.net.TrafficStats'
    //   68: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   71: astore_1
    //   72: aload_1
    //   73: ldc 'tagSocket'
    //   75: iconst_1
    //   76: anewarray java/lang/Class
    //   79: dup
    //   80: iconst_0
    //   81: ldc java/net/Socket
    //   83: aastore
    //   84: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   87: astore #5
    //   89: aload_1
    //   90: ldc 'untagSocket'
    //   92: iconst_1
    //   93: anewarray java/lang/Class
    //   96: dup
    //   97: iconst_0
    //   98: ldc java/net/Socket
    //   100: aastore
    //   101: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   104: astore #6
    //   106: ldc 'android.net.Network'
    //   108: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   111: pop
    //   112: new com/squareup/okhttp/internal/OptionalMethod
    //   115: astore_1
    //   116: aload_1
    //   117: ldc [B
    //   119: ldc 'getAlpnSelectedProtocol'
    //   121: iconst_0
    //   122: anewarray java/lang/Class
    //   125: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   128: new com/squareup/okhttp/internal/OptionalMethod
    //   131: astore #7
    //   133: aload #7
    //   135: aconst_null
    //   136: ldc 'setAlpnProtocols'
    //   138: iconst_1
    //   139: anewarray java/lang/Class
    //   142: dup
    //   143: iconst_0
    //   144: ldc [B
    //   146: aastore
    //   147: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   150: aload #7
    //   152: astore_3
    //   153: goto -> 191
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_1
    //   159: goto -> 191
    //   162: astore_1
    //   163: aconst_null
    //   164: astore #6
    //   166: aload #6
    //   168: astore_1
    //   169: goto -> 191
    //   172: astore_1
    //   173: aconst_null
    //   174: astore #7
    //   176: aload #7
    //   178: astore #6
    //   180: aload #6
    //   182: astore_1
    //   183: aload #6
    //   185: astore #5
    //   187: aload #7
    //   189: astore #6
    //   191: new com/squareup/okhttp/internal/Platform$Android
    //   194: dup
    //   195: aload_0
    //   196: aload_2
    //   197: aload #4
    //   199: aload #5
    //   201: aload #6
    //   203: aload_1
    //   204: aload_3
    //   205: invokespecial <init> : (Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   208: astore_1
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: ldc 'sun.security.ssl.SSLContextImpl'
    //   214: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   217: astore_1
    //   218: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   220: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   223: astore #6
    //   225: new java/lang/StringBuilder
    //   228: astore_0
    //   229: aload_0
    //   230: invokespecial <init> : ()V
    //   233: aload_0
    //   234: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_0
    //   241: ldc '$Provider'
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_0
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   254: astore_0
    //   255: new java/lang/StringBuilder
    //   258: astore #5
    //   260: aload #5
    //   262: invokespecial <init> : ()V
    //   265: aload #5
    //   267: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #5
    //   275: ldc '$ClientProvider'
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #5
    //   283: invokevirtual toString : ()Ljava/lang/String;
    //   286: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   289: astore #5
    //   291: new java/lang/StringBuilder
    //   294: astore_3
    //   295: aload_3
    //   296: invokespecial <init> : ()V
    //   299: aload_3
    //   300: ldc 'org.eclipse.jetty.alpn.ALPN'
    //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: ldc '$ServerProvider'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_3
    //   314: invokevirtual toString : ()Ljava/lang/String;
    //   317: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   320: astore_3
    //   321: new com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   324: dup
    //   325: aload_1
    //   326: aload #6
    //   328: ldc 'put'
    //   330: iconst_2
    //   331: anewarray java/lang/Class
    //   334: dup
    //   335: iconst_0
    //   336: ldc javax/net/ssl/SSLSocket
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: aload_0
    //   342: aastore
    //   343: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   346: aload #6
    //   348: ldc 'get'
    //   350: iconst_1
    //   351: anewarray java/lang/Class
    //   354: dup
    //   355: iconst_0
    //   356: ldc javax/net/ssl/SSLSocket
    //   358: aastore
    //   359: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   362: aload #6
    //   364: ldc 'remove'
    //   366: iconst_1
    //   367: anewarray java/lang/Class
    //   370: dup
    //   371: iconst_0
    //   372: ldc javax/net/ssl/SSLSocket
    //   374: aastore
    //   375: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   378: aload #5
    //   380: aload_3
    //   381: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   384: astore #6
    //   386: aload #6
    //   388: areturn
    //   389: astore #6
    //   391: new com/squareup/okhttp/internal/Platform$JdkPlatform
    //   394: dup
    //   395: aload_1
    //   396: invokespecial <init> : (Ljava/lang/Class;)V
    //   399: astore_1
    //   400: aload_1
    //   401: areturn
    //   402: astore_1
    //   403: new com/squareup/okhttp/internal/Platform
    //   406: dup
    //   407: invokespecial <init> : ()V
    //   410: areturn
    //   411: astore #7
    //   413: goto -> 191
    // Exception table:
    //   from	to	target	type
    //   0	6	9	java/lang/ClassNotFoundException
    //   10	16	211	java/lang/ClassNotFoundException
    //   19	27	211	java/lang/ClassNotFoundException
    //   29	66	211	java/lang/ClassNotFoundException
    //   66	89	172	java/lang/ClassNotFoundException
    //   66	89	172	java/lang/NoSuchMethodException
    //   89	106	162	java/lang/ClassNotFoundException
    //   89	106	162	java/lang/NoSuchMethodException
    //   106	128	156	java/lang/ClassNotFoundException
    //   106	128	156	java/lang/NoSuchMethodException
    //   128	150	411	java/lang/ClassNotFoundException
    //   128	150	411	java/lang/NoSuchMethodException
    //   191	209	211	java/lang/ClassNotFoundException
    //   212	218	402	java/lang/ClassNotFoundException
    //   218	386	389	java/lang/ClassNotFoundException
    //   218	386	389	java/lang/NoSuchMethodException
    //   391	400	402	java/lang/ClassNotFoundException
  }
  
  public static Platform get() {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString) {
    Class<?> clazz = paramObject.getClass();
    while (clazz != Object.class) {
      try {
        Field field = clazz.getDeclaredField(paramString);
        field.setAccessible(true);
        null = field.get(paramObject);
        return (null == null || !paramClass.isInstance(null)) ? null : paramClass.cast(null);
      } catch (NoSuchFieldException noSuchFieldException) {
        clazz = clazz.getSuperclass();
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError();
      } 
    } 
    if (!paramString.equals("delegate")) {
      illegalAccessException = readFieldOrNull(illegalAccessException, Object.class, "delegate");
      if (illegalAccessException != null)
        return readFieldOrNull(illegalAccessException, paramClass, paramString); 
    } 
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix() {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket) {
    return null;
  }
  
  public void log(String paramString) {
    System.out.println(paramString);
  }
  
  public void logW(String paramString) {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket) throws SocketException {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory) {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager) {
    return (TrustRootIndex)new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket) throws SocketException {}
  
  private static class Android extends Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    
    private final OptionalMethod<Socket> setAlpnProtocols;
    
    private final OptionalMethod<Socket> setHostname;
    
    private final OptionalMethod<Socket> setUseSessionTickets;
    
    private final Class<?> sslParametersClass;
    
    private final Method trafficStatsTagSocket;
    
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> param1Class, OptionalMethod<Socket> param1OptionalMethod1, OptionalMethod<Socket> param1OptionalMethod2, Method param1Method1, Method param1Method2, OptionalMethod<Socket> param1OptionalMethod3, OptionalMethod<Socket> param1OptionalMethod4) {
      this.sslParametersClass = param1Class;
      this.setUseSessionTickets = param1OptionalMethod1;
      this.setHostname = param1OptionalMethod2;
      this.trafficStatsTagSocket = param1Method1;
      this.trafficStatsUntagSocket = param1Method2;
      this.getAlpnSelectedProtocol = param1OptionalMethod3;
      this.setAlpnProtocols = param1OptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      if (param1String != null) {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(param1SSLSocket, new Object[] { param1String });
      } 
      OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
      if (optionalMethod != null && optionalMethod.isSupported(param1SSLSocket)) {
        byte[] arrayOfByte = concatLengthPrefixed(param1List);
        this.setAlpnProtocols.invokeWithoutCheckedException(param1SSLSocket, new Object[] { arrayOfByte });
      } 
    }
    
    public void connectSocket(Socket param1Socket, InetSocketAddress param1InetSocketAddress, int param1Int) throws IOException {
      try {
        param1Socket.connect(param1InetSocketAddress, param1Int);
        return;
      } catch (AssertionError assertionError) {
        if (Util.isAndroidGetsocknameError(assertionError))
          throw new IOException(assertionError); 
        throw assertionError;
      } catch (SecurityException securityException) {
        IOException iOException = new IOException("Exception in connect");
        iOException.initCause(securityException);
        throw iOException;
      } 
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      String str;
      OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
      SSLSocket sSLSocket = null;
      if (optionalMethod == null)
        return null; 
      if (!optionalMethod.isSupported(param1SSLSocket))
        return null; 
      byte[] arrayOfByte = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(param1SSLSocket, new Object[0]);
      param1SSLSocket = sSLSocket;
      if (arrayOfByte != null)
        str = new String(arrayOfByte, Util.UTF_8); 
      return str;
    }
    
    public void log(String param1String) {
      int i = param1String.length();
      int j = 0;
      label16: while (j < i) {
        int k = param1String.indexOf('\n', j);
        if (k == -1)
          k = i; 
        while (true) {
          int m = Math.min(k, j + 4000);
          Log.d("OkHttp", param1String.substring(j, m));
          if (m >= k) {
            j = m + 1;
            continue label16;
          } 
          j = m;
        } 
      } 
    }
    
    public void tagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsTagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      Object object1 = readFieldOrNull(param1SSLSocketFactory, (Class)this.sslParametersClass, "sslParameters");
      Object object2 = object1;
      if (object1 == null)
        try {
          object2 = readFieldOrNull(param1SSLSocketFactory, (Class)Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, param1SSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        } catch (ClassNotFoundException classNotFoundException) {
          return null;
        }  
      X509TrustManager x509TrustManager = readFieldOrNull(object2, X509TrustManager.class, "x509TrustManager");
      return (x509TrustManager != null) ? x509TrustManager : readFieldOrNull(object2, X509TrustManager.class, "trustManager");
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager param1X509TrustManager) {
      TrustRootIndex trustRootIndex = AndroidTrustRootIndex.get(param1X509TrustManager);
      return (trustRootIndex != null) ? trustRootIndex : super.trustRootIndex(param1X509TrustManager);
    }
    
    public void untagSocket(Socket param1Socket) throws SocketException {
      Method method = this.trafficStatsUntagSocket;
      if (method == null)
        return; 
      try {
        method.invoke(null, new Object[] { param1Socket });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException.getCause());
      } 
    }
  }
  
  private static class JdkPlatform extends Platform {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> param1Class) {
      this.sslContextClass = param1Class;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory param1SSLSocketFactory) {
      param1SSLSocketFactory = readFieldOrNull(param1SSLSocketFactory, this.sslContextClass, "context");
      return (param1SSLSocketFactory == null) ? null : readFieldOrNull(param1SSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  private static class JdkWithJettyBootPlatform extends JdkPlatform {
    private final Class<?> clientProviderClass;
    
    private final Method getMethod;
    
    private final Method putMethod;
    
    private final Method removeMethod;
    
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> param1Class1, Method param1Method1, Method param1Method2, Method param1Method3, Class<?> param1Class2, Class<?> param1Class3) {
      super(param1Class1);
      this.putMethod = param1Method1;
      this.getMethod = param1Method2;
      this.removeMethod = param1Method3;
      this.clientProviderClass = param1Class2;
      this.serverProviderClass = param1Class3;
    }
    
    public void afterHandshake(SSLSocket param1SSLSocket) {
      try {
        this.removeMethod.invoke(null, new Object[] { param1SSLSocket });
        return;
      } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
        throw new AssertionError();
      } 
    }
    
    public void configureTlsExtensions(SSLSocket param1SSLSocket, String param1String, List<Protocol> param1List) {
      ArrayList<String> arrayList = new ArrayList(param1List.size());
      int i = param1List.size();
      for (byte b = 0; b < i; b++) {
        Protocol protocol = param1List.get(b);
        if (protocol != Protocol.HTTP_1_0)
          arrayList.add(protocol.toString()); 
      } 
      try {
        ClassLoader classLoader = Platform.class.getClassLoader();
        Class<?> clazz1 = this.clientProviderClass;
        Class<?> clazz2 = this.serverProviderClass;
        Platform.JettyNegoProvider jettyNegoProvider = new Platform.JettyNegoProvider();
        this(arrayList);
        Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz1, clazz2 }, jettyNegoProvider);
        this.putMethod.invoke(null, new Object[] { param1SSLSocket, object });
        return;
      } catch (InvocationTargetException invocationTargetException) {
      
      } catch (IllegalAccessException illegalAccessException) {}
      throw new AssertionError(illegalAccessException);
    }
    
    public String getSelectedProtocol(SSLSocket param1SSLSocket) {
      try {
        String str;
        Method method = this.getMethod;
        Platform.JettyNegoProvider jettyNegoProvider2 = null;
        Platform.JettyNegoProvider jettyNegoProvider1 = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(method.invoke(null, new Object[] { param1SSLSocket }));
        if (!jettyNegoProvider1.unsupported && jettyNegoProvider1.selected == null) {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        } 
        if (jettyNegoProvider1.unsupported) {
          jettyNegoProvider1 = jettyNegoProvider2;
        } else {
          str = jettyNegoProvider1.selected;
        } 
        return str;
      } catch (InvocationTargetException|IllegalAccessException invocationTargetException) {
        throw new AssertionError();
      } 
    }
  }
  
  private static class JettyNegoProvider implements InvocationHandler {
    private final List<String> protocols;
    
    private String selected;
    
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> param1List) {
      this.protocols = param1List;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      String str = param1Method.getName();
      Class<?> clazz = param1Method.getReturnType();
      param1Object = param1ArrayOfObject;
      if (param1ArrayOfObject == null)
        param1Object = Util.EMPTY_STRING_ARRAY; 
      if (str.equals("supports") && boolean.class == clazz)
        return Boolean.valueOf(true); 
      if (str.equals("unsupported") && void.class == clazz) {
        this.unsupported = true;
        return null;
      } 
      if (str.equals("protocols") && param1Object.length == 0)
        return this.protocols; 
      if ((str.equals("selectProtocol") || str.equals("select")) && String.class == clazz && param1Object.length == 1 && param1Object[0] instanceof List) {
        param1Object = param1Object[0];
        int i = param1Object.size();
        for (byte b = 0; b < i; b++) {
          if (this.protocols.contains(param1Object.get(b))) {
            param1Object = param1Object.get(b);
            this.selected = (String)param1Object;
            return param1Object;
          } 
        } 
        param1Object = this.protocols.get(0);
        this.selected = (String)param1Object;
        return param1Object;
      } 
      if ((str.equals("protocolSelected") || str.equals("selected")) && param1Object.length == 1) {
        this.selected = (String)param1Object[0];
        return null;
      } 
      return param1Method.invoke(this, (Object[])param1Object);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\Platform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */