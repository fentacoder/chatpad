package com.infotechnano.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class SafetyTips extends AppCompatActivity {
  public void onBackPressed() {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492901);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public void onSafetyBackButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, StartUpScreen.class));
  }
  
  public void onSafetyContinueButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, CreateAccountScreen.class));
  }
}
