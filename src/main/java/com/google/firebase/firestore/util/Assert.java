package com.google.firebase.firestore.util;

public class Assert {
  public static AssertionError fail(String paramString, Object... paramVarArgs) {
    throw new AssertionError(format(paramString, paramVarArgs));
  }
  
  public static AssertionError fail(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
    throw ApiUtil.newAssertionError(format(paramString, paramVarArgs), paramThrowable);
  }
  
  private static String format(String paramString, Object... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("INTERNAL ASSERTION FAILED: ");
    stringBuilder.append(String.format(paramString, paramVarArgs));
    return stringBuilder.toString();
  }
  
  public static void hardAssert(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw fail(paramString, paramVarArgs);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\Assert.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */