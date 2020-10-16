package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.GeoPoint;

public class GeoPointValue extends FieldValue {
  private final GeoPoint internalValue;
  
  private GeoPointValue(GeoPoint paramGeoPoint) {
    this.internalValue = paramGeoPoint;
  }
  
  public static GeoPointValue valueOf(GeoPoint paramGeoPoint) {
    return new GeoPointValue(paramGeoPoint);
  }
  
  public int compareTo(FieldValue paramFieldValue) {
    return (paramFieldValue instanceof GeoPointValue) ? this.internalValue.compareTo(((GeoPointValue)paramFieldValue).internalValue) : defaultCompareTo(paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof GeoPointValue && this.internalValue.equals(((GeoPointValue)paramObject).internalValue)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public int hashCode() {
    return this.internalValue.hashCode();
  }
  
  public int typeOrder() {
    return 7;
  }
  
  public GeoPoint value() {
    return this.internalValue;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\value\GeoPointValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */