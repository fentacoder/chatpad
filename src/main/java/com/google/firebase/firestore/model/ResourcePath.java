package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ResourcePath extends BasePath<ResourcePath> {
  public static final ResourcePath EMPTY = new ResourcePath(Collections.emptyList());
  
  private ResourcePath(List<String> paramList) {
    super(paramList);
  }
  
  public static ResourcePath fromSegments(List<String> paramList) {
    ResourcePath resourcePath;
    if (paramList.isEmpty()) {
      resourcePath = EMPTY;
    } else {
      resourcePath = new ResourcePath((List<String>)resourcePath);
    } 
    return resourcePath;
  }
  
  public static ResourcePath fromString(String paramString) {
    String[] arrayOfString;
    if (!paramString.contains("//")) {
      arrayOfString = paramString.split("/");
      ArrayList<String> arrayList = new ArrayList(arrayOfString.length);
      int i = arrayOfString.length;
      for (byte b = 0; b < i; b++) {
        String str = arrayOfString[b];
        if (!str.isEmpty())
          arrayList.add(str); 
      } 
      return new ResourcePath(arrayList);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid path (");
    stringBuilder.append((String)arrayOfString);
    stringBuilder.append("). Paths must not contain // in them.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public String canonicalString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < this.segments.size(); b++) {
      if (b > 0)
        stringBuilder.append("/"); 
      stringBuilder.append(this.segments.get(b));
    } 
    return stringBuilder.toString();
  }
  
  ResourcePath createPathWithSegments(List<String> paramList) {
    return new ResourcePath(paramList);
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\model\ResourcePath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */