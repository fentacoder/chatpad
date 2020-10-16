package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

public class zzm implements Parcelable {
  public static final Parcelable.Creator<zzm> CREATOR = new zzl();
  
  private Messenger zzao;
  
  private zzw zzap;
  
  public zzm(IBinder paramIBinder) {
    if (Build.VERSION.SDK_INT >= 21) {
      this.zzao = new Messenger(paramIBinder);
      return;
    } 
    this.zzap = new zzv(paramIBinder);
  }
  
  private final IBinder getBinder() {
    Messenger messenger = this.zzao;
    return (messenger != null) ? messenger.getBinder() : this.zzap.asBinder();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    try {
      return getBinder().equals(((zzm)paramObject).getBinder());
    } catch (ClassCastException classCastException) {
      return false;
    } 
  }
  
  public int hashCode() {
    return getBinder().hashCode();
  }
  
  public final void send(Message paramMessage) throws RemoteException {
    Messenger messenger = this.zzao;
    if (messenger != null) {
      messenger.send(paramMessage);
      return;
    } 
    this.zzap.send(paramMessage);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    Messenger messenger = this.zzao;
    if (messenger != null) {
      paramParcel.writeStrongBinder(messenger.getBinder());
      return;
    } 
    paramParcel.writeStrongBinder(this.zzap.asBinder());
  }
  
  public static final class zza extends ClassLoader {
    protected final Class<?> loadClass(String param1String, boolean param1Boolean) throws ClassNotFoundException {
      if ("com.google.android.gms.iid.MessengerCompat".equals(param1String)) {
        if (FirebaseInstanceId.zzm())
          Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class"); 
        return zzm.class;
      } 
      return super.loadClass(param1String, param1Boolean);
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */