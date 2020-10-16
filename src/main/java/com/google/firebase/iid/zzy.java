package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import java.security.KeyPair;

final class zzy {
  private final KeyPair zzbw;
  
  private final long zzbx;
  
  zzy(KeyPair paramKeyPair, long paramLong) {
    this.zzbw = paramKeyPair;
    this.zzbx = paramLong;
  }
  
  private final String zzv() {
    return Base64.encodeToString(this.zzbw.getPublic().getEncoded(), 11);
  }
  
  private final String zzw() {
    return Base64.encodeToString(this.zzbw.getPrivate().getEncoded(), 11);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof zzy))
      return false; 
    paramObject = paramObject;
    return (this.zzbx == ((zzy)paramObject).zzbx && this.zzbw.getPublic().equals(((zzy)paramObject).zzbw.getPublic()) && this.zzbw.getPrivate().equals(((zzy)paramObject).zzbw.getPrivate()));
  }
  
  final long getCreationTime() {
    return this.zzbx;
  }
  
  final KeyPair getKeyPair() {
    return this.zzbw;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { this.zzbw.getPublic(), this.zzbw.getPrivate(), Long.valueOf(this.zzbx) });
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */