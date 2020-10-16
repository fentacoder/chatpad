package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.api.internal.zzau;
import com.google.firebase.auth.api.internal.zzds;
import com.google.firebase.auth.api.internal.zzdv;
import com.google.firebase.auth.api.internal.zzeh;
import com.google.firebase.auth.api.internal.zzei;
import com.google.firebase.auth.api.internal.zzeq;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzap;
import com.google.firebase.auth.internal.zzas;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzaw;
import com.google.firebase.auth.internal.zzaz;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzo;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalAuthProvider {
  private FirebaseApp zza;
  
  private final List<IdTokenListener> zzb;
  
  private final List<IdTokenListener> zzc;
  
  private List<AuthStateListener> zzd;
  
  private zzau zze;
  
  private FirebaseUser zzf;
  
  private zzo zzg;
  
  private final Object zzh = new Object();
  
  private String zzi;
  
  private final Object zzj = new Object();
  
  private String zzk;
  
  private final zzav zzl;
  
  private final zzam zzm;
  
  private zzau zzn;
  
  private zzaw zzo;
  
  public FirebaseAuth(FirebaseApp paramFirebaseApp) {
    this(paramFirebaseApp, zzeh.zza(paramFirebaseApp.getApplicationContext(), zzei), new zzav(paramFirebaseApp.getApplicationContext(), paramFirebaseApp.getPersistenceKey()), zzam.zza());
  }
  
  private FirebaseAuth(FirebaseApp paramFirebaseApp, zzau paramzzau, zzav paramzzav, zzam paramzzam) {
    this.zza = (FirebaseApp)Preconditions.checkNotNull(paramFirebaseApp);
    this.zze = (zzau)Preconditions.checkNotNull(paramzzau);
    this.zzl = (zzav)Preconditions.checkNotNull(paramzzav);
    this.zzg = new zzo();
    this.zzm = (zzam)Preconditions.checkNotNull(paramzzam);
    this.zzb = new CopyOnWriteArrayList<>();
    this.zzc = new CopyOnWriteArrayList<>();
    this.zzd = new CopyOnWriteArrayList<>();
    this.zzo = zzaw.zza();
    this.zzf = this.zzl.zza();
    FirebaseUser firebaseUser = this.zzf;
    if (firebaseUser != null) {
      zzff zzff = this.zzl.zzb(firebaseUser);
      if (zzff != null)
        zza(this.zzf, zzff, false); 
    } 
    this.zzm.zza(this);
  }
  
  public static FirebaseAuth getInstance() {
    return (FirebaseAuth)FirebaseApp.getInstance().get(FirebaseAuth.class);
  }
  
  public static FirebaseAuth getInstance(FirebaseApp paramFirebaseApp) {
    return (FirebaseAuth)paramFirebaseApp.get(FirebaseAuth.class);
  }
  
  private final Task<Void> zza(FirebaseUser paramFirebaseUser, zzaz paramzzaz) {
    Preconditions.checkNotNull(paramFirebaseUser);
    return this.zze.zza(this.zza, paramFirebaseUser, paramzzaz);
  }
  
  private final void zza(zzau paramzzau) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield zzn : Lcom/google/firebase/auth/internal/zzau;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  private final boolean zzb(String paramString) {
    zzf zzf = zzf.zza(paramString);
    return (zzf != null && !TextUtils.equals(this.zzk, zzf.zzc()));
  }
  
  private final void zzc(FirebaseUser paramFirebaseUser) {
    if (paramFirebaseUser != null) {
      String str = paramFirebaseUser.getUid();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
      stringBuilder.append("Notifying id token listeners about user ( ");
      stringBuilder.append(str);
      stringBuilder.append(" ).");
      Log.d("FirebaseAuth", stringBuilder.toString());
    } else {
      Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
    } 
    if (paramFirebaseUser != null) {
      String str = paramFirebaseUser.zzg();
    } else {
      paramFirebaseUser = null;
    } 
    InternalTokenResult internalTokenResult = new InternalTokenResult((String)paramFirebaseUser);
    this.zzo.execute(new zzm(this, internalTokenResult));
  }
  
  private final zzau zzd() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzn : Lcom/google/firebase/auth/internal/zzau;
    //   6: ifnonnull -> 26
    //   9: new com/google/firebase/auth/internal/zzau
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: getfield zza : Lcom/google/firebase/FirebaseApp;
    //   18: invokespecial <init> : (Lcom/google/firebase/FirebaseApp;)V
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial zza : (Lcom/google/firebase/auth/internal/zzau;)V
    //   26: aload_0
    //   27: getfield zzn : Lcom/google/firebase/auth/internal/zzau;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
    //   26	31	35	finally
  }
  
  private final void zzd(FirebaseUser paramFirebaseUser) {
    if (paramFirebaseUser != null) {
      String str = paramFirebaseUser.getUid();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 47);
      stringBuilder.append("Notifying auth state listeners about user ( ");
      stringBuilder.append(str);
      stringBuilder.append(" ).");
      Log.d("FirebaseAuth", stringBuilder.toString());
    } else {
      Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
    } 
    this.zzo.execute(new zzp(this));
  }
  
  public void addAuthStateListener(AuthStateListener paramAuthStateListener) {
    this.zzd.add(paramAuthStateListener);
    this.zzo.execute(new zzn(this, paramAuthStateListener));
  }
  
  public void addIdTokenListener(IdTokenListener paramIdTokenListener) {
    this.zzb.add(paramIdTokenListener);
    this.zzo.execute(new zzl(this, paramIdTokenListener));
  }
  
  public void addIdTokenListener(IdTokenListener paramIdTokenListener) {
    Preconditions.checkNotNull(paramIdTokenListener);
    this.zzc.add(paramIdTokenListener);
    zzd().zza(this.zzc.size());
  }
  
  public Task<Void> applyActionCode(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zzc(this.zza, paramString, this.zzk);
  }
  
  public Task<ActionCodeResult> checkActionCode(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zzb(this.zza, paramString, this.zzk);
  }
  
  public Task<Void> confirmPasswordReset(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    return this.zze.zza(this.zza, paramString1, paramString2, this.zzk);
  }
  
  public Task<AuthResult> createUserWithEmailAndPassword(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    return this.zze.zza(this.zza, paramString1, paramString2, this.zzk, new zza(this));
  }
  
  public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zza(this.zza, paramString, this.zzk);
  }
  
  public Task<GetTokenResult> getAccessToken(boolean paramBoolean) {
    return zza(this.zzf, paramBoolean);
  }
  
  public FirebaseApp getApp() {
    return this.zza;
  }
  
  public FirebaseUser getCurrentUser() {
    return this.zzf;
  }
  
  public FirebaseAuthSettings getFirebaseAuthSettings() {
    return (FirebaseAuthSettings)this.zzg;
  }
  
  public String getLanguageCode() {
    synchronized (this.zzh) {
      return this.zzi;
    } 
  }
  
  public Task<AuthResult> getPendingAuthResult() {
    return this.zzm.zzb();
  }
  
  public String getUid() {
    FirebaseUser firebaseUser = this.zzf;
    return (firebaseUser == null) ? null : firebaseUser.getUid();
  }
  
  public boolean isSignInWithEmailLink(String paramString) {
    return EmailAuthCredential.zza(paramString);
  }
  
  public void removeAuthStateListener(AuthStateListener paramAuthStateListener) {
    this.zzd.remove(paramAuthStateListener);
  }
  
  public void removeIdTokenListener(IdTokenListener paramIdTokenListener) {
    this.zzb.remove(paramIdTokenListener);
  }
  
  public void removeIdTokenListener(IdTokenListener paramIdTokenListener) {
    Preconditions.checkNotNull(paramIdTokenListener);
    this.zzc.remove(paramIdTokenListener);
    zzd().zza(this.zzc.size());
  }
  
  public Task<Void> sendPasswordResetEmail(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return sendPasswordResetEmail(paramString, null);
  }
  
  public Task<Void> sendPasswordResetEmail(String paramString, ActionCodeSettings paramActionCodeSettings) {
    Preconditions.checkNotEmpty(paramString);
    ActionCodeSettings actionCodeSettings = paramActionCodeSettings;
    if (paramActionCodeSettings == null)
      actionCodeSettings = ActionCodeSettings.zza(); 
    String str = this.zzi;
    if (str != null)
      actionCodeSettings.zza(str); 
    actionCodeSettings.zza(zzgk.zzb);
    return this.zze.zza(this.zza, paramString, actionCodeSettings, this.zzk);
  }
  
  public Task<Void> sendSignInLinkToEmail(String paramString, ActionCodeSettings paramActionCodeSettings) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramActionCodeSettings);
    if (paramActionCodeSettings.canHandleCodeInApp()) {
      String str = this.zzi;
      if (str != null)
        paramActionCodeSettings.zza(str); 
      return this.zze.zzb(this.zza, paramString, paramActionCodeSettings, this.zzk);
    } 
    throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
  }
  
  public Task<Void> setFirebaseUIVersion(String paramString) {
    return this.zze.zza(paramString);
  }
  
  public void setLanguageCode(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    synchronized (this.zzh) {
      this.zzi = paramString;
      return;
    } 
  }
  
  public Task<AuthResult> signInAnonymously() {
    FirebaseUser firebaseUser = this.zzf;
    if (firebaseUser != null && firebaseUser.isAnonymous()) {
      zzn zzn = (zzn)this.zzf;
      zzn.zza(false);
      return Tasks.forResult(new zzh(zzn));
    } 
    return this.zze.zza(this.zza, new zza(this), this.zzk);
  }
  
  public Task<AuthResult> signInWithCredential(AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramAuthCredential);
    paramAuthCredential = paramAuthCredential.zza();
    if (paramAuthCredential instanceof EmailAuthCredential) {
      paramAuthCredential = paramAuthCredential;
      return !paramAuthCredential.zzg() ? this.zze.zzb(this.zza, paramAuthCredential.zzb(), paramAuthCredential.zzc(), this.zzk, new zza(this)) : (zzb(paramAuthCredential.zzd()) ? Tasks.forException((Exception)zzdv.zza(new Status(17072))) : this.zze.zza(this.zza, (EmailAuthCredential)paramAuthCredential, new zza(this)));
    } 
    if (paramAuthCredential instanceof PhoneAuthCredential) {
      paramAuthCredential = paramAuthCredential;
      return this.zze.zza(this.zza, (PhoneAuthCredential)paramAuthCredential, this.zzk, new zza(this));
    } 
    return this.zze.zza(this.zza, paramAuthCredential, this.zzk, new zza(this));
  }
  
  public Task<AuthResult> signInWithCustomToken(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zza(this.zza, paramString, this.zzk, new zza(this));
  }
  
  public Task<AuthResult> signInWithEmailAndPassword(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    return this.zze.zzb(this.zza, paramString1, paramString2, this.zzk, new zza(this));
  }
  
  public Task<AuthResult> signInWithEmailLink(String paramString1, String paramString2) {
    return signInWithCredential(EmailAuthProvider.getCredentialWithLink(paramString1, paramString2));
  }
  
  public void signOut() {
    zza();
    zzau zzau1 = this.zzn;
    if (zzau1 != null)
      zzau1.zza(); 
  }
  
  public Task<AuthResult> startActivityForSignInWithProvider(Activity paramActivity, FederatedAuthProvider paramFederatedAuthProvider) {
    Preconditions.checkNotNull(paramFederatedAuthProvider);
    Preconditions.checkNotNull(paramActivity);
    if (!zzds.zza())
      return Tasks.forException((Exception)zzdv.zza(new Status(17063))); 
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    if (!this.zzm.zza(paramActivity, taskCompletionSource, this))
      return Tasks.forException((Exception)zzdv.zza(new Status(17057))); 
    zzas.zza(paramActivity.getApplicationContext(), this);
    paramFederatedAuthProvider.zza(paramActivity);
    return taskCompletionSource.getTask();
  }
  
  public Task<Void> updateCurrentUser(FirebaseUser paramFirebaseUser) {
    if (paramFirebaseUser != null) {
      if (paramFirebaseUser.zzd() == null || paramFirebaseUser.zzd().equals(this.zzk)) {
        String str = this.zzk;
        if (str == null || str.equals(paramFirebaseUser.zzd())) {
          String str1 = paramFirebaseUser.zzc().getOptions().getApiKey();
          str = this.zza.getOptions().getApiKey();
          if (paramFirebaseUser.zze().zzb() && str.equals(str1)) {
            zza(zzn.zza(this.zza, paramFirebaseUser), paramFirebaseUser.zze(), true);
            return Tasks.forResult(null);
          } 
          return zza(paramFirebaseUser, (zzaz)new zzc(this));
        } 
      } 
      return Tasks.forException((Exception)zzdv.zza(new Status(17072)));
    } 
    throw new IllegalArgumentException("Cannot update current user with null user!");
  }
  
  public void useAppLanguage() {
    synchronized (this.zzh) {
      this.zzi = zzeq.zza();
      return;
    } 
  }
  
  public Task<String> verifyPasswordResetCode(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zzd(this.zza, paramString, this.zzk);
  }
  
  public final Task<AuthResult> zza(Activity paramActivity, FederatedAuthProvider paramFederatedAuthProvider, FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramFederatedAuthProvider);
    Preconditions.checkNotNull(paramFirebaseUser);
    if (!zzds.zza())
      return Tasks.forException((Exception)zzdv.zza(new Status(17063))); 
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    if (!this.zzm.zza(paramActivity, taskCompletionSource, this, paramFirebaseUser))
      return Tasks.forException((Exception)zzdv.zza(new Status(17057))); 
    zzas.zza(paramActivity.getApplicationContext(), this, paramFirebaseUser);
    paramFederatedAuthProvider.zzb(paramActivity);
    return taskCompletionSource.getTask();
  }
  
  public final Task<Void> zza(ActionCodeSettings paramActionCodeSettings, String paramString) {
    Preconditions.checkNotEmpty(paramString);
    ActionCodeSettings actionCodeSettings = paramActionCodeSettings;
    if (this.zzi != null) {
      actionCodeSettings = paramActionCodeSettings;
      if (paramActionCodeSettings == null)
        actionCodeSettings = ActionCodeSettings.zza(); 
      actionCodeSettings.zza(this.zzi);
    } 
    return this.zze.zza(this.zza, actionCodeSettings, paramString);
  }
  
  public final Task<Void> zza(FirebaseUser paramFirebaseUser) {
    return zza(paramFirebaseUser, (zzaz)new zzb(this));
  }
  
  public final Task<Void> zza(FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramAuthCredential);
    paramAuthCredential = paramAuthCredential.zza();
    if (paramAuthCredential instanceof EmailAuthCredential) {
      paramAuthCredential = paramAuthCredential;
      return "password".equals(paramAuthCredential.getSignInMethod()) ? this.zze.zza(this.zza, paramFirebaseUser, paramAuthCredential.zzb(), paramAuthCredential.zzc(), paramFirebaseUser.zzd(), (zzaz)new zzb(this)) : (zzb(paramAuthCredential.zzd()) ? Tasks.forException((Exception)zzdv.zza(new Status(17072))) : this.zze.zza(this.zza, paramFirebaseUser, (EmailAuthCredential)paramAuthCredential, (zzaz)new zzb(this)));
    } 
    return (paramAuthCredential instanceof PhoneAuthCredential) ? this.zze.zza(this.zza, paramFirebaseUser, (PhoneAuthCredential)paramAuthCredential, this.zzk, (zzaz)new zzb(this)) : this.zze.zza(this.zza, paramFirebaseUser, paramAuthCredential, paramFirebaseUser.zzd(), (zzaz)new zzb(this));
  }
  
  public final Task<Void> zza(FirebaseUser paramFirebaseUser, PhoneAuthCredential paramPhoneAuthCredential) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramPhoneAuthCredential);
    return this.zze.zza(this.zza, paramFirebaseUser, (PhoneAuthCredential)paramPhoneAuthCredential.zza(), (zzaz)new zzb(this));
  }
  
  public final Task<Void> zza(FirebaseUser paramFirebaseUser, UserProfileChangeRequest paramUserProfileChangeRequest) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramUserProfileChangeRequest);
    return this.zze.zza(this.zza, paramFirebaseUser, paramUserProfileChangeRequest, (zzaz)new zzb(this));
  }
  
  public final Task<AuthResult> zza(FirebaseUser paramFirebaseUser, String paramString) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramFirebaseUser);
    return this.zze.zzd(this.zza, paramFirebaseUser, paramString, (zzaz)new zzb(this));
  }
  
  public final Task<GetTokenResult> zza(FirebaseUser paramFirebaseUser, boolean paramBoolean) {
    if (paramFirebaseUser == null)
      return Tasks.forException((Exception)zzdv.zza(new Status(17495))); 
    zzff zzff = paramFirebaseUser.zze();
    return (zzff.zzb() && !paramBoolean) ? Tasks.forResult(zzap.zza(zzff.zzd())) : this.zze.zza(this.zza, paramFirebaseUser, zzff.zzc(), (zzaz)new zzo(this));
  }
  
  public final void zza() {
    FirebaseUser firebaseUser = this.zzf;
    if (firebaseUser != null) {
      zzav zzav1 = this.zzl;
      Preconditions.checkNotNull(firebaseUser);
      zzav1.zza(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[] { firebaseUser.getUid() }));
      this.zzf = null;
    } 
    this.zzl.zza("com.google.firebase.auth.FIREBASE_USER");
    zzc((FirebaseUser)null);
    zzd((FirebaseUser)null);
  }
  
  public final void zza(FirebaseUser paramFirebaseUser, zzff paramzzff, boolean paramBoolean) {
    zza(paramFirebaseUser, paramzzff, paramBoolean, false);
  }
  
  final void zza(FirebaseUser paramFirebaseUser, zzff paramzzff, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool2;
    boolean bool3;
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramzzff);
    FirebaseUser firebaseUser = this.zzf;
    boolean bool1 = true;
    if (firebaseUser != null && paramFirebaseUser.getUid().equals(this.zzf.getUid())) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (!bool2 && paramBoolean2)
      return; 
    firebaseUser = this.zzf;
    if (firebaseUser == null) {
      bool3 = true;
      bool2 = bool1;
    } else {
      paramBoolean2 = firebaseUser.zze().zzd().equals(paramzzff.zzd());
      if (bool2 && (paramBoolean2 ^ true) == 0) {
        bool3 = false;
      } else {
        bool3 = true;
      } 
      if (!bool2) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
    } 
    Preconditions.checkNotNull(paramFirebaseUser);
    firebaseUser = this.zzf;
    if (firebaseUser == null) {
      this.zzf = paramFirebaseUser;
    } else {
      firebaseUser.zza(paramFirebaseUser.getProviderData());
      if (!paramFirebaseUser.isAnonymous())
        this.zzf.zzb(); 
      List<zzy> list = paramFirebaseUser.zzh().zza();
      this.zzf.zzb(list);
    } 
    if (paramBoolean1)
      this.zzl.zza(this.zzf); 
    if (bool3) {
      firebaseUser = this.zzf;
      if (firebaseUser != null)
        firebaseUser.zza(paramzzff); 
      zzc(this.zzf);
    } 
    if (bool2)
      zzd(this.zzf); 
    if (paramBoolean1)
      this.zzl.zza(paramFirebaseUser, paramzzff); 
    zzd().zza(this.zzf.zze());
  }
  
  public final void zza(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    synchronized (this.zzj) {
      this.zzk = paramString;
      return;
    } 
  }
  
  public final void zza(String paramString1, long paramLong, TimeUnit paramTimeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, Activity paramActivity, Executor paramExecutor, boolean paramBoolean, String paramString2) {
    paramLong = TimeUnit.SECONDS.convert(paramLong, paramTimeUnit);
    if (paramLong >= 0L && paramLong <= 120L) {
      zzfr zzfr = new zzfr(paramString1, paramLong, paramBoolean, this.zzi, this.zzk, null);
      if (this.zzg.zzc() && paramString1.equals(this.zzg.zza()))
        paramOnVerificationStateChangedCallbacks = new zzr(this, paramOnVerificationStateChangedCallbacks); 
      this.zze.zza(this.zza, zzfr, paramOnVerificationStateChangedCallbacks, paramActivity, paramExecutor);
      return;
    } 
    throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
  }
  
  public final Task<AuthResult> zzb(Activity paramActivity, FederatedAuthProvider paramFederatedAuthProvider, FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramFederatedAuthProvider);
    Preconditions.checkNotNull(paramFirebaseUser);
    if (!zzds.zza())
      return Tasks.forException((Exception)zzdv.zza(new Status(17063))); 
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    if (!this.zzm.zza(paramActivity, taskCompletionSource, this, paramFirebaseUser))
      return Tasks.forException((Exception)zzdv.zza(new Status(17057))); 
    zzas.zza(paramActivity.getApplicationContext(), this, paramFirebaseUser);
    paramFederatedAuthProvider.zzc(paramActivity);
    return taskCompletionSource.getTask();
  }
  
  public final Task<Void> zzb(FirebaseUser paramFirebaseUser) {
    Preconditions.checkNotNull(paramFirebaseUser);
    return this.zze.zza(paramFirebaseUser, new zzq(this, paramFirebaseUser));
  }
  
  public final Task<AuthResult> zzb(FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramAuthCredential);
    paramAuthCredential = paramAuthCredential.zza();
    if (paramAuthCredential instanceof EmailAuthCredential) {
      paramAuthCredential = paramAuthCredential;
      return "password".equals(paramAuthCredential.getSignInMethod()) ? this.zze.zzb(this.zza, paramFirebaseUser, paramAuthCredential.zzb(), paramAuthCredential.zzc(), paramFirebaseUser.zzd(), (zzaz)new zzb(this)) : (zzb(paramAuthCredential.zzd()) ? Tasks.forException((Exception)zzdv.zza(new Status(17072))) : this.zze.zzb(this.zza, paramFirebaseUser, (EmailAuthCredential)paramAuthCredential, (zzaz)new zzb(this)));
    } 
    return (paramAuthCredential instanceof PhoneAuthCredential) ? this.zze.zzb(this.zza, paramFirebaseUser, (PhoneAuthCredential)paramAuthCredential, this.zzk, (zzaz)new zzb(this)) : this.zze.zzb(this.zza, paramFirebaseUser, paramAuthCredential, paramFirebaseUser.zzd(), (zzaz)new zzb(this));
  }
  
  public final Task<Void> zzb(FirebaseUser paramFirebaseUser, String paramString) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zzb(this.zza, paramFirebaseUser, paramString, (zzaz)new zzb(this));
  }
  
  public final FirebaseApp zzb() {
    return this.zza;
  }
  
  public final Task<AuthResult> zzc(FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential) {
    Preconditions.checkNotNull(paramAuthCredential);
    Preconditions.checkNotNull(paramFirebaseUser);
    return this.zze.zza(this.zza, paramFirebaseUser, paramAuthCredential.zza(), (zzaz)new zzb(this));
  }
  
  public final Task<Void> zzc(FirebaseUser paramFirebaseUser, String paramString) {
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotEmpty(paramString);
    return this.zze.zzc(this.zza, paramFirebaseUser, paramString, (zzaz)new zzb(this));
  }
  
  public final String zzc() {
    synchronized (this.zzj) {
      return this.zzk;
    } 
  }
  
  public static interface AuthStateListener {
    void onAuthStateChanged(FirebaseAuth param1FirebaseAuth);
  }
  
  public static interface IdTokenListener {
    void onIdTokenChanged(FirebaseAuth param1FirebaseAuth);
  }
  
  class zza implements zza {
    zza(FirebaseAuth this$0) {}
    
    public final void zza(zzff param1zzff, FirebaseUser param1FirebaseUser) {
      Preconditions.checkNotNull(param1zzff);
      Preconditions.checkNotNull(param1FirebaseUser);
      param1FirebaseUser.zza(param1zzff);
      this.zza.zza(param1FirebaseUser, param1zzff, true);
    }
  }
  
  final class zzb implements zza, zzae {
    zzb(FirebaseAuth this$0) {}
    
    public final void zza(Status param1Status) {
      if (param1Status.getStatusCode() == 17011 || param1Status.getStatusCode() == 17021 || param1Status.getStatusCode() == 17005 || param1Status.getStatusCode() == 17091)
        this.zza.signOut(); 
    }
    
    public final void zza(zzff param1zzff, FirebaseUser param1FirebaseUser) {
      Preconditions.checkNotNull(param1zzff);
      Preconditions.checkNotNull(param1FirebaseUser);
      param1FirebaseUser.zza(param1zzff);
      this.zza.zza(param1FirebaseUser, param1zzff, true, true);
    }
  }
  
  final class zzc extends zza implements zza, zzae {
    zzc(FirebaseAuth this$0) {
      super(this$0);
    }
    
    public final void zza(Status param1Status) {}
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\FirebaseAuth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */