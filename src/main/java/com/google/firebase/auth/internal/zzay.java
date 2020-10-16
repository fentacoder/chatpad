package com.google.firebase.auth.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.HashMap;
import java.util.Map;

public final class zzay {
  private static final Map<String, String> zza;
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<>();
    zza = (Map)hashMap;
    hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
    zza.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
    zza.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
    zza.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
    zza.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
  }
  
  public static void zza(Intent paramIntent, Status paramStatus) {
    SafeParcelableSerializer.serializeToIntentExtra((SafeParcelable)paramStatus, paramIntent, "com.google.firebase.auth.internal.STATUS");
  }
  
  public static boolean zza(Intent paramIntent) {
    Preconditions.checkNotNull(paramIntent);
    return paramIntent.hasExtra("com.google.firebase.auth.internal.STATUS");
  }
  
  public static Status zzb(Intent paramIntent) {
    Preconditions.checkNotNull(paramIntent);
    Preconditions.checkArgument(zza(paramIntent));
    return (Status)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */