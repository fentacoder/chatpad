package com.infotechnano.audionect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.infotechnano.audionect.signUpProcess.SafetyTips;
import com.infotechnano.audionect.signUpProcess.StartUpScreen;
import java.util.HashMap;
import util.Person;

public class Settings extends AppCompatActivity implements View.OnClickListener {
  private int ageMaxNum;
  
  private SeekBar ageMaxSeekBar;
  
  private String ageMaxString;
  
  private TextView ageMaxTextView;
  
  private int ageMinNum;
  
  private SeekBar ageMinSeekBar;
  
  private String ageMinString;
  
  private TextView ageMinTextView;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private FirebaseAuth.AuthStateListener authStateListener;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private RelativeLayout categoryFrameView;
  
  private RelativeLayout changeColorFrameView;
  
  private RelativeLayout changePasswordFrameView;
  
  private String city;
  
  private TextView currentLocationTextView;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private RelativeLayout deleteAccountFrameView;
  
  private String distance;
  
  private SeekBar distanceSeekBar;
  
  private RelativeLayout editPicturesFrameView;
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private FirebaseAuth firebaseAuth;
  
  private FirebaseUser firebaseUser;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private LinearLayout linearLayout;
  
  private RelativeLayout locationFrameView;
  
  private TextView locationTextView;
  
  private RelativeLayout logOutFrameView;
  
  private TextView maximumDistanceTextView;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private Switch notificationSwitch;
  
  private RelativeLayout paymentFrameView;
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private RelativeLayout resetSwipesFrameView;
  
  private RelativeLayout safetyTipsFrameView;
  
  private Button settingsButton;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private Switch showMeSwitch;
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private SQLiteDatabase sqLiteDatabase;
  
  private StorageReference storageReference;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private RelativeLayout switchGenderPrefFrameView;
  
  private RelativeLayout termsAndPrivacyFrameView;
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private void clearLeftUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("LeftPics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void clearMiddleUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("MiddlePics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void clearRightUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("RightPics").child(this.sharedPreferences.getString("currentUser", "")).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void deleteSqlTables() {
    this.sqLiteDatabase.execSQL("DROP TABLE IF EXISTS swipeRight");
    this.sqLiteDatabase.execSQL("DROP TABLE IF EXISTS swipeLeft");
  }
  
  private void downloadUserData() {
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                Settings.this.sharedPreferences.edit().putString("userCategory", queryDocumentSnapshot.getString("category")).apply(); 
            } 
          }
        });
  }
  
  private void setColor() {
    if (this.sharedPreferences.getString("darkMode", "false").equals("false")) {
      switch (this.sharedPreferences.getString("colorSelect", "")) {
        default:
          return;
        case "beige":
          this.linearLayout.setBackgroundResource(2131230815);
        case "pink":
          this.linearLayout.setBackgroundResource(2131230897);
        case "violet":
          this.linearLayout.setBackgroundResource(2131230910);
        case "purple":
          this.linearLayout.setBackgroundResource(2131230902);
        case "blaze":
          this.linearLayout.setBackgroundResource(2131230816);
        case "red":
          this.linearLayout.setBackgroundResource(2131230903);
        case "salmon":
          this.linearLayout.setBackgroundResource(2131230904);
        case "orange":
          this.linearLayout.setBackgroundResource(2131230895);
        case "brown":
          this.linearLayout.setBackgroundResource(2131230823);
        case "gray":
          this.linearLayout.setBackgroundResource(2131230867);
        case "blue":
          this.linearLayout.setBackgroundResource(2131230818);
        case "light blue":
          this.linearLayout.setBackgroundResource(2131230877);
        case "gold":
          this.linearLayout.setBackgroundResource(2131230864);
        case "yellow":
          this.linearLayout.setBackgroundResource(2131230879);
        case "green":
          break;
      } 
      this.linearLayout.setBackgroundResource(2131230878);
    } 
    this.linearLayout.setBackgroundResource(2131230855);
    this.settingsButton.setBackgroundResource(2131230854);
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
            Log.d("updateUserData", "success");
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
  
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  public void onClick(View paramView) {
    FirebaseAuth firebaseAuth;
    switch (paramView.getId()) {
      default:
        return;
      case 2131296683:
        startActivity(new Intent((Context)this, TermsPrivacyPolicyPage.class));
        finish();
      case 2131296681:
        startActivity(new Intent((Context)this, GenderChoice.class));
        finish();
      case 2131296680:
        startActivity(new Intent((Context)this, CategorySwitcher.class));
        finish();
      case 2131296674:
        startActivity(new Intent((Context)this, SafetyTips.class));
        finish();
      case 2131296672:
        (new AlertDialog.Builder((Context)this)).setTitle(2131689524).setMessage(getString(2131689704)).setPositiveButton(2131689742, new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Settings.this.deleteSqlTables();
                Settings.this.updateUserData();
              }
            }).setNegativeButton(2131689647, new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            }).create().show();
      case 2131296670:
        startActivity(new Intent((Context)this, PaymentSetUp.class));
        finish();
      case 2131296663:
      case 2131296664:
        stopService(new Intent((Context)this, NotificationService.class));
        this.sharedPreferences.edit().putString("login", "false").putString("currentUser", "").apply();
        this.firebaseAuth.signOut();
        firebaseAuth = this.firebaseAuth;
        if (firebaseAuth != null)
          firebaseAuth.removeAuthStateListener(this.authStateListener); 
        startActivity(new Intent((Context)this, StartUpScreen.class));
        finish();
      case 2131296661:
        startActivity(new Intent((Context)this, LocationChooser.class));
        finish();
      case 2131296657:
        startActivity(new Intent((Context)this, EditPictures.class));
        finish();
      case 2131296654:
        (new AlertDialog.Builder((Context)this)).setTitle(getString(2131689524)).setMessage(getString(2131689509)).setPositiveButton(getString(2131689742), new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                Settings settings = Settings.this;
                settings.clearLeftUri(settings.sharedPreferences.getString("leftPicTitle", ""));
                settings = Settings.this;
                settings.clearMiddleUri(settings.sharedPreferences.getString("middlePicTitle", ""));
                settings = Settings.this;
                settings.clearRightUri(settings.sharedPreferences.getString("rightPicTitle", ""));
                Settings.this.db.collection("Users").document(Person.getInstance().getPerson_userId()).delete();
                Settings.this.firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                      public void onComplete(Task<Void> param2Task) {
                        if (param2Task.isSuccessful())
                          Log.d("deletionSuccess", "successfully deleted"); 
                      }
                    });
                settings = Settings.this;
                settings.startActivity(new Intent((Context)settings, StartUpScreen.class));
                Settings.this.finish();
              }
            }).setNegativeButton(getString(2131689647), new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
            }).create().show();
      case 2131296651:
        startActivity(new Intent((Context)this, PasswordReset.class));
        finish();
      case 2131296649:
        break;
    } 
    startActivity(new Intent((Context)this, ColorChooser.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492902);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.sqLiteDatabase = openOrCreateDatabase("database", 0, null);
    this.storageReference = FirebaseStorage.getInstance().getReference();
    this.linearLayout = (LinearLayout)findViewById(2131296659);
    this.settingsButton = (Button)findViewById(2131296648);
    this.maximumDistanceTextView = (TextView)findViewById(2131296666);
    this.ageMinTextView = (TextView)findViewById(2131296646);
    this.ageMaxTextView = (TextView)findViewById(2131296643);
    this.locationTextView = (TextView)findViewById(2131296660);
    this.currentLocationTextView = (TextView)findViewById(2131296653);
    this.distanceSeekBar = (SeekBar)findViewById(2131296656);
    this.ageMinSeekBar = (SeekBar)findViewById(2131296645);
    this.ageMaxSeekBar = (SeekBar)findViewById(2131296642);
    this.locationFrameView = (RelativeLayout)findViewById(2131296661);
    this.categoryFrameView = (RelativeLayout)findViewById(2131296680);
    this.editPicturesFrameView = (RelativeLayout)findViewById(2131296657);
    this.safetyTipsFrameView = (RelativeLayout)findViewById(2131296674);
    this.termsAndPrivacyFrameView = (RelativeLayout)findViewById(2131296683);
    this.changePasswordFrameView = (RelativeLayout)findViewById(2131296651);
    this.logOutFrameView = (RelativeLayout)findViewById(2131296663);
    this.deleteAccountFrameView = (RelativeLayout)findViewById(2131296654);
    this.switchGenderPrefFrameView = (RelativeLayout)findViewById(2131296681);
    this.changeColorFrameView = (RelativeLayout)findViewById(2131296649);
    this.paymentFrameView = (RelativeLayout)findViewById(2131296670);
    this.resetSwipesFrameView = (RelativeLayout)findViewById(2131296672);
    this.showMeSwitch = (Switch)findViewById(2131296677);
    this.notificationSwitch = (Switch)findViewById(2131296669);
    setColor();
    this.firebaseAuth = FirebaseAuth.getInstance();
    this.firebaseUser = this.firebaseAuth.getCurrentUser();
    this.authStateListener = new FirebaseAuth.AuthStateListener() {
        public void onAuthStateChanged(FirebaseAuth param1FirebaseAuth) {
          Settings.access$002(Settings.this, param1FirebaseAuth.getCurrentUser());
        }
      };
    downloadUserData();
    this.city = this.sharedPreferences.getString("userLocation", "");
    this.currentLocationTextView.setVisibility(0);
    if (this.sharedPreferences.getString("currentLocation", "").equals("true")) {
      this.locationTextView.setText(2131689584);
      if (this.city.length() > 20) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.city.substring(0, 15));
        stringBuilder.append("...");
        String str = stringBuilder.toString();
        this.currentLocationTextView.setText(str);
      } else {
        this.currentLocationTextView.setText(this.city);
      } 
    } else if (this.city.length() > 20) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.city.substring(0, 15));
      stringBuilder.append("...");
      String str = stringBuilder.toString();
      this.locationTextView.setText(str);
      this.currentLocationTextView.setVisibility(4);
    } else {
      this.locationTextView.setText(this.city);
      this.currentLocationTextView.setVisibility(4);
    } 
    if (this.sharedPreferences.getString("settingsShowMe", "true").equals("true")) {
      this.showMeSwitch.setChecked(true);
    } else {
      this.showMeSwitch.setChecked(false);
    } 
    if (this.sharedPreferences.getString("notificationsActive", "true").equals("true")) {
      this.notificationSwitch.setChecked(true);
    } else {
      this.notificationSwitch.setChecked(false);
    } 
    if (this.sharedPreferences.getString("ageMin", "18").equals("18"))
      this.ageMinString = "18"; 
    if (this.sharedPreferences.getString("ageMax", "50").equals("50"))
      this.ageMaxString = "50"; 
    if (this.sharedPreferences.getString("distanceLimit", "50").equals("50"))
      this.distance = "50"; 
    this.ageMinSeekBar.setProgress(Integer.parseInt(this.sharedPreferences.getString("ageMin", "18")) - 18);
    this.ageMaxSeekBar.setProgress(Integer.parseInt(this.sharedPreferences.getString("ageMax", "50")) - 18);
    this.distanceSeekBar.setProgress(Integer.parseInt(this.sharedPreferences.getString("distanceLimit", "50")));
    this.showMeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              Settings.this.sharedPreferences.edit().putString("settingsShowMe", "true").apply();
            } else {
              Settings.this.sharedPreferences.edit().putString("settingsShowMe", "false").apply();
            } 
          }
        });
    this.notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              Settings.this.sharedPreferences.edit().putString("notificationsActive", "true").apply();
            } else {
              Settings.this.sharedPreferences.edit().putString("notificationsActive", "false").apply();
            } 
          }
        });
    this.ageMinSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            Settings.access$202(Settings.this, param1SeekBar.getProgress() + 18);
            Settings settings = Settings.this;
            Settings.access$302(settings, String.valueOf(settings.ageMinNum));
            String str = Settings.this.ageMinString;
            Settings.this.ageMinTextView.setText(str);
            param1SeekBar.setProgress(param1Int);
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-256);
          }
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-16777216);
          }
        });
    this.ageMaxSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            Settings.access$502(Settings.this, param1SeekBar.getProgress() + 18);
            Settings settings = Settings.this;
            Settings.access$602(settings, String.valueOf(settings.ageMaxNum));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Settings.this.ageMinString);
            stringBuilder.append(" - ");
            stringBuilder.append(Settings.this.ageMaxString);
            String str = stringBuilder.toString();
            Settings.this.ageMaxTextView.setText(str);
            param1SeekBar.setProgress(param1Int);
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-256);
          }
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-16777216);
          }
        });
    this.distanceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            Settings.access$802(Settings.this, String.valueOf(param1SeekBar.getProgress()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Settings.this.distance);
            stringBuilder.append(" mi");
            String str = stringBuilder.toString();
            Settings.this.maximumDistanceTextView.setText(str);
            param1SeekBar.setProgress(param1Int);
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-256);
          }
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {
            param1SeekBar.setBackgroundColor(-16777216);
          }
        });
    this.locationFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, LocationChooser.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.categoryFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, CategorySwitcher.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.editPicturesFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, EditPictures.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.safetyTipsFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, SafetyTips.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.termsAndPrivacyFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, TermsPrivacyPolicyPage.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.changePasswordFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, PasswordReset.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.logOutFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Intent intent = new Intent((Context)Settings.this, NotificationService.class);
              Settings.this.stopService(intent);
              Settings.this.sharedPreferences.edit().putString("login", "false").putString("currentUser", "").apply();
              Settings.this.firebaseAuth.signOut();
              if (Settings.this.firebaseAuth != null)
                Settings.this.firebaseAuth.removeAuthStateListener(Settings.this.authStateListener); 
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, StartUpScreen.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.deleteAccountFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              (new AlertDialog.Builder((Context)Settings.this)).setTitle(Settings.this.getString(2131689524)).setMessage(Settings.this.getString(2131689509)).setPositiveButton(Settings.this.getString(2131689742), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      Settings.this.clearLeftUri(Settings.this.sharedPreferences.getString("leftPicTitle", ""));
                      Settings.this.clearMiddleUri(Settings.this.sharedPreferences.getString("middlePicTitle", ""));
                      Settings.this.clearRightUri(Settings.this.sharedPreferences.getString("rightPicTitle", ""));
                      Settings.this.db.collection("Users").document(Person.getInstance().getPerson_userId()).delete();
                      Settings.this.firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(Task<Void> param3Task) {
                              if (param3Task.isSuccessful())
                                Log.d("deletionSuccess", "successfully deleted"); 
                            }
                          });
                      Settings.this.startActivity(new Intent((Context)Settings.this, StartUpScreen.class));
                      Settings.this.finish();
                    }
                  }).setNegativeButton(Settings.this.getString(2131689647), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                  }).create().show();
            } 
            return true;
          }
        });
    this.switchGenderPrefFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, GenderChoice.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.changeColorFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1)
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false); 
            } else {
              param1View.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              Settings settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, ColorChooser.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.paymentFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            Settings settings;
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1) {
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                settings = Settings.this;
                settings.startActivity(new Intent((Context)settings, PaymentSetUp.class));
                Settings.this.finish();
              } 
            } else {
              settings.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              settings = Settings.this;
              settings.startActivity(new Intent((Context)settings, PaymentSetUp.class));
              Settings.this.finish();
            } 
            return true;
          }
        });
    this.resetSwipesFrameView.setOnTouchListener(new View.OnTouchListener() {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            Settings settings;
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i == 1) {
                param1View.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                settings = Settings.this;
                settings.startActivity(new Intent((Context)settings, PaymentSetUp.class));
                Settings.this.finish();
              } 
            } else {
              settings.getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
              (new AlertDialog.Builder((Context)Settings.this)).setTitle(2131689524).setMessage(Settings.this.getString(2131689704)).setPositiveButton(2131689742, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      Settings.this.deleteSqlTables();
                      Settings.this.updateUserData();
                    }
                  }).setNegativeButton(2131689647, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                  }).create().show();
            } 
            return true;
          }
        });
    this.locationFrameView.setOnClickListener(this);
    this.categoryFrameView.setOnClickListener(this);
    this.editPicturesFrameView.setOnClickListener(this);
    this.safetyTipsFrameView.setOnClickListener(this);
    this.termsAndPrivacyFrameView.setOnClickListener(this);
    this.changePasswordFrameView.setOnClickListener(this);
    this.logOutFrameView.setOnClickListener(this);
    this.deleteAccountFrameView.setOnClickListener(this);
    this.switchGenderPrefFrameView.setOnClickListener(this);
    this.changeColorFrameView.setOnClickListener(this);
    this.paymentFrameView.setOnClickListener(this);
    this.resetSwipesFrameView.setOnClickListener(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    FirebaseAuth firebaseAuth = this.firebaseAuth;
    if (firebaseAuth != null)
      firebaseAuth.removeAuthStateListener(this.authStateListener); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public void onSettingsSaveClicked(View paramView) {
    this.sharedPreferences.edit().putString("ageMin", this.ageMinString).apply();
    this.sharedPreferences.edit().putString("ageMax", this.ageMaxString).apply();
    this.sharedPreferences.edit().putString("distanceLimit", this.distance).apply();
    if (this.showMeSwitch.isChecked()) {
      this.sharedPreferences.edit().putString("settingsShowMe", "true").apply();
    } else {
      this.sharedPreferences.edit().putString("settingsShowMe", "false").apply();
    } 
    if (this.notificationSwitch.isChecked()) {
      this.sharedPreferences.edit().putString("notificationsActive", "true").apply();
    } else {
      this.sharedPreferences.edit().putString("notificationsActive", "false").apply();
    } 
    updateUserCollection();
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  protected void onStart() {
    super.onStart();
    this.firebaseAuth.addAuthStateListener(this.authStateListener);
  }
}