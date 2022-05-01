package com.jamar.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class GenderIdentity extends AppCompatActivity {
  private boolean activityCompleted;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private ProgressBar progressBar;
  
  private SharedPreferences sharedPreferences;
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492929);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.progressBar = (ProgressBar)findViewById(2131296474);
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
  
  public void onGenderIdentityChoiceClicked(View paramView) {

  }
}
