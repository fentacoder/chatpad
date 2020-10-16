package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.api.zza;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaf extends zzy {
  public static final Parcelable.Creator<zzaf> CREATOR = new zzae();
  
  private final String zza;
  
  @Nullable
  private final String zzb;
  
  private final long zzc;
  
  private final String zzd;
  
  public zzaf(String paramString1, @Nullable String paramString2, long paramLong, String paramString3) {
    this.zza = Preconditions.checkNotEmpty(paramString1);
    this.zzb = paramString2;
    this.zzc = paramLong;
    this.zzd = Preconditions.checkNotEmpty(paramString3);
  }
  
  public static zzaf zza(JSONObject paramJSONObject) {
    if (paramJSONObject.has("enrollmentTimestamp"))
      return new zzaf(paramJSONObject.optString("uid"), paramJSONObject.optString("displayName"), paramJSONObject.optLong("enrollmentTimestamp"), paramJSONObject.optString("phoneNumber")); 
    throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  @Nullable
  public final JSONObject zza() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("factorIdKey", "phone");
      jSONObject.putOpt("uid", this.zza);
      jSONObject.putOpt("displayName", this.zzb);
      jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
      jSONObject.putOpt("phoneNumber", this.zzd);
      return jSONObject;
    } catch (JSONException jSONException) {
      Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
      throw new zza(jSONException);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\zzaf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */