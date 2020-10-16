package com.google.firebase.firestore.core;

import android.app.Activity;
import android.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

public class ActivityScope {
  private static final String FRAGMENT_TAG = "FirestoreOnStopObserverFragment";
  
  private static final String SUPPORT_FRAGMENT_TAG = "FirestoreOnStopObserverSupportFragment";
  
  public static ListenerRegistration bind(Activity paramActivity, ListenerRegistration paramListenerRegistration) {
    if (paramActivity != null) {
      FragmentActivity fragmentActivity;
      if (paramActivity instanceof FragmentActivity) {
        fragmentActivity = (FragmentActivity)paramActivity;
        paramListenerRegistration.getClass();
        onFragmentActivityStopCallOnce(fragmentActivity, ActivityScope$$Lambda$3.lambdaFactory$(paramListenerRegistration));
      } else {
        paramListenerRegistration.getClass();
        onActivityStopCallOnce((Activity)fragmentActivity, ActivityScope$$Lambda$4.lambdaFactory$(paramListenerRegistration));
      } 
    } 
    return paramListenerRegistration;
  }
  
  private static <T> T castFragment(Class<T> paramClass, Object paramObject, String paramString) {
    if (paramObject == null)
      return null; 
    try {
      return paramClass.cast(paramObject);
    } catch (ClassCastException classCastException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment with tag '");
      stringBuilder.append(paramString);
      stringBuilder.append("' is a ");
      stringBuilder.append(paramObject.getClass().getName());
      stringBuilder.append(" but should be a ");
      stringBuilder.append(paramClass.getName());
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private static void onActivityStopCallOnce(Activity paramActivity, Runnable paramRunnable) {
    Assert.hardAssert(paramActivity instanceof FragmentActivity ^ true, "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
    paramActivity.runOnUiThread(ActivityScope$$Lambda$1.lambdaFactory$(paramActivity, paramRunnable));
  }
  
  private static void onFragmentActivityStopCallOnce(FragmentActivity paramFragmentActivity, Runnable paramRunnable) {
    paramFragmentActivity.runOnUiThread(ActivityScope$$Lambda$2.lambdaFactory$(paramFragmentActivity, paramRunnable));
  }
  
  private static class CallbackList {
    private final List<Runnable> callbacks = new ArrayList<>();
    
    private CallbackList() {}
    
    void add(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield callbacks : Ljava/util/List;
      //   6: aload_1
      //   7: invokeinterface add : (Ljava/lang/Object;)Z
      //   12: pop
      //   13: aload_0
      //   14: monitorexit
      //   15: return
      //   16: astore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_1
      //   20: athrow
      // Exception table:
      //   from	to	target	type
      //   2	13	16	finally
    }
    
    void run() {
      for (Runnable runnable : this.callbacks) {
        if (runnable != null)
          runnable.run(); 
      } 
    }
  }
  
  public static class StopListenerFragment extends Fragment {
    ActivityScope.CallbackList callbacks = new ActivityScope.CallbackList();
    
    public void onStop() {
      super.onStop();
      synchronized (this.callbacks) {
        ActivityScope.CallbackList callbackList1 = this.callbacks;
        ActivityScope.CallbackList callbackList2 = new ActivityScope.CallbackList();
        this();
        this.callbacks = callbackList2;
        callbackList1.run();
        return;
      } 
    }
  }
  
  public static class StopListenerSupportFragment extends Fragment {
    ActivityScope.CallbackList callbacks = new ActivityScope.CallbackList();
    
    public void onStop() {
      super.onStop();
      synchronized (this.callbacks) {
        ActivityScope.CallbackList callbackList1 = this.callbacks;
        ActivityScope.CallbackList callbackList2 = new ActivityScope.CallbackList();
        this();
        this.callbacks = callbackList2;
        callbackList1.run();
        return;
      } 
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\ActivityScope.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */