package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.cloud.datastore.core.number.NumberComparisonHelper;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Util {
  private static final String AUTO_ID_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
  private static final int AUTO_ID_LENGTH = 20;
  
  private static final Comparator COMPARABLE_COMPARATOR;
  
  private static final Continuation<Void, Void> VOID_ERROR_TRANSFORMER;
  
  private static final Random rand = new Random();
  
  static {
    COMPARABLE_COMPARATOR = new Comparator<Comparable<?>>() {
        public int compare(Comparable<Comparable> param1Comparable1, Comparable param1Comparable2) {
          return param1Comparable1.compareTo(param1Comparable2);
        }
      };
    VOID_ERROR_TRANSFORMER = Util$$Lambda$2.lambdaFactory$();
  }
  
  public static String autoId() {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < 20; b++)
      stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(rand.nextInt(62))); 
    return stringBuilder.toString();
  }
  
  public static List<Object> collectUpdateArguments(int paramInt, Object paramObject1, Object paramObject2, Object... paramVarArgs) {
    if (paramVarArgs.length % 2 != 1) {
      ArrayList<Object> arrayList = new ArrayList();
      arrayList.add(paramObject1);
      arrayList.add(paramObject2);
      Collections.addAll(arrayList, paramVarArgs);
      byte b = 0;
      while (b < arrayList.size()) {
        paramObject1 = arrayList.get(b);
        if (paramObject1 instanceof String || paramObject1 instanceof com.google.firebase.firestore.FieldPath) {
          b += 2;
          continue;
        } 
        paramObject2 = new StringBuilder();
        paramObject2.append("Excepted field name at argument position ");
        paramObject2.append(b + paramInt + 1);
        paramObject2.append(" but got ");
        paramObject2.append(paramObject1);
        paramObject2.append(" in call to update.  The arguments to update should alternate between field names and values");
        throw new IllegalArgumentException(paramObject2.toString());
      } 
      return arrayList;
    } 
    throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
  }
  
  public static <T extends Comparable<T>> Comparator<T> comparator() {
    return COMPARABLE_COMPARATOR;
  }
  
  public static int compareBooleans(boolean paramBoolean1, boolean paramBoolean2) {
    return (paramBoolean1 == paramBoolean2) ? 0 : (paramBoolean1 ? 1 : -1);
  }
  
  public static int compareDoubles(double paramDouble1, double paramDouble2) {
    return NumberComparisonHelper.firestoreCompareDoubles(paramDouble1, paramDouble2);
  }
  
  public static int compareIntegers(int paramInt1, int paramInt2) {
    return (paramInt1 < paramInt2) ? -1 : ((paramInt1 > paramInt2) ? 1 : 0);
  }
  
  public static int compareInts(int paramInt1, int paramInt2) {
    return NumberComparisonHelper.compareLongs(paramInt1, paramInt2);
  }
  
  public static int compareLongs(long paramLong1, long paramLong2) {
    return NumberComparisonHelper.compareLongs(paramLong1, paramLong2);
  }
  
  public static int compareMixed(double paramDouble, long paramLong) {
    return NumberComparisonHelper.firestoreCompareDoubleWithLong(paramDouble, paramLong);
  }
  
  private static Exception convertStatusException(Exception paramException) {
    FirebaseFirestoreException firebaseFirestoreException;
    if (paramException instanceof StatusException)
      return (Exception)exceptionFromStatus(((StatusException)paramException).getStatus()); 
    Exception exception = paramException;
    if (paramException instanceof StatusRuntimeException)
      firebaseFirestoreException = exceptionFromStatus(((StatusRuntimeException)paramException).getStatus()); 
    return (Exception)firebaseFirestoreException;
  }
  
  public static Exception convertThrowableToException(Throwable paramThrowable) {
    return (paramThrowable instanceof Exception) ? convertStatusException((Exception)paramThrowable) : new Exception(paramThrowable);
  }
  
  public static void crashMainThread(RuntimeException paramRuntimeException) {
    (new Handler(Looper.getMainLooper())).post(Util$$Lambda$1.lambdaFactory$(paramRuntimeException));
  }
  
  public static FirebaseFirestoreException exceptionFromStatus(Status paramStatus) {
    StatusException statusException = paramStatus.asException();
    return new FirebaseFirestoreException(statusException.getMessage(), FirebaseFirestoreException.Code.fromValue(paramStatus.getCode().value()), (Throwable)statusException);
  }
  
  public static String toDebugString(ByteString paramByteString) {
    int i = paramByteString.size();
    StringBuilder stringBuilder = new StringBuilder(i * 2);
    for (byte b = 0; b < i; b++) {
      int j = paramByteString.byteAt(b) & 0xFF;
      stringBuilder.append(Character.forDigit(j >>> 4, 16));
      stringBuilder.append(Character.forDigit(j & 0xF, 16));
    } 
    return stringBuilder.toString();
  }
  
  public static String typeName(Object paramObject) {
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.getClass().getName();
    } 
    return (String)paramObject;
  }
  
  public static Continuation<Void, Void> voidErrorTransformer() {
    return VOID_ERROR_TRANSFORMER;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */