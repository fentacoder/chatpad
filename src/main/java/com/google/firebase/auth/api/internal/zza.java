package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzeh;
import com.google.android.gms.internal.firebase_auth.zzen;
import com.google.android.gms.internal.firebase_auth.zzer;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzev;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzfa;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.android.gms.internal.firebase_auth.zzfn;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzfu;
import com.google.android.gms.internal.firebase_auth.zzfv;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.android.gms.internal.firebase_auth.zzgd;
import com.google.android.gms.internal.firebase_auth.zzge;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzy;
import com.google.firebase.auth.zzg;

public final class zza {
  private static final Logger zza = new Logger("FBAuthApiDispatcher", new String[0]);
  
  private final zzfb zzb;
  
  private final zzar zzc;
  
  public zza(zzfb paramzzfb, zzar paramzzar) {
    this.zzb = (zzfb)Preconditions.checkNotNull(paramzzfb);
    this.zzc = (zzar)Preconditions.checkNotNull(paramzzar);
  }
  
  private static zzff zza(zzff paramzzff, zzfv paramzzfv) {
    Preconditions.checkNotNull(paramzzff);
    Preconditions.checkNotNull(paramzzfv);
    String str1 = paramzzfv.zzb();
    String str2 = paramzzfv.zzc();
    return (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) ? new zzff(str2, str1, Long.valueOf(paramzzfv.zzd()), paramzzff.zzf()) : paramzzff;
  }
  
  private final void zza(zzer paramzzer, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzer);
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza(paramzzer, new zzg(this, paramzzdu));
  }
  
  private final void zza(zzff paramzzff, String paramString1, String paramString2, Boolean paramBoolean, zzg paramzzg, zzdu paramzzdu, zzfe paramzzfe) {
    Preconditions.checkNotNull(paramzzff);
    Preconditions.checkNotNull(paramzzfe);
    Preconditions.checkNotNull(paramzzdu);
    zzev zzev = new zzev(paramzzff.zzd());
    this.zzb.zza(zzev, new zzh(this, paramzzfe, paramString2, paramString1, paramBoolean, paramzzg, paramzzdu, paramzzff));
  }
  
  private final void zza(zzga paramzzga, zzdu paramzzdu, zzfe paramzzfe) {
    Status status;
    String str;
    if (paramzzga.zzk()) {
      zzg zzg = paramzzga.zzp();
      str = paramzzga.zzd();
      String str1 = paramzzga.zzl();
      if (paramzzga.zzb()) {
        status = new Status(17012);
      } else {
        status = zzy.zza(status.zzj());
      } 
      if (this.zzc.zza()) {
        paramzzdu.zza(new zzeh(status, zzg, str, str1));
        return;
      } 
      paramzzdu.zza(status);
      return;
    } 
    zza(new zzff(status.zzg(), status.zzc(), Long.valueOf(status.zzh()), "Bearer"), status.zzf(), status.zze(), Boolean.valueOf(status.zzi()), status.zzp(), paramzzdu, (zzfe)str);
  }
  
  private final void zza(zzdu paramzzdu, zzff paramzzff, zzew paramzzew, zzfs paramzzfs, zzfe paramzzfe) {
    Preconditions.checkNotNull(paramzzdu);
    Preconditions.checkNotNull(paramzzff);
    Preconditions.checkNotNull(paramzzew);
    Preconditions.checkNotNull(paramzzfs);
    Preconditions.checkNotNull(paramzzfe);
    this.zzb.zza(paramzzfs, new zzi(this, paramzzfs, paramzzew, paramzzdu, paramzzff, paramzzfe));
  }
  
  private final void zza(zzdu paramzzdu, zzff paramzzff, zzfs paramzzfs, zzfe paramzzfe) {
    Preconditions.checkNotNull(paramzzdu);
    Preconditions.checkNotNull(paramzzff);
    Preconditions.checkNotNull(paramzzfs);
    Preconditions.checkNotNull(paramzzfe);
    zzev zzev = new zzev(paramzzff.zzd());
    this.zzb.zza(zzev, new zzf(this, paramzzfe, paramzzdu, paramzzff, paramzzfs));
  }
  
  private final void zza(String paramString, zzfd<zzff> paramzzfd) {
    Preconditions.checkNotNull(paramzzfd);
    Preconditions.checkNotEmpty(paramString);
    zzff zzff = zzff.zzb(paramString);
    if (zzff.zzb()) {
      paramzzfd.zza(zzff);
      return;
    } 
    zzes zzes = new zzes(zzff.zzc());
    this.zzb.zza(zzes, new zzaj(this, paramzzfd));
  }
  
  private final void zzb(zzfa paramzzfa, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzfa);
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza(paramzzfa, new zzad(this, paramzzdu));
  }
  
  public final void zza(Context paramContext, zzfy paramzzfy, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzfy);
    Preconditions.checkNotNull(paramzzdu);
    if (this.zzc.zza())
      paramzzfy.zzc(true); 
    this.zzb.zza((Context)null, paramzzfy, new zzx(this, paramzzdu));
  }
  
  public final void zza(Context paramContext, zzgg paramzzgg, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzgg);
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza((Context)null, paramzzgg, new zzq(this, paramzzdu));
  }
  
  public final void zza(Context paramContext, String paramString, zzgg paramzzgg, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzgg);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzs(this, paramzzgg, null, paramzzdu));
  }
  
  public final void zza(Context paramContext, String paramString1, String paramString2, String paramString3, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zzge zzge = new zzge(paramString1, paramString2, paramString3);
    this.zzb.zza((Context)null, zzge, new zze(this, paramzzdu));
  }
  
  public final void zza(zzfa paramzzfa, zzdu paramzzdu) {
    zzb(paramzzfa, paramzzdu);
  }
  
  public final void zza(zzfr paramzzfr, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramzzfr.zzb());
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza(paramzzfr, new zzn(this, paramzzdu));
  }
  
  public final void zza(zzgd paramzzgd, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzgd);
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza(paramzzgd, new zzl(this, paramzzdu));
  }
  
  public final void zza(EmailAuthCredential paramEmailAuthCredential, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramEmailAuthCredential);
    Preconditions.checkNotNull(paramzzdu);
    if (paramEmailAuthCredential.zzf()) {
      zza(paramEmailAuthCredential.zze(), new zzd(this, paramEmailAuthCredential, paramzzdu));
      return;
    } 
    zza(new zzer(paramEmailAuthCredential, null), paramzzdu);
  }
  
  public final void zza(String paramString, zzfy paramzzfy, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzfy);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzu(this, paramzzfy, paramzzdu));
  }
  
  public final void zza(String paramString, ActionCodeSettings paramActionCodeSettings, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzdu);
    zzfa zzfa = new zzfa(zzgk.zzc);
    zzfa.zzb(paramString);
    if (paramActionCodeSettings != null)
      zzfa.zza(paramActionCodeSettings); 
    zzb(zzfa, paramzzdu);
  }
  
  public final void zza(String paramString1, ActionCodeSettings paramActionCodeSettings, String paramString2, zzdu paramzzdu) {
    zzfa zzfa;
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramzzdu);
    zzgk zzgk = zzgk.zza(paramActionCodeSettings.zzd());
    if (zzgk != null) {
      zzfa = new zzfa(zzgk);
    } else {
      zzfa = new zzfa(zzgk.zza);
    } 
    zzfa.zza(paramString1);
    zzfa.zza(paramActionCodeSettings);
    zzfa.zzc(paramString2);
    this.zzb.zza(zzfa, new zzj(this, paramzzdu));
  }
  
  public final void zza(String paramString, UserProfileChangeRequest paramUserProfileChangeRequest, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramUserProfileChangeRequest);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzaf(this, paramUserProfileChangeRequest, paramzzdu));
  }
  
  public final void zza(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzdu);
    zzes zzes = new zzes(paramString);
    this.zzb.zza(zzes, new zzc(this, paramzzdu));
  }
  
  public final void zza(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString1, new zzai(this, paramString2, paramzzdu));
  }
  
  public final void zza(String paramString1, String paramString2, String paramString3, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zzfu zzfu = new zzfu(paramString1, paramString2, null, paramString3);
    this.zzb.zza(zzfu, new zzb(this, paramzzdu));
  }
  
  public final void zzb(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzdu);
    zzfu zzfu = new zzfu(paramString);
    this.zzb.zza(zzfu, new zzag(this, paramzzdu));
  }
  
  public final void zzb(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString1, new zzah(this, paramString2, paramzzdu));
  }
  
  public final void zzb(String paramString1, String paramString2, String paramString3, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zzfn zzfn = new zzfn(paramString1, paramString2, paramString3);
    this.zzb.zza(zzfn, new zzo(this, paramzzdu));
  }
  
  public final void zzc(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzw(this, paramzzdu));
  }
  
  public final void zzc(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramzzdu);
    zzfs zzfs = new zzfs();
    zzfs.zzh(paramString1);
    zzfs.zzi(paramString2);
    this.zzb.zza(zzfs, new zzak(this, paramzzdu));
  }
  
  public final void zzc(String paramString1, String paramString2, String paramString3, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString3, new zzp(this, paramString1, paramString2, paramzzdu));
  }
  
  public final void zzd(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzaa(this, paramzzdu));
  }
  
  public final void zzd(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramzzdu);
    zzen zzen = new zzen(paramString1, paramString2);
    this.zzb.zza(zzen, new zzk(this, paramzzdu));
  }
  
  public final void zze(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString, new zzac(this, paramzzdu));
  }
  
  public final void zze(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramzzdu);
    zzfn zzfn = new zzfn(paramString1, null, paramString2);
    this.zzb.zza(zzfn, new zzm(this, paramzzdu));
  }
  
  public final void zzf(String paramString, zzdu paramzzdu) {
    Preconditions.checkNotNull(paramzzdu);
    this.zzb.zza(paramString, new zzae(this, paramzzdu));
  }
  
  public final void zzf(String paramString1, String paramString2, zzdu paramzzdu) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotNull(paramzzdu);
    zza(paramString2, new zzv(this, paramString1, paramzzdu));
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\api\internal\zza.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */