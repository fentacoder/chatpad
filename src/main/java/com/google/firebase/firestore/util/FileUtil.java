package com.google.firebase.firestore.util;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {
  public static void delete(File paramFile) throws IOException {
    if (Build.VERSION.SDK_INT >= 26) {
      DefaultFileDeleter.delete(paramFile);
    } else {
      LegacyFileDeleter.delete(paramFile);
    } 
  }
  
  private static class DefaultFileDeleter {
    public static void delete(File param1File) throws IOException {
      try {
        Files.deleteIfExists(param1File.toPath());
        return;
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to delete file ");
        stringBuilder.append(param1File);
        stringBuilder.append(": ");
        stringBuilder.append(iOException);
        throw new IOException(stringBuilder.toString());
      } 
    }
  }
  
  private static class LegacyFileDeleter {
    public static void delete(File param1File) throws IOException {
      if (param1File.delete() || !param1File.exists())
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to delete file ");
      stringBuilder.append(param1File);
      throw new IOException(stringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\FileUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */