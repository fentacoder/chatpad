package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzz {
  private final zzy zza(Context paramContext, String paramString, zzy paramzzy, boolean paramBoolean) {
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Writing key to properties file"); 
    Properties properties = new Properties();
    properties.setProperty("pub", zzy.zza(paramzzy));
    properties.setProperty("pri", zzy.zzb(paramzzy));
    properties.setProperty("cre", String.valueOf(zzy.zzc(paramzzy)));
    File file = zzf(paramContext, paramString);
    try {
      file.createNewFile();
      RandomAccessFile randomAccessFile = new RandomAccessFile();
      this(file, "rw");
      try {
        FileChannel fileChannel = randomAccessFile.getChannel();
      } finally {
        paramzzy = null;
      } 
    } catch (IOException iOException) {
      paramString = String.valueOf(iOException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 21);
      stringBuilder.append("Failed to write key: ");
      stringBuilder.append(paramString);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      return null;
    } 
  }
  
  private static zzy zza(SharedPreferences paramSharedPreferences, String paramString) throws zzaa {
    zzy zzy;
    String str1 = zzav.zzd(paramString, "|P|");
    String str2 = null;
    String str3 = paramSharedPreferences.getString(str1, null);
    String str4 = paramSharedPreferences.getString(zzav.zzd(paramString, "|K|"), null);
    str1 = str2;
    if (str3 != null)
      if (str4 == null) {
        str1 = str2;
      } else {
        zzy = new zzy(zzc(str3, str4), zzb(paramSharedPreferences, paramString));
      }  
    return zzy;
  }
  
  private final zzy zza(File paramFile) throws zzaa, IOException {
    FileInputStream fileInputStream = new FileInputStream(paramFile);
    try {
      FileChannel fileChannel = fileInputStream.getChannel();
    } finally {
      Exception exception = null;
    } 
  }
  
  private static zzy zza(FileChannel paramFileChannel) throws zzaa, IOException {
    Properties properties = new Properties();
    properties.load(Channels.newInputStream(paramFileChannel));
    String str1 = properties.getProperty("pub");
    String str2 = properties.getProperty("pri");
    if (str1 != null && str2 != null) {
      KeyPair keyPair = zzc(str1, str2);
      try {
        long l = Long.parseLong(properties.getProperty("cre"));
        return new zzy(keyPair, l);
      } catch (NumberFormatException numberFormatException) {
        throw new zzaa(numberFormatException);
      } 
    } 
    throw new zzaa("Invalid properties file");
  }
  
  static void zza(Context paramContext) {
    for (File file : zzb(paramContext).listFiles()) {
      if (file.getName().startsWith("com.google.InstanceId"))
        file.delete(); 
    } 
  }
  
  private final void zza(Context paramContext, String paramString, zzy paramzzy) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try {
      boolean bool = paramzzy.equals(zza(sharedPreferences, paramString));
      if (bool)
        return; 
    } catch (zzaa zzaa) {}
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Writing key to shared preferences"); 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(zzav.zzd(paramString, "|P|"), zzy.zza(paramzzy));
    editor.putString(zzav.zzd(paramString, "|K|"), zzy.zzb(paramzzy));
    editor.putString(zzav.zzd(paramString, "cre"), String.valueOf(zzy.zzc(paramzzy)));
    editor.commit();
  }
  
  private static long zzb(SharedPreferences paramSharedPreferences, String paramString) {
    String str = paramSharedPreferences.getString(zzav.zzd(paramString, "cre"), null);
    if (str != null)
      try {
        return Long.parseLong(str);
      } catch (NumberFormatException numberFormatException) {} 
    return 0L;
  }
  
  private static File zzb(Context paramContext) {
    File file = ContextCompat.getNoBackupFilesDir(paramContext);
    if (file != null && file.isDirectory())
      return file; 
    Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
    return paramContext.getFilesDir();
  }
  
  private static KeyPair zzc(String paramString1, String paramString2) throws zzaa {
    try {
      byte[] arrayOfByte2 = Base64.decode(paramString1, 8);
      byte[] arrayOfByte1 = Base64.decode(paramString2, 8);
      try {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
        this(arrayOfByte2);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec();
        this(arrayOfByte1);
        return new KeyPair(publicKey, keyFactory.generatePrivate(pKCS8EncodedKeySpec));
      } catch (InvalidKeySpecException invalidKeySpecException) {
      
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
      paramString2 = String.valueOf(noSuchAlgorithmException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 19);
      stringBuilder.append("Invalid key stored ");
      stringBuilder.append(paramString2);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      throw new zzaa(noSuchAlgorithmException);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new zzaa(illegalArgumentException);
    } 
  }
  
  private final zzy zzd(Context paramContext, String paramString) throws zzaa {
    try {
      zzy zzy = zze(paramContext, paramString);
      if (zzy != null) {
        zza(paramContext, paramString, zzy);
        return zzy;
      } 
      zzy = null;
    } catch (zzaa null) {}
    try {
      zzy zzy = zza(paramContext.getSharedPreferences("com.google.android.gms.appid", 0), paramString);
      if (zzy != null) {
        zza(paramContext, paramString, zzy, false);
        return zzy;
      } 
    } catch (zzaa zzaa) {}
    if (zzaa == null)
      return null; 
    throw zzaa;
  }
  
  private final zzy zze(Context paramContext, String paramString) throws zzaa {
    File file = zzf(paramContext, paramString);
    if (!file.exists())
      return null; 
    try {
      return zza(file);
    } catch (zzaa zzaa) {
    
    } catch (IOException iOException) {}
    if (Log.isLoggable("FirebaseInstanceId", 3)) {
      String str = String.valueOf(iOException);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 40);
      stringBuilder.append("Failed to read key from file, retrying: ");
      stringBuilder.append(str);
      Log.d("FirebaseInstanceId", stringBuilder.toString());
    } 
    try {
      return zza(file);
    } catch (IOException iOException1) {
      String str = String.valueOf(iOException1);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
      stringBuilder.append("IID file exists, but failed to read from it: ");
      stringBuilder.append(str);
      Log.w("FirebaseInstanceId", stringBuilder.toString());
      throw new zzaa(iOException1);
    } 
  }
  
  private static File zzf(Context paramContext, String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    } else {
      try {
        String str1 = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        int i = String.valueOf(str1).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 33);
        stringBuilder.append("com.google.InstanceId_");
        stringBuilder.append(str1);
        stringBuilder.append(".properties");
        str = stringBuilder.toString();
        return new File(zzb(paramContext), str);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new AssertionError(unsupportedEncodingException);
      } 
    } 
    return new File(zzb((Context)unsupportedEncodingException), str);
  }
  
  final zzy zzb(Context paramContext, String paramString) throws zzaa {
    zzy zzy = zzd(paramContext, paramString);
    return (zzy != null) ? zzy : zzc(paramContext, paramString);
  }
  
  final zzy zzc(Context paramContext, String paramString) {
    zzy zzy1 = new zzy(zza.zzc(), System.currentTimeMillis());
    zzy zzy2 = zza(paramContext, paramString, zzy1, true);
    if (zzy2 != null && !zzy2.equals(zzy1)) {
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one"); 
      return zzy2;
    } 
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Generated new key"); 
    zza(paramContext, paramString, zzy1);
    return zzy1;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzz.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */