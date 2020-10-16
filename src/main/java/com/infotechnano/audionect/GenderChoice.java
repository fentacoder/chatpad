package com.infotechnano.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

public class GenderChoice extends AppCompatActivity {
  private Button both;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private Button female;
  
  private Button male;
  
  private ProgressBar progressBar;
  
  private ScrollView scrollView;
  
  private SharedPreferences sharedPreferences;
  
  private TextView textView;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
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
          this.scrollView.setBackgroundResource(2131230815);
        case 13:
          this.scrollView.setBackgroundResource(2131230897);
        case 12:
          this.scrollView.setBackgroundResource(2131230910);
        case 11:
          this.scrollView.setBackgroundResource(2131230902);
        case 10:
          this.scrollView.setBackgroundResource(2131230816);
        case 9:
          this.scrollView.setBackgroundResource(2131230903);
        case 8:
          this.scrollView.setBackgroundResource(2131230904);
        case 7:
          this.scrollView.setBackgroundResource(2131230895);
        case 6:
          this.scrollView.setBackgroundResource(2131230823);
        case 5:
          this.scrollView.setBackgroundResource(2131230867);
        case 4:
          this.scrollView.setBackgroundResource(2131230818);
        case 3:
          this.scrollView.setBackgroundResource(2131230877);
        case 2:
          this.scrollView.setBackgroundResource(2131230864);
        case 1:
          this.scrollView.setBackgroundResource(2131230879);
        case 0:
          break;
      } 
      this.scrollView.setBackgroundResource(2131230878);
    } 
    this.scrollView.setBackgroundResource(2131230855);
    this.male.setBackgroundResource(2131230854);
    this.female.setBackgroundResource(2131230854);
    this.both.setBackgroundResource(2131230854);
    this.male.setTextColor(-1);
    this.female.setTextColor(-1);
    this.both.setTextColor(-1);
    this.textView.setTextColor(-1);
  }
  
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
            GenderChoice.this.progressBar.setVisibility(4);
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            GenderChoice.this.progressBar.setVisibility(4);
          }
        });
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492927);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.progressBar = (ProgressBar)findViewById(2131296472);
    this.scrollView = (ScrollView)findViewById(2131296471);
    this.textView = (TextView)findViewById(2131296473);
    this.male = (Button)findViewById(2131296469);
    this.female = (Button)findViewById(2131296468);
    this.both = (Button)findViewById(2131296467);
    setColor();
  }
  
  public void onGenderChoiceSettingsClicked(View paramView) {
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
          this.sharedPreferences.edit().putString("gender", "both").apply();
          this.progressBar.setVisibility(0);
          updateUserCollection();
          startActivity(new Intent((Context)this, Settings.class));
          finish();
        } 
      } else {
        this.sharedPreferences.edit().putString("gender", "female").apply();
        this.progressBar.setVisibility(0);
        updateUserCollection();
        startActivity(new Intent((Context)this, Settings.class));
        finish();
      } 
    } else {
      this.sharedPreferences.edit().putString("gender", "male").apply();
      this.progressBar.setVisibility(0);
      updateUserCollection();
      startActivity(new Intent((Context)this, Settings.class));
      finish();
    } 
  }
}


