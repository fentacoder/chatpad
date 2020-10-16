package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zze;

public final class zzdw extends GmsClient<zzed> implements zzdt {
  private static Logger zza = new Logger("FirebaseAuth", new String[] { "FirebaseAuth:" });
  
  private final Context zzb;
  
  private final zzei zzc;
  
  public zzdw(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, zzei paramzzei, ConnectionCallbacks paramConnectionCallbacks, OnConnectionFailedListener paramOnConnectionFailedListener) {
    super(paramContext, paramLooper, 112, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzb = (Context)Preconditions.checkNotNull(paramContext);
    this.zzc = paramzzei;
  }
  
  public final Feature[] getApiFeatures() {
    return zze.zzb;
  }
  
  protected final Bundle getGetServiceRequestExtraArgs() {
    Bundle bundle1 = super.getGetServiceRequestExtraArgs();
    Bundle bundle2 = bundle1;
    if (bundle1 == null)
      bundle2 = new Bundle(); 
    zzei zzei1 = this.zzc;
    if (zzei1 != null)
      bundle2.putString("com.google.firebase.auth.API_KEY", zzei1.zzb()); 
    bundle2.putString("com.google.firebase.auth.LIBRARY_VERSION", zzek.zzb());
    return bundle2;
  }
  
  public final int getMinApkVersion() {
    return 12451000;
  }
  
  protected final String getServiceDescriptor() {
    return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
  }
  
  protected final String getStartServiceAction() {
    return "com.google.firebase.auth.api.gms.service.START";
  }
  
  protected final String getStartServicePackage() {
    if (this.zzc.zza) {
      zza.i("Preparing to create service connection to fallback implementation", new Object[0]);
      return this.zzb.getPackageName();
    } 
    zza.i("Preparing to create service connection to gms implementation", new Object[0]);
    return "com.google.android.gms";
  }
  
  public final boolean requiresGooglePlayServices() {
    return (DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth") == 0);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzdw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */