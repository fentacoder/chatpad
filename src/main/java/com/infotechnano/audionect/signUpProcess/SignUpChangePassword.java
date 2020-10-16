package com.infotechnano.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.infotechnano.audionect.MainActivity;
import java.util.HashMap;
import java.util.Objects;
import util.Person;

public class SignUpChangePassword extends AppCompatActivity {
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private EditText confirmedPassword;
  
  private String confirmedPasswordLine = "";
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private EditText newPassword;
  
  private String newPasswordLine = "";
  
  private EditText oldPassword;
  
  private String oldPasswordLine = "";
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private ProgressBar progressBar;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private void downloadDataFromServer(CollectionReference paramCollectionReference) {
    paramCollectionReference.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                SignUpChangePassword.this.sharedPreferences.edit().putString("settingsShowMe", queryDocumentSnapshot.getString("showMe")).putString("currentUser", queryDocumentSnapshot.getString("userId")).putString("name", queryDocumentSnapshot.getString("name")).putString("age", String.valueOf(Objects.requireNonNull(queryDocumentSnapshot.getLong("age")))).putString("bio", queryDocumentSnapshot.getString("bio")).putString("picturesList", queryDocumentSnapshot.getString("picturesList")).putString("userCategory", queryDocumentSnapshot.getString("category")).putString("userLocation", queryDocumentSnapshot.getString("city")).putString("urlList", queryDocumentSnapshot.getString("urlList")).putString("lat", String.valueOf(queryDocumentSnapshot.getString("lat"))).putString("lng", String.valueOf(queryDocumentSnapshot.getString("lng"))).putString("swipeRightList", queryDocumentSnapshot.getString("swipeRightList")).putString("swipeLeftList", queryDocumentSnapshot.getString("swipeLeftList")).apply(); 
            } 
          }
        });
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                SignUpChangePassword.this.sharedPreferences.edit().putString("username", queryDocumentSnapshot.getString("username")).putString("password", queryDocumentSnapshot.getString("password")).putString("email", queryDocumentSnapshot.getString("email")).putString("phoneNumber", queryDocumentSnapshot.getString("phoneNumber")).apply(); 
            } 
          }
        });
  }
  
  private void downloadUserData() {
    byte b;
    String str = Person.getInstance().getPerson_category();
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
        downloadDataFromServer(this.programmingProjectsCollection);
      case 13:
        downloadDataFromServer(this.engineeringProjectsCollection);
      case 12:
        downloadDataFromServer(this.canoeingCollection);
      case 11:
        downloadDataFromServer(this.videogamesCollection);
      case 10:
        downloadDataFromServer(this.studyingCollection);
      case 9:
        downloadDataFromServer(this.hikingCollection);
      case 8:
        downloadDataFromServer(this.travelingCollection);
      case 7:
        downloadDataFromServer(this.ventingCollection);
      case 6:
        downloadDataFromServer(this.filmProductionCollection);
      case 5:
        downloadDataFromServer(this.artworkArtistCollection);
      case 4:
        downloadDataFromServer(this.musicProductionCollection);
      case 3:
        downloadDataFromServer(this.sportsCollection);
      case 2:
        downloadDataFromServer(this.goingOutForGoodTimeCollection);
      case 1:
        downloadDataFromServer(this.vehicleCollection);
      case 0:
        break;
    } 
    downloadDataFromServer(this.shoppingCollection);
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
            Toast.makeText((Context)SignUpChangePassword.this, "category changed", 0).show();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void updateUserData() {
    byte b;
    String str = Person.getInstance().getPerson_category();
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
        uploadUserData(this.programmingProjectsCollection);
      case 13:
        uploadUserData(this.engineeringProjectsCollection);
      case 12:
        uploadUserData(this.canoeingCollection);
      case 11:
        uploadUserData(this.videogamesCollection);
      case 10:
        uploadUserData(this.studyingCollection);
      case 9:
        uploadUserData(this.hikingCollection);
      case 8:
        uploadUserData(this.travelingCollection);
      case 7:
        uploadUserData(this.ventingCollection);
      case 6:
        uploadUserData(this.filmProductionCollection);
      case 5:
        uploadUserData(this.artworkArtistCollection);
      case 4:
        uploadUserData(this.musicProductionCollection);
      case 3:
        uploadUserData(this.sportsCollection);
      case 2:
        uploadUserData(this.goingOutForGoodTimeCollection);
      case 1:
        uploadUserData(this.vehicleCollection);
      case 0:
        break;
    } 
    uploadUserData(this.shoppingCollection);
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
    setContentView(2131492973);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.oldPassword = (EditText)findViewById(2131296691);
    this.newPassword = (EditText)findViewById(2131296690);
    this.confirmedPassword = (EditText)findViewById(2131296689);
    this.progressBar = (ProgressBar)findViewById(2131296692);
  }
  
  public void onSignUpChangePasswordDoneButtonClicked(View paramView) {
    this.oldPasswordLine = this.oldPassword.getText().toString().trim();
    this.newPasswordLine = this.newPassword.getText().toString().trim();
    this.confirmedPasswordLine = this.confirmedPassword.getText().toString().trim();
    if (!this.oldPasswordLine.equals("") && !this.newPasswordLine.equals("") && !this.confirmedPasswordLine.equals("")) {
      if (!this.oldPasswordLine.equals(this.newPasswordLine) && this.newPasswordLine.equals(this.confirmedPasswordLine)) {
        this.progressBar.setVisibility(0);
        this.sharedPreferences.edit().putString("password", this.confirmedPasswordLine).apply();
        downloadUserData();
        updateUserData();
        updateUserCollection();
        if (!this.sharedPreferences.getString("name", "").equals("")) {
          this.progressBar.setVisibility(4);
          this.sharedPreferences.edit().putString("login", "false").apply();
          Toast.makeText((Context)this, 2131689661, 0).show();
          startActivity(new Intent((Context)this, MainActivity.class));
          finish();
        } else {
          Toast.makeText((Context)this, 2131689694, 0).show();
        } 
      } else {
        Toast.makeText((Context)this, 2131689660, 1).show();
      } 
    } else {
      Toast.makeText((Context)this, 2131689519, 1).show();
    } 
  }
}
