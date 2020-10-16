package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

final class zzdr implements Callable<zzal<zzei>> {
  private final zzei zza;
  
  private final Context zzb;
  
  public zzdr(zzei paramzzei, Context paramContext) {
    this.zza = paramzzei;
    this.zzb = paramContext;
  }
  
  private final GoogleApi<zzei> zza(boolean paramBoolean, Context paramContext) {
    zzei zzei1 = (zzei)this.zza.clone();
    zzei1.zza = paramBoolean;
    return new zzaq<>(paramContext, zzeh.zza, zzei1, (StatusExceptionMapper)new FirebaseExceptionMapper());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */