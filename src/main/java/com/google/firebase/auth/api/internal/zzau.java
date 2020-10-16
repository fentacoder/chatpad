package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzf;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.android.gms.internal.firebase_auth.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzab;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.internal.zzaz;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class zzau extends zzam<zzei> {
  private final Context zza;
  
  private final zzei zzb;
  
  private final Future<zzal<zzei>> zzc;
  
  zzau(Context paramContext, zzei paramzzei) {
    this.zza = paramContext;
    this.zzb = paramzzei;
    this.zzc = super.zza();
  }
  
  private final <ResultT> Task<ResultT> zza(Task<ResultT> paramTask, zzap<zzdt, ResultT> paramzzap) {
    return paramTask.continueWithTask(new zzat(this, paramzzap));
  }
  
  static zzn zza(FirebaseApp paramFirebaseApp, zzew paramzzew) {
    Preconditions.checkNotNull(paramFirebaseApp);
    Preconditions.checkNotNull(paramzzew);
    ArrayList<zzj> arrayList = new ArrayList();
    arrayList.add(new zzj(paramzzew, "firebase"));
    List<zzfj> list = paramzzew.zzj();
    if (list != null && !list.isEmpty())
      for (byte b = 0; b < list.size(); b++)
        arrayList.add(new zzj(list.get(b)));  
    zzn zzn = new zzn(paramFirebaseApp, arrayList);
    zzn.zza(new zzp(paramzzew.zzh(), paramzzew.zzg()));
    zzn.zza(paramzzew.zzi());
    zzn.zza(paramzzew.zzl());
    zzn.zzb(zzar.zza(paramzzew.zzm()));
    return zzn;
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, ActionCodeSettings paramActionCodeSettings, String paramString) {
    zzck zzck = (zzck)(new zzck(paramString, paramActionCodeSettings)).zza(paramFirebaseApp);
    return zza(zzb(zzck), zzck);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, AuthCredential paramAuthCredential, String paramString, zza paramzza) {
    zzcs zzcs = (zzcs)(new zzcs(paramAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzcs), zzcs);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, EmailAuthCredential paramEmailAuthCredential, zza paramzza) {
    zzcy zzcy = (zzcy)(new zzcy(paramEmailAuthCredential)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzcy), zzcy);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential, zzaz paramzzaz) {
    zzbq zzbq;
    zzbo zzbo;
    EmailAuthCredential emailAuthCredential;
    Preconditions.checkNotNull(paramFirebaseApp);
    Preconditions.checkNotNull(paramAuthCredential);
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramzzaz);
    List list = paramFirebaseUser.zza();
    if (list != null && list.contains(paramAuthCredential.getProvider()))
      return Tasks.forException((Exception)zzdv.zza(new Status(17015))); 
    if (paramAuthCredential instanceof EmailAuthCredential) {
      zzbk zzbk;
      emailAuthCredential = (EmailAuthCredential)paramAuthCredential;
      if (!emailAuthCredential.zzg()) {
        zzbk = (zzbk)(new zzbk(emailAuthCredential)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
        return zza(zzb(zzbk), zzbk);
      } 
      zzbq = (zzbq)(new zzbq(emailAuthCredential)).zza((FirebaseApp)zzbk).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
      return zza(zzb(zzbq), zzbq);
    } 
    if (emailAuthCredential instanceof PhoneAuthCredential) {
      zzbo = (zzbo)(new zzbo((PhoneAuthCredential)emailAuthCredential)).zza((FirebaseApp)zzbq).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
      return zza(zzb(zzbo), zzbo);
    } 
    Preconditions.checkNotNull(zzbo);
    Preconditions.checkNotNull(emailAuthCredential);
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramzzaz);
    zzbm zzbm = (zzbm)(new zzbm((AuthCredential)emailAuthCredential)).zza((FirebaseApp)zzbo).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzbm), zzbm);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential, String paramString, zzaz paramzzaz) {
    zzbs zzbs = (zzbs)(new zzbs(paramAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzbs), zzbs);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, EmailAuthCredential paramEmailAuthCredential, zzaz paramzzaz) {
    zzbw zzbw = (zzbw)(new zzbw(paramEmailAuthCredential)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzbw), zzbw);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, PhoneAuthCredential paramPhoneAuthCredential, zzaz paramzzaz) {
    zzdk zzdk = (zzdk)(new zzdk(paramPhoneAuthCredential)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzdk), zzdk);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, PhoneAuthCredential paramPhoneAuthCredential, String paramString, zzaz paramzzaz) {
    zzce zzce = (zzce)(new zzce(paramPhoneAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzce), zzce);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, UserProfileChangeRequest paramUserProfileChangeRequest, zzaz paramzzaz) {
    zzdm zzdm = (zzdm)(new zzdm(paramUserProfileChangeRequest)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzdm), zzdm);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, zzaz paramzzaz) {
    zzci zzci = (zzci)(new zzci()).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zza(zzci), zzci);
  }
  
  public final Task<GetTokenResult> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString, zzaz paramzzaz) {
    zzbi zzbi = (zzbi)(new zzbi(paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zza(zzbi), zzbi);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString1, String paramString2, String paramString3, zzaz paramzzaz) {
    zzca zzca = (zzca)(new zzca(paramString1, paramString2, paramString3)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzca), zzca);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, PhoneAuthCredential paramPhoneAuthCredential, String paramString, zza paramzza) {
    zzda zzda = (zzda)(new zzda(paramPhoneAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzda), zzda);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, zza paramzza, String paramString) {
    zzcq zzcq = (zzcq)(new zzcq(paramString)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzcq), zzcq);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, String paramString1, ActionCodeSettings paramActionCodeSettings, String paramString2) {
    paramActionCodeSettings.zza(zzgk.zzb);
    zzcm zzcm = (zzcm)(new zzcm(paramString1, paramActionCodeSettings, paramString2, "sendPasswordResetEmail")).zza(paramFirebaseApp);
    return zza(zzb(zzcm), zzcm);
  }
  
  public final Task<SignInMethodQueryResult> zza(FirebaseApp paramFirebaseApp, String paramString1, String paramString2) {
    zzbg zzbg = (zzbg)(new zzbg(paramString1, paramString2)).zza(paramFirebaseApp);
    return zza(zza(zzbg), zzbg);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, String paramString1, String paramString2, zza paramzza) {
    zzcu zzcu = (zzcu)(new zzcu(paramString1, paramString2)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzcu), zzcu);
  }
  
  public final Task<Void> zza(FirebaseApp paramFirebaseApp, String paramString1, String paramString2, String paramString3) {
    zzba zzba = (zzba)(new zzba(paramString1, paramString2, paramString3)).zza(paramFirebaseApp);
    return zza(zzb(zzba), zzba);
  }
  
  public final Task<AuthResult> zza(FirebaseApp paramFirebaseApp, String paramString1, String paramString2, String paramString3, zza paramzza) {
    zzbc zzbc = (zzbc)(new zzbc(paramString1, paramString2, paramString3)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzbc), zzbc);
  }
  
  public final Task<Void> zza(FirebaseUser paramFirebaseUser, zzab paramzzab) {
    zzbe zzbe = (zzbe)(new zzbe()).zza(paramFirebaseUser).zza(paramzzab).zza((zzae)paramzzab);
    return zza(zzb(zzbe), zzbe);
  }
  
  public final Task<Void> zza(String paramString) {
    zzco zzco = new zzco(paramString);
    return zza(zzb(zzco), zzco);
  }
  
  final Future<zzal<zzei>> zza() {
    Future<zzal<zzei>> future = this.zzc;
    if (future != null)
      return future; 
    Context context = this.zza;
    zzdr zzdr = new zzdr(this.zzb, context);
    return zzf.zza().zza(zzk.zza).submit(zzdr);
  }
  
  public final void zza(FirebaseApp paramFirebaseApp, zzfr paramzzfr, PhoneAuthProvider.OnVerificationStateChangedCallbacks paramOnVerificationStateChangedCallbacks, Activity paramActivity, Executor paramExecutor) {
    zzdq zzdq = (zzdq)(new zzdq(paramzzfr)).zza(paramFirebaseApp).zza(paramOnVerificationStateChangedCallbacks, paramActivity, paramExecutor);
    zza(zzb(zzdq), zzdq);
  }
  
  public final Task<AuthResult> zzb(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, AuthCredential paramAuthCredential, String paramString, zzaz paramzzaz) {
    zzbu zzbu = (zzbu)(new zzbu(paramAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzbu), zzbu);
  }
  
  public final Task<AuthResult> zzb(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, EmailAuthCredential paramEmailAuthCredential, zzaz paramzzaz) {
    zzby zzby = (zzby)(new zzby(paramEmailAuthCredential)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzby), zzby);
  }
  
  public final Task<AuthResult> zzb(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, PhoneAuthCredential paramPhoneAuthCredential, String paramString, zzaz paramzzaz) {
    zzcg zzcg = (zzcg)(new zzcg(paramPhoneAuthCredential, paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzcg), zzcg);
  }
  
  public final Task<Void> zzb(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString, zzaz paramzzaz) {
    zzdg zzdg = (zzdg)(new zzdg(paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzdg), zzdg);
  }
  
  public final Task<AuthResult> zzb(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString1, String paramString2, String paramString3, zzaz paramzzaz) {
    zzcc zzcc = (zzcc)(new zzcc(paramString1, paramString2, paramString3)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzcc), zzcc);
  }
  
  public final Task<Void> zzb(FirebaseApp paramFirebaseApp, String paramString1, ActionCodeSettings paramActionCodeSettings, String paramString2) {
    paramActionCodeSettings.zza(zzgk.zze);
    zzcm zzcm = (zzcm)(new zzcm(paramString1, paramActionCodeSettings, paramString2, "sendSignInLinkToEmail")).zza(paramFirebaseApp);
    return zza(zzb(zzcm), zzcm);
  }
  
  public final Task<ActionCodeResult> zzb(FirebaseApp paramFirebaseApp, String paramString1, String paramString2) {
    zzay zzay = (zzay)(new zzay(paramString1, paramString2)).zza(paramFirebaseApp);
    return zza(zzb(zzay), zzay);
  }
  
  public final Task<AuthResult> zzb(FirebaseApp paramFirebaseApp, String paramString1, String paramString2, String paramString3, zza paramzza) {
    zzcw zzcw = (zzcw)(new zzcw(paramString1, paramString2, paramString3)).zza(paramFirebaseApp).zza(paramzza);
    return zza(zzb(zzcw), zzcw);
  }
  
  public final Task<Void> zzc(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString, zzaz paramzzaz) {
    zzdi zzdi = (zzdi)(new zzdi(paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzdi), zzdi);
  }
  
  public final Task<Void> zzc(FirebaseApp paramFirebaseApp, String paramString1, String paramString2) {
    zzaw zzaw = (zzaw)(new zzaw(paramString1, paramString2)).zza(paramFirebaseApp);
    return zza(zzb(zzaw), zzaw);
  }
  
  public final Task<AuthResult> zzd(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser, String paramString, zzaz paramzzaz) {
    zzde zzde;
    Preconditions.checkNotNull(paramFirebaseApp);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramFirebaseUser);
    Preconditions.checkNotNull(paramzzaz);
    List list = paramFirebaseUser.zza();
    if ((list != null && !list.contains(paramString)) || paramFirebaseUser.isAnonymous())
      return Tasks.forException((Exception)zzdv.zza(new Status(17016, paramString))); 
    byte b = -1;
    if (paramString.hashCode() == 1216985755 && paramString.equals("password"))
      b = 0; 
    if (b != 0) {
      zzde = (zzde)(new zzde(paramString)).zza(paramFirebaseApp).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
      return zza(zzb(zzde), zzde);
    } 
    zzdc zzdc = (zzdc)(new zzdc()).zza((FirebaseApp)zzde).zza(paramFirebaseUser).zza(paramzzaz).zza((zzae)paramzzaz);
    return zza(zzb(zzdc), zzdc);
  }
  
  public final Task<String> zzd(FirebaseApp paramFirebaseApp, String paramString1, String paramString2) {
    zzdo zzdo = (zzdo)(new zzdo(paramString1, paramString2)).zza(paramFirebaseApp);
    return zza(zzb(zzdo), zzdo);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zzau.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */