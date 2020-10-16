package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzp implements FirebaseUserMetadata {
  public static final Parcelable.Creator<zzp> CREATOR = new zzs();
  
  private long zza;
  
  private long zzb;
  
  public zzp(long paramLong1, long paramLong2) {
    this.zza = paramLong1;
    this.zzb = paramLong2;
  }
  
  public static zzp zza(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    try {
      return new zzp(paramJSONObject.getLong("lastSignInTimestamp"), paramJSONObject.getLong("creationTimestamp"));
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final long getCreationTimestamp() {
    return this.zzb;
  }
  
  public final long getLastSignInTimestamp() {
    return this.zza;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, getLastSignInTimestamp());
    SafeParcelWriter.writeLong(paramParcel, 2, getCreationTimestamp());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final JSONObject zza() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("lastSignInTimestamp", this.zza);
      jSONObject.put("creationTimestamp", this.zzb);
    } catch (JSONException jSONException) {}
    return jSONObject;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\auth\internal\zzp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */