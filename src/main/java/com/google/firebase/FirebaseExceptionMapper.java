package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

public class FirebaseExceptionMapper implements StatusExceptionMapper {
  public Exception getException(Status paramStatus) {
    return (paramStatus.getStatusCode() == 8) ? new FirebaseException(paramStatus.zzg()) : new FirebaseApiNotAvailableException(paramStatus.zzg());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\FirebaseExceptionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */