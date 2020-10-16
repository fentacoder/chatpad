package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

public final class Registrar implements ComponentRegistrar {
  public final List<Component<?>> getComponents() {
    return Arrays.asList((Component<?>[])new Component[] { Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).factory(zzap.zzcr).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzao.zzcr).build(), LibraryVersionComponent.create("fire-iid", "18.0.0") });
  }
  
  private static final class zza implements FirebaseInstanceIdInternal {
    private final FirebaseInstanceId zzct;
    
    public zza(FirebaseInstanceId param1FirebaseInstanceId) {
      this.zzct = param1FirebaseInstanceId;
    }
    
    public final String getId() {
      return this.zzct.getId();
    }
    
    public final String getToken() {
      return this.zzct.getToken();
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\iid\Registrar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */