package com.google.firebase.storage.internal;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Util {
  public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  
  private static final int MAXIMUM_TOKEN_WAIT_TIME_MS = 30000;
  
  public static final int NETWORK_UNAVAILABLE = -2;
  
  private static final String TAG = "StorageUtil";
  
  public static boolean equals(Object paramObject1, Object paramObject2) {
    return Objects.equal(paramObject1, paramObject2);
  }
  
  private static String getAuthority() throws RemoteException {
    return NetworkRequest.getAuthority();
  }
  
  public static String getCurrentAuthToken(InternalAuthProvider paramInternalAuthProvider) {
    if (paramInternalAuthProvider != null) {
      try {
        String str = ((GetTokenResult)Tasks.await(paramInternalAuthProvider.getAccessToken(false), 30000L, TimeUnit.MILLISECONDS)).getToken();
        if (!TextUtils.isEmpty(str))
          return str; 
      } catch (ExecutionException executionException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error getting token ");
        stringBuilder.append(executionException);
        Log.e("StorageUtil", stringBuilder.toString());
      } catch (InterruptedException interruptedException) {
      
      } catch (TimeoutException timeoutException) {}
    } else {
      paramInternalAuthProvider = null;
      if (!TextUtils.isEmpty((CharSequence)paramInternalAuthProvider))
        return (String)paramInternalAuthProvider; 
    } 
    return null;
  }
  
  public static Uri normalize(FirebaseApp paramFirebaseApp, String paramString) throws UnsupportedEncodingException {
    StringBuilder stringBuilder2;
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.toLowerCase().startsWith("gs://")) {
      String str1 = Slashes.preserveSlashEncode(Slashes.normalizeSlashes(paramString.substring(5)));
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("gs://");
      stringBuilder2.append(str1);
      return Uri.parse(stringBuilder2.toString());
    } 
    Uri uri = Uri.parse((String)stringBuilder2);
    String str = uri.getScheme();
    if (str != null && (equals(str.toLowerCase(), "http") || equals(str.toLowerCase(), "https"))) {
      str = uri.getAuthority().toLowerCase();
      try {
        String str1;
        int i = str.indexOf(getAuthority());
        str = Slashes.slashize(uri.getEncodedPath());
        if (i == 0 && str.startsWith("/")) {
          int j = str.indexOf("/b/", 0);
          int k = j + 3;
          i = str.indexOf("/", k);
          int m = str.indexOf("/o/", 0);
          if (j != -1 && i != -1) {
            str1 = str.substring(k, i);
            if (m != -1) {
              str = str.substring(m + 3);
            } else {
              str = "";
            } 
          } else {
            Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
          } 
        } else {
          if (i > 1) {
            str1 = str1.getAuthority().substring(0, i - 1);
            Preconditions.checkNotEmpty(str1, "No bucket specified");
            return (new Uri.Builder()).scheme("gs").authority(str1).encodedPath(str).build();
          } 
          Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
          throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
        } 
        Preconditions.checkNotEmpty(str1, "No bucket specified");
        return (new Uri.Builder()).scheme("gs").authority(str1).encodedPath(str).build();
      } catch (RemoteException remoteException) {
        throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("FirebaseStorage is unable to support the scheme:");
    stringBuilder1.append((String)remoteException);
    Log.w("StorageUtil", stringBuilder1.toString());
    throw new IllegalArgumentException("Uri scheme");
  }
  
  public static long parseDateTime(String paramString) {
    if (paramString == null)
      return 0L; 
    paramString = paramString.replaceAll("Z$", "-0000");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    try {
      return simpleDateFormat.parse(paramString).getTime();
    } catch (ParseException parseException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unable to parse datetime:");
      stringBuilder.append(paramString);
      Log.w("StorageUtil", stringBuilder.toString(), parseException);
      return 0L;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\internal\Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */