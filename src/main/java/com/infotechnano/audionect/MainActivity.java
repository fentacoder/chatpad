package com.infotechnano.audionect;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
  public static Context context;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private FirebaseAuth.AuthStateListener authStateListener;
  
  private ImageButton boltButton;
  
  private TextView bottomBioTextView;
  
  private View bottomSheet;
  
  private BottomSheetBehavior bottomSheetBehavior;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private float cardHeight;
  
  private float cardWidth;
  
  private float cardXTrans;
  
  private float cardYTrans;
  
  private TextView chatTextView;
  
  private TextView cityTextView;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private DocumentReference documentReference;
  
  private boolean dragStarted;
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private ImageView exclamation;
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private FirebaseAuth firebaseAuth;
  
  private ImageView fragmentBackground;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private int height;
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private String latString;
  
  private ImageView leftPic;
  
  private LinearLayout linearLayout;
  
  private String lngString;
  
  private String locationLine;
  
  private LocationListener locationListener;
  
  private LocationManager locationManager;
  
  private TextView locationTextView;
  
  private ImageView logo;
  
  private TextView mainBioTextView;
  
  private CardView mainFragmentCardView;
  
  private ImageView middlePic;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private TextView nameAgeTextView;
  
  private TextView noStrangersLeftTextView;
  
  private PowerManager powerManager;
  
  private ArrayList<String> profileList;
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private ProgressBar progressBar;
  
  private ImageButton rewindButton;
  
  private String rewindId = "";
  
  private TextView rightOrLeftText;
  
  private ImageView rightPic;
  
  private ImageButton settingsButton;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private SQLiteDatabase sqlDatabase;
  
  private String strangerId;
  
  private String strangerSwipedRightLine;
  
  private ConstraintLayout strangerView;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private String swipeLeft = "INSERT INTO swipeLeft(usernamesLeft) VALUES (?)";
  
  private String swipeLeftList;
  
  private SQLiteStatement swipeLeftStatement;
  
  private String swipeRight = "INSERT INTO swipeRight(usernamesRight) VALUES (?)";
  
  private String swipeRightList;
  
  private SQLiteStatement swipeRightStatement;
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private String userId;
  
  private boolean userRewinded;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private int width;
  
  private void addToChatList(String paramString) {
    String str = this.sharedPreferences.getString("chatList", "");
    if (str.equals("")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(",");
      paramString = stringBuilder.toString();
      this.sharedPreferences.edit().putString("chatList", paramString).apply();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(paramString);
      stringBuilder.append(",");
      paramString = stringBuilder.toString();
      this.sharedPreferences.edit().putString("chatList", paramString).apply();
    } 
  }
  
  private double changeInLat(int paramInt) {
    return Math.toDegrees(paramInt / 3960.0D);
  }
  
  private double changeInLng(double paramDouble, int paramInt) {
    paramDouble = Math.cos(paramDouble);
    return Math.toDegrees(paramInt / paramDouble * 3960.0D);
  }
  
  private void checkCurrentBoltStatus() {
    if (this.sharedPreferences.getString("bolt", "false").equals("true")) {
      this.boltButton.setImageResource(2131230911);
      this.boltButton.setBackgroundResource(2131230819);
    } 
  }
  
  private boolean checkForMatch(String paramString) {
    String str = this.sharedPreferences.getString("currentUser", "");
    String[] arrayOfString = paramString.split(",");
    for (byte b = 0; b < arrayOfString.length; b++) {
      if (arrayOfString[b].equals(str))
        return true; 
    } 
    return false;
  }
  
  private ArrayList<String> checkPeopleAlreadySwiped(ArrayList<String> paramArrayList) {
    ArrayList<String> arrayList1 = new ArrayList();
    ArrayList<String> arrayList2 = new ArrayList();
    ArrayList arrayList3 = new ArrayList(Arrays.asList((Object[])this.sharedPreferences.getString("swipeLeftList", "").split(",")));
    ArrayList arrayList4 = new ArrayList(Arrays.asList((Object[])this.sharedPreferences.getString("swipeRightList", "").split(",")));
    arrayList2.addAll(arrayList3);
    arrayList2.addAll(arrayList4);
    for (byte b = 0; b < paramArrayList.size(); b++) {
      for (byte b1 = 0; b1 < arrayList2.size(); b1++) {
        if (((String)arrayList2.get(b1)).equals(paramArrayList.get(b))) {
          paramArrayList.remove(b);
          break;
        } 
      } 
    } 
    arrayList1.addAll(paramArrayList);
    return arrayList1;
  }
  
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
  
  private void downloadDataFromServer(CollectionReference paramCollectionReference) {
    if (this.sharedPreferences.getString("login", "false").equals("true")) {
      paramCollectionReference.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                param1FirebaseFirestoreException.printStackTrace();
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  if (queryDocumentSnapshot.getString("swipeRightList") == null || queryDocumentSnapshot.getString("swipeRightList").equals("")) {
                    MainActivity.access$402(MainActivity.this, "");
                    MainActivity.access$502(MainActivity.this, "");
                  } else {
                    MainActivity.access$402(MainActivity.this, queryDocumentSnapshot.getString("swipeRightList"));
                    MainActivity.access$502(MainActivity.this, queryDocumentSnapshot.getString("swipeLeftList"));
                  } 
                  MainActivity.this.sharedPreferences.edit().putString("settingsShowMe", queryDocumentSnapshot.getString("showMe")).putString("currentUser", queryDocumentSnapshot.getString("userId")).putString("name", queryDocumentSnapshot.getString("name")).putString("age", String.valueOf(Math.round(queryDocumentSnapshot.getDouble("age").doubleValue()))).putString("bio", queryDocumentSnapshot.getString("bio")).putString("picturesList", queryDocumentSnapshot.getString("picturesList")).putString("userCategory", queryDocumentSnapshot.getString("category")).putString("userLocation", queryDocumentSnapshot.getString("city")).putString("urlList", queryDocumentSnapshot.getString("urlList")).putString("lat", String.valueOf(queryDocumentSnapshot.getDouble("lat"))).putString("lng", String.valueOf(queryDocumentSnapshot.getDouble("lng"))).putString("swipeRightList", MainActivity.this.swipeRightList).putString("swipeLeftList", MainActivity.this.swipeLeftList).apply();
                  Log.d("nullNumber", String.valueOf(queryDocumentSnapshot.getDouble("age")));
                  Log.d("nullNumber", String.valueOf(queryDocumentSnapshot.getDouble("lat")));
                  Log.d("nullNumber", String.valueOf(queryDocumentSnapshot.getDouble("lng")));
                } 
              } 
            }
          });
      this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                param1FirebaseFirestoreException.printStackTrace();
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                  MainActivity.this.sharedPreferences.edit().putString("username", queryDocumentSnapshot.getString("username")).putString("password", queryDocumentSnapshot.getString("password")).putString("email", queryDocumentSnapshot.getString("email")).putString("phoneNumber", queryDocumentSnapshot.getString("phoneNumber")).putString("chatList", queryDocumentSnapshot.getString("chatList")).putString("blockList", queryDocumentSnapshot.getString("blockList")).putString("chatter", queryDocumentSnapshot.getString("chatterPlan")).putString("extrovert", queryDocumentSnapshot.getString("extrovertPlan")).putString("platinum", queryDocumentSnapshot.getString("platinumPlan")).putString("newMessages", queryDocumentSnapshot.getString("newMessages")).putString("newMatches", queryDocumentSnapshot.getString("newMatches")).apply(); 
              } 
            }
          });
    } else {
      paramCollectionReference.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                param1FirebaseFirestoreException.printStackTrace();
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  MainActivity.this.sharedPreferences.edit().putString("currentUser", queryDocumentSnapshot.getString("userId")).putString("name", queryDocumentSnapshot.getString("name")).putString("bio", queryDocumentSnapshot.getString("bio")).putString("picturesList", queryDocumentSnapshot.getString("picturesList")).putString("userCategory", queryDocumentSnapshot.getString("category")).putString("urlList", queryDocumentSnapshot.getString("urlList")).apply();
                  MainActivity.this.sharedPreferences.edit().putString("age", String.valueOf(Objects.requireNonNull(Long.valueOf(Math.round(queryDocumentSnapshot.getDouble("age").doubleValue()))))).apply();
                } 
              } 
            }
          });
      this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                param1FirebaseFirestoreException.printStackTrace();
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                  MainActivity.this.sharedPreferences.edit().putString("username", queryDocumentSnapshot.getString("username")).putString("password", queryDocumentSnapshot.getString("password")).putString("email", queryDocumentSnapshot.getString("email")).putString("phoneNumber", queryDocumentSnapshot.getString("phoneNumber")).apply(); 
              } 
            }
          });
    } 
  }
  
  private String downloadStrangerData(CollectionReference paramCollectionReference, String paramString) {
    final String[] strangerSwipeRightList = new String[1];
    arrayOfString1[0] = "";
    final String[] imageListToGet = new String[1];
    arrayOfString2[0] = "";
    paramCollectionReference.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                String str1 = MainActivity.this.getFirstName(Objects.<String>requireNonNull(queryDocumentSnapshot.getString("name")));
                Integer.parseInt(String.valueOf(Objects.requireNonNull(queryDocumentSnapshot.getDouble("age"))));
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str1);
                stringBuilder1.append(" ");
                stringBuilder1.append(String.valueOf(Objects.requireNonNull(queryDocumentSnapshot.getLong("age"))));
                String str2 = stringBuilder1.toString();
                str1 = queryDocumentSnapshot.getString("bio");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(((String)Objects.<String>requireNonNull(str1)).substring(0, 17));
                stringBuilder2.append("...");
                String str4 = stringBuilder2.toString();
                String str3 = queryDocumentSnapshot.getString("city");
                strangerSwipeRightList[0] = queryDocumentSnapshot.getString("swipeRightList");
                MainActivity.this.nameAgeTextView.setText(str2);
                MainActivity.this.mainBioTextView.setText(str4);
                MainActivity.this.bottomBioTextView.setText(str1);
                MainActivity.this.cityTextView.setText(str3);
                str1 = MainActivity.this.getDistanceAway(queryDocumentSnapshot.getString("lat"), queryDocumentSnapshot.getString("lng"));
                MainActivity.this.locationTextView.setText(str1);
                imageListToGet[0] = queryDocumentSnapshot.getString("urlList");
              } 
            } 
          }
        });
    this.strangerSwipedRightLine = arrayOfString1[0];
    return arrayOfString2[0];
  }
  
  private void downloadUserData() {
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
  
  private CollectionReference getCategoryToQuery() {
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
        return null;
      case 14:
        return this.programmingProjectsCollection;
      case 13:
        return this.engineeringProjectsCollection;
      case 12:
        return this.canoeingCollection;
      case 11:
        return this.videogamesCollection;
      case 10:
        return this.studyingCollection;
      case 9:
        return this.hikingCollection;
      case 8:
        return this.travelingCollection;
      case 7:
        return this.ventingCollection;
      case 6:
        return this.filmProductionCollection;
      case 5:
        return this.artworkArtistCollection;
      case 4:
        return this.musicProductionCollection;
      case 3:
        return this.sportsCollection;
      case 2:
        return this.goingOutForGoodTimeCollection;
      case 1:
        return this.vehicleCollection;
      case 0:
        break;
    } 
    return this.shoppingCollection;
  }
  
  private String getDistanceAway(String paramString1, String paramString2) {
    double d1 = Double.parseDouble(this.sharedPreferences.getString("lat", ""));
    double d2 = Double.parseDouble(this.sharedPreferences.getString("lng", ""));
    double d3 = Double.parseDouble(paramString1);
    double d4 = Double.parseDouble(paramString2);
    double d5 = (d3 - d1) / 2.0D;
    double d6 = Math.sin(d5);
    d5 = Math.sin(d5);
    d1 = Math.cos(d1);
    d3 = Math.cos(d3);
    d2 = (d4 - d2) / 2.0D;
    d6 = d6 * d5 + d1 * d3 * Math.sin(d2) * Math.sin(d2);
    d6 = Math.ceil(Math.atan2(Math.sqrt(d6), Math.sqrt(1.0D - d6)) * 2.0D * 6371000.0D / 1609.344D);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.valueOf(d6));
    stringBuilder.append(" miles away");
    return stringBuilder.toString();
  }
  
  private String getFirstName(String paramString) {
    return paramString.split(" ")[0];
  }
  
  private Location getLastKnownLocation() {
    LocationManager locationManager = (LocationManager)getApplicationContext().getSystemService("location");
    Iterator<String> iterator = locationManager.getProviders(true).iterator();
    Location location = null;
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION"); 
      Location location1 = locationManager.getLastKnownLocation(str);
      if (location1 != null && (location == null || location1.getAccuracy() < location.getAccuracy()))
        location = location1; 
    } 
    return location;
  }
  
  private String getStrangerPic(String paramString) {
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
        return "";
      case 14:
        return downloadStrangerData(this.programmingProjectsCollection, paramString);
      case 13:
        return downloadStrangerData(this.engineeringProjectsCollection, paramString);
      case 12:
        return downloadStrangerData(this.canoeingCollection, paramString);
      case 11:
        return downloadStrangerData(this.videogamesCollection, paramString);
      case 10:
        return downloadStrangerData(this.studyingCollection, paramString);
      case 9:
        return downloadStrangerData(this.hikingCollection, paramString);
      case 8:
        return downloadStrangerData(this.travelingCollection, paramString);
      case 7:
        return downloadStrangerData(this.ventingCollection, paramString);
      case 6:
        return downloadStrangerData(this.filmProductionCollection, paramString);
      case 5:
        return downloadStrangerData(this.artworkArtistCollection, paramString);
      case 4:
        return downloadStrangerData(this.musicProductionCollection, paramString);
      case 3:
        return downloadStrangerData(this.sportsCollection, paramString);
      case 2:
        return downloadStrangerData(this.goingOutForGoodTimeCollection, paramString);
      case 1:
        return downloadStrangerData(this.vehicleCollection, paramString);
      case 0:
        break;
    } 
    return downloadStrangerData(this.shoppingCollection, paramString);
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
        } catch (Exception null) {}
      } catch (Exception null) {
        paramString1 = "";
      } 
    } catch (Exception exception) {
      paramString2 = "";
      paramString1 = paramString2;
    } 
    exception.printStackTrace();
    String str = "";
  }
  
  private void handleSwipe(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1 && !paramBoolean2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.swipeRightList);
      stringBuilder.append(",");
      stringBuilder.append(this.strangerId);
      this.swipeRightList = stringBuilder.toString();
      this.sharedPreferences.edit().putString("swipeRightList", this.swipeRightList).apply();
      if (!this.userRewinded) {
        this.rewindId = this.profileList.get(0);
        this.profileList.remove(0);
      } 
      if (this.profileList.size() == 0)
        this.mainFragmentCardView.setOnTouchListener(null); 
      if (this.userRewinded)
        this.userRewinded = false; 
      this.progressBar.setVisibility(0);
      paramBoolean1 = checkForMatch(this.strangerSwipedRightLine);
      this.progressBar.setVisibility(4);
      if (paramBoolean1) {
        Intent intent = new Intent((Context)this, Chat.class);
        intent.putExtra("userMatched", this.rewindId);
        addToChatList(this.rewindId);
        notifyStrangerOfMatch(this.rewindId);
        startActivity(intent);
        finish();
      } else {
        showStrangerPic();
        Animation animation = AnimationUtils.loadAnimation(context, 2130771998);
        this.mainFragmentCardView.startAnimation(animation);
        this.mainFragmentCardView.setVisibility(0);
      } 
    } else if (!paramBoolean1 && !paramBoolean2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.swipeLeftList);
      stringBuilder.append(",");
      stringBuilder.append(this.strangerId);
      this.swipeLeftList = stringBuilder.toString();
      this.sharedPreferences.edit().putString("swipeLeftList", this.swipeLeftList).apply();
      if (!this.userRewinded) {
        this.rewindId = this.profileList.get(0);
        this.profileList.remove(0);
      } 
      if (this.profileList.size() == 0)
        this.mainFragmentCardView.setOnTouchListener(null); 
      if (this.userRewinded)
        this.userRewinded = false; 
      showStrangerPic();
      Animation animation = AnimationUtils.loadAnimation(context, 2130771998);
      this.mainFragmentCardView.startAnimation(animation);
      this.mainFragmentCardView.setVisibility(0);
    } 
  }
  
  private void notifyStrangerOfMatch(String paramString) {
    final String[] newMatches = new String[1];
    final String[] chatUserList = new String[1];
    final String[] blockList = new String[1];
    this.user_auth_collection.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                newMatches[0] = queryDocumentSnapshot.getString("newMatches");
                if (queryDocumentSnapshot.getString("chatUsers") == null || ((String)Objects.<String>requireNonNull(queryDocumentSnapshot.getString("chatUsers"))).equals("")) {
                  chatUserList[0] = "";
                } else {
                  chatUserList[0] = queryDocumentSnapshot.getString("chatUsers");
                } 
                if (queryDocumentSnapshot.getString("blockList") != null && !queryDocumentSnapshot.getString("blockList").equals("")) {
                  blockList[0] = queryDocumentSnapshot.getString("blockList");
                  continue;
                } 
                blockList[0] = "";
              }  
          }
        });
    String str = arrayOfString2[0];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.sharedPreferences.getString("currentUser", ""));
    stringBuilder.append(",");
    str = stringBuilder.toString();
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("newMatches", "true");
    hashMap.put("chatUsers", str);
    hashMap.put("blockList", arrayOfString3[0]);
    this.user_auth_collection.document(paramString).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("strangerChatList", "succcess");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private ArrayList<String> queryStrangerIds(CollectionReference paramCollectionReference, String paramString1, String paramString2, String paramString3, String paramString4) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      EventListener<QuerySnapshot> eventListener;
      boolean bool = this.sharedPreferences.getString("gender", "both").equals("both");
      if (bool) {
        Query query = paramCollectionReference.whereEqualTo("category", this.sharedPreferences.getString("userCategory", "")).whereLessThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMax", "50")))).whereGreaterThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMin", "18"))));
        eventListener = new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                Log.d("emptyQuery", Objects.<String>requireNonNull(param1FirebaseFirestoreException.getMessage()));
                Toast.makeText((Context)MainActivity.this, "e is still null even though there is no log message", 0).show();
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  Log.d("profileQuery", Objects.<String>requireNonNull(queryDocumentSnapshot.getString("userId")));
                  Double double_1 = queryDocumentSnapshot.getDouble("lat");
                  Double double_2 = queryDocumentSnapshot.getDouble("lng");
                  String str1 = Objects.<String>requireNonNull(queryDocumentSnapshot.getString("userId"));
                  String str2 = queryDocumentSnapshot.getString("showMe");
                  Log.d("profileData", Objects.<String>requireNonNull(queryDocumentSnapshot.getString("showMe")));
                  Log.d("profileData", String.valueOf(Objects.requireNonNull(queryDocumentSnapshot.getDouble("lat"))));
                  Log.d("profileData", String.valueOf(Objects.requireNonNull(queryDocumentSnapshot.getDouble("lng"))));
                  pList.add(str1);
                  if (!str2.equals("true") || (double_1.doubleValue() >= Double.parseDouble(mSLine) && double_1.doubleValue() <= Double.parseDouble(mNLine) && double_2.doubleValue() >= Double.parseDouble(mWLine) && double_2.doubleValue() <= Double.parseDouble(mELine)))
                    continue; 
                  ArrayList arrayList = pList;
                  arrayList.remove(arrayList.indexOf(str1));
                } 
              } 
            }
          };
        super(this, arrayList, paramString1, paramString2, paramString3, paramString4);
        query.addSnapshotListener(eventListener);
      } else {
        Query query = eventListener.whereEqualTo("category", this.sharedPreferences.getString("userCategory", "")).whereLessThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMax", "50")))).whereGreaterThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMin", "18"))));
        eventListener = new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                Log.d("emptyQuery", Objects.<String>requireNonNull(param1FirebaseFirestoreException.getMessage()));
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  Double double_1 = queryDocumentSnapshot.getDouble("lat");
                  Double double_2 = queryDocumentSnapshot.getDouble("lng");
                  String str1 = queryDocumentSnapshot.getString("userId");
                  String str2 = queryDocumentSnapshot.getString("showMe");
                  queryDocumentSnapshot.getString("genderPref");
                  pList.add(str1);
                  if (!str2.equals("true") || (double_1.doubleValue() >= Double.parseDouble(mSLine) && double_1.doubleValue() <= Double.parseDouble(mNLine) && double_2.doubleValue() >= Double.parseDouble(mWLine) && double_2.doubleValue() <= Double.parseDouble(mELine)))
                    continue; 
                  ArrayList arrayList = pList;
                  arrayList.remove(arrayList.indexOf(str1));
                } 
              } 
            }
          };
        super(this, arrayList, paramString1, paramString2, paramString3, paramString4);
        query.addSnapshotListener(eventListener);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return arrayList;
  }
  
  private ArrayList<String> queryStrangersWithBolts(CollectionReference paramCollectionReference, String paramString1, String paramString2, String paramString3, String paramString4) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      Query query;
      boolean bool = this.sharedPreferences.getString("gender", "both").equals("both");
      if (bool) {
        query = paramCollectionReference.whereEqualTo("category", this.sharedPreferences.getString("userCategory", "")).whereLessThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMax", "50")))).whereGreaterThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMin", "18"))));
        EventListener<QuerySnapshot> eventListener = new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                Log.d("emptyQuery", Objects.<String>requireNonNull(param1FirebaseFirestoreException.getMessage()));
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  Double double_2 = queryDocumentSnapshot.getDouble("lat");
                  Double double_1 = queryDocumentSnapshot.getDouble("lng");
                  String str = queryDocumentSnapshot.getString("userId");
                  if (queryDocumentSnapshot.getString("showMe").equals("true") && double_2.doubleValue() >= Double.parseDouble(mSLine) && double_2.doubleValue() <= Double.parseDouble(mNLine) && double_1.doubleValue() >= Double.parseDouble(mWLine) && double_1.doubleValue() <= Double.parseDouble(mELine))
                    pList.add(str); 
                } 
              } 
            }
          };
        super(this, paramString1, paramString2, paramString3, paramString4, arrayList);
        query.addSnapshotListener(eventListener);
      } else {
        Query query1 = query.whereEqualTo("category", this.sharedPreferences.getString("userCategory", "")).whereLessThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMax", "50")))).whereGreaterThanOrEqualTo("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("ageMin", "18"))));
        EventListener<QuerySnapshot> eventListener = new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null) {
                Log.d("emptyQuery", Objects.<String>requireNonNull(param1FirebaseFirestoreException.getMessage()));
              } else if (!param1QuerySnapshot.isEmpty()) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  Double double_2 = queryDocumentSnapshot.getDouble("lat");
                  Double double_1 = queryDocumentSnapshot.getDouble("lng");
                  String str2 = queryDocumentSnapshot.getString("userId");
                  String str3 = queryDocumentSnapshot.getString("showMe");
                  String str1 = queryDocumentSnapshot.getString("genderPref");
                  if (str3.equals("true") && str1.equals(MainActivity.this.sharedPreferences.getString("gender", "both")) && double_2.doubleValue() >= Double.parseDouble(mSLine) && double_2.doubleValue() <= Double.parseDouble(mNLine) && double_1.doubleValue() >= Double.parseDouble(mWLine) && double_1.doubleValue() <= Double.parseDouble(mELine))
                    pList.add(str2); 
                } 
              } 
            }
          };
        super(this, paramString1, paramString2, paramString3, paramString4, arrayList);
        query1.addSnapshotListener(eventListener);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return arrayList;
  }
  
  private ArrayList<String> retrieveList() {
    new ArrayList();
    new ArrayList();
    new ArrayList();
    ArrayList<String> arrayList1 = new ArrayList();
    double d1 = Double.parseDouble(this.sharedPreferences.getString("lat", ""));
    double d2 = Double.parseDouble(this.sharedPreferences.getString("lng", ""));
    double d3 = changeInLat(Integer.parseInt(this.sharedPreferences.getString("distanceLimit", "50")));
    double d4 = Math.toRadians(d1 + d3);
    d1 = Math.toRadians(d1 - d3);
    double d5 = changeInLng(d4, Integer.parseInt(this.sharedPreferences.getString("distanceLimit", "50")));
    d3 = Math.toRadians(d2 - d5);
    d2 = Math.toRadians(d2 + d5);
    String str1 = String.valueOf(d4);
    String str2 = String.valueOf(d1);
    String str3 = String.valueOf(d2);
    String str4 = String.valueOf(d3);
    CollectionReference collectionReference = getCategoryToQuery();
    ArrayList<String> arrayList3 = queryStrangersWithBolts(collectionReference, str2, str1, str4, str3);
    ArrayList<String> arrayList2 = queryStrangerIds(collectionReference, str2, str1, str4, str3);
    if (arrayList2 == null || arrayList2.size() == 0)
      Toast.makeText(context, "The querying for stranger ids is not working", 1).show(); 
    arrayList2 = checkPeopleAlreadySwiped(arrayList2);
    Collections.shuffle(arrayList2);
    arrayList1.addAll(arrayList3);
    arrayList1.addAll(arrayList2);
    if (arrayList1.size() == 0)
      this.noStrangersLeftTextView.setVisibility(0); 
    return arrayList1;
  }
  
  private void runMainLogic() {
    checkCurrentBoltStatus();
    this.progressBar.setVisibility(0);
    this.firebaseAuth = FirebaseAuth.getInstance();
    if (this.sharedPreferences.getString("login", "").equals("true")) {
      downloadUserData();
      if (this.sharedPreferences.getString("currentLocation", "").equals("true"))
        this.sharedPreferences.edit().putString("lat", this.latString).putString("lng", this.lngString).putString("userLocation", getUserCity(this.latString, this.lngString)).apply(); 
      if (this.sharedPreferences.getString("newMessages", "false").equals("true"))
        this.exclamation.setAlpha(1.0F); 
      updateUserData();
      updateUserCollection();
      this.profileList = retrieveList();
      showStrangerPic();
      this.progressBar.setVisibility(4);
    } else {
      this.sharedPreferences.edit().putString("login", "true").apply();
      this.sharedPreferences.edit().putString("distanceLimit", "50").putString("ageMin", "18").putString("ageMax", "50").putString("newMessages", "false").putString("settingsShowMe", "true").putString("paymentOptionActive", "false").putString("notificationsActive", "true").putString("lat", this.latString).putString("lng", this.lngString).apply();
      stopService(new Intent((Context)this, signUpProcessService.class));
      String str = getUserCity(this.latString, this.lngString);
      this.sharedPreferences.edit().putString("userLocation", str).apply();
      updateUserData();
      updateUserCollection();
      startService(new Intent((Context)this, NotificationService.class));
      this.profileList = retrieveList();
      showStrangerPic();
      this.progressBar.setVisibility(4);
    } 
  }
  
  private void sendWelcomeEmail() {
    char[] arrayOfChar = getString(2131689737).toCharArray();
    StringBuilder stringBuilder1 = new StringBuilder();
    for (byte b = 0; b < arrayOfChar.length; b++) {
      if (arrayOfChar[b] != '!')
        stringBuilder1.append(arrayOfChar[b]); 
    } 
    String str1 = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(getString(2131689595));
    stringBuilder1.append(": ");
    stringBuilder1.append(getString(2131689719));
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(this.sharedPreferences.getString("name", ""));
    stringBuilder2.append("!");
    String str3 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append(" ");
    stringBuilder3.append(this.sharedPreferences.getString("name", ""));
    stringBuilder3.append("!,\n\n");
    stringBuilder3.append(getString(2131689628));
    stringBuilder3.append(": ");
    stringBuilder3.append(this.sharedPreferences.getString("securityKey", ""));
    String str4 = stringBuilder3.toString();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str1.toUpperCase());
    stringBuilder4.append(" ");
    stringBuilder4.append(getString(2131689595));
    str1 = stringBuilder4.toString();
    Intent intent = new Intent("android.intent.action.SEND");
    intent.setType("message/rfc822");
    intent.putExtra("android.intent.extra.EMAIL", new String[] { this.sharedPreferences.getString("email", "") });
    intent.putExtra("android.intent.extra.SUBJECT", str3);
    intent.putExtra("android.intent.extra.TEXT", str4);
    try {
      startActivity(Intent.createChooser(intent, str1));
    } catch (ActivityNotFoundException activityNotFoundException) {
      Toast.makeText((Context)this, str2, 0).show();
    } 
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
          this.bottomSheet.setBackgroundResource(2131230815);
        case 13:
          this.linearLayout.setBackgroundResource(2131230897);
          this.bottomSheet.setBackgroundResource(2131230897);
        case 12:
          this.linearLayout.setBackgroundResource(2131230910);
          this.bottomSheet.setBackgroundResource(2131230910);
        case 11:
          this.linearLayout.setBackgroundResource(2131230902);
          this.bottomSheet.setBackgroundResource(2131230902);
        case 10:
          this.linearLayout.setBackgroundResource(2131230816);
          this.bottomSheet.setBackgroundResource(2131230816);
        case 9:
          this.linearLayout.setBackgroundResource(2131230903);
          this.bottomSheet.setBackgroundResource(2131230903);
        case 8:
          this.linearLayout.setBackgroundResource(2131230904);
          this.bottomSheet.setBackgroundResource(2131230904);
        case 7:
          this.linearLayout.setBackgroundResource(2131230895);
          this.bottomSheet.setBackgroundResource(2131230895);
        case 6:
          this.linearLayout.setBackgroundResource(2131230823);
          this.bottomSheet.setBackgroundResource(2131230823);
        case 5:
          this.linearLayout.setBackgroundResource(2131230867);
          this.bottomSheet.setBackgroundResource(2131230867);
        case 4:
          this.linearLayout.setBackgroundResource(2131230818);
          this.bottomSheet.setBackgroundResource(2131230818);
        case 3:
          this.linearLayout.setBackgroundResource(2131230877);
          this.bottomSheet.setBackgroundResource(2131230877);
        case 2:
          this.linearLayout.setBackgroundResource(2131230864);
          this.bottomSheet.setBackgroundResource(2131230864);
        case 1:
          this.linearLayout.setBackgroundResource(2131230879);
          this.bottomSheet.setBackgroundResource(2131230879);
        case 0:
          break;
      } 
      this.linearLayout.setBackgroundResource(2131230878);
      this.bottomSheet.setBackgroundResource(2131230878);
    } 
    this.linearLayout.setBackgroundResource(2131230855);
    this.bottomSheet.setBackgroundResource(2131230855);
    this.logo.setBackgroundResource(2131230833);
    this.noStrangersLeftTextView.setTextColor(-1);
    this.nameAgeTextView.setTextColor(-1);
    this.mainBioTextView.setTextColor(-1);
    this.bottomBioTextView.setTextColor(-1);
    this.locationTextView.setTextColor(-1);
    this.cityTextView.setTextColor(-1);
    this.chatTextView.setTextColor(-1);
    this.settingsButton.setBackgroundResource(2131230821);
    this.settingsButton.setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  private void showActualPic(String paramString) {
    paramString = getStrangerPic(paramString);
    if (!paramString.equals("")) {
      String str1;
      String str2;
      String str3;
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString.length == 3) {
        str2 = arrayOfString[0];
        str3 = arrayOfString[1];
        str1 = arrayOfString[2];
      } else if (str1.length == 2) {
        str2 = str1[0];
        str3 = str1[1];
        str1 = "";
      } else {
        str2 = str1[0];
        str3 = "";
        str1 = str3;
      } 
      if (str3.equals("") && str1.equals("")) {
        (new GetImageFromUrl(this.fragmentBackground)).execute((Object[])new String[] { str2 });
        (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { str2 });
      } else if (str1.equals("")) {
        (new GetImageFromUrl(this.fragmentBackground)).execute((Object[])new String[] { str2 });
        (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { str2 });
        (new GetImageFromUrl(this.middlePic)).execute((Object[])new String[] { str3 });
      } else {
        (new GetImageFromUrl(this.fragmentBackground)).execute((Object[])new String[] { str2 });
        (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { str2 });
        (new GetImageFromUrl(this.middlePic)).execute((Object[])new String[] { str3 });
        (new GetImageFromUrl(this.rightPic)).execute((Object[])new String[] { str1 });
      } 
    } else {
      showStrangerPic();
    } 
  }
  
  private void showStrangerPic() {
    ArrayList<String> arrayList = this.profileList;
    if (arrayList != null && arrayList.size() > 0) {
      this.noStrangersLeftTextView.setVisibility(4);
      this.strangerId = this.profileList.get(0);
      showActualPic(this.strangerId);
    } else {
      this.noStrangersLeftTextView.setVisibility(0);
    } 
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
  
  private void updateUserData() {
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
    if (paramCollectionReference != null) {
      this.sharedPreferences.edit().putString("swipeRightList", this.swipeRightList).putString("swipeLeftList", this.swipeLeftList).apply();
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
      NumberFormat numberFormat = NumberFormat.getInstance();
      try {
        hashMap.put("age", Double.valueOf(numberFormat.parse(this.sharedPreferences.getString("age", "20")).doubleValue()));
        hashMap.put("lat", Double.valueOf(numberFormat.parse(this.sharedPreferences.getString("lat", "")).doubleValue()));
        hashMap.put("lng", Double.valueOf(numberFormat.parse(this.sharedPreferences.getString("lng", "")).doubleValue()));
      } catch (ParseException parseException) {
        parseException.printStackTrace();
        Log.d("emptyQuery", Objects.<String>requireNonNull(parseException.getMessage()));
      } 
      paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.d("updateUserData", "success");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {}
          });
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    finish();
  }
  
  public void onBoltClicked(View paramView) {
    if (this.sharedPreferences.getString("bolt", "false").equals("false")) {
      this.boltButton.animate().rotation(360.0F).setDuration(1000L);
      startActivity(new Intent((Context)this, BoltPayment.class));
      finish();
    } else {
      Toast.makeText((Context)this, getString(2131689717), 0).show();
    } 
  }
  
  public void onChatClicked(View paramView) {
    startActivity(new Intent((Context)this, Chat.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492897);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    context = getApplicationContext();
    this.progressBar = (ProgressBar)findViewById(2131296520);
    this.noStrangersLeftTextView = (TextView)findViewById(2131296575);
    this.logo = (ImageView)findViewById(2131296523);
    this.fragmentBackground = (ImageView)findViewById(2131296464);
    this.leftPic = (ImageView)findViewById(2131296345);
    this.middlePic = (ImageView)findViewById(2131296346);
    this.rightPic = (ImageView)findViewById(2131296347);
    this.nameAgeTextView = (TextView)findViewById(2131296567);
    this.mainBioTextView = (TextView)findViewById(2131296524);
    this.bottomBioTextView = (TextView)findViewById(2131296339);
    this.locationTextView = (TextView)findViewById(2131296466);
    this.cityTextView = (TextView)findViewById(2131296465);
    this.chatTextView = (TextView)findViewById(2131296386);
    this.strangerView = (ConstraintLayout)findViewById(2131296262);
    this.rightOrLeftText = (TextView)findViewById(2131296614);
    this.exclamation = (ImageView)findViewById(2131296445);
    this.settingsButton = (ImageButton)findViewById(2131296763);
    this.boltButton = (ImageButton)findViewById(2131296516);
    this.rewindButton = (ImageButton)findViewById(2131296521);
    this.linearLayout = (LinearLayout)findViewById(2131296519);
    this.mainFragmentCardView = (CardView)findViewById(2131296517);
    this.bottomSheet = findViewById(2131296343);
    this.bottomSheetBehavior = BottomSheetBehavior.from(this.bottomSheet);
    this.userId = this.sharedPreferences.getString("currentUser", "");
    if (this.userId.equals("")) {
      startActivity(new Intent((Context)this, LogInScreen.class));
      finish();
    } 
    this.userRewinded = false;
    setColor();
    this.powerManager = (PowerManager)getSystemService("power");
    this.locationManager = (LocationManager)getSystemService("location");
    this.locationListener = new LocationListener() {
        public void onLocationChanged(Location param1Location) {
          if (MainActivity.this.sharedPreferences.getString("currentLocation", "").equals("true")) {
            MainActivity.access$102(MainActivity.this, String.valueOf(param1Location.getLatitude()));
            MainActivity.access$202(MainActivity.this, String.valueOf(param1Location.getLongitude()));
          } 
        }
        
        public void onProviderDisabled(String param1String) {}
        
        public void onProviderEnabled(String param1String) {}
        
        public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
      };
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.height = displayMetrics.heightPixels;
    this.width = displayMetrics.widthPixels;
    this.swipeRightList = "";
    this.swipeLeftList = "";
    this.linearLayout.setOnTouchListener(new OnSwipeTouchListener((Context)this) {
          public boolean onSwipeBottom() {
            return true;
          }
          
          public boolean onSwipeLeft() {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.context, 2130771997);
            MainActivity.this.mainFragmentCardView.startAnimation(animation);
            MainActivity.this.mainFragmentCardView.setVisibility(4);
            return true;
          }
          
          public boolean onSwipeRight() {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.context, 2130771999);
            MainActivity.this.mainFragmentCardView.startAnimation(animation);
            MainActivity.this.mainFragmentCardView.setVisibility(4);
            return true;
          }
          
          public boolean onSwipeTop() {
            return true;
          }
        });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(2131558400, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.sharedPreferences.edit().putString("swipeRightList", this.swipeRightList).putString("swipeLeftList", this.swipeLeftList).apply();
    this.locationManager.removeUpdates(this.locationListener);
  }
  
  public void onInfoButtonClicked(View paramView) {
    this.bottomSheetBehavior.setState(3);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      finish();
      return true;
    } 
    return false;
  }
  
  public void onMainSwitchButtonClicked(View paramView) {
    this.bottomSheetBehavior.setState(4);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    switch (paramMenuItem.getItemId()) {
      default:
        return super.onOptionsItemSelected(paramMenuItem);
      case 2131296545:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "videogames").apply();
        uploadUserData(this.videogamesCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296544:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "ventFrustration").apply();
        uploadUserData(this.ventingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296543:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "vehicles").apply();
        uploadUserData(this.vehicleCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296542:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "travel").apply();
        uploadUserData(this.travelingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296541:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "studying").apply();
        uploadUserData(this.studyingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296540:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "sports").apply();
        uploadUserData(this.sportsCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296539:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "shopping").apply();
        uploadUserData(this.shoppingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296538:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "programmingProjects").apply();
        uploadUserData(this.programmingProjectsCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296537:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "musicProduction").apply();
        uploadUserData(this.musicProductionCollection);
        updateUserCollection();
      case 2131296536:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "hiking").apply();
        uploadUserData(this.hikingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296535:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "goingOut").apply();
        uploadUserData(this.goingOutForGoodTimeCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296534:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "filmProduction").apply();
        uploadUserData(this.filmProductionCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296533:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "engineeringProjects").apply();
        uploadUserData(this.engineeringProjectsCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296532:
        deleteUserFromCurrentCollection();
        this.sharedPreferences.edit().putString("userCategory", "canoeing").apply();
        uploadUserData(this.canoeingCollection);
        updateUserCollection();
        ActivityCompat.recreate((Activity)this);
      case 2131296531:
        break;
    } 
    deleteUserFromCurrentCollection();
    this.sharedPreferences.edit().putString("userCategory", "artwork").apply();
    uploadUserData(this.artworkArtistCollection);
    updateUserCollection();
    ActivityCompat.recreate((Activity)this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    if (paramArrayOfint.length > 0 && paramArrayOfint[0] == 0 && ContextCompat.checkSelfPermission((Context)this, "android.permission.ACCESS_FINE_LOCATION") == 0)
      this.locationManager.requestLocationUpdates("gps", 0L, 0.0F, this.locationListener); 
  }
  
  protected void onResume() {
    super.onResume();
    Location location = getLastKnownLocation();
    this.latString = String.valueOf(location.getLatitude());
    this.lngString = String.valueOf(location.getLongitude());
    runMainLogic();
  }
  
  public void onRewindClicked(View paramView) {
    if (this.sharedPreferences.getString("chatter", "").equals("true"))
      if (this.userRewinded) {
        Toast.makeText((Context)this, 2131689745, 0).show();
      } else if (this.rewindId.equals("")) {
        Toast.makeText((Context)this, 2131689718, 0).show();
      } else {
        this.userRewinded = true;
        this.rewindButton.animate().rotation(-360.0F).setDuration(1000L);
        showActualPic(this.rewindId);
        this.fragmentBackground.animate().translationX(-1000.0F).setDuration(10L);
        this.fragmentBackground.animate().translationX(1000.0F).setDuration(500L);
      }  
  }
  
  public void onSettingsButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, Settings.class));
    finish();
  }
  
  protected void onStart() {
    super.onStart();
  }
  
  class DropZoneListener implements View.OnDragListener {
    public boolean onDrag(View param1View, DragEvent param1DragEvent) {
      param1View = (View)param1DragEvent.getLocalState();
      int i = param1DragEvent.getAction();
      if (i != 1 && i != 3)
        if (i != 4) {
          if (i == 5) {
            param1View = (View)param1DragEvent.getLocalState();
            if (param1DragEvent.getX() < MainActivity.this.width / 2.0D) {
              MainActivity.this.rightOrLeftText.setTextColor(-65536);
              MainActivity.this.rightOrLeftText.setText(2131689647);
            } else {
              MainActivity.this.rightOrLeftText.setTextColor(-16711936);
              MainActivity.this.rightOrLeftText.setText(2131689742);
            } 
            int j = MainActivity.this.width / 2;
            int k = MainActivity.this.width / 2;
            i = MainActivity.this.width / 2;
            int m = MainActivity.this.width / 2;
            int n = MainActivity.this.width / 2;
            int i1 = MainActivity.this.width / 2;
            int i2 = MainActivity.this.width / 2;
            if (param1DragEvent.getX() == j) {
              MainActivity.this.rightOrLeftText.setAlpha(0.0F);
            } else {
              if (param1DragEvent.getX() == (k - 10) || param1DragEvent.getX() == (n + 10)) {
                MainActivity.this.rightOrLeftText.setAlpha(0.3F);
                return true;
              } 
              if (param1DragEvent.getX() == (i - 30) || param1DragEvent.getX() == (i1 + 30)) {
                MainActivity.this.rightOrLeftText.setAlpha(0.5F);
                return true;
              } 
              if (param1DragEvent.getX() == (m - 50) || param1DragEvent.getX() == (i2 + 50)) {
                MainActivity.this.rightOrLeftText.setAlpha(0.8F);
                return true;
              } 
              MainActivity.this.rightOrLeftText.setAlpha(1.0F);
            } 
          } 
        } else {
          View view;
          if (param1View.getWidth() / 2.0D < MainActivity.this.width / 2.0D) {
            view = (View)param1DragEvent.getLocalState();
            MainActivity.access$1502(MainActivity.this, false);
            param1View.setTranslationX(MainActivity.this.cardXTrans);
            param1View.setTranslationY(MainActivity.this.cardYTrans);
          } else {
            view = (View)view.getLocalState();
            MainActivity.access$1502(MainActivity.this, false);
            param1View.setTranslationX(MainActivity.this.cardXTrans);
            param1View.setTranslationY(MainActivity.this.cardYTrans);
          } 
          param1View.setVisibility(0);
          MainActivity.this.rightOrLeftText.animate().alphaBy(0.0F).setDuration(1000L);
          MainActivity.this.rightOrLeftText.setVisibility(4);
        }  
      return true;
    }
  }
  
  private final class ShadowTouchListener implements View.OnTouchListener {
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      if (param1MotionEvent.getAction() == 0) {
        param1View.startDragAndDrop(ClipData.newPlainText("", ""), new View.DragShadowBuilder(param1View), param1View, 0);
        param1View.animate().scaleX(-0.5F).scaleY(-0.5F).setDuration(1000L);
        param1View.setVisibility(4);
        return true;
      } 
      return false;
    }
  }
}
