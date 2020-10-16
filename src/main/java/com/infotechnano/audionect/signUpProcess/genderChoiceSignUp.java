package com.infotechnano.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

public class genderChoiceSignUp extends AppCompatActivity {
  private boolean activityCompleted;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private ProgressBar progressBar;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private void updateUserCollection() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("username", this.sharedPreferences.getString("username", ""));
    hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
    hashMap.put("password", this.sharedPreferences.getString("password", ""));
    hashMap.put("email", this.sharedPreferences.getString("email", ""));
    hashMap.put("phoneNumber", this.sharedPreferences.getString("phoneNumber", ""));
    hashMap.put("genderPref", this.sharedPreferences.getString("gender", "both"));
    hashMap.put("genderId", this.sharedPreferences.getString("genderId", ""));
    hashMap.put("notificationFlag", this.sharedPreferences.getString("notificationsActive", "false"));
    hashMap.put("chatterPlan", this.sharedPreferences.getString("chatter", ""));
    hashMap.put("extrovertPlan", this.sharedPreferences.getString("extrovert", ""));
    hashMap.put("platinumPlan", this.sharedPreferences.getString("platinum", ""));
    hashMap.put("newMessages", this.sharedPreferences.getString("newMessages", "false"));
    hashMap.put("newMatches", this.sharedPreferences.getString("newMatches", "false"));
    hashMap.put("chatList", this.sharedPreferences.getString("chatList", ""));
    hashMap.put("blockList", this.sharedPreferences.getString("blockList", ""));
    hashMap.put("bolt", this.sharedPreferences.getString("bolt", "false"));
    hashMap.put("boltPeriod", this.sharedPreferences.getString("boltPeriod", ""));
    hashMap.put("securityKey", this.sharedPreferences.getString("securityKey", ""));
    if (!this.sharedPreferences.getString("paymentActive", "").equals("") && !this.sharedPreferences.getString("paymentActive", "").equals("false")) {
      hashMap.put("paymentOption", this.sharedPreferences.getString("paymentActive", ""));
      hashMap.put("paymentToken", this.sharedPreferences.getString("paymentToken", ""));
    } else {
      hashMap.put("paymentOption", "");
      hashMap.put("paymentToken", "");
    } 
    this.user_auth_collection.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            genderChoiceSignUp.this.progressBar.setVisibility(4);
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            genderChoiceSignUp.this.progressBar.setVisibility(4);
          }
        });
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492928);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.progressBar = (ProgressBar)findViewById(2131296470);
    this.activityCompleted = false;
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (!this.activityCompleted) {
      this.db.collection("Users").document(this.sharedPreferences.getString("currentUser", "")).delete();
      FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> param1Task) {
              param1Task.isSuccessful();
            }
          });
    } 
  }
  
  public void onGenderChoiceClicked(View paramView) {
    byte b;
    String str = paramView.getTag().toString();
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 50:
        if (str.equals("2")) {
          b = 2;
          break;
        } 
      case 49:
        if (str.equals("1")) {
          b = 1;
          break;
        } 
      case 48:
        if (str.equals("0")) {
          b = 0;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b == 2) {
          this.activityCompleted = true;
          this.sharedPreferences.edit().putString("gender", "both").apply();
          this.progressBar.setVisibility(0);
          updateUserCollection();
          startActivity(new Intent((Context)this, PictureSignUpScreen.class));
          finish();
        } 
      } else {
        this.activityCompleted = true;
        this.sharedPreferences.edit().putString("gender", "female").apply();
        this.progressBar.setVisibility(0);
        updateUserCollection();
        startActivity(new Intent((Context)this, PictureSignUpScreen.class));
        finish();
      } 
    } else {
      this.activityCompleted = true;
      this.sharedPreferences.edit().putString("gender", "male").apply();
      this.progressBar.setVisibility(0);
      updateUserCollection();
      startActivity(new Intent((Context)this, PictureSignUpScreen.class));
      finish();
    } 
  }
}

