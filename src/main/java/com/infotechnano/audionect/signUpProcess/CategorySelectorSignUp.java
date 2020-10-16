package com.infotechnano.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;

public class InstrumentSelectorSignUp extends AppCompatActivity implements View.OnTouchListener, View.OnKeyListener {
  private boolean activityCompleted;
  
  private String artwork;
  
  private ArrayList<String> cList = new ArrayList<>();
  
  private String canoeing;
  
  private ArrayList<String> categoryArrayList = new ArrayList<>();
  
  private EditText categoryEditText;
  
  private ListView categoryListView;
  
  private TextView categorySelectedTextView;
  
  private TextView categoryTextView;
  
  private Button continueButton;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private String engineeringProjects;
  
  private String filmProduction;
  
  private String goingOutForAOuting;
  
  private String hiking;
  
  private InputMethodManager inputMethodManager;
  
  private String itemSelected;
  
  private LinearLayout linearLayout;
  
  private String listCategory;
  
  private String listItemSelected;
  
  private String musicProduction;
  
  private int preSelectedIdx = -1;
  
  private String programming;
  
  private ProgressBar progressBar;
  
  private ScrollView scrollView;
  
  private SharedPreferences sharedPreferences;
  
  private String shopping;
  
  private TextView specificInstrumentTextView;
  
  private String sports;
  
  private String studying;
  
  private String travel;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private String vehicles;
  
  private String venting;
  
  private String videogames;
  
  private String checkBio() {
    String str1 = this.categoryEditText.getText().toString().trim();
    String str2 = str1;
    if (str1.length() > 400) {
      Toast.makeText((Context)this, 2131689631, 1).show();
      str2 = "";
    } 
    return str2;
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  public void onCategorySignUpButtonClicked(View paramView) {
    String str = checkBio();
    try {
      if (this.listItemSelected != null && !this.listItemSelected.equals("")) {
        if (!str.equals("")) {
          this.activityCompleted = true;
          this.progressBar.setVisibility(0);
          this.sharedPreferences.edit().putString("userCategory", this.listCategory).putString("bio", str).apply();
          HashMap<Object, Object> hashMap = new HashMap<>();
          this();
          hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
          hashMap.put("username", this.sharedPreferences.getString("username", ""));
          hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
          hashMap.put("password", this.sharedPreferences.getString("password", ""));
          hashMap.put("email", this.sharedPreferences.getString("email", ""));
          hashMap.put("phoneNumber", this.sharedPreferences.getString("phoneNumber", ""));
          hashMap.put("genderPref", this.sharedPreferences.getString("gender", "both"));
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
          boolean bool = this.sharedPreferences.getString("paymentActive", "").equals("");
          if (!bool && !this.sharedPreferences.getString("paymentActive", "").equals("false")) {
            hashMap.put("paymentOption", this.sharedPreferences.getString("paymentActive", ""));
            hashMap.put("paymentToken", this.sharedPreferences.getString("paymentToken", ""));
          } else {
            hashMap.put("paymentOption", "");
            hashMap.put("paymentToken", "");
          } 
          Task task1 = this.user_auth_collection.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap);
          OnSuccessListener<Void> onSuccessListener = new OnSuccessListener<Void>() {
              public void onSuccess(Void param1Void) {
                InstrumentSelectorSignUp.this.progressBar.setVisibility(4);
                InstrumentSelectorSignUp instrumentSelectorSignUp = InstrumentSelectorSignUp.this;
                instrumentSelectorSignUp.startActivity(new Intent((Context)instrumentSelectorSignUp, GenderIdentity.class));
                InstrumentSelectorSignUp.this.finish();
              }
            };
          super(this);
          Task task2 = task1.addOnSuccessListener(onSuccessListener);
          OnFailureListener onFailureListener = new OnFailureListener() {
              public void onFailure(Exception param1Exception) {
                InstrumentSelectorSignUp.this.progressBar.setVisibility(4);
              }
            };
          super(this);
          task2.addOnFailureListener(onFailureListener);
        } else {
          Toast.makeText((Context)this, 2131689534, 1).show();
        } 
      } else {
        Toast.makeText((Context)this, 2131689748, 1).show();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492894);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.categoryListView = (ListView)findViewById(2131296355);
    this.continueButton = (Button)findViewById(2131296356);
    this.categoryTextView = (TextView)findViewById(2131296639);
    this.specificInstrumentTextView = (TextView)findViewById(2131296703);
    this.categoryEditText = (EditText)findViewById(2131296702);
    this.categorySelectedTextView = (TextView)findViewById(2131296764);
    this.scrollView = (ScrollView)findViewById(2131296694);
    this.progressBar = (ProgressBar)findViewById(2131296492);
    this.linearLayout = (LinearLayout)findViewById(2131296693);
    this.activityCompleted = false;
    this.linearLayout.setOnTouchListener(this);
    this.categoryEditText.setOnKeyListener(this);
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
      this.categoryListView.setAdapter((ListAdapter)arrayAdapter);
    } 
    try {
      ListView listView = this.categoryListView;
      AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            InstrumentSelectorSignUp instrumentSelectorSignUp8;
            StringBuilder stringBuilder7;
            InstrumentSelectorSignUp instrumentSelectorSignUp7;
            StringBuilder stringBuilder6;
            InstrumentSelectorSignUp instrumentSelectorSignUp6;
            StringBuilder stringBuilder5;
            InstrumentSelectorSignUp instrumentSelectorSignUp5;
            StringBuilder stringBuilder4;
            InstrumentSelectorSignUp instrumentSelectorSignUp4;
            StringBuilder stringBuilder3;
            InstrumentSelectorSignUp instrumentSelectorSignUp3;
            StringBuilder stringBuilder2;
            InstrumentSelectorSignUp instrumentSelectorSignUp2;
            StringBuilder stringBuilder1;
            StringBuilder stringBuilder12;
            InstrumentSelectorSignUp instrumentSelectorSignUp12;
            StringBuilder stringBuilder11;
            InstrumentSelectorSignUp instrumentSelectorSignUp11;
            StringBuilder stringBuilder10;
            InstrumentSelectorSignUp instrumentSelectorSignUp10;
            StringBuilder stringBuilder9;
            InstrumentSelectorSignUp instrumentSelectorSignUp9;
            param1AdapterView.getChildAt(param1Int).setAlpha(0.3F);
            if (InstrumentSelectorSignUp.this.preSelectedIdx > -1)
              param1AdapterView.getChildAt(InstrumentSelectorSignUp.this.preSelectedIdx).setAlpha(1.0F); 
            InstrumentSelectorSignUp.access$002(InstrumentSelectorSignUp.this, param1Int);
            switch (param1Int) {
              default:
                InstrumentSelectorSignUp.access$102(InstrumentSelectorSignUp.this, "");
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                stringBuilder12 = new StringBuilder();
                stringBuilder12.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder12.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp8, stringBuilder12.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 14:
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp8, instrumentSelectorSignUp8.getResources().getString(2131689678));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "programmingProjects");
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                stringBuilder12 = new StringBuilder();
                stringBuilder12.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder12.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp8, stringBuilder12.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 13:
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp8, instrumentSelectorSignUp8.getResources().getString(2131689596));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "engineeringProjects");
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                stringBuilder12 = new StringBuilder();
                stringBuilder12.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder12.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp8, stringBuilder12.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 12:
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp8, instrumentSelectorSignUp8.getResources().getString(2131689544));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "canoeing");
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                stringBuilder12 = new StringBuilder();
                stringBuilder12.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder12.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp8, stringBuilder12.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 11:
                instrumentSelectorSignUp8 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp8, instrumentSelectorSignUp8.getResources().getString(2131689736));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "videogames");
                instrumentSelectorSignUp12 = InstrumentSelectorSignUp.this;
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder7.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp12, stringBuilder7.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 10:
                instrumentSelectorSignUp7 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp7, instrumentSelectorSignUp7.getResources().getString(2131689701));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "studying");
                instrumentSelectorSignUp12 = InstrumentSelectorSignUp.this;
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder6.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp12, stringBuilder6.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 9:
                instrumentSelectorSignUp6 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp6, instrumentSelectorSignUp6.getResources().getString(2131689622));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "hiking");
                instrumentSelectorSignUp6 = InstrumentSelectorSignUp.this;
                stringBuilder11 = new StringBuilder();
                stringBuilder11.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder11.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp6, stringBuilder11.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 8:
                instrumentSelectorSignUp6 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp6, instrumentSelectorSignUp6.getResources().getString(2131689727));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "travel");
                instrumentSelectorSignUp11 = InstrumentSelectorSignUp.this;
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder5.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp11, stringBuilder5.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 7:
                instrumentSelectorSignUp5 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp5, instrumentSelectorSignUp5.getResources().getString(2131689734));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "ventFrustration");
                instrumentSelectorSignUp5 = InstrumentSelectorSignUp.this;
                stringBuilder10 = new StringBuilder();
                stringBuilder10.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder10.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp5, stringBuilder10.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 6:
                instrumentSelectorSignUp5 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp5, instrumentSelectorSignUp5.getResources().getString(2131689607));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "filmProduction");
                instrumentSelectorSignUp10 = InstrumentSelectorSignUp.this;
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder4.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp10, stringBuilder4.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 5:
                instrumentSelectorSignUp4 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp4, instrumentSelectorSignUp4.getResources().getString(2131689527));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "artwork");
                instrumentSelectorSignUp10 = InstrumentSelectorSignUp.this;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder3.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp10, stringBuilder3.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 4:
                instrumentSelectorSignUp3 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp3, instrumentSelectorSignUp3.getResources().getString(2131689642));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "musicProduction");
                instrumentSelectorSignUp10 = InstrumentSelectorSignUp.this;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder2.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp10, stringBuilder2.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 3:
                instrumentSelectorSignUp2 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp2, instrumentSelectorSignUp2.getResources().getString(2131689699));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "sports");
                instrumentSelectorSignUp2 = InstrumentSelectorSignUp.this;
                stringBuilder9 = new StringBuilder();
                stringBuilder9.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder9.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp2, stringBuilder9.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 2:
                instrumentSelectorSignUp2 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp2, instrumentSelectorSignUp2.getResources().getString(2131689614));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "goingOut");
                instrumentSelectorSignUp2 = InstrumentSelectorSignUp.this;
                stringBuilder9 = new StringBuilder();
                stringBuilder9.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder9.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp2, stringBuilder9.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 1:
                instrumentSelectorSignUp2 = InstrumentSelectorSignUp.this;
                InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp2, instrumentSelectorSignUp2.getResources().getString(2131689733));
                InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "vehicles");
                instrumentSelectorSignUp9 = InstrumentSelectorSignUp.this;
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(InstrumentSelectorSignUp.this.listItemSelected);
                stringBuilder1.append(" is selected");
                InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp9, stringBuilder1.toString());
                InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
                return;
              case 0:
                break;
            } 
            InstrumentSelectorSignUp instrumentSelectorSignUp1 = InstrumentSelectorSignUp.this;
            InstrumentSelectorSignUp.access$102(instrumentSelectorSignUp1, instrumentSelectorSignUp1.getResources().getString(2131689695));
            InstrumentSelectorSignUp.access$202(InstrumentSelectorSignUp.this, "shopping");
            instrumentSelectorSignUp1 = InstrumentSelectorSignUp.this;
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(InstrumentSelectorSignUp.this.listItemSelected);
            stringBuilder8.append(" is selected");
            InstrumentSelectorSignUp.access$302(instrumentSelectorSignUp1, stringBuilder8.toString());
            InstrumentSelectorSignUp.this.categorySelectedTextView.setText(InstrumentSelectorSignUp.this.itemSelected);
          }
        };
      super(this);
      listView.setOnItemClickListener(onItemClickListener);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
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
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 66) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.categoryEditText.getWindowToken(), 0);
      return true;
    } 
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || paramInt == 284 || paramInt == 187) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramView.getId() == 2131296693 || paramView.getId() == 2131296639 || paramView.getId() == 2131296355 || paramView.getId() == 2131296764 || paramView.getId() == 2131296703) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.categoryEditText.getWindowToken(), 0);
    } 
    return true;
  }
}
