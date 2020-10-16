package com.google.firebase.firestore.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApiUtil {
  static Object invoke(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } 
  }
  
  public static AssertionError newAssertionError(String paramString, Throwable paramThrowable) {
    AssertionError assertionError = new AssertionError(paramString);
    assertionError.initCause(paramThrowable);
    return assertionError;
  }
  
  static <T> T newInstance(Constructor<T> paramConstructor) {
    try {
      return paramConstructor.newInstance(new Object[0]);
    } catch (InstantiationException instantiationException) {
      throw new RuntimeException(instantiationException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\ApiUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */