package com.google.firebase.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.internal.FederatedSignInActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OAuthProvider extends FederatedAuthProvider {
  private final Bundle zza;
  
  private OAuthProvider(Bundle paramBundle) {
    this.zza = paramBundle;
  }
  
  @Deprecated
  public static AuthCredential getCredential(String paramString1, String paramString2, String paramString3) {
    return zzg.zza(paramString1, paramString2, paramString3);
  }
  
  public static Builder newBuilder(String paramString) {
    return newBuilder(paramString, FirebaseAuth.getInstance());
  }
  
  public static Builder newBuilder(String paramString, FirebaseAuth paramFirebaseAuth) {
    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramFirebaseAuth);
    if (!"facebook.com".equals(paramString))
      return new Builder(paramString, paramFirebaseAuth, googleApiAvailability, null); 
    throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
  }
  
  public static CredentialBuilder newCredentialBuilder(String paramString) {
    return new CredentialBuilder(Preconditions.checkNotEmpty(paramString), null);
  }
  
  public String getProviderId() {
    Bundle bundle = this.zza;
    return (bundle == null) ? null : bundle.getString("com.google.firebase.auth.KEY_PROVIDER_ID", null);
  }
  
  public final void zza(Activity paramActivity) {
    Intent intent = new Intent("com.google.firebase.auth.internal.SIGN_IN");
    intent.setPackage(paramActivity.getPackageName());
    intent.setClass((Context)paramActivity, FederatedSignInActivity.class);
    intent.putExtras(this.zza);
    paramActivity.startActivity(intent);
  }
  
  public final void zzb(Activity paramActivity) {
    Intent intent = new Intent("com.google.firebase.auth.internal.LINK");
    intent.setPackage(paramActivity.getPackageName());
    intent.setClass((Context)paramActivity, FederatedSignInActivity.class);
    intent.putExtras(this.zza);
    paramActivity.startActivity(intent);
  }
  
  public final void zzc(Activity paramActivity) {
    Intent intent = new Intent("com.google.firebase.auth.internal.REAUTHENTICATE");
    intent.setPackage(paramActivity.getPackageName());
    intent.setClass((Context)paramActivity, FederatedSignInActivity.class);
    intent.putExtras(this.zza);
    paramActivity.startActivity(intent);
  }
  
  public static class Builder {
    private final FirebaseAuth zza;
    
    private final Bundle zzb = new Bundle();
    
    private final Bundle zzc = new Bundle();
    
    private Builder(String param1String, FirebaseAuth param1FirebaseAuth, GoogleApiAvailability param1GoogleApiAvailability) {
      this.zza = param1FirebaseAuth;
      this.zzb.putString("com.google.firebase.auth.KEY_API_KEY", this.zza.zzb().getOptions().getApiKey());
      this.zzb.putString("com.google.firebase.auth.KEY_PROVIDER_ID", param1String);
      this.zzb.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", this.zzc);
      this.zzb.putString("com.google.firebase.auth.internal.CLIENT_VERSION", Integer.toString(param1GoogleApiAvailability.getClientVersion(this.zza.zzb().getApplicationContext())));
      this.zzb.putString("com.google.firebase.auth.KEY_TENANT_ID", this.zza.zzc());
    }
    
    public Builder addCustomParameter(String param1String1, String param1String2) {
      this.zzc.putString(param1String1, param1String2);
      return this;
    }
    
    public Builder addCustomParameters(Map<String, String> param1Map) {
      for (Map.Entry<String, String> entry : param1Map.entrySet())
        this.zzc.putString((String)entry.getKey(), (String)entry.getValue()); 
      return this;
    }
    
    public OAuthProvider build() {
      return new OAuthProvider(this.zzb, null);
    }
    
    public Builder setScopes(List<String> param1List) {
      this.zzb.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(param1List));
      return this;
    }
  }
  
  public static class CredentialBuilder {
    private final String zza;
    
    private String zzb;
    
    private String zzc;
    
    private String zzd;
    
    private CredentialBuilder(String param1String) {
      this.zza = param1String;
    }
    
    public AuthCredential build() {
      return zzg.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
    
    public CredentialBuilder setAccessToken(String param1String) {
      this.zzc = param1String;
      return this;
    }
    
    public CredentialBuilder setIdToken(String param1String) {
      this.zzb = param1String;
      return this;
    }
    
    public CredentialBuilder setIdTokenWithRawNonce(String param1String1, String param1String2) {
      this.zzb = param1String1;
      this.zzd = param1String2;
      return this;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\OAuthProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */