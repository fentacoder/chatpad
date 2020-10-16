package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import javax.annotation.Nullable;

final class zzba extends BroadcastReceiver {
  @Nullable
  private zzax zzdr;
  
  public zzba(zzax paramzzax) {
    this.zzdr = paramzzax;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    zzax zzax1 = this.zzdr;
    if (zzax1 == null)
      return; 
    if (!zzax1.zzan())
      return; 
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync."); 
    FirebaseInstanceId.zza(this.zzdr, 0L);
    this.zzdr.getContext().unregisterReceiver(this);
    this.zzdr = null;
  }
  
  public final void zzaq() {
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity change received registered"); 
    IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.zzdr.getContext().registerReceiver(this, intentFilter);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzba.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */