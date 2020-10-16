package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FieldPath extends BasePath<FieldPath> {
  public static final FieldPath EMPTY_PATH;
  
  public static final FieldPath KEY_PATH = fromSingleSegment("__name__");
  
  static {
    EMPTY_PATH = new FieldPath(Collections.emptyList());
  }
  
  private FieldPath(List<String> paramList) {
    super(paramList);
  }
  
  public static FieldPath fromSegments(List<String> paramList) {
    FieldPath fieldPath;
    if (paramList.isEmpty()) {
      fieldPath = EMPTY_PATH;
    } else {
      fieldPath = new FieldPath((List<String>)fieldPath);
    } 
    return fieldPath;
  }
  
  public static FieldPath fromServerFormat(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    StringBuilder stringBuilder2 = new StringBuilder();
    byte b = 0;
    int i = 0;
    while (b < paramString.length()) {
      char c = paramString.charAt(b);
      if (c == '\\') {
        if (++b != paramString.length()) {
          stringBuilder2.append(paramString.charAt(b));
        } else {
          throw new IllegalArgumentException("Trailing escape character is not allowed");
        } 
      } else if (c == '.') {
        if (!i) {
          String str1 = stringBuilder2.toString();
          if (!str1.isEmpty()) {
            stringBuilder2 = new StringBuilder();
            arrayList.add(str1);
          } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid field path (");
            stringBuilder2.append(paramString);
            stringBuilder2.append("). Paths must not be empty, begin with '.', end with '.', or contain '..'");
            throw new IllegalArgumentException(stringBuilder2.toString());
          } 
        } else {
          stringBuilder2.append(c);
        } 
      } else if (c == '`') {
        i ^= 0x1;
      } else {
        stringBuilder2.append(c);
      } 
      b++;
    } 
    String str = stringBuilder2.toString();
    if (!str.isEmpty()) {
      arrayList.add(str);
      return new FieldPath(arrayList);
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Invalid field path (");
    stringBuilder1.append(paramString);
    stringBuilder1.append("). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    throw new IllegalArgumentException(stringBuilder1.toString());
  }
  
  public static FieldPath fromSingleSegment(String paramString) {
    return new FieldPath(Collections.singletonList(paramString));
  }
  
  private static boolean isValidIdentifier(String paramString) {
    if (paramString.isEmpty())
      return false; 
    char c = paramString.charAt(0);
    if (c != '_' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
      return false; 
    for (c = '\001'; c < paramString.length(); c++) {
      char c1 = paramString.charAt(c);
      if (c1 != '_' && (c1 < 'a' || c1 > 'z') && (c1 < 'A' || c1 > 'Z') && (c1 < '0' || c1 > '9'))
        return false; 
    } 
    return true;
  }
  
  public String canonicalString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < this.segments.size(); b++) {
      if (b > 0)
        stringBuilder.append("."); 
      String str1 = ((String)this.segments.get(b)).replace("\\", "\\\\").replace("`", "\\`");
      String str2 = str1;
      if (!isValidIdentifier(str1)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append('`');
        stringBuilder1.append(str1);
        stringBuilder1.append('`');
        str2 = stringBuilder1.toString();
      } 
      stringBuilder.append(str2);
    } 
    return stringBuilder.toString();
  }
  
  FieldPath createPathWithSegments(List<String> paramList) {
    return new FieldPath(paramList);
  }
  
  public boolean isKeyField() {
    return equals(KEY_PATH);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\FieldPath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */