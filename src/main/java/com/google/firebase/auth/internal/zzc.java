package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;
import com.google.firebase.auth.zzg;

public final class zzc {
  public static zzfy zza(AuthCredential paramAuthCredential, String paramString) {
    Preconditions.checkNotNull(paramAuthCredential);
    if (GoogleAuthCredential.class.isAssignableFrom(paramAuthCredential.getClass()))
      return GoogleAuthCredential.zza((GoogleAuthCredential)paramAuthCredential, paramString); 
    if (FacebookAuthCredential.class.isAssignableFrom(paramAuthCredential.getClass()))
      return FacebookAuthCredential.zza((FacebookAuthCredential)paramAuthCredential, paramString); 
    if (TwitterAuthCredential.class.isAssignableFrom(paramAuthCredential.getClass()))
      return TwitterAuthCredential.zza((TwitterAuthCredential)paramAuthCredential, paramString); 
    if (GithubAuthCredential.class.isAssignableFrom(paramAuthCredential.getClass()))
      return GithubAuthCredential.zza((GithubAuthCredential)paramAuthCredential, paramString); 
    if (PlayGamesAuthCredential.class.isAssignableFrom(paramAuthCredential.getClass()))
      return PlayGamesAuthCredential.zza((PlayGamesAuthCredential)paramAuthCredential, paramString); 
    if (zzg.class.isAssignableFrom(paramAuthCredential.getClass()))
      return zzg.zza((zzg)paramAuthCredential, paramString); 
    throw new IllegalArgumentException("Unsupported credential type.");
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */