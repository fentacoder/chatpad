package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class MemoryIndexManager implements IndexManager {
  private final MemoryCollectionParentIndex collectionParentsIndex = new MemoryCollectionParentIndex();
  
  public void addToCollectionParentIndex(ResourcePath paramResourcePath) {
    this.collectionParentsIndex.add(paramResourcePath);
  }
  
  public List<ResourcePath> getCollectionParents(String paramString) {
    return this.collectionParentsIndex.getEntries(paramString);
  }
  
  static class MemoryCollectionParentIndex {
    private final HashMap<String, HashSet<ResourcePath>> index = new HashMap<>();
    
    boolean add(ResourcePath param1ResourcePath) {
      int i = param1ResourcePath.length();
      boolean bool = true;
      if (i % 2 != 1)
        bool = false; 
      Assert.hardAssert(bool, "Expected a collection path.", new Object[0]);
      String str = param1ResourcePath.getLastSegment();
      ResourcePath resourcePath = (ResourcePath)param1ResourcePath.popLast();
      HashSet<ResourcePath> hashSet2 = this.index.get(str);
      HashSet<ResourcePath> hashSet1 = hashSet2;
      if (hashSet2 == null) {
        hashSet1 = new HashSet();
        this.index.put(str, hashSet1);
      } 
      return hashSet1.add(resourcePath);
    }
    
    List<ResourcePath> getEntries(String param1String) {
      List<?> list;
      HashSet<?> hashSet = this.index.get(param1String);
      if (hashSet != null) {
        list = new ArrayList(hashSet);
      } else {
        list = Collections.emptyList();
      } 
      return (List)list;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\MemoryIndexManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */