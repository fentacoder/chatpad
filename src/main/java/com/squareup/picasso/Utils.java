package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;

final class Utils {
  private static final int KEY_PADDING = 50;
  
  static final char KEY_SEPARATOR = '\n';
  
  static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
  
  private static final int MAX_DISK_CACHE_SIZE = 52428800;
  
  private static final int MIN_DISK_CACHE_SIZE = 5242880;
  
  static final String OWNER_DISPATCHER = "Dispatcher";
  
  static final String OWNER_HUNTER = "Hunter";
  
  static final String OWNER_MAIN = "Main";
  
  private static final String PICASSO_CACHE = "picasso-cache";
  
  static final String THREAD_IDLE_NAME = "Picasso-Idle";
  
  static final int THREAD_LEAK_CLEANING_MS = 1000;
  
  static final String THREAD_PREFIX = "Picasso-";
  
  static final String VERB_BATCHED = "batched";
  
  static final String VERB_CANCELED = "canceled";
  
  static final String VERB_CHANGED = "changed";
  
  static final String VERB_COMPLETED = "completed";
  
  static final String VERB_CREATED = "created";
  
  static final String VERB_DECODED = "decoded";
  
  static final String VERB_DELIVERED = "delivered";
  
  static final String VERB_ENQUEUED = "enqueued";
  
  static final String VERB_ERRORED = "errored";
  
  static final String VERB_EXECUTING = "executing";
  
  static final String VERB_IGNORED = "ignored";
  
  static final String VERB_JOINED = "joined";
  
  static final String VERB_PAUSED = "paused";
  
  static final String VERB_REMOVED = "removed";
  
  static final String VERB_REPLAYING = "replaying";
  
  static final String VERB_RESUMED = "resumed";
  
  static final String VERB_RETRYING = "retrying";
  
  static final String VERB_TRANSFORMED = "transformed";
  
  private static final ByteString WEBP_FILE_HEADER_RIFF = ByteString.encodeUtf8("RIFF");
  
  private static final ByteString WEBP_FILE_HEADER_WEBP = ByteString.encodeUtf8("WEBP");
  
  static long calculateDiskCacheSize(File paramFile) {
    long l;
    try {
      long l1;
      StatFs statFs = new StatFs();
      this(paramFile.getAbsolutePath());
      if (Build.VERSION.SDK_INT < 18) {
        l = statFs.getBlockCount();
      } else {
        l = statFs.getBlockCountLong();
      } 
      if (Build.VERSION.SDK_INT < 18) {
        l1 = statFs.getBlockSize();
      } else {
        l1 = statFs.getBlockSizeLong();
      } 
      l = l * l1 / 50L;
    } catch (IllegalArgumentException illegalArgumentException) {
      l = 5242880L;
    } 
    return Math.max(Math.min(l, 52428800L), 5242880L);
  }
  
  static int calculateMemoryCacheSize(Context paramContext) {
    int i;
    ActivityManager activityManager = getService(paramContext, "activity");
    if (((paramContext.getApplicationInfo()).flags & 0x100000) != 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      i = activityManager.getLargeMemoryClass();
    } else {
      i = activityManager.getMemoryClass();
    } 
    return (int)(i * 1048576L / 7L);
  }
  
  static void checkMain() {
    if (isMain())
      return; 
    throw new IllegalStateException("Method call should happen from the main thread.");
  }
  
  static void checkNotMain() {
    if (!isMain())
      return; 
    throw new IllegalStateException("Method call should not happen from the main thread.");
  }
  
  static <T> T checkNotNull(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  static File createDefaultCacheDir(Context paramContext) {
    File file = new File(paramContext.getApplicationContext().getCacheDir(), "picasso-cache");
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  static String createKey(Request paramRequest) {
    String str = createKey(paramRequest, MAIN_THREAD_KEY_BUILDER);
    MAIN_THREAD_KEY_BUILDER.setLength(0);
    return str;
  }
  
  static String createKey(Request paramRequest, StringBuilder paramStringBuilder) {
    if (paramRequest.stableKey != null) {
      paramStringBuilder.ensureCapacity(paramRequest.stableKey.length() + 50);
      paramStringBuilder.append(paramRequest.stableKey);
    } else if (paramRequest.uri != null) {
      String str = paramRequest.uri.toString();
      paramStringBuilder.ensureCapacity(str.length() + 50);
      paramStringBuilder.append(str);
    } else {
      paramStringBuilder.ensureCapacity(50);
      paramStringBuilder.append(paramRequest.resourceId);
    } 
    paramStringBuilder.append('\n');
    if (paramRequest.rotationDegrees != 0.0F) {
      paramStringBuilder.append("rotation:");
      paramStringBuilder.append(paramRequest.rotationDegrees);
      if (paramRequest.hasRotationPivot) {
        paramStringBuilder.append('@');
        paramStringBuilder.append(paramRequest.rotationPivotX);
        paramStringBuilder.append('x');
        paramStringBuilder.append(paramRequest.rotationPivotY);
      } 
      paramStringBuilder.append('\n');
    } 
    if (paramRequest.hasSize()) {
      paramStringBuilder.append("resize:");
      paramStringBuilder.append(paramRequest.targetWidth);
      paramStringBuilder.append('x');
      paramStringBuilder.append(paramRequest.targetHeight);
      paramStringBuilder.append('\n');
    } 
    if (paramRequest.centerCrop) {
      paramStringBuilder.append("centerCrop:");
      paramStringBuilder.append(paramRequest.centerCropGravity);
      paramStringBuilder.append('\n');
    } else if (paramRequest.centerInside) {
      paramStringBuilder.append("centerInside");
      paramStringBuilder.append('\n');
    } 
    if (paramRequest.transformations != null) {
      byte b = 0;
      int i = paramRequest.transformations.size();
      while (b < i) {
        paramStringBuilder.append(((Transformation)paramRequest.transformations.get(b)).key());
        paramStringBuilder.append('\n');
        b++;
      } 
    } 
    return paramStringBuilder.toString();
  }
  
  static void flushStackLocalLeaks(Looper paramLooper) {
    Handler handler = new Handler(paramLooper) {
        public void handleMessage(Message param1Message) {
          sendMessageDelayed(obtainMessage(), 1000L);
        }
      };
    handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
  }
  
  static int getBitmapBytes(Bitmap paramBitmap) {
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = paramBitmap.getAllocationByteCount();
    } else {
      i = paramBitmap.getByteCount();
    } 
    if (i >= 0)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Negative size: ");
    stringBuilder.append(paramBitmap);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  static String getLogIdsForHunter(BitmapHunter paramBitmapHunter) {
    return getLogIdsForHunter(paramBitmapHunter, "");
  }
  
  static String getLogIdsForHunter(BitmapHunter paramBitmapHunter, String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    Action action = paramBitmapHunter.getAction();
    if (action != null)
      stringBuilder.append(action.request.logId()); 
    List<Action> list = paramBitmapHunter.getActions();
    if (list != null) {
      byte b = 0;
      int i = list.size();
      while (b < i) {
        if (b > 0 || action != null)
          stringBuilder.append(", "); 
        stringBuilder.append(((Action)list.get(b)).request.logId());
        b++;
      } 
    } 
    return stringBuilder.toString();
  }
  
  static int getResourceId(Resources paramResources, Request paramRequest) throws FileNotFoundException {
    String str1;
    if (paramRequest.resourceId != 0 || paramRequest.uri == null)
      return paramRequest.resourceId; 
    String str2 = paramRequest.uri.getAuthority();
    if (str2 != null) {
      List<String> list = paramRequest.uri.getPathSegments();
      if (list != null && !list.isEmpty()) {
        StringBuilder stringBuilder2;
        if (list.size() == 1) {
          try {
            int i = Integer.parseInt(list.get(0));
          } catch (NumberFormatException numberFormatException) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Last path segment is not a resource ID: ");
            stringBuilder2.append(paramRequest.uri);
            throw new FileNotFoundException(stringBuilder2.toString());
          } 
        } else {
          if (list.size() == 2) {
            str1 = list.get(0);
            return stringBuilder2.getIdentifier(list.get(1), str1, str2);
          } 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("More than two path segments: ");
          stringBuilder2.append(((Request)str1).uri);
          throw new FileNotFoundException(stringBuilder2.toString());
        } 
        return SYNTHETIC_LOCAL_VARIABLE_4;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("No path segments: ");
      stringBuilder1.append(((Request)str1).uri);
      throw new FileNotFoundException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package provided: ");
    stringBuilder.append(((Request)str1).uri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  static Resources getResources(Context paramContext, Request paramRequest) throws FileNotFoundException {
    if (paramRequest.resourceId != 0 || paramRequest.uri == null)
      return paramContext.getResources(); 
    String str = paramRequest.uri.getAuthority();
    if (str != null)
      try {
        return paramContext.getPackageManager().getResourcesForApplication(str);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unable to obtain resources for package: ");
        stringBuilder1.append(paramRequest.uri);
        throw new FileNotFoundException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package provided: ");
    stringBuilder.append(paramRequest.uri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  static <T> T getService(Context paramContext, String paramString) {
    return (T)paramContext.getSystemService(paramString);
  }
  
  static boolean hasPermission(Context paramContext, String paramString) {
    boolean bool;
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static boolean isAirplaneModeOn(Context paramContext) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    boolean bool1 = false;
    boolean bool2 = false;
    try {
      int i = Build.VERSION.SDK_INT;
      if (i < 17) {
        if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0)
          bool2 = true; 
        return bool2;
      } 
      i = Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
      bool2 = bool1;
      if (i != 0)
        bool2 = true; 
    } catch (NullPointerException|SecurityException nullPointerException) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  static boolean isMain() {
    boolean bool;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static boolean isWebPFile(BufferedSource paramBufferedSource) throws IOException {
    boolean bool;
    if (paramBufferedSource.rangeEquals(0L, WEBP_FILE_HEADER_RIFF) && paramBufferedSource.rangeEquals(8L, WEBP_FILE_HEADER_WEBP)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static void log(String paramString1, String paramString2, String paramString3) {
    log(paramString1, paramString2, paramString3, "");
  }
  
  static void log(String paramString1, String paramString2, String paramString3, String paramString4) {
    Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
  }
  
  private static class PicassoThread extends Thread {
    PicassoThread(Runnable param1Runnable) {
      super(param1Runnable);
    }
    
    public void run() {
      Process.setThreadPriority(10);
      super.run();
    }
  }
  
  static class PicassoThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable param1Runnable) {
      return new Utils.PicassoThread(param1Runnable);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\picasso\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */