package com.jamar.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jamar.audionect.adapter.LocationChooserAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LocationChooser extends AppCompatActivity {
  private Button add;
  
  private Button back;
  
  private LinearLayout linearLayout;
  
  private LocationChooserAdapter locationChooserAdapter;
  
  private TextView locationSelected;
  
  private ArrayList<String> recentLocationList = new ArrayList<>();
  
  private TextView recentLocationTextView;
  
  private RecyclerView recyclerView;
  
  private SharedPreferences sharedPreferences;
  
  private Button switchToCurrent;
  
  private boolean userCanChangeLocation;
  
  private ArrayList<String> getRecentLocations() {
    return new ArrayList<>(Arrays.asList(this.sharedPreferences.getString("recentLocations", "").split("!#!")));
  }
  
  private String getUserCity(String paramString1, String paramString2) {
    Geocoder geocoder = new Geocoder((Context)this, Locale.getDefault());
    try {
      List<Address> list = geocoder.getFromLocation(Double.parseDouble(paramString1), Double.parseDouble(paramString2), 1);
      paramString2 = ((Address)list.get(0)).getLocality();
      try {
        paramString1 = ((Address)list.get(0)).getAdminArea();
        try {
          String str1 = ((Address)list.get(0)).getCountryName();
        } catch (IOException null) {}
      } catch (IOException null) {
        paramString1 = "";
      } 
    } catch (IOException iOException) {
      paramString2 = "";
      paramString1 = paramString2;
    } 
    Toast.makeText((Context)this, "Problem in getUserCity method", 1).show();
    iOException.printStackTrace();
    String str = "";
  }
  
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
    this.locationSelected.setTextColor(-1);
    this.recentLocationTextView.setTextColor(-1);
    this.switchToCurrent.setBackgroundResource(2131230854);
    this.switchToCurrent.setTextColor(-1);
    this.back.setBackgroundResource(2131230854);
    this.back.setTextColor(-1);
    this.add.setBackgroundResource(2131230854);
    this.add.setTextColor(-1);
  }
  
  private void showSelectedLocation(String paramString) {
    if (this.sharedPreferences.getString("currentLocation", "").equals("true")) {
      this.locationSelected.setText(2131689584);
    } else {
      this.locationSelected.setText(paramString);
      this.sharedPreferences.edit().putString("userLocation", paramString).apply();
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492895);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.locationSelected = (TextView)findViewById(2131296512);
    this.switchToCurrent = (Button)findViewById(2131296511);
    this.back = (Button)findViewById(2131296505);
    this.add = (Button)findViewById(2131296504);
    this.recentLocationTextView = (TextView)findViewById(2131296507);
    this.recyclerView = (RecyclerView)findViewById(2131296508);
    this.linearLayout = (LinearLayout)findViewById(2131296506);
    this.recyclerView.setHasFixedSize(true);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this));
    setColor();
    if (this.sharedPreferences.getString("extrovert", "").equals("true") || this.sharedPreferences.getString("platinum", "").equals("true")) {
      this.userCanChangeLocation = true;
    } else {
      this.userCanChangeLocation = false;
    } 
    if (!this.sharedPreferences.getString("currentLocation", "").equals("true")) {
      this.switchToCurrent.setAlpha(0.3F);
      this.switchToCurrent.setEnabled(false);
    } 
    paramBundle = getIntent().getExtras();
    if (paramBundle == null || paramBundle.getString("location", "").equals("")) {
      showSelectedLocation(this.sharedPreferences.getString("userLocation", ""));
    } else {
      String[] arrayOfString = paramBundle.getString("location", "").split(">");
      String str = getUserCity(arrayOfString[0], arrayOfString[1]);
      this.sharedPreferences.edit().putString("userLocation", str).apply();
      showSelectedLocation(str);
    } 
    this.recentLocationList = getRecentLocations();
    Collections.reverse(this.recentLocationList);
    ArrayList<String> arrayList = this.recentLocationList;
    if (arrayList != null && arrayList.size() > 0) {
      this.locationChooserAdapter = new LocationChooserAdapter((Context)this, this.recentLocationList);
      this.recyclerView.setAdapter((RecyclerView.Adapter)this.locationChooserAdapter);
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public void onLocationChooserAddClicked(View paramView) {
    if (this.userCanChangeLocation) {
      startActivity(new Intent((Context)this, MapsActivity.class));
      finish();
    } else {
      startActivity(new Intent((Context)this, PaymentSetUp.class));
      finish();
    } 
  }
  
  public void onLocationChooserBackClicked(View paramView) {
    startActivity(new Intent((Context)this, Settings.class));
    finish();
  }
  
  public void onLocationChooserSwitchToCurrentClicked(View paramView) {
    this.sharedPreferences.edit().putString("currentLocation", "true").putString("userLocation", "").apply();
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
}
