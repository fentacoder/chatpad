package com.infotechnano.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.infotechnano.audionect.adapter.ColorChooserAdapter;
import java.util.ArrayList;

public class ColorChooser extends AppCompatActivity {
  private Button back;
  
  private ColorChooserAdapter colorChooserAdapter;
  
  private ArrayList<String> colorList = new ArrayList<>();
  
  private Switch darkModeSwitch;
  
  private TextView darkModeText;
  
  private LinearLayout linearLayout;
  
  private RecyclerView recyclerView;
  
  private SharedPreferences sharedPreferences;
  
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
    this.back.setTextColor(-1);
    this.back.setBackgroundResource(2131230854);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492907);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.linearLayout = (LinearLayout)findViewById(2131296395);
    this.back = (Button)findViewById(2131296393);
    this.darkModeSwitch = (Switch)findViewById(2131296397);
    this.darkModeText = (TextView)findViewById(2131296394);
    this.recyclerView = (RecyclerView)findViewById(2131296396);
    this.recyclerView.setHasFixedSize(true);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this));
    setColor();
    this.colorList.add("default settings");
    this.colorList.add("green");
    this.colorList.add("yellow");
    this.colorList.add("gold");
    this.colorList.add("light blue");
    this.colorList.add("blue");
    this.colorList.add("gray");
    this.colorList.add("brown");
    this.colorList.add("orange");
    this.colorList.add("salmon");
    this.colorList.add("red");
    this.colorList.add("blaze");
    this.colorList.add("purple");
    this.colorList.add("violet");
    this.colorList.add("pink");
    this.colorList.add("beige");
    ArrayList<String> arrayList = this.colorList;
    if (arrayList != null && arrayList.size() > 0) {
      this.colorChooserAdapter = new ColorChooserAdapter((Context)this, this.colorList);
      this.recyclerView.setAdapter((RecyclerView.Adapter)this.colorChooserAdapter);
    } 
    if (this.sharedPreferences.getString("darkMode", "false").equals("true")) {
      this.recyclerView.setEnabled(false);
      this.recyclerView.setVisibility(4);
      this.darkModeSwitch.setChecked(true);
    } else {
      this.darkModeSwitch.setChecked(false);
    } 
    this.darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              ColorChooser.this.sharedPreferences.edit().putString("darkMode", "true").apply();
              ColorChooser colorChooser = ColorChooser.this;
              colorChooser.startActivity(new Intent((Context)colorChooser, Settings.class));
              ColorChooser.this.finish();
            } else {
              ColorChooser.this.sharedPreferences.edit().putString("darkMode", "false").apply();
              ColorChooser colorChooser = ColorChooser.this;
              colorChooser.startActivity(new Intent((Context)colorChooser, Settings.class));
              ColorChooser.this.finish();
            } 
          }
        });
  }
}

