package com.infotechnano.audionect;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.infotechnano.audionect.adapter.ChatAdapter;
import com.infotechnano.audionect.signUpProcess.StartUpScreen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Chat extends AppCompatActivity {
  private ChatAdapter chatAdapter;
  
  private ArrayList<String> chatList;
  
  private String chatUsersLine;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private LinearLayout linearLayout;
  
  private TextView noUsersYet;
  
  private RecyclerView recyclerView;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private String downloadUserCollection() {
    final String[] inputArr = new String[1];
    arrayOfString[0] = "";
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                Chat.this.sharedPreferences.edit().putString("username", queryDocumentSnapshot.getString("username")).putString("password", queryDocumentSnapshot.getString("password")).putString("email", queryDocumentSnapshot.getString("email")).putString("gender", queryDocumentSnapshot.getString("genderPref")).putString("securityKey", queryDocumentSnapshot.getString("securityKey")).putString("userCategory", queryDocumentSnapshot.getString("category")).apply();
                if (queryDocumentSnapshot.getString("chatList") != null && !queryDocumentSnapshot.getString("chatList").equals("")) {
                  inputArr[0] = queryDocumentSnapshot.getString("chatUsers");
                  continue;
                } 
                inputArr[0] = "";
              } 
            } 
          }
        });
    return arrayOfString[0];
  }
  
  private void rateMe() {
    (new AlertDialog.Builder((Context)this)).setTitle(getString(2131689741)).setMessage(getString(2131689623)).setPositiveButton(getString(2131689742), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            try {
              Chat.this.sharedPreferences.edit().putString("rated", "true").apply();
              Chat chat = Chat.this;
              Intent intent = new Intent();
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("market://details?id=");
              stringBuilder.append(Chat.this.getPackageName());
              this("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
              chat.startActivity(intent);
            } catch (ActivityNotFoundException activityNotFoundException) {
              Chat.this.sharedPreferences.edit().putString("rated", "true").apply();
              Chat chat = Chat.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("http://play.google.com/store/apps/details?id=");
              stringBuilder.append(Chat.this.getPackageName());
              chat.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString())));
            } 
          }
        }).setNegativeButton(getString(2131689647), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        }).create().show();
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
    this.noUsersYet.setTextColor(-1);
  }
  
  private void updateUserCollection() {
    this.sharedPreferences.edit().putString("newMessages", "false").putString("newMatches", "false").putString("notificationActive", "false").apply();
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
            Log.d("uploadUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  public void onChatBackClicked(View paramView) {
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492892);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.sharedPreferences.edit().putString("newMessages", "false").putString("newMatches", "false").apply();
    this.recyclerView = (RecyclerView)findViewById(2131296379);
    this.linearLayout = (LinearLayout)findViewById(2131296377);
    this.noUsersYet = (TextView)findViewById(2131296378);
    this.recyclerView.setHasFixedSize(true);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this));
    this.noUsersYet.setVisibility(4);
    if (this.sharedPreferences.getString("rated", "false").equals("false"))
      rateMe(); 
    setColor();
    if (!this.sharedPreferences.getString("login", "").equals("true")) {
      startActivity(new Intent((Context)this, StartUpScreen.class));
      finish();
    } 
    this.chatUsersLine = downloadUserCollection();
    updateUserCollection();
    String str = this.sharedPreferences.getString("chatList", "");
    if (!str.equals(""))
      this.chatList = new ArrayList<>(Arrays.asList(str.split(","))); 
    str = this.chatUsersLine;
    if (str != null && !str.equals("")) {
      ArrayList<? extends String> arrayList = new ArrayList(Arrays.asList((Object[])this.chatUsersLine.split(",")));
      this.chatList.addAll(arrayList);
      Collections.reverse(this.chatList);
      ArrayList<String> arrayList1 = new ArrayList();
      HashSet<String> hashSet = new HashSet();
      for (String str1 : this.chatList) {
        if (hashSet.add(str1))
          arrayList1.add(str1); 
      } 
      this.chatList = arrayList1;
      this.chatAdapter = new ChatAdapter((Context)this, this.chatList);
      this.recyclerView.setAdapter((RecyclerView.Adapter)this.chatAdapter);
      if (ChatAdapter.newMessageNum > 0) {
        this.sharedPreferences.edit().putString("newMessages", "true").apply();
      } else {
        this.sharedPreferences.edit().putString("newMessages", "false").apply();
      } 
    } else {
      this.noUsersYet.setVisibility(0);
    } 
  }
}

