package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Util;

public class GeoPoint implements Comparable<GeoPoint> {
  private final double latitude;
  
  private final double longitude;
  
  public GeoPoint(double paramDouble1, double paramDouble2) {
    if (!Double.isNaN(paramDouble1) && paramDouble1 >= -90.0D && paramDouble1 <= 90.0D) {
      if (!Double.isNaN(paramDouble2) && paramDouble2 >= -180.0D && paramDouble2 <= 180.0D) {
        this.latitude = paramDouble1;
        this.longitude = paramDouble2;
        return;
      } 
      throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
    } 
    throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
  }
  
  public int compareTo(GeoPoint paramGeoPoint) {
    int i = Util.compareDoubles(this.latitude, paramGeoPoint.latitude);
    return (i == 0) ? Util.compareDoubles(this.longitude, paramGeoPoint.longitude) : i;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof GeoPoint;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.latitude == ((GeoPoint)paramObject).latitude) {
      bool = bool1;
      if (this.longitude == ((GeoPoint)paramObject).longitude)
        bool = true; 
    } 
    return bool;
  }
  
  public double getLatitude() {
    return this.latitude;
  }
  
  public double getLongitude() {
    return this.longitude;
  }
  
  public int hashCode() {
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.longitude);
    return i * 31 + (int)(l >>> 32L ^ l);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GeoPoint { latitude=");
    stringBuilder.append(this.latitude);
    stringBuilder.append(", longitude=");
    stringBuilder.append(this.longitude);
    stringBuilder.append(" }");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\GeoPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */