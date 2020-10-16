package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzaj<T> {
  final int what;
  
  final int zzck;
  
  final TaskCompletionSource<T> zzcl = new TaskCompletionSource();
  
  final Bundle zzcm;
  
  zzaj(int paramInt1, int paramInt2, Bundle paramBundle) {
    this.zzck = paramInt1;
    this.what = paramInt2;
    this.zzcm = paramBundle;
  }
  
  final void finish(T paramT) {
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramT);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 16 + String.valueOf(str2).length());
      stringBuilder.append("Finishing ");
      stringBuilder.append(str1);
      stringBuilder.append(" with ");
      stringBuilder.append(str2);
      Log.d("MessengerIpcClient", stringBuilder.toString());
    } 
    this.zzcl.setResult(paramT);
  }
  
  public String toString() {
    int i = this.what;
    int j = this.zzck;
    boolean bool = zzab();
    StringBuilder stringBuilder = new StringBuilder(55);
    stringBuilder.append("Request { what=");
    stringBuilder.append(i);
    stringBuilder.append(" id=");
    stringBuilder.append(j);
    stringBuilder.append(" oneWay=");
    stringBuilder.append(bool);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  final void zza(zzam paramzzam) {
    if (Log.isLoggable("MessengerIpcClient", 3)) {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramzzam);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 14 + String.valueOf(str2).length());
      stringBuilder.append("Failing ");
      stringBuilder.append(str1);
      stringBuilder.append(" with ");
      stringBuilder.append(str2);
      Log.d("MessengerIpcClient", stringBuilder.toString());
    } 
    this.zzcl.setException(paramzzam);
  }
  
  abstract boolean zzab();
  
  abstract void zzb(Bundle paramBundle);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzaj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */