package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Preconditions;
import java.util.Date;

public final class Timestamp implements Comparable<Timestamp>, Parcelable {
  public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() {
      public Timestamp createFromParcel(Parcel param1Parcel) {
        return new Timestamp(param1Parcel);
      }
      
      public Timestamp[] newArray(int param1Int) {
        return new Timestamp[param1Int];
      }
    };
  
  private final int nanoseconds;
  
  private final long seconds;
  
  public Timestamp(long paramLong, int paramInt) {
    validateRange(paramLong, paramInt);
    this.seconds = paramLong;
    this.nanoseconds = paramInt;
  }
  
  protected Timestamp(Parcel paramParcel) {
    this.seconds = paramParcel.readLong();
    this.nanoseconds = paramParcel.readInt();
  }
  
  public Timestamp(Date paramDate) {
    long l1 = paramDate.getTime();
    long l2 = l1 / 1000L;
    int i = (int)(l1 % 1000L) * 1000000;
    l1 = l2;
    int j = i;
    if (i < 0) {
      l1 = l2 - 1L;
      j = i + 1000000000;
    } 
    validateRange(l1, j);
    this.seconds = l1;
    this.nanoseconds = j;
  }
  
  public static Timestamp now() {
    return new Timestamp(new Date());
  }
  
  private static void validateRange(long paramLong, int paramInt) {
    boolean bool2;
    boolean bool1 = true;
    if (paramInt >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Timestamp nanoseconds out of range: %s", paramInt);
    if (paramInt < 1.0E9D) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Timestamp nanoseconds out of range: %s", paramInt);
    if (paramLong >= -62135596800L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Timestamp seconds out of range: %s", paramLong);
    if (paramLong < 253402300800L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Timestamp seconds out of range: %s", paramLong);
  }
  
  public int compareTo(Timestamp paramTimestamp) {
    long l1 = this.seconds;
    long l2 = paramTimestamp.seconds;
    return (l1 == l2) ? Integer.signum(this.nanoseconds - paramTimestamp.nanoseconds) : Long.signum(l1 - l2);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Timestamp))
      return false; 
    if (compareTo((Timestamp)paramObject) != 0)
      bool = false; 
    return bool;
  }
  
  public int getNanoseconds() {
    return this.nanoseconds;
  }
  
  public long getSeconds() {
    return this.seconds;
  }
  
  public int hashCode() {
    long l = this.seconds;
    return ((int)l * 37 * 37 + (int)(l >> 32L)) * 37 + this.nanoseconds;
  }
  
  public Date toDate() {
    return new Date(this.seconds * 1000L + (this.nanoseconds / 1000000));
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timestamp(seconds=");
    stringBuilder.append(this.seconds);
    stringBuilder.append(", nanoseconds=");
    stringBuilder.append(this.nanoseconds);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.seconds);
    paramParcel.writeInt(this.nanoseconds);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\Timestamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */