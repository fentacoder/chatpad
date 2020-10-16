package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzg;
import com.google.firebase.auth.zzy;
import com.google.firebase.auth.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzn extends FirebaseUser {
  public static final Parcelable.Creator<zzn> CREATOR = new zzq();
  
  private zzff zza;
  
  private zzj zzb;
  
  private String zzc;
  
  private String zzd;
  
  private List<zzj> zze;
  
  private List<String> zzf;
  
  private String zzg;
  
  private Boolean zzh;
  
  private zzp zzi;
  
  private boolean zzj;
  
  private zzg zzk;
  
  private zzaq zzl;
  
  zzn(zzff paramzzff, zzj paramzzj, String paramString1, String paramString2, List<zzj> paramList, List<String> paramList1, String paramString3, Boolean paramBoolean, zzp paramzzp, boolean paramBoolean1, zzg paramzzg, zzaq paramzzaq) {
    this.zza = paramzzff;
    this.zzb = paramzzj;
    this.zzc = paramString1;
    this.zzd = paramString2;
    this.zze = paramList;
    this.zzf = paramList1;
    this.zzg = paramString3;
    this.zzh = paramBoolean;
    this.zzi = paramzzp;
    this.zzj = paramBoolean1;
    this.zzk = paramzzg;
    this.zzl = paramzzaq;
  }
  
  public zzn(FirebaseApp paramFirebaseApp, List<? extends UserInfo> paramList) {
    Preconditions.checkNotNull(paramFirebaseApp);
    this.zzc = paramFirebaseApp.getName();
    this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
    this.zzg = "2";
    super.zza(paramList);
  }
  
  public static FirebaseUser zza(FirebaseApp paramFirebaseApp, FirebaseUser paramFirebaseUser) {
    zzn zzn1 = new zzn(paramFirebaseApp, paramFirebaseUser.getProviderData());
    if (paramFirebaseUser instanceof zzn) {
      zzn zzn2 = (zzn)paramFirebaseUser;
      zzn1.zzg = zzn2.zzg;
      zzn1.zzd = zzn2.zzd;
      zzn1.zzi = (zzp)zzn2.getMetadata();
    } else {
      zzn1.zzi = null;
    } 
    if (paramFirebaseUser.zze() != null)
      zzn1.zza(paramFirebaseUser.zze()); 
    if (!paramFirebaseUser.isAnonymous())
      zzn1.zzb(); 
    return zzn1;
  }
  
  public String getDisplayName() {
    return this.zzb.getDisplayName();
  }
  
  public String getEmail() {
    return this.zzb.getEmail();
  }
  
  public FirebaseUserMetadata getMetadata() {
    return this.zzi;
  }
  
  public String getPhoneNumber() {
    return this.zzb.getPhoneNumber();
  }
  
  public Uri getPhotoUrl() {
    return this.zzb.getPhotoUrl();
  }
  
  public List<? extends UserInfo> getProviderData() {
    return (List)this.zze;
  }
  
  public String getProviderId() {
    return this.zzb.getProviderId();
  }
  
  public String getUid() {
    return this.zzb.getUid();
  }
  
  public boolean isAnonymous() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzh : Ljava/lang/Boolean;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 16
    //   9: aload_1
    //   10: invokevirtual booleanValue : ()Z
    //   13: ifeq -> 105
    //   16: aload_0
    //   17: getfield zza : Lcom/google/android/gms/internal/firebase_auth/zzff;
    //   20: astore_2
    //   21: ldc ''
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: aload_2
    //   27: ifnull -> 49
    //   30: aload_2
    //   31: invokevirtual zzd : ()Ljava/lang/String;
    //   34: invokestatic zza : (Ljava/lang/String;)Lcom/google/firebase/auth/GetTokenResult;
    //   37: astore_2
    //   38: aload_3
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull -> 49
    //   44: aload_2
    //   45: invokevirtual getSignInProvider : ()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual getProviderData : ()Ljava/util/List;
    //   53: invokeinterface size : ()I
    //   58: istore #4
    //   60: iconst_1
    //   61: istore #5
    //   63: iload #4
    //   65: iconst_1
    //   66: if_icmpgt -> 93
    //   69: iload #5
    //   71: istore #6
    //   73: aload_1
    //   74: ifnull -> 96
    //   77: aload_1
    //   78: ldc 'custom'
    //   80: invokevirtual equals : (Ljava/lang/Object;)Z
    //   83: ifne -> 93
    //   86: iload #5
    //   88: istore #6
    //   90: goto -> 96
    //   93: iconst_0
    //   94: istore #6
    //   96: aload_0
    //   97: iload #6
    //   99: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   102: putfield zzh : Ljava/lang/Boolean;
    //   105: aload_0
    //   106: getfield zzh : Ljava/lang/Boolean;
    //   109: invokevirtual booleanValue : ()Z
    //   112: ireturn
  }
  
  public boolean isEmailVerified() {
    return this.zzb.isEmailVerified();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)super.zze(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zzb, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, this.zze, false);
    SafeParcelWriter.writeStringList(paramParcel, 6, super.zza(), false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzg, false);
    SafeParcelWriter.writeBooleanObject(paramParcel, 8, Boolean.valueOf(super.isAnonymous()), false);
    SafeParcelWriter.writeParcelable(paramParcel, 9, (Parcelable)super.getMetadata(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzj);
    SafeParcelWriter.writeParcelable(paramParcel, 11, (Parcelable)this.zzk, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 12, (Parcelable)this.zzl, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final FirebaseUser zza(List<? extends UserInfo> paramList) {
    Preconditions.checkNotNull(paramList);
    this.zze = new ArrayList<>(paramList.size());
    this.zzf = new ArrayList<>(paramList.size());
    for (byte b = 0; b < paramList.size(); b++) {
      UserInfo userInfo = paramList.get(b);
      if (userInfo.getProviderId().equals("firebase")) {
        this.zzb = (zzj)userInfo;
      } else {
        this.zzf.add(userInfo.getProviderId());
      } 
      this.zze.add((zzj)userInfo);
    } 
    if (this.zzb == null)
      this.zzb = this.zze.get(0); 
    return this;
  }
  
  public final zzn zza(String paramString) {
    this.zzg = paramString;
    return this;
  }
  
  public final List<String> zza() {
    return this.zzf;
  }
  
  public final void zza(zzff paramzzff) {
    this.zza = (zzff)Preconditions.checkNotNull(paramzzff);
  }
  
  public final void zza(zzp paramzzp) {
    this.zzi = paramzzp;
  }
  
  public final void zza(zzg paramzzg) {
    this.zzk = paramzzg;
  }
  
  public final void zza(boolean paramBoolean) {
    this.zzj = paramBoolean;
  }
  
  public final void zzb(List<zzy> paramList) {
    this.zzl = zzaq.zza(paramList);
  }
  
  public final FirebaseApp zzc() {
    return FirebaseApp.getInstance(this.zzc);
  }
  
  public final String zzd() {
    zzff zzff1 = this.zza;
    String str1 = null;
    String str2 = str1;
    if (zzff1 != null) {
      str2 = str1;
      if (zzff1.zzd() != null) {
        Map map = (Map)zzap.zza(this.zza.zzd()).getClaims().get("firebase");
        str2 = str1;
        if (map != null)
          str2 = (String)map.get("tenant"); 
      } 
    } 
    return str2;
  }
  
  public final zzff zze() {
    return this.zza;
  }
  
  public final String zzf() {
    return this.zza.zzh();
  }
  
  public final String zzg() {
    return super.zze().zzd();
  }
  
  public final List<zzj> zzi() {
    return this.zze;
  }
  
  public final boolean zzj() {
    return this.zzj;
  }
  
  public final zzg zzk() {
    return this.zzk;
  }
  
  public final List<zzy> zzl() {
    zzaq zzaq1 = this.zzl;
    return (List<zzy>)((zzaq1 != null) ? zzaq1.zza() : zzbg.zza());
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */