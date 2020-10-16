package com.google.firebase.iid;

import android.os.Bundle;

final class zzak extends zzaj<Void> {
  zzak(int paramInt1, int paramInt2, Bundle paramBundle) {
    super(paramInt1, 2, paramBundle);
  }
  
  final boolean zzab() {
    return true;
  }
  
  final void zzb(Bundle paramBundle) {
    if (paramBundle.getBoolean("ack", false)) {
      finish(null);
      return;
    } 
    zza(new zzam(4, "Invalid response to one way request"));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */