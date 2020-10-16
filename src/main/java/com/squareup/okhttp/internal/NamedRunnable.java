package com.squareup.okhttp.internal;

public abstract class NamedRunnable implements Runnable {
  protected final String name;
  
  public NamedRunnable(String paramString, Object... paramVarArgs) {
    this.name = String.format(paramString, paramVarArgs);
  }
  
  protected abstract void execute();
  
  public final void run() {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.name);
    try {
      execute();
      return;
    } finally {
      Thread.currentThread().setName(str);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\squareup\okhttp\internal\NamedRunnable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */