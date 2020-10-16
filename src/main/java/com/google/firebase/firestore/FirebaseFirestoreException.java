package com.google.firebase.firestore;

import android.util.SparseArray;
import com.google.common.base.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.firestore.util.Assert;

public class FirebaseFirestoreException extends FirebaseException {
  private final Code code;
  
  public FirebaseFirestoreException(String paramString, Code paramCode) {
    super(paramString);
    boolean bool;
    Preconditions.checkNotNull(paramString, "Provided message must not be null.");
    if (paramCode != Code.OK) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
    this.code = (Code)Preconditions.checkNotNull(paramCode, "Provided code must not be null.");
  }
  
  public FirebaseFirestoreException(String paramString, Code paramCode, Throwable paramThrowable) {
    super(paramString, paramThrowable);
    boolean bool;
    Preconditions.checkNotNull(paramString, "Provided message must not be null.");
    if (paramCode != Code.OK) {
      bool = true;
    } else {
      bool = false;
    } 
    Assert.hardAssert(bool, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
    this.code = (Code)Preconditions.checkNotNull(paramCode, "Provided code must not be null.");
  }
  
  public Code getCode() {
    return this.code;
  }
  
  public enum Code {
    ABORTED,
    ALREADY_EXISTS,
    CANCELLED,
    DATA_LOSS,
    DEADLINE_EXCEEDED,
    FAILED_PRECONDITION,
    INTERNAL,
    INVALID_ARGUMENT,
    NOT_FOUND,
    OK(0),
    OUT_OF_RANGE(0),
    PERMISSION_DENIED(0),
    RESOURCE_EXHAUSTED(0),
    UNAUTHENTICATED(0),
    UNAVAILABLE(0),
    UNIMPLEMENTED(0),
    UNKNOWN(0);
    
    private static final SparseArray<Code> STATUS_LIST;
    
    private final int value;
    
    static {
      INVALID_ARGUMENT = new Code("INVALID_ARGUMENT", 3, 3);
      DEADLINE_EXCEEDED = new Code("DEADLINE_EXCEEDED", 4, 4);
      NOT_FOUND = new Code("NOT_FOUND", 5, 5);
      ALREADY_EXISTS = new Code("ALREADY_EXISTS", 6, 6);
      PERMISSION_DENIED = new Code("PERMISSION_DENIED", 7, 7);
      RESOURCE_EXHAUSTED = new Code("RESOURCE_EXHAUSTED", 8, 8);
      FAILED_PRECONDITION = new Code("FAILED_PRECONDITION", 9, 9);
      ABORTED = new Code("ABORTED", 10, 10);
      OUT_OF_RANGE = new Code("OUT_OF_RANGE", 11, 11);
      UNIMPLEMENTED = new Code("UNIMPLEMENTED", 12, 12);
      INTERNAL = new Code("INTERNAL", 13, 13);
      UNAVAILABLE = new Code("UNAVAILABLE", 14, 14);
      DATA_LOSS = new Code("DATA_LOSS", 15, 15);
      UNAUTHENTICATED = new Code("UNAUTHENTICATED", 16, 16);
      $VALUES = new Code[] { 
          OK, CANCELLED, UNKNOWN, INVALID_ARGUMENT, DEADLINE_EXCEEDED, NOT_FOUND, ALREADY_EXISTS, PERMISSION_DENIED, RESOURCE_EXHAUSTED, FAILED_PRECONDITION, 
          ABORTED, OUT_OF_RANGE, UNIMPLEMENTED, INTERNAL, UNAVAILABLE, DATA_LOSS, UNAUTHENTICATED };
      STATUS_LIST = buildStatusList();
    }
    
    Code(int param1Int1) {
      this.value = param1Int1;
    }
    
    private static SparseArray<Code> buildStatusList() {
      SparseArray<Code> sparseArray = new SparseArray();
      Code[] arrayOfCode = values();
      int i = arrayOfCode.length;
      byte b = 0;
      while (b < i) {
        Code code1 = arrayOfCode[b];
        Code code2 = (Code)sparseArray.get(code1.value());
        if (code2 == null) {
          sparseArray.put(code1.value(), code1);
          b++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code value duplication between ");
        stringBuilder.append(code2);
        stringBuilder.append("&");
        stringBuilder.append(code1.name());
        throw new IllegalStateException(stringBuilder.toString());
      } 
      return sparseArray;
    }
    
    public static Code fromValue(int param1Int) {
      return (Code)STATUS_LIST.get(param1Int, UNKNOWN);
    }
    
    public int value() {
      return this.value;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\FirebaseFirestoreException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */