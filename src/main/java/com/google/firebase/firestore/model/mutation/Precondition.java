package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

public final class Precondition {
  public static final Precondition NONE = new Precondition(null, null);
  
  private final Boolean exists;
  
  private final SnapshotVersion updateTime;
  
  private Precondition(SnapshotVersion paramSnapshotVersion, Boolean paramBoolean) {
    boolean bool;
    if (paramSnapshotVersion == null || paramBoolean == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
    this.updateTime = paramSnapshotVersion;
    this.exists = paramBoolean;
  }
  
  public static Precondition exists(boolean paramBoolean) {
    return new Precondition(null, Boolean.valueOf(paramBoolean));
  }
  
  public static Precondition updateTime(SnapshotVersion paramSnapshotVersion) {
    return new Precondition(paramSnapshotVersion, null);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    SnapshotVersion snapshotVersion = this.updateTime;
    if ((snapshotVersion != null) ? !snapshotVersion.equals(((Precondition)paramObject).updateTime) : (((Precondition)paramObject).updateTime != null))
      return false; 
    Boolean bool1 = this.exists;
    paramObject = ((Precondition)paramObject).exists;
    if (bool1 != null) {
      bool = bool1.equals(paramObject);
    } else if (paramObject != null) {
      bool = false;
    } 
    return bool;
  }
  
  public Boolean getExists() {
    return this.exists;
  }
  
  public SnapshotVersion getUpdateTime() {
    return this.updateTime;
  }
  
  public int hashCode() {
    byte b;
    SnapshotVersion snapshotVersion = this.updateTime;
    int i = 0;
    if (snapshotVersion != null) {
      b = snapshotVersion.hashCode();
    } else {
      b = 0;
    } 
    Boolean bool = this.exists;
    if (bool != null)
      i = bool.hashCode(); 
    return b * 31 + i;
  }
  
  public boolean isNone() {
    boolean bool;
    if (this.updateTime == null && this.exists == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isValidFor(MaybeDocument paramMaybeDocument) {
    SnapshotVersion snapshotVersion = this.updateTime;
    boolean bool1 = true;
    boolean bool2 = true;
    if (snapshotVersion != null) {
      if (!(paramMaybeDocument instanceof com.google.firebase.firestore.model.Document) || !paramMaybeDocument.getVersion().equals(this.updateTime))
        bool2 = false; 
      return bool2;
    } 
    Boolean bool = this.exists;
    if (bool != null) {
      if (bool.booleanValue() == paramMaybeDocument instanceof com.google.firebase.firestore.model.Document) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      return bool2;
    } 
    Assert.hardAssert(isNone(), "Precondition should be empty", new Object[0]);
    return true;
  }
  
  public String toString() {
    if (isNone())
      return "Precondition{<none>}"; 
    if (this.updateTime != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Precondition{updateTime=");
      stringBuilder.append(this.updateTime);
      stringBuilder.append("}");
      return stringBuilder.toString();
    } 
    if (this.exists != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Precondition{exists=");
      stringBuilder.append(this.exists);
      stringBuilder.append("}");
      return stringBuilder.toString();
    } 
    throw Assert.fail("Invalid Precondition", new Object[0]);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\mutation\Precondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */