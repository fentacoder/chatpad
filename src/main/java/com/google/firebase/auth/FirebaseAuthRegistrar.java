package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class FirebaseAuthRegistrar implements ComponentRegistrar {
  public List<Component<?>> getComponents() {
    return Arrays.asList((Component<?>[])new Component[] { Component.builder(FirebaseAuth.class, new Class[] { InternalAuthProvider.class }).add(Dependency.required(FirebaseApp.class)).factory(zzt.zza).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-auth", "19.2.0") });
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseAuthRegistrar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */