package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;

public class DefaultHeartBeatInfo implements HeartBeatInfo {
  private HeartBeatInfoStorage storage;
  
  private DefaultHeartBeatInfo(Context paramContext) {
    this.storage = HeartBeatInfoStorage.getInstance(paramContext);
  }
  
  DefaultHeartBeatInfo(HeartBeatInfoStorage paramHeartBeatInfoStorage) {
    this.storage = paramHeartBeatInfoStorage;
  }
  
  public static Component<HeartBeatInfo> component() {
    return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(DefaultHeartBeatInfo$$Lambda$1.lambdaFactory$()).build();
  }
  
  public HeartBeatInfo.HeartBeat getHeartBeatCode(String paramString) {
    long l = System.currentTimeMillis();
    boolean bool1 = this.storage.shouldSendSdkHeartBeat(paramString, l);
    boolean bool2 = this.storage.shouldSendGlobalHeartBeat(l);
    return (bool1 && bool2) ? HeartBeatInfo.HeartBeat.COMBINED : (bool2 ? HeartBeatInfo.HeartBeat.GLOBAL : (bool1 ? HeartBeatInfo.HeartBeat.SDK : HeartBeatInfo.HeartBeat.NONE));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\heartbeatinfo\DefaultHeartBeatInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */