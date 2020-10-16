package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
  public Task<Void> delete() {
    return FirebaseAuth.getInstance(zzc()).zzb(this);
  }
  
  public abstract String getDisplayName();
  
  public abstract String getEmail();
  
  public Task<GetTokenResult> getIdToken(boolean paramBoolean) {
    return FirebaseAuth.getInstance(zzc()).zza(this, paramBoolean);
  }
  
  public abstract FirebaseUserMetadata getMetadata();
  
  public abstract String getPhoneNumber();
  
  public abstract Uri getPhotoUrl();
  
  public abstract List<? extends UserInfo> getProviderData();
  
  public abstract String getProviderId();
  
  public abstract String getUid();
  
  public abstract boolean isAnonymous();
  
  public Task<AuthResult> linkWithCredential(AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramAuthCredential);
    return FirebaseAuth.getInstance(zzc()).zzc(this, paramAuthCredential);
  }
  
  public Task<Void> reauthenticate(AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramAuthCredential);
    return FirebaseAuth.getInstance(zzc()).zza(this, paramAuthCredential);
  }
  
  public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramAuthCredential);
    return FirebaseAuth.getInstance(zzc()).zzb(this, paramAuthCredential);
  }
  
  public Task<Void> reload() {
    return FirebaseAuth.getInstance(zzc()).zza(this);
  }
  
  public Task<Void> sendEmailVerification() {
    return FirebaseAuth.getInstance(zzc()).zza(this, false).continueWithTask(new zzu(this));
  }
  
  public Task<Void> sendEmailVerification(ActionCodeSettings paramActionCodeSettings) {
    return FirebaseAuth.getInstance(zzc()).zza(this, false).continueWithTask(new zzv(this, paramActionCodeSettings));
  }
  
  public Task<AuthResult> startActivityForLinkWithProvider(Activity paramActivity, FederatedAuthProvider paramFederatedAuthProvider) {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramFederatedAuthProvider);
    return FirebaseAuth.getInstance(zzc()).zza(paramActivity, paramFederatedAuthProvider, this);
  }
  
  public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity paramActivity, FederatedAuthProvider paramFederatedAuthProvider) {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramFederatedAuthProvider);
    return FirebaseAuth.getInstance(zzc()).zzb(paramActivity, paramFederatedAuthProvider, this);
  }
  
  public Task<AuthResult> unlink(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return FirebaseAuth.getInstance(zzc()).zza(this, paramString);
  }
  
  public Task<Void> updateEmail(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return FirebaseAuth.getInstance(zzc()).zzb(this, paramString);
  }
  
  public Task<Void> updatePassword(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return FirebaseAuth.getInstance(zzc()).zzc(this, paramString);
  }
  
  public Task<Void> updatePhoneNumber(PhoneAuthCredential paramPhoneAuthCredential) {
    return FirebaseAuth.getInstance(zzc()).zza(this, paramPhoneAuthCredential);
  }
  
  public Task<Void> updateProfile(UserProfileChangeRequest paramUserProfileChangeRequest) {
    Preconditions.checkNotNull(paramUserProfileChangeRequest);
    return FirebaseAuth.getInstance(zzc()).zza(this, paramUserProfileChangeRequest);
  }
  
  public abstract FirebaseUser zza(List<? extends UserInfo> paramList);
  
  public abstract List<String> zza();
  
  public abstract void zza(zzff paramzzff);
  
  public abstract FirebaseUser zzb();
  
  public abstract void zzb(List<zzy> paramList);
  
  public abstract FirebaseApp zzc();
  
  public abstract String zzd();
  
  public abstract zzff zze();
  
  public abstract String zzf();
  
  public abstract String zzg();
  
  public abstract zzz zzh();
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */