package com.jamar.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.jamar.audionect.signUpProcess.StartUpScreen;

public class TermsPrivacyPolicyPage extends AppCompatActivity {
  private Bundle b;
  
  private Button back;
  
  String extra;
  
  private LinearLayout linearLayout;
  
  private Button privacyPolicyButton;
  
  private SharedPreferences sharedPreferences;
  
  private Button termsButton;
  
  private TextView textView;
  
  private void setColor() {
    boolean bool = this.sharedPreferences.getString("darkMode", "false").equals("false");
    byte b = -1;
    if (bool) {
      String str = this.sharedPreferences.getString("colorSelect", "");
      switch (str.hashCode()) {
        case 98619139:
          if (str.equals("green"))
            b = 0; 
          break;
        case 94011702:
          if (str.equals("brown"))
            b = 6; 
          break;
        case 93819586:
          if (str.equals("blaze"))
            b = 10; 
          break;
        case 93618148:
          if (str.equals("beige"))
            b = 14; 
          break;
        case 3441014:
          if (str.equals("pink"))
            b = 13; 
          break;
        case 3181155:
          if (str.equals("gray"))
            b = 5; 
          break;
        case 3178592:
          if (str.equals("gold"))
            b = 2; 
          break;
        case 3027034:
          if (str.equals("blue"))
            b = 4; 
          break;
        case 112785:
          if (str.equals("red"))
            b = 9; 
          break;
        case -267278044:
          if (str.equals("light blue"))
            b = 3; 
          break;
        case -734239628:
          if (str.equals("yellow"))
            b = 1; 
          break;
        case -816343937:
          if (str.equals("violet"))
            b = 12; 
          break;
        case -909707666:
          if (str.equals("salmon"))
            b = 8; 
          break;
        case -976943172:
          if (str.equals("purple"))
            b = 11; 
          break;
        case -1008851410:
          if (str.equals("orange"))
            b = 7; 
          break;
      } 
      switch (b) {
        default:
          return;
        case 14:
          this.linearLayout.setBackgroundResource(2131230815);
        case 13:
          this.linearLayout.setBackgroundResource(2131230897);
        case 12:
          this.linearLayout.setBackgroundResource(2131230910);
        case 11:
          this.linearLayout.setBackgroundResource(2131230902);
        case 10:
          this.linearLayout.setBackgroundResource(2131230816);
        case 9:
          this.linearLayout.setBackgroundResource(2131230903);
        case 8:
          this.linearLayout.setBackgroundResource(2131230904);
        case 7:
          this.linearLayout.setBackgroundResource(2131230895);
        case 6:
          this.linearLayout.setBackgroundResource(2131230823);
        case 5:
          this.linearLayout.setBackgroundResource(2131230867);
        case 4:
          this.linearLayout.setBackgroundResource(2131230818);
        case 3:
          this.linearLayout.setBackgroundResource(2131230877);
        case 2:
          this.linearLayout.setBackgroundResource(2131230864);
        case 1:
          this.linearLayout.setBackgroundResource(2131230879);
        case 0:
          break;
      } 
      this.linearLayout.setBackgroundResource(2131230878);
    } 
    this.linearLayout.setBackgroundResource(2131230855);
    this.termsButton.setBackgroundResource(2131230854);
    this.termsButton.setTextColor(-1);
    this.privacyPolicyButton.setBackgroundResource(2131230854);
    this.privacyPolicyButton.setTextColor(-1);
    this.back.setTextColor(-1);
    this.back.setBackgroundResource(2131230854);
    this.textView.setTextColor(-1);
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    if (this.extra.equals("startScreen")) {
      startActivity(new Intent((Context)this, StartUpScreen.class));
      finish();
    } else {
      startActivity(new Intent((Context)this, Settings.class));
      finish();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492978);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.termsButton = (Button)findViewById(2131296728);
    this.privacyPolicyButton = (Button)findViewById(2131296607);
    this.back = (Button)findViewById(2131296727);
    this.linearLayout = (LinearLayout)findViewById(2131296729);
    this.textView = (TextView)findViewById(2131296730);
    setColor();
    this.b = getIntent().getExtras();
    this.extra = this.b.getString("prevClass");
    final Intent i = new Intent((Context)this, TermsPage.class);
    intent.putExtra("prevClass", this.extra);
    this.termsButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            TermsPrivacyPolicyPage.this.startActivity(i);
            TermsPrivacyPolicyPage.this.finish();
          }
        });
    this.privacyPolicyButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            TermsPrivacyPolicyPage.this.startActivity(i);
            TermsPrivacyPolicyPage.this.finish();
          }
        });
    this.back.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            if (TermsPrivacyPolicyPage.this.extra.equals("startScreen")) {
              TermsPrivacyPolicyPage termsPrivacyPolicyPage = TermsPrivacyPolicyPage.this;
              termsPrivacyPolicyPage.startActivity(new Intent((Context)termsPrivacyPolicyPage, StartUpScreen.class));
              TermsPrivacyPolicyPage.this.finish();
            } else {
              TermsPrivacyPolicyPage termsPrivacyPolicyPage = TermsPrivacyPolicyPage.this;
              termsPrivacyPolicyPage.startActivity(new Intent((Context)termsPrivacyPolicyPage, Settings.class));
              TermsPrivacyPolicyPage.this.finish();
            } 
          }
        });
  }
}