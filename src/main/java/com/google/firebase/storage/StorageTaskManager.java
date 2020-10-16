package com.google.firebase.storage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StorageTaskManager {
  private static final StorageTaskManager _instance = new StorageTaskManager();
  
  private final Map<String, WeakReference<StorageTask<?>>> inProgressTasks = new HashMap<>();
  
  private final Object syncObject = new Object();
  
  static StorageTaskManager getInstance() {
    return _instance;
  }
  
  public void ensureRegistered(StorageTask<?> paramStorageTask) {
    synchronized (this.syncObject) {
      Map<String, WeakReference<StorageTask<?>>> map = this.inProgressTasks;
      String str = paramStorageTask.getStorage().toString();
      WeakReference<StorageTask<?>> weakReference = new WeakReference();
      this((T)paramStorageTask);
      map.put(str, weakReference);
      return;
    } 
  }
  
  public List<FileDownloadTask> getDownloadTasksUnder(StorageReference paramStorageReference) {
    synchronized (this.syncObject) {
      ArrayList<FileDownloadTask> arrayList = new ArrayList();
      this();
      String str = paramStorageReference.toString();
      for (Map.Entry<String, WeakReference<StorageTask<?>>> entry : this.inProgressTasks.entrySet()) {
        if (((String)entry.getKey()).startsWith(str)) {
          StorageTask storageTask = ((WeakReference<StorageTask>)entry.getValue()).get();
          if (storageTask instanceof FileDownloadTask)
            arrayList.add((FileDownloadTask)storageTask); 
        } 
      } 
      return Collections.unmodifiableList(arrayList);
    } 
  }
  
  public List<UploadTask> getUploadTasksUnder(StorageReference paramStorageReference) {
    synchronized (this.syncObject) {
      ArrayList<UploadTask> arrayList = new ArrayList();
      this();
      String str = paramStorageReference.toString();
      for (Map.Entry<String, WeakReference<StorageTask<?>>> entry : this.inProgressTasks.entrySet()) {
        if (((String)entry.getKey()).startsWith(str)) {
          StorageTask storageTask = ((WeakReference<StorageTask>)entry.getValue()).get();
          if (storageTask instanceof UploadTask)
            arrayList.add((UploadTask)storageTask); 
        } 
      } 
      return Collections.unmodifiableList(arrayList);
    } 
  }
  
  public void unRegister(StorageTask<?> paramStorageTask) {
    synchronized (this.syncObject) {
      String str = paramStorageTask.getStorage().toString();
      WeakReference<StorageTask> weakReference = (WeakReference)this.inProgressTasks.get(str);
      if (weakReference != null) {
        StorageTask storageTask = weakReference.get();
      } else {
        weakReference = null;
      } 
      if (weakReference == null || weakReference == paramStorageTask)
        this.inProgressTasks.remove(str); 
      return;
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\storage\StorageTaskManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */