package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.ResourcePath;
import java.util.List;

public interface IndexManager {
  void addToCollectionParentIndex(ResourcePath paramResourcePath);
  
  List<ResourcePath> getCollectionParents(String paramString);
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\IndexManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */