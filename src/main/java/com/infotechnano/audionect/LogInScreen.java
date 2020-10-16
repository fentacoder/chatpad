package com.infotechnano.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.infotechnano.audionect.signUpProcess.SafetyTips;
import com.infotechnano.audionect.signUpProcess.StartUpScreen;

public class LogInScreen extends AppCompatActivity implements View.OnTouchListener, View.OnKeyListener {
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private FirebaseAuth.AuthStateListener authStateListener;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private Button createAcctButton;
  
  private FirebaseUser currentUser;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private AutoCompleteTextView emailEditText;
  
  private LinearLayout emailLoginForm;
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private FirebaseAuth firebaseAuth;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private InputMethodManager inputMethodManager;
  
  private Button loginButton;
  
  private ConstraintLayout loginLayout;
  
  private ProgressBar loginProgress;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private EditText passwordEditText;
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private SQLiteDatabase sqlDatabase;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private String swipeLeft = "INSERT INTO swipeLeft(usernamesLeft) VALUES (?)";
  
  private SQLiteStatement swipeLeftStatement;
  
  private String swipeRight = "INSERT INTO swipeRight(usernamesRight) VALUES (?)";
  
  private SQLiteStatement swipeRightStatement;
  
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
                LogInScreen.this.sharedPreferences.edit().putString("settingsShowMe", queryDocumentSnapshot.getString("showMe")).putString("currentUser", queryDocumentSnapshot.getString("userId")).putString("name", queryDocumentSnapshot.getString("name")).putString("age", String.valueOf(queryDocumentSnapshot.getLong("age"))).putString("bio", queryDocumentSnapshot.getString("bio")).putString("picturesList", queryDocumentSnapshot.getString("picturesList")).putString("userCategory", queryDocumentSnapshot.getString("category")).putString("userLocation", queryDocumentSnapshot.getString("city")).putString("urlList", queryDocumentSnapshot.getString("urlList")).putString("lat", String.valueOf(queryDocumentSnapshot.getDouble("lat"))).putString("lng", String.valueOf(queryDocumentSnapshot.getDouble("lng"))).putString("swipeRightList", queryDocumentSnapshot.getString("swipeRightList")).putString("swipeLeftList", queryDocumentSnapshot.getString("swipeLeftList")).apply(); 
            } 
          }
        });
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                LogInScreen.this.sharedPreferences.edit().putString("username", queryDocumentSnapshot.getString("username")).putString("password", queryDocumentSnapshot.getString("password")).putString("email", queryDocumentSnapshot.getString("email")).putString("gender", queryDocumentSnapshot.getString("genderPref")).putString("genderId", queryDocumentSnapshot.getString("genderId")).putString("securityKey", queryDocumentSnapshot.getString("securityKey")).putString("notificationsActive", queryDocumentSnapshot.getString("notificationFlag")).putString("chatter", queryDocumentSnapshot.getString("chatterPlan")).putString("extrovert", queryDocumentSnapshot.getString("extrovertPlan")).putString("platinum", queryDocumentSnapshot.getString("platinumPlan")).putString("newMessages", queryDocumentSnapshot.getString("newMessages")).putString("newMatches", queryDocumentSnapshot.getString("newMatches")).putString("chatList", queryDocumentSnapshot.getString("chatList")).putString("blockList", queryDocumentSnapshot.getString("blockList")).putString("bolt", queryDocumentSnapshot.getString("bolt")).putString("boltPeriod", queryDocumentSnapshot.getString("boltPeriod")).putString("paymentActive", queryDocumentSnapshot.getString("paymentOption")).putString("paymentToken", queryDocumentSnapshot.getString("paymentToken")).apply(); 
            } 
          }
        });
    String[] arrayOfString2 = this.sharedPreferences.getString("picturesList", "").split(",");
    String[] arrayOfString1 = this.sharedPreferences.getString("urlList", "").split(",");
    int i = arrayOfString2.length;
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          this.sharedPreferences.edit().putString("leftPicTitle", arrayOfString2[0]).putString("leftPicture", arrayOfString1[0]).putString("middlePicTitle", arrayOfString2[1]).putString("middlePicture", arrayOfString1[1]).putString("rightPicTitle", arrayOfString2[2]).putString("rightPicture", arrayOfString1[2]).apply(); 
      } else {
        this.sharedPreferences.edit().putString("leftPicTitle", arrayOfString2[0]).putString("leftPicture", arrayOfString1[0]).putString("middlePicTitle", arrayOfString2[1]).putString("middlePicture", arrayOfString1[1]).apply();
      } 
    } else {
      this.sharedPreferences.edit().putString("leftPicTitle", arrayOfString2[0]).putString("leftPicture", arrayOfString1[0]).apply();
    } 
  }
  
  private void downloadUserData() {
    try {
      switch (this.sharedPreferences.getString("userCategory", "")) {
        default:
          return;
        case "programmingProjects":
          downloadDataFromServer(this.programmingProjectsCollection);
        case "engineeringProjects":
          downloadDataFromServer(this.engineeringProjectsCollection);
        case "canoeing":
          downloadDataFromServer(this.canoeingCollection);
        case "videogames":
          downloadDataFromServer(this.videogamesCollection);
        case "studying":
          downloadDataFromServer(this.studyingCollection);
        case "hiking":
          downloadDataFromServer(this.hikingCollection);
        case "travel":
          downloadDataFromServer(this.travelingCollection);
        case "ventFrustration":
          downloadDataFromServer(this.ventingCollection);
        case "filmProduction":
          downloadDataFromServer(this.filmProductionCollection);
        case "artwork":
          downloadDataFromServer(this.artworkArtistCollection);
        case "musicProduction":
          downloadDataFromServer(this.musicProductionCollection);
        case "sports":
          downloadDataFromServer(this.sportsCollection);
        case "goingOut":
          downloadDataFromServer(this.goingOutForGoodTimeCollection);
        case "vehicles":
          downloadDataFromServer(this.vehicleCollection);
        case "shopping":
          break;
      } 
      downloadDataFromServer(this.shoppingCollection);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void getCategoryFromUserCollection() {
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                LogInScreen.this.sharedPreferences.edit().putString("userCategory", queryDocumentSnapshot.getString("category")).apply();  
          }
        });
  }
  
  private void loginEmailPasswordUser(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      if (FirebaseAuth.getInstance().getCurrentUser() != null)
        this.firebaseAuth.signOut(); 
      this.firebaseAuth.signInWithEmailAndPassword(paramString1, paramString2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> param1Task) {
              if (param1Task.isSuccessful()) {
                LogInScreen.this.loginProgress.setVisibility(0);
                String str = FirebaseAuth.getInstance().getCurrentUser().getUid();
                LogInScreen.this.sharedPreferences.edit().putString("currentUser", str).apply();
                LogInScreen.this.getCategoryFromUserCollection();
                LogInScreen.this.downloadUserData();
                if (!LogInScreen.this.sharedPreferences.getString("name", "").equals("")) {
                  LogInScreen.this.sharedPreferences.edit().putString("login", "true").apply();
                  if ((LogInScreen.this.sharedPreferences.getString("extrovert", "").equals("true") || LogInScreen.this.sharedPreferences.getString("platinum", "").equals("true")) && !LogInScreen.this.sharedPreferences.getString("userLocation", "").equals(""))
                    LogInScreen.this.sharedPreferences.edit().putString("currentLocation", "true").apply(); 
                  LogInScreen.this.loginProgress.setVisibility(4);
                  if (LogInScreen.this.sharedPreferences.getString("distanceLimit", "").equals(""))
                    LogInScreen.this.sharedPreferences.edit().putString("distanceLimit", "50").apply(); 
                  if (LogInScreen.this.sharedPreferences.getString("ageMin", "").equals(""))
                    LogInScreen.this.sharedPreferences.edit().putString("ageMin", "18").apply(); 
                  if (LogInScreen.this.sharedPreferences.getString("ageMax", "").equals(""))
                    LogInScreen.this.sharedPreferences.edit().putString("ageMax", "50").apply(); 
                  LogInScreen logInScreen = LogInScreen.this;
                  logInScreen.startActivity(new Intent((Context)logInScreen, MainActivity.class));
                  LogInScreen.this.finish();
                } 
              } else {
                LogInScreen.this.loginProgress.setVisibility(4);
              } 
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {
              Toast.makeText((Context)LogInScreen.this, param1Exception.getMessage(), 1).show();
            }
          });
    } else {
      Toast.makeText((Context)this, 2131689674, 1).show();
    } 
  }
  
  private void restoreSqlDatabase() {
    byte b3;
    String[] arrayOfString1 = this.sharedPreferences.getString("swipeRightList", "").trim().split(",");
    String[] arrayOfString2 = this.sharedPreferences.getString("swipeLeftList", "").trim().split(",");
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < arrayOfString1.length) {
        this.swipeRightStatement.bindString(1, arrayOfString1[b2]);
        this.swipeRightStatement.executeInsert();
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < arrayOfString2.length) {
      this.swipeLeftStatement.bindString(1, arrayOfString2[b3]);
      this.swipeLeftStatement.executeInsert();
      b3++;
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492896);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.firebaseAuth = FirebaseAuth.getInstance();
    this.sqlDatabase = openOrCreateDatabase("database", 0, null);
    this.sqlDatabase.execSQL("CREATE TABLE IF NOT EXISTS swipeRight(usernamesRight VARCHAR)");
    this.sqlDatabase.execSQL("CREATE TABLE IF NOT EXISTS swipeLeft(usernamesLeft VARCHAR)");
    this.swipeRightStatement = this.sqlDatabase.compileStatement(this.swipeRight);
    this.swipeLeftStatement = this.sqlDatabase.compileStatement(this.swipeLeft);
    this.loginButton = (Button)findViewById(2131296440);
    this.createAcctButton = (Button)findViewById(2131296409);
    this.passwordEditText = (EditText)findViewById(2131296589);
    this.emailEditText = (AutoCompleteTextView)findViewById(2131296437);
    this.loginProgress = (ProgressBar)findViewById(2131296515);
    this.emailLoginForm = (LinearLayout)findViewById(2131296439);
    this.loginLayout = (ConstraintLayout)findViewById(2131296513);
    this.loginLayout.setOnTouchListener(this);
    this.emailEditText.setOnKeyListener(this);
    this.authStateListener = new FirebaseAuth.AuthStateListener() {
        public void onAuthStateChanged(FirebaseAuth param1FirebaseAuth) {
          LogInScreen.access$002(LogInScreen.this, param1FirebaseAuth.getCurrentUser());
        }
      };
  }
  
  public void onCreateAcctButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, SafetyTips.class));
    finish();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    FirebaseAuth firebaseAuth = this.firebaseAuth;
    if (firebaseAuth != null)
      firebaseAuth.removeAuthStateListener(this.authStateListener); 
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 66) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.passwordEditText.getWindowToken(), 0);
      return true;
    } 
    if (paramInt == 4) {
      onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public void onLoginBackButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  public void onLoginClicked(View paramView) {
    AutoCompleteTextView autoCompleteTextView = this.emailEditText;
    if (autoCompleteTextView != null && this.passwordEditText != null)
      loginEmailPasswordUser(autoCompleteTextView.getText().toString().trim(), this.passwordEditText.getText().toString().trim()); 
  }
  
  public void onLoginForgotPasswordButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, ForgotPasswordScreen.class));
    finish();
  }
  
  protected void onStart() {
    super.onStart();
  }
  
  protected void onStop() {
    super.onStop();
    FirebaseAuth firebaseAuth = this.firebaseAuth;
    if (firebaseAuth != null)
      firebaseAuth.removeAuthStateListener(this.authStateListener); 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramView.getId() == 2131296513 || paramView.getId() == 2131296439 || paramView.getId() == 2131296515) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.passwordEditText.getWindowToken(), 0);
    } 
    return true;
  }
}
