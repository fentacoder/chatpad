package com.jamar.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import java.util.ArrayList;
import java.util.HashMap;

public class CategorySwitcher extends AppCompatActivity {
  private String artwork;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private ArrayList<String> cList = new ArrayList<>();
  
  private Button cancelButton;
  
  private String canoeing;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private TextView categorySelectedTextView;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private String engineeringProjects;
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private String filmProduction;
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private FirebaseAuth firebaseAuth;
  
  private String goingOutForAOuting;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private String hiking;
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private String itemSelected;
  
  private LinearLayout linearLayout;
  
  private String listCategory;
  
  private String listItemSelected;
  
  private ListView listView;
  
  private String musicProduction;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private int preSelectedIdx = -1;
  
  private String programming;
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private Button saveButton;
  
  private SharedPreferences sharedPreferences;
  
  private String shopping;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private String sports;
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private String studying;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private String travel;
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private FirebaseUser user;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private String vehicles;
  
  private String venting;
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private String videogames;
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private void deleteUserFromCurrentCollection() {
    byte b;
    String str = this.sharedPreferences.getString("userCategory", "");
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 2014205639:
        if (str.equals("vehicles")) {
          b = 1;
          break;
        } 
      case 1960295156:
        if (str.equals("goingOut")) {
          b = 2;
          break;
        } 
      case 1876609401:
        if (str.equals("studying")) {
          b = 10;
          break;
        } 
      case 1438428509:
        if (str.equals("filmProduction")) {
          b = 6;
          break;
        } 
      case 1289849005:
        if (str.equals("engineeringProjects")) {
          b = 13;
          break;
        } 
      case 1027739838:
        if (str.equals("musicProduction")) {
          b = 4;
          break;
        } 
      case 763555736:
        if (str.equals("ventFrustration")) {
          b = 7;
          break;
        } 
      case 624751731:
        if (str.equals("programmingProjects")) {
          b = 14;
          break;
        } 
      case -112094084:
        if (str.equals("canoeing")) {
          b = 12;
          break;
        } 
      case -344460952:
        if (str.equals("shopping")) {
          b = 0;
          break;
        } 
      case -731949068:
        if (str.equals("artwork")) {
          b = 5;
          break;
        } 
      case -865698022:
        if (str.equals("travel")) {
          b = 8;
          break;
        } 
      case -895760513:
        if (str.equals("sports")) {
          b = 3;
          break;
        } 
      case -1217273832:
        if (str.equals("hiking")) {
          b = 9;
          break;
        } 
      case -1611025626:
        if (str.equals("videogames")) {
          b = 11;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 14:
        this.programmingProjectsCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 13:
        this.engineeringProjectsCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 12:
        this.canoeingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 11:
        this.videogamesCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 10:
        this.studyingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 9:
        this.hikingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 8:
        this.travelingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 7:
        this.ventingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 6:
        this.filmProductionCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 5:
        this.artworkArtistCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 4:
        this.musicProductionCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 3:
        this.sportsCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 2:
        this.goingOutForGoodTimeCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 1:
        this.vehicleCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
      case 0:
        break;
    } 
    this.shoppingCollection.document(this.sharedPreferences.getString("currentUser", "")).delete();
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
    this.categorySelectedTextView.setTextColor(-1);
    this.cancelButton.setTextColor(-1);
    this.saveButton.setTextColor(-1);
    this.cancelButton.setBackgroundResource(2131230854);
    this.saveButton.setBackgroundResource(2131230854);
    this.categorySelectedTextView.setTextColor(-1);
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
          public void onSuccess(Void param1Void) {}
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void uploadUserData(CollectionReference paramCollectionReference) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("showMe", this.sharedPreferences.getString("settingsShowMe", ""));
    hashMap.put("name", this.sharedPreferences.getString("name", ""));
    hashMap.put("city", this.sharedPreferences.getString("userLocation", ""));
    hashMap.put("picturesList", this.sharedPreferences.getString("picturesList", ""));
    hashMap.put("bio", this.sharedPreferences.getString("bio", ""));
    hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
    hashMap.put("urlList", this.sharedPreferences.getString("urlList", ""));
    hashMap.put("swipeRightList", this.sharedPreferences.getString("swipeRightList", ""));
    hashMap.put("swipeLeftList", this.sharedPreferences.getString("swipeLeftList", ""));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
    hashMap = new HashMap<>();
    hashMap.put("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("age", ""))));
    hashMap.put("lat", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("lat", ""))));
    hashMap.put("lng", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("lng", ""))));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492904);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.linearLayout = (LinearLayout)findViewById(2131296358);
    this.cancelButton = (Button)findViewById(2131296357);
    this.saveButton = (Button)findViewById(2131296360);
    this.categorySelectedTextView = (TextView)findViewById(2131296361);
    this.listView = (ListView)findViewById(2131296359);
    setColor();
    this.saveButton.setAlpha(0.3F);
    this.saveButton.setEnabled(false);
    try {
      this.shopping = getResources().getString(2131689695);
      this.vehicles = getResources().getString(2131689733);
      this.goingOutForAOuting = getResources().getString(2131689614);
      this.sports = getResources().getString(2131689699);
      this.musicProduction = getResources().getString(2131689642);
      this.artwork = getResources().getString(2131689527);
      this.filmProduction = getResources().getString(2131689607);
      this.venting = getResources().getString(2131689734);
      this.travel = getResources().getString(2131689727);
      this.hiking = getResources().getString(2131689622);
      this.studying = getResources().getString(2131689701);
      this.videogames = getResources().getString(2131689736);
      this.canoeing = getResources().getString(2131689544);
      this.engineeringProjects = getResources().getString(2131689596);
      this.programming = getResources().getString(2131689678);
    } catch (NullPointerException nullPointerException) {
      nullPointerException.printStackTrace();
    } 
    this.cList.add(this.shopping);
    this.cList.add(this.vehicles);
    this.cList.add(this.goingOutForAOuting);
    this.cList.add(this.sports);
    this.cList.add(this.musicProduction);
    this.cList.add(this.artwork);
    this.cList.add(this.filmProduction);
    this.cList.add(this.venting);
    this.cList.add(this.travel);
    this.cList.add(this.hiking);
    this.cList.add(this.studying);
    this.cList.add(this.videogames);
    this.cList.add(this.canoeing);
    this.cList.add(this.engineeringProjects);
    this.cList.add(this.programming);
    ArrayList<String> arrayList = this.cList;
    if (arrayList != null && arrayList.size() > 0) {
      ArrayAdapter arrayAdapter = new ArrayAdapter((Context)this, 17367043, this.cList);
      this.listView.setAdapter((ListAdapter)arrayAdapter);
      try {
        ListView listView = this.listView;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
              StringBuilder stringBuilder6;
              CategorySwitcher categorySwitcher6;
              StringBuilder stringBuilder5;
              CategorySwitcher categorySwitcher5;
              StringBuilder stringBuilder4;
              CategorySwitcher categorySwitcher4;
              StringBuilder stringBuilder3;
              CategorySwitcher categorySwitcher3;
              StringBuilder stringBuilder2;
              CategorySwitcher categorySwitcher2;
              StringBuilder stringBuilder1;
              CategorySwitcher categorySwitcher10;
              StringBuilder stringBuilder10;
              CategorySwitcher categorySwitcher9;
              StringBuilder stringBuilder9;
              CategorySwitcher categorySwitcher8;
              StringBuilder stringBuilder8;
              CategorySwitcher categorySwitcher7;
              param1AdapterView.getChildAt(param1Int).setAlpha(0.3F);
              if (CategorySwitcher.this.preSelectedIdx > -1)
                param1AdapterView.getChildAt(CategorySwitcher.this.preSelectedIdx).setAlpha(1.0F); 
              CategorySwitcher.access$002(CategorySwitcher.this, param1Int);
              switch (param1Int) {
                default:
                  CategorySwitcher.access$102(CategorySwitcher.this, "");
                  categorySwitcher10 = CategorySwitcher.this;
                  stringBuilder6 = new StringBuilder();
                  stringBuilder6.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder6.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher10, stringBuilder6.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  return;
                case 14:
                  categorySwitcher6 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher6, categorySwitcher6.getResources().getString(2131689678));
                  CategorySwitcher.access$202(CategorySwitcher.this, "programmingProjects");
                  categorySwitcher6 = CategorySwitcher.this;
                  stringBuilder10 = new StringBuilder();
                  stringBuilder10.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder10.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher6, stringBuilder10.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 13:
                  categorySwitcher6 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher6, categorySwitcher6.getResources().getString(2131689596));
                  CategorySwitcher.access$202(CategorySwitcher.this, "engineeringProjects");
                  categorySwitcher6 = CategorySwitcher.this;
                  stringBuilder10 = new StringBuilder();
                  stringBuilder10.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder10.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher6, stringBuilder10.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 12:
                  categorySwitcher6 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher6, categorySwitcher6.getResources().getString(2131689544));
                  CategorySwitcher.access$202(CategorySwitcher.this, "canoeing");
                  categorySwitcher6 = CategorySwitcher.this;
                  stringBuilder10 = new StringBuilder();
                  stringBuilder10.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder10.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher6, stringBuilder10.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 11:
                  categorySwitcher6 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher6, categorySwitcher6.getResources().getString(2131689736));
                  CategorySwitcher.access$202(CategorySwitcher.this, "videogames");
                  categorySwitcher6 = CategorySwitcher.this;
                  stringBuilder10 = new StringBuilder();
                  stringBuilder10.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder10.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher6, stringBuilder10.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 10:
                  categorySwitcher6 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher6, categorySwitcher6.getResources().getString(2131689701));
                  CategorySwitcher.access$202(CategorySwitcher.this, "studying");
                  categorySwitcher9 = CategorySwitcher.this;
                  stringBuilder5 = new StringBuilder();
                  stringBuilder5.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder5.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher9, stringBuilder5.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 9:
                  categorySwitcher5 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher5, categorySwitcher5.getResources().getString(2131689622));
                  CategorySwitcher.access$202(CategorySwitcher.this, "hiking");
                  categorySwitcher5 = CategorySwitcher.this;
                  stringBuilder9 = new StringBuilder();
                  stringBuilder9.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder9.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher5, stringBuilder9.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 8:
                  categorySwitcher5 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher5, categorySwitcher5.getResources().getString(2131689727));
                  CategorySwitcher.access$202(CategorySwitcher.this, "travel");
                  categorySwitcher5 = CategorySwitcher.this;
                  stringBuilder9 = new StringBuilder();
                  stringBuilder9.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder9.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher5, stringBuilder9.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 7:
                  categorySwitcher5 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher5, categorySwitcher5.getResources().getString(2131689734));
                  CategorySwitcher.access$202(CategorySwitcher.this, "ventFrustration");
                  categorySwitcher8 = CategorySwitcher.this;
                  stringBuilder4 = new StringBuilder();
                  stringBuilder4.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder4.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher8, stringBuilder4.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 6:
                  categorySwitcher4 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher4, categorySwitcher4.getResources().getString(2131689607));
                  CategorySwitcher.access$202(CategorySwitcher.this, "filmProduction");
                  categorySwitcher4 = CategorySwitcher.this;
                  stringBuilder8 = new StringBuilder();
                  stringBuilder8.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder8.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher4, stringBuilder8.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 5:
                  categorySwitcher4 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher4, categorySwitcher4.getResources().getString(2131689527));
                  CategorySwitcher.access$202(CategorySwitcher.this, "artwork");
                  categorySwitcher4 = CategorySwitcher.this;
                  stringBuilder8 = new StringBuilder();
                  stringBuilder8.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder8.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher4, stringBuilder8.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 4:
                  categorySwitcher4 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher4, categorySwitcher4.getResources().getString(2131689642));
                  CategorySwitcher.access$202(CategorySwitcher.this, "musicProduction");
                  categorySwitcher4 = CategorySwitcher.this;
                  stringBuilder8 = new StringBuilder();
                  stringBuilder8.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder8.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher4, stringBuilder8.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 3:
                  categorySwitcher4 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher4, categorySwitcher4.getResources().getString(2131689699));
                  CategorySwitcher.access$202(CategorySwitcher.this, "sports");
                  categorySwitcher7 = CategorySwitcher.this;
                  stringBuilder3 = new StringBuilder();
                  stringBuilder3.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder3.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher7, stringBuilder3.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 2:
                  categorySwitcher3 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher3, categorySwitcher3.getResources().getString(2131689614));
                  CategorySwitcher.access$202(CategorySwitcher.this, "goingOut");
                  categorySwitcher7 = CategorySwitcher.this;
                  stringBuilder2 = new StringBuilder();
                  stringBuilder2.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder2.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher7, stringBuilder2.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 1:
                  categorySwitcher2 = CategorySwitcher.this;
                  CategorySwitcher.access$102(categorySwitcher2, categorySwitcher2.getResources().getString(2131689733));
                  CategorySwitcher.access$202(CategorySwitcher.this, "vehicles");
                  categorySwitcher7 = CategorySwitcher.this;
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(CategorySwitcher.this.listItemSelected);
                  stringBuilder1.append(" is selected");
                  CategorySwitcher.access$302(categorySwitcher7, stringBuilder1.toString());
                  CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
                  CategorySwitcher.this.saveButton.setAlpha(1.0F);
                  CategorySwitcher.this.saveButton.setEnabled(true);
                  return;
                case 0:
                  break;
              } 
              CategorySwitcher categorySwitcher1 = CategorySwitcher.this;
              CategorySwitcher.access$102(categorySwitcher1, categorySwitcher1.getResources().getString(2131689695));
              CategorySwitcher.access$202(CategorySwitcher.this, "shopping");
              categorySwitcher1 = CategorySwitcher.this;
              StringBuilder stringBuilder7 = new StringBuilder();
              stringBuilder7.append(CategorySwitcher.this.listItemSelected);
              stringBuilder7.append(" is selected");
              CategorySwitcher.access$302(categorySwitcher1, stringBuilder7.toString());
              CategorySwitcher.this.categorySelectedTextView.setText(CategorySwitcher.this.itemSelected);
              CategorySwitcher.this.saveButton.setAlpha(1.0F);
              CategorySwitcher.this.saveButton.setEnabled(true);
            }
          };
        super(this);
        listView.setOnItemClickListener(onItemClickListener);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      this.cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
              CategorySwitcher categorySwitcher = CategorySwitcher.this;
              categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
              CategorySwitcher.this.finish();
            }
          });
      this.saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
              byte b;
              String str = CategorySwitcher.this.listCategory;
              switch (str.hashCode()) {
                default:
                  b = -1;
                  break;
                case 2014205639:
                  if (str.equals("vehicles")) {
                    b = 1;
                    break;
                  } 
                case 1960295156:
                  if (str.equals("goingOut")) {
                    b = 2;
                    break;
                  } 
                case 1876609401:
                  if (str.equals("studying")) {
                    b = 10;
                    break;
                  } 
                case 1438428509:
                  if (str.equals("filmProduction")) {
                    b = 6;
                    break;
                  } 
                case 1289849005:
                  if (str.equals("engineeringProjects")) {
                    b = 13;
                    break;
                  } 
                case 1027739838:
                  if (str.equals("musicProduction")) {
                    b = 4;
                    break;
                  } 
                case 763555736:
                  if (str.equals("ventFrustration")) {
                    b = 7;
                    break;
                  } 
                case 624751731:
                  if (str.equals("programmingProjects")) {
                    b = 14;
                    break;
                  } 
                case -112094084:
                  if (str.equals("canoeing")) {
                    b = 12;
                    break;
                  } 
                case -344460952:
                  if (str.equals("shopping")) {
                    b = 0;
                    break;
                  } 
                case -731949068:
                  if (str.equals("artwork")) {
                    b = 5;
                    break;
                  } 
                case -865698022:
                  if (str.equals("travel")) {
                    b = 8;
                    break;
                  } 
                case -895760513:
                  if (str.equals("sports")) {
                    b = 3;
                    break;
                  } 
                case -1217273832:
                  if (str.equals("hiking")) {
                    b = 9;
                    break;
                  } 
                case -1611025626:
                  if (str.equals("videogames")) {
                    b = 11;
                    break;
                  } 
              } 
              switch (b) {
                default:
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 14:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "programmingProjects").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.programmingProjectsCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 13:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "engineeringProjects").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.engineeringProjectsCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 12:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "canoeing").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.canoeingCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 11:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "videogames").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.videogamesCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 10:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "studying").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.studyingCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 9:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "hiking").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.hikingCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 8:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "travel").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.travelingCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 7:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "ventFrustration").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.ventingCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 6:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "filmProduction").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.filmProductionCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 5:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "artwork").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.artworkArtistCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 4:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "musicProduction").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.musicProductionCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 3:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "sports").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.sportsCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 2:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "goingOut").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.goingOutForGoodTimeCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 1:
                  CategorySwitcher.this.deleteUserFromCurrentCollection();
                  CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "vehicles").apply();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.uploadUserData(categorySwitcher.vehicleCollection);
                  CategorySwitcher.this.updateUserCollection();
                  categorySwitcher = CategorySwitcher.this;
                  categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
                  CategorySwitcher.this.finish();
                  return;
                case 0:
                  break;
              } 
              CategorySwitcher.this.deleteUserFromCurrentCollection();
              CategorySwitcher.this.sharedPreferences.edit().putString("userCategory", "shopping").apply();
              CategorySwitcher categorySwitcher = CategorySwitcher.this;
              categorySwitcher.uploadUserData(categorySwitcher.shoppingCollection);
              CategorySwitcher.this.updateUserCollection();
              categorySwitcher = CategorySwitcher.this;
              categorySwitcher.startActivity(new Intent((Context)categorySwitcher, Settings.class));
              CategorySwitcher.this.finish();
            }
          });
    } 
  }
}

