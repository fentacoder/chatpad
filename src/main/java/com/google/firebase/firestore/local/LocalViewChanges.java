package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.ArrayList;

public final class LocalViewChanges {
  private final ImmutableSortedSet<DocumentKey> added;
  
  private final boolean fromCache;
  
  private final ImmutableSortedSet<DocumentKey> removed;
  
  private final int targetId;
  
  public LocalViewChanges(int paramInt, boolean paramBoolean, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet1, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet2) {
    this.targetId = paramInt;
    this.fromCache = paramBoolean;
    this.added = paramImmutableSortedSet1;
    this.removed = paramImmutableSortedSet2;
  }
  
  public static LocalViewChanges fromViewSnapshot(int paramInt, ViewSnapshot paramViewSnapshot) {
    ImmutableSortedSet<DocumentKey> immutableSortedSet1 = new ImmutableSortedSet(new ArrayList(), DocumentKey.comparator());
    ImmutableSortedSet<DocumentKey> immutableSortedSet2 = new ImmutableSortedSet(new ArrayList(), DocumentKey.comparator());
    for (DocumentViewChange documentViewChange : paramViewSnapshot.getChanges()) {
      int i = null.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
      if (i != 1) {
        if (i != 2)
          continue; 
        immutableSortedSet2 = immutableSortedSet2.insert(documentViewChange.getDocument().getKey());
        continue;
      } 
      immutableSortedSet1 = immutableSortedSet1.insert(documentViewChange.getDocument().getKey());
    } 
    return new LocalViewChanges(paramInt, paramViewSnapshot.isFromCache(), immutableSortedSet1, immutableSortedSet2);
  }
  
  public ImmutableSortedSet<DocumentKey> getAdded() {
    return this.added;
  }
  
  public ImmutableSortedSet<DocumentKey> getRemoved() {
    return this.removed;
  }
  
  public int getTargetId() {
    return this.targetId;
  }
  
  public boolean isFromCache() {
    return this.fromCache;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LocalViewChanges.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */