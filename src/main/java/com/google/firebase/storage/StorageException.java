package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StorageException extends FirebaseException {
  public static final int ERROR_BUCKET_NOT_FOUND = -13011;
  
  public static final int ERROR_CANCELED = -13040;
  
  public static final int ERROR_INVALID_CHECKSUM = -13031;
  
  public static final int ERROR_NOT_AUTHENTICATED = -13020;
  
  public static final int ERROR_NOT_AUTHORIZED = -13021;
  
  public static final int ERROR_OBJECT_NOT_FOUND = -13010;
  
  public static final int ERROR_PROJECT_NOT_FOUND = -13012;
  
  public static final int ERROR_QUOTA_EXCEEDED = -13013;
  
  public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
  
  public static final int ERROR_UNKNOWN = -13000;
  
  private static final int NETWORK_UNAVAILABLE = -2;
  
  private static final String TAG = "StorageException";
  
  private Throwable cause;
  
  private final int errorCode;
  
  private final int httpResultCode;
  
  StorageException(int paramInt1, Throwable paramThrowable, int paramInt2) {
    super(getErrorMessageForCode(paramInt1));
    this.cause = paramThrowable;
    this.errorCode = paramInt1;
    this.httpResultCode = paramInt2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("StorageException has occurred.\n");
    stringBuilder.append(getErrorMessageForCode(paramInt1));
    stringBuilder.append("\n Code: ");
    stringBuilder.append(this.errorCode);
    stringBuilder.append(" HttpResult: ");
    stringBuilder.append(this.httpResultCode);
    Log.e("StorageException", stringBuilder.toString());
    Throwable throwable = this.cause;
    if (throwable != null)
      Log.e("StorageException", throwable.getMessage(), this.cause); 
  }
  
  private static int calculateErrorCode(Status paramStatus) {
    return paramStatus.isCanceled() ? -13040 : (paramStatus.equals(Status.RESULT_TIMEOUT) ? -13030 : -13000);
  }
  
  private static int calculateErrorCode(Throwable paramThrowable, int paramInt) {
    return (paramThrowable instanceof CancelException) ? -13040 : ((paramInt != -2) ? ((paramInt != 401) ? ((paramInt != 409) ? ((paramInt != 403) ? ((paramInt != 404) ? -13000 : -13010) : -13021) : -13031) : -13020) : -13030);
  }
  
  public static StorageException fromErrorStatus(Status paramStatus) {
    Preconditions.checkNotNull(paramStatus);
    Preconditions.checkArgument(paramStatus.isSuccess() ^ true);
    return new StorageException(calculateErrorCode(paramStatus), null, 0);
  }
  
  public static StorageException fromException(Throwable paramThrowable) {
    return fromExceptionAndHttpCode(paramThrowable, 0);
  }
  
  public static StorageException fromExceptionAndHttpCode(Throwable paramThrowable, int paramInt) {
    return (paramThrowable instanceof StorageException) ? (StorageException)paramThrowable : ((isResultSuccess(paramInt) && paramThrowable == null) ? null : new StorageException(calculateErrorCode(paramThrowable, paramInt), paramThrowable, paramInt));
  }
  
  static String getErrorMessageForCode(int paramInt) {
    if (paramInt != -13040) {
      if (paramInt != -13000) {
        if (paramInt != -13031) {
          if (paramInt != -13030) {
            if (paramInt != -13021) {
              if (paramInt != -13020) {
                switch (paramInt) {
                  default:
                    return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
                  case -13010:
                    return "Object does not exist at location.";
                  case -13011:
                    return "Bucket does not exist.";
                  case -13012:
                    return "Project does not exist.";
                  case -13013:
                    break;
                } 
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
              } 
              return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
            } 
            return "User does not have permission to access this object.";
          } 
          return "The operation retry limit has been exceeded.";
        } 
        return "Object has a checksum which does not match. Please retry the operation.";
      } 
      return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
    } 
    return "The operation was cancelled.";
  }
  
  private static boolean isResultSuccess(int paramInt) {
    return (paramInt == 0 || (paramInt >= 200 && paramInt < 300));
  }
  
  public Throwable getCause() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield cause : Ljava/lang/Throwable;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: if_acmpne -> 16
    //   12: aload_0
    //   13: monitorexit
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield cause : Ljava/lang/Throwable;
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   16	21	25	finally
  }
  
  public int getErrorCode() {
    return this.errorCode;
  }
  
  public int getHttpResultCode() {
    return this.httpResultCode;
  }
  
  public boolean getIsRecoverableException() {
    boolean bool;
    if (getErrorCode() == -13030) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ErrorCode {}
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */