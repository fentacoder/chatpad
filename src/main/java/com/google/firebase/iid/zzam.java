package com.google.firebase.iid;

public final class zzam extends Exception {
  private final int errorCode;
  
  public zzam(int paramInt, String paramString) {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public final int getErrorCode() {
    return this.errorCode;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\zzam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */