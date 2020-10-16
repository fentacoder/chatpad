package com.google.firebase.storage;

import java.io.IOException;

class CancelException extends IOException {
  CancelException() {
    super("The operation was canceled.");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\CancelException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */