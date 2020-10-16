package com.google.firebase.heartbeatinfo;

public interface HeartBeatInfo {
  HeartBeat getHeartBeatCode(String paramString);
  
  public enum HeartBeat {
    COMBINED,
    GLOBAL,
    NONE(0),
    SDK(1);
    
    private final int code;
    
    static {
      COMBINED = new HeartBeat("COMBINED", 3, 3);
      $VALUES = new HeartBeat[] { NONE, SDK, GLOBAL, COMBINED };
    }
    
    HeartBeat(int param1Int1) {
      this.code = param1Int1;
    }
    
    public int getCode() {
      return this.code;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */