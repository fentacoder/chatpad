package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzv implements zzw {
  private final IBinder zzbt;
  
  zzv(IBinder paramIBinder) {
    this.zzbt = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.zzbt;
  }
  
  public final void send(Message paramMessage) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
    parcel.writeInt(1);
    paramMessage.writeToParcel(parcel, 0);
    try {
      this.zzbt.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */