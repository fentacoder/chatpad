package com.jamar.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpSecurityKey extends AppCompatActivity {
  private EditText editText;
  
  private SharedPreferences sharedPreferences;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492974);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.editText = (EditText)findViewById(2131296695);
  }
  
  public void onSignUpSecurityKeyContinue(View paramView) {
    String str = this.editText.getText().toString().trim();
    if (str == null || str.equals("")) {
      Toast.makeText((Context)this, getString(2131689716), 1).show();
      return;
    } 
    if ((str.toCharArray()).length > 40) {
      Toast.makeText((Context)this, getString(2131689726), 0).show();
    } else {
      str = str.toLowerCase();
      this.sharedPreferences.edit().putString("securityKey", str).apply();
      startActivity(new Intent((Context)this, InstrumentSelectorSignUp.class));
      finish();
    } 
  }
}
