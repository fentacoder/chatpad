package com.infotechnano.audionect;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class signUpProcessService extends Service {
  private SharedPreferences sharedPreferences;
  
  private StorageReference storageReference;
  
  private void clearLeftUri(String paramString) {
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    if (!paramString.equals(""))
      firebaseStorage.getReference("UserPics").child("LeftPics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.i("replacePicture", "picture was deleted successfully");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {
              Log.i("replacePicture", "picture was not deleted successfully");
            }
          }); 
  }
  
  private void clearMiddleUri(String paramString) {
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    if (!paramString.equals(""))
      firebaseStorage.getReference("UserPics").child("MiddlePics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.i("replacePicture", "picture was deleted successfully");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {
              Log.i("replacePicture", "picture was not deleted successfully");
            }
          }); 
  }
  
  private void clearRightUri(String paramString) {
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    if (!paramString.equals(""))
      firebaseStorage.getReference("UserPics").child("RightPics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.i("replacePicture", "picture was deleted successfully");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {
              Log.i("replacePicture", "picture was not deleted successfully");
            }
          }); 
  }
  
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void onTaskRemoved(Intent paramIntent) {
    super.onTaskRemoved(paramIntent);
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    this.storageReference = FirebaseStorage.getInstance().getReference();
    if (!this.sharedPreferences.getString("login", "false").equals("true")) {
      clearLeftUri(this.sharedPreferences.getString("leftPicTitle", ""));
      clearMiddleUri(this.sharedPreferences.getString("middlePicTitle", ""));
      clearRightUri(this.sharedPreferences.getString("rightPicTitle", ""));
      firebaseFirestore.collection("Users").document(this.sharedPreferences.getString("currentUser", "")).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.d("deleteUser", "successful");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {}
          });
      this.sharedPreferences.edit().putString("currentUser", "").apply();
      FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
      if (firebaseUser != null)
        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
              public void onComplete(Task<Void> param1Task) {
                param1Task.isSuccessful();
              }
            }); 
    } 
    stopSelf();
  }
}