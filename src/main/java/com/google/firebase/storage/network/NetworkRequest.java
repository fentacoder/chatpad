package com.google.firebase.storage.network;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactory;
import com.google.firebase.storage.network.connection.HttpURLConnectionFactoryImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class NetworkRequest {
  private static final String APPLICATION_JSON = "application/json";
  
  private static final String CONTENT_LENGTH = "Content-Length";
  
  private static final String CONTENT_TYPE = "Content-Type";
  
  static final String DELETE = "DELETE";
  
  static final String GET = "GET";
  
  public static final int INITIALIZATION_EXCEPTION = -1;
  
  private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
  
  public static final int NETWORK_UNAVAILABLE = -2;
  
  static final String PATCH = "PATCH";
  
  static final String POST = "POST";
  
  static final String PUT = "PUT";
  
  private static final String TAG = "NetworkRequest";
  
  private static final String UTF_8 = "UTF-8";
  
  private static final String X_FIREBASE_GMPID = "x-firebase-gmpid";
  
  static HttpURLConnectionFactory connectionFactory;
  
  private static String gmsCoreVersion;
  
  static Uri sNetworkRequestUrl = Uri.parse("https://firebasestorage.googleapis.com/v0");
  
  private HttpURLConnection connection;
  
  private Context context;
  
  protected Exception mException;
  
  protected final Uri mGsUri;
  
  private String rawStringResponse;
  
  private Map<String, String> requestHeaders = new HashMap<>();
  
  private int resultCode;
  
  private Map<String, List<String>> resultHeaders;
  
  private InputStream resultInputStream;
  
  private int resultingContentLength;
  
  static {
    connectionFactory = (HttpURLConnectionFactory)new HttpURLConnectionFactoryImpl();
  }
  
  public NetworkRequest(Uri paramUri, FirebaseApp paramFirebaseApp) {
    Preconditions.checkNotNull(paramUri);
    Preconditions.checkNotNull(paramFirebaseApp);
    this.mGsUri = paramUri;
    this.context = paramFirebaseApp.getApplicationContext();
    setCustomHeader("x-firebase-gmpid", paramFirebaseApp.getOptions().getApplicationId());
  }
  
  private void constructMessage(HttpURLConnection paramHttpURLConnection, String paramString) throws IOException {
    byte[] arrayOfByte;
    int i;
    Preconditions.checkNotNull(paramHttpURLConnection);
    if (!TextUtils.isEmpty(paramString)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Firebase ");
      stringBuilder1.append(paramString);
      paramHttpURLConnection.setRequestProperty("Authorization", stringBuilder1.toString());
    } else {
      Log.w("NetworkRequest", "no auth token for request");
    } 
    StringBuilder stringBuilder = new StringBuilder("Android/");
    String str = getGmsCoreVersion(this.context);
    if (!TextUtils.isEmpty(str))
      stringBuilder.append(str); 
    paramHttpURLConnection.setRequestProperty("X-Firebase-Storage-Version", stringBuilder.toString());
    for (Map.Entry<String, String> entry : this.requestHeaders.entrySet())
      paramHttpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
    JSONObject jSONObject = getOutputJSON();
    if (jSONObject != null) {
      arrayOfByte = jSONObject.toString().getBytes("UTF-8");
      i = arrayOfByte.length;
    } else {
      byte[] arrayOfByte1 = getOutputRaw();
      int j = getOutputRawSize();
      arrayOfByte = arrayOfByte1;
      i = j;
      if (j == 0) {
        arrayOfByte = arrayOfByte1;
        i = j;
        if (arrayOfByte1 != null) {
          i = arrayOfByte1.length;
          arrayOfByte = arrayOfByte1;
        } 
      } 
    } 
    if (arrayOfByte != null && arrayOfByte.length > 0) {
      if (jSONObject != null)
        paramHttpURLConnection.setRequestProperty("Content-Type", "application/json"); 
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.setRequestProperty("Content-Length", Integer.toString(i));
    } else {
      paramHttpURLConnection.setRequestProperty("Content-Length", "0");
    } 
    paramHttpURLConnection.setUseCaches(false);
    paramHttpURLConnection.setDoInput(true);
    if (arrayOfByte != null && arrayOfByte.length > 0) {
      OutputStream outputStream = paramHttpURLConnection.getOutputStream();
      if (outputStream != null) {
        outputStream = new BufferedOutputStream(outputStream);
        try {
          outputStream.write(arrayOfByte, 0, i);
        } finally {
          outputStream.close();
        } 
      } else {
        Log.e("NetworkRequest", "Unable to write to the http request!");
      } 
    } 
  }
  
  private HttpURLConnection createConnection() throws IOException {
    Uri uri1 = getURL();
    Map<String, String> map = getQueryParameters();
    Uri uri2 = uri1;
    if (map != null) {
      Uri.Builder builder = uri1.buildUpon();
      for (Map.Entry<String, String> entry : map.entrySet())
        builder.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()); 
      uri2 = builder.build();
    } 
    return connectionFactory.createInstance(new URL(uri2.toString()));
  }
  
  private boolean ensureNetworkAvailable(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo == null || !networkInfo.isConnected()) {
      this.mException = new SocketException("Network subsystem is unavailable");
      this.resultCode = -2;
      return false;
    } 
    return true;
  }
  
  public static String getAuthority() {
    return sNetworkRequestUrl.getAuthority();
  }
  
  public static Uri getDefaultURL(Uri paramUri) {
    Preconditions.checkNotNull(paramUri);
    String str = getPathWithoutBucket(paramUri);
    Uri.Builder builder = sNetworkRequestUrl.buildUpon();
    builder.appendPath("b");
    builder.appendPath(paramUri.getAuthority());
    builder.appendPath("o");
    builder.appendPath(str);
    return builder.build();
  }
  
  private static String getGmsCoreVersion(Context paramContext) {
    if (gmsCoreVersion == null) {
      PackageManager packageManager = paramContext.getPackageManager();
      try {
        gmsCoreVersion = (packageManager.getPackageInfo("com.google.android.gms", 0)).versionName;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("NetworkRequest", "Unable to find gmscore in package manager", (Throwable)nameNotFoundException);
      } 
      if (gmsCoreVersion == null)
        gmsCoreVersion = "[No Gmscore]"; 
    } 
    return gmsCoreVersion;
  }
  
  private static String getPathWithoutBucket(Uri paramUri) {
    String str2 = paramUri.getPath();
    if (str2 == null)
      return ""; 
    String str1 = str2;
    if (str2.startsWith("/"))
      str1 = str2.substring(1); 
    return str1;
  }
  
  private void parseResponse(InputStream paramInputStream) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramInputStream != null) {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      try {
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            stringBuilder.append(str);
            continue;
          } 
          bufferedReader.close();
          break;
        } 
      } finally {
        bufferedReader.close();
      } 
    } 
    this.rawStringResponse = stringBuilder.toString();
    if (!isResultSuccess())
      this.mException = new IOException(this.rawStringResponse); 
  }
  
  private void parseResponse(HttpURLConnection paramHttpURLConnection) throws IOException {
    Preconditions.checkNotNull(paramHttpURLConnection);
    this.resultCode = paramHttpURLConnection.getResponseCode();
    this.resultHeaders = paramHttpURLConnection.getHeaderFields();
    this.resultingContentLength = paramHttpURLConnection.getContentLength();
    if (isResultSuccess()) {
      this.resultInputStream = paramHttpURLConnection.getInputStream();
    } else {
      this.resultInputStream = paramHttpURLConnection.getErrorStream();
    } 
  }
  
  private final void performRequest(String paramString) {
    performRequestStart(paramString);
    try {
      processResponseStream();
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error sending network request ");
      stringBuilder.append(getAction());
      stringBuilder.append(" ");
      stringBuilder.append(getURL());
      Log.w("NetworkRequest", stringBuilder.toString(), iOException);
      this.mException = iOException;
      this.resultCode = -2;
    } 
    performRequestEnd();
  }
  
  private void processResponseStream() throws IOException {
    if (isResultSuccess()) {
      parseSuccessulResponse(this.resultInputStream);
    } else {
      parseErrorResponse(this.resultInputStream);
    } 
  }
  
  public <TResult> void completeTask(TaskCompletionSource<TResult> paramTaskCompletionSource, TResult paramTResult) {
    Exception exception = getException();
    if (isResultSuccess() && exception == null) {
      paramTaskCompletionSource.setResult(paramTResult);
    } else {
      paramTaskCompletionSource.setException((Exception)StorageException.fromExceptionAndHttpCode(exception, getResultCode()));
    } 
  }
  
  protected abstract String getAction();
  
  public Exception getException() {
    return this.mException;
  }
  
  protected JSONObject getOutputJSON() {
    return null;
  }
  
  protected byte[] getOutputRaw() {
    return null;
  }
  
  protected int getOutputRawSize() {
    return 0;
  }
  
  String getPathWithoutBucket() {
    return getPathWithoutBucket(this.mGsUri);
  }
  
  protected Map<String, String> getQueryParameters() {
    return null;
  }
  
  public String getRawResult() {
    return this.rawStringResponse;
  }
  
  public JSONObject getResultBody() {
    JSONObject jSONObject;
    if (!TextUtils.isEmpty(this.rawStringResponse)) {
      try {
        jSONObject = new JSONObject();
        this(this.rawStringResponse);
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error parsing result into JSON:");
        stringBuilder.append(this.rawStringResponse);
        Log.e("NetworkRequest", stringBuilder.toString(), (Throwable)jSONException);
        jSONObject = new JSONObject();
      } 
    } else {
      jSONObject = new JSONObject();
    } 
    return jSONObject;
  }
  
  public int getResultCode() {
    return this.resultCode;
  }
  
  public Map<String, String> getResultHeaders() {
    return this.requestHeaders;
  }
  
  public Map<String, List<String>> getResultHeadersImpl() {
    return this.resultHeaders;
  }
  
  public String getResultString(String paramString) {
    Map<String, List<String>> map = getResultHeadersImpl();
    if (map != null) {
      List<String> list = map.get(paramString);
      if (list != null && list.size() > 0)
        return list.get(0); 
    } 
    return null;
  }
  
  public int getResultingContentLength() {
    return this.resultingContentLength;
  }
  
  public InputStream getStream() {
    return this.resultInputStream;
  }
  
  protected Uri getURL() {
    return getDefaultURL(this.mGsUri);
  }
  
  public boolean isResultSuccess() {
    boolean bool;
    int i = this.resultCode;
    if (i >= 200 && i < 300) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected void parseErrorResponse(InputStream paramInputStream) throws IOException {
    parseResponse(paramInputStream);
  }
  
  protected void parseSuccessulResponse(InputStream paramInputStream) throws IOException {
    parseResponse(paramInputStream);
  }
  
  public void performRequest(String paramString, Context paramContext) {
    if (!ensureNetworkAvailable(paramContext))
      return; 
    performRequest(paramString);
  }
  
  public void performRequestEnd() {
    HttpURLConnection httpURLConnection = this.connection;
    if (httpURLConnection != null)
      httpURLConnection.disconnect(); 
  }
  
  public void performRequestStart(String paramString) {
    if (this.mException != null) {
      this.resultCode = -1;
      return;
    } 
    if (Log.isLoggable("NetworkRequest", 3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sending network request ");
      stringBuilder.append(getAction());
      stringBuilder.append(" ");
      stringBuilder.append(getURL());
      Log.d("NetworkRequest", stringBuilder.toString());
    } 
    NetworkInfo networkInfo = ((ConnectivityManager)this.context.getSystemService("connectivity")).getActiveNetworkInfo();
    if (networkInfo == null || !networkInfo.isConnected()) {
      this.resultCode = -2;
      this.mException = new SocketException("Network subsystem is unavailable");
      return;
    } 
    try {
      this.connection = createConnection();
      this.connection.setRequestMethod(getAction());
      constructMessage(this.connection, paramString);
      parseResponse(this.connection);
      if (Log.isLoggable("NetworkRequest", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("network request result ");
        stringBuilder.append(this.resultCode);
        Log.d("NetworkRequest", stringBuilder.toString());
      } 
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error sending network request ");
      stringBuilder.append(getAction());
      stringBuilder.append(" ");
      stringBuilder.append(getURL());
      Log.w("NetworkRequest", stringBuilder.toString(), iOException);
      this.mException = iOException;
      this.resultCode = -2;
    } 
  }
  
  public final void reset() {
    this.mException = null;
    this.resultCode = 0;
  }
  
  public void setCustomHeader(String paramString1, String paramString2) {
    this.requestHeaders.put(paramString1, paramString2);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\network\NetworkRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */