package com.infotechnano.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.infotechnano.audionect.LogInScreen;
import com.infotechnano.audionect.MainActivity;
import com.infotechnano.audionect.TermsPrivacyPolicyPage;

public class StartUpScreen extends AppCompatActivity {
  private SharedPreferences sharedPreferences;
  
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492975);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    SharedPreferences sharedPreferences = this.sharedPreferences;
    if ((sharedPreferences == null || !sharedPreferences.getString("allPermissionsGranted", "").equals("true")) && (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 || checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 || checkSelfPermission("android.permission.INTERNET") != 0 || checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))
      requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_EXTERNAL_STORAGE" }, 1); 
    Bundle bundle = getIntent().getExtras();
    if (bundle != null && bundle.getString("security").equals("robot"))
      finish(); 
    if (this.sharedPreferences.getString("login", "").equals("true"))
      startActivity(new Intent((Context)this, MainActivity.class)); 
  }
  
  public void onGetStartedButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, LogInScreen.class));
    finish();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramInt == 1 && paramArrayOfint.length > 0 && paramArrayOfint[0] == 0 && paramArrayOfint[1] == 0 && paramArrayOfint[2] == 0 && paramArrayOfint[3] == 0 && paramArrayOfint[4] == 0)
      this.sharedPreferences.edit().putString("allPermissionsGranted", "true").apply(); 
  }
  
  public void onTermsButtonClicked(View paramView) {
    Intent intent = new Intent((Context)this, TermsPrivacyPolicyPage.class);
    intent.putExtra("prevClass", "startScreen");
    startActivity(intent);
    finish();
  }
}
